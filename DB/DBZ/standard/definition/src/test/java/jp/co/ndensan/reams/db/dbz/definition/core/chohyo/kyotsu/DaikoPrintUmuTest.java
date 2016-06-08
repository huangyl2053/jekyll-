package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 代行プリント有無のテストクラスです。
 * 
 * @author LDNS 
 */
public class DaikoPrintUmuTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        DaikoPrintUmu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        DaikoPrintUmu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_プリントしないを返す() {
        assertThat(DaikoPrintUmu.toValue(new RString("0")), is(DaikoPrintUmu.プリントしない));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_プリントするを返す() {
        assertThat(DaikoPrintUmu.toValue(new RString("1")), is(DaikoPrintUmu.プリントする));
    }

    @Test
    public void プリントしないを指定した場合_getコードは_0を返す() {
        assertThat(DaikoPrintUmu.プリントしない.getコード(), is(new RString("0")));
    }

    @Test
    public void プリントするを指定した場合_getコードは_1を返す() {
        assertThat(DaikoPrintUmu.プリントする.getコード(), is(new RString("1")));
    }

    @Test
    public void プリントしないを指定した場合_get名称は_プリントしないを返す() {
        assertThat(DaikoPrintUmu.プリントしない.get名称(), is(new RString("プリントしない")));
    }

    @Test
    public void プリントするを指定した場合_get名称は_プリントするを返す() {
        assertThat(DaikoPrintUmu.プリントする.get名称(), is(new RString("プリントする")));
    }

}
