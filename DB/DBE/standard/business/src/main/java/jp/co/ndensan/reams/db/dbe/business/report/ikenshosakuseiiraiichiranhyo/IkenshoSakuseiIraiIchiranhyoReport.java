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

    private final IkenshoSakuseiIraiIchiranhyoHeadItem headItem;
    private final List<IkenshoSakuseiIraiIchiranhyoBodyItem> bodyItemList;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 主治医意見書作成依頼一覧のITEM
     * @param bodyItemList 主治医意見書作成依頼一覧のリストITEM
     * @return 主治医意見書作成依頼一覧のReport
     */
    public static IkenshoSakuseiIraiIchiranhyoReport createFrom(IkenshoSakuseiIraiIchiranhyoHeadItem headItem,
            List<IkenshoSakuseiIraiIchiranhyoBodyItem> bodyItemList) {
        return new IkenshoSakuseiIraiIchiranhyoReport(headItem, bodyItemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 主治医意見書作成依頼一覧のITEM
     * @param bodyItemList 主治医意見書作成依頼一覧のリストITEM
     */
    protected IkenshoSakuseiIraiIchiranhyoReport(IkenshoSakuseiIraiIchiranhyoHeadItem headItem,
            List<IkenshoSakuseiIraiIchiranhyoBodyItem> bodyItemList) {
        this.headItem = headItem;
        this.bodyItemList = bodyItemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<IkenshoSakuseiIraiIchiranhyoReportSource> reportSourceWriter) {
        int index = 1;
        for (IkenshoSakuseiIraiIchiranhyoBodyItem item : bodyItemList) {
            IkenshoSakuseiIraiIchiranhyoEditor headEditor = new IkenshoSakuseiIraiIchiranhyoHeadEditor(headItem);
            IkenshoSakuseiIraiIchiranhyoEditor bodyEditor = new IkenshoSakuseiIraiIchiranhyoBodyEditor(item, index);
            IkenshoSakuseiIraiIchiranhyoBuilder builder = new IkenshoSakuseiIraiBuilderItem(headEditor, bodyEditor);
            index++;
            reportSourceWriter.writeLine(builder);
        }
    }
}
