/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE250001;

import jp.co.ndensan.reams.db.dbe.definition.processprm.ocr.OcrDataReadProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.csv.ocr.OcrCsvEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCR関係のCSVファイルを一時テーブルにインポートします。
 */
public class ImportOcrCsvIntoTempTable extends BatchProcessBase<RString> {

    private BatchEntityCreatedTempTableWriter<OcrCsvEntity> writer;
    private OcrDataReadProcessParameter processParameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(processParameter.getファイルPath().findCsvFilePath(), Encode.SJIS);
    }

    @Override
    protected void createWriter() {
        super.createWriter();
        this.writer = BatchWriters.batchEntityCreatedTempTableWriter(OcrCsvEntity.class)
                .tempTableName(processParameter.getTempTableName())
                .build();
    }

    @Override
    protected void process(RString t) {
        OcrCsvEntity entity = new OcrCsvEntity(t);
        this.writer.insert(entity);
    }
}
