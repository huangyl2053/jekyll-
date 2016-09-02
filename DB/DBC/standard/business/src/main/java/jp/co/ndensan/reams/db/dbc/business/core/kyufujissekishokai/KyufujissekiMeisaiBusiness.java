/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiMeisai;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績明細のbusinessクラスです。
 *
 * @reamsid_L DBC-2970-080 zhaoran
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufujissekiMeisaiBusiness implements Serializable {

    private static final long serialVersionUID = 3985431213588688190L;

    private KyufujissekiMeisai 給付実績明細;
    private RString サービス種類略称;

}
