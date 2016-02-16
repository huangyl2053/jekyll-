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
 * 境界層管理マスタリストのReportです。
 */
public class TsukibetsuSuiihyoReport extends Report<TsukibetsuSuiihyoReportSource> {

    private final TsukibetsuSuiihyoHeaderItem headItem;
    private final List<TsukibetsuSuiihyoBodyItem> bodyItemList;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 境界層管理マスタリストヘッダのITEM
     * @param itemList 境界層管理マスタリストボディのITEMリスト
     * @return 境界層管理マスタリストのReport
     */
    public static TsukibetsuSuiihyoReport createFrom(
            TsukibetsuSuiihyoHeaderItem headItem,
            @NonNull List<TsukibetsuSuiihyoBodyItem> itemList) {

        return new TsukibetsuSuiihyoReport(
                headItem,
                itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 境界層管理マスタリストヘッダのITEM
     * @param itemList 境界層管理マスタリストのITEMリスト
     */
    protected TsukibetsuSuiihyoReport(
            TsukibetsuSuiihyoHeaderItem headItem,
            List<TsukibetsuSuiihyoBodyItem> itemList) {
        this.headItem = headItem;
        this.bodyItemList = itemList;
    }

    /**
     *
     * @param reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<TsukibetsuSuiihyoReportSource> reportSourceWriter) {
        if (bodyItemList != null || !bodyItemList.isEmpty()) {
            for (int i = 0; i < bodyItemList.size(); i++) {
//                TsukibetsuSuiihyoBodyItem bodyItem = new KyokaisoKanriMasterListBodyTempItem();
//                tempItem.setListUpper_1(item.getListUpper_1().get(i));
//                tempItem.setListUpper_2(item.getListUpper_2().get(i));
//                tempItem.setListUpper_3(item.getListUpper_3().get(i));
//                tempItem.setListUpper_4(item.getListUpper_4().get(i));
//                tempItem.setListUpper_5(item.getListUpper_5().get(i));
//                tempItem.setListUpper_6(item.getListUpper_6().get(i));
//                tempItem.setListUpper_7(item.getListUpper_7().get(i));
//                tempItem.setListUpper_8(item.getListUpper_8().get(i));
//                tempItem.setListUpper_9(item.getListUpper_9().get(i));
//                tempItem.setListLower_1(item.getListLower_1().get(i));
//                tempItem.setListLower_2(item.getListLower_2().get(i));
//                tempItem.setListLower_3(item.getListLower_3().get(i));
//                tempItem.setListLower_4(item.getListLower_4().get(i));
//                tempItem.setListLower_5(item.getListLower_5().get(i));
//                tempItem.setListLower_6(item.getListLower_6().get(i));
//                tempItem.setListLower_7(item.getListLower_7().get(i));
//                tempItem.setListLower_8(item.getListLower_8().get(i));
//                tempItem.setListLower_9(item.getListLower_9().get(i));
//                tempItem.setListLower_10(item.getListLower_10().get(i));
                TsukibetsuSuiihyoHeaderEditorImpl headerEditor = new TsukibetsuSuiihyoHeaderEditorImpl(headItem);
                TsukibetsuSuiihyoBodyEditorImpl bodyEditor = new TsukibetsuSuiihyoBodyEditorImpl(bodyItemList.get(i));
                ITsukibetsuSuiihyoBuilder builder = new TsukibetsuSuiihyoBuilderImpl(headerEditor, bodyEditor);
                reportSourceWriter.writeLine(builder);
            }
        }
    }
}
