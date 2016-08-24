/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jyukyusyajoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合照会_受給申請情報Entityです。
 *
 * @reamsid_L DBU-4100-030 xuyannan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyuShinseiJohoRelateEntity {

    private RString 受給申請年月日;
    private RString 受給申請事由;
    private RString 認定申請区分_申請時コード;

}
