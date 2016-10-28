/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者給付実績台帳の計画費Entityクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KeikakuHiEntity {

    private RString 入力識別番号;
    private RString 被保険者番号;
    private RString サービス提供年月;
    private RString 事業所番号;
    private RString 通し番号;
    private RString 明細行番号;
    private RString 指定基準該当等事業所区分コード;
    private RString 単位数単価;
    private RString 居宅サービス計画作成依頼届出年月日;
    private RString サービスコード;
    private RString 単位数;
    private RString 回数;
    private RString サービス単位数;
    private RString サービス単位数合計;
    private RString 請求金額;
    private RString 担当介護支援専門員番号;
    private RString 摘要;
    private RString 後単位数;
    private RString 後回数;
    private RString 後サービス単位数;
    private RString 後サービス単位数合計;
    private RString 後請求金額;
    private RString 再審査回数;
    private RString 過誤回数;
    private RString 審査年月;

}
