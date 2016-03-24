/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.hasuchosei;

import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuHokenryoKeisanParameter;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuFukaKonkyoTest;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * ランクが4月_翌3月まで変更無いかテストクラスです。
 *
 * @author n3336
 */
public class ShikakuSoshitsuNendonaiTest {

    public ShikakuSoshitsuNendonaiTest() {
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
    public void 資格喪失日が年度開始日以前の場合falseを返す() {
        IHasuChoseiHantei soushitu = new ShikakuSoshitsuNendonai();

        NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter = new NengakuHokenryoKeisanParameter();
        nengakuHokenryoKeisanParameter.set年額賦課根拠(NengakuFukaKonkyoTest.set資格喪失日が年度開始日以前の場合falseを返す());
        nengakuHokenryoKeisanParameter.set賦課年度(new FlexibleDate("2014"));
        assertThat(soushitu.judgeHasuu(nengakuHokenryoKeisanParameter), is(false));
    }

    @Test
    public void 資格喪失日が年度内の場合はtrueを返す() {
        IHasuChoseiHantei soushitu = new ShikakuSoshitsuNendonai();

        NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter = new NengakuHokenryoKeisanParameter();
        nengakuHokenryoKeisanParameter.set年額賦課根拠(NengakuFukaKonkyoTest.set資格喪失日が年度内の場合はtrueを返す());
        nengakuHokenryoKeisanParameter.set賦課年度(new FlexibleDate("2014"));
        assertThat(soushitu.judgeHasuu(nengakuHokenryoKeisanParameter), is(true));
    }

    @Test
    public void 資格喪失日が年度終了日以降の場合falseを返す() {
        ShikakuSoshitsuNendonai soushitu = new ShikakuSoshitsuNendonai();

        NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter = new NengakuHokenryoKeisanParameter();
        nengakuHokenryoKeisanParameter.set年額賦課根拠(NengakuFukaKonkyoTest.set資格喪失日が年度終了日以降の場合falseを返す());
        nengakuHokenryoKeisanParameter.set賦課年度(new FlexibleDate("2014"));
        assertThat(soushitu.judgeHasuu(nengakuHokenryoKeisanParameter), is(false));
    }

    @Test
    public void 資格喪失日が空白の場合falseを返す() {
        ShikakuSoshitsuNendonai soushitu = new ShikakuSoshitsuNendonai();

        NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter = new NengakuHokenryoKeisanParameter();
        nengakuHokenryoKeisanParameter.set年額賦課根拠(NengakuFukaKonkyoTest.set資格喪失日が空白の場合falseを返す());
        nengakuHokenryoKeisanParameter.set賦課年度(new FlexibleDate("2014"));
        assertThat(soushitu.judgeHasuu(nengakuHokenryoKeisanParameter), is(false));
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
