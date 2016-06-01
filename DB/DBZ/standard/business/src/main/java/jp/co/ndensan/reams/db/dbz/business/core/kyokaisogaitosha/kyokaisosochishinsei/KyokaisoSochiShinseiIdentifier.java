/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.kyokaisogaitosha.kyokaisosochishinsei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 境界層措置申請の識別子です。
 *
 * @reamsid_L DBA-9999-013 huangh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class KyokaisoSochiShinseiIdentifier implements Serializable {

    private final HihokenshaNo 被保険者番号;
    private final Decimal 履歴番号;
    private final Decimal リンク番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @param リンク番号 リンク番号
     */
    public KyokaisoSochiShinseiIdentifier(HihokenshaNo 被保険者番号,
            Decimal 履歴番号,
            Decimal リンク番号) {
        this.被保険者番号 = 被保険者番号;
        this.履歴番号 = 履歴番号;
        this.リンク番号 = リンク番号;
    }
    private static final long serialVersionUID = -3587610170705762900L;
}
