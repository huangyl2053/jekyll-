/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoteishutsuiraisho;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護保険指定医依頼兼主治医意見書提出依頼書のReportです。
 */
public class ShujiiIkenshoTeishutsuIraishoReport extends Report<ShujiiIkenshoTeishutsuIraishoReportSource> {

    private final ShujiiIkenshoTeishutsuIraishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険指定医依頼兼主治医意見書提出依頼書のITEM
     * @return 介護保険指定医依頼兼主治医意見書提出依頼書のReport
     */
    public static ShujiiIkenshoTeishutsuIraishoReport createFrom(
            ShujiiIkenshoTeishutsuIraishoItem item) {

        return new ShujiiIkenshoTeishutsuIraishoReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険指定医依頼兼主治医意見書提出依頼書のITEM
     */
    protected ShujiiIkenshoTeishutsuIraishoReport(ShujiiIkenshoTeishutsuIraishoItem item) {
        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShujiiIkenshoTeishutsuIraishoReportSource> reportSourceWriter) {
        ShujiiIkenshoTeishutsuIraishoEditor editor = new ShujiiIkenshoTeishutsuIraishoEditor(item);
        IShujiiIkenshoTeishutsuIraishoBuilder builder = new ShujiiIkenshoTeishutsuIraishoBuilderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }

}
