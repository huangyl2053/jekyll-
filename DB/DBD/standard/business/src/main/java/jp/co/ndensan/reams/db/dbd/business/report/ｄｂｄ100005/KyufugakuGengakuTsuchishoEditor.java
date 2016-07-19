/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.ｄｂｄ100005;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.entity.report.ｄｂｄ100005.KyufugakuGengakuTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 給付額減額通知書
 *
 * @reamsid_L DBD-3640-060 b_liuyang2
 */
public class KyufugakuGengakuTsuchishoEditor implements IKyufugakuGengakuTsuchishoEditor {

    private final IKojin 個人情報;
    private final IAtesaki 宛先;
    private final List<ChohyoSeigyoHanyo> 帳票制御汎用リスト;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final Association 地方公共団体;
    private final FlexibleDate 発行日;
    private final RString 文書番号;
    private final List<RString> 通知書定型文リスト;
    private final RString 帳票分類ID;
    private final Ninshosha 認証者;
    private final ShiharaiHohoHenko 帳票情報;
    private final RString イメージファイルパス;
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

    /**
     * インスタンスを生成します。
     *
     * @param 個人情報 個人情報
     * @param 宛先 宛先
     * @param 帳票制御汎用リスト 帳票制御汎用リスト
     * @param 帳票制御共通 帳票制御共通
     * @param 地方公共団体 地方公共団体
     * @param 発行日 発行日
     * @param 文書番号 文書番号
     * @param 通知書定型文リスト 通知書定型文リスト
     * @param 帳票分類ID 帳票分類ID
     * @param 認証者 認証者
     * @param 帳票情報 帳票情報
     * @param イメージファイルパス イメージファイルパス
     */
    public KyufugakuGengakuTsuchishoEditor(IKojin 個人情報, IAtesaki 宛先, List<ChohyoSeigyoHanyo> 帳票制御汎用リスト,
            ChohyoSeigyoKyotsu 帳票制御共通, Association 地方公共団体, FlexibleDate 発行日, RString 文書番号,
            List<RString> 通知書定型文リスト, RString 帳票分類ID, Ninshosha 認証者, ShiharaiHohoHenko 帳票情報,
            RString イメージファイルパス) {
        this.個人情報 = 個人情報;
        this.宛先 = 宛先;
        this.帳票制御汎用リスト = 帳票制御汎用リスト;
        this.帳票制御共通 = 帳票制御共通;
        this.地方公共団体 = 地方公共団体;
        this.発行日 = 発行日;
        this.文書番号 = 文書番号;
        this.通知書定型文リスト = 通知書定型文リスト;
        this.帳票分類ID = 帳票分類ID;
        this.認証者 = 認証者;
        this.帳票情報 = 帳票情報;
        this.イメージファイルパス = イメージファイルパス;
    }

    @Override
    public KyufugakuGengakuTsuchishoReportSource edit(KyufugakuGengakuTsuchishoReportSource source) {

        setCompSofubutsuAtesaki(source);
        setCompNinshosha(source);
        setLayer1(source);
//        setKyufugakuGengaku(source);
        setLayerFontLarge(source);
        setLayerFontKonzai(source);
        setLayerFontKonzai2(source);
        アクセスログeditor(source);
        return source;
    }

