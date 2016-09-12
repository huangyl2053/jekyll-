/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinsakaikekkadatatorikomi;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5510IchiGojiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomi.TmpNijiHanteikekkaTourokuyoDataItijiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomi.TmpNinteiShinsakaiWariateIinJohoItijiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5503ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 介護認定審査会審査結果データ取込み（モバイル）ProcessnoのEditクラスです。
 *
 * @reamsid_L DBE-1841-020 xuyongchao
 */
public class DataTorikomiEdit {

    /**
     * DbT5503ShinsakaiWariateIinJohoEntityのinsertメッソドです。
     *
     * @param entity TmpNinteiShinsakaiWariateIinJohoItijiEntity
     * @return DbT5503ShinsakaiWariateIinJohoEntity
     */
    public DbT5503ShinsakaiWariateIinJohoEntity insertDbT5503Entity(TmpNinteiShinsakaiWariateIinJohoItijiEntity entity) {
        DbT5503ShinsakaiWariateIinJohoEntity dbt5503Entity = new DbT5503ShinsakaiWariateIinJohoEntity();
        return editDbT5503Entity(entity, dbt5503Entity);
    }

    /**
     * DbT5503ShinsakaiWariateIinJohoEntityのupdateメッソドです。
     *
     * @param entity TmpNinteiShinsakaiWariateIinJohoItijiEntity
     * @param dbt5503Entity DbT5503ShinsakaiWariateIinJohoEntity
     * @return DbT5503ShinsakaiWariateIinJohoEntity
     */
    public DbT5503ShinsakaiWariateIinJohoEntity updateDbT5503Entity(TmpNinteiShinsakaiWariateIinJohoItijiEntity entity,
            DbT5503ShinsakaiWariateIinJohoEntity dbt5503Entity) {
        return editDbT5503Entity(entity, dbt5503Entity);
    }

    private DbT5503ShinsakaiWariateIinJohoEntity editDbT5503Entity(TmpNinteiShinsakaiWariateIinJohoItijiEntity entity,
            DbT5503ShinsakaiWariateIinJohoEntity dbt5503Entity) {
        dbt5503Entity.setShinsakaiKaisaiNo(entity.getShinsakaiKaisaiNo());
        dbt5503Entity.setShinsakaiIinCode(entity.getShinsakaiIinCode());
        dbt5503Entity.setShinsakaiKaisaiYMD(entity.getShinsakaiKaisaiYMD());
        dbt5503Entity.setKaigoninteiShinsakaiGichoKubunCode(entity.getKaigoninteiShinsakaiGichoKubunCode());
        dbt5503Entity.setShussekiFlag(entity.isShussekiFlag());
        dbt5503Entity.setExistChikokuFlag(entity.isExistChikokuFlag());
        dbt5503Entity.setShussekiTime(entity.getShussekiTime());
        dbt5503Entity.setExistSotaiFlag(entity.isExistSotaiFlag());
        dbt5503Entity.setTaisekiTime(entity.getTaisekiTime());
        return dbt5503Entity;
    }

    /**
     * DbT5503ShinsakaiWariateIinJohoEntityのinsertメッソドです。
     *
     * @param entity TmpNinteiShinsakaiWariateIinJohoItijiEntity
     * @return DbT5503ShinsakaiWariateIinJohoEntity
     */
    public DbT5510IchiGojiHanteiKekkaJohoEntity insertDbT5510Entity(TmpNijiHanteikekkaTourokuyoDataItijiEntity entity) {
        DbT5510IchiGojiHanteiKekkaJohoEntity dbt5510Entity = new DbT5510IchiGojiHanteiKekkaJohoEntity();
        return editDbT5510Entity(entity, dbt5510Entity);
    }

    /**
     * DbT5503ShinsakaiWariateIinJohoEntityのupdateメッソドです。
     *
     * @param entity TmpNinteiShinsakaiWariateIinJohoItijiEntity
     * @param dbt5510Entity DbT5510IchiGojiHanteiKekkaJohoEntity
     * @return DbT5503ShinsakaiWariateIinJohoEntity
     */
    public DbT5510IchiGojiHanteiKekkaJohoEntity updateDbT5510Entity(TmpNijiHanteikekkaTourokuyoDataItijiEntity entity,
            DbT5510IchiGojiHanteiKekkaJohoEntity dbt5510Entity) {
        return editDbT5510Entity(entity, dbt5510Entity);
    }

