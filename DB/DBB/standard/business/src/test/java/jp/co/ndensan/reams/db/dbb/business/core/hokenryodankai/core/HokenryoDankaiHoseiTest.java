/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyoJohoTest;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2014"));

        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setCreateHokenryoDankaiHanteiHoho());

        RString hokenryodankai = new RString("2");
        RString expResult = new RString("6");
        RString result = HokenryoDankaiHosei.hokenryoDankaiHosei(hokenryoDankaiHanteiParameter, hokenryodankai);
        assertEquals(expResult, result);
    }

    /**
     * Test of HokenryoDankaiHosei method, of class HokenryoDankaiHosei.
     */
    @Test
    public void testHokenryoDankaiHosei2() {
        System.out.println("HokenryoDankaiHosei2");
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2014"));

        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setCreateHokenryoDankaiHanteiHoho());

        RString hokenryodankai = new RString("4");
        RString expResult = new RString("6");
        RString result = HokenryoDankaiHosei.hokenryoDankaiHosei(hokenryoDankaiHanteiParameter, hokenryodankai);
        assertEquals(expResult, result);

    }

    /**
     * Test of HokenryoDankaiHosei method, of class HokenryoDankaiHosei.
     */
    @Test
    public void testHokenryoDankaiHosei3() {
        System.out.println("HokenryoDankaiHosei3");
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2014"));

        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setCreateHokenryoDankaiHanteiHoho());

        RString hokenryodankai = new RString("5");
        RString expResult = new RString("5");
        RString result = HokenryoDankaiHosei.hokenryoDankaiHosei(hokenryoDankaiHanteiParameter, hokenryodankai);
        assertEquals(expResult, result);

    }

    /**
     * Test of HokenryoDankaiHosei method, of class HokenryoDankaiHosei.
     */
    @Test
    public void testHokenryoDankaiHosei4() {
        System.out.println("HokenryoDankaiHosei4");
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2014"));

        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setCreateHokenryoDankaiHanteiHoho());

        RString hokenryodankai = new RString("6");
        RString expResult = new RString("6");
        RString result = HokenryoDankaiHosei.hokenryoDankaiHosei(hokenryoDankaiHanteiParameter, hokenryodankai);
        assertEquals(expResult, result);

    }

    /**
     * Test of HokenryoDankaiHosei method, of class HokenryoDankaiHosei.
     */
    @Test
    public void testHokenryoDankaiHosei5() {
        System.out.println("HokenryoDankaiHosei5");

        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2014"));

        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setCreateHokenryoDankaiHanteiHoho());

        RString hokenryodankai = new RString("7");
        RString expResult = new RString("7");
        RString result = HokenryoDankaiHosei.hokenryoDankaiHosei(hokenryoDankaiHanteiParameter, hokenryodankai);
        assertEquals(expResult, result);

    }
}
