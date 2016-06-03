package jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 支払方法区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShiharaiHohoKubunTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShiharaiHohoKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShiharaiHohoKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_窓口払を返す() {
        assertThat(ShiharaiHohoKubun.toValue(new RString("1")), is(ShiharaiHohoKubun.窓口払));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_口座払を返す() {
        assertThat(ShiharaiHohoKubun.toValue(new RString("2")), is(ShiharaiHohoKubun.口座払));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_受領委任払を返す() {
        assertThat(ShiharaiHohoKubun.toValue(new RString("3")), is(ShiharaiHohoKubun.受領委任払));
    }

    @Test
    public void 窓口払を指定した場合_getコードは_1を返す() {
        assertThat(ShiharaiHohoKubun.窓口払.getコード(), is(new RString("1")));
    }

    @Test
    public void 口座払を指定した場合_getコードは_2を返す() {
        assertThat(ShiharaiHohoKubun.口座払.getコード(), is(new RString("2")));
    }

    @Test
    public void 受領委任払を指定した場合_getコードは_3を返す() {
        assertThat(ShiharaiHohoKubun.受領委任払.getコード(), is(new RString("3")));
    }

    @Test
    public void 窓口払を指定した場合_get名称は_窓口払を返す() {
        assertThat(ShiharaiHohoKubun.窓口払.get名称(), is(new RString("窓口払")));
    }

    @Test
    public void 口座払を指定した場合_get名称は_口座払を返す() {
        assertThat(ShiharaiHohoKubun.口座払.get名称(), is(new RString("口座払")));
    }

    @Test
    public void 受領委任払を指定した場合_get名称は_受領委任払を返す() {
        assertThat(ShiharaiHohoKubun.受領委任払.get名称(), is(new RString("受領委任払")));
    }

}
