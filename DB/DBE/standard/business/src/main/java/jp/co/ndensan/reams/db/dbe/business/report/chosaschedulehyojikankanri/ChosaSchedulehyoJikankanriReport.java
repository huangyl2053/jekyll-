/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyojikankanri;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosaschedulehyojikankanri.ChosaSchedulehyoJikankanriReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 認定調査スケジュール表(時間管理)のReportです。
 */
public class ChosaSchedulehyoJikankanriReport extends Report<ChosaSchedulehyoJikankanriReportSource> {

    private final List<ChosaSchedulehyoJikankanriBodyItem> bodyItemList;
    private final ChosaSchedulehyoJikankanriHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 認定調査スケジュール表(時間管理)ヘッダのITEM
     * @param itemList 認定調査スケジュール表(時間管理)ボディのITEMリスト
     * @return 認定調査スケジュール表(時間管理)のReport
     */
    public static ChosaSchedulehyoJikankanriReport createFrom(
            ChosaSchedulehyoJikankanriHeadItem headItem,
            @NonNull List<ChosaSchedulehyoJikankanriBodyItem> itemList) {

        return new ChosaSchedulehyoJikankanriReport(
                headItem,
                itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 認定調査スケジュール表(時間管理)ヘッダのITEM
     * @param itemList 認定調査スケジュール表(時間管理)のITEMリスト
     */
    protected ChosaSchedulehyoJikankanriReport(
            ChosaSchedulehyoJikankanriHeadItem headItem,
            List<ChosaSchedulehyoJikankanriBodyItem> itemList) {

        this.headItem = headItem;
        this.bodyItemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<ChosaSchedulehyoJikankanriReportSource> reportSourceWriter) {
        for (ChosaSchedulehyoJikankanriBodyItem bodyItem : bodyItemList) {
            IChosaSchedulehyoJikankanriEditor headerEditor = new ChosaSchedulehyoJikankanriHeaderEditor(headItem);
            IChosaSchedulehyoJikankanriEditor bodyEditor = new ChosaSchedulehyoJikankanriBodyEditor(bodyItem);
            IChosaSchedulehyoJikankanriBuilder builder = new ChosaSchedulehyoJikankanriBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
