/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.CharacteristicsPhase;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;
import lombok.NonNull;

/**
 * 特別徴収開始通知書（本算定） A4縦・オーバレイタイプ帳票Report
 */
public class TokubetsuChoshuKaishiTsuchishoOverlayA4TateReport extends Report<TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource> {

    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final RString SPLITTOKEN = new RString(".");
    private static final RString 特徴期別金額1期 = new RString("1期");
    private static final RString 特徴期別金額2期 = new RString("2期");
    private static final RString 特徴期別金額3期 = new RString("3期");
    private static final RString 特徴期別金額4期 = new RString("4期");
    private static final RString 特徴期別金額5期 = new RString("5期");
    private static final RString 特徴期別金額6期 = new RString("6期");
    private static final int MULTIPLY = 3;
    private static final RString TOKEN = new RString("～");

    private final EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private final RString 通知書定型文;
    private final TokubetsuChoshuKaishiTsuchishoOverlayA4TateItem target;

    /**
     * コンストラクタです。
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsuクラスです
     * @param 通知書定型文 RStringクラス
     */
    public TokubetsuChoshuKaishiTsuchishoOverlayA4TateReport(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報, RString 通知書定型文) {
        this.編集後本算定通知書共通情報 = 編集後本算定通知書共通情報;
        this.通知書定型文 = 通知書定型文;
        target = new TokubetsuChoshuKaishiTsuchishoOverlayA4TateItem();
    }

    /**
     * Formを創建のメソッドます。
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsuクラス
     * @param 通知書定型文 RStringクラス
     * @return TokubetsuChoshuKaishiTsuchishoSealerReportクラス
     */
    public static TokubetsuChoshuKaishiTsuchishoOverlayA4TateReport createForm(
            @NonNull EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            RString 通知書定型文) {
        return new TokubetsuChoshuKaishiTsuchishoOverlayA4TateReport(編集後本算定通知書共通情報, 通知書定型文);
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource> writer) {
        setItem();
        ITokubetsuChoshuKaishiTsuchishoOverlayA4TateEditor editor = new TokubetsuChoshuKaishiTsuchishoOverlayA4TateEditor(target);
        ITokubetsuChoshuKaishiTsuchishoOverlayA4TateBuilder builder = new TokubetsuChoshuKaishiTsuchishoOverlayA4TateBuilder(editor);
        writer.writeLine(builder);
    }

