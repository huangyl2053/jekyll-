/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 証交付回収の識別子です。
 */
@Value
public class ShoKofuKaishuIdentifier implements Serializable {

    private final HihokenshaNo 被保険者番号;
    private final RString 交付証種類;
    private final int 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 交付証種類 交付証種類
     * @param 履歴番号 履歴番号
     */
    public ShoKofuKaishuIdentifier(HihokenshaNo 被保険者番号,
            RString 交付証種類,
            int 履歴番号) {
        this.被保険者番号 = 被保険者番号;
        this.交付証種類 = 交付証種類;
        this.履歴番号 = 履歴番号;
    }
}
