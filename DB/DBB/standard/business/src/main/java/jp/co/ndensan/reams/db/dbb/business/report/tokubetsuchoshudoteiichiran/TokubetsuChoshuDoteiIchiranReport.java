/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshudoteiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshudoteiichiran.TokubetsuChoshuDoteiIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    private final List<RString> 出力順項目リスト;
    private final List<RString> 改頁項目リスト;
    private final List<TokushoTaishioIchiranEntity> 特徴対象一覧リスト;
    private final RString 特徴開始月;

    /**
     * コンストラクタです.
     *
     * @param 特徴対象一覧リスト List<TokushoTaishioIchiranEntity>
     * @param 出力順項目リスト List<RString>
     * @param 改頁項目リスト List<RString>
     * @param association Association
     * @param 特徴開始月 特徴開始年月
     */
    public TokubetsuChoshuDoteiIchiranReport(Association association,
            List<RString> 出力順項目リスト,
            List<RString> 改頁項目リスト,
            List<TokushoTaishioIchiranEntity> 特徴対象一覧リスト,
            RString 特徴開始月) {
        this.association = association;
        this.出力順項目リスト = 出力順項目リスト;
        this.改頁項目リスト = 改頁項目リスト;
        this.特徴対象一覧リスト = 特徴対象一覧リスト;
        this.特徴開始月 = 特徴開始月;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuDoteiIchiranSource> writer) {
        for (TokushoTaishioIchiranEntity 特徴対象一覧 : 特徴対象一覧リスト) {
            ITokubetsuChoshuDoteiIchiranEditor editor
                    = new TokubetsuChoshuDoteiIchiranEditor(特徴対象一覧,
                            出力順項目リスト, 改頁項目リスト, association, 特徴開始月);
            ITokubetsuChoshuDoteiIchiranBuilder builder = new TokubetsuChoshuDoteiIchiranBuilder(editor);
            writer.writeLine(builder);
        }
    }

    /**
     * 特別徴収同定一覧表
     *
     * @param 特徴対象一覧リスト List<TokushoTaishioIchiranEntity>
     * @param 出力順項目リスト 出力順項目リスト
     * @param 改頁項目リスト 改頁項目リスト
     * @param association Association
     * @param 特徴開始月 特徴開始年月
     * @return TokubetsuChoshuDoteiIchiranReport
     */
    public static TokubetsuChoshuDoteiIchiranReport createForm(
            @NonNull List<TokushoTaishioIchiranEntity> 特徴対象一覧リスト, List<RString> 出力順項目リスト,
            List<RString> 改頁項目リスト, Association association, RString 特徴開始月) {
        return new TokubetsuChoshuDoteiIchiranReport(association, 出力順項目リスト, 改頁項目リスト,
                特徴対象一覧リスト, 特徴開始月);
    }

}
