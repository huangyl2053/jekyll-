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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.TorisageKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShinseiRirekiJohoManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
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
    private static final RString 申請書管理番号_ZERO17 = new RString("00000000000000000");
    private RenkeiDataTorikomiBusiness business;
    private RenkeiDataTorikomiProcessParamter processParamter;
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
        dbT5101Writer.insert(business.setDbt5101Entity(entity, 登録, processParamter));
        dbT5123Writer.insert(business.getDbT5123Entity(entity, 登録));
        ShinseishoKanriNo 前回申請書管理番号 = new ShinseishoKanriNo(申請書管理番号_ZERO17);
        if (entity.getDbT5101Entity() != null && !entity.getDbT5101Entity().getShinseishoKanriNo().isEmpty()) {
            前回申請書管理番号 = getZenkaiShinseishoKanriNo(entity.getDbT5101Entity().getShinseishoKanriNo());
        }
        dbT5121Writer.insert(business.getDbT5121Entity(entity, 前回申請書管理番号));
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
    
    private ShinseishoKanriNo getZenkaiShinseishoKanriNo(ShinseishoKanriNo 今回申請書管理番号) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(今回申請書管理番号.getColumnValue());
        ShinseishoKanriNo 前回申請書管理番号 = new ShinseishoKanriNo(申請書管理番号_ZERO17);
        NinteiShinseiJohoManager ninteiShinseiJohoManager = new NinteiShinseiJohoManager();
        ShinseiRirekiJohoManager shinseiRirekiJohoManager = new ShinseiRirekiJohoManager();
        while(!申請書管理番号_ZERO17.equals(申請書管理番号.getColumnValue())) {
            NinteiShinseiJoho ninteiShinseiJoho = ninteiShinseiJohoManager.get要介護認定申請情報(申請書管理番号);
            if (TorisageKubunCode.認定申請有効.getコード().equals(ninteiShinseiJoho.get取下区分コード().getColumnValue())
                    && (ShoriJotaiKubun.通常.getコード().equals(ninteiShinseiJoho.get処理状態区分().getColumnValue()) 
                    || ShoriJotaiKubun.延期.getコード().equals(ninteiShinseiJoho.get処理状態区分().getColumnValue()))) {
                前回申請書管理番号 = ninteiShinseiJoho.get申請書管理番号();
                break;
            }
            ShinseiRirekiJoho shinseiRirekiJoho = shinseiRirekiJohoManager.get申請履歴情報ByKey(申請書管理番号);
            申請書管理番号 = shinseiRirekiJoho.get前回申請管理番号();
        }
        return 前回申請書管理番号;
    }
}
