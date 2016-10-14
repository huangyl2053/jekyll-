/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogakunintei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 負担限度額認定バッチ結果
 *
 * @reamsid_L DBD-3710-080 xuejm
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanGendogakuNinteiBatchResultEntity {

    private DbT4018KaigoHokenFutanGendogakuNinteiEntity 負担限度額認定;
    private List<DbT4010GemmenGengakuShinseiEntity> 減免減額申請;
    private UaFt200FindShikibetsuTaishoEntity 個人;
}
