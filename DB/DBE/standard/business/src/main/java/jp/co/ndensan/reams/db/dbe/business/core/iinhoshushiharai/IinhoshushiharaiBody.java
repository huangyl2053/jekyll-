/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.iinhoshushiharai;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会委員報酬支払通知書のBodyクラスです。
 *
 * @reamsid_L DBE-1980-030 suguangjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IinhoshushiharaiBody {

    private final RString listHoshuhi_1;
    private final RString listGokei_1;

    /**
     * コンストラクタです。
     *
     * @param listHoshuhi_1 報酬報償費
     * @param listGokei_1 差引支給額
     */
    public IinhoshushiharaiBody(RString listHoshuhi_1,
            RString listGokei_1
    ) {
        this.listHoshuhi_1 = listHoshuhi_1;
        this.listGokei_1 = listGokei_1;
    }
}
