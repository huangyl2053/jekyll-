/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.kanendononyutsuchishocvsmulti;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishocvsmulti.KanendoNonyuTsuchishoCVSMultiProperty;
import jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishocvsmulti.KanendoNonyuTsuchishoCVSMultiReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendononyutsuchishocvsmulti.KanendoNonyuTsuchishoCVSMultiSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
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
 * 保険料納入通知書（本算定過年度）【コンビニマルチ収納タイプ】のPrintServiceです。
 *
 * @reamsid_L DBB-9110-170 huangh
 */
public class KanendoNonyuTsuchishoCVSMultiPrintService {

    private final ReportId 帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");

    /**
     * 保険料納入通知書（本算定過年度）【コンビニマルチ収納タイプ】 printメソッド
     *
     * @param 本算定納入通知書情報 HonSanteiNonyuTsuchiShoJoho
     * @return SourceDataCollection
     */
    public SourceDataCollection print(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        KanendoNonyuTsuchishoCVSMultiProperty property = new KanendoNonyuTsuchishoCVSMultiProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KanendoNonyuTsuchishoCVSMultiSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KanendoNonyuTsuchishoCVSMultiSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                KanendoNonyuTsuchishoCVSMultiReport report
                        = new KanendoNonyuTsuchishoCVSMultiReport(本算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }

    }

    /**
     * 保険料納入通知書（本算定過年度）【コンビニマルチ収納タイプ】 printメソッド
     *
     * @param 本算定納入通知書情報 HonSanteiNonyuTsuchiShoJoho
     * @param reportManager ReportManager
     */
    public void print(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {
        KanendoNonyuTsuchishoCVSMultiProperty property = new KanendoNonyuTsuchishoCVSMultiProperty();
        try (ReportAssembler<KanendoNonyuTsuchishoCVSMultiSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KanendoNonyuTsuchishoCVSMultiSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            KanendoNonyuTsuchishoCVSMultiReport report
                    = new KanendoNonyuTsuchishoCVSMultiReport(本算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    /**
     * 保険料納入通知書（本算定過年度）【コンビニマルチ収納タイプ】 printメソッド
     *
     * @param 本算定納入通知書情報List List<HonSanteiNonyuTsuchiShoJoho>
     * @param reportManager ReportManager
     */
    public void print_修正(List<HonSanteiNonyuTsuchiShoJoho> 本算定納入通知書情報List, ReportManager reportManager) {
        KanendoNonyuTsuchishoCVSMultiProperty property = new KanendoNonyuTsuchishoCVSMultiProperty();
        try (ReportAssembler<KanendoNonyuTsuchishoCVSMultiSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KanendoNonyuTsuchishoCVSMultiSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報List.get(0).get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            for (HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報 : 本算定納入通知書情報List) {
                KanendoNonyuTsuchishoCVSMultiReport report
                        = new KanendoNonyuTsuchishoCVSMultiReport(本算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 帳票を出力します。
     *
     * @param 本算定納入通知書情報 HonSanteiNonyuTsuchiShoJoho
     * @return SourceDataCollection
     */
    public SourceDataCollection devidedByPage(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        KanendoNonyuTsuchishoCVSMultiProperty property = new KanendoNonyuTsuchishoCVSMultiProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KanendoNonyuTsuchishoCVSMultiSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KanendoNonyuTsuchishoCVSMultiSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<NonyuTsuchisho<KanendoNonyuTsuchishoCVSMultiSource>> reportList
                        = new KanendoNonyuTsuchishoCVSMultiReport(本算定納入通知書情報, ninshoshaSource).devidedByPage();
                for (NonyuTsuchisho report : reportList) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    /**
     * 帳票を出力します。
     *
     * @param 本算定納入通知書情報List List<HonSanteiNonyuTsuchiShoJoho>
     * @param reportManager ReportManager
     */
    public void devidedByPage_修正(
            List<HonSanteiNonyuTsuchiShoJoho> 本算定納入通知書情報List, ReportManager reportManager) {
        KanendoNonyuTsuchishoCVSMultiProperty property = new KanendoNonyuTsuchishoCVSMultiProperty();
        try (ReportAssembler<KanendoNonyuTsuchishoCVSMultiSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KanendoNonyuTsuchishoCVSMultiSource> reportSourceWriterCover = new ReportSourceWriter(assembler);
            ReportSourceWriter<KanendoNonyuTsuchishoCVSMultiSource> reportSourceWriterDetail = new ReportSourceWriter(assembler);
            for (HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報 : 本算定納入通知書情報List) {
                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriterCover);
                List<NonyuTsuchisho<KanendoNonyuTsuchishoCVSMultiSource>> reportList
                        = new KanendoNonyuTsuchishoCVSMultiReport(本算定納入通知書情報, ninshoshaSource).devidedByPage();
                reportList.get(0).writeBy(reportSourceWriterCover);
                reportList.get(1).writeBy(reportSourceWriterDetail);
            }
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
