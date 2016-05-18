/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.sonotashiryo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.sonotashiryo.SonoTashiryoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog.SimplePageBreaker;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 要介護認定情報提供その他資料情報のプロパティです。
 *
 * @reamsid_L DBE-0230-050 zhangzhiming
 */
public class SonoTashiryoProperty extends ReportPropertyBase<SonoTashiryoReportSource> {

    private static final ReportId ID = ReportIdDBE.DBE517016.getReportId();
    // TODO その他資料情報改ページ条件 QA1185
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.
            asList(new RString(SonoTashiryoReportSource.ReportSourceFields.imgSonotashiryo.name())));

    /**
     * インスタンスを生成します。
     */
    public SonoTashiryoProperty() {
        super(SubGyomuCode.DBE認定支援, ID);
    }

    @Override
    public Breakers<SonoTashiryoReportSource> defineBreakers(
            Breakers<SonoTashiryoReportSource> breakers,
            BreakerCatalog<SonoTashiryoReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<SonoTashiryoReportSource> occuredBreak(
                    ReportLineRecord<SonoTashiryoReportSource> currentRecord,
                    ReportLineRecord<SonoTashiryoReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
