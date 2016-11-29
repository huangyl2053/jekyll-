/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.honnsanteifuka;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.FukaCalculateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.FukaCalculateTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.KuBunnGaTsurakuTempEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaTorokuKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.YokinShubetsuPatternCodeValue;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaT0301YokinShubetsuPatternEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaT0310KozaEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 賦課計算中間一時テーブルに登録を作成のクラスです。
 *
 * @reamsid_L DBB-0730-010 lijunjun
 */
public class CreatCalCulateEntity {

    private static final RString 徴収方法1 = new RString("1");
    private static final RString 徴収方法2 = new RString("2");
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_9 = 9;
    private static final int INDEX_10 = 10;
    private static final int INDEX_11 = 11;
    private static final int INDEX_12 = 12;
    private static final int INDEX_13 = 13;
    private static final int INDEX_14 = 14;
    private static final int INDEX_15 = 15;
    private static final int INDEX_16 = 16;
    private static final int INDEX_17 = 17;
    private static final int INDEX_18 = 18;
    private static final int INDEX_19 = 19;
    private static final int INDEX_20 = 20;
    private static final int INDEX_21 = 21;
    private static final int INDEX_22 = 22;
    private static final int INDEX_23 = 23;
    private static final int INDEX_24 = 24;
    private static final int INDEX_25 = 25;
    private static final int INDEX_26 = 26;
    private static final int INDEX_27 = 27;
    private static final int INDEX_28 = 28;
    private static final int INDEX_29 = 29;
    private static final int INDEX_30 = 30;
    private static final int INDEX_31 = 31;
    private static final int INDEX_32 = 32;
    private static final int INDEX_33 = 33;
    private static final int INDEX_34 = 34;
    private static final int INDEX_35 = 35;
    private static final int INDEX_36 = 36;
    private static final int INDEX_37 = 37;
    private static final int INDEX_38 = 38;
    private static final int INDEX_39 = 39;
    private static final int INDEX_40 = 40;
    private static final int INDEX_41 = 41;
    private static final int INDEX_42 = 42;
    private static final int INDEX_43 = 43;
    private static final int INDEX_44 = 44;
    private static final int INDEX_45 = 45;
    private static final int INDEX_46 = 46;
    private static final int INDEX_47 = 47;
    private static final int INDEX_48 = 48;
    private static final int INDEX_49 = 49;
    private static final int INDEX_50 = 50;

    /**
     * にて生成した{@link CreatFukaEntity}のインスタンスを返します。
     *
     * @return CreatFukaEntity
     */
    public static CreatCalCulateEntity createInstance() {
        return InstanceProvider.create(CreatCalCulateEntity.class);
    }

    /**
     * 賦課Entityを作成のメソッドです。
     *
     * @param entity FukaCalculateTempEntity
     * @param 賦課計算entity FukaCalculateEntity
     * @return FukaCalculateTempEntity
     */
    public FukaCalculateTempEntity creat賦課Entity(FukaCalculateTempEntity entity,
            FukaCalculateEntity 賦課計算entity) {
        entity = set介護賦課Entity(entity, 賦課計算entity);
        return entity;
    }

    /**
     * 期別金額Entityを作成のメソッドです。
     *
     * @param entity FukaCalculateTempEntity
     * @param 賦課計算entity FukaCalculateEntity
     * @return FukaCalculateTempEntity
     */
    public FukaCalculateTempEntity creat期別金額Entity(FukaCalculateTempEntity entity,
            FukaCalculateEntity 賦課計算entity) {
        entity = set期別金額(entity, 賦課計算entity);
        return entity;
    }

