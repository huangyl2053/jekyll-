/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokensha.jukyushadaicho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者台帳の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class JukyushaDaichoIdentifier implements Serializable {

    private static final long serialVersionUID = 8783303115467556258L;
    private final LasdecCode 市町村コード;
    private final HihokenshaNo 被保険者番号;
    private final RString 履歴番号;
    private final RString 枝番;
    private final Code 受給申請事由;

    /**
     * コンストラクタです。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @param 枝番 枝番
     * @param 受給申請事由 受給申請事由
     */
    public JukyushaDaichoIdentifier(LasdecCode 市町村コード,
            HihokenshaNo 被保険者番号,
            RString 履歴番号,
            RString 枝番,
            Code 受給申請事由) {
        this.市町村コード = 市町村コード;
        this.被保険者番号 = 被保険者番号;
        this.履歴番号 = 履歴番号;
        this.枝番 = 枝番;
        this.受給申請事由 = 受給申請事由;
    }
}
