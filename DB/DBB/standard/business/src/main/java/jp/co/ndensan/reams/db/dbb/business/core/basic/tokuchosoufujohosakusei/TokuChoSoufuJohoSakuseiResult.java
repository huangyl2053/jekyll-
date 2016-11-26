/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchosoufujohosakusei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.kibetsu.KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakusei.DbT2003FukaJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakusei.TokuChoSoufuJohoSakuseiEntity;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.ue.uex.business.core.NenkinTokuchoKaifuJoho;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 特徴送付情報作成のクラスです。
 *
 * @reamsid_L DBB-1830-040 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TokuChoSoufuJohoSakuseiResult {

    private NenkinTokuchoKaifuJoho 対象者の情報;
    private ChoshuHoho 徴収方法の情報;
    private HihokenshaDaicho 資格の情報;
    private FukaJoho 賦課の情報;

    private TokuChoSoufuJohoSakuseiResult() {
    }

    private TokuChoSoufuJohoSakuseiResult(List<TokuChoSoufuJohoSakuseiEntity> resultentities) {
        if (resultentities == null || resultentities.isEmpty()) {
            return;
        }
        TokuChoSoufuJohoSakuseiEntity resultEntity = resultentities.get(0);
        if (resultEntity == null) {
            return;
        }
        if (resultEntity.getUet0511entity() != null) {
            this.対象者の情報 = new NenkinTokuchoKaifuJoho(resultEntity.getUet0511entity());
        }
        if (resultEntity.getDbt2001entity() != null) {
            this.徴収方法の情報 = new ChoshuHoho(resultEntity.getDbt2001entity());
        }
        if (resultEntity.getDbt1001entity() != null) {
            this.資格の情報 = new HihokenshaDaicho(resultEntity.getDbt1001entity());
        }
        List<KibetsuEntity> 介護期別RelateEntity = new ArrayList();
        for (TokuChoSoufuJohoSakuseiEntity resultentitiy : resultentities) {
            DbT2003FukaJohoEntity dbt2003entitiy = resultentitiy.getDbt2003entities();
            if (dbt2003entitiy == null) {
                continue;
            }
            DbT2003KibetsuEntity 介護期別entity = new DbT2003KibetsuEntity();
            介護期別entity.setKi(dbt2003entitiy.getKi());
            介護期別entity.setChoshuHouhou(dbt2003entitiy.getChoshuHouhou());
            介護期別entity.setChoteiId(new Decimal(dbt2003entitiy.getChoteiId()));
            UrT0705ChoteiKyotsuEntity 調定共通_介護継承entity = new UrT0705ChoteiKyotsuEntity();
            調定共通_介護継承entity.setChoteigaku(dbt2003entitiy.getChoteigaku());
            調定共通_介護継承entity.setChoteiId(dbt2003entitiy.getChoteiId());
            List<UrT0705ChoteiKyotsuEntity> 調定共通entitylist = new ArrayList();
            調定共通entitylist.add(調定共通_介護継承entity);
            KibetsuEntity kibetsuentity = new KibetsuEntity();
            kibetsuentity.set介護期別Entity(介護期別entity);
            kibetsuentity.set調定共通Entity(調定共通entitylist);
            介護期別RelateEntity.add(kibetsuentity);
        }
        if (resultEntity.getDbt2002entity() != null && !介護期別RelateEntity.isEmpty()) {
            FukaJohoRelateEntity fukajohorelateentity = new FukaJohoRelateEntity();
            fukajohorelateentity.set介護賦課Entity(resultEntity.getDbt2002entity());
            fukajohorelateentity.set介護期別RelateEntity(介護期別RelateEntity);
            this.賦課の情報 = new FukaJoho(fukajohorelateentity);
        }
    }

    /**
     * TokuChoSoufuJohoSakuseiResultを作成します。
     *
     * @param resultentities TokuChoSoufuJohoSakuseiEntity
     * @return TokuChoSoufuJohoSakuseiResult
     */
    public static TokuChoSoufuJohoSakuseiResult getTokuChoSoufuJohoSakuseiResult(List<TokuChoSoufuJohoSakuseiEntity> resultentities) {
        return new TokuChoSoufuJohoSakuseiResult(resultentities);
    }
}
