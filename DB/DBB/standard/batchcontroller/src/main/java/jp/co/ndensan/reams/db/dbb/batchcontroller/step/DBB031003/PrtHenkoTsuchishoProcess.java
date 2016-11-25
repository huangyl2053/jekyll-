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
import jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoInfo;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempResult;
import jp.co.ndensan.reams.db.dbb.business.report.henkokenchushitsuchisho.KaigoHokenryogakuHenkoKenChushiTsuchishoBusiness;
import jp.co.ndensan.reams.db.dbb.business.report.henkokenchushitsuchisho.KaigoHokenryogakuHenkoKenChushiTsuchishoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.henkokenchushitsuchisho.a4tate.KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReport;
import jp.co.ndensan.reams.db.dbb.business.report.henkokenchushitsuchisho.b5yoko.KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReport;
import jp.co.ndensan.reams.db.dbb.business.report.honsantei.KaigoHokenryogakuOutPutOrder;
import jp.co.ndensan.reams.db.dbb.business.report.honsantei.KaigoHokenryogakuPageBreak;
import jp.co.ndensan.reams.db.dbb.business.report.kaigohokenryogakuketteihenkotsuchihakkoichiran.KaigoHokenryogakuReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiKetteiTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsuKomokuHenshu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka.HonsanteifukaBatchTyouhyou;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteitsuchishoikkatsuhakko.PrtKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt43002.HonsanteifukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.henkokenchushitsuchisho.KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReportSource;
import jp.co.ndensan.reams.db.dbb.entity.report.henkokenchushitsuchisho.KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReportSource;
import jp.co.ndensan.reams.db.dbb.entity.report.kaigohokenryogakuketteihenkotsuchihakkoichiran.KaigoHokenryogakuSource;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoToiawasesaki;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.KaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KaigoToiawasesakiManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
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
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 変更通知書の発行するクラスです。
 *
 * @reamsid_L DBB-0780-050 xicongwang
 */
