/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100003;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.sashitome.ShiharaiHohoHenkoSashitome;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.taino.ShiharaiHohoHenkoTaino;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoJohoBunruiKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shokankihonjiho.ShokanKihonJihoEntiy;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100003.ShiharaiIchijiSashitomeTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 支払一時差止通知書Editorです。
 *
 * @reamsid_L DBD-3640-100 b_liuyang2
 */
public class ShiharaiIchijiSashitomeTsuchishoEditor implements IShiharaiIchijiSashitomeTsuchishoEditor {

    private static final int NOCOUNT_1 = 1;
    private static final int NOCOUNT_2 = 2;
    private static final int NOCOUNT_3 = 3;
    private static final int NOCOUNT_4 = 4;
    private static final int NOCOUNT_5 = 5;
    private static final int NOCOUNT_6 = 6;
    private static final int NOCOUNT_7 = 7;
    private static final int NOCOUNT_8 = 8;
    private static final int NOCOUNT_9 = 9;
    private static final int NOCOUNT_10 = 10;
    private static final int NOCOUNT_13 = 13;
    private static final int NOCOUNT_14 = 14;

    private final IKojin 個人情報;
    private final IAtesaki 宛先;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final Association 地方公共団体;
    private final RString 文書番号;
    private final Map<Integer, RString> 通知書定型文リスト;
    private final NinshoshaSource 認証者ソースビルダー;
    private final ShiharaiHohoHenko 帳票情報;
    private final List<ShokanKihonJihoEntiy> 償還払集計情報リスト;
    private final FlexibleYear 最新賦課年度;
    private final List<ShiharaiHohoHenkoTaino> 年度1リスト;
    private final List<ShiharaiHohoHenkoTaino> 年度2リスト;
    private final List<ShiharaiHohoHenkoTaino> 年度3リスト;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param 個人情報 IKojin
     * @param 宛先 IAtesaki
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param 地方公共団体 Association
     * @param 文書番号 RString
     * @param 通知書定型文リスト Map<Integer, RString>
     * @param 認証者ソースビルダー NinshoshaSource
     * @param 帳票情報 ShiharaiHohoHenko
     * @param 償還払集計情報リスト List<ShokanKihonJihoEntiy>
     * @param 最新賦課年度 FlexibleYear
     * @param 年度1リスト List<ShiharaiHohoHenkoTaino>
     * @param 年度2リスト List<ShiharaiHohoHenkoTaino>
     * @param 年度3リスト List<ShiharaiHohoHenkoTaino>
     * @param index int
     */
    public ShiharaiIchijiSashitomeTsuchishoEditor(IKojin 個人情報, IAtesaki 宛先, ChohyoSeigyoKyotsu 帳票制御共通,
            Association 地方公共団体, RString 文書番号, Map<Integer, RString> 通知書定型文リスト, NinshoshaSource 認証者ソースビルダー,
            ShiharaiHohoHenko 帳票情報, List<ShokanKihonJihoEntiy> 償還払集計情報リスト, FlexibleYear 最新賦課年度,
            List<ShiharaiHohoHenkoTaino> 年度1リスト, List<ShiharaiHohoHenkoTaino> 年度2リスト,
            List<ShiharaiHohoHenkoTaino> 年度3リスト, int index) {
        this.個人情報 = 個人情報;
        this.宛先 = 宛先;
        this.帳票制御共通 = 帳票制御共通;
        this.地方公共団体 = 地方公共団体;
        this.文書番号 = 文書番号;
        this.通知書定型文リスト = 通知書定型文リスト;
        this.認証者ソースビルダー = 認証者ソースビルダー;
        this.帳票情報 = 帳票情報;
        this.償還払集計情報リスト = 償還払集計情報リスト;
        this.最新賦課年度 = 最新賦課年度;
        this.年度1リスト = 年度1リスト;
        this.年度2リスト = 年度2リスト;
        this.年度3リスト = 年度3リスト;
        this.index = index;
    }

