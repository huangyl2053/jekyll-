/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200024;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200024.ShokanbaraiSashitomeTaishoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog.SimplePageBreaker;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 帳票設計_DBC200024_償還払支給差止対象者一覧表のProperty
 *
 * @reamsid_L DBC-1000-160 liwul
 */
public class ShokanbaraiSashitomeTaishoshaIchiranProperty extends ReportPropertyBase<ShokanbaraiSashitomeTaishoshaIchiranSource> {

    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(
                            new RString("kaipage1"),
                            new RString("kaipage2"),
                            new RString("kaipage3"),
                            new RString("kaipage4"),
                            new RString("kaipage5")));

    /**
     * コンストラクタです。
     */
    public ShokanbaraiSashitomeTaishoshaIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200024.getReportId());
    }

    @Override
    public Breakers<ShokanbaraiSashitomeTaishoshaIchiranSource> defineBreakers(
            Breakers<ShokanbaraiSashitomeTaishoshaIchiranSource> breakers,
            BreakerCatalog<ShokanbaraiSashitomeTaishoshaIchiranSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<ShokanbaraiSashitomeTaishoshaIchiranSource> occuredBreak(
                    ReportLineRecord<ShokanbaraiSashitomeTaishoshaIchiranSource> currentRecord,
                    ReportLineRecord<ShokanbaraiSashitomeTaishoshaIchiranSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
