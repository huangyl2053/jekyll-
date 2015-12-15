package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 採番汎用キー名称のテストクラスです。
 * 
 * @author LDNS 
 */
public class SaibanHanyokeyNameTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        SaibanHanyokeyName.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        SaibanHanyokeyName.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_文書番号を返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("01")), is(SaibanHanyokeyName.文書番号));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_医療機関コードを返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("02")), is(SaibanHanyokeyName.医療機関コード));
    }

    @Test
    public void 引数に03を指定した場合_toValueは_調査委託先コードを返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("03")), is(SaibanHanyokeyName.調査委託先コード));
    }

    @Test
    public void 引数に04を指定した場合_toValueは_被保険者番号自動採番を返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("04")), is(SaibanHanyokeyName.被保険者番号自動採番));
    }

    @Test
    public void 引数に21を指定した場合_toValueは_被保険者番号自動MCDを返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("21")), is(SaibanHanyokeyName.被保険者番号自動MCD));
    }

    @Test
    public void 引数に05を指定した場合_toValueは_公費受給者番号を返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("05")), is(SaibanHanyokeyName.公費受給者番号));
    }

    @Test
    public void 引数に06を指定した場合_toValueは_償還整理番号を返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("06")), is(SaibanHanyokeyName.償還整理番号));
    }

    @Test
    public void 引数に07を指定した場合_toValueは_実績管理番号を返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("07")), is(SaibanHanyokeyName.実績管理番号));
    }

    @Test
    public void 引数に08を指定した場合_toValueは_08確認番号を返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("08")), is(SaibanHanyokeyName._08確認番号));
    }

    @Test
    public void 引数に09を指定した場合_toValueは_特定住所管理番号を返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("09")), is(SaibanHanyokeyName.特定住所管理番号));
    }

    @Test
    public void 引数に10を指定した場合_toValueは_10確認番号を返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("10")), is(SaibanHanyokeyName._10確認番号));
    }

    @Test
    public void 引数に11を指定した場合_toValueは_受給者番号を返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("11")), is(SaibanHanyokeyName.受給者番号));
    }

    @Test
    public void 引数に12を指定した場合_toValueは_申請書整理番号を返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("12")), is(SaibanHanyokeyName.申請書整理番号));
    }

    @Test
    public void 引数に13を指定した場合_toValueは_証明書整理番号を返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("13")), is(SaibanHanyokeyName.証明書整理番号));
    }

    @Test
    public void 引数に14を指定した場合_toValueは_入浴券整理番号を返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("14")), is(SaibanHanyokeyName.入浴券整理番号));
    }

    @Test
    public void 引数に22を指定した場合_toValueは_契約事業者番号を返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("22")), is(SaibanHanyokeyName.契約事業者番号));
    }

    @Test
    public void 引数に15を指定した場合_toValueは_第三者管理番号を返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("15")), is(SaibanHanyokeyName.第三者管理番号));
    }

    @Test
    public void 引数に91を指定した場合_toValueは_住民コード発番用を返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("91")), is(SaibanHanyokeyName.住民コード発番用));
    }

    @Test
    public void 引数に92を指定した場合_toValueは_世帯コード発番用を返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("92")), is(SaibanHanyokeyName.世帯コード発番用));
    }

    @Test
    public void 引数に93を指定した場合_toValueは_住所コード発番用を返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("93")), is(SaibanHanyokeyName.住所コード発番用));
    }

    @Test
    public void 引数に94を指定した場合_toValueは_行政区コード発番用を返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("94")), is(SaibanHanyokeyName.行政区コード発番用));
    }

    @Test
    public void 引数に95を指定した場合_toValueは_地区コード１発番用を返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("95")), is(SaibanHanyokeyName.地区コード１発番用));
    }

    @Test
    public void 引数に96を指定した場合_toValueは_地区コード２発番用を返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("96")), is(SaibanHanyokeyName.地区コード２発番用));
    }

    @Test
    public void 引数に41を指定した場合_toValueは_商品番号を返す() {
        assertThat(SaibanHanyokeyName.toValue(new RString("41")), is(SaibanHanyokeyName.商品番号));
    }

    @Test
    public void 文書番号を指定した場合_getコードは_01を返す() {
        assertThat(SaibanHanyokeyName.文書番号.getコード(), is(new RString("01")));
    }

    @Test
    public void 医療機関コードを指定した場合_getコードは_02を返す() {
        assertThat(SaibanHanyokeyName.医療機関コード.getコード(), is(new RString("02")));
    }

    @Test
    public void 調査委託先コードを指定した場合_getコードは_03を返す() {
        assertThat(SaibanHanyokeyName.調査委託先コード.getコード(), is(new RString("03")));
    }

    @Test
    public void 被保険者番号自動採番を指定した場合_getコードは_04を返す() {
        assertThat(SaibanHanyokeyName.被保険者番号自動採番.getコード(), is(new RString("04")));
    }

    @Test
    public void 被保険者番号自動MCDを指定した場合_getコードは_21を返す() {
        assertThat(SaibanHanyokeyName.被保険者番号自動MCD.getコード(), is(new RString("21")));
    }

    @Test
    public void 公費受給者番号を指定した場合_getコードは_05を返す() {
        assertThat(SaibanHanyokeyName.公費受給者番号.getコード(), is(new RString("05")));
    }

    @Test
    public void 償還整理番号を指定した場合_getコードは_06を返す() {
        assertThat(SaibanHanyokeyName.償還整理番号.getコード(), is(new RString("06")));
    }

    @Test
    public void 実績管理番号を指定した場合_getコードは_07を返す() {
        assertThat(SaibanHanyokeyName.実績管理番号.getコード(), is(new RString("07")));
    }

    @Test
    public void _08確認番号を指定した場合_getコードは_08を返す() {
        assertThat(SaibanHanyokeyName._08確認番号.getコード(), is(new RString("08")));
    }

    @Test
    public void 特定住所管理番号を指定した場合_getコードは_09を返す() {
        assertThat(SaibanHanyokeyName.特定住所管理番号.getコード(), is(new RString("09")));
    }

    @Test
    public void _10確認番号を指定した場合_getコードは_10を返す() {
        assertThat(SaibanHanyokeyName._10確認番号.getコード(), is(new RString("10")));
    }

    @Test
    public void 受給者番号を指定した場合_getコードは_11を返す() {
        assertThat(SaibanHanyokeyName.受給者番号.getコード(), is(new RString("11")));
    }

    @Test
    public void 申請書整理番号を指定した場合_getコードは_12を返す() {
        assertThat(SaibanHanyokeyName.申請書整理番号.getコード(), is(new RString("12")));
    }

    @Test
    public void 証明書整理番号を指定した場合_getコードは_13を返す() {
        assertThat(SaibanHanyokeyName.証明書整理番号.getコード(), is(new RString("13")));
    }

    @Test
    public void 入浴券整理番号を指定した場合_getコードは_14を返す() {
        assertThat(SaibanHanyokeyName.入浴券整理番号.getコード(), is(new RString("14")));
    }

    @Test
    public void 契約事業者番号を指定した場合_getコードは_22を返す() {
        assertThat(SaibanHanyokeyName.契約事業者番号.getコード(), is(new RString("22")));
    }

    @Test
    public void 第三者管理番号を指定した場合_getコードは_15を返す() {
        assertThat(SaibanHanyokeyName.第三者管理番号.getコード(), is(new RString("15")));
    }

    @Test
    public void 住民コード発番用を指定した場合_getコードは_91を返す() {
        assertThat(SaibanHanyokeyName.住民コード発番用.getコード(), is(new RString("91")));
    }

    @Test
    public void 世帯コード発番用を指定した場合_getコードは_92を返す() {
        assertThat(SaibanHanyokeyName.世帯コード発番用.getコード(), is(new RString("92")));
    }

    @Test
    public void 住所コード発番用を指定した場合_getコードは_93を返す() {
        assertThat(SaibanHanyokeyName.住所コード発番用.getコード(), is(new RString("93")));
    }

    @Test
    public void 行政区コード発番用を指定した場合_getコードは_94を返す() {
        assertThat(SaibanHanyokeyName.行政区コード発番用.getコード(), is(new RString("94")));
    }

    @Test
    public void 地区コード１発番用を指定した場合_getコードは_95を返す() {
        assertThat(SaibanHanyokeyName.地区コード１発番用.getコード(), is(new RString("95")));
    }

    @Test
    public void 地区コード２発番用を指定した場合_getコードは_96を返す() {
        assertThat(SaibanHanyokeyName.地区コード２発番用.getコード(), is(new RString("96")));
    }

    @Test
    public void 商品番号を指定した場合_getコードは_41を返す() {
        assertThat(SaibanHanyokeyName.商品番号.getコード(), is(new RString("41")));
    }

    @Test
    public void 文書番号を指定した場合_get名称は_文書番号を返す() {
        assertThat(SaibanHanyokeyName.文書番号.get名称(), is(new RString("文書番号")));
    }

    @Test
    public void 医療機関コードを指定した場合_get名称は_医療機関コードを返す() {
        assertThat(SaibanHanyokeyName.医療機関コード.get名称(), is(new RString("医療機関コード")));
    }

    @Test
    public void 調査委託先コードを指定した場合_get名称は_調査委託先コードを返す() {
        assertThat(SaibanHanyokeyName.調査委託先コード.get名称(), is(new RString("調査委託先コード")));
    }

    @Test
    public void 被保険者番号自動採番を指定した場合_get名称は_被保険者番号自動採番を返す() {
        assertThat(SaibanHanyokeyName.被保険者番号自動採番.get名称(), is(new RString("被保険者番号自動採番")));
    }

    @Test
    public void 被保険者番号自動MCDを指定した場合_get名称は_被保険者番号自動MCDを返す() {
        assertThat(SaibanHanyokeyName.被保険者番号自動MCD.get名称(), is(new RString("被保険者番号自動MCD")));
    }

    @Test
    public void 公費受給者番号を指定した場合_get名称は_公費受給者番号を返す() {
        assertThat(SaibanHanyokeyName.公費受給者番号.get名称(), is(new RString("公費受給者番号")));
    }

    @Test
    public void 償還整理番号を指定した場合_get名称は_償還整理番号を返す() {
        assertThat(SaibanHanyokeyName.償還整理番号.get名称(), is(new RString("償還整理番号")));
    }

    @Test
    public void 実績管理番号を指定した場合_get名称は_実績管理番号を返す() {
        assertThat(SaibanHanyokeyName.実績管理番号.get名称(), is(new RString("実績管理番号")));
    }

    @Test
    public void _08確認番号を指定した場合_get名称は_確認番号を返す() {
        assertThat(SaibanHanyokeyName._08確認番号.get名称(), is(new RString("確認番号")));
    }

    @Test
    public void 特定住所管理番号を指定した場合_get名称は_特定住所管理番号を返す() {
        assertThat(SaibanHanyokeyName.特定住所管理番号.get名称(), is(new RString("特定住所管理番号")));
    }

    @Test
    public void _10確認番号を指定した場合_get名称は_確認番号を返す() {
        assertThat(SaibanHanyokeyName._10確認番号.get名称(), is(new RString("確認番号")));
    }

    @Test
    public void 受給者番号を指定した場合_get名称は_受給者番号を返す() {
        assertThat(SaibanHanyokeyName.受給者番号.get名称(), is(new RString("受給者番号")));
    }

    @Test
    public void 申請書整理番号を指定した場合_get名称は_申請書整理番号を返す() {
        assertThat(SaibanHanyokeyName.申請書整理番号.get名称(), is(new RString("申請書整理番号")));
    }

    @Test
    public void 証明書整理番号を指定した場合_get名称は_証明書整理番号を返す() {
        assertThat(SaibanHanyokeyName.証明書整理番号.get名称(), is(new RString("証明書整理番号")));
    }

    @Test
    public void 入浴券整理番号を指定した場合_get名称は_入浴券整理番号を返す() {
        assertThat(SaibanHanyokeyName.入浴券整理番号.get名称(), is(new RString("入浴券整理番号")));
    }

    @Test
    public void 契約事業者番号を指定した場合_get名称は_契約事業者番号を返す() {
        assertThat(SaibanHanyokeyName.契約事業者番号.get名称(), is(new RString("契約事業者番号")));
    }

    @Test
    public void 第三者管理番号を指定した場合_get名称は_第三者管理番号を返す() {
        assertThat(SaibanHanyokeyName.第三者管理番号.get名称(), is(new RString("第三者管理番号")));
    }

    @Test
    public void 住民コード発番用を指定した場合_get名称は_住民コード発番用を返す() {
        assertThat(SaibanHanyokeyName.住民コード発番用.get名称(), is(new RString("住民コード発番用")));
    }

    @Test
    public void 世帯コード発番用を指定した場合_get名称は_世帯コード発番用を返す() {
        assertThat(SaibanHanyokeyName.世帯コード発番用.get名称(), is(new RString("世帯コード発番用")));
    }

    @Test
    public void 住所コード発番用を指定した場合_get名称は_住所コード発番用を返す() {
        assertThat(SaibanHanyokeyName.住所コード発番用.get名称(), is(new RString("住所コード発番用")));
    }

    @Test
    public void 行政区コード発番用を指定した場合_get名称は_行政区コード発番用を返す() {
        assertThat(SaibanHanyokeyName.行政区コード発番用.get名称(), is(new RString("行政区コード発番用")));
    }

    @Test
    public void 地区コード１発番用を指定した場合_get名称は_地区コード１発番用を返す() {
        assertThat(SaibanHanyokeyName.地区コード１発番用.get名称(), is(new RString("地区コード１発番用")));
    }

    @Test
    public void 地区コード２発番用を指定した場合_get名称は_地区コード２発番用を返す() {
        assertThat(SaibanHanyokeyName.地区コード２発番用.get名称(), is(new RString("地区コード２発番用")));
    }

    @Test
    public void 商品番号を指定した場合_get名称は_商品番号を返す() {
        assertThat(SaibanHanyokeyName.商品番号.get名称(), is(new RString("商品番号")));
    }

}
