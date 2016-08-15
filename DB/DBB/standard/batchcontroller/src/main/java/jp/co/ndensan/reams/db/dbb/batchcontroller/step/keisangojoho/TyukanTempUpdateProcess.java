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
import jp.co.ndensan.reams.ca.cax.entity.db.basic.CaV0702SaishinShunyuEntity;
import jp.co.ndensan.reams.ca.cax.entity.db.relate.TotalShunyuRelateEntity;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.keisangojoho.KeisangoJohoSakuseiMybitisParamter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.keisangojoho.KeisangoJohoSakuseiProcessParamter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.DbTKeisangoJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.KeisangoJohoSakuseiRelateEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.keisangojoho.IKeisangoJohoSakuseiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 計算中間Tempの更新後データを更新する処理クラスです。
 *
 * @reamsid_L DBB-9060-010 duanzhanli
 */
public class TyukanTempUpdateProcess extends BatchProcessBase<KeisangoJohoSakuseiRelateEntity> {

    private static final RString 期別金額取得 = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.keisangojoho."
            + "IKeisangoJohoSakuseiMapper.get期別金額");
    private static final int 期3 = 3;
    private static final int 期4 = 4;
    private static final int 期5 = 5;
    private static final int 期6 = 6;
    private static final int 期7 = 7;
    private static final int 期8 = 8;
    private static final int 期9 = 9;
    private static final int 期10 = 10;
    private static final int 期11 = 11;
    private static final int 期12 = 12;
    private static final int 期13 = 13;
    private static final int 期14 = 14;
    //private static final int 数値6 = 6;
    private static final RString 徴収方法1 = new RString("1");
    private static final RString 徴収方法2 = new RString("2");
    private static final RString TABLE_計算中間_NAME = new RString("KeisanTyukanTemp");
    private DbTKeisangoJohoTempTableEntity 計算中間Entity;
    private static final RString 更正前後区分_更正前 = new RString("1");
    private static final RString 更正前後区分_更正後 = new RString("2");
    private IKeisangoJohoSakuseiMapper iKeisangoJohoSakuseiMapper;
    private KeisangoJohoSakuseiProcessParamter processParamter;
    private KeisangoJohoSakuseiMybitisParamter mybatisParamter;
    private TsuchishoNo tsuchishoNo = TsuchishoNo.EMPTY;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 計算中間Temp;

    @Override
    protected void initialize() {
        setMybatisParamter();
        iKeisangoJohoSakuseiMapper = getMapper(IKeisangoJohoSakuseiMapper.class);
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
        計算中間Entity = entity.get計算中間Entity();
        tsuchishoNo = TsuchishoNo.EMPTY;
        if (!tsuchishoNo.equals(entity.get介護期別Entity().getTsuchishoNo())) {
            tsuchishoNo = entity.get介護期別Entity().getTsuchishoNo();
            set期別金額(entity);
            計算中間Temp.update(計算中間Entity);
        }
    }

    @Override
    protected void afterExecute() {
        update計算中間Temp情報();
        if (!processParamter.is更新前フラグ()) {
            insert計算中間Temp情報();
        }
    }

    private void update計算中間Temp情報() {
        tsuchishoNo = TsuchishoNo.EMPTY;
        List<KeisangoJohoSakuseiRelateEntity> 収入情報EntityList = iKeisangoJohoSakuseiMapper.get収入情報(mybatisParamter);
        for (KeisangoJohoSakuseiRelateEntity entity : 収入情報EntityList) {
            計算中間Entity = entity.get計算中間Entity();
            if (!tsuchishoNo.equals(entity.get介護期別Entity().getTsuchishoNo())) {
                tsuchishoNo = entity.get介護期別Entity().getTsuchishoNo();
                set収入情報(entity);
                set徴収方法(entity.get介護徴収方法Entity());
                計算中間Temp.update(計算中間Entity);
            }
        }
    }

    private void insert計算中間Temp情報() {
        List<DbT2002FukaEntity> 更新前賦課情報EntityList = iKeisangoJohoSakuseiMapper.get更新前賦課情報(mybatisParamter);
        for (DbT2002FukaEntity dbT2002FukaEntity : 更新前賦課情報EntityList) {
            計算中間Temp.insert(set計算中間Entity(dbT2002FukaEntity));
        }
    }

    private DbTKeisangoJohoTempTableEntity set計算中間Entity(DbT2002FukaEntity entity) {
        DbTKeisangoJohoTempTableEntity keisaEntity = new DbTKeisangoJohoTempTableEntity();
        keisaEntity.setChoteiNendo(entity.getChoteiNendo());
        keisaEntity.setFukaNendo(entity.getFukaNendo());
        keisaEntity.setTsuchishoNo(entity.getTsuchishoNo());
        keisaEntity.setFukaRirekiNo(entity.getRirekiNo());
        keisaEntity.setHihokenshaNo(entity.getHihokenshaNo());
        keisaEntity.setShikibetsuCode(entity.getShikibetsuCode());
        keisaEntity.setSetaiCode(entity.getSetaiCode());
        keisaEntity.setSetaiInsu(entity.getSetaiInsu());
        keisaEntity.setShikakuShutokuYMD(entity.getShikakuShutokuYMD());
        keisaEntity.setShikakuShutokuJiyu(entity.getShikakuShutokuJiyu());
        keisaEntity.setShikakuSoshitsuYMD(entity.getShikakuSoshitsuYMD());
        keisaEntity.setShikakuSoshitsuJiyu(entity.getShikakuSoshitsuJiyu());
        keisaEntity.setSeihofujoShurui(entity.getSeihofujoShurui());
        keisaEntity.setSeihoKaishiYMD(entity.getSeihoKaishiYMD());
        keisaEntity.setSeihoHaishiYMD(entity.getSeihoHaishiYMD());
        keisaEntity.setRonenKaishiYMD(entity.getRonenKaishiYMD());
        keisaEntity.setRonenHaishiYMD(entity.getRonenHaishiYMD());
        keisaEntity.setFukaYMD(entity.getFukaYMD());
        keisaEntity.setKazeiKubun(entity.getKazeiKubun());
        keisaEntity.setSetaikazeiKubun(entity.getSetaikazeiKubun());
        keisaEntity.setGokeiShotokuGaku(entity.getGokeiShotokuGaku());
        keisaEntity.setNenkinShunyuGaku(entity.getNenkinShunyuGaku());
        keisaEntity.setHokenryoDankai(entity.getHokenryoDankai());
        keisaEntity.setHokenryoDankai1(entity.getHokenryoDankai1());
        keisaEntity.setNengakuHokenryo1(entity.getNengakuHokenryo1());
        //TODO 内部QA1089　DB項目のLenghtが違う
//        keisaEntity.setTsukiwariStartYM1(setFlexibleDateFromFlexibleYearMonth(entity.getTsukiwariStartYM1()));
//        keisaEntity.setTsukiwariEndYM1(setFlexibleDateFromFlexibleYearMonth(entity.getTsukiwariEndYM1()));
        keisaEntity.setHokenryoDankai2(entity.getHokenryoDankai2());
        keisaEntity.setNengakuHokenryo2(entity.getNengakuHokenryo2());
        //TODO 内部QA1089　DB項目のLenghtが違う
//        keisaEntity.setTsukiwariStartYM2(setFlexibleDateFromFlexibleYearMonth(entity.getTsukiwariStartYM2()));
//        keisaEntity.setTsukiwariEndYM2(setFlexibleDateFromFlexibleYearMonth(entity.getTsukiwariEndYM2()));
        keisaEntity.setChoteiNichiji(entity.getChoteiNichiji());
        keisaEntity.setChoteiJiyu1(entity.getChoteiJiyu1());
        keisaEntity.setChoteiJiyu2(entity.getChoteiJiyu2());
        keisaEntity.setChoteiJiyu3(entity.getChoteiJiyu3());
        keisaEntity.setChoteiJiyu4(entity.getChoteiJiyu4());
        keisaEntity.setKoseiM(entity.getKoseiM());
        keisaEntity.setGemmenMaeHokenryo(entity.getGemmenMaeHokenryo());
        keisaEntity.setGemmenGaku(entity.getGemmenGaku());
        keisaEntity.setKakuteiHokenryo(entity.getKakuteiHokenryo());
        keisaEntity.setHokenryoDankaiKarisanntei(entity.getHokenryoDankaiKarisanntei());
        keisaEntity.setChoshuHohoRirekiNo(entity.getChoshuHohoRirekiNo());
        keisaEntity.setIdoKijunNichiji(entity.getIdoKijunNichiji());
        keisaEntity.setKozaKubun(entity.getKozaKubun());
        keisaEntity.setKyokaisoKubun(entity.getKyokaisoKubun());
        keisaEntity.setShokkenKubun(entity.getShokkenKubun());
        keisaEntity.setFukaShichosonCode(entity.getFukaShichosonCode());
        keisaEntity.setTkSaishutsuKampuGaku(entity.getTkSaishutsuKampuGaku());
        keisaEntity.setFuSaishutsuKampuGaku(entity.getFuSaishutsuKampuGaku());
        return keisaEntity;
    }

    private void set期別金額(KeisangoJohoSakuseiRelateEntity entity) {
        UrT0705ChoteiKyotsuEntity urT0705Entity = entity.get調定共通介護継承Entity();
        DbT2003KibetsuEntity dbT2003Entity = entity.get介護期別Entity();
        if (urT0705Entity != null && dbT2003Entity != null) {
            if (dbT2003Entity.getChoshuHouhou().equals(徴収方法1)) {
                set特徴期期別金額(urT0705Entity.getChoteigaku(), dbT2003Entity.getKi());
            }
            if (dbT2003Entity.getChoshuHouhou().equals(徴収方法2)) {
                set普徴期期別金額(urT0705Entity.getChoteigaku(), dbT2003Entity.getKi());
            }
        }
    }

    private void set特徴期期別金額(Decimal choteigaku, int ki) {
        switch (ki) {
            case 1:
                計算中間Entity.setTkKibetsuGaku01(choteigaku);
                break;
            case 2:
                計算中間Entity.setTkKibetsuGaku02(choteigaku);
                break;
            case 期3:
                計算中間Entity.setTkKibetsuGaku03(choteigaku);
                break;
            case 期4:
                計算中間Entity.setTkKibetsuGaku04(choteigaku);
                break;
            case 期5:
                計算中間Entity.setTkKibetsuGaku05(choteigaku);
                break;
            case 期6:
                計算中間Entity.setTkKibetsuGaku06(choteigaku);
                break;
            default:
                break;
        }
    }

    private void set普徴期期別金額(Decimal choteigaku, int ki) {
        switch (ki) {
            case 1:
                計算中間Entity.setFuKibetsuGaku01(choteigaku);
                break;
            case 2:
                計算中間Entity.setFuKibetsuGaku02(choteigaku);
                break;
            case 期3:
                計算中間Entity.setFuKibetsuGaku03(choteigaku);
                break;
            case 期4:
                計算中間Entity.setFuKibetsuGaku04(choteigaku);
                break;
            case 期5:
                計算中間Entity.setFuKibetsuGaku05(choteigaku);
                break;
            case 期6:
                計算中間Entity.setFuKibetsuGaku06(choteigaku);
                break;
            case 期7:
                計算中間Entity.setFuKibetsuGaku07(choteigaku);
                break;
            case 期8:
                計算中間Entity.setFuKibetsuGaku08(choteigaku);
                break;
            case 期9:
                計算中間Entity.setFuKibetsuGaku09(choteigaku);
                break;
            case 期10:
                計算中間Entity.setFuKibetsuGaku10(choteigaku);
                break;
            case 期11:
                計算中間Entity.setFuKibetsuGaku11(choteigaku);
                break;
            case 期12:
                計算中間Entity.setFuKibetsuGaku12(choteigaku);
                break;
            case 期13:
                計算中間Entity.setFuKibetsuGaku13(choteigaku);
                break;
            case 期14:
                計算中間Entity.setFuKibetsuGaku14(choteigaku);
                break;
            default:
                break;
        }
    }

    private void set徴収方法(DbT2001ChoshuHohoEntity entity) {
        if (processParamter.is更新前フラグ()) {
            計算中間Entity.setKoseiZengoKubun(更正前後区分_更正前);
        } else {
            計算中間Entity.setKoseiZengoKubun(更正前後区分_更正後);
        }
        //TODO QA1089 介護徴収方法テーブルのデータはどこから取得
        計算中間Entity.setChoshuHoho4gatsu(entity.getChoshuHoho4gatsu());
        計算中間Entity.setChoshuHoho5gatsu(entity.getChoshuHoho5gatsu());
        計算中間Entity.setChoshuHoho6gatsu(entity.getChoshuHoho6gatsu());
        計算中間Entity.setChoshuHoho7gatsu(entity.getChoshuHoho7gatsu());
        計算中間Entity.setChoshuHoho8gatsu(entity.getChoshuHoho8gatsu());
        計算中間Entity.setChoshuHoho9gatsu(entity.getChoshuHoho9gatsu());
        計算中間Entity.setChoshuHoho10gatsu(entity.getChoshuHoho10gatsu());
        計算中間Entity.setChoshuHoho11gatsu(entity.getChoshuHoho11gatsu());
        計算中間Entity.setChoshuHoho12gatsu(entity.getChoshuHoho12gatsu());
        計算中間Entity.setChoshuHoho1gatsu(entity.getChoshuHoho1gatsu());
        計算中間Entity.setChoshuHoho2gatsu(entity.getChoshuHoho2gatsu());
        計算中間Entity.setChoshuHoho3gatsu(entity.getChoshuHoho3gatsu());
        計算中間Entity.setChoshuHohoYoku4gatsu(entity.getChoshuHohoYoku4gatsu());
        計算中間Entity.setChoshuHohoYoku5gatsu(entity.getChoshuHohoYoku5gatsu());
        計算中間Entity.setChoshuHohoYoku6gatsu(entity.getChoshuHohoYoku6gatsu());
        計算中間Entity.setChoshuHohoYoku7gatsu(entity.getChoshuHohoYoku7gatsu());
        計算中間Entity.setChoshuHohoYoku8gatsu(entity.getChoshuHohoYoku8gatsu());
        計算中間Entity.setChoshuHohoYoku9gatsu(entity.getChoshuHohoYoku9gatsu());
        計算中間Entity.setKariNenkinNo(entity.getKariNenkinNo());
        計算中間Entity.setKariNenkinCode(entity.getKariNenkinCode());
        計算中間Entity.setKariHosokuM(entity.getKariHosokuM());
        計算中間Entity.setHonNenkinNo(entity.getHonNenkinNo());
        計算中間Entity.setHonNenkinCode(entity.getHonNenkinCode());
        計算中間Entity.setHonHosokuM(entity.getHonHosokuM());
        計算中間Entity.setYokunendoKariNenkinNo(entity.getYokunendoKariNenkinNo());
        計算中間Entity.setYokunendoKariNenkinCode(entity.getYokunendoKariNenkinCode());
        計算中間Entity.setYokunendoKariHosokuM(entity.getYokunendoKariHosokuM());
        計算中間Entity.setIraiSohuzumiFlag(entity.getIraiSohuzumiFlag());
        計算中間Entity.setTsuikaIraiSohuzumiFlag(entity.getTsuikaIraiSohuzumiFlag());
        計算中間Entity.setTokuchoTeishiNichiji(entity.getTokuchoTeishiNichiji());
        計算中間Entity.setTokuchoTeishiJiyuCode(entity.getTokuchoTeishiJiyuCode());
    }

    private void set収入情報(KeisangoJohoSakuseiRelateEntity entity) {
        TotalShunyuRelateEntity totalShunyuEntity = entity.get収入情報取得PSMEntity();
        DbT2003KibetsuEntity dbT2003Entity = entity.get介護期別Entity();
        if (totalShunyuEntity != null && dbT2003Entity != null) {
            CaV0702SaishinShunyuEntity 収入情報Entity = totalShunyuEntity.get最新収入Entity();
            if (収入情報Entity != null && dbT2003Entity.getChoshuHouhou().equals(徴収方法1)) {
                set特徴収入額(収入情報Entity.getShunyugaku(), dbT2003Entity.getKi());
            }
            if (収入情報Entity != null && dbT2003Entity.getChoshuHouhou().equals(徴収方法2)) {
                set普徴収入額(収入情報Entity.getShunyugaku(), dbT2003Entity.getKi());
            }
        }
    }

    private void set特徴収入額(Decimal shunyugaku, int ki) {
        switch (ki) {
            case 1:
                計算中間Entity.setTkShunyuGaku01(shunyugaku);
                break;
            case 2:
                計算中間Entity.setTkShunyuGaku02(shunyugaku);
                break;
            case 期3:
                計算中間Entity.setTkShunyuGaku03(shunyugaku);
                break;
            case 期4:
                計算中間Entity.setTkShunyuGaku04(shunyugaku);
                break;
            case 期5:
                計算中間Entity.setTkShunyuGaku05(shunyugaku);
                break;
            case 期6:
                計算中間Entity.setTkShunyuGaku06(shunyugaku);
                break;
            default:
                break;
        }

    }

    private void set普徴収入額(Decimal shunyugaku, int ki) {
        switch (ki) {
            case 1:
                計算中間Entity.setFuShunyuGaku01(shunyugaku);
                break;
            case 2:
                計算中間Entity.setFuShunyuGaku02(shunyugaku);
                break;
            case 期3:
                計算中間Entity.setFuShunyuGaku03(shunyugaku);
                break;
            case 期4:
                計算中間Entity.setFuShunyuGaku04(shunyugaku);
                break;
            case 期5:
                計算中間Entity.setFuShunyuGaku05(shunyugaku);
                break;
            case 期6:
                計算中間Entity.setFuShunyuGaku06(shunyugaku);
                break;
            case 期7:
                計算中間Entity.setFuShunyuGaku07(shunyugaku);
                break;
            case 期8:
                計算中間Entity.setFuShunyuGaku08(shunyugaku);
                break;
            case 期9:
                計算中間Entity.setFuShunyuGaku09(shunyugaku);
                break;
            case 期10:
                計算中間Entity.setFuShunyuGaku10(shunyugaku);
                break;
            case 期11:
                計算中間Entity.setFuShunyuGaku11(shunyugaku);
                break;
            case 期12:
                計算中間Entity.setFuShunyuGaku12(shunyugaku);
                break;
            case 期13:
                計算中間Entity.setFuShunyuGaku13(shunyugaku);
                break;
            case 期14:
                計算中間Entity.setFuShunyuGaku14(shunyugaku);
                break;
            default:
                break;
        }
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
