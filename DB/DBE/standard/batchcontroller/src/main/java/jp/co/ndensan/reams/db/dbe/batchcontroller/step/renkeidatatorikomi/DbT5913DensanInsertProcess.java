/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi;

import jp.co.ndensan.reams.db.dbe.business.core.renkeidatatorikomi.RenkeiDataTorikomiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.renkeidatatorikomi.RenkeiDataTorikomiProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5913RelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査委託先一時テーブルより、認定調査委託先テーブルに登録_バッチフ処理クラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
public class DbT5913DensanInsertProcess extends BatchProcessBase<DbT5913RelateEntity> {

    private static final RString 調査員更新対象情報_電算 = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi.IDbT5913TempMapper.get調査員更新対象情報_電算");
    private static final RString 調査員更新対象情報_厚労省 = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi.IDbT5913TempMapper.get調査員更新対象情報_厚労省");
    private RenkeiDataTorikomiBusiness business;
    private RenkeiDataTorikomiProcessParamter processParamter;
    @BatchWriter
    BatchPermanentTableWriter<DbT5913ChosainJohoEntity> dbT5913Writer;

    @Override
    protected void initialize() {
        business = new RenkeiDataTorikomiBusiness();
    }

    @Override
    protected void createWriter() {
        dbT5913Writer = new BatchPermanentTableWriter(DbT5913ChosainJohoEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        if (processParamter.is厚労省フラグ()) {
            return new BatchDbReader(調査員更新対象情報_厚労省, processParamter.toRenkeiDataTorikomiMybitisParamter());
        } else {
            return new BatchDbReader(調査員更新対象情報_電算, processParamter.toRenkeiDataTorikomiMybitisParamter());
        }
    }

    @Override
    protected void process(DbT5913RelateEntity entity) {
        if (entity.getDbT5913Entity() == null) {
            dbT5913Writer.insert(business.setDbt5913Entity(entity, processParamter, true));
        } else {
            dbT5913Writer.update(business.setDbt5913Entity(entity, processParamter, false));
        }
    }
}