    private void setCompSofubutsuAtesaki(KyufugakuGengakuTsuchishoReportSource source) {
        EditedAtesaki 編集後宛先 = JushoHenshu.create編集後宛先(this.宛先, this.地方公共団体, this.帳票制御共通);
        SofubutsuAtesakiSource sofubutsuAtesakiSource;
        try {
            sofubutsuAtesakiSource = 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース();
        } catch (Exception e) {
            sofubutsuAtesakiSource = new SofubutsuAtesakiSource();
        }
        source.customerBarCode = sofubutsuAtesakiSource.customerBarCode;
        source.dainoKubunMei = sofubutsuAtesakiSource.dainoKubunMei;
        source.gyoseiku1 = sofubutsuAtesakiSource.gyoseiku;
        //source.jusho4 = sofubutsuAtesakiSource.jusho4;
        //source.jusho5 = RString.EMPTY;
        //source.jusho6 = RString.EMPTY;
        source.jushoText = sofubutsuAtesakiSource.jushoText;
        source.kakkoLeft1 = sofubutsuAtesakiSource.kakkoLeft1;
        source.kakkoLeft2 = sofubutsuAtesakiSource.kakkoLeft2;
        source.kakkoRight1 = sofubutsuAtesakiSource.kakkoRight1;
        source.kakkoRight2 = sofubutsuAtesakiSource.kakkoRight2;
        // source.katagaki3 = RString.EMPTY;
        // source.katagaki4 = RString.EMPTY;
        source.katagakiSmall1 = sofubutsuAtesakiSource.katagakiSmall1;
        source.katagakiSmall2 = sofubutsuAtesakiSource.katagakiSmall2;
        source.katagakiText = sofubutsuAtesakiSource.katagakiText;
        source.meishoFuyo1 = sofubutsuAtesakiSource.meishoFuyo1;
        source.meishoFuyo2 = sofubutsuAtesakiSource.meishoFuyo2;
        source.samaBun1 = sofubutsuAtesakiSource.samaBun1;
        source.samaBun2 = sofubutsuAtesakiSource.samaBun2;
        source.samabunShimei1 = sofubutsuAtesakiSource.samabunShimei1;
        source.samabunShimei2 = sofubutsuAtesakiSource.samabunShimei2;
        source.samabunShimeiSmall1 = sofubutsuAtesakiSource.samabunShimeiSmall1;
        source.samabunShimeiSmall2 = sofubutsuAtesakiSource.samabunShimeiSmall2;
        source.samabunShimeiText = sofubutsuAtesakiSource.samabunShimeiText;
        // source.shimei3 = RString.EMPTY;
        // source.shimei4 = RString.EMPTY;
        source.shimeiSmall1 = sofubutsuAtesakiSource.shimeiSmall1;
        source.shimeiSmall2 = sofubutsuAtesakiSource.shimeiSmall2;
        source.shimeiText = sofubutsuAtesakiSource.shimeiText;
        source.yubinNo = sofubutsuAtesakiSource.yubinNo;
    }

    private void setCompNinshosha(KyufugakuGengakuTsuchishoReportSource source) {
        NinshoshaSource ninshoshaSource = getCompNinshosha();
        source.denshiKoin = ninshoshaSource.denshiKoin;
        source.hakkoYMD = ninshoshaSource.hakkoYMD;
        source.koinMojiretsu = ninshoshaSource.koinMojiretsu;
        source.koinShoryaku = ninshoshaSource.koinShoryaku;
        source.ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
        source.ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
        source.ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
        source.ninshoshaYakushokuMei1 = ninshoshaSource.ninshoshaYakushokuMei1;
        source.ninshoshaYakushokuMei2 = ninshoshaSource.ninshoshaYakushokuMei2;
    }

    private NinshoshaSource getCompNinshosha() {
        RDate 発行日RDate = new RDate(this.発行日.toString());
        return NinshoshaSourceBuilderFactory.createInstance(
                this.認証者, this.地方公共団体, this.イメージファイルパス, 発行日RDate).buildSource();
    }

