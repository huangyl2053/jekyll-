/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshumidoteiichiran;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshumidoteiichiran.TokubetsuChoshuMidoteiIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBBPR81003_2_特別徴収未同定一覧表のReportです。
 *
 * @reamsid_L DBB-1860-070 liuyang
 */
public class TokubetsuChoshuMidoteiIchiranReport extends
        Report<TokubetsuChoshuMidoteiIchiranSource> {

    private final TokushoTaishioIchiranMidoteiEntity 特徴対象一覧未同定;
    private final List<RString> 出力順項目リスト;
    private final Map<RString, RString> 改頁項目Map;
    private final List<RString> 改頁項目リスト;
    private final Association association;
    private final RString 特徴開始月;

    /**
     * コンストラクタです.
     *
     * @param 出力順項目リスト List<RString>
     * @param 特徴対象一覧未同定 特徴対象一覧未同定
     * @param 改頁項目Map Map<RString, RString>
     * @param 改頁項目リスト List<RString>
     * @param 特徴開始月 特徴開始月
     * @param association Association
     */
    public TokubetsuChoshuMidoteiIchiranReport(Association association,
            List<RString> 出力順項目リスト,
            Map<RString, RString> 改頁項目Map,
            List<RString> 改頁項目リスト,
            TokushoTaishioIchiranMidoteiEntity 特徴対象一覧未同定,
            RString 特徴開始月) {
        this.特徴対象一覧未同定 = 特徴対象一覧未同定;
        this.出力順項目リスト = 出力順項目リスト;
        this.改頁項目Map = 改頁項目Map;
        this.改頁項目リスト = 改頁項目リスト;
        this.association = association;
        this.特徴開始月 = 特徴開始月;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuMidoteiIchiranSource> writer) {
        ITokubetsuChoshuMidoteiIchiranEditor editor = new TokubetsuChoshuMidoteiIchiranEditor(
                特徴対象一覧未同定, 出力順項目リスト, 改頁項目Map, 改頁項目リスト, 特徴開始月, association);
        TokubetsuChoshuMidoteiIchiranBuilder builder = new TokubetsuChoshuMidoteiIchiranBuilder(editor);
        writer.writeLine(builder);

    }

}
