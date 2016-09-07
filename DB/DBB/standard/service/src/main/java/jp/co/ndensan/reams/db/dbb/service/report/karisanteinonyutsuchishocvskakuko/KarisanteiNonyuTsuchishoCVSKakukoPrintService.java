/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.karisanteinonyutsuchishocvskakuko;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoRenchoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
 * 保険料納入通知書（仮算定）【コンビニ角公タイプ】納付書のPrintServiceです。
 *
 * @reamsid_L DBB-9110-060 huangh
 */
public class KarisanteiNonyuTsuchishoCVSKakukoPrintService {

    private final ReportId 帳票分類ID = new ReportId("DBB100014_KarisanteiHokenryoNonyuTsuchishoDaihyo");
    private final RString 帳票IDの先頭_DBB100024 = new RString("DBB100024");
    private final RString 帳票IDの先頭_DBB100025 = new RString("DBB100025");

    /**
     * 保険料納入通知書（仮算定）【コンビニ角公タイプ】 printメソッド
     *
     * @param 仮算定納入通知書情報 KariSanteiNonyuTsuchiShoJoho
     * @return SourceDataCollection
     */
    public SourceDataCollection print(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        RString 帳票IDRString = RString.EMPTY;
        if (仮算定納入通知書情報 != null && 仮算定納入通知書情報.get帳票ID() != null) {
            帳票IDRString = 仮算定納入通知書情報.get帳票ID().getColumnValue();
        }
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100024)) {
            return print全てページDBB100024(仮算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100025)) {
            return print全てページDBB100025(仮算定納入通知書情報);
        }
        return null;

    }

    /**
     * 帳票を出力します。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, ReportManager reportManager) {
        RString 帳票IDRString = RString.EMPTY;
        if (仮算定納入通知書情報 != null && 仮算定納入通知書情報.get帳票ID() != null) {
            帳票IDRString = 仮算定納入通知書情報.get帳票ID().getColumnValue();
        }
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100024)) {
            print全てページDBB100024(仮算定納入通知書情報, reportManager);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100025)) {
            print全てページDBB100025(仮算定納入通知書情報, reportManager);
        }
    }

    /**
     * 帳票を出力します。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     * @return SourceDataCollection
     */
    public SourceDataCollection printDevidedByPage(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        RString 帳票IDRString = RString.EMPTY;
        if (仮算定納入通知書情報 != null && 仮算定納入通知書情報.get帳票ID() != null) {
            帳票IDRString = 仮算定納入通知書情報.get帳票ID().getColumnValue();
        }
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100024)) {
            return print全てページDBB100024DevidedByPage(仮算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100025)) {
            return print全てページDBB100025DevidedByPage(仮算定納入通知書情報);
        }
        return null;
    }

    private SourceDataCollection print全てページDBB100024(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        KarisanteiNonyuTsuchishoCVSKakukoProperty property = new KarisanteiNonyuTsuchishoCVSKakukoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KarisanteiNonyuTsuchishoCVSKakukoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KarisanteiNonyuTsuchishoCVSKakukoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID, 仮算定納入通知書情報.get発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                KarisanteiNonyuTsuchishoCVSKakukoReport report
                        = new KarisanteiNonyuTsuchishoCVSKakukoReport(仮算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private void print全てページDBB100024(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, ReportManager reportManager) {
        KarisanteiNonyuTsuchishoCVSKakukoProperty property = new KarisanteiNonyuTsuchishoCVSKakukoProperty();
        try (ReportAssembler<KarisanteiNonyuTsuchishoCVSKakukoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KarisanteiNonyuTsuchishoCVSKakukoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID, 仮算定納入通知書情報.get発行日(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            KarisanteiNonyuTsuchishoCVSKakukoReport report
                    = new KarisanteiNonyuTsuchishoCVSKakukoReport(仮算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private SourceDataCollection print全てページDBB100025(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        KarisanteiNonyuTsuchishoCVSKakukoRenchoProperty property = new KarisanteiNonyuTsuchishoCVSKakukoRenchoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KarisanteiNonyuTsuchishoCVSKakukoRenchoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KarisanteiNonyuTsuchishoCVSKakukoRenchoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID, 仮算定納入通知書情報.get発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                KarisanteiNonyuTsuchishoCVSKakukoRenchoReport report
                        = new KarisanteiNonyuTsuchishoCVSKakukoRenchoReport(仮算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private void print全てページDBB100025(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, ReportManager reportManager) {
        KarisanteiNonyuTsuchishoCVSKakukoRenchoProperty property = new KarisanteiNonyuTsuchishoCVSKakukoRenchoProperty();
        try (ReportAssembler<KarisanteiNonyuTsuchishoCVSKakukoRenchoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KarisanteiNonyuTsuchishoCVSKakukoRenchoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID, 仮算定納入通知書情報.get発行日(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            KarisanteiNonyuTsuchishoCVSKakukoRenchoReport report
                    = new KarisanteiNonyuTsuchishoCVSKakukoRenchoReport(仮算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private SourceDataCollection print全てページDBB100024DevidedByPage(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        KarisanteiNonyuTsuchishoCVSKakukoProperty property = new KarisanteiNonyuTsuchishoCVSKakukoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KarisanteiNonyuTsuchishoCVSKakukoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KarisanteiNonyuTsuchishoCVSKakukoSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID, 仮算定納入通知書情報.get発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<NonyuTsuchisho<KarisanteiNonyuTsuchishoCVSKakukoSource>> reportList
                        = new KarisanteiNonyuTsuchishoCVSKakukoReport(仮算定納入通知書情報, ninshoshaSource).devidedByPage();
                for (NonyuTsuchisho report : reportList) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private SourceDataCollection print全てページDBB100025DevidedByPage(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        KarisanteiNonyuTsuchishoCVSKakukoRenchoProperty property = new KarisanteiNonyuTsuchishoCVSKakukoRenchoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KarisanteiNonyuTsuchishoCVSKakukoRenchoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KarisanteiNonyuTsuchishoCVSKakukoRenchoSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID, 仮算定納入通知書情報.get発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<NonyuTsuchisho<KarisanteiNonyuTsuchishoCVSKakukoRenchoSource>> reportList
                        = new KarisanteiNonyuTsuchishoCVSKakukoRenchoReport(仮算定納入通知書情報, ninshoshaSource).devidedByPage();
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
