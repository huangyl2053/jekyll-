package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 境界層区分のテストクラスです。
 *
 * @author LDNS
 */
public class KyokaisoKubunTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KyokaisoKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KyokaisoKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_非該当を返す() {
        assertThat(KyokaisoKubun.toValue(new RString("0")), is(KyokaisoKubun.非該当));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_該当を返す() {
        assertThat(KyokaisoKubun.toValue(new RString("1")), is(KyokaisoKubun.該当));
    }

    @Test
    public void 非該当を指定した場合_getコードは_0を返す() {
        assertThat(KyokaisoKubun.非該当.getコード(), is(new RString("0")));
    }

    @Test
    public void 該当を指定した場合_getコードは_1を返す() {
        assertThat(KyokaisoKubun.該当.getコード(), is(new RString("1")));
    }

    @Test
    public void 非該当を指定した場合_get名称は_非該当を返す() {
        assertThat(KyokaisoKubun.非該当.get名称(), is(new RString("非該当")));
    }

    @Test
    public void 該当を指定した場合_get名称は_該当を返す() {
        assertThat(KyokaisoKubun.該当.get名称(), is(new RString("該当")));
    }

}
