/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import lombok.Getter;
import lombok.Setter;

/**
 * エラー登録するSQL検索結果クラスです．
 *
 * @reamsid_L DBC-5010-030 donghj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class EraTourokuEntity {

    private HihokenshaNo 被保険者番号;

}
