/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshudoteiichiran;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshudoteiichiran.TokubetsuChoshuDoteiIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBBPR81003_1_特別徴収同定一覧表のReportクラスです。
 *
 * @reamsid_L DBB-1860-060 liuyang
 */
public class TokubetsuChoshuDoteiIchiranReport extends
        Report<TokubetsuChoshuDoteiIchiranSource> {

    private final Association association;
    private final List<RString> 出力順項目リスト;
    private final Map<RString, RString> 改頁項目Map;
    private final List<RString> 改頁項目リスト;
    private final TokushoTaishioIchiranEntity 特徴対象一覧;
    private final RString 特徴開始月;

    /**
     * コンストラクタです.
     *
     * @param 特徴対象一覧 TokushoTaishioIchiranEntity
     * @param 出力順項目リスト List<RString>
     * @param 改頁項目Map Map<RString, RString>
     * @param 改頁項目リスト List<RString>
     * @param association Association
     * @param 特徴開始月 特徴開始年月
     */
    public TokubetsuChoshuDoteiIchiranReport(Association association,
            List<RString> 出力順項目リスト,
            Map<RString, RString> 改頁項目Map,
            List<RString> 改頁項目リスト,
            TokushoTaishioIchiranEntity 特徴対象一覧,
            RString 特徴開始月) {
        this.association = association;
        this.出力順項目リスト = 出力順項目リスト;
        this.改頁項目Map = 改頁項目Map;
        this.改頁項目リスト = 改頁項目リスト;
        this.特徴対象一覧 = 特徴対象一覧;
        this.特徴開始月 = 特徴開始月;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuDoteiIchiranSource> writer) {
        ITokubetsuChoshuDoteiIchiranEditor editor
                = new TokubetsuChoshuDoteiIchiranEditor(特徴対象一覧,
                        出力順項目リスト, 改頁項目Map, 改頁項目リスト, association, 特徴開始月);
        ITokubetsuChoshuDoteiIchiranBuilder builder = new TokubetsuChoshuDoteiIchiranBuilder(editor);
        writer.writeLine(builder);
    }

}
