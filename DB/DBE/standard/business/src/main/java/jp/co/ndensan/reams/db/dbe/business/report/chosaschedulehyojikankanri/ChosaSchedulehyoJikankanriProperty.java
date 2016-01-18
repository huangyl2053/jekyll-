/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyojikankanri;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosaschedulehyojikankanri.ChosaSchedulehyoJikankanriReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog.SimplePageBreaker;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 *
 * {@link ChosaSchedulehyoJikankanriReport}のプロパティです。
 */
public class ChosaSchedulehyoJikankanriProperty extends ReportPropertyBase<ChosaSchedulehyoJikankanriReportSource> {

    private static final ReportId ID = new ReportId("DBE202011");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("title")));

    /**
     * インスタンスを生成します。
     */
    public ChosaSchedulehyoJikankanriProperty() {
        super(SubGyomuCode.DBE認定支援, ID);
    }

    @Override
    public Breakers<ChosaSchedulehyoJikankanriReportSource> defineBreakers(
            Breakers<ChosaSchedulehyoJikankanriReportSource> breakers,
            BreakerCatalog<ChosaSchedulehyoJikankanriReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<ChosaSchedulehyoJikankanriReportSource> occuredBreak(
                    ReportLineRecord<ChosaSchedulehyoJikankanriReportSource> currentRecord,
                    ReportLineRecord<ChosaSchedulehyoJikankanriReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
