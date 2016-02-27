/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakuseitokusokujo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshosakuseitokusokujo.ShujiiIkenshoSakuseiTokusokujoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書提出督促状のReportです。
 *
 */
public class ShujiiIkenshoSakuseiTokusokujoReport extends Report<ShujiiIkenshoSakuseiTokusokujoReportSource> {

    private final ShujiiIkenshoSakuseiTokusokujoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 主治医意見書提出督促状のITEM
     * @return 主治医意見書提出督促状のReport
     */
    public static ShujiiIkenshoSakuseiTokusokujoReport createFrom(ShujiiIkenshoSakuseiTokusokujoItem item) {
        return new ShujiiIkenshoSakuseiTokusokujoReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 主治医意見書提出督促状のITEM
     */
    protected ShujiiIkenshoSakuseiTokusokujoReport(ShujiiIkenshoSakuseiTokusokujoItem item) {
        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShujiiIkenshoSakuseiTokusokujoReportSource> reportSourceWriter) {
        ShujiiIkenshoSakuseiTokusokujoHeadEditor editor = new ShujiiIkenshoSakuseiTokusokujoHeadEditor(item);
        ShujiiIkenshoSakuseiTokusokujoBuilderImpl builder = new ShujiiIkenshoSakuseiTokusokujoBuilderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }
}
