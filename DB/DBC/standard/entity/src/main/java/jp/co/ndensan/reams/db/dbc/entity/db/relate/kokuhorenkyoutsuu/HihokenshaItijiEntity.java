/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyoutsuu;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 被保険者一時TBLエンティティです。
 *
 * @reamsid_L DBC-0980-560 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaItijiEntity implements Serializable {

    private int meisaiRenban;
    private HokenshaNo shoHokenshaNo;
    private HihokenshaNo orgHihokenshaNo;
    private FlexibleDate serviceTeikyoYmd;
    private RString orgHihokenshaKanaShimei;
    private RString orgHihokenshaShimei;
    private LasdecCode oldShichosonCode;
    private HihokenshaNo henkanHihokenshaNo;
    private HihokenshaNo hihokenshaNo;
    private LasdecCode shichosonCode;
    private RString kannaiKangaiKubun;
    private RString yubinNo;
    private RString choikiCode;
    private RString gyoseikuCode;
    private RString gyoseikuMei;
    private RString jusho;
    private RString banchi;
    private RString katagaki;
    private RString kanaMeisho;
    private RString meisho;
    private RString shimei50onKana;
    private FlexibleDate shikakuShutokuYmd;
    private RString shikakuShutokuJiyuCode;
    private FlexibleDate shikakuSoshitsuYmd;
    private RString shikakuSoshitsuJiyuCode;
    private RString setaiShuyakuNo;
    private ShikibetsuCode shikibetsuCode;
}
