/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.kyufujoho;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合照会_給付情報のEntityです。
 *
 * @reamsid_L DBU-4100-040 wanghuafeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJohoEntity {

    private RString 届出年月日;
    private RString 事業作成区分;
    private RString 事業適用開始;
    private RString 事業適用終了;
    private RString サービス種類コード;
    private RString 計画事業所番号;
    private RString 自己計画作成区分;
    private RString 自己適用開始;
    private RString 自己適用終了;
    private RString サービス提供年月;
    private RString サービス分類コード;
    private int 購入金額;
    private int 保険請求額;
    private int 利用者負担額;
    private int 改修費用合計;
    private RString 被保険者番号;
    private RString 整理番号;
    private RString 事業所番号;
    private RString 様式番号;
    private RString 明細番号;
    private RString 識別番号;
    private DbT7063KaigoJigyoshaShiteiServiceEntity 事業者名称;
}
