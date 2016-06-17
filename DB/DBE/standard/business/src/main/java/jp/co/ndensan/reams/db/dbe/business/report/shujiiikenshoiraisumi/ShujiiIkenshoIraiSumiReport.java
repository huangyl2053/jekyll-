/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoiraisumi;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshoiraisumi.ShujiiIkenshoIraiSumiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoiraisumi.ShujiiIkenshoIraiSumiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書依頼済み一覧表のReportです。
 *
 * @reamsid_L DBE-1390-160 suguangjun
 */
public class ShujiiIkenshoIraiSumiReport extends Report<ShujiiIkenshoIraiSumiReportSource> {

    private final ShujiiIkenshoIraiSumiEntity data;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     * @param index int
     */
    public ShujiiIkenshoIraiSumiReport(ShujiiIkenshoIraiSumiEntity data, int index) {
        this.data = data;
        this.index = index;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShujiiIkenshoIraiSumiReportSource> reportSourceWriter) {
        IShujiiIkenshoIraiSumiEditor editor = new ShujiiIkenshoIraiSumiEditor(data, index);
        IShujiiIkenshoIraiSumiBuilder builder = new ShujiiIkenshoIraiSumiBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
