/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.futanwariaishohakkoichiran.FutanWariaiShoHakkoIchiranReport;
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
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
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
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
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
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

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

    @BatchWriter
    BatchPermanentTableWriter shoKofuKaishuWriter;

    private static final RString コンマ = new RString(",");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");
    private static final RString FOUR = new RString("4");
    private static final RString 交付証種類_003 = new RString("003");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final int NUM_ONE = 1;
    private static final int NUM_TWO = 2;
    private static final int NUM_THREE = 3;
    private static final int NUM_FOUR = 4;
    private static final int NUM_SEVEN = 7;
    private static final int NUM_THIRTY_ONE = 31;
    private static final RString 交付事由_01 = new RString("01");
    private static final RString 交付事由_02 = new RString("02");
    private static final RString 交付事由_03 = new RString("03");
    private static final RString 交付事由_04 = new RString("04");
    private static final RString 回収事由_00 = new RString("00");
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
            出力順BODY = MyBatisOrderByClauseCreator.create(
                    SaishinsaKetteiTsuchishoIchiranKohifutanshaProperty.KagoKetteiKohifutanshaInBreakerFieldsEnum.class, 出力順)
                    .split(コンマ.toString());
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
        shoKofuKaishuWriter = new BatchPermanentTableWriter(DbT7037ShoKofuKaishuEntity.class);

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
        insertShoKofuKaishu(entity);
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

    private void insertShoKofuKaishu(RiyoshaFutanwariaishoTempEntity entity) {
        DbT7037ShoKofuKaishuEntity item = new DbT7037ShoKofuKaishuEntity();
        if (entity.get被保台帳() == null) {
            return;
        }
        item.setHihokenshaNo(entity.get被保台帳().getHihokenshaNo());
        item.setKofuShoShurui(交付証種類_003);
        if (entity.get証交付回収() == null) {
            item.setRirekiNo(NUM_ONE);
        } else {
            item.setRirekiNo(entity.get証交付回収().getRirekiNo() + NUM_ONE);
        }
        item.setShichosonCode(entity.get被保台帳().getShichosonCode());
        item.setShikibetsuCode(entity.get被保台帳().getShikibetsuCode());
        item.setKofuYMD(new FlexibleDate(parameter.get交付年月日().toDateString()));
        item.setYukoKigenYMD(new FlexibleDate(parameter.get年度().getYearValue(), NUM_SEVEN, NUM_THIRTY_ONE));
        item.setKofuJiyu(get交付事由(entity));
        item.setKofuRiyu(CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付, DBACodeShubetsu.資格者証回収事由.getCodeShubetsu(), new Code(get交付事由(entity))));
        item.setKaishuJiyu(回収事由_00);
        item.setTanpyoHakkoUmuFlag(false);
        item.setHakkoShoriTimestamp(new YMDHMS(parameter.getバッチ起動時処理日時()));
        item.setLogicalDeletedFlag(false);
        shoKofuKaishuWriter.update(item);
    }

    private RString get交付事由(RiyoshaFutanwariaishoTempEntity entity) {
        RString 交付事由 = RString.EMPTY;
        if (ONE.equals(entity.get利用者負担割合().getHanteiKubun())) {
            交付事由 = 交付事由_01;
        } else if (TWO.equals(entity.get利用者負担割合().getHanteiKubun())) {
            交付事由 = 交付事由_02;
        } else if (THREE.equals(entity.get利用者負担割合().getHanteiKubun())) {
            交付事由 = 交付事由_03;
        } else if (FOUR.equals(entity.get利用者負担割合().getHanteiKubun())) {
            交付事由 = 交付事由_04;
        }
        return 交付事由;
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
