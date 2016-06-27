/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoEntity;
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
public class ShinsakaiKaisaiYoteiJohoUpdateProcess extends BatchProcessBase<DbT5501ShinsakaiKaisaiYoteiJohoEntity> {

    private static final RString SELECT_SHINASKAIIINJOHO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper.getSelectByKey");
    private IinItiziHanteiProcessParameter paramter;
    @BatchWriter
    BatchPermanentTableWriter<DbT5501ShinsakaiKaisaiYoteiJohoEntity> tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_SHINASKAIIINJOHO, paramter.toIinItiziHanteiMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchPermanentTableWriter<>(DbT5501ShinsakaiKaisaiYoteiJohoEntity.class);
    }

    @Override
    protected void process(DbT5501ShinsakaiKaisaiYoteiJohoEntity entity) {
        entity.setShinsakaiShiryoSakuseiYMD(FlexibleDate.getNowDate());
        entity.setShiryoSakuseiZumiFlag(true);
        tableWriter.update(entity);
    }

    @Override
    protected void afterExecute() {
    }

}
