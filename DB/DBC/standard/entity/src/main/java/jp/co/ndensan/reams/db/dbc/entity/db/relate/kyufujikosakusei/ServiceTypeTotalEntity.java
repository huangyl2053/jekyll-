/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * ビジネス設計_DBC0120031_サービス利用票情報 給付計画自己作成Resultオブジェクト
 *
 * @reamsid_L DBC-1930-060 xupeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServiceTypeTotalEntity {

    private RString サービス種類略称;
    private Decimal 支給限度単位数;
    private ServiceShuruiCode サービス種類コード;
}
