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
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakusei.TokuChoSoufuJohoSakuseiEntity;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NenkinTokuchoKaifuJoho;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 特徴仮算定賦課確定の戻るEntity。
 *
 * @reamsid_L DBB-0800-020 wanghui
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

    private TokuChoSoufuJohoSakuseiResult(TokuChoSoufuJohoSakuseiEntity resultentity) {
        if (resultentity != null) {
            if (resultentity.getUet0511entity() != null) {
                this.対象者の情報 = new NenkinTokuchoKaifuJoho(resultentity.getUet0511entity());
            }
            if (resultentity.getDbt2001entity() != null) {
                this.徴収方法の情報 = new ChoshuHoho(resultentity.getDbt2001entity());
            }
            if (resultentity.getDbt1001entity() != null) {
                this.資格の情報 = new HihokenshaDaicho(resultentity.getDbt1001entity());
            }
            DbT2003KibetsuEntity 介護期別entity = new DbT2003KibetsuEntity();
            介護期別entity.setKi(resultentity.getKi());
            介護期別entity.setChoshuHouhou(resultentity.getChoshuHouhou());
            介護期別entity.setChoteiId(new Decimal(resultentity.getChoteiId()));
            UrT0705ChoteiKyotsuEntity 調定共通_介護継承entity = new UrT0705ChoteiKyotsuEntity();
            調定共通_介護継承entity.setChoteigaku(resultentity.getChoteigaku());
            調定共通_介護継承entity.setChoteiId(resultentity.getChoteiId());
            List 調定共通entitylist = new ArrayList();
            調定共通entitylist.add(調定共通_介護継承entity);
            KibetsuEntity kibetsuentity = new KibetsuEntity();
            kibetsuentity.set介護期別Entity(介護期別entity);
            kibetsuentity.set調定共通Entity(調定共通entitylist);
            List<KibetsuEntity> 介護期別RelateEntity = new ArrayList();
            介護期別RelateEntity.add(kibetsuentity);
            FukaJohoRelateEntity fukajohorelateentity = new FukaJohoRelateEntity();
            fukajohorelateentity.set介護賦課Entity(resultentity.getDbt2002entity());
            fukajohorelateentity.set介護期別RelateEntity(介護期別RelateEntity);
            this.賦課の情報 = new FukaJoho(fukajohorelateentity);
        }
    }

    /**
     * TokuChoSoufuJohoSakuseiResultを作成します。
     *
     * @param resultentity TokuChoSoufuJohoSakuseiEntity
     * @return TokuChoSoufuJohoSakuseiResult
     */
    public static TokuChoSoufuJohoSakuseiResult getTokuChoSoufuJohoSakuseiResult(TokuChoSoufuJohoSakuseiEntity resultentity) {
        return new TokuChoSoufuJohoSakuseiResult(resultentity);
    }

    /**
     * List<TokuChoSoufuJohoSakuseiResult>を作成します。
     *
     * @param resultentitylist List<ResultEntity>
     * @return List<TokuChoSoufuJohoSakuseiResult>
     */
    public static List<TokuChoSoufuJohoSakuseiResult> getTokuChoSoufuJohoSakuseiResultList(List<TokuChoSoufuJohoSakuseiEntity> resultentitylist) {
        List<TokuChoSoufuJohoSakuseiResult> list = new ArrayList();
        for (TokuChoSoufuJohoSakuseiEntity resultentity : resultentitylist) {
            list.add(new TokuChoSoufuJohoSakuseiResult(resultentity));
        }
        return list;
    }
}
