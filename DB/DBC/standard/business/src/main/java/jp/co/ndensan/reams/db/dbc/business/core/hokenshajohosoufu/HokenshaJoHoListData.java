/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.hokenshajohosoufu;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;

/**
 * 保険者情報送付の保険者情報リストクラスです。
 *
 * @reamsid_L DBC-3480-010 dongyabin
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HokenshaJoHoListData implements Serializable {

    private List<HokenshaJoHoList> hokenshaJoHoList;

    /**
     * コンストラクタです。
     *
     * @param hokenshaJoHoList hokenshaJoHoList
     */
    public HokenshaJoHoListData(List<HokenshaJoHoList> hokenshaJoHoList) {
        this.hokenshaJoHoList = hokenshaJoHoList;
    }
}
