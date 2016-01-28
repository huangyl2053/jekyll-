package jp.co.ndensan.reams.db.dba.definition.core.idolistidojoho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 異動リスト異動情報区分のテストクラスです。
 *
 */
public class IdoListIdojohoKubunTest extends DbaTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        IdoListIdojohoKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        IdoListIdojohoKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に101を指定した場合_toValueは_取得異動を返す() {
        assertThat(IdoListIdojohoKubun.toValue(new RString("101")), is(IdoListIdojohoKubun.取得異動));
    }

    @Test
    public void 引数に102を指定した場合_toValueは_喪失異動を返す() {
        assertThat(IdoListIdojohoKubun.toValue(new RString("102")), is(IdoListIdojohoKubun.喪失異動));
    }

    @Test
    public void 引数に103を指定した場合_toValueは_変更移動を返す() {
        assertThat(IdoListIdojohoKubun.toValue(new RString("103")), is(IdoListIdojohoKubun.変更移動));
    }

    @Test
    public void 引数に104を指定した場合_toValueは_住特適用異動を返す() {
        assertThat(IdoListIdojohoKubun.toValue(new RString("104")), is(IdoListIdojohoKubun.住特適用異動));
    }

    @Test
    public void 引数に105を指定した場合_toValueは_住特解除異動を返す() {
        assertThat(IdoListIdojohoKubun.toValue(new RString("105")), is(IdoListIdojohoKubun.住特解除異動));
    }

    @Test
    public void 引数に106を指定した場合_toValueは_適用異動を返す() {
        assertThat(IdoListIdojohoKubun.toValue(new RString("106")), is(IdoListIdojohoKubun.適用異動));
    }

    @Test
    public void 引数に107を指定した場合_toValueは_解除異動を返す() {
        assertThat(IdoListIdojohoKubun.toValue(new RString("107")), is(IdoListIdojohoKubun.解除異動));
    }

    @Test
    public void 引数に108を指定した場合_toValueは_入所異動を返す() {
        assertThat(IdoListIdojohoKubun.toValue(new RString("108")), is(IdoListIdojohoKubun.入所異動));
    }

    @Test
    public void 引数に109を指定した場合_toValueは_退所異動を返す() {
        assertThat(IdoListIdojohoKubun.toValue(new RString("109")), is(IdoListIdojohoKubun.退所異動));
    }

    @Test
    public void 引数に110を指定した場合_toValueは_開始異動を返す() {
        assertThat(IdoListIdojohoKubun.toValue(new RString("110")), is(IdoListIdojohoKubun.開始異動));
    }

    @Test
    public void 引数に111を指定した場合_toValueは_廃止異動を返す() {
        assertThat(IdoListIdojohoKubun.toValue(new RString("111")), is(IdoListIdojohoKubun.廃止異動));
    }

    @Test
    public void 引数に112を指定した場合_toValueは_終了異動を返す() {
        assertThat(IdoListIdojohoKubun.toValue(new RString("112")), is(IdoListIdojohoKubun.終了異動));
    }

    @Test
    public void 引数に201を指定した場合_toValueは_取得削除を返す() {
        assertThat(IdoListIdojohoKubun.toValue(new RString("201")), is(IdoListIdojohoKubun.取得削除));
    }

    @Test
    public void 引数に202を指定した場合_toValueは_喪失削除を返す() {
        assertThat(IdoListIdojohoKubun.toValue(new RString("202")), is(IdoListIdojohoKubun.喪失削除));
    }

    @Test
    public void 引数に203を指定した場合_toValueは_変更削除を返す() {
        assertThat(IdoListIdojohoKubun.toValue(new RString("203")), is(IdoListIdojohoKubun.変更削除));
    }

    @Test
    public void 引数に204を指定した場合_toValueは_住特適用削除を返す() {
        assertThat(IdoListIdojohoKubun.toValue(new RString("204")), is(IdoListIdojohoKubun.住特適用削除));
    }

    @Test
    public void 引数に205を指定した場合_toValueは_住特解除削除を返す() {
        assertThat(IdoListIdojohoKubun.toValue(new RString("205")), is(IdoListIdojohoKubun.住特解除削除));
    }

    @Test
    public void 引数に206を指定した場合_toValueは_適用削除を返す() {
        assertThat(IdoListIdojohoKubun.toValue(new RString("206")), is(IdoListIdojohoKubun.適用削除));
    }

    @Test
    public void 引数に207を指定した場合_toValueは_解除削除を返す() {
        assertThat(IdoListIdojohoKubun.toValue(new RString("207")), is(IdoListIdojohoKubun.解除削除));
    }

    @Test
    public void 引数に301を指定した場合_toValueは_広域内転居を返す() {
        assertThat(IdoListIdojohoKubun.toValue(new RString("301")), is(IdoListIdojohoKubun.広域内転居));
    }

    @Test
    public void 取得異動を指定した場合_getコードは_101を返す() {
        assertThat(IdoListIdojohoKubun.取得異動.getコード(), is(new RString("101")));
    }

    @Test
    public void 喪失異動を指定した場合_getコードは_102を返す() {
        assertThat(IdoListIdojohoKubun.喪失異動.getコード(), is(new RString("102")));
    }

    @Test
    public void 変更移動を指定した場合_getコードは_103を返す() {
        assertThat(IdoListIdojohoKubun.変更移動.getコード(), is(new RString("103")));
    }

    @Test
    public void 住特適用異動を指定した場合_getコードは_104を返す() {
        assertThat(IdoListIdojohoKubun.住特適用異動.getコード(), is(new RString("104")));
    }

    @Test
    public void 住特解除異動を指定した場合_getコードは_105を返す() {
        assertThat(IdoListIdojohoKubun.住特解除異動.getコード(), is(new RString("105")));
    }

    @Test
    public void 適用異動を指定した場合_getコードは_106を返す() {
        assertThat(IdoListIdojohoKubun.適用異動.getコード(), is(new RString("106")));
    }

    @Test
    public void 解除異動を指定した場合_getコードは_107を返す() {
        assertThat(IdoListIdojohoKubun.解除異動.getコード(), is(new RString("107")));
    }

    @Test
    public void 入所異動を指定した場合_getコードは_108を返す() {
        assertThat(IdoListIdojohoKubun.入所異動.getコード(), is(new RString("108")));
    }

    @Test
    public void 退所異動を指定した場合_getコードは_109を返す() {
        assertThat(IdoListIdojohoKubun.退所異動.getコード(), is(new RString("109")));
    }

    @Test
    public void 開始異動を指定した場合_getコードは_110を返す() {
        assertThat(IdoListIdojohoKubun.開始異動.getコード(), is(new RString("110")));
    }

    @Test
    public void 廃止異動を指定した場合_getコードは_111を返す() {
        assertThat(IdoListIdojohoKubun.廃止異動.getコード(), is(new RString("111")));
    }

    @Test
    public void 終了異動を指定した場合_getコードは_112を返す() {
        assertThat(IdoListIdojohoKubun.終了異動.getコード(), is(new RString("112")));
    }

    @Test
    public void 取得削除を指定した場合_getコードは_201を返す() {
        assertThat(IdoListIdojohoKubun.取得削除.getコード(), is(new RString("201")));
    }

    @Test
    public void 喪失削除を指定した場合_getコードは_202を返す() {
        assertThat(IdoListIdojohoKubun.喪失削除.getコード(), is(new RString("202")));
    }

    @Test
    public void 変更削除を指定した場合_getコードは_203を返す() {
        assertThat(IdoListIdojohoKubun.変更削除.getコード(), is(new RString("203")));
    }

    @Test
    public void 住特適用削除を指定した場合_getコードは_204を返す() {
        assertThat(IdoListIdojohoKubun.住特適用削除.getコード(), is(new RString("204")));
    }

    @Test
    public void 住特解除削除を指定した場合_getコードは_205を返す() {
        assertThat(IdoListIdojohoKubun.住特解除削除.getコード(), is(new RString("205")));
    }

    @Test
    public void 適用削除を指定した場合_getコードは_206を返す() {
        assertThat(IdoListIdojohoKubun.適用削除.getコード(), is(new RString("206")));
    }

    @Test
    public void 解除削除を指定した場合_getコードは_207を返す() {
        assertThat(IdoListIdojohoKubun.解除削除.getコード(), is(new RString("207")));
    }

    @Test
    public void 広域内転居を指定した場合_getコードは_301を返す() {
        assertThat(IdoListIdojohoKubun.広域内転居.getコード(), is(new RString("301")));
    }

    @Test
    public void 取得異動を指定した場合_get名称は_取得異動を返す() {
        assertThat(IdoListIdojohoKubun.取得異動.get名称(), is(new RString("取得異動")));
    }

    @Test
    public void 喪失異動を指定した場合_get名称は_喪失異動を返す() {
        assertThat(IdoListIdojohoKubun.喪失異動.get名称(), is(new RString("喪失異動")));
    }

    @Test
    public void 変更移動を指定した場合_get名称は_変更移動を返す() {
        assertThat(IdoListIdojohoKubun.変更移動.get名称(), is(new RString("変更移動")));
    }

    @Test
    public void 住特適用異動を指定した場合_get名称は_住特適用異動を返す() {
        assertThat(IdoListIdojohoKubun.住特適用異動.get名称(), is(new RString("住特適用異動")));
    }

    @Test
    public void 住特解除異動を指定した場合_get名称は_住特解除異動を返す() {
        assertThat(IdoListIdojohoKubun.住特解除異動.get名称(), is(new RString("住特解除異動")));
    }

    @Test
    public void 適用異動を指定した場合_get名称は_適用異動を返す() {
        assertThat(IdoListIdojohoKubun.適用異動.get名称(), is(new RString("適用異動")));
    }

    @Test
    public void 解除異動を指定した場合_get名称は_解除異動を返す() {
        assertThat(IdoListIdojohoKubun.解除異動.get名称(), is(new RString("解除異動")));
    }

    @Test
    public void 入所異動を指定した場合_get名称は_入所異動を返す() {
        assertThat(IdoListIdojohoKubun.入所異動.get名称(), is(new RString("入所異動")));
    }

    @Test
    public void 退所異動を指定した場合_get名称は_退所異動を返す() {
        assertThat(IdoListIdojohoKubun.退所異動.get名称(), is(new RString("退所異動")));
    }

    @Test
    public void 開始異動を指定した場合_get名称は_開始異動を返す() {
        assertThat(IdoListIdojohoKubun.開始異動.get名称(), is(new RString("開始異動")));
    }

    @Test
    public void 廃止異動を指定した場合_get名称は_廃止異動を返す() {
        assertThat(IdoListIdojohoKubun.廃止異動.get名称(), is(new RString("廃止異動")));
    }

    @Test
    public void 終了異動を指定した場合_get名称は_終了異動を返す() {
        assertThat(IdoListIdojohoKubun.終了異動.get名称(), is(new RString("終了異動")));
    }

    @Test
    public void 取得削除を指定した場合_get名称は_取得削除を返す() {
        assertThat(IdoListIdojohoKubun.取得削除.get名称(), is(new RString("取得削除")));
    }

    @Test
    public void 喪失削除を指定した場合_get名称は_喪失削除を返す() {
        assertThat(IdoListIdojohoKubun.喪失削除.get名称(), is(new RString("喪失削除")));
    }

    @Test
    public void 変更削除を指定した場合_get名称は_変更削除を返す() {
        assertThat(IdoListIdojohoKubun.変更削除.get名称(), is(new RString("変更削除")));
    }

    @Test
    public void 住特適用削除を指定した場合_get名称は_住特適用削除を返す() {
        assertThat(IdoListIdojohoKubun.住特適用削除.get名称(), is(new RString("住特適用削除")));
    }

    @Test
    public void 住特解除削除を指定した場合_get名称は_住特解除削除を返す() {
        assertThat(IdoListIdojohoKubun.住特解除削除.get名称(), is(new RString("住特解除削除")));
    }

    @Test
    public void 適用削除を指定した場合_get名称は_適用削除を返す() {
        assertThat(IdoListIdojohoKubun.適用削除.get名称(), is(new RString("適用削除")));
    }

    @Test
    public void 解除削除を指定した場合_get名称は_解除削除を返す() {
        assertThat(IdoListIdojohoKubun.解除削除.get名称(), is(new RString("解除削除")));
    }

    @Test
    public void 広域内転居を指定した場合_get名称は_広域内転居を返す() {
        assertThat(IdoListIdojohoKubun.広域内転居.get名称(), is(new RString("広域内転居")));
    }

}
