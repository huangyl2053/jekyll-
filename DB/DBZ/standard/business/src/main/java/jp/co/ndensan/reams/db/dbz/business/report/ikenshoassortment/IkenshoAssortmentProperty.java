package jp.co.ndensan.reams.db.dbz.business.report.ikenshoassortment;

import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.entity.report.ikenshoassortment.IkenshoAssortmentReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog.SimpleLayoutBreaker;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 意見書まとめて印刷のプロパティです。
 * @author n8438
 */
public class IkenshoAssortmentProperty extends ReportPropertyBase<IkenshoAssortmentReportSource> {
    
    /**
     * コンストラクタです。
     */
    public IkenshoAssortmentProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBZ.DBE221071.getReportId());
    }
    
    @Override
    public Breakers<IkenshoAssortmentReportSource> defineBreakers(Breakers<IkenshoAssortmentReportSource> breakers,
                                                            BreakerCatalog<IkenshoAssortmentReportSource> catalog) {
        return breakers.add(catalog.new SimpleLayoutBreaker(
        
            IkenshoAssortmentReportSource.LAYOUT_BREAK_KEYS) {
            @Override
            public ReportLineRecord<IkenshoAssortmentReportSource> occuredBreak(ReportLineRecord<IkenshoAssortmentReportSource> currentRecord,
                                                                               ReportLineRecord<IkenshoAssortmentReportSource> nextRecord,
                                                                               ReportDynamicChart dynamicChart) {
                int layoutIndex = currentRecord.getSource().layout.getIndex();
                currentRecord.setFormGroupIndex(layoutIndex);
                if (nextRecord != null && nextRecord.getSource() != null) {
                    layoutIndex = nextRecord.getSource().layout.getIndex();
                    nextRecord.setFormGroupIndex(layoutIndex);
                }
                return currentRecord;
            }
        }).fixed();
    }
}
