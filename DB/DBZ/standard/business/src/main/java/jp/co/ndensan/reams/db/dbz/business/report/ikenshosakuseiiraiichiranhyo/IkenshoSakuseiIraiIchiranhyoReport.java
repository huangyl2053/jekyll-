/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ikenshosakuseiiraiichiranhyo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoReportSource;
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
     * @param bodyItem 主治医意見書作成依頼一覧のリストITEM
     * @return 主治医意見書作成依頼一覧のReport
     */
    public static IkenshoSakuseiIraiIchiranhyoReport createFrom2(IkenshoSakuseiIraiIchiranhyoItem bodyItem) {
        List<IkenshoSakuseiIraiIchiranhyoItem> itemList = new ArrayList<>();
        itemList.add(bodyItem);
        return new IkenshoSakuseiIraiIchiranhyoReport(itemList);
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
        int pageCount = ZERO;
        Collections.sort(bodyItemList, new Comparator<IkenshoSakuseiIraiIchiranhyoItem>() {
            @Override
            public int compare(IkenshoSakuseiIraiIchiranhyoItem entity1, IkenshoSakuseiIraiIchiranhyoItem entity2) {
                if (entity1.getListIchiranhyo_2().compareTo(entity2.getListIchiranhyo_2()) == 0) {
                    return entity1.getListIchiranhyo_3().compareTo(entity2.getListIchiranhyo_3());
                } else {
                    return entity1.getListIchiranhyo_2().compareTo(entity2.getListIchiranhyo_2());
                }
            }
        });
        RString keyBreak1 = RString.EMPTY;
        RString keyBreak2 = RString.EMPTY;
        for (IkenshoSakuseiIraiIchiranhyoItem item : bodyItemList) {
            if (!keyBreak1.equals(item.getShichosonCode()) || !keyBreak2.equals(item.getShujiiIryokikanCode())) {
                index = ZERO;
                pageCount = ZERO;
            }
            index++;
            keyBreak1 = item.getShichosonCode();
            keyBreak2 = item.getShujiiIryokikanCode();
            if (index % 20 == 1) {
                pageCount++;
            }
            IkenshoSakuseiIraiIchiranhyoEditor bodyEditor = new IkenshoSakuseiIraiIchiranhyoBodyEditor(item, index, pageCount);
            IkenshoSakuseiIraiIchiranhyoBuilder builder = new IkenshoSakuseiIraiBuilderItem(bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
