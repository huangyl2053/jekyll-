/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.gassankyufujissekisofuichiran;

import jp.co.ndensan.reams.db.dbc.business.report.gassankyufujissekisofuichiran.GassanKyufujissekiSofuIchiranProperty;
import jp.co.ndensan.reams.db.dbc.business.report.gassankyufujissekisofuichiran.GassanKyufujissekiSofuIchiranReport;
import jp.co.ndensan.reams.db.dbc.business.report.kogakugassan.KogakugassanKyufujissekiDoSofuReportEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassankyufujissekisofuichiran.GassanKyufujissekiSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 *
 * 帳票設計_DBC200042_高額合算給付実績情報送付一覧表のPrintServiceクラスです。
 *
 * @reamsid_L DBC-2710-040 qinzhen
 */
public class GassanKyufujissekiSofuIchiranPrintService {

    /**
     * 帳票設計_DBC200042_高額合算給付実績情報送付一覧表(単一帳票出力用)
     *
     * @param 出力用受給者訂正情報Entity KogakugassanKyufujissekiDoSofuReportEntity
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(
            KogakugassanKyufujissekiDoSofuReportEntity 出力用受給者訂正情報Entity) {
        if (出力用受給者訂正情報Entity == null) {
            return new SourceDataCollection();
        }
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(出力用受給者訂正情報Entity, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票設計_DBC200042_高額合算給付実績情報送付一覧表(複数帳票出力用)。
     *
     * @param 出力用受給者訂正情報Entity KogakugassanKyufujissekiDoSofuReportEntity
     * @param reportManager ReportManager
     */
    public void print(
            KogakugassanKyufujissekiDoSofuReportEntity 出力用受給者訂正情報Entity,
            ReportManager reportManager) {
        GassanKyufujissekiSofuIchiranProperty property = new GassanKyufujissekiSofuIchiranProperty();

        try (ReportAssembler<GassanKyufujissekiSofuIchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<GassanKyufujissekiSofuIchiranSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            new GassanKyufujissekiSofuIchiranReport(出力用受給者訂正情報Entity).writeBy(reportSourceWriter);
        }
    }

    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(
            IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }
}