    private FukaCalculateTempEntity set介護賦課Entity(FukaCalculateTempEntity entity,
            FukaCalculateEntity 賦課計算entity) {
        DbT2002FukaEntity 賦課情報Entity = 賦課計算entity.get介護賦課Entity();
        entity.setDbT2002_choteiNendo(賦課情報Entity.getChoteiNendo());
        entity.setDbT2002_fukaNendo(賦課情報Entity.getFukaNendo());
        entity.setDbT2002_tsuchishoNo(賦課情報Entity.getTsuchishoNo());
        entity.setDbT2002_rirekiNo(賦課情報Entity.getRirekiNo());
        entity.setDbT2002_hihokenshaNo(賦課情報Entity.getHihokenshaNo());
        entity.setDbT2002_shikibetsuCode(賦課情報Entity.getShikibetsuCode());
        entity.setDbT2002_setaiCode(賦課情報Entity.getSetaiCode());
        entity.setDbT2002_setaiInsu(賦課情報Entity.getSetaiInsu());
        entity.setDbT2002_shikakuShutokuYMD(賦課情報Entity.getShikakuShutokuYMD());
        entity.setDbT2002_shikakuShutokuJiyu(賦課情報Entity.getShikakuShutokuJiyu());
        entity.setDbT2002_shikakuSoshitsuYMD(賦課情報Entity.getShikakuSoshitsuYMD());
        entity.setDbT2002_shikakuSoshitsuJiyu(賦課情報Entity.getShikakuSoshitsuJiyu());
        entity.setDbT2002_seihofujoShurui(賦課情報Entity.getSeihofujoShurui());
        entity.setDbT2002_seihoKaishiYMD(賦課情報Entity.getSeihoKaishiYMD());
        entity.setDbT2002_seihoHaishiYMD(賦課情報Entity.getSeihoHaishiYMD());
        entity.setDbT2002_ronenKaishiYMD(賦課情報Entity.getRonenKaishiYMD());
        entity.setDbT2002_ronenHaishiYMD(賦課情報Entity.getRonenHaishiYMD());
        entity.setDbT2002_fukaYMD(賦課情報Entity.getFukaYMD());
        entity.setDbT2002_kazeiKubun(賦課情報Entity.getKazeiKubun());
        entity.setDbT2002_setaikazeiKubun(賦課情報Entity.getSetaikazeiKubun());
        entity.setDbT2002_gokeiShotokuGaku(賦課情報Entity.getGokeiShotokuGaku());
        entity.setDbT2002_nenkinShunyuGaku(賦課情報Entity.getNenkinShunyuGaku());
        entity.setDbT2002_hokenryoDankai(賦課情報Entity.getHokenryoDankai());
        entity.setDbT2002_hokenryoDankai1(賦課情報Entity.getHokenryoDankai1());
        entity.setDbT2002_nengakuHokenryo1(賦課情報Entity.getNengakuHokenryo1());
        entity.setDbT2002_tsukiwariStartYM1(賦課情報Entity.getTsukiwariStartYM1());
        entity.setDbT2002_tsukiwariEndYM1(賦課情報Entity.getTsukiwariEndYM1());
        entity.setDbT2002_hokenryoDankai2(賦課情報Entity.getHokenryoDankai2());
        entity.setDbT2002_nengakuHokenryo2(賦課情報Entity.getNengakuHokenryo2());
        entity.setDbT2002_tsukiwariStartYM2(賦課情報Entity.getTsukiwariStartYM2());
        entity.setDbT2002_tsukiwariEndYM2(賦課情報Entity.getTsukiwariEndYM2());
        entity.setDbT2002_choteiNichiji(賦課情報Entity.getChoteiNichiji());
        entity.setDbT2002_choteiJiyu1(賦課情報Entity.getChoteiJiyu1());
        entity.setDbT2002_choteiJiyu2(賦課情報Entity.getChoteiJiyu2());
        entity.setDbT2002_choteiJiyu3(賦課情報Entity.getChoteiJiyu3());
        entity.setDbT2002_choteiJiyu4(賦課情報Entity.getChoteiJiyu4());
        entity.setDbT2002_koseiM(賦課情報Entity.getKoseiM());
        entity.setDbT2002_gemmenMaeHokenryo(賦課情報Entity.getGemmenMaeHokenryo());
        entity.setDbT2002_gemmenGaku(賦課情報Entity.getGemmenGaku());
        entity.setDbT2002_kakuteiHokenryo(賦課情報Entity.getKakuteiHokenryo());
        entity.setDbT2002_hokenryoDankaiKarisanntei(賦課情報Entity.getHokenryoDankaiKarisanntei());
        entity.setDbT2002_choshuHohoRirekiNo(賦課情報Entity.getChoshuHohoRirekiNo());
        entity.setDbT2002_idoKijunNichiji(賦課情報Entity.getIdoKijunNichiji());
        entity.setDbT2002_kozaKubun(賦課情報Entity.getKozaKubun());
        entity.setDbT2002_kyokaisoKubun(賦課情報Entity.getKyokaisoKubun());
        entity.setDbT2002_shokkenKubun(賦課情報Entity.getShokkenKubun());
        entity.setDbT2002_fukaShichosonCode(賦課情報Entity.getFukaShichosonCode());
        entity.setDbT2002_tkSaishutsuKampuGaku(賦課情報Entity.getTkSaishutsuKampuGaku());
        entity.setDbT2002_fuSaishutsuKampuGaku(賦課情報Entity.getFuSaishutsuKampuGaku());
        return entity;
    }

    private FukaCalculateTempEntity set期別金額(FukaCalculateTempEntity 中間Entity, FukaCalculateEntity entity) {
        UrT0705ChoteiKyotsuEntity urT0705Entity = entity.get調定共通Entity();
        DbT2003KibetsuEntity dbT2003Entity = entity.get介護期別Entity();
        if (urT0705Entity != null && dbT2003Entity != null) {
            if (dbT2003Entity.getChoshuHouhou().equals(徴収方法1)) {
                中間Entity = set特徴期期別金額(urT0705Entity.getChoteigaku(), dbT2003Entity.getKi(), 中間Entity);
            }
            if (dbT2003Entity.getChoshuHouhou().equals(徴収方法2)) {
                中間Entity = set普徴期期別金額(urT0705Entity.getChoteigaku(), dbT2003Entity.getKi(), 中間Entity);
            }
        }
        return 中間Entity;
    }

    private FukaCalculateTempEntity set特徴期期別金額(Decimal shunyugaku, int ki, FukaCalculateTempEntity 中間Entity) {
        switch (ki) {
            case INDEX_1:
                中間Entity.setTkKibetsuGaku01(shunyugaku);
                break;
            case INDEX_2:
                中間Entity.setTkKibetsuGaku02(shunyugaku);
                break;
            case INDEX_3:
                中間Entity.setTkKibetsuGaku03(shunyugaku);
                break;
            case INDEX_4:
                中間Entity.setTkKibetsuGaku04(shunyugaku);
                break;
            case INDEX_5:
                中間Entity.setTkKibetsuGaku05(shunyugaku);
                break;
            case INDEX_6:
                中間Entity.setTkKibetsuGaku06(shunyugaku);
                break;
            default:
                break;
        }
        return 中間Entity;
    }

