/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.taino;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.DateDuration;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 滞納判定結果のクラスです。
 *
 * @reamsid_L DBD-3620-060 liangbc
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TainoHanteiResult implements Serializable {

    private FlexibleDate 滞納判定基準日;
    private FlexibleDate 最古滞納納期限;
    private DateDuration 滞納期間;
    private KyufugakuGengakuInfo 給付額減額;
    private List<TainoKiSummary> 滞納情報;
    private boolean is警告対象;
    private TainoHanteiKikan 滞納判定期間;

    /**
     * コンストラクタです。
     */
    public TainoHanteiResult() {
    }

    /**
     * コンストラクタです。
     *
     * @param 滞納判定基準日 滞納判定基準日
     * @param 最古滞納納期限 最古滞納納期限
     * @param 滞納期間 滞納期間
     * @param 給付額減額 給付額減額
     * @param 滞納情報 滞納情報
     * @param is警告対象 is警告対象
     * @param 滞納判定期間 滞納判定期間
     */
    public TainoHanteiResult(
            FlexibleDate 滞納判定基準日,
            FlexibleDate 最古滞納納期限,
            DateDuration 滞納期間,
            KyufugakuGengakuInfo 給付額減額,
            List<TainoKiSummary> 滞納情報,
            boolean is警告対象,
            TainoHanteiKikan 滞納判定期間) {
        this.滞納判定基準日 = 滞納判定基準日;
        this.最古滞納納期限 = 最古滞納納期限;
        this.滞納期間 = 滞納期間;
        this.給付額減額 = 給付額減額;
        this.滞納情報 = 滞納情報;
        this.is警告対象 = is警告対象;
        this.滞納判定期間 = 滞納判定期間;

    }
}
