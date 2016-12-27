/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.kaigohokenshindanmeireisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoItem;
import jp.co.ndensan.reams.db.dbz.business.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoReport;
import jp.co.ndensan.reams.db.dbz.entity.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護保険診断命令書のReportです。
 *
 * @reamsid_L DBE-0080-070 wangxiaodong
 */
public class KaigohokenShindanMeireishoReport extends Report<KaigohokenShindanMeireishoReportSource> {

    private final List<KaigohokenShindanMeireishoHeaderItem> headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 介護保険診断命令書ヘッダのITEM
     * @return 介護保険診断命令書のReport
     */
    public static KaigohokenShindanMeireishoReport createFrom(
            List<KaigohokenShindanMeireishoHeaderItem> headItem) {

        return new KaigohokenShindanMeireishoReport(headItem);
    }
    
        /**
     * インスタンスを生成します。
     *
     * @param headItem 介護保険診断命令書ヘッダのITEM
     * @return 介護保険診断命令書のReport
     */
    public static KaigohokenShindanMeireishoReport createFrom2(
            KaigohokenShindanMeireishoHeaderItem headItem) {
        List<KaigohokenShindanMeireishoHeaderItem> itemList = new ArrayList<>();
        itemList.add(headItem);
        return new KaigohokenShindanMeireishoReport(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 介護保険診断命令書ヘッダのITEM
     */
    protected KaigohokenShindanMeireishoReport(
            List<KaigohokenShindanMeireishoHeaderItem> headItem) {
        this.headItem = headItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<KaigohokenShindanMeireishoReportSource> reportSourceWriter) {
        for (KaigohokenShindanMeireishoHeaderItem item : headItem) {
            IKaigohokenShindanMeireishoEditor headerEditor = new KaigohokenShindanMeireishoHeaderEditor(item);
            IKaigohokenShindanMeireishoBuider buider = new KaigohokenShindanMeireishoBuiderImpl(headerEditor);
            reportSourceWriter.writeLine(buider);
        }
    }
}
