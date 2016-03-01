/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.keisangojoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.ca.cax.business.search.CaFt702FindTotalShunyuFunction;
import jp.co.ndensan.reams.ca.cax.business.search.TotalShunyuSearchKeyBuilder;
import jp.co.ndensan.reams.ca.cax.definition.core.shuno.SearchSaishutsuKubun;
import jp.co.ndensan.reams.ca.cax.definition.core.shuno.SearchSokuhoKubun;
import jp.co.ndensan.reams.ca.cax.entity.db.basic.CaV0702SaishinShunyuEntity;
import jp.co.ndensan.reams.ca.cax.entity.db.relate.TotalShunyuRelateEntity;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.keisangojoho.KeisangoJohoSakuseiMybitisParamter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.keisangojoho.KeisangoJohoSakuseiProcessParamter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbV2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.DbTKeisangoJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.KeisangoJohoSakuseiRelateEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.keisangojoho.IKeisangoJohoSakuseiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV2002FukaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.RLogger;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 計算後情報作成です_バッチフ処理クラスです
 */
public class KeisangoJohoSakuseiProcess extends BatchProcessBase<KeisangoJohoSakuseiRelateEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.keisangojoho."
            + "IKeisangoJohoSakuseiMapper.");
    private static final RString 計算後情報_最新2 = new RString(MAPPERPATH + "get計算後情報_最新2");
    private static final RString 計算後情報_最新3 = new RString(MAPPERPATH + "get計算後情報_最新3");
    private static final RString 計算後情報_最新4 = new RString(MAPPERPATH + "get計算後情報_最新4");
    private static final RString 計算後情報_最新5 = new RString(MAPPERPATH + "get計算後情報_最新5");
    private static final RString システムエラー = new RString("バッチパラメータの調定年度または賦課年度が未設定のため、処理を中止します。"
            + "バッチパラメータに調定年度または賦課年度を設定してください。");
    private static final RString 更正前後区分_更正前 = new RString("1");
    private static final RString 更正前後区分_更正後 = new RString("2");
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
    private static final int 数値6 = 6;
    private static final RString 徴収方法1 = new RString("1");
    private static final RString 徴収方法2 = new RString("2");
    private boolean 更正前フラグ = false;
    private boolean saishinFlag2 = false;
    private boolean saishinFlag3 = false;
    private boolean saishinFlag4 = false;
    private boolean saishinFlag5 = false;
    private IKeisangoJohoSakuseiMapper iKeisangoJohoSakuseiMapper;
    private List<DbT2015KeisangoJohoEntity> 計算後情報リスト;
    private KeisangoJohoSakuseiProcessParamter processParamter;
    private KeisangoJohoSakuseiMybitisParamter mybatisParamter;
    private DbT2015KeisangoJohoEntity dbT2015;
    private TsuchishoNo tsuchishoNo = TsuchishoNo.EMPTY;
    @BatchWriter
    BatchPermanentTableWriter<DbT2015KeisangoJohoEntity> dbT2015Writer;

    @BatchWriter
    BatchEntityCreatedTempTableWriter dbT2015KeisangoJohoTemp;

    @Override
    protected void initialize() {
        計算後情報リスト = new ArrayList<>();
        setMybatisParamter();
        iKeisangoJohoSakuseiMapper = getMapper(IKeisangoJohoSakuseiMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        if (RString.isNullOrEmpty(processParamter.getChoteiNendo()) || RString.isNullOrEmpty(processParamter.getFukaNendo())) {
            RLogger.error(システムエラー);
            return null;
        } else if (RString.isNullOrEmpty(processParamter.getChoteiNichiji()) && RString.isNullOrEmpty(processParamter.getChohyoBunruiID())) {
            saishinFlag2 = true;
            return new BatchDbReader(計算後情報_最新2, mybatisParamter);
        } else if (!RString.isNullOrEmpty(processParamter.getChoteiNichiji()) && RString.isNullOrEmpty(processParamter.getChohyoBunruiID())) {
            saishinFlag3 = true;
            return new BatchDbReader(計算後情報_最新3, mybatisParamter);
        } else if (RString.isNullOrEmpty(processParamter.getChoteiNichiji()) && !RString.isNullOrEmpty(processParamter.getChohyoBunruiID())) {
            saishinFlag4 = true;
            return new BatchDbReader(計算後情報_最新4, mybatisParamter);
        } else if (!RString.isNullOrEmpty(processParamter.getChoteiNichiji()) && !RString.isNullOrEmpty(processParamter.getChohyoBunruiID())) {
            saishinFlag5 = true;
            return new BatchDbReader(計算後情報_最新5, mybatisParamter);
        } else {
            return null;
        }
    }

    @Override
    protected void createWriter() {
        dbT2015Writer = new BatchPermanentTableWriter(DbT2015KeisangoJohoEntity.class);
        dbT2015KeisangoJohoTemp = new BatchEntityCreatedTempTableWriter(DbTKeisangoJohoTempTableEntity.TABLE_NAME,
                DbTKeisangoJohoTempTableEntity.class);
    }

    @Override
    protected void process(KeisangoJohoSakuseiRelateEntity entity) {
        dbT2015 = new DbT2015KeisangoJohoEntity();
        if (saishinFlag2 || saishinFlag4) {
            DbV2002FukaEntity 介護賦課ビューEntity = entity.get介護賦課ビューEntity();
            if (介護賦課ビューEntity != null && !tsuchishoNo.equals(介護賦課ビューEntity.getTsuchishoNo())) {
                setDbT2015EntityFromView(entity);
                計算後情報リスト.add(dbT2015);
            }
        } else if (saishinFlag3 || saishinFlag5) {
            DbT2002FukaEntity 介護賦課Entity = entity.get介護賦課Entity();
            if (介護賦課Entity != null && !tsuchishoNo.equals(介護賦課Entity.getTsuchishoNo())) {
                setDbT2015EntityFromTable(entity);
                計算後情報リスト.add(dbT2015);
            }
        }
    }

    @Override
    protected void afterExecute() {
        tsuchishoNo = TsuchishoNo.EMPTY;
        List<DbT2015KeisangoJohoEntity> 計算後情報履歴 = new ArrayList<>();
        for (DbT2015KeisangoJohoEntity dbT2015KeisangoJohoEntity : 計算後情報リスト) {
            List<KeisangoJohoSakuseiRelateEntity> keisangoJohoSakuseiEntityList
                    = iKeisangoJohoSakuseiMapper.get計算後情報_履歴(dbT2015KeisangoJohoEntity);
            for (KeisangoJohoSakuseiRelateEntity entity : keisangoJohoSakuseiEntityList) {
                dbT2015 = new DbT2015KeisangoJohoEntity();
                DbT2002FukaEntity 介護賦課Entity = entity.get介護賦課Entity();
                if (介護賦課Entity != null && !tsuchishoNo.equals(介護賦課Entity.getTsuchishoNo())) {
                    更正前フラグ = true;
                    setDbT2015EntityFromTable(entity);
                    計算後情報履歴.add(dbT2015);
                }
            }
        }
        計算後情報リスト.addAll(計算後情報履歴);
        if (saishinFlag2 || saishinFlag4 || saishinFlag5) {
            //TODO 内部QA：749　一時テーブル削除の確認
            //iKeisangoJohoSakuseiMapper.dropDbT2015KeisangoJohoTemp();
        }
        for (DbT2015KeisangoJohoEntity dbT2015KeisangoJohoEntity : 計算後情報リスト) {
            if (saishinFlag2 || saishinFlag4 || saishinFlag5) {
                iKeisangoJohoSakuseiMapper.insertDbT2015KeisangoJohoTemp(dbT2015KeisangoJohoEntity);
            } else if (saishinFlag3) {
                dbT2015Writer.insert(dbT2015KeisangoJohoEntity);
            }
        }
    }

    private void setDbT2015EntityFromTable(KeisangoJohoSakuseiRelateEntity entity) {
        tsuchishoNo = entity.get介護賦課Entity().getTsuchishoNo();
        if (entity.get介護賦課Entity() != null) {
            set計算後情報From介護賦課(entity.get介護賦課Entity());
        }
        if (entity.get調定共通介護継承Entity() != null && entity.get介護期別Entity() != null) {
            set計算後情報From調定共通介護継承(entity.get調定共通介護継承Entity(), entity.get介護期別Entity());
        }
        if (entity.get介護徴収方法Entity() != null) {
            set計算後情報From介護徴収方法(entity.get介護徴収方法Entity());
        }
    }

    private void setDbT2015EntityFromView(KeisangoJohoSakuseiRelateEntity entity) {
        tsuchishoNo = entity.get介護賦課ビューEntity().getTsuchishoNo();
        set計算後情報From介護賦課ビュー(entity.get介護賦課ビューEntity());
        if (entity.get調定共通介護継承Entity() != null && entity.get介護期別Entity() != null) {
            set計算後情報From調定共通介護継承(entity.get調定共通介護継承Entity(), entity.get介護期別Entity());
        }
        if (entity.get介護徴収方法ビューEntity() != null) {
            set計算後情報From介護徴収方法ビュー(entity.get介護徴収方法ビューEntity());
        }
        if (entity.get収入情報取得PSMEntity() != null && entity.get介護期別Entity() != null) {
            set計算後情報From収入情報取得PSM(entity.get収入情報取得PSMEntity(), entity.get介護期別Entity());
        }
    }

    private void set計算後情報From介護賦課ビュー(DbV2002FukaEntity entity) {
        FlexibleYear choteiNend = entity.getChoteiNendo();
        if (choteiNend != null) {
            dbT2015.setChoteiNendo(choteiNend);
        } else {
            dbT2015.setChoteiNendo(FlexibleYear.EMPTY);
        }
        FlexibleYear fukaNendo = entity.getFukaNendo();
        if (fukaNendo != null) {
            dbT2015.setFukaNendo(fukaNendo);
        } else {
            dbT2015.setFukaNendo(FlexibleYear.EMPTY);
        }
        TsuchishoNo tsuchiShoNo = entity.getTsuchishoNo();
        if (tsuchiShoNo != null) {
            dbT2015.setTsuchishoNo(tsuchiShoNo);
        } else {
            dbT2015.setTsuchishoNo(TsuchishoNo.EMPTY);
        }
        dbT2015.setKoseiZengoKubun(更正前後区分_更正後);
        dbT2015.setSakuseiShoriName(RString.EMPTY);
        dbT2015.setFukaRirekiNo(entity.getRirekiNo());
        HihokenshaNo hihokenshaNo = entity.getHihokenshaNo();
        if (hihokenshaNo != null) {
            dbT2015.setHihokenshaNo(hihokenshaNo);
        } else {
            dbT2015.setHihokenshaNo(HihokenshaNo.EMPTY);
        }
        ShikibetsuCode shikibetsuCode = entity.getShikibetsuCode();
        if (shikibetsuCode != null) {
            dbT2015.setShikibetsuCode(shikibetsuCode);
        } else {
            dbT2015.setShikibetsuCode(ShikibetsuCode.EMPTY);
        }
        dbT2015.setSetaiCode(entity.getSetaiCode());
        dbT2015.setSetaiInsu(entity.getSetaiInsu());
        dbT2015.setShikakuShutokuYMD(entity.getShikakuShutokuYMD());
        dbT2015.setShikakuShutokuJiyu(entity.getShikakuShutokuJiyu());
        dbT2015.setShikakuSoshitsuYMD(entity.getShikakuSoshitsuYMD());
        dbT2015.setShikakuSoshitsuJiyu(entity.getShikakuSoshitsuJiyu());
        dbT2015.setSeihofujoShurui(entity.getSeihofujoShurui());
        dbT2015.setSeihoKaishiYMD(entity.getSeihoKaishiYMD());
        dbT2015.setSeihoHaishiYMD(entity.getSeihoHaishiYMD());
        dbT2015.setRonenKaishiYMD(entity.getRonenKaishiYMD());
        dbT2015.setRonenHaishiYMD(entity.getRonenHaishiYMD());
        dbT2015.setFukaYMD(entity.getFukaYMD());
        dbT2015.setKazeiKubun(entity.getKazeiKubun());
        dbT2015.setSetaikazeiKubun(entity.getSetaikazeiKubun());
        dbT2015.setGokeiShotokuGaku(entity.getGokeiShotokuGaku());
        dbT2015.setNenkinShunyuGaku(entity.getNenkinShunyuGaku());
        dbT2015.setHokenryoDankai(entity.getHokenryoDankai());
        dbT2015.setHokenryoDankai1(entity.getHokenryoDankai1());
        dbT2015.setNengakuHokenryo1(entity.getNengakuHokenryo1());
        dbT2015.setTsukiwariStartYM1(setFlexibleDateFromFlexibleYearMonth(entity.getTsukiwariStartYM1()));
        dbT2015.setTsukiwariEndYM1(setFlexibleDateFromFlexibleYearMonth(entity.getTsukiwariEndYM1()));
        dbT2015.setHokenryoDankai2(entity.getHokenryoDankai2());
        dbT2015.setNengakuHokenryo2(entity.getNengakuHokenryo2());
        dbT2015.setTsukiwariStartYM2(setFlexibleDateFromFlexibleYearMonth(entity.getTsukiwariStartYM2()));
        dbT2015.setTsukiwariEndYM2(setFlexibleDateFromFlexibleYearMonth(entity.getTsukiwariEndYM2()));
        dbT2015.setChoteiNichiji(entity.getChoteiNichiji());
        dbT2015.setChoteiJiyu1(entity.getChoteiJiyu1());
        dbT2015.setChoteiJiyu2(entity.getChoteiJiyu2());
        dbT2015.setChoteiJiyu3(entity.getChoteiJiyu3());
        dbT2015.setChoteiJiyu4(entity.getChoteiJiyu4());
        dbT2015.setKoseiM(entity.getKoseiM());
        dbT2015.setGemmenMaeHokenryo(entity.getGemmenMaeHokenryo());
        dbT2015.setGemmenGaku(entity.getGemmenGaku());
        dbT2015.setKakuteiHokenryo(entity.getKakuteiHokenryo());
        dbT2015.setHokenryoDankaiKarisanntei(entity.getHokenryoDankaiKarisanntei());
        dbT2015.setChoshuHohoRirekiNo(entity.getChoshuHohoRirekiNo());
        YMDHMS idoKijunNichiji = entity.getIdoKijunNichiji();
        if (idoKijunNichiji != null) {
            dbT2015.setIdoKijunNichiji(idoKijunNichiji);
        } else {
            dbT2015.setIdoKijunNichiji(new YMDHMS(RString.EMPTY));
        }
        dbT2015.setKozaKubun(entity.getKozaKubun());
        dbT2015.setKyokaisoKubun(entity.getKyokaisoKubun());
        dbT2015.setShokkenKubun(entity.getShokkenKubun());
        dbT2015.setFukaShichosonCode(entity.getFukaShichosonCode());
        dbT2015.setTkSaishutsuKampuGaku(entity.getTkSaishutsuKampuGaku());
        dbT2015.setFuSaishutsuKampuGaku(entity.getFuSaishutsuKampuGaku());
    }

    private void set計算後情報From介護賦課(DbT2002FukaEntity entity) {

        dbT2015.setChoteiNendo(entity.getChoteiNendo());
        dbT2015.setFukaNendo(entity.getFukaNendo());
        dbT2015.setTsuchishoNo(entity.getTsuchishoNo());
        if (更正前フラグ) {
            dbT2015.setKoseiZengoKubun(更正前後区分_更正前);
            更正前フラグ = false;
        } else {
            dbT2015.setKoseiZengoKubun(更正前後区分_更正後);
        }
        dbT2015.setSakuseiShoriName(processParamter.getSakuseiShoriName());
        dbT2015.setFukaRirekiNo(entity.getRirekiNo());
        dbT2015.setHihokenshaNo(entity.getHihokenshaNo());
        ShikibetsuCode shikibetsuCode = entity.getShikibetsuCode();
        if (shikibetsuCode != null) {
            dbT2015.setShikibetsuCode(shikibetsuCode);
        } else {
            dbT2015.setShikibetsuCode(ShikibetsuCode.EMPTY);
        }
        dbT2015.setSetaiCode(entity.getSetaiCode());
        dbT2015.setSetaiInsu(entity.getSetaiInsu());
        dbT2015.setShikakuShutokuYMD(entity.getShikakuShutokuYMD());
        dbT2015.setShikakuShutokuJiyu(entity.getShikakuShutokuJiyu());
        dbT2015.setShikakuSoshitsuYMD(entity.getShikakuSoshitsuYMD());
        dbT2015.setShikakuSoshitsuJiyu(entity.getShikakuSoshitsuJiyu());
        dbT2015.setSeihofujoShurui(entity.getSeihofujoShurui());
        dbT2015.setSeihoKaishiYMD(entity.getSeihoKaishiYMD());
        dbT2015.setSeihoHaishiYMD(entity.getSeihoHaishiYMD());
        dbT2015.setRonenKaishiYMD(entity.getRonenKaishiYMD());
        dbT2015.setRonenHaishiYMD(entity.getRonenHaishiYMD());
        dbT2015.setFukaYMD(entity.getFukaYMD());
        dbT2015.setKazeiKubun(entity.getKazeiKubun());
        dbT2015.setSetaikazeiKubun(entity.getSetaikazeiKubun());
        dbT2015.setGokeiShotokuGaku(entity.getGokeiShotokuGaku());
        dbT2015.setNenkinShunyuGaku(entity.getNenkinShunyuGaku());
        dbT2015.setHokenryoDankai(entity.getHokenryoDankai());
        dbT2015.setHokenryoDankai1(entity.getHokenryoDankai1());
        dbT2015.setNengakuHokenryo1(entity.getNengakuHokenryo1());
        dbT2015.setTsukiwariStartYM1(setFlexibleDateFromFlexibleYearMonth(entity.getTsukiwariStartYM1()));
        dbT2015.setTsukiwariEndYM1(setFlexibleDateFromFlexibleYearMonth(entity.getTsukiwariEndYM1()));
        dbT2015.setHokenryoDankai2(entity.getHokenryoDankai2());
        dbT2015.setNengakuHokenryo2(entity.getNengakuHokenryo2());
        dbT2015.setTsukiwariStartYM2(setFlexibleDateFromFlexibleYearMonth(entity.getTsukiwariStartYM2()));
        dbT2015.setTsukiwariEndYM2(setFlexibleDateFromFlexibleYearMonth(entity.getTsukiwariEndYM2()));
        dbT2015.setChoteiNichiji(entity.getChoteiNichiji());
        dbT2015.setChoteiJiyu1(entity.getChoteiJiyu1());
        dbT2015.setChoteiJiyu2(entity.getChoteiJiyu2());
        dbT2015.setChoteiJiyu3(entity.getChoteiJiyu3());
        dbT2015.setChoteiJiyu4(entity.getChoteiJiyu4());
        dbT2015.setKoseiM(entity.getKoseiM());
        dbT2015.setGemmenMaeHokenryo(entity.getGemmenMaeHokenryo());
        dbT2015.setGemmenGaku(entity.getGemmenGaku());
        dbT2015.setKakuteiHokenryo(entity.getKakuteiHokenryo());
        dbT2015.setHokenryoDankaiKarisanntei(entity.getHokenryoDankaiKarisanntei());
        dbT2015.setChoshuHohoRirekiNo(entity.getChoshuHohoRirekiNo());
        dbT2015.setIdoKijunNichiji(entity.getIdoKijunNichiji());
        dbT2015.setKozaKubun(entity.getKozaKubun());
        dbT2015.setKyokaisoKubun(entity.getKyokaisoKubun());
        dbT2015.setShokkenKubun(entity.getShokkenKubun());
        dbT2015.setFukaShichosonCode(entity.getFukaShichosonCode());
        dbT2015.setTkSaishutsuKampuGaku(entity.getTkSaishutsuKampuGaku());
        dbT2015.setFuSaishutsuKampuGaku(entity.getFuSaishutsuKampuGaku());
    }

    private void set計算後情報From調定共通介護継承(UrT0705ChoteiKyotsuEntity choteiKyotsuEntity, DbT2003KibetsuEntity kibetsuEntity) {
        if (kibetsuEntity.getChoshuHouhou().equals(徴収方法1)) {
            set特徴期期別金額(choteiKyotsuEntity.getChoteigaku(), kibetsuEntity.getKi());
        }
        if (kibetsuEntity.getChoshuHouhou().equals(徴収方法2)) {
            set普徴期期別金額(choteiKyotsuEntity.getChoteigaku(), kibetsuEntity.getKi());
        }
    }

    private void set特徴期期別金額(Decimal choteiKyotsu, int ki) {
        switch (ki) {
            case 1:
                dbT2015.setTkKibetsuGaku01(choteiKyotsu);
                break;
            case 2:
                dbT2015.setTkKibetsuGaku02(choteiKyotsu);
                break;
            case 期3:
                dbT2015.setTkKibetsuGaku03(choteiKyotsu);
                break;
            case 期4:
                dbT2015.setTkKibetsuGaku04(choteiKyotsu);
                break;
            case 期5:
                dbT2015.setTkKibetsuGaku05(choteiKyotsu);
                break;
            case 期6:
                dbT2015.setTkKibetsuGaku06(choteiKyotsu);
                break;
            default:
                break;
        }
    }

    private void set普徴期期別金額(Decimal choteiKyotsu, int ki) {
        switch (ki) {
            case 1:
                dbT2015.setFuKibetsuGaku01(choteiKyotsu);
                break;
            case 2:
                dbT2015.setFuKibetsuGaku02(choteiKyotsu);
                break;
            case 期3:
                dbT2015.setFuKibetsuGaku03(choteiKyotsu);
                break;
            case 期4:
                dbT2015.setFuKibetsuGaku04(choteiKyotsu);
                break;
            case 期5:
                dbT2015.setFuKibetsuGaku05(choteiKyotsu);
                break;
            case 期6:
                dbT2015.setFuKibetsuGaku06(choteiKyotsu);
                break;
            case 期7:
                dbT2015.setFuKibetsuGaku07(choteiKyotsu);
                break;
            case 期8:
                dbT2015.setFuKibetsuGaku08(choteiKyotsu);
                break;
            case 期9:
                dbT2015.setFuKibetsuGaku09(choteiKyotsu);
                break;
            case 期10:
                dbT2015.setFuKibetsuGaku10(choteiKyotsu);
                break;
            case 期11:
                dbT2015.setFuKibetsuGaku11(choteiKyotsu);
                break;
            case 期12:
                dbT2015.setFuKibetsuGaku12(choteiKyotsu);
                break;
            case 期13:
                dbT2015.setFuKibetsuGaku13(choteiKyotsu);
                break;
            case 期14:
                dbT2015.setFuKibetsuGaku14(choteiKyotsu);
                break;
            default:
                break;
        }

    }

    private void set計算後情報From介護徴収方法ビュー(DbV2001ChoshuHohoEntity entity) {
        dbT2015.setChoshuHoho4gatsu(entity.getChoshuHoho4gatsu());
        dbT2015.setChoshuHoho5gatsu(entity.getChoshuHoho5gatsu());
        dbT2015.setChoshuHoho6gatsu(entity.getChoshuHoho6gatsu());
        dbT2015.setChoshuHoho7gatsu(entity.getChoshuHoho7gatsu());
        dbT2015.setChoshuHoho8gatsu(entity.getChoshuHoho8gatsu());
        dbT2015.setChoshuHoho9gatsu(entity.getChoshuHoho9gatsu());
        dbT2015.setChoshuHoho10gatsu(entity.getChoshuHoho10gatsu());
        dbT2015.setChoshuHoho11gatsu(entity.getChoshuHoho11gatsu());
        dbT2015.setChoshuHoho12gatsu(entity.getChoshuHoho12gatsu());
        dbT2015.setChoshuHoho1gatsu(entity.getChoshuHoho1gatsu());
        dbT2015.setChoshuHoho2gatsu(entity.getChoshuHoho2gatsu());
        dbT2015.setChoshuHoho3gatsu(entity.getChoshuHoho3gatsu());
        dbT2015.setChoshuHohoYoku4gatsu(entity.getChoshuHohoYoku4gatsu());
        dbT2015.setChoshuHohoYoku5gatsu(entity.getChoshuHohoYoku5gatsu());
        dbT2015.setChoshuHohoYoku6gatsu(entity.getChoshuHohoYoku6gatsu());
        dbT2015.setChoshuHohoYoku7gatsu(entity.getChoshuHohoYoku7gatsu());
        dbT2015.setChoshuHohoYoku8gatsu(entity.getChoshuHohoYoku8gatsu());
        dbT2015.setChoshuHohoYoku9gatsu(entity.getChoshuHohoYoku9gatsu());
        dbT2015.setKariNenkinNo(entity.getKariNenkinNo());
        dbT2015.setKariNenkinCode(entity.getKariNenkinCode());
        dbT2015.setKariHosokuM(entity.getKariHosokuM());
        dbT2015.setHonNenkinNo(entity.getHonNenkinNo());
        dbT2015.setHonNenkinCode(entity.getHonNenkinCode());
        dbT2015.setHonHosokuM(entity.getHonHosokuM());
        dbT2015.setYokunendoKariNenkinNo(entity.getYokunendoKariNenkinNo());
        dbT2015.setYokunendoKariNenkinCode(entity.getYokunendoKariNenkinCode());
        dbT2015.setYokunendoKariHosokuM(entity.getYokunendoKariHosokuM());
        dbT2015.setIraiSohuzumiFlag(entity.getIraiSohuzumiFlag());
        dbT2015.setTsuikaIraiSohuzumiFlag(entity.getTsuikaIraiSohuzumiFlag());
        dbT2015.setTokuchoTeishiNichiji(entity.getTokuchoTeishiNichiji());
        dbT2015.setTokuchoTeishiJiyuCode(entity.getTokuchoTeishiJiyuCode());
    }

    private void set計算後情報From介護徴収方法(DbT2001ChoshuHohoEntity entity) {
        dbT2015.setChoshuHoho4gatsu(entity.getChoshuHoho4gatsu());
        dbT2015.setChoshuHoho5gatsu(entity.getChoshuHoho5gatsu());
        dbT2015.setChoshuHoho6gatsu(entity.getChoshuHoho6gatsu());
        dbT2015.setChoshuHoho7gatsu(entity.getChoshuHoho7gatsu());
        dbT2015.setChoshuHoho8gatsu(entity.getChoshuHoho8gatsu());
        dbT2015.setChoshuHoho9gatsu(entity.getChoshuHoho9gatsu());
        dbT2015.setChoshuHoho10gatsu(entity.getChoshuHoho10gatsu());
        dbT2015.setChoshuHoho11gatsu(entity.getChoshuHoho11gatsu());
        dbT2015.setChoshuHoho12gatsu(entity.getChoshuHoho12gatsu());
        dbT2015.setChoshuHoho1gatsu(entity.getChoshuHoho1gatsu());
        dbT2015.setChoshuHoho2gatsu(entity.getChoshuHoho2gatsu());
        dbT2015.setChoshuHoho3gatsu(entity.getChoshuHoho3gatsu());
        dbT2015.setChoshuHohoYoku4gatsu(entity.getChoshuHohoYoku4gatsu());
        dbT2015.setChoshuHohoYoku5gatsu(entity.getChoshuHohoYoku5gatsu());
        dbT2015.setChoshuHohoYoku6gatsu(entity.getChoshuHohoYoku6gatsu());
        dbT2015.setChoshuHohoYoku7gatsu(entity.getChoshuHohoYoku7gatsu());
        dbT2015.setChoshuHohoYoku8gatsu(entity.getChoshuHohoYoku8gatsu());
        dbT2015.setChoshuHohoYoku9gatsu(entity.getChoshuHohoYoku9gatsu());
        dbT2015.setKariNenkinNo(entity.getKariNenkinNo());
        dbT2015.setKariNenkinCode(entity.getKariNenkinCode());
        dbT2015.setKariHosokuM(entity.getKariHosokuM());
        dbT2015.setHonNenkinNo(entity.getHonNenkinNo());
        dbT2015.setHonNenkinCode(entity.getHonNenkinCode());
        dbT2015.setHonHosokuM(entity.getHonHosokuM());
        dbT2015.setYokunendoKariNenkinNo(entity.getYokunendoKariNenkinNo());
        dbT2015.setYokunendoKariNenkinCode(entity.getYokunendoKariNenkinCode());
        dbT2015.setYokunendoKariHosokuM(entity.getYokunendoKariHosokuM());
        dbT2015.setIraiSohuzumiFlag(entity.getIraiSohuzumiFlag());
        dbT2015.setTsuikaIraiSohuzumiFlag(entity.getTsuikaIraiSohuzumiFlag());
        dbT2015.setTokuchoTeishiNichiji(entity.getTokuchoTeishiNichiji());
        dbT2015.setTokuchoTeishiJiyuCode(entity.getTokuchoTeishiJiyuCode());
    }

    private void set計算後情報From収入情報取得PSM(TotalShunyuRelateEntity totalShunyuEntity, DbT2003KibetsuEntity kibetsuEntity) {

        CaV0702SaishinShunyuEntity 最新収入Entity = totalShunyuEntity.get最新収入Entity();
        if (最新収入Entity != null && kibetsuEntity.getChoshuHouhou().equals(徴収方法1)) {
            set特徴収入額(最新収入Entity.getShunyugaku(), kibetsuEntity.getKi());
        }
        if (最新収入Entity != null && kibetsuEntity.getChoshuHouhou().equals(徴収方法2)) {
            set普徴収入額(最新収入Entity.getShunyugaku(), kibetsuEntity.getKi());
        }
    }

    private void set特徴収入額(Decimal shunyugaku, int ki) {
        switch (ki) {
            case 1:
                dbT2015.setTkShunyuGaku01(shunyugaku);
                break;
            case 2:
                dbT2015.setTkShunyuGaku02(shunyugaku);
                break;
            case 期3:
                dbT2015.setTkShunyuGaku03(shunyugaku);
                break;
            case 期4:
                dbT2015.setTkShunyuGaku04(shunyugaku);
                break;
            case 期5:
                dbT2015.setTkShunyuGaku05(shunyugaku);
                break;
            case 期6:
                dbT2015.setTkShunyuGaku06(shunyugaku);
                break;
            default:
                break;
        }

    }

    private void set普徴収入額(Decimal shunyugaku, int ki) {
        switch (ki) {
            case 1:
                dbT2015.setFuShunyuGaku01(shunyugaku);
                break;
            case 2:
                dbT2015.setFuShunyuGaku02(shunyugaku);
                break;
            case 期3:
                dbT2015.setFuShunyuGaku03(shunyugaku);
                break;
            case 期4:
                dbT2015.setFuShunyuGaku04(shunyugaku);
                break;
            case 期5:
                dbT2015.setFuShunyuGaku05(shunyugaku);
                break;
            case 期6:
                dbT2015.setFuShunyuGaku06(shunyugaku);
                break;
            case 期7:
                dbT2015.setFuShunyuGaku07(shunyugaku);
                break;
            case 期8:
                dbT2015.setFuShunyuGaku08(shunyugaku);
                break;
            case 期9:
                dbT2015.setFuShunyuGaku09(shunyugaku);
                break;
            case 期10:
                dbT2015.setFuShunyuGaku10(shunyugaku);
                break;
            case 期11:
                dbT2015.setFuShunyuGaku11(shunyugaku);
                break;
            case 期12:
                dbT2015.setFuShunyuGaku12(shunyugaku);
                break;
            case 期13:
                dbT2015.setFuShunyuGaku13(shunyugaku);
                break;
            case 期14:
                dbT2015.setFuShunyuGaku14(shunyugaku);
                break;
            default:
                break;
        }
    }

    private FlexibleDate setFlexibleDateFromFlexibleYearMonth(FlexibleYearMonth ym) {
        if (ym != null) {
            return new FlexibleDate(ym.toDateString().substring(0, 数値6));
        } else {
            return FlexibleDate.EMPTY;
        }
    }

    private void setMybatisParamter() {
        TotalShunyuSearchKeyBuilder searchKey = new TotalShunyuSearchKeyBuilder(SearchSokuhoKubun.全て, SearchSaishutsuKubun.全て);
        CaFt702FindTotalShunyuFunction psmEntity = new CaFt702FindTotalShunyuFunction(searchKey);
        mybatisParamter = KeisangoJohoSakuseiMybitisParamter.createSelectByKeyParam(processParamter.getChoteiNendo(),
                processParamter.getFukaNendo(),
                processParamter.getChoteiNichiji(),
                processParamter.getSakuseiShoriName(),
                processParamter.getChohyoBunruiID(),
                new RString(psmEntity.toString()));
    }
}
