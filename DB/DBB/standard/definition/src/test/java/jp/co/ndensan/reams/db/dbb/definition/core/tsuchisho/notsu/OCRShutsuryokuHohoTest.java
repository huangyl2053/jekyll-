package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 口座振替のOCR出力方法のテストクラスです。
 *
 * @author LDNS
 */
public class OCRShutsuryokuHohoTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        OCRShutsuryokuHoho.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        OCRShutsuryokuHoho.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_口座振替_ならOCR欄を印字しないを返す() {
        assertThat(OCRShutsuryokuHoho.toValue(new RString("0")), is(OCRShutsuryokuHoho.印字しない));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_口座振替_ならOCR欄を_星印_でつぶすを返す() {
        assertThat(OCRShutsuryokuHoho.toValue(new RString("1")), is(OCRShutsuryokuHoho.マスクでつぶす
        ));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_口座振替_ならOCR欄を印字するを返す() {
        assertThat(OCRShutsuryokuHoho.toValue(new RString("2")), is(OCRShutsuryokuHoho.印字する));
    }

    @Test
    public void _口座振替_ならOCR欄を印字しないを指定した場合_getコードは_0を返す() {
        assertThat(OCRShutsuryokuHoho.印字しない.getコード(), is(new RString("0")));
    }

    @Test
    public void _口座振替_ならOCR欄を_星印_でつぶすを指定した場合_getコードは_1を返す() {
        assertThat(OCRShutsuryokuHoho.マスクでつぶす.getコード(), is(new RString("1"))
        );
    }

    @Test
    public void _口座振替_ならOCR欄を印字するを指定した場合_getコードは_2を返す() {
        assertThat(OCRShutsuryokuHoho.印字する.getコード(), is(new RString("2")));
    }

    @Test
    public void _口座振替_ならOCR欄を印字しないを指定した場合_get名称は_印字しないを返す() {
        assertThat(OCRShutsuryokuHoho.印字しない.get名称(), is(new RString("「口座振替」ならOCR欄を印字しない")));
    }

    @Test
    public void _口座振替_ならOCR欄を_星印_でつぶすを指定した場合_get名称は_マスクでつぶすを返す() {
        assertThat(OCRShutsuryokuHoho.マスクでつぶす.get名称(), is(new RString("「口座振替」ならOCR欄を「＊」でつぶす"))
        );
    }

    @Test
    public void _口座振替_ならOCR欄を印字するを指定した場合_get名称は_印字するを返す() {
        assertThat(OCRShutsuryokuHoho.印字する.get名称(), is(new RString("「口座振替」ならOCR欄を印字する")));
    }

}
