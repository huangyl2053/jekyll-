package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 住所編集区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class JushoHenshuKubunTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        JushoHenshuKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        JushoHenshuKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_市町村共通を返す() {
        assertThat(JushoHenshuKubun.toValue(new RString("0")), is(JushoHenshuKubun.市町村共通));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_帳票独自を返す() {
        assertThat(JushoHenshuKubun.toValue(new RString("1")), is(JushoHenshuKubun.帳票独自));
    }

    @Test
    public void 市町村共通を指定した場合_getコードは_0を返す() {
        assertThat(JushoHenshuKubun.市町村共通.getコード(), is(new RString("0")));
    }

    @Test
    public void 帳票独自を指定した場合_getコードは_1を返す() {
        assertThat(JushoHenshuKubun.帳票独自.getコード(), is(new RString("1")));
    }

    @Test
    public void 市町村共通を指定した場合_get名称は_市町村共通を返す() {
        assertThat(JushoHenshuKubun.市町村共通.get名称(), is(new RString("市町村共通")));
    }

    @Test
    public void 帳票独自を指定した場合_get名称は_帳票独自を返す() {
        assertThat(JushoHenshuKubun.帳票独自.get名称(), is(new RString("帳票独自")));
    }

}
