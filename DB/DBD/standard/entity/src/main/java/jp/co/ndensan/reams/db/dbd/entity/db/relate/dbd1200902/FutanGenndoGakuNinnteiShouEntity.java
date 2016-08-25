/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 負担限度額認定の認定証発行のSQL結果クラスです。
 *
 * @reamsid_L DBD-3981-030 jinge
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class FutanGenndoGakuNinnteiShouEntity {

    private FutanGendogakuNinteiEntity 介護保険負担限度額認定;
    private UaFt200FindShikibetsuTaishoEntity psmEntity;
    private UaFt250FindAtesakiEntity atesakiEntity;
    private ShikibetsuCode shikibetsuCode;
    private LasdecCode shichosonCode;
}
