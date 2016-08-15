/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.sogojigyohiSeikyugakuTsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiSeikyugakuTsuchisho.SogojigyohiSeikyugakuTsuchishoInProperty;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiSeikyugakuTsuchisho.SogojigyohiSeikyugakuTsuchishoInReport;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.dbc120890.SogojigyohiSeikyugakuTsuchishoInSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
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
 * 総合事業費等請求額通知書帳票PrintService
 *
 * @reamsid_L DBC-2480-032 sunqingzhu
 */
public class SogojigyohiSeikyugakuTsuchishoInPrintService {

    /**
     * printメソッド(単一帳票出力用)
     *
     * @param 帳票出力対象データリスト List<DbWT1511SeikyugakuTsuchishoTempEntity>
     * @param 作成日時 RDateTime
     * @return SourceDataCollection
     */
    public SourceDataCollection printTaitsu(List<DbWT1511SeikyugakuTsuchishoTempEntity> 帳票出力対象データリスト,
            RDateTime 作成日時) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            printFukusu(帳票出力対象データリスト, 作成日時, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 総合事業費（経過措置）請求額通知書一覧表 printメソッド(複数帳票出力用)
     *
     * @param 帳票出力対象データリスト List<SogojigyohiSeiEntity>
     * @param 作成日時 RDateTime
     * @param reportManager ReportManager
     */
    public void printFukusu(List<DbWT1511SeikyugakuTsuchishoTempEntity> 帳票出力対象データリスト,
            RDateTime 作成日時, ReportManager reportManager) {
        SogojigyohiSeikyugakuTsuchishoInProperty property
                = new SogojigyohiSeikyugakuTsuchishoInProperty();
        try (ReportAssembler<SogojigyohiSeikyugakuTsuchishoInSource> assembler
                = createAssembler(property, reportManager)) {
            ReportSourceWriter<SogojigyohiSeikyugakuTsuchishoInSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new SogojigyohiSeikyugakuTsuchishoInReport(帳票出力対象データリスト,
                    作成日時).writeBy(reportSourceWriter);
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
