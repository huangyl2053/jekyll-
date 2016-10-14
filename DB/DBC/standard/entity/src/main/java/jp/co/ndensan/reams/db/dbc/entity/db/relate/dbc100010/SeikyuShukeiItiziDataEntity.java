/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成取得Entity
 *
 * @reamsid_L DBC-2860-030 suguangjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikyuShukeiItiziDataEntity {

    private int 件数;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private JigyoshaNo 介護住宅改修理由書作成事業者番号;
}
