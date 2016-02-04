/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyotokkijiko;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosahyotokkijiko.ChosahyoTokkijikoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定調査票（特記事項）のReportです。
 */
public class ChosahyoTokkijikoReport extends Report<ChosahyoTokkijikoReportSource> {

    private final List<ChosahyoTokkijikoItem> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 介護認定審査会スケジュール表かがみのItem
     * @return 介護認定審査会スケジュール表かがみのReport
     */
    public static ChosahyoTokkijikoReport createFrom(List<ChosahyoTokkijikoItem> itemList) {
        return new ChosahyoTokkijikoReport(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 介護認定審査会スケジュール表かがみのItem
     */
    protected ChosahyoTokkijikoReport(List<ChosahyoTokkijikoItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<ChosahyoTokkijikoReportSource> reportSourceWriter) {
        for (ChosahyoTokkijikoItem item : itemList) {
            ChosahyoTokkijikoEditorImpl editor = new ChosahyoTokkijikoEditorImpl(item);
            ChosahyoTokkijikoBuilderImpl builder = new ChosahyoTokkijikoBuilderImpl(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
