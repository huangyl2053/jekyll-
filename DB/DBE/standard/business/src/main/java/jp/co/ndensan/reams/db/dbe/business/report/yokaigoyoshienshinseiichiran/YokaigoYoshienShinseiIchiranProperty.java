/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.yokaigoyoshienshinseiichiran;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.yokaigoyoshienshinseiichiran.YokaigoYoshienShinseiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 *
 * 要介護認定・要支援認定等申請者一覧表のプロパティです。
 *
 * @reamsid_L DBE-1370-020 sunhaidi
 */
public class YokaigoYoshienShinseiIchiranProperty extends ReportPropertyBase<YokaigoYoshienShinseiIchiranReportSource> {
    
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("shichosonName")));

    /**
     * インスタンスを生成します。
     */
    public YokaigoYoshienShinseiIchiranProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE011001.getReportId());
    }
    
    @Override
    public Breakers<YokaigoYoshienShinseiIchiranReportSource> defineBreakers(
            Breakers<YokaigoYoshienShinseiIchiranReportSource> breakers,
            BreakerCatalog<YokaigoYoshienShinseiIchiranReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(


            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<YokaigoYoshienShinseiIchiranReportSource> occuredBreak(
                    ReportLineRecord<YokaigoYoshienShinseiIchiranReportSource> currentRecord,
                    ReportLineRecord<YokaigoYoshienShinseiIchiranReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
