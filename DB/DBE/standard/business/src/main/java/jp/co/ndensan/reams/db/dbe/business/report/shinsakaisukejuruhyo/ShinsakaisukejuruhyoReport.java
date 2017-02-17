/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaisukejuruhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaisukejuruhyo.ShinsakaisukejuruhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    private final List<RString> 審査会委員コードリスト;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 介護認定審査会スケジュール表ヘッダのITEM
     * @param item item
     * @param 審査会委員コードリスト List<RString>
     * @return 介護認定審査会スケジュール表のReport
     */
    public static ShinsakaisukejuruhyoReport createFrom(
            ShinsakaisukejuruhyoHeadItem headItem,
            ShinsakaisukejuruhyoBodyItem item,
            List<RString> 審査会委員コードリスト) {

        return new ShinsakaisukejuruhyoReport(
                headItem,
                item,
                null,
                審査会委員コードリスト);
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
                itemList,
                null);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 介護認定審査会スケジュール表ヘッダのITEM
     * @param bodyItem bodyItem
     * @param 審査会委員コードリスト List<RString>
     * @param itemList 介護認定審査会スケジュール表のITEMリスト
     */
    protected ShinsakaisukejuruhyoReport(
            ShinsakaisukejuruhyoHeadItem headItem,
            ShinsakaisukejuruhyoBodyItem bodyItem,
            List<ShinsakaisukejuruhyoBodyItem> itemList,
            List<RString> 審査会委員コードリスト) {

        this.headItem = headItem;
        this.bodyItem = bodyItem;
        this.bodyItemList = itemList;
        this.審査会委員コードリスト = 審査会委員コードリスト;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShinsakaisukejuruhyoReportSource> reportSourceWriter) {
        if (bodyItemList != null && !bodyItemList.isEmpty()) {
            for (RString 審査会委員コード : 審査会委員コードリスト) {
                int renban = 0;
                ShinsakaisukejuruhyoHeaderEditor headerEditor = new ShinsakaisukejuruhyoHeaderEditor(headItem);
                printBodyItemList(renban, headerEditor, reportSourceWriter);
            }
        } else {
            ShinsakaisukejuruhyoHeaderEditor headerEditor = new ShinsakaisukejuruhyoHeaderEditor(headItem);
            ShinsakaisukejuruhyoBodyEditor bodyEditor = new ShinsakaisukejuruhyoBodyEditor(bodyItem);
            IShinsakaisukejuruhyoBuilder builder = new ShinsakaisukejuruhyoBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private void printBodyItemList(int renban, ShinsakaisukejuruhyoHeaderEditor headerEditor, ReportSourceWriter<ShinsakaisukejuruhyoReportSource> reportSourceWriter) {
        for (ShinsakaisukejuruhyoBodyItem item : bodyItemList) {
            renban++;
            item.set項番(renban);
            ShinsakaisukejuruhyoBodyEditor bodyEditor = new ShinsakaisukejuruhyoBodyEditor(item);
            IShinsakaisukejuruhyoBuilder builder = new ShinsakaisukejuruhyoBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
