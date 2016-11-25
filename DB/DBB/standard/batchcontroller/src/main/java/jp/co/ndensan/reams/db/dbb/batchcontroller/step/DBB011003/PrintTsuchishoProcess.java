/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchokarisanteitsuchishohakko.TokuchoKaishiTsuchishoKarisanteiPageBreak;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5RenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5Report;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.KaishiTsuchishoKariHakkoIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiTsuchishoKariHakkoIchirReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariTokuchoKaishiTsuchisyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsuAfterCorrection;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiTsuchiShoKyotsuKomokuHenshu;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchokarisanteitsuchishohakko.KarisanteiBatchEntity;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchokarisanteitsuchishohakko.TokuchoKaishiTsuchishoMybatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteitsuchishohakko.TokuchoKaishiTsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteitsuchishohakko.KaishiTsuchishoKairiHakkoIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteitsuchishohakko.TsuchishoDataTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5Source;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteitsuchishohakko.TokuchoKaishiTsuchishoDataHenshu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.db.dbz.service.report.parts.kaigotoiawasesaki.KaigoToiawasesakiSourceBuilderCreator;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ue.uex.business.core.NenkinTokuchoKaifuJoho;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.IBatchReportWriterWithCheckList;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListInfoFactory;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListLineItemSet;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckShubetsu;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckListInfo;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckTarget;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ISpecificKey;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 通知書の発行クラスです。
 *
 * @reamsid_L DBB-0790-030 chenaoqi
 */
