/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskakuko;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoRenchoSource;
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
 * @reamsid_L DBB-9110-060 huangh
 */
public class KarisanteiNonyuTsuchishoCVSKakukoRenchoProperty extends ReportPropertyBase<KarisanteiNonyuTsuchishoCVSKakukoRenchoSource> {

    private static final List<RString> LAYOUT_BREAK_KEYS = Collections.
            unmodifiableList(Arrays.asList(KarisanteiNonyuTsuchishoCVSKakukoRenchoSource.LAYOUTBREAKITEM));

    /**
     * インスタンスを生成します。
     */
    public KarisanteiNonyuTsuchishoCVSKakukoRenchoProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100025.getReportId());
    }

    @Override
    public Breakers<KarisanteiNonyuTsuchishoCVSKakukoRenchoSource> defineBreakers(
            Breakers<KarisanteiNonyuTsuchishoCVSKakukoRenchoSource> breakers,
            BreakerCatalog<KarisanteiNonyuTsuchishoCVSKakukoRenchoSource> catalog) {

        return breakers.add(catalog.new SimpleLayoutBreaker(













            LAYOUT_BREAK_KEYS) {
            @Override
            public ReportLineRecord<KarisanteiNonyuTsuchishoCVSKakukoRenchoSource> occuredBreak(
                    ReportLineRecord<KarisanteiNonyuTsuchishoCVSKakukoRenchoSource> currentRecord,
                    ReportLineRecord<KarisanteiNonyuTsuchishoCVSKakukoRenchoSource> nextRecord,
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
