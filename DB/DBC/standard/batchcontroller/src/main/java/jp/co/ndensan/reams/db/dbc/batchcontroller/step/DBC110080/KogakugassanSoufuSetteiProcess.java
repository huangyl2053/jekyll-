/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110080;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangaku.DbWT37K1KogakuGassanJikoFutanGakuTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算補正済自己負担額情報作成のバッチ送付除外区分設定Processです。
 *
 * @reamsid_L DBC-2660-030 gongliang
 */
public class KogakugassanSoufuSetteiProcess extends BatchProcessBase<DbWT37K1KogakuGassanJikoFutanGakuTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassan."
            + "IKogakugassanHoseisumiJikofutangakuOutMapper.get識別コードがないデータ");
    private static final RString 高額合算自己負担額一時NAME = new RString("DbWT37K1KogakuGassanJikoFutanGaku");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額合算自己負担額一時tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        高額合算自己負担額一時tableWriter
                = new BatchEntityCreatedTempTableWriter(高額合算自己負担額一時NAME, DbWT37K1KogakuGassanJikoFutanGakuTempEntity.class);
    }

    @Override
    protected void process(DbWT37K1KogakuGassanJikoFutanGakuTempEntity entity) {
        entity.setSofuJogaiFlag(true);
        高額合算自己負担額一時tableWriter.update(entity);
    }
}
