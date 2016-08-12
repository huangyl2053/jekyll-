/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.seikyugakutsuchishoin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.seikyugakutsuchishoin.SeikyugakuTsuchishoInProperty;
import jp.co.ndensan.reams.db.dbc.business.report.seikyugakutsuchishoin.SeikyugakuTsuchishoInReport;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.seikyugakutsuchishoin.SeikyugakuTsuchishoSource;
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
 * 介護給付費等請求額通知書情報取込一覧表帳票PrintService
 *
 * @reamsid_L DBC-2480-030 jiangwenkai
 */
public class SeikyugakuTsuchishoInIchiranPrintService {

    /**
     * printメソッド(単一帳票出力用)
     *
     * @param 帳票出力対象データリスト List<SeikyugakuTsuchishoEntity>
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
     * 高額介護サービス費給付対象者一覧表 printメソッド(複数帳票出力用)
     *
     * @param 帳票出力対象データリスト List<SeikyugakuTsuchishoEntity>
     * @param 作成日時 RDateTime
     * @param reportManager ReportManager
     */
    public void printFukusu(List<DbWT1511SeikyugakuTsuchishoTempEntity> 帳票出力対象データリスト,
            RDateTime 作成日時, ReportManager reportManager) {
        SeikyugakuTsuchishoInProperty property
                = new SeikyugakuTsuchishoInProperty();
        try (ReportAssembler<SeikyugakuTsuchishoSource> assembler
                = createAssembler(property, reportManager)) {
            ReportSourceWriter<SeikyugakuTsuchishoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new SeikyugakuTsuchishoInReport(帳票出力対象データリスト,
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
