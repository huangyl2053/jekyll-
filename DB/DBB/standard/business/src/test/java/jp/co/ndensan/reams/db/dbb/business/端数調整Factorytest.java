/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.business;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author n3336
 */
public class 端数調整Factorytest {
    
            HokenryoDankai dankai4 = new HokenryoDankai();
        HokenryoDankai dankai5 = new HokenryoDankai();
        HokenryoDankai dankai6 = new HokenryoDankai();
        HokenryoDankai dankai7 = new HokenryoDankai();
        HokenryoDankai dankai8 = new HokenryoDankai();
        HokenryoDankai dankai9 = new HokenryoDankai();
        HokenryoDankai dankai10 = new HokenryoDankai();
        HokenryoDankai dankai11 = new HokenryoDankai();
        HokenryoDankai dankai12 = new HokenryoDankai();
        HokenryoDankai dankai1 = new HokenryoDankai();
        HokenryoDankai dankai2 = new HokenryoDankai();
        HokenryoDankai dankai3 = new HokenryoDankai();    
    
    public 端数調整Factorytest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void 端数調整不要の場合は金額に変更なし(){
        
        端数調整Factory factory = new 端数調整Factory();
        
        保険料段階判定input input = new 保険料段階判定input();
        
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格取得日(new RDate("20140401"));
        fukakonkyo.set資格喪失日(new RDate("20150401"));
        fukakonkyo.setランク_4月("4");
        fukakonkyo.setランク_5月("4");
        fukakonkyo.setランク_6月("4");
        fukakonkyo.setランク_7月("4");
        fukakonkyo.setランク_8月("4");
        fukakonkyo.setランク_9月("4");
        fukakonkyo.setランク_10月("4");
        fukakonkyo.setランク_11月("4");
        fukakonkyo.setランク_12月("4");
        fukakonkyo.setランク_1月("4");
        fukakonkyo.setランク_2月("4");
        fukakonkyo.setランク_3月("4");
        
       dankai4.setSystemDankai("4");
        dankai5.setSystemDankai("4");
        dankai6.setSystemDankai("4");
        dankai7.setSystemDankai("4");
        dankai8.setSystemDankai("4");
        dankai9.setSystemDankai("4");
        dankai10.setSystemDankai("4");
        dankai11.setSystemDankai("4");
        dankai12.setSystemDankai("4");
        dankai1.setSystemDankai("4");
        dankai2.setSystemDankai("4");
        dankai3.setSystemDankai("4");
        
        fukakonkyo.set保険料段階_4月(dankai4);
        fukakonkyo.set保険料段階_5月(dankai5);
        fukakonkyo.set保険料段階_6月(dankai6);
        fukakonkyo.set保険料段階_7月(dankai7);
        fukakonkyo.set保険料段階_8月(dankai8);
        fukakonkyo.set保険料段階_9月(dankai9);
        fukakonkyo.set保険料段階_10月(dankai10);
        fukakonkyo.set保険料段階_11月(dankai11);
        fukakonkyo.set保険料段階_12月(dankai12);
        fukakonkyo.set保険料段階_1月(dankai1);
        fukakonkyo.set保険料段階_2月(dankai2);
        fukakonkyo.set保険料段階_3月(dankai3);        
        
        NengakuSeigyoJoho seigyo = new NengakuSeigyoJoho();
        seigyo.set端数単位(new Decimal("10"));
        seigyo.set端数調整方法("切り上げ");
        seigyo.set端数単位_ランク用(new Decimal("100"));
        seigyo.set端数調整方法_ランク用("切捨て");
        
        input.set年額賦課根拠(fukakonkyo);
        input.set年額制御情報(seigyo);
        input.set賦課年度("2014");       
        
        assertThat(factory.getIncetance(input).Calc端数(new Decimal("9999")) , is(new Decimal("9999")));
        
    }
    
