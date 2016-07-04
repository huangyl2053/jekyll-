/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 保険料納入通知書（本算定）【ブックタイプ】（口振依頼なし）通知書のプロパティです。
 *
 * @reamsid_L DBB-9110-010 huangh
 */
public class HokenryoNonyuTsuchishoBookFuriKaeNashiProperty
        extends ReportPropertyBase<HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> {

    private static final List<RString> LAYOUT_BREAK_KEY = Collections.unmodifiableList(Arrays.
            asList(HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource.LAYOUTBREAKITEM));

    /**
     * コンストラクタです。
     *
     */
    public HokenryoNonyuTsuchishoBookFuriKaeNashiProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100056.getReportId());
    }

    @Override
    public Breakers<HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> defineBreakers(
            Breakers<HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> breakers,
            BreakerCatalog<HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> catalog) {
        return breakers.add(catalog.new SimpleLayoutBreaker(





            LAYOUT_BREAK_KEY) {
                @Override
            public ReportLineRecord<HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> occuredBreak(
                    ReportLineRecord<HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> currentRecord,
                    ReportLineRecord<HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> nextRecord,
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
