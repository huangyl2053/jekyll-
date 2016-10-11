/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.furikomimeisaiichiran;

import jp.co.ndensan.reams.db.dbc.business.report.furikomimeisaiichiran.FurikomiMeisaiIchiranProperty;
import jp.co.ndensan.reams.db.dbc.business.report.furikomimeisaiichiran.FurikomiMeisaiIchiranReport;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.furikaego.FurikaeGoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiran.FurikomiMeisaiIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
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
 * 帳票設計_DBC200003_振込明細一覧表（高額合算） PrintServiceクラスです。
 *
 * @reamsid_L DBC-4870-060 lijian
 */
public class FurikomiMeisaiIchiranPrintService {

    /**
     * 帳票設計_DBC200003_事業合算・事業分振込明細書作成（一括）(単一帳票出力用)
     *
     * @param 振込明細一覧Entity FurikaeGoMeisaiEntity
     * @param 出力順情報 IOutputOrder
     * @param 番号 int
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(FurikaeGoMeisaiEntity 振込明細一覧Entity, IOutputOrder 出力順情報, int 番号) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(振込明細一覧Entity, 出力順情報, 番号, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票設計_DBC200003_振込明細一覧表（高額合算）(複数帳票出力用)
     *
     * @param 振込明細一覧Entity FurikaeGoMeisaiEntity
     * @param 出力順情報 IOutputOrder
     * @param 番号 int
     * @param reportManager ReportManager
     */
    public void print(FurikaeGoMeisaiEntity 振込明細一覧Entity, IOutputOrder 出力順情報, int 番号, ReportManager reportManager) {
        FurikomiMeisaiIchiranProperty property = new FurikomiMeisaiIchiranProperty();
        try (ReportAssembler<FurikomiMeisaiIchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<FurikomiMeisaiIchiranSource> reportSourceWriter = new ReportSourceWriter(assembler);
            new FurikomiMeisaiIchiranReport(振込明細一覧Entity, 出力順情報, 番号).writeBy(reportSourceWriter);
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
