/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.kaigohohenshisetsu;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 介護保険入退所履歴のRelateEntityクラスです。
 *
 * @reamsid_L DBA-0360-050 wangkun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoHohenShisetsuRelateEntity {

    private ShikibetsuCode shikibetsuCode;
    private Decimal rirekiNo;
    private LasdecCode shichosonCode;
    private RString daichoShubetsu;
    private RString nyushoShisetsuShurui;
    private JigyoshaNo nyushoShisetsuCode;
    private FlexibleDate nyushoShoriYMD;
    private FlexibleDate nyushoYMD;
    private FlexibleDate taishoShoriYMD;
    private FlexibleDate taishoYMD;
    private RString roomKigoNo;
    private RString jigyoshaName;
    private HokenshaNo hokenshaNo;
}
