/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030;

import jp.co.ndensan.reams.db.dbc.business.core.honnsanteifuka.KyodoShoriKihonSofuBusiness;
import jp.co.ndensan.reams.db.dbc.business.report.dbc200095.KokuhorenSofuDataErrorIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.honnsanteifuka.HonnsanteiFukaProcessParamter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.kunihosorensofudata.IKuniHoSorenSofuDataCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka.SofuEraRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200095.KokuhorenSofuDataErrorIchiranSource;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
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
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 送付エラーリストの帳票とCSVを出力を実行する。
 *
 * @reamsid_L DBC-2770-050 zhangzhiming
 */
public class ErarisutoProcess extends BatchProcessBase<SofuEraRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.honnsanteifuka."
            + "IHonnSanteiFukaMapper.select送付エラーデータ");
    private HonnsanteiFukaProcessParamter processParameter;
    private RString eucFilePath;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC110030");
    private final RString csvFileName = new RString("SofuDataErroriList.csv");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private int 連番;
    private RString 市町村コード = RString.EMPTY;
    private RString 市町村名称 = RString.EMPTY;
    private FileSpoolManager spoolManager;
    @BatchWriter
    private CsvWriter<IKuniHoSorenSofuDataCsvEntity> csvListWriter;
    private static final ReportId REPORT_DBC200095 = ReportIdDBC.DBC200095.getReportId();
    @BatchWriter
    private BatchReportWriter<KokuhorenSofuDataErrorIchiranSource> batchWrite;
    private ReportSourceWriter<KokuhorenSofuDataErrorIchiranSource> reportSourceWriter;
    private KyodoShoriKihonSofuBusiness business;

    @Override
    protected void initialize() {
        市町村コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード().value();
        市町村名称 = KoikiShichosonJohoFinder.createInstance().koseiShichosonJoho().records().get(0).get市町村名称();
        連番 = 0;
        business = new KyodoShoriKihonSofuBusiness();
    }

    @Override
    protected void createWriter() {
        spoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID,
                UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(spoolManager.getEucOutputDirectry(), csvFileName);
        csvListWriter = BatchWriters.csvWriter(IKuniHoSorenSofuDataCsvEntity.class)
                .filePath(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBC200095.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(SofuEraRelateEntity entity) {
        連番++;
        KokuhorenSofuDataErrorIchiranReport report = new KokuhorenSofuDataErrorIchiranReport(business
                .set帳票出力対象データ(entity, processParameter.get処理対象年月()), 市町村コード, 市町村名称, 連番);
        report.writeBy(reportSourceWriter);
        csvListWriter.writeLine(business.setファイル出力(entity, 市町村コード, 市町村名称, 連番, processParameter.get処理対象年月()));
    }

    @Override
    protected void afterExecute() {
        csvListWriter.close();
        spoolManager.spool(eucFilePath);
    }
}
