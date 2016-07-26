/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.hokenryononyutsuchishobook;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookFuriKaeAriCoverProperty;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookFuriKaeAriCoverReport;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverProperty;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverReport;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookFuriKaeNashiProperty;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookFuriKaeNashiReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.HokenryoNonyuNonyuTsuchishoBookFuriKaeAriRenchoCoverSource;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 帳票設計_DBBRP00007_10_保険料納入通知書（本算定）【ブックタイプ】のプリントサービスです。
 *
 * @reamsid_L DBB-9110-100 huangh
 */
public class HokenryoNonyuTsuchishoBookPrintService {

    private final ReportId 帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private final RString 帳票IDの先頭_DBB100055 = new RString("DBB100055");
    private final RString 帳票IDの先頭_DBB100056 = new RString("DBB100056");
    private final RString 帳票IDの先頭_DBB100057 = new RString("DBB100057");
    private final RString 帳票IDの先頭_DBB100058 = new RString("DBB100058");
    private final RString 項目名１ = new RString("当初出力_中期開始期");
    private final RString 項目名２ = new RString("当初出力_後期開始期");

    /**
     * 帳票を出力します。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @return SourceDataCollection SourceDataCollection
     */
    public SourceDataCollection print(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {

        RString 帳票IDRString = 本算定納入通知書情報.get帳票ID().getColumnValue();

        RString 当初出力_中期開始期 = new RString("0");
        RString 当初出力_後期開始期 = new RString("0");
        ChohyoSeigyoHanyo 帳票制御汎用１ = load帳票制御汎用ByKey(帳票分類ID, 本算定納入通知書情報.get納付書共通().get調定年度(), 項目名１);
        if (帳票制御汎用１ != null) {
            当初出力_中期開始期 = 帳票制御汎用１.get設定値();
        }
        ChohyoSeigyoHanyo 帳票制御汎用２ = load帳票制御汎用ByKey(帳票分類ID, 本算定納入通知書情報.get納付書共通().get調定年度(), 項目名２);
        if (帳票制御汎用２ != null) {
            当初出力_後期開始期 = 帳票制御汎用２.get設定値();
        }

        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100055)) {
            return print全てページDBB100055(本算定納入通知書情報, 当初出力_中期開始期, 当初出力_後期開始期);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100057)) {
            return print全てページDBB100057(本算定納入通知書情報, 当初出力_中期開始期, 当初出力_後期開始期);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100056)) {
            return print全てページDBB100056(本算定納入通知書情報, 当初出力_中期開始期, 当初出力_後期開始期);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100058)) {
            return print全てページDBB100058(本算定納入通知書情報, 当初出力_中期開始期, 当初出力_後期開始期);
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

        RString 帳票IDRString = 本算定納入通知書情報.get帳票ID().getColumnValue();

        RString 当初出力_中期開始期 = new RString("0");
        RString 当初出力_後期開始期 = new RString("0");
        ChohyoSeigyoHanyo 帳票制御汎用１ = load帳票制御汎用ByKey(帳票分類ID, 本算定納入通知書情報.get納付書共通().get調定年度(), 項目名１);
        if (帳票制御汎用１ != null) {
            当初出力_中期開始期 = 帳票制御汎用１.get設定値();
        }
        ChohyoSeigyoHanyo 帳票制御汎用２ = load帳票制御汎用ByKey(帳票分類ID, 本算定納入通知書情報.get納付書共通().get調定年度(), 項目名２);
        if (帳票制御汎用２ != null) {
            当初出力_後期開始期 = 帳票制御汎用２.get設定値();
        }
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100055)) {
            print全てページDBB100055(本算定納入通知書情報, reportManager, 当初出力_中期開始期, 当初出力_後期開始期);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100057)) {
            print全てページDBB100057(本算定納入通知書情報, reportManager, 当初出力_中期開始期, 当初出力_後期開始期);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100056)) {
            print全てページDBB100056(本算定納入通知書情報, reportManager, 当初出力_中期開始期, 当初出力_後期開始期);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100058)) {
            print全てページDBB100058(本算定納入通知書情報, reportManager, 当初出力_中期開始期, 当初出力_後期開始期);
        }
    }

    /**
     * 帳票を出力します。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @return SourceDataCollection
     */
    public SourceDataCollection printDevidedByPage(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {

        RString 帳票IDRString = 本算定納入通知書情報.get帳票ID().getColumnValue();

        RString 当初出力_中期開始期 = new RString("0");
        RString 当初出力_後期開始期 = new RString("0");
        ChohyoSeigyoHanyo 帳票制御汎用１ = load帳票制御汎用ByKey(帳票分類ID, 本算定納入通知書情報.get納付書共通().get調定年度(), 項目名１);
        if (帳票制御汎用１ != null) {
            当初出力_中期開始期 = 帳票制御汎用１.get設定値();
        }
        ChohyoSeigyoHanyo 帳票制御汎用２ = load帳票制御汎用ByKey(帳票分類ID, 本算定納入通知書情報.get納付書共通().get調定年度(), 項目名２);
        if (帳票制御汎用２ != null) {
            当初出力_後期開始期 = 帳票制御汎用２.get設定値();
        }
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100055)) {
            return print全てページDBB100055DevidedByPage(本算定納入通知書情報, 当初出力_中期開始期, 当初出力_後期開始期);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100057)) {
            return print全てページDBB100057DevidedByPage(本算定納入通知書情報, 当初出力_中期開始期, 当初出力_後期開始期);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100056)) {
            return print全てページDBB100056DevidedByPage(本算定納入通知書情報, 当初出力_中期開始期, 当初出力_後期開始期);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100058)) {
            return print全てページDBB100058DevidedByPage(本算定納入通知書情報, 当初出力_中期開始期, 当初出力_後期開始期);
        }
        return null;
    }

    private void print全てページDBB100058(
            HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報,
            ReportManager reportManager,
            RString 当初出力_中期開始期,
            RString 当初出力_後期開始期) {
        HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoProperty property = new HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoProperty();
        try (ReportAssembler<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport report
                    = new HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport(
                            本算定納入通知書情報, ninshoshaSource, 当初出力_中期開始期, 当初出力_後期開始期);
            report.writeBy(reportSourceWriter);
        }
    }

    private SourceDataCollection print全てページDBB100058DevidedByPage(
            HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報,
            RString 当初出力_中期開始期,
            RString 当初出力_後期開始期) {
        HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoProperty property = new HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<NonyuTsuchisho<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource>> reportList
                        = new HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport(
                                本算定納入通知書情報, ninshoshaSource, 当初出力_中期開始期, 当初出力_後期開始期).devidedByPage();
                for (NonyuTsuchisho report : reportList) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private SourceDataCollection print全てページDBB100058(
            HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報,
            RString 当初出力_中期開始期,
            RString 当初出力_後期開始期) {
        HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoProperty property = new HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport report
                        = new HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport(
                                本算定納入通知書情報, ninshoshaSource, 当初出力_中期開始期, 当初出力_後期開始期);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private SourceDataCollection print全てページDBB100055DevidedByPage(
            HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報,
            RString 当初出力_中期開始期,
            RString 当初出力_後期開始期) {
        HokenryoNonyuTsuchishoBookFuriKaeAriCoverProperty property = new HokenryoNonyuTsuchishoBookFuriKaeAriCoverProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<NonyuTsuchisho<HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource>> reportList
                        = new HokenryoNonyuTsuchishoBookFuriKaeAriCoverReport(
                                本算定納入通知書情報, ninshoshaSource, 当初出力_中期開始期, 当初出力_後期開始期).devidedByPage();
                for (NonyuTsuchisho report : reportList) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private SourceDataCollection print全てページDBB100056DevidedByPage(
            HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報,
            RString 当初出力_中期開始期,
            RString 当初出力_後期開始期) {
        HokenryoNonyuTsuchishoBookFuriKaeNashiProperty property = new HokenryoNonyuTsuchishoBookFuriKaeNashiProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<NonyuTsuchisho<HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource>> reportList
                        = new HokenryoNonyuTsuchishoBookFuriKaeNashiReport(
                                本算定納入通知書情報, ninshoshaSource, 当初出力_中期開始期, 当初出力_後期開始期).devidedByPage();
                for (NonyuTsuchisho report : reportList) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private SourceDataCollection print全てページDBB100056(
            HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報,
            RString 当初出力_中期開始期,
            RString 当初出力_後期開始期) {
        HokenryoNonyuTsuchishoBookFuriKaeNashiProperty property = new HokenryoNonyuTsuchishoBookFuriKaeNashiProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                HokenryoNonyuTsuchishoBookFuriKaeNashiReport report
                        = new HokenryoNonyuTsuchishoBookFuriKaeNashiReport(
                                本算定納入通知書情報, ninshoshaSource, 当初出力_中期開始期, 当初出力_後期開始期);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private void print全てページDBB100056(
            HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報,
            ReportManager reportManager,
            RString 当初出力_中期開始期,
            RString 当初出力_後期開始期) {
        HokenryoNonyuTsuchishoBookFuriKaeNashiProperty property = new HokenryoNonyuTsuchishoBookFuriKaeNashiProperty();
        try (ReportAssembler<HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            HokenryoNonyuTsuchishoBookFuriKaeNashiReport report
                    = new HokenryoNonyuTsuchishoBookFuriKaeNashiReport(
                            本算定納入通知書情報, ninshoshaSource, 当初出力_中期開始期, 当初出力_後期開始期);
            report.writeBy(reportSourceWriter);
        }
    }

    private SourceDataCollection print全てページDBB100055(
            HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報,
            RString 当初出力_中期開始期,
            RString 当初出力_後期開始期) {
        HokenryoNonyuTsuchishoBookFuriKaeAriCoverProperty property = new HokenryoNonyuTsuchishoBookFuriKaeAriCoverProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                HokenryoNonyuTsuchishoBookFuriKaeAriCoverReport report
                        = new HokenryoNonyuTsuchishoBookFuriKaeAriCoverReport(
                                本算定納入通知書情報, ninshoshaSource, 当初出力_中期開始期, 当初出力_後期開始期);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private void print全てページDBB100055(
            HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報,
            ReportManager reportManager,
            RString 当初出力_中期開始期,
            RString 当初出力_後期開始期) {
        HokenryoNonyuTsuchishoBookFuriKaeAriCoverProperty property = new HokenryoNonyuTsuchishoBookFuriKaeAriCoverProperty();
        try (ReportAssembler<HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource> reportSourceWriter = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            HokenryoNonyuTsuchishoBookFuriKaeAriCoverReport report
                    = new HokenryoNonyuTsuchishoBookFuriKaeAriCoverReport(
                            本算定納入通知書情報, ninshoshaSource, 当初出力_中期開始期, 当初出力_後期開始期);
            report.writeBy(reportSourceWriter);
        }
    }

    private SourceDataCollection print全てページDBB100057DevidedByPage(
            HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報,
            RString 当初出力_中期開始期,
            RString 当初出力_後期開始期) {
        HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverProperty property = new HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HokenryoNonyuNonyuTsuchishoBookFuriKaeAriRenchoCoverSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<HokenryoNonyuNonyuTsuchishoBookFuriKaeAriRenchoCoverSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                List<NonyuTsuchisho<HokenryoNonyuNonyuTsuchishoBookFuriKaeAriRenchoCoverSource>> reportList
                        = new HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverReport(
                                本算定納入通知書情報, ninshoshaSource, 当初出力_中期開始期, 当初出力_後期開始期).devidedByPage();
                for (NonyuTsuchisho report : reportList) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private SourceDataCollection print全てページDBB100057(
            HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報,
            RString 当初出力_中期開始期,
            RString 当初出力_後期開始期) {
        HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverProperty property = new HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HokenryoNonyuNonyuTsuchishoBookFuriKaeAriRenchoCoverSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<HokenryoNonyuNonyuTsuchishoBookFuriKaeAriRenchoCoverSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverReport report
                        = new HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverReport(
                                本算定納入通知書情報, ninshoshaSource, 当初出力_中期開始期, 当初出力_後期開始期);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private void print全てページDBB100057(
            HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報,
            ReportManager reportManager,
            RString 当初出力_中期開始期,
            RString 当初出力_後期開始期) {
        HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverProperty property = new HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverProperty();
        try (ReportAssembler<HokenryoNonyuNonyuTsuchishoBookFuriKaeAriRenchoCoverSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<HokenryoNonyuNonyuTsuchishoBookFuriKaeAriRenchoCoverSource> reportSourceWriter = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverReport report
                    = new HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverReport(
                            本算定納入通知書情報, ninshoshaSource, 当初出力_中期開始期, 当初出力_後期開始期);
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

    /**
     * 帳票制御汎用取得メソッドです。
     *
     * @param 帳票分類ID 帳票分類ID
     * @param 管理年度 管理年度
     * @param 項目名 項目名
     * @return ChohyoSeigyoHanyo
     */
    private ChohyoSeigyoHanyo load帳票制御汎用ByKey(ReportId 帳票分類ID,
            FlexibleYear 管理年度, RString 項目名) {
        DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
        DbT7067ChohyoSeigyoHanyoEntity entity
                = 帳票制御汎用Dac.select帳票制御汎用キー(SubGyomuCode.DBB介護賦課, 帳票分類ID, 管理年度, 項目名);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoHanyo(entity);
    }
}
