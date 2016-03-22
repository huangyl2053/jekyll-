/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.nenreitotatsuyoteishaichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.report.nenreitotatsuyoteishaichiranhyo.NenreitotatsuYoteishaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 年齢到達予定者一覧表のReportです。
 */
public class NenreitotatsuYoteishaIchiranhyoReport extends Report<NenreitotatsuYoteishaIchiranhyoReportSource> {

    private final List<NenreitotatsuYoteishaIchiranhyoBodyItem> bodyItemList;
    private final NenreitotatsuYoteishaIchiranhyoHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 年齢到達予定者一覧表ヘッダのITEM
     * @param itemList 年齢到達予定者一覧表ボディのITEMリスト
     * @return 年齢到達予定者一覧表のReport
     */
    public static NenreitotatsuYoteishaIchiranhyoReport createFrom(
            NenreitotatsuYoteishaIchiranhyoHeadItem headItem,
            @NonNull List<NenreitotatsuYoteishaIchiranhyoBodyItem> itemList) {

        return new NenreitotatsuYoteishaIchiranhyoReport(
                headItem,
                itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 年齢到達予定者一覧表ヘッダのITEM
     * @param itemList 年齢到達予定者一覧表のITEMリスト
     */
    protected NenreitotatsuYoteishaIchiranhyoReport(
            NenreitotatsuYoteishaIchiranhyoHeadItem headItem,
            List<NenreitotatsuYoteishaIchiranhyoBodyItem> itemList) {
        this.headItem = headItem;
        this.bodyItemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<NenreitotatsuYoteishaIchiranhyoReportSource> reportSourceWriter) {
        for (NenreitotatsuYoteishaIchiranhyoBodyItem bodyItem : bodyItemList) {
            NenreitotatsuYoteishaIchiranhyoHeaderEditor headerEditor = new NenreitotatsuYoteishaIchiranhyoHeaderEditor(headItem);
            NenreitotatsuYoteishaIchiranhyoBodyEditor bodyEditor = new NenreitotatsuYoteishaIchiranhyoBodyEditor(bodyItem);
            INenreitotatsuYoteishaIchiranhyoBuilder builder = new NenreitotatsuYoteishaIchiranhyoBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
