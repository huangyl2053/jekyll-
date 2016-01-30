/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.koikinaitenkyokekkaichiranhyo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.report.koikinaitenkyokekkaichiranhyo.KoikinaiTenkyoKekkaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * {@link KoikinaiTenkyoKekkaIchiranhyoReportSource}のプロパティです。
 */
public class KoikinaiTenkyoKekkaIchiranhyoProperty extends ReportPropertyBase<KoikinaiTenkyoKekkaIchiranhyoReportSource> {

    private static final ReportId ID = new ReportId("DBA200011");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("listHihokenshaNo_1")));

    /**
     * インスタンスを生成します。
     */
    public KoikinaiTenkyoKekkaIchiranhyoProperty() {
        super(SubGyomuCode.DBA介護資格, ID);
    }

    @Override
    public Breakers<KoikinaiTenkyoKekkaIchiranhyoReportSource> defineBreakers(
            Breakers<KoikinaiTenkyoKekkaIchiranhyoReportSource> breakers,
            BreakerCatalog<KoikinaiTenkyoKekkaIchiranhyoReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(


            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<KoikinaiTenkyoKekkaIchiranhyoReportSource> occuredBreak(
                    ReportLineRecord<KoikinaiTenkyoKekkaIchiranhyoReportSource> currentRecord,
                    ReportLineRecord<KoikinaiTenkyoKekkaIchiranhyoReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
