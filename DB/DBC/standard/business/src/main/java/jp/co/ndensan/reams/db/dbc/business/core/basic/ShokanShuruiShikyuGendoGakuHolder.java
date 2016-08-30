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
 * 業務概念ShokanShuruiShikyuGendoGakuのHolderクラスです。
 *
 * @reamsid_L DBC-3460-010 jianglaisheng
 */
public class ShokanShuruiShikyuGendoGakuHolder implements Serializable {

    private static final long serialVersionUID = -3935825012351482058L;
    private final Models<ShokanShuruiShikyuGendoGakuIdentifier, ShokanShuruiShikyuGendoGaku> shokanShuruiShikyuGendoGakuList;

    /**
     * ShokanShuruiShikyuGendoGakuHolderのobj作成です。
     */
    public ShokanShuruiShikyuGendoGakuHolder() {
        this.shokanShuruiShikyuGendoGakuList = Models.create(new ArrayList<ShokanShuruiShikyuGendoGaku>());
    }

    /**
     * ShokanShuruiShikyuGendoGakuHolderのobj作成です。
     *
     * @param shokanShuruiShikyuGendoGakuList List<ShokanShuruiShikyuGendoGaku>
     */
    public ShokanShuruiShikyuGendoGakuHolder(List<ShokanShuruiShikyuGendoGaku> shokanShuruiShikyuGendoGakuList) {
        this.shokanShuruiShikyuGendoGakuList = Models.create(shokanShuruiShikyuGendoGakuList);
    }

    /**
     * ShokanShuruiShikyuGendoGakuHolderのobj作成です。
     *
     * @param shokanShuruiShikyuGendoGakuList List<ShokanShuruiShikyuGendoGaku>
     * Models<ShokanShuruiShikyuGendoGakuIdentifier,
     * ShokanShuruiShikyuGendoGaku>
     */
    public ShokanShuruiShikyuGendoGakuHolder(
            Models<ShokanShuruiShikyuGendoGakuIdentifier, ShokanShuruiShikyuGendoGaku> shokanShuruiShikyuGendoGakuList) {
        this.shokanShuruiShikyuGendoGakuList = shokanShuruiShikyuGendoGakuList;
    }

    /**
     * ShokanShuruiShikyuGendoGakuのlistを取得します。
     *
     * @return List<ShokanShuruiShikyuGendoGaku>
     */
    public List<ShokanShuruiShikyuGendoGaku> getShokanShuruiShikyuGendoGakuList() {
        return new ArrayList<>(shokanShuruiShikyuGendoGakuList.values());
    }

    /**
     * ShokanShuruiShikyuGendoGakuのlistを設定します。
     *
     * @param shokanShuruiShikyuGendoGaku ShokanShuruiShikyuGendoGaku
     */
    public void addShokanShuruiShikyuGendoGaku(ShokanShuruiShikyuGendoGaku shokanShuruiShikyuGendoGaku) {
        shokanShuruiShikyuGendoGakuList.add(shokanShuruiShikyuGendoGaku);
    }

    /**
     * ShokanShuruiShikyuGendoGakuを取得します。
     *
     * @param id ShokanShuruiShikyuGendoGakuIdentifier
     * @return ShokanShuruiShikyuGendoGaku
     */
    public ShokanShuruiShikyuGendoGaku getShokanShuruiShikyuGendoGaku(ShokanShuruiShikyuGendoGakuIdentifier id) {
        if (shokanShuruiShikyuGendoGakuList.contains(id)) {
            return shokanShuruiShikyuGendoGakuList.clone().get(id);
        }
        return null;
    }
}
