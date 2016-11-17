/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempResult;
import jp.co.ndensan.reams.db.dbb.business.report.honsantei.TokubetsuChoshuKaishiPageBreak;
import jp.co.ndensan.reams.db.dbb.business.report.honsantei.TokubetsuChoshuKaishiPageOutPutOrder;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52RenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52Report;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5RenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5Report;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoOverlayA4TateReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsuKomokuHenshu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka.HonsanteifukaBatchTyouhyou;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.TokuchoKaishiTsuhishoHoniOutputJoken;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteitsuchishoikkatsuhakko.PrtTokuchoKaishiTsuchishoHonsanteiParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt43002.HonsanteifukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52RenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52Source;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5RenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5Source;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiSource;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
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
 * 特徴開始通知書(本算定）の発行クラスです。
 *
 * @reamsid_L DBB-0780-050 xicongwang
 */
public class PrtTokuchoKaishiTsuchishoHonsanteiProcess extends BatchProcessBase<HonsanteiTsuchishoTempEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "honsanteitsuchishoikkatsuhakko.IHonsanteiTsuchishoIkkatsuHakkoMapper.select特徴開始通知書");
    private static final ReportId 特別徴収開始通知書本算定_帳票分類ID = new ReportId("DBB100032_TokubetsuChoshuKaishiTsuchishoDaihyo");
    private static final RString 定数_賦課年度 = new RString("賦課年度");
    private static final RString 定数_通知書番号 = new RString("通知書番号");
    private static final RString 定数_被保険者氏名 = new RString("被保険者氏名");
    private static final RString 定数_被保険者番号 = new RString("hihokenshaName");
    private static final RString RSTRING_1 = new RString("1");
    private static final RString 定値_ゼロ = new RString("0");
    private static final RString CSV出力有無_なし = new RString("なし");
    private static final RString CSVファイル名 = new RString("-");
    private static final RString CSV出力有無_あり = new RString("あり");
    private static final RString CSVファイル名_一覧表 = new RString("特別徴収開始通知書発行一覧表");
    private static final RString 定数_出力条件 = new RString("出力条件");
    private static final RString 定数_調定年度 = new RString("調定年度");
    private static final RString 定数_出力対象 = new RString("出力対象");
    private static final RString 定数_出力順 = new RString("出力順");
    private static final RString FORMAT_LEFT = new RString("【");
    private static final RString FORMAT_RIGHT = new RString("】");
    private static final RString SIGN = new RString(" ＞ ");
    private static final int INT_1 = 1;
    private static final FlexibleYear 定値_管理年度 = new FlexibleYear("0000");
    private static final RString 定値_項目名 = new RString("宛名連番印字");
    private static final RString 定値_宛名連番 = new RString("*000001#");
    private static final RString 定値_印字する = new RString("1");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBB200001");
    private static final RString 特別徴収_EUCファイル名 = new RString("TokubetsuChoshuKaishiTsuchishoKairiHakkoIchiranData.csv");
    private static final RString カンマ = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private boolean データ有無区分;
    private RString 帳票名;
    private List<RString> 出力条件リスト;
    private Association 地方公共団体;
    private HonsanteifukaProcessParameter processParameter;
    private PrtTokuchoKaishiTsuchishoHonsanteiParameter myBatisParameter;
    private HonsanteiTsuchishoIkkatsuHakko manager;
    private HonsanteiTsuchishoIkkatsuHakkoSyori honsanteiSyori;
    private HonSanteiTsuchiShoKyotsuKomokuHenshu 本算定共通情報作成;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private RString 通知書定型文;
    private RString 宛名連番;
    private int 総ページ数;
    private int 連番;
    private HonsanteifukaBatchTyouhyou 出力帳票一覧;
    private List<RString> 出力項目リスト;
    private List<RString> 改頁項目リスト;
    private RString 出力順;
    private List<RString> pageBreakKeys;
    private FileSpoolManager fileSpoolManager;
    private RString eucFilePath;
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

    private BatchReportWriter<TokubetsuChoshuKaishiSource> 一覧表reportWriter;
    private ReportSourceWriter<TokubetsuChoshuKaishiSource> 一覧表ReportSourceWriter;

    private CsvListWriter csvListWriter;

    @BatchWriter
    private BatchPermanentTableWriter permanentTableWriter;

    @Override
    protected void initialize() {

        総ページ数 = 0;
        データ有無区分 = false;
        出力帳票一覧 = processParameter.get出力帳票一覧();
        本算定共通情報作成 = InstanceProvider.create(HonSanteiTsuchiShoKyotsuKomokuHenshu.class);
        manager = HonsanteiTsuchishoIkkatsuHakko.createInstance();
        honsanteiSyori = new HonsanteiTsuchishoIkkatsuHakkoSyori();
        帳票名 = manager.get帳票名_特徴(出力帳票一覧.get帳票ID().getColumnValue());

        get出力条件リスト();

        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        帳票制御共通 = manager.load帳票制御共通(特別徴収開始通知書本算定_帳票分類ID);
        int 定型文文字サイズ = 0;
        if (帳票制御共通 != null && !RString.isNullOrEmpty(帳票制御共通.get定型文文字サイズ())) {
            定型文文字サイズ = Integer.parseInt(帳票制御共通.get定型文文字サイズ().toString());
        }
        通知書定型文 = ReportUtil.get通知文(SubGyomuCode.DBB介護賦課,
                特別徴収開始通知書本算定_帳票分類ID, KamokuCode.EMPTY, 定型文文字サイズ, INT_1, FlexibleDate.getNowDate());
        宛名連番 = RString.EMPTY;
        ChohyoSeigyoHanyo 帳票制御 = manager.load帳票制御汎用ByKey(特別徴収開始通知書本算定_帳票分類ID, 定値_管理年度, 定値_項目名);
        if (帳票制御 != null && 定値_印字する.equals(帳票制御.get設定値())) {
            宛名連番 = 定値_宛名連番;
        }

        myBatisParameter = PrtTokuchoKaishiTsuchishoHonsanteiParameter.createSelectByKeyParam(processParameter.get特徴_出力対象(), 出力順);
    }

    @Override
    protected void createWriter() {

        initialize特徴開始通知書();

        PageBreaker<TokubetsuChoshuKaishiSource> breaker = new TokubetsuChoshuKaishiPageBreak(pageBreakKeys);
        一覧表reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB200011.getReportId().value()).addBreak(breaker).create();
        一覧表ReportSourceWriter = new ReportSourceWriter<>(一覧表reportWriter);

        fileSpoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = fileSpoolManager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 特別徴収_EUCファイル名);
        csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(カンマ)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true).setHeader(honsanteiSyori.get特別徴収開始通知書発行一覧表タイトルList())
                .build();

        permanentTableWriter = new BatchPermanentTableWriter(DbT2017TsuchishoHakkogoIdoshaEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH, myBatisParameter);
    }

    @Override
    protected void beforeExecute() {

    }

    @Override
    protected void process(HonsanteiTsuchishoTempEntity tempEntity) {

        データ有無区分 = true;
        連番 = 連番 + 1;
        HonsanteiTsuchishoTempResult tmpResult = new HonsanteiTsuchishoTempResult();
        try {
            tmpResult = manager.get賦課情報(tempEntity);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(PrtTokuchoKaishiTsuchishoHonsanteiProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        本算定通知書情報.set帳票制御共通(帳票制御共通);
        EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 = 本算定共通情報作成.create本算定通知書共通情報(本算定通知書情報);
        総ページ数 = publish特徴開始通知書(編集後本算定通知書共通情報);
        TokubetsuChoshuKaishiReport report = new TokubetsuChoshuKaishiReport(
                tempEntity.get特徴10月開始者区分(), 本算定通知書情報,
                編集後本算定通知書共通情報, processParameter.get調定年度(),
                processParameter.get帳票作成日時().getRDateTime(), 地方公共団体.get地方公共団体コード().getColumnValue(),
                地方公共団体.get市町村名(), 出力項目リスト, 改頁項目リスト, 連番);
        report.writeBy(一覧表ReportSourceWriter);
        List<RString> bodyList = honsanteiSyori.get特別徴収開始通知書発行一覧表bodyList(processParameter.get調定年度(),
                processParameter.get帳票作成日時().getRDateTime(), 編集後本算定通知書共通情報);
        csvListWriter.writeLine(bodyList);

        permanentTableWriter.insert(honsanteiSyori.insert通知書発行後異動者(processParameter.get帳票作成日時(),
                出力帳票一覧.get帳票ID(), tmpResult.get計算後情報_更正後(), 連番));
    }

    @Override
    protected void afterExecute() {
        if (!データ有無区分) {
            manager.loadバッチ出力条件リスト(出力条件リスト, 出力帳票一覧.get帳票ID(), 定値_ゼロ, CSV出力有無_なし, CSVファイル名, 帳票名);
        } else {
            manager.loadバッチ出力条件リスト(出力条件リスト, 出力帳票一覧.get帳票ID(), new RString(総ページ数),
                    CSV出力有無_あり, CSVファイル名_一覧表, 帳票名);
        }
        close特徴開始通知書();
        一覧表reportWriter.close();
        csvListWriter.close();
        fileSpoolManager.spool(SubGyomuCode.DBB介護賦課, eucFilePath);
    }

    private void get出力条件リスト() {
        出力条件リスト = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(定数_出力条件);
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_賦課年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(processParameter.get調定年度().wareki().toDateString()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_調定年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(processParameter.get調定年度().wareki().toDateString()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_出力対象).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(RString.isNullOrEmpty(processParameter.get特徴_出力対象())
                        ? RString.EMPTY : TokuchoKaishiTsuhishoHoniOutputJoken.toValue(processParameter.get特徴_出力対象()).get名称()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_出力順).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE));
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = null;
        if (!RString.isNullOrEmpty(出力帳票一覧.get出力順ID())) {
            outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 特別徴収開始通知書本算定_帳票分類ID,
                    Long.parseLong(出力帳票一覧.get出力順ID().toString()));
        }
        出力順 = RString.EMPTY;
        出力項目リスト = new ArrayList();
        改頁項目リスト = new ArrayList();
        pageBreakKeys = new ArrayList<>();
        if (outputOrder != null) {
            出力順 = MyBatisOrderByClauseCreator.create(TokubetsuChoshuKaishiPageOutPutOrder.class, outputOrder);
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

    private void close特徴開始通知書() {
        if (ReportIdDBB.DBB100032.getReportId().equals(出力帳票一覧.get帳票ID())) {
            dbb100032ReportWriter.close();
        } else if (ReportIdDBB.DBB100033.getReportId().equals(出力帳票一覧.get帳票ID())) {
            dbb100033ReportWriter.close();
        } else if (ReportIdDBB.DBB100034.getReportId().equals(出力帳票一覧.get帳票ID())) {
            dbb100034ReportWriter.close();
        } else if (ReportIdDBB.DBB100035.getReportId().equals(出力帳票一覧.get帳票ID())) {
            dbb100035ReportWriter.close();
        } else if (ReportIdDBB.DBB100036.getReportId().equals(出力帳票一覧.get帳票ID())) {
            dbb100036ReportWriter.close();
        } else if (ReportIdDBB.DBB100037.getReportId().equals(出力帳票一覧.get帳票ID())) {
            dbb100037ReportWriter.close();
        } else if (ReportIdDBB.DBB100038.getReportId().equals(出力帳票一覧.get帳票ID())) {
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
        if (ReportIdDBB.DBB100032.getReportId().equals(出力帳票一覧.get帳票ID())) {
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
                    processParameter.get特徴_発行日(),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        } else if (ReportIdDBB.DBB100033.getReportId().equals(出力帳票一覧.get帳票ID())) {
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
                    processParameter.get特徴_発行日(),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        } else if (ReportIdDBB.DBB100034.getReportId().equals(出力帳票一覧.get帳票ID())) {
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
                    processParameter.get特徴_発行日(),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        } else if (ReportIdDBB.DBB100035.getReportId().equals(出力帳票一覧.get帳票ID())) {
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
                    processParameter.get特徴_発行日(),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        } else if (ReportIdDBB.DBB100036.getReportId().equals(出力帳票一覧.get帳票ID())) {
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
                    processParameter.get特徴_発行日(),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        } else if (ReportIdDBB.DBB100037.getReportId().equals(出力帳票一覧.get帳票ID())) {
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
                    processParameter.get特徴_発行日(),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        } else if (ReportIdDBB.DBB100038.getReportId().equals(出力帳票一覧.get帳票ID())) {
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
                    processParameter.get特徴_発行日(),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();
        }
    }

    private int publish特徴開始通知書(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報) {

        if (ReportIdDBB.DBB100032.getReportId().equals(出力帳票一覧.get帳票ID())) {
            new TokubetsuChoshuKaishiTsuchishoB5Report(編集後本算定通知書共通情報, 宛名連番, dbb100032NinshoshaSource)
                    .writeBy(dbb100032ReportSourceWriter);
            return dbb100032ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100033.getReportId().equals(出力帳票一覧.get帳票ID())) {
            new TokubetsuChoshuKaishiTsuchishoB5RenchoReport(編集後本算定通知書共通情報, 宛名連番, dbb100033NinshoshaSource).
                    writeBy(dbb100033ReportSourceWriter);
            return dbb100033ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100034.getReportId().equals(出力帳票一覧.get帳票ID())) {
            new TokubetsuChoshuKaishiTsuchishoSealerReport(編集後本算定通知書共通情報, dbb100034NinshoshaSource).
                    writeBy(dbb100034ReportSourceWriter);
            return dbb100034ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100035.getReportId().equals(出力帳票一覧.get帳票ID())) {
            new TokubetsuChoshuKaishiTsuchishoSealerRenchoReport(編集後本算定通知書共通情報, dbb100035NinshoshaSource).
                    writeBy(dbb100035ReportSourceWriter);
            return dbb100035ReportSourceWriter.pageCount().value();
        }
        return publish特徴開始通知書_その他(出力帳票一覧, 編集後本算定通知書共通情報);
    }

    private int publish特徴開始通知書_その他(HonsanteifukaBatchTyouhyou 出力帳票一覧, EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報) {
        if (ReportIdDBB.DBB100036.getReportId().equals(出力帳票一覧.get帳票ID())) {
            new TokubetsuChoshuKaishiTsuchishoB52Report(編集後本算定通知書共通情報, 宛名連番, 地方公共団体, dbb100036NinshoshaSource).
                    writeBy(dbb100036ReportSourceWriter);
            return dbb100036ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100037.getReportId().equals(出力帳票一覧.get帳票ID())) {
            new TokubetsuChoshuKaishiTsuchishoB52RenchoReport(編集後本算定通知書共通情報, 宛名連番, dbb100037NinshoshaSource).
                    writeBy(dbb100037ReportSourceWriter);
            return dbb100037ReportSourceWriter.pageCount().value();
        } else if (ReportIdDBB.DBB100038.getReportId().equals(出力帳票一覧.get帳票ID())) {
            IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー
                    = KaigoToiawasesakiSourceBuilderCreator.create(SubGyomuCode.DBB介護賦課, 出力帳票一覧.get帳票分類ID());
            CompKaigoToiawasesakiSource toiawasesakiSource = 介護問合せ先ソースビルダー.buildSource();
            new TokubetsuChoshuKaishiTsuchishoOverlayA4TateReport(編集後本算定通知書共通情報, 通知書定型文,
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
