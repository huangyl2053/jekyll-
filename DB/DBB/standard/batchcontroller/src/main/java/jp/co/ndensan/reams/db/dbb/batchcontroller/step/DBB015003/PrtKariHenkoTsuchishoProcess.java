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
import jp.co.ndensan.reams.db.dbb.business.core.karisanteiidotsuchisho.TsuchishoKyotsuEntity;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100010.KarisanteiHenkoTsuchishoB5YokoReport;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100011.KarisanteiHenkoTsuchishoA4TateReport;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200014.KariSanteigakuHenkoTsuchishoHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisantei.KariHenkoTsuchishoOutPutOrder;
import jp.co.ndensan.reams.db.dbb.business.report.karisantei.KariHenkoTsuchishoPageBreak;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiTsuchiShoKyotsuKomokuHenshu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB015003.TyouhyouEntity;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidotsuchisho.IdoOrZenkenFukaSelectParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt36002.KarisanteiIdoFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100010.KarisanteiHenkoTsuchishoB5YokoReportSource;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100011.KarisanteiHenkoTsuchishoA4TateReportSource;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200014.KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource;
import jp.co.ndensan.reams.db.dbb.service.core.karisanteiidotsuchisho.KarisanteiIdoTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.db.dbz.service.report.parts.kaigotoiawasesaki.KaigoToiawasesakiSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 「仮算定額変更通知書の発行」処理クラスです。
 *
 * @reamsid_L DBB-0890-030 xicongwang
 */
