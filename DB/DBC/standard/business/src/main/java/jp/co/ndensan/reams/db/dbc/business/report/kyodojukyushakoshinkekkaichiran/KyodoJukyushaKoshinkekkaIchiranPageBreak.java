/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyodojukyushakoshinkekkaichiran;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushakoshinkekkaichiran.KyodoJukyushaKoshinkekkaIchiranReportData;
import jp.co.ndensan.reams.db.dbc.entity.report.kyodojukyushakoshinkekkaichiran.KyodoJukyushaKoshinkekkaIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 国保連保有共同処理用受給者情報一覧取込のPageBreakクラスです。
 *
 * @reamsid_L DBC-2920-010 liuxiaoyu
 */
public class KyodoJukyushaKoshinkekkaIchiranPageBreak extends PageBreaker<KyodoJukyushaKoshinkekkaIchiranReportSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public KyodoJukyushaKoshinkekkaIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KyodoJukyushaKoshinkekkaIchiranReportSource> currentSource,
            ReportLineRecord<KyodoJukyushaKoshinkekkaIchiranReportSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(KyodoJukyushaKoshinkekkaIchiranOutPutOrder.保険者番号.getフォームフィールド名())
                && !currentSource.getSource().hokenshaNo.equals(nextSource.getSource().hokenshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(KyodoJukyushaKoshinkekkaIchiranOutPutOrder.町域コード.get項目ID())
                && !currentSource.getSource().list2_4.equals(nextSource.getSource().list2_4)) {
            flag = true;
        } else if (this.breakKeysList.contains(KyodoJukyushaKoshinkekkaIchiranOutPutOrder.行政区コード.get項目ID())
                && !currentSource.getSource().list1_9.equals(nextSource.getSource().list1_9)) {
            flag = true;
        }
        return flag;
    }

    /**
     * 改頁判断のメソッドです。
     *
     * @param currentSource KyodoJukyushaKoshinkekkaIchiranReportData
     * @param nextSource KyodoJukyushaKoshinkekkaIchiranReportData
     * @return 改頁Flag
     */
    public boolean is改頁(KyodoJukyushaKoshinkekkaIchiranReportData currentSource,
            KyodoJukyushaKoshinkekkaIchiranReportData nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(KyodoJukyushaKoshinkekkaIchiranOutPutOrder.保険者番号.getフォームフィールド名())
                && !currentSource.get共同処理一時TBL().get保険者番号().equals(nextSource.get共同処理一時TBL().get保険者番号())) {
            flag = true;
        } else if (this.breakKeysList.contains(KyodoJukyushaKoshinkekkaIchiranOutPutOrder.町域コード.get項目ID())
                && !currentSource.get被保険者一時TBL().get町域コード().equals(nextSource.get被保険者一時TBL().get町域コード())) {
            flag = true;
        } else if (this.breakKeysList.contains(KyodoJukyushaKoshinkekkaIchiranOutPutOrder.行政区コード.get項目ID())
                && !currentSource.get被保険者一時TBL().get行政区コード().equals(nextSource.get被保険者一時TBL().get行政区コード())) {
            flag = true;
        }
        return flag;
    }
}
