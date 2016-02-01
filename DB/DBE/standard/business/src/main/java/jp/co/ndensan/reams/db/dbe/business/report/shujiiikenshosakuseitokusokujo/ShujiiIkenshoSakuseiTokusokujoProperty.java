/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakuseitokusokujo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.itakusakichosainzichiran.ItakusakiChosainIchiranReportId;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshosakuseitokusokujo.ShujiiIkenshoSakuseiTokusokujoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 主治医意見書提出督促状のプロパティです。
 *
 */
public class ShujiiIkenshoSakuseiTokusokujoProperty extends ReportPropertyBase<ShujiiIkenshoSakuseiTokusokujoReportSource> {

    private static final ReportId ID = new ReportId(ItakusakiChosainIchiranReportId.REPORTID_DBE233001.getCode());
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("title")));

    /**
     * インスタンスを生成します。
     */
    public ShujiiIkenshoSakuseiTokusokujoProperty() {
        super(SubGyomuCode.DBE認定支援, ID);
    }

    @Override
    public Breakers<ShujiiIkenshoSakuseiTokusokujoReportSource> defineBreakers(
            Breakers<ShujiiIkenshoSakuseiTokusokujoReportSource> breakers,
            BreakerCatalog<ShujiiIkenshoSakuseiTokusokujoReportSource> catalog) {

        return breakers.add(catalog.new SimplePageBreaker(





            PAGE_BREAK_KEYS){
         @Override
            public ReportLineRecord<ShujiiIkenshoSakuseiTokusokujoReportSource> occuredBreak(
                    ReportLineRecord<ShujiiIkenshoSakuseiTokusokujoReportSource> currentRecord,
                    ReportLineRecord<ShujiiIkenshoSakuseiTokusokujoReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
