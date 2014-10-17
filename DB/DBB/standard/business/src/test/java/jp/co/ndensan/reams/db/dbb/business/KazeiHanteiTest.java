/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author N2810
 */
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
        System.out.println("testkazeiTaisho");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryodankaiinput;

        fukakonkyo.setFukakijunYMD(toDate("2014/06/01"));
        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("課税");
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(0));

        seigyojoho.setHokenryoDankaiHyoki01("第１段階");
        seigyojoho.setHokenryoDankaiHyoki02("第２段階");
        seigyojoho.setHokenryoDankaiHyoki03("第３段階①");
        seigyojoho.setHokenryoDankaiHyoki04("第３段階②");
        seigyojoho.setHokenryoDankaiHyoki05("第４段階");
        seigyojoho.setHokenryoDankaiHyoki06("第５段階");
        seigyojoho.setHokenryoDankaiHyoki07("第６段階");
        seigyojoho.setHokenryoDankaiHyoki08("第７段階");

        seigyojoho.setKijunNenkinShunyu01(new Decimal(200000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(300000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(400000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1300000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1300000));

        hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaKonkyo(fukakonkyo);
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        KazeiHantei a = new KazeiHantei();
        assertEquals("4", a.kazeiHantei(hokenryodankaiinput));
    }

    protected static Date toDate(String str) {
        Date date = null;
        try {
            date = DateFormat.getDateInstance().parse(str);
        } catch (ParseException pe) {

        }
        return date;
    }

    /**
     * Test of kazeiHantei method, of class KazeiHantei.
     */
    @Test
    public void testKazeiHantei1() {
        System.out.println("未申告使用_段階補正なし");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryodankaiinput;

        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("非課税");
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(0));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(200000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(300000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(400000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1300000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1300000));

        seigyojoho.setMishinkokuDankaiShiyo("使用する");
        seigyojoho.setMishinkokuDankai("5");

        hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo("2014");
        hokenryodankaiinput.setFukaKonkyo(fukakonkyo);
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        KazeiHantei instance = new KazeiHantei();
        String expResult = "5";
        String result = instance.kazeiHantei(hokenryodankaiinput);
        assertEquals(expResult, result);

    }

    @Test
    public void testKazeiHantei2() {
        System.out.println("未申告使用_段階補正あり");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryodankaiinput;

        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("課税");
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(0));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(200000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(300000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(400000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1300000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1300000));

        seigyojoho.setMishinkokuDankaiShiyo("使用する");
        seigyojoho.setMishinkokuDankai("3");

        hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo("2014");
        hokenryodankaiinput.setFukaKonkyo(fukakonkyo);
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        KazeiHantei instance = new KazeiHantei();
        String expResult = "6";
        String result = instance.kazeiHantei(hokenryodankaiinput);
        assertEquals(expResult, result);

    }

    @Test
    public void testKazeiHantei3() {
        System.out.println("調査中使用_段階補正なし");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryodankaiinput;

        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("非課税");
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(0));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(200000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(300000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(400000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1300000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1300000));

        seigyojoho.setShotokuChosachuDankaiShiyo("使用する");
        seigyojoho.setShotokuChosachuDankai("5");

        hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo("2014");
        hokenryodankaiinput.setFukaKonkyo(fukakonkyo);
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        KazeiHantei instance = new KazeiHantei();
        String expResult = "5";
        String result = instance.kazeiHantei(hokenryodankaiinput);
        assertEquals(expResult, result);

    }

    @Test
    public void testKazeiHantei4() {
        System.out.println("調査中使用_段階補正あり");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryodankaiinput;

        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("課税");
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(0));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(200000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(300000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(400000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1300000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1300000));

        seigyojoho.setShotokuChosachuDankaiShiyo("使用する");
        seigyojoho.setShotokuChosachuDankai("3");

        hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo("2014");
        hokenryodankaiinput.setFukaKonkyo(fukakonkyo);
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        KazeiHantei instance = new KazeiHantei();
        String expResult = "6";
        String result = instance.kazeiHantei(hokenryodankaiinput);
        assertEquals(expResult, result);

    }

    @Test
    public void testKazeiHantei5() {
        System.out.println("課税取消使用_段階補正なし");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryodankaiinput;

        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("非課税");
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(0));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(200000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(300000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(400000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1300000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1300000));

        seigyojoho.setKazeiTorikeshiDankaiShiyo("使用する");
        seigyojoho.setKazeiTorikeshiDankai("5");

        hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo("2014");
        hokenryodankaiinput.setFukaKonkyo(fukakonkyo);
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        KazeiHantei instance = new KazeiHantei();
        String expResult = "5";
        String result = instance.kazeiHantei(hokenryodankaiinput);
        assertEquals(expResult, result);

    }

    @Test
    public void testKazeiHantei6() {
        System.out.println("課税取消使用_段階補正あり");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryodankaiinput;

        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("課税");
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(0));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(200000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(300000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(400000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1300000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1300000));

        seigyojoho.setKazeiTorikeshiDankaiShiyo("使用する");
        seigyojoho.setKazeiTorikeshiDankai("3");

        hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo("2014");
        hokenryodankaiinput.setFukaKonkyo(fukakonkyo);
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        KazeiHantei instance = new KazeiHantei();
        String expResult = "6";
        String result = instance.kazeiHantei(hokenryodankaiinput);
        assertEquals(expResult, result);

    }

    @Test
    public void testKazeiHantei7() {
        System.out.println("段階使用すべて使用しない_世帯非課税");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryodankaiinput;

        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("非課税");
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(0));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(200000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(300000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(400000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1300000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1300000));

        hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo("2014");
        hokenryodankaiinput.setFukaKonkyo(fukakonkyo);
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        KazeiHantei instance = new KazeiHantei();
        String expResult = null;
        String result = instance.kazeiHantei(hokenryodankaiinput);
        assertEquals(expResult, result);

    }

    @Test
    public void testKazeiHantei8() {
        System.out.println("段階使用すべて使用しない_世帯課税");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryodankaiinput;

        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("課税");
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(0));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(200000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(300000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(400000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1300000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1300000));

        hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo("2014");
        hokenryodankaiinput.setFukaKonkyo(fukakonkyo);
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        KazeiHantei instance = new KazeiHantei();
        String expResult = null;
        String result = instance.kazeiHantei(hokenryodankaiinput);
        assertEquals(expResult, result);

    }

    @Test
    public void testKazeiHantei9() {
        System.out.println("未申告使用しない_課税区分課税");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryodankaiinput;

        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("非課税");
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(100000));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(200000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(300000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(400000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1300000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1300000));

        seigyojoho.setMishinkokuDankaiShiyo("使用しない");
        seigyojoho.setMishinkokuKazeiKubun("課税");

        hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo("2014");
        hokenryodankaiinput.setFukaKonkyo(fukakonkyo);
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        KazeiHantei instance = new KazeiHantei();
        HokenryoDankaiInput expResult = new HokenryoDankaiInput();
        FukaKonkyo expfukakonkyo = new FukaKonkyo();
        expfukakonkyo.setSetaiKazeiKubun("課税");
        expfukakonkyo.setHonninKazeiKubun("課税");
        expResult.setFukaKonkyo(expfukakonkyo);
        String result = instance.kazeiHantei(hokenryodankaiinput);
        if (!hokenryoDankaiInputEquals(expResult, hokenryodankaiinput)) {
            fail("未申告使用しない_課税区分課税 failed");
        }

    }

    @Test
    public void testKazeiHantei10() {
        System.out.println("所得調査中使用しない_課税区分課税");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryodankaiinput;

        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("非課税");
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(100000));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(200000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(300000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(400000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1300000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1300000));

        seigyojoho.setShotokuChosachuDankaiShiyo("使用しない");
        seigyojoho.setShotokuChosachuKazeiKubun("課税");

        hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo("2014");
        hokenryodankaiinput.setFukaKonkyo(fukakonkyo);
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        KazeiHantei instance = new KazeiHantei();
        HokenryoDankaiInput expResult = new HokenryoDankaiInput();
        FukaKonkyo expfukakonkyo = new FukaKonkyo();
        expfukakonkyo.setSetaiKazeiKubun("課税");
        expfukakonkyo.setHonninKazeiKubun("課税");
        expResult.setFukaKonkyo(expfukakonkyo);
        String result = instance.kazeiHantei(hokenryodankaiinput);
        if (!hokenryoDankaiInputEquals(expResult, hokenryodankaiinput)) {
            fail("所得調査中使用しない_課税区分課税 failed");
        }

    }

    @Test
    public void testKazeiHantei11() {
        System.out.println("所得調査中使用しない_課税区分課税");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryodankaiinput;

        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("非課税");
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(100000));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(200000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(300000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(400000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1300000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1300000));

        seigyojoho.setShotokuChosachuDankaiShiyo("使用しない");
        seigyojoho.setShotokuChosachuKazeiKubun("課税");

        hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo("2014");
        hokenryodankaiinput.setFukaKonkyo(fukakonkyo);
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        KazeiHantei instance = new KazeiHantei();
        HokenryoDankaiInput expResult = new HokenryoDankaiInput();
        FukaKonkyo expfukakonkyo = new FukaKonkyo();
        expfukakonkyo.setSetaiKazeiKubun("課税");
        expfukakonkyo.setHonninKazeiKubun("課税");
        expResult.setFukaKonkyo(expfukakonkyo);
        String result = instance.kazeiHantei(hokenryodankaiinput);
        if (!hokenryoDankaiInputEquals(expResult, hokenryodankaiinput)) {
            fail("所得調査中使用しない_課税区分課税 failed");
        }

    }

    private boolean hokenryoDankaiInputEquals(HokenryoDankaiInput expResult, HokenryoDankaiInput result) {

        boolean hantei = true;

        if (!expResult.getFukaKonkyo().getSetaiKazeiKubun().equals(result.getFukaKonkyo().getSetaiKazeiKubun())) {
            hantei = false;
        }

        if (!expResult.getFukaKonkyo().getHonninKazeiKubun().equals(result.getFukaKonkyo().getHonninKazeiKubun())) {
            hantei = false;
        }

        return hantei;
    }
}
