/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.shisetsuidojoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 【共有子Div】施設入退 介護施設入退所情報entityです。
 *
 * @reamsid_L DBD-3560-120 wangjie2
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShisetsuIdoJohoEntity {

    private FlexibleDate 入所年月日;
    private FlexibleDate 退所年月日;
    private RString 入所施設種類;
    private RString 入所施設コード;
    private RString 事業者名称;
    private HihokenshaNo 転出先保険者番号;

}
