/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kaigokekkataishouichiran;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.KekkatsuchiTaishoshaIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * {@link IkenshoShujiiIchiranReport}のプロパティです。
 *
 * @reamsid_L DBE-0190-020 lizhuoxuan
 */
public class KaigoKekkaTaishouIchiranProperty extends ReportPropertyBase<KekkatsuchiTaishoshaIchiranReportSource> {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("title")));

    /**
     * インスタンスを生成します。
     */
    public KaigoKekkaTaishouIchiranProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE525005.getReportId());
    }

    @Override
    public Breakers<KekkatsuchiTaishoshaIchiranReportSource> defineBreakers(
            Breakers<KekkatsuchiTaishoshaIchiranReportSource> breakers,
            BreakerCatalog<KekkatsuchiTaishoshaIchiranReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(
            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<KekkatsuchiTaishoshaIchiranReportSource> occuredBreak(
                    ReportLineRecord<KekkatsuchiTaishoshaIchiranReportSource> currentRecord,
                    ReportLineRecord<KekkatsuchiTaishoshaIchiranReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
