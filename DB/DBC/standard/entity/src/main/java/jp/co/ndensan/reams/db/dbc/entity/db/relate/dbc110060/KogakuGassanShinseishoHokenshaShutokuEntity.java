/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;

/**
 * 高額合算支給申請書情報作成の保険者番号の取得エンティティクラスです。
 *
 * @reamsid_L DBC-2630-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanShinseishoHokenshaShutokuEntity {

    private int 件数;
    private HokenshaNo 保険者番号;
    private int レコード件数;

}
