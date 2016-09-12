/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenjukyushain;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票出力対象データのEntity
 *
 * @reamsid_L DBC-2740-010 fuyanling
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT0001DbWT5331Entity {

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
    private RString 広域連合政令市保険者番号;
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
    private Decimal 訪問通所支給限度基準額;
    private FlexibleDate 訪問通所上限管理適用期間開始年月日;
    private FlexibleDate 訪問通所上限管理適用期間終了年月日;
    private Decimal 短期入所支給限度基準額;
    private FlexibleDate 短期入所上限管理適用期間開始年月日;
    private FlexibleDate 短期入所上限管理適用期間終了年月日;
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
    private Decimal 居住費ユニット型個室負担限度額;
    private Decimal 居住費ユニット型準個室負担限度額;
    private Decimal 居住費従来型個室特養等負担限度額;
    private Decimal 居住費従来型個室老健療養等負担限度額;
    private Decimal 居住費多床室負担限度額;
    private FlexibleDate 負担限度額適用開始年月日;
    private FlexibleDate 負担限度額適用終了年月日;
    private Decimal 軽減率;
    private FlexibleDate 軽減率適用開始年月日;
    private FlexibleDate 軽減率適用終了年月日;
    private RString 小規模居宅サービス利用有無;
    private RString 保険者番号後期;
    private RString 被保険者番号後期;
    private RString 保険者番号国保;
    private RString 被保険者証番号国保;
    private RString 宛名番号;
    private RString 二次予防事業区分コード;
    private FlexibleDate 二次予防事業有効期間開始年月日;
    private FlexibleDate 二次予防事業有効期間終了年月日;
    private RString 住所地特例対象者区分コード;
    private RString 施設所在保険者番号;
    private FlexibleDate 住所地特例適用開始年月日;
    private FlexibleDate 住所地特例適用終了年月日;
    private Decimal 居住費新１負担限度額;
    private Decimal 居住費新２負担限度額;
    private Decimal 居住費新３負担限度額;
    private FlexibleDate 二割負担適用開始年月日;
    private FlexibleDate 二割負担終了開始年月日;
    private RString 有料老人ホーム等同意書の有無;
    private RString 突合結果区分;
    private RString 突合情報区分;
    private RString 保険者番号;
    private RString 保険者名;
    private FlexibleDate 取込年月;

    private ShoKisaiHokenshaNo 証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private FlexibleDate サービス提供年月末日;
    private RString 被保険者カナ氏名;
    private RString 被保険者氏名;
    private LasdecCode 旧市町村コード;
    private HihokenshaNo 変換被保険者番号;
    private HihokenshaNo 登録被保険者番号;
    private LasdecCode 市町村コード;
    private RString 管内管外区分;
    private RString 郵便番号;
    private RString 町域コード;
    private RString 行政区コード;
    private RString 行政区名;
    private RString 住所;
    private RString 番地;
    private RString 方書;
    private RString 宛名カナ名称;
    private RString 宛名名称;
    private RString 氏名50音カナ;
    private RString 識別コード;
    private FlexibleDate 資格取得日;
    private RString 資格取得事由コード;
    private FlexibleDate 資格喪失日;
    private RString 資格喪失事由コード;
    private RString 世帯集約番号;
}
