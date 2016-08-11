/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.futanwariaishohakkoichiran.FutanWariaiShoHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbc.business.report.futanwariaishokattokami.FutanWariaiShoKattokamiProperty;
import jp.co.ndensan.reams.db.dbc.business.report.saishinsa.SaishinsaKetteiTsuchishoIchiranKohifutanshaProperty;
import jp.co.ndensan.reams.db.dbc.definition.processprm.futanwariaishohakko.FutanwariaishoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.FutanwariaiShoHakkoIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.ShoriKekkaKakuninListCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaishohakko.RiyoshaFutanwariaishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishohakkoichiran.FutanWariaiShoHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishohakkoichiran.FutanWariaiShoHakkoIchiranSource;
import jp.co.ndensan.reams.db.dbc.service.core.futanwariaishoikkatsu.FutanWariaishoIkkatsu;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 負担割合証発行一覧のProcessクラスです。
 *
 * @reamsid_L DBC-4990-030 pengxingyi
 */
public class FutanWariaiShoHakkoIchiranOutputProcess extends BatchProcessBase<RiyoshaFutanwariaishoTempEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.futanwariaishohakko.IFutanwariaishoHakkoMapper.select利用者負担割合証");
    private FutanwariaishoHakkoProcessParameter parameter;
    private FutanWariaishoIkkatsu service;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private int 連番;
    private IOutputOrder 出力順;
    private RString ソート順１;
    private RString ソート順２;
    private RString ソート順３;
    private RString ソート順４;
    private RString ソート順５;
    private int ページ;
    List<RString> 出力順BODY;
    private final List<PersonalData> personalDataList = new ArrayList<>();
    @BatchWriter
    private BatchReportWriter<FutanWariaiShoHakkoIchiranSource> batchReportWriter;
    private ReportSourceWriter<FutanWariaiShoHakkoIchiranSource> reportSourceWriter;

    @BatchWriter
    BatchPermanentTableWriter riyoshaFutanWariaiWriter;

    private static final RString コンマ = new RString(",");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString ORDERBY = new RString("order by");
    private static final int NUM_ONE = 1;
    private static final int NUM_TWO = 2;
    private static final int NUM_THREE = 3;
    private static final int NUM_FOUR = 4;
    private static final RString 確認内容 = new RString("資格喪失している、負担割合証を発行しませんでした。");
    FileSpoolManager futanwariaiShoHakkoIchiranManager;
    FileSpoolManager shoriKekkaKakuninListManager;
    @BatchWriter
    private CsvWriter<FutanwariaiShoHakkoIchiranCSVEntity> futanwariaiShoHakkoIchiranEucCsvWriter;
    @BatchWriter
    private CsvWriter<ShoriKekkaKakuninListCSVEntity> shoriKekkaKakuninListEucCsvWriter;

    private static final EucEntityId FUATANWARIAI_EUC_ENTITY_ID = new EucEntityId(new RString("DBC200090"));
    private RString futanwariaiShoHakkoIchiranEucFilePath;
    private final RString futanwariaiShoHakkoIchiranFileName = new RString("DBC200090_FutanWariaiShoHakkoIchiran.csv");
    private static final EucEntityId SHORIKEKKA_EUC_ENTITY_ID = new EucEntityId(new RString("DBU900002"));
    private RString shoriKekkaKakuninListEucFilePath;
    private final RString shoriKekkaKakuninListFileName = new RString("DBC900002_ShoriKekkaKakuninList.csv");

    @Override
    protected void initialize() {
        連番 = 1;
        service = new FutanWariaishoIkkatsu();
        帳票制御共通 = new ChohyoSeigyoKyotsu(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200090.getReportId());
        出力順BODY = new ArrayList<>();
        if (!RString.isNullOrEmpty(parameter.get出力順()) && !ZERO.equals(parameter.get出力順())) {
            IChohyoShutsuryokujunFinder iChohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
            出力順 = iChohyoShutsuryokujunFinder.get出力順(SubGyomuCode.FCZ医療費共通,
                    ReportIdDBC.DBC100065.getReportId(), Long.valueOf(parameter.get出力順().toString()));
            if (出力順 != null) {
                parameter.set出力順(MyBatisOrderByClauseCreator.create(
                        FutanWariaiShoKattokamiProperty.DBB100065ShutsuryokujunEnum.class, 出力順));
            } else {
                parameter.set出力順(null);
            }
            出力順BODY = MyBatisOrderByClauseCreator.create(
                    SaishinsaKetteiTsuchishoIchiranKohifutanshaProperty.KagoKetteiKohifutanshaInBreakerFieldsEnum.class, 出力順)
                    .replace(ORDERBY, RString.EMPTY).split(コンマ.toString());
        }
        setソート順(出力順BODY);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200090.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        riyoshaFutanWariaiWriter = new BatchPermanentTableWriter(DbT3113RiyoshaFutanWariaiEntity.class);

        futanwariaiShoHakkoIchiranManager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, FUATANWARIAI_EUC_ENTITY_ID,
                UzUDE0831EucAccesslogFileType.Csv);
        futanwariaiShoHakkoIchiranEucFilePath = Path.combinePath(futanwariaiShoHakkoIchiranManager.getEucOutputDirectry(),
                futanwariaiShoHakkoIchiranFileName);
        futanwariaiShoHakkoIchiranEucCsvWriter = BatchWriters.csvWriter(FutanwariaiShoHakkoIchiranCSVEntity.class).
                filePath(futanwariaiShoHakkoIchiranEucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();

        shoriKekkaKakuninListManager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, SHORIKEKKA_EUC_ENTITY_ID,
                UzUDE0831EucAccesslogFileType.Csv);
        shoriKekkaKakuninListEucFilePath = Path.combinePath(shoriKekkaKakuninListManager.getEucOutputDirectry(),
                shoriKekkaKakuninListFileName);
        shoriKekkaKakuninListEucCsvWriter = BatchWriters.csvWriter(ShoriKekkaKakuninListCSVEntity.class).
                filePath(shoriKekkaKakuninListEucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void process(RiyoshaFutanwariaishoTempEntity entity) {
        FutanWariaiShoHakkoIchiranEntity futanWariaiShoHakkoIchiranEntity = service.getHakkoIchiranSourceData(帳票制御共通,
                entity, parameter, ソート順１, コンマ, ソート順１, ソート順２, ソート順３, ソート順４, ソート順５,
                new RString(ページ), parameter.getバッチ起動時処理日時(), new RString(連番));
        FutanWariaiShoHakkoIchiranReport report = new FutanWariaiShoHakkoIchiranReport(futanWariaiShoHakkoIchiranEntity);
        report.writeBy(reportSourceWriter);
        FutanwariaiShoHakkoIchiranCSVEntity futanwariaiShoHakkoIchiranCSVEntity
                = service.getHakkoIchiranCSVData(帳票制御共通, entity, new RString(連番));
        futanwariaiShoHakkoIchiranEucCsvWriter.writeLine(futanwariaiShoHakkoIchiranCSVEntity);
        if (entity.get被保台帳() != null) {
            ShoriKekkaKakuninListCSVEntity shoriKekkaKakuninListCSVEntity = new ShoriKekkaKakuninListCSVEntity();
            shoriKekkaKakuninListCSVEntity.set被保険者番号(entity.get被保台帳().getHihokenshaNo().getColumnValue());
            shoriKekkaKakuninListCSVEntity.set確認内容(確認内容);
            shoriKekkaKakuninListEucCsvWriter.writeLine(shoriKekkaKakuninListCSVEntity);
            personalDataList.add(PersonalData.of(entity.get被保台帳().getShikibetsuCode()));
        }
        連番++;
        updateRiyoshaFutanWariai(entity);

    }

    private void updateRiyoshaFutanWariai(RiyoshaFutanwariaishoTempEntity entity) {
        DbT3113RiyoshaFutanWariaiEntity item = entity.get利用者負担割合();
        if (item == null) {
            return;
        }
        item.setHakoKubun(ONE);
        item.setHakoYMD(new FlexibleDate(parameter.getバッチ起動時処理日時().getDate().toDateString()));
        item.setKofuYMD(new FlexibleDate(parameter.get交付年月日().toDateString()));
        riyoshaFutanWariaiWriter.update(item);
    }

    private void setソート順(List<RString> list) {
        if (list == null) {
            return;
        }
        if (!list.isEmpty()) {
            ソート順１ = list.get(0);
        }
        if (list.size() > NUM_ONE) {
            ソート順２ = list.get(NUM_ONE);
        }
        if (list.size() > NUM_TWO) {
            ソート順３ = list.get(NUM_TWO);
        }
        if (list.size() > NUM_THREE) {
            ソート順４ = list.get(NUM_THREE);
        }
        if (list.size() > NUM_FOUR) {
            ソート順５ = list.get(NUM_FOUR);
        }
    }

    @Override
    protected void afterExecute() {
        futanwariaiShoHakkoIchiranEucCsvWriter.close();
        futanwariaiShoHakkoIchiranManager.spool(futanwariaiShoHakkoIchiranEucFilePath);
        shoriKekkaKakuninListEucCsvWriter.close();
        shoriKekkaKakuninListManager.spool(shoriKekkaKakuninListEucFilePath);
        AccessLogger.logReport(personalDataList);
    }

}