    /**
     * 設定Item値のメソッドます。
     */
    private void setItem() {
        target.set年度名(編集後本算定通知書共通情報.get調定年度());
        target.set表示コード名1(編集後本算定通知書共通情報.get表示コード().get表示コード名１());
        target.set表示コード名2(編集後本算定通知書共通情報.get表示コード().get表示コード名２());
        target.set表示コード名3(編集後本算定通知書共通情報.get表示コード().get表示コード名３());
        target.set表示コード１(編集後本算定通知書共通情報.get表示コード().get表示コード１());
        target.set表示コード２(編集後本算定通知書共通情報.get表示コード().get表示コード２());
        target.set表示コード３(編集後本算定通知書共通情報.get表示コード().get表示コード３());
        target.set被保険者番号(編集後本算定通知書共通情報.get被保険者番号().value());
        target.set通知書番号(編集後本算定通知書共通情報.get通知書番号().value());
        target.set世帯コード(編集後本算定通知書共通情報.get編集後個人().get世帯コード().value());
        target.set識別コード(編集後本算定通知書共通情報.get識別コード().value());
        target.set被保険者氏名(編集後本算定通知書共通情報.get編集後個人().get名称().getName().value());
        target.set世帯主名(編集後本算定通知書共通情報.get編集後個人().get世帯主名().value());
        target.set被保険者住所(編集後本算定通知書共通情報.get編集後宛先().get編集後住所());
        target.set被保険者方書(編集後本算定通知書共通情報.get編集後個人().get方書().value());
        target.set生年月日の年(編集後本算定通知書共通情報.get編集後個人().get生年月日().split(SPLITTOKEN.toString()).get(INDEX_0));
        target.set生年月日の月(編集後本算定通知書共通情報.get編集後個人().get生年月日().split(SPLITTOKEN.toString()).get(INDEX_1));
        target.set生年月日の日(編集後本算定通知書共通情報.get編集後個人().get生年月日().split(SPLITTOKEN.toString()).get(INDEX_2));
        target.set性別(編集後本算定通知書共通情報.get編集後個人().get性別());
        target.set特別徴収業務者名(編集後本算定通知書共通情報.get更正後().get特別徴収義務者());
        target.set特別徴収対象年金名(編集後本算定通知書共通情報.get更正後().get特別徴収対象年金());
        target.set保険料額年度1(編集後本算定通知書共通情報.get賦課年度());
        target.set保険料額年度2(編集後本算定通知書共通情報.get賦課年度());
        target.set仮算定額合計(set仮算定額合計());
        target.set保険料額10月(set特徴期別金額(特徴期別金額4期));
        target.set保険料額12月(set特徴期別金額(特徴期別金額5期));
        target.set保険料額2月(set特徴期別金額(特徴期別金額6期));
        target.set算定期の年度(編集後本算定通知書共通情報.get賦課年度());
        target.set算定期の期間(編集後本算定通知書共通情報.get更正後().get期間_自().concat(TOKEN)
                .concat(編集後本算定通知書共通情報.get更正後().get期間_至()));
        target.set算定期の月数(編集後本算定通知書共通情報.get更正後().get月数_ケ月());
        target.set所得段階1(編集後本算定通知書共通情報.get更正後().get保険料段階());
        target.set保険料額4月仮徴収額(set特徴期別金額(特徴期別金額1期));
        target.set保険料額10月本徴収額(set特徴期別金額(特徴期別金額4期));
        target.set保険料額6月仮徴収額(set特徴期別金額(特徴期別金額2期));
        target.set保険料額12月本徴収額(set特徴期別金額(特徴期別金額5期));
        target.set保険料率(DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get保険料率(), 0));
        target.set年度保険料(DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get確定保険料_年額(), 0));
        target.set普通徴収で納付する額(DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get普通徴収額合計(), 0));
        target.set保険料額8月仮徴収額(set特徴期別金額(特徴期別金額3期));
        target.set翌年度仮特徴保険料額(set翌年度仮特徴保険料額(特徴期別金額6期));
        target.set通知文(通知書定型文);

        // TODO 帳票項目定義_CompSofubutsuAtesaki
        SofubutsuAtesakiSource sofubutsuAtesakiSource = 編集後本算定通知書共通情報.get編集後宛先().getSofubutsuAtesakiSource();
        target.set郵便番号No(sofubutsuAtesakiSource.yubinNo);
        target.set行政区(sofubutsuAtesakiSource.gyoseiku);
        target.set住所3(sofubutsuAtesakiSource.jusho3);
        target.set住所(sofubutsuAtesakiSource.jushoText);
        target.set住所1(sofubutsuAtesakiSource.jusho1);
        target.set住所2(sofubutsuAtesakiSource.jusho2);
        target.set方書(sofubutsuAtesakiSource.katagakiText);
        target.set方書2(sofubutsuAtesakiSource.katagaki2);
        target.set方書Small2(sofubutsuAtesakiSource.katagakiSmall2);
        target.set方書1(sofubutsuAtesakiSource.katagaki1);
        target.set方書Small1(sofubutsuAtesakiSource.katagakiSmall1);
        target.set氏名2(sofubutsuAtesakiSource.shimei2);
        target.set氏名Small2(sofubutsuAtesakiSource.shimeiSmall2);
        target.set氏名(sofubutsuAtesakiSource.shimeiText);
        target.set名称付与2(sofubutsuAtesakiSource.meishoFuyo2);
        target.set氏名Small1(sofubutsuAtesakiSource.shimeiSmall1);
        target.set代納区分名(sofubutsuAtesakiSource.dainoKubunMei);
        target.set氏名1(sofubutsuAtesakiSource.shimei1);
        target.set名称付与1(sofubutsuAtesakiSource.meishoFuyo1);
        target.set様文氏名(sofubutsuAtesakiSource.samabunShimeiText);
        target.set左括弧2(sofubutsuAtesakiSource.kakkoLeft2);
        target.set様文氏名2(sofubutsuAtesakiSource.samabunShimei2);
        target.set様文氏名Small2(sofubutsuAtesakiSource.samabunShimeiSmall2);
        target.set様文2(sofubutsuAtesakiSource.samaBun2);
        target.set右括弧2(sofubutsuAtesakiSource.kakkoRight2);
        target.set左括弧1(sofubutsuAtesakiSource.kakkoLeft1);
        target.set様文氏名1(sofubutsuAtesakiSource.samabunShimei1);
        target.set様文1(sofubutsuAtesakiSource.samaBun1);
        target.set右括弧1(sofubutsuAtesakiSource.kakkoRight1);
        target.set様文氏名Small1(sofubutsuAtesakiSource.samabunShimeiSmall1);
        target.set顧客場番号(sofubutsuAtesakiSource.customerBarCode);

        // TODO 雛形部品CompNinshoshaを作成する
        // TODO 帳票項目定義_CompKaigoToiawasesaki
    }

    /**
     * 設定仮算定額合計のメソッドます。
     */
    private RString set仮算定額合計() {
        Decimal 金額1期 = Decimal.ZERO;
        Decimal 金額2期 = Decimal.ZERO;
        Decimal 金額3期 = Decimal.ZERO;
        List<CharacteristicsPhase> 特徴期別金額リスト = 編集後本算定通知書共通情報.get更正後().get特徴期別金額リスト();
        for (CharacteristicsPhase 特徴期別金額 : 特徴期別金額リスト) {
            if (特徴期別金額1期.equals(特徴期別金額.get期())) {
                金額1期 = 特徴期別金額.get金額();
            } else if (特徴期別金額2期.equals(特徴期別金額.get期())) {
                金額2期 = 特徴期別金額.get金額();
            } else if (特徴期別金額3期.equals(特徴期別金額.get期())) {
                金額3期 = 特徴期別金額.get金額();
            }
        }
        return DecimalFormatter.toコンマ区切りRString(金額1期.add(金額2期).add(金額3期), 0);
    }

    /**
     * 設定金額のメソッドます。
     *
     * @param index 期
     * @return RString
     */
    private RString set特徴期別金額(RString 期) {
        Decimal 金額 = Decimal.ZERO;
        List<CharacteristicsPhase> 特徴期別金額リスト = 編集後本算定通知書共通情報.get更正後().get特徴期別金額リスト();
        for (CharacteristicsPhase 特徴期別金額 : 特徴期別金額リスト) {
            if (期.equals(特徴期別金額.get期())) {
                金額 = 特徴期別金額.get金額();
            }
            break;
        }
        return DecimalFormatter.toコンマ区切りRString(金額, 0);
    }

    /**
     * 設定翌年度仮特徴保険料額のメソッドます。
     *
     * @param index 期
     * @return RString
     */
    private RString set翌年度仮特徴保険料額(RString 期) {
        Decimal 金額 = Decimal.ZERO;
        List<CharacteristicsPhase> 特徴期別金額リスト = 編集後本算定通知書共通情報.get更正後().get特徴期別金額リスト();
        for (CharacteristicsPhase 特徴期別金額 : 特徴期別金額リスト) {
            if (期.equals(特徴期別金額.get期())) {
                金額 = 特徴期別金額.get金額().multiply(MULTIPLY);
            }
            break;
        }
        return DecimalFormatter.toコンマ区切りRString(金額, 0);
    }
}
