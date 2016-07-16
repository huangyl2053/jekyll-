/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai;

import java.util.List;
import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.TsukibetsuHokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.TsukibetsuHokenryoDankaiTest;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.FukaKonkyo;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyoJohoTest;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
public class HokenryoDankaiHanteiTest {

    public HokenryoDankaiHanteiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of determine月別保険料段階 method, of class HokenryoDankaiHantei.
     */
    @Test
    public void testHokenryoDankaiHantei1() {

        System.out.println(new RString("段階使用あり"));

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter;

        List<KazeiKubun> setaiinKazeiKubunList = new ArrayList<>();
        setaiinKazeiKubunList.add(KazeiKubun.valueOf("課税"));
        fukakonkyo.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(100000));

        hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2014"));
        hokenryoDankaiHanteiParameter.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setHokenryoDankaiHantei(1));

        HokenryoDankaiHantei instance = new HokenryoDankaiHantei();

        TsukibetsuHokenryoDankai result = instance.determine月別保険料段階(hokenryoDankaiHanteiParameter);
        if (!HokenryoDankaiEquals(TsukibetsuHokenryoDankaiTest.setHokenryoDankaiHantei1(), result)) {
            fail("段階使用あり 保険料段階failed");
        }

        if (!SystemDankaiEquals(TsukibetsuHokenryoDankaiTest.setHokenryoDankaiHantei1(), result)) {
            fail("段階使用あり システム段階failed");
        }

        if (!TokureiTaishoEquals(TsukibetsuHokenryoDankaiTest.setHokenryoDankaiHantei1(), result)) {
            fail("段階使用あり 特例対象failed");
        }

    }

    @Test
    public void testHokenryoDankaiHantei2() {

        System.out.println(new RString("段階使用なし"));

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter;

        List<KazeiKubun> setaiinKazeiKubunList = new ArrayList<>();
        fukakonkyo.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(800000));

        hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2014"));
        hokenryoDankaiHanteiParameter.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setHokenryoDankaiHantei(2));

        HokenryoDankaiHantei instance = new HokenryoDankaiHantei();

        TsukibetsuHokenryoDankai result = instance.determine月別保険料段階(hokenryoDankaiHanteiParameter);
        if (!HokenryoDankaiEquals(TsukibetsuHokenryoDankaiTest.setHokenryoDankaiHantei2(), result)) {
            fail("段階使用なし 保険料段階failed");
        }
        if (!SystemDankaiEquals(TsukibetsuHokenryoDankaiTest.setHokenryoDankaiHantei2(), result)) {
            fail("段階使用なし システム段階failed");
        }
        if (!TokureiTaishoEquals(TsukibetsuHokenryoDankaiTest.setHokenryoDankaiHantei2(), result)) {
            fail("段階使用なし 特例対象failed");
        }

    }

    @Test
    public void testHokenryoDankaiHantei3() {

        System.out.println(new RString("段階使用有無全無 5段階"));

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter;

        List<KazeiKubun> setaiinKazeiKubunList = new ArrayList<>();
        setaiinKazeiKubunList.add(KazeiKubun.valueOf("課税"));
        fukakonkyo.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(200000));

        hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2014"));
        hokenryoDankaiHanteiParameter.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setHokenryoDankaiHantei(0));

        HokenryoDankaiHantei instance = new HokenryoDankaiHantei();

        TsukibetsuHokenryoDankai result = instance.determine月別保険料段階(hokenryoDankaiHanteiParameter);
        if (!HokenryoDankaiEquals(TsukibetsuHokenryoDankaiTest.setHokenryoDankaiHantei3(), result)) {
            fail("段階使用有無全無 5段階 保険料段階failed");
        }
        if (!SystemDankaiEquals(TsukibetsuHokenryoDankaiTest.setHokenryoDankaiHantei3(), result)) {
            fail("段階使用有無全無 5段階 システム段階failed");
        }
        if (!TokureiTaishoEquals(TsukibetsuHokenryoDankaiTest.setHokenryoDankaiHantei3(), result)) {
            fail("段階使用有無全無 5段階 特例対象failed");
        }

    }

    @Test
    public void testHokenryoDankaiHantei4() {

        System.out.println(new RString("段階使用有無全無 途中から生保開始"));

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter;

        List<KazeiKubun> setaiinKazeiKubunList = new ArrayList<>();
        fukakonkyo.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        fukakonkyo.setGokeiShotoku(new Decimal(1300000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(0));
        fukakonkyo.setSeihoStartYMD(new FlexibleDate("2014/07/25"));

        hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2014"));
        hokenryoDankaiHanteiParameter.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setHokenryoDankaiHantei(0));

        HokenryoDankaiHantei instance = new HokenryoDankaiHantei();

        TsukibetsuHokenryoDankai result = instance.determine月別保険料段階(hokenryoDankaiHanteiParameter);
        if (!HokenryoDankaiEquals(TsukibetsuHokenryoDankaiTest.setHokenryoDankaiHantei4(), result)) {
            fail("段階使用有無全無 途中から生保開始 保険料段階failed");
        }
        if (!SystemDankaiEquals(TsukibetsuHokenryoDankaiTest.setHokenryoDankaiHantei4(), result)) {
            fail("段階使用有無全無 途中から生保開始 システム段階failed");
        }
        if (!TokureiTaishoEquals(TsukibetsuHokenryoDankaiTest.setHokenryoDankaiHantei4(), result)) {
            fail("段階使用有無全無 途中から生保開始 特例対象failed");
        }
    }

    @Test
    public void testHokenryoDankaiHantei5() {

        System.out.println(new RString("段階使用有無全無 途中で生保終了"));

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter;

        List<KazeiKubun> setaiinKazeiKubunList = new ArrayList<>();
        fukakonkyo.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(0));
        fukakonkyo.setSeihoStartYMD(new FlexibleDate("2014/01/25"));
        fukakonkyo.setSeihoEndYMD(new FlexibleDate("2014/07/25"));

        hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2014"));
        hokenryoDankaiHanteiParameter.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setHokenryoDankaiHantei(0));

        HokenryoDankaiHantei instance = new HokenryoDankaiHantei();

        TsukibetsuHokenryoDankai result = instance.determine月別保険料段階(hokenryoDankaiHanteiParameter);
        if (!HokenryoDankaiEquals(TsukibetsuHokenryoDankaiTest.setHokenryoDankaiHantei5(), result)) {
            fail("段階使用有無全無 途中で生保終了 保険料段階failed");
        }
        if (!SystemDankaiEquals(TsukibetsuHokenryoDankaiTest.setHokenryoDankaiHantei5(), result)) {
            fail("段階使用有無全無 途中で生保終了 システム段階failed");
        }
        if (!TokureiTaishoEquals(TsukibetsuHokenryoDankaiTest.setHokenryoDankaiHantei5(), result)) {
            fail("段階使用有無全無 途中で生保終了 特例対象failed");
        }
    }

    @Test
    public void testHokenryoDankaiHantei6() {

        System.out.println(new RString("段階使用有無全無 途中で生保開始終了"));

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter;

        List<KazeiKubun> setaiinKazeiKubunList = new ArrayList<>();
        fukakonkyo.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(300001));
        fukakonkyo.setSeihoStartYMD(new FlexibleDate("2015/01/25"));
        fukakonkyo.setSeihoEndYMD(new FlexibleDate("2015/02/25"));

        hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2014"));
        hokenryoDankaiHanteiParameter.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setHokenryoDankaiHantei(0));

        HokenryoDankaiHantei instance = new HokenryoDankaiHantei();

        TsukibetsuHokenryoDankai result = instance.determine月別保険料段階(hokenryoDankaiHanteiParameter);
        if (!HokenryoDankaiEquals(TsukibetsuHokenryoDankaiTest.setHokenryoDankaiHantei6(), result)) {
            fail("段階使用有無全無 途中で生保開始終了 保険料段階failed");
        }
        if (!SystemDankaiEquals(TsukibetsuHokenryoDankaiTest.setHokenryoDankaiHantei6(), result)) {
            fail("段階使用有無全無 途中で生保開始終了 システム段階failed");
        }
        if (!TokureiTaishoEquals(TsukibetsuHokenryoDankaiTest.setHokenryoDankaiHantei6(), result)) {
            fail("段階使用有無全無 途中で生保開始終了 特例対象failed");
        }
    }

    private boolean HokenryoDankaiEquals(TsukibetsuHokenryoDankai input1, TsukibetsuHokenryoDankai input2) {

        boolean result = true;

        if (!(input1.get保険料段階01月().getHokenryoDankai().equals(input2.get保険料段階01月().getHokenryoDankai()))) {
            result = false;
        }

        if (!(input1.get保険料段階02月().getHokenryoDankai().equals(input2.get保険料段階02月().getHokenryoDankai()))) {
            result = false;
        }

        if (!(input1.get保険料段階03月().getHokenryoDankai().equals(input2.get保険料段階03月().getHokenryoDankai()))) {
            result = false;
        }

        if (!(input1.get保険料段階04月().getHokenryoDankai().equals(input2.get保険料段階04月().getHokenryoDankai()))) {
            result = false;
        }

        if (!(input1.get保険料段階05月().getHokenryoDankai().equals(input2.get保険料段階05月().getHokenryoDankai()))) {
            result = false;
        }

        if (!(input1.get保険料段階06月().getHokenryoDankai().equals(input2.get保険料段階06月().getHokenryoDankai()))) {
            result = false;
        }

        if (!(input1.get保険料段階07月().getHokenryoDankai().equals(input2.get保険料段階07月().getHokenryoDankai()))) {
            result = false;
        }

        if (!(input1.get保険料段階08月().getHokenryoDankai().equals(input2.get保険料段階08月().getHokenryoDankai()))) {
            result = false;
        }

        if (!(input1.get保険料段階09月().getHokenryoDankai().equals(input2.get保険料段階09月().getHokenryoDankai()))) {
            result = false;
        }

        if (!(input1.get保険料段階10月().getHokenryoDankai().equals(input2.get保険料段階10月().getHokenryoDankai()))) {
            result = false;
        }

        if (!(input1.get保険料段階11月().getHokenryoDankai().equals(input2.get保険料段階11月().getHokenryoDankai()))) {
            result = false;
        }

        if (!(input1.get保険料段階12月().getHokenryoDankai().equals(input2.get保険料段階12月().getHokenryoDankai()))) {
            result = false;
        }

        return result;
    }

    private boolean SystemDankaiEquals(TsukibetsuHokenryoDankai expResult, TsukibetsuHokenryoDankai resultoutput) {

        boolean result = true;

        if (!(expResult.get保険料段階01月().getSystemDankai().equals(resultoutput.get保険料段階01月().getSystemDankai()))) {
            result = false;
        }

        if (!(expResult.get保険料段階02月().getSystemDankai().equals(resultoutput.get保険料段階02月().getSystemDankai()))) {
            result = false;
        }

        if (!(expResult.get保険料段階03月().getSystemDankai().equals(resultoutput.get保険料段階03月().getSystemDankai()))) {
            result = false;
        }

        if (!(expResult.get保険料段階04月().getSystemDankai().equals(resultoutput.get保険料段階04月().getSystemDankai()))) {
            result = false;
        }

        if (!(expResult.get保険料段階05月().getSystemDankai().equals(resultoutput.get保険料段階05月().getSystemDankai()))) {
            result = false;
        }

        if (!(expResult.get保険料段階06月().getSystemDankai().equals(resultoutput.get保険料段階06月().getSystemDankai()))) {
            result = false;
        }

        if (!(expResult.get保険料段階07月().getSystemDankai().equals(resultoutput.get保険料段階07月().getSystemDankai()))) {
            result = false;
        }

        if (!(expResult.get保険料段階08月().getSystemDankai().equals(resultoutput.get保険料段階08月().getSystemDankai()))) {
            result = false;
        }

        if (!(expResult.get保険料段階09月().getSystemDankai().equals(resultoutput.get保険料段階09月().getSystemDankai()))) {
            result = false;
        }

        if (!(expResult.get保険料段階10月().getSystemDankai().equals(resultoutput.get保険料段階10月().getSystemDankai()))) {
            result = false;
        }

        if (!(expResult.get保険料段階11月().getSystemDankai().equals(resultoutput.get保険料段階11月().getSystemDankai()))) {
            result = false;
        }

        if (!(expResult.get保険料段階12月().getSystemDankai().equals(resultoutput.get保険料段階12月().getSystemDankai()))) {
            result = false;
        }

        return result;
    }

    private boolean TokureiTaishoEquals(TsukibetsuHokenryoDankai expResult, TsukibetsuHokenryoDankai resultoutput) {

        boolean result = true;

        if (!(expResult.get保険料段階01月().isTokureiTaisho() == resultoutput.get保険料段階01月().isTokureiTaisho())) {
            result = false;
        }
        if (!(expResult.get保険料段階02月().isTokureiTaisho() == resultoutput.get保険料段階02月().isTokureiTaisho())) {
            result = false;
        }
        if (!(expResult.get保険料段階03月().isTokureiTaisho() == resultoutput.get保険料段階03月().isTokureiTaisho())) {
            result = false;
        }
        if (!(expResult.get保険料段階04月().isTokureiTaisho() == resultoutput.get保険料段階04月().isTokureiTaisho())) {
            result = false;
        }
        if (!(expResult.get保険料段階05月().isTokureiTaisho() == resultoutput.get保険料段階05月().isTokureiTaisho())) {
            result = false;
        }
        if (!(expResult.get保険料段階06月().isTokureiTaisho() == resultoutput.get保険料段階06月().isTokureiTaisho())) {
            result = false;
        }
        if (!(expResult.get保険料段階07月().isTokureiTaisho() == resultoutput.get保険料段階07月().isTokureiTaisho())) {
            result = false;
        }
        if (!(expResult.get保険料段階08月().isTokureiTaisho() == resultoutput.get保険料段階08月().isTokureiTaisho())) {
            result = false;
        }
        if (!(expResult.get保険料段階09月().isTokureiTaisho() == resultoutput.get保険料段階09月().isTokureiTaisho())) {
            result = false;
        }
        if (!(expResult.get保険料段階10月().isTokureiTaisho() == resultoutput.get保険料段階10月().isTokureiTaisho())) {
            result = false;
        }
        if (!(expResult.get保険料段階11月().isTokureiTaisho() == resultoutput.get保険料段階11月().isTokureiTaisho())) {
            result = false;
        }
        if (!(expResult.get保険料段階12月().isTokureiTaisho() == resultoutput.get保険料段階12月().isTokureiTaisho())) {
            result = false;
        }
        return result;
    }
}