    private DbT5510IchiGojiHanteiKekkaJohoEntity editDbT5510Entity(TmpNijiHanteikekkaTourokuyoDataItijiEntity entity,
            DbT5510IchiGojiHanteiKekkaJohoEntity dbt5510Entity) {
        dbt5510Entity.setShinseishoKanriNo(entity.getShinseishoKanriNo());
        dbt5510Entity.setIchiGojiHanteiYMD(entity.getIchiGojiHanteiYMD());
        dbt5510Entity.setIchiGojiHanteiKekkaCode(entity.getIchiGojiHanteiKekkaCode());
        dbt5510Entity.setIchiGojiHanteiKekkaNinchishoKasanCode(entity.getIchiGojiHanteiKekkaNinchishoKasanCode());
        dbt5510Entity.setKijunJikan(entity.getKijunJikan());
        dbt5510Entity.setKijunJikanShokuji(entity.getKijunJikanShokuji());
        dbt5510Entity.setKijunJikanHaisetsu(entity.getKijunJikanHaisetsu());
        dbt5510Entity.setKijunJikanIdo(entity.getKijunJikanIdo());
        dbt5510Entity.setKijunJikanSeiketsuHoji(entity.getKijunJikanSeiketsuHoji());
        dbt5510Entity.setKijunJikanKansetsuCare(entity.getKijunJikanKansetsuCare());
        dbt5510Entity.setKijunJikanBPSDKanren(entity.getKijunJikanBPSDKanren());
        dbt5510Entity.setKijunJikanKinoKunren(entity.getKijunJikanKinoKunren());
        dbt5510Entity.setKijunJikanIryoKanren(entity.getKijunJikanIryoKanren());
        dbt5510Entity.setKijunJikanNinchishoKasan(entity.getKijunJikanNinchishoKasan());
        dbt5510Entity.setChukanHyokaKomoku1gun(entity.getChukanHyokaKomoku1gun());
        dbt5510Entity.setChukanHyokaKomoku2gun(entity.getChukanHyokaKomoku2gun());
        dbt5510Entity.setChukanHyokaKomoku3gun(entity.getChukanHyokaKomoku3gun());
        dbt5510Entity.setChukanHyokaKomoku4gun(entity.getChukanHyokaKomoku4gun());
        dbt5510Entity.setChukanHyokaKomoku5gun(entity.getChukanHyokaKomoku5gun());
        dbt5510Entity.setIchiGojiHnateiKeikokuCode(entity.getIchiGojiHnateiKeikokuCode());
        dbt5510Entity.setJotaiAnteiseiCode(entity.getJotaiAnteiseiCode());
        dbt5510Entity.setNinchishoJiritsudoIIijoNoGaizensei(entity.getNinchishoJiritsudoIIijoNoGaizensei());
        dbt5510Entity.setSuiteiKyufuKubunCode(entity.getSuiteiKyufuKubunCode());
        return dbt5510Entity;
    }

    /**
     * DbT5105NinteiKanryoJohoEntityのinsertメッソドです。
     *
     * @param entity TmpNinteiShinsakaiWariateIinJohoItijiEntity
     * @param 審査会資料作成年月日 審査会資料作成年月日
     * @return DbT5102NinteiKekkaJohoEntity
     */
    public DbT5102NinteiKekkaJohoEntity insertDbT5102Entity(TmpNijiHanteikekkaTourokuyoDataItijiEntity entity, FlexibleDate 審査会資料作成年月日) {
        DbT5102NinteiKekkaJohoEntity dbt5102Entity = new DbT5102NinteiKekkaJohoEntity();
        return editDbT5102Entity(entity, dbt5102Entity, 審査会資料作成年月日);
    }

    /**
     * DbT5105NinteiKanryoJohoEntityの設定メッソドです。
     *
     * @param entity TmpNinteiShinsakaiWariateIinJohoItijiEntity
     * @param dbt5102Entity DbT5102NinteiKekkaJohoEntity
     * @param 審査会資料作成年月日 審査会資料作成年月日
     * @return DbT5102NinteiKekkaJohoEntity
     */
    public DbT5102NinteiKekkaJohoEntity updateDbT5102Entity(TmpNijiHanteikekkaTourokuyoDataItijiEntity entity,
            DbT5102NinteiKekkaJohoEntity dbt5102Entity, FlexibleDate 審査会資料作成年月日) {
        return editDbT5102Entity(entity, dbt5102Entity, 審査会資料作成年月日);
    }

    private DbT5102NinteiKekkaJohoEntity editDbT5102Entity(TmpNijiHanteikekkaTourokuyoDataItijiEntity entity,
            DbT5102NinteiKekkaJohoEntity dbt5102Entity, FlexibleDate 審査会資料作成年月日) {
        dbt5102Entity.setShinseishoKanriNo(entity.getShinseishoKanriNo());
        dbt5102Entity.setNijiHanteiYMD(entity.getNijiHanteiYMD());
        dbt5102Entity.setNijiHanteiYokaigoJotaiKubunCode(entity.getNijiHanteiYokaigoJotaiKubunCode());
        dbt5102Entity.setNijiHanteiNinteiYukoKikan(entity.getNijiHanteiNinteiYukoKikan());
        dbt5102Entity.setNijiHanteiNinteiYukoKaishiYMD(entity.getNijiHanteiNinteiYukoKaishiYMD());
        dbt5102Entity.setNijiHanteiNinteiYukoShuryoYMD(entity.getNijiHanteiNinteiYukoShuryoYMD());
        dbt5102Entity.setShinsakaiShiryoSakuseiYMD(審査会資料作成年月日);
        dbt5102Entity.setShinsakaiKaisaiNo(entity.getShinsakaiKaisaiNo());
        dbt5102Entity.setShinsakaiIken(entity.getShinsakaiIken());
        dbt5102Entity.setIchijiHanteiKekkaHenkoRiyu(entity.getIchijiHanteiKekkaHenkoRiyu());
        dbt5102Entity.setYokaigoJotaizoReiCode(entity.getYokaigoJotaizoReiCode());
        dbt5102Entity.setShinsakaiMemo(entity.getShinsakaiMemo());
        dbt5102Entity.setNinteishinsakaiIkenShurui(entity.getNinteishinsakaiIkenShurui());
        dbt5102Entity.setNijiHanteiKekkaInputHoho(entity.getNijiHanteiKekkaInputHoho());
        dbt5102Entity.setNijiHanteiKekkaInputYMD(entity.getNijiHanteiKekkaInputYMD());
        return dbt5102Entity;
    }

}