    @Override
    public ShiharaiIchijiSashitomeTsuchishoReportSource edit(ShiharaiIchijiSashitomeTsuchishoReportSource source) {
        setCompSofubutsuAtesaki(source);
        setCompNinshosha(source);
        setLayer1(source);
        setHokenryoTainoJyokyoStep1(source);
        setHokenryoTainoJyokyoStep2(source);
        setLayerFontLarge(source);
        setLayerFontKonzai(source);
        setLayerFontKonzai2(source);
        setAccessLogEditor(source);
        return source;
    }

    private void setCompSofubutsuAtesaki(ShiharaiIchijiSashitomeTsuchishoReportSource source) {
        EditedAtesaki 編集後宛先 = JushoHenshu.create編集後宛先(this.宛先, this.地方公共団体, this.帳票制御共通);
        SofubutsuAtesakiSource sofubutsuAtesakiSource;
        try {
            sofubutsuAtesakiSource = 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース();
        } catch (Exception e) {
            sofubutsuAtesakiSource = new SofubutsuAtesakiSource();
        }
        source.yubinNo = sofubutsuAtesakiSource.yubinNo;
        source.gyoseiku1 = sofubutsuAtesakiSource.gyoseiku;
        source.jushoText = sofubutsuAtesakiSource.jushoText;
        source.katagakiText = sofubutsuAtesakiSource.katagakiText;
        source.shimei3 = sofubutsuAtesakiSource.shimei1;
        source.shimei4 = sofubutsuAtesakiSource.shimei2;
        source.katagaki3 = sofubutsuAtesakiSource.katagaki1;
        source.katagaki4 = sofubutsuAtesakiSource.katagaki2;
        source.jusho4 = sofubutsuAtesakiSource.jusho1;
        source.jusho5 = sofubutsuAtesakiSource.jusho2;
        source.jusho6 = sofubutsuAtesakiSource.jusho3;
        source.dainoKubunMei = sofubutsuAtesakiSource.dainoKubunMei;
        source.samabunShimeiText = sofubutsuAtesakiSource.samabunShimeiText;
        source.kakkoLeft1 = sofubutsuAtesakiSource.kakkoLeft1;
        source.kakkoLeft2 = sofubutsuAtesakiSource.kakkoLeft2;
        source.kakkoRight1 = sofubutsuAtesakiSource.kakkoRight1;
        source.kakkoRight2 = sofubutsuAtesakiSource.kakkoRight2;
        source.samaBun1 = sofubutsuAtesakiSource.samaBun1;
        source.samaBun2 = sofubutsuAtesakiSource.samaBun2;
        source.customerBarCode = sofubutsuAtesakiSource.customerBarCode;
        source.katagakiSmall1 = sofubutsuAtesakiSource.katagakiSmall1;
        source.katagakiSmall2 = sofubutsuAtesakiSource.katagakiSmall2;
        source.meishoFuyo1 = sofubutsuAtesakiSource.meishoFuyo1;
        source.meishoFuyo2 = sofubutsuAtesakiSource.meishoFuyo2;
        source.samabunShimei1 = sofubutsuAtesakiSource.samabunShimei1;
        source.samabunShimei2 = sofubutsuAtesakiSource.samabunShimei2;
        source.samabunShimeiSmall1 = sofubutsuAtesakiSource.samabunShimeiSmall1;
        source.samabunShimeiSmall2 = sofubutsuAtesakiSource.samabunShimeiSmall2;
        source.shimeiSmall1 = sofubutsuAtesakiSource.shimeiSmall1;
        source.shimeiSmall2 = sofubutsuAtesakiSource.shimeiSmall2;
        source.shimeiText = sofubutsuAtesakiSource.shimeiText;
    }

    private void setCompNinshosha(ShiharaiIchijiSashitomeTsuchishoReportSource source) {
        source.denshiKoin = 認証者ソースビルダー.denshiKoin;
        source.hakkoYMD = 認証者ソースビルダー.hakkoYMD;
        source.ninshoshaYakushokuMei = 認証者ソースビルダー.ninshoshaYakushokuMei;
        source.ninshoshaYakushokuMei1 = 認証者ソースビルダー.ninshoshaYakushokuMei1;
        source.koinMojiretsu = 認証者ソースビルダー.koinMojiretsu;
        source.ninshoshaYakushokuMei2 = 認証者ソースビルダー.ninshoshaYakushokuMei2;
        source.ninshoshaShimeiKakenai = 認証者ソースビルダー.ninshoshaShimeiKakenai;
        source.ninshoshaShimeiKakeru = 認証者ソースビルダー.ninshoshaShimeiKakeru;
        source.koinShoryaku = 認証者ソースビルダー.koinShoryaku;
    }

