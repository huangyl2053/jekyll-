/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyotokkijikofree;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyotokkijiko.ChosahyoTokkijikoItem;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosahyotokkijiko.ChosahyoTokkijikoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定調査票（特記事項）フリー様式のReportです。
 */
public class ChosahyoTokkijikoFreeReport extends Report<ChosahyoTokkijikoReportSource> {

    private final List<ChosahyoTokkijikoItem> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 要介護認定調査票（特記事項）フリー様式のItem
     * @return 要介護認定調査票（特記事項）フリー様式のReport
     */
    public static ChosahyoTokkijikoFreeReport createFrom(List<ChosahyoTokkijikoItem> itemList) {
        return new ChosahyoTokkijikoFreeReport(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 要介護認定調査票（特記事項）フリー様式のItem
     */
    protected ChosahyoTokkijikoFreeReport(List<ChosahyoTokkijikoItem> itemList) {
        this.itemList = itemList;
    }

    /**
     * 要介護認定調査票（特記事項）フリー様式を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<ChosahyoTokkijikoReportSource> reportSourceWriter) {
        for (ChosahyoTokkijikoItem item : itemList) {
            IChosahyoTokkijikoFreeEditor editor = new ChosahyoTokkijikoFreeEditorImpl(item);
            IChosahyoTokkijikoFreeBuilder builder = new ChosahyoTokkijikoFreeBuilderImpl(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
