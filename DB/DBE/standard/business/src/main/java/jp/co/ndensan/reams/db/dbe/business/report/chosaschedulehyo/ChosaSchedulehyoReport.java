/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.chosaschedulehyo.ChosaSchedulehyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 認定調査スケジュール表(事務所)のReportです。
 */
public class ChosaSchedulehyoReport extends Report<ChosaSchedulehyoReportSource> {

    private final List<ChosaSchedulehyoBodyItem> bodyItemList;
    private final ChosaSchedulehyoHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 認定調査スケジュール表(事務所)ヘッダのITEM
     * @param itemList 認定調査スケジュール表(事務所)ボディのITEMリスト
     * @return 認定調査スケジュール表(事務所)のReport
     */
    public static ChosaSchedulehyoReport createFrom(
            ChosaSchedulehyoHeadItem headItem,
            @NonNull List<ChosaSchedulehyoBodyItem> itemList) {

        return new ChosaSchedulehyoReport(
                headItem,
                itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 認定調査スケジュール表(事務所)ヘッダのITEM
     * @param itemList 認定調査スケジュール表(事務所)のITEMリスト
     */
    protected ChosaSchedulehyoReport(
            ChosaSchedulehyoHeadItem headItem,
            List<ChosaSchedulehyoBodyItem> itemList) {

        this.headItem = headItem;
        this.bodyItemList = itemList;
    }

    /**
     *
     * @param reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<ChosaSchedulehyoReportSource> reportSourceWriter) {
        for (ChosaSchedulehyoBodyItem bodyItem : bodyItemList) {
            ChosaSchedulehyoEditor headerEditor = new ChosaSchedulehyoHeaderEditor(headItem);
            ChosaSchedulehyoEditor bodyEditor = new ChosaSchedulehyoBodyEditor(bodyItem);
            ChosaSchedulehyoBuilder builder = new ChosaSchedulehyoBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
