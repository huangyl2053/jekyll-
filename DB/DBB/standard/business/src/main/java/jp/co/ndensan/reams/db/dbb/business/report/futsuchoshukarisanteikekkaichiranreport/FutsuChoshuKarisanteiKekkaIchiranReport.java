/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.futsuchoshukarisanteikekkaichiranreport;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.futsuchoshukarisanteikekkaichiranreport.FuchoKariKeisanGoFukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.futsuchoshukarisanteikekkaichiranreport.FutsuChoshuKarisanteiKekkaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 普徴仮算定計算後賦課Report
 *
 * @reamsid_L DBB-0870-030 surun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutsuChoshuKarisanteiKekkaIchiranReport extends
        Report<FutsuChoshuKarisanteiKekkaIchiranSource> {

    private final FuchoKariKeisanGoFukaEntity 普徴仮算定計算後賦課;
    private final FlexibleYear 調定年度;
    private final FlexibleYear 賦課年度;
    private final YMDHMS 調定日時;
    private final Association association;
    private final List<RString> 出力項目リスト;
    private final List<RString> 改頁項目リスト;
    private final int 連番;

    /**
     * FutsuChoshuKarisanteiKekkaIchiranReport
     *
     * @param 普徴仮算定計算後賦課 FuchoKariKeisanGoFukaEntity
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param association Association
     * @param 出力項目リスト List<RString>
     * @param 改頁項目リスト List<RString>
     * @param 連番 int
     */
    public FutsuChoshuKarisanteiKekkaIchiranReport(FuchoKariKeisanGoFukaEntity 普徴仮算定計算後賦課, FlexibleYear 調定年度,
            FlexibleYear 賦課年度, YMDHMS 調定日時, Association association, List<RString> 出力項目リスト, List<RString> 改頁項目リスト, int 連番) {
        this.普徴仮算定計算後賦課 = 普徴仮算定計算後賦課;
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.調定日時 = 調定日時;
        this.association = association;
        this.出力項目リスト = 出力項目リスト;
        this.改頁項目リスト = 改頁項目リスト;
        this.連番 = 連番;

    }

    @Override
    public void writeBy(ReportSourceWriter<FutsuChoshuKarisanteiKekkaIchiranSource> writer) {
        IFutsuChoshuKarisanteiKekkaIchiranEditor editor = new FutsuChoshuKarisanteiKekkaIchiranEditor(普徴仮算定計算後賦課,
                調定年度, 賦課年度, 調定日時, association, 出力項目リスト, 改頁項目リスト, 連番);
        IFutsuChoshuKarisanteiKekkaIchiranBuilder builder
                = new FutsuChoshuKarisanteiKekkaIchiranBuilder(editor);
        writer.writeLine(builder);

    }

}
