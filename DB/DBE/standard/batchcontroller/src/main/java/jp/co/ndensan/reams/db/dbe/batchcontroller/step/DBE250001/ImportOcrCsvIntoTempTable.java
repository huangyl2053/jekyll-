/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE250001;

import jp.co.ndensan.reams.db.dbe.definition.processprm.ocr.ImportOcrCsvIntoTempTableParamter;
import jp.co.ndensan.reams.db.dbe.entity.csv.ocr.TempOcrCsvEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCR関係のCSVファイルを一時テーブルにインポートします。
 */
public class ImportOcrCsvIntoTempTable extends BatchProcessBase<RString> {

    @BatchWriter
    private BatchEntityCreatedTempTableWriter<TempOcrCsvEntity> writer;
    private ImportOcrCsvIntoTempTableParamter processParameter;
    private int lineNum;

    @Override
    protected void initialize() {
        lineNum = 0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(processParameter.getCsvFilePath(), Encode.SJIS);
    }

    @Override
    protected void createWriter() {
        super.createWriter();
        this.writer = BatchWriters.batchEntityCreatedTempTableWriter(TempOcrCsvEntity.class)
                .tempTableName(processParameter.getTempTableName())
                .build();
    }

    @Override
    protected void process(RString t) {
        TempOcrCsvEntity entity = new TempOcrCsvEntity(t, ++lineNum);
        this.writer.insert(entity);
    }
}
