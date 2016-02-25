/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaihakkoichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaihakkoichiranhyo.ChosaIraiHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 *
 * {@link 認定調査依頼発行一覧表のReport}のプロパティです。
 */
public class ChosaIraiHakkoIchiranhyoProperty extends ReportPropertyBase<ChosaIraiHakkoIchiranhyoReportSource> {

    private static final List<RString> PAGE_BREAK_KEYS = new ArrayList<>();

    static {
        PAGE_BREAK_KEYS.add(new RString("joken4"));
        PAGE_BREAK_KEYS.add(new RString("joken5"));
        PAGE_BREAK_KEYS.add(new RString("cityCode"));
    }

    /**
     * インスタンスを生成します。
     */
    public ChosaIraiHakkoIchiranhyoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE220003.getReportId());
    }

    @Override
    public Breakers<ChosaIraiHakkoIchiranhyoReportSource> defineBreakers(
            Breakers<ChosaIraiHakkoIchiranhyoReportSource> breakers,
            BreakerCatalog<ChosaIraiHakkoIchiranhyoReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(




            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<ChosaIraiHakkoIchiranhyoReportSource> occuredBreak(
                    ReportLineRecord<ChosaIraiHakkoIchiranhyoReportSource> currentRecord,
                    ReportLineRecord<ChosaIraiHakkoIchiranhyoReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
