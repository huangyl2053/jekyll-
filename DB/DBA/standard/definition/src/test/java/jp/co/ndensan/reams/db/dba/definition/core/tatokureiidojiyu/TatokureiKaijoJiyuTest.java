package jp.co.ndensan.reams.db.dba.definition.core.tatokureiidojiyu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 他特例解除事由のテストクラスです。
 *
 */
public class TatokureiKaijoJiyuTest extends DbaTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TatokureiKaijoJiyu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TatokureiKaijoJiyu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に51を指定した場合_toValueは_他特例解除を返す() {
        assertThat(TatokureiKaijoJiyu.toValue(new RString("51")), is(TatokureiKaijoJiyu.他特例解除));
    }

    @Test
    public void 引数に52を指定した場合_toValueは_他特例転出を返す() {
        assertThat(TatokureiKaijoJiyu.toValue(new RString("52")), is(TatokureiKaijoJiyu.他特例転出));
    }

    @Test
    public void 引数に53を指定した場合_toValueは_他特例死亡を返す() {
        assertThat(TatokureiKaijoJiyu.toValue(new RString("53")), is(TatokureiKaijoJiyu.他特例死亡));
    }

    @Test
    public void 引数に58を指定した場合_toValueは_職権解除を返す() {
        assertThat(TatokureiKaijoJiyu.toValue(new RString("58")), is(TatokureiKaijoJiyu.職権解除));
    }

    @Test
    public void 引数に99を指定した場合_toValueは_その他を返す() {
        assertThat(TatokureiKaijoJiyu.toValue(new RString("99")), is(TatokureiKaijoJiyu.その他));
    }

    @Test
    public void 他特例解除を指定した場合_getコードは_51を返す() {
        assertThat(TatokureiKaijoJiyu.他特例解除.getコード(), is(new RString("51")));
    }

    @Test
    public void 他特例転出を指定した場合_getコードは_52を返す() {
        assertThat(TatokureiKaijoJiyu.他特例転出.getコード(), is(new RString("52")));
    }

    @Test
    public void 他特例死亡を指定した場合_getコードは_53を返す() {
        assertThat(TatokureiKaijoJiyu.他特例死亡.getコード(), is(new RString("53")));
    }

    @Test
    public void 職権解除を指定した場合_getコードは_58を返す() {
        assertThat(TatokureiKaijoJiyu.職権解除.getコード(), is(new RString("58")));
    }

    @Test
    public void その他を指定した場合_getコードは_99を返す() {
        assertThat(TatokureiKaijoJiyu.その他.getコード(), is(new RString("99")));
    }

    @Test
    public void 他特例解除を指定した場合_get名称は_他特例解除を返す() {
        assertThat(TatokureiKaijoJiyu.他特例解除.get名称(), is(new RString("他特例解除")));
    }

    @Test
    public void 他特例転出を指定した場合_get名称は_他特例転出を返す() {
        assertThat(TatokureiKaijoJiyu.他特例転出.get名称(), is(new RString("他特例転出")));
    }

    @Test
    public void 他特例死亡を指定した場合_get名称は_他特例死亡を返す() {
        assertThat(TatokureiKaijoJiyu.他特例死亡.get名称(), is(new RString("他特例死亡")));
    }

    @Test
    public void 職権解除を指定した場合_get名称は_職権解除を返す() {
        assertThat(TatokureiKaijoJiyu.職権解除.get名称(), is(new RString("職権解除")));
    }

    @Test
    public void その他を指定した場合_get名称は_その他を返す() {
        assertThat(TatokureiKaijoJiyu.その他.get名称(), is(new RString("その他")));
    }

}
