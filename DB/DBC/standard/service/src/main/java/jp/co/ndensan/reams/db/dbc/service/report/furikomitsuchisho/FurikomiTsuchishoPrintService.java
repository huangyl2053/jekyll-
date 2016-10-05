/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.furikomitsuchisho;

import jp.co.ndensan.reams.db.dbc.business.report.furikomitsuchisho.FurikomiTsuchishoProperty;
import jp.co.ndensan.reams.db.dbc.business.report.furikomitsuchisho.FurikomiTsuchishoReport;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.furikaego.FurikaeGoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomitsuchisho.FurikomiTsuchishoSource;
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
 * 帳票設計_DBC100060_事業合算・事業分振込明細書作成（一括） PrintServiceクラスです。
 *
 * @reamsid_L DBC-4870-050 lijian
 */
public class FurikomiTsuchishoPrintService {

    /**
     * 帳票設計_DBC100060_事業合算・事業分振込明細書作成（一括） (単一帳票出力用)
     *
     * @param 振込Entity FurikaeGoEntity
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(FurikaeGoEntity 振込Entity) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(振込Entity, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票設計_DBC100060_事業合算・事業分振込明細書作成（一括）(複数帳票出力用)
     *
     * @param 振込Entity FurikaeGoEntity
     * @param reportManager ReportManager
     */
    public void print(FurikaeGoEntity 振込Entity, ReportManager reportManager) {
        FurikomiTsuchishoProperty property = new FurikomiTsuchishoProperty();
        try (ReportAssembler<FurikomiTsuchishoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<FurikomiTsuchishoSource> reportSourceWriter = new ReportSourceWriter(assembler);
            new FurikomiTsuchishoReport(振込Entity).writeBy(reportSourceWriter);
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
