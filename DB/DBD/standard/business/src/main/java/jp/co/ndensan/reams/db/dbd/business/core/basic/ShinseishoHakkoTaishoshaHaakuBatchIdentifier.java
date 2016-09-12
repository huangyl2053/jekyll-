/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import java.util.UUID;
import lombok.Value;

/**
 * 申請書発行対象者把握の識別子です。
 *
 * @reamsid_L DBD-3530-060 liuyl
 */
@Value
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinseishoHakkoTaishoshaHaakuBatchIdentifier {

    private final UUID 把握処理ID;

    /**
     * コンストラクタです。
     *
     * @param 把握処理ID UUID
     */
    public ShinseishoHakkoTaishoshaHaakuBatchIdentifier(UUID 把握処理ID) {
        this.把握処理ID = 把握処理ID;
    }
}