public class PrintTsuchishoProcess extends BatchProcessBase<TsuchishoDataTempEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
            + ".tokuchokarisanteitsuchishohakko.ITokuchoKarisanteiTsuchishoHakkoMapper.select出力対象データ");
    private static final ReportId 帳票分類ID = new ReportId("DBB100003_TokubetsuChoshuKaishiTsuchishoKariDaihyo");
    private static final FlexibleYear 管理年度 = new FlexibleYear("0000");
    private static final RString 項目名 = new RString("宛名連番印字");
    private static final RString 宛名連番値 = new RString("*000001#");
    private static final RString 定数_調定年度 = new RString("調定年度");
    private static final RString 定数_通知書番号 = new RString("通知書番号");
    private static final RString CSV出力有無_なし = new RString("なし");
    private static final RString CSV出力有無_あり = new RString("あり");
    private static final RString CSVファイル名 = new RString("-");
    private static final RString CSVファイル名_一覧表 = new RString("特徴仮算定通知書一括発行一覧");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBB200001");
    private static final RString 特別徴収_EUCファイル名 = new RString("TokubetsuChoshuKaishiTsuchishoKairiHakkoIchiranData.csv");
    private static final RString カンマ = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 定値_0 = new RString("0");
    private static final RString 定値_1 = new RString("1");
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_5 = 5;

    private TokuchoKaishiTsuchishoProcessParameter processParameter;
    private TokuchoKaishiTsuchishoDataHenshu manager;
    private FileSpoolManager spoolManager;
    private ReportId 帳票ID;
    private RString 出力順;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private ChohyoSeigyoHanyo 帳票制御汎用;
    private Ninshosha 認証者;
    private NinshoshaSource dbb100003SourceBuilder;
    private NinshoshaSource dbb100004SourceBuilder;
    private NinshoshaSource dbb100005SourceBuilder;
    private NinshoshaSource dbb100006SourceBuilder;
    private NinshoshaSource dbb100008SourceBuilder;
    private NinshoshaSource dbb100009SourceBuilder;
    private CompKaigoToiawasesakiSource toiawasesakiSource;
    private KarisanteiBatchEntity 出力帳票一覧Entity;
    private Association 地方公共団体;
    private List<RString> 出力項目リスト;
    private List<RString> 改頁項目リスト;
    private List<RString> breakKeyList;
    private RString 通知書定型文1;
    private RString 通知書定型文2;
    private RString 宛名連番;
    private RString 帳票名;
    private RString 出力対象;
    private boolean 出力flag;
    private int 総ページ数;
    private int 連番;

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
    @BatchWriter
    private BatchReportWriter<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> batchReportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> reportSourceWriter;

    private CsvWriter<KaishiTsuchishoKairiHakkoIchiranCSVEntity> eucCsvWriter;
    @BatchWriter
    private BatchPermanentTableWriter 通知書発行後異動者tableWriter;

    @Override
    protected void initialize() {
        出力flag = false;
        総ページ数 = 0;
        連番 = 1;
        出力項目リスト = new ArrayList();
        改頁項目リスト = new ArrayList();
        breakKeyList = new ArrayList();
        manager = TokuchoKaishiTsuchishoDataHenshu.createInstance();
        出力帳票一覧Entity = processParameter.get出力帳票一覧Entity();
        if (!RString.isNullOrEmpty(出力帳票一覧Entity.get出力順ID())) {
            get出力順(出力帳票一覧Entity.get出力順ID());
        }
        帳票制御共通 = manager.load帳票制御共通(帳票分類ID);
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        if (帳票制御共通 != null && !nullTOEmpty(帳票制御共通.get定型文文字サイズ()).isEmpty()) {
            int パターン番号 = Integer.parseInt(nullTOEmpty(帳票制御共通.get定型文文字サイズ()).toString());
            FlexibleDate システム日付 = FlexibleDate.getNowDate();
            通知書定型文1 = ReportUtil.get通知文(SubGyomuCode.DBB介護賦課, 帳票分類ID, KamokuCode.EMPTY,
                    パターン番号, INT_1, システム日付);
            通知書定型文2 = ReportUtil.get通知文(SubGyomuCode.DBB介護賦課, 帳票分類ID, KamokuCode.EMPTY,
                    パターン番号, INT_2, システム日付);
        }
        帳票制御汎用 = manager.load帳票制御汎用ByKey(帳票分類ID, 管理年度, 項目名);
        if (定値_1.equals(帳票制御汎用.get設定値())) {
            宛名連番 = 宛名連番値;
        }
        帳票ID = 出力帳票一覧Entity.get帳票ID();
        帳票名 = manager.get帳票名_特徴(帳票ID.value());
        出力対象 = manager.get出力対象(processParameter.get出力対象());
    }

    @Override
    protected void beforeExecute() {

    }

    @Override
    protected void createWriter() {
        initialize特徴開始通知書();
        通知書発行後異動者tableWriter = new BatchPermanentTableWriter(DbT2017TsuchishoHakkogoIdoshaEntity.class);
        PageBreaker<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> breaker = new TokuchoKaishiTsuchishoKarisanteiPageBreak(breakKeyList);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB200001.getReportId().value())
                .addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        spoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = spoolManager.getEucOutputDirectry();
        RString eucFilePath = Path.combinePath(spoolWorkPath, 特別徴収_EUCファイル名);
        eucCsvWriter = BatchWriters.csvWriter(KaishiTsuchishoKairiHakkoIchiranCSVEntity.class)
                .filePath(eucFilePath)
                .setDelimiter(カンマ)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected IBatchReader createReader() {
        TokuchoKaishiTsuchishoMybatisParameter parameter = new TokuchoKaishiTsuchishoMybatisParameter();
        parameter.set出力順(出力順);
        parameter.set出力対象(出力対象);
        return new BatchDbReader(MAPPERPATH, parameter);
    }

    @Override
    protected void process(TsuchishoDataTempEntity entity) {

        KariSanteiTsuchiShoKyotsuKomokuHenshu 仮算定通知書共通情報作成 = InstanceProvider
                .create(KariSanteiTsuchiShoKyotsuKomokuHenshu.class);
        KariSanteiTsuchiShoKyotsu 仮算定通知書情報 = new KariSanteiTsuchiShoKyotsu();
        KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報 = new KariTokuchoKaishiTsuchisyoJoho();
        仮算定通知書情報.set発行日(processParameter.get発行日());
        仮算定通知書情報.set帳票分類ID(帳票分類ID);
        仮算定通知書情報.set帳票ID(帳票ID);
        仮算定通知書情報.set処理区分(ShoriKubun.バッチ);
        仮算定通知書情報.set地方公共団体(地方公共団体);
        仮算定通知書情報.set賦課の情報_更正後(manager.get賦課の情報(entity));
        仮算定通知書情報.set納組情報(entity.get納組());
        IAtesaki 宛先 = AtesakiFactory.createInstance(entity.get宛先());
        仮算定通知書情報.set宛先情報(宛先);
        List<Decimal> 期別金額リスト = new ArrayList<>();
        期別金額リスト.add(entity.get前年度特徴期別金額01());
        期別金額リスト.add(entity.get前年度特徴期別金額02());
        期別金額リスト.add(entity.get前年度特徴期別金額03());
        期別金額リスト.add(entity.get前年度特徴期別金額04());
        期別金額リスト.add(entity.get前年度特徴期別金額05());
        期別金額リスト.add(entity.get前年度特徴期別金額06());
        FukaJoho 賦課情報 = manager.get賦課情報(entity.get前年度賦課情報(), 期別金額リスト);
        if (賦課情報.get調定年度() == null || 賦課情報.get賦課年度() == null || 賦課情報.get通知書番号() == null) {
            賦課情報 = null;
        }
        仮算定通知書情報.set前年度賦課情報(賦課情報);
        仮算定通知書情報.set徴収方法情報_更正後(manager.get徴収方法情報(entity));
        仮算定通知書情報.set対象者_追加含む_情報_更正後(new NenkinTokuchoKaifuJoho(entity.get対象者_追加含む情報()));
        仮算定通知書情報.set帳票制御共通(帳票制御共通);
        EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報 = 仮算定通知書共通情報作成
                .create仮算定通知書共通情報(仮算定通知書情報);
        仮算定特徴開始通知書情報.set発行日(processParameter.get発行日());
        仮算定特徴開始通知書情報.set編集後仮算定通知書共通情報(編集後仮算定通知書共通情報);
        仮算定特徴開始通知書情報.set帳票分類ID(帳票分類ID);
        仮算定特徴開始通知書情報.set帳票ID(帳票ID);
        仮算定特徴開始通知書情報.set宛先情報(宛先);
        総ページ数 = publish特徴開始通知書(出力帳票一覧Entity, 仮算定特徴開始通知書情報, 宛名連番, 仮算定通知書情報);
        TokubetsuChoshuKaishiTsuchishoKariHakkoIchirReport report = new TokubetsuChoshuKaishiTsuchishoKariHakkoIchirReport(
                仮算定通知書情報, 編集後仮算定通知書共通情報, processParameter.get調定年度(), processParameter.get帳票作成日時(),
                地方公共団体, 出力項目リスト, 改頁項目リスト, 連番, entity);
        report.writeBy(reportSourceWriter);
        eucCsvWriter.writeLine(createCSVData(編集後仮算定通知書共通情報));
        通知書発行後異動者tableWriter.insert(create通知書発行後異動者(entity));
        出力flag = true;
        連番 = 連番 + INT_1;
    }

    @Override
    protected void afterExecute() {
        colseWriter();
        eucCsvWriter.close();
        spoolManager.spool(SubGyomuCode.DBB介護賦課, 特別徴収_EUCファイル名);
        List<RString> 出力条件リスト = manager.get出力条件リスト(processParameter.get発行日(), processParameter.get出力対象(),
                出力帳票一覧Entity.get出力順ID());
        if (!出力flag) {
            manager.load代行プリント送付票(processParameter.get発行日(), processParameter.get出力対象(), 帳票制御共通, 地方公共団体,
                    出力帳票一覧Entity.get出力順ID(), Decimal.ZERO);
            manager.loadバッチ出力条件リスト(出力条件リスト, 帳票ID, 定値_0,
                    CSV出力有無_なし, CSVファイル名, 帳票名);
        } else {
            manager.load代行プリント送付票(processParameter.get発行日(), processParameter.get出力対象(), 帳票制御共通,
                    地方公共団体, 出力帳票一覧Entity.get出力順ID(), new Decimal(総ページ数));
            manager.loadバッチ出力条件リスト(出力条件リスト, 帳票ID, new RString(総ページ数),
                    CSV出力有無_あり, CSVファイル名_一覧表, 帳票名);
        }

    }

    private DbT2017TsuchishoHakkogoIdoshaEntity create通知書発行後異動者(TsuchishoDataTempEntity 出力対象) {
        DbT2017TsuchishoHakkogoIdoshaEntity 通知書発行後異動者 = new DbT2017TsuchishoHakkogoIdoshaEntity();
        通知書発行後異動者.setReportID(帳票ID);
        通知書発行後異動者.setChohyosakuseiTimestamp(processParameter.get帳票作成日時());
        通知書発行後異動者.setTsuchishoNo(出力対象.get計算後情報().getTsuchishoNo());
        通知書発行後異動者.setFukaNendo(出力対象.get計算後情報().getFukaNendo());
        通知書発行後異動者.setShikibetsuCode(出力対象.get計算後情報().getShikibetsuCode());
        通知書発行後異動者.setHihokenshaNo(出力対象.get計算後情報().getHihokenshaNo());
        通知書発行後異動者.setKeisanTimestamp(出力対象.get計算後情報().getChoteiNichiji());
        通知書発行後異動者.setGaitoRemban(連番);
        通知書発行後異動者.setIdoAriFlag(false);
        return 通知書発行後異動者;
    }

    private KaishiTsuchishoKairiHakkoIchiranCSVEntity createCSVData(EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報) {
        KaishiTsuchishoKairiHakkoIchiranCSVEntity csvEntity = new KaishiTsuchishoKairiHakkoIchiranCSVEntity();
        RString 作成年月日 = processParameter.get帳票作成日時().getDate().seireki().separator(Separator.SLASH)
                .fillType(FillType.BLANK).toDateString();
        csvEntity.set作成年月日(作成年月日);
        RString 帳票作成日時 = processParameter.get帳票作成日時().getRDateTime().getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH_mm_ss);
        csvEntity.set作成時刻(帳票作成日時);
        FlexibleYear 賦課年度 = processParameter.get調定年度();
        csvEntity.set賦課年度(賦課年度 != null ? 賦課年度.toDateString() : RString.EMPTY);
        EditedAtesaki 編集後宛先 = 編集後仮算定通知書共通情報.get編集後宛先();
        EditedKojin 編集後個人 = 編集後仮算定通知書共通情報.get編集後個人();
        EditedKariSanteiTsuchiShoKyotsuAfterCorrection 更正後 = 編集後仮算定通知書共通情報.get更正後();
        if (編集後宛先 != null) {
            csvEntity.set郵便番号(編集後宛先.get郵便番号());
            csvEntity.set住所(編集後宛先.get編集後住所());
            csvEntity.set町域管内管外住所(編集後宛先.get町域());
            csvEntity.set番地(編集後宛先.get番地());
            GyoseikuCode 行政区コード = 編集後宛先.get行政区コード();
            csvEntity.set行政区コード(行政区コード != null ? 行政区コード.value() : RString.EMPTY);
            csvEntity.set行政区(編集後宛先.get行政区名());
        }
        if (編集後個人 != null) {
            csvEntity.set生年月日(編集後個人.get生年月日Csv());
            csvEntity.set性別(編集後個人.get性別());
            AtenaMeisho 世帯主名 = 編集後個人.get世帯主名();
            csvEntity.set世帯主名(世帯主名 != null ? 世帯主名.value() : RString.EMPTY);
            SetaiCode 世帯コード = 編集後個人.get世帯コード();
            csvEntity.set世帯コード(世帯コード != null ? 世帯コード.value() : RString.EMPTY);
            IName 名称 = 編集後個人.get名称();
            csvEntity.set被保険者氏名(名称 != null ? 名称.getName().value() : RString.EMPTY);
        }
        TsuchishoNo 通知書番号 = 編集後仮算定通知書共通情報.get通知書番号();
        csvEntity.set通知書番号(通知書番号 != null ? 通知書番号.value() : RString.EMPTY);
        if (更正後 != null) {
            csvEntity.set特別徴収業務者コード(更正後.get更正後特別徴収義務者コード());
            csvEntity.set特別徴収業務者(更正後.get更正後特別徴収義務者());
            csvEntity.set特別徴収対象年金コード(更正後.get更正後特別徴収対象年金コード());
            csvEntity.set特別徴収対象年金(更正後.get更正後特別徴収対象年金());
            csvEntity.set仮徴収額_4月(DecimalFormatter.toコンマ区切りRString(
                    nullToDecimal(更正後.get更正後特徴期別金額01()), 0));
            csvEntity.set仮徴収額_6月(DecimalFormatter.toコンマ区切りRString(
                    nullToDecimal(更正後.get更正後特徴期別金額02()), 0));
            csvEntity.set仮徴収額_8月(DecimalFormatter.toコンマ区切りRString(
                    nullToDecimal(更正後.get更正後特徴期別金額03()), 0));
        }
        return csvEntity;

    }

    private void initialize特徴開始通知書() {
        FlexibleDate 開始年月日 = FlexibleDate.getNowDate();
        if (processParameter.get発行日() != null) {
            開始年月日 = processParameter.get発行日();
        }
        boolean is公印に掛ける = false;
        boolean is公印を省略 = false;
        if (帳票制御共通 != null && 定値_1.equals(帳票制御共通.get首長名印字位置())) {
            is公印に掛ける = true;
        }
        if (帳票制御共通 != null && !帳票制御共通.is電子公印印字有無()) {
            is公印を省略 = true;
        }
        認証者 = NinshoshaFinderFactory.createInstance()
                .get帳票認証者(GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), 開始年月日);
        ICheckListInfo info = CheckListInfoFactory.createInstance(SubGyomuCode.DBB介護賦課,
                地方公共団体.getLasdecCode_(), 地方公共団体.get市町村名());
        IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー = KaigoToiawasesakiSourceBuilderCreator.create(
                SubGyomuCode.DBB介護賦課, 出力帳票一覧Entity.get帳票分類ID());
        toiawasesakiSource = 介護問合せ先ソースビルダー.buildSource();
        if (ReportIdDBB.DBB100003.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {

            CheckListLineItemSet pairs = CheckListLineItemSet.
                    of(PrintTsuchishoProcess.特定項目1.class,
                            PrintTsuchishoProcess.チェック項目1.class);
            dbb100003reportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariB5Source.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧Entity().get帳票ID())
                    .build();
            dbb100003ReportSourceWriter = new ReportSourceWriter<>(dbb100003reportWriter);
            dbb100003SourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100003ReportSourceWriter.getImageFolderPath(),
                    new RDate(processParameter.get発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();

        } else if (ReportIdDBB.DBB100004.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {

            CheckListLineItemSet pairs = CheckListLineItemSet.
                    of(PrintTsuchishoProcess.特定項目2.class,
                            PrintTsuchishoProcess.チェック項目2.class);
            dbb100004reportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧Entity().get帳票ID())
                    .build();
            dbb100004ReportSourceWriter = new ReportSourceWriter<>(dbb100004reportWriter);
            dbb100004SourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100004ReportSourceWriter.getImageFolderPath(),
                    new RDate(processParameter.get発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        } else if (ReportIdDBB.DBB100005.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {

            CheckListLineItemSet pairs = CheckListLineItemSet.
                    of(PrintTsuchishoProcess.特定項目3.class,
                            PrintTsuchishoProcess.チェック項目3.class);
            dbb100005reportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariSealerSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧Entity().get帳票ID())
                    .build();
            dbb100005ReportSourceWriter = new ReportSourceWriter<>(dbb100005reportWriter);
            dbb100005SourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100005ReportSourceWriter.getImageFolderPath(),
                    new RDate(processParameter.get発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();

        } else if (ReportIdDBB.DBB100006.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {

            CheckListLineItemSet pairs = CheckListLineItemSet.
                    of(PrintTsuchishoProcess.特定項目4.class,
                            PrintTsuchishoProcess.チェック項目4.class);
            dbb100006reportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧Entity().get帳票ID())
                    .build();
            dbb100006ReportSourceWriter = new ReportSourceWriter<>(dbb100006reportWriter);
            dbb100006SourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100006ReportSourceWriter.getImageFolderPath(),
                    new RDate(processParameter.get発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();

        } else if (ReportIdDBB.DBB100008.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {

            CheckListLineItemSet pairs = CheckListLineItemSet.
                    of(PrintTsuchishoProcess.特定項目5.class,
                            PrintTsuchishoProcess.チェック項目5.class);
            dbb100008reportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧Entity().get帳票ID())
                    .build();
            dbb100008ReportSourceWriter = new ReportSourceWriter<>(dbb100008reportWriter);
            dbb100008SourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100008ReportSourceWriter.getImageFolderPath(),
                    new RDate(processParameter.get発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();

        } else if (ReportIdDBB.DBB100009.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {

            CheckListLineItemSet pairs = CheckListLineItemSet.
                    of(PrintTsuchishoProcess.特定項目6.class,
                            PrintTsuchishoProcess.チェック項目6.class);
            dbb100009reportWriter = BatchWriters
                    .batchReportWriterWithCheckList(TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource.class)
                    .checkListInfo(info)
                    .checkListLineItemSet(pairs)
                    .reportId(processParameter.get出力帳票一覧Entity().get帳票ID())
                    .build();
            dbb100009ReportSourceWriter = new ReportSourceWriter<>(dbb100009reportWriter);
            dbb100009SourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    dbb100009ReportSourceWriter.getImageFolderPath(),
                    new RDate(processParameter.get発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        }

    }

    private int publish特徴開始通知書(KarisanteiBatchEntity 出力帳票一覧Entity,
            KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            RString 宛名連番, KariSanteiTsuchiShoKyotsu 仮算定通知書情報) {

        EditedAtesaki 編集後宛先 = JushoHenshu.create編集後宛先(仮算定通知書情報.get宛先情報(),
                仮算定通知書情報.get地方公共団体(), 仮算定通知書情報.get帳票制御共通());
        if (ReportIdDBB.DBB100003.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {

            new TokubetsuChoshuKaishiTsuchishoKariB5Report(編集後宛先, dbb100003SourceBuilder,
                    仮算定特徴開始通知書情報, 宛名連番).writeBy(dbb100003ReportSourceWriter);
            return dbb100003ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100004.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {

            new TokubetsuChoshuKaishiTsuchishoKariB5RenchoReport(編集後宛先, dbb100004SourceBuilder,
                    仮算定特徴開始通知書情報, 宛名連番).writeBy(dbb100004ReportSourceWriter);
            return dbb100004ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100005.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {

            new TokubetsuChoshuKaishiTsuchishoKariSealerReport(編集後宛先, dbb100005SourceBuilder,
                    仮算定特徴開始通知書情報).writeBy(dbb100005ReportSourceWriter);
            return dbb100005ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100006.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {

            new TokubetsuChoshuKaishiTsuchishoKariSealerRenchoReport(編集後宛先, dbb100006SourceBuilder,
                    仮算定特徴開始通知書情報).writeBy(dbb100006ReportSourceWriter);
            return dbb100006ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100008.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {

            new TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateReport(編集後宛先, dbb100008SourceBuilder, toiawasesakiSource,
                    仮算定特徴開始通知書情報, 通知書定型文1).writeBy(dbb100008ReportSourceWriter);
            return dbb100008ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100009.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {

            new TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoReport(編集後宛先, dbb100009SourceBuilder, toiawasesakiSource,
                    仮算定特徴開始通知書情報, 通知書定型文1, 通知書定型文2)
                    .writeBy(dbb100009ReportSourceWriter);
            return dbb100009ReportSourceWriter.pageCount().value();
        }
        return 0;

    }

    private void colseWriter() {
        if (ReportIdDBB.DBB100003.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {
            dbb100003reportWriter.close();

        } else if (ReportIdDBB.DBB100004.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {

            dbb100004reportWriter.close();
        } else if (ReportIdDBB.DBB100005.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {

            dbb100005reportWriter.close();
        } else if (ReportIdDBB.DBB100006.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {

            dbb100006reportWriter.close();
        } else if (ReportIdDBB.DBB100008.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {

            dbb100008reportWriter.close();
        } else if (ReportIdDBB.DBB100009.getReportId().equals(出力帳票一覧Entity.get帳票ID())) {

            dbb100009reportWriter.close();
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

    private void get出力順(RString 出力順ID) {
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 帳票分類ID, Long.valueOf(出力順ID.toString()));
        if (outputOrder == null || outputOrder.get設定項目リスト() == null) {
            return;
        }
        出力順 = MyBatisOrderByClauseCreator.create(KaishiTsuchishoKariHakkoIchiranProperty.BreakerFieldsEnum.class,
                outputOrder);
        int i = INT_1;
        for (ISetSortItem setSortItem : outputOrder.get設定項目リスト()) {
            if (i <= INT_5) {
                出力項目リスト.add(setSortItem.get項目名());
                if (setSortItem.is改頁項目()) {
                    改頁項目リスト.add(setSortItem.get項目名());
                    breakKeyList.add(setSortItem.get項目ID());
                }
            }
            i = i + INT_1;
        }
    }

    private RString nullTOEmpty(RString 項目) {
        if (項目 == null || 項目.isEmpty()) {
            return RString.EMPTY;
        }
        return 項目;
    }

    private Decimal nullToDecimal(Decimal 金額) {
        if (金額 == null) {
            return Decimal.ZERO;
        }
        return 金額;
    }
}