    private FukaCalculateTempEntity set普徴期期別金額(Decimal shunyugaku, int ki, FukaCalculateTempEntity 中間Entity) {
        switch (ki) {
            case INDEX_1:
                中間Entity.setFuKibetsuGaku01(shunyugaku);
                break;
            case INDEX_2:
                中間Entity.setFuKibetsuGaku02(shunyugaku);
                break;
            case INDEX_3:
                中間Entity.setFuKibetsuGaku03(shunyugaku);
                break;
            case INDEX_4:
                中間Entity.setFuKibetsuGaku04(shunyugaku);
                break;
            case INDEX_5:
                中間Entity.setFuKibetsuGaku05(shunyugaku);
                break;
            case INDEX_6:
                中間Entity.setFuKibetsuGaku06(shunyugaku);
                break;
            case INDEX_7:
                中間Entity.setFuKibetsuGaku07(shunyugaku);
                break;
            case INDEX_8:
                中間Entity.setFuKibetsuGaku08(shunyugaku);
                break;
            case INDEX_9:
                中間Entity.setFuKibetsuGaku09(shunyugaku);
                break;
            case INDEX_10:
                中間Entity.setFuKibetsuGaku10(shunyugaku);
                break;
            case INDEX_11:
                中間Entity.setFuKibetsuGaku11(shunyugaku);
                break;
            case INDEX_12:
                中間Entity.setFuKibetsuGaku12(shunyugaku);
                break;
            case INDEX_13:
                中間Entity.setFuKibetsuGaku13(shunyugaku);
                break;
            case INDEX_14:
                中間Entity.setFuKibetsuGaku14(shunyugaku);
                break;
            default:
                break;
        }
        return 中間Entity;
    }

    /**
     * 賦課計算を作成のメソッドです。
     *
     * @param entity FukaCalculateTempEntity
     * @param 賦課計算entity FukaCalculateEntity
     * @return FukaCalculateTempEntity
     */
    public FukaCalculateTempEntity creat賦課計算Entity(FukaCalculateTempEntity entity,
            FukaCalculateEntity 賦課計算entity) {
        entity.setChoteiNendo(賦課計算entity.getChoteiNendo());
        entity.setFukaNendo(賦課計算entity.getFukaNendo());
        entity.setTsuchishoNo(賦課計算entity.getTsuchishoNo());
        entity.setKijunYMD(賦課計算entity.getKijunYMD());
        entity = set本算定抽出Temp(賦課計算entity, entity);
        entity = set月別Temp(賦課計算entity, entity);
        entity = set徴収方法Newest(賦課計算entity, entity);
        entity = set口座(賦課計算entity, entity);
        return entity;
    }

    /**
     * 賦課計算Entityを作成のメソッドです。
     *
     * @param entity FukaCalculateTempEntity
     * @param 世帯員所得情報Entity SetaiShotokuEntity
     * @param index int
     * @return FukaCalculateTempEntity
     */
    public FukaCalculateTempEntity creat世帯員所得情報Entity(FukaCalculateTempEntity entity,
            SetaiShotokuEntity 世帯員所得情報Entity,
            int index) {
        entity = set世帯員所得情報_1(entity, 世帯員所得情報Entity, index);
        entity = set世帯員所得情報_2(entity, 世帯員所得情報Entity, index);
        entity = set世帯員所得情報_3(entity, 世帯員所得情報Entity, index);
        entity = set世帯員所得情報_4(entity, 世帯員所得情報Entity, index);
        entity = set世帯員所得情報_5(entity, 世帯員所得情報Entity, index);
        entity = set世帯員所得情報_6(entity, 世帯員所得情報Entity, index);
        entity = set世帯員所得情報_7(entity, 世帯員所得情報Entity, index);
        entity = set世帯員所得情報_8(entity, 世帯員所得情報Entity, index);
        entity = set世帯員所得情報_9(entity, 世帯員所得情報Entity, index);
        entity = set世帯員所得情報_10(entity, 世帯員所得情報Entity, index);
        return entity;
    }

