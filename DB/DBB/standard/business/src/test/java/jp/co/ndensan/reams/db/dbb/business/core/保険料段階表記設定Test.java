/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
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
public class 保険料段階表記設定Test {

    public 保険料段階表記設定Test() {
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
    public void test保険料段階表記設定1() {
        System.out.println(new RString("保険料段階表記設定1"));
        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();

        fukakonkyo.setSeihoStartYMD(toDate(new RString("2014/07/25")));

        seigyojoho.setHokenryoDankaiHyoki01(new RString("第1段階"));
        seigyojoho.setHokenryoDankaiHyoki02(new RString("第2段階"));
        seigyojoho.setHokenryoDankaiHyoki03(new RString("第3段階①"));
        seigyojoho.setHokenryoDankaiHyoki04(new RString("第3段階②"));
        seigyojoho.setHokenryoDankaiHyoki05(new RString("第4段階１"));
        seigyojoho.setHokenryoDankaiHyoki06(new RString("第4段階２"));
        seigyojoho.setHokenryoDankaiHyoki07(new RString("第5段階"));
        seigyojoho.setHokenryoDankaiHyoki08(new RString("第6段階"));
        seigyojoho.setHokenryoDankaiHyoki09(new RString("第7段階"));
        seigyojoho.setHokenryoDankaiHyoki10(new RString("第8段階"));
        seigyojoho.setHokenryoDankaiHyoki11(new RString("第9段階"));
        seigyojoho.setHokenryoDankaiHyoki12(new RString("第10段階"));
        seigyojoho.setHokenryoDankaiHyoki13(new RString("第11段階"));
        seigyojoho.setHokenryoDankaiHyoki14(new RString("第12段階"));
        seigyojoho.setHokenryoDankaiHyoki15(new RString("第13段階"));
        seigyojoho.setHokenryoDankaiHyoki16(new RString("第14段階"));
        seigyojoho.setHokenryoDankaiHyoki17(new RString("第15段階"));
        seigyojoho.setHokenryoDankaiHyoki18(new RString("第16段階"));
        seigyojoho.setHokenryoDankaiHyoki19(new RString("第17段階"));
        seigyojoho.setHokenryoDankaiHyoki20(new RString("第18段階"));

        HokenryoDankaiInput hokenryoDankaiInput = new HokenryoDankaiInput();
        hokenryoDankaiInput.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiInput.setSeigyoJoho(seigyojoho);

        HokenryoDankaiOutput hokenryoDankaiOutput = new HokenryoDankaiOutput(new RString("4"));
        hokenryoDankaiOutput.get保険料段階01月().setHokenryoDankai(new RString("1"));
        hokenryoDankaiOutput.get保険料段階02月().setHokenryoDankai(new RString("2"));
        hokenryoDankaiOutput.get保険料段階03月().setHokenryoDankai(new RString("3"));
        hokenryoDankaiOutput.get保険料段階04月().setHokenryoDankai(new RString("4"));
        hokenryoDankaiOutput.get保険料段階05月().setHokenryoDankai(new RString("5"));
        hokenryoDankaiOutput.get保険料段階06月().setHokenryoDankai(new RString("6"));
        hokenryoDankaiOutput.get保険料段階07月().setHokenryoDankai(new RString("7"));
        hokenryoDankaiOutput.get保険料段階08月().setHokenryoDankai(new RString("8"));
        hokenryoDankaiOutput.get保険料段階09月().setHokenryoDankai(new RString("9"));
        hokenryoDankaiOutput.get保険料段階10月().setHokenryoDankai(new RString("10"));
        hokenryoDankaiOutput.get保険料段階11月().setHokenryoDankai(new RString("11"));
        hokenryoDankaiOutput.get保険料段階12月().setHokenryoDankai(new RString("12"));

        HokenryoDankaiOutput expResult = new HokenryoDankaiOutput(new RString("4"));
        hokenryoDankaiOutput.get保険料段階01月().setHokenryoDankai(new RString("第1段階"));
        hokenryoDankaiOutput.get保険料段階02月().setHokenryoDankai(new RString("第2段階"));
        hokenryoDankaiOutput.get保険料段階03月().setHokenryoDankai(new RString("第3段階①"));
        hokenryoDankaiOutput.get保険料段階04月().setHokenryoDankai(new RString("第3段階②"));
        hokenryoDankaiOutput.get保険料段階05月().setHokenryoDankai(new RString("第4段階１"));
        hokenryoDankaiOutput.get保険料段階06月().setHokenryoDankai(new RString("第4段階２"));
        hokenryoDankaiOutput.get保険料段階07月().setHokenryoDankai(new RString("第5段階"));
        hokenryoDankaiOutput.get保険料段階08月().setHokenryoDankai(new RString("第6段階"));
        hokenryoDankaiOutput.get保険料段階09月().setHokenryoDankai(new RString("第7段階"));
        hokenryoDankaiOutput.get保険料段階10月().setHokenryoDankai(new RString("第8段階"));
        hokenryoDankaiOutput.get保険料段階11月().setHokenryoDankai(new RString("第9段階"));
        hokenryoDankaiOutput.get保険料段階12月().setHokenryoDankai(new RString("第10段階"));

        保険料段階表記設定.set保険料段階表記(hokenryoDankaiInput, hokenryoDankaiOutput);
        if (outputEquals(hokenryoDankaiOutput, expResult)) {
            fail("保険料段階表記設定1 failed");
        }
    }

    @Test
    public void test保険料段階表記設定2() {
        System.out.println(new RString("保険料段階表記設定2"));
        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();

        fukakonkyo.setSeihoStartYMD(toDate(new RString("2014/07/25")));

        seigyojoho.setHokenryoDankaiHyoki01(new RString("第1段階"));
        seigyojoho.setHokenryoDankaiHyoki02(new RString("第2段階"));
        seigyojoho.setHokenryoDankaiHyoki03(new RString("第3段階①"));
        seigyojoho.setHokenryoDankaiHyoki04(new RString("第3段階②"));
        seigyojoho.setHokenryoDankaiHyoki05(new RString("第4段階１"));
        seigyojoho.setHokenryoDankaiHyoki06(new RString("第4段階２"));
        seigyojoho.setHokenryoDankaiHyoki07(new RString("第5段階"));
        seigyojoho.setHokenryoDankaiHyoki08(new RString("第6段階"));
        seigyojoho.setHokenryoDankaiHyoki09(new RString("第7段階"));
        seigyojoho.setHokenryoDankaiHyoki10(new RString("第8段階"));
        seigyojoho.setHokenryoDankaiHyoki11(new RString("第9段階"));
        seigyojoho.setHokenryoDankaiHyoki12(new RString("第10段階"));
        seigyojoho.setHokenryoDankaiHyoki13(new RString("第11段階"));
        seigyojoho.setHokenryoDankaiHyoki14(new RString("第12段階"));
        seigyojoho.setHokenryoDankaiHyoki15(new RString("第13段階"));
        seigyojoho.setHokenryoDankaiHyoki16(new RString("第14段階"));
        seigyojoho.setHokenryoDankaiHyoki17(new RString("第15段階"));
        seigyojoho.setHokenryoDankaiHyoki18(new RString("第16段階"));
        seigyojoho.setHokenryoDankaiHyoki19(new RString("第17段階"));
        seigyojoho.setHokenryoDankaiHyoki20(new RString("第18段階"));

        HokenryoDankaiInput hokenryoDankaiInput = new HokenryoDankaiInput();
        hokenryoDankaiInput.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiInput.setSeigyoJoho(seigyojoho);

        HokenryoDankaiOutput hokenryoDankaiOutput = new HokenryoDankaiOutput(new RString("4"));
        hokenryoDankaiOutput.get保険料段階01月().setHokenryoDankai(new RString("12"));
        hokenryoDankaiOutput.get保険料段階02月().setHokenryoDankai(new RString("13"));
        hokenryoDankaiOutput.get保険料段階03月().setHokenryoDankai(new RString("14"));
        hokenryoDankaiOutput.get保険料段階04月().setHokenryoDankai(new RString("15"));
        hokenryoDankaiOutput.get保険料段階05月().setHokenryoDankai(new RString("16"));
        hokenryoDankaiOutput.get保険料段階06月().setHokenryoDankai(new RString("17"));
        hokenryoDankaiOutput.get保険料段階07月().setHokenryoDankai(new RString("18"));
        hokenryoDankaiOutput.get保険料段階08月().setHokenryoDankai(new RString("19"));
        hokenryoDankaiOutput.get保険料段階09月().setHokenryoDankai(new RString("20"));

        HokenryoDankaiOutput expResult = new HokenryoDankaiOutput(new RString("4"));
        hokenryoDankaiOutput.get保険料段階01月().setHokenryoDankai(new RString("第10段階"));
        hokenryoDankaiOutput.get保険料段階02月().setHokenryoDankai(new RString("第11段階"));
        hokenryoDankaiOutput.get保険料段階03月().setHokenryoDankai(new RString("第12段階"));
        hokenryoDankaiOutput.get保険料段階04月().setHokenryoDankai(new RString("第13段階"));
        hokenryoDankaiOutput.get保険料段階05月().setHokenryoDankai(new RString("第14段階"));
        hokenryoDankaiOutput.get保険料段階06月().setHokenryoDankai(new RString("第15段階"));
        hokenryoDankaiOutput.get保険料段階07月().setHokenryoDankai(new RString("第16段階"));
        hokenryoDankaiOutput.get保険料段階08月().setHokenryoDankai(new RString("第17段階"));
        hokenryoDankaiOutput.get保険料段階09月().setHokenryoDankai(new RString("第18段階"));
        hokenryoDankaiOutput.get保険料段階10月().setHokenryoDankai(new RString("第3段階②"));
        hokenryoDankaiOutput.get保険料段階11月().setHokenryoDankai(new RString("第3段階②"));
        hokenryoDankaiOutput.get保険料段階12月().setHokenryoDankai(new RString("第3段階②"));

        保険料段階表記設定.set保険料段階表記(hokenryoDankaiInput, hokenryoDankaiOutput);
        if (outputEquals(hokenryoDankaiOutput, expResult)) {
            fail("保険料段階表記設定2 failed");
        }
    }

    protected static Date toDate(RString str) {
        Date date = null;
        try {
            date = DateFormat.getDateInstance().parse(str.toString());
        } catch (ParseException pe) {

        }
        return date;
    }

    private boolean outputEquals(HokenryoDankaiOutput input1, HokenryoDankaiOutput input2) {

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
