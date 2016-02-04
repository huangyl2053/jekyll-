/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyufushikyuketteitsuchiichiran;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanbaraishikyufushikyuketteitsuchiichiran.ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 償還払支給（不支給）決定通知一覧表覧表のプロパティです。
 */
public class ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranProperty
        extends ReportPropertyBase<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReportSource> {

    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(
                            new RString("kaipage1"),
                            new RString("kaipage2"),
                            new RString("kaipage3"),
                            new RString("kaipage4"),
                            new RString("kaipage5")));

    public ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200023.getReportId());
    }

    @Override
    public Breakers<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReportSource> defineBreakers(
            Breakers<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReportSource> breakers,
            BreakerCatalog<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(



            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReportSource> occuredBreak(
                    ReportLineRecord<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReportSource> currentRecord,
                    ReportLineRecord<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
