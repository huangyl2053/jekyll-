/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoa3;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoa3.ShujiiikenshoA3ReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoa3.ShujiiikenshoItem;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 委員用主治医意見書A3のReportです。
 *
 * @reamsid_L DBE-0150-140 lishengli
 */
public class ShujiiikenshoA3Report extends Report<ShujiiikenshoA3ReportSource> {

    private final ShujiiikenshoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item ShujiiikenshoItem
     * @return 委員用主治医意見書A3のReport
     */
    public static ShujiiikenshoA3Report createFrom(ShujiiikenshoItem item) {

        return new ShujiiikenshoA3Report(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 委員用主治医意見書Entity
     */
    public ShujiiikenshoA3Report(ShujiiikenshoItem item) {
        this.item = item;
    }

    /**
     * 委員用主治医意見書A3を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<ShujiiikenshoA3ReportSource> reportSourceWriter) {
        IShujiiikenshoA3Editor editor = new ShujiiikenshoA3Editor(item);
        IShujiiikenshoA3Builder builder = new ShujiiikenshoA3Builder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
