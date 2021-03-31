package tp01.q3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestProxy {
    
    @Test(expected = VerificationException.class,timeout = 1000)
    public void testMoisHorsLimite13() {
        Date3 dateCible = new Date3();
        DateInterface date = CheckProxyFactory.creerProxy(DateInterface.class, dateCible);
        date.setMois(13);
    }

    @Test(expected = VerificationException.class)
    public void testMoisHorsLimite0() {
        Date3 dateCible = new Date3();
        DateInterface date = CheckProxyFactory.creerProxy(DateInterface.class, dateCible);
        date.setMois(0);
    }

    @Test(expected = VerificationException.class)
    public void testJourHorsLimite32() {
        Date3 dateCible = new Date3();
        DateInterface date = CheckProxyFactory.creerProxy(DateInterface.class, dateCible);
        date.setJour(32);;
    }

    @Test(expected = VerificationException.class)
    public void testJourHorsLimite0() {
        Date3 dateCible = new Date3();
        DateInterface date = CheckProxyFactory.creerProxy(DateInterface.class, dateCible);
        date.setJour(0);
    }

    @Test
    public void testJourCorrect() {
        Date3 dateCible = new Date3();
        DateInterface date = CheckProxyFactory.creerProxy(DateInterface.class, dateCible);
        date.setJour(31);;
        assertEquals(31, dateCible.getJour());
    }



    @Test
    public void testMoisCorrect() {
        Date3 dateCible = new Date3();
        DateInterface date = CheckProxyFactory.creerProxy(DateInterface.class, dateCible);
        date.setMois(11);
        assertEquals(11, dateCible.getMois());
    }

    @Test
    public void testDateCorrecte() {
        Date3 dateCible = new Date3();
        DateInterface date = CheckProxyFactory.creerProxy(DateInterface.class, dateCible);
        date.setMois(3);
        date.setJour(10);
        date.setAnnee(2021);
        assertEquals(10, dateCible.getJour());
        assertEquals(3, dateCible.getMois());
        assertEquals(2021, dateCible.getAnnee());
    }
}
