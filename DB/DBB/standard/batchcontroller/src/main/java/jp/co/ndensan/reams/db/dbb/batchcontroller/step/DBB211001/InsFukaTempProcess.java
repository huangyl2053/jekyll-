/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsFukaTempProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch.FukaTempJouhouEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 最新の賦課の情報を取得します。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
public class InsFukaTempProcess extends BatchProcessBase<FukaTempJouhouEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence"
            + ".db.mapper.relate.tokuchosoufujohosakuseibatch.ITokuChoSoufuJohoSakuseiBatchMapper.get最新の賦課の情報");
    private static final RString TEMP_TABLE = new RString("賦課Temp");
    private static final int 期1 = 1;
    private static final int 期2 = 2;
    private static final int 期3 = 3;
    private static final int 期4 = 4;
    private static final int 期5 = 5;
    private static final int 期6 = 6;
    private InsFukaTempProcessParameter parameter;
    private TsuchishoNo 通知書番号;
    private DbT2002FukaJohoTempTableEntity 賦課Temp情報;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter<DbT2002FukaJohoTempTableEntity> 賦課Temp;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toSelectFukaTempJouhouMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        賦課Temp = new BatchEntityCreatedTempTableWriter(
                TEMP_TABLE, DbT2002FukaJohoTempTableEntity.class);
    }

    @Override
    protected void process(FukaTempJouhouEntity t) {

        if (!t.get賦課情報().getTsuchishoNo().equals(通知書番号)) {
            if (通知書番号 != null) {
                賦課Temp.insert(賦課Temp情報);
            }
            賦課Temp情報 = new DbT2002FukaJohoTempTableEntity();
            get処理前賦課Temp情報(賦課Temp情報, t.get賦課情報());
        }
        set特徴期期別金額(new Decimal(t.get調定額().toString()),
                Integer.parseInt(t.get期().toString()), 賦課Temp情報);
        通知書番号 = t.get賦課情報().getTsuchishoNo();

    }

    @Override
    protected void afterExecute() {
        if (通知書番号 != null) {
            賦課Temp.insert(賦課Temp情報);
        }
    }

    private void get処理前賦課Temp情報(DbT2002FukaJohoTempTableEntity 賦課Temp情報,
            DbT2002FukaEntity 介護賦課) {
        賦課Temp情報.setChoteiNendo(介護賦課.getChoteiNendo());
        賦課Temp情報.setFukaNendo(介護賦課.getFukaNendo());
        賦課Temp情報.setTsuchishoNo(介護賦課.getTsuchishoNo());
        賦課Temp情報.setRirekiNo(介護賦課.getRirekiNo());
        賦課Temp情報.setHihokenshaNo(介護賦課.getHihokenshaNo());
        賦課Temp情報.setShikibetsuCode(介護賦課.getShikibetsuCode());
        賦課Temp情報.setSetaiCode(介護賦課.getSetaiCode());
        賦課Temp情報.setSetaiInsu(介護賦課.getSetaiInsu());
        賦課Temp情報.setShikakuShutokuYMD(介護賦課.getShikakuShutokuYMD());
        賦課Temp情報.setShikakuShutokuJiyu(介護賦課.getShikakuShutokuJiyu());
        賦課Temp情報.setShikakuSoshitsuYMD(介護賦課.getShikakuSoshitsuYMD());
        賦課Temp情報.setShikakuSoshitsuJiyu(介護賦課.getShikakuSoshitsuJiyu());
        賦課Temp情報.setSeihofujoShurui(介護賦課.getSeihofujoShurui());
        賦課Temp情報.setSeihoKaishiYMD(介護賦課.getSeihoKaishiYMD());
        賦課Temp情報.setSeihoHaishiYMD(介護賦課.getSeihoHaishiYMD());
        賦課Temp情報.setRonenKaishiYMD(介護賦課.getRonenKaishiYMD());
        賦課Temp情報.setRonenHaishiYMD(介護賦課.getRonenHaishiYMD());
        賦課Temp情報.setFukaYMD(介護賦課.getFukaYMD());
        賦課Temp情報.setKazeiKubun(介護賦課.getKazeiKubun());
        賦課Temp情報.setSetaikazeiKubun(介護賦課.getSetaikazeiKubun());
        賦課Temp情報.setGokeiShotokuGaku(介護賦課.getGokeiShotokuGaku());
        賦課Temp情報.setNenkinShunyuGaku(介護賦課.getNenkinShunyuGaku());
        賦課Temp情報.setHokenryoDankai(介護賦課.getHokenryoDankai());
        賦課Temp情報.setHokenryoDankai1(介護賦課.getHokenryoDankai1());
        賦課Temp情報.setNengakuHokenryo1(介護賦課.getNengakuHokenryo1());
        賦課Temp情報.setTsukiwariStartYM1(介護賦課.getTsukiwariStartYM1());
        賦課Temp情報.setTsukiwariEndYM1(介護賦課.getTsukiwariEndYM1());
        賦課Temp情報.setHokenryoDankai2(介護賦課.getHokenryoDankai2());
        賦課Temp情報.setNengakuHokenryo2(介護賦課.getNengakuHokenryo2());
        賦課Temp情報.setTsukiwariStartYM2(介護賦課.getTsukiwariStartYM2());
        賦課Temp情報.setTsukiwariEndYM2(介護賦課.getTsukiwariEndYM2());
        賦課Temp情報.setChoteiNichiji(介護賦課.getChoteiNichiji());
        賦課Temp情報.setChoteiJiyu1(介護賦課.getChoteiJiyu1());
        賦課Temp情報.setChoteiJiyu2(介護賦課.getChoteiJiyu2());
        賦課Temp情報.setChoteiJiyu3(介護賦課.getChoteiJiyu3());
        賦課Temp情報.setChoteiJiyu4(介護賦課.getChoteiJiyu4());
        賦課Temp情報.setKoseiM(介護賦課.getKoseiM());
        賦課Temp情報.setGemmenMaeHokenryo(介護賦課.getGemmenMaeHokenryo());
        賦課Temp情報.setGemmenGaku(介護賦課.getGemmenGaku());
        賦課Temp情報.setKakuteiHokenryo(介護賦課.getKakuteiHokenryo());
        賦課Temp情報.setHokenryoDankaiKarisanntei(介護賦課.getHokenryoDankaiKarisanntei());
        賦課Temp情報.setChoshuHohoRirekiNo(介護賦課.getChoshuHohoRirekiNo());
        賦課Temp情報.setIdoKijunNichiji(介護賦課.getIdoKijunNichiji());
        賦課Temp情報.setKozaKubun(介護賦課.getKozaKubun());
        賦課Temp情報.setKyokaisoKubun(介護賦課.getKyokaisoKubun());
        賦課Temp情報.setShokkenKubun(介護賦課.getShokkenKubun());
        賦課Temp情報.setFukaShichosonCode(介護賦課.getFukaShichosonCode());
        賦課Temp情報.setTkSaishutsuKampuGaku(介護賦課.getTkSaishutsuKampuGaku());
        賦課Temp情報.setFuSaishutsuKampuGaku(介護賦課.getFuSaishutsuKampuGaku());
    }

    private void set特徴期期別金額(Decimal choteigaku, int ki, DbT2002FukaJohoTempTableEntity 処理前賦課Temp情報) {
        switch (ki) {
            case 期1:
                処理前賦課Temp情報.setTkKibetsuGaku01(choteigaku);
                break;
            case 期2:
                処理前賦課Temp情報.setTkKibetsuGaku02(choteigaku);
                break;
            case 期3:
                処理前賦課Temp情報.setTkKibetsuGaku03(choteigaku);
                break;
            case 期4:
                処理前賦課Temp情報.setTkKibetsuGaku04(choteigaku);
                break;
            case 期5:
                処理前賦課Temp情報.setTkKibetsuGaku05(choteigaku);
                break;
            case 期6:
                処理前賦課Temp情報.setTkKibetsuGaku06(choteigaku);
                break;
            default:
                break;
        }
    }
}
