/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB015003;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempResult;
import jp.co.ndensan.reams.db.dbb.business.report.karisantei.KarisanteigakuTsuchishoOutPutOrder;
import jp.co.ndensan.reams.db.dbb.business.report.karisantei.KarisanteigakuTsuchishoPageBreak;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5RenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5Report;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiTsuchishoKariHakkoIchirReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariTokuchoKaishiTsuchisyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiTsuchiShoKyotsuKomokuHenshu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB015003.TyouhyouEntity;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidotsuchisho.IdoOrZenkenFukaSelectParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt36002.KarisanteiIdoFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5Source;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource;
import jp.co.ndensan.reams.db.dbb.service.core.karisanteiidotsuchisho.KarisanteiIdoTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.db.dbz.service.report.parts.kaigotoiawasesaki.KaigoToiawasesakiSourceBuilderCreator;
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
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 「特徴開始通知書(仮算定）の発行」処理クラスです。
 *
 * @reamsid_L DBB-0890-030 xicongwang
 */
public class PrtTokuchoKariTsuchishoProcess extends BatchProcessBase<HonsanteiTsuchishoTempEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "karisanteiidotsuchisho.IKarisanteiIdoFukaMapper.select全件賦課情報");
    private static final ReportId 特別徴収開始通知書仮算定帳票分類ID = new ReportId("DBB100003_TokubetsuChoshuKaishiTsuchishoKariDaihyo");
    private static final RString 定数_調定年度 = new RString("調定年度");
    private static final RString 定数_通知書番号 = new RString("通知書番号");
    private static final RString RSTRING_1 = new RString("1");
    private static final RString カンマ = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final FlexibleYear 定値_管理年度 = new FlexibleYear("0000");
    private static final RString 定値_項目名 = new RString("宛名連番印字");
    private static final RString 定値_宛名連番 = new RString("*000001#");
    private static final RString 定値_印字する = new RString("1");
    private static final RString 定数_出力条件 = new RString("出力条件");
    private static final RString 定数_出力順 = new RString("出力順");
    private static final RString 定数_発行日 = new RString("発行日");
    private static final RString SIGN = new RString(" ＞ ");
    private static final RString FORMAT_LEFT = new RString("【");
    private static final RString FORMAT_RIGHT = new RString("】");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBB200001");
    private static final RString 特別徴収_EUCファイル名 = new RString("TokubetsuChoshuKaishiTsuchishoKairiHakkoIchiranData.csv");
    private static final RString 定値_ゼロ = new RString("0");
    private static final RString CSV出力有無_なし = new RString("なし");
    private static final RString CSVファイル名 = new RString("-");
    private static final RString CSV出力有無_あり = new RString("あり");
    private static final RString CSVファイル名_特徴一覧表 = new RString("特別徴収開始通知書（仮算定）発行一覧表");
    private Association 地方公共団体;
    private KarisanteiIdoFukaProcessParameter processParameter;
    private FileSpoolManager fileSpoolManager;
    private RString eucFilePath;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private RString 通知文1;
    private RString 通知文2;
    private RString 宛名連番;
    private int 総ページ数;
    private int 連番;
    private TyouhyouEntity 出力帳票一覧;
    private List<RString> 出力項目リスト;
    private List<RString> 改頁項目リスト;
    private RString 出力順;
    private List<RString> pageBreakKeys;
    private boolean データ有無区分;
    private RString 帳票名;
    private List<RString> 出力条件リスト;
    private KarisanteiIdoTsuchishoIkkatsuHakko manager;
    private KarisanteiIdoTsuchishoHakkoSyori karisanteiSyori;
    private CompKaigoToiawasesakiSource toiawasesakiSource;
    private NinshoshaSource dbb100003NinshoshaSource;
    private NinshoshaSource dbb100004NinshoshaSource;
    private NinshoshaSource dbb100005NinshoshaSource;
    private NinshoshaSource dbb100006NinshoshaSource;
    private NinshoshaSource dbb100008NinshoshaSource;
    private NinshoshaSource dbb100009NinshoshaSource;
    private KariSanteiTsuchiShoKyotsuKomokuHenshu 仮算定共通情報作成;

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

    private BatchReportWriter<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> 一覧表reportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> 一覧表ReportSourceWriter;

    private CsvListWriter csvListWriter;

    @BatchWriter
    private BatchPermanentTableWriter permanentTableWriter;

    @Override
    protected void initialize() {
        総ページ数 = 0;
        データ有無区分 = false;
        出力帳票一覧 = processParameter.get出力帳票一覧();
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        manager = KarisanteiIdoTsuchishoIkkatsuHakko.createInstance();
        karisanteiSyori = new KarisanteiIdoTsuchishoHakkoSyori();
        仮算定共通情報作成 = InstanceProvider.create(KariSanteiTsuchiShoKyotsuKomokuHenshu.class);

        帳票名 = manager.get帳票名_特徴仮算定(出力帳票一覧.get帳票ID().getColumnValue());

        get出力条件リスト();

        帳票制御共通 = manager.load帳票制御共通(特別徴収開始通知書仮算定帳票分類ID);
        int 定型文文字サイズ = 0;
        if (帳票制御共通 != null && !RString.isNullOrEmpty(帳票制御共通.get定型文文字サイズ())) {
            定型文文字サイズ = Integer.parseInt(帳票制御共通.get定型文文字サイズ().toString());
        }
        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        通知文1 = ReportUtil.get通知文(SubGyomuCode.DBB介護賦課,
                特別徴収開始通知書仮算定帳票分類ID, KamokuCode.EMPTY, 定型文文字サイズ, INT_1, システム日付);
        通知文2 = ReportUtil.get通知文(SubGyomuCode.DBB介護賦課,
                特別徴収開始通知書仮算定帳票分類ID, KamokuCode.EMPTY, 定型文文字サイズ, INT_2, システム日付);
        ChohyoSeigyoHanyo 帳票制御汎用 = manager.load帳票制御汎用ByKey(特別徴収開始通知書仮算定帳票分類ID, 定値_管理年度, 定値_項目名);
        if (帳票制御汎用 != null && 定値_印字する.equals(帳票制御汎用.get設定値())) {
            宛名連番 = 定値_宛名連番;
        }
    }

    @Override
    protected void createWriter() {

        initialize特徴開始通知書();

        PageBreaker<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> breaker = new KarisanteigakuTsuchishoPageBreak(pageBreakKeys);
        一覧表reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB200001.getReportId().value()).addBreak(breaker).create();
        一覧表ReportSourceWriter = new ReportSourceWriter<>(一覧表reportWriter);

        fileSpoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = fileSpoolManager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 特別徴収_EUCファイル名);
        csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(カンマ)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true).setHeader(karisanteiSyori.get特別徴収開始通知書発行一覧表タイトルList())
                .build();

        permanentTableWriter = new BatchPermanentTableWriter(DbT2017TsuchishoHakkogoIdoshaEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        IdoOrZenkenFukaSelectParameter parameter
                = IdoOrZenkenFukaSelectParameter.createSelectByKeyParam(0, null, null, null, 出力順);
        return new BatchDbReader(MAPPERPATH, parameter);
    }

    @Override
    protected void process(HonsanteiTsuchishoTempEntity tempEntity) {

        データ有無区分 = true;
        連番 = 連番 + 1;
        HonsanteiTsuchishoTempResult tmpResult = new HonsanteiTsuchishoTempResult();
        try {
            tmpResult = manager.get賦課情報(tempEntity);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(PrtTokuchoKariTsuchishoProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        KariSanteiTsuchiShoKyotsu 仮算定通知書情報 = new KariSanteiTsuchiShoKyotsu();
        仮算定通知書情報.set発行日(new FlexibleDate(processParameter.get特徴_発行日().toDateString()));
        仮算定通知書情報.set帳票分類ID(特別徴収開始通知書仮算定帳票分類ID);
        仮算定通知書情報.set帳票ID(出力帳票一覧.get帳票ID());
        仮算定通知書情報.set処理区分(ShoriKubun.バッチ);
        仮算定通知書情報.set地方公共団体(地方公共団体);
        仮算定通知書情報.set賦課の情報_更正後(tmpResult.get賦課の情報_更正後());
        仮算定通知書情報.set納組情報(tmpResult.get納組情報());
        仮算定通知書情報.set宛先情報(tmpResult.get宛先情報());
        仮算定通知書情報.set前年度賦課情報(tmpResult.get賦課の情報_更正後().get賦課情報());
        仮算定通知書情報.set徴収方法情報_更正後(tmpResult.get徴収方法情報_更正後());
        仮算定通知書情報.set対象者_追加含む_情報_更正後(tmpResult.get対象者_追加含む_情報_更正後());
        仮算定通知書情報.set帳票制御共通(帳票制御共通);
        EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報 = 仮算定共通情報作成.create仮算定通知書共通情報(仮算定通知書情報);

        KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報 = new KariTokuchoKaishiTsuchisyoJoho();
        仮算定特徴開始通知書情報.set発行日(new FlexibleDate(processParameter.get特徴_発行日().toDateString()));
        仮算定特徴開始通知書情報.set帳票分類ID(特別徴収開始通知書仮算定帳票分類ID);
        仮算定特徴開始通知書情報.set帳票ID(出力帳票一覧.get帳票ID());
        仮算定特徴開始通知書情報.set編集後仮算定通知書共通情報(編集後仮算定通知書共通情報);
        仮算定特徴開始通知書情報.set宛先情報(仮算定通知書情報.get宛先情報());
        仮算定特徴開始通知書情報.set処理区分(ShoriKubun.バッチ);
        仮算定特徴開始通知書情報.set地方公共団体(地方公共団体);
        仮算定特徴開始通知書情報.set特徴捕捉月(tmpResult.get対象者_追加含む_情報_更正後().get捕捉月());

        publish特徴開始通知書(仮算定特徴開始通知書情報, 仮算定通知書情報);

        TokubetsuChoshuKaishiTsuchishoKariHakkoIchirReport report
                = new TokubetsuChoshuKaishiTsuchishoKariHakkoIchirReport(仮算定通知書情報,
                        編集後仮算定通知書共通情報, processParameter.get調定年度(), processParameter.get帳票作成日時(),
                        地方公共団体, 出力項目リスト, 改頁項目リスト, 連番);
        report.writeBy(一覧表ReportSourceWriter);
        List<RString> bodyList = karisanteiSyori.get特別徴収開始通知書発行一覧表bodyList(processParameter.get調定年度(),
                processParameter.get帳票作成日時().getRDateTime(), 編集後仮算定通知書共通情報);
        csvListWriter.writeLine(bodyList);

        permanentTableWriter.insert(karisanteiSyori.insert通知書発行後異動者(processParameter.get帳票作成日時(),
                出力帳票一覧.get帳票ID(), tmpResult.get計算後情報_更正後(), 連番));
    }

    @Override
    protected void afterExecute() {

        if (!データ有無区分) {
            manager.loadバッチ出力条件リスト(出力条件リスト, 出力帳票一覧.get帳票ID(), 定値_ゼロ, CSV出力有無_なし, CSVファイル名, 帳票名);
        } else {
            manager.loadバッチ出力条件リスト(出力条件リスト, 出力帳票一覧.get帳票ID(), new RString(総ページ数),
                    CSV出力有無_あり, CSVファイル名_特徴一覧表, 帳票名);
        }

        close特徴開始通知書();
        一覧表reportWriter.close();
        csvListWriter.close();
        fileSpoolManager.spool(SubGyomuCode.DBB介護賦課, eucFilePath);

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
        if (ReportIdDBB.DBB100003.getReportId().equals(出力帳票一覧.get帳票ID())) {
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
                    processParameter.get特徴_発行日(),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        } else if (ReportIdDBB.DBB100004.getReportId().equals(出力帳票一覧.get帳票ID())) {
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
                    processParameter.get特徴_発行日(),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        } else if (ReportIdDBB.DBB100005.getReportId().equals(出力帳票一覧.get帳票ID())) {
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
                    processParameter.get特徴_発行日(),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        } else if (ReportIdDBB.DBB100006.getReportId().equals(出力帳票一覧.get帳票ID())) {
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
                    processParameter.get特徴_発行日(),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        } else if (ReportIdDBB.DBB100008.getReportId().equals(出力帳票一覧.get帳票ID())) {
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
                    processParameter.get特徴_発行日(),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        } else if (ReportIdDBB.DBB100009.getReportId().equals(出力帳票一覧.get帳票ID())) {
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
                    processParameter.get特徴_発行日(),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        }
    }

    private void publish特徴開始通知書(KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報, KariSanteiTsuchiShoKyotsu 仮算定通知書情報) {
        EditedAtesaki 編集後宛先 = JushoHenshu.create編集後宛先(仮算定通知書情報.get宛先情報(),
                仮算定通知書情報.get地方公共団体(), 仮算定通知書情報.get帳票制御共通());
        if (ReportIdDBB.DBB100003.getReportId().equals(出力帳票一覧.get帳票ID())) {
            new TokubetsuChoshuKaishiTsuchishoKariB5Report(編集後宛先, dbb100003NinshoshaSource, 仮算定特徴開始通知書情報, 宛名連番)
                    .writeBy(dbb100003ReportSourceWriter);
            総ページ数 = dbb100003ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100004.getReportId().equals(出力帳票一覧.get帳票ID())) {
            new TokubetsuChoshuKaishiTsuchishoKariB5RenchoReport(編集後宛先, dbb100004NinshoshaSource,
                    仮算定特徴開始通知書情報, 宛名連番).writeBy(dbb100004ReportSourceWriter);
            総ページ数 = dbb100004ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100005.getReportId().equals(出力帳票一覧.get帳票ID())) {
            new TokubetsuChoshuKaishiTsuchishoKariSealerReport(編集後宛先, dbb100005NinshoshaSource, 仮算定特徴開始通知書情報)
                    .writeBy(dbb100005ReportSourceWriter);
            総ページ数 = dbb100005ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100006.getReportId().equals(出力帳票一覧.get帳票ID())) {
            new TokubetsuChoshuKaishiTsuchishoKariSealerRenchoReport(編集後宛先, dbb100006NinshoshaSource, 仮算定特徴開始通知書情報)
                    .writeBy(dbb100006ReportSourceWriter);
            総ページ数 = dbb100006ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100008.getReportId().equals(出力帳票一覧.get帳票ID())) {
            new TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateReport(編集後宛先, dbb100008NinshoshaSource,
                    toiawasesakiSource, 仮算定特徴開始通知書情報, 通知文1).writeBy(dbb100008ReportSourceWriter);
            総ページ数 = dbb100008ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100009.getReportId().equals(出力帳票一覧.get帳票ID())) {
            new TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoReport(編集後宛先, dbb100009NinshoshaSource,
                    toiawasesakiSource, 仮算定特徴開始通知書情報, 通知文1, 通知文2).writeBy(dbb100009ReportSourceWriter);
            総ページ数 = dbb100009ReportSourceWriter.pageCount().value();
        }
    }

    private void close特徴開始通知書() {
        if (ReportIdDBB.DBB100003.getReportId().equals(出力帳票一覧.get帳票ID())) {
            dbb100003ReportWriter.close();
        } else if (ReportIdDBB.DBB100004.getReportId().equals(出力帳票一覧.get帳票ID())) {
            dbb100004ReportWriter.close();
        } else if (ReportIdDBB.DBB100005.getReportId().equals(出力帳票一覧.get帳票ID())) {
            dbb100005ReportWriter.close();
        } else if (ReportIdDBB.DBB100006.getReportId().equals(出力帳票一覧.get帳票ID())) {
            dbb100006ReportWriter.close();
        } else if (ReportIdDBB.DBB100008.getReportId().equals(出力帳票一覧.get帳票ID())) {
            dbb100008ReportWriter.close();
        } else if (ReportIdDBB.DBB100009.getReportId().equals(出力帳票一覧.get帳票ID())) {
            dbb100009ReportWriter.close();
        }
    }

    private void get出力条件リスト() {
        出力条件リスト = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(定数_出力条件);
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_発行日).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(processParameter.get特徴_発行日().wareki().toDateString()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_出力順).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE));
        出力順 = RString.EMPTY;
        出力項目リスト = new ArrayList();
        改頁項目リスト = new ArrayList();
        pageBreakKeys = new ArrayList<>();
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = null;
        if (!RString.isNullOrEmpty(出力帳票一覧.get出力順ID())) {
            outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 特別徴収開始通知書仮算定帳票分類ID,
                    Long.parseLong(出力帳票一覧.get出力順ID().toString()));
        }
        if (outputOrder != null) {
            出力順 = MyBatisOrderByClauseCreator.create(KarisanteigakuTsuchishoOutPutOrder.class, outputOrder);
            List<ISetSortItem> iSetSortItemList = outputOrder.get設定項目リスト();
            for (ISetSortItem iSetSortItem : iSetSortItemList) {
                出力項目リスト.add(iSetSortItem.get項目名());
                if (iSetSortItem.is改頁項目()) {
                    pageBreakKeys.add(iSetSortItem.get項目ID());
                    改頁項目リスト.add(iSetSortItem.get項目名());
                }
                if (iSetSortItem == iSetSortItemList.get(iSetSortItemList.size() - 1)) {
                    builder.append(iSetSortItem.get項目名());
                } else {
                    builder.append(iSetSortItem.get項目名()).append(SIGN);
                }
            }
        }
        出力条件リスト.add(builder.toRString());

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
