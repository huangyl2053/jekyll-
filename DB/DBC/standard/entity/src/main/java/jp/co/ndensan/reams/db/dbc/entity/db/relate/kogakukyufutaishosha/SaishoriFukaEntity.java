/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishosha;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 再処理不可データエンティティ。
 *
 * @reamsid_L DBC-0980-360 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishoriFukaEntity {

    private DbT3055KogakuKyufuTaishoshaGokeiEntity 合計;
    private DbV1001HihokenshaDaichoEntity 被保険者;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private List<KyuufuTaishoshaHihokenshaEntity> 一時リスト;

}
