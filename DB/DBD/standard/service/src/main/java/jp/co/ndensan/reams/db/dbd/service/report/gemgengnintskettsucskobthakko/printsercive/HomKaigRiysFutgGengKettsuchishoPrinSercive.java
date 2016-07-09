/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.printsercive;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.homkaigriysfutggengkettsuchisho.HomKaigRiysFutgGengKettsuchishoItem;
import jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.homkaigriysfutggengkettsuchisho.HomKaigRiysFutgGengKettsuchishoProerty;
import jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.homkaigriysfutggengkettsuchisho.HomKaigRiysFutgGengKettsuchishoReport;
import jp.co.ndensan.reams.db.dbd.entity.report.homkaigriysfutggengkettsuchisho.HomonKaigoRiyoshaFutangakuGengakuKetteiTsuchishoReportSource;
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
 * 訪問介護等利用者負担額減額決定通知書のReportSource
 *
 * @reamsid_L DBD-3540-090 wangchao
 */
public class HomKaigRiysFutgGengKettsuchishoPrinSercive {

    /**
     * 帳票を出力
     *
     * @param targets パラメータ
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(List<HomKaigRiysFutgGengKettsuchishoItem> targets, ReportManager reportManager) {
        HomKaigRiysFutgGengKettsuchishoProerty property = new HomKaigRiysFutgGengKettsuchishoProerty();
        try (ReportAssembler<HomonKaigoRiyoshaFutangakuGengakuKetteiTsuchishoReportSource> assembler = createAssembler(property, reportManager)) {
            for (HomKaigRiysFutgGengKettsuchishoReport report : toReports(targets)) {
                ReportSourceWriter<HomonKaigoRiyoshaFutangakuGengakuKetteiTsuchishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    private static List<HomKaigRiysFutgGengKettsuchishoReport> toReports(List<HomKaigRiysFutgGengKettsuchishoItem> targets) {
        List<HomKaigRiysFutgGengKettsuchishoReport> list = new ArrayList();
        for (HomKaigRiysFutgGengKettsuchishoItem item : targets) {
            item.set編集後宛先(JushoHenshu.create編集後宛先(item.getIAtesaki(), item.get地方公共団体(), item.get帳票制御共通()));
            list.add(HomKaigRiysFutgGengKettsuchishoReport.createReport(item));
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
