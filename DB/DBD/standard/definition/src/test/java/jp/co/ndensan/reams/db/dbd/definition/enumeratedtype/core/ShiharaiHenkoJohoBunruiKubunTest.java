package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 支払方法変更情報分類区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShiharaiHenkoJohoBunruiKubunTest extends DbdTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShiharaiHenkoJohoBunruiKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShiharaiHenkoJohoBunruiKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_差止情報を返す() {
        assertThat(ShiharaiHenkoJohoBunruiKubun.toValue(new RString("1")), is(ShiharaiHenkoJohoBunruiKubun.差止情報));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_保険料控除情報を返す() {
        assertThat(ShiharaiHenkoJohoBunruiKubun.toValue(new RString("2")), is(ShiharaiHenkoJohoBunruiKubun.保険料控除情報));
    }

    @Test
    public void 差止情報を指定した場合_getコードは_1を返す() {
        assertThat(ShiharaiHenkoJohoBunruiKubun.差止情報.getコード(), is(new RString("1")));
    }

    @Test
    public void 保険料控除情報を指定した場合_getコードは_2を返す() {
        assertThat(ShiharaiHenkoJohoBunruiKubun.保険料控除情報.getコード(), is(new RString("2")));
    }

    @Test
    public void 差止情報を指定した場合_get名称は_差止情報を返す() {
        assertThat(ShiharaiHenkoJohoBunruiKubun.差止情報.get名称(), is(new RString("差止情報")));
    }

    @Test
    public void 保険料控除情報を指定した場合_get名称は_保険料控除情報を返す() {
        assertThat(ShiharaiHenkoJohoBunruiKubun.保険料控除情報.get名称(), is(new RString("保険料控除情報")));
    }

}
