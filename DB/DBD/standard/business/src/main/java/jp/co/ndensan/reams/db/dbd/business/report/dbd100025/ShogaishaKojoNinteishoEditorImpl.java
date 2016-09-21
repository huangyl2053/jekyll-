/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100025;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.shogaishakoujo.NinteiNaiyoKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.shogaishakoujo.Ninteikubun;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd4030011.NinteishoJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100025.NinteishoJohoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 障がい者控除対象者認定証のEditorです。
 *
 * @reamsid_L DBD-3870-030 donghj
 */
public class ShogaishaKojoNinteishoEditorImpl implements IShogaishaKojoNinteishoEditor {

    private final NinteishoJohoEntity target;
    private final IKojin iKojin;
    private final IAtesaki iAtesaki;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final Association 地方公共団体;
    private final RString 文書番号;
    private final List<RString> 通知書定型文List;
    private final NinshoshaSource ninshoshaSource;
    private static final int NOCOUNT_2 = 2;
    private static final int NOCOUNT_3 = 3;

    /**
     * インスタンスを生成します。
     *
     * @param target NinteishoJohoEntity
     * @param iKojin iKojin
     * @param iAtesaki iAtesaki
     * @param 帳票制御共通 帳票制御共通
     * @param 地方公共団体 地方公共団体
     * @param ninshoshaSource 認証者
     * @param 通知書定型文List 通知書定型文List
     * @param 文書番号 文書番号
     */
    protected ShogaishaKojoNinteishoEditorImpl(NinteishoJohoEntity target, IKojin iKojin, IAtesaki iAtesaki, ChohyoSeigyoKyotsu 帳票制御共通,
            Association 地方公共団体, RString 文書番号, List<RString> 通知書定型文List, NinshoshaSource ninshoshaSource) {
        this.target = target;
        this.iKojin = iKojin;
        this.iAtesaki = iAtesaki;
        this.帳票制御共通 = 帳票制御共通;
        this.地方公共団体 = 地方公共団体;
        this.文書番号 = 文書番号;
        this.通知書定型文List = 通知書定型文List;
        this.ninshoshaSource = ninshoshaSource;
    }

    /**
     * 障がい者控除対象者認定証Editorです。
     *
     * @param source NinteishoJohoReportSource
     * @return NinteishoJohoReportSource
     */
    @Override
    public NinteishoJohoReportSource edit(NinteishoJohoReportSource source) {
        return edit項目(source);
    }

    private NinteishoJohoReportSource edit項目(NinteishoJohoReportSource source) {
        EditedKojin 編集後個人 = getEditedKojin(this.iKojin, this.帳票制御共通, this.地方公共団体);
        source.hihokenshaNo = target.get被保険者番号().getColumnValue();
        source.shikibetsuCode = iKojin.get識別コード().getColumnValue();
        source.hihokenshaJusho = 編集後個人.get編集後住所();
        source.hihokenshaName = 編集後個人.get名称().getName().getColumnValue();
        FlexibleDate 対象者生年月日 = iKojin.get生年月日().toFlexibleDate();
        if (iKojin.is日本人() && 対象者生年月日 != null) {
            source.birthYMD = 対象者生年月日.wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        } else if (対象者生年月日 != null) {
            source.seibetsu = 対象者生年月日.seireki()
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        RString 性別 = RString.EMPTY;
        if (new RString("1").equals(iKojin.get性別().code())) {
            性別 = new RString("男");
        } else if (new RString("2").equals(iKojin.get性別().code())) {
            性別 = new RString("女");
        }
        source.seibetsu = 性別;
        edit文書番号(source);
        edit発行日(source);
        edit通知文(source);
        edit認証者(source);
        edit申請者住所(source);
        edit申請者氏名(source);
        edit障害理由(source);
        edit要介護認定日(source);
        edit申告年(source);
        edit連絡先他(source);
        editLayerFontLarge(source);
        editLayerFontKonzai(source);
        editLayerFontKonzai2(source);
        editCompSofubutsuAtesaki(source);
        return source;
    }

    private void edit文書番号(NinteishoJohoReportSource source) {
        source.bunshoNo = 文書番号;
    }

    private void edit発行日(NinteishoJohoReportSource source) {
        source.hakkoYMD = target.get発行日() == null ? RString.EMPTY : target.get発行日().wareki()
                .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.ZERO).toDateString();
    }

    private void edit通知文(NinteishoJohoReportSource source) {
        if (null != 通知書定型文List && !通知書定型文List.isEmpty()) {
            source.tsuchiBun1 = 通知書定型文List.get(1);
        }
    }

    private void edit認証者(NinteishoJohoReportSource source) {
        source.denshiKoin = ninshoshaSource.denshiKoin;
        source.hakkoYMD = ninshoshaSource.hakkoYMD;
        source.ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
        source.ninshoshaYakushokuMei1 = ninshoshaSource.ninshoshaYakushokuMei1;
        source.koinMojiretsu = ninshoshaSource.koinMojiretsu;
        source.ninshoshaYakushokuMei2 = ninshoshaSource.ninshoshaYakushokuMei2;
        source.ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
        source.ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
        source.koinShoryaku = ninshoshaSource.koinShoryaku;
    }

    private void edit申請者住所(NinteishoJohoReportSource source) {
        source.shiseishaJusho = target.get申請者住所();
    }

    private void edit申請者氏名(NinteishoJohoReportSource source) {
        source.shiseishaShimei = target.get申請者氏名();
    }

