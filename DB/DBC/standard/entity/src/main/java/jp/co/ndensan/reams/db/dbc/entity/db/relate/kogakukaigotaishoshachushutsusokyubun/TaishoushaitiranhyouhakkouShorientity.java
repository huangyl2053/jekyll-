/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 計算対象者ファイルEntity項目定義クラスです。
 *
 * @reamsid_L DBE-1500-020 wanghui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaishoushaitiranhyouhakkouShorientity {

    private RString 被保険者番号;
    private RString 識別コード;
    private RString サービス提供年月;
    private RString 証記載保険者番号;
    private RString 世帯コード;
    private RString 利用者負担額;
    private RString 支給予定金額;
    private RString 市町村コード;
    private RString 備考欄個人所得区分;
    private RString 被保険者名;
    private RString 要介護認定状態区分コード;
    private RString 旧措置者フラグ;
    private RString 認定有効期間開始年月日;
    private RString 認定有効期間終了年月日;
    private RString カナ名称;
    private RString 郵便番号;
    private RString 町域コード;
    private RString 住所番地方書;
    private RString 行政区コード;
    private RString 行政区;
    private RString 措置元市町村コード;

}
