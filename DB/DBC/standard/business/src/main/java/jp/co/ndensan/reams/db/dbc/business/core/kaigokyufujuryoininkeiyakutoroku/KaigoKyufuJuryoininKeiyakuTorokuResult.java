/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kaigokyufujuryoininkeiyakutoroku;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigokyufujuryoininkeiyakutoroku.KaigoKyufuJuryoininKeiyakuTorokuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigokyufujuryoininkeiyakutoroku.KaigoKyufuJuryoininKeiyakuTorokuRiyoshaEntity;

/**
 * 受領委任契約承認（不承認）確認書のResultクラスです。
 *
 * @reamsid_L DBC-2130-020 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoKyufuJuryoininKeiyakuTorokuResult {

    private KaigoKyufuJuryoininKeiyakuTorokuJigyoshaEntity 事業者用Entity;
    private KaigoKyufuJuryoininKeiyakuTorokuRiyoshaEntity 利用者向けEntity;
}
