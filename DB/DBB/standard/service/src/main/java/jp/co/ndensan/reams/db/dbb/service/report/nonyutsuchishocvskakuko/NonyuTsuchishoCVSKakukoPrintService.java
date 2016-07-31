/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.nonyutsuchishocvskakuko;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoRenchoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoSource;
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
 * 保険料納入通知書（本算定）【コンビニ角公タイプ】納付書のprintServiceです。
 *
 * @reamsid_L DBB-9110-120 huangh
 */
public class NonyuTsuchishoCVSKakukoPrintService {

    private final ReportId 帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private final RString 帳票IDの先頭_DBB100059 = new RString("DBB100059");
    private final RString 帳票IDの先頭_DBB100060 = new RString("DBB100060");

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
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100059)) {
            return print全てページDBB100059(本算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100060)) {
            return print全てページDBB100060(本算定納入通知書情報);
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
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100059)) {
            print全てページDBB100059(本算定納入通知書情報, reportManager);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100060)) {
            print全てページDBB100060(本算定納入通知書情報, reportManager);
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
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100059)) {
            return print全てページDBB100059DevidedByPage(本算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100060)) {
            return print全てページDBB100060DevidedByPage(本算定納入通知書情報);
        }
        return null;
    }

    private SourceDataCollection print全てページDBB100059(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        NonyuTsuchishoCVSKakukoProperty property = new NonyuTsuchishoCVSKakukoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<NonyuTsuchishoCVSKakukoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<NonyuTsuchishoCVSKakukoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                NonyuTsuchishoCVSKakukoReport report
                        = new NonyuTsuchishoCVSKakukoReport(本算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private void print全てページDBB100059(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {
        NonyuTsuchishoCVSKakukoProperty property = new NonyuTsuchishoCVSKakukoProperty();
        try (ReportAssembler<NonyuTsuchishoCVSKakukoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<NonyuTsuchishoCVSKakukoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            NonyuTsuchishoCVSKakukoReport report
                    = new NonyuTsuchishoCVSKakukoReport(本算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private SourceDataCollection print全てページDBB100060(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        NonyuTsuchishoCVSKakukoRenchoProperty property = new NonyuTsuchishoCVSKakukoRenchoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<NonyuTsuchishoCVSKakukoRenchoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<NonyuTsuchishoCVSKakukoRenchoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                NonyuTsuchishoCVSKakukoRenchoReport report
                        = new NonyuTsuchishoCVSKakukoRenchoReport(本算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private void print全てページDBB100060(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {
        NonyuTsuchishoCVSKakukoRenchoProperty property = new NonyuTsuchishoCVSKakukoRenchoProperty();
        try (ReportAssembler<NonyuTsuchishoCVSKakukoRenchoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<NonyuTsuchishoCVSKakukoRenchoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            NonyuTsuchishoCVSKakukoRenchoReport report
                    = new NonyuTsuchishoCVSKakukoRenchoReport(本算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private SourceDataCollection print全てページDBB100059DevidedByPage(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        NonyuTsuchishoCVSKakukoProperty property = new NonyuTsuchishoCVSKakukoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<NonyuTsuchishoCVSKakukoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<NonyuTsuchishoCVSKakukoSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<NonyuTsuchisho<NonyuTsuchishoCVSKakukoSource>> reportList
                        = new NonyuTsuchishoCVSKakukoReport(本算定納入通知書情報, ninshoshaSource).devidedByPage();
                for (NonyuTsuchisho report : reportList) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private SourceDataCollection print全てページDBB100060DevidedByPage(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        NonyuTsuchishoCVSKakukoRenchoProperty property = new NonyuTsuchishoCVSKakukoRenchoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<NonyuTsuchishoCVSKakukoRenchoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<NonyuTsuchishoCVSKakukoRenchoSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<NonyuTsuchisho<NonyuTsuchishoCVSKakukoRenchoSource>> reportList
                        = new NonyuTsuchishoCVSKakukoRenchoReport(本算定納入通知書情報, ninshoshaSource).devidedByPage();
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
