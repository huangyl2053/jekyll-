/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokensha.shisetsunyutaisho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 介護保険施設入退所の識別子です。
 *
 * @reamsid_L DBA-9999-011 sunhaidi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShisetsuNyutaishoIdentifier implements Serializable {

    private static final long serialVersionUID = -1729947044781903093L;
    private final ShikibetsuCode 識別コード;
    private final int 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     */
    public ShisetsuNyutaishoIdentifier(ShikibetsuCode 識別コード,
            int 履歴番号) {
        this.識別コード = 識別コード;
        this.履歴番号 = 履歴番号;
    }
}
