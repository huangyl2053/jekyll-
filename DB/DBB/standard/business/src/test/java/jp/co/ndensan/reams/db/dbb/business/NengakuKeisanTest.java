/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import java.util.HashMap;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 *
 * @author N2810
 */
public class NengakuKeisanTest {
//
//    public NengakuKeisanTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @Before
//    public void setUp() {
//    }
//
//    /**
//     * Test of calc年額保険料 method, of class NengakuKeisan.
//     */
//    @Test
//    public void testCalc年額保険料1() {
//        System.out.println("１年同ランク同段階");
//        保険料段階判定input input = new 保険料段階判定input();
//
//        input.set賦課年度("2014");
//
//        input.set年額賦課根拠(new NengakuFukaKonkyo());
//        input.get年額賦課根拠().set賦課基準日(new RDate("2014/04/01"));
//        input.get年額賦課根拠().set資格取得日(new RDate("2014/01/01"));
//        input.get年額賦課根拠().set保険料段階_1月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_2月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_3月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_4月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_5月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_6月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_7月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_8月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_9月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_10月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_11月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_12月(各保険料段階作成("第４段階", false, "4"));
//
//        input.set年額制御情報(new NengakuSeigyoJoho());
//        input.get年額制御情報().setランク別制御情報(new HashMap<String, Rank別基準金額>());
//        input.get年額制御情報().getランク別制御情報().put("1", new Rank別基準金額());
//        set各ランク別制御情報(input, "1", "1", new Decimal(50001));
//        set各ランク別制御情報(input, "1", "2", new Decimal(100002));
//        set各ランク別制御情報(input, "1", "3", new Decimal(150003));
//        set各ランク別制御情報(input, "1", "4", new Decimal(200004));
//        set各ランク別制御情報(input, "1", "5", new Decimal(250005));
//        set各ランク別制御情報(input, "1", "6", new Decimal(300006));
//        set各ランク別制御情報(input, "1", "7", new Decimal(350007));
//        set各ランク別制御情報(input, "1", "8", new Decimal(400008));
//        set各ランク別制御情報(input, "1", "9", new Decimal(450009));
//        set各ランク別制御情報(input, "1", "10", new Decimal(500010));
//
//        年額計算Output expResult = new 年額計算Output();
//        expResult.setFukaNendo("2014");
//        expResult.setHokenryoNengaku(new Decimal(200004));
//
//        NengakuKeisan instance = new NengakuKeisan();
//        年額計算Output result = instance.calc年額保険料(input);
//        if (!outputEquals(expResult, result)) {
//            fail("１年同ランク同段階 failed" + "expResult = " + expResult.getHokenryoNengaku().toString() + " , Result = " + result.getHokenryoNengaku().toString());
//        }
//
//    }
//
//    @Test
//    public void testCalc年額保険料2() {
//        System.out.println("１年同ランク　年度途中で生保");
//        保険料段階判定input input = new 保険料段階判定input();
//
//        input.set賦課年度("2014");
//
//        input.set年額賦課根拠(new NengakuFukaKonkyo());
//        input.get年額賦課根拠().set賦課基準日(new RDate("2014/04/01"));
//        input.get年額賦課根拠().set資格取得日(new RDate("2014/01/01"));
//        input.get年額賦課根拠().set保険料段階_4月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_5月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_6月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_7月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_8月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_9月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_10月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_11月(各保険料段階作成("第１段階", false, "1"));
//        input.get年額賦課根拠().set保険料段階_12月(各保険料段階作成("第１段階", false, "1"));
//        input.get年額賦課根拠().set保険料段階_1月(各保険料段階作成("第１段階", false, "1"));
//        input.get年額賦課根拠().set保険料段階_2月(各保険料段階作成("第１段階", false, "1"));
//        input.get年額賦課根拠().set保険料段階_3月(各保険料段階作成("第１段階", false, "1"));
//
//        input.set年額制御情報(new NengakuSeigyoJoho());
//        input.get年額制御情報().setランク別制御情報(new HashMap<String, Rank別基準金額>());
//        input.get年額制御情報().getランク別制御情報().put("1", new Rank別基準金額());
//        set各ランク別制御情報(input, "1", "1", new Decimal(50001));
//        set各ランク別制御情報(input, "1", "2", new Decimal(100002));
//        set各ランク別制御情報(input, "1", "3", new Decimal(150003));
//        set各ランク別制御情報(input, "1", "4", new Decimal(200004));
//        set各ランク別制御情報(input, "1", "5", new Decimal(250005));
//        set各ランク別制御情報(input, "1", "6", new Decimal(300006));
//        set各ランク別制御情報(input, "1", "7", new Decimal(350007));
//        set各ランク別制御情報(input, "1", "8", new Decimal(400008));
//        set各ランク別制御情報(input, "1", "9", new Decimal(450009));
//        set各ランク別制御情報(input, "1", "10", new Decimal(500010));
//
//        年額計算Output expResult = new 年額計算Output();
//        expResult.setFukaNendo("2014");
//        expResult.setHokenryoNengaku(new Decimal(137502.75));
//
//        NengakuKeisan instance = new NengakuKeisan();
//        年額計算Output result = instance.calc年額保険料(input);
//        if (!outputEquals(expResult, result)) {
//            fail("１年同ランク　年度途中で生保 failed" + "expResult = " + expResult.getHokenryoNengaku().toString() + " , Result = " + result.getHokenryoNengaku().toString());
//        }
//
//    }
//
//    @Test
//    public void testCalc年額保険料3() {
//        System.out.println("１年同段階");
//        保険料段階判定input input = new 保険料段階判定input();
//
//        input.set賦課年度("2014");
//
//        input.set年額賦課根拠(new NengakuFukaKonkyo());
//        input.get年額賦課根拠().set賦課基準日(new RDate("2014/04/01"));
//        input.get年額賦課根拠().set資格取得日(new RDate("2014/01/01"));
//        input.get年額賦課根拠().set保険料段階_4月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_5月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_6月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_7月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_8月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_9月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_10月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_11月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_12月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_1月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_2月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_3月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().setランク_4月("1");
//        input.get年額賦課根拠().setランク_5月("1");
//        input.get年額賦課根拠().setランク_6月("1");
//        input.get年額賦課根拠().setランク_7月("1");
//        input.get年額賦課根拠().setランク_8月("2");
//        input.get年額賦課根拠().setランク_9月("2");
//        input.get年額賦課根拠().setランク_10月("2");
//        input.get年額賦課根拠().setランク_11月("2");
//        input.get年額賦課根拠().setランク_12月("2");
//        input.get年額賦課根拠().setランク_1月("2");
//        input.get年額賦課根拠().setランク_2月("2");
//        input.get年額賦課根拠().setランク_3月("3");
//
//        input.set年額制御情報(new NengakuSeigyoJoho());
//        input.get年額制御情報().setランク別制御情報(new HashMap<String, Rank別基準金額>());
//        input.get年額制御情報().getランク別制御情報().put("1", new Rank別基準金額());
//        set各ランク別制御情報(input, "1", "1", new Decimal(50001));
//        set各ランク別制御情報(input, "1", "2", new Decimal(100002));
//        set各ランク別制御情報(input, "1", "3", new Decimal(150003));
//        set各ランク別制御情報(input, "1", "4", new Decimal(200004));
//        set各ランク別制御情報(input, "1", "5", new Decimal(250005));
//        set各ランク別制御情報(input, "1", "6", new Decimal(300006));
//        set各ランク別制御情報(input, "1", "7", new Decimal(350007));
//        set各ランク別制御情報(input, "1", "8", new Decimal(400008));
//        set各ランク別制御情報(input, "1", "9", new Decimal(450009));
//        set各ランク別制御情報(input, "1", "10", new Decimal(500010));
//        input.get年額制御情報().getランク別制御情報().put("2", new Rank別基準金額());
//        set各ランク別制御情報(input, "2", "4", new Decimal(20001));
//        input.get年額制御情報().getランク別制御情報().put("3", new Rank別基準金額());
//        set各ランク別制御情報(input, "3", "4", new Decimal(2002));
//
//        年額計算Output expResult = new 年額計算Output();
//        expResult.setFukaNendo("2014");
//        expResult.setHokenryoNengaku(new Decimal(78502.08));
//
//        NengakuKeisan instance = new NengakuKeisan();
//        年額計算Output result = instance.calc年額保険料(input);
//        if (!outputEquals(expResult, result)) {
//            fail("１年同段階 failed" + "expResult = " + expResult.getHokenryoNengaku().toString() + " , Result = " + result.getHokenryoNengaku().toString());
//        }
//
//    }
//
//    @Test
//    public void testCalc年額保険料4() {
//        System.out.println("年度内取得");
//        保険料段階判定input input = new 保険料段階判定input();
//
//        input.set賦課年度("2014");
//
//        input.set年額賦課根拠(new NengakuFukaKonkyo());
//        input.get年額賦課根拠().set賦課基準日(new RDate("2014/09/01"));
//        input.get年額賦課根拠().set資格取得日(new RDate("2014/09/01"));
//        //input.getFukaKonkyo().set保険料段階_4月(各保険料段階作成("第４段階", false, "4"));
//        //input.getFukaKonkyo().set保険料段階_5月(各保険料段階作成("第４段階", false, "4"));
//        //input.getFukaKonkyo().set保険料段階_6月(各保険料段階作成("第４段階", false, "4"));
//        //input.getFukaKonkyo().set保険料段階_7月(各保険料段階作成("第４段階", false, "4"));
//        //input.getFukaKonkyo().set保険料段階_8月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_9月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_10月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_11月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_12月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_1月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_2月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_3月(各保険料段階作成("第４段階", false, "4"));
//        //input.getFukaKonkyo().setランク_4月("1");
//        //input.getFukaKonkyo().setランク_5月("1");
//        //input.getFukaKonkyo().setランク_6月("1");
//        //input.getFukaKonkyo().setランク_7月("1");
//        //input.getFukaKonkyo().setランク_8月("1");
//        input.get年額賦課根拠().setランク_9月("1");
//        input.get年額賦課根拠().setランク_10月("1");
//        input.get年額賦課根拠().setランク_11月("1");
//        input.get年額賦課根拠().setランク_12月("1");
//        input.get年額賦課根拠().setランク_1月("1");
//        input.get年額賦課根拠().setランク_2月("1");
//        input.get年額賦課根拠().setランク_3月("1");
//
//        input.set年額制御情報(new NengakuSeigyoJoho());
//        input.get年額制御情報().setランク別制御情報(new HashMap<String, Rank別基準金額>());
//        input.get年額制御情報().getランク別制御情報().put("1", new Rank別基準金額());
//        set各ランク別制御情報(input, "1", "1", new Decimal(50001));
//        set各ランク別制御情報(input, "1", "2", new Decimal(100002));
//        set各ランク別制御情報(input, "1", "3", new Decimal(150003));
//        set各ランク別制御情報(input, "1", "4", new Decimal(200004));
//        set各ランク別制御情報(input, "1", "5", new Decimal(250005));
//        set各ランク別制御情報(input, "1", "6", new Decimal(300006));
//        set各ランク別制御情報(input, "1", "7", new Decimal(350007));
//        set各ランク別制御情報(input, "1", "8", new Decimal(400008));
//        set各ランク別制御情報(input, "1", "9", new Decimal(450009));
//        set各ランク別制御情報(input, "1", "10", new Decimal(500010));
//        input.get年額制御情報().getランク別制御情報().put("2", new Rank別基準金額());
//        set各ランク別制御情報(input, "2", "4", new Decimal(20001));
//        input.get年額制御情報().getランク別制御情報().put("3", new Rank別基準金額());
//        set各ランク別制御情報(input, "3", "4", new Decimal(2002));
//
//        年額計算Output expResult = new 年額計算Output();
//        expResult.setFukaNendo("2014");
//        expResult.setHokenryoNengaku(new Decimal(116669));
//
//        NengakuKeisan instance = new NengakuKeisan();
//        年額計算Output result = instance.calc年額保険料(input);
//        if (!outputEquals(expResult, result)) {
//            fail("年度内取得 failed" + "expResult = " + expResult.getHokenryoNengaku().toString() + " , Result = " + result.getHokenryoNengaku().toString());
//        }
//
//    }
//
//    @Test
//    public void testCalc年額保険料5() {
//        System.out.println("年度内喪失");
//        保険料段階判定input input = new 保険料段階判定input();
//
//        input.set賦課年度("2014");
//
//        input.set年額賦課根拠(new NengakuFukaKonkyo());
//        input.get年額賦課根拠().set賦課基準日(new RDate("2014/04/01"));
//        input.get年額賦課根拠().set資格取得日(new RDate("2014/01/01"));
//        input.get年額賦課根拠().set資格喪失日(new RDate("2014/11/10"));
//        input.get年額賦課根拠().set保険料段階_4月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_5月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_6月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_7月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_8月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_9月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_10月(各保険料段階作成("第４段階", false, "4"));
////        input.getFukaKonkyo().set保険料段階_11月(各保険料段階作成("第４段階", false, "4"));
////        input.getFukaKonkyo().set保険料段階_12月(各保険料段階作成("第４段階", false, "4"));
////        input.getFukaKonkyo().set保険料段階_1月(各保険料段階作成("第４段階", false, "4"));
////        input.getFukaKonkyo().set保険料段階_2月(各保険料段階作成("第４段階", false, "4"));
////        input.getFukaKonkyo().set保険料段階_3月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().setランク_4月("1");
//        input.get年額賦課根拠().setランク_5月("1");
//        input.get年額賦課根拠().setランク_6月("1");
//        input.get年額賦課根拠().setランク_7月("1");
//        input.get年額賦課根拠().setランク_8月("1");
//        input.get年額賦課根拠().setランク_9月("1");
//        input.get年額賦課根拠().setランク_10月("1");
////        input.getFukaKonkyo().setランク_11月("1");
////        input.getFukaKonkyo().setランク_12月("1");
////        input.getFukaKonkyo().setランク_1月("1");
////        input.getFukaKonkyo().setランク_2月("1");
////        input.getFukaKonkyo().setランク_3月("1");
//
//        input.set年額制御情報(new NengakuSeigyoJoho());
//        input.get年額制御情報().setランク別制御情報(new HashMap<String, Rank別基準金額>());
//        input.get年額制御情報().getランク別制御情報().put("1", new Rank別基準金額());
//        set各ランク別制御情報(input, "1", "1", new Decimal(50001));
//        set各ランク別制御情報(input, "1", "2", new Decimal(100002));
//        set各ランク別制御情報(input, "1", "3", new Decimal(150003));
//        set各ランク別制御情報(input, "1", "4", new Decimal(200004));
//        set各ランク別制御情報(input, "1", "5", new Decimal(250005));
//        set各ランク別制御情報(input, "1", "6", new Decimal(300006));
//        set各ランク別制御情報(input, "1", "7", new Decimal(350007));
//        set各ランク別制御情報(input, "1", "8", new Decimal(400008));
//        set各ランク別制御情報(input, "1", "9", new Decimal(450009));
//        set各ランク別制御情報(input, "1", "10", new Decimal(500010));
//        input.get年額制御情報().getランク別制御情報().put("2", new Rank別基準金額());
//        set各ランク別制御情報(input, "2", "4", new Decimal(20001));
//        input.get年額制御情報().getランク別制御情報().put("3", new Rank別基準金額());
//        set各ランク別制御情報(input, "3", "4", new Decimal(2002));
//
//        年額計算Output expResult = new 年額計算Output();
//        expResult.setFukaNendo("2014");
//        expResult.setHokenryoNengaku(new Decimal(116669));
//
//        NengakuKeisan instance = new NengakuKeisan();
//        年額計算Output result = instance.calc年額保険料(input);
//        if (!outputEquals(expResult, result)) {
//            fail("年度内喪失 failed" + "expResult = " + expResult.getHokenryoNengaku().toString() + " , Result = " + result.getHokenryoNengaku().toString());
//        }
//
//    }
//
//    @Test
//    public void testCalc年額保険料6() {
//        System.out.println("年度内取得喪失");
//        保険料段階判定input input = new 保険料段階判定input();
//
//        input.set賦課年度("2014");
//
//        input.set年額賦課根拠(new NengakuFukaKonkyo());
//        input.get年額賦課根拠().set賦課基準日(new RDate("2014/06/01"));
//        input.get年額賦課根拠().set資格取得日(new RDate("2014/06/01"));
//        input.get年額賦課根拠().set資格喪失日(new RDate("2014/12/10"));
////        input.getFukaKonkyo().set保険料段階_4月(各保険料段階作成("第４段階", false, "4"));
////        input.getFukaKonkyo().set保険料段階_5月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_6月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_7月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_8月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_9月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_10月(各保険料段階作成("第４段階", false, "4"));
//        input.get年額賦課根拠().set保険料段階_11月(各保険料段階作成("第４段階", false, "4"));
////        input.getFukaKonkyo().set保険料段階_12月(各保険料段階作成("第４段階", false, "4"));
////        input.getFukaKonkyo().set保険料段階_1月(各保険料段階作成("第４段階", false, "4"));
////        input.getFukaKonkyo().set保険料段階_2月(各保険料段階作成("第４段階", false, "4"));
////        input.getFukaKonkyo().set保険料段階_3月(各保険料段階作成("第４段階", false, "4"));
////        input.getFukaKonkyo().setランク_4月("1");
////        input.getFukaKonkyo().setランク_5月("1");
//        input.get年額賦課根拠().setランク_6月("1");
//        input.get年額賦課根拠().setランク_7月("1");
//        input.get年額賦課根拠().setランク_8月("1");
//        input.get年額賦課根拠().setランク_9月("1");
//        input.get年額賦課根拠().setランク_10月("1");
//        input.get年額賦課根拠().setランク_11月("1");
////        input.getFukaKonkyo().setランク_12月("1");
////        input.getFukaKonkyo().setランク_1月("1");
////        input.getFukaKonkyo().setランク_2月("1");
////        input.getFukaKonkyo().setランク_3月("1");
//
//        input.set年額制御情報(new NengakuSeigyoJoho());
//        input.get年額制御情報().setランク別制御情報(new HashMap<String, Rank別基準金額>());
//        input.get年額制御情報().getランク別制御情報().put("1", new Rank別基準金額());
//        set各ランク別制御情報(input, "1", "1", new Decimal(50001));
//        set各ランク別制御情報(input, "1", "2", new Decimal(100002));
//        set各ランク別制御情報(input, "1", "3", new Decimal(150003));
//        set各ランク別制御情報(input, "1", "4", new Decimal(200004));
//        set各ランク別制御情報(input, "1", "5", new Decimal(250005));
//        set各ランク別制御情報(input, "1", "6", new Decimal(300006));
//        set各ランク別制御情報(input, "1", "7", new Decimal(350007));
//        set各ランク別制御情報(input, "1", "8", new Decimal(400008));
//        set各ランク別制御情報(input, "1", "9", new Decimal(450009));
//        set各ランク別制御情報(input, "1", "10", new Decimal(500010));
//        input.get年額制御情報().getランク別制御情報().put("2", new Rank別基準金額());
//        set各ランク別制御情報(input, "2", "4", new Decimal(20001));
//        input.get年額制御情報().getランク別制御情報().put("3", new Rank別基準金額());
//        set各ランク別制御情報(input, "3", "4", new Decimal(2002));
//
//        年額計算Output expResult = new 年額計算Output();
//        expResult.setFukaNendo("2014");
//        expResult.setHokenryoNengaku(new Decimal(100002));
//
//        NengakuKeisan instance = new NengakuKeisan();
//        年額計算Output result = instance.calc年額保険料(input);
//        if (!outputEquals(expResult, result)) {
//            fail("年度内取得喪失 failed" + "expResult = " + expResult.getHokenryoNengaku().toString() + " , Result = " + result.getHokenryoNengaku().toString());
//        }
//
//    }
//
//    @Test
//    public void testCalc年額保険料7() {
//        System.out.println("ランク変動 途中で生保");
//        保険料段階判定input input = new 保険料段階判定input();
//
//        input.set賦課年度("2014");
//
//        input.set年額賦課根拠(new NengakuFukaKonkyo());
//        input.get年額賦課根拠().set賦課基準日(new RDate("2014/04/01"));
//        input.get年額賦課根拠().set資格取得日(new RDate("2014/01/01"));
////        input.getFukaKonkyo().set資格喪失日(new RDate("2014/12/10"));
//        input.get年額賦課根拠().set保険料段階_4月(各保険料段階作成("第３段階", false, "3"));
//        input.get年額賦課根拠().set保険料段階_5月(各保険料段階作成("第３段階", false, "3"));
//        input.get年額賦課根拠().set保険料段階_6月(各保険料段階作成("第３段階", false, "3"));
//        input.get年額賦課根拠().set保険料段階_7月(各保険料段階作成("第３段階", false, "3"));
//        input.get年額賦課根拠().set保険料段階_8月(各保険料段階作成("第３段階", false, "3"));
//        input.get年額賦課根拠().set保険料段階_9月(各保険料段階作成("第３段階", false, "3"));
//        input.get年額賦課根拠().set保険料段階_10月(各保険料段階作成("第３段階", false, "3"));
//        input.get年額賦課根拠().set保険料段階_11月(各保険料段階作成("第３段階", false, "3"));
//        input.get年額賦課根拠().set保険料段階_12月(各保険料段階作成("第１段階", false, "1"));
//        input.get年額賦課根拠().set保険料段階_1月(各保険料段階作成("第１段階", false, "1"));
//        input.get年額賦課根拠().set保険料段階_2月(各保険料段階作成("第１段階", false, "1"));
//        input.get年額賦課根拠().set保険料段階_3月(各保険料段階作成("第１段階", false, "1"));
//        input.get年額賦課根拠().setランク_4月("1");
//        input.get年額賦課根拠().setランク_5月("1");
//        input.get年額賦課根拠().setランク_6月("1");
//        input.get年額賦課根拠().setランク_7月("2");
//        input.get年額賦課根拠().setランク_8月("2");
//        input.get年額賦課根拠().setランク_9月("2");
//        input.get年額賦課根拠().setランク_10月("2");
//        input.get年額賦課根拠().setランク_11月("2");
//        input.get年額賦課根拠().setランク_12月("2");
//        input.get年額賦課根拠().setランク_1月("2");
//        input.get年額賦課根拠().setランク_2月("3");
//        input.get年額賦課根拠().setランク_3月("3");
//
//        input.set年額制御情報(new NengakuSeigyoJoho());
//        input.get年額制御情報().setランク別制御情報(new HashMap<String, Rank別基準金額>());
//        input.get年額制御情報().getランク別制御情報().put("1", new Rank別基準金額());
//        set各ランク別制御情報(input, "1", "1", new Decimal(50001));
//        set各ランク別制御情報(input, "1", "2", new Decimal(100002));
//        set各ランク別制御情報(input, "1", "3", new Decimal(150003));
//        set各ランク別制御情報(input, "1", "4", new Decimal(200004));
//        set各ランク別制御情報(input, "1", "5", new Decimal(250005));
//        set各ランク別制御情報(input, "1", "6", new Decimal(300006));
//        set各ランク別制御情報(input, "1", "7", new Decimal(350007));
//        set各ランク別制御情報(input, "1", "8", new Decimal(400008));
//        set各ランク別制御情報(input, "1", "9", new Decimal(450009));
//        set各ランク別制御情報(input, "1", "10", new Decimal(500010));
//        input.get年額制御情報().getランク別制御情報().put("2", new Rank別基準金額());
//        set各ランク別制御情報(input, "2", "1", new Decimal(10002));
//        set各ランク別制御情報(input, "2", "3", new Decimal(20001));
//        input.get年額制御情報().getランク別制御情報().put("3", new Rank別基準金額());
//        set各ランク別制御情報(input, "3", "1", new Decimal(2002));
//
//        年額計算Output expResult = new 年額計算Output();
//        expResult.setFukaNendo("2014");
//        expResult.setHokenryoNengaku(new Decimal(47835.17));
//
//        NengakuKeisan instance = new NengakuKeisan();
//        年額計算Output result = instance.calc年額保険料(input);
//        if (!outputEquals(expResult, result)) {
//            fail("ランク変動 途中で生保 failed" + "expResult = " + expResult.getHokenryoNengaku().toString() + " , Result = " + result.getHokenryoNengaku().toString());
//        }
//
//    }
//
//    @Test
//    public void testCalc年額保険料8() {
//        System.out.println("ランク変動 途中で生保 取得喪失");
//        保険料段階判定input input = new 保険料段階判定input();
//
//        input.set賦課年度("2014");
//
//        input.set年額賦課根拠(new NengakuFukaKonkyo());
//        input.get年額賦課根拠().set賦課基準日(new RDate("2014/06/01"));
//        input.get年額賦課根拠().set資格取得日(new RDate("2014/06/01"));
//        input.get年額賦課根拠().set資格喪失日(new RDate("2015/03/10"));
//        input.get年額賦課根拠().set保険料段階_4月(各保険料段階作成("第３段階", false, "3"));
//        input.get年額賦課根拠().set保険料段階_5月(各保険料段階作成("第３段階", false, "3"));
//        input.get年額賦課根拠().set保険料段階_6月(各保険料段階作成("第３段階", false, "3"));
//        input.get年額賦課根拠().set保険料段階_7月(各保険料段階作成("第３段階", false, "3"));
//        input.get年額賦課根拠().set保険料段階_8月(各保険料段階作成("第３段階", false, "3"));
//        input.get年額賦課根拠().set保険料段階_9月(各保険料段階作成("第３段階", false, "3"));
//        input.get年額賦課根拠().set保険料段階_10月(各保険料段階作成("第３段階", false, "3"));
//        input.get年額賦課根拠().set保険料段階_11月(各保険料段階作成("第３段階", false, "3"));
//        input.get年額賦課根拠().set保険料段階_12月(各保険料段階作成("第１段階", false, "1"));
//        input.get年額賦課根拠().set保険料段階_1月(各保険料段階作成("第１段階", false, "1"));
//        input.get年額賦課根拠().set保険料段階_2月(各保険料段階作成("第１段階", false, "1"));
//        input.get年額賦課根拠().set保険料段階_3月(各保険料段階作成("第１段階", false, "1"));
//        input.get年額賦課根拠().setランク_4月("1");
//        input.get年額賦課根拠().setランク_5月("1");
//        input.get年額賦課根拠().setランク_6月("1");
//        input.get年額賦課根拠().setランク_7月("2");
//        input.get年額賦課根拠().setランク_8月("2");
//        input.get年額賦課根拠().setランク_9月("2");
//        input.get年額賦課根拠().setランク_10月("2");
//        input.get年額賦課根拠().setランク_11月("2");
//        input.get年額賦課根拠().setランク_12月("2");
//        input.get年額賦課根拠().setランク_1月("2");
//        input.get年額賦課根拠().setランク_2月("3");
//        input.get年額賦課根拠().setランク_3月("3");
//
//        input.set年額制御情報(new NengakuSeigyoJoho());
//        input.get年額制御情報().setランク別制御情報(new HashMap<String, Rank別基準金額>());
//        input.get年額制御情報().getランク別制御情報().put("1", new Rank別基準金額());
//        set各ランク別制御情報(input, "1", "1", new Decimal(50001));
//        set各ランク別制御情報(input, "1", "2", new Decimal(100002));
//        set各ランク別制御情報(input, "1", "3", new Decimal(150003));
//        set各ランク別制御情報(input, "1", "4", new Decimal(200004));
//        set各ランク別制御情報(input, "1", "5", new Decimal(250005));
//        set各ランク別制御情報(input, "1", "6", new Decimal(300006));
//        set各ランク別制御情報(input, "1", "7", new Decimal(350007));
//        set各ランク別制御情報(input, "1", "8", new Decimal(400008));
//        set各ランク別制御情報(input, "1", "9", new Decimal(450009));
//        set各ランク別制御情報(input, "1", "10", new Decimal(500010));
//        input.get年額制御情報().getランク別制御情報().put("2", new Rank別基準金額());
//        set各ランク別制御情報(input, "2", "1", new Decimal(10002));
//        set各ランク別制御情報(input, "2", "3", new Decimal(20001));
//        input.get年額制御情報().getランク別制御情報().put("3", new Rank別基準金額());
//        set各ランク別制御情報(input, "3", "1", new Decimal(2002));
//
//        年額計算Output expResult = new 年額計算Output();
//        expResult.setFukaNendo("2014");
//        expResult.setHokenryoNengaku(new Decimal(22667.83));
//
//        NengakuKeisan instance = new NengakuKeisan();
//        年額計算Output result = instance.calc年額保険料(input);
//        if (!outputEquals(expResult, result)) {
//            fail("ランク変動 途中で生保 failed" + "expResult = " + expResult.getHokenryoNengaku().toString() + " , Result = " + result.getHokenryoNengaku().toString());
//        }
//
//    }
//
//    private HokenryoDankai 各保険料段階作成(String 保険料段階, boolean 特例対象, String システム段階) {
//
//        HokenryoDankai hokenryoDankai = new HokenryoDankai();
//        hokenryoDankai.setHokenryoDankai(保険料段階);
//        hokenryoDankai.setTokureiTaisho(特例対象);
//        hokenryoDankai.setSystemDankai(システム段階);
//
//        return hokenryoDankai;
//    }
//
//    private void set各ランク別制御情報(保険料段階判定input input, String rank, String dankai, Decimal nengaku) {
//
//        switch (dankai) {
//            case "1":
//                input.get年額制御情報().getランク別制御情報().get(rank).setランク基準金額1(nengaku);
//                break;
//            case "2":
//                input.get年額制御情報().getランク別制御情報().get(rank).setランク基準金額2(nengaku);
//                break;
//            case "3":
//                input.get年額制御情報().getランク別制御情報().get(rank).setランク基準金額3(nengaku);
//                break;
//            case "4":
//                input.get年額制御情報().getランク別制御情報().get(rank).setランク基準金額4(nengaku);
//                break;
//            case "5":
//                input.get年額制御情報().getランク別制御情報().get(rank).setランク基準金額5(nengaku);
//                break;
//            case "6":
//                input.get年額制御情報().getランク別制御情報().get(rank).setランク基準金額6(nengaku);
//                break;
//            case "7":
//                input.get年額制御情報().getランク別制御情報().get(rank).setランク基準金額7(nengaku);
//                break;
//            case "8":
//                input.get年額制御情報().getランク別制御情報().get(rank).setランク基準金額8(nengaku);
//                break;
//            case "9":
//                input.get年額制御情報().getランク別制御情報().get(rank).setランク基準金額9(nengaku);
//                break;
//            case "10":
//                input.get年額制御情報().getランク別制御情報().get(rank).setランク基準金額10(nengaku);
//                break;
//            case "11":
//                input.get年額制御情報().getランク別制御情報().get(rank).setランク基準金額11(nengaku);
//                break;
//            case "12":
//                input.get年額制御情報().getランク別制御情報().get(rank).setランク基準金額12(nengaku);
//                break;
//            case "13":
//                input.get年額制御情報().getランク別制御情報().get(rank).setランク基準金額13(nengaku);
//                break;
//            case "14":
//                input.get年額制御情報().getランク別制御情報().get(rank).setランク基準金額14(nengaku);
//                break;
//            case "15":
//                input.get年額制御情報().getランク別制御情報().get(rank).setランク基準金額15(nengaku);
//                break;
//            case "16":
//                input.get年額制御情報().getランク別制御情報().get(rank).setランク基準金額16(nengaku);
//                break;
//            case "17":
//                input.get年額制御情報().getランク別制御情報().get(rank).setランク基準金額17(nengaku);
//                break;
//            case "18":
//                input.get年額制御情報().getランク別制御情報().get(rank).setランク基準金額18(nengaku);
//                break;
//            case "19":
//                input.get年額制御情報().getランク別制御情報().get(rank).setランク基準金額19(nengaku);
//                break;
//            case "20":
//                input.get年額制御情報().getランク別制御情報().get(rank).setランク基準金額20(nengaku);
//                break;
//            default:
//        }
//    }
//
//    private boolean outputEquals(年額計算Output expResult, 年額計算Output outputResult) {
//
//        boolean result = true;
//
//        if (!expResult.getFukaNendo().equals(outputResult.getFukaNendo())) {
//            result = false;
//        }
//
//        if (!expResult.getHokenryoNengaku().equals(outputResult.getHokenryoNengaku())) {
//            result = false;
//        }
//
//        return result;
//    }

}
