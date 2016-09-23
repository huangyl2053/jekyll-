/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120130;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.DbWT37H1KogakuGassanaJikofutangakuTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算自己負担額証明書情報取込ののマスタ登録です。
 *
 * @reamsid_L DBC-2640-010 zhengshenlei
 */
public class KogakuGassanJSaiSyoriJyunbiDoInsertProcess extends BatchProcessBase<DbWT37H1KogakuGassanaJikofutangakuTempEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakugassanjikofutangaku.IKogakuGassanJSaiSyoriJyunbiMapper.select連番");
    private static final RString 高額合算自己負担額一時_TABLE_NAME = new RString("DbWT37H1KogakuGassanaJikofutangaku");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額合算自己負担額一時tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void createWriter() {
        高額合算自己負担額一時tableWriter
                = new BatchEntityCreatedTempTableWriter(高額合算自己負担額一時_TABLE_NAME, DbWT37H1KogakuGassanaJikofutangakuTempEntity.class);
    }

    @Override
    protected void process(DbWT37H1KogakuGassanaJikofutangakuTempEntity entity) {
        if (entity != null) {
            update高額合算自己負担額一時();
        }
    }

    private void update高額合算自己負担額一時() {
        DbWT37H1KogakuGassanaJikofutangakuTempEntity entity = new DbWT37H1KogakuGassanaJikofutangakuTempEntity();
        entity.setJikoFutangakuSaiFlag(true);
        高額合算自己負担額一時tableWriter.update(entity);
    }

}
