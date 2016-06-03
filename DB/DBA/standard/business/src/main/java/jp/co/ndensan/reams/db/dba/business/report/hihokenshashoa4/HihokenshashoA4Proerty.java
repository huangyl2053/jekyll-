/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashoa4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashoa4.HihokenshashoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * {@link HihokenshashoA4ReportSource}のプロパティです。
 * 
 * @reamsid_L DBU-0490-070  suguangjun
 */
public class HihokenshashoA4Proerty extends ReportPropertyBase<HihokenshashoA4ReportSource> {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("hihokenshanno")));

    /**
     * コンストラクタです。
     */
    public HihokenshashoA4Proerty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA100002.getReportId());
    }

    @Override
    public Breakers<HihokenshashoA4ReportSource> defineBreakers(
            Breakers<HihokenshashoA4ReportSource> breakers,
            BreakerCatalog<HihokenshashoA4ReportSource> catalog) {

        return breakers.add(catalog.new SimplePageBreaker(


            PAGE_BREAK_KEYS) {
         @Override
            public ReportLineRecord<HihokenshashoA4ReportSource> occuredBreak(
                    ReportLineRecord<HihokenshashoA4ReportSource> currentRecord,
                    ReportLineRecord<HihokenshashoA4ReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
