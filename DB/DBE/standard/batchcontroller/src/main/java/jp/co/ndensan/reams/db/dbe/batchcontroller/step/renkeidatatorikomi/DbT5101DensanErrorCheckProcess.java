/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi;

import jp.co.ndensan.reams.db.dbe.definition.processprm.renkeidatatorikomi.RenkeiDataTorikomiProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5101ErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5101TempEntity;
import jp.co.ndensan.reams.db.dbe.service.core.renkeidatatorikomi.NinteiShinseirenkeiDataInsert;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 要介護認定申請情報中間一時テーブルを要介護認定申請情報一時テーブルに登録_バッチフ処理クラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
public class DbT5101DensanErrorCheckProcess extends BatchProcessBase<DbT5101TempEntity> {

    private static final RString 申請一時電算_東芝情報 = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi.IDbT5101TempMapper.get申請一時電算_東芝情報");
    private static final RString 申請一時厚労省情報 = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi.IDbT5101TempMapper.get申請一時厚労省情報");
    private RenkeiDataTorikomiProcessParamter processParamter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbT5101Temp;
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbT5101ErrorTemp;

    @Override
    protected void createWriter() {
        dbT5101Temp = new BatchEntityCreatedTempTableWriter(new RString("DbT5101Temp"),
                DbT5101TempEntity.class);
        dbT5101ErrorTemp = new BatchEntityCreatedTempTableWriter(new RString("DbT5101ErrorTemp"),
                DbT5101ErrorTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        if (processParamter.is厚労省フラグ()) {
            return new BatchDbReader(申請一時厚労省情報);
        } else {
            return new BatchDbReader(申請一時電算_東芝情報);
        }
    }

    @Override
    protected void process(DbT5101TempEntity entity) {
        NinteiShinseirenkeiDataInsert service = new NinteiShinseirenkeiDataInsert();
        if (service.getDbT5101ErrorTempEntity(entity, processParamter) != null) {
            dbT5101ErrorTemp.insert(service.getDbT5101ErrorTempEntity(entity, processParamter));
            dbT5101Temp.delete(entity);
        }
    }

}
