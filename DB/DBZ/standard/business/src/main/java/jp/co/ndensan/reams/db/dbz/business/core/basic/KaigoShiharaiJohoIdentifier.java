/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 介護支払情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class KaigoShiharaiJohoIdentifier implements Serializable {

    private final ShikibetsuCode 識別コード;
    private final KamokuCode 科目コード;
    private final FlexibleDate 決定年月日;

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     * @param 科目コード 科目コード
     * @param 決定年月日 決定年月日
     */
    public KaigoShiharaiJohoIdentifier(ShikibetsuCode 識別コード,
            KamokuCode 科目コード,
            FlexibleDate 決定年月日) {
        this.識別コード = 識別コード;
        this.科目コード = 科目コード;
        this.決定年月日 = 決定年月日;
    }
}
