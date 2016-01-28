package jp.co.ndensan.reams.db.dbb.definition.core.gemmenchoshuyuyo;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 減免・徴収猶予作成区分のテストクラスです。
 *
 * @author LDNS
 */
public class GemmenChoshuYuyoSakuseiKubunTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        GemmenChoshuYuyoSakuseiKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        GemmenChoshuYuyoSakuseiKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_申請を返す() {
        assertThat(GemmenChoshuYuyoSakuseiKubun.toValue(new RString("0")), is(GemmenChoshuYuyoSakuseiKubun.申請));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_決定_承認を返す() {
        assertThat(GemmenChoshuYuyoSakuseiKubun.toValue(new RString("1")), is(GemmenChoshuYuyoSakuseiKubun.決定_承認));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_決定_不承認を返す() {
        assertThat(GemmenChoshuYuyoSakuseiKubun.toValue(new RString("2")), is(GemmenChoshuYuyoSakuseiKubun.決定_不承認));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_取消を返す() {
        assertThat(GemmenChoshuYuyoSakuseiKubun.toValue(new RString("3")), is(GemmenChoshuYuyoSakuseiKubun.取消));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_訂正を返す() {
        assertThat(GemmenChoshuYuyoSakuseiKubun.toValue(new RString("4")), is(GemmenChoshuYuyoSakuseiKubun.訂正));
    }

    @Test
    public void 引数に9を指定した場合_toValueは_論理削除を返す() {
        assertThat(GemmenChoshuYuyoSakuseiKubun.toValue(new RString("9")), is(GemmenChoshuYuyoSakuseiKubun.論理削除));
    }

    @Test
    public void 申請を指定した場合_getコードは_0を返す() {
        assertThat(GemmenChoshuYuyoSakuseiKubun.申請.getコード(), is(new RString("0")));
    }

    @Test
    public void 決定_承認を指定した場合_getコードは_1を返す() {
        assertThat(GemmenChoshuYuyoSakuseiKubun.決定_承認.getコード(), is(new RString("1")));
    }

    @Test
    public void 決定_不承認を指定した場合_getコードは_2を返す() {
        assertThat(GemmenChoshuYuyoSakuseiKubun.決定_不承認.getコード(), is(new RString("2")));
    }

    @Test
    public void 取消を指定した場合_getコードは_3を返す() {
        assertThat(GemmenChoshuYuyoSakuseiKubun.取消.getコード(), is(new RString("3")));
    }

    @Test
    public void 訂正を指定した場合_getコードは_4を返す() {
        assertThat(GemmenChoshuYuyoSakuseiKubun.訂正.getコード(), is(new RString("4")));
    }

    @Test
    public void 論理削除を指定した場合_getコードは_9を返す() {
        assertThat(GemmenChoshuYuyoSakuseiKubun.論理削除.getコード(), is(new RString("9")));
    }

    @Test
    public void 申請を指定した場合_get名称は_申請を返す() {
        assertThat(GemmenChoshuYuyoSakuseiKubun.申請.get名称(), is(new RString("申請")));
    }

    @Test
    public void 決定_承認を指定した場合_get名称は_決定_承認を返す() {
        assertThat(GemmenChoshuYuyoSakuseiKubun.決定_承認.get名称(), is(new RString("決定_承認")));
    }

    @Test
    public void 決定_不承認を指定した場合_get名称は_決定_不承認を返す() {
        assertThat(GemmenChoshuYuyoSakuseiKubun.決定_不承認.get名称(), is(new RString("決定_不承認")));
    }

    @Test
    public void 取消を指定した場合_get名称は_取消を返す() {
        assertThat(GemmenChoshuYuyoSakuseiKubun.取消.get名称(), is(new RString("取消")));
    }

    @Test
    public void 訂正を指定した場合_get名称は_訂正を返す() {
        assertThat(GemmenChoshuYuyoSakuseiKubun.訂正.get名称(), is(new RString("訂正")));
    }

    @Test
    public void 論理削除を指定した場合_get名称は_論理削除を返す() {
        assertThat(GemmenChoshuYuyoSakuseiKubun.論理削除.get名称(), is(new RString("論理削除")));
    }

}
