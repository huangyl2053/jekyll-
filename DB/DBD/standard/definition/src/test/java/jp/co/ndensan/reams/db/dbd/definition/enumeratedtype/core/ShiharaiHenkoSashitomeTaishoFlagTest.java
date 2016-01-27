package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 支払方法変更差止対象フラグのテストクラスです。
 * 
 * @author LDNS 
 */
public class ShiharaiHenkoSashitomeTaishoFlagTest extends DbdTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShiharaiHenkoSashitomeTaishoFlag.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShiharaiHenkoSashitomeTaishoFlag.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_差止対象外を返す() {
        assertThat(ShiharaiHenkoSashitomeTaishoFlag.toValue(new RString("0")), is(ShiharaiHenkoSashitomeTaishoFlag.差止対象外));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_差止対象を返す() {
        assertThat(ShiharaiHenkoSashitomeTaishoFlag.toValue(new RString("1")), is(ShiharaiHenkoSashitomeTaishoFlag.差止対象));
    }

    @Test
    public void 差止対象外を指定した場合_getコードは_0を返す() {
        assertThat(ShiharaiHenkoSashitomeTaishoFlag.差止対象外.getコード(), is(new RString("0")));
    }

    @Test
    public void 差止対象を指定した場合_getコードは_1を返す() {
        assertThat(ShiharaiHenkoSashitomeTaishoFlag.差止対象.getコード(), is(new RString("1")));
    }

    @Test
    public void 差止対象外を指定した場合_get名称は_差止対象外を返す() {
        assertThat(ShiharaiHenkoSashitomeTaishoFlag.差止対象外.get名称(), is(new RString("差止対象外")));
    }

    @Test
    public void 差止対象を指定した場合_get名称は_差止対象を返す() {
        assertThat(ShiharaiHenkoSashitomeTaishoFlag.差止対象.get名称(), is(new RString("差止対象")));
    }

}
