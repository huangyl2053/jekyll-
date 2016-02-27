package jp.co.ndensan.reams.db.dbc.definition.core.shinnsanaiyo;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 審査内容区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShinsaNaiyoKubunTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShinsaNaiyoKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShinsaNaiyoKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_承認するを返す() {
        assertThat(ShinsaNaiyoKubun.toValue(new RString("1")), is(ShinsaNaiyoKubun.承認する));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_却下するを返す() {
        assertThat(ShinsaNaiyoKubun.toValue(new RString("2")), is(ShinsaNaiyoKubun.却下する));
    }

    @Test
    public void 承認するを指定した場合_getコードは_1を返す() {
        assertThat(ShinsaNaiyoKubun.承認する.getコード(), is(new RString("1")));
    }

    @Test
    public void 却下するを指定した場合_getコードは_2を返す() {
        assertThat(ShinsaNaiyoKubun.却下する.getコード(), is(new RString("2")));
    }

    @Test
    public void 承認するを指定した場合_get名称は_承認するを返す() {
        assertThat(ShinsaNaiyoKubun.承認する.get名称(), is(new RString("承認する")));
    }

    @Test
    public void 却下するを指定した場合_get名称は_却下するを返す() {
        assertThat(ShinsaNaiyoKubun.却下する.get名称(), is(new RString("却下する")));
    }

}
