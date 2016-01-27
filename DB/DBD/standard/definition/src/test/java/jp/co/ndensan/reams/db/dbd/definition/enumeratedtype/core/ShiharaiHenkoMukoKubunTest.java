package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 支払方法変更無効区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShiharaiHenkoMukoKubunTest extends DbdTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShiharaiHenkoMukoKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShiharaiHenkoMukoKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_有効を返す() {
        assertThat(ShiharaiHenkoMukoKubun.toValue(new RString("0")), is(ShiharaiHenkoMukoKubun.有効));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_無効を返す() {
        assertThat(ShiharaiHenkoMukoKubun.toValue(new RString("1")), is(ShiharaiHenkoMukoKubun.無効));
    }

    @Test
    public void 有効を指定した場合_getコードは_0を返す() {
        assertThat(ShiharaiHenkoMukoKubun.有効.getコード(), is(new RString("0")));
    }

    @Test
    public void 無効を指定した場合_getコードは_1を返す() {
        assertThat(ShiharaiHenkoMukoKubun.無効.getコード(), is(new RString("1")));
    }

    @Test
    public void 有効を指定した場合_get名称は_有効を返す() {
        assertThat(ShiharaiHenkoMukoKubun.有効.get名称(), is(new RString("有効")));
    }

    @Test
    public void 無効を指定した場合_get名称は_無効を返す() {
        assertThat(ShiharaiHenkoMukoKubun.無効.get名称(), is(new RString("無効")));
    }

}
