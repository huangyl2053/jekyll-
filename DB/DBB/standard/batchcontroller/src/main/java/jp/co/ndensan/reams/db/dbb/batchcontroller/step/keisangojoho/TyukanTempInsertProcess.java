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
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 検索した賦課情報を計算中間Tempテーブルに登録する処理クラスです。
 *
 * @reamsid_L DBB-9060-010 duanzhanli
 */
public class TyukanTempInsertProcess extends BatchProcessBase<DbT2002FukaEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.keisangojoho."
            + "IKeisangoJohoSakuseiMapper.");
    private static final RString 全賦課最新情報2 = new RString(MAPPERPATH + "get全賦課最新情報2");
    private static final RString 全賦課最新情報3 = new RString(MAPPERPATH + "get全賦課最新情報3");
    private static final RString 全賦課最新情報4 = new RString(MAPPERPATH + "get全賦課最新情報4");
    private static final RString 全賦課最新情報5 = new RString(MAPPERPATH + "get全賦課最新情報5");
    private static final RString システムエラー = new RString("バッチパラメータの調定年度または賦課年度が未設定のため、処理を中止します。"
            + "バッチパラメータに調定年度または賦課年度を設定してください。");
    private static final RString TABLE_計算中間_NAME = new RString("KeisanTyukanTemp");
    //private static final int 数値6 = 6;
    private KeisangoJohoSakuseiProcessParamter processParamter;
    private KeisangoJohoSakuseiMybitisParamter mybatisParamter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 計算中間Temp;

    @Override
    protected void initialize() {
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
    }

    @Override
    protected void process(DbT2002FukaEntity entity) {
        計算中間Temp.insert(set計算中間Entity(entity));
    }

    private DbTKeisangoJohoTempTableEntity set計算中間Entity(DbT2002FukaEntity entity) {
        DbTKeisangoJohoTempTableEntity 計算中間Entity = new DbTKeisangoJohoTempTableEntity();
        計算中間Entity.setChoteiNendo(entity.getChoteiNendo());
        計算中間Entity.setFukaNendo(entity.getFukaNendo());
        計算中間Entity.setTsuchishoNo(entity.getTsuchishoNo());
        計算中間Entity.setFukaRirekiNo(entity.getRirekiNo());
        計算中間Entity.setHihokenshaNo(entity.getHihokenshaNo());
        計算中間Entity.setShikibetsuCode(entity.getShikibetsuCode());
        計算中間Entity.setSetaiCode(entity.getSetaiCode());
        計算中間Entity.setSetaiInsu(entity.getSetaiInsu());
        計算中間Entity.setShikakuShutokuYMD(entity.getShikakuShutokuYMD());
        計算中間Entity.setShikakuShutokuJiyu(entity.getShikakuShutokuJiyu());
        計算中間Entity.setShikakuSoshitsuYMD(entity.getShikakuSoshitsuYMD());
        計算中間Entity.setShikakuSoshitsuJiyu(entity.getShikakuSoshitsuJiyu());
        計算中間Entity.setSeihofujoShurui(entity.getSeihofujoShurui());
        計算中間Entity.setSeihoKaishiYMD(entity.getSeihoKaishiYMD());
        計算中間Entity.setSeihoHaishiYMD(entity.getSeihoHaishiYMD());
        計算中間Entity.setRonenKaishiYMD(entity.getRonenKaishiYMD());
        計算中間Entity.setRonenHaishiYMD(entity.getRonenHaishiYMD());
        計算中間Entity.setFukaYMD(entity.getFukaYMD());
        計算中間Entity.setKazeiKubun(entity.getKazeiKubun());
        計算中間Entity.setSetaikazeiKubun(entity.getSetaikazeiKubun());
        計算中間Entity.setGokeiShotokuGaku(entity.getGokeiShotokuGaku());
        計算中間Entity.setNenkinShunyuGaku(entity.getNenkinShunyuGaku());
        計算中間Entity.setHokenryoDankai(entity.getHokenryoDankai());
        計算中間Entity.setHokenryoDankai1(entity.getHokenryoDankai1());
        計算中間Entity.setNengakuHokenryo1(entity.getNengakuHokenryo1());
        //TODO 内部QA1089　DB項目のLenghtが違う
//        計算中間Entity.setTsukiwariStartYM1(setFlexibleDateFromFlexibleYearMonth(entity.getTsukiwariStartYM1()));
//        計算中間Entity.setTsukiwariEndYM1(setFlexibleDateFromFlexibleYearMonth(entity.getTsukiwariEndYM1()));
        計算中間Entity.setHokenryoDankai2(entity.getHokenryoDankai2());
        計算中間Entity.setNengakuHokenryo2(entity.getNengakuHokenryo2());
        //TODO 内部QA1089　DB項目のLenghtが違う
//        計算中間Entity.setTsukiwariStartYM2(setFlexibleDateFromFlexibleYearMonth(entity.getTsukiwariStartYM2()));
//        計算中間Entity.setTsukiwariEndYM2(setFlexibleDateFromFlexibleYearMonth(entity.getTsukiwariEndYM2()));
        計算中間Entity.setChoteiNichiji(entity.getChoteiNichiji());
        計算中間Entity.setChoteiJiyu1(entity.getChoteiJiyu1());
        計算中間Entity.setChoteiJiyu2(entity.getChoteiJiyu2());
        計算中間Entity.setChoteiJiyu3(entity.getChoteiJiyu3());
        計算中間Entity.setChoteiJiyu4(entity.getChoteiJiyu4());
        計算中間Entity.setKoseiM(entity.getKoseiM());
        計算中間Entity.setGemmenMaeHokenryo(entity.getGemmenMaeHokenryo());
        計算中間Entity.setGemmenGaku(entity.getGemmenGaku());
        計算中間Entity.setKakuteiHokenryo(entity.getKakuteiHokenryo());
        計算中間Entity.setHokenryoDankaiKarisanntei(entity.getHokenryoDankaiKarisanntei());
        計算中間Entity.setChoshuHohoRirekiNo(entity.getChoshuHohoRirekiNo());
        計算中間Entity.setIdoKijunNichiji(entity.getIdoKijunNichiji());
        計算中間Entity.setKozaKubun(entity.getKozaKubun());
        計算中間Entity.setKyokaisoKubun(entity.getKyokaisoKubun());
        計算中間Entity.setShokkenKubun(entity.getShokkenKubun());
        計算中間Entity.setFukaShichosonCode(entity.getFukaShichosonCode());
        計算中間Entity.setTkSaishutsuKampuGaku(entity.getTkSaishutsuKampuGaku());
        計算中間Entity.setFuSaishutsuKampuGaku(entity.getFuSaishutsuKampuGaku());
        return 計算中間Entity;
    }

//    private FlexibleDate setFlexibleDateFromFlexibleYearMonth(FlexibleYearMonth ym) {
//        if (ym != null) {
//            return new FlexibleDate(ym.toDateString().substring(0, 数値6));
//        } else {
//            return FlexibleDate.EMPTY;
//        }
//    }
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
