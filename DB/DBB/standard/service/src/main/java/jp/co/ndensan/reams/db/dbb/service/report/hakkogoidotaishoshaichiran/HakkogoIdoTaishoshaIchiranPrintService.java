/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.hakkogoidotaishoshaichiran;

import javax.validation.constraints.NotNull;
import jp.co.ndensan.reams.db.dbb.business.core.tsuchishohakkogoidosha.TsuchiShoHakkogoIdoshaListJoho;
import jp.co.ndensan.reams.db.dbb.business.report.hakkogoidotaishoshaichiran.HakkogoIdoTaishoshaIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.hakkogoidotaishoshaichiran.HakkogoIdoTaishoshaIchiranReport;
import jp.co.ndensan.reams.db.dbb.entity.report.hakkogoidotaishoshaichiran.HakkogoIdoTaishoshaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
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
 * DBBRP32001_通知書発行後異動把握帳票PrintService
 *
 * @reamsid_L DBB-0690-030 surun
 */
public class HakkogoIdoTaishoshaIchiranPrintService {

    /**
     * printメソッド
     *
     * @param 発行後異動者一覧情報 TsuchiShoHakkogoIdoshaListJoho
     * @param 導入団体クラス Association
     * @param 帳票作成日時 YMDHMS
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(
            @NotNull TsuchiShoHakkogoIdoshaListJoho 発行後異動者一覧情報,
            @NotNull Association 導入団体クラス,
            @NotNull YMDHMS 帳票作成日時) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(発行後異動者一覧情報, 導入団体クラス, 帳票作成日時, reportManager);
            collection = reportManager.publish();
        }
        return collection;

    }

    /**
     * print
     *
     * @param 発行後異動者一覧情報 TsuchiShoHakkogoIdoshaListJoho
     * @param 導入団体クラス Association
     * @param 帳票作成日時 YMDHMS
     * @param reportManager ReportManager
     */
    public void print(TsuchiShoHakkogoIdoshaListJoho 発行後異動者一覧情報, Association 導入団体クラス,
            YMDHMS 帳票作成日時, ReportManager reportManager) {
        HakkogoIdoTaishoshaIchiranProperty property = new HakkogoIdoTaishoshaIchiranProperty();
        try (ReportAssembler<HakkogoIdoTaishoshaIchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<HakkogoIdoTaishoshaIchiranSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new HakkogoIdoTaishoshaIchiranReport(発行後異動者一覧情報, 導入団体クラス, 帳票作成日時).writeBy(reportSourceWriter);
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
