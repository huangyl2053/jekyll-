package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Dokuji;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 再調査送付区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class SaiChousaSoufuKubunTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        SaiChousaSoufuKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        SaiChousaSoufuKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_未使用を返す() {
        assertThat(SaiChousaSoufuKubun.toValue(new RString("0")), is(SaiChousaSoufuKubun.未使用));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_再送信を返す() {
        assertThat(SaiChousaSoufuKubun.toValue(new RString("1")), is(SaiChousaSoufuKubun.再送信));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_再調査を返す() {
        assertThat(SaiChousaSoufuKubun.toValue(new RString("2")), is(SaiChousaSoufuKubun.再調査));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_再調査送付済を返す() {
        assertThat(SaiChousaSoufuKubun.toValue(new RString("3")), is(SaiChousaSoufuKubun.再調査送付済));
    }

    @Test
    public void 未使用を指定した場合_getコードは_0を返す() {
        assertThat(SaiChousaSoufuKubun.未使用.getコード(), is(new RString("0")));
    }

    @Test
    public void 再送信を指定した場合_getコードは_1を返す() {
        assertThat(SaiChousaSoufuKubun.再送信.getコード(), is(new RString("1")));
    }

    @Test
    public void 再調査を指定した場合_getコードは_2を返す() {
        assertThat(SaiChousaSoufuKubun.再調査.getコード(), is(new RString("2")));
    }

    @Test
    public void 再調査送付済を指定した場合_getコードは_3を返す() {
        assertThat(SaiChousaSoufuKubun.再調査送付済.getコード(), is(new RString("3")));
    }

    @Test
    public void 未使用を指定した場合_get名称は_未使用を返す() {
        assertThat(SaiChousaSoufuKubun.未使用.get名称(), is(new RString("未使用")));
    }

    @Test
    public void 再送信を指定した場合_get名称は_再送信を返す() {
        assertThat(SaiChousaSoufuKubun.再送信.get名称(), is(new RString("再送信")));
    }

    @Test
    public void 再調査を指定した場合_get名称は_再調査を返す() {
        assertThat(SaiChousaSoufuKubun.再調査.get名称(), is(new RString("再調査")));
    }

    @Test
    public void 再調査送付済を指定した場合_get名称は_再調査送付済を返す() {
        assertThat(SaiChousaSoufuKubun.再調査送付済.get名称(), is(new RString("再調査送付済")));
    }

}
