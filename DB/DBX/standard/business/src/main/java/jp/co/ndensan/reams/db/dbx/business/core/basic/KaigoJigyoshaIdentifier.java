/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Value;

/**
 * 介護事業者の識別子です。
 *
 * @reamsid_L DBX-9999-022 tianshuai
 */
@Value
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoJigyoshaIdentifier implements Serializable {

    private static final long serialVersionUID = -4872959460293809687L;

    private final JigyoshaNo 事業者番号;
    private final FlexibleDate 有効開始日;

    /**
     * コンストラクタです。
     *
     * @param 事業者番号 事業者番号
     * @param 有効開始日 有効開始日
     */
    public KaigoJigyoshaIdentifier(JigyoshaNo 事業者番号,
            FlexibleDate 有効開始日) {
        this.事業者番号 = 事業者番号;
        this.有効開始日 = 有効開始日;
    }
}
