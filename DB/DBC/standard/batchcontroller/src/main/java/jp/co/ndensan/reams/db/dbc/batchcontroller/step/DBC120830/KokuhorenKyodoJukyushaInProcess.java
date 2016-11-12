/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120830;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushakoshinkekkain.KyodoJukyushaIchiranCSVData;
import jp.co.ndensan.reams.db.dbc.business.report.kyodojukyushakoshinkekkaichiran.KyodoJukyushaKoshinkekkaIchiranOutPutOrder;
import jp.co.ndensan.reams.db.dbc.business.report.kyodojukyushakoshinkekkaichiran.KyodoJukyushaKoshinkekkaIchiranPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.kyodojukyushakoshinkekkaichiran.KyodoJukyushaKoshinkekkaIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.core.chohyoseigyohanyo.ChohyoSeigyoHanyoKomokuMei;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyodojukyushakoshinkekkain.KyodoJukyushaKoshinKekkaInMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyodojukyushain.KokuhorenKyodoJukyushaInGetIdProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyodojukyushakoshinkekkain.KyodoJukyushaIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushakoshinkekkaichiran.KyodoJukyushaKoshinkekkaIchiranReportData;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushakoshinkekkain.KyodoJukyushaKoshinkekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyodojukyushakoshinkekkaichiran.KyodoJukyushaKoshinkekkaIchiranReportSource;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyodojukyushakoshinkekkain.IKyodoJukyushaKoshinKekkaInMapper;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
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
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 国保連保有共同処理用受給者情報一覧取込のバッチ処理フロー．一覧表作成を実行する
 *
 * @reamsid_L DBC-2920-010 liuxiaoyu
 */
