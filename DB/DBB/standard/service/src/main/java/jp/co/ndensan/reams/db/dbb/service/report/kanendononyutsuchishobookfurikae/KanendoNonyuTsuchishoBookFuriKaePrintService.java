/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.kanendononyutsuchishobookfurikae;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishobookfurikae.KanendoNonyuTsuchishoBookFuriKaeAriProperty;
import jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishobookfurikae.KanendoNonyuTsuchishoBookFuriKaeAriReport;
import jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishobookfurikae.KanendoNonyuTsuchishoBookFuriKaeNashiProperty;
import jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishobookfurikae.KanendoNonyuTsuchishoBookFuriKaeNashiReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendononyutsuchishobookfurikae.KanendoNonyuTsuchishoBookFuriKaeAriSource;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendononyutsuchishobookfurikae.KanendoNonyuTsuchishoBookFuriKaeNashiSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * 帳票設計_DBBRP00007_16_保険料納入通知書（本算定過年度）【ブックタイプ】のプリントサービスです。
 *
 * @reamsid_L DBB-9110-160 wangjie2
 */
public class KanendoNonyuTsuchishoBookFuriKaePrintService {

    private final ReportId 帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private final RString 帳票IDの先頭_DBB100071 = new RString("DBB100071");
    private final RString 帳票IDの先頭_DBB100072 = new RString("DBB100072");

    /**
     * 帳票を出力します。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @return SourceDataCollection SourceDataCollection
     */
    public SourceDataCollection print(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        RString 帳票IDRString = RString.EMPTY;
        if (本算定納入通知書情報 != null && 本算定納入通知書情報.get帳票ID() != null) {
            帳票IDRString = 本算定納入通知書情報.get帳票ID().getColumnValue();
        }
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100071)) {
            return print全てページDBB100071(本算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100072)) {
            return print全てページDBB100072(本算定納入通知書情報);
        }
        return null;
    }

    /**
     * 帳票を出力します。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {
        RString 帳票IDRString = RString.EMPTY;
        if (本算定納入通知書情報 != null && 本算定納入通知書情報.get帳票ID() != null) {
            帳票IDRString = 本算定納入通知書情報.get帳票ID().getColumnValue();
        }
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100071)) {
            print全てページDBB100071(本算定納入通知書情報, reportManager);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100072)) {
            print全てページDBB100072(本算定納入通知書情報, reportManager);
        }
    }

    /**
     * 帳票を出力します。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @return SourceDataCollection SourceDataCollection
     */
    public SourceDataCollection printDevidedByPage(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        RString 帳票IDRString = RString.EMPTY;
        if (本算定納入通知書情報 != null && 本算定納入通知書情報.get帳票ID() != null) {
            帳票IDRString = 本算定納入通知書情報.get帳票ID().getColumnValue();
        }
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100071)) {
            return print全てページDBB100071printDevidedByPage(本算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100072)) {
            return print全てページDBB100072printDevidedByPage(本算定納入通知書情報);
        }
        return null;
    }

    private SourceDataCollection print全てページDBB100072printDevidedByPage(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        KanendoNonyuTsuchishoBookFuriKaeNashiProperty property = new KanendoNonyuTsuchishoBookFuriKaeNashiProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KanendoNonyuTsuchishoBookFuriKaeNashiSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KanendoNonyuTsuchishoBookFuriKaeNashiSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                KanendoNonyuTsuchishoBookFuriKaeNashiReport report
                        = new KanendoNonyuTsuchishoBookFuriKaeNashiReport(本算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private SourceDataCollection print全てページDBB100071printDevidedByPage(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        KanendoNonyuTsuchishoBookFuriKaeAriProperty property = new KanendoNonyuTsuchishoBookFuriKaeAriProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KanendoNonyuTsuchishoBookFuriKaeAriSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KanendoNonyuTsuchishoBookFuriKaeAriSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<NonyuTsuchisho<KanendoNonyuTsuchishoBookFuriKaeAriSource>> reportList
                        = new KanendoNonyuTsuchishoBookFuriKaeAriReport(本算定納入通知書情報, ninshoshaSource).devidedByPage();
                for (NonyuTsuchisho report : reportList) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private void print全てページDBB100072(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {
        KanendoNonyuTsuchishoBookFuriKaeNashiProperty property = new KanendoNonyuTsuchishoBookFuriKaeNashiProperty();
        try (ReportAssembler<KanendoNonyuTsuchishoBookFuriKaeNashiSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KanendoNonyuTsuchishoBookFuriKaeNashiSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            List<NonyuTsuchisho<KanendoNonyuTsuchishoBookFuriKaeNashiSource>> reportList
                    = new KanendoNonyuTsuchishoBookFuriKaeNashiReport(本算定納入通知書情報, ninshoshaSource).devidedByPage();
            for (NonyuTsuchisho report : reportList) {
                report.writeBy(reportSourceWriter);
            }
        }
    }

    private void print全てページDBB100071(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {
        KanendoNonyuTsuchishoBookFuriKaeAriProperty property = new KanendoNonyuTsuchishoBookFuriKaeAriProperty();
        try (ReportAssembler<KanendoNonyuTsuchishoBookFuriKaeAriSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KanendoNonyuTsuchishoBookFuriKaeAriSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            KanendoNonyuTsuchishoBookFuriKaeAriReport report
                    = new KanendoNonyuTsuchishoBookFuriKaeAriReport(本算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private SourceDataCollection print全てページDBB100072(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        KanendoNonyuTsuchishoBookFuriKaeNashiProperty property = new KanendoNonyuTsuchishoBookFuriKaeNashiProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KanendoNonyuTsuchishoBookFuriKaeNashiSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KanendoNonyuTsuchishoBookFuriKaeNashiSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                KanendoNonyuTsuchishoBookFuriKaeNashiReport report
                        = new KanendoNonyuTsuchishoBookFuriKaeNashiReport(本算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private SourceDataCollection print全てページDBB100071(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        KanendoNonyuTsuchishoBookFuriKaeAriProperty property = new KanendoNonyuTsuchishoBookFuriKaeAriProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KanendoNonyuTsuchishoBookFuriKaeAriSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KanendoNonyuTsuchishoBookFuriKaeAriSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                KanendoNonyuTsuchishoBookFuriKaeAriReport report
                        = new KanendoNonyuTsuchishoBookFuriKaeAriReport(本算定納入通知書情報, ninshoshaSource);
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
