/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishoshiharaiyoteibiyijiari;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriRepotSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 償還払い支給（不支給）決定通知書(支払予定日あり）のReportです。
 */
public class ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriReport extends Report<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriRepotSource> {

    private final List<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 償還払い支給（不支給）決定通知書(支払予定日あり）のITEMリスト
     * @return 償還払い支給（不支給）決定通知書(支払予定日あり）のReport
     */
    public static ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriReport createFrom(
            List<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem> itemList) {

        return new ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriReport(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 償還払い支給（不支給）決定通知書(支払予定日あり）のITEMリスト
     */
    protected ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriReport(
            List<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem> itemList) {

        this.itemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriRepotSource> reportSourceWriter) {
        for (ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem item : itemList) {
            IShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriEditor editor = new ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriEditor(item);
            IShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriBuilder builder = new ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
