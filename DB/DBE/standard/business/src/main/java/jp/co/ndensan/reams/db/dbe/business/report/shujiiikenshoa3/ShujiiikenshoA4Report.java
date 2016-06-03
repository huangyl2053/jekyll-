/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoa3;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoa3.ShujiiikenshoA4ReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoa3.ShujiiikenshoItem;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 委員用主治医意見書A4のReportです。
 *
 * @reamsid_L DBE-0150-140 lishengli
 */
public class ShujiiikenshoA4Report extends Report<ShujiiikenshoA4ReportSource> {

    private final ShujiiikenshoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item ShujiiikenshoItem
     * @return 委員用主治医意見書A4のReport
     */
    public static ShujiiikenshoA4Report createFrom(ShujiiikenshoItem item) {

        return new ShujiiikenshoA4Report(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 委員用主治医意見書Item
     */
    public ShujiiikenshoA4Report(ShujiiikenshoItem item) {
        this.item = item;
    }

    /**
     * 委員用主治医意見書を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    protected void writeBy(ReportSourceWriter<ShujiiikenshoA4ReportSource> reportSourceWriter) {
        IShujiiikenshoA4Editor editor = new ShujiiikenshoA4Editor(item);
        IShujiiikenshoA4Builder builder = new ShujiiikenshoA4Builder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
