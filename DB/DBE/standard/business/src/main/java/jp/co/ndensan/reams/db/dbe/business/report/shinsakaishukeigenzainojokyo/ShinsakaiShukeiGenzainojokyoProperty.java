/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeigenzainojokyo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 介護認定審査会集計表（現在の状況別）のプロパティです。
 *
 * @reamsid_L DBE-1450-090 duanzhanli
 */
public class ShinsakaiShukeiGenzainojokyoProperty extends ReportPropertyBase<ShinsakaiShukeiGenzainojokyoReportSource> {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.
            asList(new RString(ShinsakaiShukeiGenzainojokyoReportSource.ReportSourceFields.shichosonName.name())));

    /**
     * インスタンスを生成します。
     */
    public ShinsakaiShukeiGenzainojokyoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE701009.getReportId());
    }

    @Override
    public Breakers<ShinsakaiShukeiGenzainojokyoReportSource> defineBreakers(
            Breakers<ShinsakaiShukeiGenzainojokyoReportSource> breakers,
            BreakerCatalog<ShinsakaiShukeiGenzainojokyoReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<ShinsakaiShukeiGenzainojokyoReportSource> occuredBreak(
                    ReportLineRecord<ShinsakaiShukeiGenzainojokyoReportSource> currentRecord,
                    ReportLineRecord<ShinsakaiShukeiGenzainojokyoReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
