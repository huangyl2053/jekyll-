/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb011003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchokarisanteitsuchishohakko.PrtTokuchoKaishiTsuchishoKarisanteiResult;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchokarisanteitsuchishohakko.TsuchishoDataTempResult;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5RenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5Report;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariTokuchoKaishiTsuchisyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiTsuchiShoKyotsuKomokuHenshu;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchokarisanteitsuchishohakko.KarisanteiBatchEntity;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteitsuchishohakko.TokuchoKaishiTsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5Source;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerSource;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteitsuchishohakko.TokuchoKaishiTsuchishoDataHenshu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
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
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
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
 * 特徴開始通知書(仮算定）の発行クラスです。
 *
 * @reamsid_L DBB-0790-030 chenaoqi
 */
public class PrtTokuchoKaishiTsuchishoKarisanteiProcess extends SimpleBatchProcessBase {

    private static final ReportId 特別徴収開始通知書仮算定_帳票分類ID = new ReportId("DBB100003_TokubetsuChoshuKaishiTsuchishoKariDaihyo");
    private static final RString RSTRING_1 = new RString("1");
    private Association 地方公共団体;
    private TokuchoKaishiTsuchishoDataHenshu manager;
    private TokuchoKaishiTsuchishoProcessParameter processParameter;
    @BatchWriter
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoKariB5Source> dbb100003reportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariB5Source> dbb100003ReportSourceWriter;
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource> dbb100004reportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource> dbb100004ReportSourceWriter;
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoKariSealerSource> dbb100005reportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariSealerSource> dbb100005ReportSourceWriter;
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource> dbb100006reportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource> dbb100006ReportSourceWriter;
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource> dbb100008reportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource> dbb100008ReportSourceWriter;
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource> dbb100009reportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource> dbb100009ReportSourceWriter;

    @Override
    protected void beforeExecute() {
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        manager = TokuchoKaishiTsuchishoDataHenshu.createInstance();
    }

    @Override
    protected void process() {
        KarisanteiBatchEntity 出力帳票一覧Entity = processParameter.get出力帳票一覧Entity();
        PrtTokuchoKaishiTsuchishoKarisanteiResult result = manager.prtTokuchoKaishiTsuchishoKarisantei(
                processParameter.get調定年度(), processParameter.get発行日(),
                processParameter.get帳票作成日時(), 出力帳票一覧Entity.get出力順ID(), 出力帳票一覧Entity.get帳票ID(),
                processParameter.get出力対象());
        if (result == null) {
            return;
        }
        KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報 = new KariTokuchoKaishiTsuchisyoJoho();
        KariSanteiTsuchiShoKyotsuKomokuHenshu 仮算定通知書共通情報作成 = InstanceProvider.create(KariSanteiTsuchiShoKyotsuKomokuHenshu.class);
        List<EditedKariSanteiTsuchiShoKyotsu> 編集後仮算定通知書共通情報List = new ArrayList<>();
        int 総ページ数 = 0;
        for (TsuchishoDataTempResult tempResult : result.get特徴開始通知書ResultList()) {
            KariSanteiTsuchiShoKyotsu 仮算定通知書情報 = new KariSanteiTsuchiShoKyotsu();
            仮算定通知書情報.set発行日(processParameter.get発行日());
            仮算定通知書情報.set帳票分類ID(特別徴収開始通知書仮算定_帳票分類ID);
            仮算定通知書情報.set帳票ID(result.get帳票ID());
            仮算定通知書情報.set処理区分(ShoriKubun.バッチ);
            仮算定通知書情報.set地方公共団体(地方公共団体);
            仮算定通知書情報.set賦課の情報_更正後(tempResult.get賦課の情報());
            仮算定通知書情報.set納組情報(tempResult.get納組情報());
            仮算定通知書情報.set宛先情報(tempResult.get宛先情報());
            仮算定通知書情報.set前年度賦課情報(tempResult.get前年度賦課情報());
            仮算定通知書情報.set徴収方法情報_更正後(tempResult.get徴収方法情報());
            仮算定通知書情報.set対象者_追加含む_情報_更正後(tempResult.get対象者_追加含む_情報());
            仮算定通知書情報.set帳票制御共通(result.get帳票制御共通());
            EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報 = 仮算定通知書共通情報作成.create仮算定通知書共通情報(仮算定通知書情報);
            編集後仮算定通知書共通情報List.add(編集後仮算定通知書共通情報);
            仮算定特徴開始通知書情報.set発行日(processParameter.get発行日());
            仮算定特徴開始通知書情報.set編集後仮算定通知書共通情報(編集後仮算定通知書共通情報);
            仮算定特徴開始通知書情報.set帳票分類ID(特別徴収開始通知書仮算定_帳票分類ID);
            仮算定特徴開始通知書情報.set帳票ID(result.get帳票ID());
            仮算定特徴開始通知書情報.set宛先情報(tempResult.get宛先情報());
            総ページ数 = 総ページ数 + publish特徴開始通知書(出力帳票一覧Entity, 仮算定特徴開始通知書情報, result, 仮算定通知書情報);
        }
        manager.printTsuchisho(result, 総ページ数, 編集後仮算定通知書共通情報List);
    }

    private int publish特徴開始通知書(KarisanteiBatchEntity 出力帳票一覧Entity,
            KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            PrtTokuchoKaishiTsuchishoKarisanteiResult result, KariSanteiTsuchiShoKyotsu 仮算定通知書情報) {

        FlexibleDate 開始年月日 = FlexibleDate.getNowDate();
        if (仮算定通知書情報.get発行日() != null) {
            開始年月日 = 仮算定通知書情報.get発行日();
        }
        Ninshosha 認証者 = NinshoshaFinderFactory.createInstance()
                .get帳票認証者(GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), 開始年月日);
        boolean is公印に掛ける = false;
        boolean is公印を省略 = false;
        ChohyoSeigyoKyotsu 帳票制御共通 = 仮算定通知書情報.get帳票制御共通();
        if (帳票制御共通 != null && RSTRING_1.equals(帳票制御共通.get首長名印字位置())) {
            is公印に掛ける = true;
        }
        if (帳票制御共通 != null && !帳票制御共通.is電子公印印字有無()) {
            is公印を省略 = true;
        }
        EditedAtesaki 編集後宛先 = JushoHenshu.create編集後宛先(仮算定通知書情報.get宛先情報(),
                仮算定通知書情報.get地方公共団体(), 仮算定通知書情報.get帳票制御共通());
        ICheckListInfo info = CheckListInfoFactory.createInstance(SubGyomuCode.DBB介護賦課,
                地方公共団体.getLasdecCode_(), 地方公共団体.get市町村名());
        if (ReportIdDBB.DBB100003.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {

            CheckListLineItemSet pairs = CheckListLineItemSet.of(PrtTokuchoKaishiTsuchishoKarisanteiProcess.特定項目1.class,
                    PrtTokuchoKaishiTsuchishoKarisanteiProcess.チェック項目1.class);
            dbb100003reportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariB5Source.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧Entity().get帳票ID())
                    .build();
            dbb100003ReportSourceWriter = new ReportSourceWriter<>(dbb100003reportWriter);
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100003ReportSourceWriter.getImageFolderPath(),
                    new RDate(仮算定通知書情報.get発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
            new TokubetsuChoshuKaishiTsuchishoKariB5Report(編集後宛先, sourceBuilder,
                    仮算定特徴開始通知書情報, result.get宛名連番()).writeBy(dbb100003ReportSourceWriter);
            dbb100003reportWriter.close();
            return dbb100003ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100004.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {

            CheckListLineItemSet pairs = CheckListLineItemSet.of(PrtTokuchoKaishiTsuchishoKarisanteiProcess.特定項目2.class,
                    PrtTokuchoKaishiTsuchishoKarisanteiProcess.チェック項目2.class);
            dbb100004reportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧Entity().get帳票ID())
                    .build();
            dbb100004ReportSourceWriter = new ReportSourceWriter<>(dbb100004reportWriter);
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100004ReportSourceWriter.getImageFolderPath(),
                    new RDate(仮算定通知書情報.get発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
            new TokubetsuChoshuKaishiTsuchishoKariB5RenchoReport(編集後宛先, sourceBuilder,
                    仮算定特徴開始通知書情報, result.get宛名連番()).writeBy(dbb100004ReportSourceWriter);
            dbb100004reportWriter.close();
            return dbb100004ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100005.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {

            CheckListLineItemSet pairs = CheckListLineItemSet.of(PrtTokuchoKaishiTsuchishoKarisanteiProcess.特定項目3.class,
                    PrtTokuchoKaishiTsuchishoKarisanteiProcess.チェック項目3.class);
            dbb100005reportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariSealerSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧Entity().get帳票ID())
                    .build();
            dbb100005ReportSourceWriter = new ReportSourceWriter<>(dbb100005reportWriter);
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100005ReportSourceWriter.getImageFolderPath(),
                    new RDate(仮算定通知書情報.get発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
            new TokubetsuChoshuKaishiTsuchishoKariSealerReport(編集後宛先, sourceBuilder,
                    仮算定特徴開始通知書情報).writeBy(dbb100005ReportSourceWriter);
            dbb100005reportWriter.close();
            return dbb100005ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100006.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {

            CheckListLineItemSet pairs = CheckListLineItemSet.of(PrtTokuchoKaishiTsuchishoKarisanteiProcess.特定項目4.class,
                    PrtTokuchoKaishiTsuchishoKarisanteiProcess.チェック項目4.class);
            dbb100006reportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧Entity().get帳票ID())
                    .build();
            dbb100006ReportSourceWriter = new ReportSourceWriter<>(dbb100006reportWriter);
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100006ReportSourceWriter.getImageFolderPath(),
                    new RDate(仮算定通知書情報.get発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
            new TokubetsuChoshuKaishiTsuchishoKariSealerRenchoReport(編集後宛先, sourceBuilder,
                    仮算定特徴開始通知書情報).writeBy(dbb100006ReportSourceWriter);
            dbb100006reportWriter.close();
            return dbb100006ReportSourceWriter.pageCount().value();
        }
        return publish特徴開始通知書_その他(出力帳票一覧Entity, 仮算定特徴開始通知書情報, result, 仮算定通知書情報, 編集後宛先,
                認証者, is公印に掛ける, is公印を省略, info);
    }

    private int publish特徴開始通知書_その他(KarisanteiBatchEntity 出力帳票一覧Entity, KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            PrtTokuchoKaishiTsuchishoKarisanteiResult result, KariSanteiTsuchiShoKyotsu 仮算定通知書情報, EditedAtesaki 編集後宛先,
            Ninshosha 認証者, boolean is公印に掛ける, boolean is公印を省略, ICheckListInfo info) {
        if (ReportIdDBB.DBB100008.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {

            CheckListLineItemSet pairs = CheckListLineItemSet.of(PrtTokuchoKaishiTsuchishoKarisanteiProcess.特定項目5.class,
                    PrtTokuchoKaishiTsuchishoKarisanteiProcess.チェック項目5.class);
            dbb100008reportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧Entity().get帳票ID())
                    .build();
            dbb100008ReportSourceWriter = new ReportSourceWriter<>(dbb100008reportWriter);
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100008ReportSourceWriter.getImageFolderPath(),
                    new RDate(仮算定通知書情報.get発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
            IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー = KaigoToiawasesakiSourceBuilderCreator.create(
                    SubGyomuCode.DBB介護賦課, 仮算定通知書情報.get帳票分類ID());
            CompKaigoToiawasesakiSource toiawasesakiSource = 介護問合せ先ソースビルダー.buildSource();
            new TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateReport(編集後宛先, sourceBuilder, toiawasesakiSource,
                    仮算定特徴開始通知書情報, result.get通知書定型文1()).writeBy(dbb100008ReportSourceWriter);
            dbb100008reportWriter.close();
            return dbb100008ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100009.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {

            CheckListLineItemSet pairs = CheckListLineItemSet.of(PrtTokuchoKaishiTsuchishoKarisanteiProcess.特定項目6.class,
                    PrtTokuchoKaishiTsuchishoKarisanteiProcess.チェック項目6.class);
            dbb100009reportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧Entity().get帳票ID())
                    .build();
            dbb100009ReportSourceWriter = new ReportSourceWriter<>(dbb100009reportWriter);
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100009ReportSourceWriter.getImageFolderPath(),
                    new RDate(仮算定通知書情報.get発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
            IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー = KaigoToiawasesakiSourceBuilderCreator.create(
                    SubGyomuCode.DBB介護賦課, 仮算定通知書情報.get帳票分類ID());
            CompKaigoToiawasesakiSource toiawasesakiSource = 介護問合せ先ソースビルダー.buildSource();
            new TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoReport(編集後宛先, sourceBuilder, toiawasesakiSource,
                    仮算定特徴開始通知書情報, result.get通知書定型文1(), result.get通知書定型文2()).writeBy(dbb100009ReportSourceWriter);
            dbb100009reportWriter.close();
            return dbb100009ReportSourceWriter.pageCount().value();
        }
        return 0;

    }

    @Override
    protected void afterExecute() {

    }

    private enum 特定項目1 implements ISpecificKey {

        key1(TokubetsuChoshuKaishiTsuchishoKariB5Source.ITEM_NENDO, "調定年度"),
        key2(TokubetsuChoshuKaishiTsuchishoKariB5Source.ITEM_TSUCHISHONO2, "通知書番号");

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

        target1("hihokenshaName2", "被保険者氏名2", CheckShubetsu.文字切れ);

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

        key1(TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource.ITEM_NENDO, "調定年度"),
        key2(TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource.ITEM_TSUCHISHONO2, "通知書番号");

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

        target1("hihokenshaName2", "被保険者氏名2", CheckShubetsu.文字切れ);

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

        key1(TokubetsuChoshuKaishiTsuchishoKariSealerSource.ITEM_NENDO, "調定年度"),
        key2(TokubetsuChoshuKaishiTsuchishoKariSealerSource.ITEM_TSUCHISHONO, "通知書番号");

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

        target1("hihokenshaJusho1", "被保険者住所1", CheckShubetsu.文字切れ),
        target2("hihokenshaName", "被保険者氏名", CheckShubetsu.文字切れ),
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

        key1(TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource.ITEM_NENDO2, "調定年度"),
        key2(TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource.ITEM_TSUCHISHONO, "通知書番号");

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

        target1("hihokenshaName", "被保険者氏名", CheckShubetsu.文字切れ),
        target2("hihokenshaJusho1", "被保険者住所1", CheckShubetsu.文字切れ),
        target3("hihokenshaKatagaki1", "被保険者方書1", CheckShubetsu.文字切れ);

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

        key1(TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource.ITEM_TITLENENDO, "調定年度"),
        key2(TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource.ITEM_TSUCHISHONO, "通知書番号");

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

        target1("hihokenshaName", "被保険者氏名", CheckShubetsu.文字切れ),
        target2("hihokenshaJusho", "被保険者住所", CheckShubetsu.文字切れ);

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

        key1(TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource.ITEM_NENDO1, "調定年度"),
        key2(TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource.ITEM_TSUCHISHONO2, "通知書番号");

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

        target1("hihokenshaName1", "被保険者名称1", CheckShubetsu.文字切れ);

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

}
