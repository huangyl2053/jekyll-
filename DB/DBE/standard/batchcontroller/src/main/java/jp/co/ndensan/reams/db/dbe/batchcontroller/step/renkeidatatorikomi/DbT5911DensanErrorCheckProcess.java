/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5911ErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5911TempEntity;
import jp.co.ndensan.reams.db.dbe.service.core.renkeidatatorikomi.NinteiShinseirenkeiDataInsert;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 主治医医療機関情報一時テーブルからエラーをチェックするバッチフ処理クラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
public class DbT5911DensanErrorCheckProcess extends BatchProcessBase<DbT5911TempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi.IDbT5911TempMapper.get医療機関情報_電算");
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbT5911Temp;
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbT5911ErrorTemp;

    @Override
    protected void createWriter() {
        dbT5911Temp = new BatchEntityCreatedTempTableWriter(new RString("DbT5911Temp"),
                DbT5911TempEntity.class);
        dbT5911ErrorTemp = new BatchEntityCreatedTempTableWriter(new RString("DbT5911ErrorTemp"),
                DbT5911ErrorTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(DbT5911TempEntity entity) {
        DbT5911ErrorTempEntity dbT5911ErrorTempEntity = new NinteiShinseirenkeiDataInsert().getDbT5911ErrorTempEntity(entity);
        if (dbT5911ErrorTempEntity != null) {
            dbT5911ErrorTemp.insert(dbT5911ErrorTempEntity);
            dbT5911Temp.delete(entity);
        }
    }
}
