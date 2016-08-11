/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.sogojigyohisei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiseikyugakutsuchishokeikasochi.SogojigyohiSeikyugakuTsuchishoKeikaSochiProperty;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiseikyugakutsuchishokeikasochi.SogojigyohiSeikyugakuTsuchishoKeikaSochiReport;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.SogojigyohiSeiDoIchiranhyoSakusei.SogojigyohiSeikyugakuTsuchishoKeikaSochiSource;
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
 * 総合事業費（経過措置）請求額通知書一覧表帳票PrintService
 *
 * @reamsid_L DBC-2480-031 jiangxiaolong
 */
public class SogojigyohiSeikyugakuTsuchishoKeikaSochiPrintService {

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
     * @param 帳票出力対象データリスト List<DbWT1511SeikyugakuTsuchishoTempEntity>
     * @param 作成日時 RDateTime
     * @param reportManager ReportManager
     */
    public void printFukusu(List<DbWT1511SeikyugakuTsuchishoTempEntity> 帳票出力対象データリスト,
            RDateTime 作成日時, ReportManager reportManager) {
        SogojigyohiSeikyugakuTsuchishoKeikaSochiProperty property
                = new SogojigyohiSeikyugakuTsuchishoKeikaSochiProperty();
        try (ReportAssembler<SogojigyohiSeikyugakuTsuchishoKeikaSochiSource> assembler
                = createAssembler(property, reportManager)) {
            ReportSourceWriter<SogojigyohiSeikyugakuTsuchishoKeikaSochiSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new SogojigyohiSeikyugakuTsuchishoKeikaSochiReport(帳票出力対象データリスト,
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
