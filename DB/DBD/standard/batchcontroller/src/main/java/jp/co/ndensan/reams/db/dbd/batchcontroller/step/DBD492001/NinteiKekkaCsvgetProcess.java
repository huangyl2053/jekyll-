/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD492001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd492001.RendingJieguoLianxieProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu.ErrordataIchijiTeburuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu.NichijiShinchokuIchijiTeburuEntity;
import jp.co.ndensan.reams.db.dbd.service.core.dbd492001.NinteiKekkaRenkeiDataTorikomiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchCsvListReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチパラメータ．データリストより、取込みファイルデータの取得する_process処理クラスです。
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
public class NinteiKekkaCsvgetProcess extends BatchProcessBase<List<RString>> {

    private RendingJieguoLianxieProcessParameter processParameter;
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString 日次進捗 = new RString("1");
    private static final RString 認定結果 = new RString("2");
    private static final int NUM_328 = 328;
    private static final RString エラーメッセージ = new RString("項目数が設定と異なります");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 日次進捗一時TBL;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 進捗の取込みエラー一時TBL;

    @Override
    protected void initialize() {

    }

    @Override
    protected IBatchReader createReader() {
        RString csvファイル名 = RString.EMPTY;
        if (日次進捗.equals(processParameter.get取込みデータ区分())) {
            csvファイル名 = DbBusinessConfig.get(ConfigNameDBD.日次進捗データ取込みファイル名, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
        }
        if (認定結果.equals(processParameter.get取込みデータ区分())) {
            csvファイル名 = DbBusinessConfig.get(ConfigNameDBD.要介護認定結果連携データ取込みファイル名, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
        }

//        List<UzT0885SharedFileEntryEntity> sharedFiles = SharedFile.searchSharedFile(csvファイル名);
//        if (sharedFiles == null || sharedFiles.isEmpty()) {
//            throw new BatchInterruptedException(DbzErrorMessages.アップロードファイル無し.getMessage().toString());
//        }
//
//        RString maeSharedName = RString.EMPTY;
//        RString atoSharedName = RString.EMPTY;
//        for (UzT0885SharedFileEntryEntity sharedfile : sharedFiles) {
//            atoSharedName = sharedfile.getLocalFileName();
//            if (atoSharedName.compareTo(maeSharedName) != 0) {
//                SharedFile.copyToLocal(FilesystemName.fromString(csvファイル名), FilesystemPath.fromString(Path.getTmpDirectoryPath()));
//                break;
//            }
//        }
        RString csvReaderPath = Path.combinePath(processParameter.get外部媒体格納パス(), csvファイル名);
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), csvReaderPath);
//        File file = new File(filePath.toString());
//        if (!file.exists()) {
//            throw new ApplicationException(UrErrorMessages.対象ファイルが存在しない.getMessage().replace(csvファイル名.toString()).evaluate());
//        }
        return new BatchCsvListReader(new CsvListReader.InstanceBuilder(filePath)
                .setDelimiter(CSV_WRITER_DELIMITER).setEncode(getEncode()).hasHeader(false).setNewLine(NewLine.CRLF).build());
    }

    @Override
    protected void createWriter() {
        日次進捗一時TBL = new BatchEntityCreatedTempTableWriter(NichijiShinchokuIchijiTeburuEntity.TABLE_NAME,
                NichijiShinchokuIchijiTeburuEntity.class);
        進捗の取込みエラー一時TBL = new BatchEntityCreatedTempTableWriter(ErrordataIchijiTeburuEntity.TABLE_NAME,
                ErrordataIchijiTeburuEntity.class);
    }

    @Override
    protected void process(List<RString> data) {
        ErrordataIchijiTeburuEntity errordataentity = new ErrordataIchijiTeburuEntity();
        NichijiShinchokuIchijiTeburuEntity fairudataentity = new NichijiShinchokuIchijiTeburuEntity();
        if (data != null && !data.isEmpty()) {
            if (data.size() != NUM_328) {
                NinteiKekkaRenkeiDataTorikomiManager.createInstance().進捗の取込みエラー項目設定(エラーメッセージ, data, errordataentity);
                進捗の取込みエラー一時TBL.insert(errordataentity);
            } else {
                NinteiKekkaRenkeiDataTorikomiManager.createInstance().日次進捗一時項目設定(data, fairudataentity);
                日次進捗一時TBL.insert(fairudataentity);
            }
        }
    }

    @Override
    protected void afterExecute() {
    }

    private Encode getEncode() {
        RString 連携文字コード = DbBusinessConfig.get(ConfigNameDBE.連携文字コード, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (new RString("1").equals(連携文字コード)) {
            return Encode.SJIS;
        } else {
            return Encode.UTF_8;
        }
    }

}
