/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kaigokekkataishouichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.KekkatsuchiTaishoshaIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 要介護認定結果通知書対象者一覧表のReportです。
 */
public class KaigoKekkaTaishouIchiranReport extends Report<KekkatsuchiTaishoshaIchiranReportSource> {

    private final List<KaigoKekkaTaishouIchiranBodyItem> bodyItemList;
    private KaigoKekkaTaishouIchiranHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 要介護認定結果通知書対象者一覧表ヘッダのITEM
     * @param itemList 要介護認定結果通知書対象者一覧表ボディのITEMリスト
     * @return 要介護認定結果通知書対象者一覧表のReport
     */
    public static KaigoKekkaTaishouIchiranReport createFrom(
            KaigoKekkaTaishouIchiranHeadItem headItem,
            @NonNull List<KaigoKekkaTaishouIchiranBodyItem> itemList) {

        return new KaigoKekkaTaishouIchiranReport(
                headItem,
                itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 要介護認定結果通知書対象者一覧表ヘッダのITEM
     * @param itemList 要介護認定結果通知書対象者一覧表のITEMリスト
     */
    protected KaigoKekkaTaishouIchiranReport(
            KaigoKekkaTaishouIchiranHeadItem headItem,
            List<KaigoKekkaTaishouIchiranBodyItem> itemList) {

        this.headItem = headItem;
        this.bodyItemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<KekkatsuchiTaishoshaIchiranReportSource> reportSourceWriter) {
        Integer index = 1;
        Integer indexPage = bodyItemList.size() % 50 == 0 ? bodyItemList.size() / 50 : bodyItemList.size() / 50 + 1;
        for (KaigoKekkaTaishouIchiranBodyItem bodyItem : bodyItemList) {

            if (indexPage == reportSourceWriter.pageCount().value()) {
                headItem = KaigoKekkaTaishouIchiranHeadItem.creataKaigoKekkaTaishouIchiranHeadItem(
                        headItem.getShichosonName(), headItem.getChushutsuKikanFrom(), headItem.getChushutsuKikanTo(), headItem.getPrintTimeStamp(), bodyItemList.size());
            } else {
                headItem = KaigoKekkaTaishouIchiranHeadItem.creataKaigoKekkaTaishouIchiranHeadItem(
                        headItem.getShichosonName(), headItem.getChushutsuKikanFrom(), headItem.getChushutsuKikanTo(), headItem.getPrintTimeStamp(), null);

            }
            KaigoKekkaTaishouIchiranHeaderEditor headerEditor = new KaigoKekkaTaishouIchiranHeaderEditor(headItem);
            KaigoKekkaTaishouIchiranBodyEditor bodyEditor = new KaigoKekkaTaishouIchiranBodyEditor(bodyItem, new RString(index.toString()));
            KaigoKekkaTaishouIchiranBuilder builder = new KaigoKekkaTaishouIchiranBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
            index++;
        }
    }
}
