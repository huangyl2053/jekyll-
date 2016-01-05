package jp.co.ndensan.reams.db.dba.definition.core.tatokureiidojiyu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 他特例適用事由のテストクラスです。
 */
public class TatokureiTekiyoJiyuTest extends DbaTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TatokureiTekiyoJiyu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TatokureiTekiyoJiyu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_他特例適用を返す() {
        assertThat(TatokureiTekiyoJiyu.toValue(new RString("01")), is(TatokureiTekiyoJiyu.他特例適用));
    }

    @Test
    public void 引数に08を指定した場合_toValueは_職権適用を返す() {
        assertThat(TatokureiTekiyoJiyu.toValue(new RString("08")), is(TatokureiTekiyoJiyu.職権適用));
    }

    @Test
    public void 引数に99を指定した場合_toValueは_その他を返す() {
        assertThat(TatokureiTekiyoJiyu.toValue(new RString("99")), is(TatokureiTekiyoJiyu.その他));
    }

    @Test
    public void 他特例適用を指定した場合_getコードは_01を返す() {
        assertThat(TatokureiTekiyoJiyu.他特例適用.getコード(), is(new RString("01")));
    }

    @Test
    public void 職権適用を指定した場合_getコードは_08を返す() {
        assertThat(TatokureiTekiyoJiyu.職権適用.getコード(), is(new RString("08")));
    }

    @Test
    public void その他を指定した場合_getコードは_99を返す() {
        assertThat(TatokureiTekiyoJiyu.その他.getコード(), is(new RString("99")));
    }

    @Test
    public void 他特例適用を指定した場合_get名称は_他特例適用を返す() {
        assertThat(TatokureiTekiyoJiyu.他特例適用.get名称(), is(new RString("他特例適用")));
    }

    @Test
    public void 職権適用を指定した場合_get名称は_職権適用を返す() {
        assertThat(TatokureiTekiyoJiyu.職権適用.get名称(), is(new RString("職権適用")));
    }

    @Test
    public void その他を指定した場合_get名称は_その他を返す() {
        assertThat(TatokureiTekiyoJiyu.その他.get名称(), is(new RString("その他")));
    }

}
