/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.shorikekkakakuninist;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.shorikekkakakuninlist.ShoriKekkaKakuninListReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * {@link ShoriKekkaKakuninListProperty}のプロパティです。
 *
 * @reamsid_L DBU-5590-040 wanghuafeng
 */
public class ShoriKekkaKakuninListProperty extends ReportPropertyBase<ShoriKekkaKakuninListReportSource> {

    private static final List<RString> PAGE_BREAK_KEYS = new ArrayList<>();

    static {
        PAGE_BREAK_KEYS.add(new RString("keyKomoku1"));
        PAGE_BREAK_KEYS.add(new RString("keykomoku2"));
        PAGE_BREAK_KEYS.add(new RString("keykomoku3"));
        PAGE_BREAK_KEYS.add(new RString("keykomoku4"));
        PAGE_BREAK_KEYS.add(new RString("listUpper_1"));
        PAGE_BREAK_KEYS.add(new RString("listUpper_2"));
        PAGE_BREAK_KEYS.add(new RString("listUpper_3"));
        PAGE_BREAK_KEYS.add(new RString("listUpper_4"));
        PAGE_BREAK_KEYS.add(new RString("listUpper_5"));

    }

    /**
     * インスタンスを生成します。
     */
    public ShoriKekkaKakuninListProperty() {
        super(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU200002.getReportId());
    }

    /**
     * 分頁処理です。
     *
     * @param breakers breakers
     * @param catalog catalog
     * @return Breakers
     */
    @Override
    public Breakers<ShoriKekkaKakuninListReportSource> defineBreakers(
            Breakers<ShoriKekkaKakuninListReportSource> breakers,
            BreakerCatalog<ShoriKekkaKakuninListReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(




            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<ShoriKekkaKakuninListReportSource> occuredBreak(
                    ReportLineRecord<ShoriKekkaKakuninListReportSource> currentRecord,
                    ReportLineRecord<ShoriKekkaKakuninListReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
