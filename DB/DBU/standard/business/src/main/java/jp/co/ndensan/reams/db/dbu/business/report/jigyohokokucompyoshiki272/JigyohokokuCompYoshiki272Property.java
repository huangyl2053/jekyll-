/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki272;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.ｊigyohokokucompyoshiki272.JigyohokokuCompYoshiki272ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * {@link JigyohokokuCompYoshiki272Property}のプロパティです。
 *
 * @reamsid_L DBU-5590-050 wanghuafeng
 */
public class JigyohokokuCompYoshiki272Property extends ReportPropertyBase<JigyohokokuCompYoshiki272ReportSource> {

    /**
     * インスタンスを生成します。
     */
    public JigyohokokuCompYoshiki272Property() {
        super(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU300020.getReportId());
    }

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString(JigyohokokuCompYoshiki272ReportSource.ReportsSourceFields.shichosonkodo.name())));

    @Override
    public Breakers<JigyohokokuCompYoshiki272ReportSource> defineBreakers(
            Breakers<JigyohokokuCompYoshiki272ReportSource> breakers,
            BreakerCatalog<JigyohokokuCompYoshiki272ReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<JigyohokokuCompYoshiki272ReportSource> occuredBreak(
                    ReportLineRecord<JigyohokokuCompYoshiki272ReportSource> currentRecord,
                    ReportLineRecord<JigyohokokuCompYoshiki272ReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
