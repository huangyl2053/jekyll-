/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.dbc200010.JukyushaIdorenrakuhyoSofuTaishoshachiranReport;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200010.JukyushaIdorenrakuhyoSofuTaishoshachiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.IdouSofuListTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200010.JukyushaIdorenrakuhyoSofuTaishoshachiranSource;
import jp.co.ndensan.reams.db.dbc.service.core.honnsanteifuka.HonnSanteiFukaManager;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 異動基本送付対象リストの帳票とCSVを出力するクラスです。
 *
 * @reamsid_L DBC-2770-050 jinjue
 */
public class IdouKihonSofuCsvProcess extends BatchProcessBase<IdouSofuListTempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.honnsanteifuka.IHonnSanteiFukaMapper.select送付対象リスト");
    private ReportSourceWriter<JukyushaIdorenrakuhyoSofuTaishoshachiranSource> reportSourceWriter;
    private static final int 市町村名称COUNT_0 = 0;
    private final RString 市町村コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード().value();
    private final RString 市町村名称 = KoikiShichosonJohoFinder.createInstance().koseiShichosonJoho().records().get(市町村名称COUNT_0).get市町村名称();
    private final RString csvFileName = new RString("JukyusyaIdouJohoSofuTaisyosyaList.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200010");
    private static final RString CSV_作成年月日 = new RString("作成年月日");
    private static final RString CSV_タイトル = new RString("タイトル");
    private static final RString CSV_市町村コード = new RString("市町村コード");
    private static final RString CSV_市町村名称 = new RString("市町村名称");
    private static final RString CSV_被保険者番号 = new RString("被保険者番号");
    private static final RString CSV_氏名 = new RString("氏名");
    private static final RString CSV_区分 = new RString("区分");
    private static final RString CSV_異動年月日 = new RString("異動年月日");
    private static final RString CSV_要介護度 = new RString("要介護度");
    private static final RString CSV_開始日 = new RString("開始認定日");
    private static final RString CSV_終了日 = new RString("終了認定日");
    private static final RString CSV_変更項目 = new RString("変更項目");
    private static final RString CSV_備考 = new RString("備考");
    private RString eucFilePath;
    private FileSpoolManager spoolManager;
    private CsvListWriter csvListWriter;
    @BatchWriter
    private BatchReportWriter<JukyushaIdorenrakuhyoSofuTaishoshachiranSource> batchWrite;
    private static final ReportId REPORT_DBC200010 = ReportIdDBC.DBC200010.getReportId();

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        spoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID,
                UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(spoolManager.getEucOutputDirectry(),
                csvFileName);
        csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true)
                .setHeader(getHeaderList())
                .build();
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBC200010.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(IdouSofuListTempEntity tempEntity) {
        JukyushaIdorenrakuhyoSofuTaishoshachiranEntity entity = new JukyushaIdorenrakuhyoSofuTaishoshachiranEntity();
        entity.set区分(tempEntity.get区分());
        entity.set変更項目(tempEntity.get変更項目());
        entity.set氏名(tempEntity.get氏名());
        entity.set異動年月日(tempEntity.get異動年月日());
        entity.set終了認定日(tempEntity.get終了認定日());
        entity.set被保険者番号(tempEntity.get被保険者番号());
        entity.set要介護度(tempEntity.get要介護度());
        entity.set開始認定日(tempEntity.get開始認定日());
        JukyushaIdorenrakuhyoSofuTaishoshachiranReport report = new JukyushaIdorenrakuhyoSofuTaishoshachiranReport(entity,
                市町村コード, 市町村名称);
        report.writeBy(reportSourceWriter);
        csvListWriter.writeLine(getBodyList(entity));
    }

    @Override
    protected void afterExecute() {
        csvListWriter.close();
        spoolManager.spool(eucFilePath);
        HonnSanteiFukaManager.createInstance().get基本送付出力用();
        HonnSanteiFukaManager.createInstance().get償還送付出力用();
        HonnSanteiFukaManager.createInstance().get高額送付出力用();
    }

    /**
     * CSVヘッダを設定します。
     *
     * @return {@link List<RString>}
     */
    public List<RString> getHeaderList() {
        List<RString> headerList = new ArrayList<>();
        headerList.add(CSV_作成年月日);
        headerList.add(CSV_タイトル);
        headerList.add(CSV_市町村コード);
        headerList.add(CSV_市町村名称);
        headerList.add(CSV_被保険者番号);
        headerList.add(CSV_氏名);
        headerList.add(CSV_区分);
        headerList.add(CSV_異動年月日);
        headerList.add(CSV_要介護度);
        headerList.add(CSV_開始日);
        headerList.add(CSV_終了日);
        headerList.add(CSV_変更項目);
        headerList.add(CSV_備考);
        return headerList;
    }

    /**
     * CSVレコードを取得します。
     *
     * @param entity JukyushaIdorenrakuhyoSofuTaishoshachiranEntity
     *
     * @return {@link List<RString>}
     */
    public List<RString> getBodyList(JukyushaIdorenrakuhyoSofuTaishoshachiranEntity entity) {
        List<RString> headerList = new ArrayList<>();
        headerList.add(dateChangeToRString(FlexibleDate.getNowDate()));
        headerList.add(new RString("受給者異動連絡票情報送付対象者リスト"));
        headerList.add(市町村コード);
        headerList.add(市町村名称);
        headerList.add(entity.get被保険者番号());
        headerList.add(entity.get氏名());
        headerList.add(entity.get区分());
        headerList.add(dateChangeToRString(entity.get異動年月日()));
        headerList.add(entity.get要介護度());
        headerList.add(dateChangeToRString(entity.get開始認定日()));
        headerList.add(dateChangeToRString(entity.get終了認定日()));
        headerList.add(entity.get変更項目());
        headerList.add(RString.EMPTY);
        return headerList;
    }

    private RString dateChangeToRString(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return new RString(date.toString());
    }
}
