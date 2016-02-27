/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.koikinaijushochitokureishaichiranhyo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.koikinaijushochitokureishaichiranhyo.KoikinaiJushochitokureishaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * {@link KoikinaiJushochitokureishaIchiranhyoReport}のプロパティです。
 */
public class KoikinaiJushochitokureishaIchiranhyoProperty extends ReportPropertyBase<KoikinaiJushochitokureishaIchiranhyoReportSource> {

    private static final ReportId ID = ReportIdDBA.DBA200013.getReportId();
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("listUpper_1")));

    /**
     * インスタンスを生成します。
     */
    public KoikinaiJushochitokureishaIchiranhyoProperty() {
        super(SubGyomuCode.DBA介護資格, ID);
    }

    @Override
    public Breakers<KoikinaiJushochitokureishaIchiranhyoReportSource> defineBreakers(
            Breakers<KoikinaiJushochitokureishaIchiranhyoReportSource> breakers,
            BreakerCatalog<KoikinaiJushochitokureishaIchiranhyoReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<KoikinaiJushochitokureishaIchiranhyoReportSource> occuredBreak(
                    ReportLineRecord<KoikinaiJushochitokureishaIchiranhyoReportSource> currentRecord,
                    ReportLineRecord<KoikinaiJushochitokureishaIchiranhyoReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
