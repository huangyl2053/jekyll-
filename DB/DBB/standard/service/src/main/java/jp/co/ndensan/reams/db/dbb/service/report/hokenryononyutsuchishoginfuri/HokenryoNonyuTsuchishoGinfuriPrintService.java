/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.hokenryononyutsuchishoginfuri;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.INonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFiveKiProperty;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFiveKiRenchoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFiveKiReport;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFourKiProperty;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFourKiRenchoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFourKiRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFourKiReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFiveKiSource;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFourKiRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFourKiSource;
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
 * 保険料納入通知書（本算定）【銀振タイプ】のPrintService
 *
 * @reamsid_L DBB-9110-090 huangh
 */
public class HokenryoNonyuTsuchishoGinfuriPrintService {

    private final ReportId 帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private final RString 帳票IDの先頭_DBB100051 = new RString("DBB100051");
    private final RString 帳票IDの先頭_DBB100052 = new RString("DBB100052");
    private final RString 帳票IDの先頭_DBB100053 = new RString("DBB100053");
    private final RString 帳票IDの先頭_DBB100054 = new RString("DBB100054");

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
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100051)) {
            return print全てページDBB100051(本算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100052)) {
            return print全てページDBB100052(本算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100053)) {
            return print全てページDBB100053(本算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100054)) {
            return print全てページDBB100054(本算定納入通知書情報);
        }
        return null;
    }

    /**
     * 帳票を出力します。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @param reportManager ReportManager
     */
    public void print(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {
        RString 帳票IDRString = RString.EMPTY;
        if (本算定納入通知書情報 != null && 本算定納入通知書情報.get帳票ID() != null) {
            帳票IDRString = 本算定納入通知書情報.get帳票ID().getColumnValue();
        }
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100051)) {
            print全てページDBB100051(本算定納入通知書情報, reportManager);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100052)) {
            print全てページDBB100052(本算定納入通知書情報, reportManager);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100053)) {
            print全てページDBB100053(本算定納入通知書情報, reportManager);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100054)) {
            print全てページDBB100054(本算定納入通知書情報, reportManager);
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
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100051)) {
            print全てページDBB100051DevidedByPage(本算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100052)) {
            print全てページDBB100052DevidedByPage(本算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100053)) {
            print全てページDBB100053DevidedByPage(本算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100054)) {
            print全てページDBB100054DevidedByPage(本算定納入通知書情報);
        }
        return null;
    }

    private SourceDataCollection print全てページDBB100051(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        HokenryoNonyuTsuchishoGinfuriFourKiProperty property = new HokenryoNonyuTsuchishoGinfuriFourKiProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HokenryoNonyuTsuchishoGinfuriFourKiSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFourKiSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                HokenryoNonyuTsuchishoGinfuriFourKiReport report
                        = new HokenryoNonyuTsuchishoGinfuriFourKiReport(本算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private void print全てページDBB100051(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {
        HokenryoNonyuTsuchishoGinfuriFourKiProperty property = new HokenryoNonyuTsuchishoGinfuriFourKiProperty();
        try (ReportAssembler<HokenryoNonyuTsuchishoGinfuriFourKiSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFourKiSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            HokenryoNonyuTsuchishoGinfuriFourKiReport report
                    = new HokenryoNonyuTsuchishoGinfuriFourKiReport(本算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private SourceDataCollection print全てページDBB100052(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        HokenryoNonyuTsuchishoGinfuriFourKiRenchoProperty property = new HokenryoNonyuTsuchishoGinfuriFourKiRenchoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HokenryoNonyuTsuchishoGinfuriFourKiRenchoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFourKiRenchoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                HokenryoNonyuTsuchishoGinfuriFourKiRenchoReport report
                        = new HokenryoNonyuTsuchishoGinfuriFourKiRenchoReport(本算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private void print全てページDBB100052(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {
        HokenryoNonyuTsuchishoGinfuriFourKiRenchoProperty property = new HokenryoNonyuTsuchishoGinfuriFourKiRenchoProperty();
        try (ReportAssembler<HokenryoNonyuTsuchishoGinfuriFourKiRenchoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFourKiRenchoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            HokenryoNonyuTsuchishoGinfuriFourKiRenchoReport report
                    = new HokenryoNonyuTsuchishoGinfuriFourKiRenchoReport(本算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private SourceDataCollection print全てページDBB100053(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        HokenryoNonyuTsuchishoGinfuriFiveKiProperty property = new HokenryoNonyuTsuchishoGinfuriFiveKiProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HokenryoNonyuTsuchishoGinfuriFiveKiSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFiveKiSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                HokenryoNonyuTsuchishoGinfuriFiveKiReport report
                        = new HokenryoNonyuTsuchishoGinfuriFiveKiReport(本算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private void print全てページDBB100053(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {
        HokenryoNonyuTsuchishoGinfuriFiveKiProperty property = new HokenryoNonyuTsuchishoGinfuriFiveKiProperty();
        try (ReportAssembler<HokenryoNonyuTsuchishoGinfuriFiveKiSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFiveKiSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            HokenryoNonyuTsuchishoGinfuriFiveKiReport report
                    = new HokenryoNonyuTsuchishoGinfuriFiveKiReport(本算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private SourceDataCollection print全てページDBB100054(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        HokenryoNonyuTsuchishoGinfuriFiveKiRenchoProperty property = new HokenryoNonyuTsuchishoGinfuriFiveKiRenchoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport report
                        = new HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport(本算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private void print全てページDBB100054(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {
        HokenryoNonyuTsuchishoGinfuriFiveKiRenchoProperty property = new HokenryoNonyuTsuchishoGinfuriFiveKiRenchoProperty();
        try (ReportAssembler<HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport report
                    = new HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport(本算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private SourceDataCollection print全てページDBB100051DevidedByPage(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        HokenryoNonyuTsuchishoGinfuriFourKiProperty property = new HokenryoNonyuTsuchishoGinfuriFourKiProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HokenryoNonyuTsuchishoGinfuriFourKiSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFourKiSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<INonyuTsuchisho> reportList
                        = new HokenryoNonyuTsuchishoGinfuriFourKiReport(本算定納入通知書情報, ninshoshaSource).devidedByPage();
                for (INonyuTsuchisho report : reportList) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private SourceDataCollection print全てページDBB100052DevidedByPage(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        HokenryoNonyuTsuchishoGinfuriFourKiRenchoProperty property = new HokenryoNonyuTsuchishoGinfuriFourKiRenchoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HokenryoNonyuTsuchishoGinfuriFourKiRenchoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFourKiRenchoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<INonyuTsuchisho> reportList
                        = new HokenryoNonyuTsuchishoGinfuriFourKiRenchoReport(本算定納入通知書情報, ninshoshaSource).devidedByPage();
                for (INonyuTsuchisho report : reportList) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private SourceDataCollection print全てページDBB100053DevidedByPage(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        HokenryoNonyuTsuchishoGinfuriFiveKiProperty property = new HokenryoNonyuTsuchishoGinfuriFiveKiProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HokenryoNonyuTsuchishoGinfuriFiveKiSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFiveKiSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<INonyuTsuchisho> reportList
                        = new HokenryoNonyuTsuchishoGinfuriFiveKiReport(本算定納入通知書情報, ninshoshaSource).devidedByPage();
                for (INonyuTsuchisho report : reportList) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private SourceDataCollection print全てページDBB100054DevidedByPage(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        HokenryoNonyuTsuchishoGinfuriFiveKiRenchoProperty property = new HokenryoNonyuTsuchishoGinfuriFiveKiRenchoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<INonyuTsuchisho> reportList
                        = new HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport(本算定納入通知書情報, ninshoshaSource).devidedByPage();
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
