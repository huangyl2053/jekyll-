package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 納入通知書口座出力対象のテストクラスです。
 *
 * @author LDNS
 */
public class NotsuKozaShutsuryokuTaishoTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        NotsuKozaShutsuryokuTaisho.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        NotsuKozaShutsuryokuTaisho.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_現金納付者を返す() {
        assertThat(NotsuKozaShutsuryokuTaisho.toValue(new RString("0")), is(NotsuKozaShutsuryokuTaisho.現金納付者));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_口座振替者を返す() {
        assertThat(NotsuKozaShutsuryokuTaisho.toValue(new RString("1")), is(NotsuKozaShutsuryokuTaisho.口座振替者));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_全てを返す() {
        assertThat(NotsuKozaShutsuryokuTaisho.toValue(new RString("2")), is(NotsuKozaShutsuryokuTaisho.全て));
    }

    @Test
    public void 現金納付者を指定した場合_getコードは_0を返す() {
        assertThat(NotsuKozaShutsuryokuTaisho.現金納付者.getコード(), is(new RString("0")));
    }

    @Test
    public void 口座振替者を指定した場合_getコードは_1を返す() {
        assertThat(NotsuKozaShutsuryokuTaisho.口座振替者.getコード(), is(new RString("1")));
    }

    @Test
    public void 全てを指定した場合_getコードは_2を返す() {
        assertThat(NotsuKozaShutsuryokuTaisho.全て.getコード(), is(new RString("2")));
    }

    @Test
    public void 現金納付者を指定した場合_get名称は_現金納付者を返す() {
        assertThat(NotsuKozaShutsuryokuTaisho.現金納付者.get名称(), is(new RString("現金納付者")));
    }

    @Test
    public void 口座振替者を指定した場合_get名称は_口座振替者を返す() {
        assertThat(NotsuKozaShutsuryokuTaisho.口座振替者.get名称(), is(new RString("口座振替者")));
    }

    @Test
    public void 全てを指定した場合_get名称は_全てを返す() {
        assertThat(NotsuKozaShutsuryokuTaisho.全て.get名称(), is(new RString("全て")));
    }

}
