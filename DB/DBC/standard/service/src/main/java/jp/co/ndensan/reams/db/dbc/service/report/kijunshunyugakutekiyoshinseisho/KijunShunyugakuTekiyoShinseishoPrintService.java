/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.kijunshunyugakutekiyoshinseisho;

import jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugakutekiyoshinseisho.KijunShunyugakuTekiyoShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoshinseisho.KijunShunyugakuTekiyoShinseishoProperty;
import jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoshinseisho.KijunShunyugakuTekiyoShinseishoReport;
import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoshinseisho.KijunShunyugakuTekiyoShinseishoSource;
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
 * 帳票設計_DBC100064_基準収入額適用申請書 PrintServiceクラスです。
 *
 * @reamsid_L DBC-4640-040 lijian
 */
public class KijunShunyugakuTekiyoShinseishoPrintService {

    /**
     * 帳票設計_DBC100064_基準収入額適用申請書 (単一帳票出力用)
     *
     * @param 基準収入額適用申請書Entity KijunShunyugakuTekiyoShinseishoEntity
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(KijunShunyugakuTekiyoShinseishoEntity 基準収入額適用申請書Entity) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(基準収入額適用申請書Entity, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票設計_DBC100064_基準収入額適用申請書(複数帳票出力用)。
     *
     * @param 基準収入額適用申請書Entity KijunShunyugakuTekiyoShinseishoEntity
     * @param reportManager ReportManager
     */
    public void print(
            KijunShunyugakuTekiyoShinseishoEntity 基準収入額適用申請書Entity,
            ReportManager reportManager) {
        KijunShunyugakuTekiyoShinseishoProperty property = new KijunShunyugakuTekiyoShinseishoProperty();

        try (ReportAssembler<KijunShunyugakuTekiyoShinseishoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KijunShunyugakuTekiyoShinseishoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new KijunShunyugakuTekiyoShinseishoReport(基準収入額適用申請書Entity).writeBy(reportSourceWriter);

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
