/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.tokkijiko;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.NinteichosaRelate;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokkiimage.NinteiChosaTokkiImageEntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokkiimage.NinteiChosaTokkiImageProperty;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokkiimage.NinteiChosaTokkiImageReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosatokkiimage.NinteiChosaTokkiImageReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
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
 * 特記事項(イメージ)のPrinterクラスです。
 *
 * @author N3212 竹内 和紀
 */
public class NinteiChosaTokkiImagePrintService implements ITokkiJikoPrintService {

    private final ReportManager reportManager;

    /**
     * コンストラクタです。
     *
     * @param reportManager
     */
    public NinteiChosaTokkiImagePrintService(ReportManager reportManager) {
        this.reportManager = reportManager;
    }

    @Override
    public void print(YokaigoNinteiJohoTeikyoBusiness business, List<NinteichosaRelate> 特記事項List,
            RString 特記事項マスキング区分, RDateTime イメージ共有ファイルID) {
        try (ReportAssembler<NinteiChosaTokkiImageReportSource> assembler = createAssembler(new NinteiChosaTokkiImageProperty(), reportManager)) {
            ReportSourceWriter<NinteiChosaTokkiImageReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            NinteiChosaTokkiImageReport report = new NinteiChosaTokkiImageReport(
                    NinteiChosaTokkiImageEntityEditor.edit(business.toEntity(), 特記事項List, 特記事項マスキング区分));
            report.writeBy(reportSourceWriter);
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
