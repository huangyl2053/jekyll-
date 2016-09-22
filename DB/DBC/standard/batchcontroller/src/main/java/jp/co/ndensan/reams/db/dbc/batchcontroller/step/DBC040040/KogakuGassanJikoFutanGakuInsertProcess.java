/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040040;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040040.JikofutanShomeishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 高額合算自己負担額Updateのprocessクラスです。
 *
 * @reamsid_L DBC-2380-030 pengxingyi
 */
public class KogakuGassanJikoFutanGakuInsertProcess extends BatchProcessBase<DbT3070KogakuGassanJikoFutanGakuEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040040."
                    + "IJikofutanShomeishoMapper.select高額合算自己負担額");
    @BatchWriter
    BatchPermanentTableWriter tableWriter;

    private JikofutanShomeishoProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchPermanentTableWriter(DbT3070KogakuGassanJikoFutanGakuEntity.class);
    }

    @Override
    protected void process(DbT3070KogakuGassanJikoFutanGakuEntity entity) {
        tableWriter.insert(entity);
    }

}
