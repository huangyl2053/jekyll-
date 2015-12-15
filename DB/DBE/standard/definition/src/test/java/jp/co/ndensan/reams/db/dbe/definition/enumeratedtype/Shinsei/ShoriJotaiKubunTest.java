package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 処理状態区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShoriJotaiKubunTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShoriJotaiKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShoriJotaiKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_通常を返す() {
        assertThat(ShoriJotaiKubun.toValue(new RString("0")), is(ShoriJotaiKubun.通常));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_取下を返す() {
        assertThat(ShoriJotaiKubun.toValue(new RString("1")), is(ShoriJotaiKubun.取下));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_却下を返す() {
        assertThat(ShoriJotaiKubun.toValue(new RString("2")), is(ShoriJotaiKubun.却下));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_延期を返す() {
        assertThat(ShoriJotaiKubun.toValue(new RString("3")), is(ShoriJotaiKubun.延期));
    }

    @Test
    public void 通常を指定した場合_getコードは_0を返す() {
        assertThat(ShoriJotaiKubun.通常.getコード(), is(new RString("0")));
    }

    @Test
    public void 取下を指定した場合_getコードは_1を返す() {
        assertThat(ShoriJotaiKubun.取下.getコード(), is(new RString("1")));
    }

    @Test
    public void 却下を指定した場合_getコードは_2を返す() {
        assertThat(ShoriJotaiKubun.却下.getコード(), is(new RString("2")));
    }

    @Test
    public void 延期を指定した場合_getコードは_3を返す() {
        assertThat(ShoriJotaiKubun.延期.getコード(), is(new RString("3")));
    }

    @Test
    public void 通常を指定した場合_get名称は_通常を返す() {
        assertThat(ShoriJotaiKubun.通常.get名称(), is(new RString("通常")));
    }

    @Test
    public void 取下を指定した場合_get名称は_取下を返す() {
        assertThat(ShoriJotaiKubun.取下.get名称(), is(new RString("取下")));
    }

    @Test
    public void 却下を指定した場合_get名称は_却下を返す() {
        assertThat(ShoriJotaiKubun.却下.get名称(), is(new RString("却下")));
    }

    @Test
    public void 延期を指定した場合_get名称は_延期を返す() {
        assertThat(ShoriJotaiKubun.延期.get名称(), is(new RString("延期")));
    }

}
