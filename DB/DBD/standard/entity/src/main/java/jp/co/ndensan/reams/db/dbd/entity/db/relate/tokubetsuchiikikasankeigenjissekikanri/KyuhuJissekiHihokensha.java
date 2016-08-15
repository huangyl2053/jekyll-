/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.tokubetsuchiikikasankeigenjissekikanri;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績被保険者Entityクラスです。
 *
 * @reamsid_L DBD-3880-060 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
public class KyuhuJissekiHihokensha {

    private HihokenshaNo 被保険者番号;
    private FlexibleYear サービス提供年月;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private FlexibleYear 審査年月;
    private RString 給付区分;
    private boolean exists社福軽減給付実績;
    private boolean exists有効特地減免;
    private List<KyuhuJissekiMeisai> 給付実績明細リスト;
    private KyuhuJissekiShukei 給付実績集計;
}
