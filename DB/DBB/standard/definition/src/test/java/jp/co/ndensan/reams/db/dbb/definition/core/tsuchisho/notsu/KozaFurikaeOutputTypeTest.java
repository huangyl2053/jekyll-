package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 口座振替者出力様式のテストクラスです。
 *
 * @author LDNS
 */
public class KozaFurikaeOutputTypeTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KozaFurikaeOutputType.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KozaFurikaeOutputType.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_現金用を返す() {
        assertThat(KozaFurikaeOutputType.toValue(new RString("0")), is(KozaFurikaeOutputType.現金用));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_口座用を返す() {
        assertThat(KozaFurikaeOutputType.toValue(new RString("1")), is(KozaFurikaeOutputType.口座用));
    }

    @Test
    public void 現金用を指定した場合_getコードは_0を返す() {
        assertThat(KozaFurikaeOutputType.現金用.getコード(), is(new RString("0")));
    }

    @Test
    public void 口座用を指定した場合_getコードは_1を返す() {
        assertThat(KozaFurikaeOutputType.口座用.getコード(), is(new RString("1")));
    }

    @Test
    public void 現金用を指定した場合_get名称は_現金用を返す() {
        assertThat(KozaFurikaeOutputType.現金用.get名称(), is(new RString("現金用")));
    }

    @Test
    public void 口座用を指定した場合_get名称は_口座用を返す() {
        assertThat(KozaFurikaeOutputType.口座用.get名称(), is(new RString("口座用")));
    }

}
