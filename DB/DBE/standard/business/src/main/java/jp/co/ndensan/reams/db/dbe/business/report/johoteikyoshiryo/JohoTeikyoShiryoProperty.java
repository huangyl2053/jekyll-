/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.johoteikyoshiryo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.itakusakichosainzichiran.ItakusakiChosainIchiranReportId;
import jp.co.ndensan.reams.db.dbe.entity.report.johoteikyoshiryo.JohoTeikyoShiryoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 要介護認定結果情報提供票（主治医）のプロパティです。
 */
public class JohoTeikyoShiryoProperty extends ReportPropertyBase<JohoTeikyoShiryoReportSource> {

    private static final ReportId ID = new ReportId(ItakusakiChosainIchiranReportId.REPORTID_DBE090001.getCode());
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("title")));

    /**
     * インスタンスを生成します。
     */
    public JohoTeikyoShiryoProperty() {
        super(SubGyomuCode.DBE認定支援, ID);
    }

    @Override
    public Breakers<JohoTeikyoShiryoReportSource> defineBreakers(
            Breakers<JohoTeikyoShiryoReportSource> breakers,
            BreakerCatalog<JohoTeikyoShiryoReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(




            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<JohoTeikyoShiryoReportSource> occuredBreak(
                    ReportLineRecord<JohoTeikyoShiryoReportSource> currentRecord,
                    ReportLineRecord<JohoTeikyoShiryoReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
