/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.seikyugakutsuchishokohifutanshabun;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.seikyugakutsuchishokohifutanshabun.SeikyugakuTsuchishoKohifutanshabunProperty;
import jp.co.ndensan.reams.db.dbc.business.report.seikyugakutsuchishokohifutanshabun.SeikyugakuTsuchishoKohifutanshabunReport;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.seikyugakutsuchishokohifutanshabun.SeikyugakuTsuchishoKohifutanshabunSource;
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
 * 帳票設計_DBC200067_介護給付費等請求額通知書（公費負担者分）PrintServiceクラスです。
 *
 * @reamsid_L DBC-2790-030 lijian
 */
public class SeikyugakuTsuchishoKohifutanshabunPrintService {

    /**
     * 介護給付費等請求額通知書（公費負担者分）(単一帳票出力用)
     *
     * @param 請求額通知書帳票用データリスト List<DbWT1511SeikyugakuTsuchishoTempEntity>
     * @param 作成日時 RDateTime
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(
            List<DbWT1511SeikyugakuTsuchishoTempEntity> 請求額通知書帳票用データリスト,
            RDateTime 作成日時) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(請求額通知書帳票用データリスト, 作成日時, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 介護給付費等請求額通知書（公費負担者分）(複数帳票出力用)。
     *
     * @param 請求額通知書帳票用データリスト List<DbWT1511SeikyugakuTsuchishoTempEntity>
     * @param 作成日時 RDateTime
     * @param reportManager ReportManager
     */
    public void print(
            List<DbWT1511SeikyugakuTsuchishoTempEntity> 請求額通知書帳票用データリスト,
            RDateTime 作成日時,
            ReportManager reportManager) {
        SeikyugakuTsuchishoKohifutanshabunProperty property = new SeikyugakuTsuchishoKohifutanshabunProperty();
        try (ReportAssembler<SeikyugakuTsuchishoKohifutanshabunSource> assembler = createAssembler(property, reportManager)) {

            ReportSourceWriter<SeikyugakuTsuchishoKohifutanshabunSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            if (null == 請求額通知書帳票用データリスト || 請求額通知書帳票用データリスト.isEmpty()) {
                return;
            }

            for (int i = 0; i < 請求額通知書帳票用データリスト.size(); i++) {

                new SeikyugakuTsuchishoKohifutanshabunReport(
                        請求額通知書帳票用データリスト.get(i),
                        作成日時
                ).writeBy(reportSourceWriter);
            }
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
