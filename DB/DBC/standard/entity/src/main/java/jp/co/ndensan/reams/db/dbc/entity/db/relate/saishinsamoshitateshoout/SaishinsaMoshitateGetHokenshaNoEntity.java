/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護給付費再審査申立書情報作成の保険者番号の取得エンティティクラスです。
 *
 * @reamsid_L DBC-2540-030 liuhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaMoshitateGetHokenshaNoEntity {

    private HokenshaNo 保険者番号;
    private int レコード件数;

}
