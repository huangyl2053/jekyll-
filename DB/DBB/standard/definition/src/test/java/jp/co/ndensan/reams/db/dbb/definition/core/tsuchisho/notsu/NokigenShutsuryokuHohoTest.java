package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 納期限出力方法のテストクラスです。
 *
 * @author LDNS
 */
public class NokigenShutsuryokuHohoTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        NokigenShutsuryokuHoho.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        NokigenShutsuryokuHoho.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_納付書の対象となっている期を全て印字するを返す() {
        assertThat(NokigenShutsuryokuHoho.toValue(new RString("0")), is(NokigenShutsuryokuHoho.対象の期));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_全ての期分を印字するを返す() {
        assertThat(NokigenShutsuryokuHoho.toValue(new RString("1")), is(NokigenShutsuryokuHoho.全ての期));
    }

    @Test
    public void 納付書の対象となっている期を全て印字するを指定した場合_getコードは_0を返す() {
        assertThat(NokigenShutsuryokuHoho.対象の期.getコード(), is(new RString("0")));
    }

    @Test
    public void 全ての期分を印字するを指定した場合_getコードは_1を返す() {
        assertThat(NokigenShutsuryokuHoho.全ての期.getコード(), is(new RString("1")));
    }

    @Test
    public void 納付書の対象となっている期を全て印字するを指定した場合_get名称は_対象の期を返す() {
        assertThat(NokigenShutsuryokuHoho.対象の期.get名称(), is(new RString("納付書の対象となっている期を全て印字する")));
    }

    @Test
    public void 全ての期分を印字するを指定した場合_get名称は_全ての期を返す() {
        assertThat(NokigenShutsuryokuHoho.全ての期.get名称(), is(new RString("全ての期分を印字する")));
    }

}
