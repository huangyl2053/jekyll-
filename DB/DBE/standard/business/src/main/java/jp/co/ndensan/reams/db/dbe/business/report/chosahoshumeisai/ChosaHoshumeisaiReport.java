/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahoshumeisai;

import jp.co.ndensan.reams.db.dbe.business.core.chosahoshumeisai.ChosaHoshumeisai;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshumeisai.ChosaHoshumeisaiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 認定調査報酬支払明細書のReportです。
 *
 * @reamsid_L DBE-1980-045 suguangjun
 */
public class ChosaHoshumeisaiReport extends Report<ChosaHoshumeisaiReportSource> {

    private final ChosaHoshumeisai data;

    /**
     * インスタンスを生成します。
     *
     * @param data 要介護状態区分別判定件数のdataList
     */
    public ChosaHoshumeisaiReport(ChosaHoshumeisai data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ChosaHoshumeisaiReportSource> reportSourceWriter) {
        IChosaHoshumeisaiEditor editor = new ChosaHoshumeisaiEditor(data);
        IChosaHoshumeisaiBuilder builder = new ChosaHoshumeisaiBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