public class PrtHenkoTsuchishoProcess extends BatchProcessBase<HonsanteiTsuchishoTempEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "honsanteitsuchishoikkatsuhakko.IHonsanteiTsuchishoIkkatsuHakkoMapper.select決定変更通知書");
    private static final RString 定値_変更区分 = new RString("2");
    private static final ReportId 決定変更通知書_帳票分類ID = new ReportId("DBB100039_KaigoHokenHokenryogakuKetteiTsuchishoDaihyo");
    private static final RString ソート = new RString("order by");
    private static final RString ソート順_昇順 = new RString("ASC");
    private static final RString 定値_出力順グループ指定 = new RString("出力順グループ指定");
    private static final RString FORMAT = new RString("\"");
    private static final RString 定数_出力条件 = new RString("出力条件");
    private static final RString 定数_出力順 = new RString("出力順");
    private static final RString 定数_発行日 = new RString("発行日");
    private static final RString 定数_文書番号 = new RString("文書番号");
    private static final RString FORMAT_LEFT = new RString("【");
    private static final RString FORMAT_RIGHT = new RString("】");
    private static final RString SIGN = new RString(" ＞ ");
    private static final RString 定値_ゼロ = new RString("0");
    private static final RString CSV出力有無_なし = new RString("なし");
    private static final RString CSVファイル名 = new RString("-");
    private static final RString CSV出力有無_あり = new RString("あり");
    private static final RString CSVファイル名_変更一覧表 = new RString("介護保険料額変更知書発行一覧表");
    private static final EucEntityId 変更_EUC_ENTITY_ID = new EucEntityId("DBB200030");
    private static final RString 変更_EUCファイル名 = new RString("KaigoHokenryogakuHenkoTsuchiHakkoIchiranData.csv");
    private static final RString カンマ = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 定値_タイトル = new RString("介護保険料額変更通知書発行一覧表");
    private HonsanteifukaProcessParameter processParameter;
    private PrtKetteiTsuchishoParameter myBatisParameter;
    private HonsanteiTsuchishoIkkatsuHakko manager;
    private HonsanteiTsuchishoIkkatsuHakkoSyori honsanteiSyori;
    private HonSanteiTsuchiShoKyotsuKomokuHenshu 本算定共通情報作成;
    private Association 地方公共団体;
    private NinshoshaSource dbb100042NinshoshaSource;
    private NinshoshaSource dbb100043NinshoshaSource;
    private CompKaigoToiawasesakiSource compKaigoToiawasesakiSource;

    private HonsanteifukaBatchTyouhyou 出力帳票一覧;
    private List<RString> 出力項目リスト;
    private List<RString> 改頁項目リスト;
    private RString 出力順;
    private List<RString> pageBreakKeys;
    private List<RString> 出力条件リスト;
    private boolean データ有無区分;
    private RString 帳票名;
    private int 総ページ数;
    private Decimal 連番;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private HonsanteiTsuchishoInfo 通知書共通情報entity;
    private FileSpoolManager fileSpoolManager;
    private RString eucFilePath;

    private BatchReportWriter<KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReportSource> dbb100042reportWriter;
    private ReportSourceWriter<KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReportSource> dbb100042ReportSourceWriter;
    private BatchReportWriter<KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReportSource> dbb100043reportWriter;
    private ReportSourceWriter<KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReportSource> dbb100043ReportSourceWriter;

    private BatchReportWriter<KaigoHokenryogakuSource> 一覧表reportWriter;
    private ReportSourceWriter<KaigoHokenryogakuSource> 一覧表ReportSourceWriter;

    private CsvListWriter csvListWriter;

    @BatchWriter
    private BatchPermanentTableWriter permanentTableWriter;

    @Override
    protected void initialize() {

        連番 = Decimal.ZERO;

        manager = HonsanteiTsuchishoIkkatsuHakko.createInstance();
        本算定共通情報作成 = InstanceProvider.create(HonSanteiTsuchiShoKyotsuKomokuHenshu.class);
        honsanteiSyori = new HonsanteiTsuchishoIkkatsuHakkoSyori();
        出力帳票一覧 = processParameter.get出力帳票一覧();
        帳票名 = manager.get帳票名_変更(出力帳票一覧.get帳票ID().getColumnValue());
        通知書共通情報entity = manager.get通知書共通情報(processParameter.get調定年度(), null);

        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();

        get出力条件リスト();

        帳票制御共通 = manager.load帳票制御共通(決定変更通知書_帳票分類ID);

        KaigoToiawasesakiManager kaigoToiawasesakiManager = new KaigoToiawasesakiManager();
        KaigoToiawasesaki kaigoToiawasesaki = kaigoToiawasesakiManager.get介護問合せ先(SubGyomuCode.DBB介護賦課, 決定変更通知書_帳票分類ID);
        KaigoToiawasesakiSourceBuilder builder = new KaigoToiawasesakiSourceBuilder(kaigoToiawasesaki);
        compKaigoToiawasesakiSource = builder.buildSource();

        myBatisParameter = PrtKetteiTsuchishoParameter.createSelectByKeyParam(定値_変更区分, 出力順);
    }

    @Override
    protected void createWriter() {

        initialize変更通知書();

        PageBreaker<KaigoHokenryogakuSource> breaker = new KaigoHokenryogakuPageBreak(pageBreakKeys);
        一覧表reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB200030.getReportId().value()).addBreak(breaker).create();
        一覧表ReportSourceWriter = new ReportSourceWriter<>(一覧表reportWriter);

        fileSpoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                変更_EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = fileSpoolManager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 変更_EUCファイル名);
        csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(カンマ)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true).setHeader(honsanteiSyori.get保険料額決定通知書発行一覧表タイトルList())
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

        HonsanteiTsuchishoTempResult tmpResult = new HonsanteiTsuchishoTempResult();
        try {
            tmpResult = manager.get賦課情報(tempEntity);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(PrtTokuchoKaishiTsuchishoHonsanteiProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        HonSanteiTsuchiShoKyotsu 本算定通知書情報 = new HonSanteiTsuchiShoKyotsu();
        本算定通知書情報.set発行日(processParameter.get決定変更_発行日());
        本算定通知書情報.set帳票分類ID(決定変更通知書_帳票分類ID);
        本算定通知書情報.set帳票ID(出力帳票一覧.get帳票ID());
        本算定通知書情報.set処理区分(ShoriKubun.バッチ);
        本算定通知書情報.set地方公共団体(地方公共団体);
        本算定通知書情報.set賦課の情報_更正前(tmpResult.get賦課の情報_更正前());
        本算定通知書情報.set賦課の情報_更正後(tmpResult.get賦課の情報_更正後());
        本算定通知書情報.set納組情報(tmpResult.get納組情報());
        本算定通知書情報.set普徴納期情報リスト(通知書共通情報entity.get普徴納期情報リスト());
        本算定通知書情報.set特徴納期情報リスト(通知書共通情報entity.get特徴納期情報リスト());
        本算定通知書情報.set宛先情報(tmpResult.get宛先情報());
        本算定通知書情報.set口座情報(tmpResult.get口座情報());
        本算定通知書情報.set徴収方法情報_更正前(tmpResult.get徴収方法情報_更正前());
        本算定通知書情報.set徴収方法情報_更正後(tmpResult.get徴収方法情報_更正後());
        本算定通知書情報.set対象者_追加含む_情報_更正前(tmpResult.get対象者_追加含む_情報_更正前());
        本算定通知書情報.set対象者_追加含む_情報_更正後(tmpResult.get対象者_追加含む_情報_更正後());
        本算定通知書情報.set収入情報(tmpResult.get収入情報());
        本算定通知書情報.set帳票制御共通(帳票制御共通);
        EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 = 本算定共通情報作成.create本算定通知書共通情報(本算定通知書情報);
        HonSanteiKetteiTsuchiShoJoho 本算定決定通知書情報 = new HonSanteiKetteiTsuchiShoJoho();
        本算定決定通知書情報.set現年度_過年度区分(GennenKanen.現年度);
        本算定決定通知書情報.set発行日(processParameter.get決定変更_発行日());
        本算定決定通知書情報.set帳票分類ID(決定変更通知書_帳票分類ID);
        本算定決定通知書情報.set帳票ID(出力帳票一覧.get帳票ID());
        本算定決定通知書情報.set編集後本算定通知書共通情報(編集後本算定通知書共通情報);
        本算定決定通知書情報.set宛先情報(tmpResult.get宛先情報());
        本算定決定通知書情報.set処理区分(ShoriKubun.バッチ);
        本算定決定通知書情報.set地方公共団体(地方公共団体);

        KaigoHokenryogakuHenkoKenChushiTsuchishoJoho 通知書情報 = new KaigoHokenryogakuHenkoKenChushiTsuchishoJoho();
        通知書情報.set文書番号(processParameter.get決定変更_文書番号());
        通知書情報.set本算定決定通知書情報(本算定決定通知書情報);

        総ページ数 = publish変更通知書(通知書情報);

        連番 = 連番.add(Decimal.ONE);
        KaigoHokenryogakuReport report = new KaigoHokenryogakuReport(tempEntity.get生活保護区分(),
                tempEntity.get特徴8月開始者区分(), tempEntity.get特徴10月開始者区分(), 本算定通知書情報, 編集後本算定通知書共通情報,
                processParameter.get帳票作成日時().getRDateTime(), 地方公共団体, 出力項目リスト, 連番, 定値_タイトル);
        report.writeBy(一覧表ReportSourceWriter);

        List<RString> bodyList = honsanteiSyori.get保険料額決定通知書発行一覧表bodyList(processParameter.get調定年度(),
                processParameter.get帳票作成日時().getRDateTime(), 編集後本算定通知書共通情報);
        csvListWriter.writeLine(bodyList);

        permanentTableWriter.insert(honsanteiSyori.insert通知書発行後異動者(processParameter.get帳票作成日時(),
                出力帳票一覧.get帳票ID(), tmpResult.get計算後情報_更正後(), 連番.intValue()));
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

    private int publish変更通知書(KaigoHokenryogakuHenkoKenChushiTsuchishoJoho 通知書情報) {

        List<KaigoHokenryogakuHenkoKenChushiTsuchishoBusiness> items = new ArrayList<>();
        KaigoHokenryogakuHenkoKenChushiTsuchishoBusiness business = new KaigoHokenryogakuHenkoKenChushiTsuchishoBusiness();
        business.set文書番号(通知書情報.get文書番号());
        business.set本算定決定通知書情報(通知書情報.get本算定決定通知書情報());
        business.set調定事由リスト(通知書情報.get調定事由リスト());
        business.setCompKaigoToiawasesakiSource(compKaigoToiawasesakiSource);

        if (ReportIdDBB.DBB100042.getReportId().equals(出力帳票一覧.get帳票ID())) {
            business.setNinshoshaSource(dbb100042NinshoshaSource);
            items.add(business);
            KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReport report = new KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReport(items);
            report.writeBy(dbb100042ReportSourceWriter);
            return dbb100042reportWriter.getPageCount();
        } else if (ReportIdDBB.DBB100043.getReportId().equals(出力帳票一覧.get帳票ID())) {
            business.setNinshoshaSource(dbb100043NinshoshaSource);
            items.add(business);
            KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReport report = new KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReport(items);
            report.writeBy(dbb100043ReportSourceWriter);
            return dbb100043reportWriter.getPageCount();
        }
        return 0;
    }

    private void get出力条件リスト() {
        出力条件リスト = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(定数_出力条件);
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_発行日).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(processParameter.get決定変更_発行日().wareki().toDateString()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_文書番号).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(RString.isNullOrEmpty(processParameter.get決定変更_文書番号()) ? RString.EMPTY : processParameter.get決定変更_文書番号()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_出力順).concat(FORMAT_RIGHT));
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = null;
        if (!RString.isNullOrEmpty(出力帳票一覧.get出力順ID())) {
            outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 決定変更通知書_帳票分類ID,
                    Long.parseLong(出力帳票一覧.get出力順ID().toString()));
        }

        出力順 = RString.EMPTY;
        出力項目リスト = new ArrayList();
        改頁項目リスト = new ArrayList();
        pageBreakKeys = new ArrayList<>();
        if (outputOrder != null) {
            出力順 = MyBatisOrderByClauseCreator.create(KaigoHokenryogakuOutPutOrder.class, outputOrder);
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
        RStringBuilder orderByClause = new RStringBuilder(ソート);
        orderByClause.append(RString.HALF_SPACE.concat(FORMAT).concat(定値_出力順グループ指定).concat(FORMAT)
                .concat(RString.HALF_SPACE).concat(ソート順_昇順));
        if (!RString.isNullOrEmpty(出力順)) {
            orderByClause.append(カンマ).append(RString.HALF_SPACE).append(出力順.replace(ソート, RString.EMPTY));
        }
        出力順 = orderByClause.toRString();
        出力条件リスト.add(builder.toRString());
    }

    private void initialize変更通知書() {
        if (ReportIdDBB.DBB100042.getReportId().equals(出力帳票一覧.get帳票ID())) {
            dbb100042reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100042.getReportId().value()).create();
            dbb100042ReportSourceWriter = new ReportSourceWriter<>(dbb100042reportWriter);
            dbb100042NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課,
                    決定変更通知書_帳票分類ID,
                    new FlexibleDate(processParameter.get決定変更_発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                    KenmeiFuyoKubunType.付与なし,
                    dbb100042ReportSourceWriter);
        } else if (ReportIdDBB.DBB100043.getReportId().equals(出力帳票一覧.get帳票ID())) {
            dbb100043reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100043.getReportId().value()).create();
            dbb100043ReportSourceWriter = new ReportSourceWriter<>(dbb100043reportWriter);
            dbb100043NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課,
                    決定変更通知書_帳票分類ID,
                    new FlexibleDate(processParameter.get決定変更_発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                    KenmeiFuyoKubunType.付与なし,
                    dbb100043ReportSourceWriter);
        }
    }

    private void close変更通知書() {
        if (ReportIdDBB.DBB100042.getReportId().equals(出力帳票一覧.get帳票ID())) {
            dbb100042reportWriter.close();
        } else if (ReportIdDBB.DBB100043.getReportId().equals(出力帳票一覧.get帳票ID())) {
            dbb100043reportWriter.close();
        }
    }

}
