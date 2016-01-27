package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 普徴仮算定計算方法のテストクラスです。
 *
 * @author LDNS
 */
public class FuchoZanteiKeisanHohoTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        FuchoZanteiKeisanHoho.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        FuchoZanteiKeisanHoho.toValue(new RString("99999"));
    }

    @Test
    public void 引数に00を指定した場合_toValueは_仮算定賦課なしを返す() {
        assertThat(FuchoZanteiKeisanHoho.toValue(new RString("00")), is(FuchoZanteiKeisanHoho.仮算定賦課なし));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_前年度_最終期保険料額を返す() {
        assertThat(FuchoZanteiKeisanHoho.toValue(new RString("01")), is(FuchoZanteiKeisanHoho.前年度_最終期保険料額));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_前年度末_基準年額_今納期数を返す() {
        assertThat(FuchoZanteiKeisanHoho.toValue(new RString("02")), is(FuchoZanteiKeisanHoho.前年度末_基準年額_今納期数));
    }

    @Test
    public void 引数に03を指定した場合_toValueは_前年度末_基準年額_前納期数を返す() {
        assertThat(FuchoZanteiKeisanHoho.toValue(new RString("03")), is(FuchoZanteiKeisanHoho.前年度末_基準年額_前納期数));
    }

    @Test
    public void 引数に04を指定した場合_toValueは_前年度_確定年額_今納期数を返す() {
        assertThat(FuchoZanteiKeisanHoho.toValue(new RString("04")), is(FuchoZanteiKeisanHoho.前年度_確定年額_今納期数));
    }

    @Test
    public void 引数に05を指定した場合_toValueは_前年度_確定年額_前納期数_全納期数を返す() {
        assertThat(FuchoZanteiKeisanHoho.toValue(new RString("05")), is(FuchoZanteiKeisanHoho.前年度_確定年額_前納期数_全納期数));
    }

    @Test
    public void 引数に06を指定した場合_toValueは_前年度_確定年額_前納期数_賦課納期数を返す() {
        assertThat(FuchoZanteiKeisanHoho.toValue(new RString("06")), is(FuchoZanteiKeisanHoho.前年度_確定年額_前納期数_賦課納期数));
    }

    @Test
    public void 引数に07を指定した場合_toValueは_今年度_基準年額_今納期数を返す() {
        assertThat(FuchoZanteiKeisanHoho.toValue(new RString("07")), is(FuchoZanteiKeisanHoho.今年度_基準年額_今納期数));
    }

    @Test
    public void 引数に08を指定した場合_toValueは_前年度_基準年額乗３分の４_今納期数を返す() {
        assertThat(FuchoZanteiKeisanHoho.toValue(new RString("08")), is(FuchoZanteiKeisanHoho.前年度_基準年額乗３分の４_今納期数
        ));
    }

    @Test
    public void 引数に09を指定した場合_toValueは_前年度_確定年額乗３分の４_今納期数を返す() {
        assertThat(FuchoZanteiKeisanHoho.toValue(new RString("09")), is(FuchoZanteiKeisanHoho.前年度_確定年額乗３分の４_今納期数
        ));
    }

    @Test
    public void 引数に10を指定した場合_toValueは_今年度_基準年額_今納期数_段階補正を返す() {
        assertThat(FuchoZanteiKeisanHoho.toValue(new RString("10")), is(FuchoZanteiKeisanHoho.今年度_基準年額_今納期数_段階補正));
    }

    @Test
    public void 引数に11を指定した場合_toValueは_今年度_基準年額_前年度所得_今年度賦課期日__今納期数_段階補正を返す() {
        assertThat(FuchoZanteiKeisanHoho.toValue(new RString("11")), is(FuchoZanteiKeisanHoho.今年度_基準年額_前年度所得_今年度賦課期日__今納期数_段階補正));
    }

    @Test
    public void 引数に12を指定した場合_toValueは_今年度_基準年額_今納期数_一律を返す() {
        assertThat(FuchoZanteiKeisanHoho.toValue(new RString("12")), is(FuchoZanteiKeisanHoho.今年度_基準年額_今納期数_一律));
    }

    @Test
    public void 引数に91を指定した場合_toValueは_千代田区独自算定を返す() {
        assertThat(FuchoZanteiKeisanHoho.toValue(new RString("91")), is(FuchoZanteiKeisanHoho.千代田区独自算定));
    }

    @Test
    public void 引数に99を指定した場合_toValueは_その他を返す() {
        assertThat(FuchoZanteiKeisanHoho.toValue(new RString("99")), is(FuchoZanteiKeisanHoho.その他));
    }

    @Test
    public void 仮算定賦課なしを指定した場合_getコードは_00を返す() {
        assertThat(FuchoZanteiKeisanHoho.仮算定賦課なし.getコード(), is(new RString("00")));
    }

    @Test
    public void 前年度_最終期保険料額を指定した場合_getコードは_01を返す() {
        assertThat(FuchoZanteiKeisanHoho.前年度_最終期保険料額.getコード(), is(new RString("01")));
    }

    @Test
    public void 前年度末_基準年額_今納期数を指定した場合_getコードは_02を返す() {
        assertThat(FuchoZanteiKeisanHoho.前年度末_基準年額_今納期数.getコード(), is(new RString("02")));
    }

    @Test
    public void 前年度末_基準年額_前納期数を指定した場合_getコードは_03を返す() {
        assertThat(FuchoZanteiKeisanHoho.前年度末_基準年額_前納期数.getコード(), is(new RString("03")));
    }

    @Test
    public void 前年度_確定年額_今納期数を指定した場合_getコードは_04を返す() {
        assertThat(FuchoZanteiKeisanHoho.前年度_確定年額_今納期数.getコード(), is(new RString("04")));
    }

    @Test
    public void 前年度_確定年額_前納期数_全納期数を指定した場合_getコードは_05を返す() {
        assertThat(FuchoZanteiKeisanHoho.前年度_確定年額_前納期数_全納期数.getコード(), is(new RString("05")));
    }

    @Test
    public void 前年度_確定年額_前納期数_賦課納期数を指定した場合_getコードは_06を返す() {
        assertThat(FuchoZanteiKeisanHoho.前年度_確定年額_前納期数_賦課納期数.getコード(), is(new RString("06")));
    }

    @Test
    public void 今年度_基準年額_今納期数を指定した場合_getコードは_07を返す() {
        assertThat(FuchoZanteiKeisanHoho.今年度_基準年額_今納期数.getコード(), is(new RString("07")));
    }

    @Test
    public void 前年度_基準年額乗３分の４_今納期数を指定した場合_getコードは_08を返す() {
        assertThat(FuchoZanteiKeisanHoho.前年度_基準年額乗３分の４_今納期数.getコード(), is(new RString("08")));
    }

    @Test
    public void 前年度_確定年額乗３分の４_今納期数を指定した場合_getコードは_09を返す() {
        assertThat(FuchoZanteiKeisanHoho.前年度_確定年額乗３分の４_今納期数.getコード(), is(new RString("09")));
    }

    @Test
    public void 今年度_基準年額_今納期数_段階補正を指定した場合_getコードは_10を返す() {
        assertThat(FuchoZanteiKeisanHoho.今年度_基準年額_今納期数_段階補正.getコード(), is(new RString("10")));
    }

    @Test
    public void 今年度_基準年額_前年度所得_今年度賦課期日__今納期数_段階補正を指定した場合_getコードは_11を返す() {
        assertThat(FuchoZanteiKeisanHoho.今年度_基準年額_前年度所得_今年度賦課期日__今納期数_段階補正.getコード(), is(new RString("11")));
    }

    @Test
    public void 今年度_基準年額_今納期数_一律を指定した場合_getコードは_12を返す() {
        assertThat(FuchoZanteiKeisanHoho.今年度_基準年額_今納期数_一律.getコード(), is(new RString("12")));
    }

    @Test
    public void 千代田区独自算定を指定した場合_getコードは_91を返す() {
        assertThat(FuchoZanteiKeisanHoho.千代田区独自算定.getコード(), is(new RString("91")));
    }

    @Test
    public void その他を指定した場合_getコードは_99を返す() {
        assertThat(FuchoZanteiKeisanHoho.その他.getコード(), is(new RString("99")));
    }

    @Test
    public void 仮算定賦課なしを指定した場合_get名称は_仮算定賦課なしを返す() {
        assertThat(FuchoZanteiKeisanHoho.仮算定賦課なし.get名称(), is(new RString("仮算定賦課なし")));
    }

    @Test
    public void 前年度_最終期保険料額を指定した場合_get名称は_前年度最終期の保険料額を返す() {
        assertThat(FuchoZanteiKeisanHoho.前年度_最終期保険料額.get名称(), is(new RString("前年度最終期の保険料額")));
    }

    @Test
    public void 前年度末_基準年額_今納期数を指定した場合_get名称は_前年度末時点での基準年額保険料_月割前年額保険料_を今年度の納期数で除すを返す() {
        assertThat(FuchoZanteiKeisanHoho.前年度末_基準年額_今納期数.get名称(), is(new RString("前年度末時点での基準年額保険料_月割前年額保険料_を今年度の納期数で除す")));
    }

    @Test
    public void 前年度末_基準年額_前納期数を指定した場合_get名称は_前年度末時点での基準年額保険料_月割前年額保険料_を前年度の納期数で除すを返す() {
        assertThat(FuchoZanteiKeisanHoho.前年度末_基準年額_前納期数.get名称(), is(new RString("前年度末時点での基準年額保険料_月割前年額保険料_を前年度の納期数で除す")));
    }

    @Test
    public void 前年度_確定年額_今納期数を指定した場合_get名称は_前年度の確定年額保険料_月割後年額保険料_を今年度の納期数で除すを返す() {
        assertThat(FuchoZanteiKeisanHoho.前年度_確定年額_今納期数.get名称(), is(new RString("前年度の確定年額保険料_月割後年額保険料_を今年度の納期数で除す")));
    }

    @Test
    public void 前年度_確定年額_前納期数_全納期数を指定した場合_get名称は_前年度の確定年額保険料_月割後年額保険料_を前年度の納期数_全納期数_で除すを返す() {
        assertThat(FuchoZanteiKeisanHoho.前年度_確定年額_前納期数_全納期数.get名称(), is(new RString("前年度の確定年額保険料_月割後年額保険料_を前年度の納期数_全納期数_で除す")));
    }

    @Test
    public void 前年度_確定年額_前納期数_賦課納期数を指定した場合_get名称は_前年度の確定年額保険料_月割後年額保険料_を前年度の納期数_賦課納期数_で除すを返す() {
        assertThat(FuchoZanteiKeisanHoho.前年度_確定年額_前納期数_賦課納期数.get名称(), is(new RString("前年度の確定年額保険料_月割後年額保険料_を前年度の納期数_賦課納期数_で除す")));
    }

    @Test
    public void 今年度_基準年額_今納期数を指定した場合_get名称は_前年度末時点の所得段階に応じた今年度基準年額保険料を今年度納期数で除すを返す() {
        assertThat(FuchoZanteiKeisanHoho.今年度_基準年額_今納期数.get名称(), is(new RString("前年度末時点の所得段階に応じた今年度基準年額保険料を今年度納期数で除す")));
    }

    @Test
    public void 前年度_基準年額乗３分の４_今納期数を指定した場合_get名称は_前年度末時点での基準年額保険料に3分の4を乗じた額を今年度の納期数で除すを返す() {
        assertThat(FuchoZanteiKeisanHoho.前年度_基準年額乗３分の４_今納期数.get名称(), is(new RString("前年度末時点での基準年額保険料に3分の4を乗じた額を今年度の納期数で除す")));
    }

    @Test
    public void 前年度_確定年額乗３分の４_今納期数を指定した場合_get名称は_前年度の確定年額保険料に3分の4を乗じた額を今年度の納期数で除すを返す() {
        assertThat(FuchoZanteiKeisanHoho.前年度_確定年額乗３分の４_今納期数.get名称(), is(new RString("前年度の確定年額保険料に3分の4を乗じた額を今年度の納期数で除す")));
    }

    @Test
    public void 今年度_基準年額_今納期数_段階補正を指定した場合_get名称は_今年度の基準年額保険料を今年度の納期数で除す_前年度の所得情報より段階補正を返す() {
        assertThat(FuchoZanteiKeisanHoho.今年度_基準年額_今納期数_段階補正.get名称(), is(new RString("今年度の基準年額保険料を今年度の納期数で除す_前年度の所得情報より段階補正")));
    }

    @Test
    public void 今年度_基準年額_前年度所得_今年度賦課期日__今納期数_段階補正を指定した場合_get名称は_前年度所得_今年度賦課期日に応じた基準年額保険料を今年度納期数で除すを返す() {
        assertThat(FuchoZanteiKeisanHoho.今年度_基準年額_前年度所得_今年度賦課期日__今納期数_段階補正.get名称(), is(new RString("前年度所得_今年度賦課期日に応じた基準年額保険料を今年度納期数で除す")));
    }

    @Test
    public void 今年度_基準年額_今納期数_一律を指定した場合_get名称は_一律_今年度基準年額保険料を今納期数で除すを返す() {
        assertThat(FuchoZanteiKeisanHoho.今年度_基準年額_今納期数_一律.get名称(), is(new RString("一律_今年度基準年額保険料を今納期数で除す")));
    }

    @Test
    public void 千代田区独自算定を指定した場合_get名称は_千代田区独自算定を返す() {
        assertThat(FuchoZanteiKeisanHoho.千代田区独自算定.get名称(), is(new RString("千代田区独自算定")));
    }

    @Test
    public void その他を指定した場合_get名称は_その他を返す() {
        assertThat(FuchoZanteiKeisanHoho.その他.get名称(), is(new RString("その他")));
    }

    @Test
    public void 仮算定賦課なしを指定した場合_get略称は_仮算定賦課なしを返す() {
        assertThat(FuchoZanteiKeisanHoho.仮算定賦課なし.get略称(), is(new RString("仮算定賦課なし")));
    }

    @Test
    public void 前年度_最終期保険料額を指定した場合_get略称は_前年度_最終期保険料額を返す() {
        assertThat(FuchoZanteiKeisanHoho.前年度_最終期保険料額.get略称(), is(new RString("前年度・最終期保険料額")));
    }

    @Test
    public void 前年度末_基準年額_今納期数を指定した場合_get略称は_前年度末_基準年額_今納期数を返す() {
        assertThat(FuchoZanteiKeisanHoho.前年度末_基準年額_今納期数.get略称(), is(new RString("前年度末・基準年額／今納期数")));
    }

    @Test
    public void 前年度末_基準年額_前納期数を指定した場合_get略称は_前年度末_基準年額_前納期数を返す() {
        assertThat(FuchoZanteiKeisanHoho.前年度末_基準年額_前納期数.get略称(), is(new RString("前年度末・基準年額／前納期数")));
    }

    @Test
    public void 前年度_確定年額_今納期数を指定した場合_get略称は_前年度_確定年額_今納期数を返す() {
        assertThat(FuchoZanteiKeisanHoho.前年度_確定年額_今納期数.get略称(), is(new RString("前年度・確定年額／今納期数")));
    }

    @Test
    public void 前年度_確定年額_前納期数_全納期数を指定した場合_get略称は_前年度_確定年額_前納期数_全納期数を返す() {
        assertThat(FuchoZanteiKeisanHoho.前年度_確定年額_前納期数_全納期数.get略称(), is(new RString("前年度・確定年額／前納期数（全納期数）")));
    }

    @Test
    public void 前年度_確定年額_前納期数_賦課納期数を指定した場合_get略称は_前年度_確定年額_前納期数_賦課納期数を返す() {
        assertThat(FuchoZanteiKeisanHoho.前年度_確定年額_前納期数_賦課納期数.get略称(), is(new RString("前年度・確定年額／前納期数（賦課納期数）")));
    }

    @Test
    public void 今年度_基準年額_今納期数を指定した場合_get略称は_今年度_基準年額_今納期数を返す() {
        assertThat(FuchoZanteiKeisanHoho.今年度_基準年額_今納期数.get略称(), is(new RString("今年度・基準年額／今納期数")));
    }

    @Test
    public void 前年度_基準年額乗３分の４_今納期数を指定した場合_get略称は_前年度_基準年額乗３分の４_今納期数を返す() {
        assertThat(FuchoZanteiKeisanHoho.前年度_基準年額乗３分の４_今納期数.get略称(), is(new RString("前年度・基準年額乗３分の４／今納期数")));
    }

    @Test
    public void 今年度_基準年額_今納期数_段階補正を指定した場合_get略称は_今年度_基準年額_今納期数_段階補正を返す() {
        assertThat(FuchoZanteiKeisanHoho.今年度_基準年額_今納期数_段階補正.get略称(), is(new RString("今年度・基準年額／今納期数(段階補正)")));
    }

    @Test
    public void 今年度_基準年額_前年度所得_今年度賦課期日__今納期数_段階補正を指定した場合_get略称は_今年度_基準年額_前年度所得_今年度賦課期日__今納期数_段階補正を返す() {
        assertThat(FuchoZanteiKeisanHoho.今年度_基準年額_前年度所得_今年度賦課期日__今納期数_段階補正.get略称(), is(new RString("今年度・基準年額（前年度所得・今年度賦課期日）／今納期数(段階補正)")));
    }

    @Test
    public void 今年度_基準年額_今納期数_一律を指定した場合_get略称は_今年度_基準年額_今納期数_一律を返す() {
        assertThat(FuchoZanteiKeisanHoho.今年度_基準年額_今納期数_一律.get略称(), is(new RString("今年度・基準年額／今納期数（一律）")));
    }

    @Test
    public void 千代田区独自算定を指定した場合_get略称は_千代田区独自算定を返す() {
        assertThat(FuchoZanteiKeisanHoho.千代田区独自算定.get略称(), is(new RString("千代田区独自算定")));
    }

    @Test
    public void その他を指定した場合_get略称は_その他を返す() {
        assertThat(FuchoZanteiKeisanHoho.その他.get略称(), is(new RString("その他")));
    }

}
