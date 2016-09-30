/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.chosairaisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.report.chosairaisho.ChosaIraishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定調査依頼書のReportです。
 *
 * @reamsid_L DBE-0010-020 lishengli
 */
public class ChosaIraishoReport extends Report<ChosaIraishoReportSource> {

    private final List<ChosaIraishoHeadItem> headItemList;

    /**
     * インスタンスを生成します。
     *
     * @param headItemList 要介護認定調査依頼書ヘッダのITEMLIST
     * @return 要介護認定調査依頼書のReport
     */
    public static ChosaIraishoReport createFrom(List<ChosaIraishoHeadItem> headItemList) {

        return new ChosaIraishoReport(headItemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItemList 要介護認定調査依頼書ヘッダのITEMLIST
     */
    protected ChosaIraishoReport(List<ChosaIraishoHeadItem> headItemList) {

        this.headItemList = headItemList;
    }

    /**
     *
     * @param reportSourceWriter 要介護認定調査依頼書Sourceクラス
     */
    @Override
    public void writeBy(ReportSourceWriter<ChosaIraishoReportSource> reportSourceWriter) {
        for (ChosaIraishoHeadItem headItem : headItemList) {
            IChosaIraishoEditor headerEditor = new ChosaIraishoHeaderEditor(headItem);
            IChosaIraishoBuilder builder = new ChosaIraishoBuilderImpl(headerEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
