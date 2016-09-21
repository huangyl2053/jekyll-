/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120880;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyoshikakushogohyoin.SogojigyohiShikakuShogohyoPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyoshikakushogohyoin.SogojigyohiShikakuShogohyoReport;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyoshikakushogohyoin.SogojigyohiShikakuShogohyoInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.sogojigyoshikakushogohyoin.SogojigyohiShikakuShogohyoInSource;
import jp.co.ndensan.reams.db.dbc.service.core.sogojigyoshikakushogohyoin.SogojigyohiShikakuShogohyoDoSakuseiService;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
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
 * 総合事業費資格照合表情報取込の帳票生成Processです。
 *
 * @reamsid_L DBC-2890-012 wangxue
 */
public class SogojigyohiShikakuDoIchiranhyoSakuseiProcess
        extends BatchKeyBreakBase<SogojigyohiShikakuShogohyoInEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "sogojigyoshikakushogohyoin.ISogojigyohiShikakuShogohyoInMapper.get帳票出力対象データ");
    private static final RString 市町村セキュリティ情報の取得実行不可 = new RString("市町村セキュリティ情報の取得");
    private static final RString CSVファイル名 = new RString("DBC100099_SogojigyohiShikakuShogohyo.csv");
    private static final RString カンマ = new RString(",");
    private static final RString WRITER_ENCLOSURE = new RString("\"");
    private static final RString EUC_ENTITY_ID = new RString("DBC100099");
    private static final Code EXPANDED_CODE = new Code("0003");
    private static final RString EXPANDED_NAME = new RString("被保険者番号");
    private static final RString 固定改頁項目 = new RString("保険者番号");
    private static final int INDEX_1 = 1;

    private ShichosonSecurityJoho 市町村セキュリティ;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private SogojigyohiShikakuShogohyoDoSakuseiService service;
    private Set<ShikibetsuCode> 識別コードset;
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private List<RString> pageBreakKeys;
    private int 合計件数;
    private SogojigyohiShikakuShogohyoInEntity lastEntity;
    private RDateTime システム日付;
    private int 連番;

    @BatchWriter
    private CsvWriter csvWriter;
    @BatchWriter
    private BatchReportWriter<SogojigyohiShikakuShogohyoInSource> batchReportWriter;
    private ReportSourceWriter<SogojigyohiShikakuShogohyoInSource> reportSourceWriter;

    @Override
    protected void initialize() {

        合計件数 = INDEX_1;
        連番 = INDEX_1;
        システム日付 = RDateTime.now();
        pageBreakKeys = new ArrayList<>();
        識別コードset = new HashSet<>();
        service = SogojigyohiShikakuShogohyoDoSakuseiService.createInstance();
        ShichosonSecurityJohoFinder 市町村finder = ShichosonSecurityJohoFinder.createInstance();
        市町村セキュリティ = 市町村finder.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (null == 市町村セキュリティ) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(市町村セキュリティ情報の取得実行不可.toString()).toString());
        }
    }

    @Override
    protected IBatchReader createReader() {

        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void createWriter() {

        pageBreakKeys.add(固定改頁項目);
        PageBreaker<SogojigyohiShikakuShogohyoInSource> breaker = new SogojigyohiShikakuShogohyoPageBreak(pageBreakKeys);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100099.getReportId().value())
                .addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, CSVファイル名);
        csvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(カンマ).
                setEnclosure(WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();

    }

    @Override
    protected void keyBreakProcess(SogojigyohiShikakuShogohyoInEntity entity) {
    }

    @Override
    protected void usualProcess(SogojigyohiShikakuShogohyoInEntity entity) {

        SogojigyohiShikakuShogohyoInEntity beforeEntity = getBefore();
        if (null != beforeEntity) {
            beforeEntity.set連番(連番 - INDEX_1);
            if (!beforeEntity.get資格照合_保険者番号().equals(entity.get資格照合_保険者番号())) {
                SogojigyohiShikakuShogohyoReport report = new SogojigyohiShikakuShogohyoReport(beforeEntity,
                        市町村セキュリティ.get導入形態コード(), システム日付, true, 合計件数);
                report.writeBy(reportSourceWriter);
                合計件数 = 1;
            } else {
                SogojigyohiShikakuShogohyoReport report = new SogojigyohiShikakuShogohyoReport(beforeEntity,
                        市町村セキュリティ.get導入形態コード(), システム日付, false, 合計件数);
                report.writeBy(reportSourceWriter);
                合計件数 = 合計件数 + 1;
            }
        }
        entity.set連番(連番);
        lastEntity = entity;
        if (市町村セキュリティ.get導入形態コード().is広域()) {
            csvWriter.writeLine(service.getCsvEntity(entity, システム日付));
        } else {
            csvWriter.writeLine(service.get単一CsvEntity(entity, システム日付));
        }

        連番 = 連番 + INDEX_1;
        if (null != entity.get識別コード() && !entity.get識別コード().isEmpty()
                && !識別コードset.contains(entity.get識別コード())) {
            識別コードset.add(entity.get識別コード());
            personalDataList.add(getPersonalData(entity));
        }
    }

    @Override
    protected void afterExecute() {

        if (null != lastEntity) {
            SogojigyohiShikakuShogohyoReport report = new SogojigyohiShikakuShogohyoReport(lastEntity,
                    市町村セキュリティ.get導入形態コード(), システム日付, true, 合計件数);
            report.writeBy(reportSourceWriter);
        }
        csvWriter.close();
        if (null != personalDataList) {
            AccessLogUUID log = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            manager.spool(eucFilePath, log);
        } else {
            manager.spool(eucFilePath);
        }
    }

    private PersonalData getPersonalData(SogojigyohiShikakuShogohyoInEntity entity) {

        ExpandedInformation expandedInformations = new ExpandedInformation(EXPANDED_CODE, EXPANDED_NAME,
                entity.get被保険者_被保険者番号().getColumnValue());
        return PersonalData.of(entity.get識別コード(), expandedInformations);
    }

}
