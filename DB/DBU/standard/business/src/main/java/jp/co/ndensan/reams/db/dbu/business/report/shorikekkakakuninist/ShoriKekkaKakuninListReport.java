/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.shorikekkakakuninist;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.shorikekkakakuninlist.ShoriKekkaKakuninListEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.shorikekkakakuninlist.ShoriKekkaKakuninListReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 処理確認リストのレポートです。
 *
 * @reamsid_L DBU-5590-040 wanghuafeng
 */
public class ShoriKekkaKakuninListReport extends Report<ShoriKekkaKakuninListReportSource> {

    private final List<ShoriKekkaKakuninListBodyItem> bodyItemList;
    private final ShoriKekkaKakuninListHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 処理確認リストヘッダのITEM
     * @param itemList 処理確認リストボディのITEMリスト
     * @return 処理確認リストのReport
     */
    public static ShoriKekkaKakuninListReport createFrom(
            ShoriKekkaKakuninListHeadItem headItem,
            @NonNull List<ShoriKekkaKakuninListBodyItem> itemList) {

        return new ShoriKekkaKakuninListReport(
                headItem,
                itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 処理確認リストヘッダのITEM
     * @param itemList 処理確認リストのITEMリスト
     */
    public ShoriKekkaKakuninListReport(
            ShoriKekkaKakuninListHeadItem headItem,
            List<ShoriKekkaKakuninListBodyItem> itemList) {
        this.headItem = headItem;
        this.bodyItemList = itemList;
    }

    /**
     * 処理確認リストのwriteBy
     *
     * @param writer writer
     */
    @Override
    public void writeBy(ReportSourceWriter<ShoriKekkaKakuninListReportSource> writer) {

        if (bodyItemList != null && !bodyItemList.isEmpty()) {
            for (ShoriKekkaKakuninListBodyItem item : bodyItemList) {
                for (int i = 0; i < item.getListUpper_1().size(); i++) {
                    ShoriKekkaKakuninListEntity tempItem = new ShoriKekkaKakuninListEntity();
                    tempItem.setプログラムID(item.getListUpper_1().get(i));
                    tempItem.set項目値1(item.getListUpper_2().get(i));
                    tempItem.set項目値2(item.getListUpper_3().get(i));
                    tempItem.set項目値3(item.getListUpper_4().get(i));
                    tempItem.set項目値4(item.getListUpper_5().get(i));
                    tempItem.set項目値5(item.getListUpper_6().get(i));
                    tempItem.set内容1(item.getListUpper_7().get(i));
                    tempItem.set処理名称(item.getListLower_1().get(i));
                    tempItem.set内容2(item.getListLower_2().get(i));
                    IShoriKekkaKakuninListEditor headerEditor = new ShoriKekkaKakuninListHeaderEditor(headItem);
                    IShoriKekkaKakuninListEditor bodyEditor = new ShoriKekkaKakuninListBodyEditor(tempItem);
                    IShoriKekkaKakuninListBuidler builder = new ShoriKekkaKakuninListBuilder(headerEditor, bodyEditor);
                    writer.writeLine(builder);
                }
            }

        }
    }

}
