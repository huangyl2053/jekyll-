/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyogaikyochosa;

import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.entity.report.ninteichosahyogaikyochosa.ChosahyoGaikyochosaReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 *
 * @author n3331
 */
public class ChosahyoOcrRyomenProperty extends ReportPropertyBase<ChosahyoGaikyochosaReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ChosahyoOcrRyomenProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBZ.DBE221011.getReportId());
    }

    @Override
    protected Breakers<ChosahyoGaikyochosaReportSource> defineBreakers(Breakers<ChosahyoGaikyochosaReportSource> breakers,
            BreakerCatalog<ChosahyoGaikyochosaReportSource> catalog) {
        return breakers.add(catalog.new SimpleLayoutBreaker(

            new RString("layoutIndex")) {
            @Override
            public ReportLineRecord<ChosahyoGaikyochosaReportSource> occuredBreak(ReportLineRecord<ChosahyoGaikyochosaReportSource> currentRecord,
                    ReportLineRecord<ChosahyoGaikyochosaReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                int layout = currentRecord.getSource().layoutIndex;
                currentRecord.setFormGroupIndex(layout);
                if (nextRecord != null && nextRecord.getSource() != null) {
                    layout = nextRecord.getSource().layoutIndex;
                    nextRecord.setFormGroupIndex(layout);
                }
                return currentRecord;
            }
        }).fixed();
    }
}
