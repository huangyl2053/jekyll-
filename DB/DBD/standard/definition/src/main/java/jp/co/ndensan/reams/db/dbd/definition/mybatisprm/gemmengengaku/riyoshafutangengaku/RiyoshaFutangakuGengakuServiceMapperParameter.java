/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.riyoshafutangengaku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用者負担額減額の情報を取得するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-3600-030 xuyue
 */
@lombok.Getter
public class RiyoshaFutangakuGengakuServiceMapperParameter {

    private final RString 減免減額種類;
    private final HihokenshaNo 被保険者番号;

    private RiyoshaFutangakuGengakuServiceMapperParameter(RString 減免減額種類, HihokenshaNo 被保険者番号) {
        this.減免減額種類 = 減免減額種類;
        this.被保険者番号 = 被保険者番号;
    }

    public static RiyoshaFutangakuGengakuServiceMapperParameter createParameter(RString 減免減額種類, HihokenshaNo 被保険者番号) {
        return new RiyoshaFutangakuGengakuServiceMapperParameter(減免減額種類, 被保険者番号);
    }
}
