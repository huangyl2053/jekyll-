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
    private int index = 0;

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

    @Override
    public void writeBy(ReportSourceWriter<ShinsaschedulekagamiReportSource> reportSourceWriter) {
        for (ShinsaschedulekagamiItem item : itemList) {
            // TODO 内部QA：660 Redmine# (連番の設定がわかりません、"'1'から..."を設定する)
            index = index + 1;
            ShinsaschedulekagamiEditorImpl editor = new ShinsaschedulekagamiEditorImpl(item, index);
            ShinsaschedulekagamiBuilderImpl builder = new ShinsaschedulekagamiBuilderImpl(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
