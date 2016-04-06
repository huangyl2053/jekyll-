/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shikakushasho;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.shikakushasho.ShikakushashoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * {@link ShikakushashoReportSource}のプロパティです。
 *
 * @reamsid_L DBU-0490-080 suguangjun
 */
public class ShikakushashoProerty extends ReportPropertyBase<ShikakushashoReportSource> {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("hihokenshaNo")));

    /**
     * コンストラクタです。
     */
    public ShikakushashoProerty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA100003.getReportId());
    }

    @Override
    public Breakers<ShikakushashoReportSource> defineBreakers(
            Breakers<ShikakushashoReportSource> breakers,
            BreakerCatalog<ShikakushashoReportSource> catalog) {

        return breakers.add(catalog.new SimplePageBreaker(PAGE_BREAK_KEYS) {
         @Override
            public ReportLineRecord<ShikakushashoReportSource> occuredBreak(
                    ReportLineRecord<ShikakushashoReportSource> currentRecord,
                    ReportLineRecord<ShikakushashoReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
