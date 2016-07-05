/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.hokenryononyutsuchishokigoto;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishokigoto.HokenryoNonyuTsuchishoKigotoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishokigoto.HokenryoNonyuTsuchishoKigotoRenchoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishokigoto.HokenryoNonyuTsuchishoKigotoRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishokigoto.HokenryoNonyuTsuchishoKigotoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishokigoto.HokenryoNonyuTsuchishoKigotoRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishokigoto.HokenryoNonyuTsuchishoKigotoSource;
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
 * 保険料納入通知書（本算定）【期毎タイプ】HokenryoNonyuTsuchishoKigotoPrintService
 *
 * @reamsid_L DBB-9110-080 huangh
 */
public class HokenryoNonyuTsuchishoKigotoPrintService {

    private final ReportId 帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private final RString 帳票IDの先頭_DBB100045 = new RString("DBB100045");
    private final RString 帳票IDの先頭_DBB100046 = new RString("DBB100046");

    /**
     * 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】納付書 printメソッド
     *
     * @param 本算定納入通知書情報 HonSanteiNonyuTsuchiShoJoho
     * @return SourceDataCollection
     */
    public SourceDataCollection print(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        RString 帳票IDRString = RString.EMPTY;
        if (本算定納入通知書情報 != null && 本算定納入通知書情報.get帳票ID() != null) {
            帳票IDRString = 本算定納入通知書情報.get帳票ID().getColumnValue();
        }
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100045)) {
            return print全てページDBB100045(本算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100046)) {
            return print全てページDBB100046(本算定納入通知書情報);
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
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100045)) {
            print全てページDBB100045(本算定納入通知書情報, reportManager);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100046)) {
            print全てページDBB100046(本算定納入通知書情報, reportManager);
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
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100045)) {
            return print全てページDBB100045DevidedByPage(本算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100046)) {
            return print全てページDBB100046DevidedByPage(本算定納入通知書情報);
        }
        return null;
    }

    private SourceDataCollection print全てページDBB100045(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        HokenryoNonyuTsuchishoKigotoProperty property = new HokenryoNonyuTsuchishoKigotoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HokenryoNonyuTsuchishoKigotoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<HokenryoNonyuTsuchishoKigotoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                HokenryoNonyuTsuchishoKigotoReport report
                        = new HokenryoNonyuTsuchishoKigotoReport(本算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private void print全てページDBB100045(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {
        HokenryoNonyuTsuchishoKigotoProperty property = new HokenryoNonyuTsuchishoKigotoProperty();
        try (ReportAssembler<HokenryoNonyuTsuchishoKigotoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<HokenryoNonyuTsuchishoKigotoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            HokenryoNonyuTsuchishoKigotoReport report
                    = new HokenryoNonyuTsuchishoKigotoReport(本算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private SourceDataCollection print全てページDBB100046(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        HokenryoNonyuTsuchishoKigotoRenchoProperty property = new HokenryoNonyuTsuchishoKigotoRenchoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HokenryoNonyuTsuchishoKigotoRenchoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<HokenryoNonyuTsuchishoKigotoRenchoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                HokenryoNonyuTsuchishoKigotoRenchoReport report
                        = new HokenryoNonyuTsuchishoKigotoRenchoReport(本算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private void print全てページDBB100046(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {
        HokenryoNonyuTsuchishoKigotoRenchoProperty property = new HokenryoNonyuTsuchishoKigotoRenchoProperty();
        try (ReportAssembler<HokenryoNonyuTsuchishoKigotoRenchoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<HokenryoNonyuTsuchishoKigotoRenchoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            HokenryoNonyuTsuchishoKigotoRenchoReport report
                    = new HokenryoNonyuTsuchishoKigotoRenchoReport(本算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private SourceDataCollection print全てページDBB100045DevidedByPage(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        HokenryoNonyuTsuchishoKigotoProperty property = new HokenryoNonyuTsuchishoKigotoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HokenryoNonyuTsuchishoKigotoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<HokenryoNonyuTsuchishoKigotoSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<NonyuTsuchisho<HokenryoNonyuTsuchishoKigotoSource>> reportList
                        = new HokenryoNonyuTsuchishoKigotoReport(本算定納入通知書情報, ninshoshaSource).devidedByPage();
                for (NonyuTsuchisho report : reportList) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private SourceDataCollection print全てページDBB100046DevidedByPage(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        HokenryoNonyuTsuchishoKigotoRenchoProperty property = new HokenryoNonyuTsuchishoKigotoRenchoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HokenryoNonyuTsuchishoKigotoRenchoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<HokenryoNonyuTsuchishoKigotoRenchoSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<NonyuTsuchisho<HokenryoNonyuTsuchishoKigotoRenchoSource>> reportList
                        = new HokenryoNonyuTsuchishoKigotoRenchoReport(本算定納入通知書情報, ninshoshaSource).devidedByPage();
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
