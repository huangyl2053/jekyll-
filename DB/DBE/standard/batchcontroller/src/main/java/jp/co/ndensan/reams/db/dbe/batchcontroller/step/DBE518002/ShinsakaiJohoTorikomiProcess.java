/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE518002;

import jp.co.ndensan.reams.db.dbe.business.core.ninteishinsakaikekkadatatorikomi.DataTorikomiEdit;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteishinsakaikekkadatatorikomi.ShinsakaiKekkaDataTorikomiMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomimobile.TempShinsakaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteishinsakaikekkadatatorikomi.IShinsakaiKekkaDataTorikomiMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5511ShinsakaiKaisaiKekkaJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author
 */
public class ShinsakaiJohoTorikomiProcess extends BatchProcessBase<TempShinsakaiJohoEntity> {

    private static final RString 審査会情報 = new RString(
        "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteishinsakaikekkadatatorikomi."
        + "IShinsakaiKekkaDataTorikomiMapper.getShinsakaiJohoTemp");
    private IShinsakaiKekkaDataTorikomiMapper mapper;
    private DataTorikomiEdit edit;
    private ShinsakaiKekkaDataTorikomiMybatisParameter mybatisParameter;

    @BatchWriter
    BatchPermanentTableWriter<DbT5511ShinsakaiKaisaiKekkaJohoEntity> dbT5511Writer;

    @Override
    protected void beforeExecute() {
        edit = new DataTorikomiEdit();
        mapper = getMapper(IShinsakaiKekkaDataTorikomiMapper.class);
    }

    @Override
    protected void createWriter() {
        dbT5511Writer = new BatchPermanentTableWriter(DbT5511ShinsakaiKaisaiKekkaJohoEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(審査会情報);
    }

    @Override
    protected void process(TempShinsakaiJohoEntity entity) {
        if (null != entity) {
            mybatisParameter = ShinsakaiKekkaDataTorikomiMybatisParameter.createParam(
                RString.EMPTY, entity.get介護認定審査会開催番号(), RString.EMPTY);
            DbT5511ShinsakaiKaisaiKekkaJohoEntity t5511Entity = mapper.getShinsakaiJoho(mybatisParameter);
            try {
                if (null == t5511Entity) {
                    dbT5511Writer.insert(edit.insertDbT5511Entity(entity));
                } else {
                    dbT5511Writer.update(edit.updateDbT5511Entity(entity, t5511Entity));
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

}
