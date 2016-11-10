/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 計算対象者ファイルEntity項目定義クラスです。
 *
 * @reamsid_L DBE-1500-020 wanghui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KougakukaigoSabishiRelateEntity {

    private RString 被保険者番号;
    private RString 識別コード;
    private RString サービス提供年月;
    private RString 証記載保険者番号;
    private RString 世帯コード;
    private RString 利用者負担額;
    private RString 支給予定金額;
    private RString 市町村コード;
    private RString 備考欄個人所得区分;
    private RString 要介護認定状態区分コード;
    private RString 旧措置者フラグ;
    private RString 認定有効期間開始年月日;
    private RString 認定有効期間終了年月日;
}
