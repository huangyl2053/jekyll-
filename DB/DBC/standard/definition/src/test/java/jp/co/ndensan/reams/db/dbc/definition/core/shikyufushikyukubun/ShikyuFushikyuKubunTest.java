package jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 支給不支給区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShikyuFushikyuKubunTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShikyuFushikyuKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShikyuFushikyuKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_不支給を返す() {
        assertThat(ShikyuFushikyuKubun.toValue(new RString("0")), is(ShikyuFushikyuKubun.不支給));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_支給を返す() {
        assertThat(ShikyuFushikyuKubun.toValue(new RString("1")), is(ShikyuFushikyuKubun.支給));
    }

    @Test
    public void 不支給を指定した場合_getコードは_0を返す() {
        assertThat(ShikyuFushikyuKubun.不支給.getコード(), is(new RString("0")));
    }

    @Test
    public void 支給を指定した場合_getコードは_1を返す() {
        assertThat(ShikyuFushikyuKubun.支給.getコード(), is(new RString("1")));
    }

    @Test
    public void 不支給を指定した場合_get名称は_不支給を返す() {
        assertThat(ShikyuFushikyuKubun.不支給.get名称(), is(new RString("不支給")));
    }

    @Test
    public void 支給を指定した場合_get名称は_支給を返す() {
        assertThat(ShikyuFushikyuKubun.支給.get名称(), is(new RString("支給")));
    }

}
