/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE518002;

import jp.co.ndensan.reams.db.dbe.business.core.ninteishinsakaikekkadatatorikomi.DataTorikomiEdit;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteishinsakaikekkadatatorikomi.ShinsakaiKekkaDataTorikomiMybatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteishinsakaikekkadatatorikomi.ShinsakaiKekkaDataTorikomiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5510IchiGojiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomimobile.TempShinsakaiKekkaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteishinsakaikekkadatatorikomi.IShinsakaiKekkaDataTorikomiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5502ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会審査結果データ取込み（モバイル）Processクラスです。
 *
 * @reamsid_L DBE-1841-020 xuyongchao
 */
public class DataTorikomiProcess extends BatchProcessBase<TempShinsakaiKekkaEntity> {

    private static final RString 判定結果 = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteishinsakaikekkadatatorikomi."
            + "IShinsakaiKekkaDataTorikomiMapper.getNijiHanteikekkaTourokuJoho");
    private IShinsakaiKekkaDataTorikomiMapper mapper;
    private ShinsakaiKekkaDataTorikomiProcessParameter processParameter;
    private ShinsakaiKekkaDataTorikomiMybatisParameter mybatisParameter;
    private static final RString RSRING_1 = new RString("1");
    private DataTorikomiEdit edit;
    private FlexibleDate nowDate;

    @BatchWriter
    BatchPermanentTableWriter<DbT5510IchiGojiHanteiKekkaJohoEntity> dbT5510Writer;
    @BatchWriter
    BatchPermanentTableWriter<DbT5102NinteiKekkaJohoEntity> dbT5102Writer;
    @BatchWriter
    BatchPermanentTableWriter<DbT5105NinteiKanryoJohoEntity> dbT5105Writer;

    @Override
    protected void beforeExecute() {
        edit = new DataTorikomiEdit();
        mapper = getMapper(IShinsakaiKekkaDataTorikomiMapper.class);
        nowDate = FlexibleDate.getNowDate();
    }

    @Override
    protected void createWriter() {
        dbT5510Writer = new BatchPermanentTableWriter(DbT5510IchiGojiHanteiKekkaJohoEntity.class);
        dbT5102Writer = new BatchPermanentTableWriter(DbT5102NinteiKekkaJohoEntity.class);
        dbT5105Writer = new BatchPermanentTableWriter(DbT5105NinteiKanryoJohoEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(判定結果);
    }

    @Override
    protected void process(TempShinsakaiKekkaEntity entity) {
        if (null != entity) {
            syoriDbT5510(entity);
            syoriDbT5102(entity);
            syoriDbT5105(entity);
        }
    }

    private void syoriDbT5510(TempShinsakaiKekkaEntity entity) {
        if (RSRING_1.equals(processParameter.getTorikominaiyoukubun())) {
            DbT5510IchiGojiHanteiKekkaJohoEntity dbt5510 = mapper.getIchiGojiHanteiKekka(new ShinseishoKanriNo(entity.get申請書管理番号()));
            if (null == dbt5510) {
                dbT5510Writer.insert(edit.insertDbT5510Entity(entity));
            } else {
                dbT5510Writer.update(edit.updateDbT5510Entity(entity, dbt5510));
            }
        }
    }

    private void syoriDbT5102(TempShinsakaiKekkaEntity entity) {
        FlexibleDate 審査会資料作成年月日 = FlexibleDate.EMPTY;
        DbT5102NinteiKekkaJohoEntity dbt5102 = mapper.getNinteiKekkan(new ShinseishoKanriNo(entity.get申請書管理番号()));
        mybatisParameter = ShinsakaiKekkaDataTorikomiMybatisParameter.createParam(entity.get申請書管理番号(),
                entity.get今回_審査会開催番号(), RString.EMPTY);
        DbT5502ShinsakaiWariateJohoEntity dbt5502 = mapper.getShinsakaiWariateJoho(mybatisParameter);
        if (null != dbt5502) {
            審査会資料作成年月日 = dbt5502.getShinsakaiShiryoSakuseiYMD();
        }
        if (null == dbt5102) {
            dbT5102Writer.insert(edit.insertDbT5102Entity(entity, 審査会資料作成年月日, nowDate));
        } else {
            dbT5102Writer.update(edit.updateDbT5102Entity(entity, dbt5102, 審査会資料作成年月日, nowDate));
        }
    }

    private void syoriDbT5105(TempShinsakaiKekkaEntity entity) {
        DbT5105NinteiKanryoJohoEntity dbt5105 = mapper.getNinteiKanryo(new ShinseishoKanriNo(entity.get申請書管理番号()));
        if (null != dbt5105) {
            dbT5105Writer.update(edit.editDbT5105Entity(entity, dbt5105));
        }
    }
}
