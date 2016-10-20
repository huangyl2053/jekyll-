/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyotokkijiko;

import jp.co.ndensan.reams.db.dbz.entity.report.ninteichosahyotokkijiko.ChosahyoTokkijikoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog.SimpleLayoutBreaker;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 要介護認定調査票（特記事項）のプロパティです。
 *
 * @reamsid_L DBE-0080-040 xuyannan
 */
public class ChosahyoTokkijikoProperty extends ReportPropertyBase<ChosahyoTokkijikoReportSource> {

    /**
     * インスタンスを生成します。
     *
     * @param id 帳票ID
     */
    public ChosahyoTokkijikoProperty(ReportId id) {
        super(SubGyomuCode.DBE認定支援, id);
    }

    @Override
    public Breakers<ChosahyoTokkijikoReportSource> defineBreakers(Breakers<ChosahyoTokkijikoReportSource> breakers,
            BreakerCatalog<ChosahyoTokkijikoReportSource> catalog) {
        return breakers.add(catalog.new SimpleLayoutBreaker(

            ChosahyoTokkijikoReportSource.LAYOUT_BREAK_KEYS) {
            @Override
            public ReportLineRecord<ChosahyoTokkijikoReportSource> occuredBreak(ReportLineRecord<ChosahyoTokkijikoReportSource> currentRecord,
                    ReportLineRecord<ChosahyoTokkijikoReportSource> nextRecord,
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
