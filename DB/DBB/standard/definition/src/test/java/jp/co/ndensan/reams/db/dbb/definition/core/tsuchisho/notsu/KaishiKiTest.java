package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 開始期のテストクラスです。
 *
 * @author LDNS
 */
public class KaishiKiTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KaishiKi.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KaishiKi.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_無しを返す() {
        assertThat(KaishiKi.toValue(new RString("0")), is(KaishiKi.無し));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_1期を返す() {
        assertThat(KaishiKi.toValue(new RString("1")), is(KaishiKi._1期));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_2期を返す() {
        assertThat(KaishiKi.toValue(new RString("2")), is(KaishiKi._2期));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_3期を返す() {
        assertThat(KaishiKi.toValue(new RString("3")), is(KaishiKi._3期));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_4期を返す() {
        assertThat(KaishiKi.toValue(new RString("4")), is(KaishiKi._4期));
    }

    @Test
    public void 引数に5を指定した場合_toValueは_5期を返す() {
        assertThat(KaishiKi.toValue(new RString("5")), is(KaishiKi._5期));
    }

    @Test
    public void 引数に6を指定した場合_toValueは_6期を返す() {
        assertThat(KaishiKi.toValue(new RString("6")), is(KaishiKi._6期));
    }

    @Test
    public void 引数に7を指定した場合_toValueは_7期を返す() {
        assertThat(KaishiKi.toValue(new RString("7")), is(KaishiKi._7期));
    }

    @Test
    public void 引数に8を指定した場合_toValueは_8期を返す() {
        assertThat(KaishiKi.toValue(new RString("8")), is(KaishiKi._8期));
    }

    @Test
    public void 引数に9を指定した場合_toValueは_9期を返す() {
        assertThat(KaishiKi.toValue(new RString("9")), is(KaishiKi._9期));
    }

    @Test
    public void 引数に10を指定した場合_toValueは_10期を返す() {
        assertThat(KaishiKi.toValue(new RString("10")), is(KaishiKi._10期));
    }

    @Test
    public void 引数に11を指定した場合_toValueは_11期を返す() {
        assertThat(KaishiKi.toValue(new RString("11")), is(KaishiKi._11期));
    }

    @Test
    public void 引数に12を指定した場合_toValueは_12期を返す() {
        assertThat(KaishiKi.toValue(new RString("12")), is(KaishiKi._12期));
    }

    @Test
    public void 無しを指定した場合_getコードは_0を返す() {
        assertThat(KaishiKi.無し.getコード(), is(new RString("0")));
    }

    @Test
    public void _1期を指定した場合_getコードは_1を返す() {
        assertThat(KaishiKi._1期.getコード(), is(new RString("1")));
    }

    @Test
    public void _2期を指定した場合_getコードは_2を返す() {
        assertThat(KaishiKi._2期.getコード(), is(new RString("2")));
    }

    @Test
    public void _3期を指定した場合_getコードは_3を返す() {
        assertThat(KaishiKi._3期.getコード(), is(new RString("3")));
    }

    @Test
    public void _4期を指定した場合_getコードは_4を返す() {
        assertThat(KaishiKi._4期.getコード(), is(new RString("4")));
    }

    @Test
    public void _5期を指定した場合_getコードは_5を返す() {
        assertThat(KaishiKi._5期.getコード(), is(new RString("5")));
    }

    @Test
    public void _6期を指定した場合_getコードは_6を返す() {
        assertThat(KaishiKi._6期.getコード(), is(new RString("6")));
    }

    @Test
    public void _7期を指定した場合_getコードは_7を返す() {
        assertThat(KaishiKi._7期.getコード(), is(new RString("7")));
    }

    @Test
    public void _8期を指定した場合_getコードは_8を返す() {
        assertThat(KaishiKi._8期.getコード(), is(new RString("8")));
    }

    @Test
    public void _9期を指定した場合_getコードは_9を返す() {
        assertThat(KaishiKi._9期.getコード(), is(new RString("9")));
    }

    @Test
    public void _10期を指定した場合_getコードは_10を返す() {
        assertThat(KaishiKi._10期.getコード(), is(new RString("10")));
    }

    @Test
    public void _11期を指定した場合_getコードは_11を返す() {
        assertThat(KaishiKi._11期.getコード(), is(new RString("11")));
    }

    @Test
    public void _12期を指定した場合_getコードは_12を返す() {
        assertThat(KaishiKi._12期.getコード(), is(new RString("12")));
    }

    @Test
    public void 無しを指定した場合_get名称は_無しを返す() {
        assertThat(KaishiKi.無し.get名称(), is(new RString("無し")));
    }

    @Test
    public void _1期を指定した場合_get名称は__1期を返す() {
        assertThat(KaishiKi._1期.get名称(), is(new RString("_1期")));
    }

    @Test
    public void _2期を指定した場合_get名称は__2期を返す() {
        assertThat(KaishiKi._2期.get名称(), is(new RString("_2期")));
    }

    @Test
    public void _3期を指定した場合_get名称は__3期を返す() {
        assertThat(KaishiKi._3期.get名称(), is(new RString("_3期")));
    }

    @Test
    public void _4期を指定した場合_get名称は__4期を返す() {
        assertThat(KaishiKi._4期.get名称(), is(new RString("_4期")));
    }

    @Test
    public void _5期を指定した場合_get名称は__5期を返す() {
        assertThat(KaishiKi._5期.get名称(), is(new RString("_5期")));
    }

    @Test
    public void _6期を指定した場合_get名称は__6期を返す() {
        assertThat(KaishiKi._6期.get名称(), is(new RString("_6期")));
    }

    @Test
    public void _7期を指定した場合_get名称は__7期を返す() {
        assertThat(KaishiKi._7期.get名称(), is(new RString("_7期")));
    }

    @Test
    public void _8期を指定した場合_get名称は__8期を返す() {
        assertThat(KaishiKi._8期.get名称(), is(new RString("_8期")));
    }

    @Test
    public void _9期を指定した場合_get名称は__9期を返す() {
        assertThat(KaishiKi._9期.get名称(), is(new RString("_9期")));
    }

    @Test
    public void _10期を指定した場合_get名称は__10期を返す() {
        assertThat(KaishiKi._10期.get名称(), is(new RString("_10期")));
    }

    @Test
    public void _11期を指定した場合_get名称は__11期を返す() {
        assertThat(KaishiKi._11期.get名称(), is(new RString("_11期")));
    }

    @Test
    public void _12期を指定した場合_get名称は__12期を返す() {
        assertThat(KaishiKi._12期.get名称(), is(new RString("_12期")));
    }

}
