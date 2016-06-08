/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 再審査決定通知書明細情報
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaMeisaiPsmEntity {

    private FlexibleYearMonth toriatsukaiYM;
    private int rirekiNo;
    private JigyoshaNo jigyoshoNo;
    private RString jigyoshoName;
    private HihokenshaNo hiHokenshaNo;
    private RString hiHokenshaName;
    private FlexibleYearMonth serviceTeikyoYM;
    private ServiceShuruiCode serviceShuruiCode;
    private RString serviceShuruiName;
    private RString moushitateJiyuCode;
    private RString moushitateJiyu;
    private RString saishinsaResultCode;
    private Decimal toshoSeikyuTanisu;
    private Decimal genshinSeikyuTanisu;
    private Decimal moushitateTanisu;
    private Decimal ketteiTanisu;
    private Decimal choseiTanisu;
    private Decimal hokenshaFutangaku;
    private ShikibetsuCode shikibetsuCode;
    private RString juminShubetsuCode;
    private RString tsushomei;
    private AtenaMeisho meisho;
    private AtenaMeisho kanjiShimei;

}
