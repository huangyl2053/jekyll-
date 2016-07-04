/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt43002;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempResult;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko.PrtTokuchoKaishiTsuchishoHonsanteiResult;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5Report;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsuKomokuHenshu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka.HonsanteifukaBatchTyouhyou;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt43002.HonsanteifukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5Source;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.IBatchReportWriterWithCheckList;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListInfoFactory;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListLineItemSet;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckShubetsu;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckListInfo;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckTarget;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ISpecificKey;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 特徴開始通知書(本算定）の発行クラスです。
 *
 * @reamsid_L DBB-0780-050 xicongwang
 */
public class PrtTokuchoKaishiTsuchishoHonsanteiProcess extends SimpleBatchProcessBase {

    private static final ReportId 特別徴収開始通知書本算定_帳票分類ID = new ReportId("DBB100032_TokubetsuChoshuKaishiTsuchishoDaihyo");
    private static final RString RSTRING_1 = new RString("1");
    private Association 地方公共団体;
    private HonsanteifukaProcessParameter processParameter;
    @BatchWriter
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoB5Source> reportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoB5Source> dbb100032ReportSourceWriter;

    @Override
    protected void beforeExecute() {
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
    }

    @Override
    protected void process() {
        HonsanteiTsuchishoIkkatsuHakko manager = HonsanteiTsuchishoIkkatsuHakko.createInstance();
        HonsanteifukaBatchTyouhyou 出力帳票一覧 = processParameter.get出力帳票一覧();
        PrtTokuchoKaishiTsuchishoHonsanteiResult result = null;
        try {
            result = manager.prtTokuchoKaishiTsuchishoHonsantei(processParameter.get調定年度(), processParameter.get特徴_発行日(),
                    processParameter.get帳票作成日時().getRDateTime(), 出力帳票一覧.get出力順ID(), 出力帳票一覧.get帳票ID(),
                    processParameter.get特徴_出力対象());
        } catch (InvocationTargetException ex) {
            Logger.getLogger(PrtTokuchoKaishiTsuchishoHonsanteiProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result == null) {
            return;
        }
        CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目1.class, チェック項目1.class);
        ICheckListInfo info = CheckListInfoFactory.createInstance(SubGyomuCode.DBB介護賦課,
                地方公共団体.getLasdecCode_(), 地方公共団体.get市町村名());

        reportWriter = BatchWriters
                .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoB5Source.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(processParameter.get出力帳票一覧().get帳票ID())
                .build();
        dbb100032ReportSourceWriter = new ReportSourceWriter<>(reportWriter);
        List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報List = new ArrayList<>();
        HonSanteiTsuchiShoKyotsuKomokuHenshu 本算定共通情報作成 = InstanceProvider.create(HonSanteiTsuchiShoKyotsuKomokuHenshu.class);
        int 総ページ数 = 0;
        for (HonsanteiTsuchishoTempResult tmpResult : result.get特徴開始通知書ResultList()) {
            HonSanteiTsuchiShoKyotsu 本算定通知書情報 = new HonSanteiTsuchiShoKyotsu();
            本算定通知書情報.set発行日(processParameter.get特徴_発行日());
            本算定通知書情報.set帳票分類ID(特別徴収開始通知書本算定_帳票分類ID);
            本算定通知書情報.set帳票ID(出力帳票一覧.get帳票ID());
            本算定通知書情報.set処理区分(ShoriKubun.バッチ);
            本算定通知書情報.set地方公共団体(地方公共団体);
            本算定通知書情報.set賦課の情報_更正前(tmpResult.get賦課の情報_更正前());
            本算定通知書情報.set賦課の情報_更正後(tmpResult.get賦課の情報_更正後());
            本算定通知書情報.set納組情報(tmpResult.get納組情報());
            本算定通知書情報.set宛先情報(tmpResult.get宛先情報());
            本算定通知書情報.set口座情報(tmpResult.get口座情報());
            本算定通知書情報.set徴収方法情報_更正前(tmpResult.get徴収方法情報_更正前());
            本算定通知書情報.set徴収方法情報_更正後(tmpResult.get徴収方法情報_更正後());
            本算定通知書情報.set対象者_追加含む_情報_更正前(tmpResult.get対象者_追加含む_情報_更正前());
            本算定通知書情報.set対象者_追加含む_情報_更正後(tmpResult.get対象者_追加含む_情報_更正後());
            本算定通知書情報.set収入情報(tmpResult.get収入情報());
            本算定通知書情報.set帳票制御共通(result.get帳票制御共通());
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 = 本算定共通情報作成.create本算定通知書共通情報(本算定通知書情報);
            総ページ数 = 総ページ数 + publish特徴開始通知書(出力帳票一覧, 編集後本算定通知書共通情報, result, 本算定通知書情報);

            編集後本算定通知書共通情報List.add(編集後本算定通知書共通情報);
        }
        manager.publishTokuchoKaishiTsuchishoHonsantei(result, 編集後本算定通知書共通情報List, 総ページ数);

    }

    private int publish特徴開始通知書(HonsanteifukaBatchTyouhyou 出力帳票一覧, EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            PrtTokuchoKaishiTsuchishoHonsanteiResult result, HonSanteiTsuchiShoKyotsu 本算定通知書情報) {

        if (ReportIdDBB.DBB100032.getReportId().equals(出力帳票一覧.get帳票ID())) {
            FlexibleDate 開始年月日 = FlexibleDate.getNowDate();
            if (本算定通知書情報.get発行日() != null) {
                開始年月日 = new FlexibleDate(本算定通知書情報.get発行日().toString());
            }
            Ninshosha 認証者 = NinshoshaFinderFactory.createInstance()
                    .get帳票認証者(GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), 開始年月日);
            boolean is公印に掛ける = false;
            boolean is公印を省略 = false;
            ChohyoSeigyoKyotsu 帳票制御共通 = 本算定通知書情報.get帳票制御共通();
            if (帳票制御共通 != null && RSTRING_1.equals(帳票制御共通.get首長名印字位置())) {
                is公印に掛ける = true;
            }
            if (帳票制御共通 != null && !帳票制御共通.is電子公印印字有無()) {
                is公印を省略 = true;
            }
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100032ReportSourceWriter.getImageFolderPath(),
                    本算定通知書情報.get発行日(),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
            new TokubetsuChoshuKaishiTsuchishoB5Report(編集後本算定通知書共通情報, result.get宛名連番(), sourceBuilder)
                    .writeBy(dbb100032ReportSourceWriter);
            reportWriter.close();
        }
        return dbb100032ReportSourceWriter.pageCount().value();
//        else if (ReportIdDBB.DBB100033.getReportId().equals(出力帳票一覧.get帳票ID())) {
//            new TokubetsuChoshuKaishiTsuchishoB5RenchoReport(編集後本算定通知書共通情報, result.get宛名連番(), sourceBuilder).
//                    writeBy(dbb100032ReportSourceWriter);
//        } else if (ReportIdDBB.DBB100034.getReportId().equals(出力帳票一覧.get帳票ID())) {
//            new TokubetsuChoshuKaishiTsuchishoSealerReport(編集後本算定通知書共通情報, sourceBuilder).
//                    writeBy(dbb100032ReportSourceWriter);
//        } else if (ReportIdDBB.DBB100035.getReportId().equals(出力帳票一覧.get帳票ID())) {
//            new TokubetsuChoshuKaishiTsuchishoSealerRenchoReport(編集後本算定通知書共通情報, sourceBuilder).
//                    writeBy(dbb100032ReportSourceWriter);
//        } else if (ReportIdDBB.DBB100036.getReportId().equals(出力帳票一覧.get帳票ID())) {
//            new TokubetsuChoshuKaishiTsuchishoB52Report(編集後本算定通知書共通情報, result.get宛名連番(), sourceBuilder).
//                    writeBy(dbb100032ReportSourceWriter);
//        } else if (ReportIdDBB.DBB100037.getReportId().equals(出力帳票一覧.get帳票ID())) {
//            new TokubetsuChoshuKaishiTsuchishoB52RenchoReport(編集後本算定通知書共通情報, result.get宛名連番(), sourceBuilder).
//                    writeBy(dbb100032ReportSourceWriter);
//        } else if (ReportIdDBB.DBB100038.getReportId().equals(出力帳票一覧.get帳票ID())) {
//            IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー
//                    = KaigoToiawasesakiSourceBuilderCreator.create(SubGyomuCode.DBB介護賦課, 本算定通知書情報.get帳票分類ID());
//            CompKaigoToiawasesakiSource toiawasesakiSource = 介護問合せ先ソースビルダー.buildSource();
//            new TokubetsuChoshuKaishiTsuchishoOverlayA4TateReport(編集後本算定通知書共通情報, result.get通知書定型文(),
//                    toiawasesakiSource, sourceBuilder).writeBy(dbb100032ReportSourceWriter);
//        }

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

    @Override
    protected void afterExecute() {

    }

    private enum 特定項目1 implements ISpecificKey {

        key1(TokubetsuChoshuKaishiTsuchishoB5Source.ITEM_NENDO, "賦課年度"),
        key2(TokubetsuChoshuKaishiTsuchishoB5Source.ITEM_TSUCHISHONO2, "通知書番号");

        private final RString itemName;
        private final RString printName;

        private 特定項目1(String itemName, String printName) {
            this.itemName = new RString(itemName);
            this.printName = new RString(printName);
        }

        @Override
        public RString getItemName() {
            return this.itemName;
        }

        @Override
        public RString getPrintName() {
            return this.printName;
        }
    }

    private enum チェック項目1 implements ICheckTarget {

        target1("hihokenshaName2", "被保険者氏名2", CheckShubetsu.文字切れ),
        target2("setainushiName1", "世帯主名1", CheckShubetsu.文字切れ),
        target4("hokenshaName", "被保険者氏名", CheckShubetsu.文字切れ);

        private final RString itemName;
        private final RString printName;
        private final CheckShubetsu checkShubetsu;

        private チェック項目1(String itemName, String printName, CheckShubetsu checkShubetsu) {
            this.itemName = new RString(itemName);
            this.printName = new RString(printName);
            this.checkShubetsu = checkShubetsu;
        }

        @Override
        public RString getItemName() {
            return this.itemName;
        }

        @Override
        public RString getPrintName() {
            return this.printName;
        }

        @Override
        public CheckShubetsu getCheckShubetsu() {
            return this.checkShubetsu;
        }
    }

}
