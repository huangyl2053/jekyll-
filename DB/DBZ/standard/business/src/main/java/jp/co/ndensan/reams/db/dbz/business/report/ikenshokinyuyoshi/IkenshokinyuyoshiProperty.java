/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ikenshokinyuyoshi;

import jp.co.ndensan.reams.db.dbz.entity.report.ikenshokinyuyoshi.IkenshokinyuyoshiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog.SimpleLayoutBreaker;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 要介護認定主治医意見書記入用紙-片面-白黒のプロパティです。
 *
 * @reamsid_L DBE-0050-030 xuyannan
 */
public class IkenshokinyuyoshiProperty extends ReportPropertyBase<IkenshokinyuyoshiReportSource> {

    /**
     * インスタンスを生成します。
     *
     * @param id 帳票ID
     */
    public IkenshokinyuyoshiProperty(ReportId id) {
        super(SubGyomuCode.DBE認定支援, id);
    }

    @Override
    public Breakers<IkenshokinyuyoshiReportSource> defineBreakers(Breakers<IkenshokinyuyoshiReportSource> breakers,
            BreakerCatalog<IkenshokinyuyoshiReportSource> catalog) {
        return breakers.add(catalog.new SimpleLayoutBreaker(

            IkenshokinyuyoshiReportSource.LAYOUT_BREAK_KEYS) {
            @Override
            public ReportLineRecord<IkenshokinyuyoshiReportSource> occuredBreak(ReportLineRecord<IkenshokinyuyoshiReportSource> currentRecord,
                    ReportLineRecord<IkenshokinyuyoshiReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                int layout = currentRecord.getSource().layout.index();
                currentRecord.setFormGroupIndex(layout);
                if (nextRecord != null && nextRecord.getSource() != null) {
                    layout = nextRecord.getSource().layout.index();
                    nextRecord.setFormGroupIndex(layout);
                }
                return currentRecord;
            }
        }).fixed();
    }
}
