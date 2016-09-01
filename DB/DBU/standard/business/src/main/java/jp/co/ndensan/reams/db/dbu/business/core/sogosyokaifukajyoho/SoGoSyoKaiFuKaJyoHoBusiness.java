/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.sogosyokaifukajyoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.sogosyokaifukajyoho.SoGoSyoKaiFuKaJyoHoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 画面設計_DBU0600041_総合照会_賦課情報Business。
 *
 * @reamsid_L DBU-4100-050 houtianpeng
 */
public class SoGoSyoKaiFuKaJyoHoBusiness implements Serializable {

    private final SoGoSyoKaiFuKaJyoHoEntity entity;

    /**
     * コンストラクタです。<br/>
     * 対象者一覧に使用します。
     *
     * @param entity JyuMiKoNyuJyoHoEntity
     */
    public SoGoSyoKaiFuKaJyoHoBusiness(SoGoSyoKaiFuKaJyoHoEntity entity) {
        this.entity = entity;
    }

    /**
     * 徴収方法を取得します。
     *
     * @return 徴収方法
     */
    public RString get介護期別_徴収方法() {
        return entity.getChoshuHouhou();
    }

    /**
     * 介護期別.期を取得します。
     *
     * @return 介護期別.期
     */
    public int get介護期別_期() {
        return entity.getKi();
    }

    /**
     * 調定IDを取得します。
     *
     * @return 調定ID
     */
    public Decimal get調定ID() {
        return entity.getChoteiId();
    }

    /**
     * 調定共通.収納IDを取得します。
     *
     * @return 調定共通.収納ID
     */
    public Long get調定共通_収納ID() {
        return entity.getShunoId();
    }

    /**
     * 調定共通.調定額を取得します。
     *
     * @return 調定共通.調定額
     */
    public Decimal get調定共通_調定額() {
        return entity.getChoteigaku();
    }
}
