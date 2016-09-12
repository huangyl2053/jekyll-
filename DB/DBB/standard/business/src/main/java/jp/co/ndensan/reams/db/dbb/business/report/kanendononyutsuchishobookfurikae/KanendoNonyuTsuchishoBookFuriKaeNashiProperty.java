/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishobookfurikae;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendononyutsuchishobookfurikae.KanendoNonyuTsuchishoBookFuriKaeNashiSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 保険料納入通知書（本算定過年度）【ブックタイプ】（口振依頼なし）通知書のプロパティです。
 *
 * @reamsid_L DBB-9110-150 wangjie2
 */
public class KanendoNonyuTsuchishoBookFuriKaeNashiProperty
        extends ReportPropertyBase<KanendoNonyuTsuchishoBookFuriKaeNashiSource> {

    private static final List<RString> LAYOUT_BREAK_KEY = Collections.unmodifiableList(Arrays.
            asList(KanendoNonyuTsuchishoBookFuriKaeNashiSource.LAYOUTBREAKITEM));

    /**
     * コンストラクタです。
     *
     */
    public KanendoNonyuTsuchishoBookFuriKaeNashiProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100072.getReportId());
    }

    @Override
    public Breakers<KanendoNonyuTsuchishoBookFuriKaeNashiSource> defineBreakers(
            Breakers<KanendoNonyuTsuchishoBookFuriKaeNashiSource> breakers,
            BreakerCatalog<KanendoNonyuTsuchishoBookFuriKaeNashiSource> catalog) {
        return breakers.add(catalog.new SimpleLayoutBreaker(




            LAYOUT_BREAK_KEY) {
                @Override
            public ReportLineRecord<KanendoNonyuTsuchishoBookFuriKaeNashiSource> occuredBreak(
                    ReportLineRecord<KanendoNonyuTsuchishoBookFuriKaeNashiSource> currentRecord,
                    ReportLineRecord<KanendoNonyuTsuchishoBookFuriKaeNashiSource> nextRecord,
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