    private void edit障害理由(NinteishoJohoReportSource source) {
        if (new RString("1").equals(target.get障害理由区分())) {
            source.ninnteiKubun = Ninteikubun.障がい者.get名称();
        } else if (new RString("2").equals(target.get障害理由区分())) {
            source.ninnteiKubun = Ninteikubun.特別障がい者.get名称();
        }
        if (new RString("1").equals(target.get障害理由内容())) {
            source.ninnteiKubun1 = NinteiNaiyoKubun.知的障がい者_軽度_中度_に準ずる.get名称();
        } else if (new RString("2").equals(target.get障害理由内容())) {
            source.ninnteiKubun1 = NinteiNaiyoKubun.知的障がい者_重度_に準ずる.get名称();
        } else if (new RString("3").equals(target.get障害理由内容())) {
            source.ninnteiKubun1 = NinteiNaiyoKubun.身体障がい者_３から６級_に準ずる.get名称();
        } else if (new RString("4").equals(target.get障害理由内容())) {
            source.ninnteiKubun1 = NinteiNaiyoKubun.ねたきり老人.get名称();
        }
    }

    private void edit要介護認定日(NinteishoJohoReportSource source) {
        source.ninteiYMD = target.get要介護認定日() == null ? RString.EMPTY : target.get要介護認定日().wareki()
                .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString();
    }

    private void edit申告年(NinteishoJohoReportSource source) {
        source.shinkokuNen = target.get対象年度() == null ? RString.EMPTY : target.get対象年度().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
    }

    private void edit連絡先他(NinteishoJohoReportSource source) {
        RString 定型文文字サイズ = this.帳票制御共通.get定型文文字サイズ();
        if (null != 通知書定型文List && !通知書定型文List.isEmpty() && new RString("1").equals(定型文文字サイズ)) {
            source.renrakusakiHoka = 通知書定型文List.get(NOCOUNT_2);
        }
    }

    private void editLayerFontLarge(NinteishoJohoReportSource source) {
        RString 定型文文字サイズ = this.帳票制御共通.get定型文文字サイズ();
        if (null != 通知書定型文List && !通知書定型文List.isEmpty() && new RString("2").equals(定型文文字サイズ)) {
            source.renrakusakiHokaLarge = 通知書定型文List.get(NOCOUNT_2);
        }
    }

    private void editLayerFontKonzai(NinteishoJohoReportSource source) {
        RString 定型文文字サイズ = this.帳票制御共通.get定型文文字サイズ();
        if (null != 通知書定型文List && !通知書定型文List.isEmpty() && new RString("3").equals(定型文文字サイズ)) {
            source.renrakusakiHokaJodanSmall = 通知書定型文List.get(NOCOUNT_2);
            source.renrakusakiHokaGedanLarge = 通知書定型文List.get(NOCOUNT_3);
        }
    }

    private void editLayerFontKonzai2(NinteishoJohoReportSource source) {
        RString 定型文文字サイズ = this.帳票制御共通.get定型文文字サイズ();
        if (null != 通知書定型文List && !通知書定型文List.isEmpty() && new RString("4").equals(定型文文字サイズ)) {
            source.renrakusakiHokaJodanLarge = 通知書定型文List.get(NOCOUNT_2);
            source.renrakusakiHokaGedanSmall = 通知書定型文List.get(NOCOUNT_3);
        }
    }

    private void editCompSofubutsuAtesaki(NinteishoJohoReportSource source) {
        EditedAtesaki 編集後宛先 = JushoHenshu.create編集後宛先(this.iAtesaki, this.地方公共団体, this.帳票制御共通);
        SofubutsuAtesakiSource sofubutsuAtesakiSource;
        try {
            sofubutsuAtesakiSource = 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース();
        } catch (Exception e) {
            sofubutsuAtesakiSource = new SofubutsuAtesakiSource();
        }
        source.customerBarCode = sofubutsuAtesakiSource.customerBarCode;
        source.dainoKubunMei = sofubutsuAtesakiSource.dainoKubunMei;
        source.gyoseiku = sofubutsuAtesakiSource.gyoseiku;
        source.jusho1 = sofubutsuAtesakiSource.jusho1;
        source.jusho2 = sofubutsuAtesakiSource.jusho2;
        source.jusho3 = sofubutsuAtesakiSource.jusho3;
        source.jushoText = sofubutsuAtesakiSource.jushoText;
        source.kakkoLeft1 = sofubutsuAtesakiSource.kakkoLeft1;
        source.kakkoLeft2 = sofubutsuAtesakiSource.kakkoLeft2;
        source.kakkoRight1 = sofubutsuAtesakiSource.kakkoRight1;
        source.kakkoRight2 = sofubutsuAtesakiSource.kakkoRight2;
        source.katagaki1 = sofubutsuAtesakiSource.katagaki1;
        source.katagaki2 = sofubutsuAtesakiSource.katagaki2;
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
        source.shimei1 = sofubutsuAtesakiSource.shimei1;
        source.shimei2 = sofubutsuAtesakiSource.shimei2;
        source.shimeiSmall1 = sofubutsuAtesakiSource.shimeiSmall1;
        source.shimeiSmall2 = sofubutsuAtesakiSource.shimeiSmall2;
        source.shimeiText = sofubutsuAtesakiSource.shimeiText;
        source.yubinNo = sofubutsuAtesakiSource.yubinNo;
    }

    private static EditedKojin getEditedKojin(IKojin 個人情報, ChohyoSeigyoKyotsu 帳票制御共通, Association 地方公共団体) {
        return new EditedKojin(個人情報, 帳票制御共通, 地方公共団体);
    }
}
