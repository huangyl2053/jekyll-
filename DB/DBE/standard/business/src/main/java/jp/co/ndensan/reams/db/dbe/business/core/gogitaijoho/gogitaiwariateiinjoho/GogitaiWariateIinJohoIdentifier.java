/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaiWariateIinJoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合議体割当委員情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class GogitaiWariateIinJohoIdentifier implements Serializable {

    private static final long serialVersionUID = 8705643393504237713L;
    private final int 合議体番号;
    private final FlexibleDate 合議体有効期間開始年月日;
    private final RString 介護認定審査会委員コード;

    /**
     * コンストラクタです。
     *
     * @param 合議体番号 合議体番号
     * @param 合議体有効期間開始年月日 合議体有効期間開始年月日
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     */
    public GogitaiWariateIinJohoIdentifier(int 合議体番号,
            FlexibleDate 合議体有効期間開始年月日,
            RString 介護認定審査会委員コード) {
        this.合議体番号 = 合議体番号;
        this.合議体有効期間開始年月日 = 合議体有効期間開始年月日;
        this.介護認定審査会委員コード = 介護認定審査会委員コード;
    }
}
