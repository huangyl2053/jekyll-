/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.kyotakuservicekeikakuinfo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 居宅サービス計画情報を取得するのエンティティクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyotakuServiceKeikakuInfoRelateEntity {

    private HihokenshaNo hihokenshano;
    private FlexibleYearMonth taishoYM;
    private Decimal rirekiNo;
    private FlexibleDate tekiyoKaishiYMD;
    private FlexibleDate tekiyoShuryoYMD;
    private RString sakuseiKubunCode;
    private JigyoshaNo keikakuJigyoshaNo;
    private JigyoshaNo itakusakiJigyoshaNo;
    private RString jigyoshaName;
}
