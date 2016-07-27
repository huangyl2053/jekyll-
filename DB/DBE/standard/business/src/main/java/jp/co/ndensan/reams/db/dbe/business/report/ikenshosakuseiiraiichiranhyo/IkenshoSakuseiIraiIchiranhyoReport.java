/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書作成依頼一覧のReportです。
 *
 * @reamsid_L DBE-0080-090 zhangzhiming
 */
public class IkenshoSakuseiIraiIchiranhyoReport extends Report<IkenshoSakuseiIraiIchiranhyoReportSource> {

    private final List<IkenshoSakuseiIraiIchiranhyoItem> bodyItemList;
    private static final int ZERO = 0;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItemList 主治医意見書作成依頼一覧のリストITEM
     * @return 主治医意見書作成依頼一覧のReport
     */
    public static IkenshoSakuseiIraiIchiranhyoReport createFrom(List<IkenshoSakuseiIraiIchiranhyoItem> bodyItemList) {
        return new IkenshoSakuseiIraiIchiranhyoReport(bodyItemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param bodyItemList 主治医意見書作成依頼一覧のリストITEM
     */
    protected IkenshoSakuseiIraiIchiranhyoReport(List<IkenshoSakuseiIraiIchiranhyoItem> bodyItemList) {
        this.bodyItemList = bodyItemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<IkenshoSakuseiIraiIchiranhyoReportSource> reportSourceWriter) {
        int index = ZERO;
        RString keyBreak = RString.EMPTY;
        for (IkenshoSakuseiIraiIchiranhyoItem item : bodyItemList) {
            if (!keyBreak.equals(item.getShujiiIryokikanCode())) {
                index = ZERO;
            }
            index++;
            keyBreak = item.getShujiiIryokikanCode();
            IkenshoSakuseiIraiIchiranhyoEditor bodyEditor = new IkenshoSakuseiIraiIchiranhyoBodyEditor(item, index);
            IkenshoSakuseiIraiIchiranhyoBuilder builder = new IkenshoSakuseiIraiBuilderItem(bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
