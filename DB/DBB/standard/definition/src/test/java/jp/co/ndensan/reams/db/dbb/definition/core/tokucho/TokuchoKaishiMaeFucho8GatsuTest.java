package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 特徴開始前普通徴収8月のテストクラスです。
 *
 * @author LDNS
 */
public class TokuchoKaishiMaeFucho8GatsuTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TokuchoKaishiMaeFucho8Gatsu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TokuchoKaishiMaeFucho8Gatsu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_特別徴収開始前の本算定納期で普通徴収しないを返す() {
        assertThat(TokuchoKaishiMaeFucho8Gatsu.toValue(new RString("0")), is(TokuchoKaishiMaeFucho8Gatsu.なし));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_特別徴収開始前の本算定納期で普通徴収するを返す() {
        assertThat(TokuchoKaishiMaeFucho8Gatsu.toValue(new RString("1")), is(TokuchoKaishiMaeFucho8Gatsu.あり));
    }

    @Test
    public void 特別徴収開始前の本算定納期で普通徴収しないを指定した場合_getコードは_0を返す() {
        assertThat(TokuchoKaishiMaeFucho8Gatsu.なし.getコード(), is(new RString("0")));
    }

    @Test
    public void 特別徴収開始前の本算定納期で普通徴収するを指定した場合_getコードは_1を返す() {
        assertThat(TokuchoKaishiMaeFucho8Gatsu.あり.getコード(), is(new RString("1")));
    }

    @Test
    public void 特別徴収開始前の本算定納期で普通徴収しないを指定した場合_get名称は_なしを返す() {
        assertThat(TokuchoKaishiMaeFucho8Gatsu.なし.get名称(), is(new RString("特別徴収開始前の本算定納期で普通徴収しない")));
    }

    @Test
    public void 特別徴収開始前の本算定納期で普通徴収するを指定した場合_get名称は_ありを返す() {
        assertThat(TokuchoKaishiMaeFucho8Gatsu.あり.get名称(), is(new RString("特別徴収開始前の本算定納期で普通徴収する")));
    }

}
