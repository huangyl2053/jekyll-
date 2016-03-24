/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.nenreitotatsuyoteishaichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.nenreitotatsuyoteishaichiranhyo.NenreitotatsuYoteishaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 年齢到達予定者一覧表のプロパティです。
 */
public class NenreitotatsuYoteishaIchiranhyoProperty extends ReportPropertyBase<NenreitotatsuYoteishaIchiranhyoReportSource> {

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
    public NenreitotatsuYoteishaIchiranhyoProperty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA200001.getReportId());
    }

    /**
     * 分頁処理です。
     *
     * @param breakers breakers
     * @param catalog catalog
     * @return Breakers
     */
    @Override
    public Breakers<NenreitotatsuYoteishaIchiranhyoReportSource> defineBreakers(
            Breakers<NenreitotatsuYoteishaIchiranhyoReportSource> breakers,
            BreakerCatalog<NenreitotatsuYoteishaIchiranhyoReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(
            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<NenreitotatsuYoteishaIchiranhyoReportSource> occuredBreak(
                    ReportLineRecord<NenreitotatsuYoteishaIchiranhyoReportSource> currentRecord,
                    ReportLineRecord<NenreitotatsuYoteishaIchiranhyoReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
