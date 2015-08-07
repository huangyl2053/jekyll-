/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import lombok.Value;

/**
 * 資格取得除外者の識別子です。
 */
@Value
public class ShikakuShutokuJogaishaIdentifier implements Serializable {

    private final ShikibetsuCode 識別コード;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     */
    public ShikakuShutokuJogaishaIdentifier(ShikibetsuCode 識別コード,
Decimal 履歴番号) {
        this.識別コード = 識別コード;
        this.履歴番号 = 履歴番号;
    }
}
