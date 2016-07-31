/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuservicehihanteierrorichiran;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteierrorichiran.KogakuServicehiHanteiErrorIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 帳票設計_DBCMN41002_高額介護サービス費判定エラーリスト Property
 *
 * @reamsid_L DBC-2010-110 sunhui
 */
public class KogakuServicehiHanteiErrorIchiranProperty
        extends ReportPropertyBase<KogakuServicehiHanteiErrorIchiranSource> {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(KogakuServicehiHanteiErrorIchiranSource.ReportSourceFields.listHanteiError_2.name()),
            new RString(KogakuServicehiHanteiErrorIchiranSource.ReportSourceFields.listHanteiError_4.name()),
            new RString(KogakuServicehiHanteiErrorIchiranSource.ReportSourceFields.listHanteiError_5.name()),
            new RString(KogakuServicehiHanteiErrorIchiranSource.ReportSourceFields.listHanteiError_6.name()),
            new RString(KogakuServicehiHanteiErrorIchiranSource.ReportSourceFields.listHanteiError_7.name())
    ));

    /**
     * インスタンスを生成します。
     */
    public KogakuServicehiHanteiErrorIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200018.getReportId());
    }

    @Override
    public Breakers<KogakuServicehiHanteiErrorIchiranSource> defineBreakers(
            Breakers<KogakuServicehiHanteiErrorIchiranSource> breakers,
            BreakerCatalog<KogakuServicehiHanteiErrorIchiranSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<KogakuServicehiHanteiErrorIchiranSource> occuredBreak(
                    ReportLineRecord<KogakuServicehiHanteiErrorIchiranSource> currentRecord,
                    ReportLineRecord<KogakuServicehiHanteiErrorIchiranSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
