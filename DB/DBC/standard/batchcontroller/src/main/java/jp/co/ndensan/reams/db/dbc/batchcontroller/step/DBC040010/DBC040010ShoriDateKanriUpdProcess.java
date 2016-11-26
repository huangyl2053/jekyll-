/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010;

import jp.co.ndensan.reams.db.dbc.business.core.dbc040010.DBC040010DataUtil;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.DBC040010ProcessParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMN62006_自己負担額計算（一括）の処理日付管理テーブル更新のプロセスクラスです。
 *
 * @reamsid_L DBC-2060-030 liuyang
 */
public class DBC040010ShoriDateKanriUpdProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc040010.IKogakuGassanJikofutangakuKeisanMapper.get処理日付管理");
    private DBC040010ProcessParameter parameter;
    private boolean isあり;
    private DBC040010DataUtil util;

    @BatchWriter
    private IBatchTableWriter<DbT7022ShoriDateKanriEntity> tableWriter;

    @Override
    protected void initialize() {
        isあり = false;
        util = new DBC040010DataUtil();
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchPermanentTableWriter<>(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, parameter.toDBC040010MyBatisParameter());
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity entity) {
        isあり = true;
        DbT7022ShoriDateKanriEntity result = util.getInsertOrUpdateDbT7022Entity(entity, parameter);
        tableWriter.update(result);
    }

    @Override
    protected void afterExecute() {
        if (isあり) {
            return;
        }
        DbT7022ShoriDateKanriEntity result = util.getInsertOrUpdateDbT7022Entity(null, parameter);
        tableWriter.insert(result);
    }
}
