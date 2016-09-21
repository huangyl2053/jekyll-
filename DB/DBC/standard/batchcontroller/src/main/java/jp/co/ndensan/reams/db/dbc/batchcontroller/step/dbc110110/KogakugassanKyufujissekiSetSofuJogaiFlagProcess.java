/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110110;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiout.DbWT38Q1KogakuGassanKyufuJissekiTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算給付実績情報作成のバッチ送付除外区分設定Processです。
 *
 * @reamsid_L DBC-2710-030 wangxue
 */
public class KogakugassanKyufujissekiSetSofuJogaiFlagProcess extends BatchProcessBase<DbWT38Q1KogakuGassanKyufuJissekiTempEntity> {

    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassankyufujissekiout."
            + "IKogakugassanKyufujissekiOutMapper.get識別コード無しの対象データ");
    private static final RString 高額合算給付実績一時_NAME = new RString("DbWT38Q1KogakuGassanKyufuJisseki");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter 高額合算給付実績一時Writer;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_PATH);
    }

    @Override
    protected void createWriter() {
        高額合算給付実績一時Writer = new BatchEntityCreatedTempTableWriter(高額合算給付実績一時_NAME,
                DbWT38Q1KogakuGassanKyufuJissekiTempEntity.class);
    }

    @Override
    protected void process(DbWT38Q1KogakuGassanKyufuJissekiTempEntity entity) {
        entity.setSofuJogaiFlag(true);
        高額合算給付実績一時Writer.update(entity);
    }

}
