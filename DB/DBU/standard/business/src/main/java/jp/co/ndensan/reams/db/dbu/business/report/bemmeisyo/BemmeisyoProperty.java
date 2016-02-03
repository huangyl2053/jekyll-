/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.bemmeisyo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.report.bemmeisyo.BemmeisyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * {@link BemmeisyoReport}のプロパティです。
 */
public class BemmeisyoProperty extends ReportPropertyBase<BemmeisyoReportSource> {

    private static final ReportId ID = new ReportId("DBU100001");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("")));

    /**
     * インスタンスを生成します。
     */
    public BemmeisyoProperty() {
        super(SubGyomuCode.DBU介護統計報告, ID);
    }

    @Override
    public Breakers<BemmeisyoReportSource> defineBreakers(
            Breakers<BemmeisyoReportSource> breakers,
            BreakerCatalog<BemmeisyoReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<BemmeisyoReportSource> occuredBreak(
                    ReportLineRecord<BemmeisyoReportSource> currentRecord,
                    ReportLineRecord<BemmeisyoReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
