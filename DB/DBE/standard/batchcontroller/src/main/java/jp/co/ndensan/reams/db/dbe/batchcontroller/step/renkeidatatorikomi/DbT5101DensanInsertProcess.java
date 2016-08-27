/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi;

import jp.co.ndensan.reams.db.dbe.business.core.renkeidatatorikomi.RenkeiDataTorikomiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.renkeidatatorikomi.RenkeiDataTorikomiProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5123NinteiKeikakuJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5101RelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5101TempEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 要介護認定申請情報一時テーブルより、要介護認定申請情報テーブルに登録_バッチフ処理クラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
public class DbT5101DensanInsertProcess extends BatchProcessBase<DbT5101RelateEntity> {

    private static final RString 更新対象情報_電算東芝版 = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi.IDbT5101TempMapper.get更新対象情報_電算東芝版");
    private static final RString 更新対象情報_厚労省 = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi.IDbT5101TempMapper.get更新対象情報_厚労省");
    private static final RString 更新1 = new RString("1");
    private static final RString 更新2 = new RString("2");
    private static final RString 登録 = new RString("3");
    private RenkeiDataTorikomiBusiness business;
    private RenkeiDataTorikomiProcessParamter processParamter;
    @BatchWriter
    BatchPermanentTableWriter<DbT5101NinteiShinseiJohoEntity> dbT5101Writer;
    @BatchWriter
    BatchPermanentTableWriter<DbT5123NinteiKeikakuJohoEntity> dbT5123Writer;

    @Override
    protected void initialize() {
        business = new RenkeiDataTorikomiBusiness();
    }

    @Override
    protected void createWriter() {
        dbT5101Writer = new BatchPermanentTableWriter(DbT5101NinteiShinseiJohoEntity.class);
        dbT5123Writer = new BatchPermanentTableWriter(DbT5123NinteiKeikakuJohoEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        if (processParamter.is厚労省フラグ()) {
            return new BatchDbReader(更新対象情報_厚労省);
        } else {
            return new BatchDbReader(更新対象情報_電算東芝版);
        }

    }

    @Override
    protected void process(DbT5101RelateEntity entity) {
        if (entity.getDbT5101Entity() == null) {
            dbT5101Writer.insert(business.setDbt5101Entity(entity, 登録, processParamter));
        } else {
            if (isnull(entity)) {
                dbT5101Writer.update(business.setDbt5101Entity(entity, 更新1, processParamter));
                dbT5123Writer.update(business.getDbT5123Entity(entity, 更新1));
            } else {
                dbT5101Writer.update(business.setDbt5101Entity(entity, 更新2, processParamter));
                dbT5123Writer.update(business.getDbT5123Entity(entity, 更新2));
            }
            business.getアクセスログ(new RString(entity.getDbT5101Entity().getShinseishoKanriNo().toString()));
        }
    }

    private boolean isnull(DbT5101RelateEntity entity) {
        DbT5101NinteiShinseiJohoEntity dbt5101Entity = entity.getDbT5101Entity();
        DbT5101TempEntity dbt5101tempEntity = entity.getDbt5101TempEntity();
        RString 認定申請日 = dbt5101tempEntity.get認定申請日();
        FlexibleDate 認定申請日TEMP = dbt5101Entity.getNinteiShinseiYMD();
        return 認定申請日TEMP != null && !認定申請日TEMP.isEmpty()
                && !RString.isNullOrEmpty(認定申請日) && 認定申請日.equals(new RString(認定申請日TEMP.toString()));
    }

}
