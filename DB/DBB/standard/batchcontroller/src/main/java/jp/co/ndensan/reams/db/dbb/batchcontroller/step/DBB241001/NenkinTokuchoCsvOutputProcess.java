/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB241001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.euc.nenkintokucho.NenkinTokuchoIchiranCsvEditor;
import jp.co.ndensan.reams.db.dbb.business.euc.nenkintokucho.NenkinTokuchoInsertEditor;
import jp.co.ndensan.reams.db.dbb.business.euc.nenkintokucho.NenkinTokuchoKennSuuCsvEditor;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbb241001.TokuchoHaishinDataTorikomiMybatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb241001.TokuchoHaishinDataTorikomiProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.csv.IdoShoriKekkaJohoCsvEntity;
import jp.co.ndensan.reams.db.dbb.entity.csv.IraiOrTuikaIraiShoriKekkaCsvEntity;
import jp.co.ndensan.reams.db.dbb.entity.csv.KekkajohoCsvEntity;
import jp.co.ndensan.reams.db.dbb.entity.csv.NenkinTokuchoIchiranCsvEntity;
import jp.co.ndensan.reams.db.dbb.entity.csv.TaishoshaOrTuikaKohoshaJohoCsvEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.nenkintokucho.NenkinTokuchoEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.nenkintokucho.INenkinTokuchoMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.ShoriKekkaCode;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCodeType;
import jp.co.ndensan.reams.ue.uex.entity.db.relate.uext00010.TorikomiFileKaifuJohoTempEntity;
import jp.co.ndensan.reams.ue.uex.entity.db.relate.uext00010.TorikomiFileTrailRecordTempEntity;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.zenkokujusho.ZenkokuJushoFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * バッチ設計_DBB241001_特徴配信データ取り込みの抽出のプロセスクラスです。
 *
 * @reamsid_L DBB-4270-020 chenyadong
 */
