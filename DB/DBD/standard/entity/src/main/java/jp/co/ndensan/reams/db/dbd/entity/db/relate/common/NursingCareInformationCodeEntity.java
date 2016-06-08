/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.common;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 要介護認定情報コードです。
 *
 * @reamsid_L DBD-4342-020 wangjie2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NursingCareInformationCodeEntity {

    private RString 申請状況区分;
    private FlexibleDate 受給申請年月日;
    private Code 受給申請事由;
    private boolean 旧措置者フラグ;
    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;
    private FlexibleDate 認定年月日;
    private Code 厚労省IF識別コード;
    private Code 要介護認定状態区分コード;

}
