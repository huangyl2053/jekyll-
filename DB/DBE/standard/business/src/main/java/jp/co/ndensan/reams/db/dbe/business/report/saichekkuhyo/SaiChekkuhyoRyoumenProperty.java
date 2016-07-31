/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.saichekkuhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.saichekkuhyo.SaiChekkuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 要介護認定調査票差異チェック票のプロパティです。
 *
 * @reamsid_L DBE-0080-060 xuyannan
 */
public class SaiChekkuhyoRyoumenProperty extends ReportPropertyBase<SaiChekkuhyoReportSource> {

    /**
     * インスタンスを生成します。
     *
     * @param id 帳票ID
     */
    public SaiChekkuhyoRyoumenProperty(ReportId id) {
        super(SubGyomuCode.DBE認定支援, id);
    }

    @Override
    public Breakers<SaiChekkuhyoReportSource> defineBreakers(Breakers<SaiChekkuhyoReportSource> breakers,
            BreakerCatalog<SaiChekkuhyoReportSource> catalog) {
        return breakers.add(catalog.new SimpleLayoutBreaker(

            SaiChekkuhyoReportSource.LAYOUT_BREAK_KEYS) {
            @Override
            public ReportLineRecord<SaiChekkuhyoReportSource> occuredBreak(ReportLineRecord<SaiChekkuhyoReportSource> currentRecord,
                    ReportLineRecord<SaiChekkuhyoReportSource> nextRecord,
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
