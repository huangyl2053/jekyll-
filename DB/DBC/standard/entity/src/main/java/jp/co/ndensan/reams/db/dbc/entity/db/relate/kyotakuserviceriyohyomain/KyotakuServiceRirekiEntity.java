/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakuserviceriyohyomain;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居宅サービスentityです。
 *
 * @reamsid_L DBC-1930-030 huzongcheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyotakuServiceRirekiEntity {

    private HihokenshaNo hihokenshaNo;
    private FlexibleYearMonth taishoYM;
    private int rirekiNo;
    private FlexibleDate todokedeYMD;
    private RString sakuseiKubunCode;
    private FlexibleDate tekiyoKaishiYMD;
    private FlexibleDate tekiyoShuryoYMD;
    private FlexibleDate keikakuHenkoYMD;
    private int rirekiSort;
    private RString sogoJigyoKubun;

}
