# Métaprogrammation en Java

## Remarque préliminaire

Le but de ce TP n'est pas de vous inciter à utiliser des mécanismes d'introspection java 
dans tous vos bouts de code. Vous devez d'abord penser à la **lisibilité** du code. 

L'idée est de vous faire manipuler un certain nombre de mécanismes mis en œuvre dans 
des *frameworks* comme Spring, pour que vous compreniez comment ils fonctionnent en interne.

En pratique, dans la plupart des cas, les mécanismes étudiés ici seront
mis en œuvre à travers des bibliothèques **déjà écrites**.

## Exercice 1

On veut pouvoir manipuler plus ou moins des objets dont on ne connaîtrait pas 
la classe à l'avance. Pensez à des objets qui seraient décrits par un fichier texte, 
ou des objets tirés d'une base de données.

### Question 1

Étudiez la fonction `Afficheur.afficher`.

Profitez-en pour regarder la classe `IntrospectionHelper`, elle contient des méthodes
qui vous seront utiles.

### Question 2

On veut pouvoir créer et initialiser des classes arbitraires (encore une fois, parce
que la description des objets viendra par exemple de bases de données ou de fichiers textes).

Dans un premier temps, on suppose que la classe a un constructeur par défaut. Complétez la méthode `creer` de la classe `Createur`.
Pour bien comprendre ce qu'elle fait, vous pouvez regarder le test correspondant :

~~~java
        Createur<Adresse> createur = new Createur<>(Adresse.class);
        Adresse a = createur.creer();
        assertNotNull(a);
~~~

### Question 3

On veut pouvoir initialiser maintenant des champs *textes* de notre objet. Pour cela, complétez la méthode `setProprieteTexte`
de la classe `Createur`.

### Question 4

On veut enfin avoir un peu plus de souplesse : on passe non seulement un couple nom et valeur, mais aussi 
la classe de la valeur en question (qu'on aura normalement récupérée aussi par introspection, mais on va s'arrêter là).

Complétez la méthode `setChamp`
de la classe `Createur`.


## Exercice 2

On a créé une annotation nommée "Label", que l'on peut mettre sur une méthode (en fait, sur un getter).

Complétez la classe `Afficheur2`, qui fait en gros la même chose que `Afficheur`, mais qui
utilise, dans l'affichage, le *label* lié au getter au lieu du nom de la propriété.

Par exemple, avec la configuration actuelle, le test suivant :

~~~java
Personne2 p = new Personne2("Alfred", 1999);
String expected = "annee de naissance : 1999 ; nom : Alfred";
String actual = new Afficheur2().afficher(p);
assertEquals(expected, actual);        
~~~

devrait réussir. Le nom dans la classe `Personne2` n'est pas annoté et sera affiché
en utilisant le nom de propriété comme dans le premier exercice. En revanche, 
le getter d'anneeDeNaissance est annoté, et la valeur du label devrait être utilisée.

Les annotations de ce type sont extrêmement utilisées dans les *frameworks* java professionnels, comme par exemple 
Spring, J2EE, Lombok ou Android.


## Exercice 3

On voudrait pouvoir utiliser un système déclaratif pour 
ajouter des contraintes aux propriétés d'un objet, comme par exemple d'être comprises 
dans un intervalle donné.

Une des solutions existantes suppose que les objets implémentent 
une interface (dans les systèmes modernes, on peut aussi 
modifier directement le bytecode java, mais cela nous emmènerait trop loin).

Nous avons mis en place l'infrastructure du système, à vous d'écrire la classe `CheckProxyHandler`.

Pour vous guider :

Le but est de pouvoir annoter une classe de la manière suivante :

~~~java
public interface DateInterface {
    ...

    void setAnnee(int annee);

    @Intervalle(min = 1, max=12)
    void setMois(int mois);

    @Intervalle(min = 1, max=31)
    void setJour(int jour);

}
~~~

Vous voyez que dans cette interface, nous avons indiqué que la méthode `setMois` et la méthode `setJour` 
attendaient des arguments dans un intervalle particulier.

La classe `Date3`, qui est l'implémentation de `DateInterface`, ne vérifie rien du tout.


L'API Bean Validation (https://jcp.org/en/jsr/detail?id=303), implémentée par de nombreuses 
bibliothèques, propose ce type de fonctionnalités (heureusement dans un format moins "brut de décoffrage" que 
celui que nous vous demandons d'implémenter).


# Exercice 4

Si vous avez le temps, un exercice un peu ambitieux :

On suppose qu'on a des données simples (non reliées les unes aux autres) stockées dans des fichiers au format CSV,
les tabulations servant de séparateurs.

L'idée est la suivante :

- on a une classe Lecteur, dotée d'une méthode :

~~~java
    public <T> List<T> lireFichier(Reader reader, Class<T> clazz) {...}
~~~

qui est supposée lire un fichier CSV, et renvoyer les objets de class `clazz` dont les données sont décrites dans le fichier.

Par ailleurs, on veut avoir une annotation, qu'on posera sur les *setters*, qui donne le *numéro* du champ
de l'objet dans le fichier CSV.

Les classes utilisées sont supposées être dotées de constructeurs par défaut.

Le système aura donc besoin :
- d'identifier le "setter" associé à chaque champ possible du fichier CSV
- de lire le fichier CSV :
    - pour chaque ligne créer un objet,
    - et pour chaque champ associé à un setter, remplir le champ.

On pourra supposer que les champs sont, soit des entiers, soit des chaînes de caractères (sinon, il faudrait aussi définir des convertisseurs texte vers objet plus génériques).

