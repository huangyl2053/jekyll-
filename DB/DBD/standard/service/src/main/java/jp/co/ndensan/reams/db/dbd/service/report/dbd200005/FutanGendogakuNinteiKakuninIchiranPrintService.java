/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd200005;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200005.FutanGendogakuNinteiKakuninIchiranProerty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200005.FutanGendogakuNinteiKakuninIchiranReport;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogakuninteikakunin.FutanGendogakuNinteiKakunin;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200005.FutanGendogakuNinteiKakuninIchiranReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 負担限度額認定（一括）確認リスト
 *
 * @reamsid_L DBD-3710-100 b_liuyang2
 */
public class FutanGendogakuNinteiKakuninIchiranPrintService {

    /**
     * 帳票を出力
     *
     * @param 負担限度額認定確認リスト List<FutanGendogakuNinteiKakunin>
     * @param 作成日時 YMDHMS
     * @param 導入団体 Association
     * @param 帳票出力順 IOutputOrder
     * @param 負担限度額認定宛名Entity FutanGendogakuNinteiKakunin
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(List<FutanGendogakuNinteiKakunin> 負担限度額認定確認リスト, YMDHMS 作成日時, Association 導入団体,
            IOutputOrder 帳票出力順, FutanGendogakuNinteiKakunin 負担限度額認定宛名Entity, ReportManager reportManager) {
        FutanGendogakuNinteiKakuninIchiranProerty property = new FutanGendogakuNinteiKakuninIchiranProerty();
        try (ReportAssembler<FutanGendogakuNinteiKakuninIchiranReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<FutanGendogakuNinteiKakuninIchiranReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            FutanGendogakuNinteiKakuninIchiranReport report = FutanGendogakuNinteiKakuninIchiranReport.
                    createReport(負担限度額認定確認リスト, 導入団体, 帳票出力順, 負担限度額認定宛名Entity);
            report.writeBy(reportSourceWriter);

        }
    }

    private <T extends IReportSource, R extends Report<T>> ReportAssembler<T>
            createAssembler(IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }
}
