package jp.co.ndensan.reams.db.dbc.definition.core.shikyushinseishinsa;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 支給申請審査区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShikyushinseiShinsaKubunTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShikyushinseiShinsaKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShikyushinseiShinsaKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_未審査を返す() {
        assertThat(ShikyushinseiShinsaKubun.toValue(new RString("1")), is(ShikyushinseiShinsaKubun.未審査));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_審査済を返す() {
        assertThat(ShikyushinseiShinsaKubun.toValue(new RString("2")), is(ShikyushinseiShinsaKubun.審査済));
    }

    @Test
    public void 未審査を指定した場合_getコードは_1を返す() {
        assertThat(ShikyushinseiShinsaKubun.未審査.getコード(), is(new RString("1")));
    }

    @Test
    public void 審査済を指定した場合_getコードは_2を返す() {
        assertThat(ShikyushinseiShinsaKubun.審査済.getコード(), is(new RString("2")));
    }

    @Test
    public void 未審査を指定した場合_get名称は_未審査を返す() {
        assertThat(ShikyushinseiShinsaKubun.未審査.get名称(), is(new RString("未審査")));
    }

    @Test
    public void 審査済を指定した場合_get名称は_審査済を返す() {
        assertThat(ShikyushinseiShinsaKubun.審査済.get名称(), is(new RString("審査済")));
    }

}
