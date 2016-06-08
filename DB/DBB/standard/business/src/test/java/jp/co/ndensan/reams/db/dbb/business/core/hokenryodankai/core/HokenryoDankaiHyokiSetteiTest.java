/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.FukaKonkyo;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyoJohoTest;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author N2810
 */
@Ignore
public class HokenryoDankaiHyokiSetteiTest {

    public HokenryoDankaiHyokiSetteiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of set保険料段階表記 method, of class set保険料段階表記.
     */
    @Test
    public void testHokenryoDankaiHyokiSettei1() {
        System.out.println(new RString("保険料段階表記設定1"));
        FukaKonkyo fukakonkyo = new FukaKonkyo();
        fukakonkyo.setSeihoStartYMD(new FlexibleDate("2014/07/25"));

        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setHokenryoDankaiHyokiSettei());

        TsukibetsuHokenryoDankai tsukibetsuHokenryoDankai = new TsukibetsuHokenryoDankai(new RString("4"));
        tsukibetsuHokenryoDankai.get保険料段階01月().setHokenryoDankai(new RString("1"));
        tsukibetsuHokenryoDankai.get保険料段階02月().setHokenryoDankai(new RString("2"));
        tsukibetsuHokenryoDankai.get保険料段階03月().setHokenryoDankai(new RString("3"));
        tsukibetsuHokenryoDankai.get保険料段階04月().setHokenryoDankai(new RString("4"));
        tsukibetsuHokenryoDankai.get保険料段階05月().setHokenryoDankai(new RString("5"));
        tsukibetsuHokenryoDankai.get保険料段階06月().setHokenryoDankai(new RString("6"));
        tsukibetsuHokenryoDankai.get保険料段階07月().setHokenryoDankai(new RString("7"));
        tsukibetsuHokenryoDankai.get保険料段階08月().setHokenryoDankai(new RString("8"));
        tsukibetsuHokenryoDankai.get保険料段階09月().setHokenryoDankai(new RString("9"));
        tsukibetsuHokenryoDankai.get保険料段階10月().setHokenryoDankai(new RString("10"));
        tsukibetsuHokenryoDankai.get保険料段階11月().setHokenryoDankai(new RString("11"));
        tsukibetsuHokenryoDankai.get保険料段階12月().setHokenryoDankai(new RString("12"));

        TsukibetsuHokenryoDankai expResult = new TsukibetsuHokenryoDankai(new RString("4"));
        tsukibetsuHokenryoDankai.get保険料段階01月().setHokenryoDankai(new RString("第1段階"));
        tsukibetsuHokenryoDankai.get保険料段階02月().setHokenryoDankai(new RString("第2段階"));
        tsukibetsuHokenryoDankai.get保険料段階03月().setHokenryoDankai(new RString("第3段階①"));
        tsukibetsuHokenryoDankai.get保険料段階04月().setHokenryoDankai(new RString("第3段階②"));
        tsukibetsuHokenryoDankai.get保険料段階05月().setHokenryoDankai(new RString("第4段階１"));
        tsukibetsuHokenryoDankai.get保険料段階06月().setHokenryoDankai(new RString("第4段階２"));
        tsukibetsuHokenryoDankai.get保険料段階07月().setHokenryoDankai(new RString("第5段階"));
        tsukibetsuHokenryoDankai.get保険料段階08月().setHokenryoDankai(new RString("第6段階"));
        tsukibetsuHokenryoDankai.get保険料段階09月().setHokenryoDankai(new RString("第7段階"));
        tsukibetsuHokenryoDankai.get保険料段階10月().setHokenryoDankai(new RString("第8段階"));
        tsukibetsuHokenryoDankai.get保険料段階11月().setHokenryoDankai(new RString("第9段階"));
        tsukibetsuHokenryoDankai.get保険料段階12月().setHokenryoDankai(new RString("第10段階"));

