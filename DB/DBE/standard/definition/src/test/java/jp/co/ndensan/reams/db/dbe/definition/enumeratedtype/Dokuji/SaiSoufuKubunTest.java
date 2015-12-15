package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Dokuji;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 再送付区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class SaiSoufuKubunTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        SaiSoufuKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        SaiSoufuKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_再送信を返す() {
        assertThat(SaiSoufuKubun.toValue(new RString("01")), is(SaiSoufuKubun.再送信));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_再送信送付済を返す() {
        assertThat(SaiSoufuKubun.toValue(new RString("02")), is(SaiSoufuKubun.再送信送付済));
    }

    @Test
    public void 再送信を指定した場合_getコードは_01を返す() {
        assertThat(SaiSoufuKubun.再送信.getコード(), is(new RString("01")));
    }

    @Test
    public void 再送信送付済を指定した場合_getコードは_02を返す() {
        assertThat(SaiSoufuKubun.再送信送付済.getコード(), is(new RString("02")));
    }

    @Test
    public void 再送信を指定した場合_get名称は_再送信を返す() {
        assertThat(SaiSoufuKubun.再送信.get名称(), is(new RString("再送信")));
    }

    @Test
    public void 再送信送付済を指定した場合_get名称は_再送信送付済を返す() {
        assertThat(SaiSoufuKubun.再送信送付済.get名称(), is(new RString("再送信送付済")));
    }

}
