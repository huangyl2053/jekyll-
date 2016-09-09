/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer2;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票設計_DBCMN43002_高額介護（予防）サービス費支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）Entityクラスです。
 *
 * @reamsid_L DBC-2000-070 lijian
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KogakuKetteiTsuchiShoEntity {

    private RString 文書番号;
    private ShikibetsuCode 識別コード;
    private boolean テスト出力フラグ;
    private boolean 自動償還対象フラグ;
    private boolean ゆうちょ銀行フラグ;
    private RString 被保険者氏名;
    private HihokenshaNo 被保険者番号;
    private FlexibleDate 受付年月日;
    private FlexibleDate 提供年月IDX1;
    private FlexibleDate 提供年月IDX2;
    private FlexibleDate 提供年月IDX3;
    private FlexibleDate 提供年月IDX4;
    private FlexibleDate 決定年月日;
    private Decimal 本人支払額;
    private FlexibleDate 対象年月;
    private RString 給付の種類;
    private RString 支給結果;
    private Decimal 決定額IDX1;
    private Decimal 決定額IDX2;
    private Decimal 決定額IDX3;
    private Decimal 決定額IDX4;
    private RString 審査方法区分;
    private int 支給金額;
    private RString 不支給理由;
    private RString 窓口払;
    private RString 口座払;
    private RString 金融機関名称;
    private RString 支給不支給区分;
    private RString 持ちもの;
    private RString 支払場所;
    private RString 支払期間;
    private RString 口座種別;
    private RString 通帳記号;
    private RString 通帳番号;
    private RString 口座名義人;
    private RString 口座番号;
    private FlexibleDate 支払予定日;
    private RString 決定通知書番号;
    private RString 支払方法区分;
    private RString 支払方法;
    private Decimal 支給額;
    private Decimal 支給額IDX1;
    private Decimal 支給額IDX2;
    private Decimal 支給額IDX3;
    private Decimal 支給額IDX4;
    private RString 支給_不支給区分;
    private RString 金融機関上段;
    private RString 金融機関下段;
    private RString 証記載保険者番号;
    private int 通番;
}
