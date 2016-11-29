/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130020;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130020.KokiKoreishaInfoCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130020.KokiKoreshaJyohoRealEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130020.TorikomiKokiKoreshaJyohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
 * 取込確認CSVファイル出力
 *
 * @reamsid_L DBC-3020-040 qinzhen
 */
public class CreateCsvFileProcess extends BatchProcessBase<KokiKoreshaJyohoRealEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130020.IKokikoreishaShikakuIdoInMapper.get取込後期高齢者情報");
    private final RString csvファイル名 = new RString("torikomikakuninkekka.csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBZ000001"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private RString eucFilePath;
    private FileSpoolManager manager;
    @BatchWriter
    private CsvWriter<KokiKoreishaInfoCsvEntity> csvWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        this.eucFilePath = Path.combinePath(spoolWorkPath, csvファイル名);
        csvWriter = new CsvWriter.InstanceBuilder(this.eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void process(KokiKoreshaJyohoRealEntity entity) {
        csvWriter.writeLine(getCsvEntity(entity.get取込後期高齢者情報Entity()));
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        manager.spool(SubGyomuCode.DBC介護給付, eucFilePath);
    }

    private KokiKoreishaInfoCsvEntity getCsvEntity(TorikomiKokiKoreshaJyohoEntity entity) {
        KokiKoreishaInfoCsvEntity csvEntity = new KokiKoreishaInfoCsvEntity();
        csvEntity.set市町村コード(entity.get市町村コード());
        csvEntity.set住民コード(entity.get住民コード());
        csvEntity.set履歴番号(entity.get履歴番号());
        csvEntity.set後期高齢保険者番号_市町村(entity.get後期高齢保険者番号_市町村());
        csvEntity.set後期高齢保険者番号_広域(entity.get後期高齢保険者番号_広域());
        csvEntity.set後期高齢被保険者番号(entity.get後期高齢被保険者番号());
        csvEntity.set資格取得事由コード(entity.get資格取得事由コード());
        csvEntity.set資格取得年月日(entity.get資格取得年月日());
        csvEntity.set資格喪失事由コード(entity.get資格喪失事由コード());
        csvEntity.set資格喪失年月日(entity.get資格喪失年月日());
        csvEntity.set保険者適用開始年月日(entity.get保険者適用開始年月日());
        csvEntity.set保険者適用終了年月日(entity.get保険者適用終了年月日());
        csvEntity.set個人区分コード(entity.get個人区分コード());
        csvEntity.set登録区分(entity.get登録区分());
        csvEntity.set更新コード(entity.get更新コード());
        csvEntity.set氏名(entity.get氏名());
        csvEntity.setカナ氏名(entity.getカナ氏名());
        csvEntity.set生年月日(entity.get生年月日());
        csvEntity.set性別コード(entity.get性別コード());
        csvEntity.set郵便番号(entity.get郵便番号());
        csvEntity.set住所(entity.get住所());
        csvEntity.set住所コード(entity.get住所コード());
        csvEntity.set行政区(entity.get行政区());
        csvEntity.set行政区コード(entity.get行政区コード());
        csvEntity.setエラーコード(entity.getエラーコード());
        csvEntity.setエラー文言(entity.getエラー文言());
        return csvEntity;
    }
}
