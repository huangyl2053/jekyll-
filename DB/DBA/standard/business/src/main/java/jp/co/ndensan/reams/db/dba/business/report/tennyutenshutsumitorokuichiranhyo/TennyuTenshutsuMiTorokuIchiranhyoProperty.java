/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tennyutenshutsumitorokuichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.tennyutenshutsumitorokuichiranhyo.TennyuTenshutsuMitorokuIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 転入転出未登録一覧表のプロパティです。
 *
 * @reamsid_L DBU-4110-040 yaodongsheng
 */
public class TennyuTenshutsuMiTorokuIchiranhyoProperty extends ReportPropertyBase<TennyuTenshutsuMitorokuIchiranhyoReportSource> {

    private static final List<RString> PAGE_BREAK_KEYS = new ArrayList<>();

    static {
        PAGE_BREAK_KEYS.add(new RString("kaipage1"));
        PAGE_BREAK_KEYS.add(new RString("kaipage2"));
        PAGE_BREAK_KEYS.add(new RString("kaipage3"));
        PAGE_BREAK_KEYS.add(new RString("kaipage4"));
        PAGE_BREAK_KEYS.add(new RString("kaipage5"));
    }

    /**
     * インスタンスを生成します。
     */
    public TennyuTenshutsuMiTorokuIchiranhyoProperty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA200014.getReportId());
    }

    /**
     * 分頁処理です。
     *
     * @param breakers breakers
     * @param catalog catalog
     * @return Breakers
     */
    @Override
    public Breakers<TennyuTenshutsuMitorokuIchiranhyoReportSource> defineBreakers(
            Breakers<TennyuTenshutsuMitorokuIchiranhyoReportSource> breakers,
            BreakerCatalog<TennyuTenshutsuMitorokuIchiranhyoReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(


            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<TennyuTenshutsuMitorokuIchiranhyoReportSource> occuredBreak(
                    ReportLineRecord<TennyuTenshutsuMitorokuIchiranhyoReportSource> currentRecord,
                    ReportLineRecord<TennyuTenshutsuMitorokuIchiranhyoReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
