/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.viewbox.idotaishoshaichiranpar;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import lombok.Getter;

/**
 * 通知書発行後異動把握viewStateのParameter
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class IdoTaishoshaIchiranPar implements Serializable {

    public IdoTaishoshaIchiranPar(FlexibleYear fukaNendo, HihokenshaNo hihokenshaNo, TsuchishoNo tsuchishoNo, ShikibetsuCode shikibetsuCode) {
        this.fukaNendo = fukaNendo;
        this.hihokenshaNo = hihokenshaNo;
        this.tsuchishoNo = tsuchishoNo;
        this.shikibetsuCode = shikibetsuCode;
    }

    private final FlexibleYear fukaNendo;
    private final HihokenshaNo hihokenshaNo;
    private final TsuchishoNo tsuchishoNo;
    private final ShikibetsuCode shikibetsuCode;

}
