/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import lombok.Getter;
import lombok.Setter;

/**
 * 送付ファイル作成の保険者番号取得用Entityクラスです。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HokenshaNoShutokuEntity {

    private HokenshaNo hokenshaNo;
    private int count;
}
