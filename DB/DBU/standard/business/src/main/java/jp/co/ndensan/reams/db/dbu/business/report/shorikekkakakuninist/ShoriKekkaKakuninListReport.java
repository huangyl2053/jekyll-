/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.shorikekkakakuninist;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.report.shorikekkakakuninlist.ShoriKekkaKakuninListReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

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

        IShoriKekkaKakuninListEditor headerEditor = new ShoriKekkaKakuninListHeaderEditor(headItem);
        for (ShoriKekkaKakuninListBodyItem item : bodyItemList) {
            IShoriKekkaKakuninListEditor bodyEditor = new ShoriKekkaKakuninListBodyEditor(item);
            IShoriKekkaKakuninListBuidler builder = new ShoriKekkaKakuninListBuilder(headerEditor, bodyEditor);
            writer.writeLine(builder);
        }
    }

}
