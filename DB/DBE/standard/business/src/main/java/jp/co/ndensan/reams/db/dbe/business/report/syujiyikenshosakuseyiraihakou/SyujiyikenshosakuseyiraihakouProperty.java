/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.syujiyikensho.IkenshoSakuseiIraiHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog.SimplePageBreaker;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 *
 * {@link SyujiyikenshosakuseyiraihakouReport}のプロパティです。
 */
public class SyujiyikenshosakuseyiraihakouProperty extends ReportPropertyBase<IkenshoSakuseiIraiHakkoIchiranhyoReportSource> {

    private static final List<RString> PAGE_BREAK_KEYS = new ArrayList<>();

    static {
        PAGE_BREAK_KEYS.add(new RString("joken3"));
        PAGE_BREAK_KEYS.add(new RString("joken4"));
        PAGE_BREAK_KEYS.add(new RString("cityCode"));
    }

    public SyujiyikenshosakuseyiraihakouProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE230003.getReportId());
    }

    @Override
    public Breakers<IkenshoSakuseiIraiHakkoIchiranhyoReportSource> defineBreakers(
            Breakers<IkenshoSakuseiIraiHakkoIchiranhyoReportSource> breakers,
            BreakerCatalog<IkenshoSakuseiIraiHakkoIchiranhyoReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(
            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<IkenshoSakuseiIraiHakkoIchiranhyoReportSource> occuredBreak(
                    ReportLineRecord<IkenshoSakuseiIraiHakkoIchiranhyoReportSource> currentRecord,
                    ReportLineRecord<IkenshoSakuseiIraiHakkoIchiranhyoReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
