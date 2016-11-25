/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariTokuchoKaishiTsuchisyoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerSource;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 特別徴収開始通知書（仮算定）帳票 シーラタイプEditor
 *
 * @reamsid_L DBB-0790-050 lijunjun
 */
public class TokubetsuChoshuKaishiTsuchishoKariSealerEditor implements
        ITokubetsuChoshuKaishiTsuchishoKariSealerEditor {

    private final KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報;
    private final EditedAtesaki 編集後宛先;
    private final NinshoshaSource ninshoshaSource;

    /**
     * コンストラクタです
     *
     * @param 編集後宛先 EditedAtesaki
     * @param ninshoshaSource NinshoshaSource
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     */
    public TokubetsuChoshuKaishiTsuchishoKariSealerEditor(EditedAtesaki 編集後宛先,
            NinshoshaSource ninshoshaSource,
            KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報) {
        this.編集後宛先 = 編集後宛先;
        this.ninshoshaSource = ninshoshaSource;
        this.仮算定特徴開始通知書情報 = 仮算定特徴開始通知書情報;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoKariSealerSource edit(TokubetsuChoshuKaishiTsuchishoKariSealerSource source) {

        editorSource(source);
        editorSource_1(source);
        editorSource_2(source);
        if (編集後宛先 != null && 編集後宛先.getSofubutsuAtesakiSource() != null
                && 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース() != null) {
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
        }
        if (ninshoshaSource != null) {
            source.hakkoYMD = ninshoshaSource.hakkoYMD;
            source.denshiKoin = ninshoshaSource.denshiKoin;
            source.koinMojiretsu = ninshoshaSource.koinMojiretsu;
            source.koinShoryaku = ninshoshaSource.koinShoryaku;
            source.ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
            source.ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
            source.ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
        }
        return source;
    }

    private void editorSource(TokubetsuChoshuKaishiTsuchishoKariSealerSource source) {
        if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人() != null) {
            source.birthYMD = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get生年月日For帳票();
            source.hihokenshaJusho = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後宛先().get編集後住所();
            if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get方書() != null) {
                source.hihokenshaKatagaki = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get方書().value();
            }
            if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get名称() != null) {
                source.hihokenshaName = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get名称().getName().value();
            }
        }
        if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後() != null) {
            if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                    .get更正後().get更正後特徴期別金額01() != null) {
                source.hokenryoGaku4Gatsu1 = DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                        .get更正後().get更正後特徴期別金額01(), 0);
                source.hokenryoGaku4Gatsu2 = DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                        .get更正後().get更正後特徴期別金額01(), 0);
            }
            if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                    .get更正後().get更正後特徴期別金額02() != null) {
                source.hokenryoGaku6Gatsu1 = DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                        .get更正後().get更正後特徴期別金額02(), 0);
                source.hokenryoGaku6Gatsu2 = DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                        .get更正後().get更正後特徴期別金額02(), 0);
            }
            if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                    .get更正後().get更正後特徴期別金額03() != null) {
                source.hokenryoGaku8Gatsu1 = DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                        .get更正後().get更正後特徴期別金額03(), 0);
                source.hokenryoGaku8Gatsu2 = DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                        .get更正後().get更正後特徴期別金額03(), 0);
            }
        }
    }

    private void editorSource_1(TokubetsuChoshuKaishiTsuchishoKariSealerSource source) {
        if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get前年度情報() != null) {
            if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                    .get前年度情報().get前年度特徴期別金額04() != null) {
                source.hokenryoGakuZen10Gatsu = DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                        .get前年度情報().get前年度特徴期別金額04(), 0);
            }
            if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                    .get前年度情報().get前年度特徴期別金額05() != null) {
                source.hokenryoGakuZen12Gatsu = DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                        .get前年度情報().get前年度特徴期別金額05(), 0);
            }
            if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                    .get前年度情報().get前年度最終期特徴期別介護保険料() != null) {
                source.hokenryoGakuZen2Gatsu = DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                        .get前年度情報().get前年度最終期特徴期別介護保険料(), 0);
            }
        }
        if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後() != null) {
            source.hokenryoGokei = DecimalFormatter.toコンマ区切りRString(
                    nullToDemical(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後().get更正後特徴期別金額01())
                    .add(nullToDemical(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後().get更正後特徴期別金額02()))
                    .add(nullToDemical(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後().get更正後特徴期別金額03())),
                    0);
        }
        source.hyojicode1 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get表示コード1();
        source.hyojicode2 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get表示コード２();
        source.hyojicode3 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get表示コード３();
        source.hyojicodeName1 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get表示コード１名();
        source.hyojicodeName2 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get表示コード２名();
        source.hyojicodeName3 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get表示コード３名();
        if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get調定年度() != null) {
            source.nendo = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get調定年度().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
            source.nendo2 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get調定年度().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
            source.nendo3 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get調定年度().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
            source.nendo4 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get調定年度().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
        }
    }

    private void editorSource_2(TokubetsuChoshuKaishiTsuchishoKariSealerSource source) {
        if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get前年度情報() != null
                && 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get前年度情報().get前年度賦課年度() != null) {
            source.nendo5 = new FlexibleYear(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get前年度情報().get前年度賦課年度())
                    .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
        }
        if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get調定年度() != null) {
            source.nendo6 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get調定年度().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
            source.nendo7 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get調定年度().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
            source.nendo8 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get調定年度().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
            source.nendo9 = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get調定年度().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
        }

        if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人() != null) {
            source.seibetsu = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get性別();
            if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get世帯コード() != null) {
                source.setaiCode = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get世帯コード().value();
            }
            if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get世帯主名() != null) {
                source.setainushiName = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get世帯主名().value();
            }
        }
        if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後() != null) {
            source.tokuchoGimushaName = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後().get更正後特別徴収義務者();
            source.tokuchoTaishoNenkinName = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後().get更正後特別徴収対象年金();
        }
        if (仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get通知書番号() != null) {
            source.tsuchishoNo = 仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get通知書番号().value();
        }
    }

    private Decimal nullToDemical(Decimal 項目) {
        if (項目 == null) {
            return Decimal.ZERO;
        }
        return 項目;
    }
}
