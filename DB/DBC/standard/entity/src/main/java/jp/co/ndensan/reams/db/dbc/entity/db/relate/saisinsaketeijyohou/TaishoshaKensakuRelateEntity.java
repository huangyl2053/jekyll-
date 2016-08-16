/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.saisinsaketeijyohou;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 再審査決定情報RelateEntityクラスです。
 *
 * @reamsid_L DBC-3040-010 zhangzhiming
 */
@lombok.Getter
@lombok.Setter
public class TaishoshaKensakuRelateEntity {

    private RString 作成年月日;
    private RString 審査委員会名;
    private int 履歴番号;
    private int 介護請求件数;
    private int 介護決定件数;
    private int 介護調整件数;
    private Decimal 介護請求単位;
    private Decimal 介護決定単位;
    private Decimal 介護調整単位;
    private Decimal 介護請求保険者負担額;
    private Decimal 介護決定保険者負担額;
    private Decimal 介護調整保険者負担額;
    private int 高額請求件数;
    private int 高額決定件数;
    private int 高額調整件数;
    private Decimal 高額請求単位;
    private Decimal 高額決定単位;
    private Decimal 高額調整単位;
    private Decimal 高額請求保険者負担額;
    private Decimal 高額決定保険者負担額;
    private Decimal 高額調整保険者負担額;
    private RString 事業所番号;
    private RString 事業所名;
    private RString 被保険者番号;
    private RString 宛名名称;
    private RString 申立事由コード;
    private RString コード名称;
    private RString 再審査申立事由;
    private RString サービス提供年月;
    private RString サービス種類コード;
    private RString サービス種類名;
    private RString 再審査結果コード;
    private RString 当初請求単位数;
    private RString 原審単位数;
    private RString 申立単位数;
    private RString 決定単位数;
    private RString 調整単位数;
    private RString 保険者負担額;
    private RString 公費受給者番号;
    private RString 証記載保険者番号;
    private RString 保険者区分;
}
