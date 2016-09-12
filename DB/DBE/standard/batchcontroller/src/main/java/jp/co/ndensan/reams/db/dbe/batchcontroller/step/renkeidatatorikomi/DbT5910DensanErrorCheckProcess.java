/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5910ErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5910TempEntity;
import jp.co.ndensan.reams.db.dbe.service.core.renkeidatatorikomi.NinteiShinseirenkeiDataInsert;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査委託先情報一時テーブルからエラーをチェックするバッチフ処理クラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
public class DbT5910DensanErrorCheckProcess extends BatchProcessBase<DbT5910TempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi.IDbT5910TempMapper.get委託先一時情報_電算");
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbT5910Temp;
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbT5910ErrorTemp;

    @Override
    protected void createWriter() {
        dbT5910Temp = new BatchEntityCreatedTempTableWriter(new RString("DbT5910Temp"),
                DbT5910TempEntity.class);
        dbT5910ErrorTemp = new BatchEntityCreatedTempTableWriter(new RString("DbT5910ErrorTemp"),
                DbT5910ErrorTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(DbT5910TempEntity entity) {
        DbT5910ErrorTempEntity dbT5910ErrorTempEntity = new NinteiShinseirenkeiDataInsert().getDbT5910ErrorTempEntity(entity);
        if (dbT5910ErrorTempEntity != null) {
            dbT5910ErrorTemp.insert(dbT5910ErrorTempEntity);
            dbT5910Temp.delete(entity);
        }
    }
}
