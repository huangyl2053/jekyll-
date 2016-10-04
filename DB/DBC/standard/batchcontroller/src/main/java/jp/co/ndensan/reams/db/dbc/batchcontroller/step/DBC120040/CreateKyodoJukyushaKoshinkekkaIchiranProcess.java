/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushakoshinkekkain.KyodoJukyushaIchiranCSVData;
import jp.co.ndensan.reams.db.dbc.business.report.kyodojukyushakoshinkekkaichiran.KyodoJukyushaKoshinkekkaIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.core.chohyoseigyohanyo.ChohyoSeigyoHanyoKomokuMei;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyodojukyushakoshinkekkain.KyodoJukyushaKoshinKekkaInMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyodojukyushakoshinkekkain.KyodoJukyushaIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushakoshinkekkaichiran.KyodoJukyushaKoshinkekkaIchiranReportData;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushakoshinkekkain.KyodoJukyushaKoshinkekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyodojukyushakoshinkekkaichiran.KyodoJukyushaKoshinkekkaIchiranReportSource;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyodojukyushakoshinkekkain.IKyodoJukyushaKoshinKekkaInMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
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
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 共同処理用受給者情報一覧表Processクラスです。
 *
 * @reamsid_L DBC-2780-010 lishengli
 */
public class CreateKyodoJukyushaKoshinkekkaIchiranProcess extends BatchKeyBreakBase<KyodoJukyushaKoshinkekkaIchiranEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kyodojukyushakoshinkekkain.IKyodoJukyushaKoshinKekkaInMapper.帳票出力対象データ取得");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(KyodoJukyushaKoshinkekkaIchiranReportSource.ReportSourceFields.hokenshaNo.name())));
    private static final ReportId REPORT_DBC200057 = ReportIdDBC.DBC200057.getReportId();
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC200056"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private KyodoJukyushaIchiranCSVData kyodoJukyushaIchiranCSVData;
    private IKyodoJukyushaKoshinKekkaInMapper mapper;
    private RString eucFilename;
    private RString spoolWorkPath;
    private FileSpoolManager manager;
    private List<PersonalData> personalDataList;
    private List<ShikibetsuCode> 識別コードList;
    private RDateTime 作成日時;
    private boolean is1行目;
    private RString 帳票タイトル;
    @BatchWriter
    private BatchReportWriter<KyodoJukyushaKoshinkekkaIchiranReportSource> batchWrite;
    private ReportSourceWriter<KyodoJukyushaKoshinkekkaIchiranReportSource> reportSourceWriter;
    @BatchWriter
    private CsvWriter<KyodoJukyushaIchiranCSVEntity> eucCsvWriterJunitoJugo;

    @Override
    protected void initialize() {
        //TODO 出力順情報取得　関連展開待ち
        mapper = getMapper(IKyodoJukyushaKoshinKekkaInMapper.class);
        KyodoJukyushaKoshinKekkaInMybatisParameter parameter = new KyodoJukyushaKoshinKekkaInMybatisParameter();
        parameter.setSubGyomuCode(SubGyomuCode.DBC介護給付);
        parameter.setChohyoBunruiID(REPORT_DBC200057.value());
        parameter.setKanriNendo(new RString("0000"));
        parameter.setKomokuName(ChohyoSeigyoHanyoKomokuMei.帳票タイトル.get名称());
        帳票タイトル = mapper.帳票タイトルの取得(parameter);
        kyodoJukyushaIchiranCSVData = new KyodoJukyushaIchiranCSVData();
        作成日時 = RDate.getNowDateTime();
        is1行目 = true;
        personalDataList = new ArrayList<>();
        識別コードList = new ArrayList<>();
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        spoolWorkPath = manager.getEucOutputDirectry();
        eucFilename = Path.combinePath(spoolWorkPath, new RString("DBC200056_KyodoJukyushaKoshinkekkaIchiran.csv"));
        eucCsvWriterJunitoJugo = new CsvWriter.InstanceBuilder(eucFilename).
                setEncode(Encode.SJIS)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true).
                build();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBC200057.value())
                .addBreak(new BreakerCatalog<KyodoJukyushaKoshinkekkaIchiranReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void usualProcess(KyodoJukyushaKoshinkekkaIchiranEntity entity) {
        KyodoJukyushaKoshinkekkaIchiranReportData data = kyodoJukyushaIchiranCSVData.getReportData(entity);
        data.set帳票タイトル(帳票タイトル);
        KyodoJukyushaKoshinkekkaIchiranReport report = new KyodoJukyushaKoshinkekkaIchiranReport(data,
                ChohyoSeigyoHanyoKomokuMei.帳票タイトル_定期.get名称(),
                作成日時, null);
        report.writeBy(reportSourceWriter);
        KyodoJukyushaIchiranCSVEntity csvEntity = new KyodoJukyushaIchiranCSVData().getCSVEntity(data, is1行目, 作成日時);
        eucCsvWriterJunitoJugo.writeLine(csvEntity);
        if (entity.get識別コード() != null && !entity.get識別コード().isEmpty()
                && (!RString.isNullOrEmpty(entity.get宛名カナ名称()) || !RString.isNullOrEmpty(entity.get宛名名称()))
                && !識別コードList.contains(entity.get識別コード())) {
            ExpandedInformation expandedInformations = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                    entity.get被保険者番号().value());
            PersonalData personalData = PersonalData.of(entity.get識別コード(), expandedInformations);
            personalDataList.add(personalData);
            識別コードList.add(entity.get識別コード());
        }
        is1行目 = false;
    }

    @Override
    protected void keyBreakProcess(KyodoJukyushaKoshinkekkaIchiranEntity current) {
        hasBreak(getBefore(), current);
    }

    private boolean hasBreak(KyodoJukyushaKoshinkekkaIchiranEntity before, KyodoJukyushaKoshinkekkaIchiranEntity current) {
        return before.get保険者番号() != current.get保険者番号();
    }

    @Override
    protected void afterExecute() {
        eucCsvWriterJunitoJugo.close();
        AccessLogUUID id = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
        manager.spool(eucFilename, id);
    }
}
