/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Value;

/**
 * 介護事業者の識別子です。
 */
@Value
public class KaigoJigyoshaIdentifier implements Serializable {

    private final KaigoJigyoshaNo 事業者番号;
    private final FlexibleDate 有効開始日;

    /**
     * コンストラクタです。
     *
     * @param 事業者番号 事業者番号
     * @param 有効開始日 有効開始日
     */
    public KaigoJigyoshaIdentifier(KaigoJigyoshaNo 事業者番号,
            FlexibleDate 有効開始日) {
        this.事業者番号 = 事業者番号;
        this.有効開始日 = 有効開始日;
    }
}
