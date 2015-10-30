/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author N2810
 */
public class HokenryoDankaiHoseiTest {

    public HokenryoDankaiHoseiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of HokenryoDankaiHosei method, of class HokenryoDankaiHosei.
     */
    @Test
    public void testHokenryoDankaiHosei1() {
        System.out.println("HokenryoDankaiHosei1");
        HokenryoDankaiInput hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo(new RString("2014"));

        SeigyoJoho seigyojoho = new SeigyoJoho();

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        RString hokenryodankai = new RString("2");
        RString expResult = new RString("6");
        RString result = HokenryoDankaiHosei.hokenryoDankaiHosei(hokenryodankaiinput, hokenryodankai);
        assertEquals(expResult, result);
    }

    /**
     * Test of HokenryoDankaiHosei method, of class HokenryoDankaiHosei.
     */
    @Test
    public void testHokenryoDankaiHosei2() {
        System.out.println("HokenryoDankaiHosei2");
        HokenryoDankaiInput hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo(new RString("2014"));

        SeigyoJoho seigyojoho = new SeigyoJoho();

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        RString hokenryodankai = new RString("4");
        RString expResult = new RString("6");
        RString result = HokenryoDankaiHosei.hokenryoDankaiHosei(hokenryodankaiinput, hokenryodankai);
        assertEquals(expResult, result);

    }

    /**
     * Test of HokenryoDankaiHosei method, of class HokenryoDankaiHosei.
     */
    @Test
    public void testHokenryoDankaiHosei3() {
        System.out.println("HokenryoDankaiHosei3");
        HokenryoDankaiInput hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo(new RString("2014"));

        SeigyoJoho seigyojoho = new SeigyoJoho();

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        RString hokenryodankai = new RString("5");
        RString expResult = new RString("5");
        RString result = HokenryoDankaiHosei.hokenryoDankaiHosei(hokenryodankaiinput, hokenryodankai);
        assertEquals(expResult, result);

    }

    /**
     * Test of HokenryoDankaiHosei method, of class HokenryoDankaiHosei.
     */
    @Test
    public void testHokenryoDankaiHosei4() {
        System.out.println("HokenryoDankaiHosei4");
        HokenryoDankaiInput hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo(new RString("2014"));

        SeigyoJoho seigyojoho = new SeigyoJoho();

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        RString hokenryodankai = new RString("6");
        RString expResult = new RString("6");
        RString result = HokenryoDankaiHosei.hokenryoDankaiHosei(hokenryodankaiinput, hokenryodankai);
        assertEquals(expResult, result);

    }

    /**
     * Test of HokenryoDankaiHosei method, of class HokenryoDankaiHosei.
     */
    @Test
    public void testHokenryoDankaiHosei5() {
        System.out.println("HokenryoDankaiHosei5");

        HokenryoDankaiInput hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo(new RString("2014"));

        SeigyoJoho seigyojoho = new SeigyoJoho();

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        RString hokenryodankai = new RString("7");
        RString expResult = new RString("7");
        RString result = HokenryoDankaiHosei.hokenryoDankaiHosei(hokenryodankaiinput, hokenryodankai);
        assertEquals(expResult, result);

    }
}
