/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinseikensaku;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import lombok.Getter;

/**
 * 要介護認定申請検索Businessクラスです。
 *
 * @reamsid_L DBE-1370-010 sunhaidi
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinseiKensakuInfoBusiness implements Serializable {

    private static final long serialVersionUID = 2060329856813237621L;

    private final List<ShinseishoKanriNo> shinseiKensakuList;

    /**
     * コンストラクタです。
     *
     * @param shinseiKensakuList List<ShinseiKensakuBusiness>
     */
    public ShinseiKensakuInfoBusiness(List<ShinseishoKanriNo> shinseiKensakuList) {
        this.shinseiKensakuList = shinseiKensakuList;
    }
}
