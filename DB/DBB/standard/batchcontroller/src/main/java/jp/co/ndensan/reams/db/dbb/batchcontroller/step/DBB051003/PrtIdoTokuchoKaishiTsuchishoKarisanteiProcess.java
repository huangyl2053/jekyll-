/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB051003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.fukaatena.FukaAtena;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteiidogennendotsuchisyoikatsuhako.HonsanteiIdoGennendoTsuchisyoIkatsuHakoResult;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5RenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5Report;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariTokuchoKaishiTsuchisyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsuInfo;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiTsuchiShoKyotsuKomokuHenshu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB051001.ChohyoResult;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt44002.HonsanteiIdoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidogennendotsuchisyoikatsuhako.TmpIdoGennendoKarisanteiEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5Source;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerSource;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteiidogennendotsuchisyoikatsuhako.HonsanteiIdoGennendoTsuchisyoIkatsuHako;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.report.parts.kaigotoiawasesaki.KaigoToiawasesakiSourceBuilderCreator;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ue.uex.business.core.NenkinTokuchoKaifuJoho;
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
 * 特徴開始通知書(仮算定）の発行クラスです。
 *
 * @reamsid_L DBB-0880-030 xicongwang
 */
public class PrtIdoTokuchoKaishiTsuchishoKarisanteiProcess extends SimpleBatchProcessBase {

    private static final ReportId 特別徴収開始通知書仮算定帳票分類ID = new ReportId("DBB100003_TokubetsuChoshuKaishiTsuchishoKariDaihyo");
    private static final RString 定数_調定年度 = new RString("調定年度");
    private static final RString 定数_通知書番号 = new RString("通知書番号");
    private static final RString RSTRING_1 = new RString("1");
    private ChohyoResult 出力帳票一覧;
    private Association 地方公共団体;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private HonsanteiIdoProcessParameter processParameter;
    private HonsanteiIdoGennendoTsuchisyoIkatsuHako manager;
    private CompKaigoToiawasesakiSource toiawasesakiSource;
    private NinshoshaSource dbb100003NinshoshaSource;
    private NinshoshaSource dbb100004NinshoshaSource;
    private NinshoshaSource dbb100005NinshoshaSource;
    private NinshoshaSource dbb100006NinshoshaSource;
    private NinshoshaSource dbb100008NinshoshaSource;
    private NinshoshaSource dbb100009NinshoshaSource;

    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoKariB5Source> dbb100003ReportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariB5Source> dbb100003ReportSourceWriter;
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource> dbb100004ReportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource> dbb100004ReportSourceWriter;
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoKariSealerSource> dbb100005ReportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariSealerSource> dbb100005ReportSourceWriter;
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource> dbb100006ReportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource> dbb100006ReportSourceWriter;
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource> dbb100008ReportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource> dbb100008ReportSourceWriter;
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource> dbb100009ReportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource> dbb100009ReportSourceWriter;

    @Override
    protected void beforeExecute() {
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        manager = HonsanteiIdoGennendoTsuchisyoIkatsuHako.createInstance();
        出力帳票一覧 = processParameter.get出力帳票一覧();
        帳票制御共通 = manager.load帳票制御共通(特別徴収開始通知書仮算定帳票分類ID);

        initialize特徴開始通知書();
    }

    @Override
    protected void process() {
        HonsanteiIdoGennendoTsuchisyoIkatsuHakoResult result
                = manager.prtTokuchoKaishiTsuchishoKarisantei(processParameter.get調定年度(),
                        new RDate(processParameter.get特徴_発行日().toString()),
                        processParameter.get帳票作成日時(), 出力帳票一覧.get出力順ID(),
                        new ReportId(出力帳票一覧.get帳票ID()), processParameter.get特徴_出力対象());
        if (result == null) {
            return;
        }
        KariSanteiTsuchiShoKyotsuKomokuHenshu 仮算定共通情報作成 = InstanceProvider.create(KariSanteiTsuchiShoKyotsuKomokuHenshu.class);
        List<EditedKariSanteiTsuchiShoKyotsuInfo> 編集後仮算定通知書共通情報List = new ArrayList<>();
        int 総ページ数 = 0;
        for (TmpIdoGennendoKarisanteiEntity tmpResult : result.get特徴開始通知書ResultList()) {
            EditedKariSanteiTsuchiShoKyotsuInfo info = new EditedKariSanteiTsuchiShoKyotsuInfo();
            KariSanteiTsuchiShoKyotsu 仮算定通知書情報 = new KariSanteiTsuchiShoKyotsu();
            仮算定通知書情報.set発行日(processParameter.get特徴_発行日());
            仮算定通知書情報.set帳票分類ID(特別徴収開始通知書仮算定帳票分類ID);
            仮算定通知書情報.set帳票ID(new ReportId(出力帳票一覧.get帳票ID()));
            仮算定通知書情報.set処理区分(ShoriKubun.バッチ);
            仮算定通知書情報.set地方公共団体(地方公共団体);
            FukaAtena fukaAtena = new FukaAtena();
            fukaAtena.set賦課情報(new FukaJoho(tmpResult.get賦課の情報_更正後()));
            IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(tmpResult.get宛名());
            fukaAtena.set宛名(宛名);
            仮算定通知書情報.set賦課の情報_更正後(fukaAtena);
            仮算定通知書情報.set納組情報(tmpResult.get納組());
            IAtesaki 宛先 = AtesakiFactory.createInstance(tmpResult.get宛先());
            仮算定通知書情報.set宛先情報(宛先);
            if (tmpResult.get今年度賦課情報() != null) {
                仮算定通知書情報.set前年度賦課情報(new FukaJoho(tmpResult.get今年度賦課情報()));
            }
            仮算定通知書情報.set徴収方法情報_更正後(new ChoshuHoho(tmpResult.get徴収方法()));
            NenkinTokuchoKaifuJoho 対象者_追加含む_情報 = null;
            if (tmpResult.get対象者_追加含む_情報() != null) {
                対象者_追加含む_情報 = new NenkinTokuchoKaifuJoho(tmpResult.get対象者_追加含む_情報());
            }
            仮算定通知書情報.set対象者_追加含む_情報_更正後(対象者_追加含む_情報);
            仮算定通知書情報.set帳票制御共通(result.get帳票制御共通());
            EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報 = 仮算定共通情報作成.create仮算定通知書共通情報(仮算定通知書情報);

            KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報 = new KariTokuchoKaishiTsuchisyoJoho();
            仮算定特徴開始通知書情報.set発行日(processParameter.get特徴_発行日());
            仮算定特徴開始通知書情報.set帳票分類ID(特別徴収開始通知書仮算定帳票分類ID);
            仮算定特徴開始通知書情報.set帳票ID(new ReportId(出力帳票一覧.get帳票ID()));
            仮算定特徴開始通知書情報.set編集後仮算定通知書共通情報(編集後仮算定通知書共通情報);
            仮算定特徴開始通知書情報.set宛先情報(仮算定通知書情報.get宛先情報());
            仮算定特徴開始通知書情報.set処理区分(ShoriKubun.バッチ);
            仮算定特徴開始通知書情報.set地方公共団体(地方公共団体);
            if (対象者_追加含む_情報 != null) {
                仮算定特徴開始通知書情報.set特徴捕捉月(対象者_追加含む_情報.get捕捉月());
            }
            総ページ数 = publish特徴開始通知書(仮算定特徴開始通知書情報, result, 仮算定通知書情報);
            info.set仮算定通知書情報(仮算定通知書情報);
            info.set編集後仮算定通知書情報(編集後仮算定通知書共通情報);
            編集後仮算定通知書共通情報List.add(info);
        }
        manager.publish特徴開始通知仮算定(result, 編集後仮算定通知書共通情報List, 総ページ数);
    }

    @Override
    protected void afterExecute() {
        close特徴開始通知書();
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
        if (ReportIdDBB.DBB100003.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目1.class, チェック項目1.class);
            dbb100003ReportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariB5Source.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧().get帳票ID())
                    .build();
            dbb100003ReportSourceWriter = new ReportSourceWriter<>(dbb100003ReportWriter);
            dbb100003NinshoshaSource = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100003ReportSourceWriter.getImageFolderPath(),
                    new RDate(processParameter.get特徴_発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        } else if (ReportIdDBB.DBB100004.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目2.class, チェック項目2.class);
            dbb100004ReportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧().get帳票ID())
                    .build();
            dbb100004ReportSourceWriter = new ReportSourceWriter<>(dbb100004ReportWriter);
            dbb100004NinshoshaSource = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100004ReportSourceWriter.getImageFolderPath(),
                    new RDate(processParameter.get特徴_発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        } else if (ReportIdDBB.DBB100005.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目3.class, チェック項目3.class);
            dbb100005ReportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariSealerSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧().get帳票ID())
                    .build();
            dbb100005ReportSourceWriter = new ReportSourceWriter<>(dbb100005ReportWriter);
            dbb100005NinshoshaSource = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100005ReportSourceWriter.getImageFolderPath(),
                    new RDate(processParameter.get特徴_発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        } else if (ReportIdDBB.DBB100006.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目4.class, チェック項目4.class);
            dbb100006ReportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧().get帳票ID())
                    .build();
            dbb100006ReportSourceWriter = new ReportSourceWriter<>(dbb100006ReportWriter);
            dbb100006NinshoshaSource = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100006ReportSourceWriter.getImageFolderPath(),
                    new RDate(processParameter.get特徴_発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        } else if (ReportIdDBB.DBB100008.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー = KaigoToiawasesakiSourceBuilderCreator.create(
                    SubGyomuCode.DBB介護賦課, 特別徴収開始通知書仮算定帳票分類ID);
            toiawasesakiSource = 介護問合せ先ソースビルダー.buildSource();
            CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目5.class, チェック項目5.class);
            dbb100008ReportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧().get帳票ID())
                    .build();
            dbb100008ReportSourceWriter = new ReportSourceWriter<>(dbb100008ReportWriter);
            dbb100008NinshoshaSource = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100008ReportSourceWriter.getImageFolderPath(),
                    new RDate(processParameter.get特徴_発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        } else if (ReportIdDBB.DBB100009.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー = KaigoToiawasesakiSourceBuilderCreator.create(
                    SubGyomuCode.DBB介護賦課, 特別徴収開始通知書仮算定帳票分類ID);
            toiawasesakiSource = 介護問合せ先ソースビルダー.buildSource();
            CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目6.class, チェック項目6.class);
            dbb100009ReportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧().get帳票ID())
                    .build();
            dbb100009ReportSourceWriter = new ReportSourceWriter<>(dbb100009ReportWriter);
            dbb100009NinshoshaSource = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100009ReportSourceWriter.getImageFolderPath(),
                    new RDate(processParameter.get特徴_発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        }
    }

    private int publish特徴開始通知書(KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            HonsanteiIdoGennendoTsuchisyoIkatsuHakoResult result, KariSanteiTsuchiShoKyotsu 仮算定通知書情報) {
        EditedAtesaki 編集後宛先 = JushoHenshu.create編集後宛先(仮算定通知書情報.get宛先情報(),
                仮算定通知書情報.get地方公共団体(), 仮算定通知書情報.get帳票制御共通());
        if (ReportIdDBB.DBB100003.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100003ReportSourceWriter = new ReportSourceWriter<>(dbb100003ReportWriter);
            new TokubetsuChoshuKaishiTsuchishoKariB5Report(編集後宛先, dbb100003NinshoshaSource, 仮算定特徴開始通知書情報, result.get宛名連番())
                    .writeBy(dbb100003ReportSourceWriter);
            return dbb100003ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100004.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100004ReportSourceWriter = new ReportSourceWriter<>(dbb100004ReportWriter);
            new TokubetsuChoshuKaishiTsuchishoKariB5RenchoReport(編集後宛先, dbb100004NinshoshaSource, 仮算定特徴開始通知書情報, result.get宛名連番())
                    .writeBy(dbb100004ReportSourceWriter);
            return dbb100004ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100005.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100005ReportSourceWriter = new ReportSourceWriter<>(dbb100005ReportWriter);
            new TokubetsuChoshuKaishiTsuchishoKariSealerReport(編集後宛先, dbb100005NinshoshaSource, 仮算定特徴開始通知書情報)
                    .writeBy(dbb100005ReportSourceWriter);
            return dbb100005ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100006.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100006ReportSourceWriter = new ReportSourceWriter<>(dbb100006ReportWriter);
            new TokubetsuChoshuKaishiTsuchishoKariSealerRenchoReport(編集後宛先, dbb100006NinshoshaSource, 仮算定特徴開始通知書情報)
                    .writeBy(dbb100006ReportSourceWriter);
            return dbb100006ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100008.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100008ReportSourceWriter = new ReportSourceWriter<>(dbb100008ReportWriter);
            new TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateReport(編集後宛先, dbb100008NinshoshaSource,
                    toiawasesakiSource, 仮算定特徴開始通知書情報, result.get通知文1()).writeBy(dbb100008ReportSourceWriter);
            return dbb100008ReportSourceWriter.pageCount().value();
        }
        return publish特徴開始通知書_B5横オーバレイタイプ(仮算定特徴開始通知書情報, result, 編集後宛先);
    }

    private int publish特徴開始通知書_B5横オーバレイタイプ(KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            HonsanteiIdoGennendoTsuchisyoIkatsuHakoResult result, EditedAtesaki 編集後宛先) {
        if (ReportIdDBB.DBB100009.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100009ReportSourceWriter = new ReportSourceWriter<>(dbb100009ReportWriter);
            new TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoReport(編集後宛先, dbb100009NinshoshaSource,
                    toiawasesakiSource, 仮算定特徴開始通知書情報, result.get通知文1(), result.get通知文2()).writeBy(dbb100009ReportSourceWriter);
            return dbb100009ReportSourceWriter.pageCount().value();
        }
        return 0;
    }

    private void close特徴開始通知書() {
        if (ReportIdDBB.DBB100003.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100003ReportWriter.close();
        } else if (ReportIdDBB.DBB100004.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100004ReportWriter.close();
        } else if (ReportIdDBB.DBB100005.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100005ReportWriter.close();
        } else if (ReportIdDBB.DBB100006.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100006ReportWriter.close();
        } else if (ReportIdDBB.DBB100008.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100008ReportWriter.close();
        } else if (ReportIdDBB.DBB100009.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            dbb100009ReportWriter.close();
        }
    }

    private enum 特定項目1 implements ISpecificKey {

        key1(TokubetsuChoshuKaishiTsuchishoKariB5Source.ITEM_NENDO, 定数_調定年度.toString()),
        key2(TokubetsuChoshuKaishiTsuchishoKariB5Source.ITEM_TSUCHISHONO2, 定数_通知書番号.toString());

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

        target1("hihokenshaName2", "被保険者氏名２", CheckShubetsu.文字切れ),
        target2("setainushiName1", "世帯主名１", CheckShubetsu.文字切れ);

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

        key1(TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource.ITEM_NENDO, 定数_調定年度.toString()),
        key2(TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource.ITEM_TSUCHISHONO2, 定数_通知書番号.toString());

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

        target1("hihokenshaName2", "被保険者氏名２", CheckShubetsu.文字切れ),
        target2("setainushiName1", "世帯主名１", CheckShubetsu.文字切れ);

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

        key1(TokubetsuChoshuKaishiTsuchishoKariSealerSource.ITEM_NENDO, 定数_調定年度.toString()),
        key2(TokubetsuChoshuKaishiTsuchishoKariSealerSource.ITEM_TSUCHISHONO, 定数_通知書番号.toString());

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

        target1("hihokenshaJusho1", "被保険者住所１", CheckShubetsu.文字切れ),
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

        key1(TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource.ITEM_NENDO2, 定数_調定年度.toString()),
        key2(TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource.ITEM_TSUCHISHONO, 定数_通知書番号.toString());

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
        target2("hihokenshaJusho1", "被保険者住所１", CheckShubetsu.文字切れ),
        target3("hihokenshaKatagaki1", "被保険者方書１", CheckShubetsu.文字切れ);

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

        key1(TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource.ITEM_TITLENENDO, 定数_調定年度.toString()),
        key2(TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource.ITEM_TSUCHISHONO, 定数_通知書番号.toString());

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

        key1(TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource.ITEM_NENDO1, 定数_調定年度.toString()),
        key2(TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource.ITEM_TSUCHISHONO2, 定数_通知書番号.toString());

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

        target1("hihokenshaName1", "被保険者名称１", CheckShubetsu.文字切れ);

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
