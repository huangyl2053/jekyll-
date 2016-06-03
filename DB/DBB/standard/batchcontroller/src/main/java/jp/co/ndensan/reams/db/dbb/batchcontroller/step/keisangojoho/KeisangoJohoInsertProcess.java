/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.keisangojoho;

import jp.co.ndensan.reams.db.dbb.definition.processprm.keisangojoho.KeisangoJohoSakuseiProcessParamter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.DbTKeisangoJohoTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 計算中間Tempテーブルから検索したデータを計算後情報一時または計算後情報に登録し、
 * <br>計算中間Tempテーブルから削除する処理を行う処理クラスです。
 *
 * @reamsid_L DBB-9060-010 duanzhanli
 */
public class KeisangoJohoInsertProcess extends BatchProcessBase<DbTKeisangoJohoTempTableEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.keisangojoho."
            + "IKeisangoJohoSakuseiMapper.");
    private static final RString 計算中間一時更新前情報 = new RString(MAPPERPATH + "get計算中間Temp更新前情報");
    private static final RString 計算中間一時更新後情報 = new RString(MAPPERPATH + "get計算中間Temp更新後情報");
    private static final RString TABLE_計算中間_NAME = new RString("KeisanTyukanTemp");
    private static final RString TABLE_計算後情報一時_NAME = new RString("DbT2015KeisangoJohoTemp");
    private KeisangoJohoSakuseiProcessParamter processParamter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 計算中間Temp;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 計算後情報Temp;
    @BatchWriter
    BatchPermanentTableWriter<DbT2015KeisangoJohoEntity> dbT2015Writer;

    @Override
    protected IBatchReader createReader() {
        if (processParamter.is更新前フラグ()) {
            return new BatchDbReader(計算中間一時更新前情報);
        } else {
            return new BatchDbReader(計算中間一時更新後情報);
        }
    }

    @Override
    protected void createWriter() {
        計算中間Temp = new BatchEntityCreatedTempTableWriter(TABLE_計算中間_NAME,
                DbTKeisangoJohoTempTableEntity.class);
        計算後情報Temp = new BatchEntityCreatedTempTableWriter(TABLE_計算後情報一時_NAME,
                DbTKeisangoJohoTempTableEntity.class);
        dbT2015Writer = new BatchPermanentTableWriter(DbT2015KeisangoJohoEntity.class);
    }

    @Override
    protected void process(DbTKeisangoJohoTempTableEntity entity) {
        entity.setSakuseiShoriName(processParamter.getSakuseiShoriName());
        if (processParamter.isSaishinFlag2()
                || processParamter.isSaishinFlag4()
                || processParamter.isSaishinFlag5()) {
            計算後情報Temp.insert(entity);
        } else if (processParamter.isSaishinFlag3()) {

            dbT2015Writer.insert(setDbT2015Entity(entity));
        }
        計算中間Temp.delete(entity);
    }

    private DbT2015KeisangoJohoEntity setDbT2015Entity(DbTKeisangoJohoTempTableEntity entity) {
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
}
