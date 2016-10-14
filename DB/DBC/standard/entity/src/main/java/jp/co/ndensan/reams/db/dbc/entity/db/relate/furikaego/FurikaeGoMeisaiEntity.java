/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.furikaego;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業合算・事業分振込明細書作成（一括）Entity
 *
 * @reamsid_L DBC-4870-060 lijian
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FurikaeGoMeisaiEntity {

    private RString 支払方法区分;
    private boolean 総合事業フラグ;
    private boolean 頁計フラグ;
    private boolean 総合計フラグ;
    private RString 帳票タイトル;
    private RString 金融機関名称;
    private RString 支店名称;
    private RString 預金種別名称;
    private RString 口座番号;
    private RString 口座名義人;
    private HihokenshaNo 被保険者番号;
    private AtenaMeisho 被保険者氏名;
    private RString 支給申請書整理番号;
    private FlexibleDate 申請年月日;
    private RString 申請区分コード;
    private RString 要介護認定状態区分コード;
    private RString 支払区分方法コード;
    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 総合事業適用開始年月日;
    private FlexibleDate 認定有効期間終了年月日;
    private FlexibleDate 総合事業適用終了年月日;
    private FlexibleYearMonth 対象計算期間開始年月;
    private FlexibleYearMonth 対象計算期間終了年月;
    private FlexibleDate 支払期間開始年月日;
    private FlexibleDate 支払期間終了年月日;
    private RString 支払窓口開始時間;
    private RString 支払窓口終了時間;
    private Decimal 自己負担総額円;
    private FlexibleYear 対象年度;
    private RString 住所;
    private RString 支払場所;
    private FlexibleDate 決定年月日;
    private Decimal 振込金額;
    private int 名寄せ件数;
    private Decimal 頁計人数;
    private Decimal 頁計金額;
    private Decimal 総合計要支援人数;
    private Decimal 総合計要支援金額;
    private Decimal 総合計事業対象人数;
    private Decimal 総合計事業対象金額;
    private Decimal 総合計不明人数;
    private Decimal 総合計不明金額;
    private Decimal 総合計人数;
    private Decimal 総合計金額;
    private ShikibetsuCode 識別コード;

}
