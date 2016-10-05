/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 業務概念KaigoServiceNaiyouのHolderクラスです。
 *
 * @reamsid_L DBC-3320-010 chenhui
 */
public class KaigoServiceNaiyouHolder implements Serializable {

    private static final long serialVersionUID = -3935825012351482058L;
    private final Models<KaigoServiceNaiyouIdentifier, KaigoServiceNaiyou> kaigoServiceNaiyouList;

    /**
     * KaigoServiceNaiyouHolderのobj作成です。
     */
    public KaigoServiceNaiyouHolder() {
        this.kaigoServiceNaiyouList = Models.create(new ArrayList<KaigoServiceNaiyou>());
    }

    /**
     * KaigoServiceNaiyouHolderのobj作成です。
     *
     * @param kaigoServiceNaiyouList List<KaigoServiceNaiyou>
     */
    public KaigoServiceNaiyouHolder(List<KaigoServiceNaiyou> kaigoServiceNaiyouList) {
        this.kaigoServiceNaiyouList = Models.create(kaigoServiceNaiyouList);
    }

    /**
     * KaigoServiceNaiyouHolderのobj作成です。
     *
     * @param kaigoServiceNaiyouList Models<KaigoServiceNaiyouIdentifier,
     * KaigoServiceNaiyou>
     */
    public KaigoServiceNaiyouHolder(Models<KaigoServiceNaiyouIdentifier, KaigoServiceNaiyou> kaigoServiceNaiyouList) {
        this.kaigoServiceNaiyouList = kaigoServiceNaiyouList;
    }

    /**
     * KaigoServiceNaiyouHolderのlistを取得します。
     *
     * @return List<KaigoServiceNaiyou>
     */
    public List<KaigoServiceNaiyou> getKaigoServiceNaiyouList() {
        return new ArrayList<>(kaigoServiceNaiyouList.values());
    }

    /**
     * KaigoServiceNaiyouのlistを設定します。
     *
     * @param kaigoServiceNaiyou KaigoServiceNaiyou
     */
    public void addKaigoServiceNaiyou(KaigoServiceNaiyou kaigoServiceNaiyou) {
        kaigoServiceNaiyouList.add(kaigoServiceNaiyou);
    }

    /**
     * KaigoServiceNaiyouを取得します。
     *
     * @param id KaigoServiceNaiyouIdentifier
     * @return KaigoServiceNaiyou
     */
    public KaigoServiceNaiyou getKaigoServiceNaiyou(KaigoServiceNaiyouIdentifier id) {
        if (kaigoServiceNaiyouList.contains(id)) {
            return kaigoServiceNaiyouList.clone().get(id);
        }
        return null;
    }

}
