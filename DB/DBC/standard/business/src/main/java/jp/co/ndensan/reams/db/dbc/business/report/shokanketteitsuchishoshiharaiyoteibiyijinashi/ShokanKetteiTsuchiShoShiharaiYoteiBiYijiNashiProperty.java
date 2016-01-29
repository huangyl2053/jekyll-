/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishoshiharaiyoteibiyijinashi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 償還払い支給（不支給）決定通知書のプロパティです。
 */
public class ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiProperty
        extends ReportPropertyBase<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource> {

    private static final ReportId ID = ReportIdDBC.DBC100002.getReportId();
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("title")));

    public ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiProperty() {
        super(SubGyomuCode.DBC介護給付, ID);
    }

    @Override
    public Breakers<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource> defineBreakers(
            Breakers<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource> breakers,
            BreakerCatalog<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource> occuredBreak(
                    ReportLineRecord<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource> currentRecord,
                    ReportLineRecord<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
