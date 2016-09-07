/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 業務概念KaigoServiceShuruiのHolderクラスです。
 *
 * @reamsid_L DBC-3350-010 jiangzongyue
 */
public class KaigoServiceShuruiHolder implements Serializable {

    private static final long serialVersionUID = -3935825012351482058L;
    private final Models<KaigoServiceShuruiIdentifier, KaigoServiceShurui> kaigoServiceShuruiList;

    /**
     * KaigoServiceShuruiHolderのobj作成です。
     */
    public KaigoServiceShuruiHolder() {
        this.kaigoServiceShuruiList = Models.create(new ArrayList<KaigoServiceShurui>());
    }

    /**
     * KaigoServiceShuruiHolderのobj作成です。
     *
     * @param kaigoServiceShuruiList List<kaigoServiceShuruiList>
     */
    public KaigoServiceShuruiHolder(List<KaigoServiceShurui> kaigoServiceShuruiList) {
        this.kaigoServiceShuruiList = Models.create(kaigoServiceShuruiList);
    }

    /**
     * KaigoServiceShuruiHolderのobj作成です。
     *
     * @param kaigoServiceShuruiList Models<KaigoServiceShuruiIdentifier, KaigoServiceShurui>
     */
    public KaigoServiceShuruiHolder(Models<KaigoServiceShuruiIdentifier, KaigoServiceShurui> kaigoServiceShuruiList) {
        this.kaigoServiceShuruiList = kaigoServiceShuruiList;
    }

    /**
     * KaigoServiceShuruiHolderのlistを取得します。
     *
     * @return List<KogakuGassanJikoFutanGaku>
     */
    public List<KaigoServiceShurui> getKaigoServiceShuruiList() {
        return new ArrayList<>(kaigoServiceShuruiList.values());
    }

    /**
     * SogoJigyoKubunShikyuGendoGakuのlistを設定します。
     *
     * @param kaigoServiceShurui KaigoServiceShurui
     */
    public void addKogakuGassanJikoFutanGaku(KaigoServiceShurui kaigoServiceShurui) {
        kaigoServiceShuruiList.add(kaigoServiceShurui);
    }

    /**
     * KogakuGassanJikoFutanGakuを取得します。
     *
     * @param id KaigoServiceShuruiIdentifier
     * @return KaigoServiceShurui
     */
    public KaigoServiceShurui getKogakuGassanJikoFutanGaku(KaigoServiceShuruiIdentifier id) {
        if (kaigoServiceShuruiList.contains(id)) {
            return kaigoServiceShuruiList.clone().get(id);
        }
        return null;
    }

}
