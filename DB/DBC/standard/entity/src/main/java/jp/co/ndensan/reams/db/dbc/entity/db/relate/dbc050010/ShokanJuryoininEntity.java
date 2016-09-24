/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 償還受領委任払の口座情報SQL検索結果クラスです．
 *
 * @reamsid_L DBC-2180-030 donghj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanJuryoininEntity {

    private FurikomiDetailTempTableEntity 振込明細一時Entity;
    private DbT3077JuryoininKeiyakuJigyoshaEntity 受領委任契約事業者Entity;

}
