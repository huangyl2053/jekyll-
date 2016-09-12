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
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 検索した賦課情報を計算中間Tempテーブルに登録する処理クラスです。
 *
 * @reamsid_L DBB-9060-010 duanzhanli
 */
public class TyukanTempAfterInsertProcess extends BatchProcessBase<DbT2002FukaEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.keisangojoho."
            + "IKeisangoJohoSakuseiMapper.");
    private static final RString 全賦課最新情報2 = new RString(MAPPERPATH + "get全賦課最新情報2");
    private static final RString 全賦課最新情報3 = new RString(MAPPERPATH + "get全賦課最新情報3");
    private static final RString 全賦課最新情報4 = new RString(MAPPERPATH + "get全賦課最新情報4");
    private static final RString 全賦課最新情報5 = new RString(MAPPERPATH + "get全賦課最新情報5");
    private static final RString システムエラー = new RString("バッチパラメータの調定年度または賦課年度が未設定のため、処理を中止します。"
            + "バッチパラメータに調定年度または賦課年度を設定してください。");
    private static final RString TABLE_計算中間_NAME = new RString("KeisanTyukanTemp");
    private static final RString TABLE_計算後情報一時_NAME = new RString("DbT2015KeisangoJohoTemp");
    private KeisangoJohoSakuseiProcessParamter processParamter;
    private KeisangoJohoSakuseiMybitisParamter mybatisParamter;
    /**
     * データ有無の判定です。
     */
    public static final RString データ有無;

    static {
        データ有無 = new RString("outData");
    }
    private OutputParameter<Boolean> outData;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 計算中間Temp;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 計算後情報Temp;

    @Override
    protected void initialize() {
        outData = new OutputParameter<>();
        outData.setValue(false);
        setMybatisParamter();
    }

    @Override
    protected IBatchReader createReader() {
        if (processParamter.isSaishinFlag1()) {
            throw new BatchInterruptedException(システムエラー.toString());
        } else if (processParamter.isSaishinFlag2()) {
            return new BatchDbReader(全賦課最新情報2, mybatisParamter);
        } else if (processParamter.isSaishinFlag3()) {
            return new BatchDbReader(全賦課最新情報3, mybatisParamter);
        } else if (processParamter.isSaishinFlag4()) {
            return new BatchDbReader(全賦課最新情報4, mybatisParamter);
        } else {
            return new BatchDbReader(全賦課最新情報5, mybatisParamter);
        }
    }

    @Override
    protected void createWriter() {
        計算中間Temp = new BatchEntityCreatedTempTableWriter(TABLE_計算中間_NAME,
                DbTKeisangoJohoTempTableEntity.class);
        計算後情報Temp = new BatchEntityCreatedTempTableWriter(TABLE_計算後情報一時_NAME,
                DbTKeisangoJohoTempTableEntity.class);
    }

    @Override
    protected void process(DbT2002FukaEntity entity) {
        計算中間Temp.insert(new KeisangoJohoResult().get計算中間Entity(entity));
        outData.setValue(true);
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
