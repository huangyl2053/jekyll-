/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.nonyutsuchishocvsmulti;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvsmulti.NonyuTsuchishoCVSMultiProperty;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvsmulti.NonyuTsuchishoCVSMultiRenchoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvsmulti.NonyuTsuchishoCVSMultiRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvsmulti.NonyuTsuchishoCVSMultiReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishocvsmulti.NonyuTsuchishoCVSMultiRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishocvsmulti.NonyuTsuchishoCVSMultiSource;
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
 * 保険料納入通知書（本算定）【コンビニマルチ収納タイプ】のPrintServiceです。
 *
 * @reamsid_L DBB-9110-110 huangh
 */
public class NonyuTsuchishoCVSMultiPrintService {

    private final ReportId 帳票分類ID = new ReportId("DBB100014_KarisanteiHokenryoNonyuTsuchishoDaihyo");
    private final RString 帳票IDの先頭_DBB100061 = new RString("DBB100061");
    private final RString 帳票IDの先頭_DBB100062 = new RString("DBB100062");

    /**
     * 保険料納入通知書（本算定）【コンビニマルチ収納タイプ】納付書 printメソッド
     *
     * @param 本算定納入通知書情報 HonSanteiNonyuTsuchiShoJoho
     * @return SourceDataCollection
     */
    public SourceDataCollection print(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        RString 帳票IDRString = RString.EMPTY;
        if (本算定納入通知書情報 != null && 本算定納入通知書情報.get帳票ID() != null) {
            帳票IDRString = 本算定納入通知書情報.get帳票ID().getColumnValue();
        }
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100061)) {
            return print全てページDBB100061(本算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100062)) {
            return print全てページDBB100062(本算定納入通知書情報);
        }
        return null;

    }

    /**
     * 帳票を出力します。
     *
     * @param 本算定納入通知書情報 HonSanteiNonyuTsuchiShoJoho
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {
        RString 帳票IDRString = RString.EMPTY;
        if (本算定納入通知書情報 != null && 本算定納入通知書情報.get帳票ID() != null) {
            帳票IDRString = 本算定納入通知書情報.get帳票ID().getColumnValue();
        }
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100061)) {
            print全てページDBB100061(本算定納入通知書情報, reportManager);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100062)) {
            print全てページDBB100062(本算定納入通知書情報, reportManager);
        }
    }

    /**
     * 帳票を出力します。
     *
     * @param 本算定納入通知書情報 HonSanteiNonyuTsuchiShoJoho
     * @return SourceDataCollection
     */
    public SourceDataCollection printDevidedByPage(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        RString 帳票IDRString = RString.EMPTY;
        if (本算定納入通知書情報 != null && 本算定納入通知書情報.get帳票ID() != null) {
            帳票IDRString = 本算定納入通知書情報.get帳票ID().getColumnValue();
        }
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100061)) {
            return print全てページDBB100061DevidedByPage(本算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100062)) {
            return print全てページDBB100062DevidedByPage(本算定納入通知書情報);
        }
        return null;
    }

    private SourceDataCollection print全てページDBB100061(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        NonyuTsuchishoCVSMultiProperty property = new NonyuTsuchishoCVSMultiProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<NonyuTsuchishoCVSMultiSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<NonyuTsuchishoCVSMultiSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                NonyuTsuchishoCVSMultiReport report
                        = new NonyuTsuchishoCVSMultiReport(本算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private void print全てページDBB100061(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {
        NonyuTsuchishoCVSMultiProperty property = new NonyuTsuchishoCVSMultiProperty();
        try (ReportAssembler<NonyuTsuchishoCVSMultiSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<NonyuTsuchishoCVSMultiSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            NonyuTsuchishoCVSMultiReport report
                    = new NonyuTsuchishoCVSMultiReport(本算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private SourceDataCollection print全てページDBB100062(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        NonyuTsuchishoCVSMultiRenchoProperty property = new NonyuTsuchishoCVSMultiRenchoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<NonyuTsuchishoCVSMultiRenchoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<NonyuTsuchishoCVSMultiRenchoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                NonyuTsuchishoCVSMultiRenchoReport report
                        = new NonyuTsuchishoCVSMultiRenchoReport(本算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private void print全てページDBB100062(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {
        NonyuTsuchishoCVSMultiRenchoProperty property = new NonyuTsuchishoCVSMultiRenchoProperty();
        try (ReportAssembler<NonyuTsuchishoCVSMultiRenchoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<NonyuTsuchishoCVSMultiRenchoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            NonyuTsuchishoCVSMultiRenchoReport report
                    = new NonyuTsuchishoCVSMultiRenchoReport(本算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private SourceDataCollection print全てページDBB100061DevidedByPage(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        NonyuTsuchishoCVSMultiProperty property = new NonyuTsuchishoCVSMultiProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<NonyuTsuchishoCVSMultiSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<NonyuTsuchishoCVSMultiSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<NonyuTsuchisho<NonyuTsuchishoCVSMultiSource>> reportList
                        = new NonyuTsuchishoCVSMultiReport(本算定納入通知書情報, ninshoshaSource).devidedByPage();
                for (NonyuTsuchisho report : reportList) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private SourceDataCollection print全てページDBB100062DevidedByPage(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        NonyuTsuchishoCVSMultiRenchoProperty property = new NonyuTsuchishoCVSMultiRenchoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<NonyuTsuchishoCVSMultiRenchoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<NonyuTsuchishoCVSMultiRenchoSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<NonyuTsuchisho<NonyuTsuchishoCVSMultiRenchoSource>> reportList
                        = new NonyuTsuchishoCVSMultiRenchoReport(本算定納入通知書情報, ninshoshaSource).devidedByPage();
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
