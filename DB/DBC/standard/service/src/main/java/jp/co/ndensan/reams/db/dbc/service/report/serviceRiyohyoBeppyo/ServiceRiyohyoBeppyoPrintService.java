/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.serviceRiyohyoBeppyo;

import jp.co.ndensan.reams.db.dbc.business.core.serviceriyohyobeppyo.ServiceRiyohyoBeppyoParameter;
import jp.co.ndensan.reams.db.dbc.business.report.serviceRiyohyoBeppyo.ServiceRiyohyoBeppyoProperty;
import jp.co.ndensan.reams.db.dbc.business.report.serviceRiyohyoBeppyo.ServiceRiyohyoBeppyoReport;
import jp.co.ndensan.reams.db.dbc.entity.report.source.serviceRiyohyoBeppyo.ServiceRiyohyoBeppyoSource;
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
 * 帳票設計_DBC0150011_1_サービス提供票別表PrintServiceのインターフェースクラスです。
 *
 * @reamsid_L DBC-5100-030 tianshuai
 */
public class ServiceRiyohyoBeppyoPrintService {

    /**
     * サービス提供票別表(単一帳票出力用)
     *
     * @param parameter サービス提供票別表parameter
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(
            ServiceRiyohyoBeppyoParameter parameter) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            if (parameter != null) {
                print(parameter, reportManager);
            }
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * printメソッドします。
     *
     * @param parameter サービス提供票別表parameter
     * @param reportManager ReportManager
     */
    public void print(ServiceRiyohyoBeppyoParameter parameter, ReportManager reportManager) {
        ServiceRiyohyoBeppyoProperty property = new ServiceRiyohyoBeppyoProperty();
        try (ReportAssembler<ServiceRiyohyoBeppyoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<ServiceRiyohyoBeppyoSource> reportSourceWriter = new ReportSourceWriter(assembler);
            new ServiceRiyohyoBeppyoReport(parameter.get帳票情報マップ(),
                    parameter.get合計情報(), parameter.get帳票ヘッダー(), parameter.get作成日時(), parameter.get利用年月(),
                    parameter.get種類別支給限度情報(), parameter.get短期入所情報()).writeBy(reportSourceWriter);
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
