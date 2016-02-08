package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 納付額算出方法のテストクラスです。
 *
 * @author LDNS
 */
public class NofugakuSanshutsuHohoTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        NofugakuSanshutsuHoho.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        NofugakuSanshutsuHoho.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_収入額をもとに算出を返す() {
        assertThat(NofugakuSanshutsuHoho.toValue(new RString("1")), is(NofugakuSanshutsuHoho.収入額をもとに算出));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_調定額をもとに算出を返す() {
        assertThat(NofugakuSanshutsuHoho.toValue(new RString("2")), is(NofugakuSanshutsuHoho.調定額をもとに算出));
    }

    @Test
    public void 収入額をもとに算出を指定した場合_getコードは_1を返す() {
        assertThat(NofugakuSanshutsuHoho.収入額をもとに算出.getコード(), is(new RString("1")));
    }

    @Test
    public void 調定額をもとに算出を指定した場合_getコードは_2を返す() {
        assertThat(NofugakuSanshutsuHoho.調定額をもとに算出.getコード(), is(new RString("2")));
    }

    @Test
    public void 収入額をもとに算出を指定した場合_get名称は_収入額をもとに算出を返す() {
        assertThat(NofugakuSanshutsuHoho.収入額をもとに算出.get名称(), is(new RString("収入額をもとに算出")));
    }

    @Test
    public void 調定額をもとに算出を指定した場合_get名称は_調定額をもとに算出を返す() {
        assertThat(NofugakuSanshutsuHoho.調定額をもとに算出.get名称(), is(new RString("調定額をもとに算出")));
    }

}
