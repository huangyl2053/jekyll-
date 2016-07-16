/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.kazeihantei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.FukaKonkyo;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyoJohoTest;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.junit.Assert.assertEquals;
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
public class KazeiHanteiTest {

    public KazeiHanteiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {

    }

    public void testkazeiTaisho() {
        System.out.println(new RString("testkazeiTaisho"));

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter;

        fukakonkyo.setFukakijunYMD(new FlexibleDate("2014/06/01"));
        List<KazeiKubun> setaiinKazeiKubunList = new ArrayList<>();
        setaiinKazeiKubunList.add(KazeiKubun.valueOf("課税"));
        fukakonkyo.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(0));

        hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setkazeiTaisho());

        KazeiHantei a = new KazeiHantei();
        assertEquals(new RString("4"), a.kazeiHantei(hokenryoDankaiHanteiParameter));
    }

    /**
     * Test of kazeiHantei method, of class KazeiHantei.
     */
    @Test
    public void testKazeiHantei1() {
        System.out.println(new RString("未申告使用_段階補正なし"));

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter;

        List<KazeiKubun> setaiinKazeiKubunList = new ArrayList<>();
        fukakonkyo.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(0));

        hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2014"));
        hokenryoDankaiHanteiParameter.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setKazeiHantei(1));

        KazeiHantei instance = new KazeiHantei();
        RString expResult = new RString("5");
        RString result = instance.kazeiHantei(hokenryoDankaiHanteiParameter);
        assertEquals(expResult, result);

    }

    @Test
    public void testKazeiHantei2() {
        System.out.println(new RString("未申告使用_段階補正あり"));

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter;

        List<KazeiKubun> setaiinKazeiKubunList = new ArrayList<>();
        setaiinKazeiKubunList.add(KazeiKubun.valueOf("課税"));
        fukakonkyo.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(0));

        hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2014"));
        hokenryoDankaiHanteiParameter.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setKazeiHantei(2));

        KazeiHantei instance = new KazeiHantei();
        RString expResult = new RString("6");
        RString result = instance.kazeiHantei(hokenryoDankaiHanteiParameter);
        assertEquals(expResult, result);

    }

    @Test
    public void testKazeiHantei3() {
        System.out.println(new RString("調査中使用_段階補正なし"));

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter;

        List<KazeiKubun> setaiinKazeiKubunList = new ArrayList<>();
        fukakonkyo.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(0));

        hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2014"));
        hokenryoDankaiHanteiParameter.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setKazeiHantei(3));

        KazeiHantei instance = new KazeiHantei();
        RString expResult = new RString("5");
        RString result = instance.kazeiHantei(hokenryoDankaiHanteiParameter);
        assertEquals(expResult, result);

    }

    @Test
    public void testKazeiHantei4() {
        System.out.println(new RString("調査中使用_段階補正あり"));

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter;

        List<KazeiKubun> setaiinKazeiKubunList = new ArrayList<>();
        setaiinKazeiKubunList.add(KazeiKubun.valueOf("課税"));
        fukakonkyo.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(0));

        hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2014"));
        hokenryoDankaiHanteiParameter.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setKazeiHantei(4));

        KazeiHantei instance = new KazeiHantei();
        RString expResult = new RString("6");
        RString result = instance.kazeiHantei(hokenryoDankaiHanteiParameter);
        assertEquals(expResult, result);

    }

    @Test
    public void testKazeiHantei5() {
        System.out.println(new RString("課税取消使用_段階補正なし"));

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter;

        List<KazeiKubun> setaiinKazeiKubunList = new ArrayList<>();
        fukakonkyo.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(0));

        hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2014"));
        hokenryoDankaiHanteiParameter.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setKazeiHantei(5));

        KazeiHantei instance = new KazeiHantei();
        RString expResult = new RString("5");
        RString result = instance.kazeiHantei(hokenryoDankaiHanteiParameter);
        assertEquals(expResult, result);

    }

    @Test
    public void testKazeiHantei6() {
        System.out.println(new RString("課税取消使用_段階補正あり"));

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter;

        List<KazeiKubun> setaiinKazeiKubunList = new ArrayList<>();
        setaiinKazeiKubunList.add(KazeiKubun.valueOf("課税"));
        fukakonkyo.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(0));

        hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2014"));
        hokenryoDankaiHanteiParameter.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setKazeiHantei(6));

        KazeiHantei instance = new KazeiHantei();
        RString expResult = new RString("6");
        RString result = instance.kazeiHantei(hokenryoDankaiHanteiParameter);
        assertEquals(expResult, result);

    }

    @Test
    public void testKazeiHantei7() {
        System.out.println(new RString("段階使用すべて使用しない_世帯非課税"));

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter;

        List<KazeiKubun> setaiinKazeiKubunList = new ArrayList<>();
        fukakonkyo.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(0));

        hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2014"));
        hokenryoDankaiHanteiParameter.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setKazeiHantei(7));

        KazeiHantei instance = new KazeiHantei();
        RString expResult = null;
        RString result = instance.kazeiHantei(hokenryoDankaiHanteiParameter);
        assertEquals(expResult, result);

    }

    @Test
    public void testKazeiHantei8() {
        System.out.println(new RString("段階使用すべて使用しない_世帯課税"));

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter;

        List<KazeiKubun> setaiinKazeiKubunList = new ArrayList<>();
        setaiinKazeiKubunList.add(KazeiKubun.valueOf("課税"));
        fukakonkyo.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(0));

        hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2014"));
        hokenryoDankaiHanteiParameter.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setKazeiHantei(8));

        KazeiHantei instance = new KazeiHantei();
        RString expResult = null;
        RString result = instance.kazeiHantei(hokenryoDankaiHanteiParameter);
        assertEquals(expResult, result);

    }

    @Test
    public void testKazeiHantei9() {
        System.out.println(new RString("未申告使用しない_課税区分課税"));

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter;

        List<KazeiKubun> setaiinKazeiKubunList = new ArrayList<>();
        fukakonkyo.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(100000));

        hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2014"));
        hokenryoDankaiHanteiParameter.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setKazeiHantei(9));

        KazeiHantei instance = new KazeiHantei();
        HokenryoDankaiHanteiParameter expResult = new HokenryoDankaiHanteiParameter();
        FukaKonkyo expfukakonkyo = new FukaKonkyo();
        setaiinKazeiKubunList.add(KazeiKubun.valueOf("課税"));
        expfukakonkyo.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        expResult.setFukaKonkyo(expfukakonkyo);
        RString result = instance.kazeiHantei(hokenryoDankaiHanteiParameter);
        if (!hokenryoDankaiHanteiParameterEquals(expResult, hokenryoDankaiHanteiParameter)) {
            fail("未申告使用しない_課税区分課税 failed");
        }

    }

    @Test
    public void testKazeiHantei10() {
        System.out.println(new RString("所得調査中使用しない_課税区分課税"));

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter;

        List<KazeiKubun> setaiinKazeiKubunList = new ArrayList<>();
        fukakonkyo.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(100000));

        hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2014"));
        hokenryoDankaiHanteiParameter.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setKazeiHantei(10));

        KazeiHantei instance = new KazeiHantei();
        HokenryoDankaiHanteiParameter expResult = new HokenryoDankaiHanteiParameter();
        FukaKonkyo expfukakonkyo = new FukaKonkyo();
        setaiinKazeiKubunList.add(KazeiKubun.valueOf("課税"));
        expfukakonkyo.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        expResult.setFukaKonkyo(expfukakonkyo);
        RString result = instance.kazeiHantei(hokenryoDankaiHanteiParameter);
        if (!hokenryoDankaiHanteiParameterEquals(expResult, hokenryoDankaiHanteiParameter)) {
            fail("所得調査中使用しない_課税区分課税 failed");
        }

    }

    @Test
    public void testKazeiHantei11() {
        System.out.println(new RString("所得調査中使用しない_課税区分課税"));

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter;

        List<KazeiKubun> setaiinKazeiKubunList = new ArrayList<>();
        fukakonkyo.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(100000));

        hokenryoDankaiHanteiParameter = new HokenryoDankaiHanteiParameter();
        hokenryoDankaiHanteiParameter.setFukaNendo(new FlexibleYear("2014"));
        hokenryoDankaiHanteiParameter.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiHanteiParameter.setSeigyoJoho(SeigyoJohoTest.setKazeiHantei(11));

        KazeiHantei instance = new KazeiHantei();
        HokenryoDankaiHanteiParameter expResult = new HokenryoDankaiHanteiParameter();
        FukaKonkyo expfukakonkyo = new FukaKonkyo();
        setaiinKazeiKubunList.add(KazeiKubun.valueOf("課税"));
        expfukakonkyo.setSetaiinKazeiKubunList(setaiinKazeiKubunList);
        expResult.setFukaKonkyo(expfukakonkyo);
        RString result = instance.kazeiHantei(hokenryoDankaiHanteiParameter);
        if (!hokenryoDankaiHanteiParameterEquals(expResult, hokenryoDankaiHanteiParameter)) {
            fail("所得調査中使用しない_課税区分課税 failed");
        }

    }

    private boolean hokenryoDankaiHanteiParameterEquals(HokenryoDankaiHanteiParameter expResult, HokenryoDankaiHanteiParameter result) {

        boolean hantei = true;

        if (!expResult.getFukaKonkyo().getSetaiinKazeiKubunList().equals(result.getFukaKonkyo().getSetaiinKazeiKubunList())) {
            hantei = false;
        }

        return hantei;
    }
}
