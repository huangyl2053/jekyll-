/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
        fukakonkyo.setランク_4月(new RString("5"));
        fukakonkyo.setランク_5月(new RString("4"));
        fukakonkyo.setランク_6月(new RString("4"));
        fukakonkyo.setランク_7月(new RString("4"));
        fukakonkyo.setランク_8月(new RString("4"));
        fukakonkyo.setランク_9月(new RString("4"));
        fukakonkyo.setランク_10月(new RString("4"));
        fukakonkyo.setランク_11月(new RString("4"));
        fukakonkyo.setランク_12月(new RString("4"));
        fukakonkyo.setランク_1月(new RString("4"));
        fukakonkyo.setランク_2月(new RString("4"));
        fukakonkyo.setランク_3月(new RString("4"));
                
        端数調整判定 hantei = new ランクが4月_翌3月まで変更無いか();        
        保険料段階判定input input = new 保険料段階判定input();                
        input.set年額賦課根拠(fukakonkyo);
        assertThat(hantei.judgeHasuu(input), is(true));    
    }
    
    @Test
    public void ランクに変更がない場合はfalse(){
        
                NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.setランク_4月(new RString("4"));
        fukakonkyo.setランク_5月(new RString("4"));
        fukakonkyo.setランク_6月(new RString("4"));
        fukakonkyo.setランク_7月(new RString("4"));
        fukakonkyo.setランク_8月(new RString("4"));
        fukakonkyo.setランク_9月(new RString("4"));
        fukakonkyo.setランク_10月(new RString("4"));
        fukakonkyo.setランク_11月(new RString("4"));
        fukakonkyo.setランク_12月(new RString("4"));
        fukakonkyo.setランク_1月(new RString("4"));
        fukakonkyo.setランク_2月(new RString("4"));
        fukakonkyo.setランク_3月(new RString("4"));
                
        端数調整判定 hantei = new ランクが4月_翌3月まで変更無いか();        
        保険料段階判定input input = new 保険料段階判定input();                
        input.set年額賦課根拠(fukakonkyo);
        assertThat(hantei.judgeHasuu(input), is(false));    
    }    
    
}
