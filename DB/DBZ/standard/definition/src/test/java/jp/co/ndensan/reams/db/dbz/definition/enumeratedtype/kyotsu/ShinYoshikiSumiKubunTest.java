package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 新様式印書済区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShinYoshikiSumiKubunTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShinYoshikiSumiKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShinYoshikiSumiKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_新様式印書しているを返す() {
        assertThat(ShinYoshikiSumiKubun.toValue(new RString("01")), is(ShinYoshikiSumiKubun.新様式印書している));
    }

    @Test
    public void 引数に00を指定した場合_toValueは_新様式印書していないを返す() {
        assertThat(ShinYoshikiSumiKubun.toValue(new RString("00")), is(ShinYoshikiSumiKubun.新様式印書していない));
    }

    @Test
    public void 新様式印書しているを指定した場合_getコードは_01を返す() {
        assertThat(ShinYoshikiSumiKubun.新様式印書している.getコード(), is(new RString("01")));
    }

    @Test
    public void 新様式印書していないを指定した場合_getコードは_00を返す() {
        assertThat(ShinYoshikiSumiKubun.新様式印書していない.getコード(), is(new RString("00")));
    }

    @Test
    public void 新様式印書しているを指定した場合_get名称は_新様式印書しているを返す() {
        assertThat(ShinYoshikiSumiKubun.新様式印書している.get名称(), is(new RString("新様式印書している")));
    }

    @Test
    public void 新様式印書していないを指定した場合_get名称は_新様式印書していないを返す() {
        assertThat(ShinYoshikiSumiKubun.新様式印書していない.get名称(), is(new RString("新様式印書していない")));
    }

}
