/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710100;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;

/**
 * 過誤決定事業者のエンティティクラスです。
 *
 * @reamsid_L DBC-3094-020 qinzhen
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoKetteiJukyoshaRealEntity {

    private JigyoshaNo jigyoshaNo;
    private AtenaMeisho jigyoshaName;
}
