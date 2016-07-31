/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.keisangojoho;

import jp.co.ndensan.reams.ca.cax.business.search.CaFt702FindTotalShunyuFunction;
import jp.co.ndensan.reams.ca.cax.business.search.TotalShunyuSearchKeyBuilder;
import jp.co.ndensan.reams.ca.cax.definition.core.shuno.SearchSaishutsuKubun;
import jp.co.ndensan.reams.ca.cax.definition.core.shuno.SearchSokuhoKubun;
import jp.co.ndensan.reams.db.dbb.business.core.keisangojoho.KeisangoJohoResult;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.keisangojoho.KeisangoJohoSakuseiMybitisParamter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.keisangojoho.KeisangoJohoSakuseiProcessParamter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.DbTKeisangoJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.KeisangoJohoSakuseiRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 期別金額から計算中間Tempのデータを更新する処理クラスです。
 *
 * @reamsid_L DBB-9060-010 duanzhanli
 */
public class KibetsuUpdateProcess extends BatchProcessBase<KeisangoJohoSakuseiRelateEntity> {

    private static final RString 期別金額取得 = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.keisangojoho."
            + "IKeisangoJohoSakuseiMapper.get期別金額");
    private static final RString TABLE_計算中間_NAME = new RString("KeisanTyukanTemp");
    private KeisangoJohoSakuseiProcessParamter processParamter;
    private DbTKeisangoJohoTempTableEntity 計算中間TempEnitty;
    private TsuchishoNo tsuchishoNo = TsuchishoNo.EMPTY;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 計算中間Temp;

    @Override
    protected void initialize() {
        setMybatisParamter();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(期別金額取得, setMybatisParamter());
    }

    @Override
    protected void createWriter() {
        計算中間Temp = new BatchEntityCreatedTempTableWriter(TABLE_計算中間_NAME,
                DbTKeisangoJohoTempTableEntity.class);
    }

    @Override
    protected void process(KeisangoJohoSakuseiRelateEntity entity) {
        if (tsuchishoNo.equals(entity.get介護期別Entity().getTsuchishoNo())) {
            tsuchishoNo = entity.get介護期別Entity().getTsuchishoNo();
            計算中間TempEnitty = new KeisangoJohoResult().get中間Entity(entity, processParamter.is更新前フラグ(), 計算中間TempEnitty);
        } else {
            if (計算中間TempEnitty != null) {
                計算中間Temp.update(計算中間TempEnitty);
            }
            計算中間TempEnitty = new DbTKeisangoJohoTempTableEntity();
            tsuchishoNo = entity.get介護期別Entity().getTsuchishoNo();
            計算中間TempEnitty = new KeisangoJohoResult().get中間Entity(entity, processParamter.is更新前フラグ(), 計算中間TempEnitty);
        }
    }

    @Override
    protected void afterExecute() {
        if (計算中間TempEnitty != null) {
            計算中間Temp.update(計算中間TempEnitty);
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
