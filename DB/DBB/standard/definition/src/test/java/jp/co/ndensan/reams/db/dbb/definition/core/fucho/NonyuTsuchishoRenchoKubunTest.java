package jp.co.ndensan.reams.db.dbb.definition.core.fucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 納入通知書連帳区分のテストクラスです。
 *
 * @author LDNS
 */
public class NonyuTsuchishoRenchoKubunTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        NonyuTsuchishoRenchoKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        NonyuTsuchishoRenchoKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_カット紙を返す() {
        assertThat(NonyuTsuchishoRenchoKubun.toValue(new RString("0")), is(NonyuTsuchishoRenchoKubun.カット紙));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_連帳を返す() {
        assertThat(NonyuTsuchishoRenchoKubun.toValue(new RString("1")), is(NonyuTsuchishoRenchoKubun.連帳));
    }

    @Test
    public void カット紙を指定した場合_getコードは_0を返す() {
        assertThat(NonyuTsuchishoRenchoKubun.カット紙.getコード(), is(new RString("0")));
    }

    @Test
    public void 連帳を指定した場合_getコードは_1を返す() {
        assertThat(NonyuTsuchishoRenchoKubun.連帳.getコード(), is(new RString("1")));
    }

    @Test
    public void カット紙を指定した場合_get名称は_カット紙を返す() {
        assertThat(NonyuTsuchishoRenchoKubun.カット紙.get名称(), is(new RString("カット紙")));
    }

    @Test
    public void 連帳を指定した場合_get名称は_連帳を返す() {
        assertThat(NonyuTsuchishoRenchoKubun.連帳.get名称(), is(new RString("連帳")));
    }

}
