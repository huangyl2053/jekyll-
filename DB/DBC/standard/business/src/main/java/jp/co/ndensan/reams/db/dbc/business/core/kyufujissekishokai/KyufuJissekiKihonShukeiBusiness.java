/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShukei;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績基本集計データのbusinessクラスです。
 *
 * @reamsid_L DBC-2970-170 dingyi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiKihonShukeiBusiness implements Serializable {

    private static final long serialVersionUID = -2546497115468214511L;

    private KyufujissekiShukei 給付実績集計データ;
    private KyufujissekiKihon 給付実績基本データ;
}
