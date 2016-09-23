/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlist;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.report.kyokaisokanrimasterlist.KyokaisoKanriMasterListReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 境界層管理マスタリストのReportです。
 *
 * @reamsid_L DBU-1050-060 linghuhang
 */
public class KyokaisoKanriMasterListReport extends Report<KyokaisoKanriMasterListReportSource> {

    private final List<KyokaisoKanriMasterListBodyItem> bodyItemList;
    private final KyokaisoKanriMasterListHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 境界層管理マスタリストヘッダのITEM
     * @param itemList 境界層管理マスタリストボディのITEMリスト
     * @return 境界層管理マスタリストのReport
     */
    public static KyokaisoKanriMasterListReport createFrom(
            KyokaisoKanriMasterListHeadItem headItem,
            @NonNull List<KyokaisoKanriMasterListBodyItem> itemList) {

        return new KyokaisoKanriMasterListReport(
                headItem,
                itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 境界層管理マスタリストヘッダのITEM
     * @param itemList 境界層管理マスタリストのITEMリスト
     */
    protected KyokaisoKanriMasterListReport(
            KyokaisoKanriMasterListHeadItem headItem,
            List<KyokaisoKanriMasterListBodyItem> itemList) {
        this.headItem = headItem;
        this.bodyItemList = itemList;
    }

    /**
     *
     * @param reportSourceWriter reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<KyokaisoKanriMasterListReportSource> reportSourceWriter) {
        for (KyokaisoKanriMasterListBodyItem item : bodyItemList) {
            for (int i = 0; i < item.getListUpper_1().size(); i++) {
                KyokaisoKanriMasterListBodyTempItem tempItem = new KyokaisoKanriMasterListBodyTempItem();
                tempItem.setListUpper_1(item.getListUpper_1().get(i));
                tempItem.setListUpper_2(item.getListUpper_2().get(i));
                tempItem.setListUpper_3(item.getListUpper_3().get(i));
                tempItem.setListUpper_4(item.getListUpper_4().get(i));
                tempItem.setListUpper_5(item.getListUpper_5().get(i));
                tempItem.setListUpper_6(item.getListUpper_6().get(i));
                tempItem.setListUpper_7(item.getListUpper_7().get(i));
                tempItem.setListUpper_8(item.getListUpper_8().get(i));
                tempItem.setListUpper_9(item.getListUpper_9().get(i));
                tempItem.setListLower_1(item.getListLower_1().get(i));
                tempItem.setListLower_2(item.getListLower_2().get(i));
                tempItem.setListLower_3(item.getListLower_3().get(i));
                tempItem.setListLower_4(item.getListLower_4().get(i));
                tempItem.setListLower_5(item.getListLower_5().get(i));
                tempItem.setListLower_6(item.getListLower_6().get(i));
                tempItem.setListLower_7(item.getListLower_7().get(i));
                tempItem.setListLower_8(item.getListLower_8().get(i));
                tempItem.setListLower_9(item.getListLower_9().get(i));
                tempItem.setListLower_10(item.getListLower_10().get(i));
                IKyokaisoKanriMasterListEditor headerEditor = new KyokaisoKanriMasterListHeaderEditor(headItem);
                IKyokaisoKanriMasterListEditor bodyEditor = new KyokaisoKanriMasterListBodyEditor(tempItem);
                IKyokaisoKanriMasterListBuilder builder = new KyokaisoKanriMasterListBuilderImpl(headerEditor, bodyEditor);
                reportSourceWriter.writeLine(builder);
            }
        }
        if (bodyItemList.isEmpty()) {
            KyokaisoKanriMasterListBodyTempItem tempItem = new KyokaisoKanriMasterListBodyTempItem();
            IKyokaisoKanriMasterListEditor headerEditor = new KyokaisoKanriMasterListHeaderEditor(headItem);
            IKyokaisoKanriMasterListEditor bodyEditor = new KyokaisoKanriMasterListBodyEditor(tempItem);
            IKyokaisoKanriMasterListBuilder builder = new KyokaisoKanriMasterListBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
