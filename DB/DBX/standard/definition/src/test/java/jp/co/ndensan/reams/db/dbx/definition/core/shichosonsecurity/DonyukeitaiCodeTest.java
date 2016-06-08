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

    @Test(expected = IllegalArgumentException.class)
    public void 引数がNullである場合_toValueは_IllegalArgumentExceptionが発生する() {
        DonyuKeitaiCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        DonyuKeitaiCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に111を指定した場合_toValueは_事務広域を返す() {
        assertThat(DonyuKeitaiCode.toValue(new RString("111")), is(DonyuKeitaiCode.事務広域));
    }

    @Test
    public void 引数に112を指定した場合_toValueは_事務構成市町村を返す() {
        assertThat(DonyuKeitaiCode.toValue(new RString("112")), is(DonyuKeitaiCode.事務構成市町村));
    }

    @Test
    public void 引数に120を指定した場合_toValueは_事務単一を返す() {
        assertThat(DonyuKeitaiCode.toValue(new RString("120")), is(DonyuKeitaiCode.事務単一));
    }

    @Test
    public void 引数に211を指定した場合_toValueは_認定広域を返す() {
        assertThat(DonyuKeitaiCode.toValue(new RString("211")), is(DonyuKeitaiCode.認定広域));
    }

    @Test
    public void 引数に220を指定した場合_toValueは_認定単一を返す() {
        assertThat(DonyuKeitaiCode.toValue(new RString("220")), is(DonyuKeitaiCode.認定単一));
    }

    @Test
    public void 事務広域を指定した場合_getCodeは_111を返す() {
        assertThat(DonyuKeitaiCode.事務広域.getCode(), is(new RString("111")));
    }

    @Test
    public void 事務構成市町村を指定した場合_getCodeは_112を返す() {
        assertThat(DonyuKeitaiCode.事務構成市町村.getCode(), is(new RString("112")));
    }

    @Test
    public void 事務単一を指定した場合_getCodeは_120を返す() {
        assertThat(DonyuKeitaiCode.事務単一.getCode(), is(new RString("120")));
    }

    @Test
    public void 認定広域を指定した場合_getCodeは_211を返す() {
        assertThat(DonyuKeitaiCode.認定広域.getCode(), is(new RString("211")));
    }

    @Test
    public void 認定単一を指定した場合_getCodeは_220を返す() {
        assertThat(DonyuKeitaiCode.認定単一.getCode(), is(new RString("220")));
    }

    @Test
    public void 事務広域を指定した場合_toRStringは_事務広域を返す() {
        assertThat(DonyuKeitaiCode.事務広域.toRString(), is(new RString("事務広域")));
    }

    @Test
    public void 事務構成市町村を指定した場合_toRStringは_事務構成市町村を返す() {
        assertThat(DonyuKeitaiCode.事務構成市町村.toRString(), is(new RString("事務構成市町村")));
    }

    @Test
    public void 事務単一を指定した場合_toRStringは_事務単一を返す() {
        assertThat(DonyuKeitaiCode.事務単一.toRString(), is(new RString("事務単一")));
    }

    @Test
    public void 認定広域を指定した場合_toRStringは_認定広域を返す() {
        assertThat(DonyuKeitaiCode.認定広域.toRString(), is(new RString("認定広域")));
    }

    @Test
    public void 認定単一を指定した場合_toRStringは_認定単一を返す() {
        assertThat(DonyuKeitaiCode.認定単一.toRString(), is(new RString("認定単一")));
    }

}
