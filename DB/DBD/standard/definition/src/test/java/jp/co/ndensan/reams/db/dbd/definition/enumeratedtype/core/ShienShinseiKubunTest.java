package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 要介護申請・要支援申請の区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShienShinseiKubunTest extends DbdTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShienShinseiKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShienShinseiKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_要介護を返す() {
        assertThat(ShienShinseiKubun.toValue(new RString("1")), is(ShienShinseiKubun.要介護));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_要支援を返す() {
        assertThat(ShienShinseiKubun.toValue(new RString("2")), is(ShienShinseiKubun.要支援));
    }

    @Test
    public void 引数に9を指定した場合_toValueは_不明を返す() {
        assertThat(ShienShinseiKubun.toValue(new RString("9")), is(ShienShinseiKubun.不明));
    }

    @Test
    public void 要介護を指定した場合_getコードは_1を返す() {
        assertThat(ShienShinseiKubun.要介護.getコード(), is(new RString("1")));
    }

    @Test
    public void 要支援を指定した場合_getコードは_2を返す() {
        assertThat(ShienShinseiKubun.要支援.getコード(), is(new RString("2")));
    }

    @Test
    public void 不明を指定した場合_getコードは_9を返す() {
        assertThat(ShienShinseiKubun.不明.getコード(), is(new RString("9")));
    }

    @Test
    public void 要介護を指定した場合_get名称は_要介護を返す() {
        assertThat(ShienShinseiKubun.要介護.get名称(), is(new RString("要介護")));
    }

    @Test
    public void 要支援を指定した場合_get名称は_要支援を返す() {
        assertThat(ShienShinseiKubun.要支援.get名称(), is(new RString("要支援")));
    }

    @Test
    public void 不明を指定した場合_get名称は_不明を返す() {
        assertThat(ShienShinseiKubun.不明.get名称(), is(new RString("不明")));
    }

}
