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
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 保険料納入通知書（仮算定）【ブックタイプ】納付書連帳 （口振依頼あり）通知書のプロパティです。
 *
 * @reamsid_L DBB-9110-040 wangjie2
 */
public class KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverProperty
        extends ReportPropertyBase<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource> {

    private static final List<RString> LAYOUT_BREAK_KEY = Collections.unmodifiableList(Arrays.
            asList(KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource.LAYOUTBREAKITEM));

    /**
     * コンストラクタです。
     *
     */
    public KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100020.getReportId());
    }

    @Override
    public Breakers<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource> defineBreakers(
            Breakers<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource> breakers,
            BreakerCatalog<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource> catalog) {
        return breakers.add(catalog.new SimpleLayoutBreaker(






            LAYOUT_BREAK_KEY) {
                @Override
            public ReportLineRecord<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource> occuredBreak(
                    ReportLineRecord<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource> currentRecord,
                    ReportLineRecord<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource> nextRecord,
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
