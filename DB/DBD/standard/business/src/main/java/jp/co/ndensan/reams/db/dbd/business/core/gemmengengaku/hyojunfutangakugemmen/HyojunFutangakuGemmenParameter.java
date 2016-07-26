/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.hyojunFutangakuGemmen;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 標準負担額減免申請のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-3700-010 liuwei2
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HyojunFutangakuGemmenParameter {

    private final HihokenshaNo 被保険者番号;
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

    public HyojunFutangakuGemmenParameter(HihokenshaNo 被保険者番号, ShoKisaiHokenshaNo shoKisaiHokenshaNo, HihokenshaNo hihokenshaNo, int rirekiNo, RString shinseiJiyu, RString gengakuKubun, Decimal gengakugoKingaku, RString hyojunFutanKubun, FlexibleDate shinseiYMD, RString ketteiKubun, FlexibleDate ketteiYMD, FlexibleDate tekiyoKaishiYMD, FlexibleDate tekiyoShuryoYMD, RString hiShoninRiyu) {
        this.被保険者番号 = 被保険者番号;
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

    public HyojunFutangakuGemmenParameter(HihokenshaNo hihokenshaNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
