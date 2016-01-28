package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 特徴捕捉月のテストクラスです。
 *
 * @author LDNS
 */
public class TokuchoHosokuMonthTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TokuchoHosokuMonth.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TokuchoHosokuMonth.toValue(new RString("99999"));
    }

    @Test
    public void 引数に04を指定した場合_toValueは_特徴4月捕捉を返す() {
        assertThat(TokuchoHosokuMonth.toValue(new RString("04")), is(TokuchoHosokuMonth.特徴4月捕捉));
    }

    @Test
    public void 引数に06を指定した場合_toValueは_特徴6月捕捉を返す() {
        assertThat(TokuchoHosokuMonth.toValue(new RString("06")), is(TokuchoHosokuMonth.特徴6月捕捉));
    }

    @Test
    public void 引数に08を指定した場合_toValueは_特徴8月捕捉を返す() {
        assertThat(TokuchoHosokuMonth.toValue(new RString("08")), is(TokuchoHosokuMonth.特徴8月捕捉));
    }

    @Test
    public void 引数に10を指定した場合_toValueは_特徴10月捕捉を返す() {
        assertThat(TokuchoHosokuMonth.toValue(new RString("10")), is(TokuchoHosokuMonth.特徴10月捕捉));
    }

    @Test
    public void 引数に12を指定した場合_toValueは_特徴12月捕捉を返す() {
        assertThat(TokuchoHosokuMonth.toValue(new RString("12")), is(TokuchoHosokuMonth.特徴12月捕捉));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_特徴2月捕捉を返す() {
        assertThat(TokuchoHosokuMonth.toValue(new RString("02")), is(TokuchoHosokuMonth.特徴2月捕捉));
    }

    @Test
    public void 特徴4月捕捉を指定した場合_getコードは_04を返す() {
        assertThat(TokuchoHosokuMonth.特徴4月捕捉.getコード(), is(new RString("04")));
    }

    @Test
    public void 特徴6月捕捉を指定した場合_getコードは_06を返す() {
        assertThat(TokuchoHosokuMonth.特徴6月捕捉.getコード(), is(new RString("06")));
    }

    @Test
    public void 特徴8月捕捉を指定した場合_getコードは_08を返す() {
        assertThat(TokuchoHosokuMonth.特徴8月捕捉.getコード(), is(new RString("08")));
    }

    @Test
    public void 特徴10月捕捉を指定した場合_getコードは_10を返す() {
        assertThat(TokuchoHosokuMonth.特徴10月捕捉.getコード(), is(new RString("10")));
    }

    @Test
    public void 特徴12月捕捉を指定した場合_getコードは_12を返す() {
        assertThat(TokuchoHosokuMonth.特徴12月捕捉.getコード(), is(new RString("12")));
    }

    @Test
    public void 特徴2月捕捉を指定した場合_getコードは_02を返す() {
        assertThat(TokuchoHosokuMonth.特徴2月捕捉.getコード(), is(new RString("02")));
    }

    @Test
    public void 特徴4月捕捉を指定した場合_get名称は_特徴4月捕捉を返す() {
        assertThat(TokuchoHosokuMonth.特徴4月捕捉.get名称(), is(new RString("特徴4月捕捉")));
    }

    @Test
    public void 特徴6月捕捉を指定した場合_get名称は_特徴6月捕捉を返す() {
        assertThat(TokuchoHosokuMonth.特徴6月捕捉.get名称(), is(new RString("特徴6月捕捉")));
    }

    @Test
    public void 特徴8月捕捉を指定した場合_get名称は_特徴8月捕捉を返す() {
        assertThat(TokuchoHosokuMonth.特徴8月捕捉.get名称(), is(new RString("特徴8月捕捉")));
    }

    @Test
    public void 特徴10月捕捉を指定した場合_get名称は_特徴10月捕捉を返す() {
        assertThat(TokuchoHosokuMonth.特徴10月捕捉.get名称(), is(new RString("特徴10月捕捉")));
    }

    @Test
    public void 特徴12月捕捉を指定した場合_get名称は_特徴12月捕捉を返す() {
        assertThat(TokuchoHosokuMonth.特徴12月捕捉.get名称(), is(new RString("特徴12月捕捉")));
    }

    @Test
    public void 特徴2月捕捉を指定した場合_get名称は_特徴2月捕捉を返す() {
        assertThat(TokuchoHosokuMonth.特徴2月捕捉.get名称(), is(new RString("特徴2月捕捉")));
    }

}
