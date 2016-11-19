/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.kanendononyutsuchishocvskigoto;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishocvskigoto.KanendoNonyuTsuchishoCVSKigotoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishocvskigoto.KanendoNonyuTsuchishoCVSKigotoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendononyutsuchishocvskigoto.KanendoNonyuTsuchishoCVSKigotoSource;
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
 * 保険料納入通知書（本算定）【コンビニ期毎タイプ】のPrintServiceです。
 *
 * @reamsid_L DBB-9110-190 huangh
 */
public class KanendoNonyuTsuchishoCVSKigotoPrintService {

    private final ReportId 帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");

    /**
     * 保険料納入通知書（本算定過年度）【コンビニ角公タイプ】 printメソッド
     *
     * @param 本算定納入通知書情報 HonSanteiNonyuTsuchiShoJoho
     * @return SourceDataCollection
     */
    public SourceDataCollection print(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        KanendoNonyuTsuchishoCVSKigotoProperty property = new KanendoNonyuTsuchishoCVSKigotoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KanendoNonyuTsuchishoCVSKigotoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KanendoNonyuTsuchishoCVSKigotoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                KanendoNonyuTsuchishoCVSKigotoReport report
                        = new KanendoNonyuTsuchishoCVSKigotoReport(本算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }

    }

    /**
     * 保険料納入通知書（本算定過年度）【コンビニ角公タイプ】 printメソッド
     *
     * @param 本算定納入通知書情報 HonSanteiNonyuTsuchiShoJoho
     * @param reportManager ReportManager
     */
    public void print(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {
        KanendoNonyuTsuchishoCVSKigotoProperty property = new KanendoNonyuTsuchishoCVSKigotoProperty();
        try (ReportAssembler<KanendoNonyuTsuchishoCVSKigotoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KanendoNonyuTsuchishoCVSKigotoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            KanendoNonyuTsuchishoCVSKigotoReport report
                    = new KanendoNonyuTsuchishoCVSKigotoReport(本算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    /**
     * 保険料納入通知書（本算定過年度）【コンビニ角公タイプ】 printメソッド
     *
     * @param 本算定納入通知書情報List List<HonSanteiNonyuTsuchiShoJoho>
     * @param reportManager ReportManager
     */
    public void print_修正(List<HonSanteiNonyuTsuchiShoJoho> 本算定納入通知書情報List, ReportManager reportManager) {
        KanendoNonyuTsuchishoCVSKigotoProperty property = new KanendoNonyuTsuchishoCVSKigotoProperty();
        try (ReportAssembler<KanendoNonyuTsuchishoCVSKigotoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KanendoNonyuTsuchishoCVSKigotoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報List.get(0).get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            for (HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報 : 本算定納入通知書情報List) {
                KanendoNonyuTsuchishoCVSKigotoReport report
                        = new KanendoNonyuTsuchishoCVSKigotoReport(本算定納入通知書情報, ninshoshaSource);
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
        KanendoNonyuTsuchishoCVSKigotoProperty property = new KanendoNonyuTsuchishoCVSKigotoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KanendoNonyuTsuchishoCVSKigotoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KanendoNonyuTsuchishoCVSKigotoSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<NonyuTsuchisho<KanendoNonyuTsuchishoCVSKigotoSource>> reportList
                        = new KanendoNonyuTsuchishoCVSKigotoReport(本算定納入通知書情報, ninshoshaSource).devidedByPage();
                for (NonyuTsuchisho report : reportList) {
                    report.writeBy(reportSourceWriter);
                }
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
