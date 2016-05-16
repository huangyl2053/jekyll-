/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.common;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmen;

/**
 *
 * 各種減免情報です。
 *
 * @reamsid_L DBD-4342-020 wangjie2
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class VariousReductionInformation {

    private final List<FutanGendogakuNintei> 介護保険負担限度額認定の情報List;
    private final List<RiyoshaFutangakuGengaku> 利用者負担額減額の情報List;
    private final List<HomonKaigoRiyoshaFutangakuGengaku> 訪問介護利用者負担額減額の情報List;
    private final List<ShakaifukuRiyoshaFutanKeigen> 社会福祉法人等利用者負担軽減の情報List;
    private final List<TokubetsuchiikiKasanGemmen> 特別地域加算減免の情報List;

    /**
     * コンストラクタです。
     *
     * @param 介護保険負担限度額認定の情報List 介護保険負担限度額認定の情報List
     * @param 利用者負担額減額の情報List 利用者負担額減額の情報List
     * @param 訪問介護利用者負担額減額の情報List 訪問介護利用者負担額減額の情報List
     * @param 社会福祉法人等利用者負担軽減の情報List 社会福祉法人等利用者負担軽減の情報List
     * @param 特別地域加算減免の情報List 特別地域加算減免の情報List
     */
    public VariousReductionInformation(List<FutanGendogakuNintei> 介護保険負担限度額認定の情報List,
            List<RiyoshaFutangakuGengaku> 利用者負担額減額の情報List,
            List<HomonKaigoRiyoshaFutangakuGengaku> 訪問介護利用者負担額減額の情報List,
            List<ShakaifukuRiyoshaFutanKeigen> 社会福祉法人等利用者負担軽減の情報List,
            List<TokubetsuchiikiKasanGemmen> 特別地域加算減免の情報List) {
        this.介護保険負担限度額認定の情報List = 介護保険負担限度額認定の情報List;
        this.利用者負担額減額の情報List = 利用者負担額減額の情報List;
        this.訪問介護利用者負担額減額の情報List = 訪問介護利用者負担額減額の情報List;
        this.社会福祉法人等利用者負担軽減の情報List = 社会福祉法人等利用者負担軽減の情報List;
        this.特別地域加算減免の情報List = 特別地域加算減免の情報List;
    }
}