    private void setLayer1(ShiharaiIchijiSashitomeTsuchishoReportSource source) {
        EditedKojin 編集後個人 = getEditedKojin(this.個人情報, this.帳票制御共通, this.地方公共団体);
        if (null != 編集後個人) {
            source.hihokenshaName = 編集後個人.get名称().getName().getColumnValue();
        }
        source.bunshoNo = this.文書番号;
        if (null != 帳票情報) {
            RString 被保険者番号 = this.帳票情報.get被保険者番号().getColumnValue();
            source.hihokenshaNo1 = 被保険者番号.substring(0, NOCOUNT_1);
            source.hihokenshaNo2 = 被保険者番号.substring(NOCOUNT_1, NOCOUNT_2);
            source.hihokenshaNo3 = 被保険者番号.substring(NOCOUNT_2, NOCOUNT_3);
            source.hihokenshaNo4 = 被保険者番号.substring(NOCOUNT_3, NOCOUNT_4);
            source.hihokenshaNo5 = 被保険者番号.substring(NOCOUNT_4, NOCOUNT_5);
            source.hihokenshaNo6 = 被保険者番号.substring(NOCOUNT_5, NOCOUNT_6);
            source.hihokenshaNo7 = 被保険者番号.substring(NOCOUNT_6, NOCOUNT_7);
            source.hihokenshaNo8 = 被保険者番号.substring(NOCOUNT_7, NOCOUNT_8);
            source.hihokenshaNo9 = 被保険者番号.substring(NOCOUNT_8, NOCOUNT_9);
            source.hihokenshaNo10 = 被保険者番号.substring(NOCOUNT_9, NOCOUNT_10);
        }
        source.tsuchibun1 = 通知書定型文リスト.get(1);
        if (null != 帳票制御共通) {
            RString 定型文文字サイズ = this.帳票制御共通.get定型文文字サイズ();
            if (new RString("1").equals(定型文文字サイズ)) {
                source.renrakusakiHoka = 通知書定型文リスト.get(NOCOUNT_3);
            }
        }

        RString サービス種類コード = RString.EMPTY;
        if (償還払集計情報リスト.size() > 0 && 償還払集計情報リスト.size() <= NOCOUNT_13) {
            for (int i = 0; i < 償還払集計情報リスト.size(); i++) {
                サービス種類コード = サービス種類コード.concat(償還払集計情報リスト.get(i).getサービス種類コード()).
                        concat(new RString(","));
            }
            source.serviceName = サービス種類コード.substring(0, サービス種類コード.length() - 1);
        } else if (償還払集計情報リスト.size() > NOCOUNT_14) {
            for (int i = 0; i < NOCOUNT_13; i++) {
                サービス種類コード = サービス種類コード.concat(償還払集計情報リスト.get(i).getサービス種類コード()).
                        concat(new RString(","));
            }
            source.serviceName = サービス種類コード.substring(0, サービス種類コード.length() - 1);
        } else {
            source.serviceName = サービス種類コード;
        }
        source.hoka = 償還払集計情報リスト.size() <= NOCOUNT_13 ? RString.EMPTY : new RString("他");
        source.kyufuGaku = DecimalFormatter.toコンマ区切りRString(get支払金額合計(), 0);

    }

