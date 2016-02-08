package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 証様式区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShoYoshikiKubunTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShoYoshikiKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShoYoshikiKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_新様式２を返す() {
        assertThat(ShoYoshikiKubun.toValue(new RString("02")), is(ShoYoshikiKubun.新様式２));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_新様式を返す() {
        assertThat(ShoYoshikiKubun.toValue(new RString("01")), is(ShoYoshikiKubun.新様式));
    }

    @Test
    public void 引数に00を指定した場合_toValueは_旧様式を返す() {
        assertThat(ShoYoshikiKubun.toValue(new RString("00")), is(ShoYoshikiKubun.旧様式));
    }

    @Test
    public void 新様式２を指定した場合_getコードは_02を返す() {
        assertThat(ShoYoshikiKubun.新様式２.getコード(), is(new RString("02")));
    }

    @Test
    public void 新様式を指定した場合_getコードは_01を返す() {
        assertThat(ShoYoshikiKubun.新様式.getコード(), is(new RString("01")));
    }

    @Test
    public void 旧様式を指定した場合_getコードは_00を返す() {
        assertThat(ShoYoshikiKubun.旧様式.getコード(), is(new RString("00")));
    }

    @Test
    public void 新様式２を指定した場合_get名称は_新様式２を返す() {
        assertThat(ShoYoshikiKubun.新様式２.get名称(), is(new RString("新様式２")));
    }

    @Test
    public void 新様式を指定した場合_get名称は_新様式を返す() {
        assertThat(ShoYoshikiKubun.新様式.get名称(), is(new RString("新様式")));
    }

    @Test
    public void 旧様式を指定した場合_get名称は_旧様式を返す() {
        assertThat(ShoYoshikiKubun.旧様式.get名称(), is(new RString("旧様式")));
    }

}
