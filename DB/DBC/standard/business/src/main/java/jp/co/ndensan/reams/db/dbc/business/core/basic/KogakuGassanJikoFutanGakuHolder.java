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
 * 業務概念KogakuGassanJikoFutanGakuのHolderクラスです。
 *
 * @reamsid_L DBC-4800-010 huzongcheng
 */
public class KogakuGassanJikoFutanGakuHolder implements Serializable {

    private static final long serialVersionUID = -3935825012351482058L;
    private final Models<KogakuGassanJikoFutanGakuIdentifier, KogakuGassanJikoFutanGaku> kogakuGassanJikoFutanGakuList;

    /**
     * KogakuGassanJikoFutanGakuHolderのobj作成です。
     */
    public KogakuGassanJikoFutanGakuHolder() {
        this.kogakuGassanJikoFutanGakuList = Models.create(new ArrayList<KogakuGassanJikoFutanGaku>());
    }

    /**
     * KogakuGassanJikoFutanGakuHolderのobj作成です。
     *
     * @param kogakuGassanJikoFutanGakuList List<KogakuGassanJikoFutanGaku>
     */
    public KogakuGassanJikoFutanGakuHolder(List<KogakuGassanJikoFutanGaku> kogakuGassanJikoFutanGakuList) {
        this.kogakuGassanJikoFutanGakuList = Models.create(kogakuGassanJikoFutanGakuList);
    }

    /**
     * KogakuGassanJikoFutanGakuHolderのobj作成です。
     *
     * @param kogakuGassanJikoFutanGakuList
     * Models<KogakuGassanJikoFutanGakuIdentifier, KogakuGassanJikoFutanGaku>
     */
    public KogakuGassanJikoFutanGakuHolder(Models<KogakuGassanJikoFutanGakuIdentifier, KogakuGassanJikoFutanGaku> kogakuGassanJikoFutanGakuList) {
        this.kogakuGassanJikoFutanGakuList = kogakuGassanJikoFutanGakuList;
    }

    /**
     * SogoJigyoKubunShikyuGendoGakuのlistを取得します。
     *
     * @return List<KogakuGassanJikoFutanGaku>
     */
    public List<KogakuGassanJikoFutanGaku> getKogakuGassanJikoFutanGakuList() {
        return new ArrayList<>(kogakuGassanJikoFutanGakuList.values());
    }

    /**
     * SogoJigyoKubunShikyuGendoGakuのlistを設定します。
     *
     * @param kogakugassanjikofutangaku KogakuGassanJikoFutanGaku
     */
    public void addKogakuGassanJikoFutanGaku(KogakuGassanJikoFutanGaku kogakugassanjikofutangaku) {
        kogakuGassanJikoFutanGakuList.add(kogakugassanjikofutangaku);
    }

    /**
     * KogakuGassanJikoFutanGakuを取得します。
     *
     * @param id KogakuGassanJikoFutanGakuIdentifier
     * @return KogakuGassanJikoFutanGaku
     */
    public KogakuGassanJikoFutanGaku getKogakuGassanJikoFutanGaku(KogakuGassanJikoFutanGakuIdentifier id) {
        if (kogakuGassanJikoFutanGakuList.contains(id)) {
            return kogakuGassanJikoFutanGakuList.clone().get(id);
        }
        return null;
    }

}
