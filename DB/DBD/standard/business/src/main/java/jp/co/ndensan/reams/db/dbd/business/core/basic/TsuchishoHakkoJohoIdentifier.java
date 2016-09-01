/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 通知書発行情報の識別子です。
 *
 * @reamsid_L DBD-9999-010 chenxin
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class TsuchishoHakkoJohoIdentifier implements Serializable {

    private final ShinseishoKanriNo 申請書管理番号;
    private final Code 通知区分;
    private final RString 通知理由;
    private final FlexibleDate 通知年月日;
    private final FlexibleDate 通知開始年月日;
    private final FlexibleDate 通知終了年月日;
    private final FlexibleDate 通知区分期限;
    private final FlexibleDate 通知完了年月日;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 通知区分 通知区分
     * @param 通知理由 通知理由
     * @param 通知年月日 通知年月日
     * @param 通知開始年月日 通知開始年月日
     * @param 通知終了年月日 通知終了年月日
     * @param 通知区分期限 通知区分期限
     * @param 通知完了年月日 通知完了年月日
     */
    public TsuchishoHakkoJohoIdentifier(ShinseishoKanriNo 申請書管理番号,
            Code 通知区分,
            RString 通知理由,
            FlexibleDate 通知年月日,
            FlexibleDate 通知開始年月日,
            FlexibleDate 通知終了年月日,
            FlexibleDate 通知区分期限,
            FlexibleDate 通知完了年月日) {
        this.申請書管理番号 = 申請書管理番号;
        this.通知区分 = 通知区分;
        this.通知理由 = 通知理由;
        this.通知年月日 = 通知年月日;
        this.通知開始年月日 = 通知開始年月日;
        this.通知終了年月日 = 通知終了年月日;
        this.通知区分期限 = 通知区分期限;
        this.通知完了年月日 = 通知完了年月日;
    }
}
