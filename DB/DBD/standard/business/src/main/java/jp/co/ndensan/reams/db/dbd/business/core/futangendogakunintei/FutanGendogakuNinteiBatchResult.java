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

/**
 * 一括承認結果一覧のビジネス設計です。
 *
 * @reamsid_L DBD-3710-080 xuejm
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class FutanGendogakuNinteiBatchResult implements Serializable {

    private final FutanGendogakuNintei 介護保険負担限度額認定の情報;
    private final IKojin 個人;

    /**
     * コンストラクタです.
     *
     * @param entity FutanGendogakuNinteiBatchResultEntity
     */
    public FutanGendogakuNinteiBatchResult(FutanGendogakuNinteiBatchResultEntity entity) {
        FutanGendogakuNinteiEntity futanentity = new FutanGendogakuNinteiEntity();
        futanentity.set介護保険負担限度額認定Entity(entity.get負担限度額認定());
        futanentity.set減免減額申請Entity(entity.get減免減額申請());
        this.個人 = ShikibetsuTaishoFactory.createKojin(entity.get個人());
        this.介護保険負担限度額認定の情報 = new FutanGendogakuNintei(futanentity);
    }
}
