/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi;

import jp.co.ndensan.reams.db.dbe.business.core.renkeidatatorikomi.RenkeiDataTorikomiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.renkeidatatorikomi.RenkeiDataTorikomiProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5911RelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 主治医医療機関情報一時テーブルより、認定調査委託先テーブルに登録_バッチフ処理クラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
public class DbT5911DensanInsertProcess extends BatchProcessBase<DbT5911RelateEntity> {

    private static final RString 医療機関更新対象情報_電算 = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi.IDbT5911TempMapper.get医療機関更新対象情報_電算");
    private static final RString 医療機関更新対象情報_厚労省 = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi.IDbT5911TempMapper.get医療機関更新対象情報_厚労省");
    private RenkeiDataTorikomiBusiness business;
    private RenkeiDataTorikomiProcessParamter processParamter;
    @BatchWriter
    BatchPermanentTableWriter<DbT5911ShujiiIryoKikanJohoEntity> dbT5911Writer;

    @Override
    protected void initialize() {
        business = new RenkeiDataTorikomiBusiness();
    }

    @Override
    protected void createWriter() {
        dbT5911Writer = new BatchPermanentTableWriter(DbT5911ShujiiIryoKikanJohoEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        if (processParamter.is厚労省フラグ()) {
            return new BatchDbReader(医療機関更新対象情報_厚労省, processParamter.toRenkeiDataTorikomiMybitisParamter());
        } else {
            return new BatchDbReader(医療機関更新対象情報_電算, processParamter.toRenkeiDataTorikomiMybitisParamter());
        }
    }

    @Override
    protected void process(DbT5911RelateEntity entity) {
        if (entity.getDbT5911Entity() == null) {
            dbT5911Writer.insert(business.setDbt5911Entity(entity, processParamter, true));
        } else {
            dbT5911Writer.update(business.setDbt5911Entity(entity, processParamter, false));
        }
    }
}
