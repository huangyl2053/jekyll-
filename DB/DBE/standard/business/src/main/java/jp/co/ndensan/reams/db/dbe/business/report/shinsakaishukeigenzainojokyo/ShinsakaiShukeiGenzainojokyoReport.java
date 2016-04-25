/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeigenzainojokyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 介護認定審査会集計表（現在の状況別）のReportです。
 *
 * @reamsid_L DBE-1450-090 duanzhanli
 */
public class ShinsakaiShukeiGenzainojokyoReport extends Report<ShinsakaiShukeiGenzainojokyoReportSource> {

    private final List<ShinsakaiShukeiGenzainojokyoItem> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemlist 介護認定審査会集計表（現在の状況別）のitemlist
     * @return 介護認定審査会集計表（現在の状況別）のReport
     */
    public static ShinsakaiShukeiGenzainojokyoReport createFrom(@NonNull List<ShinsakaiShukeiGenzainojokyoItem> itemlist) {
        return new ShinsakaiShukeiGenzainojokyoReport(itemlist);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemlist 介護認定審査会集計表（現在の状況別）のitemlist
     */
    protected ShinsakaiShukeiGenzainojokyoReport(List<ShinsakaiShukeiGenzainojokyoItem> itemlist) {
        this.itemList = itemlist;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShinsakaiShukeiGenzainojokyoReportSource> reportSourceWriter) {
        for (ShinsakaiShukeiGenzainojokyoItem item : itemList) {
            IShinsakaiShukeiGenzainojokyoEditor editor = new ShinsakaiShukeiGenzainojokyoEditor(item);
            IShinsakaiShukeiGenzainojokyoBuilder builder = new ShinsakaiShukeiGenzainojokyoBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
