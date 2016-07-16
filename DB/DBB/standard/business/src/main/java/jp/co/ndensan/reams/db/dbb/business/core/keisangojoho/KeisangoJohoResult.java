/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.keisangojoho;

import jp.co.ndensan.reams.ca.cax.entity.db.basic.CaV0702SaishinShunyuEntity;
import jp.co.ndensan.reams.ca.cax.entity.db.relate.TotalShunyuRelateEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.DbTKeisangoJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.KeisangoJohoSakuseiRelateEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 計算後情報作成のビジネスです。
 *
 * @reamsid_L DBB-9060-010 duanzhanli
 */
public class KeisangoJohoResult {

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
    private static final RString 徴収方法1 = new RString("1");
    private static final RString 徴収方法2 = new RString("2");
    private static final RString 更正前後区分_更正前 = new RString("1");
    private static final RString 更正前後区分_更正後 = new RString("2");

    /**
     * 計算中間Entityの設定メッソドです。
     *
     * @param entity 介護賦課
     * @return DbTKeisangoJohoTempTableEntity
     */
    public DbTKeisangoJohoTempTableEntity get計算中間Entity(DbT2002FukaEntity entity) {
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
        計算中間Entity.setTsukiwariStartYM1(entity.getTsukiwariStartYM1());
        計算中間Entity.setTsukiwariEndYM1(entity.getTsukiwariEndYM1());
        計算中間Entity.setHokenryoDankai2(entity.getHokenryoDankai2());
        計算中間Entity.setNengakuHokenryo2(entity.getNengakuHokenryo2());
        計算中間Entity.setTsukiwariStartYM2(entity.getTsukiwariStartYM2());
        計算中間Entity.setTsukiwariEndYM2(entity.getTsukiwariEndYM2());
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

    /**
     * 計算後情報Entityの設定メッソドです。
     *
     * @param entity 計算中間Entity
     * @return DbT2015KeisangoJohoEntity
     */
    public DbT2015KeisangoJohoEntity getDbT2015Entity(DbTKeisangoJohoTempTableEntity entity) {
        DbT2015KeisangoJohoEntity dbT2015entity = new DbT2015KeisangoJohoEntity();
        dbT2015entity.setChoteiNendo(entity.getChoteiNendo());
        dbT2015entity.setFukaNendo(entity.getFukaNendo());
        dbT2015entity.setTsuchishoNo(entity.getTsuchishoNo());
        dbT2015entity.setKoseiZengoKubun(entity.getKoseiZengoKubun());
        dbT2015entity.setSakuseiShoriName(entity.getSakuseiShoriName());
        dbT2015entity.setFukaRirekiNo(entity.getFukaRirekiNo());
        dbT2015entity.setHihokenshaNo(entity.getHihokenshaNo());
        dbT2015entity.setShikibetsuCode(entity.getShikibetsuCode());
        dbT2015entity.setSetaiCode(entity.getSetaiCode());
        dbT2015entity.setSetaiInsu(entity.getSetaiInsu());
        dbT2015entity.setShikakuShutokuYMD(entity.getShikakuShutokuYMD());
        dbT2015entity.setShikakuShutokuJiyu(entity.getShikakuShutokuJiyu());
        dbT2015entity.setShikakuSoshitsuYMD(entity.getShikakuSoshitsuYMD());
        dbT2015entity.setShikakuSoshitsuJiyu(entity.getShikakuSoshitsuJiyu());
        dbT2015entity.setSeihofujoShurui(entity.getSeihofujoShurui());
        dbT2015entity.setSeihoKaishiYMD(entity.getSeihoKaishiYMD());
        dbT2015entity.setSeihoHaishiYMD(entity.getSeihoHaishiYMD());
        dbT2015entity.setRonenKaishiYMD(entity.getRonenKaishiYMD());
        dbT2015entity.setRonenHaishiYMD(entity.getRonenHaishiYMD());
        dbT2015entity.setFukaYMD(entity.getFukaYMD());
        dbT2015entity.setKazeiKubun(entity.getKazeiKubun());
        dbT2015entity.setSetaikazeiKubun(entity.getSetaikazeiKubun());
        dbT2015entity.setGokeiShotokuGaku(entity.getGokeiShotokuGaku());
        dbT2015entity.setNenkinShunyuGaku(entity.getNenkinShunyuGaku());
        dbT2015entity.setHokenryoDankai(entity.getHokenryoDankai());
        dbT2015entity.setHokenryoDankai1(entity.getHokenryoDankai1());
        dbT2015entity.setNengakuHokenryo1(entity.getNengakuHokenryo1());
        dbT2015entity.setTsukiwariStartYM1(entity.getTsukiwariStartYM1());
        dbT2015entity.setTsukiwariEndYM1(entity.getTsukiwariEndYM1());
        dbT2015entity.setHokenryoDankai2(entity.getHokenryoDankai2());
        dbT2015entity.setNengakuHokenryo2(entity.getNengakuHokenryo2());
        dbT2015entity.setTsukiwariStartYM2(entity.getTsukiwariStartYM2());
        dbT2015entity.setTsukiwariEndYM2(entity.getTsukiwariEndYM2());
        dbT2015entity.setChoteiNichiji(entity.getChoteiNichiji());
        dbT2015entity.setChoteiJiyu1(entity.getChoteiJiyu1());
        dbT2015entity.setChoteiJiyu2(entity.getChoteiJiyu2());
        dbT2015entity.setChoteiJiyu3(entity.getChoteiJiyu3());
        dbT2015entity.setChoteiJiyu4(entity.getChoteiJiyu4());
        dbT2015entity.setKoseiM(entity.getKoseiM());
        dbT2015entity.setGemmenMaeHokenryo(entity.getGemmenMaeHokenryo());
        dbT2015entity.setGemmenGaku(entity.getGemmenGaku());
        dbT2015entity.setKakuteiHokenryo(entity.getKakuteiHokenryo());
        dbT2015entity.setHokenryoDankaiKarisanntei(entity.getHokenryoDankaiKarisanntei());
        dbT2015entity.setChoshuHohoRirekiNo(entity.getChoshuHohoRirekiNo());
        dbT2015entity.setIdoKijunNichiji(entity.getIdoKijunNichiji());
        dbT2015entity.setKozaKubun(entity.getKozaKubun());
        dbT2015entity.setKyokaisoKubun(entity.getKyokaisoKubun());
        dbT2015entity.setShokkenKubun(entity.getShokkenKubun());
        dbT2015entity.setFukaShichosonCode(entity.getFukaShichosonCode());
        dbT2015entity.setTkSaishutsuKampuGaku(entity.getTkSaishutsuKampuGaku());
        dbT2015entity.setFuSaishutsuKampuGaku(entity.getFuSaishutsuKampuGaku());
        dbT2015entity.setTkKibetsuGaku01(entity.getTkKibetsuGaku01());
        dbT2015entity.setTkKibetsuGaku02(entity.getTkKibetsuGaku02());
        dbT2015entity.setTkKibetsuGaku03(entity.getTkKibetsuGaku03());
        dbT2015entity.setTkKibetsuGaku04(entity.getTkKibetsuGaku04());
        dbT2015entity.setTkKibetsuGaku05(entity.getTkKibetsuGaku05());
        dbT2015entity.setTkKibetsuGaku06(entity.getTkKibetsuGaku06());
        dbT2015entity.setFuKibetsuGaku01(entity.getFuKibetsuGaku01());
        dbT2015entity.setFuKibetsuGaku02(entity.getFuKibetsuGaku02());
        dbT2015entity.setFuKibetsuGaku03(entity.getFuKibetsuGaku03());
        dbT2015entity.setFuKibetsuGaku04(entity.getFuKibetsuGaku04());
        dbT2015entity.setFuKibetsuGaku05(entity.getFuKibetsuGaku05());
        dbT2015entity.setFuKibetsuGaku06(entity.getFuKibetsuGaku06());
        dbT2015entity.setFuKibetsuGaku07(entity.getFuKibetsuGaku07());
        dbT2015entity.setFuKibetsuGaku08(entity.getFuKibetsuGaku08());
        dbT2015entity.setFuKibetsuGaku09(entity.getFuKibetsuGaku09());
        dbT2015entity.setFuKibetsuGaku10(entity.getFuKibetsuGaku10());
        dbT2015entity.setFuKibetsuGaku11(entity.getFuKibetsuGaku11());
        dbT2015entity.setFuKibetsuGaku12(entity.getFuKibetsuGaku12());
        dbT2015entity.setFuKibetsuGaku13(entity.getFuKibetsuGaku13());
        dbT2015entity.setFuKibetsuGaku14(entity.getFuKibetsuGaku14());
        dbT2015entity.setChoshuHoho4gatsu(entity.getChoshuHoho4gatsu());
        dbT2015entity.setChoshuHoho5gatsu(entity.getChoshuHoho5gatsu());
        dbT2015entity.setChoshuHoho6gatsu(entity.getChoshuHoho6gatsu());
        dbT2015entity.setChoshuHoho7gatsu(entity.getChoshuHoho7gatsu());
        dbT2015entity.setChoshuHoho8gatsu(entity.getChoshuHoho8gatsu());
        dbT2015entity.setChoshuHoho9gatsu(entity.getChoshuHoho9gatsu());
        dbT2015entity.setChoshuHoho10gatsu(entity.getChoshuHoho10gatsu());
        dbT2015entity.setChoshuHoho11gatsu(entity.getChoshuHoho11gatsu());
        dbT2015entity.setChoshuHoho12gatsu(entity.getChoshuHoho12gatsu());
        dbT2015entity.setChoshuHoho1gatsu(entity.getChoshuHoho1gatsu());
        dbT2015entity.setChoshuHoho2gatsu(entity.getChoshuHoho2gatsu());
        dbT2015entity.setChoshuHoho3gatsu(entity.getChoshuHoho3gatsu());
        dbT2015entity.setChoshuHohoYoku4gatsu(entity.getChoshuHohoYoku4gatsu());
        dbT2015entity.setChoshuHohoYoku5gatsu(entity.getChoshuHohoYoku5gatsu());
        dbT2015entity.setChoshuHohoYoku6gatsu(entity.getChoshuHohoYoku6gatsu());
        dbT2015entity.setChoshuHohoYoku7gatsu(entity.getChoshuHohoYoku7gatsu());
        dbT2015entity.setChoshuHohoYoku8gatsu(entity.getChoshuHohoYoku8gatsu());
        dbT2015entity.setChoshuHohoYoku9gatsu(entity.getChoshuHohoYoku9gatsu());
        dbT2015entity.setKariNenkinNo(entity.getKariNenkinNo());
        dbT2015entity.setKariNenkinCode(entity.getKariNenkinCode());
        dbT2015entity.setKariHosokuM(entity.getKariHosokuM());
        dbT2015entity.setHonNenkinNo(entity.getHonNenkinNo());
        dbT2015entity.setHonNenkinCode(entity.getHonNenkinCode());
        dbT2015entity.setHonHosokuM(entity.getHonHosokuM());
        dbT2015entity.setYokunendoKariNenkinNo(entity.getYokunendoKariNenkinNo());
        dbT2015entity.setYokunendoKariNenkinCode(entity.getYokunendoKariNenkinCode());
        dbT2015entity.setYokunendoKariHosokuM(entity.getYokunendoKariHosokuM());
        dbT2015entity.setIraiSohuzumiFlag(entity.isIraiSohuzumiFlag());
        dbT2015entity.setTsuikaIraiSohuzumiFlag(entity.isTsuikaIraiSohuzumiFlag());
        dbT2015entity.setTokuchoTeishiNichiji(entity.getTokuchoTeishiNichiji());
        dbT2015entity.setTokuchoTeishiJiyuCode(entity.getTokuchoTeishiJiyuCode());
        dbT2015entity.setTkShunyuGaku01(entity.getTkShunyuGaku01());
        dbT2015entity.setTkShunyuGaku02(entity.getTkShunyuGaku02());
        dbT2015entity.setTkShunyuGaku03(entity.getTkShunyuGaku03());
        dbT2015entity.setTkShunyuGaku04(entity.getTkShunyuGaku04());
        dbT2015entity.setTkShunyuGaku05(entity.getTkShunyuGaku05());
        dbT2015entity.setTkShunyuGaku06(entity.getTkShunyuGaku06());
        dbT2015entity.setFuShunyuGaku01(entity.getFuShunyuGaku01());
        dbT2015entity.setFuShunyuGaku02(entity.getFuShunyuGaku02());
        dbT2015entity.setFuShunyuGaku03(entity.getFuShunyuGaku03());
        dbT2015entity.setFuShunyuGaku04(entity.getFuShunyuGaku04());
        dbT2015entity.setFuShunyuGaku05(entity.getFuShunyuGaku05());
        dbT2015entity.setFuShunyuGaku06(entity.getFuShunyuGaku06());
        dbT2015entity.setFuShunyuGaku07(entity.getFuShunyuGaku07());
        dbT2015entity.setFuShunyuGaku08(entity.getFuShunyuGaku08());
        dbT2015entity.setFuShunyuGaku09(entity.getFuShunyuGaku09());
        dbT2015entity.setFuShunyuGaku10(entity.getFuShunyuGaku10());
        dbT2015entity.setFuShunyuGaku11(entity.getFuShunyuGaku11());
        dbT2015entity.setFuShunyuGaku12(entity.getFuShunyuGaku12());
        dbT2015entity.setFuShunyuGaku13(entity.getFuShunyuGaku13());
        dbT2015entity.setFuShunyuGaku14(entity.getFuShunyuGaku14());
        return dbT2015entity;
    }

    /**
     * 計算後情報Entityの設定メッソドです。
     *
     * @param entity 計算後情報作成Entity
     * @param 中間Entity 計算中間Entity
     * @param 更新フラグ 更新フラグ
     * @return DbTKeisangoJohoTempTableEntity
     */
    public DbTKeisangoJohoTempTableEntity get中間Entity(KeisangoJohoSakuseiRelateEntity entity,
            boolean 更新フラグ,
            DbTKeisangoJohoTempTableEntity 中間Entity) {
        set期別金額(entity, 中間Entity);
        set徴収方法(entity.get介護徴収方法Entity(), 更新フラグ, 中間Entity);
        return 中間Entity;
    }

    /**
     * 中間Entityの設定メッソドです。
     *
     * @param entity 計算後情報作成のRelateEntity
     * @param 中間Entity 計算中間Entity
     * @return DbTKeisangoJohoTempTableEntity
     */
    public DbTKeisangoJohoTempTableEntity get収入情報(KeisangoJohoSakuseiRelateEntity entity, DbTKeisangoJohoTempTableEntity 中間Entity) {
        TotalShunyuRelateEntity totalShunyuEntity = entity.get収入情報取得PSMEntity();
        DbT2003KibetsuEntity dbT2003Entity = entity.get介護期別Entity();
        if (totalShunyuEntity != null && dbT2003Entity != null) {
            CaV0702SaishinShunyuEntity 収入情報Entity = totalShunyuEntity.get最新収入Entity();
            if (収入情報Entity != null && dbT2003Entity.getChoshuHouhou().equals(徴収方法1)) {
                set特徴収入額(収入情報Entity.getShunyugaku(), dbT2003Entity.getKi(), 中間Entity);
            }
            if (収入情報Entity != null && dbT2003Entity.getChoshuHouhou().equals(徴収方法2)) {
                set普徴収入額(収入情報Entity.getShunyugaku(), dbT2003Entity.getKi(), 中間Entity);
            }
        }
        return 中間Entity;
    }

    private void set期別金額(KeisangoJohoSakuseiRelateEntity entity, DbTKeisangoJohoTempTableEntity 中間Entity) {
        UrT0705ChoteiKyotsuEntity urT0705Entity = entity.get調定共通介護継承Entity();
        DbT2003KibetsuEntity dbT2003Entity = entity.get介護期別Entity();
        if (urT0705Entity != null && dbT2003Entity != null) {
            if (dbT2003Entity.getChoshuHouhou().equals(徴収方法1)) {
                set特徴期期別金額(urT0705Entity.getChoteigaku(), dbT2003Entity.getKi(), 中間Entity);
            }
            if (dbT2003Entity.getChoshuHouhou().equals(徴収方法2)) {
                set普徴期期別金額(urT0705Entity.getChoteigaku(), dbT2003Entity.getKi(), 中間Entity);
            }
        }
    }

    private void set特徴期期別金額(Decimal choteigaku, int ki, DbTKeisangoJohoTempTableEntity 中間Entity) {
        switch (ki) {
            case 1:
                中間Entity.setTkKibetsuGaku01(choteigaku);
                break;
            case 2:
                中間Entity.setTkKibetsuGaku02(choteigaku);
                break;
            case 期3:
                中間Entity.setTkKibetsuGaku03(choteigaku);
                break;
            case 期4:
                中間Entity.setTkKibetsuGaku04(choteigaku);
                break;
            case 期5:
                中間Entity.setTkKibetsuGaku05(choteigaku);
                break;
            case 期6:
                中間Entity.setTkKibetsuGaku06(choteigaku);
                break;
            default:
                break;
        }
    }

    private void set普徴期期別金額(Decimal choteigaku, int ki, DbTKeisangoJohoTempTableEntity 中間Entity) {
        switch (ki) {
            case 1:
                中間Entity.setFuKibetsuGaku01(choteigaku);
                break;
            case 2:
                中間Entity.setFuKibetsuGaku02(choteigaku);
                break;
            case 期3:
                中間Entity.setFuKibetsuGaku03(choteigaku);
                break;
            case 期4:
                中間Entity.setFuKibetsuGaku04(choteigaku);
                break;
            case 期5:
                中間Entity.setFuKibetsuGaku05(choteigaku);
                break;
            case 期6:
                中間Entity.setFuKibetsuGaku06(choteigaku);
                break;
            case 期7:
                中間Entity.setFuKibetsuGaku07(choteigaku);
                break;
            case 期8:
                中間Entity.setFuKibetsuGaku08(choteigaku);
                break;
            case 期9:
                中間Entity.setFuKibetsuGaku09(choteigaku);
                break;
            case 期10:
                中間Entity.setFuKibetsuGaku10(choteigaku);
                break;
            case 期11:
                中間Entity.setFuKibetsuGaku11(choteigaku);
                break;
            case 期12:
                中間Entity.setFuKibetsuGaku12(choteigaku);
                break;
            case 期13:
                中間Entity.setFuKibetsuGaku13(choteigaku);
                break;
            case 期14:
                中間Entity.setFuKibetsuGaku14(choteigaku);
                break;
            default:
                break;
        }
    }

    private void set徴収方法(DbT2001ChoshuHohoEntity entity, boolean 更新フラグ, DbTKeisangoJohoTempTableEntity 中間Entity) {
        if (更新フラグ) {
            中間Entity.setKoseiZengoKubun(更正前後区分_更正前);
        } else {
            中間Entity.setKoseiZengoKubun(更正前後区分_更正後);
        }
        中間Entity.setChoshuHoho4gatsu(entity.getChoshuHoho4gatsu());
        中間Entity.setChoshuHoho5gatsu(entity.getChoshuHoho5gatsu());
        中間Entity.setChoshuHoho6gatsu(entity.getChoshuHoho6gatsu());
        中間Entity.setChoshuHoho7gatsu(entity.getChoshuHoho7gatsu());
        中間Entity.setChoshuHoho8gatsu(entity.getChoshuHoho8gatsu());
        中間Entity.setChoshuHoho9gatsu(entity.getChoshuHoho9gatsu());
        中間Entity.setChoshuHoho10gatsu(entity.getChoshuHoho10gatsu());
        中間Entity.setChoshuHoho11gatsu(entity.getChoshuHoho11gatsu());
        中間Entity.setChoshuHoho12gatsu(entity.getChoshuHoho12gatsu());
        中間Entity.setChoshuHoho1gatsu(entity.getChoshuHoho1gatsu());
        中間Entity.setChoshuHoho2gatsu(entity.getChoshuHoho2gatsu());
        中間Entity.setChoshuHoho3gatsu(entity.getChoshuHoho3gatsu());
        中間Entity.setChoshuHohoYoku4gatsu(entity.getChoshuHohoYoku4gatsu());
        中間Entity.setChoshuHohoYoku5gatsu(entity.getChoshuHohoYoku5gatsu());
        中間Entity.setChoshuHohoYoku6gatsu(entity.getChoshuHohoYoku6gatsu());
        中間Entity.setChoshuHohoYoku7gatsu(entity.getChoshuHohoYoku7gatsu());
        中間Entity.setChoshuHohoYoku8gatsu(entity.getChoshuHohoYoku8gatsu());
        中間Entity.setChoshuHohoYoku9gatsu(entity.getChoshuHohoYoku9gatsu());
        中間Entity.setKariNenkinNo(entity.getKariNenkinNo());
        中間Entity.setKariNenkinCode(entity.getKariNenkinCode());
        中間Entity.setKariHosokuM(entity.getKariHosokuM());
        中間Entity.setHonNenkinNo(entity.getHonNenkinNo());
        中間Entity.setHonNenkinCode(entity.getHonNenkinCode());
        中間Entity.setHonHosokuM(entity.getHonHosokuM());
        中間Entity.setYokunendoKariNenkinNo(entity.getYokunendoKariNenkinNo());
        中間Entity.setYokunendoKariNenkinCode(entity.getYokunendoKariNenkinCode());
        中間Entity.setYokunendoKariHosokuM(entity.getYokunendoKariHosokuM());
        中間Entity.setIraiSohuzumiFlag(entity.getIraiSohuzumiFlag());
        中間Entity.setTsuikaIraiSohuzumiFlag(entity.getTsuikaIraiSohuzumiFlag());
        中間Entity.setTokuchoTeishiNichiji(entity.getTokuchoTeishiNichiji());
        中間Entity.setTokuchoTeishiJiyuCode(entity.getTokuchoTeishiJiyuCode());
    }

    private void set特徴収入額(Decimal shunyugaku, int ki, DbTKeisangoJohoTempTableEntity 中間Entity) {
        switch (ki) {
            case 1:
                中間Entity.setTkShunyuGaku01(shunyugaku);
                break;
            case 2:
                中間Entity.setTkShunyuGaku02(shunyugaku);
                break;
            case 期3:
                中間Entity.setTkShunyuGaku03(shunyugaku);
                break;
            case 期4:
                中間Entity.setTkShunyuGaku04(shunyugaku);
                break;
            case 期5:
                中間Entity.setTkShunyuGaku05(shunyugaku);
                break;
            case 期6:
                中間Entity.setTkShunyuGaku06(shunyugaku);
                break;
            default:
                break;
        }

    }

    private void set普徴収入額(Decimal shunyugaku, int ki, DbTKeisangoJohoTempTableEntity 中間Entity) {
        switch (ki) {
            case 1:
                中間Entity.setFuShunyuGaku01(shunyugaku);
                break;
            case 2:
                中間Entity.setFuShunyuGaku02(shunyugaku);
                break;
            case 期3:
                中間Entity.setFuShunyuGaku03(shunyugaku);
                break;
            case 期4:
                中間Entity.setFuShunyuGaku04(shunyugaku);
                break;
            case 期5:
                中間Entity.setFuShunyuGaku05(shunyugaku);
                break;
            case 期6:
                中間Entity.setFuShunyuGaku06(shunyugaku);
                break;
            case 期7:
                中間Entity.setFuShunyuGaku07(shunyugaku);
                break;
            case 期8:
                中間Entity.setFuShunyuGaku08(shunyugaku);
                break;
            case 期9:
                中間Entity.setFuShunyuGaku09(shunyugaku);
                break;
            case 期10:
                中間Entity.setFuShunyuGaku10(shunyugaku);
                break;
            case 期11:
                中間Entity.setFuShunyuGaku11(shunyugaku);
                break;
            case 期12:
                中間Entity.setFuShunyuGaku12(shunyugaku);
                break;
            case 期13:
                中間Entity.setFuShunyuGaku13(shunyugaku);
                break;
            case 期14:
                中間Entity.setFuShunyuGaku14(shunyugaku);
                break;
            default:
                break;
        }
    }
}
