/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import java.io.Serializable;
import java.util.UUID;

/**
 * 申請書一括発行の識別子です。
 *
 * @reamsid_L DBD-3530-060 liuyl
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShinseishoIkkatsuHakkoBatchIdentifier implements Serializable {

    private final UUID 発行処理ID;

    /**
     * コンストラクタです。
     *
     * @param 発行処理ID UUID
     */
    public ShinseishoIkkatsuHakkoBatchIdentifier(UUID 発行処理ID) {
        this.発行処理ID = 発行処理ID;
    }

}
