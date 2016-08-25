/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jyukyusyajoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合照会_受給認定情報Entityです。
 *
 * @reamsid_L DBU-4100-030 xuyannan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyuNinteiJohoRelateEntity {

    private RString 要介護認定状態区分コード;
    private RString 認定有効期間開始年月日;
    private RString 受給申請年月日;
    private RString 受給申請事由;
    private boolean 旧措置者フラグ;
    private RString 認定有効期間終了年月日;
    private RString 認定年月日;
    private RString データ区分;
    private RString 認定申請区分_申請時コード;
    private RString 認定申請区分_法令コード;

}
