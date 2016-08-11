/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd300004;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd300004.YokaigoNinteiTsukibetsuJukyushaSuJokyohyoProerty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd300004.YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReport;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteitsukibetsujukyushasujokyohyo.YokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd300004.YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
 * 要介護認定月別受給者数状況表（統計表）
 *
 * @reamsid_L DBD-1771-034 b_liuyang2
 */
public class YokaigoNinteiTsukibetsuJukyushaSuJokyohyoPrintService {

    /**
     * 帳票を出力
     *
     * @param 基準日 FlexibleDate
     * @param 年齢 RString
     * @param 地区 RString
     * @param 集計単位 Code
     * @param 年度 FlexibleYear
     * @param 受給状況Entityリスト List<YokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity>
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(FlexibleDate 基準日, RString 年齢, RString 地区, Code 集計単位, FlexibleYear 年度,
            List<YokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity> 受給状況Entityリスト, ReportManager reportManager) {
        YokaigoNinteiTsukibetsuJukyushaSuJokyohyoProerty property = new YokaigoNinteiTsukibetsuJukyushaSuJokyohyoProerty();
        try (ReportAssembler<YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReport report = YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReport.
                    createReport(基準日, 年齢, 地区, 集計単位, 年度, 受給状況Entityリスト);
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
