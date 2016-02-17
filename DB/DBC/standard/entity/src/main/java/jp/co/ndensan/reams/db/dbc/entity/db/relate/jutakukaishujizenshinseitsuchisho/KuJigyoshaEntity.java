/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujizenshinseitsuchisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業者情報entity
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KuJigyoshaEntity {

    private HihokenshaNo hihokenshaNo;
    private RString keiyakuJigyoshaNo;
    private FlexibleYearMonth shikyushinseiServiceYM;
    private RString shikyushinseiSeiriNo;
    private AtenaMeisho keiyakuJigyoshaName;
    private AtenaMeisho keiyakuDaihyoshaName;
    private YubinNo keiyakuJigyoshaYubinNo;
    private AtenaJusho keiyakuJigyoshaJusho;
    private TelNo keiyakuJigyoshaTelNo;

}
