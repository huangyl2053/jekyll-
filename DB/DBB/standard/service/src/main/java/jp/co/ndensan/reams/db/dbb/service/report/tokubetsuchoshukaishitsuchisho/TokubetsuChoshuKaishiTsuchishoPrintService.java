/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.tokubetsuchoshukaishitsuchisho;

import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52Property;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52RenchoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52RenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52Report;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5Property;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5RenchoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5RenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5Report;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoOverlayA4TateProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoOverlayA4TateReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerRenchoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52RenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52Source;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5RenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5Source;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.report.parts.kaigotoiawasesaki.KaigoToiawasesakiSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha._NinshoshaManager;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 帳票設計_DBBRP43002_1_特別徴収開始通知書（本算定）PrintService
 *
 * @reamsid_L DBB-0780-070 xuhao
 */
public class TokubetsuChoshuKaishiTsuchishoPrintService {

    private static final RString 種別コード = NinshoshaDenshikoinshubetsuCode.保険者印.getコード();
    private static final RString RSTRING_1 = new RString("1");

    /**
     * 帳票を出力します。
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param 宛名連番 RString
     * @param 本算定通知書情報 HonSanteiTsuchiShoKyotsu
     * @param reportManager ReportManager
     */
    public void print(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            RString 宛名連番, HonSanteiTsuchiShoKyotsu 本算定通知書情報, ReportManager reportManager) {

        RString 帳票ID = 本算定通知書情報.get帳票ID().getColumnValue();

        if (ReportIdDBB.DBB100032.getReportId().getColumnValue().equals(帳票ID)) {
            printB5横タイプ(編集後本算定通知書共通情報, 宛名連番, 本算定通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100033.getReportId().getColumnValue().equals(帳票ID)) {
            printB5横タイプ連帳(編集後本算定通知書共通情報, 宛名連番, 本算定通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100034.getReportId().getColumnValue().equals(帳票ID)) {
            printシーラタイプ(編集後本算定通知書共通情報, 本算定通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100035.getReportId().getColumnValue().equals(帳票ID)) {
            printシーラタイプ連帳(編集後本算定通知書共通情報, 本算定通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100036.getReportId().getColumnValue().equals(帳票ID)) {
            printB5横タイプ2(編集後本算定通知書共通情報, 宛名連番, 本算定通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100037.getReportId().getColumnValue().equals(帳票ID)) {
            printB5横タイプ2連帳(編集後本算定通知書共通情報, 宛名連番, 本算定通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100038.getReportId().getColumnValue().equals(帳票ID)) {
            printA4縦(編集後本算定通知書共通情報, 宛名連番, 本算定通知書情報, reportManager);
        }
    }

    /**
     * B5横タイプ printメソッド
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param 宛名連番 RString
     * @param 本算定通知書情報 HonSanteiTsuchiShoKyotsu
     * @param reportManager ReportManager
     */
    public void printB5横タイプ(
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            RString 宛名連番,
            HonSanteiTsuchiShoKyotsu 本算定通知書情報, ReportManager reportManager) {
        TokubetsuChoshuKaishiTsuchishoB5Property property
                = new TokubetsuChoshuKaishiTsuchishoB5Property();
        try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoB5Source> assembler = createAssembler(property, reportManager)) {
            FlexibleDate 開始年月日 = FlexibleDate.getNowDate();
            if (本算定通知書情報.get発行日() != null) {
                開始年月日 = new FlexibleDate(本算定通知書情報.get発行日().toString());
            }
            INinshoshaManager manager = new _NinshoshaManager();
            Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 種別コード, 開始年月日);
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            boolean is公印に掛ける = false;
            boolean is公印を省略 = false;
            ChohyoSeigyoKyotsu 帳票制御共通 = 本算定通知書情報.get帳票制御共通();
            if (帳票制御共通 != null) {
                if (RSTRING_1.equals(帳票制御共通.get首長名印字位置())) {
                    is公印に掛ける = true;
                }
                if (!帳票制御共通.is電子公印印字有無()) {
                    is公印を省略 = true;
                }
            }
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    assembler.getImageFolderPath(),
                    本算定通知書情報.get発行日(),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
            ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoB5Source> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new TokubetsuChoshuKaishiTsuchishoB5Report(編集後本算定通知書共通情報, 宛名連番, sourceBuilder).
                    writeBy(reportSourceWriter);
        }
    }

    /**
     * B5横タイプ連帳 printメソッド
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param 宛名連番 RString
     * @param 本算定通知書情報 HonSanteiTsuchiShoKyotsu
     * @param reportManager ReportManager
     */
    public void printB5横タイプ連帳(
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            RString 宛名連番,
            HonSanteiTsuchiShoKyotsu 本算定通知書情報, ReportManager reportManager) {
        TokubetsuChoshuKaishiTsuchishoB5RenchoProperty property
                = new TokubetsuChoshuKaishiTsuchishoB5RenchoProperty();
        try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoB5RenchoSource> assembler = createAssembler(property, reportManager)) {
            FlexibleDate 開始年月日 = FlexibleDate.getNowDate();
            if (本算定通知書情報.get発行日() != null) {
                開始年月日 = new FlexibleDate(本算定通知書情報.get発行日().toString());
            }
            INinshoshaManager manager = new _NinshoshaManager();
            Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 種別コード, 開始年月日);
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            boolean is公印に掛ける = false;
            boolean is公印を省略 = false;
            ChohyoSeigyoKyotsu 帳票制御共通 = 本算定通知書情報.get帳票制御共通();
            if (帳票制御共通 != null) {
                if (RSTRING_1.equals(帳票制御共通.get首長名印字位置())) {
                    is公印に掛ける = true;
                }
                if (!帳票制御共通.is電子公印印字有無()) {
                    is公印を省略 = true;
                }
            }
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    assembler.getImageFolderPath(),
                    本算定通知書情報.get発行日(),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
            ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoB5RenchoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new TokubetsuChoshuKaishiTsuchishoB5RenchoReport(編集後本算定通知書共通情報, 宛名連番, sourceBuilder).
                    writeBy(reportSourceWriter);
        }
    }

    /**
     * シーラタイプ printメソッド
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param 本算定通知書情報 HonSanteiTsuchiShoKyotsu
     * @param reportManager ReportManager
     */
    public void printシーラタイプ(
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            HonSanteiTsuchiShoKyotsu 本算定通知書情報, ReportManager reportManager) {
        TokubetsuChoshuKaishiTsuchishoSealerProperty property
                = new TokubetsuChoshuKaishiTsuchishoSealerProperty();
        try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoSealerSource> assembler = createAssembler(property, reportManager)) {
            FlexibleDate 開始年月日 = FlexibleDate.getNowDate();
            if (本算定通知書情報.get発行日() != null) {
                開始年月日 = new FlexibleDate(本算定通知書情報.get発行日().toString());
            }
            INinshoshaManager manager = new _NinshoshaManager();
            Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 種別コード, 開始年月日);
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            boolean is公印に掛ける = false;
            boolean is公印を省略 = false;
            ChohyoSeigyoKyotsu 帳票制御共通 = 本算定通知書情報.get帳票制御共通();
            if (帳票制御共通 != null) {
                if (RSTRING_1.equals(帳票制御共通.get首長名印字位置())) {
                    is公印に掛ける = true;
                }
                if (!帳票制御共通.is電子公印印字有無()) {
                    is公印を省略 = true;
                }
            }
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    assembler.getImageFolderPath(),
                    本算定通知書情報.get発行日(),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
            ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoSealerSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new TokubetsuChoshuKaishiTsuchishoSealerReport(編集後本算定通知書共通情報, sourceBuilder).
                    writeBy(reportSourceWriter);
        }
    }

