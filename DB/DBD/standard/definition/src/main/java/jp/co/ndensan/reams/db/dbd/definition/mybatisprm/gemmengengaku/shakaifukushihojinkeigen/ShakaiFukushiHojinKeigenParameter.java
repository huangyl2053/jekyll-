/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.shakaifukushihojinkeigen;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 社会福祉法人等利用者負担軽減申請（画面）のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-3660-030 wangjie2
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShakaiFukushiHojinKeigenParameter {

    private final HihokenshaNo 被保険者番号;
    private final RString 減免減額種類コード;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 減免減額種類コード 減免減額種類コード
     */
    public ShakaiFukushiHojinKeigenParameter(HihokenshaNo 被保険者番号, RString 減免減額種類コード) {
        this.被保険者番号 = 被保険者番号;
        this.減免減額種類コード = 減免減額種類コード;
    }

}
