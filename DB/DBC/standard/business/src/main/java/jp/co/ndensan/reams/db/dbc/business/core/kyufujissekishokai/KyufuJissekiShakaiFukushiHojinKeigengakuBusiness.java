/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufuJissekiShakaiFukushiHojinKeigengaku;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績の社会福祉法人軽減額を照会のbusinessクラスです。
 *
 *
 * @reamsid_L DBC-2970-140 zhaoyao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiShakaiFukushiHojinKeigengakuBusiness implements Serializable {

    private static final long serialVersionUID = 8313567060587063881L;

    private KyufuJissekiShakaiFukushiHojinKeigengaku 給付実績社会福祉法人軽減額情報;
    private RString サービス種類略称;
}
