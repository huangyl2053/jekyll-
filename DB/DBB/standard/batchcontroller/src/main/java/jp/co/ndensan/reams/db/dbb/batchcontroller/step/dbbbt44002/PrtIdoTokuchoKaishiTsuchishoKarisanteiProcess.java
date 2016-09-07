/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt44002;

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
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiTsuchiShoKyotsuKomokuHenshu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogennen.ChohyoResult;
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
 * @reamsid_L DBB-0880-030 xicongwang
 */
public class PrtIdoTokuchoKaishiTsuchishoKarisanteiProcess extends SimpleBatchProcessBase {

    private static final ReportId 特別徴収開始通知書仮算定帳票分類ID = new ReportId("DBB100003_TokubetsuChoshuKaishiTsuchishoKariDaihyo");
    private static final RString 定数_調定年度 = new RString("調定年度");
    private static final RString 定数_通知書番号 = new RString("通知書番号");
    private static final RString RSTRING_1 = new RString("1");
    private Association 地方公共団体;
    private HonsanteiIdoProcessParameter processParameter;

    @BatchWriter
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoKariB5Source> reportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariB5Source> dbb100003ReportSourceWriter;
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource> reportWriter2;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource> dbb100003ReportSourceWriter2;
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoKariSealerSource> reportWriter3;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariSealerSource> dbb100003ReportSourceWriter3;
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource> reportWriter4;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource> dbb100003ReportSourceWriter4;
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource> reportWriter5;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource> dbb100003ReportSourceWriter5;
    private IBatchReportWriterWithCheckList<TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource> reportWriter6;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource> dbb100003ReportSourceWriter6;

    @Override
    protected void beforeExecute() {
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
    }

    @Override
    protected void process() {
        HonsanteiIdoGennendoTsuchisyoIkatsuHako manager = HonsanteiIdoGennendoTsuchisyoIkatsuHako.createInstance();
        ChohyoResult 出力帳票一覧 = processParameter.get出力帳票一覧();
        HonsanteiIdoGennendoTsuchisyoIkatsuHakoResult result
                = manager.prtTokuchoKaishiTsuchishoKarisantei(processParameter.get調定年度(),
                        new RDate(processParameter.get特徴_発行日().toString()),
                        processParameter.get帳票作成日時(), 出力帳票一覧.get出力順ID(),
                        new ReportId(出力帳票一覧.get帳票ID()), processParameter.get特徴_出力対象());
        if (result == null) {
            return;
        }
        KariSanteiTsuchiShoKyotsuKomokuHenshu 仮算定共通情報作成 = InstanceProvider.create(KariSanteiTsuchiShoKyotsuKomokuHenshu.class);
        List<EditedKariSanteiTsuchiShoKyotsu> 編集後仮算定通知書共通情報List = new ArrayList<>();
        List<KariTokuchoKaishiTsuchisyoJoho> 仮算定特徴開始通知書情報List = new ArrayList<>();
        int 総ページ数 = 0;
        for (TmpIdoGennendoKarisanteiEntity tmpResult : result.get特徴開始通知書ResultList()) {
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
            総ページ数 = 総ページ数 + publish特徴開始通知書(出力帳票一覧, 仮算定特徴開始通知書情報, result, 仮算定通知書情報);
            編集後仮算定通知書共通情報List.add(編集後仮算定通知書共通情報);
            仮算定特徴開始通知書情報List.add(仮算定特徴開始通知書情報);
        }
        manager.publish特徴開始通知仮算定(result, 編集後仮算定通知書共通情報List, 地方公共団体, 仮算定特徴開始通知書情報List, 総ページ数);
    }

