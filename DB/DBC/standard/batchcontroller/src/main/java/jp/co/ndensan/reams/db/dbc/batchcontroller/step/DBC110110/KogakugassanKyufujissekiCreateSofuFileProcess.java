/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110110;

import java.io.File;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.RecordShubetsu;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface.ConfigKeysKokuhorenSofu;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassankyufujissekiout.KogakugassanKyufujissekiCreateSofuFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakugassan.KogakugassanSoufuFairuSakuseiControlEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakugassan.KogakugassanSoufuFairuSakuseiEndEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakugassankyufujissekiout.KogakuGassanKyufuJissekiSofuDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiout.KogakuGassanKyufuJissekiSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiout.SofuTaishoEntity;
import jp.co.ndensan.reams.db.dbc.service.core.kogakugassankyufujissekiout.KogakugassanKyufujissekiOutService;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.externalcharacter.BinaryCharacterConvertParameter;
import jp.co.ndensan.reams.uz.uza.externalcharacter.BinaryCharacterConvertParameterBuilder;
import jp.co.ndensan.reams.uz.uza.externalcharacter.CharacterAttribute;
import jp.co.ndensan.reams.uz.uza.externalcharacter.CharacterConvertTable;
import jp.co.ndensan.reams.uz.uza.externalcharacter.ReamsUnicodeToBinaryConverter;
import jp.co.ndensan.reams.uz.uza.externalcharacter.RecordConvertMaterial;
import jp.co.ndensan.reams.uz.uza.io.ByteWriter;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.FileReader;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 高額合算給付実績情報作成の送付ファイル作成Process
 *
 * @reamsid_L DBC-2710-030 wangxue
 */
