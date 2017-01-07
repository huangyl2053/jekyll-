/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.ninteishinseishafinder;

import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;

/**
 * NinteiShinseishaFinder のパラメタ保持クラスです。
 */
@lombok.Getter
@lombok.Setter
public class NinteiShinseishaFinderParameter {

    GyomuBunrui 業務分類;
    boolean checkedみなし2号申請;
    ShoKisaiHokenshaNo 証記載保険者番号;

    public NinteiShinseishaFinderParameter() {
        業務分類 = null;
        checkedみなし2号申請 = false;
        証記載保険者番号 = null;
    }
}
