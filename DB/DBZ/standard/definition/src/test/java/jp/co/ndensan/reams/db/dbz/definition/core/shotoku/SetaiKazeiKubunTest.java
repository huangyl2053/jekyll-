package jp.co.ndensan.reams.db.dbz.definition.core.shotoku;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 世帯課税区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class SetaiKazeiKubunTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        SetaiKazeiKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        SetaiKazeiKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_課税を返す() {
        assertThat(SetaiKazeiKubun.toValue(new RString("1")), is(SetaiKazeiKubun.課税));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_非課税を返す() {
        assertThat(SetaiKazeiKubun.toValue(new RString("2")), is(SetaiKazeiKubun.非課税));
    }

    @Test
    public void 課税を指定した場合_getコードは_1を返す() {
        assertThat(SetaiKazeiKubun.課税.getコード(), is(new RString("1")));
    }

    @Test
    public void 非課税を指定した場合_getコードは_2を返す() {
        assertThat(SetaiKazeiKubun.非課税.getコード(), is(new RString("2")));
    }

    @Test
    public void 課税を指定した場合_get名称は_課税を返す() {
        assertThat(SetaiKazeiKubun.課税.get名称(), is(new RString("課税")));
    }

    @Test
    public void 非課税を指定した場合_get名称は_非課税を返す() {
        assertThat(SetaiKazeiKubun.非課税.get名称(), is(new RString("非課税")));
    }

}
