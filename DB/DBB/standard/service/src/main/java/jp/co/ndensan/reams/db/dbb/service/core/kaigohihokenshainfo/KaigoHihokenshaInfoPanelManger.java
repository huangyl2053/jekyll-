/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.kaigohihokenshainfo;

import jp.co.ndensan.reams.db.dbb.business.core.basic.RentaiGimusha;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2009RentaiGimushaDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 連帯納付義務者登録Mangerです。
 *
 * @reamsid_L DBB-1640-010 jiangzongyue
 */
public class KaigoHihokenshaInfoPanelManger {

    private final DbT2009RentaiGimushaDac rentaiGimushaDac;

    /**
     * サービス種類登録クラスのコンストラクタです。
     */
    public KaigoHihokenshaInfoPanelManger() {

        rentaiGimushaDac = InstanceProvider.create(DbT2009RentaiGimushaDac.class);

    }

    /**
     * 利サービス種類登録クラスのコンストラクタです(テスト用)。
     *
     * @param kaigoServiceDac rentaigimushaDac
     */
    KaigoHihokenshaInfoPanelManger(DbT2009RentaiGimushaDac rentaiGimushaDac) {

        this.rentaiGimushaDac = rentaiGimushaDac;

    }

    /**
     * 連帯納付義務者登録を取得します。
     *
     * @param entity DbT2009RentaiGimushaEntity
     */
    public void save(RentaiGimusha entity) {
        rentaiGimushaDac.save(entity.toEntity());
    }
}
