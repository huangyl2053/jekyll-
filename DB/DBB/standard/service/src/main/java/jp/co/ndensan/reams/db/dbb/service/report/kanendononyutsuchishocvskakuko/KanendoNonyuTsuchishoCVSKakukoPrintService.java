/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.kanendononyutsuchishocvskakuko;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.INonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishocvskakuko.KanendoNonyuTsuchishoCVSKakukoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishocvskakuko.KanendoNonyuTsuchishoCVSKakukoReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendononyutsuchishocvskakuko.KanendoNonyuTsuchishoCVSKakukoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiSource;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.util.report.ReportUtil;
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
 * 保険料納入通知書（本算定過年度）【コンビニ角公タイプ】のPrintServiceです。
 *
 * @reamsid_L DBB-9110-180 huangh
 */
public class KanendoNonyuTsuchishoCVSKakukoPrintService {

    private final ReportId 帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");

    /**
     * 保険料納入通知書（本算定過年度）【コンビニ角公タイプ】 printメソッド
     *
     * @param 本算定納入通知書情報 HonSanteiNonyuTsuchiShoJoho
     * @return SourceDataCollection
     */
    public SourceDataCollection print(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        KanendoNonyuTsuchishoCVSKakukoProperty property = new KanendoNonyuTsuchishoCVSKakukoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KanendoNonyuTsuchishoCVSKakukoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KanendoNonyuTsuchishoCVSKakukoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                KanendoNonyuTsuchishoCVSKakukoReport report
                        = new KanendoNonyuTsuchishoCVSKakukoReport(本算定納入通知書情報, ninshoshaSource);
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
        KanendoNonyuTsuchishoCVSKakukoProperty property = new KanendoNonyuTsuchishoCVSKakukoProperty();
        try (ReportAssembler<KanendoNonyuTsuchishoCVSKakukoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KanendoNonyuTsuchishoCVSKakukoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            KanendoNonyuTsuchishoCVSKakukoReport report
                    = new KanendoNonyuTsuchishoCVSKakukoReport(本算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    /**
     * 帳票を出力します。
     *
     * @param 本算定納入通知書情報 HonSanteiNonyuTsuchiShoJoho
     * @return SourceDataCollection
     */
    public SourceDataCollection devidedByPage(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        KarisanteiNonyuTsuchishoCVSMultiProperty property = new KarisanteiNonyuTsuchishoCVSMultiProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KarisanteiNonyuTsuchishoCVSMultiSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KarisanteiNonyuTsuchishoCVSMultiSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<INonyuTsuchisho> reportList
                        = new KanendoNonyuTsuchishoCVSKakukoReport(本算定納入通知書情報, ninshoshaSource).devidedByPage();
                for (INonyuTsuchisho report : reportList) {
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
