/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB051003;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempResult;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko.PrtTokuchoKaishiTsuchishoHonsanteiResult;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko.TokuchoKaishiTsuchishoInfo;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52RenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52Report;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5RenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5Report;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoOverlayA4TateReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsuKomokuHenshu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB051001.ChohyoResult;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt44002.HonsanteiIdoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52RenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52Source;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5RenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5Source;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerSource;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteiidogennendotsuchisyoikatsuhako.HonsanteiIdoGennendoTsuchisyoIkatsuHako;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.report.parts.kaigotoiawasesaki.KaigoToiawasesakiSourceBuilderCreator;
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
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 特徴開始通知書(本算定）の発行クラスです。
 *
 * @reamsid_L DBB-0880-030 xicongwang
 */
public class PrtIdoTokuchoKaishiTsuchishoHonsanteiProcess extends SimpleBatchProcessBase {

    private static final ReportId 特別徴収開始通知書本算定_帳票分類ID = new ReportId("DBB100032_TokubetsuChoshuKaishiTsuchishoDaihyo");
    private static final RString 定数_賦課年度 = new RString("賦課年度");
    private static final RString 定数_通知書番号 = new RString("通知書番号");
    private static final RString 定数_被保険者氏名 = new RString("被保険者氏名");
    private static final RString 定数_被保険者番号 = new RString("hihokenshaName");
    private static final RString RSTRING_1 = new RString("1");

    private ChohyoResult 出力帳票一覧;
    private Association 地方公共団体;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private HonsanteiIdoProcessParameter processParameter;
    private HonsanteiIdoGennendoTsuchisyoIkatsuHako manager;

    private NinshoshaSource dbb100032NinshoshaSource;
    private NinshoshaSource dbb100033NinshoshaSource;
    private NinshoshaSource dbb100034NinshoshaSource;
    private NinshoshaSource dbb100035NinshoshaSource;
    private NinshoshaSource dbb100036NinshoshaSource;
    private NinshoshaSource dbb100037NinshoshaSource;
    private NinshoshaSource dbb100038NinshoshaSource;

    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoB5Source> dbb100032ReportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoB5Source> dbb100032ReportSourceWriter;
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoB5RenchoSource> dbb100033ReportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoB5RenchoSource> dbb100033ReportSourceWriter;
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoSealerSource> dbb100034ReportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoSealerSource> dbb100034ReportSourceWriter;
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoSealerRenchoSource> dbb100035ReportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoSealerRenchoSource> dbb100035ReportSourceWriter;
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoB52Source> dbb100036ReportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoB52Source> dbb100036ReportSourceWriter;
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoB52RenchoSource> dbb100037ReportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoB52RenchoSource> dbb100037ReportSourceWriter;
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource> dbb100038ReportWriter8;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource> dbb100038ReportSourceWriter;

    @Override
    protected void beforeExecute() {
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        出力帳票一覧 = processParameter.get出力帳票一覧();
        manager = HonsanteiIdoGennendoTsuchisyoIkatsuHako.createInstance();
        帳票制御共通 = manager.load帳票制御共通(特別徴収開始通知書本算定_帳票分類ID);

        initialize特徴開始通知書();
    }

    @Override
    protected void process() {
        PrtTokuchoKaishiTsuchishoHonsanteiResult result = null;
        try {
            result = manager.prtTokuchoKaishiTsuchishoHonsantei(processParameter.get調定年度(), new RDate(processParameter.get特徴_発行日().toString()),
                    processParameter.get帳票作成日時().getRDateTime(), 出力帳票一覧.get出力順ID(), new ReportId(出力帳票一覧.get帳票ID()),
                    processParameter.get特徴_出力対象());
        } catch (InvocationTargetException ex) {
            Logger.getLogger(PrtIdoTokuchoKaishiTsuchishoHonsanteiProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result == null) {
            return;
        }

        List<TokuchoKaishiTsuchishoInfo> 編集本算定通知書共通情報List = new ArrayList<>();
        HonSanteiTsuchiShoKyotsuKomokuHenshu 本算定共通情報作成 = InstanceProvider.create(HonSanteiTsuchiShoKyotsuKomokuHenshu.class);
        int 総ページ数 = 0;
        for (HonsanteiTsuchishoTempResult tmpResult : result.get特徴開始通知書ResultList()) {
            TokuchoKaishiTsuchishoInfo tokuchoKaishiTsuchishoInfo = new TokuchoKaishiTsuchishoInfo();
            HonSanteiTsuchiShoKyotsu 本算定通知書情報 = new HonSanteiTsuchiShoKyotsu();
            本算定通知書情報.set発行日(result.get発行日());
            本算定通知書情報.set帳票分類ID(特別徴収開始通知書本算定_帳票分類ID);
            本算定通知書情報.set帳票ID(result.get帳票ID());
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
            総ページ数 = publish特徴開始通知書(編集後本算定通知書共通情報, result, 本算定通知書情報);
            tokuchoKaishiTsuchishoInfo.set本算定通知書情報(本算定通知書情報);
            tokuchoKaishiTsuchishoInfo.set編集後本算定通知書共通情報(編集後本算定通知書共通情報);
            tokuchoKaishiTsuchishoInfo.set生活保護区分(tmpResult.get生活保護区分());
            tokuchoKaishiTsuchishoInfo.set特徴10月開始者区分(tmpResult.get特徴10月開始者区分());

            編集本算定通知書共通情報List.add(tokuchoKaishiTsuchishoInfo);
        }
        manager.publish特徴開始通知書本算定(result, 編集本算定通知書共通情報List, 総ページ数);

    }

    @Override
    protected void afterExecute() {
        close特徴開始通知書();
    }

    private void close特徴開始通知書() {
        if (ReportIdDBB.DBB100032.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100032ReportWriter.close();
        } else if (ReportIdDBB.DBB100033.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100033ReportWriter.close();
        } else if (ReportIdDBB.DBB100034.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100034ReportWriter.close();
        } else if (ReportIdDBB.DBB100035.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100035ReportWriter.close();
        } else if (ReportIdDBB.DBB100036.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100036ReportWriter.close();
        } else if (ReportIdDBB.DBB100037.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100037ReportWriter.close();
        } else if (ReportIdDBB.DBB100038.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100038ReportWriter8.close();
        }
    }

    private void initialize特徴開始通知書() {

        FlexibleDate 開始年月日 = FlexibleDate.getNowDate();
        if (processParameter.get特徴_発行日() != null) {
            開始年月日 = new FlexibleDate(processParameter.get特徴_発行日().toString());
        }
        Ninshosha 認証者 = NinshoshaFinderFactory.createInstance()
                .get帳票認証者(GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), 開始年月日);
        boolean is公印に掛ける = false;
        boolean is公印を省略 = false;
        if (帳票制御共通 != null && RSTRING_1.equals(帳票制御共通.get首長名印字位置())) {
            is公印に掛ける = true;
        }
        if (帳票制御共通 != null && !帳票制御共通.is電子公印印字有無()) {
            is公印を省略 = true;
        }
        ICheckListInfo info = CheckListInfoFactory.createInstance(SubGyomuCode.DBB介護賦課,
                地方公共団体.getLasdecCode_(), 地方公共団体.get市町村名());
        if (ReportIdDBB.DBB100032.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目1.class, チェック項目1.class);
            dbb100032ReportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoB5Source.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧().get帳票ID())
                    .build();
            dbb100032ReportSourceWriter = new ReportSourceWriter<>(dbb100032ReportWriter);
            dbb100032NinshoshaSource = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100032ReportSourceWriter.getImageFolderPath(),
                    new RDate(processParameter.get特徴_発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        } else if (ReportIdDBB.DBB100033.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目2.class, チェック項目2.class);
            dbb100033ReportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoB5RenchoSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧().get帳票ID())
                    .build();
            dbb100033ReportSourceWriter = new ReportSourceWriter<>(dbb100033ReportWriter);
            dbb100033NinshoshaSource = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100033ReportSourceWriter.getImageFolderPath(),
                    new RDate(processParameter.get特徴_発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        } else if (ReportIdDBB.DBB100034.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目3.class, チェック項目3.class);
            dbb100034ReportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoSealerSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧().get帳票ID())
                    .build();
            dbb100034ReportSourceWriter = new ReportSourceWriter<>(dbb100034ReportWriter);
            dbb100034NinshoshaSource = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100034ReportSourceWriter.getImageFolderPath(),
                    new RDate(processParameter.get特徴_発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        } else if (ReportIdDBB.DBB100035.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目4.class, チェック項目4.class);
            dbb100035ReportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoSealerRenchoSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧().get帳票ID())
                    .build();
            dbb100035ReportSourceWriter = new ReportSourceWriter<>(dbb100035ReportWriter);
            dbb100035NinshoshaSource = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100035ReportSourceWriter.getImageFolderPath(),
                    new RDate(processParameter.get特徴_発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        } else if (ReportIdDBB.DBB100036.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目5.class, チェック項目5.class);
            dbb100036ReportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoB52Source.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧().get帳票ID())
                    .build();
            dbb100036ReportSourceWriter = new ReportSourceWriter<>(dbb100036ReportWriter);
            dbb100036NinshoshaSource = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100036ReportSourceWriter.getImageFolderPath(),
                    new RDate(processParameter.get特徴_発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        } else if (ReportIdDBB.DBB100037.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目6.class, チェック項目6.class);
            dbb100037ReportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoB52RenchoSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧().get帳票ID())
                    .build();
            dbb100037ReportSourceWriter = new ReportSourceWriter<>(dbb100037ReportWriter);
            dbb100037NinshoshaSource = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100037ReportSourceWriter.getImageFolderPath(),
                    new RDate(processParameter.get特徴_発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        } else if (ReportIdDBB.DBB100038.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目7.class, チェック項目7.class);
            dbb100038ReportWriter8 = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧().get帳票ID())
                    .build();
            dbb100038ReportSourceWriter = new ReportSourceWriter<>(dbb100038ReportWriter8);
            dbb100038NinshoshaSource = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100038ReportSourceWriter.getImageFolderPath(),
                    new RDate(processParameter.get特徴_発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        }
    }

    private int publish特徴開始通知書(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            PrtTokuchoKaishiTsuchishoHonsanteiResult result, HonSanteiTsuchiShoKyotsu 本算定通知書情報) {

        if (ReportIdDBB.DBB100032.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100032ReportSourceWriter = new ReportSourceWriter<>(dbb100032ReportWriter);
            new TokubetsuChoshuKaishiTsuchishoB5Report(編集後本算定通知書共通情報, result.get宛名連番(), 地方公共団体, dbb100032NinshoshaSource)
                    .writeBy(dbb100032ReportSourceWriter);
            return dbb100032ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100033.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100033ReportSourceWriter = new ReportSourceWriter<>(dbb100033ReportWriter);
            new TokubetsuChoshuKaishiTsuchishoB5RenchoReport(編集後本算定通知書共通情報, result.get宛名連番(), dbb100033NinshoshaSource).
                    writeBy(dbb100033ReportSourceWriter);
            return dbb100033ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100034.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100034ReportSourceWriter = new ReportSourceWriter<>(dbb100034ReportWriter);
            new TokubetsuChoshuKaishiTsuchishoSealerReport(編集後本算定通知書共通情報, dbb100034NinshoshaSource).
                    writeBy(dbb100034ReportSourceWriter);
            return dbb100034ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100035.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100035ReportSourceWriter = new ReportSourceWriter<>(dbb100035ReportWriter);
            new TokubetsuChoshuKaishiTsuchishoSealerRenchoReport(編集後本算定通知書共通情報, dbb100035NinshoshaSource).
                    writeBy(dbb100035ReportSourceWriter);
            return dbb100035ReportSourceWriter.pageCount().value();
        }
        return print特徴開始通知書(編集後本算定通知書共通情報, result, 本算定通知書情報);
    }

    private int print特徴開始通知書(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            PrtTokuchoKaishiTsuchishoHonsanteiResult result, HonSanteiTsuchiShoKyotsu 本算定通知書情報) {
        if (ReportIdDBB.DBB100036.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100036ReportSourceWriter = new ReportSourceWriter<>(dbb100036ReportWriter);
            new TokubetsuChoshuKaishiTsuchishoB52Report(編集後本算定通知書共通情報, result.get宛名連番(), 地方公共団体, dbb100036NinshoshaSource).
                    writeBy(dbb100036ReportSourceWriter);
            return dbb100036ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100037.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100037ReportSourceWriter = new ReportSourceWriter<>(dbb100037ReportWriter);
            new TokubetsuChoshuKaishiTsuchishoB52RenchoReport(編集後本算定通知書共通情報, result.get宛名連番(), dbb100037NinshoshaSource).
                    writeBy(dbb100037ReportSourceWriter);
            return dbb100037ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100038.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100038ReportSourceWriter = new ReportSourceWriter<>(dbb100038ReportWriter8);
            IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー
                    = KaigoToiawasesakiSourceBuilderCreator.create(SubGyomuCode.DBB介護賦課, 本算定通知書情報.get帳票分類ID());
            CompKaigoToiawasesakiSource toiawasesakiSource = 介護問合せ先ソースビルダー.buildSource();
            new TokubetsuChoshuKaishiTsuchishoOverlayA4TateReport(編集後本算定通知書共通情報, result.get通知書定型文(),
                    toiawasesakiSource, dbb100038NinshoshaSource).writeBy(dbb100038ReportSourceWriter);
            return dbb100038ReportSourceWriter.pageCount().value();
        }
        return 0;
    }

    private enum 特定項目1 implements ISpecificKey {

        key1(TokubetsuChoshuKaishiTsuchishoB5Source.ITEM_NENDO, 定数_賦課年度.toString()),
        key2(TokubetsuChoshuKaishiTsuchishoB5Source.ITEM_TSUCHISHONO2, 定数_通知書番号.toString());

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
        target3("hokenshaName", 定数_被保険者氏名.toString(), CheckShubetsu.文字切れ);

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

    private enum 特定項目2 implements ISpecificKey {

        key1(TokubetsuChoshuKaishiTsuchishoB5RenchoSource.ITEM_NENDO, 定数_賦課年度.toString()),
        key2(TokubetsuChoshuKaishiTsuchishoB5RenchoSource.ITEM_TSUCHISHONO1, 定数_通知書番号.toString());

        private final RString itemName;
        private final RString printName;

        private 特定項目2(String itemName, String printName) {
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

    private enum チェック項目2 implements ICheckTarget {

        target1("hihokenshaName2", "被保険者氏名2", CheckShubetsu.文字切れ),
        target2("hihokenshaName1", "被保険者氏名1", CheckShubetsu.文字切れ);

        private final RString itemName;
        private final RString printName;
        private final CheckShubetsu checkShubetsu;

        private チェック項目2(String itemName, String printName, CheckShubetsu checkShubetsu) {
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

    private enum 特定項目3 implements ISpecificKey {

        key1(TokubetsuChoshuKaishiTsuchishoSealerSource.ITEM_NENDO, 定数_賦課年度.toString()),
        key2(TokubetsuChoshuKaishiTsuchishoSealerSource.ITEM_TSUCHISHONO, 定数_通知書番号.toString());

        private final RString itemName;
        private final RString printName;

        private 特定項目3(String itemName, String printName) {
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

    private enum チェック項目3 implements ICheckTarget {

        target1(定数_被保険者番号.toString(), 定数_被保険者氏名.toString(), CheckShubetsu.文字切れ),
        target2("hihokenshaJusho", "被保険者住所", CheckShubetsu.文字切れ),
        target3("setainushiName", "世帯主名", CheckShubetsu.文字切れ);

        private final RString itemName;
        private final RString printName;
        private final CheckShubetsu checkShubetsu;

        private チェック項目3(String itemName, String printName, CheckShubetsu checkShubetsu) {
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

    private enum 特定項目4 implements ISpecificKey {

        key1(TokubetsuChoshuKaishiTsuchishoSealerRenchoSource.ITEM_NENDO, 定数_賦課年度.toString()),
        key2(TokubetsuChoshuKaishiTsuchishoSealerRenchoSource.ITEM_TSUCHISHONO, 定数_通知書番号.toString());

        private final RString itemName;
        private final RString printName;

        private 特定項目4(String itemName, String printName) {
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

    private enum チェック項目4 implements ICheckTarget {

        target1(定数_被保険者番号.toString(), 定数_被保険者氏名.toString(), CheckShubetsu.文字切れ),
        target2("hihokenshaJusho", "被保険者住所", CheckShubetsu.文字切れ),
        target3("setainushiName", "世帯主名", CheckShubetsu.文字切れ);

        private final RString itemName;
        private final RString printName;
        private final CheckShubetsu checkShubetsu;

        private チェック項目4(String itemName, String printName, CheckShubetsu checkShubetsu) {
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

    private enum 特定項目5 implements ISpecificKey {

        key1(TokubetsuChoshuKaishiTsuchishoB52Source.ITEM_NENDO, 定数_賦課年度.toString()),
        key2(TokubetsuChoshuKaishiTsuchishoB52Source.ITEM_TSUCHISHONO, 定数_通知書番号.toString());

        private final RString itemName;
        private final RString printName;

        private 特定項目5(String itemName, String printName) {
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

    private enum チェック項目5 implements ICheckTarget {

        target1(定数_被保険者番号.toString(), 定数_被保険者氏名.toString(), CheckShubetsu.文字切れ),
        target2("hokenshaName", 定数_被保険者氏名.toString(), CheckShubetsu.文字切れ);

        private final RString itemName;
        private final RString printName;
        private final CheckShubetsu checkShubetsu;

        private チェック項目5(String itemName, String printName, CheckShubetsu checkShubetsu) {
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

    private enum 特定項目6 implements ISpecificKey {

        key1(TokubetsuChoshuKaishiTsuchishoB52RenchoSource.ITEM_NENDO, 定数_賦課年度.toString()),
        key2(TokubetsuChoshuKaishiTsuchishoB52RenchoSource.ITEM_TSUCHISHONO, 定数_通知書番号.toString());

        private final RString itemName;
        private final RString printName;

        private 特定項目6(String itemName, String printName) {
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

    private enum チェック項目6 implements ICheckTarget {

        target1(定数_被保険者番号.toString(), 定数_被保険者氏名.toString(), CheckShubetsu.文字切れ);

        private final RString itemName;
        private final RString printName;
        private final CheckShubetsu checkShubetsu;

        private チェック項目6(String itemName, String printName, CheckShubetsu checkShubetsu) {
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

    private enum 特定項目7 implements ISpecificKey {

        key1(TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource.ITEM_TITLENENDO, 定数_賦課年度.toString()),
        key2(TokubetsuChoshuKaishiTsuchishoB52RenchoSource.ITEM_TSUCHISHONO, 定数_通知書番号.toString());

        private final RString itemName;
        private final RString printName;

        private 特定項目7(String itemName, String printName) {
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

    private enum チェック項目7 implements ICheckTarget {

        target1(定数_被保険者番号.toString(), 定数_被保険者氏名.toString(), CheckShubetsu.文字切れ),
        target2("setainushiName", "世帯主名", CheckShubetsu.文字切れ),
        target3("hihokenshaJusho", "被保険者住所", CheckShubetsu.文字切れ);

        private final RString itemName;
        private final RString printName;
        private final CheckShubetsu checkShubetsu;

        private チェック項目7(String itemName, String printName, CheckShubetsu checkShubetsu) {
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
