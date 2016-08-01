/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd550003;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd550003.YokaigodoHenkoTshuchishoProperty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd550003.YokaigodoHenkoTshuchishoReport;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.ninteikekkatshuchishohakko.YokaigodoHenkoTsuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd550003.YokaigodoHenkoTshuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 要介護度変更通知書
 *
 * @reamsid_L DBD-1430-050 b_zhengs
 */
public class YokaigodoHenkoTshuchishoPrintService {

    /**
     * 帳票を出力
     *
     * @param entity YokaigodoHenkoTsuchishoEntity
     * @param 通知書定型文リスト List<RString>
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(YokaigodoHenkoTsuchishoEntity entity, List<RString> 通知書定型文リスト, ChohyoSeigyoKyotsu 帳票制御共通, ReportManager reportManager) {
        YokaigodoHenkoTshuchishoProperty property = new YokaigodoHenkoTshuchishoProperty();
        try (ReportAssembler<YokaigodoHenkoTshuchishoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<YokaigodoHenkoTshuchishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            YokaigodoHenkoTshuchishoReport report = YokaigodoHenkoTshuchishoReport.createReport(entity,
                    通知書定型文リスト,
                    帳票制御共通);
            report.writeBy(reportSourceWriter);
        }
    }

    private <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }

}
