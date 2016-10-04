/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd206010;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービス事業者情報Entityです。
 *
 * @reamsid_L DBD-3810-030 liuwei2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SabisuKeikakuJigyoshaJohoEntity {

    private ShoKisaiHokenshaNo 証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private int 履歴番号;
    private boolean 居宅サービス限定;
    private boolean 居住費食費のみ;
    private boolean 旧措置者ユニット型個室のみ;
    private RString 確認番号;
    private FlexibleDate 適用開始年月日;
    private FlexibleDate 適用終了年月日;

    private RString 識別コード;
    private RString 被保険者区分コード;
    private FlexibleDate 資格取得年月日;
    private RString 資格取得事由コード;
    private FlexibleDate 資格喪失年月日;
    private RString 資格喪失事由コード;
    private boolean 住所地特例フラグ;
    private boolean 広域内住所地特例フラグ;
    private LasdecCode 広住特措置元市町村コード;
    private LasdecCode 市町村コード;
    private LasdecCode 旧市町村コード;

    private Code 要介護認定状態区分コード;
    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;

    private NyuryokuShikibetsuNo 入力識別番号;
    private FlexibleYearMonth サービス提供年月;
    private RString 事業所番号;
    private RString 給付実績情報作成区分コード;
    private FlexibleYearMonth 審査年月;

    private RString 事業者名称;
    private RString 事業者名称カナ;
    private RString 郵便番号;
    private AtenaJusho 事業者住所;
    private TelNo 電話番号;
    private FlexibleDate 有効開始日;
    private FlexibleDate 有効終了日;
}
