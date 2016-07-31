/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * ビジネス設計_DBC0120031_サービス利用票情報 給付計画自己作成Entityオブジェクト
 *
 * @reamsid_L DBC-1930-060 xupeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServiceTypeDetails {

    private Decimal サービス単位;
    private ServiceShuruiCode サービス種類コード;
    private ServiceKomokuCode サービス項目コード;
    private RString 限度額対象外フラグ;
}
