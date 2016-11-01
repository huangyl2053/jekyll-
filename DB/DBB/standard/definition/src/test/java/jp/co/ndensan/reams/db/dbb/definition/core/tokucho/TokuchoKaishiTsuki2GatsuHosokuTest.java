package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 特徴開始月2月捕捉のテストクラスです。
 *
 * @author LDNS
 */
public class TokuchoKaishiTsuki2GatsuHosokuTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TokuchoKaishiTsuki2GatsuHosoku.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TokuchoKaishiTsuki2GatsuHosoku.toValue(new RString("99999"));
    }

    @Test
    public void 引数に00を指定した場合_toValueは_特別徴収しないを返す() {
        assertThat(TokuchoKaishiTsuki2GatsuHosoku.toValue(new RString("00")), is(TokuchoKaishiTsuki2GatsuHosoku.特別徴収しない));
    }

    @Test
    public void 引数に08を指定した場合_toValueは_08月を返す() {
        assertThat(TokuchoKaishiTsuki2GatsuHosoku.toValue(new RString("08")), is(TokuchoKaishiTsuki2GatsuHosoku._8月開始));
    }

    @Test
    public void 特別徴収しないを指定した場合_getコードは_00を返す() {
        assertThat(TokuchoKaishiTsuki2GatsuHosoku.特別徴収しない.getコード(), is(new RString("00")));
    }

    @Test
    public void _08月を指定した場合_getコードは_08を返す() {
        assertThat(TokuchoKaishiTsuki2GatsuHosoku._8月開始.getコード(), is(new RString("08")));
    }

    @Test
    public void 特別徴収しないを指定した場合_get名称は_特別徴収しないを返す() {
        assertThat(TokuchoKaishiTsuki2GatsuHosoku.特別徴収しない.get名称(), is(new RString("特別徴収しない")));
    }

    @Test
    public void _08月を指定した場合_get名称は__8月開始を返す() {
        assertThat(TokuchoKaishiTsuki2GatsuHosoku._8月開始.get名称(), is(new RString("_8月開始")));
    }

    @Test
    public void 特別徴収しないを指定した場合_get略称は_空文字列を返す() {
        assertThat(TokuchoKaishiTsuki2GatsuHosoku.特別徴収しない.get略称(), is(RString.EMPTY));
    }

    @Test
    public void _08月を指定した場合_get略称は_08月を返す() {
        assertThat(TokuchoKaishiTsuki2GatsuHosoku._8月開始.get略称(), is(new RString("08月")));
    }

}
