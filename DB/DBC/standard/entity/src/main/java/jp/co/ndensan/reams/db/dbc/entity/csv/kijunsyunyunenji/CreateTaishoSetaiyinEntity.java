/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;

/**
 * 帳票出力、CSV作成 Entityクラスです
 *
 * @reamsid_L DBC-4630-030 jiangwenkai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CreateTaishoSetaiyinEntity {

    private TaishoSetaiinEntity 対象世帯員;
    private UaFt250FindAtesakiEntity 宛先;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
}
