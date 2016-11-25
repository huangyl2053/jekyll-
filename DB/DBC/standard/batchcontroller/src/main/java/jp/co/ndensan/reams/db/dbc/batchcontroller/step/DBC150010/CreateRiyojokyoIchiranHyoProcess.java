/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.riyojokyotokeihyomeisailist.RiyoJokyoIchiranOutput;
import jp.co.ndensan.reams.db.dbc.business.report.riyojokyoichiran.RiyoJokyoIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.RiyojokyoTokeihyo_MeisaiGokeiOutKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.RiyojokyoTokeihyo_ShutsuryokuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.Tokeihyo_CSVEditKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc150010.ShutsuRyokuDataSyotkuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc150010.CreateRiyojokyoIchiranHyoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1513RiyoJokyoTokeihyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.riyojokyotokeihyomeisailistsakusei.IRiyoJokyoIchiranEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.riyojokyoichiran.RiyoJokyoIchiranReportSource;
import jp.co.ndensan.reams.db.dbc.entity.report.riyojokyotokeihyo.RiyoJokyoIchiranEntity;
import jp.co.ndensan.reams.db.dbc.service.core.riyojokyotokeihyomeisailistsakusei.RiyoJokyoTokeihyoMeisaiListSakuseiService;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.business.core.mybatisorderbycreator.BreakPageCreator;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.BatchGyomuException;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.journal.JournalWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 利用状況一覧表作成のプロセスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
public class CreateRiyojokyoIchiranHyoProcess extends BatchKeyBreakBase<DbWT1513RiyoJokyoTokeihyoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.riyojokyotokeihyomeisailistsakusei.IRiyoJokyoTokeihyoMeisaiListSakuseiMapper.select帳票出力対象データ");
    private static final RString なし = new RString("なし");
    private static final RString あり = new RString("あり");
    private static final RString 旧市町村コード = new RString("000000");
    private static final RString ORDER_BY = new RString("order by");
    private static final RString 出力対象 = new RString("【出力対象】:");
    private static final RString ファイル名 = new RString("DBC200004_RiyoJokyoIchiran.csv");
    private static final RString コンマ = new RString(",");
    private static final RString EUCエンティティID = new RString("DBC200004");
    private static final RString EUCファイル名 = new RString("DBC200004_RiyoJokyoIchiran.csv");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString MESSAGE = new RString("帳票出力順の取得ができませんでした。");
    private static final RString 帳票出力順の取得 = new RString("帳票出力順の取得");
    private static final RString ログコード = new RString("0003");
    private static final RString ログ表示名 = new RString("被保険者番号");
    private RString 出力順1 = RString.EMPTY;
    private RString 出力順2 = RString.EMPTY;
    private RString 出力順3 = RString.EMPTY;
    private RString 出力順4 = RString.EMPTY;
    private RString 出力順5 = RString.EMPTY;
    private RString 改頁1 = RString.EMPTY;
    private RString 改頁2 = RString.EMPTY;
    private RString 改頁3 = RString.EMPTY;
    private RString 改頁4 = RString.EMPTY;
    private RString 改頁5 = RString.EMPTY;
    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private CreateRiyojokyoIchiranHyoProcessParameter parameter;
    private RString eucFilePath;
    private FileSpoolManager manager;
    @BatchWriter
    private BatchReportWriter<RiyoJokyoIchiranReportSource> 利用状況一覧表ReportWriter;
    private ReportSourceWriter<RiyoJokyoIchiranReportSource> 利用状況一覧表SourceWriter;
    @BatchWriter
    private CsvWriter<IRiyoJokyoIchiranEUCEntity> csvWriter;
    Map<RString, RString> 利用実人員集計用MAP;
    RiyoJokyoTokeihyoMeisaiListSakuseiService service;
    private static List<RString> pageBreakKeys;
    private static List<RString> 出力順List;
    private static List<RString> 改頁List;
    DbT7051KoseiShichosonMasterEntity 保険者情報;
    private List<PersonalData> personalDataList;
    int index;
    RString 識別コード;

    @Override
    protected void initialize() {
        service = RiyoJokyoTokeihyoMeisaiListSakuseiService.createInstance();
        出力順List = new ArrayList<>();
        改頁List = new ArrayList<>();
        保険者情報 = service.get保険者情報(parameter.get導入形態コード(), parameter.get市町村コード(), parameter.get旧市町村コード());
        get出力順項目();
        index = 0;
        識別コード = RString.EMPTY;
        personalDataList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        ShutsuRyokuDataSyotkuMybatisParameter mybatisParameter = new ShutsuRyokuDataSyotkuMybatisParameter();
        if (旧市町村コード.equals(parameter.get旧市町村コード())) {
            mybatisParameter.setSort旧市町村コード(true);
        } else {
            mybatisParameter.setSort旧市町村コード(false);
        }
        mybatisParameter.set出力順(get出力順());
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUCエンティティID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), EUCファイル名);
        csvWriter = BatchWriters.csvWriter(IRiyoJokyoIchiranEUCEntity.class)
                .filePath(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(Tokeihyo_CSVEditKubun.する.getコード().equals(parameter.get項目名付加()))
                .build();
        if (RiyojokyoTokeihyo_ShutsuryokuKubun.出力する.getコード().equals(parameter.get明細リスト出力区分())) {
            利用状況一覧表ReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200004.getReportId().value()).
                    addBreak(new BreakerCatalog<RiyoJokyoIchiranReportSource>().simplePageBreaker(pageBreakKeys)).create();
            利用状況一覧表SourceWriter = new ReportSourceWriter<>(利用状況一覧表ReportWriter);
        }
    }

    private RString get出力順() {
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder shutsuryokujunId = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC200004.getReportId(),
                Long.valueOf(parameter.get出力順ID().toString()));
        return MyBatisOrderByClauseCreator.create(RiyoJokyoIchiranOutput.BreakerFieldsEnum.class,
                shutsuryokujunId).replace(ORDER_BY, RString.EMPTY);
    }

    @Override
    protected void keyBreakProcess(DbWT1513RiyoJokyoTokeihyoEntity current) {
//        if (hasBrek(getBefore(), current) && RiyojokyoTokeihyo_ShutsuryokuKubun.出力する.getコード().equals(parameter.get明細リスト出力区分())) {
//            if (RiyojokyoTokeihyo_ShutsuryokuKubun.出力する.getコード().equals(parameter.get明細リスト出力区分())) {
//                RiyoJokyoIchiranEntity ichiranEntity = new RiyoJokyoIchiranEntity();
//                ichiranEntity.set保険者番号(保険者情報.getShoKisaiHokenshaNo().value());
//                ichiranEntity.set保険者名(保険者情報.getShichosonMeisho());
//                ichiranEntity.set旧市町村コード(parameter.get旧市町村コード());
//                ichiranEntity.set旧市町村名(parameter.get旧市町村名称());
//                ichiranEntity.set明細合計出力区分(parameter.get明細合計出力区分());
//                ichiranEntity.set帳票出力対象データリスト(current);
//                ichiranEntity.set並び順(出力順List);
//                ichiranEntity.set改頁(改頁List);
//                RiyoJokyoIchiranReport report = new RiyoJokyoIchiranReport(ichiranEntity);
//                report.writeBy(利用状況一覧表SourceWriter);
//            }
//        }
    }

    @Override
    protected void usualProcess(DbWT1513RiyoJokyoTokeihyoEntity entity) {
        index++;
        if (RiyojokyoTokeihyo_ShutsuryokuKubun.出力する.getコード().equals(parameter.get明細リスト出力区分())) {
            RiyoJokyoIchiranEntity ichiranEntity = new RiyoJokyoIchiranEntity();
            ichiranEntity.set保険者番号(保険者情報.getShoKisaiHokenshaNo().value());
            ichiranEntity.set保険者名(保険者情報.getShichosonMeisho());
            ichiranEntity.set旧市町村コード(parameter.get旧市町村コード());
            ichiranEntity.set旧市町村名(parameter.get旧市町村名称());
            ichiranEntity.set明細合計出力区分(parameter.get明細合計出力区分());
            ichiranEntity.set帳票出力対象データリスト(entity);
            ichiranEntity.set並び順(出力順List);
            ichiranEntity.set改頁(改頁List);
            RiyoJokyoIchiranReport report = new RiyoJokyoIchiranReport(ichiranEntity);
            report.writeBy(利用状況一覧表SourceWriter);
            if (!識別コード.equals(entity.getShikibetsuCode())) {
                ExpandedInformation expandedInformations = new ExpandedInformation(new Code(ログコード),
                        ログ表示名, entity.getHihokenshaNo());
                personalDataList.add(PersonalData.of(new ShikibetsuCode(entity.getShikibetsuCode()), expandedInformations));
            }
        }
        if (RiyojokyoTokeihyo_ShutsuryokuKubun.出力する.getコード().equals(parameter.get明細CSV出力区分())) {
            csvWriter.writeLine(service.createEUCEntity(保険者情報, entity, parameter, index));
        }
    }

    @Override
    protected void afterExecute() {
        if (RiyojokyoTokeihyo_ShutsuryokuKubun.出力する.getコード().equals(parameter.get明細CSV出力区分())) {
            csvWriter.close();
            AccessLogUUID id = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            manager.spool(eucFilePath, id);
        }
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        List<RString> outputJokenhyoList = service.getOutputJokenhyoParam(parameter);
        RStringBuilder builder = new RStringBuilder();
        builder.append(出力対象);
        builder.append(RiyojokyoTokeihyo_MeisaiGokeiOutKubun.toValue(parameter.get明細合計出力区分()).get名称());
        outputJokenhyoList.add(builder.toRString());
        RString csv出力有無;
        RString csvファイル名;
        if (RiyojokyoTokeihyo_ShutsuryokuKubun.出力する.getコード().equals(parameter.get明細CSV出力区分())) {
            csv出力有無 = あり;
            csvファイル名 = ファイル名;
        } else {
            csv出力有無 = なし;
            csvファイル名 = RString.EMPTY;
        }
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBC.DBC200004.getReportId().value(),
                Association.getLasdecCode().value(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBC.DBC200004.getReportName(),
                new RString(String.valueOf(利用状況一覧表SourceWriter.pageCount().value())),
                csv出力有無,
                csvファイル名,
                outputJokenhyoList);
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private void get出力順項目() {
        Map<Integer, ISetSortItem> 出力順Map = ReportUtil.get出力順項目(SubGyomuCode.DBC介護給付,
                Long.valueOf(parameter.get出力順ID().toString()),
                ReportIdDBC.DBC200004.getReportId());
        if (出力順Map.isEmpty()) {
            new JournalWriter().writeErrorJournal(RDateTime.now(), MESSAGE);
            throw new BatchGyomuException(UrErrorMessages.実行不可.getMessage().replace(
                    帳票出力順の取得.toString()));
        }
        Map<Integer, RString> 改頁Map = ReportUtil.get改頁項目(SubGyomuCode.DBC介護給付,
                Long.valueOf(parameter.get出力順ID().toString()),
                ReportIdDBC.DBC200004.getReportId());
        if (出力順Map.get(0) != null) {
            出力順1 = 出力順Map.get(0).get項目名();
        }
        if (出力順Map.get(1) != null) {
            出力順2 = 出力順Map.get(1).get項目名();
        }
        if (出力順Map.get(2) != null) {
            出力順3 = 出力順Map.get(2).get項目名();
        }
        if (出力順Map.get(INT3) != null) {
            出力順4 = 出力順Map.get(INT3).get項目名();
        }
        if (出力順Map.get(INT4) != null) {
            出力順5 = 出力順Map.get(INT4).get項目名();
        }
        改頁1 = 改頁Map.get(0);
        改頁2 = 改頁Map.get(1);
        改頁3 = 改頁Map.get(2);
        改頁4 = 改頁Map.get(INT3);
        改頁5 = 改頁Map.get(INT4);
        出力順List.add(出力順1);
        出力順List.add(出力順2);
        出力順List.add(出力順3);
        出力順List.add(出力順4);
        出力順List.add(出力順5);
        改頁List.add(改頁1);
        改頁List.add(改頁2);
        改頁List.add(改頁3);
        改頁List.add(改頁4);
        改頁List.add(改頁5);
        getPageBreakKeys();
    }

    private void getPageBreakKeys() {
        List<RString> pageBreakKeyList = new ArrayList<>();
        if (!RString.isNullOrEmpty(改頁1)) {
            pageBreakKeyList.add(BreakPageCreator.getBreakPageName(RiyoJokyoIchiranOutput.BreakPageRelateItem.class, 改頁1));
        }
        if (!RString.isNullOrEmpty(改頁2)) {
            pageBreakKeyList.add(BreakPageCreator.getBreakPageName(RiyoJokyoIchiranOutput.BreakPageRelateItem.class, 改頁2));
        }
        if (!RString.isNullOrEmpty(改頁3)) {
            pageBreakKeyList.add(BreakPageCreator.getBreakPageName(RiyoJokyoIchiranOutput.BreakPageRelateItem.class, 改頁3));
        }
        if (!RString.isNullOrEmpty(改頁4)) {
            pageBreakKeyList.add(BreakPageCreator.getBreakPageName(RiyoJokyoIchiranOutput.BreakPageRelateItem.class, 改頁4));
        }
        if (!RString.isNullOrEmpty(改頁5)) {
            pageBreakKeyList.add(BreakPageCreator.getBreakPageName(RiyoJokyoIchiranOutput.BreakPageRelateItem.class, 改頁5));
        }
        pageBreakKeyList.add(new RString(RiyoJokyoIchiranReportSource.KeyBreakItem.kyuShichoson.name()));
        pageBreakKeys = Collections.unmodifiableList(pageBreakKeyList);
    }
}
