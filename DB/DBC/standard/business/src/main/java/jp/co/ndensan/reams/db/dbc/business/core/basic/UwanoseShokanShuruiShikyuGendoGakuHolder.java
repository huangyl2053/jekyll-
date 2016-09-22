/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;

/**
 * 業務概念UwanoseShokanShuruiShikyuGendoGakuのHolderクラスです。
 *
 * @reamsid_L DBC-3460-010 jianglaisheng
 */
public class UwanoseShokanShuruiShikyuGendoGakuHolder implements Serializable {

    private static final long serialVersionUID = -3935825012351482058L;
    private final Models<
            UwanoseShokanShuruiShikyuGendoGakuIdentifier, UwanoseShokanShuruiShikyuGendoGaku> uwanoseShokanShuruiShiList;

    /**
     * UwanoseShokanShuruiShikyuGendoGakuHolderのobj作成です。
     */
    public UwanoseShokanShuruiShikyuGendoGakuHolder() {
        this.uwanoseShokanShuruiShiList
                = Models.create(new ArrayList<UwanoseShokanShuruiShikyuGendoGaku>());
    }

    /**
     * UwanoseShokanShuruiShikyuGendoGakuHolderのobj作成です。
     *
     * @param uwanoseShokanShuruiShiList
     * List<UwanoseShokanShuruiShikyuGendoGaku>
     */
    public UwanoseShokanShuruiShikyuGendoGakuHolder(
            List<UwanoseShokanShuruiShikyuGendoGaku> uwanoseShokanShuruiShiList) {
        this.uwanoseShokanShuruiShiList = Models.create(uwanoseShokanShuruiShiList);
    }

    /**
     * UwanoseShokanShuruiShikyuGendoGakuHolderのobj作成です。
     *
     * @param uwanoseShokanShuruiShiList
     * List<UwanoseShokanShuruiShikyuGendoGaku>
     * Models<UwanoseShokanShuruiShikyuGendoGakuIdentifier,
     * UwanoseShokanShuruiShikyuGendoGaku>
     */
    public UwanoseShokanShuruiShikyuGendoGakuHolder(Models<
                    UwanoseShokanShuruiShikyuGendoGakuIdentifier, UwanoseShokanShuruiShikyuGendoGaku> uwanoseShokanShuruiShiList) {
        this.uwanoseShokanShuruiShiList = uwanoseShokanShuruiShiList;
    }

    /**
     * UwanoseShokanShuruiShikyuGendoGakuのlistを取得します。
     *
     * @return List<UwanoseShokanShuruiShikyuGendoGaku>
     */
    public List<UwanoseShokanShuruiShikyuGendoGaku> getuwanoseShokanShuruiShiList() {
        return new ArrayList<>(uwanoseShokanShuruiShiList.values());
    }

    /**
     * UwanoseShokanShuruiShikyuGendoGakuのlistを設定します。
     *
     * @param uwanoseShokanShuruiShikyuGendoGaku
     * UwanoseShokanShuruiShikyuGendoGaku
     */
    public void addUwanoseShokanShuruiShikyuGendoGaku(
            UwanoseShokanShuruiShikyuGendoGaku uwanoseShokanShuruiShikyuGendoGaku) {
        uwanoseShokanShuruiShiList.add(uwanoseShokanShuruiShikyuGendoGaku);
    }

    /**
     * UwanoseShokanShuruiShikyuGendoGakuを取得します。
     *
     * @param id UwanoseShokanShuruiShikyuGendoGakuIdentifier
     * @return UwanoseShokanShuruiShikyuGendoGaku
     */
    public UwanoseShokanShuruiShikyuGendoGaku getUwanoseShokanShuruiShikyuGendoGaku(
            UwanoseShokanShuruiShikyuGendoGakuIdentifier id) {
        if (uwanoseShokanShuruiShiList.contains(id)) {
            return uwanoseShokanShuruiShiList.clone().get(id);
        }
        return null;
    }
}
