package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 月のテストクラスです。
 *
 * @author LDNS
 */
public class TsukiTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        Tsuki.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        Tsuki.toValue(new RString("99999"));
    }

    @Test
    public void 引数に04を指定した場合_toValueは_4月を返す() {
        assertThat(Tsuki.toValue(new RString("04")), is(Tsuki._4月));
    }

    @Test
    public void 引数に05を指定した場合_toValueは_5月を返す() {
        assertThat(Tsuki.toValue(new RString("05")), is(Tsuki._5月));
    }

    @Test
    public void 引数に06を指定した場合_toValueは_6月を返す() {
        assertThat(Tsuki.toValue(new RString("06")), is(Tsuki._6月));
    }

    @Test
    public void 引数に07を指定した場合_toValueは_7月を返す() {
        assertThat(Tsuki.toValue(new RString("07")), is(Tsuki._7月));
    }

    @Test
    public void 引数に08を指定した場合_toValueは_8月を返す() {
        assertThat(Tsuki.toValue(new RString("08")), is(Tsuki._8月));
    }

    @Test
    public void 引数に09を指定した場合_toValueは_9月を返す() {
        assertThat(Tsuki.toValue(new RString("09")), is(Tsuki._9月));
    }

    @Test
    public void 引数に10を指定した場合_toValueは_10月を返す() {
        assertThat(Tsuki.toValue(new RString("10")), is(Tsuki._10月));
    }

    @Test
    public void 引数に11を指定した場合_toValueは_11月を返す() {
        assertThat(Tsuki.toValue(new RString("11")), is(Tsuki._11月));
    }

    @Test
    public void 引数に12を指定した場合_toValueは_12月を返す() {
        assertThat(Tsuki.toValue(new RString("12")), is(Tsuki._12月));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_1月を返す() {
        assertThat(Tsuki.toValue(new RString("01")), is(Tsuki._1月));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_2月を返す() {
        assertThat(Tsuki.toValue(new RString("02")), is(Tsuki._2月));
    }

    @Test
    public void 引数に03を指定した場合_toValueは_3月を返す() {
        assertThat(Tsuki.toValue(new RString("03")), is(Tsuki._3月));
    }

    @Test
    public void 引数に14を指定した場合_toValueは_翌年度4月を返す() {
        assertThat(Tsuki.toValue(new RString("14")), is(Tsuki.翌年度4月));
    }

    @Test
    public void 引数に15を指定した場合_toValueは_翌年度5月を返す() {
        assertThat(Tsuki.toValue(new RString("15")), is(Tsuki.翌年度5月));
    }

    @Test
    public void _4月を指定した場合_getコードは_04を返す() {
        assertThat(Tsuki._4月.getコード(), is(new RString("04")));
    }

    @Test
    public void _5月を指定した場合_getコードは_05を返す() {
        assertThat(Tsuki._5月.getコード(), is(new RString("05")));
    }

    @Test
    public void _6月を指定した場合_getコードは_06を返す() {
        assertThat(Tsuki._6月.getコード(), is(new RString("06")));
    }

    @Test
    public void _7月を指定した場合_getコードは_07を返す() {
        assertThat(Tsuki._7月.getコード(), is(new RString("07")));
    }

    @Test
    public void _8月を指定した場合_getコードは_08を返す() {
        assertThat(Tsuki._8月.getコード(), is(new RString("08")));
    }

    @Test
    public void _9月を指定した場合_getコードは_09を返す() {
        assertThat(Tsuki._9月.getコード(), is(new RString("09")));
    }

    @Test
    public void _10月を指定した場合_getコードは_10を返す() {
        assertThat(Tsuki._10月.getコード(), is(new RString("10")));
    }

    @Test
    public void _11月を指定した場合_getコードは_11を返す() {
        assertThat(Tsuki._11月.getコード(), is(new RString("11")));
    }

    @Test
    public void _12月を指定した場合_getコードは_12を返す() {
        assertThat(Tsuki._12月.getコード(), is(new RString("12")));
    }

    @Test
    public void _1月を指定した場合_getコードは_01を返す() {
        assertThat(Tsuki._1月.getコード(), is(new RString("01")));
    }

    @Test
    public void _2月を指定した場合_getコードは_02を返す() {
        assertThat(Tsuki._2月.getコード(), is(new RString("02")));
    }

    @Test
    public void _3月を指定した場合_getコードは_03を返す() {
        assertThat(Tsuki._3月.getコード(), is(new RString("03")));
    }

    @Test
    public void 翌年度4月を指定した場合_getコードは_14を返す() {
        assertThat(Tsuki.翌年度4月.getコード(), is(new RString("14")));
    }

    @Test
    public void 翌年度5月を指定した場合_getコードは_15を返す() {
        assertThat(Tsuki.翌年度5月.getコード(), is(new RString("15")));
    }

    @Test
    public void _4月を指定した場合_get名称は__4月を返す() {
        assertThat(Tsuki._4月.get名称(), is(new RString("_4月")));
    }

    @Test
    public void _5月を指定した場合_get名称は__5月を返す() {
        assertThat(Tsuki._5月.get名称(), is(new RString("_5月")));
    }

    @Test
    public void _6月を指定した場合_get名称は__6月を返す() {
        assertThat(Tsuki._6月.get名称(), is(new RString("_6月")));
    }

    @Test
    public void _7月を指定した場合_get名称は__7月を返す() {
        assertThat(Tsuki._7月.get名称(), is(new RString("_7月")));
    }

    @Test
    public void _8月を指定した場合_get名称は__8月を返す() {
        assertThat(Tsuki._8月.get名称(), is(new RString("_8月")));
    }

    @Test
    public void _9月を指定した場合_get名称は__9月を返す() {
        assertThat(Tsuki._9月.get名称(), is(new RString("_9月")));
    }

    @Test
    public void _10月を指定した場合_get名称は__10月を返す() {
        assertThat(Tsuki._10月.get名称(), is(new RString("_10月")));
    }

    @Test
    public void _11月を指定した場合_get名称は__11月を返す() {
        assertThat(Tsuki._11月.get名称(), is(new RString("_11月")));
    }

    @Test
    public void _12月を指定した場合_get名称は__12月を返す() {
        assertThat(Tsuki._12月.get名称(), is(new RString("_12月")));
    }

    @Test
    public void _1月を指定した場合_get名称は__1月を返す() {
        assertThat(Tsuki._1月.get名称(), is(new RString("_1月")));
    }

    @Test
    public void _2月を指定した場合_get名称は__2月を返す() {
        assertThat(Tsuki._2月.get名称(), is(new RString("_2月")));
    }

    @Test
    public void _3月を指定した場合_get名称は__3月を返す() {
        assertThat(Tsuki._3月.get名称(), is(new RString("_3月")));
    }

    @Test
    public void 翌年度4月を指定した場合_get名称は_翌年度4月を返す() {
        assertThat(Tsuki.翌年度4月.get名称(), is(new RString("翌年度4月")));
    }

    @Test
    public void 翌年度5月を指定した場合_get名称は_翌年度5月を返す() {
        assertThat(Tsuki.翌年度5月.get名称(), is(new RString("翌年度5月")));
    }

}
