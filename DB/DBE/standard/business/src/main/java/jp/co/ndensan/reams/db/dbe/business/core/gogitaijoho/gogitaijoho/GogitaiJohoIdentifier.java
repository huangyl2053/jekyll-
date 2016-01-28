/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 合議体情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class GogitaiJohoIdentifier implements Serializable {

    private static final long serialVersionUID = -4747726331880812879L;
    private final int 合議体番号;
    private final FlexibleDate 合議体有効期間開始年月日;

    /**
     * コンストラクタです。
     *
     * @param 合議体番号 合議体番号
     * @param 合議体有効期間開始年月日 合議体有効期間開始年月日
     */
    public GogitaiJohoIdentifier(int 合議体番号,
            FlexibleDate 合議体有効期間開始年月日) {
        this.合議体番号 = 合議体番号;
        this.合議体有効期間開始年月日 = 合議体有効期間開始年月日;
    }

}
