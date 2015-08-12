/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Value;

/**
 * 転入保留対象者の識別子です。
 */
@Value
public class TennyushutsuHoryuTaishoshaIdentifier implements Serializable {

    private final ShikibetsuCode 識別コード;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     */
    public TennyushutsuHoryuTaishoshaIdentifier(ShikibetsuCode 識別コード,
            Decimal 履歴番号) {
        this.識別コード = 識別コード;
        this.履歴番号 = 履歴番号;
    }
}
