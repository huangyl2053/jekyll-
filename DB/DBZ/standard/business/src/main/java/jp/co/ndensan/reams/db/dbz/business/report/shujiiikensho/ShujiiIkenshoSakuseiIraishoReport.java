/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.shujiiikensho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書作成依頼書のReportです。
 *
 * @reamsid_L DBE-0050-020 sunhaidi
 */
public class ShujiiIkenshoSakuseiIraishoReport extends Report<ShujiiIkenshoSakuseiIraishoReportSource> {

    private final List<ShujiiIkenshoSakuseiIraishoItem> items;

    /**
     * インスタンスを生成します。
     *
     * @param item 主治医意見書作成依頼書のITEM
     * @return 主治医意見書作成依頼書のReport
     */
    public static ShujiiIkenshoSakuseiIraishoReport createFrom(ShujiiIkenshoSakuseiIraishoItem item) {
        List<ShujiiIkenshoSakuseiIraishoItem> itemList = new ArrayList<>();
        itemList.add(item);
        return new ShujiiIkenshoSakuseiIraishoReport(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param items 主治医意見書作成依頼書のITEM
     * @return 主治医意見書作成依頼書のReport
     */
    public static ShujiiIkenshoSakuseiIraishoReport createFrom(List<ShujiiIkenshoSakuseiIraishoItem> items) {
        return new ShujiiIkenshoSakuseiIraishoReport(items);
    }

    /**
     * インスタンスを生成します。
     *
     * @param items 主治医意見書作成依頼書のITEM
     */
    protected ShujiiIkenshoSakuseiIraishoReport(List<ShujiiIkenshoSakuseiIraishoItem> items) {
        this.items = items;
    }

    /**
     * 主治医意見書作成依頼書を出力します。
     *
     * @param reportSourceWriter 主治医意見書作成依頼書Sourceクラス
     */
    @Override
    public void writeBy(ReportSourceWriter<ShujiiIkenshoSakuseiIraishoReportSource> reportSourceWriter) {
        for (ShujiiIkenshoSakuseiIraishoItem item : items) {
            IShujiiIkenshoSakuseiIraishoEditor editor = new ShujiiIkenshoSakuseiIraishoEditor(item);
            IShujiiIkenshoSakuseiIraishoBuilder builder = new ShujiiIkenshoSakuseiIraishoBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
