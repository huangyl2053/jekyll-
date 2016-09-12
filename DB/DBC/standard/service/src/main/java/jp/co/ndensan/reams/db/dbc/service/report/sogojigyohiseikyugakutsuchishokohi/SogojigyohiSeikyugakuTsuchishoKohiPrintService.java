/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.sogojigyohiseikyugakutsuchishokohi;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiseikyugakutsuchishokohi.SogojigyohiSeikyugakuTsuchishoKohiProperty;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiseikyugakutsuchishokohi.SogojigyohiSeikyugakuTsuchishoKohiReport;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohiseikyugakutsuchishokohi.SogojigyohiSeikyugakuTsuchishoKohiSource;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
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
 * 総合事業費等請求額通知書（公費負担者分）帳票PrintService
 *
 * @reamsid_L DBC-4700-040 zhangyaru
 */
public class SogojigyohiSeikyugakuTsuchishoKohiPrintService {

    /**
     * printメソッド(単一帳票出力用)
     *
     * @param parameterList List<DbWT1511SeikyugakuTsuchishoTempEntity>
     * @param 帳票作成日時 YMDHMS
     * @return collection
     */
    public SourceDataCollection printSingle(List<DbWT1511SeikyugakuTsuchishoTempEntity> parameterList,
            YMDHMS 帳票作成日時) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(parameterList, 帳票作成日時, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    private void print(List<DbWT1511SeikyugakuTsuchishoTempEntity> parameterList,
            YMDHMS 帳票作成日時,
            ReportManager reportManager) {
        SogojigyohiSeikyugakuTsuchishoKohiProperty property = new SogojigyohiSeikyugakuTsuchishoKohiProperty();
        try (ReportAssembler<SogojigyohiSeikyugakuTsuchishoKohiSource> assembler
                = createAssembler(property, reportManager)) {
            ReportSourceWriter<SogojigyohiSeikyugakuTsuchishoKohiSource> reportSourceWriter;
            reportSourceWriter = new ReportSourceWriter(assembler);
            executereport(parameterList, 帳票作成日時, reportSourceWriter);

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

    private void executereport(List<DbWT1511SeikyugakuTsuchishoTempEntity> parameterList,
            YMDHMS 帳票作成日時,
            ReportSourceWriter reportSourceWriter) {
        for (DbWT1511SeikyugakuTsuchishoTempEntity 請求額通知書情報 : parameterList) {
            SogojigyohiSeikyugakuTsuchishoKohiReport report = new SogojigyohiSeikyugakuTsuchishoKohiReport(請求額通知書情報, 帳票作成日時);
            report.writeBy(reportSourceWriter);
        }

    }
}
