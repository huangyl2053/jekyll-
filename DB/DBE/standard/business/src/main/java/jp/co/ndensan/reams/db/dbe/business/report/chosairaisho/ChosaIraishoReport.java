/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaisho;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaisho.ChosaIraishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 要介護認定調査依頼書のReportです。
 */
public class ChosaIraishoReport extends Report<ChosaIraishoReportSource> {

    private final ChosaIraishoHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 要介護認定調査依頼書ヘッダのITEM
     * @return 要介護認定調査依頼書のReport
     */
    public static ChosaIraishoReport createFrom(
            ChosaIraishoHeadItem headItem) {

        return new ChosaIraishoReport(
                headItem);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 要介護認定調査依頼書ヘッダのITEM
     */
    protected ChosaIraishoReport(
            ChosaIraishoHeadItem headItem) {

        this.headItem = headItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<ChosaIraishoReportSource> reportSourceWriter) {
        IChosaIraishoEditor headerEditor = new ChosaIraishoHeaderEditor(headItem);
        IChosaIraishoBuilder builder = new ChosaIraishoBuilderImpl(headerEditor);
        reportSourceWriter.writeLine(builder);
    }
}
