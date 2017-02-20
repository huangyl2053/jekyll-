/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE010002;

import jp.co.ndensan.reams.db.dbe.definition.processprm.shinseishadataout.ShinseishaDataOutProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseishadataout.OutputTaishoTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面で指定した申請書管理番号をTempテーブルに登録するプロセスです。
 *
 * @author N3212 竹内 和紀
 */
public class TempTableCreateProcess extends SimpleBatchProcessBase {

    @BatchWriter
    private BatchEntityCreatedTempTableWriter<OutputTaishoTempEntity> tempTableWriter;
    private ShinseishaDataOutProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
        tempTableWriter = new BatchEntityCreatedTempTableWriter(OutputTaishoTempEntity.TABLE_NAME, OutputTaishoTempEntity.class);
    }

    @Override
    protected void process() {
        OutputTaishoTempEntity tempEntity;
        for (RString 申請書管理番号 : processParameter.get申請書管理番号リスト()) {
            tempEntity = new OutputTaishoTempEntity();
            tempEntity.setShinseishoKanriNo(申請書管理番号);
            tempTableWriter.insert(tempEntity);
        }
    }

}
