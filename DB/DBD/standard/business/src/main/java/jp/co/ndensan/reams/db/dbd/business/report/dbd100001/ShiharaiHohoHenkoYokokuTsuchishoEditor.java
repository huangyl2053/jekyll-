/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100001;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.taino.ShiharaiHohoHenkoTaino;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100001.ShiharaiHohoHenkoYokokuTsuchishoReportSource;
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
 * 支払方法変更予告通知書Editorです。
 *
 * @reamsid_L DBD-3640-040 b_liuyang2
 */
public class ShiharaiHohoHenkoYokokuTsuchishoEditor implements IShiharaiHohoHenkoYokokuTsuchishoEditor {

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

    private final IKojin 個人情報;
    private final IAtesaki 宛先;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final Association 地方公共団体;
    private final RString 文書番号;
    private final Map<Integer, RString> 通知書定型文リスト;
    private final NinshoshaSource 認証者ソースビルダー;
    private final ShiharaiHohoHenko 帳票情報;
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
     * @param 最新賦課年度 FlexibleYear
     * @param 年度1リスト List<ShiharaiHohoHenkoTaino>
     * @param 年度2リスト List<ShiharaiHohoHenkoTaino>
     * @param 年度3リスト List<ShiharaiHohoHenkoTaino>
     * @param index int
     */
    public ShiharaiHohoHenkoYokokuTsuchishoEditor(IKojin 個人情報, IAtesaki 宛先, ChohyoSeigyoKyotsu 帳票制御共通,
            Association 地方公共団体, RString 文書番号, Map<Integer, RString> 通知書定型文リスト,
            NinshoshaSource 認証者ソースビルダー, ShiharaiHohoHenko 帳票情報, FlexibleYear 最新賦課年度,
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
        this.最新賦課年度 = 最新賦課年度;
        this.年度1リスト = 年度1リスト;
        this.年度2リスト = 年度2リスト;
        this.年度3リスト = 年度3リスト;
        this.index = index;
    }

    @Override
    public ShiharaiHohoHenkoYokokuTsuchishoReportSource edit(ShiharaiHohoHenkoYokokuTsuchishoReportSource source) {

        setCompSofubutsuAtesaki(source);
        setCompNinshosha(source);
        setLayer1(source);
        setAccessLogEditor(source);
        return source;
    }

    private void setCompSofubutsuAtesaki(ShiharaiHohoHenkoYokokuTsuchishoReportSource source) {
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

    private void setCompNinshosha(ShiharaiHohoHenkoYokokuTsuchishoReportSource source) {
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

    private void setLayer1(ShiharaiHohoHenkoYokokuTsuchishoReportSource source) {
        source.bunshoNo = this.文書番号;
        EditedKojin 編集後個人 = getEditedKojin(this.個人情報, this.帳票制御共通, this.地方公共団体);
        if (null != 編集後個人) {
            source.hihokenshaName = 編集後個人.get名称().getName().getColumnValue();
        }
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

        if (null != 通知書定型文リスト && !通知書定型文リスト.isEmpty()) {
            source.tsuchibun1 = 通知書定型文リスト.get(1);
            source.tsuchibun2 = 通知書定型文リスト.get(2);
        }
        if (null != 最新賦課年度 && !最新賦課年度.isEmpty()) {
            source.nendoTitle1 = 最新賦課年度.minusYear(2).toDateString();
            source.nendoTitle2 = 最新賦課年度.minusYear(1).toDateString();
            source.nendoTitle3 = 最新賦課年度.toDateString();
        }
        if (null != 帳票情報.getShiharaiHohoHenkoTainoList() && !帳票情報.getShiharaiHohoHenkoTainoList().isEmpty()) {
            if (null != 年度1リスト && 年度1リスト.size() > index) {
                ShiharaiHohoHenkoTaino 支払方法変更滞納 = 年度1リスト.get(index);
                source.listTainoJokyo_1 = 支払方法変更滞納.get収納期_月();
                source.listTainoJokyo_2 = DecimalFormatter.toコンマ区切りRString(
                        支払方法変更滞納.get収入額(支払方法変更滞納.get調定額(), 支払方法変更滞納.get滞納額()), 0);
                source.listTainoJokyo_3 = DecimalFormatter.toコンマ区切りRString(支払方法変更滞納.get滞納額(), 0);
            }
            if (null != 年度2リスト && 年度2リスト.size() > index) {
                ShiharaiHohoHenkoTaino 支払方法変更滞納 = 年度2リスト.get(index);
                source.listTainoJokyo_4 = 支払方法変更滞納.get収納期_月();
                source.listTainoJokyo_5 = DecimalFormatter.toコンマ区切りRString(
                        支払方法変更滞納.get収入額(支払方法変更滞納.get調定額(), 支払方法変更滞納.get滞納額()), 0);
                source.listTainoJokyo_6 = DecimalFormatter.toコンマ区切りRString(支払方法変更滞納.get滞納額(), 0);
            }
            if (null != 年度3リスト && 年度3リスト.size() > index) {
                ShiharaiHohoHenkoTaino 支払方法変更滞納 = 年度3リスト.get(index);
                source.listTainoJokyo_7 = 支払方法変更滞納.get収納期_月();
                source.listTainoJokyo_8 = DecimalFormatter.toコンマ区切りRString(
                        支払方法変更滞納.get収入額(支払方法変更滞納.get調定額(), 支払方法変更滞納.get滞納額()), 0);
                source.listTainoJokyo_9 = DecimalFormatter.toコンマ区切りRString(支払方法変更滞納.get滞納額(), 0);
            }
            source.hanteiYMD = this.帳票情報.getShiharaiHohoHenkoTainoList().get(index).get滞納判定年月日().wareki().toDateString();
            if (get3年以前滞納額合計().intValue() != 0) {
                source.izenHokenryo = new RString(get3年以前滞納額合計().toString());
            }
            if (年度1リスト.size() > 0) {
                source.hokenGokei1 = DecimalFormatter.toコンマ区切りRString(get保険料合計(年度1リスト), 0);
                source.entaiGokei1 = DecimalFormatter.toコンマ区切りRString(get滞納額合計(年度1リスト), 0);
            }
            if (年度2リスト.size() > 0) {
                source.hokenGokei2 = DecimalFormatter.toコンマ区切りRString(get保険料合計(年度2リスト), 0);
                source.entaiGokei2 = DecimalFormatter.toコンマ区切りRString(get滞納額合計(年度2リスト), 0);
            }
            if (年度3リスト.size() > 0) {
                source.hokenGokei3 = DecimalFormatter.toコンマ区切りRString(get保険料合計(年度3リスト), 0);
                source.entaiGokei3 = DecimalFormatter.toコンマ区切りRString(get滞納額合計(年度3リスト), 0);
            }
        }
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

    private static EditedKojin getEditedKojin(IKojin 個人情報, ChohyoSeigyoKyotsu 帳票制御共通, Association 地方公共団体) {
        return new EditedKojin(個人情報, 帳票制御共通, 地方公共団体);
    }

    private void setAccessLogEditor(ShiharaiHohoHenkoYokokuTsuchishoReportSource source) {
        source.shikibetsuCode = this.個人情報.get識別コード().getColumnValue();
        source.hihokenshaNo = this.帳票情報.get被保険者番号().getColumnValue();
    }
}
