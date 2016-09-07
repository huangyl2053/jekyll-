/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.choshuhoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import lombok.Value;

/**
 * 介護徴収方法の識別子です。
 */
@Value
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChoshuHohoIdentifier implements Serializable {

    private final FlexibleYear 賦課年度;
    private final HihokenshaNo 被保険者番号;
    private final int 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 賦課年度
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     */
    public ChoshuHohoIdentifier(FlexibleYear 賦課年度,
            HihokenshaNo 被保険者番号,
            int 履歴番号) {
        this.賦課年度 = 賦課年度;
        this.被保険者番号 = 被保険者番号;
        this.履歴番号 = 履歴番号;
    }
}
