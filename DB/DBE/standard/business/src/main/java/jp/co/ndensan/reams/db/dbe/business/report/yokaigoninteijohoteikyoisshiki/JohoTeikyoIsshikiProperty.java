/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.yokaigoninteijohoteikyoisshiki.YokaigoNinteiJohoTeikyoIsshikiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 要介護認定情報提供一式のプロパティです。
 *
 * @author N3212 竹内 和紀
 */
public class JohoTeikyoIsshikiProperty extends ReportPropertyBase<YokaigoNinteiJohoTeikyoIsshikiReportSource> {

    /**
     * コンストラクタです。
     */
    public JohoTeikyoIsshikiProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE091101.getReportId());
    }

    @Override
    public Breakers<YokaigoNinteiJohoTeikyoIsshikiReportSource> defineBreakers(
            Breakers<YokaigoNinteiJohoTeikyoIsshikiReportSource> breakers,
            BreakerCatalog<YokaigoNinteiJohoTeikyoIsshikiReportSource> catalog) {
        return breakers.add(catalog.new SimpleLayoutBreaker(
            YokaigoNinteiJohoTeikyoIsshikiReportSource.LAYOUT_BREAK_KEYS) {
            @Override
            public ReportLineRecord<YokaigoNinteiJohoTeikyoIsshikiReportSource> occuredBreak(
                    ReportLineRecord<YokaigoNinteiJohoTeikyoIsshikiReportSource> currentRecord,
                    ReportLineRecord<YokaigoNinteiJohoTeikyoIsshikiReportSource> nextRecord, ReportDynamicChart dynamicChart) {
                int layout = currentRecord.getSource().layout;
                currentRecord.setFormGroupIndex(layout);
                if (nextRecord != null && nextRecord.getSource() != null) {
                    layout = nextRecord.getSource().layout;
                    nextRecord.setFormGroupIndex(layout);
                }
                return currentRecord;
            }
        }).fixed();
    }
}
