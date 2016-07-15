/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.keisangojoho;

import java.util.List;
import jp.co.ndensan.reams.ca.cax.business.search.CaFt702FindTotalShunyuFunction;
import jp.co.ndensan.reams.ca.cax.business.search.TotalShunyuSearchKeyBuilder;
import jp.co.ndensan.reams.ca.cax.definition.core.shuno.SearchSaishutsuKubun;
import jp.co.ndensan.reams.ca.cax.definition.core.shuno.SearchSokuhoKubun;
import jp.co.ndensan.reams.db.dbb.business.core.keisangojoho.KeisangoJohoResult;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.keisangojoho.KeisangoJohoSakuseiMybitisParamter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.keisangojoho.KeisangoJohoSakuseiProcessParamter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.DbTKeisangoJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.keisangojoho.IKeisangoJohoSakuseiMapper;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 検索した更新前賦課情報を計算中間Tempテーブルに登録する処理クラスです。
 *
 * @reamsid_L DBB-9060-010 duanzhanli
 */
public class TyukanTempBeforeInsertProcess extends BatchProcessBase<DbT2002FukaEntity> {

    private static final RString 更新前賦課情報 = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.keisangojoho."
            + "IKeisangoJohoSakuseiMapper.get更新前賦課情報");
    private static final RString TABLE_計算中間_NAME = new RString("KeisanTyukanTemp");
    private IKeisangoJohoSakuseiMapper iKeisangoJohoSakuseiMapper;
    private KeisangoJohoResult keisangoJohoResult;
    private KeisangoJohoSakuseiProcessParamter processParamter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 計算中間Temp;

    @Override
    protected void initialize() {
        setMybatisParamter();
        iKeisangoJohoSakuseiMapper = getMapper(IKeisangoJohoSakuseiMapper.class);
        keisangoJohoResult = new KeisangoJohoResult();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(更新前賦課情報, setMybatisParamter());
    }

    @Override
    protected void createWriter() {
        計算中間Temp = new BatchEntityCreatedTempTableWriter(TABLE_計算中間_NAME,
                DbTKeisangoJohoTempTableEntity.class);
    }

    @Override
    protected void process(DbT2002FukaEntity entity) {
        計算中間Temp.insert(keisangoJohoResult.get計算中間Entity(entity));
    }

    @Override
    protected void afterExecute() {
        List<DbTKeisangoJohoTempTableEntity> tempEntityList = iKeisangoJohoSakuseiMapper.get計算中間Temp更新後情報();
        for (DbTKeisangoJohoTempTableEntity tempEntity : tempEntityList) {
            計算中間Temp.delete(tempEntity);
        }
    }

    private KeisangoJohoSakuseiMybitisParamter setMybatisParamter() {
        TotalShunyuSearchKeyBuilder searchKey = new TotalShunyuSearchKeyBuilder(SearchSokuhoKubun.全て, SearchSaishutsuKubun.全て);
        CaFt702FindTotalShunyuFunction psmEntity = new CaFt702FindTotalShunyuFunction(searchKey);
        return KeisangoJohoSakuseiMybitisParamter.createSelectByKeyParam(processParamter.getChoteiNendo(),
                processParamter.getFukaNendo(),
                processParamter.getChoteiNichiji(),
                processParamter.getChohyoBunruiID(),
                new RString(psmEntity.toString()),
                YMDHMS.now());
    }
}
