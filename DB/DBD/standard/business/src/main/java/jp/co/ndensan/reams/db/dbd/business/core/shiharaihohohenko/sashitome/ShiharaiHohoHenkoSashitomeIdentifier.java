/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.sashitome;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更差止の識別子です。
 *
 * @reamsid_L DBD-9999-013 huangh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShiharaiHohoHenkoSashitomeIdentifier implements Serializable {

    private final ShoKisaiHokenshaNo 証記載保険者番号;
    private final HihokenshaNo 被保険者番号;
    private final RString 管理区分;
    private final int 履歴番号;
    private final RString 情報分類区分;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 管理区分 管理区分
     * @param 履歴番号 履歴番号
     * @param 情報分類区分 情報分類区分
     * @param 連番 連番
     */
    public ShiharaiHohoHenkoSashitomeIdentifier(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            RString 管理区分,
            int 履歴番号,
            RString 情報分類区分,
            int 連番) {
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.管理区分 = 管理区分;
        this.履歴番号 = 履歴番号;
        this.情報分類区分 = 情報分類区分;
        this.連番 = 連番;
    }
    private static final long serialVersionUID = -2006595235583368078L;
}
