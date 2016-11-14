/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaiiinwaritsuke;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaiiinwaritsuke.ShinsaschedulekagamiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会スケジュール表かがみのReportです。
 *
 * @reamsid_L DBE-0130-080 xuyannan
 */
public class ShinsaschedulekagamiReport extends Report<ShinsaschedulekagamiReportSource> {

    private final ShinsaschedulekagamiItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護認定審査会スケジュール表かがみのItem
     */
    public ShinsaschedulekagamiReport(ShinsaschedulekagamiItem item) {
        this.item = item;
    }

    /**
     * 介護認定審査会スケジュール表かがみを生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<ShinsaschedulekagamiReportSource> reportSourceWriter) {
        IShinsaschedulekagamiEditor editor = new ShinsaschedulekagamiEditorImpl(item);
        IShinsaschedulekagamiBuilder builder = new ShinsaschedulekagamiBuilderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }
}
