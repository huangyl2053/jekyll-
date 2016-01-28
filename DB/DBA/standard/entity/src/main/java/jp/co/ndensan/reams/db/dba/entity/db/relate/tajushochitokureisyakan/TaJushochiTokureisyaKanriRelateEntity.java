/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.tajushochitokureisyakan;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 他住所地特例者管理のRelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaJushochiTokureisyaKanriRelateEntity {

    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate idoYMD;
    private RString edaNo;
    private RString idoJiyuCode;
    private LasdecCode shichosonCode;
    private RString tekiyoJiyuCode;
    private FlexibleDate tekiyoYMD;
    private FlexibleDate tekiyoTodokedeYMD;
    private FlexibleDate tekiyoUketsukeYMD;
    private RString kaijoJiyuCode;
    private FlexibleDate kaijoYMD;
    private FlexibleDate kaijoTodokedeYMD;
    private FlexibleDate kaijoUketsukeYMD;
    private ShoKisaiHokenshaNo sochiHokenshaNo;
    private HihokenshaNo sochiHihokenshaNo;
    private FlexibleDate tatokuRenrakuhyoHakkoYMD;
    private FlexibleDate shisetsuTaishoTsuchiHakkoYMD;
    private FlexibleDate shisetsuHenkoTsuchiHakkoYMD;
    private Decimal rirekiNo;
    private RString daichoShubetsu;
    private RString nyushoShisetsuShurui;
    private JigyoshaNo nyushoShisetsuCode;
    private FlexibleDate nyushoYMD;
    private FlexibleDate taishoYMD;
    private AtenaMeisho jigyoshaName;

}
