package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 特徴開始月8月捕捉のテストクラスです。
 *
 * @author LDNS
 */
public class TokuchoKaishiTsuki8GatsuHosokuTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TokuchoKaishiTsuki8GatsuHosoku.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TokuchoKaishiTsuki8GatsuHosoku.toValue(new RString("99999"));
    }

    @Test
    public void 引数に00を指定した場合_toValueは_特別徴収しないを返す() {
        assertThat(TokuchoKaishiTsuki8GatsuHosoku.toValue(new RString("00")), is(TokuchoKaishiTsuki8GatsuHosoku.特別徴収しない));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_02月を返す() {
        assertThat(TokuchoKaishiTsuki8GatsuHosoku.toValue(new RString("02")), is(TokuchoKaishiTsuki8GatsuHosoku._2月開始));
    }

    @Test
    public void 引数に04を指定した場合_toValueは_04月を返す() {
        assertThat(TokuchoKaishiTsuki8GatsuHosoku.toValue(new RString("04")), is(TokuchoKaishiTsuki8GatsuHosoku._4月開始_待機));
    }

    @Test
    public void 特別徴収しないを指定した場合_getコードは_00を返す() {
        assertThat(TokuchoKaishiTsuki8GatsuHosoku.特別徴収しない.getコード(), is(new RString("00")));
    }

    @Test
    public void _02月を指定した場合_getコードは_02を返す() {
        assertThat(TokuchoKaishiTsuki8GatsuHosoku._2月開始.getコード(), is(new RString("02")));
    }

    @Test
    public void _04月を指定した場合_getコードは_04を返す() {
        assertThat(TokuchoKaishiTsuki8GatsuHosoku._4月開始_待機.getコード(), is(new RString("04")));
    }

    @Test
    public void 特別徴収しないを指定した場合_get名称は_特別徴収しないを返す() {
        assertThat(TokuchoKaishiTsuki8GatsuHosoku.特別徴収しない.get名称(), is(new RString("特別徴収しない")));
    }

    @Test
    public void _02月を指定した場合_get名称は__2月開始を返す() {
        assertThat(TokuchoKaishiTsuki8GatsuHosoku._2月開始.get名称(), is(new RString("2月開始")));
    }

    @Test
    public void _04月を指定した場合_get名称は__4月開始_待機を返す() {
        assertThat(TokuchoKaishiTsuki8GatsuHosoku._4月開始_待機.get名称(), is(new RString("4月開始_待機")));
    }

    @Test
    public void 特別徴収しないを指定した場合_get略称は_空文字列を返す() {
        assertThat(TokuchoKaishiTsuki8GatsuHosoku.特別徴収しない.get略称(), is(RString.EMPTY));
    }

    @Test
    public void _02月を指定した場合_get略称は_02月を返す() {
        assertThat(TokuchoKaishiTsuki8GatsuHosoku._2月開始.get略称(), is(new RString("02月")));
    }

    @Test
    public void _04月を指定した場合_get略称は_04月を返す() {
        assertThat(TokuchoKaishiTsuki8GatsuHosoku._4月開始_待機.get略称(), is(new RString("04月")));
    }

}
