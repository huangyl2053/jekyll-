/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.kijunshunyugakutekiyooshirasetsuchisho;

import jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugakutekiyoshinseisho.KijunShunyugakuTekiyoShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyooshirasetsuchisho.KijunShunyugakuTekiyoOshiraseTsuchishoProperty;
import jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyooshirasetsuchisho.KijunShunyugakuTekiyoOshiraseTsuchishoReport;
import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyooshirasetsuchisho.KijunShunyugakuTekiyoOshiraseTsuchishoSource;
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
 * 帳票設計_DBC100063_基準収入額適用お知らせ通知書 PrintServiceクラスです。
 *
 * @reamsid_L DBC-4640-050 lijian
 */
public class KijunShunyugakuTekiyoOshiraseTsuchishoPrintService {

    /**
     * 帳票設計_DBC100063_基準収入額適用お知らせ通知書 (単一帳票出力用)
     *
     * @param 基準収入額適用Entity KijunShunyugakuTekiyoShinseishoEntity
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(KijunShunyugakuTekiyoShinseishoEntity 基準収入額適用Entity) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(基準収入額適用Entity, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票設計_DBC100063_基準収入額適用お知らせ通知書(複数帳票出力用)。
     *
     * @param 基準収入額適用Entity KijunShunyugakuTekiyoShinseishoEntity
     * @param reportManager ReportManager
     */
    public void print(
            KijunShunyugakuTekiyoShinseishoEntity 基準収入額適用Entity,
            ReportManager reportManager) {
        KijunShunyugakuTekiyoOshiraseTsuchishoProperty property = new KijunShunyugakuTekiyoOshiraseTsuchishoProperty();

        try (ReportAssembler<KijunShunyugakuTekiyoOshiraseTsuchishoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KijunShunyugakuTekiyoOshiraseTsuchishoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new KijunShunyugakuTekiyoOshiraseTsuchishoReport(基準収入額適用Entity).writeBy(reportSourceWriter);

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
