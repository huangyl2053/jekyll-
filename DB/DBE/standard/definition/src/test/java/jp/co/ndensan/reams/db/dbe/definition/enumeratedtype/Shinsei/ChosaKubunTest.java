package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 調査区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ChosaKubunTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ChosaKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ChosaKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_新規調査を返す() {
        assertThat(ChosaKubun.toValue(new RString("0")), is(ChosaKubun.新規調査));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_再調査を返す() {
        assertThat(ChosaKubun.toValue(new RString("1")), is(ChosaKubun.再調査));
    }

    @Test
    public void 新規調査を指定した場合_getコードは_0を返す() {
        assertThat(ChosaKubun.新規調査.getコード(), is(new RString("0")));
    }

    @Test
    public void 再調査を指定した場合_getコードは_1を返す() {
        assertThat(ChosaKubun.再調査.getコード(), is(new RString("1")));
    }

    @Test
    public void 新規調査を指定した場合_get名称は_新規調査を返す() {
        assertThat(ChosaKubun.新規調査.get名称(), is(new RString("新規調査")));
    }

    @Test
    public void 再調査を指定した場合_get名称は_再調査を返す() {
        assertThat(ChosaKubun.再調査.get名称(), is(new RString("再調査")));
    }

}
