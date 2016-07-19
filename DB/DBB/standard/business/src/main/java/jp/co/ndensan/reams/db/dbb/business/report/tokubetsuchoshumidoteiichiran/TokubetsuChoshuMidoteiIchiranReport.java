/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshumidoteiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshumidoteiichiran.TokubetsuChoshuMidoteiIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 帳票設計_DBBPR81003_2_特別徴収未同定一覧表のReportです。
 *
 * @reamsid_L DBB-1860-070 liuyang
 */
public class TokubetsuChoshuMidoteiIchiranReport extends
        Report<TokubetsuChoshuMidoteiIchiranSource> {

    private final List<TokushoTaishioIchiranMidoteiEntity> 特徴対象一覧未同定リスト;
    private final Association association;

    /**
     * コンストラクタです.
     *
     * @param 特徴対象一覧未同定リスト 特徴対象一覧未同定リスト
     * @param association Association
     */
    public TokubetsuChoshuMidoteiIchiranReport(Association association,
            List<TokushoTaishioIchiranMidoteiEntity> 特徴対象一覧未同定リスト) {
        this.特徴対象一覧未同定リスト = 特徴対象一覧未同定リスト;
        this.association = association;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuMidoteiIchiranSource> writer) {
        for (TokushoTaishioIchiranMidoteiEntity 特徴対象一覧未同定 : 特徴対象一覧未同定リスト) {
            ITokubetsuChoshuMidoteiIchiranEditor editor = new TokubetsuChoshuMidoteiIchiranEditor(
                    特徴対象一覧未同定, association);
            TokubetsuChoshuMidoteiIchiranBuilder builder = new TokubetsuChoshuMidoteiIchiranBuilder(editor);
            writer.writeLine(builder);
        }
    }

    /**
     * 特別徴収未同定一覧表
     *
     * @param 特徴対象一覧リスト List<TokushoTaishioIchiranMidoteiEntity>
     * @param association Association
     * @return TokubetsuChoshuMidoteiIchiranReport
     */
    public static TokubetsuChoshuMidoteiIchiranReport createForm(
            @NonNull List<TokushoTaishioIchiranMidoteiEntity> 特徴対象一覧リスト, Association association) {
        return new TokubetsuChoshuMidoteiIchiranReport(association, 特徴対象一覧リスト);
    }
}
