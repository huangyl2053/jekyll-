/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.uzclasses.Models;

/**
 * 業務概念CareManegerのHolderクラスです。
 *
 * @reamsid_L DBC-9999-012 yuqingzhang
 */
public class CareManegerHolder implements Serializable {

    private static final long serialVersionUID = -3935825012351482058L;
    private final Models<CareManegerIdentifier, CareManeger> careManegerList;

    /**
     * CareManegerHolderのobj作成です。
     */
    public CareManegerHolder() {
        this.careManegerList = Models.create(new ArrayList<CareManeger>());
    }

    /**
     * CareManegerHolderのobj作成です。
     *
     * @param careManegerList List<CareManeger>
     */
    public CareManegerHolder(List<CareManeger> careManegerList) {
        this.careManegerList = Models.create(careManegerList);
    }

    /**
     * CareManegerHolderのobj作成です。
     *
     * @param careManegerList Models<CareManegerIdentifier, CareManeger>
     */
    public CareManegerHolder(Models<CareManegerIdentifier, CareManeger> careManegerList) {
        this.careManegerList = careManegerList;
    }

    /**
     * SogoJigyoKubunShikyuGendoGakuのlistを取得します。
     *
     * @return List<CareManeger>
     */
    public List<CareManeger> getCareManegerList() {
        return new ArrayList<>(careManegerList.values());
    }

    /**
     * SogoJigyoKubunShikyuGendoGakuのlistを設定します。
     *
     * @param kogakugassanjikofutangaku CareManeger
     */
    public void addCareManeger(CareManeger kogakugassanjikofutangaku) {
        careManegerList.add(kogakugassanjikofutangaku);
    }

    /**
     * CareManegerを取得します。
     *
     * @param id CareManegerIdentifier
     * @return CareManeger
     */
    public CareManeger getCareManeger(CareManegerIdentifier id) {
        if (careManegerList.contains(id)) {
            return careManegerList.clone().get(id);
        }
        return null;
    }
}
