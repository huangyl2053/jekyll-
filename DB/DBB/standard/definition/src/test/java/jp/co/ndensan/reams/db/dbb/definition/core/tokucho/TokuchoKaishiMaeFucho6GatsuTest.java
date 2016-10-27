package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 特徴開始前普通徴収6月のテストクラスです。
 *
 * @author LDNS
 */
public class TokuchoKaishiMaeFucho6GatsuTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TokuchoKaishiMaeFucho6Gatsu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TokuchoKaishiMaeFucho6Gatsu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_特別徴収開始前の仮算定納期で普通徴収しないを返す() {
        assertThat(TokuchoKaishiMaeFucho6Gatsu.toValue(new RString("0")), is(TokuchoKaishiMaeFucho6Gatsu.なし));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_特別徴収開始前の仮算定納期で普通徴収するを返す() {
        assertThat(TokuchoKaishiMaeFucho6Gatsu.toValue(new RString("1")), is(TokuchoKaishiMaeFucho6Gatsu.あり));
    }

    @Test
    public void 特別徴収開始前の仮算定納期で普通徴収しないを指定した場合_getコードは_0を返す() {
        assertThat(TokuchoKaishiMaeFucho6Gatsu.なし.getコード(), is(new RString("0")));
    }

    @Test
    public void 特別徴収開始前の仮算定納期で普通徴収するを指定した場合_getコードは_1を返す() {
        assertThat(TokuchoKaishiMaeFucho6Gatsu.あり.getコード(), is(new RString("1")));
    }

    @Test
    public void 特別徴収開始前の仮算定納期で普通徴収しないを指定した場合_get名称は_なしを返す() {
        assertThat(TokuchoKaishiMaeFucho6Gatsu.なし.get名称(), is(new RString("特別徴収開始前の仮算定納期で普通徴収しない")));
    }

    @Test
    public void 特別徴収開始前の仮算定納期で普通徴収するを指定した場合_get名称は_ありを返す() {
        assertThat(TokuchoKaishiMaeFucho6Gatsu.あり.get名称(), is(new RString("特別徴収開始前の仮算定納期で普通徴収する")));
    }

}
