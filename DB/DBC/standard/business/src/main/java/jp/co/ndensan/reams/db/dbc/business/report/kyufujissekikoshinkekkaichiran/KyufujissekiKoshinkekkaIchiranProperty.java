/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufujissekikoshinkekkaichiran;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinkekkaichiran.KyufujissekiKoshinkekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 帳票設計_DBC200054_給付実績更新結果情報一覧表 Property
 *
 * @reamsid_L DBC-2470-030 surun
 */
public class KyufujissekiKoshinkekkaIchiranProperty extends ReportPropertyBase<KyufujissekiKoshinkekkaIchiranSource> {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(KyufujissekiKoshinkekkaIchiranSource.ReportSourceFields.hokenshaNo.name()),
            new RString(KyufujissekiKoshinkekkaIchiranSource.ReportSourceFields.listUpper_5.name()),
            new RString(KyufujissekiKoshinkekkaIchiranSource.ReportSourceFields.listUpper_7.name()),
            new RString(KyufujissekiKoshinkekkaIchiranSource.ReportSourceFields.listUpper_9.name()),
            new RString(KyufujissekiKoshinkekkaIchiranSource.ReportSourceFields.listUpper_2.name()),
            new RString(KyufujissekiKoshinkekkaIchiranSource.ReportSourceFields.listUpper_10.name())
    ));

    /**
     * インスタンスを生成します。
     */
    public KyufujissekiKoshinkekkaIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200054.getReportId());
    }

    @Override
    public Breakers<KyufujissekiKoshinkekkaIchiranSource> defineBreakers(
            Breakers<KyufujissekiKoshinkekkaIchiranSource> breakers,
            BreakerCatalog<KyufujissekiKoshinkekkaIchiranSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<KyufujissekiKoshinkekkaIchiranSource> occuredBreak(
                    ReportLineRecord<KyufujissekiKoshinkekkaIchiranSource> currentRecord,
                    ReportLineRecord<KyufujissekiKoshinkekkaIchiranSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
