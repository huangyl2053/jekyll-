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
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.KeisangoJohoSakuseiRelateEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.keisangojoho.IKeisangoJohoSakuseiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 計算中間Tempの更新後データを更新する処理クラスです。
 *
 * @reamsid_L DBB-9060-010 duanzhanli
 */
public class TyukanTempUpdateProcess extends BatchProcessBase<KeisangoJohoSakuseiRelateEntity> {

    private static final RString 期別金額取得 = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.keisangojoho."
            + "IKeisangoJohoSakuseiMapper.get期別金額");
    private static final RString TABLE_計算中間_NAME = new RString("KeisanTyukanTemp");
    private IKeisangoJohoSakuseiMapper iKeisangoJohoSakuseiMapper;
    private KeisangoJohoResult keisangoJohoResult;
    private KeisangoJohoSakuseiProcessParamter processParamter;
    private KeisangoJohoSakuseiMybitisParamter mybatisParamter;
    private TsuchishoNo tsuchishoNo = TsuchishoNo.EMPTY;

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
        return new BatchDbReader(期別金額取得, mybatisParamter);
    }

    @Override
    protected void createWriter() {
        計算中間Temp = new BatchEntityCreatedTempTableWriter(TABLE_計算中間_NAME,
                DbTKeisangoJohoTempTableEntity.class);
    }

    @Override
    protected void process(KeisangoJohoSakuseiRelateEntity entity) {
        tsuchishoNo = TsuchishoNo.EMPTY;
        if (!tsuchishoNo.equals(entity.get介護期別Entity().getTsuchishoNo())) {
            tsuchishoNo = entity.get介護期別Entity().getTsuchishoNo();
            計算中間Temp.update(keisangoJohoResult.get中間Entity(entity, processParamter.is更新前フラグ(), entity.get計算中間Entity()));
        }
    }

    @Override
    protected void afterExecute() {
        update計算中間Temp情報();
        if (!processParamter.is更新前フラグ()) {
            List<DbT2002FukaEntity> 更新前賦課情報EntityList = iKeisangoJohoSakuseiMapper.get更新前賦課情報(mybatisParamter);
            for (DbT2002FukaEntity dbT2002FukaEntity : 更新前賦課情報EntityList) {
                計算中間Temp.insert(keisangoJohoResult.get計算中間Entity(dbT2002FukaEntity));
            }
        }
    }

    private void update計算中間Temp情報() {
        tsuchishoNo = TsuchishoNo.EMPTY;
        List<KeisangoJohoSakuseiRelateEntity> 収入情報EntityList = iKeisangoJohoSakuseiMapper.get収入情報(mybatisParamter);
        for (KeisangoJohoSakuseiRelateEntity entity : 収入情報EntityList) {
            if (!tsuchishoNo.equals(entity.get介護期別Entity().getTsuchishoNo())) {
                tsuchishoNo = entity.get介護期別Entity().getTsuchishoNo();
                計算中間Temp.update(keisangoJohoResult.get収入情報(entity, entity.get計算中間Entity()));
            }
        }
    }

    private void setMybatisParamter() {
        TotalShunyuSearchKeyBuilder searchKey = new TotalShunyuSearchKeyBuilder(SearchSokuhoKubun.全て, SearchSaishutsuKubun.全て);
        CaFt702FindTotalShunyuFunction psmEntity = new CaFt702FindTotalShunyuFunction(searchKey);
        mybatisParamter = KeisangoJohoSakuseiMybitisParamter.createSelectByKeyParam(processParamter.getChoteiNendo(),
                processParamter.getFukaNendo(),
                processParamter.getChoteiNichiji(),
                processParamter.getChohyoBunruiID(),
                new RString(psmEntity.toString()),
                YMDHMS.now());
    }
}