public class PrtKariHenkoTsuchishoProcess extends BatchProcessBase<HonsanteiTsuchishoTempEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "karisanteiidotsuchisho.IKarisanteiIdoFukaMapper.select全件賦課情報_変更");
    private static final ReportId 仮算定額変更通知書_帳票分類ID = new ReportId("DBB100010_KarisanteiHenkoTsuchishoDaihyo");
    private static final RString 定数_出力条件 = new RString("出力条件");
    private static final RString 定数_出力順 = new RString("出力順");
    private static final RString 定数_発行日 = new RString("発行日");
    private static final RString 定数_文書番号 = new RString("文書番号");
    private static final RString SIGN = new RString(" ＞ ");
    private static final RString FORMAT_LEFT = new RString("【");
    private static final RString FORMAT_RIGHT = new RString("】");
    private static final RString 定値_ゼロ = new RString("0");
    private static final RString CSV出力有無_なし = new RString("なし");
    private static final RString CSVファイル名 = new RString("-");
    private static final RString CSV出力有無_あり = new RString("あり");
    private static final RString カンマ = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final EucEntityId 変更_EUC_ENTITY_ID = new EucEntityId("DBB200014");
    private static final RString 変更_EUCファイル名 = new RString("KariSanteigakuHenkoTsuchishoHakkoIchiranData.csv");
    private static final RString CSVファイル名_変更一覧表 = new RString("仮算定額変更通知書発行一覧表");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private KarisanteiIdoFukaProcessParameter processParameter;

    private TyouhyouEntity 出力帳票一覧;
    private List<RString> 出力項目リスト;
    private List<RString> 改頁項目リスト;
    private RString 出力順;
    private RString 出力順１ = RString.EMPTY;
    private RString 出力順２ = RString.EMPTY;
    private RString 出力順３ = RString.EMPTY;
    private RString 出力順４ = RString.EMPTY;
    private RString 出力順５ = RString.EMPTY;
    private List<RString> pageBreakKeys;
    private List<RString> 出力条件リスト;
    private boolean データ有無区分;
    private RString 帳票名;
    private int 総ページ数;
    private int 連番;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private TsuchishoKyotsuEntity 通知書共通情報entity;
    private FileSpoolManager fileSpoolManager;
    private RString eucFilePath;
    private NinshoshaSource dbb100010NinshoshaSource;
    private NinshoshaSource dbb100011NinshoshaSource;
    private CompKaigoToiawasesakiSource kaigoToiawasesakiSource;
    private KarisanteiIdoTsuchishoIkkatsuHakko manager;
    private KariSanteiTsuchiShoKyotsuKomokuHenshu 仮算定共通情報作成;
    private KarisanteiIdoTsuchishoHakkoSyori karisanteiSyori;
    private Association 地方公共団体;

    private BatchReportWriter<KarisanteiHenkoTsuchishoB5YokoReportSource> dbb100010reportWriter;
    private ReportSourceWriter<KarisanteiHenkoTsuchishoB5YokoReportSource> dbb100010ReportSourceWriter;
    private BatchReportWriter<KarisanteiHenkoTsuchishoA4TateReportSource> dbb100011reportWriter;
    private ReportSourceWriter<KarisanteiHenkoTsuchishoA4TateReportSource> dbb100011ReportSourceWriter;

    private BatchReportWriter<KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource> 一覧表reportWriter;
    private ReportSourceWriter<KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource> 一覧表ReportSourceWriter;

    private CsvListWriter csvListWriter;

    @BatchWriter
    private BatchPermanentTableWriter permanentTableWriter;

    @Override
    protected void initialize() {

        manager = KarisanteiIdoTsuchishoIkkatsuHakko.createInstance();
        karisanteiSyori = new KarisanteiIdoTsuchishoHakkoSyori();
        仮算定共通情報作成 = InstanceProvider.create(KariSanteiTsuchiShoKyotsuKomokuHenshu.class);
        出力帳票一覧 = processParameter.get出力帳票一覧();
        帳票名 = manager.get帳票名_変更(出力帳票一覧.get帳票ID().getColumnValue());
        通知書共通情報entity = manager.get通知書共通情報(processParameter.get調定年度(), null);

        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();

        get出力条件リスト();

        帳票制御共通 = manager.load帳票制御共通(仮算定額変更通知書_帳票分類ID);

        kaigoToiawasesakiSource = KaigoToiawasesakiSourceBuilderCreator
                .create(SubGyomuCode.DBB介護賦課, 仮算定額変更通知書_帳票分類ID).buildSource();

    }

    @Override
    protected void createWriter() {

        initialize変更通知書();

        PageBreaker<KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource> breaker = new KariHenkoTsuchishoPageBreak(pageBreakKeys);
        一覧表reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB200014.getReportId().value()).addBreak(breaker).create();
        一覧表ReportSourceWriter = new ReportSourceWriter<>(一覧表reportWriter);

        fileSpoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                変更_EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = fileSpoolManager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 変更_EUCファイル名);
        csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(カンマ)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true).setHeader(karisanteiSyori.get仮算定額変更通知書発行一覧表タイトルList())
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
            Logger.getLogger(PrtKariHenkoTsuchishoProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        KariSanteiTsuchiShoKyotsu 仮算定通知書情報 = new KariSanteiTsuchiShoKyotsu();
        仮算定通知書情報.set発行日(new FlexibleDate(processParameter.get仮算定額変更_発行日().toDateString()));
        仮算定通知書情報.set帳票分類ID(仮算定額変更通知書_帳票分類ID);
        仮算定通知書情報.set帳票ID(出力帳票一覧.get帳票ID());
        仮算定通知書情報.set処理区分(ShoriKubun.バッチ);
        仮算定通知書情報.set地方公共団体(地方公共団体);
        仮算定通知書情報.set賦課の情報_更正前(tmpResult.get賦課の情報_更正前());
        仮算定通知書情報.set賦課の情報_更正後(tmpResult.get賦課の情報_更正後());
        仮算定通知書情報.set納組情報(tmpResult.get納組情報());
        仮算定通知書情報.set普徴納期情報リスト(通知書共通情報entity.get普徴納期情報リスト());
        仮算定通知書情報.set特徴納期情報リスト(通知書共通情報entity.get特徴納期情報リスト());
        仮算定通知書情報.set宛先情報(tmpResult.get宛先情報());
        仮算定通知書情報.set口座情報(tmpResult.get口座情報());
        仮算定通知書情報.set徴収方法情報_更正前(tmpResult.get徴収方法情報_更正前());
        仮算定通知書情報.set徴収方法情報_更正後(tmpResult.get徴収方法情報_更正後());
        仮算定通知書情報.set対象者_追加含む_情報_更正前(tmpResult.get対象者_追加含む_情報_更正前());
        仮算定通知書情報.set対象者_追加含む_情報_更正後(tmpResult.get対象者_追加含む_情報_更正後());
        仮算定通知書情報.set収入情報(tmpResult.get収入情報());
        仮算定通知書情報.set帳票制御共通(帳票制御共通);
        EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報 = 仮算定共通情報作成.create仮算定通知書共通情報(仮算定通知書情報);
        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報 = new KariSanteiNonyuTsuchiShoJoho();
        仮算定納入通知書情報.set発行日(new FlexibleDate(processParameter.get仮算定額変更_発行日().toDateString()));
        仮算定納入通知書情報.set帳票分類ID(仮算定額変更通知書_帳票分類ID);
        仮算定納入通知書情報.set帳票ID(出力帳票一覧.get帳票ID());
        仮算定納入通知書情報.set編集後仮算定通知書共通情報(編集後仮算定通知書共通情報);

        publish変更通知書(仮算定納入通知書情報);

        KariSanteigakuHenkoTsuchishoHakkoIchiranReport report
                = new KariSanteigakuHenkoTsuchishoHakkoIchiranReport(仮算定通知書情報, 編集後仮算定通知書共通情報,
                        出力順１, 出力順２, 出力順３, 出力順４, 出力順５, processParameter.get帳票作成日時().getRDateTime());
        report.writeBy(一覧表ReportSourceWriter);
        List<RString> bodyList = karisanteiSyori.get仮算定額変更通知書発行一覧表bodyList(processParameter.get調定年度(),
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
                    CSV出力有無_あり, CSVファイル名_変更一覧表, 帳票名);
        }
        close変更通知書();
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
        builder.append(FORMAT_LEFT.concat(定数_発行日).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(processParameter.get仮算定額変更_発行日().wareki().toDateString()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_文書番号).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(processParameter.get仮算定額変更_文書番号()));
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
            outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 仮算定額変更通知書_帳票分類ID,
                    Long.parseLong(出力帳票一覧.get出力順ID().toString()));
        }
        if (outputOrder != null) {
            出力順 = MyBatisOrderByClauseCreator.create(KariHenkoTsuchishoOutPutOrder.class, outputOrder);
            List<ISetSortItem> iSetSortItemList = outputOrder.get設定項目リスト();
            int 番号 = INT_0;
            for (ISetSortItem iSetSortItem : iSetSortItemList) {
                番号 = 番号 + INT_1;
                if (番号 == INT_1) {
                    出力順１ = iSetSortItem.get項目名();
                } else if (番号 == INT_2) {
                    出力順２ = iSetSortItem.get項目名();
                } else if (番号 == INT_3) {
                    出力順３ = iSetSortItem.get項目名();
                } else if (番号 == INT_4) {
                    出力順４ = iSetSortItem.get項目名();
                } else if (番号 == INT_5) {
                    出力順５ = iSetSortItem.get項目名();
                }
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

    private void publish変更通知書(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {

        if (ReportIdDBB.DBB100010.getReportId().equals(出力帳票一覧.get帳票ID())) {
            KarisanteiHenkoTsuchishoB5YokoReport report = new KarisanteiHenkoTsuchishoB5YokoReport(仮算定納入通知書情報,
                    processParameter.get仮算定額変更_文書番号(), dbb100010NinshoshaSource, kaigoToiawasesakiSource);
            report.writeBy(dbb100010ReportSourceWriter);
            総ページ数 = dbb100010reportWriter.getPageCount();
        } else if (ReportIdDBB.DBB100011.getReportId().equals(出力帳票一覧.get帳票ID())) {
            KarisanteiHenkoTsuchishoA4TateReport report = new KarisanteiHenkoTsuchishoA4TateReport(仮算定納入通知書情報,
                    processParameter.get仮算定額変更_文書番号(), dbb100011NinshoshaSource, kaigoToiawasesakiSource);
            report.writeBy(dbb100011ReportSourceWriter);
            総ページ数 = dbb100011reportWriter.getPageCount();
        }
    }

    private void initialize変更通知書() {
        if (ReportIdDBB.DBB100010.getReportId().equals(出力帳票一覧.get帳票ID())) {
            dbb100010reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100010.getReportId().value()).create();
            dbb100010ReportSourceWriter = new ReportSourceWriter<>(dbb100010reportWriter);
            dbb100010NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課,
                    仮算定額変更通知書_帳票分類ID,
                    new FlexibleDate(processParameter.get仮算定額変更_発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                    KenmeiFuyoKubunType.付与なし,
                    dbb100010ReportSourceWriter);
        } else if (ReportIdDBB.DBB100011.getReportId().equals(出力帳票一覧.get帳票ID())) {
            dbb100011reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100011.getReportId().value()).create();
            dbb100011ReportSourceWriter = new ReportSourceWriter<>(dbb100011reportWriter);
            dbb100011NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課,
                    仮算定額変更通知書_帳票分類ID,
                    new FlexibleDate(processParameter.get仮算定額変更_発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                    KenmeiFuyoKubunType.付与なし,
                    dbb100011ReportSourceWriter);
        }
    }

    private void close変更通知書() {
        if (ReportIdDBB.DBB100010.getReportId().equals(出力帳票一覧.get帳票ID())) {
            dbb100010reportWriter.close();
        } else if (ReportIdDBB.DBB100011.getReportId().equals(出力帳票一覧.get帳票ID())) {
            dbb100011reportWriter.close();
        }
    }
}
