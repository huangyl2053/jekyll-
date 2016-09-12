/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5912KoroshoErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5912KoroshoTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5912TempEntity;
import jp.co.ndensan.reams.db.dbe.service.core.renkeidatatorikomi.NinteiShinseirenkeiDataInsert;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 主治医情報一時テーブルからエラーをチェックするバッチフ処理クラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
public class DbT5912KoroshoErrorCheckProcess extends BatchProcessBase<DbT5912TempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi.IDbT5912TempMapper.get主治医情報_厚労省");
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbT5912KoroshoTemp;
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbT5912KoroshoErrorTemp;

    @Override
    protected void createWriter() {
        dbT5912KoroshoTemp = new BatchEntityCreatedTempTableWriter(new RString("DbT5912Temp"),
                DbT5912KoroshoTempEntity.class);
        dbT5912KoroshoErrorTemp = new BatchEntityCreatedTempTableWriter(new RString("DbT5912ErrorTemp"),
                DbT5912KoroshoErrorTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(DbT5912TempEntity entity) {
        DbT5912KoroshoErrorTempEntity dbT5912KoroshoErrorTempEntity = new NinteiShinseirenkeiDataInsert().getDbT5912KoroshoErrorTempEntity(entity);
        if (dbT5912KoroshoErrorTempEntity != null) {
            dbT5912KoroshoErrorTemp.insert(dbT5912KoroshoErrorTempEntity);
            dbT5912KoroshoTemp.delete(entity);
        }
    }
}
