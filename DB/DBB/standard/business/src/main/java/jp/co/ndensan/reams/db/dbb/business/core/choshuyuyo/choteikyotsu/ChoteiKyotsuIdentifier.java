/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.choteikyotsu;

import java.io.Serializable;

/**
 * 調定共通（介護継承）の識別子です。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ChoteiKyotsuIdentifier implements Serializable {

    private final long 調定ID;

    /**
     * コンストラクタです。
     *
     * @param 調定ID 調定ID
     */
    public ChoteiKyotsuIdentifier(long 調定ID) {
        this.調定ID = 調定ID;
    }
    private static final long serialVersionUID = 4658617548505667736L;
}
