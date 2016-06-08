/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvsmulti;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiRenchoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】連帳のPropertyです。
 *
 * @reamsid_L DBB-9110-050 huangh
 */
public class KarisanteiNonyuTsuchishoCVSMultiRenchoProperty extends ReportPropertyBase<KarisanteiNonyuTsuchishoCVSMultiRenchoSource> {

    private static final List<RString> LAYOUT_BREAK_KEYS = Collections.
            unmodifiableList(Arrays.asList(KarisanteiNonyuTsuchishoCVSMultiRenchoSource.LAYOUTBREAKITEM));

    /**
     * インスタンスを生成します。
     */
    public KarisanteiNonyuTsuchishoCVSMultiRenchoProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100027.getReportId());
    }

    @Override
    public Breakers<KarisanteiNonyuTsuchishoCVSMultiRenchoSource> defineBreakers(
            Breakers<KarisanteiNonyuTsuchishoCVSMultiRenchoSource> breakers,
            BreakerCatalog<KarisanteiNonyuTsuchishoCVSMultiRenchoSource> catalog) {

        return breakers.add(catalog.new SimplePageBreaker(






            LAYOUT_BREAK_KEYS) {
            @Override
            public ReportLineRecord<KarisanteiNonyuTsuchishoCVSMultiRenchoSource> occuredBreak(
                    ReportLineRecord<KarisanteiNonyuTsuchishoCVSMultiRenchoSource> currentRecord,
                    ReportLineRecord<KarisanteiNonyuTsuchishoCVSMultiRenchoSource> nextRecord,
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