    @Test
    public void 段階に変更あった場合は端数調整必要(){
        
        端数調整Factory factory = new 端数調整Factory();
        
        保険料段階判定input input = new 保険料段階判定input();
        
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格取得日(new RDate("20140401"));
        fukakonkyo.set資格喪失日(new RDate("20150401"));
        fukakonkyo.setランク_4月("4");
        fukakonkyo.setランク_5月("4");
        fukakonkyo.setランク_6月("4");
        fukakonkyo.setランク_7月("4");
        fukakonkyo.setランク_8月("4");
        fukakonkyo.setランク_9月("4");
        fukakonkyo.setランク_10月("4");
        fukakonkyo.setランク_11月("4");
        fukakonkyo.setランク_12月("4");
        fukakonkyo.setランク_1月("4");
        fukakonkyo.setランク_2月("4");
        fukakonkyo.setランク_3月("4");
        
       dankai4.setSystemDankai("5");
        dankai5.setSystemDankai("4");
        dankai6.setSystemDankai("4");
        dankai7.setSystemDankai("4");
        dankai8.setSystemDankai("4");
        dankai9.setSystemDankai("4");
        dankai10.setSystemDankai("4");
        dankai11.setSystemDankai("4");
        dankai12.setSystemDankai("4");
        dankai1.setSystemDankai("4");
        dankai2.setSystemDankai("4");
        dankai3.setSystemDankai("4");
        
        fukakonkyo.set保険料段階_4月(dankai4);
        fukakonkyo.set保険料段階_5月(dankai5);
        fukakonkyo.set保険料段階_6月(dankai6);
        fukakonkyo.set保険料段階_7月(dankai7);
        fukakonkyo.set保険料段階_8月(dankai8);
        fukakonkyo.set保険料段階_9月(dankai9);
        fukakonkyo.set保険料段階_10月(dankai10);
        fukakonkyo.set保険料段階_11月(dankai11);
        fukakonkyo.set保険料段階_12月(dankai12);
        fukakonkyo.set保険料段階_1月(dankai1);
        fukakonkyo.set保険料段階_2月(dankai2);
        fukakonkyo.set保険料段階_3月(dankai3);        
        
        NengakuSeigyoJoho seigyo = new NengakuSeigyoJoho();
        seigyo.set端数単位(new Decimal("10"));
        seigyo.set端数調整方法("切り上げ");
        seigyo.set端数単位_ランク用(new Decimal("100"));
        seigyo.set端数調整方法_ランク用("切捨て");
        
        input.set年額賦課根拠(fukakonkyo);
        input.set年額制御情報(seigyo);
        input.set賦課年度("2014");       
        
        assertThat(factory.getIncetance(input).Calc端数(new Decimal("9999")) , is(new Decimal("10000")));
        
    }    
   
    @Test
    public void ランクに変更あった場合は端数調整必要(){
        
        端数調整Factory factory = new 端数調整Factory();
        
        保険料段階判定input input = new 保険料段階判定input();
        
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格取得日(new RDate("20140401"));
        fukakonkyo.set資格喪失日(new RDate("20150401"));
        fukakonkyo.setランク_4月("5");
        fukakonkyo.setランク_5月("4");
        fukakonkyo.setランク_6月("4");
        fukakonkyo.setランク_7月("4");
        fukakonkyo.setランク_8月("4");
        fukakonkyo.setランク_9月("4");
        fukakonkyo.setランク_10月("4");
        fukakonkyo.setランク_11月("4");
        fukakonkyo.setランク_12月("4");
        fukakonkyo.setランク_1月("4");
        fukakonkyo.setランク_2月("4");
        fukakonkyo.setランク_3月("4");
        
       dankai4.setSystemDankai("4");
        dankai5.setSystemDankai("4");
        dankai6.setSystemDankai("4");
        dankai7.setSystemDankai("4");
        dankai8.setSystemDankai("4");
        dankai9.setSystemDankai("4");
        dankai10.setSystemDankai("4");
        dankai11.setSystemDankai("4");
        dankai12.setSystemDankai("4");
        dankai1.setSystemDankai("4");
        dankai2.setSystemDankai("4");
        dankai3.setSystemDankai("4");
        
        fukakonkyo.set保険料段階_4月(dankai4);
        fukakonkyo.set保険料段階_5月(dankai5);
        fukakonkyo.set保険料段階_6月(dankai6);
        fukakonkyo.set保険料段階_7月(dankai7);
        fukakonkyo.set保険料段階_8月(dankai8);
        fukakonkyo.set保険料段階_9月(dankai9);
        fukakonkyo.set保険料段階_10月(dankai10);
        fukakonkyo.set保険料段階_11月(dankai11);
        fukakonkyo.set保険料段階_12月(dankai12);
        fukakonkyo.set保険料段階_1月(dankai1);
        fukakonkyo.set保険料段階_2月(dankai2);
        fukakonkyo.set保険料段階_3月(dankai3);        
        
        NengakuSeigyoJoho seigyo = new NengakuSeigyoJoho();
        seigyo.set端数単位(new Decimal("10"));
        seigyo.set端数調整方法("切り上げ");
        seigyo.set端数単位_ランク用(new Decimal("100"));
        seigyo.set端数調整方法_ランク用("切捨て");
        
        input.set年額賦課根拠(fukakonkyo);
        input.set年額制御情報(seigyo);
        input.set賦課年度("2014");       
        
        assertThat(factory.getIncetance(input).Calc端数(new Decimal("9999")) , is(new Decimal("9900")));
        
    }        

