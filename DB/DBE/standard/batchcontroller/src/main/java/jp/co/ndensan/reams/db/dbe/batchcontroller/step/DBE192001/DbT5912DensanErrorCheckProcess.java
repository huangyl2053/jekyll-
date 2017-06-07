/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE192001;

import jp.co.ndensan.reams.db.dbe.definition.processprm.renkeidatatorikomi.RenkeiDataTorikomiProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5912ErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5912RelateEntity;
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
public class DbT5912DensanErrorCheckProcess extends BatchProcessBase<DbT5912RelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi.IDbT5912TempMapper.get主治医更新対象情報_電算");
    private RenkeiDataTorikomiProcessParamter processParamter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbT5912Temp;
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbT5912ErrorTemp;

    @Override
    protected void createWriter() {
        dbT5912Temp = new BatchEntityCreatedTempTableWriter(new RString("DbT5912Temp"),
                DbT5912TempEntity.class);
        dbT5912ErrorTemp = new BatchEntityCreatedTempTableWriter(new RString("DbT5912ErrorTemp"),
                DbT5912ErrorTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toRenkeiDataTorikomiMybitisParamter());
    }

    @Override
    protected void process(DbT5912RelateEntity entity) {
        DbT5912ErrorTempEntity dbT5912ErrorTempEntity = new NinteiShinseirenkeiDataInsert().getDbT5912ErrorTempEntity(entity, processParamter);
        if (dbT5912ErrorTempEntity != null) {
            dbT5912ErrorTemp.insert(dbT5912ErrorTempEntity);
            dbT5912Temp.delete(entity.getDbt5912TempEntity());
        }
    }
}
