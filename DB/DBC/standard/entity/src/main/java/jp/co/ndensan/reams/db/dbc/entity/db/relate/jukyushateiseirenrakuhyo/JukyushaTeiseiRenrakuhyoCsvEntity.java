/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushateiseirenrakuhyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 出力用受給者訂正情報Entity
 *
 * @reamsid_L DBC-2720-091 surun
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaTeiseiRenrakuhyoCsvEntity {

    private HihokenshaNo 被保険者番号;
    private FlexibleDate 異動年月日;
    private int 履歴番号;
    private RString 異動区分;
    private RString 異動事由;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private RString 被保険者氏名カナ;
    private FlexibleDate 生年月日;
    private RString 性別;
    private FlexibleDate 資格取得年月日;
    private FlexibleDate 資格喪失年月日;
    private RString 老人保健市町村番号;
    private RString 老人保健受給者番号;
    private RString 公費負担者番号;
    private ShoKisaiHokenshaNo 広域保険者番号;
    private RString 申請種別;
    private RString 変更申請中区分;
    private FlexibleDate 申請年月日;
    private RString みなし区分;
    private RString 要介護状態区分;
    private FlexibleDate 有効期間開始年月日;
    private FlexibleDate 有効期間終了年月日;
    private RString 計画作成区分;
    private RString 居宅支援事業所番号;
    private FlexibleDate 居宅適用開始年月日;
    private FlexibleDate 居宅適用終了年月日;
    private int 支給限度基準額1;
    private FlexibleDate 上限管理適用開始年月日1;
    private FlexibleDate 上限管理適用終了年月日1;
    private int 支給限度基準額2;
    private FlexibleDate 上限管理適用開始年月日2;
    private FlexibleDate 上限管理適用終了年月日2;
    private RString 公費負担上限額減額の有無;
    private FlexibleDate 償還払化適用開始年月日;
    private FlexibleDate 償還払化適用終了年月日;
    private FlexibleDate 給付率引下げ適用開始年月日;
    private FlexibleDate 給付率引下げ適用終了年月日;
    private RString 減免申請中区分;
    private RString 利用者負担区分;
    private Decimal 利用給付率;
    private FlexibleDate 利用適用開始年月日;
    private FlexibleDate 利用適用終了年月日;
    private RString 標準負担区分;
    private Decimal 標準負担額;
    private FlexibleDate 標準適用開始年月日;
    private FlexibleDate 標準適用終了年月日;
    private RString 認定申請中区分;
    private RString サービス区分;
    private RString 特例減額措置対象;
    private RString 食費負担限度額;
    private RString ユニット型個室;
    private RString ユニット型準個室;
    private RString 従来型個室特;
    private RString 従来型個室老療;
    private RString 多床室;
    private FlexibleDate 特定入所者適用開始年月日;
    private FlexibleDate 特定入所者適用終了年月日;
    private RString 軽減率;
    private FlexibleDate 軽減率適用開始年月日;
    private FlexibleDate 軽減率適用終了年月日;
    private RString 小規模居宅ｻｰﾋﾞｽ利用;
    private RString 後期高齢保険者番号;
    private RString 後期高齢被保険者番号;
    private RString 国保保険者番号;
    private RString 国保被保険者証番号;
    private RString 国保個人番号;
    private RString 二次予防事業区分;
    private FlexibleDate 二次予防有効期間開始年月日;
    private FlexibleDate 二次予防有効期間終了年月日;
    private boolean 訂正連絡票フラグ;
    private FlexibleYearMonth 送付年月;
    private RString 住特対象者区分;
    private RString 住特施設所在保険者番号;
    private FlexibleDate 住特適用開始年月日;
    private FlexibleDate 住特適用終了年月日;
    private RString 新１;
    private RString 新２;
    private RString 新３;
    private FlexibleDate 二割負担適用開始年月日;
    private FlexibleDate 二割負担適用終了年月日;
    private RString 訂正区分コード;
    private FlexibleDate 訂正年月日;
    private boolean 論理削除フラグ;
}
