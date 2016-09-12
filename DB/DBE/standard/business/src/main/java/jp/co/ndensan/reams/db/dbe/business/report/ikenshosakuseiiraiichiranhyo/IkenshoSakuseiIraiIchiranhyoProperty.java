/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog.SimplePageBreaker;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 主治医意見書作成依頼一覧のプロパティです。
 *
 * @reamsid_L DBE-0080-090 zhangzhiming
 */
public class IkenshoSakuseiIraiIchiranhyoProperty extends ReportPropertyBase<IkenshoSakuseiIraiIchiranhyoReportSource> {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("shujiiIryokikanCode")));

    /**
     * インスタンスを生成します。
     */
    public IkenshoSakuseiIraiIchiranhyoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE230002.getReportId());
    }

    @Override
    public Breakers<IkenshoSakuseiIraiIchiranhyoReportSource> defineBreakers(
            Breakers<IkenshoSakuseiIraiIchiranhyoReportSource> breakers,
            BreakerCatalog<IkenshoSakuseiIraiIchiranhyoReportSource> catalog) {

        return breakers.add(catalog.new SimplePageBreaker(


            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<IkenshoSakuseiIraiIchiranhyoReportSource> occuredBreak(
                    ReportLineRecord<IkenshoSakuseiIraiIchiranhyoReportSource> currentRecord,
                    ReportLineRecord<IkenshoSakuseiIraiIchiranhyoReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
