/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.kanendohokenryononyutsuchishoginfuri;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.kanendohokenryononyutsuchishoginfuri.KanendoHokenryoNonyuTsuchishoGinfuriFiveKiProperty;
import jp.co.ndensan.reams.db.dbb.business.report.kanendohokenryononyutsuchishoginfuri.KanendoHokenryoNonyuTsuchishoGinfuriFiveKiReport;
import jp.co.ndensan.reams.db.dbb.business.report.kanendohokenryononyutsuchishoginfuri.KanendoHokenryoNonyuTsuchishoGinfuriFourKiProperty;
import jp.co.ndensan.reams.db.dbb.business.report.kanendohokenryononyutsuchishoginfuri.KanendoHokenryoNonyuTsuchishoGinfuriFourKiReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendohokenryononyutsuchishoginfuri.KanendoHokenryoNonyuTsuchishoGinfuriFiveKiSource;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendohokenryononyutsuchishoginfuri.KanendoHokenryoNonyuTsuchishoGinfuriFourKiSource;
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
 * 帳票設計_DBBRP00007_15_保険料納入通知書（本算定過年度）【銀振タイプ】のプリントサービスです。
 *
 * @reamsid_L DBB-9110-150 wangjie2
 */
public class KanendoHokenryoNonyuTsuchishoGinfuriPrintService {

    private final ReportId 帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private final RString 帳票IDの先頭_DBB100069 = new RString("DBB100069");
    private final RString 帳票IDの先頭_DBB100070 = new RString("DBB100070");

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
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100069)) {
            return print全てページDBB100069(本算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100070)) {
            return print全てページDBB100070(本算定納入通知書情報);
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
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100069)) {
            print全てページDBB100069(本算定納入通知書情報, reportManager);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100070)) {
            print全てページDBB100070(本算定納入通知書情報, reportManager);
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
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100069)) {
            return print全てページDBB100069DevidedByPage(本算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100070)) {
            return print全てページDBB100070DevidedByPage(本算定納入通知書情報);
        }
        return null;
    }

    private SourceDataCollection print全てページDBB100070DevidedByPage(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        KanendoHokenryoNonyuTsuchishoGinfuriFiveKiProperty property = new KanendoHokenryoNonyuTsuchishoGinfuriFiveKiProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KanendoHokenryoNonyuTsuchishoGinfuriFiveKiSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KanendoHokenryoNonyuTsuchishoGinfuriFiveKiSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<NonyuTsuchisho<KanendoHokenryoNonyuTsuchishoGinfuriFiveKiSource>> reportList
                        = new KanendoHokenryoNonyuTsuchishoGinfuriFiveKiReport(本算定納入通知書情報, ninshoshaSource).devidedByPage();
                for (NonyuTsuchisho report : reportList) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private SourceDataCollection print全てページDBB100069DevidedByPage(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        KanendoHokenryoNonyuTsuchishoGinfuriFourKiProperty property = new KanendoHokenryoNonyuTsuchishoGinfuriFourKiProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KanendoHokenryoNonyuTsuchishoGinfuriFourKiSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KanendoHokenryoNonyuTsuchishoGinfuriFourKiSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<NonyuTsuchisho<KanendoHokenryoNonyuTsuchishoGinfuriFourKiSource>> reportList
                        = new KanendoHokenryoNonyuTsuchishoGinfuriFourKiReport(本算定納入通知書情報, ninshoshaSource).devidedByPage();
                for (NonyuTsuchisho report : reportList) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private void print全てページDBB100070(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {
        KanendoHokenryoNonyuTsuchishoGinfuriFiveKiProperty property = new KanendoHokenryoNonyuTsuchishoGinfuriFiveKiProperty();
        try (ReportAssembler<KanendoHokenryoNonyuTsuchishoGinfuriFiveKiSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KanendoHokenryoNonyuTsuchishoGinfuriFiveKiSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            KanendoHokenryoNonyuTsuchishoGinfuriFiveKiReport report
                    = new KanendoHokenryoNonyuTsuchishoGinfuriFiveKiReport(本算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private void print全てページDBB100069(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {
        KanendoHokenryoNonyuTsuchishoGinfuriFourKiProperty property = new KanendoHokenryoNonyuTsuchishoGinfuriFourKiProperty();
        try (ReportAssembler<KanendoHokenryoNonyuTsuchishoGinfuriFourKiSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KanendoHokenryoNonyuTsuchishoGinfuriFourKiSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            KanendoHokenryoNonyuTsuchishoGinfuriFourKiReport report
                    = new KanendoHokenryoNonyuTsuchishoGinfuriFourKiReport(本算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private SourceDataCollection print全てページDBB100070(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        KanendoHokenryoNonyuTsuchishoGinfuriFiveKiProperty property = new KanendoHokenryoNonyuTsuchishoGinfuriFiveKiProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KanendoHokenryoNonyuTsuchishoGinfuriFiveKiSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KanendoHokenryoNonyuTsuchishoGinfuriFiveKiSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                KanendoHokenryoNonyuTsuchishoGinfuriFiveKiReport report
                        = new KanendoHokenryoNonyuTsuchishoGinfuriFiveKiReport(本算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private SourceDataCollection print全てページDBB100069(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        KanendoHokenryoNonyuTsuchishoGinfuriFourKiProperty property = new KanendoHokenryoNonyuTsuchishoGinfuriFourKiProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KanendoHokenryoNonyuTsuchishoGinfuriFourKiSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KanendoHokenryoNonyuTsuchishoGinfuriFourKiSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                KanendoHokenryoNonyuTsuchishoGinfuriFourKiReport report
                        = new KanendoHokenryoNonyuTsuchishoGinfuriFourKiReport(本算定納入通知書情報, ninshoshaSource);
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
