package jp.co.ndensan.reams.db.dbc.definition.core.saihakkokubun;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 再発行区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class SaihakkoKubunTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        SaihakkoKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        SaihakkoKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_再発行するを返す() {
        assertThat(SaihakkoKubun.toValue(new RString("1")), is(SaihakkoKubun.再発行する));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_再発行しないを返す() {
        assertThat(SaihakkoKubun.toValue(new RString("0")), is(SaihakkoKubun.再発行しない));
    }

    @Test
    public void 再発行するを指定した場合_getコードは_1を返す() {
        assertThat(SaihakkoKubun.再発行する.getコード(), is(new RString("1")));
    }

    @Test
    public void 再発行しないを指定した場合_getコードは_0を返す() {
        assertThat(SaihakkoKubun.再発行しない.getコード(), is(new RString("0")));
    }

    @Test
    public void 再発行するを指定した場合_get名称は_再発行するを返す() {
        assertThat(SaihakkoKubun.再発行する.get名称(), is(new RString("再発行する")));
    }

    @Test
    public void 再発行しないを指定した場合_get名称は_再発行しないを返す() {
        assertThat(SaihakkoKubun.再発行しない.get名称(), is(new RString("再発行しない")));
    }

}
