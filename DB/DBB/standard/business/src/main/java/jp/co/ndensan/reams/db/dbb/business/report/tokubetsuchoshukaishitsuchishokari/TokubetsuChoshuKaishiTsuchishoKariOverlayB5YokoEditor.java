/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariTokuchoKaishiTsuchisyoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 特別徴収開始通知書（仮算定）帳票 B5横・オーバレイタイプEditor
 *
 * @reamsid_L DBB-0790-050 lijunjun
 */
public class TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoEditor implements
        ITokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoEditor {

    private static final RString NENDO = new RString("年度");

    private final KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報;
    private final RString 通知書定型文１;
    private final RString 通知書定型文２;
    private final NinshoshaSource ninshoshaSource;
    private final CompKaigoToiawasesakiSource toiawasesakiSource;

    /**
     * コンストラクタです
     *
     * @param ninshoshaSource NinshoshaSource
     * @param toiawasesakiSource CompKaigoToiawasesakiSource
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     * @param 通知書定型文１ RString
     * @param 通知書定型文２ RString
     */
    public TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoEditor(NinshoshaSource ninshoshaSource,
            CompKaigoToiawasesakiSource toiawasesakiSource,
            KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            RString 通知書定型文１,
            RString 通知書定型文２) {
        this.ninshoshaSource = ninshoshaSource;
        this.toiawasesakiSource = toiawasesakiSource;
        this.仮算定特徴開始通知書情報 = 仮算定特徴開始通知書情報;
        this.通知書定型文１ = 通知書定型文１;
        this.通知書定型文２ = 通知書定型文２;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource edit(TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource source) {
        source.nendo1 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get調定年度().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString().concat(NENDO);
        source.nendo2 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get調定年度().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString().concat(NENDO);
        source.tsuchishoNo2 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get通知書番号().value();
        if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人() != null) {
            source.setaiCode2 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get世帯コード().value();
        }
        // TODO  内部番号639 被保険者番号2
        source.hihokenshaNo2 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get被保険者番号().value();
        source.shikibetsuCode2 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get識別コード().value();
        if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人() != null) {
            source.hihokenshaName2 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get名称().getName().value();
            source.birthYMD2 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get生年月日();
            source.seibetsu2 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get性別();
        }
        if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後() != null) {
            source.tokuchoGimushaName2 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後().get更正後特別徴収義務者();
            source.tokuchoTaishoNenkinName2 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後().get更正後特別徴収対象年金();
            source.hokenryoGokei = DecimalFormatter.toコンマ区切りRString(
                    仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後().get更正後特徴期別金額01()
                    .add(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後().get更正後特徴期別金額02())
                    .add(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後().get更正後特徴期別金額03()),
                    0);
        }
        source.nendo3 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get調定年度().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString().concat(NENDO);
        if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get前年度情報() != null) {
            source.nendo4 = new FlexibleYear(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get前年度情報().get前年度賦課年度())
                    .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString().concat(NENDO);
        }

        source.nendo5 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get調定年度().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString().concat(NENDO);
        if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get前年度情報() != null) {
            source.shotokuDankai = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get前年度情報().get前年度保険料段階();
        }
        source.tsuchibun1 = 通知書定型文１;
        if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後() != null) {
            source.hokenryoGaku4Gatsu2 = DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                    .get更正後().get更正後特徴期別金額02(), 0);
        }
        if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get前年度情報() != null) {
            source.hokenryoRitsu = DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                    .get前年度情報().get前年度保険料率(), 0);
        }
        source.tsuchibun2 = 通知書定型文２;
        if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後() != null) {
            source.hokenryoGaku6Gatsu2 = DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                    .get更正後().get更正後特徴期別金額02(), 0);
            source.hokenryoGaku8Gatsu2 = DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                    .get更正後().get更正後特徴期別金額03(), 0);
        }
        source.hyojicodeName1 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get表示コード１名();
        source.hyojicodeName2 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get表示コード２名();
        source.hyojicodeName3 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get表示コード３名();
        source.hyojicode1 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get表示コード1();
        source.hyojicode2 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get表示コード２();
        source.hyojicode3 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get表示コード３();
        source.tsuchishoNo1 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get通知書番号().value();

        if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人() != null) {
            source.setaiCode1 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get世帯コード().value();
        }
        // TODO  内部番号639 被保険者番号1
        source.hihokenshaNo1 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get被保険者番号().value();
        source.shikibetsuCode1 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get識別コード().value();
        if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人() != null) {
            source.hihokenshaName1 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get名称().getName().value();
            source.birthYMD1 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get生年月日();
            source.seibetsu1 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get性別();
            source.setainushiName1 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get世帯主名().value();
        }
        if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後() != null) {
            source.tokuchoGimushaName1 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後().get更正後特別徴収義務者();
            source.tokuchoTaishoNenkinName1 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後().get更正後特別徴収対象年金();
            source.hokenryoGaku4Gatsu1 = DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                    .get更正後().get更正後特徴期別金額01(), 0);
            source.hokenryoGaku6Gatsu1 = DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                    .get更正後().get更正後特徴期別金額02(), 0);
            source.hokenryoGaku8Gatsu1 = DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                    .get更正後().get更正後特徴期別金額03(), 0);
        }
        // TODO 内部番号639 保険者名
        source.hokenshaName = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get保険者名();

        // TODO 内部番号647
        EditedAtesaki 編集後宛先 = new EditedAtesaki(仮算定特徴開始通知書情報.get宛先情報(), 仮算定特徴開始通知書情報.get地方公共団体(),
                仮算定特徴開始通知書情報.get帳票制御共通(), null, null, true,
                null, null, null, null);
        SofubutsuAtesakiSource sofubutsuAtesakiSource = 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース();
        source.yubinNo1 = sofubutsuAtesakiSource.yubinNo;
        source.gyoseiku1 = sofubutsuAtesakiSource.gyoseiku;
        source.jusho3 = sofubutsuAtesakiSource.jusho3;
        source.jushoText = sofubutsuAtesakiSource.jushoText;
        source.jusho1 = sofubutsuAtesakiSource.jusho1;
        source.jusho2 = sofubutsuAtesakiSource.jusho2;
        source.katagakiText = sofubutsuAtesakiSource.katagakiText;
        source.katagaki2 = sofubutsuAtesakiSource.katagaki2;
        source.katagakiSmall2 = sofubutsuAtesakiSource.katagakiSmall2;
        source.katagaki1 = sofubutsuAtesakiSource.katagaki1;
        source.katagakiSmall1 = sofubutsuAtesakiSource.katagakiSmall1;
        source.shimei2 = sofubutsuAtesakiSource.shimei2;
        source.shimeiSmall2 = sofubutsuAtesakiSource.shimeiSmall2;
        source.shimeiText = sofubutsuAtesakiSource.shimeiText;
        source.meishoFuyo2 = sofubutsuAtesakiSource.meishoFuyo2;
        source.shimeiSmall1 = sofubutsuAtesakiSource.shimeiSmall1;
        source.dainoKubunMei = sofubutsuAtesakiSource.dainoKubunMei;
        source.shimei1 = sofubutsuAtesakiSource.shimei1;
        source.meishoFuyo1 = sofubutsuAtesakiSource.meishoFuyo1;
        source.samabunShimeiText = sofubutsuAtesakiSource.samabunShimeiText;
        source.samabunShimeiSmall2 = sofubutsuAtesakiSource.samabunShimeiSmall2;
        source.samaBun2 = sofubutsuAtesakiSource.samaBun2;
        source.kakkoLeft2 = sofubutsuAtesakiSource.kakkoLeft2;
        source.samabunShimei2 = sofubutsuAtesakiSource.samabunShimei2;
        source.kakkoRight2 = sofubutsuAtesakiSource.kakkoRight2;
        source.kakkoLeft1 = sofubutsuAtesakiSource.kakkoLeft1;
        source.samabunShimei1 = sofubutsuAtesakiSource.samabunShimei1;
        source.samaBun1 = sofubutsuAtesakiSource.samaBun1;
        source.kakkoRight1 = sofubutsuAtesakiSource.kakkoRight1;
        source.samabunShimeiSmall1 = sofubutsuAtesakiSource.samabunShimeiSmall1;
        source.customerBarCode = sofubutsuAtesakiSource.customerBarCode;
        // TODO 世帯主名
        //source.setainusimei = item.get世帯主名();
        // TODO 様方
        //source.samaKata = item.get様方();

        source.yubinBango = toiawasesakiSource.yubinBango;
        source.shozaichi = toiawasesakiSource.shozaichi;
        source.choshaBushoName = toiawasesakiSource.choshaBushoName;
        source.tantoName = toiawasesakiSource.tantoName;
        source.telNo = toiawasesakiSource.telNo;
        source.naisenNo = toiawasesakiSource.naisenNo;

        source.hakkoYMD = ninshoshaSource.hakkoYMD;
        source.denshiKoin = ninshoshaSource.denshiKoin;
        source.koinMojiretsu = ninshoshaSource.koinMojiretsu;
        source.koinShoryaku = ninshoshaSource.koinShoryaku;
        source.ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
        source.ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
        source.ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
        return source;
    }

}
