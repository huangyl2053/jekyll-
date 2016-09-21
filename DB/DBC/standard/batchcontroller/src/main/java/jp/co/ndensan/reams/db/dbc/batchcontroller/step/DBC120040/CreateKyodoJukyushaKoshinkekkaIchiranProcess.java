/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushakoshinkekkain.KyodoJukyushaIchiranCSVData;
import jp.co.ndensan.reams.db.dbc.business.report.kyodojukyushakoshinkekkaichiran.KyodoJukyushaKoshinkekkaIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.core.chohyoseigyohanyo.ChohyoSeigyoHanyoKomokuMei;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyodojukyushakoshinkekkain.KyodoJukyushaIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushakoshinkekkaichiran.KyodoJukyushaKoshinkekkaIchiranReportData;
import jp.co.ndensan.reams.db.dbc.entity.report.kyodojukyushakoshinkekkaichiran.KyodoJukyushaKoshinkekkaIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
 * 共同処理用受給者情報一覧表Processクラスです。
 *
 * @reamsid_L DBC-2780-010 lishengli
 */
public class CreateKyodoJukyushaKoshinkekkaIchiranProcess extends BatchKeyBreakBase<KyodoJukyushaKoshinkekkaIchiranReportData> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kyodojukyushakoshinkekkain.IKyodoJukyushaKoshinKekkaInMapper.帳票出力対象データ取得");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(KyodoJukyushaKoshinkekkaIchiranReportSource.ReportSourceFields.hokenshaNo.name())));
    private static final ReportId REPORT_DBC200057 = ReportIdDBC.DBC200057.getReportId();
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC200057"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private RString eucFilename;
    private RString spoolWorkPath;
    private FileSpoolManager manager;
    private List<PersonalData> personalDataList;
    private Map<RString, RString> 識別コードと被保険者番号;
    private RDateTime 作成日時;
    private boolean is1行目;
    @BatchWriter
    private BatchReportWriter<KyodoJukyushaKoshinkekkaIchiranReportSource> batchWrite;
    private ReportSourceWriter<KyodoJukyushaKoshinkekkaIchiranReportSource> reportSourceWriter;
    @BatchWriter
    private CsvWriter<KyodoJukyushaIchiranCSVEntity> eucCsvWriterJunitoJugo;

    @Override
    protected void initialize() {
        //TODO 出力順情報取得　関連展開待ち
        作成日時 = RDate.getNowDateTime();
        is1行目 = true;
        personalDataList = new ArrayList<>();
        識別コードと被保険者番号 = new HashMap<>();
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        spoolWorkPath = manager.getEucOutputDirectry();
        eucFilename = Path.combinePath(spoolWorkPath, new RString("DBC200057_KyodoJukyushaIchiran.csv"));
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
    protected void usualProcess(KyodoJukyushaKoshinkekkaIchiranReportData data) {
        KyodoJukyushaKoshinkekkaIchiranReport report = new KyodoJukyushaKoshinkekkaIchiranReport(data,
                ChohyoSeigyoHanyoKomokuMei.帳票タイトル_定期.get名称(),
                作成日時, null);
        report.writeBy(reportSourceWriter);
        KyodoJukyushaIchiranCSVEntity entity = new KyodoJukyushaIchiranCSVData().getCSVEntity(data, is1行目, 作成日時);
        eucCsvWriterJunitoJugo.writeLine(entity);
        RString key = getKey(data.get被保険者一時TBL().get識別コード(), data.get被保険者一時TBL().get被保険者番号());
        if (data.get被保険者一時TBL().get識別コード() != null && !data.get被保険者一時TBL().get識別コード().isEmpty()
                && 識別コードと被保険者番号.containsKey(key)) {
            ExpandedInformation expandedInformations = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                    data.get被保険者一時TBL().get被保険者番号().value());
            PersonalData personalData = PersonalData.of(data.get被保険者一時TBL().get識別コード(), expandedInformations);
            personalDataList.add(personalData);
            識別コードと被保険者番号.put(key, key);
        }
        is1行目 = false;
    }

    @Override
    protected void keyBreakProcess(KyodoJukyushaKoshinkekkaIchiranReportData current) {
        hasBreak(getBefore(), current);
    }

    private boolean hasBreak(KyodoJukyushaKoshinkekkaIchiranReportData before, KyodoJukyushaKoshinkekkaIchiranReportData current) {
        return before.get共同処理一時TBL().get保険者番号() != current.get共同処理一時TBL().get保険者番号();
    }

    @Override
    protected void afterExecute() {
        eucCsvWriterJunitoJugo.close();
        AccessLogUUID id = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
        manager.spool(eucFilename, id);
    }

    private RString getKey(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        RStringBuilder key = new RStringBuilder();
        if (識別コード != null && !識別コード.isEmpty()) {
            key.append(識別コード);
        }
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            key.append(被保険者番号);
        }
        return key.toRString();
    }
}
