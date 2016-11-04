/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3031KyufuJissekiCareManagementHiEntity;

/**
 * 受給者給付実績台帳のケアマネジメント費RelateEntityクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CareManagementRelateEntity {

    private DbT3017KyufujissekiKihonEntity dbt3017;
    private DbT3031KyufuJissekiCareManagementHiEntity dbt3031;

}
