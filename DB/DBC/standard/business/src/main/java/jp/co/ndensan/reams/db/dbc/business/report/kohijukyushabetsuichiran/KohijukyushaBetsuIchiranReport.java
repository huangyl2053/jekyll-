/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kohijukyushabetsuichiran;

import jp.co.ndensan.reams.db.dbc.business.core.kohijukyushabetsuichiran.KohijukyushaBetsuIchiranBusiness;
import jp.co.ndensan.reams.db.dbc.entity.report.kohijukyushabetsuichiran.KohijukyushaBetsuIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護給付費公費受給者別一覧表のReportです。
 *
 * @reamsid_L DBC-2800-030 xuyannan
 */
public class KohijukyushaBetsuIchiranReport extends Report<KohijukyushaBetsuIchiranReportSource> {

    private final KohijukyushaBetsuIchiranBusiness business;
    private final boolean 集計Flag;

    /**
     * インスタンスを生成します。
     *
     * @param business 介護給付費公費受給者別一覧表のBusiness
     * @param 集計Flag 集計Flag
     */
    public KohijukyushaBetsuIchiranReport(
            KohijukyushaBetsuIchiranBusiness business, boolean 集計Flag) {
        this.business = business;
        this.集計Flag = 集計Flag;
    }

    @Override
    public void writeBy(ReportSourceWriter<KohijukyushaBetsuIchiranReportSource> reportSourceWriter) {
        IKohijukyushaBetsuIchiranEditor editor = new KohijukyushaBetsuIchiranEditor(business, 集計Flag);
        IKohijukyushaBetsuIchiranBuilder builder = new KohijukyushaBetsuIchiranBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
