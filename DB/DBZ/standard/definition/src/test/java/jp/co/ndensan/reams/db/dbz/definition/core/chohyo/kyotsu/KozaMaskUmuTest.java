package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 口座マスク有無のテストクラスです。
 * 
 * @author LDNS 
 */
public class KozaMaskUmuTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KozaMaskUmu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KozaMaskUmu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_マスクしないを返す() {
        assertThat(KozaMaskUmu.toValue(new RString("0")), is(KozaMaskUmu.マスクしない));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_マスクするを返す() {
        assertThat(KozaMaskUmu.toValue(new RString("1")), is(KozaMaskUmu.マスクする));
    }

    @Test
    public void マスクしないを指定した場合_getコードは_0を返す() {
        assertThat(KozaMaskUmu.マスクしない.getコード(), is(new RString("0")));
    }

    @Test
    public void マスクするを指定した場合_getコードは_1を返す() {
        assertThat(KozaMaskUmu.マスクする.getコード(), is(new RString("1")));
    }

    @Test
    public void マスクしないを指定した場合_get名称は_マスクしないを返す() {
        assertThat(KozaMaskUmu.マスクしない.get名称(), is(new RString("マスクしない")));
    }

    @Test
    public void マスクするを指定した場合_get名称は_マスクするを返す() {
        assertThat(KozaMaskUmu.マスクする.get名称(), is(new RString("マスクする")));
    }

}
