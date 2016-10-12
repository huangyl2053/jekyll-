package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 当初出力方法のテストクラスです。
 *
 * @author LDNS
 */
public class ToshoShutsuryokuHohoTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ToshoShutsuryokuHoho.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ToshoShutsuryokuHoho.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_前期_中期_後期を別々に出力を返す() {
        assertThat(ToshoShutsuryokuHoho.toValue(new RString("0")), is(ToshoShutsuryokuHoho.別々出力));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_前期_中期_後期を全件出力を返す() {
        assertThat(ToshoShutsuryokuHoho.toValue(new RString("1")), is(ToshoShutsuryokuHoho.全件出力));
    }

    @Test
    public void 前期_中期_後期を別々に出力を指定した場合_getコードは_0を返す() {
        assertThat(ToshoShutsuryokuHoho.別々出力.getコード(), is(new RString("0")));
    }

    @Test
    public void 前期_中期_後期を全件出力を指定した場合_getコードは_1を返す() {
        assertThat(ToshoShutsuryokuHoho.全件出力.getコード(), is(new RString("1")));
    }

    @Test
    public void 前期_中期_後期を別々に出力を指定した場合_get名称は_別々出力を返す() {
        assertThat(ToshoShutsuryokuHoho.別々出力.get名称(), is(new RString("前期・中期・後期を別々に出力")));
    }

    @Test
    public void 前期_中期_後期を全件出力を指定した場合_get名称は_全件出力を返す() {
        assertThat(ToshoShutsuryokuHoho.全件出力.get名称(), is(new RString("前期・中期・後期を全件出力")));
    }

}
