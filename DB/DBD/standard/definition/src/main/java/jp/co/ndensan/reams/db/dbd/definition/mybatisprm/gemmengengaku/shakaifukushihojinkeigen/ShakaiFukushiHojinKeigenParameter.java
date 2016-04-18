/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.shakaifukushihojinkeigen;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
    private final FlexibleDate 年度開始日;
    private final FlexibleDate 年度終了日;
    private final RString 確認番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 減免減額種類コード 減免減額種類コード
     */
    public ShakaiFukushiHojinKeigenParameter(HihokenshaNo 被保険者番号, RString 減免減額種類コード) {
        this.被保険者番号 = 被保険者番号;
        this.減免減額種類コード = 減免減額種類コード;
        this.年度開始日 = FlexibleDate.EMPTY;
        this.年度終了日 = FlexibleDate.EMPTY;
        this.確認番号 = RString.EMPTY;
    }

    /**
     * コンストラクタです。
     *
     * @param 年度開始日 年度開始日
     * @param 年度終了日 年度終了日
     * @param 確認番号 確認番号
     */
    public ShakaiFukushiHojinKeigenParameter(FlexibleDate 年度開始日, FlexibleDate 年度終了日, RString 確認番号) {
        this.被保険者番号 = HihokenshaNo.EMPTY;
        this.減免減額種類コード = RString.EMPTY;
        this.年度開始日 = 年度開始日;
        this.年度終了日 = 年度終了日;
        this.確認番号 = 確認番号;
    }

}
