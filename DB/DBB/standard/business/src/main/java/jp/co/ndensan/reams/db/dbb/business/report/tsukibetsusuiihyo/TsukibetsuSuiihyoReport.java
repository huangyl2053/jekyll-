/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.source.tsukibetsusuiihyo.TsukibetsuSuiihyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 月別推移表のReportです。
 */
public class TsukibetsuSuiihyoReport extends Report<TsukibetsuSuiihyoReportSource> {

    private final TsukibetsuSuiihyoHeaderItem headItem;
    private final List<TsukibetsuSuiihyoBodyTitleItem> bodyTitleItem;
    private final List<TsukibetsuSuiihyoBodyItem> bodyItemList;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 月別推移表ヘッダのITEM
     * @param bodyTitleItem 月別推移表ヘッダのITEM
     * @param bodyItemList 月別推移表ボディのITEMリスト
     * @return 月別推移表のReport
     */
    public static TsukibetsuSuiihyoReport createFrom(
            TsukibetsuSuiihyoHeaderItem headItem,
            @NonNull List<TsukibetsuSuiihyoBodyTitleItem> bodyTitleItem,
            @NonNull List<TsukibetsuSuiihyoBodyItem> bodyItemList) {

        return new TsukibetsuSuiihyoReport(
                headItem,
                bodyTitleItem,
                bodyItemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 月別推移表ヘッダのITEM
     * @param bodyTitleItem 月別推移表ヘッダのITEM
     * @param bodyItemList 月別推移表ボディのITEMリスト
     */
    protected TsukibetsuSuiihyoReport(
            TsukibetsuSuiihyoHeaderItem headItem,
            List<TsukibetsuSuiihyoBodyTitleItem> bodyTitleItem,
            List<TsukibetsuSuiihyoBodyItem> bodyItemList) {
        this.headItem = headItem;
        this.bodyTitleItem = bodyTitleItem;
        this.bodyItemList = bodyItemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<TsukibetsuSuiihyoReportSource> reportSourceWriter) {
        if (bodyItemList != null || !bodyItemList.isEmpty()) {
            TsukibetsuSuiihyoHeaderEditorImpl headerEditor = new TsukibetsuSuiihyoHeaderEditorImpl(headItem);
            for (int i = 1; i <= 20; i++) {
                TsukibetsuSuiihyoBodyItem item = bodyItemList.get(i - 1);
                TsukibetsuSuiihyoBodyEditorImpl bodyEditor = new TsukibetsuSuiihyoBodyEditorImpl(item);
                TsukibetsuSuiihyoBodyTitleEditorImpl bodyTitleEditor = new TsukibetsuSuiihyoBodyTitleEditorImpl(bodyTitleItem.get(i - 1));
                if (i % 21 == 0) {
                    bodyTitleEditor = null;
                }
                ITsukibetsuSuiihyoBuilder builder = new TsukibetsuSuiihyoBuilderImpl(headerEditor, bodyTitleEditor, bodyEditor);
                reportSourceWriter.writeLine(builder);
            }
        }
    }
}
