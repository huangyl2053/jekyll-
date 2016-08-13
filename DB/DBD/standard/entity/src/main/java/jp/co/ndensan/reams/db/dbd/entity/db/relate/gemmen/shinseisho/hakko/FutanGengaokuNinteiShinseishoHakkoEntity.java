/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmen.shinseisho.hakko;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 負担限度額認定申請書発行一覧表情報Entityクラスです。
 *
 * @reamsid_L DBD-3530-080 mawy
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanGengaokuNinteiShinseishoHakkoEntity {

    private HihokenshaNo 被保険者番号;
    private RString 計画事業者コード;
    private RString 計画事業者名;
    private boolean is自己作成;
    private RString 利用者負担段階;
    private boolean 生保;
    private boolean 老齢;
    private RString 入所施設コード;
    private RString 入所施設名;
    private Decimal 合計所得金額;
    private Decimal 年金収入額;
    private Decimal 非課税年金勘案額;
    private FlexibleDate 認定開始日;
    private FlexibleDate 認定終了日;
    private RString 要介護認定状態区分コード;
    private RString 厚労省IF識別コード;
    private boolean 旧措置;
    private RString 世帯課税区分;
    private FlexibleDate 前回_申請年月日;
    private FlexibleDate 前回_適用開始年月日;
    private RString 前回_利用者負担段階;
    private Decimal 前回_ユニット準;
    private Decimal 前回_多床室;
    private FlexibleDate 前回_決定年月日;
    private FlexibleDate 前回_有効期限;
    private Decimal 前回_食事負担額;
    private Decimal 前回_従来型特養等;
    private RString 前回_決定区分;
    private RString 前回_旧措置;
    private Decimal 前回_ユニット個;
    private Decimal 前回_従来型老健;
    private FlexibleDate 登録異動年月日;
    private boolean 住所地特例フラグ;
}
