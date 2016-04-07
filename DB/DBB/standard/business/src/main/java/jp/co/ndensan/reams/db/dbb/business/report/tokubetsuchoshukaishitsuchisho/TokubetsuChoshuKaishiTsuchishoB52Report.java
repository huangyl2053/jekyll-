/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.CharacteristicsPhase;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52Source;
import jp.co.ndensan.reams.db.dbz.business.core.kaigosofubutsuatesakisource.KaigoSofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;
import lombok.NonNull;

/**
 * 特別徴収開始通知書（本算定） B5横タイプ2帳票Report
 */
public class TokubetsuChoshuKaishiTsuchishoB52Report extends Report<TokubetsuChoshuKaishiTsuchishoB52Source> {

    private static final RString 特徴期別金額1期 = new RString("1期");
    private static final RString 特徴期別金額2期 = new RString("2期");
    private static final RString 特徴期別金額3期 = new RString("3期");
    private static final RString 特徴期別金額4期 = new RString("4期");
    private static final RString 特徴期別金額5期 = new RString("5期");
    private static final RString 特徴期別金額6期 = new RString("6期");
    private static final RString TOKEN = new RString("～");

    private final EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private final RString 宛名連番;
    private final TokubetsuChoshuKaishiTsuchishoB5Item target;

    /**
     * コンストラクタです。
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsuクラスです
     * @param 宛名連番 RStringクラスです
     */
    public TokubetsuChoshuKaishiTsuchishoB52Report(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報, RString 宛名連番) {
        this.編集後本算定通知書共通情報 = 編集後本算定通知書共通情報;
        this.宛名連番 = 宛名連番;
        target = new TokubetsuChoshuKaishiTsuchishoB5Item();
    }

    /**
     * Formを創建のメソッドます。
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsuクラス
     * @param 宛名連番 RStringクラス
     * @return TokubetsuChoshuKaishiTsuchishoB5RenchoReportクラス
     */
    public static TokubetsuChoshuKaishiTsuchishoB5RenchoReport createForm(
            @NonNull EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            RString 宛名連番) {
        return new TokubetsuChoshuKaishiTsuchishoB5RenchoReport(編集後本算定通知書共通情報, 宛名連番);
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoB52Source> writer) {
        setItem();
        ITokubetsuChoshuKaishiTsuchishoB52Editor editor = new TokubetsuChoshuKaishiTsuchishoB52Editor(target);
        ITokubetsuChoshuKaishiTsuchishoB52Builder builder = new TokubetsuChoshuKaishiTsuchishoB52Builder(editor);
        writer.writeLine(builder);
    }

