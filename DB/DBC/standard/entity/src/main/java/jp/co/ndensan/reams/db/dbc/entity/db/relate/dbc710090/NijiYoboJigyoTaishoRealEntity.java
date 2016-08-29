/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710090;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 二次予防事業対象情報のエンティティクラスです。
 *
 * @reamsid_L DBC-3095-020 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NijiYoboJigyoTaishoRealEntity {

    private HihokenshaNo hihokenshaNo;
    private FlexibleDate tekiyoKaishiYMD;
    private FlexibleDate tekiyoShuryoYMD;
    private FlexibleDate ketteiYMD;
    private FlexibleDate chosaJisshiYMD;
}
