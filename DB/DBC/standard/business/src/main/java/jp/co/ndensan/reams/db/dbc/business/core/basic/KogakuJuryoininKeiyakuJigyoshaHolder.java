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
 *
 * @author Administrator
 */
public class KogakuJuryoininKeiyakuJigyoshaHolder implements Serializable {

    private static final long serialVersionUID = -3935825012351482058L;
    private final Models<KogakuJuryoininKeiyakuJigyoshaIdentifier, KogakuJuryoininKeiyakuJigyosha> businessList;

    /**
     * KogakuJuryoininKeiyakuJigyoshaHolderのobj作成です。
     */
    public KogakuJuryoininKeiyakuJigyoshaHolder() {
        this.businessList = Models.create(new ArrayList<KogakuJuryoininKeiyakuJigyosha>());
    }

    /**
     * KogakuJuryoininKeiyakuJigyoshaHolderのobj作成です。
     *
     * @param businessList List<KogakuJuryoininKeiyakuJigyosha>
     */
    public KogakuJuryoininKeiyakuJigyoshaHolder(List<KogakuJuryoininKeiyakuJigyosha> businessList) {
        this.businessList = Models.create(businessList);
    }

    /**
     * KogakuJuryoininKeiyakuJigyoshaHolderのobj作成です。
     *
     * @param businessList Models<KogakuJuryoininKeiyakuJigyoshaIdentifier, KogakuJuryoininKeiyakuJigyosha>
     */
    public KogakuJuryoininKeiyakuJigyoshaHolder(Models<KogakuJuryoininKeiyakuJigyoshaIdentifier, KogakuJuryoininKeiyakuJigyosha> businessList) {
        this.businessList = businessList;
    }

    /**
     * SogoJigyoKubunShikyuGendoGakuのlistを取得します。
     *
     * @return List<KogakuJuryoininKeiyakuJigyosha>
     */
    public List<KogakuJuryoininKeiyakuJigyosha> getKogakuJuryoininKeiyakuJigyoshaList() {
        return new ArrayList<>(businessList.values());
    }

    /**
     * SogoJigyoKubunShikyuGendoGakuのlistを設定します。
     *
     * @param kogakugassanjikofutangaku KogakuJuryoininKeiyakuJigyosha
     */
    public void addKogakuJuryoininKeiyakuJigyosha(KogakuJuryoininKeiyakuJigyosha kogakugassanjikofutangaku) {
        businessList.add(kogakugassanjikofutangaku);
    }

    /**
     * KogakuJuryoininKeiyakuJigyoshaを取得します。
     *
     * @param id KogakuJuryoininKeiyakuJigyoshaIdentifier
     * @return KogakuJuryoininKeiyakuJigyosha
     */
    public KogakuJuryoininKeiyakuJigyosha getKogakuJuryoininKeiyakuJigyosha(KogakuJuryoininKeiyakuJigyoshaIdentifier id) {
        if (businessList.contains(id)) {
            return businessList.clone().get(id);
        }
        return null;
    }
}
