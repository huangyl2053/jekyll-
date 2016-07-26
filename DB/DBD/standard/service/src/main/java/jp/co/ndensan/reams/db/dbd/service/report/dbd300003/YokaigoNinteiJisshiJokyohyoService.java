/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd300003;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd300003.YokaigoNinteiJisshiJokyohyoProerty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd300003.YokaigoNinteiJisshiJokyohyoReport;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.YokaigoNinteiJisshiJokyohyo.YokaigoNinteiJisshiJokyohyoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd300003.YokaigoNinteiJisshiJokyohyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * 要介護認定実施状況表（統計表）
 *
 * @reamsid_L DBD-1771-030 b_liuyang2
 */
public class YokaigoNinteiJisshiJokyohyoService {

    /**
     * 帳票を出力
     *
     * @param 基準日 FlexibleDate
     * @param 年齢 RString
     * @param 地区 RString
     * @param 集計単位 Code
     * @param 実施状況Entityリストlist1 List<YokaigoNinteiJisshiJokyohyoEntity>
     * @param 実施状況Entityリストlist2 List<YokaigoNinteiJisshiJokyohyoEntity>
     * @param 実施状況Entityリストlist3 List<YokaigoNinteiJisshiJokyohyoEntity>
     * @param 実施状況Entityリストlist4 List<YokaigoNinteiJisshiJokyohyoEntity>
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(FlexibleDate 基準日, RString 年齢, RString 地区, Code 集計単位,
            List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist1,
            List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist2,
            List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist3,
            List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist4, ReportManager reportManager) {
        YokaigoNinteiJisshiJokyohyoProerty property = new YokaigoNinteiJisshiJokyohyoProerty();
        try (ReportAssembler<YokaigoNinteiJisshiJokyohyoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<YokaigoNinteiJisshiJokyohyoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            YokaigoNinteiJisshiJokyohyoReport report = YokaigoNinteiJisshiJokyohyoReport.createReport(基準日, 年齢, 地区,
                    集計単位, 実施状況Entityリストlist1, 実施状況Entityリストlist2,
                    実施状況Entityリストlist3, 実施状況Entityリストlist4);
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
