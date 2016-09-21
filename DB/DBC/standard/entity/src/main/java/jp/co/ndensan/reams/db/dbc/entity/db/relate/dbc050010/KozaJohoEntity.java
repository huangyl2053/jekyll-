/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.TokuteiKozaRelateEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 償還口座払の口座情報取得SQL検索結果クラスです．
 *
 * @reamsid_L DBC-5010-030 donghj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KozaJohoEntity {

    private FurikomiDetailTempTableEntity 振込明細一時Entity;
    private TokuteiKozaRelateEntity 口座;
    private DbT3077JuryoininKeiyakuJigyoshaEntity 受領委任契約事業者Entity;
}
