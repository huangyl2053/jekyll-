package jp.co.ndensan.reams.db.dbb.definition.core.gemmenchoshuyuyo;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 減免・徴収猶予状態区分のテストクラスです。
 *
 * @author LDNS
 */
public class GemmenChoshuYuyoStateKubunTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        GemmenChoshuYuyoStateKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        GemmenChoshuYuyoStateKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_申請を返す() {
        assertThat(GemmenChoshuYuyoStateKubun.toValue(new RString("0")), is(GemmenChoshuYuyoStateKubun.申請));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_決定_承認を返す() {
        assertThat(GemmenChoshuYuyoStateKubun.toValue(new RString("1")), is(GemmenChoshuYuyoStateKubun.決定_承認));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_決定_不承認を返す() {
        assertThat(GemmenChoshuYuyoStateKubun.toValue(new RString("2")), is(GemmenChoshuYuyoStateKubun.決定_不承認));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_取消を返す() {
        assertThat(GemmenChoshuYuyoStateKubun.toValue(new RString("3")), is(GemmenChoshuYuyoStateKubun.取消));
    }

    @Test
    public void 引数に9を指定した場合_toValueは_論理削除を返す() {
        assertThat(GemmenChoshuYuyoStateKubun.toValue(new RString("9")), is(GemmenChoshuYuyoStateKubun.論理削除));
    }

    @Test
    public void 申請を指定した場合_getコードは_0を返す() {
        assertThat(GemmenChoshuYuyoStateKubun.申請.getコード(), is(new RString("0")));
    }

    @Test
    public void 決定_承認を指定した場合_getコードは_1を返す() {
        assertThat(GemmenChoshuYuyoStateKubun.決定_承認.getコード(), is(new RString("1")));
    }

    @Test
    public void 決定_不承認を指定した場合_getコードは_2を返す() {
        assertThat(GemmenChoshuYuyoStateKubun.決定_不承認.getコード(), is(new RString("2")));
    }

    @Test
    public void 取消を指定した場合_getコードは_3を返す() {
        assertThat(GemmenChoshuYuyoStateKubun.取消.getコード(), is(new RString("3")));
    }

    @Test
    public void 論理削除を指定した場合_getコードは_9を返す() {
        assertThat(GemmenChoshuYuyoStateKubun.論理削除.getコード(), is(new RString("9")));
    }

    @Test
    public void 申請を指定した場合_get名称は_申請を返す() {
        assertThat(GemmenChoshuYuyoStateKubun.申請.get名称(), is(new RString("申請")));
    }

    @Test
    public void 決定_承認を指定した場合_get名称は_決定_承認を返す() {
        assertThat(GemmenChoshuYuyoStateKubun.決定_承認.get名称(), is(new RString("決定_承認")));
    }

    @Test
    public void 決定_不承認を指定した場合_get名称は_決定_不承認を返す() {
        assertThat(GemmenChoshuYuyoStateKubun.決定_不承認.get名称(), is(new RString("決定_不承認")));
    }

    @Test
    public void 取消を指定した場合_get名称は_取消を返す() {
        assertThat(GemmenChoshuYuyoStateKubun.取消.get名称(), is(new RString("取消")));
    }

    @Test
    public void 論理削除を指定した場合_get名称は_論理削除を返す() {
        assertThat(GemmenChoshuYuyoStateKubun.論理削除.get名称(), is(new RString("論理削除")));
    }

}
