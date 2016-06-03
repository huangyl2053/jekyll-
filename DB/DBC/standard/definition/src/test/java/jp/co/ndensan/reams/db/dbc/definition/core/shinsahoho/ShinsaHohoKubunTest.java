package jp.co.ndensan.reams.db.dbc.definition.core.shinsahoho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 審査方法区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShinsaHohoKubunTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShinsaHohoKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShinsaHohoKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_審査依頼を返す() {
        assertThat(ShinsaHohoKubun.toValue(new RString("1")), is(ShinsaHohoKubun.審査依頼));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_審査済みを返す() {
        assertThat(ShinsaHohoKubun.toValue(new RString("2")), is(ShinsaHohoKubun.審査済み));
    }

    @Test
    public void 審査依頼を指定した場合_getコードは_1を返す() {
        assertThat(ShinsaHohoKubun.審査依頼.getコード(), is(new RString("1")));
    }

    @Test
    public void 審査済みを指定した場合_getコードは_2を返す() {
        assertThat(ShinsaHohoKubun.審査済み.getコード(), is(new RString("2")));
    }

    @Test
    public void 審査依頼を指定した場合_get名称は_審査依頼を返す() {
        assertThat(ShinsaHohoKubun.審査依頼.get名称(), is(new RString("審査依頼")));
    }

    @Test
    public void 審査済みを指定した場合_get名称は_審査済みを返す() {
        assertThat(ShinsaHohoKubun.審査済み.get名称(), is(new RString("審査済み")));
    }

}
