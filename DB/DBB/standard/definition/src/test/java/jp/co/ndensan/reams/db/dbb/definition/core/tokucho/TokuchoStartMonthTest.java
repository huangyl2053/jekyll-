package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 特徴開始月のテストクラスです。
 *
 * @author LDNS
 */
public class TokuchoStartMonthTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TokuchoStartMonth.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TokuchoStartMonth.toValue(new RString("99999"));
    }

    @Test
    public void 引数に04を指定した場合_toValueは_特徴4月開始を返す() {
        assertThat(TokuchoStartMonth.toValue(new RString("04")), is(TokuchoStartMonth.特徴4月開始));
    }

    @Test
    public void 引数に06を指定した場合_toValueは_特徴6月開始を返す() {
        assertThat(TokuchoStartMonth.toValue(new RString("06")), is(TokuchoStartMonth.特徴6月開始));
    }

    @Test
    public void 引数に08を指定した場合_toValueは_特徴8月開始を返す() {
        assertThat(TokuchoStartMonth.toValue(new RString("08")), is(TokuchoStartMonth.特徴8月開始));
    }

    @Test
    public void 引数に10を指定した場合_toValueは_特徴10月開始を返す() {
        assertThat(TokuchoStartMonth.toValue(new RString("10")), is(TokuchoStartMonth.特徴10月開始));
    }

    @Test
    public void 引数に12を指定した場合_toValueは_特徴12月開始を返す() {
        assertThat(TokuchoStartMonth.toValue(new RString("12")), is(TokuchoStartMonth.特徴12月開始));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_特徴2月開始を返す() {
        assertThat(TokuchoStartMonth.toValue(new RString("02")), is(TokuchoStartMonth.特徴2月開始));
    }

    @Test
    public void 特徴4月開始を指定した場合_getコードは_04を返す() {
        assertThat(TokuchoStartMonth.特徴4月開始.getコード(), is(new RString("04")));
    }

    @Test
    public void 特徴6月開始を指定した場合_getコードは_06を返す() {
        assertThat(TokuchoStartMonth.特徴6月開始.getコード(), is(new RString("06")));
    }

    @Test
    public void 特徴8月開始を指定した場合_getコードは_08を返す() {
        assertThat(TokuchoStartMonth.特徴8月開始.getコード(), is(new RString("08")));
    }

    @Test
    public void 特徴10月開始を指定した場合_getコードは_10を返す() {
        assertThat(TokuchoStartMonth.特徴10月開始.getコード(), is(new RString("10")));
    }

    @Test
    public void 特徴12月開始を指定した場合_getコードは_12を返す() {
        assertThat(TokuchoStartMonth.特徴12月開始.getコード(), is(new RString("12")));
    }

    @Test
    public void 特徴2月開始を指定した場合_getコードは_02を返す() {
        assertThat(TokuchoStartMonth.特徴2月開始.getコード(), is(new RString("02")));
    }

    @Test
    public void 特徴4月開始を指定した場合_get名称は_特徴4月開始を返す() {
        assertThat(TokuchoStartMonth.特徴4月開始.get名称(), is(new RString("特徴4月開始")));
    }

    @Test
    public void 特徴6月開始を指定した場合_get名称は_特徴6月開始を返す() {
        assertThat(TokuchoStartMonth.特徴6月開始.get名称(), is(new RString("特徴6月開始")));
    }

    @Test
    public void 特徴8月開始を指定した場合_get名称は_特徴8月開始を返す() {
        assertThat(TokuchoStartMonth.特徴8月開始.get名称(), is(new RString("特徴8月開始")));
    }

    @Test
    public void 特徴10月開始を指定した場合_get名称は_特徴10月開始を返す() {
        assertThat(TokuchoStartMonth.特徴10月開始.get名称(), is(new RString("特徴10月開始")));
    }

    @Test
    public void 特徴12月開始を指定した場合_get名称は_特徴12月開始を返す() {
        assertThat(TokuchoStartMonth.特徴12月開始.get名称(), is(new RString("特徴12月開始")));
    }

    @Test
    public void 特徴2月開始を指定した場合_get名称は_特徴2月開始を返す() {
        assertThat(TokuchoStartMonth.特徴2月開始.get名称(), is(new RString("特徴2月開始")));
    }

}
