/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoteishutsuiraisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 *
 * {@link 介護保険指定医依頼兼主治医意見書提出依頼書のReport}のプロパティです。
 */
public class ShujiiIkenshoTeishutsuIraishoProperty extends ReportPropertyBase<ShujiiIkenshoTeishutsuIraishoReportSource> {

    private static final List<RString> PAGE_BREAK_KEYS = new ArrayList<>();

    static {
        //TODO 内部QA482 Redmine#78381　改ページ条件「申請書管理番号」Rseファイルがないこと確認
        //PAGE_BREAK_KEYS.add(new RString("shinseishoKanriNo"));
        PAGE_BREAK_KEYS.add(new RString("hakkoYMD1"));
    }

    /**
     * インスタンスを生成します。
     */
    public ShujiiIkenshoTeishutsuIraishoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE236001.getReportId());
    }

    /**
     * @param breakers 介護保険指定医依頼兼主治医意見書提出依頼書breakers
     * @param catalog 介護保険指定医依頼兼主治医意見書提出依頼書catalog
     * @return Breakers
     */
    @Override
    public Breakers<ShujiiIkenshoTeishutsuIraishoReportSource> defineBreakers(
            Breakers<ShujiiIkenshoTeishutsuIraishoReportSource> breakers,
            BreakerCatalog<ShujiiIkenshoTeishutsuIraishoReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(


            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<ShujiiIkenshoTeishutsuIraishoReportSource> occuredBreak(
                    ReportLineRecord<ShujiiIkenshoTeishutsuIraishoReportSource> currentRecord,
                    ReportLineRecord<ShujiiIkenshoTeishutsuIraishoReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
