package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 自動割当除外者区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class JidoWariateJyogaishaKubunTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        JidoWariateJyogaishaKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        JidoWariateJyogaishaKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_対象を返す() {
        assertThat(JidoWariateJyogaishaKubun.toValue(new RString("1")), is(JidoWariateJyogaishaKubun.対象));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_除外を返す() {
        assertThat(JidoWariateJyogaishaKubun.toValue(new RString("2")), is(JidoWariateJyogaishaKubun.除外));
    }

    @Test
    public void 対象を指定した場合_getコードは_1を返す() {
        assertThat(JidoWariateJyogaishaKubun.対象.getコード(), is(new RString("1")));
    }

    @Test
    public void 除外を指定した場合_getコードは_2を返す() {
        assertThat(JidoWariateJyogaishaKubun.除外.getコード(), is(new RString("2")));
    }

    @Test
    public void 対象を指定した場合_get名称は_対象を返す() {
        assertThat(JidoWariateJyogaishaKubun.対象.get名称(), is(new RString("対象")));
    }

    @Test
    public void 除外を指定した場合_get名称は_除外を返す() {
        assertThat(JidoWariateJyogaishaKubun.除外.get名称(), is(new RString("除外")));
    }

}