public class KogakugassanKyufujissekiCreateSofuFileProcess extends BatchProcessBase<KogakuGassanKyufuJissekiSofuEntity> {

    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassankyufujissekiout."
            + "IKogakugassanKyufujissekiOutMapper.get送付ファイル作成データ");
    private static final RString PREFIX = new RString("10_");
    private static final RString FILE_TYPE = new RString(".csv");
    private static final RString カンマ = new RString(",");
    private static final RString 変換区分_1 = new RString("1");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final RString ボリュム通番 = new RString("000");
    private static final RString 固定番号_00 = new RString("00");
    private static final RString 事業所番号 = new RString("0000000000");
    private static final RString ファイル管理番号 = new RString("0");
    private static final RString 処理結果リスト一時_NAME = new RString("DbWT1002KokuhorenSakuseiError");
    private static final RString 拡張子_TEMP = new RString("temp");
    private static final RString 拡張子 = new RString("\r\n");

    private KogakugassanKyufujissekiCreateSofuFileProcessParameter parameter;
    private int 総出力件数;
    private int レコード番号;
    private OutputParameter<SofuTaishoEntity> outReturnEntity;
    private SofuTaishoEntity returnEntity;
    private RString dbu保険者番号;
    private RString csvFileName;
    private RString csvFilePath;
    private int レコード件数;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter 処理結果リスト一時Writer;

    private CsvWriter csvWriter;
    /**
     * 総出力件数とエントリ情報Listです。
     */
    public static final RString PARAMETER_OUT_OUTRETURNENTITY;

    static {
        PARAMETER_OUT_OUTRETURNENTITY = new RString("outReturnEntity");
    }

    @Override
    protected void initialize() {
        レコード件数 = KogakugassanKyufujissekiOutService.createInstance().get出力対象データ件数();
        総出力件数 = INT_0;
        レコード番号 = INT_0;
        returnEntity = new SofuTaishoEntity();
        outReturnEntity = new OutputParameter<>();
        dbu保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        csvFileName = PREFIX.concat(parameter.get交換情報識別番号()).concat(dbu保険者番号)
                .concat(parameter.get処理年月().toDateString()).concat(拡張子_TEMP).concat(FILE_TYPE);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_PATH);
    }

    @Override
    protected void createWriter() {

        処理結果リスト一時Writer = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_NAME,
                DbWT1002KokuhorenSakuseiErrorTempEntity.class);
        RString spoolPath = Path.getTmpDirectoryPath();
        csvFilePath = Path.combinePath(spoolPath, csvFileName);

    }

    @Override
    protected void process(KogakuGassanKyufuJissekiSofuEntity entity) {

        if (レコード番号 == INT_0) {
            csvWriter = new CsvWriter.InstanceBuilder(csvFilePath).
                    setDelimiter(カンマ).
                    setEncode(Encode.UTF_8withBOM).
                    setEnclosure(RString.EMPTY).
                    setNewLine(NewLine.CRLF).
                    hasHeader(false).
                    build();
            csvWriter.writeLine(getControlEntity(INT_1));
        }
        レコード番号 = レコード番号 + INT_1;
        csvWriter.writeLine(setデータレコード(entity, レコード番号));
        総出力件数 = 総出力件数 + INT_1;

    }

    @Override
    protected void afterExecute() {

        if (総出力件数 == INT_0) {
            処理結果リスト一時Writer.insert(set処理結果リスト());

        } else {
            csvWriter.writeLine(getEndEntity(INT_1));
            csvWriter.close();
            do外字類似変換();
            SharedFileDescriptor sdf = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(csvFileName));
            sdf = SharedFile.defineSharedFile(sdf, 1, SharedFile.GROUP_ALL, null, true, null);
            CopyToSharedFileOpts opts = new CopyToSharedFileOpts().dateToDelete(RDate.getNowDate().plusMonth(1));
            SharedFile.copyToSharedFile(sdf, FilesystemPath.fromString(csvFilePath), opts);
            returnEntity.set総出力件数(総出力件数);
            returnEntity.setエントリ情報(sdf);
            outReturnEntity.setValue(returnEntity);
        }
    }

    private KogakuGassanKyufuJissekiSofuDataEntity setデータレコード(KogakuGassanKyufuJissekiSofuEntity entity, int 番号) {
        KogakuGassanKyufuJissekiSofuDataEntity dataEntity = new KogakuGassanKyufuJissekiSofuDataEntity();
        dataEntity.setレコード種別(RecordShubetsu.データレコード.getコード());
        dataEntity.setレコード番号(new RString(番号));
        if (null == entity.get交換情報識別番号() || entity.get交換情報識別番号().isEmpty()) {
            dataEntity.set交換情報識別番号(RString.EMPTY);
        } else {
            dataEntity.set交換情報識別番号(entity.get交換情報識別番号().getColumnValue().trim());
        }
        dataEntity.set支給申請書整理番号(trimRString(entity.get支給申請書整理番号()));
        dataEntity.set自己負担額証明書整理番号(trimRString(entity.get自己負担額証明書整理番号()));
        dataEntity.set保険制度コード(trimRString(entity.get保険制度コード()));
        dataEntity.set給付実績作成区分コード(trimRString(entity.get給付実績作成区分コード()));
        if (null == entity.get給付実績_証記載保険者番号() || entity.get給付実績_証記載保険者番号().isEmpty()) {
            dataEntity.set保険者番号(RString.EMPTY);
        } else {
            dataEntity.set保険者番号(entity.get給付実績_証記載保険者番号().getColumnValue().trim());
        }
        dataEntity.set被保険者証記号(trimRString(entity.get国保_被保険者証記号()));
        if (null == entity.get給付実績_被保険者番号() || entity.get給付実績_被保険者番号().isEmpty()) {
            dataEntity.set被保険者証番号(RString.EMPTY);
        } else {
            dataEntity.set被保険者証番号(entity.get給付実績_被保険者番号().getColumnValue().trim());
        }
        dataEntity.set申請年月日(trimdate(entity.get申請年月日()));
        dataEntity.set決定年月日(trimdate(entity.get決定年月日()));
        if (entity.get自己負担総額() == null) {
            dataEntity.set自己負担総額(RString.EMPTY);
        } else {
            dataEntity.set自己負担総額(new RString(entity.get自己負担総額().toString()));
        }
        if (entity.get支給額() == null) {
            dataEntity.set支給額(RString.EMPTY);
        } else {
            dataEntity.set支給額(new RString(entity.get支給額().toString()));
        }
        dataEntity.set処理年月(trimYearMonth(entity.get処理年月()));

        return dataEntity;
    }

    private KogakugassanSoufuFairuSakuseiControlEntity getControlEntity(int 連番) {
        KogakugassanSoufuFairuSakuseiControlEntity controlEntity = new KogakugassanSoufuFairuSakuseiControlEntity();
        controlEntity.setレコード種別(RecordShubetsu.コントロールレコード.getコード());
        controlEntity.setレコード番号_連番(new RString(連番));
        controlEntity.setボリュ_ム通番(ボリュム通番);
        controlEntity.setレコード件数(new RString(レコード件数));
        controlEntity.setデータ種別(ConfigKeysKokuhorenSofu.高額合算給付実績情報.getコード());
        controlEntity.set福祉事務所特定番号(固定番号_00);
        controlEntity.set保険者番号(dbu保険者番号);
        controlEntity.set事業所番号(事業所番号);
        controlEntity.set都道府県番号(固定番号_00);
        RString 媒体区分 = DbBusinessConfig
                .get(ConfigNameDBC.国保連送付媒体_合算給付実績Ｆ_媒体区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        controlEntity.set媒体区分(媒体区分);
        controlEntity.set処理対象年月(parameter.get処理年月().toDateString());
        controlEntity.setファイル管理番号(ファイル管理番号);
        return controlEntity;
    }

    private KogakugassanSoufuFairuSakuseiEndEntity getEndEntity(int 連番) {
        KogakugassanSoufuFairuSakuseiEndEntity endEntity = new KogakugassanSoufuFairuSakuseiEndEntity();
        endEntity.setレコード種別(RecordShubetsu.エンドレコード.getコード());
        endEntity.setレコード番号_連番(new RString(連番));
        return endEntity;
    }

    private void do外字類似変換() {
        try (FileReader reader = new FileReader(csvFilePath, Encode.UTF_8);
                ByteWriter writer = new ByteWriter(csvFilePath.replace(拡張子_TEMP, RString.EMPTY))) {
            for (RString record = reader.readLine(); record != null; record = reader.readLine()) {
                BinaryCharacterConvertParameter convertParameter = new BinaryCharacterConvertParameterBuilder(
                        new RecordConvertMaterial(getCharacterConvertTable(), CharacterAttribute.混在))
                        .enabledConvertError(true)
                        .build();
                ReamsUnicodeToBinaryConverter converter = new ReamsUnicodeToBinaryConverter(convertParameter);
                writer.write(converter.convert(record.concat(拡張子)));
            }
            writer.close();
            reader.close();
        }
        deleteEmptyFile(csvFilePath);
    }

    private void deleteEmptyFile(RString filePath) {
        if (RString.isNullOrEmpty(filePath)) {
            return;
        }
        File file = new File(filePath.toString());
        if (file.exists()) {
            file.getAbsoluteFile().deleteOnExit();
        }
    }

    private static CharacterConvertTable getCharacterConvertTable() {
        RString 国保連送付外字_変換区分 = DbBusinessConfig.get(ConfigNameDBC.国保連送付外字_変換区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (!変換区分_1.equals(国保連送付外字_変換区分)) {
            return CharacterConvertTable.Sjis;
        } else {
            return CharacterConvertTable.SjisRuiji;
        }
    }

    private RString trimRString(RString str) {
        return str == null || str.isEmpty() ? RString.EMPTY : str.trim();
    }

    private RString trimdate(FlexibleDate date) {
        return date == null || date.isEmpty() ? RString.EMPTY
                : date.wareki().eraType(EraType.NUMBER).firstYear(FirstYear.GAN_NEN).separator(Separator.NONE).toDateString();
    }

    private RString trimYearMonth(FlexibleYearMonth date) {
        return date == null || date.isEmpty() ? RString.EMPTY
                : date.wareki().eraType(EraType.NUMBER).firstYear(FirstYear.GAN_NEN).separator(Separator.NONE).toDateString();
    }

    private DbWT1002KokuhorenSakuseiErrorTempEntity set処理結果リスト() {
        DbWT1002KokuhorenSakuseiErrorTempEntity dbwt1002Entity = new DbWT1002KokuhorenSakuseiErrorTempEntity();
        dbwt1002Entity.setErrorKubun(KokuhorenJoho_SakuseiErrorKubun.送付対象データなし.getコード());
        dbwt1002Entity.setShoHokanehshaNo(null);
        dbwt1002Entity.setHihokenshaNo(null);
        dbwt1002Entity.setKey1(RString.EMPTY);
        dbwt1002Entity.setKey2(RString.EMPTY);
        dbwt1002Entity.setKey3(RString.EMPTY);
        dbwt1002Entity.setKey4(RString.EMPTY);
        dbwt1002Entity.setKey5(RString.EMPTY);
        dbwt1002Entity.setHihokenshaKanaShimei(RString.EMPTY);
        dbwt1002Entity.setHihokenshaShimei(RString.EMPTY);
        dbwt1002Entity.setBiko(RString.EMPTY);
        return dbwt1002Entity;
    }

}
