package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 特徴開始月12月捕捉のテストクラスです。
 *
 * @author LDNS
 */
public class TokuchoKaishiTsuki12GatsuHosokuTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TokuchoKaishiTsuki12GatsuHosoku.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TokuchoKaishiTsuki12GatsuHosoku.toValue(new RString("99999"));
    }

    @Test
    public void 引数に00を指定した場合_toValueは_特別徴収しないを返す() {
        assertThat(TokuchoKaishiTsuki12GatsuHosoku.toValue(new RString("00")), is(TokuchoKaishiTsuki12GatsuHosoku.特別徴収しない));
    }

    @Test
    public void 引数に06を指定した場合_toValueは_06月を返す() {
        assertThat(TokuchoKaishiTsuki12GatsuHosoku.toValue(new RString("06")), is(TokuchoKaishiTsuki12GatsuHosoku._6月開始));
    }

    @Test
    public void 特別徴収しないを指定した場合_getコードは_00を返す() {
        assertThat(TokuchoKaishiTsuki12GatsuHosoku.特別徴収しない.getコード(), is(new RString("00")));
    }

    @Test
    public void _06月を指定した場合_getコードは_06を返す() {
        assertThat(TokuchoKaishiTsuki12GatsuHosoku._6月開始.getコード(), is(new RString("06")));
    }

    @Test
    public void 特別徴収しないを指定した場合_get名称は_特別徴収しないを返す() {
        assertThat(TokuchoKaishiTsuki12GatsuHosoku.特別徴収しない.get名称(), is(new RString("特別徴収しない")));
    }

    @Test
    public void _06月を指定した場合_get名称は__6月開始を返す() {
        assertThat(TokuchoKaishiTsuki12GatsuHosoku._6月開始.get名称(), is(new RString("6月開始")));
    }

    @Test
    public void 特別徴収しないを指定した場合_get略称は_空文字列を返す() {
        assertThat(TokuchoKaishiTsuki12GatsuHosoku.特別徴収しない.get略称(), is(RString.EMPTY));
    }

    @Test
    public void _06月を指定した場合_get略称は_06月を返す() {
        assertThat(TokuchoKaishiTsuki12GatsuHosoku._6月開始.get略称(), is(new RString("06月")));
    }

}
