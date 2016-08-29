/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績ヘッダ情報2のbusinessクラスです。
 *
 * @reamsid_L DBC-2970-170 dingyi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiHedajyoho2 implements Serializable {

    private static final long serialVersionUID = -126557749316409820L;

    private FlexibleYearMonth サービス提供年月;
    private RString 給付実績区分コード;
    private RString 整理番号;
    private JigyoshaNo 事業所番号;
    private RString 事業者名称;
    private RString 識別番号;
    private RString 識別番号名称;
}
