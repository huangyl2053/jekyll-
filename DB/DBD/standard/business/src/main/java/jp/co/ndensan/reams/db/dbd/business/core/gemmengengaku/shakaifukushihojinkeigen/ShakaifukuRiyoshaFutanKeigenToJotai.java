/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shakaifukushihojinkeigen;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 社会福祉法人等利用者負担軽減申請の情報と状態を管理するクラスです。
 *
 * @reamsid_L DBD-3660-010 wangjie2
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShakaifukuRiyoshaFutanKeigenToJotai implements Serializable {

    private final ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減情報;
    private final RString 状態;
    private final int 新履歴番号;

    /**
     * コンストラクタです。<br/>
     * 社会福祉法人等利用者負担軽減の新規作成時に使用します。
     *
     * @param 社会福祉法人等利用者負担軽減情報 社会福祉法人等利用者負担軽減情報
     * @param 状態 状態
     * @param 新履歴番号 新履歴番号
     */
    public ShakaifukuRiyoshaFutanKeigenToJotai(ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減情報, RString 状態, int 新履歴番号) {
        this.社会福祉法人等利用者負担軽減情報 = 社会福祉法人等利用者負担軽減情報;
        this.状態 = 状態;
        this.新履歴番号 = 新履歴番号;
    }

}
