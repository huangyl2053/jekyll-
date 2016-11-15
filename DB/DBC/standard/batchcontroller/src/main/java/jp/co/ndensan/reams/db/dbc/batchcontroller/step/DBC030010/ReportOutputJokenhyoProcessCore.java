/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC030010.DBC030010_ShokanShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 帳票DBC100002_償還払い支給（不支給）決定通知書を出力します。
 *
 * @reamsid_L DBC-1000-020 hanxu
 */
public class ReportOutputJokenhyoProcessCore {
    private static final RString 受付日 = new RString("1");
    private static final RString 決定日 = new RString("2");
    private static final RString NUM_1 = new RString("1");
    private static final RString NUM_2 = new RString("2");
    private static final RString NUM_3 = new RString("2");
    private static final RString 波線 = new RString("～");
    private static final RString より = new RString("＞");
    private static final RString 決定者受付年月 = new RString("3");
    private static final RString 単票発行済を除く = new RString("単票発行済を除く");
    private static final RString 単票発行済も含める = new RString("単票発行済も含める");
    private static final RString 未発行分のみ = new RString("未発行分のみ");
    private static final RString 出力対象_1 = new RString("利用者向け決定通知書、受領委任者向け決定通知書");
    private static final RString 出力対象_2 = new RString("利用者向け決定通知書");
    private static final RString 出力対象_3 = new RString("受領委任者向け決定通知書");
    private static final RString する = new RString("する");
    private static final RString しない = new RString("しない");
    private static final RString TITLE_受付日 = new RString("【受付日】");
    private static final RString TITLE_決定日_期間 = new RString("【決定日】");
    private static final RString TITLE_決定者受付年月 = new RString("【決定者受付年月】");
    private static final RString TITLE_印書 = new RString("【印書】");
    private static final RString TITLE_発行日 = new RString("【発行日】");
    private static final RString TITLE_文書番号 = new RString("【文書番号】");
    private static final RString TITLE_テスト出力 = new RString("【テスト出力】");
    private static final RString TITLE_決定日一括更新 = new RString("【決定日一括更新】");
    private static final RString TITLE_決定日 = new RString("【決定日】");
    private static final RString TITLE_出力対象 = new RString("【出力対象】");
    private static final RString TITLE_振込予定日 = new RString("【振込予定日】");
    private static final RString TITLE_窓口払い一括更新 = new RString("【窓口払い一括更新】");
    private static final RString TITLE_支払場所 = new RString("【支払場所】");
    private static final RString TITLE_支払期間 = new RString("【支払期間】");
    private static final RString TITLE_開始時間 = new RString("【開始時間】");
    private static final RString TITLE_終了時間 = new RString("【終了時間】");
    private static final RString TITLE_出力順 = new RString("【出力順】");
    private static final int イチ = 1;
    private static final RString FLAG_TRUE = new RString("1");
    private static final RString FLAG_FALSE = new RString("0");
    private static final int RSTRING_12 = 12;
    private static final RString 午前 = new RString("午前");
    private static final RString 午後 = new RString("午後");
    
