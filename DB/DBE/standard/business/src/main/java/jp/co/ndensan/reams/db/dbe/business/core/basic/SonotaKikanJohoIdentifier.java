/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * その他機関情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
//@lombok.Value
public class SonotaKikanJohoIdentifier implements Serializable {

    private final ShoKisaiHokenshaNo 証記載保険者番号;
    private final RString その他機関コード;

    /**
     * コンストラクタです。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param その他機関コード その他機関コード
     */
    public SonotaKikanJohoIdentifier(ShoKisaiHokenshaNo 証記載保険者番号,
            RString その他機関コード) {
        this.証記載保険者番号 = 証記載保険者番号;
        this.その他機関コード = その他機関コード;
    }
}
