package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 支払方法変更差止控除状態区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShiharaiHenkoSashitomeKojoJotaiKubunTest extends DbdTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShiharaiHenkoSashitomeKojoJotaiKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShiharaiHenkoSashitomeKojoJotaiKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_登録を返す() {
        assertThat(ShiharaiHenkoSashitomeKojoJotaiKubun.toValue(new RString("01")), is(ShiharaiHenkoSashitomeKojoJotaiKubun.登録));
    }

    @Test
    public void 引数に99を指定した場合_toValueは_解除を返す() {
        assertThat(ShiharaiHenkoSashitomeKojoJotaiKubun.toValue(new RString("99")), is(ShiharaiHenkoSashitomeKojoJotaiKubun.解除));
    }

    @Test
    public void 登録を指定した場合_getコードは_01を返す() {
        assertThat(ShiharaiHenkoSashitomeKojoJotaiKubun.登録.getコード(), is(new RString("01")));
    }

    @Test
    public void 解除を指定した場合_getコードは_99を返す() {
        assertThat(ShiharaiHenkoSashitomeKojoJotaiKubun.解除.getコード(), is(new RString("99")));
    }

    @Test
    public void 登録を指定した場合_get名称は_登録を返す() {
        assertThat(ShiharaiHenkoSashitomeKojoJotaiKubun.登録.get名称(), is(new RString("登録")));
    }

    @Test
    public void 解除を指定した場合_get名称は_解除を返す() {
        assertThat(ShiharaiHenkoSashitomeKojoJotaiKubun.解除.get名称(), is(new RString("解除")));
    }

}
