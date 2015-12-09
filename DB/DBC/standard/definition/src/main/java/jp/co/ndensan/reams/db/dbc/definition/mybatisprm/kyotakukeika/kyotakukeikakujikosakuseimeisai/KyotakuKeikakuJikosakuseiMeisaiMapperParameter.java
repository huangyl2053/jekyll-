/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyotakukeika.kyotakukeikakujikosakuseimeisai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 居宅給付計画自己作成明細を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class KyotakuKeikakuJikosakuseiMeisaiMapperParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth 対象年月;
    private final Decimal 履歴番号;
    private final RString 居宅サービス区分;
    private final JigyoshaNo サービス提供事業者番号;
    private final ServiceShuruiCode サービス種類コード;
    private final ServiceKomokuCode サービス項目コード;

    private final boolean uses被保険者番号;
    private final boolean uses対象年月;
    private final boolean uses履歴番号;
    private final boolean uses居宅サービス区分;
    private final boolean usesサービス提供事業者番号;
    private final boolean usesサービス種類コード;
    private final boolean usesサービス項目コード;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     * @param 居宅サービス区分 居宅サービス区分
     * @param サービス提供事業者番号 サービス提供事業者番号
     * @param サービス種類コード サービス種類コード
     * @param サービス項目コード サービス項目コード
     * @param uses被保険者番号 uses被保険者番号
     * @param uses対象年月 uses対象年月
     * @param uses履歴番号 uses履歴番号
     * @param uses居宅サービス区分 uses居宅サービス区分
     * @param usesサービス提供事業者番号 usesサービス提供事業者番号
     * @param usesサービス種類コード usesサービス種類コード
     * @param usesサービス項目コード usesサービス項目コード
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private KyotakuKeikakuJikosakuseiMeisaiMapperParameter(
            @lombok.NonNull HihokenshaNo 被保険者番号,
            @lombok.NonNull FlexibleYearMonth 対象年月,
            @lombok.NonNull Decimal 履歴番号,
            @lombok.NonNull RString 居宅サービス区分,
            @lombok.NonNull JigyoshaNo サービス提供事業者番号,
            @lombok.NonNull ServiceShuruiCode サービス種類コード,
            @lombok.NonNull ServiceKomokuCode サービス項目コード,
            boolean uses被保険者番号,
            boolean uses対象年月,
            boolean uses履歴番号,
            boolean uses居宅サービス区分,
            boolean usesサービス提供事業者番号,
            boolean usesサービス種類コード,
            boolean usesサービス項目コード
    ) {
        this.被保険者番号 = 被保険者番号;
        this.対象年月 = 対象年月;
        this.履歴番号 = 履歴番号;
        this.居宅サービス区分 = 居宅サービス区分;
        this.サービス提供事業者番号 = サービス提供事業者番号;
        this.サービス種類コード = サービス種類コード;
        this.サービス項目コード = サービス項目コード;
        this.uses被保険者番号 = uses被保険者番号;
        this.uses対象年月 = uses対象年月;
        this.uses履歴番号 = uses履歴番号;
        this.uses居宅サービス区分 = uses居宅サービス区分;
        this.usesサービス提供事業者番号 = usesサービス提供事業者番号;
        this.usesサービス種類コード = usesサービス種類コード;
        this.usesサービス項目コード = usesサービス項目コード;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     * @param 居宅サービス区分 居宅サービス区分
     * @param サービス提供事業者番号 サービス提供事業者番号
     * @param サービス種類コード サービス種類コード
     * @param サービス項目コード サービス項目コード
     * @return 居宅給付計画自己作成明細検索パラメータ
     */
    public static KyotakuKeikakuJikosakuseiMeisaiMapperParameter createSelectByKeyParam(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号,
            RString 居宅サービス区分,
            JigyoshaNo サービス提供事業者番号,
            ServiceShuruiCode サービス種類コード,
            ServiceKomokuCode サービス項目コード) {
        return new KyotakuKeikakuJikosakuseiMeisaiMapperParameter(被保険者番号, 対象年月, 履歴番号,
                居宅サービス区分, サービス提供事業者番号, サービス種類コード,
                サービス項目コード, true, true, true, true, true, true, true);
    }
}
