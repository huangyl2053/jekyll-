/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraiskkttcsrysmuke;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 償還払い支給（不支給）決定通知書（利用者向け）に対するEntityクラス
 *
 * @reamsid_L DBC-1000-050 chengsanyuan
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanBaraiSkKtTcsRysmukeEntity implements Serializable {

    private HihokenshaNo hihokenshaNo;
    private RString keiyakuJigyoshaNo;
    private FlexibleYearMonth shikyushinseiServiceYM;
    private RString shikyushinseiSeiriNo;
    private AtenaMeisho keiyakuJigyoshaName;
    private YubinNo keiyakuJigyoshaYubinNo;
    private AtenaJusho keiyakuJigyoshaJusho;
    private AtenaMeisho keiyakuDaihyoshaName;
    private TelNo keiyakuJigyoshaTelNo;
}
