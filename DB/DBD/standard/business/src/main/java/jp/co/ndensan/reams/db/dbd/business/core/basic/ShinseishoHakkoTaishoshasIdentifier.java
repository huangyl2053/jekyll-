/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import java.io.Serializable;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * 申請書発行対象の識別子です。
 *
 * @reamsid_L DBD-3530-060 liuyl
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShinseishoHakkoTaishoshasIdentifier implements Serializable {

    private final UUID 発行処理ID;
    private final HihokenshaNo 被保険者番号;

    /**
     * コンストラクタです。
     *
     * @param 発行処理ID UUID
     * @param 被保険者番号 HihokenshaNo
     */
    public ShinseishoHakkoTaishoshasIdentifier(UUID 発行処理ID, HihokenshaNo 被保険者番号) {
        this.発行処理ID = 発行処理ID;
        this.被保険者番号 = 被保険者番号;
    }

}
