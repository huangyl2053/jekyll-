/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.gmmengngakurrekijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * GemmenGengakuRirekiJyoho_社会福祉法人等利用者負担軽減履歴情報 Entityのクラスです。
 *
 * @reamsid_L DBC-4350-090 liuxiaoyu
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShakaiFukushiHojinRiyoshaFutanKeigenJyohoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private RString 減免_減額種類;
    private FlexibleDate 適用開始日;
    private FlexibleDate 適用終了日;
    private RString 軽減率;

    /**
     * コンストラクタです。
     *
     * @param 減免_減額種類 RString
     * @param 適用開始日 TextBoxFlexibleDate
     * @param 適用終了日 TextBoxFlexibleDate
     * @param 軽減率 RString
     */
    public ShakaiFukushiHojinRiyoshaFutanKeigenJyohoEntity(
            RString 減免_減額種類,
            FlexibleDate 適用開始日,
            FlexibleDate 適用終了日,
            RString 軽減率) {
        this.減免_減額種類 = 減免_減額種類;
        this.適用開始日 = 適用開始日;
        this.適用終了日 = 適用終了日;
        this.軽減率 = 軽減率;
    }
}
