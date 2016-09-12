/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi;

import jp.co.ndensan.reams.db.dbe.business.core.renkeidatatorikomi.RenkeiDataTorikomiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.renkeidatatorikomi.RenkeiDataTorikomiProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5910RelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
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
public class DbT5910DensanInsertProcess extends BatchProcessBase<DbT5910RelateEntity> {

    private static final RString 委託先更新対象情報_電算 = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi.IDbT5910TempMapper.get委託先更新対象情報_電算");
    private static final RString 委託先更新対象情報_厚労省 = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi.IDbT5910TempMapper.get委託先更新対象情報_厚労省");
    private static final RString 登録 = new RString("3");
    private RenkeiDataTorikomiBusiness business;
    private RenkeiDataTorikomiProcessParamter processParamter;
    @BatchWriter
    BatchPermanentTableWriter<DbT5910NinteichosaItakusakiJohoEntity> dbT5910Writer;

    @Override
    protected void initialize() {
        business = new RenkeiDataTorikomiBusiness();
    }

    @Override
    protected void createWriter() {
        dbT5910Writer = new BatchPermanentTableWriter(DbT5910NinteichosaItakusakiJohoEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        if (processParamter.is厚労省フラグ()) {
            return new BatchDbReader(委託先更新対象情報_厚労省, processParamter.toRenkeiDataTorikomiMybitisParamter());
        } else {
            return new BatchDbReader(委託先更新対象情報_電算, processParamter.toRenkeiDataTorikomiMybitisParamter());
        }
    }

    @Override
    protected void process(DbT5910RelateEntity entity) {
        if (entity.getDbT5910Entity() == null) {
            dbT5910Writer.insert(business.setDbt5910Entity(entity, processParamter, 登録));
        } else {
            dbT5910Writer.update(business.setDbt5910Entity(entity, processParamter, RString.EMPTY));
        }
    }
}
