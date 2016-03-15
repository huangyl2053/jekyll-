/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinseikensaku;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;

/**
 * 要介護認定申請検索Businessクラスです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinseiKensakuInfoBusiness implements Serializable {

    private static final long serialVersionUID = 2060329856813237621L;

    private final List<ShinseiKensakuBusiness> shinseiKensakuList;

    /**
     * コンストラクタです。
     *
     * @param shinseiKensakuList List<ShinseiKensakuBusiness>
     */
    public ShinseiKensakuInfoBusiness(List<ShinseiKensakuBusiness> shinseiKensakuList) {
        this.shinseiKensakuList = shinseiKensakuList;
    }
}
