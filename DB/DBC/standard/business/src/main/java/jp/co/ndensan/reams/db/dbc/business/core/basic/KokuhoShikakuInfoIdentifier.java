/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Value;

/**
 * 国保資格詳細情報を管理の識別子です。
 *
 * @reamsid_L DBD-5730-010 tianyh
 */
@Value
@SuppressWarnings("PMD.UnusedPrivateField")
public class KokuhoShikakuInfoIdentifier implements Serializable {

    private final ShikibetsuCode 識別コード;
    private final RString 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     */
    public KokuhoShikakuInfoIdentifier(ShikibetsuCode 識別コード,
            RString 履歴番号) {
        this.識別コード = 識別コード;
        this.履歴番号 = 履歴番号;
    }
}