    /**
     * 設定Item値のメソッドます。
     */
    private void setItem() {
        target.set年度(編集後本算定通知書共通情報.get賦課年度());
        target.set年度3(編集後本算定通知書共通情報.get賦課年度());
        target.set通知書番号1(編集後本算定通知書共通情報.get通知書番号().value());
        target.set世帯コード1(編集後本算定通知書共通情報.get編集後個人().get世帯コード().value());
        target.set被保険者氏名(編集後本算定通知書共通情報.get編集後個人().get名称().getName().value());
        target.set生年月日1(編集後本算定通知書共通情報.get編集後個人().get生年月日());
        target.set性別1(編集後本算定通知書共通情報.get編集後個人().get性別());
        target.set特別徴収業務者名1(編集後本算定通知書共通情報.get更正後().get特別徴収義務者());
        target.set特別徴収対象年金名1(編集後本算定通知書共通情報.get更正後().get特別徴収対象年金());
        target.set宛名連番1(宛名連番);
        target.set期間(編集後本算定通知書共通情報.get更正後().get期間_自().concat(TOKEN)
                .concat(編集後本算定通知書共通情報.get更正後().get期間_至()));
        target.set月数(編集後本算定通知書共通情報.get更正後().get月数_ケ月());
        target.set所得段階区分(編集後本算定通知書共通情報.get更正後().get保険料段階());
        target.set月数2(編集後本算定通知書共通情報.get更正後().get月数_ケ月());
        target.set保険料率(DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get保険料率(), 0));
        target.set保険料額(DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get確定保険料_年額(), 0));
        target.set通知文年度(編集後本算定通知書共通情報.get賦課年度());
        target.set表示コード名1(編集後本算定通知書共通情報.get表示コード().get表示コード名１());
        target.set表示コード名2(編集後本算定通知書共通情報.get表示コード().get表示コード名２());
        target.set表示コード名3(編集後本算定通知書共通情報.get表示コード().get表示コード名３());
        target.set表示コード1(編集後本算定通知書共通情報.get表示コード().get表示コード１());
        target.set表示コード2(編集後本算定通知書共通情報.get表示コード().get表示コード２());
        target.set表示コード3(編集後本算定通知書共通情報.get表示コード().get表示コード３());
        target.set世帯コード1(編集後本算定通知書共通情報.get編集後個人().get世帯コード().value());
        target.set保険料額4月仮徴収額(set特徴期別金額(特徴期別金額1期));
        target.set保険料額10月(set特徴期別金額(特徴期別金額4期));
        target.set保険料額6月仮徴収額(set特徴期別金額(特徴期別金額2期));
        target.set保険料額12月(set特徴期別金額(特徴期別金額5期));
        target.set保険料額8月仮徴収額(set特徴期別金額(特徴期別金額3期));
        target.set保険料額2月(set特徴期別金額(特徴期別金額6期));
        target.set年度2(編集後本算定通知書共通情報.get賦課年度());
        target.set保険料年額(DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get確定保険料_年額(), 0));
        target.set仮保険料額(set仮保険料額());
        target.set保険料合計(set保険料合計());
        target.set普通徴収で納付する額(DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get普通徴収額合計(), 0));
        target.set被保険者氏名1(編集後本算定通知書共通情報.get編集後個人().get名称().getName().value());

        // TODO 帳票項目定義_CompSofubutsuAtesaki
        KaigoSofubutsuAtesakiSource sofubutsuAtesakiSource = 編集後本算定通知書共通情報.get編集後宛先().getSofubutsuAtesakiSource();
        target.set郵便番号(sofubutsuAtesakiSource.get送付物宛先ソース().yubinNo);
        target.set行政区(sofubutsuAtesakiSource.get送付物宛先ソース().gyoseiku);
        target.set住所3(sofubutsuAtesakiSource.get送付物宛先ソース().jusho3);
        target.set住所(sofubutsuAtesakiSource.get送付物宛先ソース().jushoText);
        target.set住所1(sofubutsuAtesakiSource.get送付物宛先ソース().jusho1);
        target.set住所2(sofubutsuAtesakiSource.get送付物宛先ソース().jusho2);
        target.set方書(sofubutsuAtesakiSource.get送付物宛先ソース().katagakiText);
        target.set方書2(sofubutsuAtesakiSource.get送付物宛先ソース().katagaki2);
        target.set方書Small2(sofubutsuAtesakiSource.get送付物宛先ソース().katagakiSmall2);
        target.set方書1(sofubutsuAtesakiSource.get送付物宛先ソース().katagaki1);
        target.set方書Small1(sofubutsuAtesakiSource.get送付物宛先ソース().katagakiSmall1);
        target.set氏名2(sofubutsuAtesakiSource.get送付物宛先ソース().shimei2);
        target.set氏名Small2(sofubutsuAtesakiSource.get送付物宛先ソース().shimeiSmall2);
        target.set氏名(sofubutsuAtesakiSource.get送付物宛先ソース().shimeiText);
        target.set名称付与2(sofubutsuAtesakiSource.get送付物宛先ソース().meishoFuyo2);
        target.set氏名Small1(sofubutsuAtesakiSource.get送付物宛先ソース().shimeiSmall1);
        target.set代納区分名(sofubutsuAtesakiSource.get送付物宛先ソース().dainoKubunMei);
        target.set氏名1(sofubutsuAtesakiSource.get送付物宛先ソース().shimei1);
        target.set名称付与1(sofubutsuAtesakiSource.get送付物宛先ソース().meishoFuyo1);
        target.set様文氏名(sofubutsuAtesakiSource.get送付物宛先ソース().samabunShimeiText);
        target.set左括弧2(sofubutsuAtesakiSource.get送付物宛先ソース().kakkoLeft2);
        target.set様文氏名2(sofubutsuAtesakiSource.get送付物宛先ソース().samabunShimei2);
        target.set様文氏名Small2(sofubutsuAtesakiSource.get送付物宛先ソース().samabunShimeiSmall2);
        target.set様文2(sofubutsuAtesakiSource.get送付物宛先ソース().samaBun2);
        target.set右括弧2(sofubutsuAtesakiSource.get送付物宛先ソース().kakkoRight2);
        target.set左括弧1(sofubutsuAtesakiSource.get送付物宛先ソース().kakkoLeft1);
        target.set様文氏名1(sofubutsuAtesakiSource.get送付物宛先ソース().samabunShimei1);
        target.set様文1(sofubutsuAtesakiSource.get送付物宛先ソース().samaBun1);
        target.set右括弧1(sofubutsuAtesakiSource.get送付物宛先ソース().kakkoRight1);
        target.set様文氏名Small1(sofubutsuAtesakiSource.get送付物宛先ソース().samabunShimeiSmall1);
        target.set顧客場番号(sofubutsuAtesakiSource.get送付物宛先ソース().customerBarCode);

        // TODO 雛形部品CompNinshoshaを作成する
    }

    /**
     * 設定仮保険料額のメソッドます。
     */
    private RString set仮保険料額() {
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
     * 設定保険料合計値のメソッドます。
     */
    private RString set保険料合計() {
        Decimal 金額4期 = Decimal.ZERO;
        Decimal 金額5期 = Decimal.ZERO;
        Decimal 金額6期 = Decimal.ZERO;
        List<CharacteristicsPhase> 特徴期別金額リスト = 編集後本算定通知書共通情報.get更正後().get特徴期別金額リスト();
        for (CharacteristicsPhase 特徴期別金額 : 特徴期別金額リスト) {
            if (特徴期別金額4期.equals(特徴期別金額.get期())) {
                金額4期 = 特徴期別金額.get金額();
            } else if (特徴期別金額5期.equals(特徴期別金額.get期())) {
                金額5期 = 特徴期別金額.get金額();
            } else if (特徴期別金額6期.equals(特徴期別金額.get期())) {
                金額6期 = 特徴期別金額.get金額();
            }
        }
        return DecimalFormatter.toコンマ区切りRString(金額4期.add(金額5期).add(金額6期), 0);
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
}
