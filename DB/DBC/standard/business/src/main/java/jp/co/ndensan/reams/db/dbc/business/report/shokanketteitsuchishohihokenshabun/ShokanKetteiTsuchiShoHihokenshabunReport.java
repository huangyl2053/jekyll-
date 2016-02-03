/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishohihokenshabun;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoHihokenshabunReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 償還払支給（不支給）決定通知書（受領委任払い・被保険者用）のReportです。
 */
public class ShokanKetteiTsuchiShoHihokenshabunReport extends Report<ShokanKetteiTsuchiShoHihokenshabunReportSource> {

    private final List<ShokanKetteiTsuchiShoHihokenshabunItem> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 償還払支給（不支給）決定通知書（受領委任払い・被保険者用）のITEMリスト
     * @return 償還払支給（不支給）決定通知書（受領委任払い・被保険者用）のReport
     */
    public static ShokanKetteiTsuchiShoHihokenshabunReport createFrom(
            List<ShokanKetteiTsuchiShoHihokenshabunItem> itemList) {

        return new ShokanKetteiTsuchiShoHihokenshabunReport(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 償還払支給（不支給）決定通知書（受領委任払い・被保険者用）のITEMリスト
     */
    protected ShokanKetteiTsuchiShoHihokenshabunReport(
            List<ShokanKetteiTsuchiShoHihokenshabunItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShokanKetteiTsuchiShoHihokenshabunReportSource> reportSourceWriter) {
        for (ShokanKetteiTsuchiShoHihokenshabunItem item : itemList) {
            IShokanKetteiTsuchiShoHihokenshabunEditor editor = new ShokanKetteiTsuchiShoHihokenshabunEditor(item);
            IShokanKetteiTsuchiShoHihokenshabunBuilder builder = new ShokanKetteiTsuchiShoHihokenshabunBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
