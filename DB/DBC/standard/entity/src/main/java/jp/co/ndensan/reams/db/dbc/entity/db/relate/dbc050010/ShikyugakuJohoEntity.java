/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010;

import java.util.List;

/**
 * 様式番号別支給金額情報取得の送付対象データエンティティクラスです
 *
 * @reamsid_L DBC-2180-030 tianyh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikyugakuJohoEntity {

    private int 名寄せ件数;
    private FurikomiDetailTempTableEntity 振込明細一時Entity;
    private List<YoushikiBangouBetuKingakuEntity> 様式番号別金額EntityList;
}
