/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKyotakuService;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居宅サービス計画費のビジネスです.
 *
 * @reamsid_L DBC-2970-090 wangrenze
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufujissekiKyotakuServiceBusiness implements Serializable {

    private static final long serialVersionUID = -4903205648808167436L;

    private KyufujissekiKyotakuService 居宅サービス計画費;
    private RString サービス種類略称;
}
