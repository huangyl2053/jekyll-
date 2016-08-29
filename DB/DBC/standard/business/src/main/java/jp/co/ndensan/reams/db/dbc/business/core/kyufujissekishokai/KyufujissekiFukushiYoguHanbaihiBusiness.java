/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiFukushiYoguHanbaihi;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績の福祉用具購入費を照会のbusinessクラスです。
 *
 * @reamsid_L DBC-2970-100 zhaoyao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufujissekiFukushiYoguHanbaihiBusiness implements Serializable {

    private static final long serialVersionUID = 5343138744350817648L;

    private KyufujissekiFukushiYoguHanbaihi 給付実績福祉用具販売費基本情報;
    private RString サービス種類略称;
}
