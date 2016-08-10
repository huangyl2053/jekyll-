package jp.co.ndensan.reams.db.dbb.definition.core.choteijiyu;

import jp.co.ndensan.reams.db.dbx.definition.core.choteijiyu.ChoteiJiyuCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 調定事由のテストクラスです。
 *
 * @author LDNS
 */
public class ChoteiJiyuCodeTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ChoteiJiyuCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ChoteiJiyuCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_転入を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("01")), is(ChoteiJiyuCode.転入));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_年齢到達を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("02")), is(ChoteiJiyuCode.年齢到達));
    }

    @Test
    public void 引数に03を指定した場合_toValueは_外国人申請を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("03")), is(ChoteiJiyuCode.外国人申請));
    }

    @Test
    public void 引数に05を指定した場合_toValueは_自特例適用を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("05")), is(ChoteiJiyuCode.自特例適用));
    }

    @Test
    public void 引数に06を指定した場合_toValueは_06自特例転入を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("06")), is(ChoteiJiyuCode._06自特例転入));
    }

    @Test
    public void 引数に07を指定した場合_toValueは_他特例居住を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("07")), is(ChoteiJiyuCode.他特例居住));
    }

    @Test
    public void 引数に08を指定した場合_toValueは_除外者居住を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("08")), is(ChoteiJiyuCode.除外者居住));
    }

    @Test
    public void 引数に09を指定した場合_toValueは_帰化取得を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("09")), is(ChoteiJiyuCode.帰化取得));
    }

    @Test
    public void 引数に18を指定した場合_toValueは_職権取得を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("18")), is(ChoteiJiyuCode.職権取得));
    }

    @Test
    public void 引数に46を指定した場合_toValueは_施行時取得を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("46")), is(ChoteiJiyuCode.施行時取得));
    }

    @Test
    public void 引数に49を指定した場合_toValueは_その他取得を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("49")), is(ChoteiJiyuCode.その他取得));
    }

    @Test
    public void 引数に51を指定した場合_toValueは_転出を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("51")), is(ChoteiJiyuCode.転出));
    }

    @Test
    public void 引数に52を指定した場合_toValueは_死亡を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("52")), is(ChoteiJiyuCode.死亡));
    }

    @Test
    public void 引数に53を指定した場合_toValueは_除外者を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("53")), is(ChoteiJiyuCode.除外者));
    }

    @Test
    public void 引数に54を指定した場合_toValueは_54自特例転入を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("54")), is(ChoteiJiyuCode._54自特例転入));
    }

    @Test
    public void 引数に55を指定した場合_toValueは_自特例解除を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("55")), is(ChoteiJiyuCode.自特例解除));
    }

    @Test
    public void 引数に56を指定した場合_toValueは_帰化喪失を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("56")), is(ChoteiJiyuCode.帰化喪失));
    }

    @Test
    public void 引数に57を指定した場合_toValueは_国籍喪失を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("57")), is(ChoteiJiyuCode.国籍喪失));
    }

    @Test
    public void 引数に58を指定した場合_toValueは_他特例者を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("58")), is(ChoteiJiyuCode.他特例者));
    }

    @Test
    public void 引数に68を指定した場合_toValueは_職権喪失を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("68")), is(ChoteiJiyuCode.職権喪失));
    }

    @Test
    public void 引数に99を指定した場合_toValueは_その他喪失を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("99")), is(ChoteiJiyuCode.その他喪失));
    }

    @Test
    public void 引数にA1を指定した場合_toValueは_本算定賦課を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("A1")), is(ChoteiJiyuCode.本算定賦課));
    }

    @Test
    public void 引数にA2を指定した場合_toValueは_仮算定賦課を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("A2")), is(ChoteiJiyuCode.仮算定賦課));
    }

    @Test
    public void 引数にA3を指定した場合_toValueは_捕捉により特徴開始を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("A3")), is(ChoteiJiyuCode.捕捉により特徴開始));
    }

    @Test
    public void 引数にB1を指定した場合_toValueは_資格異動による更正を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("B1")), is(ChoteiJiyuCode.資格異動による更正));
    }

    @Test
    public void 引数にB2を指定した場合_toValueは_老齢年金による更正を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("B2")), is(ChoteiJiyuCode.老齢年金による更正));
    }

    @Test
    public void 引数にB3を指定した場合_toValueは_生活保護による更正を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("B3")), is(ChoteiJiyuCode.生活保護による更正));
    }

    @Test
    public void 引数にB9を指定した場合_toValueは_その他資格異動を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("B9")), is(ChoteiJiyuCode.その他資格異動));
    }

    @Test
    public void 引数にC1を指定した場合_toValueは_所得更正による更正を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("C1")), is(ChoteiJiyuCode.所得更正による更正));
    }

    @Test
    public void 引数にC2を指定した場合_toValueは_所得更正による異動を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("C2")), is(ChoteiJiyuCode.所得更正による異動));
    }

    @Test
    public void 引数にD1を指定した場合_toValueは_減免決定による更正を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("D1")), is(ChoteiJiyuCode.減免決定による更正));
    }

    @Test
    public void 引数にD2を指定した場合_toValueは_減免取消による更正を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("D2")), is(ChoteiJiyuCode.減免取消による更正));
    }

    @Test
    public void 引数にD3を指定した場合_toValueは_徴収猶予決定を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("D3")), is(ChoteiJiyuCode.徴収猶予決定));
    }

    @Test
    public void 引数にD4を指定した場合_toValueは_徴収猶予取消を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("D4")), is(ChoteiJiyuCode.徴収猶予取消));
    }

    @Test
    public void 引数にE1を指定した場合_toValueは_仮徴収額の変更を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("E1")), is(ChoteiJiyuCode.仮徴収額の変更));
    }

    @Test
    public void 引数にE2を指定した場合_toValueは_期別修正による更正を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("E2")), is(ChoteiJiyuCode.期別修正による更正));
    }

    @Test
    public void 引数にE3を指定した場合_toValueは_平準化による変更6月を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("E3")), is(ChoteiJiyuCode.平準化による変更6月));
    }

    @Test
    public void 引数にE4を指定した場合_toValueは_平準化による変更8月を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("E4")), is(ChoteiJiyuCode.平準化による変更8月));
    }

    @Test
    public void 引数にF1を指定した場合_toValueは_職権変更を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("F1")), is(ChoteiJiyuCode.職権変更));
    }

    @Test
    public void 引数にG1を指定した場合_toValueは_口座情報変更を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("G1")), is(ChoteiJiyuCode.口座情報変更));
    }

    @Test
    public void 引数にK1を指定した場合_toValueは_過年度更正を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("K1")), is(ChoteiJiyuCode.過年度更正));
    }

    @Test
    public void 引数にS1を指定した場合_toValueは_歳出還付による減額を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("S1")), is(ChoteiJiyuCode.歳出還付による減額));
    }

    @Test
    public void 引数にT1を指定した場合_toValueは_年金保険者からの通知を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("T1")), is(ChoteiJiyuCode.年金保険者からの通知));
    }

    @Test
    public void 引数にT2を指定した場合_toValueは_保険料額の減額変更を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("T2")), is(ChoteiJiyuCode.保険料額の減額変更));
    }

    @Test
    public void 引数にT3を指定した場合_toValueは_職権変更特徴中止を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("T3")), is(ChoteiJiyuCode.職権変更特徴中止));
    }

    @Test
    public void 引数にT4を指定した場合_toValueは_徴収方法修正を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("T4")), is(ChoteiJiyuCode.徴収方法修正));
    }

    @Test
    public void 引数にT5を指定した場合_toValueは_特別徴収対象者外を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("T5")), is(ChoteiJiyuCode.特別徴収対象者外));
    }

    @Test
    public void 引数にT6を指定した場合_toValueは_資格喪失特徴中止を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("T6")), is(ChoteiJiyuCode.資格喪失特徴中止));
    }

    @Test
    public void 引数にT7を指定した場合_toValueは_保険料算定結果で特徴中止を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("T7")), is(ChoteiJiyuCode.保険料算定結果で特徴中止));
    }

    @Test
    public void 引数にT8を指定した場合_toValueは_境界層該当特徴中止を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("T8")), is(ChoteiJiyuCode.境界層該当特徴中止));
    }

    @Test
    public void 引数にT9を指定した場合_toValueは_その他特徴中止を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("T9")), is(ChoteiJiyuCode.その他特徴中止));
    }

    @Test
    public void 引数にY1を指定した場合_toValueは_境界層該当を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("Y1")), is(ChoteiJiyuCode.境界層該当));
    }

    @Test
    public void 引数にY2を指定した場合_toValueは_境界層非該当を返す() {
        assertThat(ChoteiJiyuCode.toValue(new RString("Y2")), is(ChoteiJiyuCode.境界層非該当));
    }

    @Test
    public void 転入を指定した場合_getコードは_01を返す() {
        assertThat(ChoteiJiyuCode.転入.getコード(), is(new RString("01")));
    }

    @Test
    public void 年齢到達を指定した場合_getコードは_02を返す() {
        assertThat(ChoteiJiyuCode.年齢到達.getコード(), is(new RString("02")));
    }

    @Test
    public void 外国人申請を指定した場合_getコードは_03を返す() {
        assertThat(ChoteiJiyuCode.外国人申請.getコード(), is(new RString("03")));
    }

    @Test
    public void 自特例適用を指定した場合_getコードは_05を返す() {
        assertThat(ChoteiJiyuCode.自特例適用.getコード(), is(new RString("05")));
    }

    @Test
    public void _06自特例転入を指定した場合_getコードは_06を返す() {
        assertThat(ChoteiJiyuCode._06自特例転入.getコード(), is(new RString("06")));
    }

    @Test
    public void 他特例居住を指定した場合_getコードは_07を返す() {
        assertThat(ChoteiJiyuCode.他特例居住.getコード(), is(new RString("07")));
    }

    @Test
    public void 除外者居住を指定した場合_getコードは_08を返す() {
        assertThat(ChoteiJiyuCode.除外者居住.getコード(), is(new RString("08")));
    }

    @Test
    public void 帰化取得を指定した場合_getコードは_09を返す() {
        assertThat(ChoteiJiyuCode.帰化取得.getコード(), is(new RString("09")));
    }

    @Test
    public void 職権取得を指定した場合_getコードは_18を返す() {
        assertThat(ChoteiJiyuCode.職権取得.getコード(), is(new RString("18")));
    }

    @Test
    public void 施行時取得を指定した場合_getコードは_46を返す() {
        assertThat(ChoteiJiyuCode.施行時取得.getコード(), is(new RString("46")));
    }

    @Test
    public void その他取得を指定した場合_getコードは_49を返す() {
        assertThat(ChoteiJiyuCode.その他取得.getコード(), is(new RString("49")));
    }

    @Test
    public void 転出を指定した場合_getコードは_51を返す() {
        assertThat(ChoteiJiyuCode.転出.getコード(), is(new RString("51")));
    }

    @Test
    public void 死亡を指定した場合_getコードは_52を返す() {
        assertThat(ChoteiJiyuCode.死亡.getコード(), is(new RString("52")));
    }

    @Test
    public void 除外者を指定した場合_getコードは_53を返す() {
        assertThat(ChoteiJiyuCode.除外者.getコード(), is(new RString("53")));
    }

    @Test
    public void _54自特例転入を指定した場合_getコードは_54を返す() {
        assertThat(ChoteiJiyuCode._54自特例転入.getコード(), is(new RString("54")));
    }

    @Test
    public void 自特例解除を指定した場合_getコードは_55を返す() {
        assertThat(ChoteiJiyuCode.自特例解除.getコード(), is(new RString("55")));
    }

    @Test
    public void 帰化喪失を指定した場合_getコードは_56を返す() {
        assertThat(ChoteiJiyuCode.帰化喪失.getコード(), is(new RString("56")));
    }

    @Test
    public void 国籍喪失を指定した場合_getコードは_57を返す() {
        assertThat(ChoteiJiyuCode.国籍喪失.getコード(), is(new RString("57")));
    }

    @Test
    public void 他特例者を指定した場合_getコードは_58を返す() {
        assertThat(ChoteiJiyuCode.他特例者.getコード(), is(new RString("58")));
    }

    @Test
    public void 職権喪失を指定した場合_getコードは_68を返す() {
        assertThat(ChoteiJiyuCode.職権喪失.getコード(), is(new RString("68")));
    }

    @Test
    public void その他喪失を指定した場合_getコードは_99を返す() {
        assertThat(ChoteiJiyuCode.その他喪失.getコード(), is(new RString("99")));
    }

    @Test
    public void 本算定賦課を指定した場合_getコードは_A1を返す() {
        assertThat(ChoteiJiyuCode.本算定賦課.getコード(), is(new RString("A1")));
    }

    @Test
    public void 仮算定賦課を指定した場合_getコードは_A2を返す() {
        assertThat(ChoteiJiyuCode.仮算定賦課.getコード(), is(new RString("A2")));
    }

    @Test
    public void 捕捉により特徴開始を指定した場合_getコードは_A3を返す() {
        assertThat(ChoteiJiyuCode.捕捉により特徴開始.getコード(), is(new RString("A3")));
    }

    @Test
    public void 資格異動による更正を指定した場合_getコードは_B1を返す() {
        assertThat(ChoteiJiyuCode.資格異動による更正.getコード(), is(new RString("B1")));
    }

    @Test
    public void 老齢年金による更正を指定した場合_getコードは_B2を返す() {
        assertThat(ChoteiJiyuCode.老齢年金による更正.getコード(), is(new RString("B2")));
    }

    @Test
    public void 生活保護による更正を指定した場合_getコードは_B3を返す() {
        assertThat(ChoteiJiyuCode.生活保護による更正.getコード(), is(new RString("B3")));
    }

    @Test
    public void その他資格異動を指定した場合_getコードは_B9を返す() {
        assertThat(ChoteiJiyuCode.その他資格異動.getコード(), is(new RString("B9")));
    }

    @Test
    public void 所得更正による更正を指定した場合_getコードは_C1を返す() {
        assertThat(ChoteiJiyuCode.所得更正による更正.getコード(), is(new RString("C1")));
    }

    @Test
    public void 所得更正による異動を指定した場合_getコードは_C2を返す() {
        assertThat(ChoteiJiyuCode.所得更正による異動.getコード(), is(new RString("C2")));
    }

    @Test
    public void 減免決定による更正を指定した場合_getコードは_D1を返す() {
        assertThat(ChoteiJiyuCode.減免決定による更正.getコード(), is(new RString("D1")));
    }

    @Test
    public void 減免取消による更正を指定した場合_getコードは_D2を返す() {
        assertThat(ChoteiJiyuCode.減免取消による更正.getコード(), is(new RString("D2")));
    }

    @Test
    public void 徴収猶予決定を指定した場合_getコードは_D3を返す() {
        assertThat(ChoteiJiyuCode.徴収猶予決定.getコード(), is(new RString("D3")));
    }

    @Test
    public void 徴収猶予取消を指定した場合_getコードは_D4を返す() {
        assertThat(ChoteiJiyuCode.徴収猶予取消.getコード(), is(new RString("D4")));
    }

    @Test
    public void 仮徴収額の変更を指定した場合_getコードは_E1を返す() {
        assertThat(ChoteiJiyuCode.仮徴収額の変更.getコード(), is(new RString("E1")));
    }

    @Test
    public void 期別修正による更正を指定した場合_getコードは_E2を返す() {
        assertThat(ChoteiJiyuCode.期別修正による更正.getコード(), is(new RString("E2")));
    }

    @Test
    public void 平準化による変更6月を指定した場合_getコードは_E3を返す() {
        assertThat(ChoteiJiyuCode.平準化による変更6月.getコード(), is(new RString("E3")));
    }

    @Test
    public void 平準化による変更8月を指定した場合_getコードは_E4を返す() {
        assertThat(ChoteiJiyuCode.平準化による変更8月.getコード(), is(new RString("E4")));
    }

    @Test
    public void 職権変更を指定した場合_getコードは_F1を返す() {
        assertThat(ChoteiJiyuCode.職権変更.getコード(), is(new RString("F1")));
    }

    @Test
    public void 口座情報変更を指定した場合_getコードは_G1を返す() {
        assertThat(ChoteiJiyuCode.口座情報変更.getコード(), is(new RString("G1")));
    }

    @Test
    public void 過年度更正を指定した場合_getコードは_K1を返す() {
        assertThat(ChoteiJiyuCode.過年度更正.getコード(), is(new RString("K1")));
    }

    @Test
    public void 歳出還付による減額を指定した場合_getコードは_S1を返す() {
        assertThat(ChoteiJiyuCode.歳出還付による減額.getコード(), is(new RString("S1")));
    }

    @Test
    public void 年金保険者からの通知を指定した場合_getコードは_T1を返す() {
        assertThat(ChoteiJiyuCode.年金保険者からの通知.getコード(), is(new RString("T1")));
    }

    @Test
    public void 保険料額の減額変更を指定した場合_getコードは_T2を返す() {
        assertThat(ChoteiJiyuCode.保険料額の減額変更.getコード(), is(new RString("T2")));
    }

    @Test
    public void 職権変更特徴中止を指定した場合_getコードは_T3を返す() {
        assertThat(ChoteiJiyuCode.職権変更特徴中止.getコード(), is(new RString("T3")));
    }

    @Test
    public void 徴収方法修正を指定した場合_getコードは_T4を返す() {
        assertThat(ChoteiJiyuCode.徴収方法修正.getコード(), is(new RString("T4")));
    }

    @Test
    public void 特別徴収対象者外を指定した場合_getコードは_T5を返す() {
        assertThat(ChoteiJiyuCode.特別徴収対象者外.getコード(), is(new RString("T5")));
    }

    @Test
    public void 資格喪失特徴中止を指定した場合_getコードは_T6を返す() {
        assertThat(ChoteiJiyuCode.資格喪失特徴中止.getコード(), is(new RString("T6")));
    }

    @Test
    public void 保険料算定結果で特徴中止を指定した場合_getコードは_T7を返す() {
        assertThat(ChoteiJiyuCode.保険料算定結果で特徴中止.getコード(), is(new RString("T7")));
    }

    @Test
    public void 境界層該当特徴中止を指定した場合_getコードは_T8を返す() {
        assertThat(ChoteiJiyuCode.境界層該当特徴中止.getコード(), is(new RString("T8")));
    }

    @Test
    public void その他特徴中止を指定した場合_getコードは_T9を返す() {
        assertThat(ChoteiJiyuCode.その他特徴中止.getコード(), is(new RString("T9")));
    }

    @Test
    public void 境界層該当を指定した場合_getコードは_Y1を返す() {
        assertThat(ChoteiJiyuCode.境界層該当.getコード(), is(new RString("Y1")));
    }

    @Test
    public void 境界層非該当を指定した場合_getコードは_Y2を返す() {
        assertThat(ChoteiJiyuCode.境界層非該当.getコード(), is(new RString("Y2")));
    }

    @Test
    public void 転入を指定した場合_get名称は_転入を返す() {
        assertThat(ChoteiJiyuCode.転入.get名称(), is(new RString("転入")));
    }

    @Test
    public void 年齢到達を指定した場合_get名称は_年齢到達を返す() {
        assertThat(ChoteiJiyuCode.年齢到達.get名称(), is(new RString("年齢到達")));
    }

    @Test
    public void 外国人申請を指定した場合_get名称は_外国人申請を返す() {
        assertThat(ChoteiJiyuCode.外国人申請.get名称(), is(new RString("外国人申請")));
    }

    @Test
    public void 自特例適用を指定した場合_get名称は_自特例適用を返す() {
        assertThat(ChoteiJiyuCode.自特例適用.get名称(), is(new RString("自特例適用")));
    }

    @Test
    public void _06自特例転入を指定した場合_get名称は_自特例転入を返す() {
        assertThat(ChoteiJiyuCode._06自特例転入.get名称(), is(new RString("自特例転入")));
    }

    @Test
    public void 他特例居住を指定した場合_get名称は_他特例居住を返す() {
        assertThat(ChoteiJiyuCode.他特例居住.get名称(), is(new RString("他特例居住")));
    }

    @Test
    public void 除外者居住を指定した場合_get名称は_除外者居住を返す() {
        assertThat(ChoteiJiyuCode.除外者居住.get名称(), is(new RString("除外者居住")));
    }

    @Test
    public void 帰化取得を指定した場合_get名称は_帰化取得を返す() {
        assertThat(ChoteiJiyuCode.帰化取得.get名称(), is(new RString("帰化取得")));
    }

    @Test
    public void 職権取得を指定した場合_get名称は_職権取得を返す() {
        assertThat(ChoteiJiyuCode.職権取得.get名称(), is(new RString("職権取得")));
    }

    @Test
    public void 施行時取得を指定した場合_get名称は_施行時取得を返す() {
        assertThat(ChoteiJiyuCode.施行時取得.get名称(), is(new RString("施行時取得")));
    }

    @Test
    public void その他取得を指定した場合_get名称は_その他取得を返す() {
        assertThat(ChoteiJiyuCode.その他取得.get名称(), is(new RString("その他取得")));
    }

    @Test
    public void 転出を指定した場合_get名称は_転出を返す() {
        assertThat(ChoteiJiyuCode.転出.get名称(), is(new RString("転出")));
    }

    @Test
    public void 死亡を指定した場合_get名称は_死亡を返す() {
        assertThat(ChoteiJiyuCode.死亡.get名称(), is(new RString("死亡")));
    }

    @Test
    public void 除外者を指定した場合_get名称は_除外者を返す() {
        assertThat(ChoteiJiyuCode.除外者.get名称(), is(new RString("除外者")));
    }

    @Test
    public void _54自特例転入を指定した場合_get名称は_自特例転入を返す() {
        assertThat(ChoteiJiyuCode._54自特例転入.get名称(), is(new RString("自特例転入")));
    }

    @Test
    public void 自特例解除を指定した場合_get名称は_自特例解除を返す() {
        assertThat(ChoteiJiyuCode.自特例解除.get名称(), is(new RString("自特例解除")));
    }

    @Test
    public void 帰化喪失を指定した場合_get名称は_帰化喪失を返す() {
        assertThat(ChoteiJiyuCode.帰化喪失.get名称(), is(new RString("帰化喪失")));
    }

    @Test
    public void 国籍喪失を指定した場合_get名称は_国籍喪失を返す() {
        assertThat(ChoteiJiyuCode.国籍喪失.get名称(), is(new RString("国籍喪失")));
    }

    @Test
    public void 他特例者を指定した場合_get名称は_他特例者を返す() {
        assertThat(ChoteiJiyuCode.他特例者.get名称(), is(new RString("他特例者")));
    }

    @Test
    public void 職権喪失を指定した場合_get名称は_職権喪失を返す() {
        assertThat(ChoteiJiyuCode.職権喪失.get名称(), is(new RString("職権喪失")));
    }

    @Test
    public void その他喪失を指定した場合_get名称は_その他喪失を返す() {
        assertThat(ChoteiJiyuCode.その他喪失.get名称(), is(new RString("その他喪失")));
    }

    @Test
    public void 本算定賦課を指定した場合_get名称は_本算定賦課を返す() {
        assertThat(ChoteiJiyuCode.本算定賦課.get名称(), is(new RString("本算定賦課")));
    }

    @Test
    public void 仮算定賦課を指定した場合_get名称は_仮算定賦課を返す() {
        assertThat(ChoteiJiyuCode.仮算定賦課.get名称(), is(new RString("仮算定賦課")));
    }

    @Test
    public void 捕捉により特徴開始を指定した場合_get名称は_捕捉により特徴開始を返す() {
        assertThat(ChoteiJiyuCode.捕捉により特徴開始.get名称(), is(new RString("捕捉により特徴開始")));
    }

    @Test
    public void 資格異動による更正を指定した場合_get名称は_資格異動による更正を返す() {
        assertThat(ChoteiJiyuCode.資格異動による更正.get名称(), is(new RString("資格異動による更正")));
    }

    @Test
    public void 老齢年金による更正を指定した場合_get名称は_老齢年金による更正を返す() {
        assertThat(ChoteiJiyuCode.老齢年金による更正.get名称(), is(new RString("老齢年金による更正")));
    }

    @Test
    public void 生活保護による更正を指定した場合_get名称は_生活保護による更正を返す() {
        assertThat(ChoteiJiyuCode.生活保護による更正.get名称(), is(new RString("生活保護による更正")));
    }

    @Test
    public void その他資格異動を指定した場合_get名称は_その他資格異動を返す() {
        assertThat(ChoteiJiyuCode.その他資格異動.get名称(), is(new RString("その他資格異動")));
    }

    @Test
    public void 所得更正による更正を指定した場合_get名称は_所得更正による更正を返す() {
        assertThat(ChoteiJiyuCode.所得更正による更正.get名称(), is(new RString("所得更正による更正")));
    }

    @Test
    public void 所得更正による異動を指定した場合_get名称は_所得更正による異動を返す() {
        assertThat(ChoteiJiyuCode.所得更正による異動.get名称(), is(new RString("所得更正による異動")));
    }

    @Test
    public void 減免決定による更正を指定した場合_get名称は_減免決定による更正を返す() {
        assertThat(ChoteiJiyuCode.減免決定による更正.get名称(), is(new RString("減免決定による更正")));
    }

    @Test
    public void 減免取消による更正を指定した場合_get名称は_減免取消による更正を返す() {
        assertThat(ChoteiJiyuCode.減免取消による更正.get名称(), is(new RString("減免取消による更正")));
    }

    @Test
    public void 徴収猶予決定を指定した場合_get名称は_徴収猶予決定を返す() {
        assertThat(ChoteiJiyuCode.徴収猶予決定.get名称(), is(new RString("徴収猶予決定")));
    }

    @Test
    public void 徴収猶予取消を指定した場合_get名称は_徴収猶予取消を返す() {
        assertThat(ChoteiJiyuCode.徴収猶予取消.get名称(), is(new RString("徴収猶予取消")));
    }

    @Test
    public void 仮徴収額の変更を指定した場合_get名称は_仮徴収額の変更を返す() {
        assertThat(ChoteiJiyuCode.仮徴収額の変更.get名称(), is(new RString("仮徴収額の変更")));
    }

    @Test
    public void 期別修正による更正を指定した場合_get名称は_期別修正による更正を返す() {
        assertThat(ChoteiJiyuCode.期別修正による更正.get名称(), is(new RString("期別修正による更正")));
    }

    @Test
    public void 平準化による変更6月を指定した場合_get名称は_平準化による変更6月を返す() {
        assertThat(ChoteiJiyuCode.平準化による変更6月.get名称(), is(new RString("平準化による変更6月")));
    }

    @Test
    public void 平準化による変更8月を指定した場合_get名称は_平準化による変更8月を返す() {
        assertThat(ChoteiJiyuCode.平準化による変更8月.get名称(), is(new RString("平準化による変更8月")));
    }

    @Test
    public void 職権変更を指定した場合_get名称は_職権変更を返す() {
        assertThat(ChoteiJiyuCode.職権変更.get名称(), is(new RString("職権変更")));
    }

    @Test
    public void 口座情報変更を指定した場合_get名称は_口座情報変更を返す() {
        assertThat(ChoteiJiyuCode.口座情報変更.get名称(), is(new RString("口座情報変更")));
    }

    @Test
    public void 過年度更正を指定した場合_get名称は_過年度更正を返す() {
        assertThat(ChoteiJiyuCode.過年度更正.get名称(), is(new RString("過年度更正")));
    }

    @Test
    public void 歳出還付による減額を指定した場合_get名称は_歳出還付による減額を返す() {
        assertThat(ChoteiJiyuCode.歳出還付による減額.get名称(), is(new RString("歳出還付による減額")));
    }

    @Test
    public void 年金保険者からの通知を指定した場合_get名称は_年金保険者からの通知を返す() {
        assertThat(ChoteiJiyuCode.年金保険者からの通知.get名称(), is(new RString("年金保険者からの通知")));
    }

    @Test
    public void 保険料額の減額変更を指定した場合_get名称は_保険料額の減額変更を返す() {
        assertThat(ChoteiJiyuCode.保険料額の減額変更.get名称(), is(new RString("保険料額の減額変更")));
    }

    @Test
    public void 職権変更特徴中止を指定した場合_get名称は_職権変更特徴中止を返す() {
        assertThat(ChoteiJiyuCode.職権変更特徴中止.get名称(), is(new RString("職権変更特徴中止")));
    }

    @Test
    public void 徴収方法修正を指定した場合_get名称は_徴収方法修正を返す() {
        assertThat(ChoteiJiyuCode.徴収方法修正.get名称(), is(new RString("徴収方法修正")));
    }

    @Test
    public void 特別徴収対象者外を指定した場合_get名称は_特別徴収対象者外を返す() {
        assertThat(ChoteiJiyuCode.特別徴収対象者外.get名称(), is(new RString("特別徴収対象者外")));
    }

    @Test
    public void 資格喪失特徴中止を指定した場合_get名称は_資格喪失特徴中止を返す() {
        assertThat(ChoteiJiyuCode.資格喪失特徴中止.get名称(), is(new RString("資格喪失特徴中止")));
    }

    @Test
    public void 保険料算定結果で特徴中止を指定した場合_get名称は_保険料算定結果で特徴中止を返す() {
        assertThat(ChoteiJiyuCode.保険料算定結果で特徴中止.get名称(), is(new RString("保険料算定結果で特徴中止")));
    }

    @Test
    public void 境界層該当特徴中止を指定した場合_get名称は_境界層該当特徴中止を返す() {
        assertThat(ChoteiJiyuCode.境界層該当特徴中止.get名称(), is(new RString("境界層該当特徴中止")));
    }

    @Test
    public void その他特徴中止を指定した場合_get名称は_その他特徴中止を返す() {
        assertThat(ChoteiJiyuCode.その他特徴中止.get名称(), is(new RString("その他特徴中止")));
    }

    @Test
    public void 境界層該当を指定した場合_get名称は_境界層該当を返す() {
        assertThat(ChoteiJiyuCode.境界層該当.get名称(), is(new RString("境界層該当")));
    }

    @Test
    public void 境界層非該当を指定した場合_get名称は_境界層非該当を返す() {
        assertThat(ChoteiJiyuCode.境界層非該当.get名称(), is(new RString("境界層非該当")));
    }

}
