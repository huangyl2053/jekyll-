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
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.futanwariaishohakko.FutanwariaishoHakkoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.futanwariaishohakko.FutanwariaishoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.FutanwariaiShoHakkoIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaishohakko.RiyoshaFutanwariaishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishohakkoichiran.FutanWariaiShoHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishohakkoichiran.FutanWariaiShoHakkoIchiranSource;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.futanwariaishohakko.IFutanwariaishoHakkoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.futanwariaishoikkatsu.FutanWariaishoIkkatsu;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
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
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
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
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.futanwariaishohakko."
                    + "IFutanwariaishoHakkoMapper.select利用者負担割合証Temp");
    private FutanwariaishoHakkoProcessParameter parameter;
    private FutanWariaishoIkkatsu service;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private IFutanwariaishoHakkoMapper mapper;
    private int 連番;
    private IOutputOrder 出力順;
    private RString ソート順１;
    private RString ソート順２;
    private RString ソート順３;
    private RString ソート順４;
    private RString ソート順５;
    private int ページ;
    List<RString> 出力順BODY;
    private Association 地方公共団体;
    private final List<PersonalData> personalDataList = new ArrayList<>();
    @BatchWriter
    private BatchReportWriter<FutanWariaiShoHakkoIchiranSource> batchReportWriter;
    private ReportSourceWriter<FutanWariaiShoHakkoIchiranSource> reportSourceWriter;

    @BatchWriter
    BatchPermanentTableWriter riyoshaFutanWariaiWriter;

    private static final RString 定数_0 = new RString("0");
    private static final RString 定数_1 = new RString("1");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final Code CODE = new Code("0003");
    private static final RString DATANAME = new RString("被保険者番号");
    private static final int NUM_ONE = 1;
    private static final int NUM_TWO = 2;
    private static final int NUM_THREE = 3;
    private static final int NUM_FOUR = 4;
    private static final int NUM_THRITY = 30;
    FileSpoolManager futanwariaiShoHakkoIchiranManager;
    FileSpoolManager shoriKekkaKakuninListManager;
    @BatchWriter
    private CsvWriter<FutanwariaiShoHakkoIchiranCSVEntity> futanwariaiShoHakkoIchiranEucCsvWriter;

    private static final EucEntityId FUATANWARIAI_EUC_ENTITY_ID = new EucEntityId(new RString("DBC200090"));
    private RString futanwariaiShoHakkoIchiranEucFilePath;
    private final RString futanwariaiShoHakkoIchiranFileName = new RString("DBC200090_FutanWariaiShoHakkoIchiran.csv");

    @Override
    protected void initialize() {
        連番 = 1;
        ソート順１ = RString.EMPTY;
        ソート順２ = RString.EMPTY;
        ソート順３ = RString.EMPTY;
        ソート順４ = RString.EMPTY;
        ソート順５ = RString.EMPTY;
        service = new FutanWariaishoIkkatsu();
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        mapper = getMapper(IFutanwariaishoHakkoMapper.class);
        FutanwariaishoHakkoMybatisParameter param = parameter.toMybatisParameter();
        param.setサブ業務コード(SubGyomuCode.DBC介護給付.getColumnValue());
        param.set帳票分類ID(ReportIdDBC.DBC100065.getReportId().getColumnValue());
        帳票制御共通 = new ChohyoSeigyoKyotsu(mapper.select帳票制御共通(param));
        出力順BODY = new ArrayList<>();
        if (!RString.isNullOrEmpty(parameter.get出力順()) && !定数_0.equals(parameter.get出力順())) {
            IChohyoShutsuryokujunFinder iChohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
            出力順 = iChohyoShutsuryokujunFinder.get出力順(SubGyomuCode.DBC介護給付,
                    ReportIdDBC.DBC100065.getReportId(), Long.valueOf(parameter.get出力順().toString()));
            if (出力順 != null) {
                parameter.set出力順(MyBatisOrderByClauseCreator.create(
                        FutanWariaiShoKattokamiProperty.DBB100065ShutsuryokujunEnum.class, 出力順));
                List<ISetSortItem> items = 出力順.get設定項目リスト();
                for (int i = 0; i < items.size(); i++) {
                    出力順BODY.add(items.get(i).get項目名());
                }
            } else {
                parameter.set出力順(null);
            }
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
    }

    @Override
    protected void process(RiyoshaFutanwariaishoTempEntity entity) {
        ページ = 連番 % NUM_THRITY == 0 ? (連番 / NUM_THRITY) : (連番 / NUM_THRITY) + 1;
        FutanWariaiShoHakkoIchiranEntity futanWariaiShoHakkoIchiranEntity = service.getHakkoIchiranSourceData(帳票制御共通,
                entity, parameter, 地方公共団体.get地方公共団体コード().value(), 地方公共団体.get市町村名(), ソート順１, ソート順２,
                ソート順３, ソート順４, ソート順５, new RString(ページ), parameter.getバッチ起動時処理日時(), new RString(連番));
        FutanWariaiShoHakkoIchiranReport report = new FutanWariaiShoHakkoIchiranReport(futanWariaiShoHakkoIchiranEntity);
        report.writeBy(reportSourceWriter);
        FutanwariaiShoHakkoIchiranCSVEntity futanwariaiShoHakkoIchiranCSVEntity
                = service.getHakkoIchiranCSVData(帳票制御共通, entity, new RString(連番));
        futanwariaiShoHakkoIchiranEucCsvWriter.writeLine(futanwariaiShoHakkoIchiranCSVEntity);
        if (entity.get被保台帳() != null) {
            ExpandedInformation expandedInformation
                    = new ExpandedInformation(CODE, DATANAME, entity.get被保台帳().getHihokenshaNo().getColumnValue());
            personalDataList.add(PersonalData.of(entity.get被保台帳().getShikibetsuCode(), expandedInformation));
        }
        連番++;
        updateRiyoshaFutanWariai(entity);

    }

    private void updateRiyoshaFutanWariai(RiyoshaFutanwariaishoTempEntity entity) {
        DbT3113RiyoshaFutanWariaiEntity item = entity.get利用者負担割合();
        if (item == null) {
            return;
        }
        item.setHakoKubun(定数_1);
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
        if (NUM_ONE < list.size()) {
            ソート順２ = list.get(NUM_ONE);
        }
        if (NUM_TWO < list.size()) {
            ソート順３ = list.get(NUM_TWO);
        }
        if (NUM_THREE < list.size()) {
            ソート順４ = list.get(NUM_THREE);
        }
        if (NUM_FOUR < list.size()) {
            ソート順５ = list.get(NUM_FOUR);
        }
    }

    @Override
    protected void afterExecute() {
        futanwariaiShoHakkoIchiranEucCsvWriter.close();
        futanwariaiShoHakkoIchiranManager.spool(futanwariaiShoHakkoIchiranEucFilePath);
        AccessLogger.logReport(personalDataList);
    }

}
