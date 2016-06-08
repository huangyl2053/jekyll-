package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 出力形式のテストクラスです。
 *
 * @author LDNS
 */
public class ShutsuryokuKeishikiTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShutsuryokuKeishiki.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShutsuryokuKeishiki.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_現金を返す() {
        assertThat(ShutsuryokuKeishiki.toValue(new RString("1")), is(ShutsuryokuKeishiki.現金));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_口座を返す() {
        assertThat(ShutsuryokuKeishiki.toValue(new RString("2")), is(ShutsuryokuKeishiki.口座));
    }

    @Test
    public void 現金を指定した場合_getコードは_1を返す() {
        assertThat(ShutsuryokuKeishiki.現金.getコード(), is(new RString("1")));
    }

    @Test
    public void 口座を指定した場合_getコードは_2を返す() {
        assertThat(ShutsuryokuKeishiki.口座.getコード(), is(new RString("2")));
    }

    @Test
    public void 現金を指定した場合_get名称は_現金を返す() {
        assertThat(ShutsuryokuKeishiki.現金.get名称(), is(new RString("現金")));
    }

    @Test
    public void 口座を指定した場合_get名称は_口座を返す() {
        assertThat(ShutsuryokuKeishiki.口座.get名称(), is(new RString("口座")));
    }

}
