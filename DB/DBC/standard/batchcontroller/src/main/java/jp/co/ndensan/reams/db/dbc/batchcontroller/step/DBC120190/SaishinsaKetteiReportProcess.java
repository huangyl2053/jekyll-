/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120190;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsaketteihokenshain.SaishinsaKetteiCSVDataCreate;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInOutPutOrder;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInReport;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsaketteihokenshain.SaishinsaKetteiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.saishinsaketteihokenshain.SaishinsaKetteitsuchishoCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain.SaishinsaKetteiResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.saishinsaketteihokenshain.SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource;
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
 * 一覧表作成を実行する。
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
public class SaishinsaKetteiReportProcess extends BatchKeyBreakBase<SaishinsaKetteiResultEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate"
            + ".saishinsaketteihokenshain.ISaishinsaKetteiHokenshaInMapper.get帳票出力対象データ");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC200048"));
    private static final RString 出力ファイル名
            = new RString("DBC200048_SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBun.csv");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final int INDEX_1 = 1;
    private static final int INDEX_5 = 5;
    private static final Code EUC_CODE = new Code("0003");
    private static final RString EUC_CODE_NAME = new RString("被保険者番号");

    private FileSpoolManager manager;
    private SaishinsaKetteiCSVDataCreate service;
    private RString eucFilePath;
    private SaishinsaKetteiProcessParameter parameter;
    private RString 出力順;
    private Set<ShikibetsuCode> 識別コードset = new HashSet<>();
    private List<PersonalData> personalDataList;
    private SaishinsaKetteiResultEntity beforeEntity;
    private IOutputOrder 並び順;
    private List<RString> 出力項目リスト;
    private List<RString> breakList;
    private int 連番;

    private CsvWriter<SaishinsaKetteitsuchishoCSVEntity> eucCsvWriter;
    @BatchWriter
    private BatchReportWriter<SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource> batchReportWriter;
    private ReportSourceWriter<SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource> reportSourceWriter;

    @Override
    protected void initialize() {

        service = SaishinsaKetteiCSVDataCreate.createInstance();
        personalDataList = new ArrayList<>();
        識別コードset = new HashSet<>();
        出力項目リスト = new ArrayList<>();
        breakList = new ArrayList<>();
        並び順 = get並び順();
        連番 = 0;
        if (null == 並び順) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        出力順 = MyBatisOrderByClauseCreator.create(SaishinsaKetteiHokenshaInOutPutOrder.class, 並び順);
        breakList.add(SaishinsaKetteiHokenshaInOutPutOrder.証記載保険者番号.get項目ID());
        int index = INDEX_1;
        for (ISetSortItem setSortItem : 並び順.get設定項目リスト()) {
            if (index <= INDEX_5) {
                出力項目リスト.add(setSortItem.get項目名());
            }
            index = index + INDEX_1;
        }
    }

    @Override
    protected IBatchReader createReader() {

        SaishinsaKetteiHokenshaInParameter mybatisParm = new SaishinsaKetteiHokenshaInParameter();
        mybatisParm.set出力順(出力順);
        return new BatchDbReader(MAPPERPATH, mybatisParm);
    }

    @Override
    protected void createWriter() {

        PageBreaker<SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource> breaker = new SaishinsaKetteiHokenshaInPageBreak(breakList);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200048.getReportId().value())
                .addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void keyBreakProcess(SaishinsaKetteiResultEntity entity) {
    }

    @Override
    protected void usualProcess(SaishinsaKetteiResultEntity entity) {

        boolean 集計flg = false;
        if (null != beforeEntity) {
            if (!beforeEntity.get証記載保険者番号().equals(entity.get証記載保険者番号())) {
                集計flg = true;
            }
            SaishinsaKetteiHokenshaInReport report = new SaishinsaKetteiHokenshaInReport(beforeEntity,
                    parameter.get処理年月(),
                    parameter.getシステム日付(),
                    出力項目リスト, 集計flg, 連番);
            report.writeBy(reportSourceWriter);
        }
        if (null == beforeEntity) {
            eucCsvWriter.writeLine(service.toヘッダのデータ(entity, parameter));
        } else {
            if (!beforeEntity.get証記載保険者番号().equals(entity.get証記載保険者番号())) {
                eucCsvWriter.writeLine(service.to集計項目(beforeEntity));
                eucCsvWriter.writeLine(service.to明細項目(entity));
            } else {
                eucCsvWriter.writeLine(service.to明細項目(entity));
            }
        }
        beforeEntity = entity;
        if (null != entity.get識別コード() && !entity.get識別コード().isEmpty()
                && !識別コードset.contains(entity.get識別コード())) {
            識別コードset.add(entity.get識別コード());
            personalDataList.add(toPersonalData(entity));
        }
        連番 = 連番 + INDEX_1;
    }

    @Override
    protected void afterExecute() {

        if (null != beforeEntity) {
            SaishinsaKetteiHokenshaInReport report = new SaishinsaKetteiHokenshaInReport(beforeEntity,
                    parameter.get処理年月(),
                    parameter.getシステム日付(),
                    出力項目リスト, true, 連番);
            report.writeBy(reportSourceWriter);
            eucCsvWriter.writeLine(service.to集計項目(beforeEntity));
        }
        eucCsvWriter.close();
        AccessLogUUID log = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
        manager.spool(eucFilePath, log);
    }

    private PersonalData toPersonalData(SaishinsaKetteiResultEntity entity) {

        ExpandedInformation expandedInformations = new ExpandedInformation(EUC_CODE, EUC_CODE_NAME,
                entity.get被保険者番号().getColumnValue());
        return PersonalData.of(entity.get識別コード(), expandedInformations);
    }

    private IOutputOrder get並び順() {

        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        if (parameter.get出力順ID() == null) {
            return null;
        }
        IOutputOrder outOrder = finder.get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200048.getReportId(),
                Long.valueOf(parameter.get出力順ID().toString()));
        return outOrder;
    }
}
