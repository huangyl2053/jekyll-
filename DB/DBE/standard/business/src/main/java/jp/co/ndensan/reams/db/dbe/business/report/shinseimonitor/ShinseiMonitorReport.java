/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinseimonitor;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseimonitor.ShinseiMonitorEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinseimonitor.ShinseiMonitorReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定申請モニタリストのReportです。
 *
 * @reamsid_L DBE-1390-100 suguangjun
 */
public class ShinseiMonitorReport extends Report<ShinseiMonitorReportSource> {

    private final ShinseiMonitorEntity data;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     * @param index 番号
     */
    public ShinseiMonitorReport(ShinseiMonitorEntity data, int index) {
        this.data = data;
        this.index = index;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShinseiMonitorReportSource> reportSourceWriter) {
        IShinseiMonitorEditor editor = new ShinseiMonitorEditor(data, index);
        IShinseiMonitorBuilder builder = new ShinseiMonitorBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
