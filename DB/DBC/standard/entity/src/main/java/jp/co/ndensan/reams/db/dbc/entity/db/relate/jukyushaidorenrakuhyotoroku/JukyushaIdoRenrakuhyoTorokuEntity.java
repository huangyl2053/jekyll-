/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyotoroku;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者異動連絡票（追加）登録です。
 *
 * @reamsid_L DBC-2100-030 jiangzongyue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaIdoRenrakuhyoTorokuEntity {

    private FlexibleDate 作成年月日;
    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private FlexibleDate 異動年月日;
    private RString 異動区分;
    private RString 氏名性別生年月日を印字する;
    private RString 性別;
    private RString 異動事由;
    private RString 被保険者氏名カナ;
    private FlexibleDate 生年月日;
    private FlexibleDate 資格取得年月日;
    private FlexibleDate 資格喪失年月日;
    private RString みなし区分;
    private RString 要介護状態区分;
    private FlexibleDate 有効期間開始年月日;
    private FlexibleDate 有効期間終了年月日;
    private RString 支給限度基準額1;
    private FlexibleDate 上限管理適用開始年月日１;
    private FlexibleDate 上限管理終了年月日１;
    private RString 支給限度基準額２;
    private FlexibleDate 上限管理適用開始年月日２;
    private FlexibleDate 上限管理終了年月日２;
    private RString 計画作成区分;
    private RString 居宅支援事業者番号;
    private FlexibleDate 居宅適用開始年月日;
    private FlexibleDate 居宅適用終了年月日;
    private RString 減免申請中区分;
    private RString 利用者負担区分;
    private RString 利用給付率;
    private FlexibleDate 利用適用開始年月日;
    private FlexibleDate 利用適用終了年月日;
    private RString 標準負担区分;
    private RString 標準負担額;
    private FlexibleDate 標準適用開始年月日;
    private FlexibleDate 標準適用終了年月日;
    private Boolean 公費負担上限額減額;
    private FlexibleDate 償還払化適用開始年月日;
    private FlexibleDate 償還払化適用終了年月日;
    private FlexibleDate 給付率引下げ適用開始年月日;
    private FlexibleDate 給付率引下げ適用終了年月日;
    private RString 認定申請中区分;
    private RString ｻｰﾋﾞｽ区分;
    private RString 特例減額措置対象;
    private RString 食費負担限度額;
    private RString ﾕﾆｯﾄ型個室;
    private RString ﾕﾆｯﾄ型準個室;
    private RString 従来型個室特;
    private RString 従来型個室老療;
    private RString 多床室;
    private RString 新１;
    private RString 新２;
    private RString 新３;
    private FlexibleDate 特定入所者適用開始年月日;
    private FlexibleDate 特定入所者適用終了年月日;
    private RString 広域保険者番号;
    private RString 老人保健市町村番号;
    private RString 老人保健受給者番号;
    private RString 軽減率;
    private FlexibleDate 軽減率適用開始年月日;
    private FlexibleDate 軽減率適用終了年月日;
    private Boolean 小規模居宅ｻｰﾋﾞｽ利用;
    private RString 二次予防事業区分;
    private FlexibleDate 二次予防有効期間開始年月日;
    private FlexibleDate 二次予防有効期間終了年月日;
    private RString 申請種別;
    private RString 変更申請中区分;
    private FlexibleDate 申請年月日;
    private RString 国保保険者番号;
    private RString 国保被保険者証番号;
    private RString 国保個人番号;
    private RString 後期高齢保険者番号;
    private RString 後期高齢被保険者番号;
    private RString 住特対象者区分;
    private RString 住特施設所在保険者番号;
    private FlexibleDate 住特適用開始年月日;
    private FlexibleDate 住特適用終了年月日;
    private FlexibleYearMonth 送付年月;
    private FlexibleDate 二割負担適用開始年月日;
    private FlexibleDate 二割負担適用終了年月日;
}
