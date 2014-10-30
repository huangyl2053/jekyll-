/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author N2810
 */
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
     * Test of 保険料段階表記設定 method, of class 保険料段階表記設定.
     */
    @Test
    public void test保険料段階表記設定1() {
        System.out.println("保険料段階表記設定1");
        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();

        fukakonkyo.setSeihoStartYMD(toDate("2014/07/25"));

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

        HokenryoDankaiInput hokenryoDankaiInput = new HokenryoDankaiInput();
        hokenryoDankaiInput.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiInput.setSeigyoJoho(seigyojoho);

        HokenryoDankaiOutput hokenryoDankaiOutput = new HokenryoDankaiOutput("4");
        hokenryoDankaiOutput.get保険料段階01月().setHokenryoDankai("1");
        hokenryoDankaiOutput.get保険料段階02月().setHokenryoDankai("2");
        hokenryoDankaiOutput.get保険料段階03月().setHokenryoDankai("3");
        hokenryoDankaiOutput.get保険料段階04月().setHokenryoDankai("4");
        hokenryoDankaiOutput.get保険料段階05月().setHokenryoDankai("5");
        hokenryoDankaiOutput.get保険料段階06月().setHokenryoDankai("6");
        hokenryoDankaiOutput.get保険料段階07月().setHokenryoDankai("7");
        hokenryoDankaiOutput.get保険料段階08月().setHokenryoDankai("8");
        hokenryoDankaiOutput.get保険料段階09月().setHokenryoDankai("9");
        hokenryoDankaiOutput.get保険料段階10月().setHokenryoDankai("10");
        hokenryoDankaiOutput.get保険料段階11月().setHokenryoDankai("11");
        hokenryoDankaiOutput.get保険料段階12月().setHokenryoDankai("12");

        HokenryoDankaiOutput expResult = new HokenryoDankaiOutput("4");
        hokenryoDankaiOutput.get保険料段階01月().setHokenryoDankai("第1段階");
        hokenryoDankaiOutput.get保険料段階02月().setHokenryoDankai("第2段階");
        hokenryoDankaiOutput.get保険料段階03月().setHokenryoDankai("第3段階①");
        hokenryoDankaiOutput.get保険料段階04月().setHokenryoDankai("第3段階②");
        hokenryoDankaiOutput.get保険料段階05月().setHokenryoDankai("第4段階１");
        hokenryoDankaiOutput.get保険料段階06月().setHokenryoDankai("第4段階２");
        hokenryoDankaiOutput.get保険料段階07月().setHokenryoDankai("第5段階");
        hokenryoDankaiOutput.get保険料段階08月().setHokenryoDankai("第6段階");
        hokenryoDankaiOutput.get保険料段階09月().setHokenryoDankai("第7段階");
        hokenryoDankaiOutput.get保険料段階10月().setHokenryoDankai("第8段階");
        hokenryoDankaiOutput.get保険料段階11月().setHokenryoDankai("第9段階");
        hokenryoDankaiOutput.get保険料段階12月().setHokenryoDankai("第10段階");

        保険料段階表記設定.保険料段階表記設定(hokenryoDankaiInput, hokenryoDankaiOutput);
        if (outputEquals(hokenryoDankaiOutput, expResult)) {
            fail("保険料段階表記設定1 failed");
        }
    }

    @Test
    public void test保険料段階表記設定2() {
        System.out.println("保険料段階表記設定2");
        FukaKonkyo fukakonkyo = new FukaKonkyo();
        SeigyoJoho seigyojoho = new SeigyoJoho();

        fukakonkyo.setSeihoStartYMD(toDate("2014/07/25"));

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

        HokenryoDankaiInput hokenryoDankaiInput = new HokenryoDankaiInput();
        hokenryoDankaiInput.setFukaKonkyo(fukakonkyo);
        hokenryoDankaiInput.setSeigyoJoho(seigyojoho);

        HokenryoDankaiOutput hokenryoDankaiOutput = new HokenryoDankaiOutput("4");
        hokenryoDankaiOutput.get保険料段階01月().setHokenryoDankai("12");
        hokenryoDankaiOutput.get保険料段階02月().setHokenryoDankai("13");
        hokenryoDankaiOutput.get保険料段階03月().setHokenryoDankai("14");
        hokenryoDankaiOutput.get保険料段階04月().setHokenryoDankai("15");
        hokenryoDankaiOutput.get保険料段階05月().setHokenryoDankai("16");
        hokenryoDankaiOutput.get保険料段階06月().setHokenryoDankai("17");
        hokenryoDankaiOutput.get保険料段階07月().setHokenryoDankai("18");
        hokenryoDankaiOutput.get保険料段階08月().setHokenryoDankai("19");
        hokenryoDankaiOutput.get保険料段階09月().setHokenryoDankai("20");

        HokenryoDankaiOutput expResult = new HokenryoDankaiOutput("4");
        hokenryoDankaiOutput.get保険料段階01月().setHokenryoDankai("第10段階");
        hokenryoDankaiOutput.get保険料段階02月().setHokenryoDankai("第11段階");
        hokenryoDankaiOutput.get保険料段階03月().setHokenryoDankai("第12段階");
        hokenryoDankaiOutput.get保険料段階04月().setHokenryoDankai("第13段階");
        hokenryoDankaiOutput.get保険料段階05月().setHokenryoDankai("第14段階");
        hokenryoDankaiOutput.get保険料段階06月().setHokenryoDankai("第15段階");
        hokenryoDankaiOutput.get保険料段階07月().setHokenryoDankai("第16段階");
        hokenryoDankaiOutput.get保険料段階08月().setHokenryoDankai("第17段階");
        hokenryoDankaiOutput.get保険料段階09月().setHokenryoDankai("第18段階");
        hokenryoDankaiOutput.get保険料段階10月().setHokenryoDankai("第3段階②");
        hokenryoDankaiOutput.get保険料段階11月().setHokenryoDankai("第3段階②");
        hokenryoDankaiOutput.get保険料段階12月().setHokenryoDankai("第3段階②");

        保険料段階表記設定.保険料段階表記設定(hokenryoDankaiInput, hokenryoDankaiOutput);
        if (outputEquals(hokenryoDankaiOutput, expResult)) {
            fail("保険料段階表記設定2 failed");
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
