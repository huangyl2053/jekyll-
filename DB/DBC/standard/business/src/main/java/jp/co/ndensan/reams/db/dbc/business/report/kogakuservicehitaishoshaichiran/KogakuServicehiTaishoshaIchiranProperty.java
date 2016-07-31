/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuservicehitaishoshaichiran;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuservicehitaishoshaichiran.KogakuServicehiTaishoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 高額介護サービス費対象者一覧表Property
 *
 * @reamsid_L DBC-2010-100 surun
 */
public class KogakuServicehiTaishoshaIchiranProperty extends
        ReportPropertyBase<KogakuServicehiTaishoshaIchiranSource> {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(KogakuServicehiTaishoshaIchiranSource.ReportSourceFields.hokenshaNo.name())
    ));

    /**
     * コンストラクタです。
     */
    public KogakuServicehiTaishoshaIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200016.getReportId());
    }

    @Override
    public Breakers<KogakuServicehiTaishoshaIchiranSource> defineBreakers(
            Breakers<KogakuServicehiTaishoshaIchiranSource> breakers,
            BreakerCatalog<KogakuServicehiTaishoshaIchiranSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<KogakuServicehiTaishoshaIchiranSource> occuredBreak(
                    ReportLineRecord<KogakuServicehiTaishoshaIchiranSource> currentRecord,
                    ReportLineRecord<KogakuServicehiTaishoshaIchiranSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }

}
