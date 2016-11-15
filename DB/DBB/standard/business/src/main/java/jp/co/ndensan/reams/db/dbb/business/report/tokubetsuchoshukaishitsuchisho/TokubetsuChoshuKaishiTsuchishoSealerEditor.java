/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.CharacteristicsPhase;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerSource;
import jp.co.ndensan.reams.db.dbz.business.core.kaigosofubutsuatesakisource.KaigoSofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 特別徴収開始通知書（本算定） シーラタイプ帳票Editor
 *
 * @reamsid_L DBB-0780-070 xuhao
 */
public class TokubetsuChoshuKaishiTsuchishoSealerEditor implements ITokubetsuChoshuKaishiTsuchishoSealerEditor {

    private final EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private final NinshoshaSource sourceBuilder;

    private static final RString 特徴期別金額1期 = new RString("1");
    private static final RString 特徴期別金額2期 = new RString("2");
    private static final RString 特徴期別金額3期 = new RString("3");
    private static final RString 特徴期別金額4期 = new RString("4");
    private static final RString 特徴期別金額5期 = new RString("5");
    private static final RString 特徴期別金額6期 = new RString("6");
    private static final int MULTIPLY = 3;
    private static final RString TOKEN = new RString("～");

    /**
     * コンストラクタです
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param sourceBuilder 雛形部品CompNinshosha
     */
    public TokubetsuChoshuKaishiTsuchishoSealerEditor(
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            NinshoshaSource sourceBuilder) {
        this.編集後本算定通知書共通情報 = 編集後本算定通知書共通情報;
        this.sourceBuilder = sourceBuilder;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoSealerSource edit(TokubetsuChoshuKaishiTsuchishoSealerSource source) {
        if (編集後本算定通知書共通情報.get賦課年度() != null) {
            source.nendo2 = 編集後本算定通知書共通情報.get賦課年度().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
            source.nendo4 = 編集後本算定通知書共通情報.get賦課年度().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
        }
        source.hokenryoGokei = set保険料合計();
        if (編集後本算定通知書共通情報.get賦課年度() != null) {
            source.nendo5 = 編集後本算定通知書共通情報.get賦課年度().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
        }
        if (編集後本算定通知書共通情報.get通知書番号() != null) {
            source.tsuchishoNo = 編集後本算定通知書共通情報.get通知書番号().value();
        }
        if (編集後本算定通知書共通情報.get編集後個人() != null) {
            if (編集後本算定通知書共通情報.get編集後個人().get世帯コード() != null) {
                source.setaiCode = 編集後本算定通知書共通情報.get編集後個人().get世帯コード().value();
            }
            if (編集後本算定通知書共通情報.get編集後個人().get名称() != null) {
                source.hihokenshaName = 編集後本算定通知書共通情報.get編集後個人().get名称().getName().value();
            }
        }
        if (編集後本算定通知書共通情報.get編集後宛先() != null) {
            source.hihokenshaJusho = 編集後本算定通知書共通情報.get編集後宛先().get編集後住所();
        }
        if (編集後本算定通知書共通情報.get更正後() != null) {
            source.tsukiSu = 編集後本算定通知書共通情報.get更正後().get月数_ケ月();
            source.shotokuDankai = 編集後本算定通知書共通情報.get更正後().get保険料段階();
            if (編集後本算定通知書共通情報.get更正後().get期間_自() != null && 編集後本算定通知書共通情報.get更正後().get期間_至() != null) {
                RString 期間_自 = 編集後本算定通知書共通情報.get更正後().get期間_自();
                RString 期間_至 = 編集後本算定通知書共通情報.get更正後().get期間_至();
                source.kikan = editDate(期間_自).concat(TOKEN).concat(editDate(期間_至));
            }
            if (編集後本算定通知書共通情報.get更正後().get保険料率() != null) {
                source.hokenryoRitsu = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get保険料率(), 0);
            }
            if (編集後本算定通知書共通情報.get更正後().get減免前保険料_年額() != null) {
                source.hokenryoCalGaku = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get減免前保険料_年額(), 0);
            }
            if (編集後本算定通知書共通情報.get更正後().get普通徴収額合計() != null) {
                source.fuchoNofuGaku = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get普通徴収額合計(), 0);
            } else {
                source.hokenryoNenGaku = new RString("0");
            }
        }
        source.gekihenHeader = RString.EMPTY;
        source.gekihenMongon = RString.EMPTY;
        editorSource(source);
        if (編集後本算定通知書共通情報.get編集後宛先() != null && 編集後本算定通知書共通情報.get編集後宛先().getSofubutsuAtesakiSource() != null) {
            KaigoSofubutsuAtesakiSource sofubutsuAtesakiSource = 編集後本算定通知書共通情報.get編集後宛先().getSofubutsuAtesakiSource();
            source.yubinNo = sofubutsuAtesakiSource.get送付物宛先ソース().yubinNo;
            source.gyoseiku = sofubutsuAtesakiSource.get送付物宛先ソース().gyoseiku;
            source.jusho3 = sofubutsuAtesakiSource.get送付物宛先ソース().jusho3;
            source.jushoText = sofubutsuAtesakiSource.get送付物宛先ソース().jushoText;
            source.jusho1 = sofubutsuAtesakiSource.get送付物宛先ソース().jusho1;
            source.jusho2 = sofubutsuAtesakiSource.get送付物宛先ソース().jusho2;
            source.katagakiText = sofubutsuAtesakiSource.get送付物宛先ソース().katagakiText;
            source.katagaki2 = sofubutsuAtesakiSource.get送付物宛先ソース().katagaki2;
            source.katagakiSmall2 = sofubutsuAtesakiSource.get送付物宛先ソース().katagakiSmall2;
            source.katagaki1 = sofubutsuAtesakiSource.get送付物宛先ソース().katagaki1;
            source.katagakiSmall1 = sofubutsuAtesakiSource.get送付物宛先ソース().katagakiSmall1;
            source.shimei2 = sofubutsuAtesakiSource.get送付物宛先ソース().shimei2;
            source.shimeiSmall2 = sofubutsuAtesakiSource.get送付物宛先ソース().shimeiSmall2;
            source.shimeiText = sofubutsuAtesakiSource.get送付物宛先ソース().shimeiText;
            source.meishoFuyo2 = sofubutsuAtesakiSource.get送付物宛先ソース().meishoFuyo2;
            source.shimeiSmall1 = sofubutsuAtesakiSource.get送付物宛先ソース().shimeiSmall1;
            source.dainoKubunMei = sofubutsuAtesakiSource.get送付物宛先ソース().dainoKubunMei;
            source.shimei1 = sofubutsuAtesakiSource.get送付物宛先ソース().shimei1;
            source.meishoFuyo1 = sofubutsuAtesakiSource.get送付物宛先ソース().meishoFuyo1;
            source.samabunShimeiText = sofubutsuAtesakiSource.get送付物宛先ソース().samabunShimeiText;
            source.kakkoLeft2 = sofubutsuAtesakiSource.get送付物宛先ソース().kakkoLeft2;
            source.samabunShimei2 = sofubutsuAtesakiSource.get送付物宛先ソース().samabunShimei2;
            source.samabunShimeiSmall2 = sofubutsuAtesakiSource.get送付物宛先ソース().samabunShimeiSmall2;
            source.samaBun2 = sofubutsuAtesakiSource.get送付物宛先ソース().samaBun2;
            source.kakkoRight2 = sofubutsuAtesakiSource.get送付物宛先ソース().kakkoRight2;
            source.kakkoLeft1 = sofubutsuAtesakiSource.get送付物宛先ソース().kakkoLeft1;
            source.samabunShimei1 = sofubutsuAtesakiSource.get送付物宛先ソース().samabunShimei1;
            source.samaBun1 = sofubutsuAtesakiSource.get送付物宛先ソース().samaBun1;
            source.kakkoRight1 = sofubutsuAtesakiSource.get送付物宛先ソース().kakkoRight1;
            source.samabunShimeiSmall1 = sofubutsuAtesakiSource.get送付物宛先ソース().samabunShimeiSmall1;
            source.customerBarCode = sofubutsuAtesakiSource.get送付物宛先ソース().customerBarCode;
        }
        if (sourceBuilder != null) {
            source.hakkoYMD = sourceBuilder.hakkoYMD;
            source.denshiKoin = sourceBuilder.denshiKoin;
            source.koinMojiretsu = sourceBuilder.koinMojiretsu;
            source.koinShoryaku = sourceBuilder.koinShoryaku;
            source.ninshoshaShimeiKakenai = sourceBuilder.ninshoshaShimeiKakenai;
            source.ninshoshaShimeiKakeru = sourceBuilder.ninshoshaShimeiKakeru;
            source.ninshoshaYakushokuMei = sourceBuilder.ninshoshaYakushokuMei;
            source.ninshoshaYakushokuMei1 = sourceBuilder.ninshoshaYakushokuMei1;
            source.ninshoshaYakushokuMei2 = sourceBuilder.ninshoshaYakushokuMei2;
        }
        return source;
    }

    private RString editDate(RString value) {
        return new RDate(value.toString()).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).width(Width.HALF).toDateString();
    }

    private void editorSource(TokubetsuChoshuKaishiTsuchishoSealerSource source) {
        if (編集後本算定通知書共通情報.get編集後個人() != null) {
            source.birthYMD = 編集後本算定通知書共通情報.get編集後個人().get生年月日();
            source.seibetsu = 編集後本算定通知書共通情報.get編集後個人().get性別();
            if (編集後本算定通知書共通情報.get編集後個人().get世帯主名() != null) {
                source.setainushiName = 編集後本算定通知書共通情報.get編集後個人().get世帯主名().value();
            }
            if (編集後本算定通知書共通情報.get編集後個人().get方書() != null) {
                source.hihokenshaKatagaki = 編集後本算定通知書共通情報.get編集後個人().get方書().value();
            }
        }
        if (編集後本算定通知書共通情報.get更正後() != null) {
            source.tokuchoGimushaName = 編集後本算定通知書共通情報.get更正後().get特別徴収義務者();
            source.tokuchotaishonenkinName = 編集後本算定通知書共通情報.get更正後().get特別徴収対象年金();
        }
        if (編集後本算定通知書共通情報.get賦課年度() != null) {
            source.nendo = 編集後本算定通知書共通情報.get賦課年度().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
        }
        source.hokenryoGaku4Gatsu = set特徴期別金額(特徴期別金額1期);
        source.hokenryoGakuZen10Gatsu2 = set特徴期別金額(特徴期別金額4期);
        if (編集後本算定通知書共通情報.get賦課年度() != null) {
            source.nendo3 = 編集後本算定通知書共通情報.get賦課年度().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
        }
        source.hokenryoGaku6Gatsu = set特徴期別金額(特徴期別金額2期);
        source.hokenryoGakuZen12Gatsu2 = set特徴期別金額(特徴期別金額5期);
        if (編集後本算定通知書共通情報.get更正後() != null && 編集後本算定通知書共通情報.get更正後().get確定保険料_年額() != null) {
            source.hokenryoNenGaku = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get確定保険料_年額(), 0);
        } else {
            source.hokenryoNenGaku = new RString("0");
        }
        source.hokenryoGaku8Gatsu = set特徴期別金額(特徴期別金額3期);
        source.hokenryoGakuZen2Gatsu2 = set特徴期別金額(特徴期別金額6期);
        if (編集後本算定通知書共通情報.get表示コード() != null) {
            source.hyojicodeName1 = 編集後本算定通知書共通情報.get表示コード().get表示コード名１();
            source.hyojicodeName2 = 編集後本算定通知書共通情報.get表示コード().get表示コード名２();
            source.hyojicodeName3 = 編集後本算定通知書共通情報.get表示コード().get表示コード名３();
            source.hyojicode1 = 編集後本算定通知書共通情報.get表示コード().get表示コード１();
            source.hyojicode2 = 編集後本算定通知書共通情報.get表示コード().get表示コード２();
            source.hyojicode3 = 編集後本算定通知書共通情報.get表示コード().get表示コード３();
        }
        source.hokenryoGaku10Gatsu1 = set特徴期別金額(特徴期別金額4期);
        source.hokenryoGaku12Gatsu1 = set特徴期別金額(特徴期別金額5期);
        source.hokenryoGaku2Gatsu1 = set特徴期別金額(特徴期別金額6期);
        source.rainendoKariHokenryoGokei = set来年度仮保険料合計(特徴期別金額6期);
    }

    /**
     * 設定保険料合計値のメソッドます。
     */
    private RString set保険料合計() {
        Decimal 金額4期 = Decimal.ZERO;
        Decimal 金額5期 = Decimal.ZERO;
        Decimal 金額6期 = Decimal.ZERO;
        if (編集後本算定通知書共通情報.get更正後() == null || 編集後本算定通知書共通情報.get更正後().get特徴期別金額リスト() == null) {
            return RString.EMPTY;
        }
        List<CharacteristicsPhase> 特徴期別金額リスト = 編集後本算定通知書共通情報.get更正後().get特徴期別金額リスト();
        for (CharacteristicsPhase 特徴期別金額 : 特徴期別金額リスト) {
            if (特徴期別金額4期.equals(特徴期別金額.get期())) {
                金額4期 = null == 特徴期別金額.get金額() ? Decimal.ZERO : 特徴期別金額.get金額();
            } else if (特徴期別金額5期.equals(特徴期別金額.get期())) {
                金額5期 = null == 特徴期別金額.get金額() ? Decimal.ZERO : 特徴期別金額.get金額();
            } else if (特徴期別金額6期.equals(特徴期別金額.get期())) {
                金額6期 = null == 特徴期別金額.get金額() ? Decimal.ZERO : 特徴期別金額.get金額();
            }
        }
        return DecimalFormatter.toコンマ区切りRString(金額4期.add(金額5期).add(金額6期), 0);
    }

    /**
     * 設定金額のメソッドます。
     *
     * @param 期 RString
     * @return 特徴期別金額
     */
    private RString set特徴期別金額(RString 期) {
        Decimal 金額 = Decimal.ZERO;
        if (編集後本算定通知書共通情報.get更正後() == null || 編集後本算定通知書共通情報.get更正後().get特徴期別金額リスト() == null) {
            return RString.EMPTY;
        }
        List<CharacteristicsPhase> 特徴期別金額リスト = 編集後本算定通知書共通情報.get更正後().get特徴期別金額リスト();
        for (CharacteristicsPhase 特徴期別金額 : 特徴期別金額リスト) {
            if (期.equals(特徴期別金額.get期())) {
                金額 = null == 特徴期別金額.get金額() ? Decimal.ZERO : 特徴期別金額.get金額();
                break;
            }
        }
        return DecimalFormatter.toコンマ区切りRString(金額, 0);
    }

    /**
     * 設定来年度仮保険料合計のメソッドます。
     *
     * @param 期 RString
     * @return 来年度仮保険料合計
     */
    private RString set来年度仮保険料合計(RString 期) {
        Decimal 金額 = Decimal.ZERO;
        if (編集後本算定通知書共通情報.get更正後() == null || 編集後本算定通知書共通情報.get更正後().get特徴期別金額リスト() == null) {
            return RString.EMPTY;
        }
        List<CharacteristicsPhase> 特徴期別金額リスト = 編集後本算定通知書共通情報.get更正後().get特徴期別金額リスト();
        for (CharacteristicsPhase 特徴期別金額 : 特徴期別金額リスト) {
            if (期.equals(特徴期別金額.get期())) {
                金額 = 特徴期別金額.get金額().multiply(MULTIPLY);
                break;
            }
        }
        return DecimalFormatter.toコンマ区切りRString(金額, 0);
    }

}
