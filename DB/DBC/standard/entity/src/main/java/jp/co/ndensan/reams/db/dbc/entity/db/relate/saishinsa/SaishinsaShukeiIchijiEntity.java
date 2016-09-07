/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsa;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 集計一時テーブルに対するテーブルのエンティティ
 *
 * @reamsid_L DBC-2820-050 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaShukeiIchijiEntity {

    private FlexibleYearMonth 取扱年月;
    private RString 履歴番号;
    private int 介護給付費請求件数;
    private Decimal 介護給付費請求単位数;
    private int 介護給付費決定件数;
    private Decimal 介護給付費請求公費負担額;
    private Decimal 介護給付費決定単位数;
    private Decimal 介護給付費決定公費負担額;
    private int 介護給付費調整件数;
    private Decimal 介護給付費調整単位数;
    private Decimal 介護給付費調整公費負担額;
    private int 高額介護サービス費請求件数;
    private Decimal 高額介護サービス費請求単位数;
    private Decimal 高額介護サービス費請求公費負担額;
    private int 高額介護サービス費決定件数;
    private Decimal 高額介護サービス費決定単位数;
    private Decimal 高額介護サービス費決定公費負担額;
    private int 高額介護サービス費調整件数;
    private Decimal 高額介護サービス費調整単位数;
    private Decimal 高額介護サービス費調整公費負担額;
    private RString 公費負担者番号;
    private RString 公費負担者名;
    private FlexibleDate 作成年月日;
    private RString 国保連合会名;
    private RString 審査委員会名;
}
