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
 * 業務概念KubunShikyuGendoGakuのHolderクラスです。
 *
 * @reamsid_L DBC-3410-010 jianglaisheng
 */
public class KubunShikyuGendoGakuHolder implements Serializable {

    private static final long serialVersionUID = -3935825012351482058L;
    private final Models<KubunShikyuGendoGakuIdentifier, KubunShikyuGendoGaku> kubunShikyuGendoGakuList;

    /**
     * KubunShikyuGendoGakuHolderのobj作成です。
     */
    public KubunShikyuGendoGakuHolder() {
        this.kubunShikyuGendoGakuList = Models.create(new ArrayList<KubunShikyuGendoGaku>());
    }

    /**
     * KubunShikyuGendoGakuHolderのobj作成です。
     *
     * @param kubunShikyuGendoGakuList List<KubunShikyuGendoGaku>
     */
    public KubunShikyuGendoGakuHolder(List<KubunShikyuGendoGaku> kubunShikyuGendoGakuList) {
        this.kubunShikyuGendoGakuList = Models.create(kubunShikyuGendoGakuList);
    }

    /**
     * KubunShikyuGendoGakuHolderのobj作成です。
     *
     * @param kubunShikyuGendoGakuList Models<KubunShikyuGendoGakuIdentifier,
     * KubunShikyuGendoGaku>
     */
    public KubunShikyuGendoGakuHolder(
            Models<KubunShikyuGendoGakuIdentifier, KubunShikyuGendoGaku> kubunShikyuGendoGakuList) {
        this.kubunShikyuGendoGakuList = kubunShikyuGendoGakuList;
    }

    /**
     * KubunShikyuGendoGakuのlistを取得します。
     *
     * @return List<KubunShikyuGendoGaku>
     */
    public List<KubunShikyuGendoGaku> getKubunShikyuGendoGakuList() {
        return new ArrayList<>(kubunShikyuGendoGakuList.values());
    }

    /**
     * KubunShikyuGendoGakuのlistを設定します。
     *
     * @param kubunShikyuGendoGaku KubunShikyuGendoGaku
     */
    public void addKubunShikyuGendoGaku(KubunShikyuGendoGaku kubunShikyuGendoGaku) {
        kubunShikyuGendoGakuList.add(kubunShikyuGendoGaku);
    }

    /**
     * KubunShikyuGendoGakuを取得します。
     *
     * @param id KubunShikyuGendoGakuIdentifier
     * @return KubunShikyuGendoGaku
     */
    public KubunShikyuGendoGaku getKubunShikyuGendoGaku(KubunShikyuGendoGakuIdentifier id) {
        if (kubunShikyuGendoGakuList.contains(id)) {
            return kubunShikyuGendoGakuList.clone().get(id);
        }
        return null;
    }
}
