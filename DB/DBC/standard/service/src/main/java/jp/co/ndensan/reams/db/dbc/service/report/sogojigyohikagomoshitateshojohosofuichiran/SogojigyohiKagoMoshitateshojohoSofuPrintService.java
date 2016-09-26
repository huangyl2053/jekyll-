/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.sogojigyohikagomoshitateshojohosofuichiran;

import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagomoshitateshojohosofu.SogojigyohiKagoMoshitateshojohoSofuProperty;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagomoshitateshojohosofu.SogojigyohiKagoMoshitateshojohoSofuReport;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagomoshitateshojohosofuichiran.SogojigyohiKagoMoshitateshojohoSofuSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * 帳票設計_DBC200079_総合事業費過誤申立書情報送付一覧表のPrintServiceクラスです。
 *
 * @reamsid_L DBC-2530-042 zhengshenlei
 */
public class SogojigyohiKagoMoshitateshojohoSofuPrintService {

    /**
     * 帳票設計_DBC200079_総合事業費過誤申立書情報送付一覧表
     *
     * @param 送付一覧表データ KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity
     * @param 出力順情報 IOutputOrder
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param 合計 int
     * @param flag boolean
     * @param 連番 int
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(
            KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity 送付一覧表データ,
            IOutputOrder 出力順情報,
            FlexibleYearMonth 処理年月,
            RDateTime 作成日時,
            int 合計,
            boolean flag,
            int 連番) {
        if (送付一覧表データ == null) {
            return new SourceDataCollection();
        }
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(送付一覧表データ, 出力順情報, 処理年月, 作成日時, 合計, flag, 連番, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     *
     * @param 送付一覧表データ KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity
     * @param 出力順情報 IOutputOrder
     * @param 処理年月 RYearMonth
     * @param 作成日時 RDateTime
     * @param 合計 int
     * @param flag boolean
     * @param 連番 int
     * @param reportManager ReportManager
     */
    public void print(
            KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity 送付一覧表データ,
            IOutputOrder 出力順情報,
            FlexibleYearMonth 処理年月,
            RDateTime 作成日時,
            int 合計,
            boolean flag,
            int 連番,
            ReportManager reportManager) {
        SogojigyohiKagoMoshitateshojohoSofuProperty property = new SogojigyohiKagoMoshitateshojohoSofuProperty();
        try (ReportAssembler<SogojigyohiKagoMoshitateshojohoSofuSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<SogojigyohiKagoMoshitateshojohoSofuSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new SogojigyohiKagoMoshitateshojohoSofuReport(送付一覧表データ, 出力順情報, 処理年月, 作成日時, 合計, flag, 連番).writeBy(reportSourceWriter);
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
