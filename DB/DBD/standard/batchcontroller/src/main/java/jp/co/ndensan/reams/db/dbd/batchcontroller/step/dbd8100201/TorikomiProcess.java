/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100201;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbd8100201.HikazeiNennkinTaishouSyaJohoTorikomiFlow;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201.TorikomiProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100201.TorikomiCsvDataEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100201.temptable.TorikomiTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.BatchGyomuException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.fld.FldReader;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.RLogger;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 取込データ一時作成_process処理クラスです.
 *
 * @reamsid_L DBD-4910-030 x_lilh
 */
public class TorikomiProcess extends BatchProcessBase<RString> {

    TorikomiProcessParameter parameter;
    private static final RString 月次 = new RString("1");
    private static final RString 年次 = new RString("0");
    private RString ファイル名;
    private static final RString Z5100000 = new RString("Z5100000_");
    private static final RString Z5200000 = new RString("Z5200000_");
    private static final RString アンダーライン = new RString("_");
    private static final RString 拡張子 = new RString(".DTA");
    private List<UzT0885SharedFileEntryEntity> dataList;
    FldReader<TorikomiCsvDataEntity> reader;
    private int i = 0;
    private int k = 0;
    private RString batFileName;
    private static final int ROW_LENGTH = 1514;
    private final RString エラー = new RString("入力データエラー");
    private List<RString> codeList;

