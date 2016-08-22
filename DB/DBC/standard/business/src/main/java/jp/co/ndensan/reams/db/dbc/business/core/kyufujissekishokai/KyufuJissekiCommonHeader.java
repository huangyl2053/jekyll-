/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付共通ヘッダ情報のbusinessクラスです。
 *
 * @reamsid_L DBC-2970-170 dingyi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiCommonHeader {

    private List<KyufuJissekiHedajyoho1> 給付実績ヘッダ情報1;
    private List<KyufuJissekiHedajyoho2> 給付実績ヘッダ情報2;
}
