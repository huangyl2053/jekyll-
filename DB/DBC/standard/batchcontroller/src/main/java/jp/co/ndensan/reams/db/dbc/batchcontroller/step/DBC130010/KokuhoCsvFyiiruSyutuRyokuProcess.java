/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130010;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130010.KokuhoJyohoTorikomiKakuNinCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130010.TorikomiKokuhoJyohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * バッチ設計_DBC130010_国保資格異動情報取込(取込確認CSVファイル出力)
 *
 * @reamsid_L DBC-3020-030 dengwei
 */
public class KokuhoCsvFyiiruSyutuRyokuProcess extends BatchProcessBase<TorikomiKokuhoJyohoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130010.IKokuhoShikakuIdoInMapper.get取込国保情報Temp");
    @BatchWriter
    private CsvWriter<KokuhoJyohoTorikomiKakuNinCsvEntity> csvWriter;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBZ000001"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private RString eucFilePath;
    private FileSpoolManager manager;
    private static final RString CSVファイル名 = new RString("ShoriKekkaKakuninList.csv");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        this.eucFilePath = Path.combinePath(spoolWorkPath, CSVファイル名);
        csvWriter = new CsvWriter.InstanceBuilder(this.eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void process(TorikomiKokuhoJyohoEntity entity) {
        csvWriter.writeLine(getCsvEntity(entity));
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
    }

    private KokuhoJyohoTorikomiKakuNinCsvEntity getCsvEntity(TorikomiKokuhoJyohoEntity entity) {
        KokuhoJyohoTorikomiKakuNinCsvEntity csvEntity = new KokuhoJyohoTorikomiKakuNinCsvEntity();
        csvEntity.set市町村コード(entity.get市町村コード());
        csvEntity.setIN住民コード(entity.getIN住民コード());
        csvEntity.set履歴番号(entity.get履歴番号());
        csvEntity.set国保番号(entity.get国保番号());
        csvEntity.set国保資格取得年月日(entity.get国保資格取得年月日());
        csvEntity.set国保資格喪失年月日(entity.get国保資格喪失年月日());
        csvEntity.set国保保険者番号(entity.get国保保険者番号());
        csvEntity.set国保保険証番号(entity.get国保保険証番号());
        csvEntity.set国保個人番号(entity.get国保個人番号());
        csvEntity.set国保退職該当日(entity.get国保退職該当日());
        csvEntity.set国保退職非該当日(entity.get国保退職非該当日());
        csvEntity.set個人区分コード(entity.get個人区分コード());
        csvEntity.set登録区分(entity.get登録区分());
        csvEntity.set更新コード(entity.get更新コード());
        csvEntity.set氏名(entity.get氏名());
        csvEntity.setカナ氏名(entity.getカナ氏名());
        csvEntity.set生年月日(entity.get生年月日());
        csvEntity.set性別コード(entity.get性別コード());
        csvEntity.set郵便番号(entity.get郵便番号());
        csvEntity.set住所(entity.get住所());
        csvEntity.set方書(entity.get方書());
        csvEntity.setエラーコード(entity.getエラーコード());
        csvEntity.setエラー文言(entity.getエラー文言());

        return csvEntity;
    }
}
