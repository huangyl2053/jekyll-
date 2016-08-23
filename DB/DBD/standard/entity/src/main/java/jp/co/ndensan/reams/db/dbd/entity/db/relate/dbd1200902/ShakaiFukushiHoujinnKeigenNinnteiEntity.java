/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 社会福祉法人等軽減の認定証発行のSQL結果クラスです。
 *
 * @reamsid_L DBD-3981-030 jinge
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShakaiFukushiHoujinnKeigenNinnteiEntity {

    private DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity 社会福祉法人等利用者負担軽減Entity;
    private DbT4010GemmenGengakuShinseiEntity 減免減額申請Entity;
    private UaFt200FindShikibetsuTaishoEntity psmEntity;
    private UaFt250FindAtesakiEntity atesakiEntity;
}
