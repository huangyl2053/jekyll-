package jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity;

import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 導入形態コードのテストクラスです。
 *
 */
public class DonyukeitaiCodeTest extends DbxTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        DonyukeitaiCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        DonyukeitaiCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に111を指定した場合_toValueは_事務広域を返す() {
        assertThat(DonyukeitaiCode.toValue(new RString("111")), is(DonyukeitaiCode.事務広域));
    }

    @Test
    public void 引数に112を指定した場合_toValueは_事務構成市町村を返す() {
        assertThat(DonyukeitaiCode.toValue(new RString("112")), is(DonyukeitaiCode.事務構成市町村));
    }

    @Test
    public void 引数に120を指定した場合_toValueは_事務単一を返す() {
        assertThat(DonyukeitaiCode.toValue(new RString("120")), is(DonyukeitaiCode.事務単一));
    }

    @Test
    public void 引数に211を指定した場合_toValueは_認定広域を返す() {
        assertThat(DonyukeitaiCode.toValue(new RString("211")), is(DonyukeitaiCode.認定広域));
    }

    @Test
    public void 引数に220を指定した場合_toValueは_認定単一を返す() {
        assertThat(DonyukeitaiCode.toValue(new RString("220")), is(DonyukeitaiCode.認定単一));
    }

    @Test
    public void 事務広域を指定した場合_getコードは_111を返す() {
        assertThat(DonyukeitaiCode.事務広域.getコード(), is(new RString("111")));
    }

    @Test
    public void 事務構成市町村を指定した場合_getコードは_112を返す() {
        assertThat(DonyukeitaiCode.事務構成市町村.getコード(), is(new RString("112")));
    }

    @Test
    public void 事務単一を指定した場合_getコードは_120を返す() {
        assertThat(DonyukeitaiCode.事務単一.getコード(), is(new RString("120")));
    }

    @Test
    public void 認定広域を指定した場合_getコードは_211を返す() {
        assertThat(DonyukeitaiCode.認定広域.getコード(), is(new RString("211")));
    }

    @Test
    public void 認定単一を指定した場合_getコードは_220を返す() {
        assertThat(DonyukeitaiCode.認定単一.getコード(), is(new RString("220")));
    }

    @Test
    public void 事務広域を指定した場合_get名称は_事務広域を返す() {
        assertThat(DonyukeitaiCode.事務広域.get名称(), is(new RString("事務広域")));
    }

    @Test
    public void 事務構成市町村を指定した場合_get名称は_事務構成市町村を返す() {
        assertThat(DonyukeitaiCode.事務構成市町村.get名称(), is(new RString("事務構成市町村")));
    }

    @Test
    public void 事務単一を指定した場合_get名称は_事務単一を返す() {
        assertThat(DonyukeitaiCode.事務単一.get名称(), is(new RString("事務単一")));
    }

    @Test
    public void 認定広域を指定した場合_get名称は_認定広域を返す() {
        assertThat(DonyukeitaiCode.認定広域.get名称(), is(new RString("認定広域")));
    }

    @Test
    public void 認定単一を指定した場合_get名称は_認定単一を返す() {
        assertThat(DonyukeitaiCode.認定単一.get名称(), is(new RString("認定単一")));
    }

}
