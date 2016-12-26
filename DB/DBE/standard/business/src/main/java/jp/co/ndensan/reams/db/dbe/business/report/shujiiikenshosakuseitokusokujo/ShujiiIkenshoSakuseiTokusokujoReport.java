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
 * @reamsid_L DBE-0060-020 hezhenzhen
 *
 */
public class ShujiiIkenshoSakuseiTokusokujoReport extends Report<ShujiiIkenshoSakuseiTokusokujoReportSource> {

    private final ShujiiIkenshoSakuseiTokusokujoItem itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 主治医意見書提出督促状のITEM
     */
    public ShujiiIkenshoSakuseiTokusokujoReport(
            ShujiiIkenshoSakuseiTokusokujoItem itemList) {
        this.itemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShujiiIkenshoSakuseiTokusokujoReportSource> reportSourceWriter) {
        IShujiiIkenshoSakuseiTokusokujoEditor editor = new ShujiiIkenshoSakuseiTokusokujoHeadEditor(
                itemList, reportSourceWriter.pageCount().value() + 1);
        IShujiiIkenshoSakuseiTokusokujoBuilder builder = new ShujiiIkenshoSakuseiTokusokujoBuilderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }
}
