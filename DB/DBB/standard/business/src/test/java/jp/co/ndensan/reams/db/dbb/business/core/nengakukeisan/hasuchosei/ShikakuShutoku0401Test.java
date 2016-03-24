package jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.hasuchosei;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * 資格取得日が4月1日か判定テストクラスです。
 *
 * @author n3336
 */
public class ShikakuShutoku0401Test {

    public ShikakuShutoku0401Test() {
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
    public void 資格取得日が年度開始日以前か判定() {
        ShikakuShutoku0401 shutoku = new ShikakuShutoku0401();

        NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter = new NengakuHokenryoKeisanParameter();
        nengakuHokenryoKeisanParameter.set年額賦課根拠(NengakuFukaKonkyoTest.set資格取得日が年度開始日以前か判定());
        nengakuHokenryoKeisanParameter.set賦課年度(new FlexibleDate("2014"));
        assertThat(shutoku.judgeHasuu(nengakuHokenryoKeisanParameter), is(false));
    }

    @Test
    public void 資格取得日が4月1日の場合端数調整する必要がないのでfalseとなる() {
        ShikakuShutoku0401 shutoku = new ShikakuShutoku0401();

        NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter = new NengakuHokenryoKeisanParameter();
        nengakuHokenryoKeisanParameter.set年額賦課根拠(NengakuFukaKonkyoTest.set資格取得日が4月1日の場合端数調整する必要がないのでfalseとなる());
        nengakuHokenryoKeisanParameter.set賦課年度(new FlexibleDate("2014"));
        assertThat(shutoku.judgeHasuu(nengakuHokenryoKeisanParameter), is(false));
    }

    @Test
    public void 資格取得日が年度開始日以降の場合trueを返す() {
        ShikakuShutoku0401 shutoku = new ShikakuShutoku0401();

        NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter = new NengakuHokenryoKeisanParameter();
        nengakuHokenryoKeisanParameter.set年額賦課根拠(NengakuFukaKonkyoTest.set資格取得日が年度開始日以降の場合trueを返す());
        nengakuHokenryoKeisanParameter.set賦課年度(new FlexibleDate("2014"));
        assertThat(shutoku.judgeHasuu(nengakuHokenryoKeisanParameter), is(true));
    }

    @Test
    public void 資格取得日が翌年3月の場合調整必要となるためtrueを返す() {
        ShikakuShutoku0401 shutoku = new ShikakuShutoku0401();

        NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter = new NengakuHokenryoKeisanParameter();
        nengakuHokenryoKeisanParameter.set年額賦課根拠(NengakuFukaKonkyoTest.set資格取得日が翌年3月の場合調整必要となるためtrueを返す());
        nengakuHokenryoKeisanParameter.set賦課年度(new FlexibleDate("2014"));
        assertThat(shutoku.judgeHasuu(nengakuHokenryoKeisanParameter), is(true));
    }

    @Test
    public void 資格取得日が次年度の場合調整不要となるためfalseを返す() {
        ShikakuShutoku0401 shutoku = new ShikakuShutoku0401();

        NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter = new NengakuHokenryoKeisanParameter();
        nengakuHokenryoKeisanParameter.set年額賦課根拠(NengakuFukaKonkyoTest.set資格取得日が次年度の場合調整不要となるためfalseを返す());
        nengakuHokenryoKeisanParameter.set賦課年度(new FlexibleDate("2014"));
        assertThat(shutoku.judgeHasuu(nengakuHokenryoKeisanParameter), is(false));
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
