/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc110810;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 受給者突合依頼情報作成のＣＳＶを定義したEntityクラスです。
 *
 * @reamsid_L DBC-2750-030 xuyongchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class DataRecordCsvEntity implements IJukyushaTotsugoIraiOutCsvEntity {

    @CsvField(order = 1, name = "種別")
    private final RString 種別;
    @CsvField(order = 2, name = "番号連番")
    private final RString 番号連番;
    @CsvField(order = 3, name = "交換情報識別番号")
    private final RString 交換情報識別番号;
    @CsvField(order = 4, name = "突合区分")
    private final RString 突合区分;
    @CsvField(order = 5, name = "認定有効年月")
    private final RString 認定有効年月;
    @CsvField(order = 6, name = "突合開始年月")
    private final RString 突合開始年月;
    @CsvField(order = 7, name = "突合終了年月")
    private final RString 突合終了年月;
    @CsvField(order = 8, name = "異動年月日")
    private final RString 異動年月日;
    @CsvField(order = 9, name = "異動区分コード")
    private final RString 異動区分コード;
    @CsvField(order = 10, name = "異動事由")
    private final RString 異動事由;
    @CsvField(order = 11, name = "証記載保険者番号")
    private final RString 証記載保険者番号;
    @CsvField(order = 12, name = "被保険者番号")
    private final RString 被保険者番号;
    @CsvField(order = 13, name = "被保険者氏名カナ")
    private final RString 被保険者氏名カナ;
    @CsvField(order = 14, name = "生年月日")
    private final RString 生年月日;
    @CsvField(order = 15, name = "性別コード")
    private final RString 性別コード;
    @CsvField(order = 16, name = "資格取得年月日")
    private final RString 資格取得年月日;
    @CsvField(order = 17, name = "資格喪失年月日")
    private final RString 資格喪失年月日;
    @CsvField(order = 18, name = "老人保健市町村番号")
    private final RString 老人保健市町村番号;
    @CsvField(order = 19, name = "老人保健受給者番号")
    private final RString 老人保健受給者番号;
    @CsvField(order = 20, name = "公費負担者番号")
    private final RString 公費負担者番号;
    @CsvField(order = 21, name = "広域連合保険者番号")
    private final RString 広域連合保険者番号;
    @CsvField(order = 22, name = "申請種別コード")
    private final RString 申請種別コード;
    @CsvField(order = 23, name = "変更申請中区分コード")
    private final RString 変更申請中区分コード;
    @CsvField(order = 24, name = "申請年月日")
    private final RString 申請年月日;
    @CsvField(order = 25, name = "みなし要介護区分コード")
    private final RString みなし要介護区分コード;
    @CsvField(order = 26, name = "要介護状態区分コード")
    private final RString 要介護状態区分コード;
    @CsvField(order = 27, name = "認定有効期間開始年月日")
    private final RString 認定有効期間開始年月日;
    @CsvField(order = 28, name = "認定有効期間終了年月日")
    private final RString 認定有効期間終了年月日;
    @CsvField(order = 29, name = "居宅サービス計画作成区分コード")
    private final RString 居宅サービス計画作成区分コード;
    @CsvField(order = 30, name = "居宅介護支援事業所番号")
    private final RString 居宅介護支援事業所番号;
    @CsvField(order = 31, name = "居宅サービス計画適用開始年月日")
    private final RString 居宅サービス計画適用開始年月日;
    @CsvField(order = 32, name = "居宅サービス計画適用終了年月日")
    private final RString 居宅サービス計画適用終了年月日;
    @CsvField(order = 33, name = "訪問支給限度基準額")
    private final RString 訪問支給限度基準額;
    @CsvField(order = 34, name = "訪問開始年月日")
    private final RString 訪問開始年月日;
    @CsvField(order = 35, name = "訪問終了年月日")
    private final RString 訪問終了年月日;
    @CsvField(order = 36, name = "短期支給限度基準額")
    private final RString 短期支給限度基準額;
    @CsvField(order = 37, name = "短期開始年月日")
    private final RString 短期開始年月日;
    @CsvField(order = 38, name = "短期終了年月日")
    private final RString 短期終了年月日;
    @CsvField(order = 39, name = "公費負担上限額減額の有無")
    private final boolean 公費負担上限額減額の有無;
    @CsvField(order = 40, name = "償還払化開始年月日")
    private final RString 償還払化開始年月日;
    @CsvField(order = 41, name = "償還払化終了年月日")
    private final RString 償還払化終了年月日;
    @CsvField(order = 42, name = "給付率引下げ開始年月日")
    private final RString 給付率引下げ開始年月日;
    @CsvField(order = 43, name = "給付率引下げ終了年月日")
    private final RString 給付率引下げ終了年月日;
    @CsvField(order = 44, name = "減免申請中区分コード")
    private final RString 減免申請中区分コード;
    @CsvField(order = 45, name = "利用者負担区分コード")
    private final RString 利用者負担区分コード;
    @CsvField(order = 46, name = "給付率")
    private final Decimal 給付率;
    @CsvField(order = 47, name = "適用開始年月日")
    private final RString 適用開始年月日;
    @CsvField(order = 48, name = "適用終了年月日")
    private final RString 適用終了年月日;
    @CsvField(order = 49, name = "標準負担区分コード")
    private final RString 標準負担区分コード;
    @CsvField(order = 50, name = "負担額")
    private final Decimal 負担額;
    @CsvField(order = 51, name = "負担額適用開始年月日")
    private final RString 負担額適用開始年月日;
    @CsvField(order = 52, name = "負担額適用終了年月日")
    private final RString 負担額適用終了年月日;
    @CsvField(order = 53, name = "特定入所者認定申請中区分コード")
    private final RString 特定入所者認定申請中区分コード;
    @CsvField(order = 54, name = "特定入所者介護サービス区分コード")
    private final RString 特定入所者介護サービス区分コード;
    @CsvField(order = 55, name = "課税層の特例減額措置対象")
    private final RString 課税層の特例減額措置対象;
    @CsvField(order = 56, name = "食費負担限度額")
    private final RString 食費負担限度額;
    @CsvField(order = 57, name = "居住費個室負担限度額")
    private final RString 居住費個室負担限度額;
    @CsvField(order = 58, name = "居住費準個室負担限度額")
    private final RString 居住費準個室負担限度額;
    @CsvField(order = 59, name = "居住費特養負担限度額")
    private final RString 居住費特養負担限度額;
    @CsvField(order = 60, name = "居住費従来型個室負担限度額")
    private final RString 居住費従来型個室負担限度額;
    @CsvField(order = 61, name = "居住費多床室負担限度額")
    private final RString 居住費多床室負担限度額;
    @CsvField(order = 62, name = "負担限度額適用開始年月日")
    private final RString 負担限度額適用開始年月日;
    @CsvField(order = 63, name = "負担限度額適用終了年月日")
    private final RString 負担限度額適用終了年月日;
    @CsvField(order = 64, name = "軽減率")
    private final RString 軽減率;
    @CsvField(order = 65, name = "軽減率適用開始年月日")
    private final RString 軽減率適用開始年月日;
    @CsvField(order = 66, name = "軽減率適用終了年月日")
    private final RString 軽減率適用終了年月日;
    @CsvField(order = 67, name = "小規模多機能型居宅介護")
    private final boolean 小規模多機能型居宅介護;
    @CsvField(order = 68, name = "保険者番号後期")
    private final RString 保険者番号後期;
    @CsvField(order = 69, name = "被保険者番号後期")
    private final RString 被保険者番号後期;
    @CsvField(order = 70, name = "保険者番号国保")
    private final RString 保険者番号国保;
    @CsvField(order = 71, name = "被保険者番号国保")
    private final RString 被保険者番号国保;
    @CsvField(order = 72, name = "個人番号国保")
    private final RString 個人番号国保;
    @CsvField(order = 73, name = "二次予防事業区分コード")
    private final RString 二次予防事業区分コード;
    @CsvField(order = 74, name = "二次予防事業開始年月日")
    private final RString 二次予防事業開始年月日;
    @CsvField(order = 75, name = "二次予防事業終了年月日")
    private final RString 二次予防事業終了年月日;
    @CsvField(order = 76, name = "住所地特例対象者区分コード")
    private final RString 住所地特例対象者区分コード;
    @CsvField(order = 77, name = "施設所在保険者番号")
    private final RString 施設所在保険者番号;
    @CsvField(order = 78, name = "住所地特例適用開始日")
    private final RString 住所地特例適用開始日;
    @CsvField(order = 79, name = "住所地特例適用終了日")
    private final RString 住所地特例適用終了日;
    @CsvField(order = 80, name = "居宅費新1負担限度額")
    private final RString 居宅費新1負担限度額;
    @CsvField(order = 81, name = "居宅費新2負担限度額")
    private final RString 居宅費新2負担限度額;
    @CsvField(order = 82, name = "居宅費新3負担限度額")
    private final RString 居宅費新3負担限度額;
    @CsvField(order = 83, name = "二割負担適用開始年月日")
    private final RString 二割負担適用開始年月日;
    @CsvField(order = 84, name = "二割負担適用終了年月日")
    private final RString 二割負担適用終了年月日;

    /**
     * コンストラクタ
     *
     * @param 種別 種別
     * @param 番号連番 番号連番
     * @param 交換情報識別番号 交換情報識別番号
     * @param 突合区分 突合区分
     * @param 認定有効年月 認定有効年月
     * @param 突合開始年月 突合開始年月
     * @param 突合終了年月 突合終了年月
     * @param 異動年月日 異動年月日
     * @param 異動区分コード 異動区分コード
     * @param 異動事由 異動事由
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 被保険者氏名カナ 被保険者氏名カナ
     * @param 生年月日 生年月日
     * @param 性別コード 性別コード
     * @param 資格取得年月日 資格取得年月日
     * @param 小規模多機能型居宅介護 小規模多機能型居宅介護
     * @param 老人保健市町村番号 老人保健市町村番号
     * @param 老人保健受給者番号 老人保健受給者番号
     * @param 公費負担者番号 公費負担者番号
     * @param 広域連合保険者番号 広域連合保険者番号
     * @param 資格喪失年月日 資格喪失年月日
     * @param 変更申請中区分コード 変更申請中区分コード
     * @param 申請年月日 申請年月日
     * @param みなし要介護区分コード みなし要介護区分コード
     * @param 要介護状態区分コード 要介護状態区分コード
     * @param 認定有効期間開始年月日 認定有効期間開始年月日
     * @param 認定有効期間終了年月日 認定有効期間終了年月日
     * @param 居宅サービス計画作成区分コード 居宅サービス計画作成区分コード
     * @param 居宅介護支援事業所番号 居宅介護支援事業所番号
     * @param 居宅サービス計画適用開始年月日 居宅サービス計画適用開始年月日
     * @param 居宅サービス計画適用終了年月日 居宅サービス計画適用終了年月日
     * @param 訪問支給限度基準額 訪問支給限度基準額
     * @param 訪問開始年月日 訪問開始年月日
     * @param 訪問終了年月日 訪問終了年月日
     * @param 短期支給限度基準額 短期支給限度基準額
     * @param 短期開始年月日 短期開始年月日
     * @param 短期終了年月日 短期終了年月日
     * @param 公費負担上限額減額の有無 公費負担上限額減額の有無
     * @param 償還払化開始年月日 償還払化開始年月日
     * @param 償還払化終了年月日 償還払化終了年月日
     * @param 給付率引下げ開始年月日 給付率引下げ開始年月日
     * @param 給付率引下げ終了年月日 給付率引下げ終了年月日
     * @param 減免申請中区分コード 減免申請中区分コード
     * @param 利用者負担区分コード 利用者負担区分コード
     * @param 給付率 給付率
     * @param 申請種別コード 申請種別コード
     * @param 適用終了年月日 適用終了年月日
     * @param 標準負担区分コード 標準負担区分コード
     * @param 負担額 負担額
     * @param 負担額適用開始年月日 負担額適用開始年月日
     * @param 負担額適用終了年月日 負担額適用終了年月日
     * @param 特定入所者認定申請中区分コード 特定入所者認定申請中区分コード
     * @param 特定入所者介護サービス区分コード 特定入所者介護サービス区分コード
     * @param 課税層の特例減額措置対象 課税層の特例減額措置対象
     * @param 食費負担限度額 食費負担限度額
     * @param 居住費個室負担限度額 居住費個室負担限度額
     * @param 居住費準個室負担限度額 居住費準個室負担限度額
     * @param 居住費特養負担限度額 居住費特養負担限度額
     * @param 適用開始年月日 適用開始年月日
     * @param 居住費多床室負担限度額 居住費多床室負担限度額
     * @param 負担限度額適用開始年月日 負担限度額適用開始年月日
     * @param 負担限度額適用終了年月日 負担限度額適用終了年月日
     * @param 軽減率 軽減率
     * @param 居住費従来型個室負担限度額 居住費従来型個室負担限度額
     * @param 軽減率適用終了年月日 軽減率適用終了年月日
     * @param 軽減率適用開始年月日 軽減率適用開始年月日
     * @param 保険者番号後期 保険者番号後期
     * @param 被保険者番号後期 被保険者番号後期
     * @param 保険者番号国保 保険者番号国保
     * @param 被保険者番号国保 被保険者番号国保
     * @param 個人番号国保 個人番号国保
     * @param 二次予防事業区分コード 二次予防事業区分コード
     * @param 二次予防事業開始年月日 二次予防事業開始年月日
     * @param 二次予防事業終了年月日 二次予防事業終了年月日
     * @param 住所地特例対象者区分コード 住所地特例対象者区分コード
     * @param 施設所在保険者番号 施設所在保険者番号
     * @param 住所地特例適用開始日 住所地特例適用開始日
     * @param 住所地特例適用終了日 住所地特例適用終了日
     * @param 居宅費新1負担限度額 居宅費新1負担限度額
     * @param 居宅費新2負担限度額 居宅費新2負担限度額
     * @param 居宅費新3負担限度額 居宅費新3負担限度額
     * @param 二割負担適用開始年月日 二割負担適用開始年月日
     * @param 二割負担適用終了年月日 二割負担適用終了年月日
     *
     */
    public DataRecordCsvEntity(RString 種別,
            RString 番号連番,
            RString 交換情報識別番号,
            RString 突合区分,
            RString 認定有効年月,
            RString 突合開始年月,
            RString 突合終了年月,
            RString 異動年月日,
            RString 異動区分コード,
            RString 異動事由,
            RString 証記載保険者番号,
            RString 被保険者番号,
            RString 被保険者氏名カナ,
            RString 生年月日,
            RString 性別コード,
            RString 資格取得年月日,
            RString 資格喪失年月日,
            RString 老人保健市町村番号,
            RString 老人保健受給者番号,
            RString 公費負担者番号,
            RString 広域連合保険者番号,
            RString 申請種別コード,
            RString 変更申請中区分コード,
            RString 申請年月日,
            RString みなし要介護区分コード,
            RString 要介護状態区分コード,
            RString 認定有効期間開始年月日,
            RString 認定有効期間終了年月日,
            RString 居宅サービス計画作成区分コード,
            RString 居宅介護支援事業所番号,
            RString 居宅サービス計画適用開始年月日,
            RString 居宅サービス計画適用終了年月日,
            RString 訪問支給限度基準額,
            RString 訪問開始年月日,
            RString 訪問終了年月日,
            RString 短期支給限度基準額,
            RString 短期開始年月日,
            RString 短期終了年月日,
            boolean 公費負担上限額減額の有無,
            RString 償還払化開始年月日,
            RString 償還払化終了年月日,
            RString 給付率引下げ開始年月日,
            RString 給付率引下げ終了年月日,
            RString 減免申請中区分コード,
            RString 利用者負担区分コード,
            Decimal 給付率,
            RString 適用開始年月日,
            RString 適用終了年月日,
            RString 標準負担区分コード,
            Decimal 負担額,
            RString 負担額適用開始年月日,
            RString 負担額適用終了年月日,
            RString 特定入所者認定申請中区分コード,
            RString 特定入所者介護サービス区分コード,
            RString 課税層の特例減額措置対象,
            RString 食費負担限度額,
            RString 居住費個室負担限度額,
            RString 居住費準個室負担限度額,
            RString 居住費特養負担限度額,
            RString 居住費従来型個室負担限度額,
            RString 居住費多床室負担限度額,
            RString 負担限度額適用開始年月日,
            RString 負担限度額適用終了年月日,
            RString 軽減率,
            RString 軽減率適用開始年月日,
            RString 軽減率適用終了年月日,
            boolean 小規模多機能型居宅介護,
            RString 保険者番号後期,
            RString 被保険者番号後期,
            RString 保険者番号国保,
            RString 被保険者番号国保,
            RString 個人番号国保,
            RString 二次予防事業区分コード,
            RString 二次予防事業開始年月日,
            RString 二次予防事業終了年月日,
            RString 住所地特例対象者区分コード,
            RString 施設所在保険者番号,
            RString 住所地特例適用開始日,
            RString 住所地特例適用終了日,
            RString 居宅費新1負担限度額,
            RString 居宅費新2負担限度額,
            RString 居宅費新3負担限度額,
            RString 二割負担適用開始年月日,
            RString 二割負担適用終了年月日
    ) {

        this.種別 = 種別;
        this.番号連番 = 番号連番;
        this.交換情報識別番号 = 交換情報識別番号;
        this.突合区分 = 突合区分;
        this.認定有効年月 = 認定有効年月;
        this.突合開始年月 = 突合開始年月;
        this.突合終了年月 = 突合終了年月;
        this.異動年月日 = 異動年月日;
        this.異動区分コード = 異動区分コード;
        this.異動事由 = 異動事由;
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.被保険者氏名カナ = 被保険者氏名カナ;
        this.生年月日 = 生年月日;
        this.性別コード = 性別コード;
        this.資格取得年月日 = 資格取得年月日;
        this.資格喪失年月日 = 資格喪失年月日;
        this.老人保健市町村番号 = 老人保健市町村番号;
        this.老人保健受給者番号 = 老人保健受給者番号;
        this.公費負担者番号 = 公費負担者番号;
        this.広域連合保険者番号 = 広域連合保険者番号;
        this.申請種別コード = 申請種別コード;
        this.変更申請中区分コード = 変更申請中区分コード;
        this.申請年月日 = 申請年月日;
        this.みなし要介護区分コード = みなし要介護区分コード;
        this.要介護状態区分コード = 要介護状態区分コード;
        this.認定有効期間開始年月日 = 認定有効期間開始年月日;
        this.認定有効期間終了年月日 = 認定有効期間終了年月日;
        this.居宅サービス計画作成区分コード = 居宅サービス計画作成区分コード;
        this.居宅介護支援事業所番号 = 居宅介護支援事業所番号;
        this.居宅サービス計画適用開始年月日 = 居宅サービス計画適用開始年月日;
        this.居宅サービス計画適用終了年月日 = 居宅サービス計画適用終了年月日;
        this.訪問支給限度基準額 = 訪問支給限度基準額;
        this.訪問開始年月日 = 訪問開始年月日;
        this.訪問終了年月日 = 訪問終了年月日;
        this.短期支給限度基準額 = 短期支給限度基準額;
        this.短期開始年月日 = 短期開始年月日;
        this.短期終了年月日 = 短期終了年月日;
        this.公費負担上限額減額の有無 = 公費負担上限額減額の有無;
        this.償還払化開始年月日 = 償還払化開始年月日;
        this.償還払化終了年月日 = 償還払化終了年月日;
        this.給付率引下げ開始年月日 = 給付率引下げ開始年月日;
        this.給付率引下げ終了年月日 = 給付率引下げ終了年月日;
        this.減免申請中区分コード = 減免申請中区分コード;
        this.利用者負担区分コード = 利用者負担区分コード;
        this.給付率 = 給付率;
        this.適用開始年月日 = 適用開始年月日;
        this.適用終了年月日 = 適用終了年月日;
        this.標準負担区分コード = 標準負担区分コード;
        this.負担額 = 負担額;
        this.負担額適用開始年月日 = 負担額適用開始年月日;
        this.負担額適用終了年月日 = 負担額適用終了年月日;
        this.特定入所者認定申請中区分コード = 特定入所者認定申請中区分コード;
        this.特定入所者介護サービス区分コード = 特定入所者介護サービス区分コード;
        this.課税層の特例減額措置対象 = 課税層の特例減額措置対象;
        this.食費負担限度額 = 食費負担限度額;
        this.居住費個室負担限度額 = 居住費個室負担限度額;
        this.居住費準個室負担限度額 = 居住費準個室負担限度額;
        this.居住費特養負担限度額 = 居住費特養負担限度額;
        this.居住費従来型個室負担限度額 = 居住費従来型個室負担限度額;
        this.居住費多床室負担限度額 = 居住費多床室負担限度額;
        this.負担限度額適用開始年月日 = 負担限度額適用開始年月日;
        this.負担限度額適用終了年月日 = 負担限度額適用終了年月日;
        this.軽減率 = 軽減率;
        this.軽減率適用開始年月日 = 軽減率適用開始年月日;
        this.軽減率適用終了年月日 = 軽減率適用終了年月日;
        this.小規模多機能型居宅介護 = 小規模多機能型居宅介護;
        this.保険者番号後期 = 保険者番号後期;
        this.被保険者番号後期 = 被保険者番号後期;
        this.保険者番号国保 = 保険者番号国保;
        this.被保険者番号国保 = 被保険者番号国保;
        this.個人番号国保 = 個人番号国保;
        this.二次予防事業区分コード = 二次予防事業区分コード;
        this.二次予防事業開始年月日 = 二次予防事業開始年月日;
        this.二次予防事業終了年月日 = 二次予防事業終了年月日;
        this.住所地特例対象者区分コード = 住所地特例対象者区分コード;
        this.施設所在保険者番号 = 施設所在保険者番号;
        this.住所地特例適用開始日 = 住所地特例適用開始日;
        this.住所地特例適用終了日 = 住所地特例適用終了日;
        this.居宅費新1負担限度額 = 居宅費新1負担限度額;
        this.居宅費新2負担限度額 = 居宅費新2負担限度額;
        this.居宅費新3負担限度額 = 居宅費新3負担限度額;
        this.二割負担適用開始年月日 = 二割負担適用開始年月日;
        this.二割負担適用終了年月日 = 二割負担適用終了年月日;
    }
}
