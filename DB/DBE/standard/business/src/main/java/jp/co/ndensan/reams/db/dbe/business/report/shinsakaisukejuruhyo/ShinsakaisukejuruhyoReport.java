/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaisukejuruhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaisukejuruhyo.ShinsakaisukejuruhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 介護認定審査会スケジュール表のReportです。
 *
 * @reamsid_L DBE-0130-070 yaodongsheng
 */
public class ShinsakaisukejuruhyoReport extends Report<ShinsakaisukejuruhyoReportSource> {

    private final List<ShinsakaisukejuruhyoBodyItem> bodyItemList;
    private final ShinsakaisukejuruhyoBodyItem bodyItem;
    private final ShinsakaisukejuruhyoHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 介護認定審査会スケジュール表ヘッダのITEM
     * @param item item
     * @return 介護認定審査会スケジュール表のReport
     */
    public static ShinsakaisukejuruhyoReport createFrom(
            ShinsakaisukejuruhyoHeadItem headItem,
            ShinsakaisukejuruhyoBodyItem item) {

        return new ShinsakaisukejuruhyoReport(
                headItem,
                item,
                null);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 介護認定審査会スケジュール表ヘッダのITEM
     * @param itemList 介護認定審査会スケジュール表ボディのITEMリスト
     * @return 介護認定審査会スケジュール表のReport
     */
    public static ShinsakaisukejuruhyoReport createFrom(
            ShinsakaisukejuruhyoHeadItem headItem,
            @NonNull List<ShinsakaisukejuruhyoBodyItem> itemList) {

        return new ShinsakaisukejuruhyoReport(
                headItem,
                null,
                itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 介護認定審査会スケジュール表ヘッダのITEM
     * @param bodyItem bodyItem
     * @param itemList 介護認定審査会スケジュール表のITEMリスト
     */
    protected ShinsakaisukejuruhyoReport(
            ShinsakaisukejuruhyoHeadItem headItem,
            ShinsakaisukejuruhyoBodyItem bodyItem,
            List<ShinsakaisukejuruhyoBodyItem> itemList) {

        this.headItem = headItem;
        this.bodyItem = bodyItem;
        this.bodyItemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShinsakaisukejuruhyoReportSource> reportSourceWriter) {
        if (bodyItemList != null && !bodyItemList.isEmpty()) {
            int renban = 0;
            ShinsakaisukejuruhyoHeaderEditor headerEditor = new ShinsakaisukejuruhyoHeaderEditor(headItem);
            for (ShinsakaisukejuruhyoBodyItem item : bodyItemList) {
                renban++;
                item.set項番(renban);
                ShinsakaisukejuruhyoBodyEditor bodyEditor = new ShinsakaisukejuruhyoBodyEditor(item);
                IShinsakaisukejuruhyoBuilder builder = new ShinsakaisukejuruhyoBuilderImpl(headerEditor, bodyEditor);
                reportSourceWriter.writeLine(builder);
            }
        } else {
            ShinsakaisukejuruhyoHeaderEditor headerEditor = new ShinsakaisukejuruhyoHeaderEditor(headItem);
            ShinsakaisukejuruhyoBodyEditor bodyEditor = new ShinsakaisukejuruhyoBodyEditor(bodyItem);
            IShinsakaisukejuruhyoBuilder builder = new ShinsakaisukejuruhyoBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
