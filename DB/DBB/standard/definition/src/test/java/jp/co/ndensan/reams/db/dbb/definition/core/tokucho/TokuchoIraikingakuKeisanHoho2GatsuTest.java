package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 特徴依頼金額計算方法2月のテストクラスです。
 *
 * @author LDNS
 */
public class TokuchoIraikingakuKeisanHoho2GatsuTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TokuchoIraikingakuKeisanHoho2Gatsu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TokuchoIraikingakuKeisanHoho2Gatsu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_特徴開始月以降の普通徴収額を返す() {
        assertThat(TokuchoIraikingakuKeisanHoho2Gatsu.toValue(new RString("1")), is(TokuchoIraikingakuKeisanHoho2Gatsu.特徴開始月以降の普通徴収額));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_年額除12乗本徴収月数除年金支給回数を返す() {
        assertThat(TokuchoIraikingakuKeisanHoho2Gatsu.toValue(new RString("3")), is(TokuchoIraikingakuKeisanHoho2Gatsu.年額除12乗本徴収月数除年金支給回数
        ));
    }

    @Test
    public void 特徴開始月以降の普通徴収額を指定した場合_getコードは_1を返す() {
        assertThat(TokuchoIraikingakuKeisanHoho2Gatsu.特徴開始月以降の普通徴収額.getコード(), is(new RString("1")));
    }

    @Test
    public void 年額除12乗本徴収月数除年金支給回数を指定した場合_getコードは_3を返す() {
        assertThat(TokuchoIraikingakuKeisanHoho2Gatsu.年額除12乗本徴収月数除年金支給回数.getコード(), is(new RString("3"))
        );
    }

    @Test
    public void 特徴開始月以降の普通徴収額を指定した場合_get名称は_特徴開始月以降の普通徴収額を返す() {
        assertThat(TokuchoIraikingakuKeisanHoho2Gatsu.特徴開始月以降の普通徴収額.get名称(), is(new RString("特徴開始月以降の普通徴収額")));
    }

    @Test
    public void 年額除12乗本徴収月数除年金支給回数を指定した場合_get名称は_法定計算方法_6で割るを返す() {
        assertThat(TokuchoIraikingakuKeisanHoho2Gatsu.年額除12乗本徴収月数除年金支給回数.get名称(), is(new RString("法定計算方法_6で割る"))
        );
    }

    @Test
    public void 特徴開始月以降の普通徴収額を指定した場合_get略称は_特徴開始月以降の普通徴収額を返す() {
        assertThat(TokuchoIraikingakuKeisanHoho2Gatsu.特徴開始月以降の普通徴収額.get略称(), is(new RString("特徴開始月以降の普通徴収額")));
    }

    @Test
    public void 年額除12乗本徴収月数除年金支給回数を指定した場合_get略称は_年額除12乗本徴収月数除年金支給回数を返す() {
        assertThat(TokuchoIraikingakuKeisanHoho2Gatsu.年額除12乗本徴収月数除年金支給回数.get略称(), is(new RString("年額除12乗本徴収月数除年金支給回数"))
        );
    }

}
