/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinseimonitor;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseimonitor.ShinseiMonitorEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinseimonitor.ShinseiMonitorReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定申請モニタリストのReportです。
 *
 * @reamsid_L DBE-1390-100 suguangjun
 */
public class ShinseiMonitorReport extends Report<ShinseiMonitorReportSource> {

    private final List<ShinseiMonitorEntity> data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     */
    public ShinseiMonitorReport(List<ShinseiMonitorEntity> data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShinseiMonitorReportSource> reportSourceWriter) {
        for (int i = 0; i < data.size(); i++) {
            IShinseiMonitorEditor editor = new ShinseiMonitorEditor(data.get(i), i);
            IShinseiMonitorBuilder builder = new ShinseiMonitorBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
        if (data.isEmpty()) {
            ShinseiMonitorEntity entity = new ShinseiMonitorEntity();
            entity.set氏名(new RString("該当データがありません"));
            IShinseiMonitorEditor editor = new ShinseiMonitorEditor(entity, -1);
            IShinseiMonitorBuilder builder = new ShinseiMonitorBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
