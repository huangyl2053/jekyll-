/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5910KoroshoErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5910KoroshoTempEntity;
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
public class DbT5910KoroshoErrorCheckProcess extends BatchProcessBase<DbT5910TempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi.IDbT5910TempMapper.get委託先情報_厚労省");
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbT5910KoroshoTemp;
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbT5910KoroshoErrorTemp;

    @Override
    protected void createWriter() {
        dbT5910KoroshoTemp = new BatchEntityCreatedTempTableWriter(new RString("DbT5910Temp"),
                DbT5910KoroshoTempEntity.class);
        dbT5910KoroshoErrorTemp = new BatchEntityCreatedTempTableWriter(new RString("DbT5910ErrorTemp"),
                DbT5910KoroshoErrorTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(DbT5910TempEntity entity) {
        DbT5910KoroshoErrorTempEntity errorTempEntity = new NinteiShinseirenkeiDataInsert().getDbT5910KoroshoErrorTempEntity(entity);
        if (errorTempEntity != null) {
            dbT5910KoroshoErrorTemp.insert(errorTempEntity);
            dbT5910KoroshoTemp.delete(entity);
        }
    }
}
