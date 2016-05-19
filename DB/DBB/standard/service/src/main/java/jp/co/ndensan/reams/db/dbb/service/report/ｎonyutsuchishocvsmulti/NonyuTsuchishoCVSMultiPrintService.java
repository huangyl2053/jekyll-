/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.ｎonyutsuchishocvsmulti;

import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvsmulticover.NonyuTsuchishoCVSMultiProperty;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvsmulticover.NonyuTsuchishoCVSMultiReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishocvsmulti.NonyuTsuchishoCVSMultiSource;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * 保険料納入通知書（本算定）【コンビニマルチ収納タイプ】のPrintServiceです。
 *
 * @reamsid_L DBB-9110-110 huangh
 */
public class NonyuTsuchishoCVSMultiPrintService {

    /**
     * 保険料納入通知書（本算定）【コンビニマルチ収納タイプ】納付書 printメソッド
     *
     * @param target HonSanteiNonyuTsuchiShoJoho
     * @return SourceDataCollection
     */
    public SourceDataCollection print(HonSanteiNonyuTsuchiShoJoho target) {
        NonyuTsuchishoCVSMultiProperty property = new NonyuTsuchishoCVSMultiProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<NonyuTsuchishoCVSMultiSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<NonyuTsuchishoCVSMultiSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, target.get帳票分類ID(),
                        new FlexibleDate(target.get発行日().toString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                NonyuTsuchishoCVSMultiReport report = new NonyuTsuchishoCVSMultiReport(target, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
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
