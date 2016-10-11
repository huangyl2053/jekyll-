/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014001;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokarisanteifuka.FukaJohoCalculateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.FukaJohoTempEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 賦課情報一時のクラスです。
 *
 * @reamsid_L DBB-0870-010 pengxingyi
 */
public class InsFukaJohoTmepProcess extends BatchKeyBreakBase<FukaJohoCalculateEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuchokarisanteifuka."
                    + "IFuchoKarisanteiFukaMapper.get賦課情報一時");
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
    private static final RString 徴収方法1 = new RString("1");
    private static final RString 徴収方法2 = new RString("2");
    private static final RString TABLE_NAME = new RString("FukaJohoTemp");
    private FukaJohoTempEntity 中間Entity;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tableWriter;

    @Override
    protected void initialize() {
        中間Entity = new FukaJohoTempEntity();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, FukaJohoTempEntity.class);
    }

    @Override
    protected void keyBreakProcess(FukaJohoCalculateEntity entity) {
        if (isBreak(entity, getBefore())) {
            中間Entity = set賦課計算中間(getBefore().get介護賦課Entity());
            tableWriter.insert(中間Entity);
            中間Entity = new FukaJohoTempEntity();
        }
    }

    @Override
    protected void usualProcess(FukaJohoCalculateEntity entity) {
        中間Entity = set期別金額(entity);
    }

    @Override
    protected void afterExecute() {
        if (getBefore() != null) {
            中間Entity = set賦課計算中間(getBefore().get介護賦課Entity());
            tableWriter.insert(中間Entity);
        }
    }

    private boolean isBreak(FukaJohoCalculateEntity current, FukaJohoCalculateEntity before) {
        return !current.get介護賦課Entity().getChoteiNendo().equals(before.get介護賦課Entity().getChoteiNendo())
                || !current.get介護賦課Entity().getFukaNendo().equals(before.get介護賦課Entity().getFukaNendo())
                || !current.get介護賦課Entity().getTsuchishoNo().equals(before.get介護賦課Entity().getTsuchishoNo())
                || current.get介護賦課Entity().getRirekiNo() != before.get介護賦課Entity().getRirekiNo();
    }

    private FukaJohoTempEntity set賦課計算中間(DbT2002FukaEntity 介護賦課) {
        中間Entity.setChoteiNendo(介護賦課.getChoteiNendo());
        中間Entity.setFukaNendo(介護賦課.getFukaNendo());
        中間Entity.setTsuchishoNo(介護賦課.getTsuchishoNo());
        中間Entity.setRirekiNo(介護賦課.getRirekiNo());
        中間Entity.setHihokenshaNo(介護賦課.getHihokenshaNo());
        中間Entity.setShikibetsuCode(介護賦課.getShikibetsuCode());
        中間Entity.setSetaiCode(介護賦課.getSetaiCode());
        中間Entity.setSetaiInsu(介護賦課.getSetaiInsu());
        中間Entity.setShikakuShutokuYMD(介護賦課.getShikakuShutokuYMD());
        中間Entity.setShikakuShutokuJiyu(介護賦課.getShikakuShutokuJiyu());
        中間Entity.setShikakuSoshitsuYMD(介護賦課.getShikakuSoshitsuYMD());
        中間Entity.setShikakuSoshitsuJiyu(介護賦課.getShikakuSoshitsuJiyu());
        中間Entity.setSeihofujoShurui(介護賦課.getSeihofujoShurui());
        中間Entity.setSeihoKaishiYMD(介護賦課.getSeihoKaishiYMD());
        中間Entity.setSeihoHaishiYMD(介護賦課.getSeihoHaishiYMD());
        中間Entity.setRonenKaishiYMD(介護賦課.getRonenKaishiYMD());
        中間Entity.setRonenHaishiYMD(介護賦課.getRonenHaishiYMD());
        中間Entity.setFukaYMD(介護賦課.getFukaYMD());
        中間Entity.setKazeiKubun(介護賦課.getKazeiKubun());
        中間Entity.setSetaikazeiKubun(介護賦課.getSetaikazeiKubun());
        中間Entity.setGokeiShotokuGaku(介護賦課.getGokeiShotokuGaku());
        中間Entity.setNenkinShunyuGaku(介護賦課.getNenkinShunyuGaku());
        中間Entity.setHokenryoDankai(介護賦課.getHokenryoDankai());
        中間Entity.setHokenryoDankai1(介護賦課.getHokenryoDankai1());
        中間Entity.setNengakuHokenryo1(介護賦課.getNengakuHokenryo1());
        中間Entity.setTsukiwariStartYM1(介護賦課.getTsukiwariStartYM1());
        中間Entity.setTsukiwariEndYM1(介護賦課.getTsukiwariEndYM1());
        中間Entity.setHokenryoDankai2(介護賦課.getHokenryoDankai2());
        中間Entity.setNengakuHokenryo2(介護賦課.getNengakuHokenryo2());
        中間Entity.setTsukiwariStartYM2(介護賦課.getTsukiwariStartYM2());
        中間Entity.setTsukiwariEndYM2(介護賦課.getTsukiwariEndYM2());
        中間Entity.setChoteiNichiji(介護賦課.getChoteiNichiji());
        中間Entity.setChoteiJiyu1(介護賦課.getChoteiJiyu1());
        中間Entity.setChoteiJiyu2(介護賦課.getChoteiJiyu2());
        中間Entity.setChoteiJiyu3(介護賦課.getChoteiJiyu3());
        中間Entity.setChoteiJiyu4(介護賦課.getChoteiJiyu4());
        中間Entity.setKoseiM(介護賦課.getKoseiM());
        中間Entity.setGemmenMaeHokenryo(介護賦課.getGemmenMaeHokenryo());
        中間Entity.setGemmenGaku(介護賦課.getGemmenGaku());
        中間Entity.setKakuteiHokenryo(介護賦課.getKakuteiHokenryo());
        中間Entity.setHokenryoDankaiKarisanntei(介護賦課.getHokenryoDankaiKarisanntei());
        中間Entity.setChoshuHohoRirekiNo(介護賦課.getChoshuHohoRirekiNo());
        中間Entity.setIdoKijunNichiji(介護賦課.getIdoKijunNichiji());
        中間Entity.setKozaKubun(介護賦課.getKozaKubun());
        中間Entity.setKyokaisoKubun(介護賦課.getKyokaisoKubun());
        中間Entity.setShokkenKubun(介護賦課.getShokkenKubun());
        中間Entity.setFukaShichosonCode(介護賦課.getFukaShichosonCode());
        中間Entity.setTkSaishutsuKampuGaku(介護賦課.getTkSaishutsuKampuGaku());
        中間Entity.setFuSaishutsuKampuGaku(介護賦課.getFuSaishutsuKampuGaku());
        return 中間Entity;
    }

    private FukaJohoTempEntity set期別金額(FukaJohoCalculateEntity entity) {
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

    private FukaJohoTempEntity set特徴期期別金額(Decimal shunyugaku, int ki, FukaJohoTempEntity 中間Entity) {
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

    private FukaJohoTempEntity set普徴期期別金額(Decimal shunyugaku, int ki, FukaJohoTempEntity 中間Entity) {
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

}
