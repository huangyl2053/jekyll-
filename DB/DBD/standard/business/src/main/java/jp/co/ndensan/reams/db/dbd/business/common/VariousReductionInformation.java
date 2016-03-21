/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.common;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShakaiFukushiHojinRiyoshaFutanKeigen;

/**
 *
 * 各種減免情報です。
 */
public class VariousReductionInformation {

    private final List<ShakaiFukushiHojinRiyoshaFutanKeigen> 社会福祉法人等利用者負担軽減の情報List;

    public VariousReductionInformation(List<ShakaiFukushiHojinRiyoshaFutanKeigen> 社会福祉法人等利用者負担軽減の情報List) {
        this.社会福祉法人等利用者負担軽減の情報List = 社会福祉法人等利用者負担軽減の情報List;
    }

    /**
     * 受給申請年月日を返します。
     *
     * @return 受給申請年月日
     */
    public List<ShakaiFukushiHojinRiyoshaFutanKeigen> get社会福祉法人等利用者負担軽減の情報() {
        return 社会福祉法人等利用者負担軽減の情報List;
    }

}
