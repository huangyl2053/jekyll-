/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakusogojigyoservicehitaishoshaichiran;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakusogojigyoservicehitaishoshaichiran.KogakuSogoJigyoServiceHiTaishoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog.SimplePageBreaker;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 高額総合事業サービス費対象者一覧表Property
 *
 * @reamsid_L DBC-2010-120 surun
 */
public class KogakuSogoJigyoServiceHiTaishoshaIchiranProperty extends
        ReportPropertyBase<KogakuSogoJigyoServiceHiTaishoshaIchiranSource> {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(KogakuSogoJigyoServiceHiTaishoshaIchiranSource.ReportSourceFields.listTaishoshaIchiran_2.name()),
            new RString(KogakuSogoJigyoServiceHiTaishoshaIchiranSource.ReportSourceFields.listTaishoshaIchiran_4.name()),
            new RString(KogakuSogoJigyoServiceHiTaishoshaIchiranSource.ReportSourceFields.listTaishoshaIchiran_6.name()),
            new RString(KogakuSogoJigyoServiceHiTaishoshaIchiranSource.ReportSourceFields.listTaishoshaIchiran_3.name()),
            new RString(KogakuSogoJigyoServiceHiTaishoshaIchiranSource.ReportSourceFields.listTaishoshaIchiran_5.name())
    ));

    /**
     * コンストラクタです。
     */
    public KogakuSogoJigyoServiceHiTaishoshaIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200077.getReportId());
    }

    @Override
    public Breakers<KogakuSogoJigyoServiceHiTaishoshaIchiranSource> defineBreakers(
            Breakers<KogakuSogoJigyoServiceHiTaishoshaIchiranSource> breakers,
            BreakerCatalog<KogakuSogoJigyoServiceHiTaishoshaIchiranSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(



            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<KogakuSogoJigyoServiceHiTaishoshaIchiranSource> occuredBreak(
                    ReportLineRecord<KogakuSogoJigyoServiceHiTaishoshaIchiranSource> currentRecord,
                    ReportLineRecord<KogakuSogoJigyoServiceHiTaishoshaIchiranSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
