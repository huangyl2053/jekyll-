/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiMeisaiJushochiTokurei;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績明細・住所地特例データのbusinessクラスです。
 *
 * @reamsid_L DBC-2970-100 zhaoyao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufujissekiMeisaiJushochiTokureiBusiness implements Serializable {

    private static final long serialVersionUID = -1309745093602902427L;

    private KyufujissekiMeisaiJushochiTokurei 給付実績明細住所地特例情報;
    private RString サービス種類略称;

}
