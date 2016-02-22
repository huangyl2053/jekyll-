/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaiiinwaritsuke;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaiiinwaritsuke.ShinsaschedulekagamiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会スケジュール表かがみのReportです。
 */
public class ShinsaschedulekagamiReport extends Report<ShinsaschedulekagamiReportSource> {

    private final List<ShinsaschedulekagamiItem> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 介護認定審査会スケジュール表かがみのItem
     * @return 介護認定審査会スケジュール表かがみのReport
     */
    public static ShinsaschedulekagamiReport createFrom(List<ShinsaschedulekagamiItem> itemList) {
        return new ShinsaschedulekagamiReport(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 介護認定審査会スケジュール表かがみのItem
     */
    protected ShinsaschedulekagamiReport(List<ShinsaschedulekagamiItem> itemList) {
        this.itemList = itemList;
    }

    /**
     * 介護認定審査会スケジュール表かがみを生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<ShinsaschedulekagamiReportSource> reportSourceWriter) {
        for (ShinsaschedulekagamiItem item : itemList) {
            IShinsaschedulekagamiEditor editor = new ShinsaschedulekagamiEditorImpl(item);
            IShinsaschedulekagamiBuilder builder = new ShinsaschedulekagamiBuilderImpl(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
