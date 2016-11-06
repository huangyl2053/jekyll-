/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kaigokekkataishouichiran;

import jp.co.ndensan.reams.db.dbe.entity.report.source.KekkatsuchiTaishoshaIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定結果通知書対象者一覧表のReportです。
 *
 * @reamsid_L DBE-0190-020 lizhuoxuan
 */
public class KaigoKekkaTaishouIchiranReport extends Report<KekkatsuchiTaishoshaIchiranReportSource> {

    private final KaigoKekkaTaishouIchiranBodyItem bodyItem;
    private KaigoKekkaTaishouIchiranHeadItem headItem;
    private static final int GOKEIHANTEI = 50;
    private static final int ゼロ = 0;
    private static Integer index = 1;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 要介護認定結果通知書対象者一覧表ヘッダのITEM
     * @param bodyItem 要介護認定結果通知書対象者一覧表ボディのKaigoKekkaTaishouIchiranBodyItem
     * @return 要介護認定結果通知書対象者一覧表のReport
     */
    public static KaigoKekkaTaishouIchiranReport createFrom(
            KaigoKekkaTaishouIchiranHeadItem headItem,
            KaigoKekkaTaishouIchiranBodyItem bodyItem) {

        return new KaigoKekkaTaishouIchiranReport(
                headItem,
                bodyItem);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 要介護認定結果通知書対象者一覧表ヘッダのITEM
     * @param bodyItem 要介護認定結果通知書対象者一覧表のKaigoKekkaTaishouIchiranBodyItem
     */
    public KaigoKekkaTaishouIchiranReport(
            KaigoKekkaTaishouIchiranHeadItem headItem,
            KaigoKekkaTaishouIchiranBodyItem bodyItem) {

        this.headItem = headItem;
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<KekkatsuchiTaishoshaIchiranReportSource> reportSourceWriter) {

        if (ゼロ != headItem.getGokei() % GOKEIHANTEI) {
            headItem = KaigoKekkaTaishouIchiranHeadItem.creataKaigoKekkaTaishouIchiranHeadItem(
                    headItem.getShichosonName(), headItem.getChushutsuKikanFrom(),
                    headItem.getChushutsuKikanTo(), headItem.getPrintTimeStamp(), headItem.getGokei());
        } else {
            headItem = KaigoKekkaTaishouIchiranHeadItem.creataKaigoKekkaTaishouIchiranHeadItem(
                    headItem.getShichosonName(), headItem.getChushutsuKikanFrom(),
                    headItem.getChushutsuKikanTo(), headItem.getPrintTimeStamp(), null);
        }
        KaigoKekkaTaishouIchiranHeaderEditor headerEditor = new KaigoKekkaTaishouIchiranHeaderEditor(headItem);
        KaigoKekkaTaishouIchiranBodyEditor bodyEditor = new KaigoKekkaTaishouIchiranBodyEditor(bodyItem, new RString(index.toString()));
        IKaigoKekkaTaishouIchiranBuilder builder = new KaigoKekkaTaishouIchiranBuilderImpl(headerEditor, bodyEditor);
        reportSourceWriter.writeLine(builder);
        index++;
    }
}
