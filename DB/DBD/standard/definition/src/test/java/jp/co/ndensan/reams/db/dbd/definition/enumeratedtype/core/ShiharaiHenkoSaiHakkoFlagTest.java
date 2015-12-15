package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 支払方法変更再発行フラグのテストクラスです。
 * 
 * @author LDNS 
 */
public class ShiharaiHenkoSaiHakkoFlagTest extends DbdTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShiharaiHenkoSaiHakkoFlag.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShiharaiHenkoSaiHakkoFlag.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_再発行対象外を返す() {
        assertThat(ShiharaiHenkoSaiHakkoFlag.toValue(new RString("0")), is(ShiharaiHenkoSaiHakkoFlag.再発行対象外));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_再発行対象を返す() {
        assertThat(ShiharaiHenkoSaiHakkoFlag.toValue(new RString("1")), is(ShiharaiHenkoSaiHakkoFlag.再発行対象));
    }

    @Test
    public void 再発行対象外を指定した場合_getコードは_0を返す() {
        assertThat(ShiharaiHenkoSaiHakkoFlag.再発行対象外.getコード(), is(new RString("0")));
    }

    @Test
    public void 再発行対象を指定した場合_getコードは_1を返す() {
        assertThat(ShiharaiHenkoSaiHakkoFlag.再発行対象.getコード(), is(new RString("1")));
    }

    @Test
    public void 再発行対象外を指定した場合_get名称は_再発行対象外を返す() {
        assertThat(ShiharaiHenkoSaiHakkoFlag.再発行対象外.get名称(), is(new RString("再発行対象外")));
    }

    @Test
    public void 再発行対象を指定した場合_get名称は_再発行対象を返す() {
        assertThat(ShiharaiHenkoSaiHakkoFlag.再発行対象.get名称(), is(new RString("再発行対象")));
    }

}
