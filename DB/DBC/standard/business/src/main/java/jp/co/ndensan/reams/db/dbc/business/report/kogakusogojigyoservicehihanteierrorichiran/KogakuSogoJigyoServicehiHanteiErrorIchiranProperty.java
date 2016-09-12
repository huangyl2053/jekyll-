/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakusogojigyoservicehihanteierrorichiran;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakusogojigyoservicehihanteierrorichiran.KogakuSogoJigyoServicehiHanteiErrorIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 帳票設計_DBCMN41002_高額総合事業サービス費判定エラーリスト PrintService
 *
 * @reamsid_L DBC-2010-110 sunhui
 */
public class KogakuSogoJigyoServicehiHanteiErrorIchiranProperty
        extends ReportPropertyBase<KogakuSogoJigyoServicehiHanteiErrorIchiranSource> {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(KogakuSogoJigyoServicehiHanteiErrorIchiranSource.ReportSourceFields.listHanteiError_2.name()),
            new RString(KogakuSogoJigyoServicehiHanteiErrorIchiranSource.ReportSourceFields.listHanteiError_4.name()),
            new RString(KogakuSogoJigyoServicehiHanteiErrorIchiranSource.ReportSourceFields.listHanteiError_5.name()),
            new RString(KogakuSogoJigyoServicehiHanteiErrorIchiranSource.ReportSourceFields.listHanteiError_6.name()),
            new RString(KogakuSogoJigyoServicehiHanteiErrorIchiranSource.ReportSourceFields.listHanteiError_7.name())
    ));

    /**
     * インスタンスを生成します。
     */
    public KogakuSogoJigyoServicehiHanteiErrorIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200076.getReportId());
    }

    @Override
    public Breakers<KogakuSogoJigyoServicehiHanteiErrorIchiranSource> defineBreakers(
            Breakers<KogakuSogoJigyoServicehiHanteiErrorIchiranSource> breakers,
            BreakerCatalog<KogakuSogoJigyoServicehiHanteiErrorIchiranSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<KogakuSogoJigyoServicehiHanteiErrorIchiranSource> occuredBreak(
                    ReportLineRecord<KogakuSogoJigyoServicehiHanteiErrorIchiranSource> currentRecord,
                    ReportLineRecord<KogakuSogoJigyoServicehiHanteiErrorIchiranSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
