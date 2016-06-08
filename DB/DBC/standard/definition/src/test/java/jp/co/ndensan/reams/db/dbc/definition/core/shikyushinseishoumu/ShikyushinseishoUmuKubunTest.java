package jp.co.ndensan.reams.db.dbc.definition.core.shikyushinseishoumu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 支給申請書有無区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShikyushinseishoUmuKubunTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShikyushinseishoUmuKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShikyushinseishoUmuKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_申請無しを返す() {
        assertThat(ShikyushinseishoUmuKubun.toValue(new RString("0")), is(ShikyushinseishoUmuKubun.申請無し));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_申請有りを返す() {
        assertThat(ShikyushinseishoUmuKubun.toValue(new RString("1")), is(ShikyushinseishoUmuKubun.申請有り));
    }

    @Test
    public void 申請無しを指定した場合_getコードは_0を返す() {
        assertThat(ShikyushinseishoUmuKubun.申請無し.getコード(), is(new RString("0")));
    }

    @Test
    public void 申請有りを指定した場合_getコードは_1を返す() {
        assertThat(ShikyushinseishoUmuKubun.申請有り.getコード(), is(new RString("1")));
    }

    @Test
    public void 申請無しを指定した場合_get名称は_申請無しを返す() {
        assertThat(ShikyushinseishoUmuKubun.申請無し.get名称(), is(new RString("申請無し")));
    }

    @Test
    public void 申請有りを指定した場合_get名称は_申請有りを返す() {
        assertThat(ShikyushinseishoUmuKubun.申請有り.get名称(), is(new RString("申請有り")));
    }

}
