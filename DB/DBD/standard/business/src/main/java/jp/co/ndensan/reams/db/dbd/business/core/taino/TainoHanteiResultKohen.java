/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.taino;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 滞納判定結果のクラスです。
 *
 * @reamsid_L DBD-3620-060 liangbc
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TainoHanteiResultKohen implements Serializable {

    private FlexibleDate 滞納判定基準日;
    private FlexibleDate 最古滞納納期限;
    private KyufugakuGengakuInfo 給付額減額;
    private List<TainoKiSummary> 滞納情報;
    private boolean is警告対象;
    private TainoHanteiKikan 滞納判定期間;

    /**
     * コンストラクタです。
     */
    public TainoHanteiResultKohen() {
    }

    /**
     * コンストラクタです。
     *
     * @param 滞納判定期間
     */
    public TainoHanteiResultKohen(TainoHanteiResult 滞納判定期間) {
        this.滞納判定基準日 = 滞納判定期間.get滞納判定基準日();
        this.最古滞納納期限 = 滞納判定期間.get最古滞納納期限();
        this.給付額減額 = 滞納判定期間.get給付額減額();
        this.滞納情報 = 滞納判定期間.get滞納情報();
        this.is警告対象 = 滞納判定期間.is警告対象();
        this.滞納判定期間 = 滞納判定期間.get滞納判定期間();
    }

}
