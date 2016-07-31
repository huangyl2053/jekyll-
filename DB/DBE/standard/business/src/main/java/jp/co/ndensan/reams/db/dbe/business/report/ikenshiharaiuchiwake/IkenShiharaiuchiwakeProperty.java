/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshiharaiuchiwake;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshiharaiuchiwake.IkenShiharaiuchiwakeReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 帳票設計_DBE622004_主治医意見書作成料支払内訳確認書のIkenShiharaiuchiwakePropertyです。
 *
 * @reamsid_L DBE-1980-047 xuyongchao
 */
public class IkenShiharaiuchiwakeProperty extends ReportPropertyBase<IkenShiharaiuchiwakeReportSource> {

    private static final List<RString> LAYOUT_BREAK_KEYS = Collections.
            unmodifiableList(Arrays.asList(IkenShiharaiuchiwakeReportSource.LAYOUTBREAKITEM));

    /**
     * インスタンスを生成します。
     */
    public IkenShiharaiuchiwakeProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE622004.getReportId());
    }

    @Override
    public Breakers<IkenShiharaiuchiwakeReportSource> defineBreakers(
            Breakers<IkenShiharaiuchiwakeReportSource> breakers,
            BreakerCatalog<IkenShiharaiuchiwakeReportSource> catalog) {

        return breakers.add(catalog.new SimplePageBreaker(

            LAYOUT_BREAK_KEYS) {
            @Override
            public ReportLineRecord<IkenShiharaiuchiwakeReportSource> occuredBreak(
                    ReportLineRecord<IkenShiharaiuchiwakeReportSource> currentRecord,
                    ReportLineRecord<IkenShiharaiuchiwakeReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                int layout = currentRecord.getSource().layoutBreakItem;
                currentRecord.setFormGroupIndex(layout);
                if (nextRecord != null && nextRecord.getSource() != null) {
                    layout = nextRecord.getSource().layoutBreakItem;
                    nextRecord.setFormGroupIndex(layout);
                }
                return currentRecord;
            }
        }).fixed();
    }

}
