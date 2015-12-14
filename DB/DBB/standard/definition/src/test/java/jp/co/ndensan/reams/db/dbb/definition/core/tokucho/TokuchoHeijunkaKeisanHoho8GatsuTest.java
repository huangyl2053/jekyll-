package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 特別徴収平準化計算方法8月分のテストクラスです。
 *
 * @author LDNS
 */
public class TokuchoHeijunkaKeisanHoho8GatsuTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TokuchoHeijunkaKeisanHoho8Gatsu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TokuchoHeijunkaKeisanHoho8Gatsu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_平準化しないを返す() {
        assertThat(TokuchoHeijunkaKeisanHoho8Gatsu.toValue(new RString("0")), is(TokuchoHeijunkaKeisanHoho8Gatsu.平準化しない));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_前半と後半を１_１にするを返す() {
        assertThat(TokuchoHeijunkaKeisanHoho8Gatsu.toValue(new RString("1")), is(TokuchoHeijunkaKeisanHoho8Gatsu.前半と後半を１_１にする
        ));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_年額より特徴３期分を含まない仮徴収額を引いた額を４期で割るを返す() {
        assertThat(TokuchoHeijunkaKeisanHoho8Gatsu.toValue(new RString("2")), is(TokuchoHeijunkaKeisanHoho8Gatsu.年額より特徴３期分を含まない仮徴収額を引いた額を４期で割る));
    }

    @Test
    public void 平準化しないを指定した場合_getコードは_0を返す() {
        assertThat(TokuchoHeijunkaKeisanHoho8Gatsu.平準化しない.getコード(), is(new RString("0")));
    }

    @Test
    public void 前半と後半を１_１にするを指定した場合_getコードは_1を返す() {
        assertThat(TokuchoHeijunkaKeisanHoho8Gatsu.前半と後半を１_１にする.getコード(), is(new RString("1")));
    }

    @Test
    public void 年額より特徴３期分を含まない仮徴収額を引いた額を４期で割るを指定した場合_getコードは_2を返す() {
        assertThat(TokuchoHeijunkaKeisanHoho8Gatsu.年額より特徴３期分を含まない仮徴収額を引いた額を４期で割る.getコード(), is(new RString("2")));
    }

    @Test
    public void 平準化しないを指定した場合_get名称は_平準化しないを返す() {
        assertThat(TokuchoHeijunkaKeisanHoho8Gatsu.平準化しない.get名称(), is(new RString("平準化しない")));
    }

    @Test
    public void 前半と後半を１_１にするを指定した場合_get名称は_前半と後半を1対1にするを返す() {
        assertThat(TokuchoHeijunkaKeisanHoho8Gatsu.前半と後半を１_１にする.get名称(), is(new RString("前半と後半を1対1にする")));
    }

    @Test
    public void 年額より特徴３期分を含まない仮徴収額を引いた額を４期で割るを指定した場合_get名称は_年額より特徴3期分を含まない仮徴収額を引いた額を4期で割るを返す() {
        assertThat(TokuchoHeijunkaKeisanHoho8Gatsu.年額より特徴３期分を含まない仮徴収額を引いた額を４期で割る.get名称(), is(new RString("年額より特徴3期分を含まない仮徴収額を引いた額を4期で割る")));
    }

    @Test
    public void 平準化しないを指定した場合_get略称は_平準化しないを返す() {
        assertThat(TokuchoHeijunkaKeisanHoho8Gatsu.平準化しない.get略称(), is(new RString("平準化しない")));
    }

    @Test
    public void 前半と後半を１_１にするを指定した場合_get略称は_前半と後半を１_１にするを返す() {
        assertThat(TokuchoHeijunkaKeisanHoho8Gatsu.前半と後半を１_１にする.get略称(), is(new RString("前半と後半を１_１にする")));
    }

    @Test
    public void 年額より特徴３期分を含まない仮徴収額を引いた額を４期で割るを指定した場合_get略称は_年額より特徴３期分を含まない仮徴収額を引いた額を４期で割るを返す() {
        assertThat(TokuchoHeijunkaKeisanHoho8Gatsu.年額より特徴３期分を含まない仮徴収額を引いた額を４期で割る.get略称(), is(new RString("年額より特徴３期分を含まない仮徴収額を引いた額を４期で割る")));
    }

}
