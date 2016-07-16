/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fukajohotoroku;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.FukaJohoTorokuRelateEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;

/**
 * 賦課の情報登録ビジネスクラスです。
 *
 * @reamsid_L DBB-9040-080 duanzhanli
 */
public class FukaJohoInsertResult {

    /**
     * 介護期別テーブルのエンティティの設定メッソドです。
     *
     * @param entity FukaJohoTorokuRelateEntity
     * @return DbT2003KibetsuEntity
     */
    public DbT2003KibetsuEntity getDbT2003Entity(FukaJohoTorokuRelateEntity entity) {
        DbT2003KibetsuEntity dbt2003 = new DbT2003KibetsuEntity();
        DbT2002FukaJohoTempTableEntity 賦課情報一時Entity = entity.get賦課情報一時Entity();
        dbt2003.setChoteiNendo(賦課情報一時Entity.getChoteiNendo());
        dbt2003.setFukaNendo(賦課情報一時Entity.getFukaNendo());
        dbt2003.setTsuchishoNo(賦課情報一時Entity.getTsuchishoNo());
        dbt2003.setRirekiNo(賦課情報一時Entity.getRirekiNo());
        dbt2003.setKi(entity.get期());
        dbt2003.setChoteiId(entity.get調定ID());
        return dbt2003;
    }

    /**
     * 介護賦課テーブルのエンティティの設定メッソドです。
     *
     * @param entity DbT2002FukaJohoTempTableEntity
     * @return DbT2002FukaEntity
     */
    public DbT2002FukaEntity getDbT2002Entity(DbT2002FukaJohoTempTableEntity entity) {
        DbT2002FukaEntity dbT2002 = new DbT2002FukaEntity();
        dbT2002.setChoteiNendo(entity.getChoteiNendo());
        dbT2002.setFukaNendo(entity.getFukaNendo());
        dbT2002.setTsuchishoNo(entity.getTsuchishoNo());
        dbT2002.setRirekiNo(entity.getRirekiNo());
        dbT2002.setHihokenshaNo(entity.getHihokenshaNo());
        dbT2002.setShikibetsuCode(entity.getShikibetsuCode());
        dbT2002.setSetaiCode(entity.getSetaiCode());
        dbT2002.setSetaiInsu(entity.getSetaiInsu());
        dbT2002.setShikakuShutokuYMD(entity.getShikakuShutokuYMD());
        dbT2002.setShikakuShutokuJiyu(entity.getShikakuShutokuJiyu());
        dbT2002.setShikakuSoshitsuYMD(entity.getShikakuSoshitsuYMD());
        dbT2002.setShikakuSoshitsuJiyu(entity.getShikakuSoshitsuJiyu());
        dbT2002.setSeihofujoShurui(entity.getSeihofujoShurui());
        dbT2002.setSeihoKaishiYMD(entity.getSeihoKaishiYMD());
        dbT2002.setSeihoHaishiYMD(entity.getSeihoHaishiYMD());
        dbT2002.setRonenKaishiYMD(entity.getRonenKaishiYMD());
        dbT2002.setRonenHaishiYMD(entity.getRonenHaishiYMD());
        dbT2002.setFukaYMD(entity.getFukaYMD());
        dbT2002.setKazeiKubun(entity.getKazeiKubun());
        dbT2002.setSetaikazeiKubun(entity.getSetaikazeiKubun());
        dbT2002.setGokeiShotokuGaku(entity.getGokeiShotokuGaku());
        dbT2002.setNenkinShunyuGaku(entity.getNenkinShunyuGaku());
        dbT2002.setHokenryoDankai(entity.getHokenryoDankai());
        dbT2002.setHokenryoDankai1(entity.getHokenryoDankai1());
        dbT2002.setNengakuHokenryo1(entity.getNengakuHokenryo1());
        dbT2002.setTsukiwariStartYM1(entity.getTsukiwariStartYM1());
        dbT2002.setTsukiwariEndYM1(entity.getTsukiwariEndYM1());
        dbT2002.setHokenryoDankai2(entity.getHokenryoDankai2());
        dbT2002.setNengakuHokenryo2(entity.getNengakuHokenryo2());
        dbT2002.setTsukiwariStartYM2(entity.getTsukiwariStartYM2());
        dbT2002.setTsukiwariEndYM2(entity.getTsukiwariEndYM2());
        dbT2002.setChoteiNichiji(entity.getChoteiNichiji());
        dbT2002.setChoteiJiyu1(entity.getChoteiJiyu1());
        dbT2002.setChoteiJiyu2(entity.getChoteiJiyu2());
        dbT2002.setChoteiJiyu3(entity.getChoteiJiyu3());
        dbT2002.setChoteiJiyu4(entity.getChoteiJiyu4());
        dbT2002.setKoseiM(entity.getKoseiM());
        dbT2002.setGemmenMaeHokenryo(entity.getGemmenMaeHokenryo());
        dbT2002.setGemmenGaku(entity.getGemmenGaku());
        dbT2002.setKakuteiHokenryo(entity.getKakuteiHokenryo());
        dbT2002.setHokenryoDankaiKarisanntei(entity.getHokenryoDankaiKarisanntei());
        dbT2002.setChoshuHohoRirekiNo(entity.getChoshuHohoRirekiNo());
        dbT2002.setIdoKijunNichiji(entity.getIdoKijunNichiji());
        dbT2002.setKozaKubun(entity.getKozaKubun());
        dbT2002.setKyokaisoKubun(entity.getKyokaisoKubun());
        dbT2002.setShokkenKubun(entity.getShokkenKubun());
        dbT2002.setFukaShichosonCode(entity.getFukaShichosonCode());
        dbT2002.setTkSaishutsuKampuGaku(entity.getTkSaishutsuKampuGaku());
        dbT2002.setFuSaishutsuKampuGaku(entity.getFuSaishutsuKampuGaku());
        return dbT2002;
    }
}
