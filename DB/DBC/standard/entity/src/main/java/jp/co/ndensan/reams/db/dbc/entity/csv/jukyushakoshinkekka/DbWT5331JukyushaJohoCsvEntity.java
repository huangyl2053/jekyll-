/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.jukyushakoshinkekka;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 受給者情報一時TBL
 *
 * @reamsid_L DBC-2730-010 chenjie
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT5331JukyushaJohoCsvEntity {
    private int 連番;
    private RString 交換情報識別番号;
    private FlexibleDate 異動年月日;
    private RString 異動区分コード;
    private FlexibleDate 訂正年月日;
    private RString 訂正区分コード;
    private RString 異動事由区分;
    private FlexibleDate 生年月日;
    private RString 性別コード;
    private FlexibleDate 資格取得年月日;
    private FlexibleDate 資格喪失年月日;
    private RString 老人保健市町村番号;
    private RString 老人保健受給者番号;
    private RString 広域連合_政令市_保険者番号;
    private RString 申請種別コード;
    private RString 変更申請中区分コード;
    private FlexibleDate 申請年月日;
    private RString みなし要介護区分コード;
    private RString 要介護状態区分コード;
    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;
    private RString 居宅サービス計画作成区分コード;
    private RString 居宅介護支援事業所番号;
    private FlexibleDate 居宅サービス計画適用開始年月日;
    private FlexibleDate 居宅サービス計画適用終了年月日;
    private Decimal 訪問通所_支給限度基準額;
    private FlexibleDate 訪問通所_上限管理適用期間開始年月日;
    private FlexibleDate 訪問通所_上限管理適用期間終了年月日;
    private Decimal 短期入所_支給限度基準額;
    private FlexibleDate 短期入所_上限管理適用期間開始年月日;
    private FlexibleDate 短期入所_上限管理適用期間終了年月日;
    private RString 公費負担上限額減額の有無;
    private FlexibleDate 償還払化開始年月日;
    private FlexibleDate 償還払化終了年月日;
    private FlexibleDate 給付率引下げ開始年月日;
    private FlexibleDate 給付率引下げ終了年月日;
    private RString 減免申請中区分コード;
    private RString 利用者負担区分コード;
    private Decimal 給付率;
    private FlexibleDate 利用者負担適用開始年月日;
    private FlexibleDate 利用者負担適用終了年月日;
    private RString 標準負担区分コード;
    private Decimal 負担額;
    private FlexibleDate 負担額適用開始年月日;
    private FlexibleDate 負担額適用終了年月日;
    private RString 特定入所者認定申請中区分コード;
    private RString 特定入所者介護サービス区分コード;
    private RString 課税層の特例減額措置対象区分;
    private Decimal 特定入所者食費負担限度額;
    private Decimal 居住費_ユニット型個室_負担限度額;
    private Decimal 居住費_ユニット型準個室_負担限度額;
    private Decimal 居住費_従来型個室_特養等_負担限度額;
    private Decimal 居住費_従来型個室_老健_療養等_負担限度額;
    private Decimal 居住費_多床室_負担限度額;
    private FlexibleDate 負担限度額適用開始年月日;
    private FlexibleDate 負担限度額適用終了年月日;
    private Decimal 軽減率;
    private FlexibleDate 軽減率適用開始年月日;
    private FlexibleDate 軽減率適用終了年月日;
    private RString 小規模居宅サービス利用有無;
    private RString 保険者番号_後期_;
    private RString 被保険者番号_後期_;
    private RString 保険者番号_国保_;
    private RString 被保険者証番号_国保_;
    private RString 宛名番号;
    private RString 二次予防事業区分コード;
    private FlexibleDate 二次予防事業有効期間開始年月日;
    private FlexibleDate 二次予防事業有効期間終了年月日;
    private RString 住所地特例対象者区分コード;
    private RString 施設所在保険者番号;
    private FlexibleDate 住所地特例適用開始年月日;
    private FlexibleDate 住所地特例適用終了年月日;
    private Decimal 居住費_新１_負担限度額;
    private Decimal 居住費_新２_負担限度額;
    private Decimal 居住費_新３_負担限度額;
    private FlexibleDate 二割負担適用開始年月日;
    private FlexibleDate 二割負担適用終了年月日;
    private RString 有料老人ホーム等同意書の有無;
    private RString 突合結果区分;
    private RString 突合情報区分;
    private RString 保険者番号;
    private RString 保険者名;
    private FlexibleYearMonth 取込年月;

}
