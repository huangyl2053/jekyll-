/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyoJohoTest;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

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
     * Test of CreateHokenryoDankaiHanteiHoho method, of class HokenryoDankaiHanteiHohoHozonFactory.
     */
    @Test
    public void testCreateHokenryoDankaiHanteiHoho1() {
        System.out.println("CreateHokenryoDankaiHanteiHoho1");
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2012"));
        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setCreateHokenryoDankaiHanteiHoho());

        HokenryoDankaiHanteiHohoHozon result = HokenryoDankaiHanteiHohoHozonFactory.createHokenryoDankaiHanteiHoho(hokenryoDankaiHanteiParameter);
        if (result instanceof Dai5Ki) {
        } else {
            fail("CreateHokenryoDankaiHanteiHoho1 failed");
        }
    }

    @Test
    public void testCreateHokenryoDankaiHanteiHoho2() {
        System.out.println("CreateHokenryoDankaiHanteiHoho2");

        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2014"));
        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setCreateHokenryoDankaiHanteiHoho());

        HokenryoDankaiHanteiHohoHozon result = HokenryoDankaiHanteiHohoHozonFactory.createHokenryoDankaiHanteiHoho(hokenryoDankaiHanteiParameter);
        if (result instanceof Dai5Ki) {
        } else {
            fail("CreateHokenryoDankaiHanteiHoho1 failed");
        }
    }

    @Test
    public void testCreateHokenryoDankaiHanteiHoho3() {
        System.out.println("CreateHokenryoDankaiHanteiHoho3");

        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2015"));
        HokenryoDankaiHanteiHohoHozon expResult = null;
        HokenryoDankaiHanteiHohoHozon result = HokenryoDankaiHanteiHohoHozonFactory.createHokenryoDankaiHanteiHoho(hokenryoDankaiHanteiParameter);
        assertEquals(expResult, result);

    }

    @Test
    public void testCreateHokenryoDankaiHanteiHoho4() {
        System.out.println("CreateHokenryoDankaiHanteiHoho4");

        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear(""));
        HokenryoDankaiHanteiHohoHozon expResult = null;
        HokenryoDankaiHanteiHohoHozon result = HokenryoDankaiHanteiHohoHozonFactory.createHokenryoDankaiHanteiHoho(hokenryoDankaiHanteiParameter);
        assertEquals(expResult, result);

    }
}
