/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakuseitokusokujo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshosakuseitokusokujo.ShujiiIkenshoSakuseiTokusokujoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書提出督促状のReportです。
 *
 */
public class ShujiiIkenshoSakuseiTokusokujoReport extends Report<ShujiiIkenshoSakuseiTokusokujoReportSource> {

    private final List<ShujiiIkenshoSakuseiTokusokujoItem> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 主治医意見書提出督促状のITEM
     * @return 主治医意見書提出督促状のReport
     */
    public static ShujiiIkenshoSakuseiTokusokujoReport createFrom(
            List<ShujiiIkenshoSakuseiTokusokujoItem> itemList) {
        return new ShujiiIkenshoSakuseiTokusokujoReport(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 主治医意見書提出督促状のITEM
     */
    protected ShujiiIkenshoSakuseiTokusokujoReport(
            List<ShujiiIkenshoSakuseiTokusokujoItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShujiiIkenshoSakuseiTokusokujoReportSource> reportSourceWriter) {
        int index = 1;
        for (ShujiiIkenshoSakuseiTokusokujoItem item : itemList) {
            IShujiiIkenshoSakuseiTokusokujoEditor editor = new ShujiiIkenshoSakuseiTokusokujoHeadEditor(item, index);
            IShujiiIkenshoSakuseiTokusokujoBuilder builder = new ShujiiIkenshoSakuseiTokusokujoBuilderImpl(editor);
            index = index + 1;
            reportSourceWriter.writeLine(builder);

        }
    }
}
