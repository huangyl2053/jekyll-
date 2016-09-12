/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt00002;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00002.HchiJinoSyouriCreateProcessParamter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00002.temptable.HchiJinoSyouriKeyTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00002.temptable.TaisyoulyaYichiTetennTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象者一次特定です
 *
 * @reamsid_L DBD-3980-030 x_youyj
 */
public class HchiJinoSyouriCreateProcess extends BatchProcessBase<HchiJinoSyouriKeyTempTableEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.riyoulyagennmenn."
            + "IGennMennGennGakuTaiSyoulyaMapper.select減免減額対象者判定用ByKey");

    HchiJinoSyouriCreateProcessParamter parameter;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;
    private static final RString TABLE_NAME = new RString("TaisyoulyaYichiTetennTempTable");

    @Override
    protected IBatchReader createReader() {
        //SQLを使用、SQLの実行結果の類型はKyufuJisekiSanshoKeyTempTableEntityのリストです
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toHchiJinoSyouriCreateMybatisprmParamter());
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(TaisyoulyaYichiTetennTempTableEntity.class)
                .tempTableName(TABLE_NAME).build();
    }

    @Override
    protected void process(HchiJinoSyouriKeyTempTableEntity t) {
        // 減免減額対象者判定用根拠作成対象者一時テーブル
        TaisyoulyaYichiTetennTempTableEntity tempTableEntity = new TaisyoulyaYichiTetennTempTableEntity(t.get被保険者番号(), parameter.get基準日());
        tmpTableWriter.insert(tempTableEntity);
    }
}
