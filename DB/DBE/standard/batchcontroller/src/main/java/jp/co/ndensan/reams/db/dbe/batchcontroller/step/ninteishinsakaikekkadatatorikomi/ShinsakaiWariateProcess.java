/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteishinsakaikekkadatatorikomi;

import jp.co.ndensan.reams.db.dbe.business.core.ninteishinsakaikekkadatatorikomi.DataTorikomiEdit;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteishinsakaikekkadatatorikomi.ShinsakaiKekkaDataTorikomiMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomi.TmpNinteiShinsakaiWariateIinJohoItijiEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteishinsakaikekkadatatorikomi.IShinsakaiKekkaDataTorikomiMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5503ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会割当委員情報Processクラスです。
 *
 * @reamsid_L DBE-1841-020 xuyongchao
 */
public class ShinsakaiWariateProcess extends BatchProcessBase<TmpNinteiShinsakaiWariateIinJohoItijiEntity> {

    private static final RString 割当委員情報 = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteishinsakaikekkadatatorikomi."
            + "IShinsakaiKekkaDataTorikomiMapper.getShinsakaiWariateIinJoho");
    private IShinsakaiKekkaDataTorikomiMapper mapper;
    private DataTorikomiEdit edit;
    private ShinsakaiKekkaDataTorikomiMybatisParameter mybatisParameter;

    @BatchWriter
    BatchPermanentTableWriter<DbT5503ShinsakaiWariateIinJohoEntity> dbT5503Writer;

    @Override
    protected void beforeExecute() {
        edit = new DataTorikomiEdit();
        mapper = getMapper(IShinsakaiKekkaDataTorikomiMapper.class);
    }

    @Override
    protected void createWriter() {
        dbT5503Writer = new BatchPermanentTableWriter(DbT5503ShinsakaiWariateIinJohoEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(割当委員情報);
    }

    @Override
    protected void process(TmpNinteiShinsakaiWariateIinJohoItijiEntity entity) {
        if (null != entity) {
            mybatisParameter = ShinsakaiKekkaDataTorikomiMybatisParameter.createParam(RString.EMPTY,
                    entity.getShinsakaiKaisaiNo(), entity.getShinsakaiIinCode());
            DbT5503ShinsakaiWariateIinJohoEntity t5503Entity = mapper.getShinsakaiWariateIin(mybatisParameter);
            if (null == t5503Entity) {
                dbT5503Writer.insert(edit.insertDbT5503Entity(entity));
            } else {
                dbT5503Writer.update(edit.updateDbT5503Entity(entity, t5503Entity));
            }
        }
    }

}
