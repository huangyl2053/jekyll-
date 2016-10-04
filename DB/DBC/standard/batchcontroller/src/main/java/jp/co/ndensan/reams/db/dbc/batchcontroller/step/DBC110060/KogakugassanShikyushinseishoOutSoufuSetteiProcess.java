/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110060;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.DbWT3711KogakuGassanShinseishoTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算支給申請書情報作成の送付除外区分設定Process
 *
 * @reamsid_L DBC-2630-030 wangxue
 */
public class KogakugassanShikyushinseishoOutSoufuSetteiProcess extends BatchProcessBase<DbWT3711KogakuGassanShinseishoTempEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110060."
            + "IKogakugassanShikyushinseishoOutMapper.get識別コードがないデータ");
    private static final RString 高額合算申請書一時TABLE_NAME = new RString("DbWT3711KogakuGassanShinseisho");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額合算申請書一時tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void createWriter() {
        高額合算申請書一時tableWriter = new BatchEntityCreatedTempTableWriter(高額合算申請書一時TABLE_NAME,
                DbWT3711KogakuGassanShinseishoTempEntity.class);
    }

    @Override
    protected void process(DbWT3711KogakuGassanShinseishoTempEntity entity) {
        entity.setSofuJogaiFlag(true);
        高額合算申請書一時tableWriter.update(entity);
    }

}
