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
 * 業務概念UwanoseKubunShikyuGendoGakuのHolderクラスです。
 *
 * @reamsid_L DBC-3410-010 jianglaisheng
 */
public class UwanoseKubunShikyuGendoGakuHolder implements Serializable {

    private static final long serialVersionUID = -3935825012351482058L;
    private final Models<
            UwanoseKubunShikyuGendoGakuIdentifier, UwanoseKubunShikyuGendoGaku> uwanoseKubunShikyuGendoGakuList;

    /**
     * UwanoseKubunShikyuGendoGakuHolderのobj作成です。
     */
    public UwanoseKubunShikyuGendoGakuHolder() {
        this.uwanoseKubunShikyuGendoGakuList
                = Models.create(new ArrayList<UwanoseKubunShikyuGendoGaku>());
    }

    /**
     * UwanoseKubunShikyuGendoGakuHolderのobj作成です。
     *
     * @param uwanoseKubunShikyuGendoGakuList List<UwanoseKubunShikyuGendoGaku>
     */
    public UwanoseKubunShikyuGendoGakuHolder(
            List<UwanoseKubunShikyuGendoGaku> uwanoseKubunShikyuGendoGakuList) {
        this.uwanoseKubunShikyuGendoGakuList = Models.create(uwanoseKubunShikyuGendoGakuList);
    }

    /**
     * UwanoseKubunShikyuGendoGakuHolderのobj作成です。
     *
     * @param uwanoseKubunShikyuGendoGakuList
     * Models<UwanoseKubunShikyuGendoGakuIdentifier,
     * UwanoseKubunShikyuGendoGaku>
     */
    public UwanoseKubunShikyuGendoGakuHolder(
            Models<
                    UwanoseKubunShikyuGendoGakuIdentifier, UwanoseKubunShikyuGendoGaku> uwanoseKubunShikyuGendoGakuList) {
        this.uwanoseKubunShikyuGendoGakuList = uwanoseKubunShikyuGendoGakuList;
    }

    /**
     * UwanoseKubunShikyuGendoGakuのlistを取得します。
     *
     * @return List<UwanoseKubunShikyuGendoGaku>
     */
    public List<UwanoseKubunShikyuGendoGaku> getUwanoseKubunShikyuGendoGakuList() {
        return new ArrayList<>(uwanoseKubunShikyuGendoGakuList.values());
    }

    /**
     * UwanoseKubunShikyuGendoGakuのlistを設定します。
     *
     * @param uwanoseKubunShikyuGendoGaku UwanoseKubunShikyuGendoGaku
     */
    public void addUwanoseKubunShikyuGendoGaku(UwanoseKubunShikyuGendoGaku uwanoseKubunShikyuGendoGaku) {
        uwanoseKubunShikyuGendoGakuList.add(uwanoseKubunShikyuGendoGaku);
    }

    /**
     * UwanoseKubunShikyuGendoGakuを取得します。
     *
     * @param id UwanoseKubunShikyuGendoGakuIdentifier
     * @return UwanoseKubunShikyuGendoGaku
     */
    public UwanoseKubunShikyuGendoGaku getUwanoseKubunShikyuGendoGaku(UwanoseKubunShikyuGendoGakuIdentifier id) {
        if (uwanoseKubunShikyuGendoGakuList.contains(id)) {
            return uwanoseKubunShikyuGendoGakuList.clone().get(id);
        }
        return null;
    }
}
