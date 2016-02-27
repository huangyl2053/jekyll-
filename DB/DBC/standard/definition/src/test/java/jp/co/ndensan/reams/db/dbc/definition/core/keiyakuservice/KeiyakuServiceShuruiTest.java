package jp.co.ndensan.reams.db.dbc.definition.core.keiyakuservice;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 契約サービス種類のテストクラスです。
 * 
 * @author LDNS 
 */
public class KeiyakuServiceShuruiTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KeiyakuServiceShurui.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KeiyakuServiceShurui.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_福祉用具を返す() {
        assertThat(KeiyakuServiceShurui.toValue(new RString("01")), is(KeiyakuServiceShurui.福祉用具));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_住宅改修を返す() {
        assertThat(KeiyakuServiceShurui.toValue(new RString("02")), is(KeiyakuServiceShurui.住宅改修));
    }

    @Test
    public void 引数に03を指定した場合_toValueは_予防福祉用具を返す() {
        assertThat(KeiyakuServiceShurui.toValue(new RString("03")), is(KeiyakuServiceShurui.予防福祉用具));
    }

    @Test
    public void 引数に04を指定した場合_toValueは_予防住宅改修を返す() {
        assertThat(KeiyakuServiceShurui.toValue(new RString("04")), is(KeiyakuServiceShurui.予防住宅改修));
    }

    @Test
    public void 引数に05を指定した場合_toValueは_償還払支給を返す() {
        assertThat(KeiyakuServiceShurui.toValue(new RString("05")), is(KeiyakuServiceShurui.償還払支給));
    }

    @Test
    public void 引数に06を指定した場合_toValueは_高額給付支給を返す() {
        assertThat(KeiyakuServiceShurui.toValue(new RString("06")), is(KeiyakuServiceShurui.高額給付支給));
    }

    @Test
    public void 福祉用具を指定した場合_getコードは_01を返す() {
        assertThat(KeiyakuServiceShurui.福祉用具.getコード(), is(new RString("01")));
    }

    @Test
    public void 住宅改修を指定した場合_getコードは_02を返す() {
        assertThat(KeiyakuServiceShurui.住宅改修.getコード(), is(new RString("02")));
    }

    @Test
    public void 予防福祉用具を指定した場合_getコードは_03を返す() {
        assertThat(KeiyakuServiceShurui.予防福祉用具.getコード(), is(new RString("03")));
    }

    @Test
    public void 予防住宅改修を指定した場合_getコードは_04を返す() {
        assertThat(KeiyakuServiceShurui.予防住宅改修.getコード(), is(new RString("04")));
    }

    @Test
    public void 償還払支給を指定した場合_getコードは_05を返す() {
        assertThat(KeiyakuServiceShurui.償還払支給.getコード(), is(new RString("05")));
    }

    @Test
    public void 高額給付支給を指定した場合_getコードは_06を返す() {
        assertThat(KeiyakuServiceShurui.高額給付支給.getコード(), is(new RString("06")));
    }

    @Test
    public void 福祉用具を指定した場合_get名称は_福祉用具を返す() {
        assertThat(KeiyakuServiceShurui.福祉用具.get名称(), is(new RString("福祉用具")));
    }

    @Test
    public void 住宅改修を指定した場合_get名称は_住宅改修を返す() {
        assertThat(KeiyakuServiceShurui.住宅改修.get名称(), is(new RString("住宅改修")));
    }

    @Test
    public void 予防福祉用具を指定した場合_get名称は_予防福祉用具を返す() {
        assertThat(KeiyakuServiceShurui.予防福祉用具.get名称(), is(new RString("予防福祉用具")));
    }

    @Test
    public void 予防住宅改修を指定した場合_get名称は_予防住宅改修を返す() {
        assertThat(KeiyakuServiceShurui.予防住宅改修.get名称(), is(new RString("予防住宅改修")));
    }

    @Test
    public void 償還払支給を指定した場合_get名称は_償還払支給を返す() {
        assertThat(KeiyakuServiceShurui.償還払支給.get名称(), is(new RString("償還払支給")));
    }

    @Test
    public void 高額給付支給を指定した場合_get名称は_高額給付支給を返す() {
        assertThat(KeiyakuServiceShurui.高額給付支給.get名称(), is(new RString("高額給付支給")));
    }

}
