/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 業務概念RentaiGimushaのHolderクラスです。
 *
 * @reamsid_L DBB-1640-010 jiangzongyue
 */
public class RentaiGimushaHolder implements Serializable {

    private static final long serialVersionUID = -3935825012351482058L;
    private final Models<RentaiGimushaIdentifier, RentaiGimusha> rentaiGimushaList;

    /**
     * RentaiGimushaHolderのobj作成です。
     */
    public RentaiGimushaHolder() {
        this.rentaiGimushaList = Models.create(new ArrayList<RentaiGimusha>());
    }

    /**
     * RentaiGimushaHolderのobj作成です。
     *
     * @param rentaiGimushaList List<RentaiGimusha>
     */
    public RentaiGimushaHolder(List<RentaiGimusha> rentaiGimushaList) {
        this.rentaiGimushaList = Models.create(rentaiGimushaList);
    }

    /**
     * RentaiGimushaHolderのobj作成です。
     *
     * @param rentaiGimushaList Models<RentaiGimushaIdentifier, RentaiGimusha>
     */
    public RentaiGimushaHolder(Models<RentaiGimushaIdentifier, RentaiGimusha> rentaiGimushaList) {
        this.rentaiGimushaList = rentaiGimushaList;
    }

    /**
     * RentaiGimushaHolderのlistを取得します。
     *
     * @return List<RentaiGimusha>
     */
    public List<RentaiGimusha> getRentaiGimushaList() {
        return new ArrayList<>(rentaiGimushaList.values());
    }

    /**
     * SogoJigyoKubunShikyuGendoGakuのlistを設定します。
     *
     * @param rentaiGimusha RentaiGimusha
     */
    public void addKogakuGassanJikoFutanGaku(RentaiGimusha rentaiGimusha) {
        rentaiGimushaList.add(rentaiGimusha);
    }

    /**
     * KogakuGassanJikoFutanGakuを取得します。
     *
     * @param id RentaiGimushaIdentifier
     * @return RentaiGimusha
     */
    public RentaiGimusha getKogakuGassanJikoFutanGaku(RentaiGimushaIdentifier id) {
        if (rentaiGimushaList.contains(id)) {
            return rentaiGimushaList.clone().get(id);
        }
        return null;
    }
}
