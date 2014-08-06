/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author N2810
 */
public class HokenryoDankaiHanteiHohoHozonFactoryTest {

    public HokenryoDankaiHanteiHohoHozonFactoryTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of CreateHokenryoDankaiHanteiHoho method, of class
     * HokenryoDankaiHanteiHohoHozonFactory.
     */
    @Test
    public void testCreateHokenryoDankaiHanteiHoho1() {
        System.out.println("CreateHokenryoDankaiHanteiHoho1");
        HokenryoDankaiInput hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo("2012");
        SeigyoJoho seigyojoho = new SeigyoJoho();

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        HokenryoDankaiHanteiHohoHozon result = HokenryoDankaiHanteiHohoHozonFactory.CreateHokenryoDankaiHanteiHoho(hokenryodankaiinput);
        if (result instanceof 第4期) {
        } else {
            fail("CreateHokenryoDankaiHanteiHoho1 failed");
        }
    }

    @Test
    public void testCreateHokenryoDankaiHanteiHoho2() {
        System.out.println("CreateHokenryoDankaiHanteiHoho2");

        HokenryoDankaiInput hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo("2014");

        SeigyoJoho seigyojoho = new SeigyoJoho();

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        HokenryoDankaiHanteiHohoHozon result = HokenryoDankaiHanteiHohoHozonFactory.CreateHokenryoDankaiHanteiHoho(hokenryodankaiinput);
        if (result instanceof 第4期) {
        } else {
            fail("CreateHokenryoDankaiHanteiHoho1 failed");
        }
    }

    @Test
    public void testCreateHokenryoDankaiHanteiHoho3() {
        System.out.println("CreateHokenryoDankaiHanteiHoho3");

        HokenryoDankaiInput hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo("2015");
        HokenryoDankaiHanteiHohoHozon expResult = null;
        HokenryoDankaiHanteiHohoHozon result = HokenryoDankaiHanteiHohoHozonFactory.CreateHokenryoDankaiHanteiHoho(hokenryodankaiinput);
        assertEquals(expResult, result);

    }

    @Test
    public void testCreateHokenryoDankaiHanteiHoho4() {
        System.out.println("CreateHokenryoDankaiHanteiHoho4");

        HokenryoDankaiInput hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo("");
        HokenryoDankaiHanteiHohoHozon expResult = null;
        HokenryoDankaiHanteiHohoHozon result = HokenryoDankaiHanteiHohoHozonFactory.CreateHokenryoDankaiHanteiHoho(hokenryodankaiinput);
        assertEquals(expResult, result);

    }
}