public class KokuhorenKyodoJukyushaInProcess extends BatchKeyBreakBase<KyodoJukyushaKoshinkekkaIchiranEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
                    + "kokuhorenkyodojukyushain.IKokuhorenKyodoJukyushaInMapper.get帳票出力対象データ");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200057");
    private static final RString コンマ = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString KANRINENDO = new RString("0000");
    private static final RString 識別情報コード = new RString("0003");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private IOutputOrder 並び順;
    private List<RString> pageBreakKeys;
    private KokuhorenKyodoJukyushaInGetIdProcessParameter parameter;
    private KokuhorenIchiranhyoMybatisParameter 帳票データの取得Parameter;
    private KyodoJukyushaIchiranCSVData kyodoJukyushaIchiranCSVData;
    private IKyodoJukyushaKoshinKekkaInMapper mapper;
    private RString eucFilename;
    private RString spoolWorkPath;
    private FileSpoolManager manager;
    private List<PersonalData> personalDataList;
    private RDateTime 作成日時;
    private boolean is1行目;
    private RString 帳票タイトル;
    private List<ShikibetsuCode> 識別コードList;
    private static final RString 出力ファイル名
            = new RString("DBC200057_KyodoJukyushaIchiran.csv");
    private static final RString デフォルト出力順_1 = new RString(" dbWT0001.\"hihokenshaNo\" ASC ");
    private static final RString デフォルト出力順_2 = new RString(" dbWT5C30.\"idoYMD\" ASC ");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");

    @BatchWriter
    private BatchReportWriter<KyodoJukyushaKoshinkekkaIchiranReportSource> batchWrite;
    private ReportSourceWriter<KyodoJukyushaKoshinkekkaIchiranReportSource> reportSourceWriter;

    @BatchWriter
    private CsvWriter<KyodoJukyushaIchiranCSVEntity> eucCsvWriter;

    @Override
    protected void initialize() {
        mapper = getMapper(IKyodoJukyushaKoshinKekkaInMapper.class);
        KyodoJukyushaKoshinKekkaInMybatisParameter batisparameter = new KyodoJukyushaKoshinKekkaInMybatisParameter();
        batisparameter.setSubGyomuCode(SubGyomuCode.DBC介護給付);
        batisparameter.setChohyoBunruiID(ReportIdDBC.DBC200057.getReportId().value());
        batisparameter.setKanriNendo(KANRINENDO);
        batisparameter.setKomokuName(ChohyoSeigyoHanyoKomokuMei.帳票タイトル_随時.get名称());
        帳票タイトル = mapper.帳票タイトルの取得(batisparameter);
        作成日時 = RDate.getNowDateTime();
        is1行目 = true;
        personalDataList = new ArrayList<>();
        識別コードList = new ArrayList<>();
        pageBreakKeys = new ArrayList<>();
        帳票データの取得Parameter = new KokuhorenIchiranhyoMybatisParameter();
        kyodoJukyushaIchiranCSVData = new KyodoJukyushaIchiranCSVData();
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        並び順 = finder.get出力順(parameter.getサブ業務コード(), parameter.get帳票ID(),
                parameter.get出力順ID());
        if (null == 並び順) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        RString 出力順 = MyBatisOrderByClauseCreator
                .create(KyodoJukyushaKoshinkekkaIchiranOutPutOrder.class, 並び順);
        出力順 = 出力順.concat(コンマ).concat(デフォルト出力順_1);
        出力順 = 出力順.concat(コンマ).concat(デフォルト出力順_2);
        帳票データの取得Parameter.set出力順(出力順);
        pageBreakKeys.add(new RString(KyodoJukyushaKoshinkekkaIchiranReportSource.ReportSourceFields.hokenshaNo.name()));
        for (ISetSortItem item : 並び順.get設定項目リスト()) {
            if (item.is改頁項目()) {
                pageBreakKeys.add(item.get項目ID());
            }
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, 帳票データの取得Parameter);
    }

    @Override
    protected void createWriter() {
        PageBreaker<KyodoJukyushaKoshinkekkaIchiranReportSource> breaker
                = new KyodoJukyushaKoshinkekkaIchiranPageBreak(pageBreakKeys);
        batchWrite = BatchReportFactory.createBatchReportWriter(
                parameter.get帳票ID().value()).addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        spoolWorkPath = manager.getEucOutputDirectry();
        eucFilename = Path.combinePath(spoolWorkPath, 出力ファイル名);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilename).
                setEncode(Encode.SJIS)
                .setDelimiter(コンマ)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void usualProcess(KyodoJukyushaKoshinkekkaIchiranEntity entity) {
        KyodoJukyushaKoshinkekkaIchiranReportData data = kyodoJukyushaIchiranCSVData.getReportData(entity);
        data.set帳票タイトル(帳票タイトル);
        KyodoJukyushaKoshinkekkaIchiranReport report = new KyodoJukyushaKoshinkekkaIchiranReport(
                data,
                ChohyoSeigyoHanyoKomokuMei.帳票タイトル_随時.get名称(),
                作成日時,
                並び順);
        report.writeBy(reportSourceWriter);
        KyodoJukyushaIchiranCSVEntity csventity = new KyodoJukyushaIchiranCSVData().getCSVEntity(data, is1行目, 作成日時);
        eucCsvWriter.writeLine(csventity);
        if (entity.get識別コード() != null && !entity.get識別コード().isEmpty()
                && (!RString.isNullOrEmpty(entity.get宛名カナ名称()) || !RString.isNullOrEmpty(entity.get宛名名称()))
                && !識別コードList.contains(entity.get識別コード())) {
            ExpandedInformation expandedInformations = new ExpandedInformation(new Code(識別情報コード), 被保険者番号,
                    entity.get被保険者番号().value());
            PersonalData personalData = PersonalData.of(entity.get識別コード(), expandedInformations);
            personalDataList.add(personalData);
            識別コードList.add(entity.get識別コード());
        }
        is1行目 = false;
    }

    @Override
    protected void keyBreakProcess(KyodoJukyushaKoshinkekkaIchiranEntity current) {
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        AccessLogUUID id = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
        manager.spool(eucFilename, id);
    }
}