    private void setHokenryoTainoJyokyoStep1(ShiharaiIchijiSashitomeTsuchishoReportSource source) {
        for (ShiharaiHohoHenkoSashitome 支払方法変更差止 : 帳票情報.getShiharaiHohoHenkoSashitomeList()) {
            if (支払方法変更差止.get情報分類区分().equals(ShiharaiHenkoJohoBunruiKubun.差止情報.getコード())) {
                source.nendoTitle1 = 最新賦課年度.minusYear(2).toDateString();
                source.nendoTitle2 = 最新賦課年度.minusYear(1).toDateString();
                source.nendoTitle3 = 最新賦課年度.toDateString();
                if (null != 帳票情報.getShiharaiHohoHenkoTainoList() && null != 年度1リスト && 年度1リスト.size() > index) {
                    ShiharaiHohoHenkoTaino 支払方法変更滞納 = 年度1リスト.get(index);
                    source.listTainoJokyo_1 = 支払方法変更滞納.get収納期_月();
                    source.listTainoJokyo_2 = DecimalFormatter.toコンマ区切りRString(
                            支払方法変更滞納.get収入額(支払方法変更滞納.get調定額(), 支払方法変更滞納.get滞納額()), 0);
                    source.listTainoJokyo_3 = DecimalFormatter.toコンマ区切りRString(支払方法変更滞納.get滞納額(), 0);
                }
                if (null != 帳票情報.getShiharaiHohoHenkoTainoList() && null != 年度2リスト && 年度2リスト.size() > index) {
                    ShiharaiHohoHenkoTaino 支払方法変更滞納 = 年度2リスト.get(index);
                    source.listTainoJokyo_4 = 支払方法変更滞納.get収納期_月();
                    source.listTainoJokyo_5 = DecimalFormatter.toコンマ区切りRString(
                            支払方法変更滞納.get収入額(支払方法変更滞納.get調定額(), 支払方法変更滞納.get滞納額()), 0);
                    source.listTainoJokyo_6 = DecimalFormatter.toコンマ区切りRString(支払方法変更滞納.get滞納額(), 0);
                }
                if (null != 帳票情報.getShiharaiHohoHenkoTainoList() && null != 年度3リスト && 年度3リスト.size() > index) {
                    ShiharaiHohoHenkoTaino 支払方法変更滞納 = 年度3リスト.get(index);
                    source.listTainoJokyo_7 = 支払方法変更滞納.get収納期_月();
                    source.listTainoJokyo_8 = DecimalFormatter.toコンマ区切りRString(
                            支払方法変更滞納.get収入額(支払方法変更滞納.get調定額(), 支払方法変更滞納.get滞納額()), 0);
                    source.listTainoJokyo_9 = DecimalFormatter.toコンマ区切りRString(支払方法変更滞納.get滞納額(), 0);
                }
            }
        }
    }

    private void setHokenryoTainoJyokyoStep2(ShiharaiIchijiSashitomeTsuchishoReportSource source) {
        for (ShiharaiHohoHenkoSashitome 支払方法変更差止 : 帳票情報.getShiharaiHohoHenkoSashitomeList()) {
            if (支払方法変更差止.get情報分類区分().equals(ShiharaiHenkoJohoBunruiKubun.差止情報.getコード())) {
                if (null != 帳票情報.getShiharaiHohoHenkoTainoList()) {
                    source.hanteiYMD = this.帳票情報.getShiharaiHohoHenkoTainoList().get(index).
                            get滞納判定年月日().wareki().toDateString();
                }
                if (get3年以前滞納額合計().intValue() != 0) {
                    source.izen_hokenryo = new RString(get3年以前滞納額合計().toString());
                }
                if (null != 通知書定型文リスト && !通知書定型文リスト.isEmpty()) {
                    source.tsuchibun2 = 通知書定型文リスト.get(2);
                }
                if (null != 年度1リスト && 年度1リスト.size() > 0) {
                    source.hokenGokei1 = DecimalFormatter.toコンマ区切りRString(get保険料合計(年度1リスト), 0);
                    source.entaiGokei1 = DecimalFormatter.toコンマ区切りRString(get滞納額合計(年度1リスト), 0);
                }
                if (null != 年度2リスト && 年度2リスト.size() > 0) {
                    source.hokenGokei2 = DecimalFormatter.toコンマ区切りRString(get保険料合計(年度2リスト), 0);
                    source.entaiGokei2 = DecimalFormatter.toコンマ区切りRString(get滞納額合計(年度2リスト), 0);
                }
                if (null != 年度3リスト && 年度3リスト.size() > 0) {
                    source.hokenGokei3 = DecimalFormatter.toコンマ区切りRString(get保険料合計(年度3リスト), 0);
                    source.entaiGokei3 = DecimalFormatter.toコンマ区切りRString(get滞納額合計(年度3リスト), 0);
                }

                if (null != 通知書定型文リスト && !通知書定型文リスト.isEmpty()) {
                    source.tsuchibun2 = 通知書定型文リスト.get(2);
                }
            }
        }
    }

