/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.sogojigyohikagomoshitateshojohosofuIchiran;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagomoshitateshojohosofuIchiran.SogojigyohiKagoMoshitateshojohoSofuIchiranProperty;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagomoshitateshojohosofuIchiran.SogojigyohiKagoMoshitateshojohoSofuIchiranReport;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.sogojigyohikagomoshitateshojohosofuIchiran.SogojigyohiKagoMoshitateshojohoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * 帳票設計_DBC200046_総合事業費（経過措置）過誤申立書情報送付一覧表 PrintServiceクラスです。
 *
 * @reamsid_L DBC-2530-041 liuxiaoyu
 */
public class SogojigyohiKagoMoshitateshojohoSofuIchiranPrintService {

    /**
     * 帳票設計_DBC200046_総合事業費（経過措置）過誤申立書情報送付一覧表(単一帳票出力用)
     *
     ** @param 帳票出力対象データ KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity
     * @param 出力順Map Map<RString, RString>
     * @param 作成日時 RDateTime
     * @param 合計出力flag boolean
     * @param 改頁リスト List<RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 件数 int
     * @param 連番
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(
            KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity 帳票出力対象データ,
            Map<RString, RString> 出力順Map,
            RDateTime 作成日時,
            boolean 合計出力flag,
            List<RString> 改頁リスト,
            FlexibleYearMonth 処理年月,
            int 件数,
            int 連番) {
        if (帳票出力対象データ == null) {
            return new SourceDataCollection();
        }
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(帳票出力対象データ, 出力順Map, 作成日時, 合計出力flag, 改頁リスト, 処理年月, 件数, 連番, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票設計_DBC200046_総合事業費（経過措置）過誤申立書情報送付一覧表(複数帳票出力用)。
     *
     * @param 帳票出力対象データ KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity
     * @param 出力順Map Map<RString, RString>
     * @param 作成日時 RDateTime
     * @param 合計出力flag boolean
     * @param 改頁リスト List<RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 件数 int
     * @param 連番 int
     * @param reportManager ReportManager
     */
    public void print(
            KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity 帳票出力対象データ,
            Map<RString, RString> 出力順Map,
            RDateTime 作成日時,
            boolean 合計出力flag,
            List<RString> 改頁リスト,
            FlexibleYearMonth 処理年月,
            int 件数,
            int 連番,
            ReportManager reportManager) {
        SogojigyohiKagoMoshitateshojohoSofuIchiranProperty property = new SogojigyohiKagoMoshitateshojohoSofuIchiranProperty();
        try (ReportAssembler<SogojigyohiKagoMoshitateshojohoSofuIchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<SogojigyohiKagoMoshitateshojohoSofuIchiranSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new SogojigyohiKagoMoshitateshojohoSofuIchiranReport(
                    帳票出力対象データ, 出力順Map, 作成日時, 合計出力flag, 改頁リスト, 処理年月, 件数, 連番).writeBy(reportSourceWriter);
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
