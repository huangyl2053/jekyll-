/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigokyufuhitaishoshatoroku;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 高額介護サービス費給付対象者登録のProcess用パラメータクラスです。
 *
 * @reamsid_L DBC-2010-040 huzongcheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKaigoKyufuhiTaishoshaTorokuProcessParameter implements IBatchProcessParameter {

    private RString menuId;
    private Long shuturyokuJunn;
    private FlexibleYearMonth ShinsaYMFrom;
    private FlexibleYearMonth ShinsaYMTo;
    private boolean shuturyokuFlg;

    /**
     * コンストラクタです。
     *
     *
     * @param menuId RString
     * @param shuturyokuJunn RString
     * @param ShinsaYMFrom FlexibleYearMonth
     * @param ShinsaYMTo FlexibleYearMonth
     * @param shuturyokuFlg boolean
     */
    public KogakuKaigoKyufuhiTaishoshaTorokuProcessParameter(
            RString menuId,
            Long shuturyokuJunn,
            FlexibleYearMonth ShinsaYMFrom,
            FlexibleYearMonth ShinsaYMTo,
            boolean shuturyokuFlg) {
        this.menuId = menuId;
        this.shuturyokuJunn = shuturyokuJunn;
        this.ShinsaYMFrom = ShinsaYMFrom;
        this.ShinsaYMTo = ShinsaYMTo;
        this.shuturyokuFlg = shuturyokuFlg;
    }

    /**
     * コンストラクタです。
     *
     *
     */
    public KogakuKaigoKyufuhiTaishoshaTorokuProcessParameter() {
    }

}
