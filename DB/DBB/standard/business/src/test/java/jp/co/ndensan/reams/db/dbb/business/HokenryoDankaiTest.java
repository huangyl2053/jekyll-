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
public class HokenryoDankaiTest {

    public HokenryoDankaiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of HokenryoDankaiHantei method, of class HokenryoDankai.
     */
    @Test
    public void testHokenryoDankaiHantei2() {
        System.out.println("2段階");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryoDankaiInput;

        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("非課税");
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(100000));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));

        hokenryoDankaiInput = new HokenryoDankaiInput();
        hokenryoDankaiInput.setFukaNendo("2014");
        hokenryoDankaiInput.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiInput.setSeigyoJoho(seigyojoho);

        HokenryoDankaiHanteiHohoHozon hokenryoDankaiHanteiHoho = HokenryoDankaiHanteiHohoHozonFactory.CreateHokenryoDankaiHanteiHoho(hokenryoDankaiInput);

        保険料段階 instance = new 保険料段階();
        HokenryoDankaiOutput expResult = new HokenryoDankaiOutput("2");
        HokenryoDankaiOutput result = instance.HokenryoDankaiHantei(hokenryoDankaiInput, hokenryoDankaiHanteiHoho);
        if (!HokenryoDankaiEquals(expResult, result)) {
            fail("2段階 保険料段階failed");
        }
        if (!SystemDankaiEquals(expResult, result)) {
            fail("2段階 システム段階failed");
        }
        if (!TokureiTaishoEquals(expResult, result)) {
            fail("2段階 特例対象failed");
        }

    }

    @Test
    public void testHokenryoDankaiHantei3() {
        System.out.println("3段階");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryoDankaiInput;

        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("非課税");
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(400000));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));

        hokenryoDankaiInput = new HokenryoDankaiInput();
        hokenryoDankaiInput.setFukaNendo("2014");
        hokenryoDankaiInput.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiInput.setSeigyoJoho(seigyojoho);

        HokenryoDankaiHanteiHohoHozon hokenryoDankaiHanteiHoho = HokenryoDankaiHanteiHohoHozonFactory.CreateHokenryoDankaiHanteiHoho(hokenryoDankaiInput);
        保険料段階 instance = new 保険料段階();
        HokenryoDankaiOutput expResult = new HokenryoDankaiOutput("3");

        expResult.get保険料段階01月().setTokureiTaisho(true);
        expResult.get保険料段階02月().setTokureiTaisho(true);
        expResult.get保険料段階03月().setTokureiTaisho(true);
        expResult.get保険料段階04月().setTokureiTaisho(true);
        expResult.get保険料段階05月().setTokureiTaisho(true);
        expResult.get保険料段階06月().setTokureiTaisho(true);
        expResult.get保険料段階07月().setTokureiTaisho(true);
        expResult.get保険料段階08月().setTokureiTaisho(true);
        expResult.get保険料段階09月().setTokureiTaisho(true);
        expResult.get保険料段階10月().setTokureiTaisho(true);
        expResult.get保険料段階11月().setTokureiTaisho(true);
        expResult.get保険料段階12月().setTokureiTaisho(true);

        HokenryoDankaiOutput result = instance.HokenryoDankaiHantei(hokenryoDankaiInput, hokenryoDankaiHanteiHoho);
        if (!HokenryoDankaiEquals(expResult, result)) {
            fail("3段階 保険料段階failed");
        }
        if (!SystemDankaiEquals(expResult, result)) {
            fail("3段階 システム段階failed");
        }
        if (!TokureiTaishoEquals(expResult, result)) {
            fail("3段階 特例対象failed");
        }

    }

    @Test
    public void testHokenryoDankaiHantei4() {
        System.out.println("4段階");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryoDankaiInput;

        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("非課税");
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(800000));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));

        hokenryoDankaiInput = new HokenryoDankaiInput();
        hokenryoDankaiInput.setFukaNendo("2014");
        hokenryoDankaiInput.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiInput.setSeigyoJoho(seigyojoho);

        HokenryoDankaiHanteiHohoHozon hokenryoDankaiHanteiHoho = HokenryoDankaiHanteiHohoHozonFactory.CreateHokenryoDankaiHanteiHoho(hokenryoDankaiInput);
        保険料段階 instance = new 保険料段階();
        HokenryoDankaiOutput expResult = new HokenryoDankaiOutput("4");
        HokenryoDankaiOutput result = instance.HokenryoDankaiHantei(hokenryoDankaiInput, hokenryoDankaiHanteiHoho);
        if (!HokenryoDankaiEquals(expResult, result)) {
            fail("4段階 保険料段階failed");
        }
        if (!SystemDankaiEquals(expResult, result)) {
            fail("4段階 システム段階failed");
        }
        if (!TokureiTaishoEquals(expResult, result)) {
            fail("4段階 特例対象failed");
        }
    }

    @Test
    public void testHokenryoDankaiHantei5() {
        System.out.println("5段階");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryoDankaiInput;

        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("課税");
        fukakonkyo.setGokeiShotoku(new Decimal(400000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(300000));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));

        hokenryoDankaiInput = new HokenryoDankaiInput();
        hokenryoDankaiInput.setFukaNendo("2014");
        hokenryoDankaiInput.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiInput.setSeigyoJoho(seigyojoho);

        HokenryoDankaiHanteiHohoHozon hokenryoDankaiHanteiHoho = HokenryoDankaiHanteiHohoHozonFactory.CreateHokenryoDankaiHanteiHoho(hokenryoDankaiInput);
        保険料段階 instance = new 保険料段階();
        HokenryoDankaiOutput expResult = new HokenryoDankaiOutput("5");

        expResult.get保険料段階01月().setTokureiTaisho(true);
        expResult.get保険料段階02月().setTokureiTaisho(true);
        expResult.get保険料段階03月().setTokureiTaisho(true);
        expResult.get保険料段階04月().setTokureiTaisho(true);
        expResult.get保険料段階05月().setTokureiTaisho(true);
        expResult.get保険料段階06月().setTokureiTaisho(true);
        expResult.get保険料段階07月().setTokureiTaisho(true);
        expResult.get保険料段階08月().setTokureiTaisho(true);
        expResult.get保険料段階09月().setTokureiTaisho(true);
        expResult.get保険料段階10月().setTokureiTaisho(true);
        expResult.get保険料段階11月().setTokureiTaisho(true);
        expResult.get保険料段階12月().setTokureiTaisho(true);

        HokenryoDankaiOutput result = instance.HokenryoDankaiHantei(hokenryoDankaiInput, hokenryoDankaiHanteiHoho);
        if (!HokenryoDankaiEquals(expResult, result)) {
            fail("5段階 保険料段階failed");
        }
        if (!SystemDankaiEquals(expResult, result)) {
            fail("5段階 システム段階failed");
        }
        if (!TokureiTaishoEquals(expResult, result)) {
            fail("5段階 特例対象failed");
        }

    }

    @Test
    public void testHokenryoDankaiHantei6() {
        System.out.println("6段階");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryoDankaiInput;

        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("課税");
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(600000));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));

        hokenryoDankaiInput = new HokenryoDankaiInput();
        hokenryoDankaiInput.setFukaNendo("2014");
        hokenryoDankaiInput.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiInput.setSeigyoJoho(seigyojoho);

        HokenryoDankaiHanteiHohoHozon hokenryoDankaiHanteiHoho = HokenryoDankaiHanteiHohoHozonFactory.CreateHokenryoDankaiHanteiHoho(hokenryoDankaiInput);
        保険料段階 instance = new 保険料段階();
        HokenryoDankaiOutput expResult = new HokenryoDankaiOutput("6");
        HokenryoDankaiOutput result = instance.HokenryoDankaiHantei(hokenryoDankaiInput, hokenryoDankaiHanteiHoho);
        if (!HokenryoDankaiEquals(expResult, result)) {
            fail("6段階 保険料段階failed");
        }
        if (!SystemDankaiEquals(expResult, result)) {
            fail("6段階 システム段階failed");
        }
        if (!TokureiTaishoEquals(expResult, result)) {
            fail("6段階 特例対象failed");
        }
    }

    @Test
    public void testHokenryoDankaiHantei7() {
        System.out.println("7段階");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryoDankaiInput;

        fukakonkyo.setHonninKazeiKubun("課税");
        fukakonkyo.setSetaiKazeiKubun("課税");
        fukakonkyo.setGokeiShotoku(new Decimal(500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(600000));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));

        hokenryoDankaiInput = new HokenryoDankaiInput();
        hokenryoDankaiInput.setFukaNendo("2014");
        hokenryoDankaiInput.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiInput.setSeigyoJoho(seigyojoho);

        HokenryoDankaiHanteiHohoHozon hokenryoDankaiHanteiHoho = HokenryoDankaiHanteiHohoHozonFactory.CreateHokenryoDankaiHanteiHoho(hokenryoDankaiInput);
        保険料段階 instance = new 保険料段階();
        HokenryoDankaiOutput expResult = new HokenryoDankaiOutput("7");
        HokenryoDankaiOutput result = instance.HokenryoDankaiHantei(hokenryoDankaiInput, hokenryoDankaiHanteiHoho);
        if (!HokenryoDankaiEquals(expResult, result)) {
            fail("7段階 保険料段階failed");
        }
        if (!SystemDankaiEquals(expResult, result)) {
            fail("7段階 システム段階failed");
        }
        if (!TokureiTaishoEquals(expResult, result)) {
            fail("7段階 特例対象failed");
        }

    }

    @Test
    public void testHokenryoDankaiHantei8() {
        System.out.println("8段階");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryoDankaiInput;

        fukakonkyo.setHonninKazeiKubun("課税");
        fukakonkyo.setSetaiKazeiKubun("課税");
        fukakonkyo.setGokeiShotoku(new Decimal(1500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(300000));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));

        hokenryoDankaiInput = new HokenryoDankaiInput();
        hokenryoDankaiInput.setFukaNendo("2014");
        hokenryoDankaiInput.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiInput.setSeigyoJoho(seigyojoho);

        HokenryoDankaiHanteiHohoHozon hokenryoDankaiHanteiHoho = HokenryoDankaiHanteiHohoHozonFactory.CreateHokenryoDankaiHanteiHoho(hokenryoDankaiInput);
        保険料段階 instance = new 保険料段階();
        HokenryoDankaiOutput expResult = new HokenryoDankaiOutput("8");
        HokenryoDankaiOutput result = instance.HokenryoDankaiHantei(hokenryoDankaiInput, hokenryoDankaiHanteiHoho);
        if (!HokenryoDankaiEquals(expResult, result)) {
            fail("8段階 保険料段階failed");
        }
        if (!SystemDankaiEquals(expResult, result)) {
            fail("8段階 システム段階failed");
        }
        if (!TokureiTaishoEquals(expResult, result)) {
            fail("8段階 特例対象failed");
        }
    }

    @Test
    public void testHokenryoDankaiHantei9() {
        System.out.println("9段階");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryoDankaiInput;

        fukakonkyo.setHonninKazeiKubun("課税");
        fukakonkyo.setSetaiKazeiKubun("課税");
        fukakonkyo.setGokeiShotoku(new Decimal(1500000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(600000));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));

        hokenryoDankaiInput = new HokenryoDankaiInput();
        hokenryoDankaiInput.setFukaNendo("2014");
        hokenryoDankaiInput.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiInput.setSeigyoJoho(seigyojoho);

        HokenryoDankaiHanteiHohoHozon hokenryoDankaiHanteiHoho = HokenryoDankaiHanteiHohoHozonFactory.CreateHokenryoDankaiHanteiHoho(hokenryoDankaiInput);
        保険料段階 instance = new 保険料段階();
        HokenryoDankaiOutput expResult = new HokenryoDankaiOutput("9");
        HokenryoDankaiOutput result = instance.HokenryoDankaiHantei(hokenryoDankaiInput, hokenryoDankaiHanteiHoho);
        if (!HokenryoDankaiEquals(expResult, result)) {
            fail("9段階 保険料段階failed");
        }
        if (!SystemDankaiEquals(expResult, result)) {
            fail("9段階 システム段階failed");
        }
        if (!TokureiTaishoEquals(expResult, result)) {
            fail("9段階 特例対象failed");
        }
    }

    @Test
    public void testHokenryoDankaiHantei10() {
        System.out.println("2段階_生保");

        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();
        HokenryoDankaiInput hokenryoDankaiInput;

        fukakonkyo.setHonninKazeiKubun("非課税");
        fukakonkyo.setSetaiKazeiKubun("非課税");
        fukakonkyo.setGokeiShotoku(new Decimal(100000));
        fukakonkyo.setKotekiNenkinShunyu(new Decimal(600000));
        fukakonkyo.setSeihoStartYMD(toDate("2011/02/06"));

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));

        hokenryoDankaiInput = new HokenryoDankaiInput();
        hokenryoDankaiInput.setFukaNendo("2014");
        hokenryoDankaiInput.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiInput.setSeigyoJoho(seigyojoho);

        HokenryoDankaiHanteiHohoHozon hokenryoDankaiHanteiHoho = HokenryoDankaiHanteiHohoHozonFactory.CreateHokenryoDankaiHanteiHoho(hokenryoDankaiInput);
        保険料段階 instance = new 保険料段階();
        HokenryoDankaiOutput expResult = new HokenryoDankaiOutput("1");

        HokenryoDankaiOutput result = instance.HokenryoDankaiHantei(hokenryoDankaiInput, hokenryoDankaiHanteiHoho);
        if (!HokenryoDankaiEquals(expResult, result)) {
            fail("2段階_生保 保険料段階failed");
        }
        if (!SystemDankaiEquals(expResult, result)) {
            fail("2段階_生保 システム段階failed");
        }
        if (!TokureiTaishoEquals(expResult, result)) {
            fail("2段階_生保 特例対象failed");

        }

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

    protected static Date toDate(String str) {
        Date date = null;
        try {
            date = DateFormat.getDateInstance().parse(str);
        } catch (ParseException pe) {

        }
        return date;
    }

}
