/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.shujiiikensho;

import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho1.ShujiiikenshoEntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho1.ShujiiikenshoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho1.ShujiiikenshoReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho1.ShujiiikenshoReportSource;
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
 * 主治医意見書のPrinterクラスです。
 *
 * @author N3212 竹内 和紀
 */
public class ShujiiIkenshoPrintService {

    private final ReportManager reportManager;

    /**
     * コンストラクタです。
     *
     * @param reportManager ReportManager
     */
    public ShujiiIkenshoPrintService(ReportManager reportManager) {
        this.reportManager = reportManager;
    }

    /**
     * 主治医意見書を印刷します。
     *
     * @param business YokaigoNinteiJohoTeikyoBusiness
     * @param イメージ共有ファイルID イメージ共有ファイルID
     * @param 主治医意見書マスキング区分 主治医意見書マスキング区分
     */
    public void print(YokaigoNinteiJohoTeikyoBusiness business, RDateTime イメージ共有ファイルID, RString 主治医意見書マスキング区分) {
        try (ReportAssembler<ShujiiikenshoReportSource> assembler = createAssembler(new ShujiiikenshoProperty(), reportManager)) {
            ReportSourceWriter<ShujiiikenshoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            ShujiiikenshoReport report = new ShujiiikenshoReport(
                    ShujiiikenshoEntityEditor.edit(business.toEntity(), イメージ共有ファイルID, 主治医意見書マスキング区分));
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
