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
 * 後期高齢者情報の識別子です。
 *
 * @reamsid_L DBD-5740-010 liuyl
 */
@Value
@SuppressWarnings("PMD.UnusedPrivateField")
public class KokiKoreishaInfoIdentifier implements Serializable {

    private final ShikibetsuCode 識別コード;
    private final RString 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 識別コード ShikibetsuCode
     * @param 履歴番号 RString
     */
    public KokiKoreishaInfoIdentifier(ShikibetsuCode 識別コード, RString 履歴番号) {
        this.識別コード = 識別コード;
        this.履歴番号 = 履歴番号;
    }

}
