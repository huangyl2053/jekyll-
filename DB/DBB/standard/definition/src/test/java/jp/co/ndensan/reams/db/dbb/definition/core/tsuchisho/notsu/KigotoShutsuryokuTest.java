package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * コンビニ期毎出力のテストクラスです。
 *
 * @author LDNS
 */
public class KigotoShutsuryokuTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KigotoShutsuryoku.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KigotoShutsuryoku.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_通常出力を返す() {
        assertThat(KigotoShutsuryoku.toValue(new RString("0")), is(KigotoShutsuryoku.通常出力));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_期毎出力を返す() {
        assertThat(KigotoShutsuryoku.toValue(new RString("1")), is(KigotoShutsuryoku.期毎出力));
    }

    @Test
    public void 通常出力を指定した場合_getコードは_0を返す() {
        assertThat(KigotoShutsuryoku.通常出力.getコード(), is(new RString("0")));
    }

    @Test
    public void 期毎出力を指定した場合_getコードは_1を返す() {
        assertThat(KigotoShutsuryoku.期毎出力.getコード(), is(new RString("1")));
    }

    @Test
    public void 通常出力を指定した場合_get名称は_通常出力を返す() {
        assertThat(KigotoShutsuryoku.通常出力.get名称(), is(new RString("通常出力")));
    }

    @Test
    public void 期毎出力を指定した場合_get名称は_期毎出力を返す() {
        assertThat(KigotoShutsuryoku.期毎出力.get名称(), is(new RString("期毎出力")));
    }

}
