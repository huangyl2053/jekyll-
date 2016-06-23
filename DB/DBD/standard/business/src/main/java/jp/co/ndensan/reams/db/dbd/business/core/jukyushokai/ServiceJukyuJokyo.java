/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.jukyushokai;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.jukyushokai.ServiceJukyuJokyoEntity;

/**
 * サービス受給状況クラスです。
 *
 * @reamsid_L DBD-3560-011 xuyue
 */
public class ServiceJukyuJokyo {

    private final ServiceJukyuJokyoEntity サービス受給状況Entity;

    /**
     * コンストラクタです。
     *
     * @param サービス受給状況Entity サービス受給状況Entity
     */
    public ServiceJukyuJokyo(ServiceJukyuJokyoEntity サービス受給状況Entity) {
        this.サービス受給状況Entity = サービス受給状況Entity;
    }

    /**
     * had負担限度額認定を取得します。
     *
     * @return had負担限度額認定
     */
    public boolean had負担限度額認定() {
        return サービス受給状況Entity.isHad負担限度額認定();
    }

    /**
     * had利用者負担減免を取得します。
     *
     * @return had利用者負担減免
     */
    public boolean had利用者負担減免() {
        return サービス受給状況Entity.isHad利用者負担減免();
    }

    /**
     * had訪問介護減免を取得します。
     *
     * @return had訪問介護減免
     */
    public boolean had訪問介護減免() {
        return サービス受給状況Entity.isHad訪問介護減免();
    }

    /**
     * had社福軽減を取得します。
     *
     * @return had社福軽減
     */
    public boolean had社福軽減() {
        return サービス受給状況Entity.isHad社福軽減();
    }

    /**
     * had特地減免を取得します。
     *
     * @return had特地減免
     */
    public boolean had特地減免() {
        return サービス受給状況Entity.isHad特地減免();
    }

    /**
     * had施設入退所を取得します。
     *
     * @return had施設入退所
     */
    public boolean had施設入退所() {
        return サービス受給状況Entity.isHad施設入退所();
    }

    /**
     * had老齢受給を取得します。
     *
     * @return had老齢受給
     */
    public boolean had老齢受給() {
        return サービス受給状況Entity.isHad老齢受給();
    }

    /**
     * had生保受給を取得します。
     *
     * @return had生保受給
     */
    public boolean had生保受給() {
        return サービス受給状況Entity.isHad生保受給();
    }

    /**
     * had医療保険加入を取得します。
     *
     * @return had医療保険加入
     */
    public boolean had医療保険加入() {
        return サービス受給状況Entity.isHad医療保険加入();
    }

    /**
     * had居宅届出を取得します。
     *
     * @return had居宅届出
     */
    public boolean had居宅届出() {
        return サービス受給状況Entity.isHad居宅届出();
    }

    /**
     * hadBeen総合事業対象を取得します。
     *
     * @return hadBeen総合事業対象
     */
    public boolean hadBeen総合事業対象() {
        return サービス受給状況Entity.isHadBeen総合事業対象();
    }

    /**
     * had非課税年金受給を取得します。
     *
     * @return had非課税年金受給
     */
    public boolean had非課税年金受給() {
        return サービス受給状況Entity.isHad非課税年金受給();
    }

}
