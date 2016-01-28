package jp.co.ndensan.reams.db.dba.definition.core.jogaiidojiyu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 除外解除事由のテストクラスです。
 *
 */
public class JogaiKaijoJiyuTest extends DbaTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        JogaiKaijoJiyu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        JogaiKaijoJiyu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に51を指定した場合_toValueは_除外者解除を返す() {
        assertThat(JogaiKaijoJiyu.toValue(new RString("51")), is(JogaiKaijoJiyu.除外者解除));
    }

    @Test
    public void 引数に52を指定した場合_toValueは_除外者転出を返す() {
        assertThat(JogaiKaijoJiyu.toValue(new RString("52")), is(JogaiKaijoJiyu.除外者転出));
    }

    @Test
    public void 引数に53を指定した場合_toValueは_除外者死亡を返す() {
        assertThat(JogaiKaijoJiyu.toValue(new RString("53")), is(JogaiKaijoJiyu.除外者死亡));
    }

    @Test
    public void 引数に58を指定した場合_toValueは_職権解除を返す() {
        assertThat(JogaiKaijoJiyu.toValue(new RString("58")), is(JogaiKaijoJiyu.職権解除));
    }

    @Test
    public void 引数に99を指定した場合_toValueは_その他を返す() {
        assertThat(JogaiKaijoJiyu.toValue(new RString("99")), is(JogaiKaijoJiyu.その他));
    }

    @Test
    public void 除外者解除を指定した場合_getコードは_51を返す() {
        assertThat(JogaiKaijoJiyu.除外者解除.getコード(), is(new RString("51")));
    }

    @Test
    public void 除外者転出を指定した場合_getコードは_52を返す() {
        assertThat(JogaiKaijoJiyu.除外者転出.getコード(), is(new RString("52")));
    }

    @Test
    public void 除外者死亡を指定した場合_getコードは_53を返す() {
        assertThat(JogaiKaijoJiyu.除外者死亡.getコード(), is(new RString("53")));
    }

    @Test
    public void 職権解除を指定した場合_getコードは_58を返す() {
        assertThat(JogaiKaijoJiyu.職権解除.getコード(), is(new RString("58")));
    }

    @Test
    public void その他を指定した場合_getコードは_99を返す() {
        assertThat(JogaiKaijoJiyu.その他.getコード(), is(new RString("99")));
    }

    @Test
    public void 除外者解除を指定した場合_get名称は_除外者解除を返す() {
        assertThat(JogaiKaijoJiyu.除外者解除.get名称(), is(new RString("除外者解除")));
    }

    @Test
    public void 除外者転出を指定した場合_get名称は_除外者転出を返す() {
        assertThat(JogaiKaijoJiyu.除外者転出.get名称(), is(new RString("除外者転出")));
    }

    @Test
    public void 除外者死亡を指定した場合_get名称は_除外者死亡を返す() {
        assertThat(JogaiKaijoJiyu.除外者死亡.get名称(), is(new RString("除外者死亡")));
    }

    @Test
    public void 職権解除を指定した場合_get名称は_職権解除を返す() {
        assertThat(JogaiKaijoJiyu.職権解除.get名称(), is(new RString("職権解除")));
    }

    @Test
    public void その他を指定した場合_get名称は_その他を返す() {
        assertThat(JogaiKaijoJiyu.その他.get名称(), is(new RString("その他")));
    }

}
