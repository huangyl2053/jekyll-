/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishoshiharaiyoteibiyijinashi;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 償還払い支給（不支給）決定通知書のReportです。
 */
public class ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReport extends Report<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource> {

    private final List<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiItem> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 償還払い支給（不支給）決定通知書のITEMリスト
     * @return 償還払い支給（不支給）決定通知書のReport
     */
    public static ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReport createFrom(
            List<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiItem> itemList) {

        return new ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReport(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 償還払い支給（不支給）決定通知書のITEMリスト
     */
    protected ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReport(
            List<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource> reportSourceWriter) {
        for (ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiItem item : itemList) {
            IShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiEditor editor = new ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiEditor(item);
            IShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiBuilder builder = new ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
