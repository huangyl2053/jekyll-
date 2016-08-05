/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5911KoroshoErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5911KoroshoTempEntity;
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
public class DbT5911KoroshoErrorCheckProcess extends BatchProcessBase<DbT5911TempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi.IDbT5911TempMapper.get医療機関情報_厚労省");
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbT5911KoroshoTemp;
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbT5911ErrorKoroshoTemp;

    @Override
    protected void createWriter() {
        dbT5911KoroshoTemp = new BatchEntityCreatedTempTableWriter(new RString("DbT5911Temp"),
                DbT5911KoroshoTempEntity.class);
        dbT5911ErrorKoroshoTemp = new BatchEntityCreatedTempTableWriter(new RString("DbT5911ErrorTemp"),
                DbT5911KoroshoErrorTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(DbT5911TempEntity entity) {
        DbT5911KoroshoErrorTempEntity dbT5911KoroshoErrorTempEntity = new NinteiShinseirenkeiDataInsert().getDbT5911KoroshoErrorTempEntity(entity);
        if (dbT5911KoroshoErrorTempEntity != null) {
            dbT5911ErrorKoroshoTemp.insert(dbT5911KoroshoErrorTempEntity);
            dbT5911KoroshoTemp.delete(entity);
        }
    }
}
