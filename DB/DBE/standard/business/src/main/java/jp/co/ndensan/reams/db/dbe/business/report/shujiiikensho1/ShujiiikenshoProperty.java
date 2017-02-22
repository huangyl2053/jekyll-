/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho1;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho1.ShujiiikenshoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 主治医意見書のプロパティです。
 *
 * @author N3212 竹内 和紀
 */
public class ShujiiikenshoProperty extends ReportPropertyBase<ShujiiikenshoReportSource> {

    /**
     * コンストラクタです。
     */
    public ShujiiikenshoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE517151.getReportId());
    }

    @Override
    public Breakers<ShujiiikenshoReportSource> defineBreakers(
            Breakers<ShujiiikenshoReportSource> breakers,
            BreakerCatalog<ShujiiikenshoReportSource> catalog) {
        return breakers.add(catalog.new SimpleLayoutBreaker(
            ShujiiikenshoReportSource.LAYOUTBREAKITEM) {
            @Override
            public ReportLineRecord<ShujiiikenshoReportSource> occuredBreak(
                    ReportLineRecord<ShujiiikenshoReportSource> currentRecord,
                    ReportLineRecord<ShujiiikenshoReportSource> nextRecord, ReportDynamicChart dynamicChart) {
                int layout = currentRecord.getSource().layout;
                currentRecord.setFormGroupIndex(layout);
                if (nextRecord != null && nextRecord.getSource() != null) {
                    layout = nextRecord.getSource().layout;
                    nextRecord.setFormGroupIndex(layout);
                }
                return currentRecord;
            }
        }).fixed();
    }
}
