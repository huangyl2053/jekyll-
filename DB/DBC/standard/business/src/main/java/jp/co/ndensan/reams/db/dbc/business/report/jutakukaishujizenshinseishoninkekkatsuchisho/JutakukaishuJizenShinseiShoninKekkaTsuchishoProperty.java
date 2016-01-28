/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jutakukaishujizenshinseishoninkekkatsuchisho;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jutakukaishujizenshinseishoninkekka.JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 住宅改修事前申請承認結果通知書のプロパティです。
 */
public class JutakukaishuJizenShinseiShoninKekkaTsuchishoProperty extends ReportPropertyBase<JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource> {

    private static final ReportId ID = new ReportId("DBC100002");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("title")));

    public JutakukaishuJizenShinseiShoninKekkaTsuchishoProperty() {
        super(SubGyomuCode.DBE認定支援, ID);
    }

    @Override
    public Breakers<JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource> defineBreakers(
            Breakers<JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource> breakers,
            BreakerCatalog<JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(


            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource> occuredBreak(
                    ReportLineRecord<JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource> currentRecord,
                    ReportLineRecord<JutakukaishuJizenShinseiShoninKekkaTsuchishoReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
