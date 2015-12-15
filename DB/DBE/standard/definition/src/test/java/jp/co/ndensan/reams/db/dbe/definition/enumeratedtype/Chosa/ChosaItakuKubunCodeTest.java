package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 調査委託区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ChosaItakuKubunCodeTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ChosaItakuKubunCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ChosaItakuKubunCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_保険者_市町村等を返す() {
        assertThat(ChosaItakuKubunCode.toValue(new RString("1")), is(ChosaItakuKubunCode.保険者_市町村等));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_指定市町村事務受託法人を返す() {
        assertThat(ChosaItakuKubunCode.toValue(new RString("2")), is(ChosaItakuKubunCode.指定市町村事務受託法人));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_指定居宅介護支援事業者を返す() {
        assertThat(ChosaItakuKubunCode.toValue(new RString("3")), is(ChosaItakuKubunCode.指定居宅介護支援事業者));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_介護保険施設を返す() {
        assertThat(ChosaItakuKubunCode.toValue(new RString("4")), is(ChosaItakuKubunCode.介護保険施設));
    }

    @Test
    public void 引数に5を指定した場合_toValueは_介護支援専門員を返す() {
        assertThat(ChosaItakuKubunCode.toValue(new RString("5")), is(ChosaItakuKubunCode.介護支援専門員));
    }

    @Test
    public void 引数に6を指定した場合_toValueは_他市町村を返す() {
        assertThat(ChosaItakuKubunCode.toValue(new RString("6")), is(ChosaItakuKubunCode.他市町村));
    }

    @Test
    public void 引数に9を指定した場合_toValueは_その他を返す() {
        assertThat(ChosaItakuKubunCode.toValue(new RString("9")), is(ChosaItakuKubunCode.その他));
    }

    @Test
    public void 保険者_市町村等を指定した場合_getコードは_1を返す() {
        assertThat(ChosaItakuKubunCode.保険者_市町村等.getコード(), is(new RString("1")));
    }

    @Test
    public void 指定市町村事務受託法人を指定した場合_getコードは_2を返す() {
        assertThat(ChosaItakuKubunCode.指定市町村事務受託法人.getコード(), is(new RString("2")));
    }

    @Test
    public void 指定居宅介護支援事業者を指定した場合_getコードは_3を返す() {
        assertThat(ChosaItakuKubunCode.指定居宅介護支援事業者.getコード(), is(new RString("3")));
    }

    @Test
    public void 介護保険施設を指定した場合_getコードは_4を返す() {
        assertThat(ChosaItakuKubunCode.介護保険施設.getコード(), is(new RString("4")));
    }

    @Test
    public void 介護支援専門員を指定した場合_getコードは_5を返す() {
        assertThat(ChosaItakuKubunCode.介護支援専門員.getコード(), is(new RString("5")));
    }

    @Test
    public void 他市町村を指定した場合_getコードは_6を返す() {
        assertThat(ChosaItakuKubunCode.他市町村.getコード(), is(new RString("6")));
    }

    @Test
    public void その他を指定した場合_getコードは_9を返す() {
        assertThat(ChosaItakuKubunCode.その他.getコード(), is(new RString("9")));
    }

    @Test
    public void 保険者_市町村等を指定した場合_get名称は_保険者_市町村等を返す() {
        assertThat(ChosaItakuKubunCode.保険者_市町村等.get名称(), is(new RString("保険者（市町村等）")));
    }

    @Test
    public void 指定市町村事務受託法人を指定した場合_get名称は_指定市町村事務受託法人を返す() {
        assertThat(ChosaItakuKubunCode.指定市町村事務受託法人.get名称(), is(new RString("指定市町村事務受託法人")));
    }

    @Test
    public void 指定居宅介護支援事業者を指定した場合_get名称は_指定居宅介護支援事業者を返す() {
        assertThat(ChosaItakuKubunCode.指定居宅介護支援事業者.get名称(), is(new RString("指定居宅介護支援事業者")));
    }

    @Test
    public void 介護保険施設を指定した場合_get名称は_介護保険施設を返す() {
        assertThat(ChosaItakuKubunCode.介護保険施設.get名称(), is(new RString("介護保険施設")));
    }

    @Test
    public void 介護支援専門員を指定した場合_get名称は_介護支援専門員を返す() {
        assertThat(ChosaItakuKubunCode.介護支援専門員.get名称(), is(new RString("介護支援専門員")));
    }

    @Test
    public void 他市町村を指定した場合_get名称は_他市町村を返す() {
        assertThat(ChosaItakuKubunCode.他市町村.get名称(), is(new RString("他市町村")));
    }

    @Test
    public void その他を指定した場合_get名称は_その他を返す() {
        assertThat(ChosaItakuKubunCode.その他.get名称(), is(new RString("その他")));
    }

}
