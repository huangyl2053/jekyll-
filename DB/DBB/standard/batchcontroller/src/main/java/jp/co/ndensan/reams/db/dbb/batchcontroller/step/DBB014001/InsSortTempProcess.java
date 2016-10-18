/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb014001.FuchoKarisanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokarisanteifuka.SortTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課情報一時のクラスです。
 *
 * @reamsid_L DBB-0870-010 pengxingyi
 */
public class InsSortTempProcess extends BatchProcessBase<DbT2015KeisangoJohoEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuchokarisanteifuka."
                    + "IFuchoKarisanteiFukaMapper.select出力順Temp");
    private static final RString TABLE_NAME = new RString("SortTemp");
    private FuchoKarisanteiFukaProcessParameter parameter;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, SortTempEntity.class);
    }

    @Override
    protected void process(DbT2015KeisangoJohoEntity entity) {
        SortTempEntity tempEntity = new SortTempEntity();
        tempEntity.setTsuchishoNo(entity.getTsuchishoNo());
        tempEntity.setTkKaishiM(TABLE_NAME);
        tempEntity.setChoshuHoho(TABLE_NAME);
        tableWriter.insert(tempEntity);
    }

}
