/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.hiyobenshotoshiharaimeisaisho;

import jp.co.ndensan.reams.db.dbe.business.core.hiyobenshotoshiharaimeisaisho.HiyobenshotoShiharaimeisaisho;
import jp.co.ndensan.reams.db.dbe.entity.report.source.hiyobenshotoshiharaimeisaisho.HiyobenshotoShiharaimeisaishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査委員報酬・費用弁償等支払明細書のReportです。
 *
 * @reamsid_L DBE-1980-048 suguangjun
 */
public class HiyobenshotoShiharaimeisaishoReport extends Report<HiyobenshotoShiharaimeisaishoReportSource> {

    private final HiyobenshotoShiharaimeisaisho data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     */
    public HiyobenshotoShiharaimeisaishoReport(HiyobenshotoShiharaimeisaisho data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<HiyobenshotoShiharaimeisaishoReportSource> reportSourceWriter) {
        IHiyobenshotoShiharaimeisaishoEditor editor = new HiyobenshotoShiharaimeisaishoEditor(data);
        IHiyobenshotoShiharaimeisaishoBuilder builder = new HiyobenshotoShiharaimeisaishoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
