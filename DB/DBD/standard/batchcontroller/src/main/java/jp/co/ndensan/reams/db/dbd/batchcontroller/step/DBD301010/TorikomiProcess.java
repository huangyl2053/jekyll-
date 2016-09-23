/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD301010;

import jp.co.ndensan.reams.db.dbd.business.core.riyoshafutanlist.RiyoshaFutanGakuGemmenNinteishaListEditor;
import jp.co.ndensan.reams.db.dbd.definition.core.convertparameter.TorikomiDtaFileRecordConverter;
import jp.co.ndensan.reams.db.dbd.definition.core.convertparameter.TorikomiRecordPunctuation;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201.TorikomiProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100201.TorikomiCsvDataEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100201.temptable.TorikomiTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchByteReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.fld.FldReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

//UNFINISHED CODE:SUPPRESS CHECKSTYLE START//
/**
 * 取込データ一時作成_process処理クラスです.
 *
 * @reamsid_L DBD-4910-030 x_lilh
 */
public class TorikomiProcess extends BatchProcessBase<byte[]> {

    TorikomiProcessParameter parameter;
    FldReader<TorikomiCsvDataEntity> reader;
    private RString batFileName;
    private static final int バイト数_96 = 96;
    private static final int バイト数_500 = 500;
    private static final RString レコード区分_2 = new RString("2");
    private BatchByteReader byteReader;
    private RiyoshaFutanGakuGemmenNinteishaListEditor torikomiEditor;

    @Override
    protected void initialize() {
        batFileName = new RString("");
        torikomiEditor = new RiyoshaFutanGakuGemmenNinteishaListEditor();
        RString tmpPath = Path.getTmpDirectoryPath();
        FilesystemPath filesystemPath = new FilesystemPath(tmpPath);
        FilesystemName filesystemName = new FilesystemName(parameter.getEntry().getSharedFileName());
        ReadOnlySharedFileEntryDescriptor entitydesc = new ReadOnlySharedFileEntryDescriptor(
                filesystemName, parameter.getEntry().getSharedFileId());
        SharedFile.copyToLocal(entitydesc, filesystemPath);
        batFileName = Path.combinePath(tmpPath, parameter.getEntry().getLocalFileName());
    }

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected IBatchReader createReader() {
        byteReader = new BatchByteReader(batFileName, バイト数_96);
        return byteReader;
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(TorikomiTempTableEntity.class)
                .tempTableName(TorikomiTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(byte[] bytes) {
        TorikomiDtaFileRecordConverter converter = new TorikomiDtaFileRecordConverter();
        RString record = converter.getBinaryToConvertCharacter(bytes);
        if (bytes.length == バイト数_500) {
            tmpTableInsert(record);
        }
        byteReader.setBytes(バイト数_500);
    }

    @Override
    protected void afterExecute() {
        byteReader.close();
    }

    private void tmpTableInsert(RString record) {
        RString レコード区分 = record.substringEmptyOnError(TorikomiRecordPunctuation.レコード区分.get開始位置(),
                TorikomiRecordPunctuation.レコード区分.get終了位置()).trim();
        if (レコード区分_2.equals(レコード区分)) {
            TorikomiCsvDataEntity dataRecordEntity = torikomiEditor.getDataRecordEntity(record, レコード区分);
            tmpTableWriter.insert(torikomiEditor.getDataRecordTempEntity(dataRecordEntity));
        }
    }
}
//UNFINISHED CODE:SUPPRESS CHECKSTYLE END//
