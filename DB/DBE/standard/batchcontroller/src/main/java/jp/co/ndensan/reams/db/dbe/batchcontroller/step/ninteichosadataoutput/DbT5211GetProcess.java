/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosadataoutput;

import jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput.DbT5211GetProcessKeyBreakCore;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosadataoutput.NinteiChosaDataOutputProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaDataOutputBatchRelateEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査票（基本調査）調査項目情報を取得し取得したEntityを一時テーブルにセットする処理です。
 */
public class DbT5211GetProcess extends BatchKeyBreakBase<NinteiChosaDataOutputBatchRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosadataoutput.INinteiChosaDataOutputMapper."
            + "getDbT5211");
    private NinteiChosaDataOutputProcessParamter processParamter;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter<NinteiChosaDataOutputBatchRelateEntity> tempTableWriter;

    private DbT5211GetProcessKeyBreakCore keyBreakCore;

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
    protected void beforeExecute() {
        keyBreakCore = new DbT5211GetProcessKeyBreakCore();
    }

    @Override
    protected void keyBreakProcess(NinteiChosaDataOutputBatchRelateEntity current) {
        NinteiChosaDataOutputBatchRelateEntity updateEntity = keyBreakCore.keyBreakProcess(getBefore(), current);
        if (updateEntity != null) {
            tempTableWriter.update(updateEntity);
        }
    }

    @Override
    protected void usualProcess(NinteiChosaDataOutputBatchRelateEntity current) {
        if (KoroshoInterfaceShikibetsuCode.V09A.getCode().equals(current.get厚労省IF識別コード())
                || KoroshoInterfaceShikibetsuCode.V09B.getCode().equals(current.get厚労省IF識別コード())) {
            keyBreakCore.usualProcess(current);
        }
    }

    @Override
    protected void afterExecute() {
        if (keyBreakCore.getLastLow() != null) {
            tempTableWriter.update(keyBreakCore.getLastLow());
        }
    }

}
