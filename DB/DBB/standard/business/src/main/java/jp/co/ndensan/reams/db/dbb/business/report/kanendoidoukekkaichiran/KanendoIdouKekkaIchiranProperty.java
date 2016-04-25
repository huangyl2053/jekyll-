/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendoidoukekkaichiran;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendoidoukekkaichiran.KanendoIdouKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog.SimplePageBreaker;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 帳票設計_DBBRP45001_2_本算定異動（過年度）結果一覧表のプロパティです。
 *
 * @reamsid_L DBB-0910-030 zhangrui
 *
 */
public class KanendoIdouKekkaIchiranProperty extends ReportPropertyBase<KanendoIdouKekkaIchiranSource> {

    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(
                            new RString("kaipage1"),
                            new RString("kaipage2"),
                            new RString("kaipage3"),
                            new RString("kaipage4"),
                            new RString("kaipage5"),
                            new RString("nendoBun1"),
                            new RString("nendoBun2")));

    /**
     * コンストラクタです。
     *
     */
    public KanendoIdouKekkaIchiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200027.getReportId());
    }

    @Override
    public Breakers<KanendoIdouKekkaIchiranSource> defineBreakers(
            Breakers<KanendoIdouKekkaIchiranSource> breakers,
            BreakerCatalog<KanendoIdouKekkaIchiranSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(


            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<KanendoIdouKekkaIchiranSource> occuredBreak(
                    ReportLineRecord<KanendoIdouKekkaIchiranSource> currentRecord,
                    ReportLineRecord<KanendoIdouKekkaIchiranSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }

}