    private int publish特徴開始通知書(ChohyoResult 出力帳票一覧, KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            HonsanteiIdoGennendoTsuchisyoIkatsuHakoResult result, KariSanteiTsuchiShoKyotsu 仮算定通知書情報) {
        Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().
                get帳票認証者(GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード());
        ChohyoSeigyoKyotsu 帳票制御共通 = 仮算定通知書情報.get帳票制御共通();
        boolean is公印に掛ける = false;
        if (帳票制御共通.get首長名印字位置() != null && RSTRING_1.equals(帳票制御共通.get首長名印字位置())) {
            is公印に掛ける = true;
        }
        boolean is公印を省略 = false;
        if (!帳票制御共通.is電子公印印字有無()) {
            is公印を省略 = true;
        }
        FlexibleDate 発行日 = (仮算定通知書情報.get発行日() == null || 仮算定通知書情報.get発行日().isEmpty())
                ? FlexibleDate.getNowDate() : 仮算定通知書情報.get発行日();
        ICheckListInfo info = CheckListInfoFactory.createInstance(SubGyomuCode.DBB介護賦課,
                地方公共団体.getLasdecCode_(), 地方公共団体.get市町村名());
        EditedAtesaki 編集後宛先 = JushoHenshu.create編集後宛先(仮算定通知書情報.get宛先情報(),
                仮算定通知書情報.get地方公共団体(), 仮算定通知書情報.get帳票制御共通());
        if (ReportIdDBB.DBB100003.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目1.class, チェック項目1.class);
            reportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariB5Source.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧().get帳票ID())
                    .build();
            dbb100003ReportSourceWriter = new ReportSourceWriter<>(reportWriter);
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100003ReportSourceWriter.getImageFolderPath(),
                    new RDate(発行日.toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
            new TokubetsuChoshuKaishiTsuchishoKariB5Report(編集後宛先, sourceBuilder, 仮算定特徴開始通知書情報, result.get宛名連番())
                    .writeBy(dbb100003ReportSourceWriter);
            reportWriter.close();
            return dbb100003ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100004.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目2.class, チェック項目2.class);
            reportWriter2 = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧().get帳票ID())
                    .build();
            dbb100003ReportSourceWriter2 = new ReportSourceWriter<>(reportWriter2);
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100003ReportSourceWriter2.getImageFolderPath(),
                    new RDate(発行日.toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
            new TokubetsuChoshuKaishiTsuchishoKariB5RenchoReport(編集後宛先, sourceBuilder, 仮算定特徴開始通知書情報, result.get宛名連番())
                    .writeBy(dbb100003ReportSourceWriter2);
            reportWriter2.close();
            return dbb100003ReportSourceWriter2.pageCount().value();
        } else if (ReportIdDBB.DBB100005.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目3.class, チェック項目3.class);
            reportWriter3 = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariSealerSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧().get帳票ID())
                    .build();
            dbb100003ReportSourceWriter3 = new ReportSourceWriter<>(reportWriter3);
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100003ReportSourceWriter3.getImageFolderPath(),
                    new RDate(発行日.toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
            new TokubetsuChoshuKaishiTsuchishoKariSealerReport(編集後宛先, sourceBuilder, 仮算定特徴開始通知書情報)
                    .writeBy(dbb100003ReportSourceWriter3);
            reportWriter3.close();
            return dbb100003ReportSourceWriter3.pageCount().value();
        } else if (ReportIdDBB.DBB100006.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目4.class, チェック項目4.class);
            reportWriter4 = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧().get帳票ID())
                    .build();
            dbb100003ReportSourceWriter4 = new ReportSourceWriter<>(reportWriter4);
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100003ReportSourceWriter4.getImageFolderPath(),
                    new RDate(発行日.toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
            new TokubetsuChoshuKaishiTsuchishoKariSealerRenchoReport(編集後宛先, sourceBuilder, 仮算定特徴開始通知書情報)
                    .writeBy(dbb100003ReportSourceWriter4);
            reportWriter4.close();
            return dbb100003ReportSourceWriter4.pageCount().value();
        } else if (ReportIdDBB.DBB100008.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー = KaigoToiawasesakiSourceBuilderCreator.create(
                    SubGyomuCode.DBB介護賦課, 仮算定通知書情報.get帳票分類ID());
            CompKaigoToiawasesakiSource toiawasesakiSource = 介護問合せ先ソースビルダー.buildSource();
            CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目5.class, チェック項目5.class);
            reportWriter5 = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧().get帳票ID())
                    .build();
            dbb100003ReportSourceWriter5 = new ReportSourceWriter<>(reportWriter5);
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100003ReportSourceWriter5.getImageFolderPath(),
                    new RDate(発行日.toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
            new TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateReport(編集後宛先, sourceBuilder,
                    toiawasesakiSource, 仮算定特徴開始通知書情報, result.get通知文1()).writeBy(dbb100003ReportSourceWriter5);
            reportWriter5.close();
            return dbb100003ReportSourceWriter5.pageCount().value();
        }
        return publish特徴開始通知書_B5横オーバレイタイプ(出力帳票一覧, 仮算定特徴開始通知書情報, result,
                仮算定通知書情報, 認証者, is公印に掛ける, is公印を省略, 発行日, info, 編集後宛先);
    }

    private int publish特徴開始通知書_B5横オーバレイタイプ(ChohyoResult 出力帳票一覧, KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            HonsanteiIdoGennendoTsuchisyoIkatsuHakoResult result, KariSanteiTsuchiShoKyotsu 仮算定通知書情報,
            Ninshosha 認証者, boolean is公印に掛ける, boolean is公印を省略, FlexibleDate 発行日, ICheckListInfo info, EditedAtesaki 編集後宛先) {
        if (ReportIdDBB.DBB100009.getReportId().getColumnValue().equals(出力帳票一覧.get帳票ID())) {
            IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー = KaigoToiawasesakiSourceBuilderCreator.create(
                    SubGyomuCode.DBB介護賦課, 仮算定通知書情報.get帳票分類ID());
            CompKaigoToiawasesakiSource toiawasesakiSource = 介護問合せ先ソースビルダー.buildSource();
            CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目6.class, チェック項目6.class);
            reportWriter6 = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧().get帳票ID())
                    .build();
            dbb100003ReportSourceWriter6 = new ReportSourceWriter<>(reportWriter6);
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100003ReportSourceWriter6.getImageFolderPath(),
                    new RDate(発行日.toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
            new TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoReport(編集後宛先, sourceBuilder,
                    toiawasesakiSource, 仮算定特徴開始通知書情報, result.get通知文1(), result.get通知文2()).writeBy(dbb100003ReportSourceWriter6);
            reportWriter6.close();
            return dbb100003ReportSourceWriter6.pageCount().value();
        }
        return 0;
    }

    @Override
    protected void afterExecute() {

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
