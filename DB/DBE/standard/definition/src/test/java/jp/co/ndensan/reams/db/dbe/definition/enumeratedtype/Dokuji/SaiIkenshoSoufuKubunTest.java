package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Dokuji;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 再意見書送付区分のテストクラスです。
 *
 * @author LDNS
 */
public class SaiIkenshoSoufuKubunTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        SaiIkenshoSoufuKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        SaiIkenshoSoufuKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_未使用を返す() {
        assertThat(SaiIkenshoSoufuKubun.toValue(new RString("0")), is(SaiIkenshoSoufuKubun.未使用));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_再送信を返す() {
        assertThat(SaiIkenshoSoufuKubun.toValue(new RString("1")), is(SaiIkenshoSoufuKubun.再送信));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_再意見書を返す() {
        assertThat(SaiIkenshoSoufuKubun.toValue(new RString("2")), is(SaiIkenshoSoufuKubun.再意見書));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_再意見書送付済を返す() {
        assertThat(SaiIkenshoSoufuKubun.toValue(new RString("3")), is(SaiIkenshoSoufuKubun.再意見書送付済));
    }

    @Test
    public void 未使用を指定した場合_getコードは_0を返す() {
        assertThat(SaiIkenshoSoufuKubun.未使用.getコード(), is(new RString("0")));
    }

    @Test
    public void 再送信を指定した場合_getコードは_1を返す() {
        assertThat(SaiIkenshoSoufuKubun.再送信.getコード(), is(new RString("1")));
    }

    @Test
    public void 再意見書を指定した場合_getコードは_2を返す() {
        assertThat(SaiIkenshoSoufuKubun.再意見書.getコード(), is(new RString("2")));
    }

    @Test
    public void 再意見書送付済を指定した場合_getコードは_3を返す() {
        assertThat(SaiIkenshoSoufuKubun.再意見書送付済.getコード(), is(new RString("3")));
    }

    @Test
    public void 未使用を指定した場合_get名称は_未使用を返す() {
        assertThat(SaiIkenshoSoufuKubun.未使用.get名称(), is(new RString("未使用")));
    }

    @Test
    public void 再送信を指定した場合_get名称は_再送信を返す() {
        assertThat(SaiIkenshoSoufuKubun.再送信.get名称(), is(new RString("再送信")));
    }

    @Test
    public void 再意見書を指定した場合_get名称は_再意見書を返す() {
        assertThat(SaiIkenshoSoufuKubun.再意見書.get名称(), is(new RString("再意見書")));
    }

    @Test
    public void 再意見書送付済を指定した場合_get名称は_再意見書送付済を返す() {
        assertThat(SaiIkenshoSoufuKubun.再意見書送付済.get名称(), is(new RString("再意見書送付済")));
    }

}
