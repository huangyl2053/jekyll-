/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishobook;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 保険料納入通知書（仮算定）【ブックタイプ】（口振依頼なし）通知書のプロパティです。
 *
 * @reamsid_L DBB-9110-040 wangjie2
 */
public class KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverProperty
        extends ReportPropertyBase<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> {

    private static final List<RString> LAYOUT_BREAK_KEY = Collections.unmodifiableList(Arrays.
            asList(KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource.LAYOUTBREAKITEM));

    /**
     * コンストラクタです。
     *
     */
    public KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100021.getReportId());
    }

    @Override
    public Breakers<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> defineBreakers(
            Breakers<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> breakers,
            BreakerCatalog<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> catalog) {
        return breakers.add(catalog.new SimpleLayoutBreaker(
            LAYOUT_BREAK_KEY) {
                @Override
            public ReportLineRecord<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> occuredBreak(
                    ReportLineRecord<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> currentRecord,
                    ReportLineRecord<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> nextRecord,
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
