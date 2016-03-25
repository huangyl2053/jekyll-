/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.chosaschedulehyo.ChosaSchedulehyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * {@link ChosaSchedulehyoReport}のプロパティです。
 */
public class ChosaSchedulehyoProperty extends ReportPropertyBase<ChosaSchedulehyoReportSource> {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("chosaItakusakiNo")));

    /**
     * インスタンスを生成します。
     */
    public ChosaSchedulehyoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE202002.getReportId());
    }

    @Override
    public Breakers<ChosaSchedulehyoReportSource> defineBreakers(
            Breakers<ChosaSchedulehyoReportSource> breakers,
            BreakerCatalog<ChosaSchedulehyoReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<ChosaSchedulehyoReportSource> occuredBreak(
                    ReportLineRecord<ChosaSchedulehyoReportSource> currentRecord,
                    ReportLineRecord<ChosaSchedulehyoReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
