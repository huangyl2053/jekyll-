/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120850;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.core.sogojigyohisaishinsaketteihokenshain.SogojigyohiSaishinsaKetteiHokenshaInOutPutOrder;
import jp.co.ndensan.reams.db.dbc.business.core.sogojigyohisaishinsaketteihokenshain.SogojigyohiSaishinsaKetteiHokenshaInPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohisaishinsaketteihokenshain.SogojigyohiSaishinsaKetteiHokenshaInReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.sogojigyohisaishinsaketteihokenshain.SogojigyohiSaishinsaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohisaishinsaketteihokenshain.SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohisaishinsaketteihokenshain.SogojigyohiSaishinsaKetteiHokenshaInEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.report.source.sogojigyohisaishinsaketteihokenshain.SogojigyohiSaishinsaKetteiHokenshaInSource;
import jp.co.ndensan.reams.db.dbc.service.core.sogojigyohisaishinsaketteihokenshain.SogojigyohiSaishinsaService;
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
 * 総合事業費再審査決定通知書情報取込（保険者分）のバッチ処理クラス.一覧表作成を実行する。
 *
 * @reamsid_L DBC-4680-030 wangxue
 */
public class SogojigyohiSaishinsaDoIchiranhyoSakuseiProcess extends
        BatchKeyBreakBase<SogojigyohiSaishinsaKetteiHokenshaInEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "sogojigyohisaishinsaketteihokenshain.ISogojigyohiSaishinsaKetteiHokenshaInMapper.get帳票出力対象データ");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC200080"));
    private static final RString 出力ファイル名
            = new RString("DBC200080_SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiran.csv");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString デフォルト出力順 = new RString(" ORDER BY DbWT3063.\"hdrShoHokenshaNo\" ASC ");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final int INT_1 = 1;
    private static final Code EUC_CODE = new Code("0003");
    private static final RString EUC_CODE_NAME = new RString("被保険者番号");

    private FileSpoolManager manager;
    private RString eucFilePath;
    private SogojigyohiSaishinsaDoIchiranhyoSakuseiProcessParameter parameter;
    private RString 出力順;
    private SogojigyohiSaishinsaService service;
    private Set<ShikibetsuCode> 識別コードset = new HashSet<>();
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private SogojigyohiSaishinsaKetteiHokenshaInEntity beforeEntity;
    private IOutputOrder 並び順;
    private List<RString> 改頁項目リスト;
    private int count;

    @BatchWriter
    private CsvWriter<SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranCSVEntity> eucCsvWriter;
    @BatchWriter
    private BatchReportWriter<SogojigyohiSaishinsaKetteiHokenshaInSource> batchReportWriter;
    private ReportSourceWriter<SogojigyohiSaishinsaKetteiHokenshaInSource> reportSourceWriter;

    @Override
    protected void initialize() {

        service = SogojigyohiSaishinsaService.createInstance();
        識別コードset = new HashSet<>();
        改頁項目リスト = new ArrayList<>();
        並び順 = get並び順();
        if (null == 並び順) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁項目リスト.add(item.get項目ID());
                }
            }
        }
        出力順 = get出力順();
        count = INT_1;
    }

    @Override
    protected IBatchReader createReader() {

        parameter.set出力順(出力順);
        return new BatchDbReader(MAPPERPATH, parameter.toパラメタ());
    }

    @Override
    protected void createWriter() {

        PageBreaker<SogojigyohiSaishinsaKetteiHokenshaInSource> breaker = new SogojigyohiSaishinsaKetteiHokenshaInPageBreak(改頁項目リスト);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200080.getReportId().value()).addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.SJIS).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void keyBreakProcess(SogojigyohiSaishinsaKetteiHokenshaInEntity entity) {
    }

    @Override
    protected void usualProcess(SogojigyohiSaishinsaKetteiHokenshaInEntity entity) {

        SogojigyohiSaishinsaKetteiHokenshaInReport report
                = new SogojigyohiSaishinsaKetteiHokenshaInReport(service.setItem(entity, 並び順, parameter.get処理年月(), count));
        report.writeBy(reportSourceWriter);
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
            personalDataList.add(getPersonalData(entity));
        }
        count = count + INT_1;
    }

    @Override
    protected void afterExecute() {

        if (null != beforeEntity) {
            eucCsvWriter.writeLine(service.to集計項目(beforeEntity));
        }
        eucCsvWriter.close();
        AccessLogUUID log = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
        manager.spool(eucFilePath, log);
    }

    private PersonalData getPersonalData(SogojigyohiSaishinsaKetteiHokenshaInEntity entity) {

        ExpandedInformation expandedInformations = new ExpandedInformation(EUC_CODE, EUC_CODE_NAME,
                entity.get被保険者番号().getColumnValue());
        return PersonalData.of(entity.get識別コード(), expandedInformations);
    }

    private IOutputOrder get並び順() {

        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outOrder = finder.get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200080.getReportId(),
                parameter.get出力順ID());
        return outOrder;
    }

    private RString get出力順() {
        RString outOrder = MyBatisOrderByClauseCreator.create(SogojigyohiSaishinsaKetteiHokenshaInOutPutOrder.class, 並び順);
        if (RString.isNullOrEmpty(outOrder)) {
            outOrder = デフォルト出力順;
        } else {
            List<RString> 出力順BODY = outOrder.split(EUC_WRITER_DELIMITER.toString());
            outOrder = デフォルト出力順;
            if (出力順BODY.size() > 1) {
                for (int i = 1; i < 出力順BODY.size(); i++) {
                    outOrder = outOrder.concat(EUC_WRITER_DELIMITER).concat(出力順BODY.get(i));
                }
            }
        }
        return outOrder;
    }
}
