package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 過年度歳出管理区分のテストクラスです。
 *
 * @author LDNS
 */
public class KanendoSaishutsuKanriKubunTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KanendoSaishutsuKanriKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KanendoSaishutsuKanriKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_管理しないを返す() {
        assertThat(KanendoSaishutsuKanriKubun.toValue(new RString("0")), is(KanendoSaishutsuKanriKubun.管理しない));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_管理するを返す() {
        assertThat(KanendoSaishutsuKanriKubun.toValue(new RString("1")), is(KanendoSaishutsuKanriKubun.管理する));
    }

    @Test
    public void 管理しないを指定した場合_getコードは_0を返す() {
        assertThat(KanendoSaishutsuKanriKubun.管理しない.getコード(), is(new RString("0")));
    }

    @Test
    public void 管理するを指定した場合_getコードは_1を返す() {
        assertThat(KanendoSaishutsuKanriKubun.管理する.getコード(), is(new RString("1")));
    }

    @Test
    public void 管理しないを指定した場合_get名称は_管理しないを返す() {
        assertThat(KanendoSaishutsuKanriKubun.管理しない.get名称(), is(new RString("管理しない")));
    }

    @Test
    public void 管理するを指定した場合_get名称は_管理するを返す() {
        assertThat(KanendoSaishutsuKanriKubun.管理する.get名称(), is(new RString("管理する")));
    }

}
