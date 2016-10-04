/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteikekkaout;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額サービス費給付判定結果情報作成の保険者番号の取得エンティティクラスです。
 *
 * @reamsid_L DBC-2610-030 liuhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuServicehiHanteiGetHokenshaNoEntity {

    private HokenshaNo 保険者番号;
    private int レコード件数;

}
