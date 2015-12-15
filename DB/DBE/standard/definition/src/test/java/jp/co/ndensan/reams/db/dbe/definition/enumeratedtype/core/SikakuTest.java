package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 資格コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class SikakuTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        Sikaku.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        Sikaku.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_医師を返す() {
        assertThat(Sikaku.toValue(new RString("01")), is(Sikaku.医師));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_歯科医師を返す() {
        assertThat(Sikaku.toValue(new RString("02")), is(Sikaku.歯科医師));
    }

    @Test
    public void 引数に03を指定した場合_toValueは_薬剤師を返す() {
        assertThat(Sikaku.toValue(new RString("03")), is(Sikaku.薬剤師));
    }

    @Test
    public void 引数に04を指定した場合_toValueは_保健師を返す() {
        assertThat(Sikaku.toValue(new RString("04")), is(Sikaku.保健師));
    }

    @Test
    public void 引数に05を指定した場合_toValueは_助産師を返す() {
        assertThat(Sikaku.toValue(new RString("05")), is(Sikaku.助産師));
    }

    @Test
    public void 引数に06を指定した場合_toValueは_洵_看護師を返す() {
        assertThat(Sikaku.toValue(new RString("06")), is(Sikaku._洵_看護師));
    }

    @Test
    public void 引数に07を指定した場合_toValueは_理学療法士を返す() {
        assertThat(Sikaku.toValue(new RString("07")), is(Sikaku.理学療法士));
    }

    @Test
    public void 引数に08を指定した場合_toValueは_作業療法士を返す() {
        assertThat(Sikaku.toValue(new RString("08")), is(Sikaku.作業療法士));
    }

    @Test
    public void 引数に09を指定した場合_toValueは_社会福祉士を返す() {
        assertThat(Sikaku.toValue(new RString("09")), is(Sikaku.社会福祉士));
    }

    @Test
    public void 引数に10を指定した場合_toValueは_介護福祉士を返す() {
        assertThat(Sikaku.toValue(new RString("10")), is(Sikaku.介護福祉士));
    }

    @Test
    public void 引数に11を指定した場合_toValueは_ソーシャルワーカーを返す() {
        assertThat(Sikaku.toValue(new RString("11")), is(Sikaku.ソーシャルワーカー));
    }

    @Test
    public void 引数に12を指定した場合_toValueは_福祉事務所現業員等を返す() {
        assertThat(Sikaku.toValue(new RString("12")), is(Sikaku.福祉事務所現業員等));
    }

    @Test
    public void 引数に13を指定した場合_toValueは_ホームヘルパーを返す() {
        assertThat(Sikaku.toValue(new RString("13")), is(Sikaku.ホームヘルパー));
    }

    @Test
    public void 引数に14を指定した場合_toValueは_介護職員を返す() {
        assertThat(Sikaku.toValue(new RString("14")), is(Sikaku.介護職員));
    }

    @Test
    public void 引数に15を指定した場合_toValueは_その他福祉関係者を返す() {
        assertThat(Sikaku.toValue(new RString("15")), is(Sikaku.その他福祉関係者));
    }

    @Test
    public void 引数に16を指定した場合_toValueは_行政関係者を返す() {
        assertThat(Sikaku.toValue(new RString("16")), is(Sikaku.行政関係者));
    }

    @Test
    public void 引数に99を指定した場合_toValueは_その他を返す() {
        assertThat(Sikaku.toValue(new RString("99")), is(Sikaku.その他));
    }

    @Test
    public void 医師を指定した場合_getコードは_01を返す() {
        assertThat(Sikaku.医師.getコード(), is(new RString("01")));
    }

    @Test
    public void 歯科医師を指定した場合_getコードは_02を返す() {
        assertThat(Sikaku.歯科医師.getコード(), is(new RString("02")));
    }

    @Test
    public void 薬剤師を指定した場合_getコードは_03を返す() {
        assertThat(Sikaku.薬剤師.getコード(), is(new RString("03")));
    }

    @Test
    public void 保健師を指定した場合_getコードは_04を返す() {
        assertThat(Sikaku.保健師.getコード(), is(new RString("04")));
    }

    @Test
    public void 助産師を指定した場合_getコードは_05を返す() {
        assertThat(Sikaku.助産師.getコード(), is(new RString("05")));
    }

    @Test
    public void _洵_看護師を指定した場合_getコードは_06を返す() {
        assertThat(Sikaku._洵_看護師.getコード(), is(new RString("06")));
    }

    @Test
    public void 理学療法士を指定した場合_getコードは_07を返す() {
        assertThat(Sikaku.理学療法士.getコード(), is(new RString("07")));
    }

    @Test
    public void 作業療法士を指定した場合_getコードは_08を返す() {
        assertThat(Sikaku.作業療法士.getコード(), is(new RString("08")));
    }

    @Test
    public void 社会福祉士を指定した場合_getコードは_09を返す() {
        assertThat(Sikaku.社会福祉士.getコード(), is(new RString("09")));
    }

    @Test
    public void 介護福祉士を指定した場合_getコードは_10を返す() {
        assertThat(Sikaku.介護福祉士.getコード(), is(new RString("10")));
    }

    @Test
    public void ソーシャルワーカーを指定した場合_getコードは_11を返す() {
        assertThat(Sikaku.ソーシャルワーカー.getコード(), is(new RString("11")));
    }

    @Test
    public void 福祉事務所現業員等を指定した場合_getコードは_12を返す() {
        assertThat(Sikaku.福祉事務所現業員等.getコード(), is(new RString("12")));
    }

    @Test
    public void ホームヘルパーを指定した場合_getコードは_13を返す() {
        assertThat(Sikaku.ホームヘルパー.getコード(), is(new RString("13")));
    }

    @Test
    public void 介護職員を指定した場合_getコードは_14を返す() {
        assertThat(Sikaku.介護職員.getコード(), is(new RString("14")));
    }

    @Test
    public void その他福祉関係者を指定した場合_getコードは_15を返す() {
        assertThat(Sikaku.その他福祉関係者.getコード(), is(new RString("15")));
    }

    @Test
    public void 行政関係者を指定した場合_getコードは_16を返す() {
        assertThat(Sikaku.行政関係者.getコード(), is(new RString("16")));
    }

    @Test
    public void その他を指定した場合_getコードは_99を返す() {
        assertThat(Sikaku.その他.getコード(), is(new RString("99")));
    }

    @Test
    public void 医師を指定した場合_get名称は_医師を返す() {
        assertThat(Sikaku.医師.get名称(), is(new RString("医師")));
    }

    @Test
    public void 歯科医師を指定した場合_get名称は_歯科医師を返す() {
        assertThat(Sikaku.歯科医師.get名称(), is(new RString("歯科医師")));
    }

    @Test
    public void 薬剤師を指定した場合_get名称は_薬剤師を返す() {
        assertThat(Sikaku.薬剤師.get名称(), is(new RString("薬剤師")));
    }

    @Test
    public void 保健師を指定した場合_get名称は_保健師を返す() {
        assertThat(Sikaku.保健師.get名称(), is(new RString("保健師")));
    }

    @Test
    public void 助産師を指定した場合_get名称は_助産師を返す() {
        assertThat(Sikaku.助産師.get名称(), is(new RString("助産師")));
    }

    @Test
    public void _洵_看護師を指定した場合_get名称は__洵_看護師を返す() {
        assertThat(Sikaku._洵_看護師.get名称(), is(new RString("（洵）看護師")));
    }

    @Test
    public void 理学療法士を指定した場合_get名称は_理学療法士を返す() {
        assertThat(Sikaku.理学療法士.get名称(), is(new RString("理学療法士")));
    }

    @Test
    public void 作業療法士を指定した場合_get名称は_作業療法士を返す() {
        assertThat(Sikaku.作業療法士.get名称(), is(new RString("作業療法士")));
    }

    @Test
    public void 社会福祉士を指定した場合_get名称は_社会福祉士を返す() {
        assertThat(Sikaku.社会福祉士.get名称(), is(new RString("社会福祉士")));
    }

    @Test
    public void 介護福祉士を指定した場合_get名称は_介護福祉士を返す() {
        assertThat(Sikaku.介護福祉士.get名称(), is(new RString("介護福祉士")));
    }

    @Test
    public void ソーシャルワーカーを指定した場合_get名称は_ソーシャルワーカーを返す() {
        assertThat(Sikaku.ソーシャルワーカー.get名称(), is(new RString("ソーシャルワーカー")));
    }

    @Test
    public void 福祉事務所現業員等を指定した場合_get名称は_福祉事務所現業員等を返す() {
        assertThat(Sikaku.福祉事務所現業員等.get名称(), is(new RString("福祉事務所現業員等")));
    }

    @Test
    public void ホームヘルパーを指定した場合_get名称は_ホームヘルパーを返す() {
        assertThat(Sikaku.ホームヘルパー.get名称(), is(new RString("ホームヘルパー")));
    }

    @Test
    public void 介護職員を指定した場合_get名称は_介護職員を返す() {
        assertThat(Sikaku.介護職員.get名称(), is(new RString("介護職員")));
    }

    @Test
    public void その他福祉関係者を指定した場合_get名称は_その他福祉関係者を返す() {
        assertThat(Sikaku.その他福祉関係者.get名称(), is(new RString("その他福祉関係者")));
    }

    @Test
    public void 行政関係者を指定した場合_get名称は_行政関係者を返す() {
        assertThat(Sikaku.行政関係者.get名称(), is(new RString("行政関係者")));
    }

    @Test
    public void その他を指定した場合_get名称は_その他を返す() {
        assertThat(Sikaku.その他.get名称(), is(new RString("その他")));
    }

}
