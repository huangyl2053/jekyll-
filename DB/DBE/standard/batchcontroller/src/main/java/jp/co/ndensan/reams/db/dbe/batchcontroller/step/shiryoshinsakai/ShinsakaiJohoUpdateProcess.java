/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.ShinsakaiShiryoUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5502ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5504ShinsakaiWariateJohoKenshuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 委員用審査対象者一覧表情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class ShinsakaiJohoUpdateProcess extends SimpleBatchProcessBase {

    private ShinsakaiShiryoUpdateProcessParameter paramter;
    private IShiryoShinsakaiIinMapper mapper;

    @BatchWriter
    BatchPermanentTableWriter<DbT5501ShinsakaiKaisaiYoteiJohoEntity> DbT5501TableWriter;
    @BatchWriter
    BatchPermanentTableWriter<DbT5502ShinsakaiWariateJohoEntity> DbT5502TableWriter;
    @BatchWriter
    BatchPermanentTableWriter<DbT5504ShinsakaiWariateJohoKenshuEntity> DbT5504TableWriter;

    @Override
    protected void beforeExecute() {
        DbT5501TableWriter = new BatchPermanentTableWriter(DbT5501ShinsakaiKaisaiYoteiJohoEntity.class);
        DbT5502TableWriter = new BatchPermanentTableWriter(DbT5502ShinsakaiWariateJohoEntity.class);
        DbT5504TableWriter = new BatchPermanentTableWriter(DbT5504ShinsakaiWariateJohoKenshuEntity.class);
    }

    @Override
    protected void process() {
        mapper = getMapper(IShiryoShinsakaiIinMapper.class);
        DbT5501ShinsakaiKaisaiYoteiJohoEntity entity = mapper.getSelectByKey(paramter.toShinsakaiShiryoUpdateMyBatisParameter());
        entity.setShinsakaiShiryoSakuseiYMD(FlexibleDate.getNowDate());
        entity.setShiryoSakuseiZumiFlag(true);
        DbT5501TableWriter.update(entity);

        if (paramter.toShinsakaiShiryoUpdateMyBatisParameter().isGogitaiDummyFlag()) {
            List<DbT5504ShinsakaiWariateJohoKenshuEntity> dbt5504EntityList
                    = mapper.getSelectByKey_DbT5504ShinsakaiWariateJohoKenshu(paramter.toShinsakaiShiryoUpdateMyBatisParameter());
            for (DbT5504ShinsakaiWariateJohoKenshuEntity dbt5504Entity : dbt5504EntityList) {
                dbt5504Entity.setShinsakaiShiryoSakuseiYMD(FlexibleDate.getNowDate());
                DbT5504TableWriter.update(dbt5504Entity);
            }
        } else {
            List<DbT5502ShinsakaiWariateJohoEntity> dbt5502EntityList
                    = mapper.getSelectByKey_DbT5502ShinsakaiWariateJoho(paramter.toShinsakaiShiryoUpdateMyBatisParameter());
            for (DbT5502ShinsakaiWariateJohoEntity dbt5502Entity : dbt5502EntityList) {
                dbt5502Entity.setShinsakaiShiryoSakuseiYMD(FlexibleDate.getNowDate());
                DbT5502TableWriter.update(dbt5502Entity);
            }
        }
    }

    @Override
    protected void afterExecute() {
    }
}