    private FukaCalculateTempEntity set世帯員所得情報_10(FukaCalculateTempEntity entity,
            SetaiShotokuEntity 世帯員所得情報Entity, int index) {

        if (世帯員所得情報Entity != null && index == INDEX_46) {
            entity.setSetai_hihokenshaNo_46(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_46(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_46(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_46(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_46(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_46(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_46(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_46(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_46(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_46(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_46(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_46(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_46(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_46(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_46(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_47) {
            entity.setSetai_hihokenshaNo_47(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_47(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_47(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_47(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_47(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_47(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_47(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_47(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_47(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_47(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_47(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_47(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_47(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_47(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_47(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_48) {
            entity.setSetai_hihokenshaNo_48(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_48(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_48(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_48(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_48(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_48(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_48(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_48(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_48(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_48(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_48(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_48(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_48(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_48(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_48(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_49) {
            entity.setSetai_hihokenshaNo_49(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_49(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_49(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_49(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_49(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_49(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_49(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_49(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_49(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_49(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_49(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_49(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_49(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_49(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_49(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_50) {
            entity.setSetai_hihokenshaNo_50(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_50(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_50(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_50(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_50(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_50(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_50(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_50(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_50(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_50(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_50(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_50(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_50(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_50(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_50(世帯員所得情報Entity.getTorokuGyomu());
        }
        return entity;
    }

    private FukaCalculateTempEntity set世帯員所得情報_9(FukaCalculateTempEntity entity,
            SetaiShotokuEntity 世帯員所得情報Entity, int index) {
        if (世帯員所得情報Entity != null && index == INDEX_41) {
            entity.setSetai_hihokenshaNo_41(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_41(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_41(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_41(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_41(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_41(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_41(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_41(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_41(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_41(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_41(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_41(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_41(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_41(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_41(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_42) {
            entity.setSetai_hihokenshaNo_42(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_42(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_42(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_42(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_42(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_42(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_42(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_42(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_42(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_42(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_42(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_42(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_42(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_42(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_42(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_43) {
            entity.setSetai_hihokenshaNo_43(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_43(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_43(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_43(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_43(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_43(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_43(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_43(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_43(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_43(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_43(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_43(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_43(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_43(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_43(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_44) {
            entity.setSetai_hihokenshaNo_44(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_44(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_44(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_44(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_44(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_44(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_44(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_44(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_44(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_44(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_44(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_44(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_44(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_44(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_44(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_45) {
            entity.setSetai_hihokenshaNo_45(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_45(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_45(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_45(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_45(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_45(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_45(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_45(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_45(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_45(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_45(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_45(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_45(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_45(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_45(世帯員所得情報Entity.getTorokuGyomu());
        }
        return entity;
    }

    private FukaCalculateTempEntity set世帯員所得情報_8(FukaCalculateTempEntity entity,
            SetaiShotokuEntity 世帯員所得情報Entity, int index) {
        if (世帯員所得情報Entity != null && index == INDEX_36) {
            entity.setSetai_hihokenshaNo_36(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_36(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_36(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_36(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_36(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_36(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_36(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_36(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_36(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_36(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_36(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_36(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_36(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_36(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_36(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_37) {
            entity.setSetai_hihokenshaNo_37(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_37(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_37(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_37(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_37(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_37(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_37(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_37(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_37(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_37(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_37(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_37(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_37(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_37(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_37(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_38) {
            entity.setSetai_hihokenshaNo_38(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_38(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_38(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_38(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_38(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_38(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_38(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_38(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_38(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_38(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_38(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_38(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_38(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_38(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_38(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_39) {
            entity.setSetai_hihokenshaNo_39(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_39(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_39(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_39(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_39(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_39(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_39(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_39(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_39(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_39(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_39(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_39(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_39(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_39(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_39(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_40) {
            entity.setSetai_hihokenshaNo_40(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_40(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_40(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_40(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_40(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_40(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_40(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_40(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_40(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_40(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_40(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_40(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_40(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_40(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_40(世帯員所得情報Entity.getTorokuGyomu());
        }
        return entity;
    }

    private FukaCalculateTempEntity set世帯員所得情報_7(FukaCalculateTempEntity entity,
            SetaiShotokuEntity 世帯員所得情報Entity, int index) {
        if (世帯員所得情報Entity != null && index == INDEX_31) {
            entity.setSetai_hihokenshaNo_31(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_31(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_31(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_31(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_31(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_31(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_31(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_31(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_31(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_31(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_31(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_31(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_31(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_31(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_31(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_32) {
            entity.setSetai_hihokenshaNo_32(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_32(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_32(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_32(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_32(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_32(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_32(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_32(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_32(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_32(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_32(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_32(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_32(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_32(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_32(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_33) {
            entity.setSetai_hihokenshaNo_33(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_33(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_33(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_33(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_33(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_33(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_33(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_33(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_33(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_33(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_33(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_33(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_33(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_33(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_33(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_34) {
            entity.setSetai_hihokenshaNo_34(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_34(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_34(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_34(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_34(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_34(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_34(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_34(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_34(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_34(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_34(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_34(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_34(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_34(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_34(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_35) {
            entity.setSetai_hihokenshaNo_35(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_35(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_35(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_35(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_35(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_35(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_35(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_35(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_35(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_35(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_35(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_35(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_35(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_35(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_35(世帯員所得情報Entity.getTorokuGyomu());
        }
        return entity;
    }

    private FukaCalculateTempEntity set世帯員所得情報_6(FukaCalculateTempEntity entity,
            SetaiShotokuEntity 世帯員所得情報Entity, int index) {
        if (世帯員所得情報Entity != null && index == INDEX_26) {
            entity.setSetai_hihokenshaNo_26(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_26(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_26(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_26(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_26(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_26(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_26(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_26(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_26(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_26(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_26(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_26(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_26(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_26(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_26(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_27) {
            entity.setSetai_hihokenshaNo_27(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_27(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_27(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_27(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_27(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_27(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_27(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_27(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_27(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_27(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_27(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_27(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_27(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_27(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_27(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_28) {
            entity.setSetai_hihokenshaNo_28(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_28(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_28(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_28(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_28(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_28(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_28(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_28(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_28(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_28(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_28(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_28(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_28(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_28(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_28(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_29) {
            entity.setSetai_hihokenshaNo_29(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_29(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_29(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_29(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_29(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_29(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_29(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_29(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_29(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_29(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_29(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_29(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_29(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_29(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_29(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_30) {
            entity.setSetai_hihokenshaNo_30(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_30(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_30(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_30(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_30(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_30(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_30(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_30(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_30(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_30(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_30(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_30(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_30(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_30(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_30(世帯員所得情報Entity.getTorokuGyomu());
        }
        return entity;
    }

    private FukaCalculateTempEntity set世帯員所得情報_5(FukaCalculateTempEntity entity,
            SetaiShotokuEntity 世帯員所得情報Entity, int index) {
        if (世帯員所得情報Entity != null && index == INDEX_21) {
            entity.setSetai_hihokenshaNo_21(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_21(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_21(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_21(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_21(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_21(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_21(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_21(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_21(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_21(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_21(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_21(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_21(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_21(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_21(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_22) {
            entity.setSetai_hihokenshaNo_22(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_22(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_22(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_22(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_22(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_22(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_22(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_22(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_22(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_22(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_22(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_22(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_22(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_22(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_22(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_23) {
            entity.setSetai_hihokenshaNo_23(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_23(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_23(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_23(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_23(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_23(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_23(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_23(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_23(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_23(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_23(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_23(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_23(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_23(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_23(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_24) {
            entity.setSetai_hihokenshaNo_24(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_24(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_24(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_24(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_24(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_24(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_24(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_24(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_24(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_24(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_24(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_24(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_24(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_24(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_24(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_25) {
            entity.setSetai_hihokenshaNo_25(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_25(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_25(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_25(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_25(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_25(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_25(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_25(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_25(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_25(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_25(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_25(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_25(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_25(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_25(世帯員所得情報Entity.getTorokuGyomu());
        }
        return entity;
    }

    private FukaCalculateTempEntity set世帯員所得情報_4(FukaCalculateTempEntity entity,
            SetaiShotokuEntity 世帯員所得情報Entity, int index) {
        if (世帯員所得情報Entity != null && index == INDEX_16) {
            entity.setSetai_hihokenshaNo_16(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_16(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_16(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_16(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_16(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_16(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_16(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_16(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_16(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_16(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_16(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_16(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_16(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_16(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_16(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_17) {
            entity.setSetai_hihokenshaNo_17(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_17(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_17(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_17(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_17(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_17(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_17(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_17(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_17(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_17(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_17(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_17(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_17(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_17(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_17(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_18) {
            entity.setSetai_hihokenshaNo_18(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_18(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_18(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_18(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_18(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_18(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_18(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_18(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_18(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_18(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_18(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_18(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_18(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_18(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_18(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_19) {
            entity.setSetai_hihokenshaNo_19(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_19(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_19(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_19(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_19(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_19(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_19(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_19(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_19(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_19(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_19(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_19(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_19(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_19(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_19(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_20) {
            entity.setSetai_hihokenshaNo_20(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_20(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_20(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_20(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_20(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_20(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_20(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_20(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_20(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_20(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_20(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_20(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_20(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_20(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_20(世帯員所得情報Entity.getTorokuGyomu());
        }
        return entity;
    }

    private FukaCalculateTempEntity set世帯員所得情報_3(FukaCalculateTempEntity entity,
            SetaiShotokuEntity 世帯員所得情報Entity, int index) {
        if (世帯員所得情報Entity != null && index == INDEX_11) {
            entity.setSetai_hihokenshaNo_11(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_11(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_11(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_11(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_11(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_11(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_11(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_11(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_11(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_11(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_11(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_11(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_11(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_11(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_11(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_12) {
            entity.setSetai_hihokenshaNo_12(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_12(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_12(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_12(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_12(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_12(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_12(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_12(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_12(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_12(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_12(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_12(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_12(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_12(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_12(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_13) {
            entity.setSetai_hihokenshaNo_13(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_13(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_13(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_13(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_13(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_13(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_13(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_13(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_13(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_13(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_13(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_13(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_13(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_13(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_13(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_14) {
            entity.setSetai_hihokenshaNo_14(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_14(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_14(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_14(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_14(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_14(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_14(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_14(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_14(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_14(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_14(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_14(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_14(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_14(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_14(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_15) {
            entity.setSetai_hihokenshaNo_15(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_15(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_15(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_15(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_15(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_15(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_15(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_15(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_15(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_15(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_15(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_15(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_15(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_15(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_15(世帯員所得情報Entity.getTorokuGyomu());
        }
        return entity;
    }

    private FukaCalculateTempEntity set世帯員所得情報_2(FukaCalculateTempEntity entity,
            SetaiShotokuEntity 世帯員所得情報Entity, int index) {
        if (世帯員所得情報Entity != null && index == INDEX_6) {
            entity.setSetai_hihokenshaNo_6(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_6(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_6(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_6(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_6(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_6(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_6(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_6(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_6(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_6(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_6(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_6(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_6(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_6(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_6(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_7) {
            entity.setSetai_hihokenshaNo_7(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_7(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_7(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_7(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_7(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_7(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_7(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_7(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_7(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_7(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_7(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_7(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_7(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_7(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_7(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_8) {
            entity.setSetai_hihokenshaNo_8(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_8(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_8(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_8(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_8(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_8(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_8(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_8(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_8(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_8(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_8(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_8(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_8(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_8(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_8(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_9) {
            entity.setSetai_hihokenshaNo_9(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_9(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_9(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_9(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_9(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_9(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_9(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_9(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_9(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_9(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_9(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_9(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_9(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_9(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_9(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_10) {
            entity.setSetai_hihokenshaNo_10(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_10(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_10(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_10(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_10(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_10(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_10(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_10(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_10(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_10(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_10(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_10(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_10(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_10(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_10(世帯員所得情報Entity.getTorokuGyomu());
        }
        return entity;
    }

    private FukaCalculateTempEntity set世帯員所得情報_1(FukaCalculateTempEntity entity,
            SetaiShotokuEntity 世帯員所得情報Entity, int index) {
        if (世帯員所得情報Entity != null && index == INDEX_1) {
            entity.setSetai_hihokenshaNo_1(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_1(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_1(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_1(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_1(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_1(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_1(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_1(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_1(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_1(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_1(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_1(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_1(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_1(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_1(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_2) {
            entity.setSetai_hihokenshaNo_2(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_2(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_2(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_2(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_2(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_2(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_2(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_2(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_2(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_2(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_2(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_2(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_2(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_2(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_2(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_3) {
            entity.setSetai_hihokenshaNo_3(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_3(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_3(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_3(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_3(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_3(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_3(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_3(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_3(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_3(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_3(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_3(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_3(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_3(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_3(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_4) {
            entity.setSetai_hihokenshaNo_4(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_4(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_4(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_4(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_4(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_4(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_4(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_4(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_4(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_4(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_4(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_4(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_4(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_4(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_4(世帯員所得情報Entity.getTorokuGyomu());
        }
        if (世帯員所得情報Entity != null && index == INDEX_5) {
            entity.setSetai_hihokenshaNo_5(世帯員所得情報Entity.getHihokenshaNo());
            entity.setSetai_shikibetsuCode_5(世帯員所得情報Entity.getShikibetsuCode());
            entity.setSetai_kijunYMD_5(世帯員所得情報Entity.getKijunYMD());
            entity.setSetai_shotokuNendo_5(世帯員所得情報Entity.getShotokuNendo());
            entity.setSetai_jushochiTokureiFlag_5(世帯員所得情報Entity.getJushochiTokureiFlag());
            entity.setSetai_setaiCode_5(世帯員所得情報Entity.getSetaiCode());
            entity.setSetai_honninKubun_5(世帯員所得情報Entity.getHonninKubun());
            entity.setSetai_kazeiKubun_5(世帯員所得情報Entity.getKazeiKubun());
            entity.setSetai_kazeiKubunGemmenGo_5(世帯員所得情報Entity.getKazeiKubunGemmenGo());
            entity.setSetai_gekihenKanwaKubun_5(世帯員所得情報Entity.getGekihenKanwaKubun());
            entity.setSetai_gokeiShotokuGaku_5(世帯員所得情報Entity.getGokeiShotokuGaku());
            entity.setSetai_nenkiniShunyuGaku_5(世帯員所得情報Entity.getNenkiniShunyuGaku());
            entity.setSetai_nenkiniShotokuGaku_5(世帯員所得情報Entity.getNenkiniShotokuGaku());
            entity.setSetai_kazeiShotokuGaku_5(世帯員所得情報Entity.getKazeiShotokuGaku());
            entity.setSetai_torokuGyomu_5(世帯員所得情報Entity.getTorokuGyomu());
        }
        return entity;
    }

    private FukaCalculateTempEntity set口座(FukaCalculateEntity 賦課計算entity, FukaCalculateTempEntity entity) {
        // 口座（PSM）全ての内容
        if (賦課計算entity.get特定口座() != null && 賦課計算entity.get特定口座().getUaT0310KozaEntity() != null) {
            UaT0310KozaEntity uaT0310Entity = 賦課計算entity.get特定口座().getUaT0310KozaEntity();
            entity.setUaT0310Koza_kozaId(uaT0310Entity.getKozaId());
            entity.setUaT0310Koza_shikibetsuCode(uaT0310Entity.getShikibetsuCode());
            entity.setUaT0310Koza_gyomubetsuPrimaryKey(uaT0310Entity.getGyomubetsuPrimaryKey());
            entity.setUaT0310Koza_gyomuKoyuKey(uaT0310Entity.getGyomuKoyuKey());
            KozaYotoKubunCodeValue yotoKubun = uaT0310Entity.getYotoKubun();
            if (yotoKubun != null) {
                entity.setUaT0310Koza_yotoKubun(yotoKubun.getColumnValue());
            }
            entity.setUaT0310Koza_torokuRenban(uaT0310Entity.getTorokuRenban());
            entity.setUaT0310Koza_kaishiYMD(uaT0310Entity.getKaishiYMD());
            entity.setUaT0310Koza_shuryoYMD(uaT0310Entity.getShuryoYMD());
            entity.setUaT0310Koza_kinyuKikanCode(uaT0310Entity.getKinyuKikanCode());
            entity.setUaT0310Koza_kinyuKikanShitenCode(uaT0310Entity.getKinyuKikanShitenCode());
            entity.setUaT0310Koza_yokinShubetsu(uaT0310Entity.getYokinShubetsu());
            entity.setUaT0310Koza_kozaNo(uaT0310Entity.getKozaNo());
            entity.setUaT0310Koza_tsuchoKigo(uaT0310Entity.getTsuchoKigo());
            entity.setUaT0310Koza_tsuchoNo(uaT0310Entity.getTsuchoNo());
            entity.setUaT0310Koza_kozaMeigininShikibetsuCode(uaT0310Entity.getKozaMeigininShikibetsuCode());
            entity.setUaT0310Koza_kozaMeiginin(uaT0310Entity.getKozaMeiginin());
            entity.setUaT0310Koza_kozaMeigininKanji(uaT0310Entity.getKozaMeigininKanji());
            entity.setUaT0310Koza_kensakuyoMeiginin(uaT0310Entity.getKensakuyoMeiginin());
            entity.setUaT0310Koza_kozaHyojiKubun(uaT0310Entity.getKozaHyojiKubun());
            entity.setUaT0310Koza_nayoseKubun(uaT0310Entity.getNayoseKubun());
            entity.setUaT0310Koza_zumitsuHakkoYohi(uaT0310Entity.getZumitsuHakkoYohi());
            entity.setUaT0310Koza_kozaFurikaeKaishiTsuchiHakkozumi(uaT0310Entity.getKozaFurikaeKaishiTsuchiHakkozumi());
            entity.setUaT0310Koza_kozaTorokuNo(uaT0310Entity.getKozaTorokuNo());
            KozaTorokuKubunCodeValue kozaTorokuKubunCode = uaT0310Entity.getKozaTorokuKubunCode();
            if (kozaTorokuKubunCode != null) {
                entity.setUaT0310Koza_kozaTorokuKubunCode(kozaTorokuKubunCode.getColumnValue());
            }
            entity.setUaT0310Koza_kozaKaishiUketsukeYMD(uaT0310Entity.getKozaKaishiUketsukeYMD());
            entity.setUaT0310Koza_kozaShuryoUketsukeYMD(uaT0310Entity.getKozaShuryoUketsukeYMD());
            entity.setUaT0310Koza_kozaTorokuYMD(uaT0310Entity.getKozaTorokuYMD());
            entity.setUaT0310Koza_temban(uaT0310Entity.getTemban());
        }
        if (賦課計算entity.get特定口座() != null
                && 賦課計算entity.get特定口座().getKinyuKikanEntity() != null) {
            UaT0301YokinShubetsuPatternEntity uaT0301Entity = 賦課計算entity.get特定口座().getYokinShubetsuPatternEntity();
            YokinShubetsuPatternCodeValue yokinShubetsuPatternCode = uaT0301Entity.getYokinShubetsuPatternCode();
            if (yokinShubetsuPatternCode != null) {
                entity.setUaT0301YokinShubetsuPattern_yokinShubetsuPatternCode(yokinShubetsuPatternCode.getColumnValue());
            }
            entity.setUaT0301YokinShubetsuPattern_yokinShubetsuCode(uaT0301Entity.getYokinShubetsuCode());
            entity.setUaT0301YokinShubetsuPattern_yokinShubetsuMeisho(uaT0301Entity.getYokinShubetsuMeisho());
            entity.setUaT0301YokinShubetsuPattern_yokinShubetsuRyakusho(uaT0301Entity.getYokinShubetsuRyakusho());
        }
        return entity;
    }

    private FukaCalculateTempEntity set徴収方法Newest(FukaCalculateEntity 賦課計算entity, FukaCalculateTempEntity entity) {
        // 徴収方法Newest全ての内容
        DbT2001ChoshuHohoEntity 徴収方法Entity = 賦課計算entity.get徴収方法の情報();
        if (徴収方法Entity != null) {
            entity.setDbT2001_fukaNendo(徴収方法Entity.getFukaNendo());
            entity.setDbT2001_hihokenshaNo(徴収方法Entity.getHihokenshaNo());
            entity.setDbT2001_rirekiNo(徴収方法Entity.getRirekiNo());
            entity.setDbT2001_choshuHoho4gatsu(徴収方法Entity.getChoshuHoho4gatsu());
            entity.setDbT2001_choshuHoho5gatsu(徴収方法Entity.getChoshuHoho5gatsu());
            entity.setDbT2001_choshuHoho6gatsu(徴収方法Entity.getChoshuHoho6gatsu());
            entity.setDbT2001_choshuHoho7gatsu(徴収方法Entity.getChoshuHoho7gatsu());
            entity.setDbT2001_choshuHoho8gatsu(徴収方法Entity.getChoshuHoho8gatsu());
            entity.setDbT2001_choshuHoho9gatsu(徴収方法Entity.getChoshuHoho9gatsu());
            entity.setDbT2001_choshuHoho10gatsu(徴収方法Entity.getChoshuHoho10gatsu());
            entity.setDbT2001_choshuHoho11gatsu(徴収方法Entity.getChoshuHoho11gatsu());
            entity.setDbT2001_choshuHoho12gatsu(徴収方法Entity.getChoshuHoho12gatsu());
            entity.setDbT2001_choshuHoho1gatsu(徴収方法Entity.getChoshuHoho1gatsu());
            entity.setDbT2001_choshuHoho2gatsu(徴収方法Entity.getChoshuHoho2gatsu());
            entity.setDbT2001_choshuHoho3gatsu(徴収方法Entity.getChoshuHoho3gatsu());
            entity.setDbT2001_choshuHohoYoku4gatsu(徴収方法Entity.getChoshuHohoYoku4gatsu());
            entity.setDbT2001_choshuHohoYoku5gatsu(徴収方法Entity.getChoshuHohoYoku5gatsu());
            entity.setDbT2001_choshuHohoYoku6gatsu(徴収方法Entity.getChoshuHohoYoku6gatsu());
            entity.setDbT2001_choshuHohoYoku7gatsu(徴収方法Entity.getChoshuHohoYoku7gatsu());
            entity.setDbT2001_choshuHohoYoku8gatsu(徴収方法Entity.getChoshuHohoYoku8gatsu());
            entity.setDbT2001_choshuHohoYoku9gatsu(徴収方法Entity.getChoshuHohoYoku9gatsu());
            entity.setDbT2001_kariNenkinNo(徴収方法Entity.getKariNenkinNo());
            entity.setDbT2001_kariNenkinCode(徴収方法Entity.getKariNenkinCode());
            entity.setDbT2001_kariHosokuM(徴収方法Entity.getKariHosokuM());
            entity.setDbT2001_honNenkinNo(徴収方法Entity.getHonNenkinNo());
            entity.setDbT2001_honNenkinCode(徴収方法Entity.getHonNenkinCode());
            entity.setDbT2001_honHosokuM(徴収方法Entity.getHonHosokuM());
            entity.setDbT2001_yokunendoKariNenkinNo(徴収方法Entity.getYokunendoKariNenkinNo());
            entity.setDbT2001_yokunendoKariNenkinCode(徴収方法Entity.getYokunendoKariNenkinCode());
            entity.setDbT2001_yokunendoKariHosokuM(徴収方法Entity.getYokunendoKariHosokuM());
            entity.setDbT2001_iraiSohuzumiFlag(徴収方法Entity.getIraiSohuzumiFlag());
            entity.setDbT2001_tsuikaIraiSohuzumiFlag(徴収方法Entity.getTsuikaIraiSohuzumiFlag());
            entity.setDbT2001_tokuchoTeishiNichiji(徴収方法Entity.getTokuchoTeishiNichiji());
            entity.setDbT2001_tokuchoTeishiJiyuCode(徴収方法Entity.getTokuchoTeishiJiyuCode());
        }
        return entity;
    }

    private FukaCalculateTempEntity set月別Temp(FukaCalculateEntity 賦課計算entity, FukaCalculateTempEntity entity) {
        // 月別Temp全ての内容
        KuBunnGaTsurakuTempEntity 月別Entity = 賦課計算entity.get月別ランク();
        if (月別Entity != null) {
            entity.setKuBunn_hihokenshaNo(月別Entity.getHihokenshaNo());
            entity.setKuBunn_rankKubun4Gatsu(月別Entity.getRankKubun4Gatsu());
            entity.setKuBunn_rankKubun5Gatsu(月別Entity.getRankKubun5Gatsu());
            entity.setKuBunn_rankKubun6Gatsu(月別Entity.getRankKubun6Gatsu());
            entity.setKuBunn_rankKubun7Gatsu(月別Entity.getRankKubun7Gatsu());
            entity.setKuBunn_rankKubun8Gatsu(月別Entity.getRankKubun8Gatsu());
            entity.setKuBunn_rankKubun9Gatsu(月別Entity.getRankKubun9Gatsu());
            entity.setKuBunn_rankKubun10Gatsu(月別Entity.getRankKubun10Gatsu());
            entity.setKuBunn_rankKubun11Gatsu(月別Entity.getRankKubun11Gatsu());
            entity.setKuBunn_rankKubun12Gatsu(月別Entity.getRankKubun12Gatsu());
            entity.setKuBunn_rankKubun1Gatsu(月別Entity.getRankKubun1Gatsu());
            entity.setKuBunn_rankKubun2Gatsu(月別Entity.getRankKubun2Gatsu());
            entity.setKuBunn_rankKubun3Gatsu(月別Entity.getRankKubun3Gatsu());
            entity.setKuBunn_shichosonCode4Gatsu(月別Entity.getShichosonCode4Gatsu());
            entity.setKuBunn_shichosonCode5Gatsu(月別Entity.getShichosonCode5Gatsu());
            entity.setKuBunn_shichosonCode6Gatsu(月別Entity.getShichosonCode6Gatsu());
            entity.setKuBunn_shichosonCode7Gatsu(月別Entity.getShichosonCode7Gatsu());
            entity.setKuBunn_shichosonCode8Gatsu(月別Entity.getShichosonCode8Gatsu());
            entity.setKuBunn_shichosonCode9Gatsu(月別Entity.getShichosonCode9Gatsu());
            entity.setKuBunn_shichosonCode10Gatsu(月別Entity.getShichosonCode10Gatsu());
            entity.setKuBunn_shichosonCode11Gatsu(月別Entity.getShichosonCode11Gatsu());
            entity.setKuBunn_shichosonCode12Gatsu(月別Entity.getShichosonCode12Gatsu());
            entity.setKuBunn_shichosonCode1Gatsu(月別Entity.getShichosonCode1Gatsu());
            entity.setKuBunn_shichosonCode2Gatsu(月別Entity.getShichosonCode2Gatsu());
            entity.setKuBunn_shichosonCode3Gatsu(月別Entity.getShichosonCode3Gatsu());
        }
        return entity;
    }

    private FukaCalculateTempEntity set本算定抽出Temp(FukaCalculateEntity 賦課計算entity, FukaCalculateTempEntity entity) {
        // 本算定抽出Temp全ての内容
        DbT1001HihokenshaDaichoEntity 資格Entity = 賦課計算entity.get資格の情報();
        if (資格Entity != null) {
            entity.setHonSanJon_hihokenshaNo(資格Entity.getHihokenshaNo());
            entity.setHonSanJon_idoYMD(資格Entity.getIdoYMD());
            entity.setHonSanJon_edaNo(資格Entity.getEdaNo());
            entity.setHonSanJon_idoJiyuCode(資格Entity.getIdoJiyuCode());
            entity.setHonSanJon_shichosonCode(資格Entity.getShichosonCode());
            entity.setHonSanJon_shikibetsuCode(資格Entity.getShikibetsuCode());
            entity.setHonSanJon_shikakuShutokuJiyuCode(資格Entity.getShikakuShutokuJiyuCode());
            entity.setHonSanJon_shikakuShutokuYMD(資格Entity.getShikakuShutokuYMD());
            entity.setHonSanJon_shikakuShutokuTodokedeYMD(資格Entity.getShikakuShutokuTodokedeYMD());
            entity.setHonSanJon_ichigoShikakuShutokuYMD(資格Entity.getIchigoShikakuShutokuYMD());
            entity.setHonSanJon_hihokennshaKubunCode(資格Entity.getHihokennshaKubunCode());
            entity.setHonSanJon_shikakuSoshitsuJiyuCode(資格Entity.getShikakuSoshitsuJiyuCode());
            entity.setHonSanJon_shikakuSoshitsuYMD(資格Entity.getShikakuSoshitsuYMD());
            entity.setHonSanJon_shikakuSoshitsuTodokedeYMD(資格Entity.getShikakuSoshitsuTodokedeYMD());
            entity.setHonSanJon_shikakuHenkoJiyuCode(資格Entity.getShikakuHenkoJiyuCode());
            entity.setHonSanJon_shikakuHenkoYMD(資格Entity.getShikakuHenkoYMD());
            entity.setHonSanJon_shikakuHenkoTodokedeYMD(資格Entity.getShikakuHenkoTodokedeYMD());
            entity.setHonSanJon_jushochitokureiTekiyoJiyuCode(資格Entity.getJushochitokureiTekiyoJiyuCode());
            entity.setHonSanJon_jushochitokureiTekiyoYMD(資格Entity.getJushochitokureiTekiyoYMD());
            entity.setHonSanJon_jushochitokureiTekiyoTodokedeYMD(資格Entity.getJushochitokureiTekiyoTodokedeYMD());
            entity.setHonSanJon_jushochitokureiKaijoJiyuCode(資格Entity.getJushochitokureiKaijoJiyuCode());
            entity.setHonSanJon_jushochitokureiKaijoYMD(資格Entity.getJushochitokureiKaijoYMD());
            entity.setHonSanJon_jushochitokureiKaijoTodokedeYMD(資格Entity.getJushochitokureiKaijoTodokedeYMD());
            entity.setHonSanJon_jushochiTokureiFlag(資格Entity.getJushochiTokureiFlag());
            entity.setHonSanJon_koikinaiJushochiTokureiFlag(資格Entity.getKoikinaiJushochiTokureiFlag());
            entity.setHonSanJon_koikinaiTokureiSochimotoShichosonCode(資格Entity.getKoikinaiTokureiSochimotoShichosonCode());
            entity.setHonSanJon_kyuShichosonCode(資格Entity.getKyuShichosonCode());
            entity.setHonSanJon_logicalDeletedFlag(資格Entity.getLogicalDeletedFlag());
            entity.setHonSanJon_choteiNendo(賦課計算entity.getChoteiNendo());
            entity.setHonSanJon_fukaNendo(賦課計算entity.getFukaNendo());
            entity.setHonSanJon_tsuchishoNo(賦課計算entity.getTsuchishoNo());
            entity.setHonSanJon_kijunYMD(賦課計算entity.getKijunYMD());
        }
        return entity;
    }
}
