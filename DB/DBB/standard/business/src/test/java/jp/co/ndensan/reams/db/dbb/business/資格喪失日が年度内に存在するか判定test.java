package jp.co.ndensan.reams.db.dbb.business;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import jp.co.ndensan.reams.db.dbb.business.NengakuFukaKonkyo;
import jp.co.ndensan.reams.db.dbb.business.保険料段階判定input;
import jp.co.ndensan.reams.db.dbb.business.資格喪失日が年度内に存在するか判定;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
public class 資格喪失日が年度内に存在するか判定test {
    
    public 資格喪失日が年度内に存在するか判定test() {
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
    public void 資格喪失日が年度開始日以前の場合falseを返す(){
        端数調整判定 soushitu = new 資格喪失日が年度内に存在するか判定();
        
        保険料段階判定input input = new 保険料段階判定input();
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格喪失日(new RDate("2014/03/31"));
        input.set年額賦課根拠(fukakonkyo);
        input.set賦課年度("2014");
        assertThat(soushitu.JudgeHasuu(input), is(false));        
    }    
 
    @Test
    public void 資格喪失日が年度内の場合はtrueを返す(){
        端数調整判定 soushitu = new 資格喪失日が年度内に存在するか判定();
        
        保険料段階判定input input = new 保険料段階判定input();
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格喪失日(new RDate("2014/04/03"));
        input.set年額賦課根拠(fukakonkyo);
        input.set賦課年度("2014");
        assertThat(soushitu.JudgeHasuu(input), is(true));        
    }         
    
    @Test
    public void 資格喪失日が年度終了日以降の場合falseを返す(){
        資格喪失日が年度内に存在するか判定 soushitu = new 資格喪失日が年度内に存在するか判定();
        
        保険料段階判定input input = new 保険料段階判定input();
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格喪失日(new RDate("2015/04/01"));
        input.set年額賦課根拠(fukakonkyo);
        input.set賦課年度("2014");
        assertThat(soushitu.JudgeHasuu(input), is(false));        
    }
    
    @Test
    public void 資格喪失日が空白の場合falseを返す(){
        資格喪失日が年度内に存在するか判定 soushitu = new 資格喪失日が年度内に存在するか判定();
        
        保険料段階判定input input = new 保険料段階判定input();
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格喪失日(null);
        input.set年額賦課根拠(fukakonkyo);
        input.set賦課年度("2014");
        assertThat(soushitu.JudgeHasuu(input), is(false));        
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