    @Test
    public void 資格取得日が年度途中の場合は端数調整必要(){
        
        端数調整Factory factory = new 端数調整Factory();
        
        保険料段階判定input input = new 保険料段階判定input();
        
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格取得日(new RDate("20140402"));
        fukakonkyo.set資格喪失日(null);
        fukakonkyo.setランク_4月("4");
        fukakonkyo.setランク_5月("4");
        fukakonkyo.setランク_6月("4");
        fukakonkyo.setランク_7月("4");
        fukakonkyo.setランク_8月("4");
        fukakonkyo.setランク_9月("4");
        fukakonkyo.setランク_10月("4");
        fukakonkyo.setランク_11月("4");
        fukakonkyo.setランク_12月("4");
        fukakonkyo.setランク_1月("4");
        fukakonkyo.setランク_2月("4");
        fukakonkyo.setランク_3月("4");
        
       dankai4.setSystemDankai("4");
        dankai5.setSystemDankai("4");
        dankai6.setSystemDankai("4");
        dankai7.setSystemDankai("4");
        dankai8.setSystemDankai("4");
        dankai9.setSystemDankai("4");
        dankai10.setSystemDankai("4");
        dankai11.setSystemDankai("4");
        dankai12.setSystemDankai("4");
        dankai1.setSystemDankai("4");
        dankai2.setSystemDankai("4");
        dankai3.setSystemDankai("4");
        
        fukakonkyo.set保険料段階_4月(dankai4);
        fukakonkyo.set保険料段階_5月(dankai5);
        fukakonkyo.set保険料段階_6月(dankai6);
        fukakonkyo.set保険料段階_7月(dankai7);
        fukakonkyo.set保険料段階_8月(dankai8);
        fukakonkyo.set保険料段階_9月(dankai9);
        fukakonkyo.set保険料段階_10月(dankai10);
        fukakonkyo.set保険料段階_11月(dankai11);
        fukakonkyo.set保険料段階_12月(dankai12);
        fukakonkyo.set保険料段階_1月(dankai1);
        fukakonkyo.set保険料段階_2月(dankai2);
        fukakonkyo.set保険料段階_3月(dankai3);        
        
        NengakuSeigyoJoho seigyo = new NengakuSeigyoJoho();
        seigyo.set端数単位(new Decimal("10"));
        seigyo.set端数調整方法("切り上げ");
        seigyo.set端数単位_ランク用(new Decimal("100"));
        seigyo.set端数調整方法_ランク用("切捨て");
        
        input.set年額賦課根拠(fukakonkyo);
        input.set年額制御情報(seigyo);
        input.set賦課年度("2014");       
        
        assertThat(factory.getIncetance(input).Calc端数(new Decimal("9999")) , is(new Decimal("10000")));
        
    }         
    
    
}
