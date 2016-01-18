/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaiichiranhyo.ChosaIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 認定調査依頼一覧表のReportです。
 */
public class ChosaIraiIchiranhyoReport extends Report<ChosaIraiIchiranhyoReportSource> {

    private final List<ChosaIraiIchiranhyoBodyItem> bodyItemList;
    private final ChosaIraiIchiranhyoHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 認定調査依頼一覧表ヘッダのITEM
     * @param itemList 認定調査依頼一覧表ボディのITEMリスト
     * @return 認定調査依頼一覧表のReport
     */
    public static ChosaIraiIchiranhyoReport createFrom(
            ChosaIraiIchiranhyoHeadItem headItem,
            @NonNull List<ChosaIraiIchiranhyoBodyItem> itemList) {

        return new ChosaIraiIchiranhyoReport(
                headItem,
                itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 認定調査依頼一覧表ヘッダのITEM
     * @param itemList 認定調査依頼一覧表のITEMリスト
     */
    protected ChosaIraiIchiranhyoReport(
            ChosaIraiIchiranhyoHeadItem headItem,
            List<ChosaIraiIchiranhyoBodyItem> itemList) {

        this.headItem = headItem;
        this.bodyItemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<ChosaIraiIchiranhyoReportSource> reportSourceWriter) {
        for (ChosaIraiIchiranhyoBodyItem bodyItem : bodyItemList) {
            IChosaIraiIchiranhyoEditor headerEditor = new ChosaIraiIchiranhyoHeaderEditor(headItem);
            IChosaIraiIchiranhyoEditor bodyEditor = new ChosaIraiIchiranhyoBodyEditor(bodyItem);
            IChosaIraiIchiranhyoBuilder builder = new ChosaIraiIchiranhyoBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
