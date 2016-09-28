/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKyotakuService;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績基本居宅サービス計画費のbusinessクラスです。
 *
 * @reamsid_L DBC-2970-170 dingyi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiKihonKyotakuServiceBusiness implements Serializable {

    private static final long serialVersionUID = -2712475675671638343L;

    private KyufujissekiKyotakuService 給付実績基本居宅サービス計画費データ;
    private KyufujissekiKihon 給付実績基本データ;
}
