/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsainshiharaimeisaisho;

import jp.co.ndensan.reams.db.dbe.business.core.shinsainshiharaimeisaisho.ShinsainShiharaimeisaisho;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsainshiharaimeisaisho.ShinsainShiharaimeisaishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会委員報酬支払明細書のReportです。
 *
 * @reamsid_L DBE-1980-046 suguangjun
 */
public class ShinsainShiharaimeisaishoReport extends Report<ShinsainShiharaimeisaishoReportSource> {

    private final ShinsainShiharaimeisaisho data;

    /**
     * インスタンスを生成します。
     *
     * @param data 要介護状態区分別判定件数のdataList
     */
    public ShinsainShiharaimeisaishoReport(ShinsainShiharaimeisaisho data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShinsainShiharaimeisaishoReportSource> reportSourceWriter) {
        IShinsainShiharaimeisaishoEditor editor = new ShinsainShiharaimeisaishoEditor(data);
        IShinsainShiharaimeisaishoBuilder builder = new ShinsainShiharaimeisaishoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
