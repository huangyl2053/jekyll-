package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 変更事由のテストクラスです。
 *
 * @author LDNS
 */
public class HenkoJiyuTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        HenkoJiyu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        HenkoJiyu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_氏名変更を返す() {
        assertThat(HenkoJiyu.toValue(new RString("01")), is(HenkoJiyu.氏名変更));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_生年月日変更を返す() {
        assertThat(HenkoJiyu.toValue(new RString("02")), is(HenkoJiyu.生年月日変更));
    }

    @Test
    public void 引数に03を指定した場合_toValueは性別変更を返す() {
        assertThat(HenkoJiyu.toValue(new RString("03")), is(HenkoJiyu.性別変更));
    }

    @Test
    public void 引数に04を指定した場合_toValueは住所等変更を返す() {
        assertThat(HenkoJiyu.toValue(new RString("04")), is(HenkoJiyu.住所等変更));
    }

    @Test
    public void 引数に05を指定した場合_toValueは行政区変更を返す() {
        assertThat(HenkoJiyu.toValue(new RString("05")), is(HenkoJiyu.行政区変更));
    }

    @Test
    public void 引数に06を指定した場合_toValueは代納人変更を返す() {
        assertThat(HenkoJiyu.toValue(new RString("06")), is(HenkoJiyu.代納人変更));
    }

    @Test
    public void 引数に07を指定した場合_toValueは連絡先変更を返す() {
        assertThat(HenkoJiyu.toValue(new RString("07")), is(HenkoJiyu.連絡先変更));
    }

    @Test
    public void 引数に08を指定した場合_toValueは口座情報変更を返す() {
        assertThat(HenkoJiyu.toValue(new RString("08")), is(HenkoJiyu.口座情報変更));
    }

    @Test
    public void 引数に09を指定した場合_toValueは資格変更を返す() {
        assertThat(HenkoJiyu.toValue(new RString("09")), is(HenkoJiyu.資格変更));
    }

    @Test
    public void 引数に10を指定した場合_toValueは老齢年金変更を返す() {
        assertThat(HenkoJiyu.toValue(new RString("10")), is(HenkoJiyu.老齢年金変更));
    }

    @Test
    public void 引数に11を指定した場合_toValueは生活保護変更を返す() {
        assertThat(HenkoJiyu.toValue(new RString("11")), is(HenkoJiyu.生活保護変更));
    }

    @Test
    public void 引数に12を指定した場合_toValueは所得更正を返す() {
        assertThat(HenkoJiyu.toValue(new RString("12")), is(HenkoJiyu.所得更正));
    }

    @Test
    public void 引数に13を指定した場合_toValueは世帯員変更を返す() {
        assertThat(HenkoJiyu.toValue(new RString("13")), is(HenkoJiyu.世帯員変更));
    }

    @Test
    public void 氏名変更を指定した場合_getコードは_01を返す() {
        assertThat(HenkoJiyu.氏名変更.getコード(), is(new RString("01")));
    }

    @Test
    public void _生年月日変更を指定した場合_getコードは_02を返す() {
        assertThat(HenkoJiyu.生年月日変更.getコード(), is(new RString("02")));
    }

    @Test
    public void 性別変更を指定した場合_getコードは_03を返す() {
        assertThat(HenkoJiyu.性別変更.getコード(), is(new RString("03")));
    }

    @Test
    public void 住所等変更を指定した場合_getコードは_04を返す() {
        assertThat(HenkoJiyu.住所等変更.getコード(), is(new RString("04")));
    }

    @Test
    public void 行政区変更を指定した場合_getコードは_05を返す() {
        assertThat(HenkoJiyu.行政区変更.getコード(), is(new RString("05")));
    }

    @Test
    public void 代納人変更を指定した場合_getコードは_06を返す() {
        assertThat(HenkoJiyu.代納人変更.getコード(), is(new RString("06")));
    }

