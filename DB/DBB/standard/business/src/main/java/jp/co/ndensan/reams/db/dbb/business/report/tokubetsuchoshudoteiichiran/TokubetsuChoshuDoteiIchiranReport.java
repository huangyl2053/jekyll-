/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshudoteiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshudoteiichiran.TokubetsuChoshuDoteiIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 帳票設計_DBBPR81003_1_特別徴収同定一覧表のReportクラスです。
 *
 * @reamsid_L DBB-1860-060 liuyang
 */
public class TokubetsuChoshuDoteiIchiranReport extends
        Report<TokubetsuChoshuDoteiIchiranSource> {

    private final Association association;
    private final List<TokushoTaishioIchiranEntity> 特徴対象一覧リスト;

    /**
     * コンストラクタです.
     *
     * @param 特徴対象一覧リスト List<TokushoTaishioIchiranEntity>
     * @param association Association
     */
    public TokubetsuChoshuDoteiIchiranReport(Association association,
            List<TokushoTaishioIchiranEntity> 特徴対象一覧リスト) {
        this.association = association;
        this.特徴対象一覧リスト = 特徴対象一覧リスト;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuDoteiIchiranSource> writer) {
        for (TokushoTaishioIchiranEntity 特徴対象一覧 : 特徴対象一覧リスト) {
            ITokubetsuChoshuDoteiIchiranEditor editor
                    = new TokubetsuChoshuDoteiIchiranEditor(特徴対象一覧, association);
            ITokubetsuChoshuDoteiIchiranBuilder builder = new TokubetsuChoshuDoteiIchiranBuilder(editor);
            writer.writeLine(builder);
        }
    }

    /**
     * 特別徴収同定一覧表
     *
     * @param 特徴対象一覧リスト List<TokushoTaishioIchiranEntity>
     * @param association Association
     * @return TokubetsuChoshuDoteiIchiranReport
     */
    public static TokubetsuChoshuDoteiIchiranReport createForm(
            @NonNull List<TokushoTaishioIchiranEntity> 特徴対象一覧リスト, Association association) {
        return new TokubetsuChoshuDoteiIchiranReport(association, 特徴対象一覧リスト);
    }

}
