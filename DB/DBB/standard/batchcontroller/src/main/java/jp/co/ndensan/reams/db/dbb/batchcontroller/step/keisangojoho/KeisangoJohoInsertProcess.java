/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.keisangojoho;

import jp.co.ndensan.reams.db.dbb.business.core.keisangojoho.KeisangoJohoResult;
import jp.co.ndensan.reams.db.dbb.definition.processprm.keisangojoho.KeisangoJohoSakuseiProcessParamter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.DbTKeisangoJohoTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 計算中間Tempテーブルから検索したデータを計算後情報一時または計算後情報に登録し、
 * <br>計算中間Tempテーブルから削除する処理を行う処理クラスです。
 *
 * @reamsid_L DBB-9060-010 duanzhanli
 */
public class KeisangoJohoInsertProcess extends BatchProcessBase<DbTKeisangoJohoTempTableEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.keisangojoho."
            + "IKeisangoJohoSakuseiMapper.");
    private static final RString 計算中間一時更新前情報 = new RString(MAPPERPATH + "get計算中間Temp更新前情報");
    private static final RString 計算中間一時更新後情報 = new RString(MAPPERPATH + "get計算中間Temp更新後情報");
    private static final RString TABLE_計算中間_NAME = new RString("KeisanTyukanTemp");
    private static final RString TABLE_計算後情報一時_NAME = new RString("DbT2015KeisangoJohoTemp");
    private KeisangoJohoSakuseiProcessParamter processParamter;
    private RString breakInsert;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 計算中間Temp;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 計算後情報Temp;
    @BatchWriter
    BatchPermanentTableWriter<DbT2015KeisangoJohoEntity> dbT2015Writer;

    @Override
    protected IBatchReader createReader() {
        breakInsert = RString.EMPTY;
        if (processParamter.is更新前フラグ()) {
            return new BatchDbReader(計算中間一時更新前情報);
        } else {
            return new BatchDbReader(計算中間一時更新後情報);
        }
    }

    @Override
    protected void createWriter() {
        計算中間Temp = new BatchEntityCreatedTempTableWriter(TABLE_計算中間_NAME,
                DbTKeisangoJohoTempTableEntity.class);
        計算後情報Temp = new BatchEntityCreatedTempTableWriter(TABLE_計算後情報一時_NAME,
                DbTKeisangoJohoTempTableEntity.class);
        dbT2015Writer = new BatchPermanentTableWriter(DbT2015KeisangoJohoEntity.class);
    }

    @Override
    protected void process(DbTKeisangoJohoTempTableEntity entity) {
        entity.setSakuseiShoriName(processParamter.getSakuseiShoriName());
        if (processParamter.is更新前フラグ()) {
            entity.setKoseiZengoKubun(new RString("1"));
            計算後情報Temp.insert(entity);
        } else {
            entity.setKoseiZengoKubun(new RString("2"));
            計算後情報Temp.insert(entity);
        }
        RString breakInsertTmp = entity.getChoteiNendo().toDateString().concat(entity.getFukaNendo().toDateString())
                .concat(entity.getTsuchishoNo().getColumnValue()).concat(entity.getKoseiZengoKubun());
        if (breakInsert.equals(breakInsertTmp)) {
            return;
        }
        breakInsert = breakInsertTmp;
        if (processParamter.isSaishinFlag2()
                || processParamter.isSaishinFlag4()
                || processParamter.isSaishinFlag5()) {
            計算後情報Temp.insert(entity);
        } else if (processParamter.isSaishinFlag3()) {
            dbT2015Writer.insert(new KeisangoJohoResult().getDbT2015Entity(entity));
        }
    }
}
