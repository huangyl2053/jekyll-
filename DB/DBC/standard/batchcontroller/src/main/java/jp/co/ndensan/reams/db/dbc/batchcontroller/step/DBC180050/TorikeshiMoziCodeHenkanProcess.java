/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180050.KoseiTaishoKyuhuzissekiItiranhyoShuturyokuProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.externalcharacter.reader.CsvListReaderParameter;
import jp.co.ndensan.reams.uz.uza.batch.externalcharacter.reader.CsvListReaderParameterBuilder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchFileConvertBase;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.externalcharacter.CharacterAttribute;
import jp.co.ndensan.reams.uz.uza.externalcharacter.CharacterConvertTable;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.externalcharacter.IoRecordConvertMaterial;
import jp.co.ndensan.reams.uz.uza.io.externalcharacter.reader.ConvertReaderParameter;
import jp.co.ndensan.reams.uz.uza.io.externalcharacter.writer.ConvertWriterParameter;
import jp.co.ndensan.reams.uz.uza.io.externalcharacter.writer.CsvBinaryConvertWriterParameter;
import jp.co.ndensan.reams.uz.uza.io.externalcharacter.writer.CsvBinaryConvertWriterParameterBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(文字コードに変換)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
public class TorikeshiMoziCodeHenkanProcess extends BatchFileConvertBase {

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC200097"));
    private static final RString CSV名称 = new RString("KyufuJissekiTorikeshiIchiran.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final int NUMBER_100 = 100;
    private KoseiTaishoKyuhuzissekiItiranhyoShuturyokuProcessParameter processParameter;
    private FileSpoolManager manager;

    @Override
    protected ConvertReaderParameter createReaderParameter() {
        CsvListReaderParameter readParameter = new CsvListReaderParameterBuilder(processParameter.get給付実績取消ファイルパス())
                .encode(Encode.JIS)
                .enclosure(EUC_WRITER_ENCLOSURE)
                .colDelimiter(EUC_WRITER_DELIMITER)
                .rowDelimiter(NewLine.CRLF)
                .hasHeader(false)
                .build();
        return readParameter;

    }

    @Override
    protected ConvertWriterParameter createWriterParameter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        RString fileWriteNameHeder = Path.combinePath(spoolWorkPath, CSV名称);
        int offset = 1;
        CsvBinaryConvertWriterParameter writeParameter = new CsvBinaryConvertWriterParameterBuilder(fileWriteNameHeder)
                .putIoRecordConvertMaterial(
                        offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .putIoRecordConvertMaterial(
                        ++offset, new IoRecordConvertMaterial(CharacterConvertTable.SjisRuiji, CharacterAttribute.混在, NUMBER_100))
                .enabledConvertError(true)
                .enclosure(EUC_WRITER_ENCLOSURE)
                .colDelimiter(EUC_WRITER_DELIMITER)
                .rowDelimiter(NewLine.CRLF)
                .build();
        return writeParameter;

    }
}
