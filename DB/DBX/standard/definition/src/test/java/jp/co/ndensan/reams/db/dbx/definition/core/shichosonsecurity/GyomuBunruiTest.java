package jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity;

import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 業務分類のテストクラスです。
 *
 */
public class GyomuBunruiTest extends DbxTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        GyomuBunrui.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        GyomuBunrui.toValue(new RString("99999"));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_介護事務を返す() {
        assertThat(GyomuBunrui.toValue(new RString("無し")), is(GyomuBunrui.介護事務));
    }

    @Test
    public void 介護事務を指定した場合_getコードは_無しを返す() {
        assertThat(GyomuBunrui.介護事務.getコード(), is(new RString("無し")));
    }

    @Test
    public void 介護事務を指定した場合_get名称は_介護事務を返す() {
        assertThat(GyomuBunrui.介護事務.get名称(), is(new RString("介護事務")));
    }

}
