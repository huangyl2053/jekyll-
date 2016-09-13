/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.chosairaiichiranhyo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.entity.report.chosairaiichiranhyo.ChosaIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog.SimplePageBreaker;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * {@link 認定調査依頼一覧表のReport}のプロパティです。
 *
 * @reamsid_L DBE-0010-030 lishengli
 */
public class ChosaIraiIchiranhyoProperty extends ReportPropertyBase<ChosaIraiIchiranhyoReportSource> {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("jigyoshaNo")));

    /**
     * インスタンスを生成します。
     */
    public ChosaIraiIchiranhyoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBZ.DBE220002.getReportId());
    }

    @Override
    public Breakers<ChosaIraiIchiranhyoReportSource> defineBreakers(
            Breakers<ChosaIraiIchiranhyoReportSource> breakers,
            BreakerCatalog<ChosaIraiIchiranhyoReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<ChosaIraiIchiranhyoReportSource> occuredBreak(
                    ReportLineRecord<ChosaIraiIchiranhyoReportSource> currentRecord,
                    ReportLineRecord<ChosaIraiIchiranhyoReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
