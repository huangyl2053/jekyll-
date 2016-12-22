/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosadataoutput;

import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosadataoutput.NinteiChosaDataOutputProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaDataOutputBatchRelateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査データ出力（モバイル）のメイン情報を取得し一時テーブルへ保存処理するクラスです。
 */
public class NinteiChosaMainDataGetProcess extends BatchProcessBase<NinteiChosaDataOutputBatchRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosadataoutput.INinteiChosaDataOutputMapper."
            + "get認定調査データ出力");
    private NinteiChosaDataOutputProcessParamter processParamter;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter<NinteiChosaDataOutputBatchRelateEntity> tempTableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toNinteiChosaDataOutputBatchMybitisParameter());
    }

    @Override
    public void createWriter() {
        tempTableWriter = new BatchEntityCreatedTempTableWriter(
                processParamter.getCsvTempTableName(), NinteiChosaDataOutputBatchRelateEntity.class, true);
    }
    
    @Override
    protected void process(NinteiChosaDataOutputBatchRelateEntity entity) {
        tempTableWriter.insert(entity);
    }

}
