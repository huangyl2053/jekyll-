/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jigyojokyohokoku;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jigyojokyohokoku.JigyoJokyoHokokuReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 要介護認定事業状況報告のプロパティです。
 *
 * @reamsid_L DBE-1450-100 dongyabin
 */
public class JigyoJokyoHokokuProperty extends ReportPropertyBase<JigyoJokyoHokokuReportSource> {

    private static final ReportId ID = ReportIdDBE.DBE702001.getReportId();
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.
            asList(new RString(JigyoJokyoHokokuReportSource.ReportSourceFields.jigyoTaishoYM.name())));

    /**
     * インスタンスを生成します。
     */
    public JigyoJokyoHokokuProperty() {
        super(SubGyomuCode.DBE認定支援, ID);
    }

    @Override
    public Breakers<JigyoJokyoHokokuReportSource> defineBreakers(
            Breakers<JigyoJokyoHokokuReportSource> breakers,
            BreakerCatalog<JigyoJokyoHokokuReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(
            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<JigyoJokyoHokokuReportSource> occuredBreak(
                    ReportLineRecord<JigyoJokyoHokokuReportSource> currentRecord,
                    ReportLineRecord<JigyoJokyoHokokuReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
