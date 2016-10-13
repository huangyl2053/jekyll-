/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakkoichiran;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付費通知書作成(一括)２のRelateEntityクラスです。
 *
 * @reamsid_L DBC-2280-030 lizhuoxuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuhiTuchiHakkoEntity {

    private RString 被保険者番号;
    private RString 証記載保険者番号;
    private RString サービス提供年月;
    private RString 要介護状態区分コード;
    private RString 事業所番号;
    private RString 事業者名称;
    private RString サービス種類コード;
    private RString サービス項目コード;
    private RString 証記載保険者名;
    private RString サービス名称;
    private RString 日数_回数;
    private Decimal 利用者負担額;
    private Decimal サービス費用合計額;
    private RString 資格喪失年月日;
    private RString 資格喪失事由コード;
    private RString 名称;
    private RString 郵便番号;
    private RString 住所;
    private RString 番地;
    private RString 識別コード;
    private int count;
    private KyufuhiTuchiHakkoIchiranRelateEntity relateEntity;
    private UaFt250FindAtesakiEntity atesakiEntity;
}
