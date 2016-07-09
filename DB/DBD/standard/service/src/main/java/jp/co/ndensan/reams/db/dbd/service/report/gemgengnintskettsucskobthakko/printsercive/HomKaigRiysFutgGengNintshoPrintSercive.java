/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.printsercive;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.homkaigriysfutggengnintsho.HomKaigRiysFutgGengNintshoItem;
import jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.homkaigriysfutggengnintsho.HomKaigRiysFutgGengNintshoProerty;
import jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.homkaigriysfutggengnintsho.HomKaigRiysFutgGengNintshoReport;
import jp.co.ndensan.reams.db.dbd.entity.report.homkaigriysfutggengnintsho.HomonKaigoRiyoshaFutangakuGengakuNinteishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 訪問介護等利用者負担額減額認定証のReportSource
 *
 * @reamsid_L DBD-3540-080 wangchao
 */
public class HomKaigRiysFutgGengNintshoPrintSercive {

    /**
     * 帳票を出力
     *
     * @param targets パラメータ
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(List<HomKaigRiysFutgGengNintshoItem> targets, ReportManager reportManager) {
        HomKaigRiysFutgGengNintshoProerty property = new HomKaigRiysFutgGengNintshoProerty();
        try (ReportAssembler<HomonKaigoRiyoshaFutangakuGengakuNinteishoReportSource> assembler = createAssembler(property, reportManager)) {
            for (HomKaigRiysFutgGengNintshoReport report : toReports(targets)) {
                ReportSourceWriter<HomonKaigoRiyoshaFutangakuGengakuNinteishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    private static List<HomKaigRiysFutgGengNintshoReport> toReports(List<HomKaigRiysFutgGengNintshoItem> targets) {
        List<HomKaigRiysFutgGengNintshoReport> list = new ArrayList();
        for (HomKaigRiysFutgGengNintshoItem item : targets) {
            item.set編集後宛先(JushoHenshu.create編集後宛先(item.getIAtesaki(), item.get地方公共団体(), item.get帳票制御共通()));
            list.add(HomKaigRiysFutgGengNintshoReport.createReport(item));
        }
        return list;
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