    private void setLayerFontLarge(ShiharaiIchijiSashitomeTsuchishoReportSource source) {
        if (null != 帳票制御共通) {
            RString 定型文文字サイズ = this.帳票制御共通.get定型文文字サイズ();
            if (null != 通知書定型文リスト && !通知書定型文リスト.isEmpty() && new RString("2").equals(定型文文字サイズ)) {
                source.renrakusakiHokaLarge = 通知書定型文リスト.get(NOCOUNT_3);
            }
        }
    }

    private void setLayerFontKonzai(ShiharaiIchijiSashitomeTsuchishoReportSource source) {
        if (null != 帳票制御共通) {
            RString 定型文文字サイズ = this.帳票制御共通.get定型文文字サイズ();
            if (null != 通知書定型文リスト && !通知書定型文リスト.isEmpty() && new RString("3").equals(定型文文字サイズ)) {
                source.renrakusakiHokaJodanSmall = 通知書定型文リスト.get(NOCOUNT_3);
                source.renrakusakiHokaGedanLarge = 通知書定型文リスト.get(NOCOUNT_4);
            }
        }
    }

    private void setLayerFontKonzai2(ShiharaiIchijiSashitomeTsuchishoReportSource source) {
        if (null != 帳票制御共通) {
            RString 定型文文字サイズ = this.帳票制御共通.get定型文文字サイズ();
            if (null != 通知書定型文リスト && !通知書定型文リスト.isEmpty() && new RString("4").equals(定型文文字サイズ)) {
                source.renrakusakiHokaJodanLarge = 通知書定型文リスト.get(NOCOUNT_3);
                source.renrakusakiHokaGedanSmall = 通知書定型文リスト.get(NOCOUNT_4);
            }
        }
    }

    private void setAccessLogEditor(ShiharaiIchijiSashitomeTsuchishoReportSource source) {
        source.shikibetsuCode = this.個人情報.get識別コード().getColumnValue();
        source.hihokenshaNo = this.帳票情報.get被保険者番号().getColumnValue();
    }

    private static EditedKojin getEditedKojin(IKojin 個人情報, ChohyoSeigyoKyotsu 帳票制御共通, Association 地方公共団体) {
        return new EditedKojin(個人情報, 帳票制御共通, 地方公共団体);
    }

    private Decimal get滞納額合計(List<ShiharaiHohoHenkoTaino> 年度リスト) {
        Decimal 滞納額合計 = Decimal.ZERO;
        for (ShiharaiHohoHenkoTaino 支払方法変更滞納 : 年度リスト) {
            滞納額合計 = 滞納額合計.add(支払方法変更滞納.get滞納額());
        }
        return 滞納額合計;
    }

    private Decimal get保険料合計(List<ShiharaiHohoHenkoTaino> 年度リスト) {
        Decimal 保険料合計 = Decimal.ZERO;
        for (ShiharaiHohoHenkoTaino 支払方法変更滞納 : 年度リスト) {
            保険料合計 = 保険料合計.add(支払方法変更滞納.get収入額(支払方法変更滞納.get調定額(), 支払方法変更滞納.get滞納額()));
        }
        return 保険料合計;
    }

    private Decimal get3年以前滞納額合計() {
        Decimal 以前保険料合計 = Decimal.ZERO;
        for (ShiharaiHohoHenkoTaino 支払方法変更滞納 : this.帳票情報.getShiharaiHohoHenkoTainoList()) {
            if (支払方法変更滞納.get賦課年度().isBeforeOrEquals(最新賦課年度.minusYear(NOCOUNT_3))) {
                以前保険料合計 = 以前保険料合計.add(支払方法変更滞納.get滞納額());
            }
        }
        return 以前保険料合計;
    }

    private Decimal get支払金額合計() {
        Decimal 支払金額合計 = Decimal.ZERO;
        for (ShokanKihonJihoEntiy 償還払集計情報 : this.償還払集計情報リスト) {
            支払金額合計 = 支払金額合計.add(償還払集計情報.get支払金額());
        }
        return 支払金額合計;
    }

}
