/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmen.shinseisho.hakko;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 利用者負担額免除申請書Entityクラスです。
 *
 * @reamsid_L DBD-3530-080 mawy
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanGendogakuNinteiShinseishoHakkoIchiranEntity {

    private HihokenshaNo 被保険者番号;
    private boolean 更新認定フラグ;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private RString 計画事業者コード;
    private RString 計画事業者名;
    private boolean is自己作成;
    private RString 利用者負担段階;
    private boolean 生保;
    private boolean 老齢;
    private RString 入所施設コード;
    private RString 入所施設名;
    private Decimal 合計所得;
    private FlexibleDate 認定開始日;
    private FlexibleDate 認定終了日;
    private RString 要介護認定状態区分コード;
    private RString 厚労省IF識別コード;
    private boolean 旧措置フラグ;
    private RString 世帯課税;
    private FlexibleDate 申請年月日;
    private FlexibleDate 適用日;
    private RString 負担段階;
    private Decimal ユニット型順個室;
    private Decimal 多床室;
    private FlexibleDate 決定年月日;
    private FlexibleDate 有効期限;
    private Decimal 食費負担額;
    private Decimal 従来型特養;
    private RString 決定区分;
    private RString 旧措置;
    private Decimal ユニット型個室;
    private Decimal 従来型老健;
    private RString 住所地特例フラグ;
    private Decimal 非課税年金勘案額;
    private Decimal 年金収入額;
    private YubinNo 郵便番号;
    private TelNo 電話番号;
    private ChoikiCode 町域コード;
    private GyoseikuCode 行政区コード;
    private RString 氏名カナ;
    private FlexibleDate 生年月日;
}