    @Test
    public void 連絡先変更を指定した場合_getコードは_07を返す() {
        assertThat(HenkoJiyu.連絡先変更.getコード(), is(new RString("07")));
    }

    @Test
    public void 口座情報変更を指定した場合_getコードは_08を返す() {
        assertThat(HenkoJiyu.口座情報変更.getコード(), is(new RString("08")));
    }

    @Test
    public void 資格変更を指定した場合_getコードは_09を返す() {
        assertThat(HenkoJiyu.資格変更.getコード(), is(new RString("09")));
    }

    @Test
    public void 老齢年金変更を指定した場合_getコードは_10を返す() {
        assertThat(HenkoJiyu.老齢年金変更.getコード(), is(new RString("10")));
    }

    @Test
    public void 生活保護変更を指定した場合_getコードは_11を返す() {
        assertThat(HenkoJiyu.生活保護変更.getコード(), is(new RString("11")));
    }

    @Test
    public void 所得更正を指定した場合_getコードは_12を返す() {
        assertThat(HenkoJiyu.所得更正.getコード(), is(new RString("12")));
    }

    @Test
    public void 世帯員変更を指定した場合_getコードは_13を返す() {
        assertThat(HenkoJiyu.世帯員変更.getコード(), is(new RString("13")));
    }

    @Test
    public void 氏名変更を指定した場合_get名称は_氏名変更を返す() {
        assertThat(HenkoJiyu.氏名変更.get名称(), is(new RString("氏名変更")));
    }

    @Test
    public void _生年月日変更を指定した場合_get名称は_生年月日変更を返す() {
        assertThat(HenkoJiyu.生年月日変更.get名称(), is(new RString("生年月日変更")));
    }

    @Test
    public void 性別変更を指定した場合_get名称は_性別変更を返す() {
        assertThat(HenkoJiyu.性別変更.get名称(), is(new RString("性別変更")));
    }

    @Test
    public void 住所等変更を指定した場合_get名称は_住所等変更を返す() {
        assertThat(HenkoJiyu.住所等変更.get名称(), is(new RString("住所等変更")));
    }

    @Test
    public void 行政区変更を指定した場合_get名称は_行政区変更を返す() {
        assertThat(HenkoJiyu.行政区変更.get名称(), is(new RString("行政区変更")));
    }

    @Test
    public void 代納人変更を指定した場合_get名称は_代納人変更を返す() {
        assertThat(HenkoJiyu.代納人変更.get名称(), is(new RString("代納人変更")));
    }

    @Test
    public void 連絡先変更を指定した場合_get名称は_連絡先変更を返す() {
        assertThat(HenkoJiyu.連絡先変更.get名称(), is(new RString("連絡先変更")));
    }

    @Test
    public void 口座情報変更を指定した場合_get名称は_口座情報変更を返す() {
        assertThat(HenkoJiyu.口座情報変更.get名称(), is(new RString("口座情報変更")));
    }

    @Test
    public void 資格変更を指定した場合_get名称は_資格変更を返す() {
        assertThat(HenkoJiyu.資格変更.get名称(), is(new RString("資格変更")));
    }

    @Test
    public void 老齢年金変更を指定した場合_get名称は_老齢年金変更を返す() {
        assertThat(HenkoJiyu.老齢年金変更.get名称(), is(new RString("老齢年金変更")));
    }

    @Test
    public void 生活保護変更を指定した場合_get名称は_生活保護変更を返す() {
        assertThat(HenkoJiyu.生活保護変更.get名称(), is(new RString("生活保護変更")));
    }

    @Test
    public void 所得更正を指定した場合_get名称は_所得更正を返す() {
        assertThat(HenkoJiyu.所得更正.get名称(), is(new RString("所得更正")));
    }

    @Test
    public void 世帯員変更を指定した場合_get名称は_世帯員変更を返す() {
        assertThat(HenkoJiyu.世帯員変更.get名称(), is(new RString("世帯員変更")));
    }

}
