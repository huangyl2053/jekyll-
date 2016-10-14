/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.futangendogakunintei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogakunintei.FutanGendogakuNinteiBatchResultEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 一括承認結果一覧のビジネス設計です。
 *
 * @reamsid_L DBD-3710-080 xuejm
 */
@lombok.Getter
@lombok.Setter
public class FutanGendogakuNinteiBatchResult implements Serializable {

    private final FutanGendogakuNintei 介護保険負担限度額認定の情報;
    private final IKojin 個人;

    public FutanGendogakuNinteiBatchResult(FutanGendogakuNinteiBatchResultEntity entity) {

        this.個人 = get個人entity(entity);
        this.介護保険負担限度額認定の情報 = get介護保険負担限度額認定の情報entity(entity);
    }

    private IKojin get個人entity(FutanGendogakuNinteiBatchResultEntity entity) {
        UaFt200FindShikibetsuTaishoEntity UaFt200entity = entity.get個人();
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(UaFt200entity);
        return kojin;
    }

    private FutanGendogakuNintei get介護保険負担限度額認定の情報entity(FutanGendogakuNinteiBatchResultEntity entity) {
        FutanGendogakuNinteiEntity futanentity = new FutanGendogakuNinteiEntity();
        futanentity.set介護保険負担限度額認定Entity(entity.get負担限度額認定());
        futanentity.set減免減額申請Entity(entity.get減免減額申請());
        FutanGendogakuNintei result = new FutanGendogakuNintei(futanentity);
        return result;

    }

}