    /**
     * printシーラタイプ連帳 printメソッド
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param 本算定通知書情報 HonSanteiTsuchiShoKyotsu
     * @param reportManager ReportManager
     */
    public void printシーラタイプ連帳(
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            HonSanteiTsuchiShoKyotsu 本算定通知書情報, ReportManager reportManager) {
        TokubetsuChoshuKaishiTsuchishoSealerRenchoProperty property
                = new TokubetsuChoshuKaishiTsuchishoSealerRenchoProperty();
        try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoSealerRenchoSource> assembler = createAssembler(property, reportManager)) {
            FlexibleDate 開始年月日 = FlexibleDate.getNowDate();
            if (本算定通知書情報.get発行日() != null) {
                開始年月日 = new FlexibleDate(本算定通知書情報.get発行日().toString());
            }
            INinshoshaManager manager = new _NinshoshaManager();
            Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 種別コード, 開始年月日);
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            boolean is公印に掛ける = false;
            boolean is公印を省略 = false;
            ChohyoSeigyoKyotsu 帳票制御共通 = 本算定通知書情報.get帳票制御共通();
            if (帳票制御共通 != null) {
                if (RSTRING_1.equals(帳票制御共通.get首長名印字位置())) {
                    is公印に掛ける = true;
                }
                if (!帳票制御共通.is電子公印印字有無()) {
                    is公印を省略 = true;
                }
            }
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    assembler.getImageFolderPath(),
                    本算定通知書情報.get発行日(),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
            ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoSealerRenchoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new TokubetsuChoshuKaishiTsuchishoSealerRenchoReport(編集後本算定通知書共通情報, sourceBuilder).
                    writeBy(reportSourceWriter);
        }
    }

    /**
     * B5横タイプ2 printメソッド
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param 宛名連番 RString
     * @param 本算定通知書情報 HonSanteiTsuchiShoKyotsu
     * @param reportManager ReportManager
     */
    public void printB5横タイプ2(
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            RString 宛名連番,
            HonSanteiTsuchiShoKyotsu 本算定通知書情報, ReportManager reportManager) {
        TokubetsuChoshuKaishiTsuchishoB52Property property
                = new TokubetsuChoshuKaishiTsuchishoB52Property();
        try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoB52Source> assembler = createAssembler(property, reportManager)) {
            FlexibleDate 開始年月日 = FlexibleDate.getNowDate();
            if (本算定通知書情報.get発行日() != null) {
                開始年月日 = new FlexibleDate(本算定通知書情報.get発行日().toString());
            }
            INinshoshaManager manager = new _NinshoshaManager();
            Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 種別コード, 開始年月日);
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            boolean is公印に掛ける = false;
            boolean is公印を省略 = false;
            ChohyoSeigyoKyotsu 帳票制御共通 = 本算定通知書情報.get帳票制御共通();
            if (帳票制御共通 != null) {
                if (RSTRING_1.equals(帳票制御共通.get首長名印字位置())) {
                    is公印に掛ける = true;
                }
                if (!帳票制御共通.is電子公印印字有無()) {
                    is公印を省略 = true;
                }
            }
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    assembler.getImageFolderPath(),
                    本算定通知書情報.get発行日(),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
            ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoB52Source> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new TokubetsuChoshuKaishiTsuchishoB52Report(編集後本算定通知書共通情報, 宛名連番, 本算定通知書情報.get地方公共団体(), sourceBuilder).
                    writeBy(reportSourceWriter);
        }
    }

    /**
     * B5横タイプ2連帳 printメソッド
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param 宛名連番 RString
     * @param 本算定通知書情報 HonSanteiTsuchiShoKyotsu
     * @param reportManager ReportManager
     */
    public void printB5横タイプ2連帳(
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            RString 宛名連番,
            HonSanteiTsuchiShoKyotsu 本算定通知書情報, ReportManager reportManager) {
        TokubetsuChoshuKaishiTsuchishoB52RenchoProperty property
                = new TokubetsuChoshuKaishiTsuchishoB52RenchoProperty();
        try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoB52RenchoSource> assembler = createAssembler(property, reportManager)) {
            FlexibleDate 開始年月日 = FlexibleDate.getNowDate();
            if (本算定通知書情報.get発行日() != null) {
                開始年月日 = new FlexibleDate(本算定通知書情報.get発行日().toString());
            }
            INinshoshaManager manager = new _NinshoshaManager();
            Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 種別コード, 開始年月日);
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            boolean is公印に掛ける = false;
            boolean is公印を省略 = false;
            ChohyoSeigyoKyotsu 帳票制御共通 = 本算定通知書情報.get帳票制御共通();
            if (帳票制御共通 != null) {
                if (RSTRING_1.equals(帳票制御共通.get首長名印字位置())) {
                    is公印に掛ける = true;
                }
                if (!帳票制御共通.is電子公印印字有無()) {
                    is公印を省略 = true;
                }
            }
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    assembler.getImageFolderPath(),
                    本算定通知書情報.get発行日(),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
            ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoB52RenchoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new TokubetsuChoshuKaishiTsuchishoB52RenchoReport(編集後本算定通知書共通情報, 宛名連番, sourceBuilder).
                    writeBy(reportSourceWriter);
        }
    }

    /**
     * printA4縦 printメソッド
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param 通知書定型文 RString
     * @param 本算定通知書情報 HonSanteiTsuchiShoKyotsu
     * @param reportManager ReportManager
     */
    public void printA4縦(
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            RString 通知書定型文,
            HonSanteiTsuchiShoKyotsu 本算定通知書情報, ReportManager reportManager) {
        TokubetsuChoshuKaishiTsuchishoOverlayA4TateProperty property
                = new TokubetsuChoshuKaishiTsuchishoOverlayA4TateProperty();
        try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource> assembler = createAssembler(property, reportManager)) {
            FlexibleDate 開始年月日 = FlexibleDate.getNowDate();
            if (本算定通知書情報.get発行日() != null) {
                開始年月日 = new FlexibleDate(本算定通知書情報.get発行日().toString());
            }
            INinshoshaManager manager = new _NinshoshaManager();
            Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 種別コード, 開始年月日);
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            boolean is公印に掛ける = false;
            boolean is公印を省略 = false;
            ChohyoSeigyoKyotsu 帳票制御共通 = 本算定通知書情報.get帳票制御共通();
            if (帳票制御共通 != null) {
                if (RSTRING_1.equals(帳票制御共通.get首長名印字位置())) {
                    is公印に掛ける = true;
                }
                if (!帳票制御共通.is電子公印印字有無()) {
                    is公印を省略 = true;
                }
            }
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    assembler.getImageFolderPath(),
                    本算定通知書情報.get発行日(),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
            IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー
                    = KaigoToiawasesakiSourceBuilderCreator.create(SubGyomuCode.DBB介護賦課, 本算定通知書情報.get帳票分類ID());
            CompKaigoToiawasesakiSource toiawasesakiSource = 介護問合せ先ソースビルダー.buildSource();
            ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new TokubetsuChoshuKaishiTsuchishoOverlayA4TateReport(編集後本算定通知書共通情報, 通知書定型文, toiawasesakiSource, sourceBuilder).
                    writeBy(reportSourceWriter);
        }
    }

    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(
            IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }
}
