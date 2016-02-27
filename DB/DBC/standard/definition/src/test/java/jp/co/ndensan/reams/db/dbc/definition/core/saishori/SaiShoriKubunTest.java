package jp.co.ndensan.reams.db.dbc.definition.core.saishori;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 再処理区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class SaiShoriKubunTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        SaiShoriKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        SaiShoriKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_空白を返す() {
        assertThat(SaiShoriKubun.toValue(new RString("0")), is(SaiShoriKubun.空白));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_再処理を返す() {
        assertThat(SaiShoriKubun.toValue(new RString("1")), is(SaiShoriKubun.再処理));
    }

    @Test
    public void 空白を指定した場合_getコードは_0を返す() {
        assertThat(SaiShoriKubun.空白.getコード(), is(new RString("0")));
    }

    @Test
    public void 再処理を指定した場合_getコードは_1を返す() {
        assertThat(SaiShoriKubun.再処理.getコード(), is(new RString("1")));
    }

    @Test
    public void 空白を指定した場合_get名称は_空白を返す() {
        assertThat(SaiShoriKubun.空白.get名称(), is(new RString("空白")));
    }

    @Test
    public void 再処理を指定した場合_get名称は_再処理を返す() {
        assertThat(SaiShoriKubun.再処理.get名称(), is(new RString("再処理")));
    }

}
