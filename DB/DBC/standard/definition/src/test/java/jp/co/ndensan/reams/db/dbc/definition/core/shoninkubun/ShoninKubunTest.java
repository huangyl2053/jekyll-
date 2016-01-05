package jp.co.ndensan.reams.db.dbc.definition.core.shoninkubun;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 承認区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShoninKubunTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShoninKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShoninKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_承認しないを返す() {
        assertThat(ShoninKubun.toValue(new RString("0")), is(ShoninKubun.承認しない));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_承認するを返す() {
        assertThat(ShoninKubun.toValue(new RString("1")), is(ShoninKubun.承認する));
    }

    @Test
    public void 承認しないを指定した場合_getコードは_0を返す() {
        assertThat(ShoninKubun.承認しない.getコード(), is(new RString("0")));
    }

    @Test
    public void 承認するを指定した場合_getコードは_1を返す() {
        assertThat(ShoninKubun.承認する.getコード(), is(new RString("1")));
    }

    @Test
    public void 承認しないを指定した場合_get名称は_承認しないを返す() {
        assertThat(ShoninKubun.承認しない.get名称(), is(new RString("承認しない")));
    }

    @Test
    public void 承認するを指定した場合_get名称は_承認するを返す() {
        assertThat(ShoninKubun.承認する.get名称(), is(new RString("承認する")));
    }

}
