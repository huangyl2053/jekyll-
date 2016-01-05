package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 支払方法変更管理区分のテストクラスです。
 *
 * @author LDNS
 */
public class ShiharaiHenkoKanriKubunTest extends DbdTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShiharaiHenkoKanriKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShiharaiHenkoKanriKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_２号差止を返す() {
        assertThat(ShiharaiHenkoKanriKubun.toValue(new RString("1")), is(ShiharaiHenkoKanriKubun._２号差止));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_１号償還払い化を返す() {
        assertThat(ShiharaiHenkoKanriKubun.toValue(new RString("2")), is(ShiharaiHenkoKanriKubun._１号償還払い化));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_１号給付額減額を返す() {
        assertThat(ShiharaiHenkoKanriKubun.toValue(new RString("3")), is(ShiharaiHenkoKanriKubun._１号給付額減額));
    }

    @Test
    public void _２号差止を指定した場合_getコードは_1を返す() {
        assertThat(ShiharaiHenkoKanriKubun._２号差止.getコード(), is(new RString("1")));
    }

    @Test
    public void _１号償還払い化を指定した場合_getコードは_2を返す() {
        assertThat(ShiharaiHenkoKanriKubun._１号償還払い化.getコード(), is(new RString("2")));
    }

    @Test
    public void _１号給付額減額を指定した場合_getコードは_3を返す() {
        assertThat(ShiharaiHenkoKanriKubun._１号給付額減額.getコード(), is(new RString("3")));
    }

    @Test
    public void _２号差止を指定した場合_get名称は_２号差止を返す() {
        assertThat(ShiharaiHenkoKanriKubun._２号差止.get名称(), is(new RString("２号差止")));
    }

    @Test
    public void _１号償還払い化を指定した場合_get名称は_１号償還払い化を返す() {
        assertThat(ShiharaiHenkoKanriKubun._１号償還払い化.get名称(), is(new RString("１号償還払い化")));
    }

    @Test
    public void _１号給付額減額を指定した場合_get名称は_１号給付額減額を返す() {
        assertThat(ShiharaiHenkoKanriKubun._１号給付額減額.get名称(), is(new RString("１号給付額減額")));
    }

}
