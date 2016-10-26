/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyoJohoTest;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author N2810
 */
public class HokenryoDankaiHanteiHohoHozonTest {

    public HokenryoDankaiHanteiHohoHozonTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of 世帯非課税最大段階数取得 method, of class HokenryoDankaiHanteiHohoHozon.
     */
    @Test
    public void test世帯非課税最大段階数取得() {
        System.out.println("test世帯非課税最大段階数取得");
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();

        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setCreateHokenryoDankaiHanteiHoho());

        HokenryoDankaiHanteiHohoHozon instance = new Dai5Ki(hokenryoDankaiHanteiParameter);
        RString expResult = new RString("4");
        RString result = instance.世帯非課税最大段階数取得();
        assertEquals(expResult, result);
    }

    /**
     * Test of 本人非課税最大段階数取得 method, of class HokenryoDankaiHanteiHohoHozon.
     */
    @Test
    public void test本人非課税最大段階数取得() {
        System.out.println("test本人非課税最大段階数取得");
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();

        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setCreateHokenryoDankaiHanteiHoho());

        HokenryoDankaiHanteiHohoHozon instance = new Dai5Ki(hokenryoDankaiHanteiParameter);
        RString expResult = new RString("6");
        RString result = instance.本人非課税最大段階数取得();
        assertEquals(expResult, result);
    }

    public class HokenryoDankaiHanteiHohoHozonImpl extends HokenryoDankaiHanteiHohoHozon {
    }

}
