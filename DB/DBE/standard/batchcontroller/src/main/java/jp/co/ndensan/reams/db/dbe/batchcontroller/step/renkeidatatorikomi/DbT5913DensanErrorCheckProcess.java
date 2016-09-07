/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5913ErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5913TempEntity;
import jp.co.ndensan.reams.db.dbe.service.core.renkeidatatorikomi.NinteiShinseirenkeiDataInsert;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査員情報一時テーブルからエラーをチェックするバッチフ処理クラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
public class DbT5913DensanErrorCheckProcess extends BatchProcessBase<DbT5913TempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi.IDbT5913TempMapper.get調査員情報_電算");
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbT5913Temp;
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbT5913ErrorTemp;

    @Override
    protected void createWriter() {
        dbT5913Temp = new BatchEntityCreatedTempTableWriter(new RString("DbT5913Temp"),
                DbT5913TempEntity.class);
        dbT5913ErrorTemp = new BatchEntityCreatedTempTableWriter(new RString("DbT5913ErrorTemp"),
                DbT5913ErrorTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(DbT5913TempEntity entity) {
        DbT5913ErrorTempEntity dbT5913ErrorTempEntity = new NinteiShinseirenkeiDataInsert().getDbT5913ErrorTempEntity(entity);
        if (dbT5913ErrorTempEntity != null) {
            dbT5913ErrorTemp.insert(dbT5913ErrorTempEntity);
            dbT5913Temp.delete(entity);
        }
    }
}