    /**
     * 
     * @param parameter
     * @param order
     * @return 出力条件
     */
    public List<RString> get出力条件(DBC030010_ShokanShikyuKetteiTsuchishoParameter parameter, IOutputOrder order) {
        List<RString> 出力条件 = new ArrayList<>();
        if (受付日.equals(parameter.get抽出モード())) {
            出力条件.add(TITLE_受付日
                    .concat(toパターン6(parameter.get受付日付From())).concat(RString.FULL_SPACE).concat(波線).concat(RString.FULL_SPACE)
                    .concat(toパターン6(parameter.get受付日付To())));
        } else if (決定日.equals(parameter.get抽出モード())) {
            出力条件.add(TITLE_決定日_期間
                    .concat(toパターン6(parameter.get決定日付From())).concat(RString.FULL_SPACE).concat(波線).concat(RString.FULL_SPACE)
                    .concat(toパターン6(parameter.get決定日付To())));
        } else if (決定者受付年月.equals(parameter.get抽出モード())) {
            FlexibleYearMonth 日付 = new FlexibleYearMonth(parameter.get決定者受付年月().toDateString());
            出力条件.add(TITLE_決定者受付年月.concat(RString.FULL_SPACE).concat(日付.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString()));
        }

        if (NUM_1.equals(parameter.get印書())) {
            出力条件.add(TITLE_印書.concat(RString.FULL_SPACE).concat(単票発行済を除く));
        } else if (NUM_2.equals(parameter.get印書())) {
            出力条件.add(TITLE_印書.concat(RString.FULL_SPACE).concat(単票発行済も含める));
        } else if (NUM_3.equals(parameter.get印書())) {
            出力条件.add(TITLE_印書.concat(RString.FULL_SPACE).concat(未発行分のみ));
        }

        出力条件.add(TITLE_発行日.concat(RString.FULL_SPACE).concat(toパターン6(parameter.get発行日())));
        出力条件.add(TITLE_文書番号.concat(RString.FULL_SPACE).concat(doStrToStr(parameter.get文書番号())));
        if (FLAG_TRUE.equals(parameter.getテスト出力フラグ())) {
            出力条件.add(TITLE_テスト出力.concat(RString.FULL_SPACE).concat(する));
        } else {
            出力条件.add(TITLE_テスト出力.concat(RString.FULL_SPACE).concat(しない));
        }

        if (NUM_2.equals(parameter.get決定日一括更新区分())) {
            出力条件.add(TITLE_決定日一括更新.concat(RString.FULL_SPACE).concat(する));
        } else if (NUM_1.equals(parameter.get決定日一括更新区分())) {
            出力条件.add(TITLE_決定日一括更新.concat(RString.FULL_SPACE).concat(しない));
        }
        出力条件.add(TITLE_決定日.concat(RString.FULL_SPACE).concat(toパターン6(parameter.get決定日())));
        if ((FLAG_TRUE.equals(parameter.get利用者向け決定通知書フラグ())) && (FLAG_TRUE.equals(parameter.get受領委任者向け決定通知書フラグ()))) {
            出力条件.add(TITLE_出力対象.concat(RString.FULL_SPACE).concat(出力対象_1));
        } else if ((FLAG_TRUE.equals(parameter.get利用者向け決定通知書フラグ())) && (FLAG_FALSE.equals(parameter.get受領委任者向け決定通知書フラグ()))) {
            出力条件.add(TITLE_出力対象.concat(RString.FULL_SPACE).concat(出力対象_2));
        } else if ((FLAG_FALSE.equals(parameter.get利用者向け決定通知書フラグ())) && (FLAG_TRUE.equals(parameter.get受領委任者向け決定通知書フラグ()))) {
            出力条件.add(TITLE_出力対象.concat(RString.FULL_SPACE).concat(出力対象_3));
        }
        出力条件.add(TITLE_振込予定日.concat(RString.FULL_SPACE).concat(toパターン6(parameter.get振込予定日())));
        if (NUM_2.equals(parameter.get窓口払い一括更新区分())) {
            出力条件.add(TITLE_窓口払い一括更新.concat(RString.FULL_SPACE).concat(する));
        } else if (NUM_1.equals(parameter.get窓口払い一括更新区分())) {
            出力条件.add(TITLE_窓口払い一括更新.concat(RString.FULL_SPACE).concat(しない));
        }

        出力条件.add(TITLE_支払場所.concat(RString.FULL_SPACE).concat(doStrToStr(parameter.get支払場所())));

        出力条件.add(TITLE_支払期間.concat(RString.FULL_SPACE)
                .concat(toパターン6(parameter.get支払期間From())).concat(RString.FULL_SPACE).concat(波線).concat(RString.FULL_SPACE)
                .concat(toパターン6(parameter.get支払期間To())));
        
        出力条件.add(TITLE_開始時間.concat(RString.FULL_SPACE)
                .concat(setDataTimeFomart2(parameter.get開始時間())));
        
        出力条件.add(TITLE_終了時間.concat(RString.FULL_SPACE)
                .concat(setDataTimeFomart2(parameter.get終了時間())));
        
        
        RString 出力順;
        出力順 = TITLE_出力順.concat(RString.FULL_SPACE);
        List<ISetSortItem> 設定項目リスト = order.get設定項目リスト();
        for (ISetSortItem item : 設定項目リスト) {
            出力順 = 出力順.concat(item.get項目名()).concat(より);
        }
        出力条件.add(出力順.substring(0, 出力順.length() - 1));

        return 出力条件;
    }

    private RString toパターン6(RDate 日付) {
        if (日付 != null) {
            FlexibleDate flex日付 = new FlexibleDate(日付.toDateString());
            return 日付.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }
    
    private RString setDataTimeFomart2(RTime 支払窓口終了期間) {
        if (null == 支払窓口終了期間) {
            return RString.EMPTY;
        }
        RStringBuilder 支払窓口終了期間Builder = new RStringBuilder();
        if (支払窓口終了期間.getHour() < RSTRING_12) {
            支払窓口終了期間Builder.append(午前);
        } else {
            支払窓口終了期間Builder.append(午後);
        }
        支払窓口終了期間Builder.append(String.format("%02d", 支払窓口終了期間.getHour()));
        支払窓口終了期間Builder.append(new RString("時"));
        if (0 < 支払窓口終了期間.getMinute()) {
            支払窓口終了期間Builder.append(String.format("%02d", 支払窓口終了期間.getMinute()));
            支払窓口終了期間Builder.append(new RString("分"));
        }
        return 支払窓口終了期間Builder.toRString();
    }
    
    private RString doStrToStr(Object object) {
        if (object == null) {
            return RString.EMPTY;
        }
        return new RString(object.toString());
    }
}
