package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.nonyutsuchishobookfurikaeari;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.nonyutsuchishohonsanteibook.FuriKaeAriCoverToNofushoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 保険料納入通知書（本算定）【ブック（口振依頼あり通知書＋納付書）タイプ】のプロパティです。
 *
 * @reamsid_L DBB-9110-100 xuyue
 */
public class NonyuTsuchishoBookFuriKaeAriProperty extends ReportPropertyBase<FuriKaeAriCoverToNofushoReportSource> {

    private static final List<RString> LAYOUT_BREAK_KEY = Collections.unmodifiableList(Arrays.
            asList(new RString(FuriKaeAriCoverToNofushoReportSource.LAYOUTBREAKITEM.toString())));

    /**
     * コンストラクタです。
     */
    public NonyuTsuchishoBookFuriKaeAriProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100055.getReportId());
    }

    @Override
    public Breakers<FuriKaeAriCoverToNofushoReportSource> defineBreakers(Breakers<FuriKaeAriCoverToNofushoReportSource> breakers,
            BreakerCatalog<FuriKaeAriCoverToNofushoReportSource> catalog) {
        return breakers.add(catalog.new SimpleLayoutBreaker(
            LAYOUT_BREAK_KEY) {
                @Override
            public ReportLineRecord<FuriKaeAriCoverToNofushoReportSource> occuredBreak(
                    ReportLineRecord<FuriKaeAriCoverToNofushoReportSource> currentRecord,
                    ReportLineRecord<FuriKaeAriCoverToNofushoReportSource> nextRecord, ReportDynamicChart dynamicChart) {
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
