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
    private final ChosaIraishoHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItemList 要介護認定調査依頼書ヘッダのITEMLIST
     * @return 要介護認定調査依頼書のReport
     */
    public static ChosaIraishoReport createFrom(List<ChosaIraishoHeadItem> headItemList) {

        return new ChosaIraishoReport(headItemList, null);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 要介護認定調査依頼書ヘッダのITEM
     * @return 要介護認定調査依頼書のReport
     */
    public static ChosaIraishoReport createFrom(ChosaIraishoHeadItem headItem) {
        return new ChosaIraishoReport(null, headItem);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItemList 要介護認定調査依頼書ヘッダのITEMLIST
     * @param headItem 要介護認定調査依頼書ヘッダのheadItem
     */
    protected ChosaIraishoReport(List<ChosaIraishoHeadItem> headItemList,
            ChosaIraishoHeadItem headItem) {
        this.headItemList = headItemList;
        this.headItem = headItem;
    }

    /**
     *
     * @param reportSourceWriter 要介護認定調査依頼書Sourceクラス
     */
    @Override
    public void writeBy(ReportSourceWriter<ChosaIraishoReportSource> reportSourceWriter) {
        if (headItemList != null) {
            for (ChosaIraishoHeadItem item : headItemList) {
                IChosaIraishoEditor headerEditor = new ChosaIraishoHeaderEditor(item);
                IChosaIraishoBuilder builder = new ChosaIraishoBuilderImpl(headerEditor);
                reportSourceWriter.writeLine(builder);
            }
        } else {
            IChosaIraishoEditor headerEditor = new ChosaIraishoHeaderEditor(headItem);
            IChosaIraishoBuilder builder = new ChosaIraishoBuilderImpl(headerEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
