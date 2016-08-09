/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokunenpoyoshiki28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokunenpoyoshiki28.JigyohokokuNenpoYoshiki28ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 事業状況報告年報（様式１・２　市町村特別給付）のPropertyです。
 *
 * @reamsid_L DBU-5610-050 yaoyahui
 */
public class JigyohokokuNenpoYoshiki28Property extends ReportPropertyBase<JigyohokokuNenpoYoshiki28ReportSource> {

    /**
     * コンストラクタです。
     */
    public JigyohokokuNenpoYoshiki28Property() {
        super(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU300121.getReportId());
    }
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString(JigyohokokuNenpoYoshiki28ReportSource.ReportsSourceFields.jijifanhao.name())));

    @Override
    public Breakers<JigyohokokuNenpoYoshiki28ReportSource> defineBreakers(
            Breakers<JigyohokokuNenpoYoshiki28ReportSource> breakers,
            BreakerCatalog<JigyohokokuNenpoYoshiki28ReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(            
             
             
            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<JigyohokokuNenpoYoshiki28ReportSource> occuredBreak(
                    ReportLineRecord<JigyohokokuNenpoYoshiki28ReportSource> currentRecord,
                    ReportLineRecord<JigyohokokuNenpoYoshiki28ReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