    @Override
    protected void initialize() {
        dataList = new ArrayList<>();
        codeList = new ArrayList<>();
        batFileName = new RString("");
    }

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected IBatchReader createReader() {
        RString tmpPath = Path.getTmpDirectoryPath();
        FilesystemPath filesystemPath = new FilesystemPath(tmpPath);
        if (!parameter.get構成市町村コードリスト().isEmpty()) {
            for (RString 市町村コード : parameter.get構成市町村コードリスト()) {
                if (月次.equals(parameter.get処理区分())) {
                    ファイル名 = Z5200000.concat(parameter.get処理年度().toDateString())
                            .concat(parameter.get処理区分()).concat(parameter.get対象月())
                            .concat(アンダーライン).concat(市町村コード).concat(拡張子);
                    List<UzT0885SharedFileEntryEntity> fileList = getFileData(ファイル名);
                    if (!fileList.isEmpty()) {
                        dataList.addAll(fileList);
                    }
                } else if (年次.equals(parameter.get処理区分())) {
                    ファイル名 = Z5100000.concat(parameter.get処理年度().toDateString())
                            .concat(parameter.get処理区分()).concat(parameter.get対象月())
                            .concat(アンダーライン).concat(市町村コード).concat(拡張子);
                    List<UzT0885SharedFileEntryEntity> fileList = getFileData(ファイル名);
                    if (!fileList.isEmpty()) {
                        dataList.addAll(fileList);
                    }
                }
            }
        } else {
            if (月次.equals(parameter.get処理区分())) {
                ファイル名 = Z5200000.concat(parameter.get処理年度().toDateString())
                        .concat(parameter.get処理区分()).concat(parameter.get対象月()).concat(拡張子);
                List<UzT0885SharedFileEntryEntity> fileList = getFileData(ファイル名);
                if (!fileList.isEmpty()) {
                    dataList.addAll(fileList);
                }
            } else if (年次.equals(parameter.get処理区分())) {
                ファイル名 = Z5100000.concat(parameter.get処理年度().toDateString())
                        .concat(parameter.get処理区分()).concat(parameter.get対象月()).concat(拡張子);
                List<UzT0885SharedFileEntryEntity> fileList = getFileData(ファイル名);
                if (!fileList.isEmpty()) {
                    dataList.addAll(fileList);
                }
            }
        }
        if (dataList == null || dataList.size() <= 0) {
            throw new ApplicationException(DbdErrorMessages.アップロードファイル無し.getMessage());
        }
        for (UzT0885SharedFileEntryEntity entry : dataList) {
            FilesystemName filesystemName = new FilesystemName(entry.getSharedFileName());
            ReadOnlySharedFileEntryDescriptor entitydesc = new ReadOnlySharedFileEntryDescriptor(filesystemName, entry.getSharedFileId());
            SharedFile.copyToLocal(entitydesc, filesystemPath);
            batFileName = Path.combinePath(tmpPath, entry.getSharedFileName());
            reader = new FldReader.InstanceBuilder(batFileName, TorikomiCsvDataEntity.class)
                    .setEncodeShiftJis()
                    .setNewLine(NewLine.LF)
                    .build();
        }
        return new BatchSimpleReader(batFileName, Encode.UTF_8);
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(TorikomiTempTableEntity.class)
                .tempTableName(TorikomiTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(RString data) {
        try {
            if (data.toString().getBytes(Encode.SJIS.getName()).length != ROW_LENGTH) {
                batchError(エラー);
            }
        } catch (UnsupportedEncodingException e) {
            RLogger.error(new RString(e.getMessage()));
        }
    }

    @Override
    protected void afterExecute() {
        TorikomiCsvDataEntity data;

        while (null != (data = reader.readLine())) {
            tmpTableWriter.insert(setTbleName1(data));
        }
    }

    private void batchError(RString logMessage) {
        RLogger.error(logMessage);
        throw new BatchGyomuException(DbdErrorMessages.アップロードファイル無し.getMessage());
    }

    private TorikomiTempTableEntity setTbleName1(TorikomiCsvDataEntity entity) {
        TorikomiTempTableEntity data = new TorikomiTempTableEntity();
        if (!parameter.get構成市町村コードリスト().isEmpty()) {
            if (codeList.contains(entity.getトレイラ市町村コード())) {
                k = 0;
                data.setDtno(++i);
            } else {
                i = 0;
                data.setDtno(++k);
                codeList.add(entity.getトレイラ市町村コード());
            }
        } else {
            data.setDtno(++i);
        }
        if (entity != null) {
            data.setDtrekodoKubun(entity.getレコード区分());
            data.setDtshichosonCode(entity.get市町村コード());
            data.setDtDTnennkinnHokennshaCode(entity.get年金保険者コード());
            data.setDttsuuchiContentCode(entity.get通知内容コード());
            data.setDtyobi1(entity.get予備1());
            data.setDtseidoCode(entity.get制度コード());
            data.setDtcreateYMD(new FlexibleDate(entity.get作成年月日()));
            data.setDtnennkinnNo(entity.get基礎年金番号());
            data.setDtnennkinnCode(entity.get年金コード());
            data.setDtyobi2(entity.get予備2());
            data.setDtseinenngappi(entity.get生年月日());
            data.setDtseibetsu(entity.get性別());
            data.setDtkanaShimei(entity.getカナ氏名());
            data.setDtshifutoCode1(entity.getシフトコード1());
            data.setDtkanjiShimei(entity.get漢字氏名());
            data.setDtshifutoCode2(entity.getシフトコード2());
            data.setDtYubinNo(new YubinNo(entity.get郵便番号()));
            data.setDtkanaJusyo(entity.getカナ住所());
            data.setDtshifutoCode3(entity.getシフトコード3());
            data.setDtkanjiJusyo(entity.get漢字住所());
            data.setDtshifutoCode4(entity.getシフトコード4());
            data.setDtTaishoYear(new FlexibleYear(entity.get対象年()));
            data.setDtteiseiHyouji(entity.get訂正表示());
            data.setDtkakushuKubun(entity.get各種区分());
            data.setDtshoriResult(entity.get処理結果());
            data.setDtyobi3(entity.get予備3());
            data.setDtyobi4(entity.get予備4());
            if (!entity.get金額１().trim().isEmpty()) {
                data.setDtkinngaku1(Decimal.valueOf(Long.parseLong((entity.get金額１().toString()).trim())));
            } else {
                data.setDtkinngaku1(Decimal.valueOf(0));
            }
            if (!entity.get金額予備1().trim().isEmpty()) {
                data.setDtkinngakuYobi1(Decimal.valueOf(Long.parseLong((entity.get金額予備1().toString()).trim())));
            } else {
                data.setDtkinngakuYobi1(Decimal.valueOf(0));
            }
            if (!entity.get金額予備2().trim().isEmpty()) {
                data.setDtkinngakuYobi2(Decimal.valueOf(Long.parseLong((entity.get金額予備2().toString()).trim())));
            } else {
                data.setDtkinngakuYobi2(Decimal.valueOf(0));
            }
            data.setDtyobi5(entity.get予備5());
            data.setDtkyousaiNennkinnShoushoKigouNo(entity.get共済年金証書記号番号());
        }
        return data;
    }

    private List<UzT0885SharedFileEntryEntity> getFileData(RString ファイル名) {
        List<UzT0885SharedFileEntryEntity> fileList = null;
        try {
            fileList = SharedFile.searchSharedFile(ファイル名);
        } catch (Exception e) {
            Logger.getLogger(HikazeiNennkinTaishouSyaJohoTorikomiFlow.class.getName()).log(Level.SEVERE, null, e);
        }
        return fileList;
    }
}