    private void setLayer1(KyufugakuGengakuTsuchishoReportSource source) {
        source.bunshoNo = this.文書番号;
        EditedKojin 編集後個人 = getEditedKojin(this.個人情報, this.帳票制御共通);
        source.hihokenshaName = 編集後個人.get名称().getName().getColumnValue();
        if (this.帳票情報.get被保険者番号() != null) {
            RString 被保険者番号 = this.帳票情報.get被保険者番号().getColumnValue();
            for (int i = 1; i <= 被保険者番号.length(); i++) {
                if (i == NOCOUNT_1) {
                    source.hihokenshaNo1 = 被保険者番号.substring(0, NOCOUNT_1);
                }
                if (i == NOCOUNT_2) {
                    source.hihokenshaNo2 = 被保険者番号.substring(NOCOUNT_1, NOCOUNT_2);
                }
                if (i == NOCOUNT_3) {
                    source.hihokenshaNo3 = 被保険者番号.substring(NOCOUNT_2, NOCOUNT_3);
                }
                if (i == NOCOUNT_4) {
                    source.hihokenshaNo4 = 被保険者番号.substring(NOCOUNT_3, NOCOUNT_4);
                }
                if (i == NOCOUNT_5) {
                    source.hihokenshaNo5 = 被保険者番号.substring(NOCOUNT_4, NOCOUNT_5);
                }
                if (i == NOCOUNT_6) {
                    source.hihokenshaNo6 = 被保険者番号.substring(NOCOUNT_5, NOCOUNT_6);
                }
                if (i == NOCOUNT_7) {
                    source.hihokenshaNo7 = 被保険者番号.substring(NOCOUNT_6, NOCOUNT_7);
                }
                if (i == NOCOUNT_8) {
                    source.hihokenshaNo8 = 被保険者番号.substring(NOCOUNT_7, NOCOUNT_8);
                }
                if (i == NOCOUNT_9) {
                    source.hihokenshaNo9 = 被保険者番号.substring(NOCOUNT_8, NOCOUNT_9);
                }
                if (i == NOCOUNT_10) {
                    source.hihokenshaNo10 = 被保険者番号.substring(NOCOUNT_9, NOCOUNT_10);
                }
            }
        }

        if (null != 通知書定型文リスト && !通知書定型文リスト.isEmpty()) {
            source.tsuchibun = 通知書定型文リスト.get(0);
        }
        if (null != 通知書定型文リスト && this.帳票制御共通.get定型文文字サイズ().equals(1)) {
            source.renrakusakiHoka = 通知書定型文リスト.get(1);
        }

    }

    private static EditedKojin getEditedKojin(IKojin 個人情報, ChohyoSeigyoKyotsu 帳票制御共通) {
        return new EditedKojin(個人情報, 帳票制御共通);
    }

//    private void setKyufugakuGengaku(KyufugakuGengakuTsuchishoReportSource source) {
//
//    }
    private void setLayerFontLarge(KyufugakuGengakuTsuchishoReportSource source) {
        if (null != 通知書定型文リスト && this.帳票制御共通.get定型文文字サイズ().equals(2)) {
            source.renrakusakiHokaLarge = 通知書定型文リスト.get(1);
        } else {
            source.renrakusakiHokaLarge = RString.EMPTY;
        }
    }

    private void setLayerFontKonzai(KyufugakuGengakuTsuchishoReportSource source) {
        if (null != 通知書定型文リスト && this.帳票制御共通.get定型文文字サイズ().equals(3)) {
            source.renrakusakiHokaJodanSmall = 通知書定型文リスト.get(1);
            source.renrakusakiHokaGedanLarge = 通知書定型文リスト.get(2);
        } else {
            source.renrakusakiHokaJodanSmall = RString.EMPTY;
            source.renrakusakiHokaGedanLarge = RString.EMPTY;
        }
    }

    private void setLayerFontKonzai2(KyufugakuGengakuTsuchishoReportSource source) {
        if (null != 通知書定型文リスト && this.帳票制御共通.get定型文文字サイズ().equals(4)) {
            source.renrakusakiHokaJodanLarge = 通知書定型文リスト.get(1);
            source.renrakusakiHokaGedanSmall = 通知書定型文リスト.get(2);
        } else {
            source.renrakusakiHokaJodanLarge = RString.EMPTY;
            source.renrakusakiHokaGedanSmall = RString.EMPTY;
        }
    }

    private void アクセスログeditor(KyufugakuGengakuTsuchishoReportSource source) {
        source.shikibetsuCode = this.個人情報.get識別コード().getColumnValue();
        source.hihokenshaNo = this.帳票情報.get被保険者番号().getColumnValue();

    }

}
