/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書作成依頼一覧のReportです。
 *
 */
public class IkenshoSakuseiIraiIchiranhyoReport extends Report<IkenshoSakuseiIraiIchiranhyoReportSource> {

    private final List<IkenshoSakuseiIraiIchiranhyoItem> item;

    /**
     * インスタンスを生成します。
     *
     * @param item 主治医意見書作成依頼一覧のITEM
     * @return 主治医意見書作成依頼一覧のReport
     */
    public static IkenshoSakuseiIraiIchiranhyoReport createFrom(List<IkenshoSakuseiIraiIchiranhyoItem> item) {
        return new IkenshoSakuseiIraiIchiranhyoReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 主治医意見書作成依頼一覧のITEM
     */
    protected IkenshoSakuseiIraiIchiranhyoReport(List<IkenshoSakuseiIraiIchiranhyoItem> item) {
        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<IkenshoSakuseiIraiIchiranhyoReportSource> reportSourceWriter) {
        for (IkenshoSakuseiIraiIchiranhyoItem itemList : item) {
            IkenshoSakuseiIraiIchiranhyoEditor editor = new IkenshoSakuseiIraiIchiranhyoHeadEditor(itemList);
            IkenshoSakuseiIraiIchiranhyoBuilder builder = new IkenshoSakuseiIraiIchiranhyoHeadBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
