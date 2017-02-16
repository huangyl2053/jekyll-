/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5502ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 委員用審査対象者一覧表情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class ShinsakaiJohoUpdateProcess extends BatchProcessBase<DbT5502ShinsakaiWariateJohoEntity> {

    private static final RString SELECT_SHINSAKAIWARIATEJOHO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper.getSelectByKey_DbT5502ShinsakaiWariateJoho");
    private IinItiziHanteiProcessParameter paramter;
    private IShiryoShinsakaiIinMapper mapper;
    
    @BatchWriter
    BatchPermanentTableWriter<DbT5501ShinsakaiKaisaiYoteiJohoEntity> DbT5501TableWriter;
    BatchPermanentTableWriter<DbT5502ShinsakaiWariateJohoEntity> DbT5502TableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_SHINSAKAIWARIATEJOHO, paramter.toIinItiziHanteiMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        DbT5501TableWriter = new BatchPermanentTableWriter<>(DbT5501ShinsakaiKaisaiYoteiJohoEntity.class);
        DbT5502TableWriter = new BatchPermanentTableWriter<>(DbT5502ShinsakaiWariateJohoEntity.class);
    }

    @Override
    protected void process(DbT5502ShinsakaiWariateJohoEntity entity) {
        entity.setShinsakaiShiryoSakuseiYMD(FlexibleDate.getNowDate());
        DbT5502TableWriter.update(entity);
    }

    @Override
    protected void afterExecute() {
        mapper = getMapper(IShiryoShinsakaiIinMapper.class);
        DbT5501ShinsakaiKaisaiYoteiJohoEntity entity = mapper.getSelectByKey(paramter.toIinItiziHanteiMyBatisParameter());
        entity.setShinsakaiShiryoSakuseiYMD(FlexibleDate.getNowDate());
        entity.setShiryoSakuseiZumiFlag(true);
        DbT5501TableWriter.update(entity);
    }
}
