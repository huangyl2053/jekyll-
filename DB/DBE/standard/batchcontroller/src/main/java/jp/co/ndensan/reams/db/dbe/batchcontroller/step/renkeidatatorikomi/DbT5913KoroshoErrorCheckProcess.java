/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5913KoroshoErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5913KoroshoTempEntity;
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
public class DbT5913KoroshoErrorCheckProcess extends BatchProcessBase<DbT5913TempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi.IDbT5913TempMapper.get調査員情報_厚労省");
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbT5913KoroshoTemp;
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbT5913KoroshoErrorTemp;

    @Override
    protected void createWriter() {
        dbT5913KoroshoTemp = new BatchEntityCreatedTempTableWriter(new RString("DbT5913Temp"),
                DbT5913KoroshoTempEntity.class);
        dbT5913KoroshoErrorTemp = new BatchEntityCreatedTempTableWriter(new RString("DbT5913ErrorTemp"),
                DbT5913KoroshoErrorTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(DbT5913TempEntity entity) {
        DbT5913KoroshoErrorTempEntity dbT5913KoroshoErrorTempEntity = new NinteiShinseirenkeiDataInsert().getDbT5913KoroshoErrorTempEntity(entity);
        if (dbT5913KoroshoErrorTempEntity != null) {
            dbT5913KoroshoErrorTemp.insert(dbT5913KoroshoErrorTempEntity);
            dbT5913KoroshoTemp.delete(entity);
        }
    }
}
