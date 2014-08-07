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
     * Test of hokenryoDankaiHantei method, of class HokenryoDankaiHantei.
     */
    @Test
    public void testHokenryoDankaiHantei1() {

        System.out.println("段階使用あり");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryodankaiinput;

        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("課税");
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(100000));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));

        seigyojoho.setMishinkokuDankaiShiyo("使用する");
        seigyojoho.setMishinkokuDankai("3");

        seigyojoho.setHokenryoDankaiHyoki01("第1段階");
        seigyojoho.setHokenryoDankaiHyoki02("第2段階");
        seigyojoho.setHokenryoDankaiHyoki03("第3段階①");
        seigyojoho.setHokenryoDankaiHyoki04("第3段階②");
        seigyojoho.setHokenryoDankaiHyoki05("第4段階１");
        seigyojoho.setHokenryoDankaiHyoki06("第4段階２");
        seigyojoho.setHokenryoDankaiHyoki07("第5段階");
        seigyojoho.setHokenryoDankaiHyoki08("第6段階");
        seigyojoho.setHokenryoDankaiHyoki09("第7段階");
        seigyojoho.setHokenryoDankaiHyoki10("第8段階");
        seigyojoho.setHokenryoDankaiHyoki11("第9段階");
        seigyojoho.setHokenryoDankaiHyoki12("第10段階");
        seigyojoho.setHokenryoDankaiHyoki13("第11段階");
        seigyojoho.setHokenryoDankaiHyoki14("第12段階");
        seigyojoho.setHokenryoDankaiHyoki15("第13段階");
        seigyojoho.setHokenryoDankaiHyoki16("第14段階");
        seigyojoho.setHokenryoDankaiHyoki17("第15段階");
        seigyojoho.setHokenryoDankaiHyoki18("第16段階");
        seigyojoho.setHokenryoDankaiHyoki19("第17段階");
        seigyojoho.setHokenryoDankaiHyoki20("第18段階");

        hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo("2014");
        hokenryodankaiinput.setFukaKonkyo(fukakonkyo);
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        HokenryoDankaiHantei instance = new HokenryoDankaiHantei();
        HokenryoDankaiOutput expResult = new HokenryoDankaiOutput("6");
        expResult.get保険料段階04月().setHokenryoDankai("第4段階２");
        expResult.get保険料段階05月().setHokenryoDankai("第4段階２");
        expResult.get保険料段階06月().setHokenryoDankai("第4段階２");
        expResult.get保険料段階07月().setHokenryoDankai("第4段階２");
        expResult.get保険料段階08月().setHokenryoDankai("第4段階２");
        expResult.get保険料段階09月().setHokenryoDankai("第4段階２");
        expResult.get保険料段階10月().setHokenryoDankai("第4段階２");
        expResult.get保険料段階11月().setHokenryoDankai("第4段階２");
        expResult.get保険料段階12月().setHokenryoDankai("第4段階２");
        expResult.get保険料段階01月().setHokenryoDankai("第4段階２");
        expResult.get保険料段階02月().setHokenryoDankai("第4段階２");
        expResult.get保険料段階03月().setHokenryoDankai("第4段階２");
        HokenryoDankaiOutput result = instance.hokenryoDankaiHantei(hokenryodankaiinput);
        if (!HokenryoDankaiEquals(expResult, result)) {
            fail("段階使用あり 保険料段階failed");
        }

        if (!SystemDankaiEquals(expResult, result)) {
            fail("段階使用あり システム段階failed");
        }

        if (!TokureiTaishoEquals(expResult, result)) {
            fail("段階使用あり 特例対象failed");
        }

    }

    @Test
    public void testHokenryoDankaiHantei2() {

        System.out.println("段階使用なし");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryodankaiinput;

        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("非課税");
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(800000));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));

        seigyojoho.setMishinkokuDankaiShiyo("使用しない");
        seigyojoho.setMishinkokuKazeiKubun("課税");

        seigyojoho.setHokenryoDankaiHyoki01("第1段階");
        seigyojoho.setHokenryoDankaiHyoki02("第2段階");
        seigyojoho.setHokenryoDankaiHyoki03("第3段階①");
        seigyojoho.setHokenryoDankaiHyoki04("第3段階②");
        seigyojoho.setHokenryoDankaiHyoki05("第4段階１");
        seigyojoho.setHokenryoDankaiHyoki06("第4段階２");
        seigyojoho.setHokenryoDankaiHyoki07("第5段階");
        seigyojoho.setHokenryoDankaiHyoki08("第6段階");
        seigyojoho.setHokenryoDankaiHyoki09("第7段階");
        seigyojoho.setHokenryoDankaiHyoki10("第8段階");
        seigyojoho.setHokenryoDankaiHyoki11("第9段階");
        seigyojoho.setHokenryoDankaiHyoki12("第10段階");
        seigyojoho.setHokenryoDankaiHyoki13("第11段階");
        seigyojoho.setHokenryoDankaiHyoki14("第12段階");
        seigyojoho.setHokenryoDankaiHyoki15("第13段階");
        seigyojoho.setHokenryoDankaiHyoki16("第14段階");
        seigyojoho.setHokenryoDankaiHyoki17("第15段階");
        seigyojoho.setHokenryoDankaiHyoki18("第16段階");
        seigyojoho.setHokenryoDankaiHyoki19("第17段階");
        seigyojoho.setHokenryoDankaiHyoki20("第18段階");

        hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo("2014");
        hokenryodankaiinput.setFukaKonkyo(fukakonkyo);
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        HokenryoDankaiHantei instance = new HokenryoDankaiHantei();
        HokenryoDankaiOutput expResult = new HokenryoDankaiOutput("8");
        expResult.get保険料段階04月().setHokenryoDankai("第6段階");
        expResult.get保険料段階05月().setHokenryoDankai("第6段階");
        expResult.get保険料段階06月().setHokenryoDankai("第6段階");
        expResult.get保険料段階07月().setHokenryoDankai("第6段階");
        expResult.get保険料段階08月().setHokenryoDankai("第6段階");
        expResult.get保険料段階09月().setHokenryoDankai("第6段階");
        expResult.get保険料段階10月().setHokenryoDankai("第6段階");
        expResult.get保険料段階11月().setHokenryoDankai("第6段階");
        expResult.get保険料段階12月().setHokenryoDankai("第6段階");
        expResult.get保険料段階01月().setHokenryoDankai("第6段階");
        expResult.get保険料段階02月().setHokenryoDankai("第6段階");
        expResult.get保険料段階03月().setHokenryoDankai("第6段階");
        HokenryoDankaiOutput result = instance.hokenryoDankaiHantei(hokenryodankaiinput);
        if (!HokenryoDankaiEquals(expResult, result)) {
            fail("段階使用なし 保険料段階failed");
        }
        if (!SystemDankaiEquals(expResult, result)) {
            fail("段階使用なし システム段階failed");
        }
        if (!TokureiTaishoEquals(expResult, result)) {
            fail("段階使用なし 特例対象failed");
        }

    }

    @Test
    public void testHokenryoDankaiHantei3() {

        System.out.println("段階使用有無全無 5段階");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryodankaiinput;

        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("課税");
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(200000));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));

        seigyojoho.setHokenryoDankaiHyoki01("第1段階");
        seigyojoho.setHokenryoDankaiHyoki02("第2段階");
        seigyojoho.setHokenryoDankaiHyoki03("第3段階①");
        seigyojoho.setHokenryoDankaiHyoki04("第3段階②");
        seigyojoho.setHokenryoDankaiHyoki05("第4段階１");
        seigyojoho.setHokenryoDankaiHyoki06("第4段階２");
        seigyojoho.setHokenryoDankaiHyoki07("第5段階");
        seigyojoho.setHokenryoDankaiHyoki08("第6段階");
        seigyojoho.setHokenryoDankaiHyoki09("第7段階");
        seigyojoho.setHokenryoDankaiHyoki10("第8段階");
        seigyojoho.setHokenryoDankaiHyoki11("第9段階");
        seigyojoho.setHokenryoDankaiHyoki12("第10段階");
        seigyojoho.setHokenryoDankaiHyoki13("第11段階");
        seigyojoho.setHokenryoDankaiHyoki14("第12段階");
        seigyojoho.setHokenryoDankaiHyoki15("第13段階");
        seigyojoho.setHokenryoDankaiHyoki16("第14段階");
        seigyojoho.setHokenryoDankaiHyoki17("第15段階");
        seigyojoho.setHokenryoDankaiHyoki18("第16段階");
        seigyojoho.setHokenryoDankaiHyoki19("第17段階");
        seigyojoho.setHokenryoDankaiHyoki20("第18段階");

        hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo("2014");
        hokenryodankaiinput.setFukaKonkyo(fukakonkyo);
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        HokenryoDankaiHantei instance = new HokenryoDankaiHantei();
        HokenryoDankaiOutput expResult = new HokenryoDankaiOutput("5");

        expResult.get保険料段階04月().setHokenryoDankai("第4段階１");
        expResult.get保険料段階05月().setHokenryoDankai("第4段階１");
        expResult.get保険料段階06月().setHokenryoDankai("第4段階１");
        expResult.get保険料段階07月().setHokenryoDankai("第4段階１");
        expResult.get保険料段階08月().setHokenryoDankai("第4段階１");
        expResult.get保険料段階09月().setHokenryoDankai("第4段階１");
        expResult.get保険料段階10月().setHokenryoDankai("第4段階１");
        expResult.get保険料段階11月().setHokenryoDankai("第4段階１");
        expResult.get保険料段階12月().setHokenryoDankai("第4段階１");
        expResult.get保険料段階01月().setHokenryoDankai("第4段階１");
        expResult.get保険料段階02月().setHokenryoDankai("第4段階１");
        expResult.get保険料段階03月().setHokenryoDankai("第4段階１");

        expResult.get保険料段階04月().setTokureiTaisho(true);
        expResult.get保険料段階05月().setTokureiTaisho(true);
        expResult.get保険料段階06月().setTokureiTaisho(true);
        expResult.get保険料段階07月().setTokureiTaisho(true);
        expResult.get保険料段階08月().setTokureiTaisho(true);
        expResult.get保険料段階09月().setTokureiTaisho(true);
        expResult.get保険料段階10月().setTokureiTaisho(true);
        expResult.get保険料段階11月().setTokureiTaisho(true);
        expResult.get保険料段階12月().setTokureiTaisho(true);
        expResult.get保険料段階01月().setTokureiTaisho(true);
        expResult.get保険料段階02月().setTokureiTaisho(true);
        expResult.get保険料段階03月().setTokureiTaisho(true);

        HokenryoDankaiOutput result = instance.hokenryoDankaiHantei(hokenryodankaiinput);
        if (!HokenryoDankaiEquals(expResult, result)) {
            fail("段階使用有無全無 5段階 保険料段階failed");
        }
        if (!SystemDankaiEquals(expResult, result)) {
            fail("段階使用有無全無 5段階 システム段階failed");
        }
        if (!TokureiTaishoEquals(expResult, result)) {
            fail("段階使用有無全無 5段階 特例対象failed");
        }

    }

    @Test
    public void testHokenryoDankaiHantei4() {

        System.out.println("段階使用有無全無 途中から生保開始");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryodankaiinput;

        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("非課税");
        fukakonkyo.setGokeiShotoku(new Decimal(1300000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(0));
        fukakonkyo.setSeihoStartYMD(toDate("2014/07/25"));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(500000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));

        seigyojoho.setHokenryoDankaiHyoki01("第1段階");
        seigyojoho.setHokenryoDankaiHyoki02("第2段階");
        seigyojoho.setHokenryoDankaiHyoki03("第3段階①");
        seigyojoho.setHokenryoDankaiHyoki04("第3段階②");
        seigyojoho.setHokenryoDankaiHyoki05("第4段階１");
        seigyojoho.setHokenryoDankaiHyoki06("第4段階２");
        seigyojoho.setHokenryoDankaiHyoki07("第5段階");
        seigyojoho.setHokenryoDankaiHyoki08("第6段階");
        seigyojoho.setHokenryoDankaiHyoki09("第7段階");
        seigyojoho.setHokenryoDankaiHyoki10("第8段階");
        seigyojoho.setHokenryoDankaiHyoki11("第9段階");
        seigyojoho.setHokenryoDankaiHyoki12("第10段階");
        seigyojoho.setHokenryoDankaiHyoki13("第11段階");
        seigyojoho.setHokenryoDankaiHyoki14("第12段階");
        seigyojoho.setHokenryoDankaiHyoki15("第13段階");
        seigyojoho.setHokenryoDankaiHyoki16("第14段階");
        seigyojoho.setHokenryoDankaiHyoki17("第15段階");
        seigyojoho.setHokenryoDankaiHyoki18("第16段階");
        seigyojoho.setHokenryoDankaiHyoki19("第17段階");
        seigyojoho.setHokenryoDankaiHyoki20("第18段階");

        hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo("2014");
        hokenryodankaiinput.setFukaKonkyo(fukakonkyo);
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        HokenryoDankaiHantei instance = new HokenryoDankaiHantei();
        HokenryoDankaiOutput expResult = new HokenryoDankaiOutput("4");

        expResult.get保険料段階04月().setHokenryoDankai("第3段階②");
        expResult.get保険料段階05月().setHokenryoDankai("第3段階②");
        expResult.get保険料段階06月().setHokenryoDankai("第3段階②");
        expResult.get保険料段階07月().setHokenryoDankai("第1段階");
        expResult.get保険料段階08月().setHokenryoDankai("第1段階");
        expResult.get保険料段階09月().setHokenryoDankai("第1段階");
        expResult.get保険料段階10月().setHokenryoDankai("第1段階");
        expResult.get保険料段階11月().setHokenryoDankai("第1段階");
        expResult.get保険料段階12月().setHokenryoDankai("第1段階");
        expResult.get保険料段階01月().setHokenryoDankai("第1段階");
        expResult.get保険料段階02月().setHokenryoDankai("第1段階");
        expResult.get保険料段階03月().setHokenryoDankai("第1段階");

        expResult.get保険料段階07月().setSystemDankai("1");
        expResult.get保険料段階08月().setSystemDankai("1");
        expResult.get保険料段階09月().setSystemDankai("1");
        expResult.get保険料段階10月().setSystemDankai("1");
        expResult.get保険料段階11月().setSystemDankai("1");
        expResult.get保険料段階12月().setSystemDankai("1");
        expResult.get保険料段階01月().setSystemDankai("1");
        expResult.get保険料段階02月().setSystemDankai("1");
        expResult.get保険料段階03月().setSystemDankai("1");

        expResult.get保険料段階07月().setTokureiTaisho(false);
        expResult.get保険料段階08月().setTokureiTaisho(false);
        expResult.get保険料段階09月().setTokureiTaisho(false);
        expResult.get保険料段階10月().setTokureiTaisho(false);
        expResult.get保険料段階11月().setTokureiTaisho(false);
        expResult.get保険料段階12月().setTokureiTaisho(false);
        expResult.get保険料段階01月().setTokureiTaisho(false);
        expResult.get保険料段階02月().setTokureiTaisho(false);
        expResult.get保険料段階03月().setTokureiTaisho(false);

        HokenryoDankaiOutput result = instance.hokenryoDankaiHantei(hokenryodankaiinput);
        if (!HokenryoDankaiEquals(expResult, result)) {
            fail("段階使用有無全無 途中から生保開始 保険料段階failed");
        }
        if (!SystemDankaiEquals(expResult, result)) {
            fail("段階使用有無全無 途中から生保開始 システム段階failed");
        }
        if (!TokureiTaishoEquals(expResult, result)) {
            fail("段階使用有無全無 途中から生保開始 特例対象failed");
        }
    }

    @Test
    public void testHokenryoDankaiHantei5() {

        System.out.println("段階使用有無全無 途中で生保終了");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryodankaiinput;

        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("非課税");
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(0));
        fukakonkyo.setSeihoStartYMD(toDate("2014/01/25"));
        fukakonkyo.setSeihoEndYMD(toDate("2014/07/25"));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));

        seigyojoho.setHokenryoDankaiHyoki01("第1段階");
        seigyojoho.setHokenryoDankaiHyoki02("第2段階");
        seigyojoho.setHokenryoDankaiHyoki03("第3段階①");
        seigyojoho.setHokenryoDankaiHyoki04("第3段階②");
        seigyojoho.setHokenryoDankaiHyoki05("第4段階１");
        seigyojoho.setHokenryoDankaiHyoki06("第4段階２");
        seigyojoho.setHokenryoDankaiHyoki07("第5段階");
        seigyojoho.setHokenryoDankaiHyoki08("第6段階");
        seigyojoho.setHokenryoDankaiHyoki09("第7段階");
        seigyojoho.setHokenryoDankaiHyoki10("第8段階");
        seigyojoho.setHokenryoDankaiHyoki11("第9段階");
        seigyojoho.setHokenryoDankaiHyoki12("第10段階");
        seigyojoho.setHokenryoDankaiHyoki13("第11段階");
        seigyojoho.setHokenryoDankaiHyoki14("第12段階");
        seigyojoho.setHokenryoDankaiHyoki15("第13段階");
        seigyojoho.setHokenryoDankaiHyoki16("第14段階");
        seigyojoho.setHokenryoDankaiHyoki17("第15段階");
        seigyojoho.setHokenryoDankaiHyoki18("第16段階");
        seigyojoho.setHokenryoDankaiHyoki19("第17段階");
        seigyojoho.setHokenryoDankaiHyoki20("第18段階");

        hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo("2014");
        hokenryodankaiinput.setFukaKonkyo(fukakonkyo);
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        HokenryoDankaiHantei instance = new HokenryoDankaiHantei();
        HokenryoDankaiOutput expResult = new HokenryoDankaiOutput("4");

        expResult.get保険料段階01月().setHokenryoDankai("第1段階");
        expResult.get保険料段階02月().setHokenryoDankai("第1段階");
        expResult.get保険料段階03月().setHokenryoDankai("第1段階");
        expResult.get保険料段階04月().setHokenryoDankai("第1段階");
        expResult.get保険料段階05月().setHokenryoDankai("第1段階");
        expResult.get保険料段階06月().setHokenryoDankai("第1段階");
        expResult.get保険料段階07月().setHokenryoDankai("第1段階");
        expResult.get保険料段階08月().setHokenryoDankai("第1段階");
        expResult.get保険料段階09月().setHokenryoDankai("第1段階");
        expResult.get保険料段階10月().setHokenryoDankai("第1段階");
        expResult.get保険料段階11月().setHokenryoDankai("第1段階");
        expResult.get保険料段階12月().setHokenryoDankai("第1段階");

        expResult.get保険料段階01月().setSystemDankai("1");
        expResult.get保険料段階02月().setSystemDankai("1");
        expResult.get保険料段階03月().setSystemDankai("1");
        expResult.get保険料段階04月().setSystemDankai("1");
        expResult.get保険料段階05月().setSystemDankai("1");
        expResult.get保険料段階06月().setSystemDankai("1");
        expResult.get保険料段階07月().setSystemDankai("1");
        expResult.get保険料段階08月().setSystemDankai("1");
        expResult.get保険料段階09月().setSystemDankai("1");
        expResult.get保険料段階10月().setSystemDankai("1");
        expResult.get保険料段階11月().setSystemDankai("1");
        expResult.get保険料段階12月().setSystemDankai("1");

        expResult.get保険料段階01月().setTokureiTaisho(false);
        expResult.get保険料段階02月().setTokureiTaisho(false);
        expResult.get保険料段階03月().setTokureiTaisho(false);
        expResult.get保険料段階04月().setTokureiTaisho(false);
        expResult.get保険料段階05月().setTokureiTaisho(false);
        expResult.get保険料段階06月().setTokureiTaisho(false);
        expResult.get保険料段階07月().setTokureiTaisho(false);
        expResult.get保険料段階08月().setTokureiTaisho(false);
        expResult.get保険料段階09月().setTokureiTaisho(false);
        expResult.get保険料段階10月().setTokureiTaisho(false);
        expResult.get保険料段階11月().setTokureiTaisho(false);
        expResult.get保険料段階12月().setTokureiTaisho(false);

        HokenryoDankaiOutput result = instance.hokenryoDankaiHantei(hokenryodankaiinput);
        if (!HokenryoDankaiEquals(expResult, result)) {
            fail("段階使用有無全無 途中で生保終了 保険料段階failed");
        }
        if (!SystemDankaiEquals(expResult, result)) {
            fail("段階使用有無全無 途中で生保終了 システム段階failed");
        }
        if (!TokureiTaishoEquals(expResult, result)) {
            fail("段階使用有無全無 途中で生保終了 特例対象failed");
        }
    }

    @Test
    public void testHokenryoDankaiHantei6() {

        System.out.println("段階使用有無全無 途中で生保開始終了");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryodankaiinput;

        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("非課税");
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(300001));
        fukakonkyo.setSeihoStartYMD(toDate("2015/01/25"));
        fukakonkyo.setSeihoEndYMD(toDate("2015/02/25"));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));

        seigyojoho.setHokenryoDankaiHyoki01("第1段階");
        seigyojoho.setHokenryoDankaiHyoki02("第2段階");
        seigyojoho.setHokenryoDankaiHyoki03("第3段階①");
        seigyojoho.setHokenryoDankaiHyoki04("第3段階②");
        seigyojoho.setHokenryoDankaiHyoki05("第4段階１");
        seigyojoho.setHokenryoDankaiHyoki06("第4段階２");
        seigyojoho.setHokenryoDankaiHyoki07("第5段階");
        seigyojoho.setHokenryoDankaiHyoki08("第6段階");
        seigyojoho.setHokenryoDankaiHyoki09("第7段階");
        seigyojoho.setHokenryoDankaiHyoki10("第8段階");
        seigyojoho.setHokenryoDankaiHyoki11("第9段階");
        seigyojoho.setHokenryoDankaiHyoki12("第10段階");
        seigyojoho.setHokenryoDankaiHyoki13("第11段階");
        seigyojoho.setHokenryoDankaiHyoki14("第12段階");
        seigyojoho.setHokenryoDankaiHyoki15("第13段階");
        seigyojoho.setHokenryoDankaiHyoki16("第14段階");
        seigyojoho.setHokenryoDankaiHyoki17("第15段階");
        seigyojoho.setHokenryoDankaiHyoki18("第16段階");
        seigyojoho.setHokenryoDankaiHyoki19("第17段階");
        seigyojoho.setHokenryoDankaiHyoki20("第18段階");

        hokenryodankaiinput = new HokenryoDankaiInput();
        hokenryodankaiinput.setFukaNendo("2014");
        hokenryodankaiinput.setFukaKonkyo(fukakonkyo);
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        HokenryoDankaiHantei instance = new HokenryoDankaiHantei();
        HokenryoDankaiOutput expResult = new HokenryoDankaiOutput("3");

        expResult.get保険料段階04月().setHokenryoDankai("第3段階①");
        expResult.get保険料段階05月().setHokenryoDankai("第3段階①");
        expResult.get保険料段階06月().setHokenryoDankai("第3段階①");
        expResult.get保険料段階07月().setHokenryoDankai("第3段階①");
        expResult.get保険料段階08月().setHokenryoDankai("第3段階①");
        expResult.get保険料段階09月().setHokenryoDankai("第3段階①");
        expResult.get保険料段階10月().setHokenryoDankai("第3段階①");
        expResult.get保険料段階11月().setHokenryoDankai("第3段階①");
        expResult.get保険料段階12月().setHokenryoDankai("第3段階①");
        expResult.get保険料段階01月().setHokenryoDankai("第1段階");
        expResult.get保険料段階02月().setHokenryoDankai("第1段階");
        expResult.get保険料段階03月().setHokenryoDankai("第1段階");

        expResult.get保険料段階01月().setSystemDankai("1");
        expResult.get保険料段階02月().setSystemDankai("1");
        expResult.get保険料段階03月().setSystemDankai("1");

        expResult.get保険料段階04月().setTokureiTaisho(true);
        expResult.get保険料段階05月().setTokureiTaisho(true);
        expResult.get保険料段階06月().setTokureiTaisho(true);
        expResult.get保険料段階07月().setTokureiTaisho(true);
        expResult.get保険料段階08月().setTokureiTaisho(true);
        expResult.get保険料段階09月().setTokureiTaisho(true);
        expResult.get保険料段階10月().setTokureiTaisho(true);
        expResult.get保険料段階11月().setTokureiTaisho(true);
        expResult.get保険料段階12月().setTokureiTaisho(true);
        expResult.get保険料段階01月().setTokureiTaisho(false);
        expResult.get保険料段階02月().setTokureiTaisho(false);
        expResult.get保険料段階03月().setTokureiTaisho(false);

        HokenryoDankaiOutput result = instance.hokenryoDankaiHantei(hokenryodankaiinput);
        if (!HokenryoDankaiEquals(expResult, result)) {
            fail("段階使用有無全無 途中で生保開始終了 保険料段階failed");
        }
        if (!SystemDankaiEquals(expResult, result)) {
            fail("段階使用有無全無 途中で生保開始終了 システム段階failed");
        }
        if (!TokureiTaishoEquals(expResult, result)) {
            fail("段階使用有無全無 途中で生保開始終了 特例対象failed");
        }
    }

    protected static Date toDate(String str) {
        Date date = null;
        try {
            date = DateFormat.getDateInstance().parse(str);
        } catch (ParseException pe) {

        }
        return date;
    }

    private boolean HokenryoDankaiEquals(HokenryoDankaiOutput input1, HokenryoDankaiOutput input2) {

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

    private boolean SystemDankaiEquals(HokenryoDankaiOutput expResult, HokenryoDankaiOutput resultoutput) {

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

    private boolean TokureiTaishoEquals(HokenryoDankaiOutput expResult, HokenryoDankaiOutput resultoutput) {

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
