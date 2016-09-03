/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.gassanshikyugakukeisankekkasofuichiran;

import jp.co.ndensan.reams.db.dbc.business.report.gassanshikyugakukeisankekkasofuichiran.GassanShikyugakuKeisankekkaSofuIchiranProperty;
import jp.co.ndensan.reams.db.dbc.business.report.gassanshikyugakukeisankekkasofuichiran.GassanShikyugakuKeisankekkaSofuIchiranReport;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070.GassanShikyugakuKeisankekkaRanrakuhyoSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanshikyugakukeisankekkasofuichiran.GassanShikyugakuKeisankekkaSofuIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
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
 * 帳票設計_DBC200036_高額合算支給額計算結果連絡票情報送付一覧表 PrintServiceクラスです。
 *
 * @reamsid_L DBC-2670-040 lijian
 */
public class GassanShikyugakuKeisankekkaSofuIchiranPrintService {

    /**
     * 帳票設計_DBC200036_高額合算支給額計算結果連絡票情報送付一覧表 (単一帳票出力用)
     *
     * @param 送付一覧表データ GassanShikyugakuKeisankekkaRanrakuhyoSofuEntity
     * @param 出力順情報 IOutputOrder
     * @param 処理年月 RYearMonth
     * @param 作成日時 YMDHMS
     * @param 連番 int
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(
            GassanShikyugakuKeisankekkaRanrakuhyoSofuEntity 送付一覧表データ,
            IOutputOrder 出力順情報,
            RYearMonth 処理年月,
            YMDHMS 作成日時,
            int 連番) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(送付一覧表データ, 出力順情報, 処理年月, 作成日時, 連番, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票設計_DBC200036_高額合算支給額計算結果連絡票情報送付一覧表 (複数帳票出力用)
     *
     * @param 送付一覧表データ GassanShikyugakuKeisankekkaRanrakuhyoSofuEntity
     * @param 出力順情報 IOutputOrder
     * @param 処理年月 RYearMonth
     * @param 作成日時 YMDHMS
     * @param 連番 int
     * @param reportManager ReportManager
     */
    public void print(
            GassanShikyugakuKeisankekkaRanrakuhyoSofuEntity 送付一覧表データ,
            IOutputOrder 出力順情報,
            RYearMonth 処理年月,
            YMDHMS 作成日時,
            int 連番,
            ReportManager reportManager) {
        GassanShikyugakuKeisankekkaSofuIchiranProperty property = new GassanShikyugakuKeisankekkaSofuIchiranProperty();

        try (ReportAssembler<GassanShikyugakuKeisankekkaSofuIchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<GassanShikyugakuKeisankekkaSofuIchiranSource> reportSourceWriter = new ReportSourceWriter(assembler);
            new GassanShikyugakuKeisankekkaSofuIchiranReport(
                    送付一覧表データ,
                    出力順情報,
                    処理年月,
                    作成日時,
                    連番).writeBy(reportSourceWriter);
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
