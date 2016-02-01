/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokutaishoshaichiranhyo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.itakusakichosainzichiran.ItakusakiChosainIchiranReportId;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosatokusokutaishoshaichiranhyo.NinteiChosaTokusokuTaishoshaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 主治医意見書督促対象者一覧表のプロパティです。
 *
 */
public class NinteiChosaTokusokuTaishoshaIchiranhyoProperty extends ReportPropertyBase<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> {

    private static final ReportId ID = new ReportId(ItakusakiChosainIchiranReportId.REPORTID_DBE233002.getCode());
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("title")));

    /**
     * インスタンスを生成します。
     */
    public NinteiChosaTokusokuTaishoshaIchiranhyoProperty() {
        super(SubGyomuCode.DBE認定支援, ID);
    }

    @Override
    public Breakers<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> defineBreakers(
            Breakers<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> breakers,
            BreakerCatalog<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> catalog) {

        return breakers.add(catalog.new SimplePageBreaker(

            PAGE_BREAK_KEYS){
         @Override
            public ReportLineRecord<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> occuredBreak(
                    ReportLineRecord<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> currentRecord,
                    ReportLineRecord<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }

}
