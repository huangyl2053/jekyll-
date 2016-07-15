/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteitsuchishohakko;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteitsuchishohakko.DbV2002FukaTempTableEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;

/**
 * 前年度賦課情報一時テーブルEntitydataクラスです。
 *
 * @reamsid_L DBB-0790-040 chenaoqi
 */
public class DbV2002FukaTempDataCreate {

    /**
     * 前年度賦課情報一時テーブルEntitydata
     *
     * @param entity DbT2002FukaEntity
     * @return DbV2002FukaTempTableEntity
     */
    public DbV2002FukaTempTableEntity toDbV2002FukaTempTableEntity(DbT2002FukaEntity entity) {
        DbV2002FukaTempTableEntity tempEntity = new DbV2002FukaTempTableEntity();
        tempEntity.setChoteiNendo(entity.getChoteiNendo());
        tempEntity.setFukaNendo(entity.getFukaNendo());
        tempEntity.setTsuchishoNo(entity.getTsuchishoNo());
        tempEntity.setRirekiNo(entity.getRirekiNo());
        tempEntity.setHihokenshaNo(entity.getHihokenshaNo());
        tempEntity.setShikibetsuCode(entity.getShikibetsuCode());
        tempEntity.setSetaiCode(entity.getSetaiCode());
        tempEntity.setSetaiInsu(entity.getSetaiInsu());
        tempEntity.setShikakuShutokuYMD(entity.getShikakuShutokuYMD());
        tempEntity.setShikakuShutokuJiyu(entity.getShikakuShutokuJiyu());
        tempEntity.setShikakuSoshitsuYMD(entity.getShikakuSoshitsuYMD());
        tempEntity.setShikakuSoshitsuJiyu(entity.getShikakuSoshitsuJiyu());
        tempEntity.setSeihofujoShurui(entity.getSeihofujoShurui());
        tempEntity.setSeihoKaishiYMD(entity.getSeihoKaishiYMD());
        tempEntity.setSeihoHaishiYMD(entity.getSeihoHaishiYMD());
        tempEntity.setRonenKaishiYMD(entity.getRonenKaishiYMD());
        tempEntity.setRonenHaishiYMD(entity.getRonenHaishiYMD());
        tempEntity.setFukaYMD(entity.getFukaYMD());
        tempEntity.setKazeiKubun(entity.getKazeiKubun());
        tempEntity.setSetaikazeiKubun(entity.getSetaikazeiKubun());
        tempEntity.setGokeiShotokuGaku(entity.getGokeiShotokuGaku());
        tempEntity.setNenkinShunyuGaku(entity.getNenkinShunyuGaku());
        tempEntity.setHokenryoDankai(entity.getHokenryoDankai());
        tempEntity.setHokenryoDankai1(entity.getHokenryoDankai1());
        tempEntity.setNengakuHokenryo1(entity.getNengakuHokenryo1());
        tempEntity.setTsukiwariStartYM1(entity.getTsukiwariStartYM1());
        tempEntity.setTsukiwariEndYM1(entity.getTsukiwariEndYM1());
        tempEntity.setHokenryoDankai2(entity.getHokenryoDankai2());
        tempEntity.setNengakuHokenryo2(entity.getNengakuHokenryo2());
        tempEntity.setTsukiwariStartYM2(entity.getTsukiwariStartYM2());
        tempEntity.setTsukiwariEndYM2(entity.getTsukiwariEndYM2());
        tempEntity.setChoteiNichiji(entity.getChoteiNichiji());
        tempEntity.setChoteiJiyu1(entity.getChoteiJiyu1());
        tempEntity.setChoteiJiyu2(entity.getChoteiJiyu2());
        tempEntity.setChoteiJiyu3(entity.getChoteiJiyu3());
        tempEntity.setChoteiJiyu4(entity.getChoteiJiyu4());
        tempEntity.setKoseiM(entity.getKoseiM());
        tempEntity.setGemmenMaeHokenryo(entity.getGemmenMaeHokenryo());
        tempEntity.setGemmenGaku(entity.getGemmenGaku());
        tempEntity.setKakuteiHokenryo(entity.getKakuteiHokenryo());
        tempEntity.setHokenryoDankaiKarisanntei(entity.getHokenryoDankaiKarisanntei());
        tempEntity.setChoshuHohoRirekiNo(entity.getChoshuHohoRirekiNo());
        tempEntity.setIdoKijunNichiji(entity.getIdoKijunNichiji());
        tempEntity.setKozaKubun(entity.getKozaKubun());
        tempEntity.setKyokaisoKubun(entity.getKyokaisoKubun());
        tempEntity.setShokkenKubun(entity.getShokkenKubun());
        tempEntity.setFukaShichosonCode(entity.getFukaShichosonCode());
        tempEntity.setTkSaishutsuKampuGaku(entity.getTkSaishutsuKampuGaku());
        tempEntity.setFuSaishutsuKampuGaku(entity.getFuSaishutsuKampuGaku());

        return tempEntity;
    }

}
