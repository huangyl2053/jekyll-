/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Value;

/**
 * 受給者限度額管理の識別子です。
 */
@Value
public class JukyushaGendoGakuKanriIdentifier implements Serializable {

    private final HihokenshaNo 被保険者番号;
    private final RString 識別区分;
    private final FlexibleYearMonth 有効開始年月;
    private final int 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別区分 識別区分
     * @param 有効開始年月 有効開始年月
     * @param 履歴番号 履歴番号
     */
    public JukyushaGendoGakuKanriIdentifier(HihokenshaNo 被保険者番号,
            RString 識別区分,
            FlexibleYearMonth 有効開始年月,
            int 履歴番号) {
        this.被保険者番号 = 被保険者番号;
        this.識別区分 = 識別区分;
        this.有効開始年月 = 有効開始年月;
        this.履歴番号 = 履歴番号;
    }
}
