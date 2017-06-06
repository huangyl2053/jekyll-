/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE192001;

import jp.co.ndensan.reams.db.dbe.business.core.renkeidatatorikomi.RenkeiDataTorikomiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.renkeidatatorikomi.RenkeiDataTorikomiProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5123NinteiKeikakuJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5129TennyuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5130ShiboEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5101RelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.config.FourMasterConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 要介護認定申請情報一時テーブルより、要介護認定申請情報テーブルに登録_バッチフ処理クラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
public class DbT5101DensanInsertProcess extends BatchProcessBase<DbT5101RelateEntity> {

    private static final RString 更新対象情報_電算版 = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi.IDbT5101TempMapper.get更新対象情報_電算版");
    private static final RString 更新対象情報_東芝版 = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi.IDbT5101TempMapper.get更新対象情報_東芝版");
    private static final RString 更新対象情報_厚労省 = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi.IDbT5101TempMapper.get更新対象情報_厚労省");
    private static final RString 登録 = new RString("3");
    private RenkeiDataTorikomiBusiness business;
    private RenkeiDataTorikomiProcessParamter processParamter;
    private RString 四マスタ管理方法;
    private RString 広域保険者市町村コード;
    private static final RString 四マスタ管理方法_構成市町村 = new RString("1");
    @BatchWriter
    BatchPermanentTableWriter<DbT5101NinteiShinseiJohoEntity> dbT5101Writer;
    @BatchWriter
    BatchPermanentTableWriter<DbT5123NinteiKeikakuJohoEntity> dbT5123Writer;
    @BatchWriter
    BatchPermanentTableWriter<DbT5105NinteiKanryoJohoEntity> dbT5105Writer;
    @BatchWriter
    BatchPermanentTableWriter<DbT5121ShinseiRirekiJohoEntity> dbT5121Writer;
    @BatchWriter
    BatchPermanentTableWriter<DbT5129TennyuEntity> dbT5129Writer;
    @BatchWriter
    BatchPermanentTableWriter<DbT5130ShiboEntity> dbT5130Writer;
    @BatchWriter
    BatchPermanentTableWriter<DbT5120ShinseitodokedeJohoEntity> dbT5120Writer;
    @BatchWriter
    BatchPermanentTableWriter<DbT5102NinteiKekkaJohoEntity> dbt5102Writer;

    @Override
    protected void initialize() {
        四マスタ管理方法 = new FourMasterConfig().get四マスタ管理方法();
        広域保険者市町村コード = DbBusinessConfig.get(ConfigNameDBE.広域保険者市町村コード, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        business = new RenkeiDataTorikomiBusiness();
    }

    @Override
    protected void createWriter() {
        dbT5101Writer = new BatchPermanentTableWriter(DbT5101NinteiShinseiJohoEntity.class);
        dbT5123Writer = new BatchPermanentTableWriter(DbT5123NinteiKeikakuJohoEntity.class);
        dbT5105Writer = new BatchPermanentTableWriter(DbT5105NinteiKanryoJohoEntity.class);
        dbT5121Writer = new BatchPermanentTableWriter(DbT5121ShinseiRirekiJohoEntity.class);
        dbT5129Writer = new BatchPermanentTableWriter(DbT5129TennyuEntity.class);
        dbT5130Writer = new BatchPermanentTableWriter(DbT5130ShiboEntity.class);
        dbT5120Writer = new BatchPermanentTableWriter(DbT5120ShinseitodokedeJohoEntity.class);
        dbt5102Writer = new BatchPermanentTableWriter(DbT5102NinteiKekkaJohoEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        if (processParamter.is厚労省フラグ()) {
            return new BatchDbReader(更新対象情報_厚労省);
        } else if (processParamter.is東芝版フラグ()) {
            return new BatchDbReader(更新対象情報_東芝版);
        } else {
            return new BatchDbReader(更新対象情報_電算版);
        }

    }

    @Override
    protected void process(DbT5101RelateEntity entity) {
        if (!四マスタ管理方法_構成市町村.equals(四マスタ管理方法)) {
            entity.getDbT7051Entity().setShichosonCode(new LasdecCode(広域保険者市町村コード));
        }
        dbT5101Writer.insert(business.setDbt5101Entity(entity, 登録, processParamter));
        dbT5123Writer.insert(business.getDbT5123Entity(entity, 登録));
        dbT5121Writer.insert(business.getDbT5121Entity(entity));
        dbT5120Writer.insert(business.getDbT5120Entity(entity, processParamter));
        if (entity.getDbt5101TempEntity().get申請区分_申請時コード().equals(NinteiShinseiShinseijiKubunCode.職権.getコード())) {
            dbT5105Writer.insert(business.getDbT5105Entity(entity, false, processParamter));
        } else if (entity.getDbt5101TempEntity().get申請区分_申請時コード().equals(NinteiShinseiShinseijiKubunCode.転入申請.getコード())) {
            dbT5105Writer.insert(business.getDbT5105Entity(entity, false, processParamter));
            dbT5129Writer.insert(business.getDbT5129Entity(entity));
            dbt5102Writer.insert(business.getDbT5102Entity(entity));
        } else if (entity.getDbt5101TempEntity().get申請区分_申請時コード().equals(NinteiShinseiShinseijiKubunCode.資格喪失_死亡.getコード())) {
            dbT5105Writer.insert(business.getDbT5105Entity(entity, false, processParamter));
            dbT5130Writer.insert(business.getDbT5130Entity(entity));
        } else {
            dbT5105Writer.insert(business.getDbT5105Entity(entity, true, processParamter));
        }
    }
}
