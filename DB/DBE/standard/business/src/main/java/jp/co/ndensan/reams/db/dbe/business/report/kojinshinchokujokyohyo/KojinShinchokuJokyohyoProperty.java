/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.kojinshinchokujokyohyo.KojinShinchokuJokyohyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * {@link KojinShinchokuJokyohyoReport}のプロパティです。
 *
 * @reamsid_L DBE-0200-040 zhangzhiming
 */
public class KojinShinchokuJokyohyoProperty extends ReportPropertyBase<KojinShinchokuJokyohyoReportSource> {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("title")));

    /**
     * コンストラクタを作成します。
     */
    public KojinShinchokuJokyohyoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE521001.getReportId());
    }

    @Override
    public Breakers<KojinShinchokuJokyohyoReportSource> defineBreakers(
            Breakers<KojinShinchokuJokyohyoReportSource> breakers,
            BreakerCatalog<KojinShinchokuJokyohyoReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<KojinShinchokuJokyohyoReportSource> occuredBreak(
                    ReportLineRecord<KojinShinchokuJokyohyoReportSource> currentRecord,
                    ReportLineRecord<KojinShinchokuJokyohyoReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
