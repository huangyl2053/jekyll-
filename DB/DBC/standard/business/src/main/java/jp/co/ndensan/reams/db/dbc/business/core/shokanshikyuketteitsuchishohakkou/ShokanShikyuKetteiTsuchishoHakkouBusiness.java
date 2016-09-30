/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanshikyuketteitsuchishohakkou;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteitsuchishohakkou.ShokanShikyuKetteiTsuchishoHakkouEntity;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;

/**
 * 償還払い支給（不支給）決定通知書の情報インターフェースです。
 *
 * @reamsid_L DBC-5310-010 liuyl
 */
public class ShokanShikyuKetteiTsuchishoHakkouBusiness implements Serializable {

    private final ShokanShikyuKetteiTsuchishoHakkouEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity ShokanShikyuKetteiTsuchishoHakkouEntity
     */
    public ShokanShikyuKetteiTsuchishoHakkouBusiness(ShokanShikyuKetteiTsuchishoHakkouEntity entity) {
        this.entity = entity;
    }

    /**
     * 償還払支給判定結果を取得します。
     *
     * @return ShokanHanteiKekka
     */
    public ShokanHanteiKekka get償還払支給判定結果() {
        return new ShokanHanteiKekka(entity.getDbT3036Entity());
    }

    /**
     * 償還払支給申請を取得します。
     *
     * @return ShokanShinsei
     */
    public ShokanShinsei get償還払支給申請() {
        return new ShokanShinsei(entity.getDbT3034Entity());
    }
}
