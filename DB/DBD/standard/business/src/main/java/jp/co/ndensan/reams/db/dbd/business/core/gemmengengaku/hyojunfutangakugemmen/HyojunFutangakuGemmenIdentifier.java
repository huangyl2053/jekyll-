/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.hyojunfutangakugemmen;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 標準負担額減免の識別子です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class HyojunFutangakuGemmenIdentifier implements Serializable {

    private final ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private final HihokenshaNo hihokenshaNo;
    private final int rirekiNo;
    private final RString shinseiJiyu;
    private final RString gengakuKubun;
    private final Decimal gengakugoKingaku;
    private final RString hyojunFutanKubun;
    private final FlexibleDate shinseiYMD;
    private final RString ketteiKubun;
    private final FlexibleDate ketteiYMD;
    private final FlexibleDate tekiyoKaishiYMD;
    private final FlexibleDate tekiyoShuryoYMD;
    private final RString hiShoninRiyu;

    /**
     * コンストラクタです。
     *
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     * @param hihokenshaNo hihokenshaNo
     * @param rirekiNo rirekiNo
     * @param shinseiJiyu shinseiJiyu
     * @param gengakuKubun gengakuKubun
     * @param gengakugoKingaku gengakugoKingaku
     * @param hyojunFutanKubun hyojunFutanKubun
     * @param shinseiYMD shinseiYMD
     * @param ketteiKubun ketteiKubun
     * @param ketteiYMD ketteiYMD
     * @param tekiyoKaishiYMD tekiyoKaishiYMD
     * @param tekiyoShuryoYMD tekiyoShuryoYMD
     * @param hiShoninRiyu hiShoninRiyu
     */
    public HyojunFutangakuGemmenIdentifier(ShoKisaiHokenshaNo shoKisaiHokenshaNo,
            HihokenshaNo hihokenshaNo,
            int rirekiNo,
            RString shinseiJiyu,
            RString gengakuKubun,
            Decimal gengakugoKingaku,
            RString hyojunFutanKubun,
            FlexibleDate shinseiYMD,
            RString ketteiKubun,
            FlexibleDate ketteiYMD,
            FlexibleDate tekiyoKaishiYMD,
            FlexibleDate tekiyoShuryoYMD,
            RString hiShoninRiyu) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
        this.hihokenshaNo = hihokenshaNo;
        this.rirekiNo = rirekiNo;
        this.shinseiJiyu = shinseiJiyu;
        this.gengakuKubun = gengakuKubun;
        this.gengakugoKingaku = gengakugoKingaku;
        this.hyojunFutanKubun = hyojunFutanKubun;
        this.shinseiYMD = shinseiYMD;
        this.ketteiKubun = ketteiKubun;
        this.ketteiYMD = ketteiYMD;
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
        this.hiShoninRiyu = hiShoninRiyu;
    }
}
