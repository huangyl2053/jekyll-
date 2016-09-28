/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiTokuteiNyushosyaKaigoServiceHiyo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定入所者費用のビジネスです.
 *
 * @reamsid_L DBC-2970-130 wangrenze
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness implements Serializable {

    private static final long serialVersionUID = 3168905126248018540L;

    private KyufujissekiTokuteiNyushosyaKaigoServiceHiyo 特定入所者費用;
    private RString サービス種類略称;
}
