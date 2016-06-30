/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007_16;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007_16.NonyuTsuchishoBookFuriKaeAriCoverSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 保険料納入通知書（本算定過年度）【ブックタイプ】（口振依頼あり）通知書のプロパティです。
 *
 * @reamsid_L DBB-9110-150 wangjie2
 */
public class NonyuTsuchishoBookFuriKaeAriCoverProperty
        extends ReportPropertyBase<NonyuTsuchishoBookFuriKaeAriCoverSource> {

    private static final List<RString> LAYOUT_BREAK_KEY = Collections.unmodifiableList(Arrays.
            asList(NonyuTsuchishoBookFuriKaeAriCoverSource.LAYOUTBREAKITEM));

    /**
     * コンストラクタです。
     *
     */
    public NonyuTsuchishoBookFuriKaeAriCoverProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100071.getReportId());
    }

    @Override
    public Breakers<NonyuTsuchishoBookFuriKaeAriCoverSource> defineBreakers(
            Breakers<NonyuTsuchishoBookFuriKaeAriCoverSource> breakers,
            BreakerCatalog<NonyuTsuchishoBookFuriKaeAriCoverSource> catalog) {
        return breakers.add(catalog.new SimpleLayoutBreaker(


            LAYOUT_BREAK_KEY) {
                @Override
            public ReportLineRecord<NonyuTsuchishoBookFuriKaeAriCoverSource> occuredBreak(
                    ReportLineRecord<NonyuTsuchishoBookFuriKaeAriCoverSource> currentRecord,
                    ReportLineRecord<NonyuTsuchishoBookFuriKaeAriCoverSource> nextRecord,
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
