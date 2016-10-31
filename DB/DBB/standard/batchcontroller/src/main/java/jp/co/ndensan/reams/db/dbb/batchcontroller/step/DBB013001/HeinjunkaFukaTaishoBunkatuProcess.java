/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001;

import jp.co.ndensan.reams.db.dbb.definition.core.choteijiyu.ChoteiJiyuCode;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.HeijunkaTaishogaiRiyu;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka6gatsu.FukaJohoTmpEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka6gatsu.TaishoshaTmpEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 平準化前賦課Temp一時テーブルに登録クラスです。
 *
 * @reamsid_L DBB-0860-030 yebangqiang
 */
public class HeinjunkaFukaTaishoBunkatuProcess extends BatchProcessBase<FukaJohoTmpEntity> {

    private static final RString 対象外データTEMP_TABLE_NAME = new RString("TmpTaishogai");
    private static final RString 対象者データTEMP_TABLE_NAME = new RString("TmpTaishosha");
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
            + ".tokuchoheinjunka8gatsu.ITokuchoHeinjunka8GatsuBatchMapper.getTmpHeijunkaMae");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 対象外データ一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 対象者データ一時tableWriter;

    @Override
    protected void beforeExecute() {

    }

    @Override
    protected void createWriter() {
        対象外データ一時tableWriter = new BatchEntityCreatedTempTableWriter(対象外データTEMP_TABLE_NAME,
                TaishoshaTmpEntity.class, true);
        対象者データ一時tableWriter = new BatchEntityCreatedTempTableWriter(対象者データTEMP_TABLE_NAME,
                TaishoshaTmpEntity.class, true);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void process(FukaJohoTmpEntity fukaTmpEntity) {
        RString 備考コード = RString.EMPTY;
        final RString 調定事由 = ChoteiJiyuCode.仮徴収額の変更.getコード();
        if (調定事由.equals(fukaTmpEntity.getChoteiJiyu1()) || 調定事由.equals(fukaTmpEntity.getChoteiJiyu2())
                || 調定事由.equals(fukaTmpEntity.getChoteiJiyu3()) || 調定事由.equals(fukaTmpEntity.getChoteiJiyu4())) {
            備考コード = HeijunkaTaishogaiRiyu.仮徴収額修正者.getコード();
        }

        TaishoshaTmpEntity 対象データTempEntity = new TaishoshaTmpEntity();
        対象データTempEntity.set備考コード(備考コード);
        類型転換(対象データTempEntity, fukaTmpEntity);
        if (!備考コード.isEmpty()) {
            対象外データ一時tableWriter.insert(対象データTempEntity);
        } else {
            対象者データ一時tableWriter.insert(対象データTempEntity);
        }
    }

    private void 類型転換(TaishoshaTmpEntity 対象データTempEntity, FukaJohoTmpEntity fukaTmpEntity) {

        対象データTempEntity.setChoteiNendo(fukaTmpEntity.getChoteiNendo());
        対象データTempEntity.setFukaNendo(fukaTmpEntity.getFukaNendo());
        対象データTempEntity.setTsuchishoNo(fukaTmpEntity.getTsuchishoNo());
        対象データTempEntity.setRirekiNo(fukaTmpEntity.getRirekiNo());
        対象データTempEntity.setHihokenshaNo(fukaTmpEntity.getHihokenshaNo());
        対象データTempEntity.setShikibetsuCode(fukaTmpEntity.getShikibetsuCode());
        対象データTempEntity.setSetaiCode(fukaTmpEntity.getSetaiCode());
        対象データTempEntity.setSetaiInsu(fukaTmpEntity.getSetaiInsu());
        対象データTempEntity.setShikakuShutokuYMD(fukaTmpEntity.getShikakuShutokuYMD());
        対象データTempEntity.setShikakuShutokuJiyu(fukaTmpEntity.getShikakuShutokuJiyu());
        対象データTempEntity.setShikakuSoshitsuYMD(fukaTmpEntity.getShikakuSoshitsuYMD());
        対象データTempEntity.setShikakuSoshitsuJiyu(fukaTmpEntity.getShikakuSoshitsuJiyu());
        対象データTempEntity.setSeihofujoShurui(fukaTmpEntity.getSeihofujoShurui());
        対象データTempEntity.setSeihoKaishiYMD(fukaTmpEntity.getSeihoKaishiYMD());
        対象データTempEntity.setSeihoHaishiYMD(fukaTmpEntity.getSeihoHaishiYMD());
        対象データTempEntity.setRonenKaishiYMD(fukaTmpEntity.getRonenKaishiYMD());
        対象データTempEntity.setRonenHaishiYMD(fukaTmpEntity.getRonenHaishiYMD());
        対象データTempEntity.setFukaYMD(fukaTmpEntity.getFukaYMD());
        対象データTempEntity.setKazeiKubun(fukaTmpEntity.getKazeiKubun());
        対象データTempEntity.setSetaikazeiKubun(fukaTmpEntity.getSetaikazeiKubun());
        対象データTempEntity.setGokeiShotokuGaku(fukaTmpEntity.getGokeiShotokuGaku());
        対象データTempEntity.setNenkinShunyuGaku(fukaTmpEntity.getNenkinShunyuGaku());
        対象データTempEntity.setHokenryoDankai(fukaTmpEntity.getHokenryoDankai());
        対象データTempEntity.setHokenryoDankai1(fukaTmpEntity.getHokenryoDankai1());
        対象データTempEntity.setNengakuHokenryo1(fukaTmpEntity.getNengakuHokenryo1());
        対象データTempEntity.setTsukiwariStartYM1(fukaTmpEntity.getTsukiwariStartYM1());
        対象データTempEntity.setTsukiwariEndYM1(fukaTmpEntity.getTsukiwariEndYM1());
        対象データTempEntity.setHokenryoDankai2(fukaTmpEntity.getHokenryoDankai2());
        対象データTempEntity.setNengakuHokenryo2(fukaTmpEntity.getNengakuHokenryo2());
        対象データTempEntity.setTsukiwariStartYM2(fukaTmpEntity.getTsukiwariStartYM2());
        対象データTempEntity.setTsukiwariEndYM2(fukaTmpEntity.getTsukiwariEndYM2());
        対象データTempEntity.setChoteiNichiji(fukaTmpEntity.getChoteiNichiji());
        対象データTempEntity.setChoteiJiyu1(fukaTmpEntity.getChoteiJiyu1());
        対象データTempEntity.setChoteiJiyu2(fukaTmpEntity.getChoteiJiyu2());
        対象データTempEntity.setChoteiJiyu3(fukaTmpEntity.getChoteiJiyu3());
        対象データTempEntity.setChoteiJiyu4(fukaTmpEntity.getChoteiJiyu4());
        対象データTempEntity.setKoseiM(fukaTmpEntity.getKoseiM());
        対象データTempEntity.setGemmenMaeHokenryo(fukaTmpEntity.getGemmenMaeHokenryo());
        対象データTempEntity.setGemmenGaku(fukaTmpEntity.getGemmenGaku());
        対象データTempEntity.setKakuteiHokenryo(fukaTmpEntity.getKakuteiHokenryo());
        対象データTempEntity.setHokenryoDankaiKarisanntei(fukaTmpEntity.getHokenryoDankaiKarisanntei());
        対象データTempEntity.setChoshuHohoRirekiNo(fukaTmpEntity.getChoshuHohoRirekiNo());
        対象データTempEntity.setIdoKijunNichiji(fukaTmpEntity.getIdoKijunNichiji());
        対象データTempEntity.setKozaKubun(fukaTmpEntity.getKozaKubun());
        対象データTempEntity.setKyokaisoKubun(fukaTmpEntity.getKyokaisoKubun());
        対象データTempEntity.setShokkenKubun(fukaTmpEntity.getShokkenKubun());
        対象データTempEntity.setFukaShichosonCode(fukaTmpEntity.getFukaShichosonCode());
        対象データTempEntity.setTkSaishutsuKampuGaku(fukaTmpEntity.getTkSaishutsuKampuGaku());
        対象データTempEntity.setFuSaishutsuKampuGaku(fukaTmpEntity.getFuSaishutsuKampuGaku());

        対象データTempEntity.setChoteigaku(fukaTmpEntity.getChoteigaku());
        対象データTempEntity.setChoshuHouhou(fukaTmpEntity.getChoshuHouhou());
        対象データTempEntity.setKi(fukaTmpEntity.getKi());

        対象データTempEntity.setTokubetsuChoteigaku01(fukaTmpEntity.getTkKibetsuGaku01());
        対象データTempEntity.setTokubetsuChoteigaku02(fukaTmpEntity.getTkKibetsuGaku02());
        対象データTempEntity.setTokubetsuChoteigaku03(fukaTmpEntity.getTkKibetsuGaku03());
        対象データTempEntity.setTokubetsuChoteigaku04(fukaTmpEntity.getTkKibetsuGaku04());
        対象データTempEntity.setTokubetsuChoteigaku05(fukaTmpEntity.getTkKibetsuGaku05());
        対象データTempEntity.setTokubetsuChoteigaku06(fukaTmpEntity.getTkKibetsuGaku06());

        対象データTempEntity.setFuchoChoteigaku01(fukaTmpEntity.getFuKibetsuGaku01());
        対象データTempEntity.setFuchoChoteigaku02(fukaTmpEntity.getFuKibetsuGaku02());
        対象データTempEntity.setFuchoChoteigaku03(fukaTmpEntity.getFuKibetsuGaku03());
        対象データTempEntity.setFuchoChoteigaku04(fukaTmpEntity.getFuKibetsuGaku04());
        対象データTempEntity.setFuchoChoteigaku05(fukaTmpEntity.getFuKibetsuGaku05());
        対象データTempEntity.setFuchoChoteigaku06(fukaTmpEntity.getFuKibetsuGaku06());
        対象データTempEntity.setFuchoChoteigaku07(fukaTmpEntity.getFuKibetsuGaku07());
        対象データTempEntity.setFuchoChoteigaku08(fukaTmpEntity.getFuKibetsuGaku08());
        対象データTempEntity.setFuchoChoteigaku09(fukaTmpEntity.getFuKibetsuGaku09());
        対象データTempEntity.setFuchoChoteigaku10(fukaTmpEntity.getFuKibetsuGaku10());
        対象データTempEntity.setFuchoChoteigaku11(fukaTmpEntity.getFuKibetsuGaku11());
        対象データTempEntity.setFuchoChoteigaku12(fukaTmpEntity.getFuKibetsuGaku12());
        対象データTempEntity.setFuchoChoteigaku13(fukaTmpEntity.getFuKibetsuGaku13());
        対象データTempEntity.setFuchoChoteigaku14(fukaTmpEntity.getFuKibetsuGaku14());
    }
}
