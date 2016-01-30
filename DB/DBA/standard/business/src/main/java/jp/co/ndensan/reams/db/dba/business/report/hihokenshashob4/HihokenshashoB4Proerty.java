/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.hihokenshashob4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashob4.HihokenshashoB4ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 
 * {@link HihokenshashoHakkoIchiranHyoProerty}のプロパティです。
 */
public class HihokenshashoB4Proerty extends ReportPropertyBase<HihokenshashoB4ReportSource> {
    
    private static final ReportId ID = ReportIdDBA.DBA100001.getReportId();
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("hihokenshanno2")));
    
    /**
     * コンストラクタです。
     */
    public HihokenshashoB4Proerty() {
        super(SubGyomuCode.DBA介護資格, ID);
    }
    
    /**
     * 改ページです。
     * @param breakers Breakers<HihokenshashoB4ReportSource>
     * @param catalog BreakerCatalog<HihokenshashoB4ReportSource>
     * @return Breakers<HihokenshashoB4ReportSource>
     */
    @Override
    public Breakers<HihokenshashoB4ReportSource> defineBreakers(
            Breakers<HihokenshashoB4ReportSource> breakers,
            BreakerCatalog<HihokenshashoB4ReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<HihokenshashoB4ReportSource> occuredBreak(
                    ReportLineRecord<HihokenshashoB4ReportSource> currentRecord,
                    ReportLineRecord<HihokenshashoB4ReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
