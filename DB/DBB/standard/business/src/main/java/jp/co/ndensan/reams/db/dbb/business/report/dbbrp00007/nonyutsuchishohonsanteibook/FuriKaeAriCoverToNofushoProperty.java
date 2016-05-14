package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.nonyutsuchishohonsanteibook;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.nonyutsuchishohonsanteibook.FuriKaeAriCoverToNofushoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 帳票「DBBRP00007_10_保険料納入通知書（本算定）【ブックタイプ】」のプロパティです。
 *
 * @reamsid_L DBB-9110-100 xuyue
 */
public class FuriKaeAriCoverToNofushoProperty extends ReportPropertyBase<FuriKaeAriCoverToNofushoReportSource> {

    private static final ReportId REPORTID = new ReportId("DBB100055_DBB100020");

    private static final List<RString> LAYOUT_BREAK_KEY = Collections.unmodifiableList(Arrays.
            asList(new RString(FuriKaeAriCoverToNofushoReportSource.LAYOUTBREAKITEM.toString())));

    public FuriKaeAriCoverToNofushoProperty() {
        super(SubGyomuCode.DBB介護賦課, REPORTID);
    }

    @Override
    public Breakers<FuriKaeAriCoverToNofushoReportSource> defineBreakers(Breakers<FuriKaeAriCoverToNofushoReportSource> breakers,
            BreakerCatalog<FuriKaeAriCoverToNofushoReportSource> catalog) {
        return breakers.add(catalog.new SimpleLayoutBreaker(
            LAYOUT_BREAK_KEY) {
                @Override
            public ReportLineRecord<FuriKaeAriCoverToNofushoReportSource> occuredBreak(ReportLineRecord<FuriKaeAriCoverToNofushoReportSource> currentRecord,
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
