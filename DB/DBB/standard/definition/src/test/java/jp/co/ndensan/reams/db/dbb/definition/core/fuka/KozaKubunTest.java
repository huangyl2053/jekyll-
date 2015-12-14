package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 口座区分のテストクラスです。
 *
 * @author LDNS
 */
public class KozaKubunTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KozaKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KozaKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_現金納付を返す() {
        assertThat(KozaKubun.toValue(new RString("0")), is(KozaKubun.現金納付));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_口座振替を返す() {
        assertThat(KozaKubun.toValue(new RString("1")), is(KozaKubun.口座振替));
    }

    @Test
    public void 現金納付を指定した場合_getコードは_0を返す() {
        assertThat(KozaKubun.現金納付.getコード(), is(new RString("0")));
    }

    @Test
    public void 口座振替を指定した場合_getコードは_1を返す() {
        assertThat(KozaKubun.口座振替.getコード(), is(new RString("1")));
    }

    @Test
    public void 現金納付を指定した場合_get名称は_現金納付を返す() {
        assertThat(KozaKubun.現金納付.get名称(), is(new RString("現金納付")));
    }

    @Test
    public void 口座振替を指定した場合_get名称は_口座振替を返す() {
        assertThat(KozaKubun.口座振替.get名称(), is(new RString("口座振替")));
    }

}
