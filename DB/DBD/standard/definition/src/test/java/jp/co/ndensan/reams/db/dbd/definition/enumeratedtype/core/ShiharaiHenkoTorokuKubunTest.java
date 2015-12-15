package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 支払方法変更登録区分のテストクラスです。
 *
 * @author LDNS
 */
public class ShiharaiHenkoTorokuKubunTest extends DbdTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShiharaiHenkoTorokuKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShiharaiHenkoTorokuKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_２号予告登録者を返す() {
        assertThat(ShiharaiHenkoTorokuKubun.toValue(new RString("01")), is(ShiharaiHenkoTorokuKubun._２号予告登録者));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_２号差止登録を返す() {
        assertThat(ShiharaiHenkoTorokuKubun.toValue(new RString("02")), is(ShiharaiHenkoTorokuKubun._２号差止登録));
    }

    @Test
    public void 引数に11を指定した場合_toValueは_１号予告登録者を返す() {
        assertThat(ShiharaiHenkoTorokuKubun.toValue(new RString("11")), is(ShiharaiHenkoTorokuKubun._１号予告登録者));
    }

    @Test
    public void 引数に12を指定した場合_toValueは_１号償還払い化登録を返す() {
        assertThat(ShiharaiHenkoTorokuKubun.toValue(new RString("12")), is(ShiharaiHenkoTorokuKubun._１号償還払い化登録));
    }

    @Test
    public void 引数に21を指定した場合_toValueは_１号給付額減額登録を返す() {
        assertThat(ShiharaiHenkoTorokuKubun.toValue(new RString("21")), is(ShiharaiHenkoTorokuKubun._１号給付額減額登録));
    }

    @Test
    public void _２号予告登録者を指定した場合_getコードは_01を返す() {
        assertThat(ShiharaiHenkoTorokuKubun._２号予告登録者.getコード(), is(new RString("01")));
    }

    @Test
    public void _２号差止登録を指定した場合_getコードは_02を返す() {
        assertThat(ShiharaiHenkoTorokuKubun._２号差止登録.getコード(), is(new RString("02")));
    }

    @Test
    public void _１号予告登録者を指定した場合_getコードは_11を返す() {
        assertThat(ShiharaiHenkoTorokuKubun._１号予告登録者.getコード(), is(new RString("11")));
    }

    @Test
    public void _１号償還払い化登録を指定した場合_getコードは_12を返す() {
        assertThat(ShiharaiHenkoTorokuKubun._１号償還払い化登録.getコード(), is(new RString("12")));
    }

    @Test
    public void _１号給付額減額登録を指定した場合_getコードは_21を返す() {
        assertThat(ShiharaiHenkoTorokuKubun._１号給付額減額登録.getコード(), is(new RString("21")));
    }

    @Test
    public void _２号予告登録者を指定した場合_get名称は_２号予告登録者を返す() {
        assertThat(ShiharaiHenkoTorokuKubun._２号予告登録者.get名称(), is(new RString("２号予告登録者")));
    }

    @Test
    public void _２号差止登録を指定した場合_get名称は_２号差止登録を返す() {
        assertThat(ShiharaiHenkoTorokuKubun._２号差止登録.get名称(), is(new RString("２号差止登録")));
    }

    @Test
    public void _１号予告登録者を指定した場合_get名称は_１号予告登録者を返す() {
        assertThat(ShiharaiHenkoTorokuKubun._１号予告登録者.get名称(), is(new RString("１号予告登録者")));
    }

    @Test
    public void _１号償還払い化登録を指定した場合_get名称は_１号償還払い化登録を返す() {
        assertThat(ShiharaiHenkoTorokuKubun._１号償還払い化登録.get名称(), is(new RString("１号償還払い化登録")));
    }

    @Test
    public void _１号給付額減額登録を指定した場合_get名称は_１号給付額減額登録を返す() {
        assertThat(ShiharaiHenkoTorokuKubun._１号給付額減額登録.get名称(), is(new RString("１号給付額減額登録")));
    }

}
