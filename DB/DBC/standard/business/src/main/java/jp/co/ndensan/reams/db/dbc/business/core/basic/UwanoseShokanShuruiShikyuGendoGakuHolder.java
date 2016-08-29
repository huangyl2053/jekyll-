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
    private final Models<UwanoseShokanShuruiShikyuGendoGakuIdentifier, UwanoseShokanShuruiShikyuGendoGaku> uwanoseShokanShuruiShikyuGendoGakuList;

    /**
     * UwanoseShokanShuruiShikyuGendoGakuHolderのobj作成です。
     */
    public UwanoseShokanShuruiShikyuGendoGakuHolder() {
        this.uwanoseShokanShuruiShikyuGendoGakuList = Models.create(new ArrayList<UwanoseShokanShuruiShikyuGendoGaku>());
    }

    /**
     * UwanoseShokanShuruiShikyuGendoGakuHolderのobj作成です。
     *
     * @param uwanoseShokanShuruiShikyuGendoGakuList
     * List<UwanoseShokanShuruiShikyuGendoGaku>
     */
    public UwanoseShokanShuruiShikyuGendoGakuHolder(List<UwanoseShokanShuruiShikyuGendoGaku> uwanoseShokanShuruiShikyuGendoGakuList) {
        this.uwanoseShokanShuruiShikyuGendoGakuList = Models.create(uwanoseShokanShuruiShikyuGendoGakuList);
    }

    /**
     * UwanoseShokanShuruiShikyuGendoGakuHolderのobj作成です。
     *
     * @param uwanoseShokanShuruiShikyuGendoGakuList
     * List<UwanoseShokanShuruiShikyuGendoGaku>
     * Models<UwanoseShokanShuruiShikyuGendoGakuIdentifier,
     * UwanoseShokanShuruiShikyuGendoGaku>
     */
    public UwanoseShokanShuruiShikyuGendoGakuHolder(
            Models<UwanoseShokanShuruiShikyuGendoGakuIdentifier, UwanoseShokanShuruiShikyuGendoGaku> uwanoseShokanShuruiShikyuGendoGakuList) {
        this.uwanoseShokanShuruiShikyuGendoGakuList = uwanoseShokanShuruiShikyuGendoGakuList;
    }

    /**
     * UwanoseShokanShuruiShikyuGendoGakuのlistを取得します。
     *
     * @return List<UwanoseShokanShuruiShikyuGendoGaku>
     */
    public List<UwanoseShokanShuruiShikyuGendoGaku> getuwanoseShokanShuruiShikyuGendoGakuList() {
        return new ArrayList<>(uwanoseShokanShuruiShikyuGendoGakuList.values());
    }

    /**
     * UwanoseShokanShuruiShikyuGendoGakuのlistを設定します。
     *
     * @param uwanoseShokanShuruiShikyuGendoGaku
     * UwanoseShokanShuruiShikyuGendoGaku
     */
    public void addUwanoseShokanShuruiShikyuGendoGaku(UwanoseShokanShuruiShikyuGendoGaku uwanoseShokanShuruiShikyuGendoGaku) {
        uwanoseShokanShuruiShikyuGendoGakuList.add(uwanoseShokanShuruiShikyuGendoGaku);
    }

    /**
     * UwanoseShokanShuruiShikyuGendoGakuを取得します。
     *
     * @param id UwanoseShokanShuruiShikyuGendoGakuIdentifier
     * @return UwanoseShokanShuruiShikyuGendoGaku
     */
    public UwanoseShokanShuruiShikyuGendoGaku getUwanoseShokanShuruiShikyuGendoGaku(UwanoseShokanShuruiShikyuGendoGakuIdentifier id) {
        if (uwanoseShokanShuruiShikyuGendoGakuList.contains(id)) {
            return uwanoseShokanShuruiShikyuGendoGakuList.clone().get(id);
        }
        return null;
    }
}
