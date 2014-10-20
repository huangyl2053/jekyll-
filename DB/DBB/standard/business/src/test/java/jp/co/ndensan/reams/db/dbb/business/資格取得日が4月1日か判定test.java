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
import jp.co.ndensan.reams.db.dbb.business.資格取得日が4月1日か判定;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
public class 資格取得日が4月1日か判定test {
    
    public 資格取得日が4月1日か判定test() {
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
    public void 資格取得日が年度開始日以前か判定(){
        資格取得日が4月1日か判定 shutoku = new 資格取得日が4月1日か判定();
        
        保険料段階判定input input = new 保険料段階判定input();
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格取得日(new RDate("20140331"));
        input.set年額賦課根拠(fukakonkyo);
        input.set賦課年度("2014");
        assertThat(shutoku.JudgeHasuu(input), is(false));        
    }

    @Test
    public void 資格取得日が4月1日の場合端数調整する必要がないのでfalseとなる(){
        資格取得日が4月1日か判定 shutoku = new 資格取得日が4月1日か判定();
        
        保険料段階判定input input = new 保険料段階判定input();
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格取得日(new RDate("20140401"));
        input.set年額賦課根拠(fukakonkyo);
        input.set賦課年度("2014");
        assertThat(shutoku.JudgeHasuu(input), is(false));        
    }

    @Test
    public void 資格取得日が年度開始日以降の場合trueを返す(){
        資格取得日が4月1日か判定 shutoku = new 資格取得日が4月1日か判定();
        
        保険料段階判定input input = new 保険料段階判定input();
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格取得日(new RDate("20140402"));
        input.set年額賦課根拠(fukakonkyo);
        input.set賦課年度("2014");
        assertThat(shutoku.JudgeHasuu(input), is(true));        
    }

    @Test
    public void 資格取得日が翌年3月の場合調整必要となるためtrueを返す(){
        資格取得日が4月1日か判定 shutoku = new 資格取得日が4月1日か判定();
        
        保険料段階判定input input = new 保険料段階判定input();
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格取得日(new RDate("20150331"));
        input.set年額賦課根拠(fukakonkyo);
        input.set賦課年度("2014");
        assertThat(shutoku.JudgeHasuu(input), is(true));        
    }        
    
    @Test
    public void 資格取得日が次年度の場合調整不要となるためfalseを返す(){
        資格取得日が4月1日か判定 shutoku = new 資格取得日が4月1日か判定();
        
        保険料段階判定input input = new 保険料段階判定input();
        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格取得日(new RDate("20150501"));
        input.set年額賦課根拠(fukakonkyo);
        input.set賦課年度("2014");
        assertThat(shutoku.JudgeHasuu(input), is(false));        
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
