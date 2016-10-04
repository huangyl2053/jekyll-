/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufuJissekiCareManagementHi;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績照会のケアマネジメント費のbusinessクラスです
 *
 * @reamsid_L DBC-2970-150 guoqilin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiCareManagementHiBusiness implements Serializable {

    private static final long serialVersionUID = 2091760678483017573L;

    private KyufuJissekiCareManagementHi 給付実績ケアマネジメント費基本情報;
    private RString サービス種類略称;
}
