package jp.co.ndensan.reams.db.dbx.definition.core.hokenshakosei;

import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 保険者構成のテストクラスです。
 *
 */
public class HokenshaKoseiTest extends DbxTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        HokenshaKosei.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        HokenshaKosei.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_単一市町村を返す() {
        assertThat(HokenshaKosei.toValue(new RString("1")), is(HokenshaKosei.単一市町村));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_広域市町村を返す() {
        assertThat(HokenshaKosei.toValue(new RString("2")), is(HokenshaKosei.広域市町村));
    }

    @Test
    public void 単一市町村を指定した場合_getコードは_1を返す() {
        assertThat(HokenshaKosei.単一市町村.getコード(), is(new RString("1")));
    }

    @Test
    public void 広域市町村を指定した場合_getコードは_2を返す() {
        assertThat(HokenshaKosei.広域市町村.getコード(), is(new RString("2")));
    }

    @Test
    public void 単一市町村を指定した場合_get名称は_単一市町村を返す() {
        assertThat(HokenshaKosei.単一市町村.get名称(), is(new RString("単一市町村")));
    }

    @Test
    public void 広域市町村を指定した場合_get名称は_広域市町村を返す() {
        assertThat(HokenshaKosei.広域市町村.get名称(), is(new RString("広域市町村")));
    }

}
