/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.shujiiikenshosakusei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 主治医意見書作成料請求書のReportです。
 *
 * @reamsid_L DBE-0050-040 sunhaidi
 */
public class ShujiiIkenshoSakuseiRyoSeikyushoReport extends Report<ShujiiIkenshoSakuseiRyoSeikyushoReportSource> {

    private final List<ShujiiIkenshoSakuseiRyoSeikyushoItem> items;

    /**
     * インスタンスを生成します。
     *
     * @param item 主治医意見書作成料請求書のITEM
     * @return 主治医意見書作成料請求書のReport
     */
    public static ShujiiIkenshoSakuseiRyoSeikyushoReport createFrom(ShujiiIkenshoSakuseiRyoSeikyushoItem item) {
        List<ShujiiIkenshoSakuseiRyoSeikyushoItem> itemList = new ArrayList<>();
        itemList.add(item);
        return new ShujiiIkenshoSakuseiRyoSeikyushoReport(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param items 主治医意見書作成料請求書のITEM
     * @return 主治医意見書作成料請求書のReport
     */
    public static ShujiiIkenshoSakuseiRyoSeikyushoReport createFrom(List<ShujiiIkenshoSakuseiRyoSeikyushoItem> items) {
        return new ShujiiIkenshoSakuseiRyoSeikyushoReport(items);
    }

    /**
     * インスタンスを生成します。
     *
     * @param items 主治医意見書作成料請求書のITEM
     */
    protected ShujiiIkenshoSakuseiRyoSeikyushoReport(List<ShujiiIkenshoSakuseiRyoSeikyushoItem> items) {
        this.items = items;
    }

    /**
     *
     * @param reportSourceWriter 主治医意見書作成料請求書Sourceクラス
     */
    @Override
    public void writeBy(ReportSourceWriter<ShujiiIkenshoSakuseiRyoSeikyushoReportSource> reportSourceWriter) {
        for (ShujiiIkenshoSakuseiRyoSeikyushoItem item : items) {
            IShujiiIkenshoSakuseiRyoSeikyushoEditor editor = new ShujiiIkenshoSakuseiRyoSeikyushoEditor(item);
            IShujiiIkenshoSakuseiRyoSeikyushoBuilder builder = new ShujiiIkenshoSakuseiRyoSeikyushoBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
