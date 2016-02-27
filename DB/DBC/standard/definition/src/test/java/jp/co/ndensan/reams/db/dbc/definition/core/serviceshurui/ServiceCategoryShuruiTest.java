package jp.co.ndensan.reams.db.dbc.definition.core.serviceshurui;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * サービス種類のテストクラスです。
 * 
 * @author LDNS 
 */
public class ServiceCategoryShuruiTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ServiceCategoryShurui.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ServiceCategoryShurui.toValue(new RString("99999"));
    }

    @Test
    public void 引数に11を指定した場合_toValueは_訪問介護を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("11")), is(ServiceCategoryShurui.訪問介護));
    }

    @Test
    public void 引数に12を指定した場合_toValueは_訪問入浴を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("12")), is(ServiceCategoryShurui.訪問入浴));
    }

    @Test
    public void 引数に13を指定した場合_toValueは_訪問看護を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("13")), is(ServiceCategoryShurui.訪問看護));
    }

    @Test
    public void 引数に14を指定した場合_toValueは_訪問リハを返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("14")), is(ServiceCategoryShurui.訪問リハ));
    }

    @Test
    public void 引数に15を指定した場合_toValueは_通所介護を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("15")), is(ServiceCategoryShurui.通所介護));
    }

    @Test
    public void 引数に16を指定した場合_toValueは_通所リハを返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("16")), is(ServiceCategoryShurui.通所リハ));
    }

    @Test
    public void 引数に17を指定した場合_toValueは_用具貸与を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("17")), is(ServiceCategoryShurui.用具貸与));
    }

    @Test
    public void 引数に21を指定した場合_toValueは_短期生活を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("21")), is(ServiceCategoryShurui.短期生活));
    }

    @Test
    public void 引数に22を指定した場合_toValueは_短期老健を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("22")), is(ServiceCategoryShurui.短期老健));
    }

    @Test
    public void 引数に23を指定した場合_toValueは_短期医療を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("23")), is(ServiceCategoryShurui.短期医療));
    }

    @Test
    public void 引数に24を指定した場合_toValueは_予短介護を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("24")), is(ServiceCategoryShurui.予短介護));
    }

    @Test
    public void 引数に25を指定した場合_toValueは_予短老健を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("25")), is(ServiceCategoryShurui.予短老健));
    }

    @Test
    public void 引数に26を指定した場合_toValueは_予短医療を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("26")), is(ServiceCategoryShurui.予短医療));
    }

    @Test
    public void 引数に27を指定した場合_toValueは_特施短期を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("27")), is(ServiceCategoryShurui.特施短期));
    }

    @Test
    public void 引数に28を指定した場合_toValueは_地施短期を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("28")), is(ServiceCategoryShurui.地施短期));
    }

    @Test
    public void 引数に31を指定した場合_toValueは_療養指導を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("31")), is(ServiceCategoryShurui.療養指導));
    }

    @Test
    public void 引数に32を指定した場合_toValueは_地共同介を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("32")), is(ServiceCategoryShurui.地共同介));
    }

    @Test
    public void 引数に33を指定した場合_toValueは_特施短外を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("33")), is(ServiceCategoryShurui.特施短外));
    }

    @Test
    public void 引数に34を指定した場合_toValueは_予療養指を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("34")), is(ServiceCategoryShurui.予療養指));
    }

    @Test
    public void 引数に35を指定した場合_toValueは_予特施設を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("35")), is(ServiceCategoryShurui.予特施設));
    }

    @Test
    public void 引数に36を指定した場合_toValueは_地施短外を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("36")), is(ServiceCategoryShurui.地施短外));
    }

    @Test
    public void 引数に37を指定した場合_toValueは_地予共同を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("37")), is(ServiceCategoryShurui.地予共同));
    }

    @Test
    public void 引数に38を指定した場合_toValueは_地共同短を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("38")), is(ServiceCategoryShurui.地共同短));
    }

    @Test
    public void 引数に39を指定した場合_toValueは_地予共短を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("39")), is(ServiceCategoryShurui.地予共短));
    }

    @Test
    public void 引数に40を指定した場合_toValueは_ケアマネを返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("40")), is(ServiceCategoryShurui.ケアマネ));
    }

    @Test
    public void 引数に41を指定した場合_toValueは_用具販売を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("41")), is(ServiceCategoryShurui.用具販売));
    }

    @Test
    public void 引数に42を指定した場合_toValueは_住宅改修を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("42")), is(ServiceCategoryShurui.住宅改修));
    }

    @Test
    public void 引数に43を指定した場合_toValueは_居宅支援を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("43")), is(ServiceCategoryShurui.居宅支援));
    }

    @Test
    public void 引数に44を指定した場合_toValueは_予用販売を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("44")), is(ServiceCategoryShurui.予用販売));
    }

    @Test
    public void 引数に45を指定した場合_toValueは_予住改修を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("45")), is(ServiceCategoryShurui.予住改修));
    }

    @Test
    public void 引数に46を指定した場合_toValueは_予防支援を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("46")), is(ServiceCategoryShurui.予防支援));
    }

    @Test
    public void 引数に47を指定した場合_toValueは_生活配食を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("47")), is(ServiceCategoryShurui.生活配食));
    }

    @Test
    public void 引数に48を指定した場合_toValueは_生活見守を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("48")), is(ServiceCategoryShurui.生活見守));
    }

    @Test
    public void 引数に49を指定した場合_toValueは_生活他を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("49")), is(ServiceCategoryShurui.生活他));
    }

    @Test
    public void 引数に50を指定した場合_toValueは_食事費用を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("50")), is(ServiceCategoryShurui.食事費用));
    }

    @Test
    public void 引数に51を指定した場合_toValueは_福祉施設を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("51")), is(ServiceCategoryShurui.福祉施設));
    }

    @Test
    public void 引数に52を指定した場合_toValueは_老健施設を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("52")), is(ServiceCategoryShurui.老健施設));
    }

    @Test
    public void 引数に53を指定した場合_toValueは_医療施設を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("53")), is(ServiceCategoryShurui.医療施設));
    }

    @Test
    public void 引数に54を指定した場合_toValueは_地福祉生を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("54")), is(ServiceCategoryShurui.地福祉生));
    }

    @Test
    public void 引数に59を指定した場合_toValueは_特定入所を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("59")), is(ServiceCategoryShurui.特定入所));
    }

    @Test
    public void 引数に61を指定した場合_toValueは_予訪介護を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("61")), is(ServiceCategoryShurui.予訪介護));
    }

    @Test
    public void 引数に62を指定した場合_toValueは_予訪入浴を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("62")), is(ServiceCategoryShurui.予訪入浴));
    }

    @Test
    public void 引数に63を指定した場合_toValueは_予訪看護を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("63")), is(ServiceCategoryShurui.予訪看護));
    }

    @Test
    public void 引数に64を指定した場合_toValueは_予訪リハを返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("64")), is(ServiceCategoryShurui.予訪リハ));
    }

    @Test
    public void 引数に65を指定した場合_toValueは_予通介護を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("65")), is(ServiceCategoryShurui.予通介護));
    }

    @Test
    public void 引数に66を指定した場合_toValueは_予通リハを返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("66")), is(ServiceCategoryShurui.予通リハ));
    }

    @Test
    public void 引数に67を指定した場合_toValueは_予用貸与を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("67")), is(ServiceCategoryShurui.予用貸与));
    }

    @Test
    public void 引数に71を指定した場合_toValueは_地夜間訪を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("71")), is(ServiceCategoryShurui.地夜間訪));
    }

    @Test
    public void 引数に72を指定した場合_toValueは_地通所介を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("72")), is(ServiceCategoryShurui.地通所介));
    }

    @Test
    public void 引数に73を指定した場合_toValueは_地小短外を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("73")), is(ServiceCategoryShurui.地小短外));
    }

    @Test
    public void 引数に74を指定した場合_toValueは_地予通所を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("74")), is(ServiceCategoryShurui.地予通所));
    }

    @Test
    public void 引数に75を指定した場合_toValueは_地予小外を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("75")), is(ServiceCategoryShurui.地予小外));
    }

    @Test
    public void 引数に76を指定した場合_toValueは_定期随時を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("76")), is(ServiceCategoryShurui.定期随時));
    }

    @Test
    public void 引数に77を指定した場合_toValueは_看小短外を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("77")), is(ServiceCategoryShurui.看小短外));
    }

    @Test
    public void 引数に81を指定した場合_toValueは_特別給付を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("81")), is(ServiceCategoryShurui.特別給付));
    }

    @Test
    public void 引数に82を指定した場合_toValueは_総訪予防を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("82")), is(ServiceCategoryShurui.総訪予防));
    }

    @Test
    public void 引数に83を指定した場合_toValueは_総通予防を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("83")), is(ServiceCategoryShurui.総通予防));
    }

    @Test
    public void 引数に84を指定した場合_toValueは_総訪入浴を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("84")), is(ServiceCategoryShurui.総訪入浴));
    }

    @Test
    public void 引数に85を指定した場合_toValueは_総訪看護を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("85")), is(ServiceCategoryShurui.総訪看護));
    }

    @Test
    public void 引数に86を指定した場合_toValueは_総訪リハを返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("86")), is(ServiceCategoryShurui.総訪リハ));
    }

    @Test
    public void 引数に87を指定した場合_toValueは_総通リハを返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("87")), is(ServiceCategoryShurui.総通リハ));
    }

    @Test
    public void 引数に88を指定した場合_toValueは_総用貸与を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("88")), is(ServiceCategoryShurui.総用貸与));
    }

    @Test
    public void 引数に89を指定した場合_toValueは_総短介護を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("89")), is(ServiceCategoryShurui.総短介護));
    }

    @Test
    public void 引数に90を指定した場合_toValueは_総短老健を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("90")), is(ServiceCategoryShurui.総短老健));
    }

    @Test
    public void 引数に91を指定した場合_toValueは_総短医療を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("91")), is(ServiceCategoryShurui.総短医療));
    }

    @Test
    public void 引数に92を指定した場合_toValueは_総療養指を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("92")), is(ServiceCategoryShurui.総療養指));
    }

    @Test
    public void 引数に93を指定した場合_toValueは_総特施設を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("93")), is(ServiceCategoryShurui.総特施設));
    }

    @Test
    public void 引数に94を指定した場合_toValueは_地総通所を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("94")), is(ServiceCategoryShurui.地総通所));
    }

    @Test
    public void 引数に95を指定した場合_toValueは_地総小規を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("95")), is(ServiceCategoryShurui.地総小規));
    }

    @Test
    public void 引数に96を指定した場合_toValueは_地総共同を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("96")), is(ServiceCategoryShurui.地総共同));
    }

    @Test
    public void 引数に97を指定した場合_toValueは_地総共短を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("97")), is(ServiceCategoryShurui.地総共短));
    }

    @Test
    public void 引数にA1を指定した場合_toValueは_訪問みなを返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("A1")), is(ServiceCategoryShurui.訪問みな));
    }

    @Test
    public void 引数にA2を指定した場合_toValueは_訪問独自を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("A2")), is(ServiceCategoryShurui.訪問独自));
    }

    @Test
    public void 引数にA3を指定した場合_toValueは_訪問定率を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("A3")), is(ServiceCategoryShurui.訪問定率));
    }

    @Test
    public void 引数にA4を指定した場合_toValueは_訪問定額を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("A4")), is(ServiceCategoryShurui.訪問定額));
    }

    @Test
    public void 引数にA5を指定した場合_toValueは_通所みなを返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("A5")), is(ServiceCategoryShurui.通所みな));
    }

    @Test
    public void 引数にA6を指定した場合_toValueは_通所独自を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("A6")), is(ServiceCategoryShurui.通所独自));
    }

    @Test
    public void 引数にA7を指定した場合_toValueは_通所定率を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("A7")), is(ServiceCategoryShurui.通所定率));
    }

    @Test
    public void 引数にA8を指定した場合_toValueは_通所定額を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("A8")), is(ServiceCategoryShurui.通所定額));
    }

    @Test
    public void 引数にA9を指定した場合_toValueは_配食定率を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("A9")), is(ServiceCategoryShurui.配食定率));
    }

    @Test
    public void 引数にAAを指定した場合_toValueは_配食定額を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("AA")), is(ServiceCategoryShurui.配食定額));
    }

    @Test
    public void 引数にABを指定した場合_toValueは_見守定率を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("AB")), is(ServiceCategoryShurui.見守定率));
    }

    @Test
    public void 引数にACを指定した場合_toValueは_見守定額を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("AC")), is(ServiceCategoryShurui.見守定額));
    }

    @Test
    public void 引数にADを指定した場合_toValueは_その他率を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("AD")), is(ServiceCategoryShurui.その他率));
    }

    @Test
    public void 引数にAEを指定した場合_toValueは_その他額を返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("AE")), is(ServiceCategoryShurui.その他額));
    }

    @Test
    public void 引数にAFを指定した場合_toValueは_予防ケアを返す() {
        assertThat(ServiceCategoryShurui.toValue(new RString("AF")), is(ServiceCategoryShurui.予防ケア));
    }

    @Test
    public void 訪問介護を指定した場合_getコードは_11を返す() {
        assertThat(ServiceCategoryShurui.訪問介護.getコード(), is(new RString("11")));
    }

    @Test
    public void 訪問入浴を指定した場合_getコードは_12を返す() {
        assertThat(ServiceCategoryShurui.訪問入浴.getコード(), is(new RString("12")));
    }

    @Test
    public void 訪問看護を指定した場合_getコードは_13を返す() {
        assertThat(ServiceCategoryShurui.訪問看護.getコード(), is(new RString("13")));
    }

    @Test
    public void 訪問リハを指定した場合_getコードは_14を返す() {
        assertThat(ServiceCategoryShurui.訪問リハ.getコード(), is(new RString("14")));
    }

    @Test
    public void 通所介護を指定した場合_getコードは_15を返す() {
        assertThat(ServiceCategoryShurui.通所介護.getコード(), is(new RString("15")));
    }

    @Test
    public void 通所リハを指定した場合_getコードは_16を返す() {
        assertThat(ServiceCategoryShurui.通所リハ.getコード(), is(new RString("16")));
    }

    @Test
    public void 用具貸与を指定した場合_getコードは_17を返す() {
        assertThat(ServiceCategoryShurui.用具貸与.getコード(), is(new RString("17")));
    }

    @Test
    public void 短期生活を指定した場合_getコードは_21を返す() {
        assertThat(ServiceCategoryShurui.短期生活.getコード(), is(new RString("21")));
    }

    @Test
    public void 短期老健を指定した場合_getコードは_22を返す() {
        assertThat(ServiceCategoryShurui.短期老健.getコード(), is(new RString("22")));
    }

    @Test
    public void 短期医療を指定した場合_getコードは_23を返す() {
        assertThat(ServiceCategoryShurui.短期医療.getコード(), is(new RString("23")));
    }

    @Test
    public void 予短介護を指定した場合_getコードは_24を返す() {
        assertThat(ServiceCategoryShurui.予短介護.getコード(), is(new RString("24")));
    }

    @Test
    public void 予短老健を指定した場合_getコードは_25を返す() {
        assertThat(ServiceCategoryShurui.予短老健.getコード(), is(new RString("25")));
    }

    @Test
    public void 予短医療を指定した場合_getコードは_26を返す() {
        assertThat(ServiceCategoryShurui.予短医療.getコード(), is(new RString("26")));
    }

    @Test
    public void 特施短期を指定した場合_getコードは_27を返す() {
        assertThat(ServiceCategoryShurui.特施短期.getコード(), is(new RString("27")));
    }

    @Test
    public void 地施短期を指定した場合_getコードは_28を返す() {
        assertThat(ServiceCategoryShurui.地施短期.getコード(), is(new RString("28")));
    }

    @Test
    public void 療養指導を指定した場合_getコードは_31を返す() {
        assertThat(ServiceCategoryShurui.療養指導.getコード(), is(new RString("31")));
    }

    @Test
    public void 地共同介を指定した場合_getコードは_32を返す() {
        assertThat(ServiceCategoryShurui.地共同介.getコード(), is(new RString("32")));
    }

    @Test
    public void 特施短外を指定した場合_getコードは_33を返す() {
        assertThat(ServiceCategoryShurui.特施短外.getコード(), is(new RString("33")));
    }

    @Test
    public void 予療養指を指定した場合_getコードは_34を返す() {
        assertThat(ServiceCategoryShurui.予療養指.getコード(), is(new RString("34")));
    }

    @Test
    public void 予特施設を指定した場合_getコードは_35を返す() {
        assertThat(ServiceCategoryShurui.予特施設.getコード(), is(new RString("35")));
    }

    @Test
    public void 地施短外を指定した場合_getコードは_36を返す() {
        assertThat(ServiceCategoryShurui.地施短外.getコード(), is(new RString("36")));
    }

    @Test
    public void 地予共同を指定した場合_getコードは_37を返す() {
        assertThat(ServiceCategoryShurui.地予共同.getコード(), is(new RString("37")));
    }

    @Test
    public void 地共同短を指定した場合_getコードは_38を返す() {
        assertThat(ServiceCategoryShurui.地共同短.getコード(), is(new RString("38")));
    }

    @Test
    public void 地予共短を指定した場合_getコードは_39を返す() {
        assertThat(ServiceCategoryShurui.地予共短.getコード(), is(new RString("39")));
    }

    @Test
    public void ケアマネを指定した場合_getコードは_40を返す() {
        assertThat(ServiceCategoryShurui.ケアマネ.getコード(), is(new RString("40")));
    }

    @Test
    public void 用具販売を指定した場合_getコードは_41を返す() {
        assertThat(ServiceCategoryShurui.用具販売.getコード(), is(new RString("41")));
    }

    @Test
    public void 住宅改修を指定した場合_getコードは_42を返す() {
        assertThat(ServiceCategoryShurui.住宅改修.getコード(), is(new RString("42")));
    }

    @Test
    public void 居宅支援を指定した場合_getコードは_43を返す() {
        assertThat(ServiceCategoryShurui.居宅支援.getコード(), is(new RString("43")));
    }

    @Test
    public void 予用販売を指定した場合_getコードは_44を返す() {
        assertThat(ServiceCategoryShurui.予用販売.getコード(), is(new RString("44")));
    }

    @Test
    public void 予住改修を指定した場合_getコードは_45を返す() {
        assertThat(ServiceCategoryShurui.予住改修.getコード(), is(new RString("45")));
    }

    @Test
    public void 予防支援を指定した場合_getコードは_46を返す() {
        assertThat(ServiceCategoryShurui.予防支援.getコード(), is(new RString("46")));
    }

    @Test
    public void 生活配食を指定した場合_getコードは_47を返す() {
        assertThat(ServiceCategoryShurui.生活配食.getコード(), is(new RString("47")));
    }

    @Test
    public void 生活見守を指定した場合_getコードは_48を返す() {
        assertThat(ServiceCategoryShurui.生活見守.getコード(), is(new RString("48")));
    }

    @Test
    public void 生活他を指定した場合_getコードは_49を返す() {
        assertThat(ServiceCategoryShurui.生活他.getコード(), is(new RString("49")));
    }

    @Test
    public void 食事費用を指定した場合_getコードは_50を返す() {
        assertThat(ServiceCategoryShurui.食事費用.getコード(), is(new RString("50")));
    }

    @Test
    public void 福祉施設を指定した場合_getコードは_51を返す() {
        assertThat(ServiceCategoryShurui.福祉施設.getコード(), is(new RString("51")));
    }

    @Test
    public void 老健施設を指定した場合_getコードは_52を返す() {
        assertThat(ServiceCategoryShurui.老健施設.getコード(), is(new RString("52")));
    }

    @Test
    public void 医療施設を指定した場合_getコードは_53を返す() {
        assertThat(ServiceCategoryShurui.医療施設.getコード(), is(new RString("53")));
    }

    @Test
    public void 地福祉生を指定した場合_getコードは_54を返す() {
        assertThat(ServiceCategoryShurui.地福祉生.getコード(), is(new RString("54")));
    }

    @Test
    public void 特定入所を指定した場合_getコードは_59を返す() {
        assertThat(ServiceCategoryShurui.特定入所.getコード(), is(new RString("59")));
    }

    @Test
    public void 予訪介護を指定した場合_getコードは_61を返す() {
        assertThat(ServiceCategoryShurui.予訪介護.getコード(), is(new RString("61")));
    }

    @Test
    public void 予訪入浴を指定した場合_getコードは_62を返す() {
        assertThat(ServiceCategoryShurui.予訪入浴.getコード(), is(new RString("62")));
    }

    @Test
    public void 予訪看護を指定した場合_getコードは_63を返す() {
        assertThat(ServiceCategoryShurui.予訪看護.getコード(), is(new RString("63")));
    }

    @Test
    public void 予訪リハを指定した場合_getコードは_64を返す() {
        assertThat(ServiceCategoryShurui.予訪リハ.getコード(), is(new RString("64")));
    }

    @Test
    public void 予通介護を指定した場合_getコードは_65を返す() {
        assertThat(ServiceCategoryShurui.予通介護.getコード(), is(new RString("65")));
    }

    @Test
    public void 予通リハを指定した場合_getコードは_66を返す() {
        assertThat(ServiceCategoryShurui.予通リハ.getコード(), is(new RString("66")));
    }

    @Test
    public void 予用貸与を指定した場合_getコードは_67を返す() {
        assertThat(ServiceCategoryShurui.予用貸与.getコード(), is(new RString("67")));
    }

    @Test
    public void 地夜間訪を指定した場合_getコードは_71を返す() {
        assertThat(ServiceCategoryShurui.地夜間訪.getコード(), is(new RString("71")));
    }

    @Test
    public void 地通所介を指定した場合_getコードは_72を返す() {
        assertThat(ServiceCategoryShurui.地通所介.getコード(), is(new RString("72")));
    }

    @Test
    public void 地小短外を指定した場合_getコードは_73を返す() {
        assertThat(ServiceCategoryShurui.地小短外.getコード(), is(new RString("73")));
    }

    @Test
    public void 地予通所を指定した場合_getコードは_74を返す() {
        assertThat(ServiceCategoryShurui.地予通所.getコード(), is(new RString("74")));
    }

    @Test
    public void 地予小外を指定した場合_getコードは_75を返す() {
        assertThat(ServiceCategoryShurui.地予小外.getコード(), is(new RString("75")));
    }

    @Test
    public void 定期随時を指定した場合_getコードは_76を返す() {
        assertThat(ServiceCategoryShurui.定期随時.getコード(), is(new RString("76")));
    }

    @Test
    public void 看小短外を指定した場合_getコードは_77を返す() {
        assertThat(ServiceCategoryShurui.看小短外.getコード(), is(new RString("77")));
    }

    @Test
    public void 特別給付を指定した場合_getコードは_81を返す() {
        assertThat(ServiceCategoryShurui.特別給付.getコード(), is(new RString("81")));
    }

    @Test
    public void 総訪予防を指定した場合_getコードは_82を返す() {
        assertThat(ServiceCategoryShurui.総訪予防.getコード(), is(new RString("82")));
    }

    @Test
    public void 総通予防を指定した場合_getコードは_83を返す() {
        assertThat(ServiceCategoryShurui.総通予防.getコード(), is(new RString("83")));
    }

    @Test
    public void 総訪入浴を指定した場合_getコードは_84を返す() {
        assertThat(ServiceCategoryShurui.総訪入浴.getコード(), is(new RString("84")));
    }

    @Test
    public void 総訪看護を指定した場合_getコードは_85を返す() {
        assertThat(ServiceCategoryShurui.総訪看護.getコード(), is(new RString("85")));
    }

    @Test
    public void 総訪リハを指定した場合_getコードは_86を返す() {
        assertThat(ServiceCategoryShurui.総訪リハ.getコード(), is(new RString("86")));
    }

    @Test
    public void 総通リハを指定した場合_getコードは_87を返す() {
        assertThat(ServiceCategoryShurui.総通リハ.getコード(), is(new RString("87")));
    }

    @Test
    public void 総用貸与を指定した場合_getコードは_88を返す() {
        assertThat(ServiceCategoryShurui.総用貸与.getコード(), is(new RString("88")));
    }

    @Test
    public void 総短介護を指定した場合_getコードは_89を返す() {
        assertThat(ServiceCategoryShurui.総短介護.getコード(), is(new RString("89")));
    }

    @Test
    public void 総短老健を指定した場合_getコードは_90を返す() {
        assertThat(ServiceCategoryShurui.総短老健.getコード(), is(new RString("90")));
    }

    @Test
    public void 総短医療を指定した場合_getコードは_91を返す() {
        assertThat(ServiceCategoryShurui.総短医療.getコード(), is(new RString("91")));
    }

    @Test
    public void 総療養指を指定した場合_getコードは_92を返す() {
        assertThat(ServiceCategoryShurui.総療養指.getコード(), is(new RString("92")));
    }

    @Test
    public void 総特施設を指定した場合_getコードは_93を返す() {
        assertThat(ServiceCategoryShurui.総特施設.getコード(), is(new RString("93")));
    }

    @Test
    public void 地総通所を指定した場合_getコードは_94を返す() {
        assertThat(ServiceCategoryShurui.地総通所.getコード(), is(new RString("94")));
    }

    @Test
    public void 地総小規を指定した場合_getコードは_95を返す() {
        assertThat(ServiceCategoryShurui.地総小規.getコード(), is(new RString("95")));
    }

    @Test
    public void 地総共同を指定した場合_getコードは_96を返す() {
        assertThat(ServiceCategoryShurui.地総共同.getコード(), is(new RString("96")));
    }

    @Test
    public void 地総共短を指定した場合_getコードは_97を返す() {
        assertThat(ServiceCategoryShurui.地総共短.getコード(), is(new RString("97")));
    }

    @Test
    public void 訪問みなを指定した場合_getコードは_A1を返す() {
        assertThat(ServiceCategoryShurui.訪問みな.getコード(), is(new RString("A1")));
    }

    @Test
    public void 訪問独自を指定した場合_getコードは_A2を返す() {
        assertThat(ServiceCategoryShurui.訪問独自.getコード(), is(new RString("A2")));
    }

    @Test
    public void 訪問定率を指定した場合_getコードは_A3を返す() {
        assertThat(ServiceCategoryShurui.訪問定率.getコード(), is(new RString("A3")));
    }

    @Test
    public void 訪問定額を指定した場合_getコードは_A4を返す() {
        assertThat(ServiceCategoryShurui.訪問定額.getコード(), is(new RString("A4")));
    }

    @Test
    public void 通所みなを指定した場合_getコードは_A5を返す() {
        assertThat(ServiceCategoryShurui.通所みな.getコード(), is(new RString("A5")));
    }

    @Test
    public void 通所独自を指定した場合_getコードは_A6を返す() {
        assertThat(ServiceCategoryShurui.通所独自.getコード(), is(new RString("A6")));
    }

    @Test
    public void 通所定率を指定した場合_getコードは_A7を返す() {
        assertThat(ServiceCategoryShurui.通所定率.getコード(), is(new RString("A7")));
    }

    @Test
    public void 通所定額を指定した場合_getコードは_A8を返す() {
        assertThat(ServiceCategoryShurui.通所定額.getコード(), is(new RString("A8")));
    }

    @Test
    public void 配食定率を指定した場合_getコードは_A9を返す() {
        assertThat(ServiceCategoryShurui.配食定率.getコード(), is(new RString("A9")));
    }

    @Test
    public void 配食定額を指定した場合_getコードは_AAを返す() {
        assertThat(ServiceCategoryShurui.配食定額.getコード(), is(new RString("AA")));
    }

    @Test
    public void 見守定率を指定した場合_getコードは_ABを返す() {
        assertThat(ServiceCategoryShurui.見守定率.getコード(), is(new RString("AB")));
    }

    @Test
    public void 見守定額を指定した場合_getコードは_ACを返す() {
        assertThat(ServiceCategoryShurui.見守定額.getコード(), is(new RString("AC")));
    }

    @Test
    public void その他率を指定した場合_getコードは_ADを返す() {
        assertThat(ServiceCategoryShurui.その他率.getコード(), is(new RString("AD")));
    }

    @Test
    public void その他額を指定した場合_getコードは_AEを返す() {
        assertThat(ServiceCategoryShurui.その他額.getコード(), is(new RString("AE")));
    }

    @Test
    public void 予防ケアを指定した場合_getコードは_AFを返す() {
        assertThat(ServiceCategoryShurui.予防ケア.getコード(), is(new RString("AF")));
    }

    @Test
    public void 訪問介護を指定した場合_get名称は_訪問介護を返す() {
        assertThat(ServiceCategoryShurui.訪問介護.get名称(), is(new RString("訪問介護")));
    }

    @Test
    public void 訪問入浴を指定した場合_get名称は_訪問入浴介護を返す() {
        assertThat(ServiceCategoryShurui.訪問入浴.get名称(), is(new RString("訪問入浴介護")));
    }

    @Test
    public void 訪問看護を指定した場合_get名称は_訪問看護を返す() {
        assertThat(ServiceCategoryShurui.訪問看護.get名称(), is(new RString("訪問看護")));
    }

    @Test
    public void 訪問リハを指定した場合_get名称は_訪問リハビリテーションを返す() {
        assertThat(ServiceCategoryShurui.訪問リハ.get名称(), is(new RString("訪問リハビリテーション")));
    }

    @Test
    public void 通所介護を指定した場合_get名称は_通所介護を返す() {
        assertThat(ServiceCategoryShurui.通所介護.get名称(), is(new RString("通所介護")));
    }

    @Test
    public void 通所リハを指定した場合_get名称は_通所リハビリテーションを返す() {
        assertThat(ServiceCategoryShurui.通所リハ.get名称(), is(new RString("通所リハビリテーション")));
    }

    @Test
    public void 用具貸与を指定した場合_get名称は_福祉用具貸与を返す() {
        assertThat(ServiceCategoryShurui.用具貸与.get名称(), is(new RString("福祉用具貸与")));
    }

    @Test
    public void 短期生活を指定した場合_get名称は_短期入所生活介護を返す() {
        assertThat(ServiceCategoryShurui.短期生活.get名称(), is(new RString("短期入所生活介護")));
    }

    @Test
    public void 短期老健を指定した場合_get名称は_短期入所療養介護_老健施設を返す() {
        assertThat(ServiceCategoryShurui.短期老健.get名称(), is(new RString("短期入所療養介護（老健施設）")));
    }

    @Test
    public void 短期医療を指定した場合_get名称は_短期入所療養介護_医療施設を返す() {
        assertThat(ServiceCategoryShurui.短期医療.get名称(), is(new RString("短期入所療養介護（医療施設）")));
    }

    @Test
    public void 予短介護を指定した場合_get名称は_予防短期入所生活介護を返す() {
        assertThat(ServiceCategoryShurui.予短介護.get名称(), is(new RString("予防短期入所生活介護")));
    }

    @Test
    public void 予短老健を指定した場合_get名称は_予防短期入所療養介護_老健を返す() {
        assertThat(ServiceCategoryShurui.予短老健.get名称(), is(new RString("予防短期入所療養介護（老健）")));
    }

    @Test
    public void 予短医療を指定した場合_get名称は_予防短期入所療養介護_医療を返す() {
        assertThat(ServiceCategoryShurui.予短医療.get名称(), is(new RString("予防短期入所療養介護（医療）")));
    }

    @Test
    public void 特施短期を指定した場合_get名称は_特定施設生活介護_短期を返す() {
        assertThat(ServiceCategoryShurui.特施短期.get名称(), is(new RString("特定施設生活介護（短期）")));
    }

    @Test
    public void 地施短期を指定した場合_get名称は_地域特定施設生活_短期を返す() {
        assertThat(ServiceCategoryShurui.地施短期.get名称(), is(new RString("地域特定施設生活（短期）")));
    }

    @Test
    public void 療養指導を指定した場合_get名称は_居宅療養管理指導を返す() {
        assertThat(ServiceCategoryShurui.療養指導.get名称(), is(new RString("居宅療養管理指導")));
    }

    @Test
    public void 地共同介を指定した場合_get名称は_認知症対応型共同生活を返す() {
        assertThat(ServiceCategoryShurui.地共同介.get名称(), is(new RString("認知症対応型共同生活")));
    }

    @Test
    public void 特施短外を指定した場合_get名称は_特定施設生活介護_短期以外を返す() {
        assertThat(ServiceCategoryShurui.特施短外.get名称(), is(new RString("特定施設生活介護（短期以外）")));
    }

    @Test
    public void 予療養指を指定した場合_get名称は_予防居宅療養管理指導を返す() {
        assertThat(ServiceCategoryShurui.予療養指.get名称(), is(new RString("予防居宅療養管理指導")));
    }

    @Test
    public void 予特施設を指定した場合_get名称は_予防特定施設入居者生活介護を返す() {
        assertThat(ServiceCategoryShurui.予特施設.get名称(), is(new RString("予防特定施設入居者生活介護")));
    }

    @Test
    public void 地施短外を指定した場合_get名称は_地域特定施設生活_短期以外を返す() {
        assertThat(ServiceCategoryShurui.地施短外.get名称(), is(new RString("地域特定施設生活（短期以外）")));
    }

    @Test
    public void 地予共同を指定した場合_get名称は_予防認知症型共同生活を返す() {
        assertThat(ServiceCategoryShurui.地予共同.get名称(), is(new RString("予防認知症型共同生活")));
    }

    @Test
    public void 地共同短を指定した場合_get名称は_認知症対応型共同生活_短期を返す() {
        assertThat(ServiceCategoryShurui.地共同短.get名称(), is(new RString("認知症対応型共同生活（短期）")));
    }

    @Test
    public void 地予共短を指定した場合_get名称は_予防認知症型共同生活_短期を返す() {
        assertThat(ServiceCategoryShurui.地予共短.get名称(), is(new RString("予防認知症型共同生活（短期）")));
    }

    @Test
    public void ケアマネを指定した場合_get名称は_ケアマネジメントを返す() {
        assertThat(ServiceCategoryShurui.ケアマネ.get名称(), is(new RString("ケアマネジメント")));
    }

    @Test
    public void 用具販売を指定した場合_get名称は_特定福祉用具販売を返す() {
        assertThat(ServiceCategoryShurui.用具販売.get名称(), is(new RString("特定福祉用具販売")));
    }

    @Test
    public void 住宅改修を指定した場合_get名称は_住宅改修を返す() {
        assertThat(ServiceCategoryShurui.住宅改修.get名称(), is(new RString("住宅改修")));
    }

    @Test
    public void 居宅支援を指定した場合_get名称は_居宅介護支援を返す() {
        assertThat(ServiceCategoryShurui.居宅支援.get名称(), is(new RString("居宅介護支援")));
    }

    @Test
    public void 予用販売を指定した場合_get名称は_特定予防福祉用具販売を返す() {
        assertThat(ServiceCategoryShurui.予用販売.get名称(), is(new RString("特定予防福祉用具販売")));
    }

    @Test
    public void 予住改修を指定した場合_get名称は_予防住宅改修を返す() {
        assertThat(ServiceCategoryShurui.予住改修.get名称(), is(new RString("予防住宅改修")));
    }

    @Test
    public void 予防支援を指定した場合_get名称は_予防支援を返す() {
        assertThat(ServiceCategoryShurui.予防支援.get名称(), is(new RString("予防支援")));
    }

    @Test
    public void 生活配食を指定した場合_get名称は_生活支援サービス_配食を返す() {
        assertThat(ServiceCategoryShurui.生活配食.get名称(), is(new RString("生活支援サービス（配食）")));
    }

    @Test
    public void 生活見守を指定した場合_get名称は_生活支援サービス_見守りを返す() {
        assertThat(ServiceCategoryShurui.生活見守.get名称(), is(new RString("生活支援サービス（見守り）")));
    }

    @Test
    public void 生活他を指定した場合_get名称は_生活支援サービス_その他を返す() {
        assertThat(ServiceCategoryShurui.生活他.get名称(), is(new RString("生活支援サービス（その他）")));
    }

    @Test
    public void 食事費用を指定した場合_get名称は_食事提供費を返す() {
        assertThat(ServiceCategoryShurui.食事費用.get名称(), is(new RString("食事提供費")));
    }

    @Test
    public void 福祉施設を指定した場合_get名称は_介護老人福祉施設サービスを返す() {
        assertThat(ServiceCategoryShurui.福祉施設.get名称(), is(new RString("介護老人福祉施設サービス")));
    }

    @Test
    public void 老健施設を指定した場合_get名称は_介護老人保健施設サービスを返す() {
        assertThat(ServiceCategoryShurui.老健施設.get名称(), is(new RString("介護老人保健施設サービス")));
    }

    @Test
    public void 医療施設を指定した場合_get名称は_介護療養型医療施設サービスを返す() {
        assertThat(ServiceCategoryShurui.医療施設.get名称(), is(new RString("介護療養型医療施設サービス")));
    }

    @Test
    public void 地福祉生を指定した場合_get名称は_地域密着型介護老人福祉施設を返す() {
        assertThat(ServiceCategoryShurui.地福祉生.get名称(), is(new RString("地域密着型介護老人福祉施設")));
    }

    @Test
    public void 特定入所を指定した場合_get名称は_特定入所者介護サービス等を返す() {
        assertThat(ServiceCategoryShurui.特定入所.get名称(), is(new RString("特定入所者介護サービス等")));
    }

    @Test
    public void 予訪介護を指定した場合_get名称は_予防訪問介護を返す() {
        assertThat(ServiceCategoryShurui.予訪介護.get名称(), is(new RString("予防訪問介護")));
    }

    @Test
    public void 予訪入浴を指定した場合_get名称は_予防訪問入浴介護を返す() {
        assertThat(ServiceCategoryShurui.予訪入浴.get名称(), is(new RString("予防訪問入浴介護")));
    }

    @Test
    public void 予訪看護を指定した場合_get名称は_予防訪問看護を返す() {
        assertThat(ServiceCategoryShurui.予訪看護.get名称(), is(new RString("予防訪問看護")));
    }

    @Test
    public void 予訪リハを指定した場合_get名称は_予防訪問リハビリテーションを返す() {
        assertThat(ServiceCategoryShurui.予訪リハ.get名称(), is(new RString("予防訪問リハビリテーション")));
    }

    @Test
    public void 予通介護を指定した場合_get名称は_予防通所介護を返す() {
        assertThat(ServiceCategoryShurui.予通介護.get名称(), is(new RString("予防通所介護")));
    }

    @Test
    public void 予通リハを指定した場合_get名称は_予防通所リハビリテーションを返す() {
        assertThat(ServiceCategoryShurui.予通リハ.get名称(), is(new RString("予防通所リハビリテーション")));
    }

    @Test
    public void 予用貸与を指定した場合_get名称は_予防福祉用具貸与を返す() {
        assertThat(ServiceCategoryShurui.予用貸与.get名称(), is(new RString("予防福祉用具貸与")));
    }

    @Test
    public void 地夜間訪を指定した場合_get名称は_夜間対応型訪問介護を返す() {
        assertThat(ServiceCategoryShurui.地夜間訪.get名称(), is(new RString("夜間対応型訪問介護")));
    }

    @Test
    public void 地通所介を指定した場合_get名称は_認知症対応型通所介護を返す() {
        assertThat(ServiceCategoryShurui.地通所介.get名称(), is(new RString("認知症対応型通所介護")));
    }

    @Test
    public void 地小短外を指定した場合_get名称は_小規模多機能型居宅_短期以外を返す() {
        assertThat(ServiceCategoryShurui.地小短外.get名称(), is(new RString("小規模多機能型居宅（短期以外）")));
    }

    @Test
    public void 地予通所を指定した場合_get名称は_予防認知症対応型通所介護を返す() {
        assertThat(ServiceCategoryShurui.地予通所.get名称(), is(new RString("予防認知症対応型通所介護")));
    }

    @Test
    public void 地予小外を指定した場合_get名称は_予防小規模多機能型_短期以外を返す() {
        assertThat(ServiceCategoryShurui.地予小外.get名称(), is(new RString("予防小規模多機能型（短期以外）")));
    }

    @Test
    public void 定期随時を指定した場合_get名称は_定期巡回_随時対応型訪問介護を返す() {
        assertThat(ServiceCategoryShurui.定期随時.get名称(), is(new RString("定期巡回・随時対応型訪問介護")));
    }

    @Test
    public void 看小短外を指定した場合_get名称は_看護小規模多機能型_短期以外を返す() {
        assertThat(ServiceCategoryShurui.看小短外.get名称(), is(new RString("看護小規模多機能型（短期以外）")));
    }

    @Test
    public void 特別給付を指定した場合_get名称は_市町村特別給付を返す() {
        assertThat(ServiceCategoryShurui.特別給付.get名称(), is(new RString("市町村特別給付")));
    }

    @Test
    public void 総訪予防を指定した場合_get名称は_総合訪問型予防サービスを返す() {
        assertThat(ServiceCategoryShurui.総訪予防.get名称(), is(new RString("総合訪問型予防サービス")));
    }

    @Test
    public void 総通予防を指定した場合_get名称は_総合通所型予防サービスを返す() {
        assertThat(ServiceCategoryShurui.総通予防.get名称(), is(new RString("総合通所型予防サービス")));
    }

    @Test
    public void 総訪入浴を指定した場合_get名称は_総合訪問入浴介護を返す() {
        assertThat(ServiceCategoryShurui.総訪入浴.get名称(), is(new RString("総合訪問入浴介護")));
    }

    @Test
    public void 総訪看護を指定した場合_get名称は_総合訪問看護を返す() {
        assertThat(ServiceCategoryShurui.総訪看護.get名称(), is(new RString("総合訪問看護")));
    }

    @Test
    public void 総訪リハを指定した場合_get名称は_総合訪問リハビリテーションを返す() {
        assertThat(ServiceCategoryShurui.総訪リハ.get名称(), is(new RString("総合訪問リハビリテーション")));
    }

    @Test
    public void 総通リハを指定した場合_get名称は_総合通所リハビリテーションを返す() {
        assertThat(ServiceCategoryShurui.総通リハ.get名称(), is(new RString("総合通所リハビリテーション")));
    }

    @Test
    public void 総用貸与を指定した場合_get名称は_総合福祉用具貸与を返す() {
        assertThat(ServiceCategoryShurui.総用貸与.get名称(), is(new RString("総合福祉用具貸与")));
    }

    @Test
    public void 総短介護を指定した場合_get名称は_総合短期入所生活介護を返す() {
        assertThat(ServiceCategoryShurui.総短介護.get名称(), is(new RString("総合短期入所生活介護")));
    }

    @Test
    public void 総短老健を指定した場合_get名称は_総合短期入所療養介護_老健を返す() {
        assertThat(ServiceCategoryShurui.総短老健.get名称(), is(new RString("総合短期入所療養介護（老健）")));
    }

    @Test
    public void 総短医療を指定した場合_get名称は_総合短期入所療養介護_医療を返す() {
        assertThat(ServiceCategoryShurui.総短医療.get名称(), is(new RString("総合短期入所療養介護（医療）")));
    }

    @Test
    public void 総療養指を指定した場合_get名称は_総合居宅療養管理指導を返す() {
        assertThat(ServiceCategoryShurui.総療養指.get名称(), is(new RString("総合居宅療養管理指導")));
    }

    @Test
    public void 総特施設を指定した場合_get名称は_総合特定施設入居者生活介護を返す() {
        assertThat(ServiceCategoryShurui.総特施設.get名称(), is(new RString("総合特定施設入居者生活介護")));
    }

    @Test
    public void 地総通所を指定した場合_get名称は_総合認知症対応型通所介護を返す() {
        assertThat(ServiceCategoryShurui.地総通所.get名称(), is(new RString("総合認知症対応型通所介護")));
    }

    @Test
    public void 地総小規を指定した場合_get名称は_総合小規模多機能型居宅介護を返す() {
        assertThat(ServiceCategoryShurui.地総小規.get名称(), is(new RString("総合小規模多機能型居宅介護")));
    }

    @Test
    public void 地総共同を指定した場合_get名称は_総合認知症型共同生活介護を返す() {
        assertThat(ServiceCategoryShurui.地総共同.get名称(), is(new RString("総合認知症型共同生活介護")));
    }

    @Test
    public void 地総共短を指定した場合_get名称は_総合認知症型共同生活_短期を返す() {
        assertThat(ServiceCategoryShurui.地総共短.get名称(), is(new RString("総合認知症型共同生活（短期）")));
    }

    @Test
    public void 訪問みなを指定した場合_get名称は_訪問型サービス_みなしを返す() {
        assertThat(ServiceCategoryShurui.訪問みな.get名称(), is(new RString("訪問型サービス（みなし）")));
    }

    @Test
    public void 訪問独自を指定した場合_get名称は_訪問型サービス_独自を返す() {
        assertThat(ServiceCategoryShurui.訪問独自.get名称(), is(new RString("訪問型サービス（独自）")));
    }

    @Test
    public void 訪問定率を指定した場合_get名称は_訪問型サービス_独自_定率を返す() {
        assertThat(ServiceCategoryShurui.訪問定率.get名称(), is(new RString("訪問型サービス（独自／定率）")));
    }

    @Test
    public void 訪問定額を指定した場合_get名称は_訪問型サービス_独自_定額を返す() {
        assertThat(ServiceCategoryShurui.訪問定額.get名称(), is(new RString("訪問型サービス（独自／定額）")));
    }

    @Test
    public void 通所みなを指定した場合_get名称は_通所型サービス_みなしを返す() {
        assertThat(ServiceCategoryShurui.通所みな.get名称(), is(new RString("通所型サービス（みなし）")));
    }

    @Test
    public void 通所独自を指定した場合_get名称は_通所型サービス_独自を返す() {
        assertThat(ServiceCategoryShurui.通所独自.get名称(), is(new RString("通所型サービス（独自）")));
    }

    @Test
    public void 通所定率を指定した場合_get名称は_通所型サービス_独自_定率を返す() {
        assertThat(ServiceCategoryShurui.通所定率.get名称(), is(new RString("通所型サービス（独自／定率）")));
    }

    @Test
    public void 通所定額を指定した場合_get名称は_通所型サービス_独自_定額を返す() {
        assertThat(ServiceCategoryShurui.通所定額.get名称(), is(new RString("通所型サービス（独自／定額）")));
    }

    @Test
    public void 配食定率を指定した場合_get名称は_その他生活支援_配食_定率を返す() {
        assertThat(ServiceCategoryShurui.配食定率.get名称(), is(new RString("その他生活支援（配食／定率）")));
    }

    @Test
    public void 配食定額を指定した場合_get名称は_その他生活支援_配食_定額を返す() {
        assertThat(ServiceCategoryShurui.配食定額.get名称(), is(new RString("その他生活支援（配食／定額）")));
    }

    @Test
    public void 見守定率を指定した場合_get名称は_その他生活支援_見守り_定率を返す() {
        assertThat(ServiceCategoryShurui.見守定率.get名称(), is(new RString("その他生活支援（見守り／定率）")));
    }

    @Test
    public void 見守定額を指定した場合_get名称は_その他生活支援_見守り_定額を返す() {
        assertThat(ServiceCategoryShurui.見守定額.get名称(), is(new RString("その他生活支援（見守り／定額）")));
    }

    @Test
    public void その他率を指定した場合_get名称は_その他生活支援_その他_定率を返す() {
        assertThat(ServiceCategoryShurui.その他率.get名称(), is(new RString("その他生活支援（その他／定率）")));
    }

    @Test
    public void その他額を指定した場合_get名称は_その他生活支援_その他_定額を返す() {
        assertThat(ServiceCategoryShurui.その他額.get名称(), is(new RString("その他生活支援（その他／定額）")));
    }

    @Test
    public void 予防ケアを指定した場合_get名称は_介護予防ケアマネジメントを返す() {
        assertThat(ServiceCategoryShurui.予防ケア.get名称(), is(new RString("介護予防ケアマネジメント")));
    }

    @Test
    public void 訪問介護を指定した場合_get略称は_訪問介護を返す() {
        assertThat(ServiceCategoryShurui.訪問介護.get略称(), is(new RString("訪問介護")));
    }

    @Test
    public void 訪問入浴を指定した場合_get略称は_訪問入浴を返す() {
        assertThat(ServiceCategoryShurui.訪問入浴.get略称(), is(new RString("訪問入浴")));
    }

    @Test
    public void 訪問看護を指定した場合_get略称は_訪問看護を返す() {
        assertThat(ServiceCategoryShurui.訪問看護.get略称(), is(new RString("訪問看護")));
    }

    @Test
    public void 訪問リハを指定した場合_get略称は_訪問リハを返す() {
        assertThat(ServiceCategoryShurui.訪問リハ.get略称(), is(new RString("訪問リハ")));
    }

    @Test
    public void 通所介護を指定した場合_get略称は_通所介護を返す() {
        assertThat(ServiceCategoryShurui.通所介護.get略称(), is(new RString("通所介護")));
    }

    @Test
    public void 通所リハを指定した場合_get略称は_通所リハを返す() {
        assertThat(ServiceCategoryShurui.通所リハ.get略称(), is(new RString("通所リハ")));
    }

    @Test
    public void 用具貸与を指定した場合_get略称は_用具貸与を返す() {
        assertThat(ServiceCategoryShurui.用具貸与.get略称(), is(new RString("用具貸与")));
    }

    @Test
    public void 短期生活を指定した場合_get略称は_短期生活を返す() {
        assertThat(ServiceCategoryShurui.短期生活.get略称(), is(new RString("短期生活")));
    }

    @Test
    public void 短期老健を指定した場合_get略称は_短期老健を返す() {
        assertThat(ServiceCategoryShurui.短期老健.get略称(), is(new RString("短期老健")));
    }

    @Test
    public void 短期医療を指定した場合_get略称は_短期医療を返す() {
        assertThat(ServiceCategoryShurui.短期医療.get略称(), is(new RString("短期医療")));
    }

    @Test
    public void 予短介護を指定した場合_get略称は_予短介護を返す() {
        assertThat(ServiceCategoryShurui.予短介護.get略称(), is(new RString("予短介護")));
    }

    @Test
    public void 予短老健を指定した場合_get略称は_予短老健を返す() {
        assertThat(ServiceCategoryShurui.予短老健.get略称(), is(new RString("予短老健")));
    }

    @Test
    public void 予短医療を指定した場合_get略称は_予短医療を返す() {
        assertThat(ServiceCategoryShurui.予短医療.get略称(), is(new RString("予短医療")));
    }

    @Test
    public void 特施短期を指定した場合_get略称は_特施短期を返す() {
        assertThat(ServiceCategoryShurui.特施短期.get略称(), is(new RString("特施短期")));
    }

    @Test
    public void 地施短期を指定した場合_get略称は_地施短期を返す() {
        assertThat(ServiceCategoryShurui.地施短期.get略称(), is(new RString("地施短期")));
    }

    @Test
    public void 療養指導を指定した場合_get略称は_療養指導を返す() {
        assertThat(ServiceCategoryShurui.療養指導.get略称(), is(new RString("療養指導")));
    }

    @Test
    public void 地共同介を指定した場合_get略称は_地共同介を返す() {
        assertThat(ServiceCategoryShurui.地共同介.get略称(), is(new RString("地共同介")));
    }

    @Test
    public void 特施短外を指定した場合_get略称は_特施短外を返す() {
        assertThat(ServiceCategoryShurui.特施短外.get略称(), is(new RString("特施短外")));
    }

    @Test
    public void 予療養指を指定した場合_get略称は_予療養指を返す() {
        assertThat(ServiceCategoryShurui.予療養指.get略称(), is(new RString("予療養指")));
    }

    @Test
    public void 予特施設を指定した場合_get略称は_予特施設を返す() {
        assertThat(ServiceCategoryShurui.予特施設.get略称(), is(new RString("予特施設")));
    }

    @Test
    public void 地施短外を指定した場合_get略称は_地施短外を返す() {
        assertThat(ServiceCategoryShurui.地施短外.get略称(), is(new RString("地施短外")));
    }

    @Test
    public void 地予共同を指定した場合_get略称は_地予共同を返す() {
        assertThat(ServiceCategoryShurui.地予共同.get略称(), is(new RString("地予共同")));
    }

    @Test
    public void 地共同短を指定した場合_get略称は_地共同短を返す() {
        assertThat(ServiceCategoryShurui.地共同短.get略称(), is(new RString("地共同短")));
    }

    @Test
    public void 地予共短を指定した場合_get略称は_地予共短を返す() {
        assertThat(ServiceCategoryShurui.地予共短.get略称(), is(new RString("地予共短")));
    }

    @Test
    public void ケアマネを指定した場合_get略称は_ケアマネを返す() {
        assertThat(ServiceCategoryShurui.ケアマネ.get略称(), is(new RString("ケアマネ")));
    }

    @Test
    public void 用具販売を指定した場合_get略称は_用具販売を返す() {
        assertThat(ServiceCategoryShurui.用具販売.get略称(), is(new RString("用具販売")));
    }

    @Test
    public void 住宅改修を指定した場合_get略称は_住宅改修を返す() {
        assertThat(ServiceCategoryShurui.住宅改修.get略称(), is(new RString("住宅改修")));
    }

    @Test
    public void 居宅支援を指定した場合_get略称は_居宅支援を返す() {
        assertThat(ServiceCategoryShurui.居宅支援.get略称(), is(new RString("居宅支援")));
    }

    @Test
    public void 予用販売を指定した場合_get略称は_予用販売を返す() {
        assertThat(ServiceCategoryShurui.予用販売.get略称(), is(new RString("予用販売")));
    }

    @Test
    public void 予住改修を指定した場合_get略称は_予住改修を返す() {
        assertThat(ServiceCategoryShurui.予住改修.get略称(), is(new RString("予住改修")));
    }

    @Test
    public void 予防支援を指定した場合_get略称は_予防支援を返す() {
        assertThat(ServiceCategoryShurui.予防支援.get略称(), is(new RString("予防支援")));
    }

    @Test
    public void 生活配食を指定した場合_get略称は_生活配食を返す() {
        assertThat(ServiceCategoryShurui.生活配食.get略称(), is(new RString("生活配食")));
    }

    @Test
    public void 生活見守を指定した場合_get略称は_生活見守を返す() {
        assertThat(ServiceCategoryShurui.生活見守.get略称(), is(new RString("生活見守")));
    }

    @Test
    public void 生活他を指定した場合_get略称は_生活他を返す() {
        assertThat(ServiceCategoryShurui.生活他.get略称(), is(new RString("生活他")));
    }

    @Test
    public void 食事費用を指定した場合_get略称は_食事費用を返す() {
        assertThat(ServiceCategoryShurui.食事費用.get略称(), is(new RString("食事費用")));
    }

    @Test
    public void 福祉施設を指定した場合_get略称は_福祉施設を返す() {
        assertThat(ServiceCategoryShurui.福祉施設.get略称(), is(new RString("福祉施設")));
    }

    @Test
    public void 老健施設を指定した場合_get略称は_老健施設を返す() {
        assertThat(ServiceCategoryShurui.老健施設.get略称(), is(new RString("老健施設")));
    }

    @Test
    public void 医療施設を指定した場合_get略称は_医療施設を返す() {
        assertThat(ServiceCategoryShurui.医療施設.get略称(), is(new RString("医療施設")));
    }

    @Test
    public void 地福祉生を指定した場合_get略称は_地福祉生を返す() {
        assertThat(ServiceCategoryShurui.地福祉生.get略称(), is(new RString("地福祉生")));
    }

    @Test
    public void 特定入所を指定した場合_get略称は_特定入所を返す() {
        assertThat(ServiceCategoryShurui.特定入所.get略称(), is(new RString("特定入所")));
    }

    @Test
    public void 予訪介護を指定した場合_get略称は_予訪介護を返す() {
        assertThat(ServiceCategoryShurui.予訪介護.get略称(), is(new RString("予訪介護")));
    }

    @Test
    public void 予訪入浴を指定した場合_get略称は_予訪入浴を返す() {
        assertThat(ServiceCategoryShurui.予訪入浴.get略称(), is(new RString("予訪入浴")));
    }

    @Test
    public void 予訪看護を指定した場合_get略称は_予訪看護を返す() {
        assertThat(ServiceCategoryShurui.予訪看護.get略称(), is(new RString("予訪看護")));
    }

    @Test
    public void 予訪リハを指定した場合_get略称は_予訪リハを返す() {
        assertThat(ServiceCategoryShurui.予訪リハ.get略称(), is(new RString("予訪リハ")));
    }

    @Test
    public void 予通介護を指定した場合_get略称は_予通介護を返す() {
        assertThat(ServiceCategoryShurui.予通介護.get略称(), is(new RString("予通介護")));
    }

    @Test
    public void 予通リハを指定した場合_get略称は_予通リハを返す() {
        assertThat(ServiceCategoryShurui.予通リハ.get略称(), is(new RString("予通リハ")));
    }

    @Test
    public void 予用貸与を指定した場合_get略称は_予用貸与を返す() {
        assertThat(ServiceCategoryShurui.予用貸与.get略称(), is(new RString("予用貸与")));
    }

    @Test
    public void 地夜間訪を指定した場合_get略称は_地夜間訪を返す() {
        assertThat(ServiceCategoryShurui.地夜間訪.get略称(), is(new RString("地夜間訪")));
    }

    @Test
    public void 地通所介を指定した場合_get略称は_地通所介を返す() {
        assertThat(ServiceCategoryShurui.地通所介.get略称(), is(new RString("地通所介")));
    }

    @Test
    public void 地小短外を指定した場合_get略称は_地小短外を返す() {
        assertThat(ServiceCategoryShurui.地小短外.get略称(), is(new RString("地小短外")));
    }

    @Test
    public void 地予通所を指定した場合_get略称は_地予通所を返す() {
        assertThat(ServiceCategoryShurui.地予通所.get略称(), is(new RString("地予通所")));
    }

    @Test
    public void 地予小外を指定した場合_get略称は_地予小外を返す() {
        assertThat(ServiceCategoryShurui.地予小外.get略称(), is(new RString("地予小外")));
    }

    @Test
    public void 定期随時を指定した場合_get略称は_定期随時を返す() {
        assertThat(ServiceCategoryShurui.定期随時.get略称(), is(new RString("定期随時")));
    }

    @Test
    public void 看小短外を指定した場合_get略称は_看小短外を返す() {
        assertThat(ServiceCategoryShurui.看小短外.get略称(), is(new RString("看小短外")));
    }

    @Test
    public void 特別給付を指定した場合_get略称は_特別給付を返す() {
        assertThat(ServiceCategoryShurui.特別給付.get略称(), is(new RString("特別給付")));
    }

    @Test
    public void 総訪予防を指定した場合_get略称は_総訪予防を返す() {
        assertThat(ServiceCategoryShurui.総訪予防.get略称(), is(new RString("総訪予防")));
    }

    @Test
    public void 総通予防を指定した場合_get略称は_総通予防を返す() {
        assertThat(ServiceCategoryShurui.総通予防.get略称(), is(new RString("総通予防")));
    }

    @Test
    public void 総訪入浴を指定した場合_get略称は_総訪入浴を返す() {
        assertThat(ServiceCategoryShurui.総訪入浴.get略称(), is(new RString("総訪入浴")));
    }

    @Test
    public void 総訪看護を指定した場合_get略称は_総訪看護を返す() {
        assertThat(ServiceCategoryShurui.総訪看護.get略称(), is(new RString("総訪看護")));
    }

    @Test
    public void 総訪リハを指定した場合_get略称は_総訪リハを返す() {
        assertThat(ServiceCategoryShurui.総訪リハ.get略称(), is(new RString("総訪リハ")));
    }

    @Test
    public void 総通リハを指定した場合_get略称は_総通リハを返す() {
        assertThat(ServiceCategoryShurui.総通リハ.get略称(), is(new RString("総通リハ")));
    }

    @Test
    public void 総用貸与を指定した場合_get略称は_総用貸与を返す() {
        assertThat(ServiceCategoryShurui.総用貸与.get略称(), is(new RString("総用貸与")));
    }

    @Test
    public void 総短介護を指定した場合_get略称は_総短介護を返す() {
        assertThat(ServiceCategoryShurui.総短介護.get略称(), is(new RString("総短介護")));
    }

    @Test
    public void 総短老健を指定した場合_get略称は_総短老健を返す() {
        assertThat(ServiceCategoryShurui.総短老健.get略称(), is(new RString("総短老健")));
    }

    @Test
    public void 総短医療を指定した場合_get略称は_総短医療を返す() {
        assertThat(ServiceCategoryShurui.総短医療.get略称(), is(new RString("総短医療")));
    }

    @Test
    public void 総療養指を指定した場合_get略称は_総療養指を返す() {
        assertThat(ServiceCategoryShurui.総療養指.get略称(), is(new RString("総療養指")));
    }

    @Test
    public void 総特施設を指定した場合_get略称は_総特施設を返す() {
        assertThat(ServiceCategoryShurui.総特施設.get略称(), is(new RString("総特施設")));
    }

    @Test
    public void 地総通所を指定した場合_get略称は_地総通所を返す() {
        assertThat(ServiceCategoryShurui.地総通所.get略称(), is(new RString("地総通所")));
    }

    @Test
    public void 地総小規を指定した場合_get略称は_地総小規を返す() {
        assertThat(ServiceCategoryShurui.地総小規.get略称(), is(new RString("地総小規")));
    }

    @Test
    public void 地総共同を指定した場合_get略称は_地総共同を返す() {
        assertThat(ServiceCategoryShurui.地総共同.get略称(), is(new RString("地総共同")));
    }

    @Test
    public void 地総共短を指定した場合_get略称は_地総共短を返す() {
        assertThat(ServiceCategoryShurui.地総共短.get略称(), is(new RString("地総共短")));
    }

    @Test
    public void 訪問みなを指定した場合_get略称は_訪問みなを返す() {
        assertThat(ServiceCategoryShurui.訪問みな.get略称(), is(new RString("訪問みな")));
    }

    @Test
    public void 訪問独自を指定した場合_get略称は_訪問独自を返す() {
        assertThat(ServiceCategoryShurui.訪問独自.get略称(), is(new RString("訪問独自")));
    }

    @Test
    public void 訪問定率を指定した場合_get略称は_訪問定率を返す() {
        assertThat(ServiceCategoryShurui.訪問定率.get略称(), is(new RString("訪問定率")));
    }

    @Test
    public void 訪問定額を指定した場合_get略称は_訪問定額を返す() {
        assertThat(ServiceCategoryShurui.訪問定額.get略称(), is(new RString("訪問定額")));
    }

    @Test
    public void 通所みなを指定した場合_get略称は_通所みなを返す() {
        assertThat(ServiceCategoryShurui.通所みな.get略称(), is(new RString("通所みな")));
    }

    @Test
    public void 通所独自を指定した場合_get略称は_通所独自を返す() {
        assertThat(ServiceCategoryShurui.通所独自.get略称(), is(new RString("通所独自")));
    }

    @Test
    public void 通所定率を指定した場合_get略称は_通所定率を返す() {
        assertThat(ServiceCategoryShurui.通所定率.get略称(), is(new RString("通所定率")));
    }

    @Test
    public void 通所定額を指定した場合_get略称は_通所定額を返す() {
        assertThat(ServiceCategoryShurui.通所定額.get略称(), is(new RString("通所定額")));
    }

    @Test
    public void 配食定率を指定した場合_get略称は_配食定率を返す() {
        assertThat(ServiceCategoryShurui.配食定率.get略称(), is(new RString("配食定率")));
    }

    @Test
    public void 配食定額を指定した場合_get略称は_配食定額を返す() {
        assertThat(ServiceCategoryShurui.配食定額.get略称(), is(new RString("配食定額")));
    }

    @Test
    public void 見守定率を指定した場合_get略称は_見守定率を返す() {
        assertThat(ServiceCategoryShurui.見守定率.get略称(), is(new RString("見守定率")));
    }

    @Test
    public void 見守定額を指定した場合_get略称は_見守定額を返す() {
        assertThat(ServiceCategoryShurui.見守定額.get略称(), is(new RString("見守定額")));
    }

    @Test
    public void その他率を指定した場合_get略称は_その他率を返す() {
        assertThat(ServiceCategoryShurui.その他率.get略称(), is(new RString("その他率")));
    }

    @Test
    public void その他額を指定した場合_get略称は_その他額を返す() {
        assertThat(ServiceCategoryShurui.その他額.get略称(), is(new RString("その他額")));
    }

    @Test
    public void 予防ケアを指定した場合_get略称は_予防ケアを返す() {
        assertThat(ServiceCategoryShurui.予防ケア.get略称(), is(new RString("予防ケア")));
    }

}
