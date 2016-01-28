package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 納付書の型のテストクラスです。
 *
 * @author LDNS
 */
public class NofusyoTypeTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        NofusyoType.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        NofusyoType.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_なしを返す() {
        assertThat(NofusyoType.toValue(new RString("0")), is(NofusyoType.なし));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_期毎を返す() {
        assertThat(NofusyoType.toValue(new RString("1")), is(NofusyoType.期毎));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_銀振型5期を返す() {
        assertThat(NofusyoType.toValue(new RString("2")), is(NofusyoType.銀振型5期));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_銀振型4期を返す() {
        assertThat(NofusyoType.toValue(new RString("4")), is(NofusyoType.銀振型4期));
    }

    @Test
    public void 引数に5を指定した場合_toValueは_ブックを返す() {
        assertThat(NofusyoType.toValue(new RString("5")), is(NofusyoType.ブック));
    }

    @Test
    public void 引数に6を指定した場合_toValueは_コンビニを返す() {
        assertThat(NofusyoType.toValue(new RString("6")), is(NofusyoType.コンビニ));
    }

    @Test
    public void 引数に9を指定した場合_toValueは_その他を返す() {
        assertThat(NofusyoType.toValue(new RString("9")), is(NofusyoType.その他));
    }

    @Test
    public void なしを指定した場合_getコードは_0を返す() {
        assertThat(NofusyoType.なし.getコード(), is(new RString("0")));
    }

    @Test
    public void 期毎を指定した場合_getコードは_1を返す() {
        assertThat(NofusyoType.期毎.getコード(), is(new RString("1")));
    }

    @Test
    public void 銀振型5期を指定した場合_getコードは_2を返す() {
        assertThat(NofusyoType.銀振型5期.getコード(), is(new RString("2")));
    }

    @Test
    public void 銀振型4期を指定した場合_getコードは_4を返す() {
        assertThat(NofusyoType.銀振型4期.getコード(), is(new RString("4")));
    }

    @Test
    public void ブックを指定した場合_getコードは_5を返す() {
        assertThat(NofusyoType.ブック.getコード(), is(new RString("5")));
    }

    @Test
    public void コンビニを指定した場合_getコードは_6を返す() {
        assertThat(NofusyoType.コンビニ.getコード(), is(new RString("6")));
    }

    @Test
    public void その他を指定した場合_getコードは_9を返す() {
        assertThat(NofusyoType.その他.getコード(), is(new RString("9")));
    }

    @Test
    public void なしを指定した場合_get名称は_なしを返す() {
        assertThat(NofusyoType.なし.get名称(), is(new RString("なし")));
    }

    @Test
    public void 期毎を指定した場合_get名称は_期毎を返す() {
        assertThat(NofusyoType.期毎.get名称(), is(new RString("期毎")));
    }

    @Test
    public void 銀振型5期を指定した場合_get名称は_銀振型5期を返す() {
        assertThat(NofusyoType.銀振型5期.get名称(), is(new RString("銀振型5期")));
    }

    @Test
    public void 銀振型4期を指定した場合_get名称は_銀振型4期を返す() {
        assertThat(NofusyoType.銀振型4期.get名称(), is(new RString("銀振型4期")));
    }

    @Test
    public void ブックを指定した場合_get名称は_ブックを返す() {
        assertThat(NofusyoType.ブック.get名称(), is(new RString("ブック")));
    }

    @Test
    public void コンビニを指定した場合_get名称は_コンビニを返す() {
        assertThat(NofusyoType.コンビニ.get名称(), is(new RString("コンビニ")));
    }

    @Test
    public void その他を指定した場合_get名称は_その他を返す() {
        assertThat(NofusyoType.その他.get名称(), is(new RString("その他")));
    }

}
