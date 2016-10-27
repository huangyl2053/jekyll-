package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 算定の基礎のテストクラスです。
 *
 * @author LDNS
 */
public class SanteiKisoTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        SanteiKiso.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        SanteiKiso.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_空白を返す() {
        assertThat(SanteiKiso.toValue(new RString("0")), is(SanteiKiso.空白));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_保険料率を返す() {
        assertThat(SanteiKiso.toValue(new RString("1")), is(SanteiKiso.保険料率));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_年額保険料を返す() {
        assertThat(SanteiKiso.toValue(new RString("2")), is(SanteiKiso.年額保険料));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_最終期保険料額を返す() {
        assertThat(SanteiKiso.toValue(new RString("3")), is(SanteiKiso.最終期保険料額));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_保険料率_今年度を返す() {
        assertThat(SanteiKiso.toValue(new RString("4")), is(SanteiKiso.保険料率_今年度));
    }

    @Test
    public void 空白を指定した場合_getコードは_0を返す() {
        assertThat(SanteiKiso.空白.getコード(), is(new RString("0")));
    }

    @Test
    public void 保険料率を指定した場合_getコードは_1を返す() {
        assertThat(SanteiKiso.保険料率.getコード(), is(new RString("1")));
    }

    @Test
    public void 年額保険料を指定した場合_getコードは_2を返す() {
        assertThat(SanteiKiso.年額保険料.getコード(), is(new RString("2")));
    }

    @Test
    public void 最終期保険料額を指定した場合_getコードは_3を返す() {
        assertThat(SanteiKiso.最終期保険料額.getコード(), is(new RString("3")));
    }

    @Test
    public void 保険料率_今年度を指定した場合_getコードは_4を返す() {
        assertThat(SanteiKiso.保険料率_今年度.getコード(), is(new RString("4")));
    }

    @Test
    public void 空白を指定した場合_get名称は_空白を返す() {
        assertThat(SanteiKiso.空白.get名称(), is(new RString("空白")));
    }

    @Test
    public void 保険料率を指定した場合_get名称は_保険料率を返す() {
        assertThat(SanteiKiso.保険料率.get名称(), is(new RString("保険料率")));
    }

    @Test
    public void 年額保険料を指定した場合_get名称は_年額保険料を返す() {
        assertThat(SanteiKiso.年額保険料.get名称(), is(new RString("年額保険料")));
    }

    @Test
    public void 最終期保険料額を指定した場合_get名称は_最終期保険料額を返す() {
        assertThat(SanteiKiso.最終期保険料額.get名称(), is(new RString("最終期保険料額")));
    }

    @Test
    public void 保険料率_今年度を指定した場合_get名称は_保険料率_今年度を返す() {
        assertThat(SanteiKiso.保険料率_今年度.get名称(), is(new RString("保険料率（今年度）")));
    }

}
