/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120240;

import jp.co.ndensan.reams.db.dbc.business.report.seikyugakutsuchishokohifutanshabun.SeikyugakuTsuchishoKohifutanshabunReport;
import jp.co.ndensan.reams.db.dbc.business.report.seikyugakutsuchishokohiin.SeikyugakuTsuchishoKohiInPageBreak;
import jp.co.ndensan.reams.db.dbc.definition.processprm.seikyugakutsuchishokohiin.SeikyugakuTsuchishoKohiInProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.seikyugakutsuchishokohiin.SeikyugakuTsuchishoKohiInCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.seikyugakutsuchishokohifutanshabun.SeikyugakuTsuchishoKohifutanshabunSource;
import jp.co.ndensan.reams.db.dbc.service.core.seikyugakutsuchishokohiin.SeikyugakuTsuchishoKohiInCsvEditor;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * バッチ設計_DBCMNF2002-631_介護給付費等請求額通知書情報（公費）取込のProcessのクラス
 *
 * @reamsid_L DBC-2790-010 surun
 */
public class SeikyugakuTsuchishoKohiInProcess extends BatchKeyBreakBase<DbWT1511SeikyugakuTsuchishoTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "seikyugakutsuchishokohiin.ISeikyugakuTsuchishoKohiInMapper.get帳票出力対象データ");
    private SeikyugakuTsuchishoKohiInProcessParameter parameter;
    private RString eucFilePath;
    private static final RString 出力ファイル名 = new RString("DBC200067_SeikyugakuTsuchishoKohi.csv");
    private static final ReportId ID = ReportIdDBC.DBC200067.getReportId();
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final int ZERO_INDEX = 0;
    private static final int ONE_INDEX = 1;
    private RDateTime システム日時;
    private int index;

    @BatchWriter
    private CsvWriter<SeikyugakuTsuchishoKohiInCsvEntity> csvWriter;
    private BatchReportWriter<SeikyugakuTsuchishoKohifutanshabunSource> batchReportWriter;
    private ReportSourceWriter<SeikyugakuTsuchishoKohifutanshabunSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        システム日時 = parameter.getシステム日付();
        index = ZERO_INDEX;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        RString spoolWorkPath = Path.getTmpDirectoryPath();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        csvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
        SeikyugakuTsuchishoKohiInPageBreak breakPage = new SeikyugakuTsuchishoKohiInPageBreak();
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ID.value(), SubGyomuCode.DBC介護給付).addBreak(breakPage).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(DbWT1511SeikyugakuTsuchishoTempEntity entity) {
        SeikyugakuTsuchishoKohiInCsvEditor editor = new SeikyugakuTsuchishoKohiInCsvEditor();
        csvWriter.writeLine(editor.editor(index, entity, システム日時));
        index = index + ONE_INDEX;
        SeikyugakuTsuchishoKohifutanshabunReport report = new SeikyugakuTsuchishoKohifutanshabunReport(entity, システム日時);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        batchReportWriter.close();
    }

    @Override
    protected void keyBreakProcess(DbWT1511SeikyugakuTsuchishoTempEntity entity) {
    }

}