        HokenryoDankaiHyokiSettei.set保険料段階表記(hokenryoDankaiHanteiParameter, tsukibetsuHokenryoDankai);
        if (outputEquals(tsukibetsuHokenryoDankai, expResult)) {
            fail("HokenryoDankaiHyokiSettei1 failed");
        }
    }

    @Test
    public void testHokenryoDankaiHyokiSettei2() {
        System.out.println(new RString("保険料段階表記設定2"));
        FukaKonkyo fukakonkyo = new FukaKonkyo();
        fukakonkyo.setSeihoStartYMD(new FlexibleDate("2014/07/25"));

        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setHokenryoDankaiHyokiSettei());

        TsukibetsuHokenryoDankai tsukibetsuHokenryoDankai = new TsukibetsuHokenryoDankai(new RString("4"));
        tsukibetsuHokenryoDankai.get保険料段階01月().setHokenryoDankai(new RString("12"));
        tsukibetsuHokenryoDankai.get保険料段階02月().setHokenryoDankai(new RString("13"));
        tsukibetsuHokenryoDankai.get保険料段階03月().setHokenryoDankai(new RString("14"));
        tsukibetsuHokenryoDankai.get保険料段階04月().setHokenryoDankai(new RString("15"));
        tsukibetsuHokenryoDankai.get保険料段階05月().setHokenryoDankai(new RString("16"));
        tsukibetsuHokenryoDankai.get保険料段階06月().setHokenryoDankai(new RString("17"));
        tsukibetsuHokenryoDankai.get保険料段階07月().setHokenryoDankai(new RString("18"));
        tsukibetsuHokenryoDankai.get保険料段階08月().setHokenryoDankai(new RString("19"));
        tsukibetsuHokenryoDankai.get保険料段階09月().setHokenryoDankai(new RString("20"));

        TsukibetsuHokenryoDankai expResult = new TsukibetsuHokenryoDankai(new RString("4"));
        tsukibetsuHokenryoDankai.get保険料段階01月().setHokenryoDankai(new RString("第10段階"));
        tsukibetsuHokenryoDankai.get保険料段階02月().setHokenryoDankai(new RString("第11段階"));
        tsukibetsuHokenryoDankai.get保険料段階03月().setHokenryoDankai(new RString("第12段階"));
        tsukibetsuHokenryoDankai.get保険料段階04月().setHokenryoDankai(new RString("第13段階"));
        tsukibetsuHokenryoDankai.get保険料段階05月().setHokenryoDankai(new RString("第14段階"));
        tsukibetsuHokenryoDankai.get保険料段階06月().setHokenryoDankai(new RString("第15段階"));
        tsukibetsuHokenryoDankai.get保険料段階07月().setHokenryoDankai(new RString("第16段階"));
        tsukibetsuHokenryoDankai.get保険料段階08月().setHokenryoDankai(new RString("第17段階"));
        tsukibetsuHokenryoDankai.get保険料段階09月().setHokenryoDankai(new RString("第18段階"));
        tsukibetsuHokenryoDankai.get保険料段階10月().setHokenryoDankai(new RString("第3段階②"));
        tsukibetsuHokenryoDankai.get保険料段階11月().setHokenryoDankai(new RString("第3段階②"));
        tsukibetsuHokenryoDankai.get保険料段階12月().setHokenryoDankai(new RString("第3段階②"));

        HokenryoDankaiHyokiSettei.set保険料段階表記(hokenryoDankaiHanteiParameter, tsukibetsuHokenryoDankai);
        if (outputEquals(tsukibetsuHokenryoDankai, expResult)) {
            fail("HokenryoDankaiHyokiSettei2 failed");
        }
    }

    private boolean outputEquals(TsukibetsuHokenryoDankai input1, TsukibetsuHokenryoDankai input2) {

        boolean result = true;

        if (!(input1.get保険料段階01月().getHokenryoDankai().equals(input2.get保険料段階01月().getHokenryoDankai())
                && input1.get保険料段階01月().isTokureiTaisho() == input2.get保険料段階01月().isTokureiTaisho())) {
            result = false;
        }

        if (!(input1.get保険料段階02月().getHokenryoDankai().equals(input2.get保険料段階02月().getHokenryoDankai())
                && input1.get保険料段階02月().isTokureiTaisho() == input2.get保険料段階02月().isTokureiTaisho())) {
            result = false;
        }

        if (!(input1.get保険料段階03月().getHokenryoDankai().equals(input2.get保険料段階03月().getHokenryoDankai())
                && input1.get保険料段階03月().isTokureiTaisho() == input2.get保険料段階03月().isTokureiTaisho())) {
            result = false;
        }

        if (!(input1.get保険料段階04月().getHokenryoDankai().equals(input2.get保険料段階04月().getHokenryoDankai())
                && input1.get保険料段階04月().isTokureiTaisho() == input2.get保険料段階04月().isTokureiTaisho())) {
            result = false;
        }

        if (!(input1.get保険料段階05月().getHokenryoDankai().equals(input2.get保険料段階05月().getHokenryoDankai())
                && input1.get保険料段階05月().isTokureiTaisho() == input2.get保険料段階05月().isTokureiTaisho())) {
            result = false;
        }

        if (!(input1.get保険料段階06月().getHokenryoDankai().equals(input2.get保険料段階06月().getHokenryoDankai())
                && input1.get保険料段階06月().isTokureiTaisho() == input2.get保険料段階06月().isTokureiTaisho())) {
            result = false;
        }
        if (!(input1.get保険料段階07月().getHokenryoDankai().equals(input2.get保険料段階07月().getHokenryoDankai())
                && input1.get保険料段階07月().isTokureiTaisho() == input2.get保険料段階07月().isTokureiTaisho())) {
            result = false;
        }
        if (!(input1.get保険料段階08月().getHokenryoDankai().equals(input2.get保険料段階08月().getHokenryoDankai())
                && input1.get保険料段階08月().isTokureiTaisho() == input2.get保険料段階08月().isTokureiTaisho())) {
            result = false;
        }
        if (!(input1.get保険料段階09月().getHokenryoDankai().equals(input2.get保険料段階09月().getHokenryoDankai())
                && input1.get保険料段階09月().isTokureiTaisho() == input2.get保険料段階09月().isTokureiTaisho())) {
            result = false;
        }
        if (!(input1.get保険料段階10月().getHokenryoDankai().equals(input2.get保険料段階10月().getHokenryoDankai())
                && input1.get保険料段階10月().isTokureiTaisho() == input2.get保険料段階10月().isTokureiTaisho())) {
            result = false;
        }
        if (!(input1.get保険料段階11月().getHokenryoDankai().equals(input2.get保険料段階11月().getHokenryoDankai())
                && input1.get保険料段階11月().isTokureiTaisho() == input2.get保険料段階11月().isTokureiTaisho())) {
            result = false;
        }
        if (!(input1.get保険料段階12月().getHokenryoDankai().equals(input2.get保険料段階12月().getHokenryoDankai())
                && input1.get保険料段階12月().isTokureiTaisho() == input2.get保険料段階12月().isTokureiTaisho())) {
            result = false;
        }

        return result;
    }

}