public class NenkinTokuchoCsvOutputProcess extends BatchProcessBase<NenkinTokuchoEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.nenkintokucho."
                    + "INenkinTokuchoMapper.get取込ファイル_回付情報");
    private NenkinTokuchoIchiranCsvEditor ichiranCsvEditor;
    private NenkinTokuchoKennSuuCsvEditor kennSuuCsvEditor;
    private NenkinTokuchoInsertEditor insertEditor;
    private INenkinTokuchoMapper mapper;
    private TokuchoHaishinDataTorikomiProcessParameter parameter;
    private FileSpoolManager 結果情報一覧Manager;
    private FileSpoolManager 対象者情報一覧Manager;
    private FileSpoolManager 依頼処理結果情報一覧Manager;
    private FileSpoolManager 追加依頼処理結果情報一覧Manager;
    private FileSpoolManager 異動処理結果情報一覧Manager;
    private FileSpoolManager 追加候補者情報一覧Manager;
    private FileSpoolManager 対象者情報件数表Manager;
    private FileSpoolManager 追加候補者情報件数表Manager;
    private FileSpoolManager 依頼処理結果情報件数表Manager;
    private FileSpoolManager 追加依頼処理結果情報件数表Manager;
    private FileSpoolManager 結果情報件数表Manager;
    private FileSpoolManager 異動処理結果情報件数表Manager;
    private RString 結果情報一覧EucFilePath;
    private RString 対象者情報一覧EucFilePath;
    private RString 依頼処理結果情報一覧EucFilePath;
    private RString 追加依頼処理結果情報一覧EucFilePath;
    private RString 異動処理結果情報一覧EucFilePath;
    private RString 追加候補者情報一覧EucFilePath;
    private RString 対象者情報件数表EucFilePath;
    private RString 追加候補者情報件数表EucFilePath;
    private RString 依頼処理結果情報件数表EucFilePath;
    private RString 追加依頼処理結果情報件数表EucFilePath;
    private RString 結果情報件数表EucFilePath;
    private RString 異動処理結果情報件数表EucFilePath;
    private TorikomiFileTrailRecordTempEntity tmpEntity;
    private List<TorikomiFileKaifuJohoTempEntity> entityList;
    private List<TorikomiFileTrailRecordTempEntity> 異動処理結果情報件数表List;
    private static final EucEntityId EUC_ENTITY_ID_DBB300007 = new EucEntityId("DBB300007");
    private static final EucEntityId EUC_ENTITY_ID_DBB300008 = new EucEntityId("DBB300008");
    private static final EucEntityId EUC_ENTITY_ID_DBB300009 = new EucEntityId("DBB300009");
    private static final EucEntityId EUC_ENTITY_ID_DBB300010 = new EucEntityId("DBB300010");
    private static final EucEntityId EUC_ENTITY_ID_DBB300011 = new EucEntityId("DBB300011");
    private static final EucEntityId EUC_ENTITY_ID_DBB300012 = new EucEntityId("DBB300012");
    private static final EucEntityId EUC_ENTITY_ID_DBB300013 = new EucEntityId("DBB300013");
    private static final EucEntityId EUC_ENTITY_ID_DBB300014 = new EucEntityId("DBB300014");
    private static final EucEntityId EUC_ENTITY_ID_DBB300015 = new EucEntityId("DBB300015");
    private static final EucEntityId EUC_ENTITY_ID_DBB300016 = new EucEntityId("DBB300016");
    private static final EucEntityId EUC_ENTITY_ID_DBB300017 = new EucEntityId("DBB300017");
    private static final EucEntityId EUC_ENTITY_ID_DBB300018 = new EucEntityId("DBB300018");

    CsvWriter<NenkinTokuchoIchiranCsvEntity> 結果情報一覧CsvWriter;
    CsvWriter<NenkinTokuchoIchiranCsvEntity> 対象者情報一覧CsvWriter;
    CsvWriter<NenkinTokuchoIchiranCsvEntity> 依頼処理結果情報一覧CsvWriter;
    CsvWriter<NenkinTokuchoIchiranCsvEntity> 追加依頼処理結果情報一覧CsvWriter;
    CsvWriter<NenkinTokuchoIchiranCsvEntity> 異動処理結果情報一覧CsvWriter;
    CsvWriter<NenkinTokuchoIchiranCsvEntity> 追加候補者情報一覧CsvWriter;
    CsvWriter<TaishoshaOrTuikaKohoshaJohoCsvEntity> 対象者情報件数表CsvWriter;
    CsvWriter<TaishoshaOrTuikaKohoshaJohoCsvEntity> 追加候補者情報件数表CsvWriter;
    CsvWriter<IraiOrTuikaIraiShoriKekkaCsvEntity> 依頼処理結果情報件数表CsvWriter;
    CsvWriter<IraiOrTuikaIraiShoriKekkaCsvEntity> 追加依頼処理結果情報件数表CsvWriter;
    CsvWriter<KekkajohoCsvEntity> 結果情報件数表CsvWriter;
    CsvWriter<IdoShoriKekkaJohoCsvEntity> 異動処理結果情報件数表CsvWriter;
    @BatchWriter
    private BatchPermanentTableWriter<UeT0511NenkinTokuchoKaifuJohoEntity> ueT0511Writer;

    private final RString 結果情報一覧_CSV_FILE_NAME = new RString("特別徴収結果情報一覧.csv");
    private final RString 対象者情報一覧_CSV_FILE_NAME = new RString("特別徴収対象者情報一覧.csv");
    private final RString 依頼処理結果情報一覧_CSV_FILE_NAME = new RString("特別徴収依頼処理結果情報一覧.csv");
    private final RString 追加依頼処理結果情報一覧_CSV_FILE_NAME = new RString("特別徴収追加依頼処理結果情報一覧.csv");
    private final RString 異動処理結果情報一覧_CSV_FILE_NAME = new RString("特別徴収異動処理結果情報一覧.csv");
    private final RString 追加候補者情報一覧_CSV_FILE_NAME = new RString("特別徴収追加候補者情報一覧.csv");
    private final RString 対象者情報件数表_CSV_FILE_NAME = new RString("特別徴収対象者情報件数表.csv");
    private final RString 追加候補者情報件数表_CSV_FILE_NAME = new RString("特別徴収追加候補者情報件数表.csv");
    private final RString 依頼処理結果情報件数表_CSV_FILE_NAME = new RString("特別徴収依頼処理結果情報件数表.csv");
    private final RString 追加依頼処理結果情報件数表_CSV_FILE_NAME = new RString("特別徴収追加依頼処理結果情報件数表.csv");
    private final RString 結果情報件数表_CSV_FILE_NAME = new RString("特別徴収結果情報件数表.csv");
    private final RString 異動処理結果情報件数表_CSV_FILE_NAME = new RString("特別徴収異動処理結果情報件数表.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_9 = 9;
    private static final int INT_10 = 10;
    private static final int INT_11 = 11;
    private static final int INT_12 = 12;
    private int 資格喪失エラー件数;
    private int 仮徴収額変更エラー件数;
    private int 住所地特例エラー件数;
    private static final RString 連番_GENERIC_KEY = new RString("連番_GENERIC_KEY");

    /**
     * 処理対象年月です。
     */
    public static final RString PARAMETER_OUT_OUTPUTSAKUSEIYMD;

    static {
        PARAMETER_OUT_OUTPUTSAKUSEIYMD = new RString("shoriTaishoYM");
    }

    private OutputParameter<FlexibleYearMonth> shoriTaishoYM;

    @Override
    protected void initialize() {
        mapper = getMapper(INenkinTokuchoMapper.class);
        entityList = new ArrayList<>();
        異動処理結果情報件数表List = new ArrayList<>();
        tmpEntity = null;
        ichiranCsvEditor = new NenkinTokuchoIchiranCsvEditor();
        kennSuuCsvEditor = new NenkinTokuchoKennSuuCsvEditor();
        insertEditor = new NenkinTokuchoInsertEditor();
        資格喪失エラー件数 = INT_0;
        仮徴収額変更エラー件数 = INT_0;
        住所地特例エラー件数 = INT_0;
        shoriTaishoYM = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        結果情報一覧Manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_DBB300007,
                UzUDE0831EucAccesslogFileType.Csv);
        結果情報一覧EucFilePath = Path.combinePath(結果情報一覧Manager.getEucOutputDirectry(),
                結果情報一覧_CSV_FILE_NAME);
        結果情報一覧CsvWriter = new CsvWriter.InstanceBuilder(結果情報一覧EucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();

        対象者情報一覧Manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_DBB300008,
                UzUDE0831EucAccesslogFileType.Csv);
        対象者情報一覧EucFilePath = Path.combinePath(対象者情報一覧Manager.getEucOutputDirectry(),
                対象者情報一覧_CSV_FILE_NAME);
        対象者情報一覧CsvWriter = new CsvWriter.InstanceBuilder(対象者情報一覧EucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();

        依頼処理結果情報一覧Manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_DBB300009,
                UzUDE0831EucAccesslogFileType.Csv);
        依頼処理結果情報一覧EucFilePath = Path.combinePath(依頼処理結果情報一覧Manager.getEucOutputDirectry(),
                依頼処理結果情報一覧_CSV_FILE_NAME);
        依頼処理結果情報一覧CsvWriter = new CsvWriter.InstanceBuilder(依頼処理結果情報一覧EucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();

        追加依頼処理結果情報一覧Manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_DBB300010,
                UzUDE0831EucAccesslogFileType.Csv);
        追加依頼処理結果情報一覧EucFilePath = Path.combinePath(追加依頼処理結果情報一覧Manager.getEucOutputDirectry(),
                追加依頼処理結果情報一覧_CSV_FILE_NAME);
        追加依頼処理結果情報一覧CsvWriter = new CsvWriter.InstanceBuilder(追加依頼処理結果情報一覧EucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();

        異動処理結果情報一覧Manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_DBB300011,
                UzUDE0831EucAccesslogFileType.Csv);
        異動処理結果情報一覧EucFilePath = Path.combinePath(異動処理結果情報一覧Manager.getEucOutputDirectry(),
                異動処理結果情報一覧_CSV_FILE_NAME);
        異動処理結果情報一覧CsvWriter = new CsvWriter.InstanceBuilder(異動処理結果情報一覧EucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();

        追加候補者情報一覧Manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_DBB300012,
                UzUDE0831EucAccesslogFileType.Csv);
        追加候補者情報一覧EucFilePath = Path.combinePath(追加候補者情報一覧Manager.getEucOutputDirectry(),
                追加候補者情報一覧_CSV_FILE_NAME);
        追加候補者情報一覧CsvWriter = new CsvWriter.InstanceBuilder(追加候補者情報一覧EucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();

        対象者情報件数表Manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_DBB300013,
                UzUDE0831EucAccesslogFileType.Csv);
        対象者情報件数表EucFilePath = Path.combinePath(対象者情報件数表Manager.getEucOutputDirectry(),
                対象者情報件数表_CSV_FILE_NAME);
        対象者情報件数表CsvWriter = new CsvWriter.InstanceBuilder(対象者情報件数表EucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();

        追加候補者情報件数表Manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_DBB300014,
                UzUDE0831EucAccesslogFileType.Csv);
        追加候補者情報件数表EucFilePath = Path.combinePath(追加候補者情報件数表Manager.getEucOutputDirectry(),
                追加候補者情報件数表_CSV_FILE_NAME);
        追加候補者情報件数表CsvWriter = new CsvWriter.InstanceBuilder(追加候補者情報件数表EucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();

        依頼処理結果情報件数表Manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_DBB300015,
                UzUDE0831EucAccesslogFileType.Csv);
        依頼処理結果情報件数表EucFilePath = Path.combinePath(依頼処理結果情報件数表Manager.getEucOutputDirectry(),
                依頼処理結果情報件数表_CSV_FILE_NAME);
        依頼処理結果情報件数表CsvWriter = new CsvWriter.InstanceBuilder(依頼処理結果情報件数表EucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();

        追加依頼処理結果情報件数表Manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_DBB300016,
                UzUDE0831EucAccesslogFileType.Csv);
        追加依頼処理結果情報件数表EucFilePath = Path.combinePath(追加依頼処理結果情報件数表Manager.getEucOutputDirectry(),
                追加依頼処理結果情報件数表_CSV_FILE_NAME);
        追加依頼処理結果情報件数表CsvWriter = new CsvWriter.InstanceBuilder(追加依頼処理結果情報件数表EucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();

        結果情報件数表Manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_DBB300017,
                UzUDE0831EucAccesslogFileType.Csv);
        結果情報件数表EucFilePath = Path.combinePath(結果情報件数表Manager.getEucOutputDirectry(),
                結果情報件数表_CSV_FILE_NAME);
        結果情報件数表CsvWriter = new CsvWriter.InstanceBuilder(結果情報件数表EucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();

        異動処理結果情報件数表Manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_DBB300018,
                UzUDE0831EucAccesslogFileType.Csv);
        異動処理結果情報件数表EucFilePath = Path.combinePath(異動処理結果情報件数表Manager.getEucOutputDirectry(),
                異動処理結果情報件数表_CSV_FILE_NAME);
        異動処理結果情報件数表CsvWriter = new CsvWriter.InstanceBuilder(異動処理結果情報件数表EucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();

        ueT0511Writer = new BatchPermanentTableWriter<>(UeT0511NenkinTokuchoKaifuJohoEntity.class);
    }

    @Override
    protected void process(NenkinTokuchoEntity entity) {
        if (entity.getデータレコードEntity() == null || entity.getトレイラレコードEntity() == null) {
            return;
        }
        if (tmpEntity == null) {
            tmpEntity = entity.getトレイラレコードEntity();
            entityList.add(entity.getデータレコードEntity());
        } else if (isEquals(entity.getトレイラレコードEntity())) {
            entityList.add(entity.getデータレコードEntity());
        } else {
            editOutPutKennSuuCsv();
            entityList.clear();
            entityList.add(entity.getデータレコードEntity());
            tmpEntity = entity.getトレイラレコードEntity();
        }
        editOutPutIchiranCsv(entity.getデータレコードEntity());
        TokuchoHaishinDataTorikomiMybatisParameter param = setMybatisParameter(entity.getデータレコードEntity());
        UeT0511NenkinTokuchoKaifuJohoEntity ueT0511Entity = mapper.select年金特徴回付情報(param);
        if (ueT0511Entity == null) {
            ueT0511Writer.insert(insertEditor.get対象者or追加候補者情報CsvEntity(entity.getデータレコードEntity(), param,
                    parameter.getShoriYMDHM(), parameter.getFileName().substring(INT_0, INT_3),
                    get処理対象年月(entity.getデータレコードEntity().getTsuchiNaiyoCode(),
                            entity.getデータレコードEntity().getSakuseiYMD())));
        }
    }

    @Override
    protected void afterExecute() {
        if (tmpEntity != null) {
            editOutPutKennSuuCsv();
            shoriTaishoYM.setValue(get処理対象年月(tmpEntity.getTsuchiNaiyoCode(), tmpEntity.getSakuseiYMD()));
        }
        if (!異動処理結果情報件数表List.isEmpty()) {
            int 資格喪失件数 = INT_0;
            int 仮徴収額変更件数 = INT_0;
            int 住所地特例件数 = INT_0;
            for (TorikomiFileTrailRecordTempEntity entity : 異動処理結果情報件数表List) {
                if (TsuchiNaiyoCodeType.資格喪失等処理結果通知.get通知内容コード().equals(entity.getTsuchiNaiyoCode())) {
                    資格喪失件数 = entity.getRecordKensu();
                } else if (TsuchiNaiyoCodeType.仮徴収額変更処理結果通知.get通知内容コード().equals(entity.getTsuchiNaiyoCode())) {
                    仮徴収額変更件数 = entity.getRecordKensu();
                } else if (TsuchiNaiyoCodeType.住所地特例該当者処理結果通知.get通知内容コード().equals(entity.getTsuchiNaiyoCode())) {
                    住所地特例件数 = entity.getRecordKensu();
                }
            }
            RString 市町村名 = get市町村名(異動処理結果情報件数表List.get(INT_0).getShichosoCode());
            異動処理結果情報件数表CsvWriter.writeLine(kennSuuCsvEditor.get特別徴収異動処理結果情報件数表CsvEntity(異動処理結果情報件数表List
                    .get(INT_0), 市町村名, 資格喪失件数, 仮徴収額変更件数, 住所地特例件数, 資格喪失エラー件数,
                    仮徴収額変更エラー件数, 住所地特例エラー件数));
        }
        対象者情報一覧CsvWriter.close();
        対象者情報一覧Manager.spool(対象者情報一覧EucFilePath);
        依頼処理結果情報一覧CsvWriter.close();
        依頼処理結果情報一覧Manager.spool(依頼処理結果情報一覧EucFilePath);
        結果情報一覧CsvWriter.close();
        結果情報一覧Manager.spool(結果情報一覧EucFilePath);
        追加候補者情報一覧CsvWriter.close();
        追加候補者情報一覧Manager.spool(追加候補者情報一覧EucFilePath);
        追加依頼処理結果情報一覧CsvWriter.close();
        追加依頼処理結果情報一覧Manager.spool(追加依頼処理結果情報一覧EucFilePath);
        異動処理結果情報一覧CsvWriter.close();
        異動処理結果情報一覧Manager.spool(異動処理結果情報一覧EucFilePath);
        対象者情報件数表CsvWriter.close();
        対象者情報件数表Manager.spool(対象者情報件数表EucFilePath);
        依頼処理結果情報件数表CsvWriter.close();
        依頼処理結果情報件数表Manager.spool(依頼処理結果情報件数表EucFilePath);
        結果情報件数表CsvWriter.close();
        結果情報件数表Manager.spool(結果情報件数表EucFilePath);
        追加候補者情報件数表CsvWriter.close();
        追加候補者情報件数表Manager.spool(追加候補者情報件数表EucFilePath);
        追加依頼処理結果情報件数表CsvWriter.close();
        追加依頼処理結果情報件数表Manager.spool(追加依頼処理結果情報件数表EucFilePath);
        異動処理結果情報件数表CsvWriter.close();
        異動処理結果情報件数表Manager.spool(異動処理結果情報件数表EucFilePath);

    }

    private void editOutPutIchiranCsv(TorikomiFileKaifuJohoTempEntity entity) {
        boolean is出力 = is出力(entity.getTsuchiNaiyoCode(),
                get処理対象年月(entity.getTsuchiNaiyoCode(), entity.getSakuseiYMD()));
        if (TsuchiNaiyoCodeType.特別徴収対象者情報.get通知内容コード().equals(entity.getTsuchiNaiyoCode()) && is出力) {
            対象者情報一覧CsvWriter.writeLine(ichiranCsvEditor.getCsvEntity(entity));
        } else if (TsuchiNaiyoCodeType.特別徴収依頼処理結果通知.get通知内容コード().equals(entity.getTsuchiNaiyoCode()) && is出力) {
            依頼処理結果情報一覧CsvWriter.writeLine(ichiranCsvEditor.getCsvEntity(entity));
        } else if (TsuchiNaiyoCodeType.特別徴収結果通知.get通知内容コード().equals(entity.getTsuchiNaiyoCode()) && is出力) {
            結果情報一覧CsvWriter.writeLine(ichiranCsvEditor.getCsvEntity(entity));
        } else if (TsuchiNaiyoCodeType.特別徴収追加候補者情報.get通知内容コード().equals(entity.getTsuchiNaiyoCode()) && is出力) {
            追加候補者情報一覧CsvWriter.writeLine(ichiranCsvEditor.getCsvEntity(entity));
        } else if (TsuchiNaiyoCodeType.特別徴収追加依頼処理結果通知.get通知内容コード().equals(entity.getTsuchiNaiyoCode()) && is出力) {
            追加依頼処理結果情報一覧CsvWriter.writeLine(ichiranCsvEditor.getCsvEntity(entity));
        } else if (TsuchiNaiyoCodeType.資格喪失等処理結果通知.get通知内容コード().equals(entity.getTsuchiNaiyoCode())
                || TsuchiNaiyoCodeType.仮徴収額変更処理結果通知.get通知内容コード().equals(entity.getTsuchiNaiyoCode())
                || TsuchiNaiyoCodeType.住所地特例該当者処理結果通知.get通知内容コード().equals(entity.getTsuchiNaiyoCode())) {
            set異動処理エラー件数(entity);
            異動処理結果情報一覧CsvWriter.writeLine(ichiranCsvEditor.getCsvEntity(entity));
        }
    }

    private void editOutPutKennSuuCsv() {
        boolean is出力 = is出力(tmpEntity.getTsuchiNaiyoCode(),
                get処理対象年月(tmpEntity.getTsuchiNaiyoCode(), tmpEntity.getSakuseiYMD()));
        RString 市町村名 = get市町村名(tmpEntity.getShichosoCode());
        if (TsuchiNaiyoCodeType.特別徴収対象者情報.get通知内容コード().equals(tmpEntity.getTsuchiNaiyoCode()) && is出力) {
            対象者情報件数表CsvWriter.writeLine(kennSuuCsvEditor.get対象者or追加候補者情報CsvEntity(tmpEntity, entityList, 市町村名));
        } else if (TsuchiNaiyoCodeType.特別徴収依頼処理結果通知.get通知内容コード().equals(tmpEntity.getTsuchiNaiyoCode()) && is出力) {
            依頼処理結果情報件数表CsvWriter.writeLine(kennSuuCsvEditor.get処理結果情報件数表CsvEntity(tmpEntity, entityList, 市町村名));
        } else if (TsuchiNaiyoCodeType.特別徴収結果通知.get通知内容コード().equals(tmpEntity.getTsuchiNaiyoCode()) && is出力) {
            結果情報件数表CsvWriter.writeLine(kennSuuCsvEditor.get特別徴収結果情報件数表CsvEntity(tmpEntity, entityList, 市町村名));
        } else if (TsuchiNaiyoCodeType.特別徴収追加候補者情報.get通知内容コード().equals(tmpEntity.getTsuchiNaiyoCode()) && is出力) {
            追加候補者情報件数表CsvWriter.writeLine(kennSuuCsvEditor.get対象者or追加候補者情報CsvEntity(tmpEntity, entityList, 市町村名));
        } else if (TsuchiNaiyoCodeType.特別徴収追加依頼処理結果通知.get通知内容コード().equals(tmpEntity.getTsuchiNaiyoCode()) && is出力) {
            追加依頼処理結果情報件数表CsvWriter.writeLine(kennSuuCsvEditor.get処理結果情報件数表CsvEntity(tmpEntity, entityList, 市町村名));
        } else if (TsuchiNaiyoCodeType.資格喪失等処理結果通知.get通知内容コード().equals(tmpEntity.getTsuchiNaiyoCode())
                || TsuchiNaiyoCodeType.仮徴収額変更処理結果通知.get通知内容コード().equals(tmpEntity.getTsuchiNaiyoCode())
                || TsuchiNaiyoCodeType.住所地特例該当者処理結果通知.get通知内容コード().equals(tmpEntity.getTsuchiNaiyoCode())) {
            異動処理結果情報件数表List.add(tmpEntity);
        }

    }

    private FlexibleYearMonth get処理対象年月(RString 通知内容コード, FlexibleDate 作成年月日) {
        if (TsuchiNaiyoCodeType.特別徴収対象者情報.get通知内容コード().equals(通知内容コード)) {
            return new FlexibleDate(作成年月日.getYearValue(), INT_5, 作成年月日.getDayValue()).getYearMonth();
        } else if (TsuchiNaiyoCodeType.特別徴収依頼処理結果通知.get通知内容コード().equals(通知内容コード)) {
            return new FlexibleDate(作成年月日.getYearValue(), INT_9, 作成年月日.getDayValue()).getYearMonth();
        } else if (TsuchiNaiyoCodeType.特別徴収結果通知.get通知内容コード().equals(通知内容コード)) {
            if (作成年月日.getMonthValue() == INT_11 || 作成年月日.getMonthValue() == INT_12) {
                return new FlexibleDate(作成年月日.plusYear(INT_1).getYearValue(), INT_1, 作成年月日.getDayValue()).getYearMonth();
            } else if (作成年月日.getMonthValue() % INT_2 == INT_0) {
                return 作成年月日.plusMonth(INT_1).getYearMonth();
            } else {
                return 作成年月日.plusMonth(INT_2).getYearMonth();
            }
        } else if (TsuchiNaiyoCodeType.特別徴収追加候補者情報.get通知内容コード().equals(通知内容コード)) {
            if (作成年月日.getMonthValue() == INT_12) {
                return new FlexibleDate(作成年月日.plusYear(INT_1).getYearValue(), INT_2, 作成年月日.getDayValue()).getYearMonth();
            } else if (作成年月日.getMonthValue() % INT_2 == INT_0) {
                return 作成年月日.plusMonth(INT_2).getYearMonth();
            } else {
                return 作成年月日.plusMonth(INT_1).getYearMonth();
            }
        } else if (TsuchiNaiyoCodeType.特別徴収追加依頼処理結果通知.get通知内容コード().equals(通知内容コード)) {
            if (作成年月日.getMonthValue() % INT_2 == INT_0) {
                return 作成年月日.plusMonth(INT_6).getYearMonth();
            } else {
                return 作成年月日.plusMonth(INT_5).getYearMonth();
            }
        } else if (TsuchiNaiyoCodeType.資格喪失等処理結果通知.get通知内容コード().equals(通知内容コード)
                || TsuchiNaiyoCodeType.仮徴収額変更処理結果通知.get通知内容コード().equals(通知内容コード)
                || TsuchiNaiyoCodeType.住所地特例該当者処理結果通知.get通知内容コード().equals(通知内容コード)) {
            return 作成年月日.plusMonth(INT_1).getYearMonth();
        }
        return FlexibleYearMonth.EMPTY;
    }

    private FlexibleYear get処理年度(FlexibleYearMonth 処理対象年月) {
        if (!FlexibleYearMonth.EMPTY.equals(処理対象年月)) {
            return 処理対象年月.getYear();
        }
        return FlexibleYear.EMPTY;
    }

    private boolean is出力(RString 通知内容コード, FlexibleYearMonth 処理対象年月) {
        if (TsuchiNaiyoCodeType.特別徴収対象者情報.get通知内容コード().equals(通知内容コード)) {
            return 処理対象年月.getMonthValue() == INT_5;
        } else if (TsuchiNaiyoCodeType.特別徴収依頼処理結果通知.get通知内容コード().equals(通知内容コード)) {
            return 処理対象年月.getMonthValue() == INT_9;
        } else if (TsuchiNaiyoCodeType.特別徴収結果通知.get通知内容コード().equals(通知内容コード)) {
            return 処理対象年月.getMonthValue() % INT_2 != INT_0;
        } else if (TsuchiNaiyoCodeType.特別徴収追加候補者情報.get通知内容コード().equals(通知内容コード)) {
            return (処理対象年月.getMonthValue() % INT_2 == INT_0) && (処理対象年月.getMonthValue() != INT_6);
        } else if (TsuchiNaiyoCodeType.特別徴収追加依頼処理結果通知.get通知内容コード().equals(通知内容コード)) {
            return (処理対象年月.getMonthValue() % INT_2 == INT_0) && (処理対象年月.getMonthValue() != INT_10);
        }
        return false;
    }

    private RString get市町村名(RString 市町村コード) {
        if (!RString.isNullOrEmpty(市町村コード)) {
            if (AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード().code検査数字無しRString().equals(市町村コード)) {
                return AssociationFinderFactory.createInstance().getAssociation().get市町村名();
            } else if (ZenkokuJushoFinderFactory.createInstance().get全国住所By都道府県市町村コード(市町村コード) != null) {
                return ZenkokuJushoFinderFactory.createInstance().get全国住所By都道府県市町村コード(市町村コード).get市町村名();
            }
        }
        return RString.EMPTY;
    }

    private void set異動処理エラー件数(TorikomiFileKaifuJohoTempEntity entity) {
        if (TsuchiNaiyoCodeType.資格喪失等処理結果通知.get通知内容コード().equals(entity.getTsuchiNaiyoCode())
                && !ShoriKekkaCode.Code00.getCode().equals(entity.getShoriKeikka())) {
            資格喪失エラー件数 = 資格喪失エラー件数 + INT_1;
        } else if (TsuchiNaiyoCodeType.仮徴収額変更処理結果通知.get通知内容コード().equals(entity.getTsuchiNaiyoCode())
                && !ShoriKekkaCode.Code00.getCode().equals(entity.getShoriKeikka())) {
            仮徴収額変更エラー件数 = 仮徴収額変更エラー件数 + INT_1;
        } else if (TsuchiNaiyoCodeType.住所地特例該当者処理結果通知.get通知内容コード().equals(entity.getTsuchiNaiyoCode())
                && !ShoriKekkaCode.Code00.getCode().equals(entity.getShoriKeikka())) {
            住所地特例エラー件数 = 住所地特例エラー件数 + INT_1;
        }
    }

    private TokuchoHaishinDataTorikomiMybatisParameter setMybatisParameter(TorikomiFileKaifuJohoTempEntity entity) {

        TokuchoHaishinDataTorikomiMybatisParameter param = new TokuchoHaishinDataTorikomiMybatisParameter();
        FlexibleYearMonth 処理対象年月 = get処理対象年月(entity.getTsuchiNaiyoCode(), entity.getSakuseiYMD());
        param.setGyomuCode(GyomuCode.DB介護保険);
        param.setShoriNendo(get処理年度(処理対象年月));
        param.setTsuchiNaiyoCode(entity.getTsuchiNaiyoCode());
        param.setShoriTaishoYM(処理対象年月);
        param.setKisoNenkinNo(entity.getKisoNenkinNo());
        param.setNenkinCode(entity.getNenkinCode());
        param.setKoseiCityCode(entity.getShichosoCode());
        param.setRenban((int) Saiban.get(SubGyomuCode.DBB介護賦課, 連番_GENERIC_KEY).next());
        return param;
    }

    private boolean isEquals(TorikomiFileTrailRecordTempEntity entity) {
        if (tmpEntity.getGoukeiKingaku1() != null && entity.getGoukeiKingaku1() != null
                && !tmpEntity.getGoukeiKingaku1().equals(entity.getGoukeiKingaku1())) {
            return false;
        }
        if (tmpEntity.getGoukeiKingaku2() != null && entity.getGoukeiKingaku2() != null
                && !tmpEntity.getGoukeiKingaku2().equals(entity.getGoukeiKingaku2())) {
            return false;
        }
        if (tmpEntity.getGoukeiKingaku3() != null && entity.getGoukeiKingaku3() != null
                && !tmpEntity.getGoukeiKingaku3().equals(entity.getGoukeiKingaku3())) {
            return false;
        }
        if (tmpEntity.getRecordKensu() != entity.getRecordKensu()) {
            return false;
        }
        if (tmpEntity.getSakuseiYMD() != null && entity.getSakuseiYMD() != null
                && !tmpEntity.getSakuseiYMD().equals(entity.getSakuseiYMD())) {
            return false;
        }
        if (tmpEntity.getShichosoCode() != null && entity.getShichosoCode() != null
                && !tmpEntity.getShichosoCode().equals(entity.getShichosoCode())) {
            return false;
        } else {
            return isEqualsPart2(entity);
        }
    }

    private boolean isEqualsPart2(TorikomiFileTrailRecordTempEntity entity) {
        if (tmpEntity.getRecordKubun() != null && entity.getRecordKubun() != null
                && !tmpEntity.getRecordKubun().equals(entity.getRecordKubun())) {
            return false;
        }
        if (tmpEntity.getTokuchoGimuCode() != null && entity.getTokuchoGimuCode() != null
                && !tmpEntity.getTokuchoGimuCode().equals(entity.getTokuchoGimuCode())) {
            return false;
        }
        if (tmpEntity.getTokuchoSeidoCode() != null && entity.getTokuchoSeidoCode() != null
                && !tmpEntity.getTokuchoSeidoCode().equals(entity.getTokuchoSeidoCode())) {
            return false;
        }
        if (tmpEntity.getTsuchiNaiyoCode() != null && entity.getTsuchiNaiyoCode() != null
                && !tmpEntity.getTsuchiNaiyoCode().equals(entity.getTsuchiNaiyoCode())) {
            return false;
        }
        if (tmpEntity.getYobi1() != null && entity.getYobi1() != null
                && !tmpEntity.getYobi1().equals(entity.getYobi1())) {
            return false;
        } else if (tmpEntity.getYobi2() != null && entity.getYobi2() != null
                && !tmpEntity.getYobi2().equals(entity.getYobi2())) {
            return false;
        }
        return true;
    }

}
