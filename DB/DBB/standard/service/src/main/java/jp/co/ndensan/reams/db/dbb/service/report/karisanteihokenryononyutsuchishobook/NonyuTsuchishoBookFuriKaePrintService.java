/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.karisanteihokenryononyutsuchishobook;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverProperty;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverProperty;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishobook.KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverProperty;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishobook.KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishobook.KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverProperty;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishobook.KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishobook.KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishobook.KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource;
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
 * 帳票設計_DBBRP00007_4_保険料納入通知書（仮算定）【ブックタイプ】のプリントサービスです。
 *
 * @reamsid_L DBB-9110-040 wangjie2
 */
public class NonyuTsuchishoBookFuriKaePrintService {

    private final ReportId 帳票分類ID = new ReportId("DBB100014_KarisanteiHokenryoNonyuTsuchishoDaihyo");
    private final RString 帳票IDの先頭_DBB100020 = new RString("DBB100020");
    private final RString 帳票IDの先頭_DBB100021 = new RString("DBB100021");
    private final RString 帳票IDの先頭_DBB100022 = new RString("DBB100022");
    private final RString 帳票IDの先頭_DBB100023 = new RString("DBB100023");

    /**
     * 帳票を出力します。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     * @return SourceDataCollection SourceDataCollection
     */
    public SourceDataCollection print(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        RString 帳票IDRString = RString.EMPTY;
        if (仮算定納入通知書情報 != null && 仮算定納入通知書情報.get帳票ID() != null) {
            帳票IDRString = 仮算定納入通知書情報.get帳票ID().getColumnValue();
        }
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100020)) {
            return print全てページDBB100020(仮算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100022)) {
            return print全てページDBB100022(仮算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100021)) {
            return print全てページDBB100021(仮算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100023)) {
            return print全てページDBB100023(仮算定納入通知書情報);
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
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100020)) {
            print全てページDBB100020(仮算定納入通知書情報, reportManager);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100022)) {
            print全てページDBB100022(仮算定納入通知書情報, reportManager);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100021)) {
            print全てページDBB100021(仮算定納入通知書情報, reportManager);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100023)) {
            print全てページDBB100023(仮算定納入通知書情報, reportManager);
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
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100020)) {
            return print全てページDBB100020DevidedByPage(仮算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100022)) {
            return print全てページDBB100022DevidedByPage(仮算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100021)) {
            return print全てページDBB100021DevidedByPage(仮算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100023)) {
            return print全てページDBB100023DevidedByPage(仮算定納入通知書情報);
        }
        return null;
    }

    private void print全てページDBB100023(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, ReportManager reportManager) {
        KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverProperty property = new KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverProperty();
        try (ReportAssembler<KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID, 仮算定納入通知書情報.get発行日(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport report
                    = new KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport(仮算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private SourceDataCollection print全てページDBB100023DevidedByPage(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverProperty property = new KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID, 仮算定納入通知書情報.get発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<NonyuTsuchisho<KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource>> reportList
                        = new KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport(仮算定納入通知書情報, ninshoshaSource).devidedByPage();
                for (NonyuTsuchisho report : reportList) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private SourceDataCollection print全てページDBB100023(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverProperty property = new KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID, 仮算定納入通知書情報.get発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport report
                        = new KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport(仮算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private SourceDataCollection print全てページDBB100020DevidedByPage(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverProperty property = new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID, 仮算定納入通知書情報.get発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<NonyuTsuchisho<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource>> reportList
                        = new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverReport(仮算定納入通知書情報, ninshoshaSource).devidedByPage();
                for (NonyuTsuchisho report : reportList) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private SourceDataCollection print全てページDBB100021DevidedByPage(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverProperty property = new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID, 仮算定納入通知書情報.get発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<NonyuTsuchisho<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource>> reportList
                        = new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport(仮算定納入通知書情報, ninshoshaSource).devidedByPage();
                for (NonyuTsuchisho report : reportList) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private SourceDataCollection print全てページDBB100021(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverProperty property = new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID, 仮算定納入通知書情報.get発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport report
                        = new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport(仮算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private void print全てページDBB100021(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, ReportManager reportManager) {
        KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverProperty property = new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverProperty();
        try (ReportAssembler<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID, 仮算定納入通知書情報.get発行日(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport report
                    = new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport(仮算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private SourceDataCollection print全てページDBB100020(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverProperty property = new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID, 仮算定納入通知書情報.get発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverReport report
                        = new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverReport(仮算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private void print全てページDBB100020(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, ReportManager reportManager) {
        KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverProperty property = new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverProperty();
        try (ReportAssembler<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource> reportSourceWriter = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID, 仮算定納入通知書情報.get発行日(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverReport report
                    = new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverReport(仮算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private SourceDataCollection print全てページDBB100022DevidedByPage(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverProperty property = new KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID, 仮算定納入通知書情報.get発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<NonyuTsuchisho<KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource>> reportList
                        = new KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverReport(仮算定納入通知書情報, ninshoshaSource).devidedByPage();
                for (NonyuTsuchisho report : reportList) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private SourceDataCollection print全てページDBB100022(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverProperty property = new KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID, 仮算定納入通知書情報.get発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverReport report
                        = new KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverReport(仮算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private void print全てページDBB100022(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, ReportManager reportManager) {
        KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverProperty property = new KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverProperty();
        try (ReportAssembler<KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource> reportSourceWriter = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID, 仮算定納入通知書情報.get発行日(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverReport report
                    = new KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverReport(仮算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
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
