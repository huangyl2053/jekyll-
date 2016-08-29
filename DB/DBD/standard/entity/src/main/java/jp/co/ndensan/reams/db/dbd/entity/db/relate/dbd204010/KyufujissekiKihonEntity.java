/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd204010;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績キー 給付実績基本entityクラスです。
 *
 * @reamsid_L DBD-3880-030 jinge
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufujissekiKihonEntity {

    private NyuryokuShikibetsuNo inputShikibetsuNo;
    private HokenshaNo shokisaiHokenshaNo;
    private HihokenshaNo hihokenshaNo;
    private FlexibleYearMonth shinsaYM;
    private FlexibleYearMonth serviceTeikyoYM;
    private JigyoshaNo jigyoshoNo;
    private RString toshiNo;
    private RString kyufuSakuseiKubunCode;
}
