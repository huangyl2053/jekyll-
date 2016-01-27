package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 出力方式のテストクラスです。
 *
 * @author LDNS
 */
public class ShutsuryokuHoshikiTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShutsuryokuHoshiki.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShutsuryokuHoshiki.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_全件出力を返す() {
        assertThat(ShutsuryokuHoshiki.toValue(new RString("1")), is(ShutsuryokuHoshiki.全件出力));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_別々出力を返す() {
        assertThat(ShutsuryokuHoshiki.toValue(new RString("2")), is(ShutsuryokuHoshiki.別々出力));
    }

    @Test
    public void 全件出力を指定した場合_getコードは_1を返す() {
        assertThat(ShutsuryokuHoshiki.全件出力.getコード(), is(new RString("1")));
    }

    @Test
    public void 別々出力を指定した場合_getコードは_2を返す() {
        assertThat(ShutsuryokuHoshiki.別々出力.getコード(), is(new RString("2")));
    }

    @Test
    public void 全件出力を指定した場合_get名称は_全件出力を返す() {
        assertThat(ShutsuryokuHoshiki.全件出力.get名称(), is(new RString("全件出力")));
    }

    @Test
    public void 別々出力を指定した場合_get名称は_別々出力を返す() {
        assertThat(ShutsuryokuHoshiki.別々出力.get名称(), is(new RString("別々出力")));
    }

}
