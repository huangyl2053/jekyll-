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
     * @param itemList 要介護認定調査票（特記事項）のItem
     * @return 要介護認定調査票（特記事項）のReport
     */
    public static ChosahyoTokkijikoReport createFrom(List<ChosahyoTokkijikoItem> itemList) {
        return new ChosahyoTokkijikoReport(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 要介護認定調査票（特記事項）のItem
     */
    protected ChosahyoTokkijikoReport(List<ChosahyoTokkijikoItem> itemList) {
        this.itemList = itemList;
    }

    /**
     * 帳票を作成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<ChosahyoTokkijikoReportSource> reportSourceWriter) {
        for (ChosahyoTokkijikoItem item : itemList) {
            IChosahyoTokkijikoEditor editor = new ChosahyoTokkijikoEditorImpl(item);
            IChosahyoTokkijikoBuilder builder = new ChosahyoTokkijikoBuilderImpl(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
