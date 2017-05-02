package jp.co.ndensan.reams.db.dbz.business.report.chosahyomatome;

import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.entity.report.chosahyomatome.ChosahyoMatomeReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog.SimpleLayoutBreaker;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 *
 * @author n8438
 */
public class ChosahyoMatomeProperty extends ReportPropertyBase<ChosahyoMatomeReportSource> {
    
    public ChosahyoMatomeProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBZ.DBE221061.getReportId());
    }
    
    @Override
    public Breakers<ChosahyoMatomeReportSource> defineBreakers(Breakers<ChosahyoMatomeReportSource> breakers,
                                                            BreakerCatalog<ChosahyoMatomeReportSource> catalog) {
        return breakers.add(catalog.new SimpleLayoutBreaker(
        
            ChosahyoMatomeReportSource.LAYOUT_BREAK_KEYS) {
            @Override
            public ReportLineRecord<ChosahyoMatomeReportSource> occuredBreak(ReportLineRecord<ChosahyoMatomeReportSource> currentRecord,
                                                                               ReportLineRecord<ChosahyoMatomeReportSource> nextRecord,
                                                                               ReportDynamicChart dynamicChart) {
                int layoutIndex = currentRecord.getSource().layout.index;
                currentRecord.setFormGroupIndex(layoutIndex);
                if (nextRecord != null && nextRecord.getSource() != null) {
                    layoutIndex = nextRecord.getSource().layout.index;
                    nextRecord.setFormGroupIndex(layoutIndex);
                }
                return currentRecord;
            }
        }).fixed();
    }
}
