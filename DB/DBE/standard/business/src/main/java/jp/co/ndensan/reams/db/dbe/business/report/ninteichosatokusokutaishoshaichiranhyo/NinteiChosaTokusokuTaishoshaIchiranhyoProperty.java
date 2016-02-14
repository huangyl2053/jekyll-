/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokutaishoshaichiranhyo;

import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosatokusokutaishoshaichiranhyo.NinteiChosaTokusokuTaishoshaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 主治医意見書督促対象者一覧表のプロパティです。
 *
 */
public class NinteiChosaTokusokuTaishoshaIchiranhyoProperty extends ReportPropertyBase<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> {
//TODO
//    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("title")));

    /**
     * インスタンスを生成します。
     */
    public NinteiChosaTokusokuTaishoshaIchiranhyoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE223002.getReportId());
    }
//TODO
//    @Override
//    public Breakers<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> defineBreakers(
//            Breakers<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> breakers,
//            BreakerCatalog<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> catalog) {
//
//        return breakers.add(catalog.new SimplePageBreaker(
//
//            PAGE_BREAK_KEYS){
//         @Override
//            public ReportLineRecord<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> occuredBreak(
//                    ReportLineRecord<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> currentRecord,
//                    ReportLineRecord<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> nextRecord,
//                    ReportDynamicChart dynamicChart) {
//                if (nextRecord == ReportLineRecord.LAST_RECORD) {
//                    return currentRecord;
//                }
//                return currentRecord;
//            }
//        }).fixed();
//    }
}
