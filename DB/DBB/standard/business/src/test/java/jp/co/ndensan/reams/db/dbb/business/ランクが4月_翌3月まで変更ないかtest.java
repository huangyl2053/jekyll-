/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.business;

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
public class ランクが4月_翌3月まで変更ないかtest {
    
    public ランクが4月_翌3月まで変更ないかtest() {
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
    public void ランクに変更がある場合はtrue(){
        
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
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
                
        端数調整判定 hantei = new ランクが4月_翌3月まで変更無いか();        
        保険料段階判定input input = new 保険料段階判定input();                
        input.set年額賦課根拠(fukakonkyo);
        assertThat(hantei.JudgeHasuu(input), is(true));    
    }
    
    @Test
    public void ランクに変更がない場合はfalse(){
        
                NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
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
                
        端数調整判定 hantei = new ランクが4月_翌3月まで変更無いか();        
        保険料段階判定input input = new 保険料段階判定input();                
        input.set年額賦課根拠(fukakonkyo);
        assertThat(hantei.JudgeHasuu(input), is(false));    
    }    
    
}
