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
            UwanoseKubunShikyuGendoGakuIdentifier, UwanoseKubunShikyuGendoGaku> uwanoseKubunShikyuList;

    /**
     * UwanoseKubunShikyuGendoGakuHolderのobj作成です。
     */
    public UwanoseKubunShikyuGendoGakuHolder() {
        this.uwanoseKubunShikyuList
                = Models.create(new ArrayList<UwanoseKubunShikyuGendoGaku>());
    }

    /**
     * UwanoseKubunShikyuGendoGakuHolderのobj作成です。
     *
     * @param uwanoseKubunShikyuList List<UwanoseKubunShikyuGendoGaku>
     */
    public UwanoseKubunShikyuGendoGakuHolder(
            List<UwanoseKubunShikyuGendoGaku> uwanoseKubunShikyuList) {
        this.uwanoseKubunShikyuList = Models.create(uwanoseKubunShikyuList);
    }

    /**
     * UwanoseKubunShikyuGendoGakuHolderのobj作成です。
     *
     * @param uwanoseKubunShikyuList
     * Models<UwanoseKubunShikyuGendoGakuIdentifier,
     * UwanoseKubunShikyuGendoGaku>
     */
    public UwanoseKubunShikyuGendoGakuHolder(
            Models<
                    UwanoseKubunShikyuGendoGakuIdentifier, UwanoseKubunShikyuGendoGaku> uwanoseKubunShikyuList) {
        this.uwanoseKubunShikyuList = uwanoseKubunShikyuList;
    }

    /**
     * UwanoseKubunShikyuGendoGakuのlistを取得します。
     *
     * @return List<UwanoseKubunShikyuGendoGaku>
     */
    public List<UwanoseKubunShikyuGendoGaku> getUwanoseKubunShikyuGendoGakuList() {
        return new ArrayList<>(uwanoseKubunShikyuList.values());
    }

    /**
     * UwanoseKubunShikyuGendoGakuのlistを設定します。
     *
     * @param uwanoseKubunShikyuGendoGaku UwanoseKubunShikyuGendoGaku
     */
    public void addUwanoseKubunShikyuGendoGaku(UwanoseKubunShikyuGendoGaku uwanoseKubunShikyuGendoGaku) {
        uwanoseKubunShikyuList.add(uwanoseKubunShikyuGendoGaku);
    }

    /**
     * UwanoseKubunShikyuGendoGakuを取得します。
     *
     * @param id UwanoseKubunShikyuGendoGakuIdentifier
     * @return UwanoseKubunShikyuGendoGaku
     */
    public UwanoseKubunShikyuGendoGaku getUwanoseKubunShikyuGendoGaku(UwanoseKubunShikyuGendoGakuIdentifier id) {
        if (uwanoseKubunShikyuList.contains(id)) {
            return uwanoseKubunShikyuList.clone().get(id);
        }
        return null;
    }
}
