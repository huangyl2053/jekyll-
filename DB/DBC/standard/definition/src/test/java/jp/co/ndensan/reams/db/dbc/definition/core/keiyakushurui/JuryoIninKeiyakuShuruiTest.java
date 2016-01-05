package jp.co.ndensan.reams.db.dbc.definition.core.keiyakushurui;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 受領委任契約種類のテストクラスです。
 * 
 * @author LDNS 
 */
public class JuryoIninKeiyakuShuruiTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        JuryoIninKeiyakuShurui.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        JuryoIninKeiyakuShurui.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_住宅改修を返す() {
        assertThat(JuryoIninKeiyakuShurui.toValue(new RString("01")), is(JuryoIninKeiyakuShurui.住宅改修));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_福祉用具を返す() {
        assertThat(JuryoIninKeiyakuShurui.toValue(new RString("02")), is(JuryoIninKeiyakuShurui.福祉用具));
    }

    @Test
    public void 引数に03を指定した場合_toValueは_住宅改修_福祉用具を返す() {
        assertThat(JuryoIninKeiyakuShurui.toValue(new RString("03")), is(JuryoIninKeiyakuShurui.住宅改修_福祉用具));
    }

    @Test
    public void 引数に11を指定した場合_toValueは_償還払給付を返す() {
        assertThat(JuryoIninKeiyakuShurui.toValue(new RString("11")), is(JuryoIninKeiyakuShurui.償還払給付));
    }

    @Test
    public void 引数に21を指定した場合_toValueは_高額給付費を返す() {
        assertThat(JuryoIninKeiyakuShurui.toValue(new RString("21")), is(JuryoIninKeiyakuShurui.高額給付費));
    }

    @Test
    public void 住宅改修を指定した場合_getコードは_01を返す() {
        assertThat(JuryoIninKeiyakuShurui.住宅改修.getコード(), is(new RString("01")));
    }

    @Test
    public void 福祉用具を指定した場合_getコードは_02を返す() {
        assertThat(JuryoIninKeiyakuShurui.福祉用具.getコード(), is(new RString("02")));
    }

    @Test
    public void 住宅改修_福祉用具を指定した場合_getコードは_03を返す() {
        assertThat(JuryoIninKeiyakuShurui.住宅改修_福祉用具.getコード(), is(new RString("03")));
    }

    @Test
    public void 償還払給付を指定した場合_getコードは_11を返す() {
        assertThat(JuryoIninKeiyakuShurui.償還払給付.getコード(), is(new RString("11")));
    }

    @Test
    public void 高額給付費を指定した場合_getコードは_21を返す() {
        assertThat(JuryoIninKeiyakuShurui.高額給付費.getコード(), is(new RString("21")));
    }

    @Test
    public void 住宅改修を指定した場合_get名称は_住宅改修を返す() {
        assertThat(JuryoIninKeiyakuShurui.住宅改修.get名称(), is(new RString("住宅改修")));
    }

    @Test
    public void 福祉用具を指定した場合_get名称は_福祉用具を返す() {
        assertThat(JuryoIninKeiyakuShurui.福祉用具.get名称(), is(new RString("福祉用具")));
    }

    @Test
    public void 住宅改修_福祉用具を指定した場合_get名称は_住宅改修_福祉用具を返す() {
        assertThat(JuryoIninKeiyakuShurui.住宅改修_福祉用具.get名称(), is(new RString("住宅改修／福祉用具")));
    }

    @Test
    public void 償還払給付を指定した場合_get名称は_償還払給付を返す() {
        assertThat(JuryoIninKeiyakuShurui.償還払給付.get名称(), is(new RString("償還払給付")));
    }

    @Test
    public void 高額給付費を指定した場合_get名称は_高額給付費を返す() {
        assertThat(JuryoIninKeiyakuShurui.高額給付費.get名称(), is(new RString("高額給付費")));
    }

}
