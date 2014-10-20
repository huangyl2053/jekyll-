/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        HokenryoDankaiInput hokenryodankaiinput = new HokenryoDankaiInput();

        SeigyoJoho seigyojoho = new SeigyoJoho();

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        HokenryoDankaiHanteiHohoHozon instance = new 第4期(hokenryodankaiinput);
        String expResult = "4";
        String result = instance.世帯非課税最大段階数取得();
        assertEquals(expResult, result);
    }

    /**
     * Test of 本人非課税最大段階数取得 method, of class HokenryoDankaiHanteiHohoHozon.
     */
    @Test
    public void test本人非課税最大段階数取得() {
        System.out.println("test本人非課税最大段階数取得");
        HokenryoDankaiInput hokenryodankaiinput = new HokenryoDankaiInput();

        SeigyoJoho seigyojoho = new SeigyoJoho();

        seigyojoho.setKijunNenkinShunyu01(new Decimal(800000));
        seigyojoho.setKijunNenkinShunyu02(new Decimal(1200000));
        seigyojoho.setKijunNenkinShunyu03(new Decimal(800000));

        seigyojoho.setKijunShotokuKingaku01(new Decimal(1200000));
        seigyojoho.setKijunShotokuKingaku02(new Decimal(1900000));
        hokenryodankaiinput.setSeigyoJoho(seigyojoho);

        HokenryoDankaiHanteiHohoHozon instance = new 第4期(hokenryodankaiinput);
        String expResult = "6";
        String result = instance.本人非課税最大段階数取得();
        assertEquals(expResult, result);
    }

    public class HokenryoDankaiHanteiHohoHozonImpl extends HokenryoDankaiHanteiHohoHozon {
    }

}
