/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.koseishichoson;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 構成市町村マスタの識別子です。
 *
 * @reamsid_L DBX-9999-011 sunhaidi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class KoseiShichosonMasterIdentifier implements Serializable {

    private static final long serialVersionUID = -2100269448367237366L;

    private final RString 市町村識別ID;

    /**
     * コンストラクタです。
     *
     * @param 市町村識別ID 市町村識別ID
     */
    public KoseiShichosonMasterIdentifier(RString 市町村識別ID) {
        this.市町村識別ID = 市町村識別ID;
    }
}
