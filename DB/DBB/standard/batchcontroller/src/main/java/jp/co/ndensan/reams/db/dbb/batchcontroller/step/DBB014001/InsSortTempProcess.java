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
import jp.co.ndensan.reams.uz.uza.math.Decimal;

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
    private static final RString 徴収方法_普通徴収 = new RString("0");
    private static final RString 徴収方法_併用徴収 = new RString("1");
    private static final RString 特徴開始月_0 = new RString("0");
    private static final RString 特徴開始月_4 = new RString("4");
    private static final RString 特徴開始月_6 = new RString("6");
    private static final RString 特徴開始月_8 = new RString("8");
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
        tempEntity.setChoshuHoho(徴収方法_普通徴収);
        if (0 < (getInteger(entity.getTkKibetsuGaku01()) + getInteger(entity.getTkKibetsuGaku02()) + getInteger(entity.getTkKibetsuGaku03()))) {
            tempEntity.setChoshuHoho(徴収方法_併用徴収);
        }
        tempEntity.setTkKaishiM(特徴開始月_0);
        if (0 < getInteger(entity.getTkKibetsuGaku01())) {
            tempEntity.setTkKaishiM(特徴開始月_4);
        } else if (0 < getInteger(entity.getTkKibetsuGaku02())) {
            tempEntity.setTkKaishiM(特徴開始月_6);
        } else if (0 < getInteger(entity.getTkKibetsuGaku03())) {
            tempEntity.setTkKaishiM(特徴開始月_8);
        }
        tableWriter.insert(tempEntity);
    }

    private int getInteger(Decimal dec) {
        if (dec == null) {
            return 0;
        }
        return dec.intValue();
    }
}
