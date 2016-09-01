/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shikakushogohyoin;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票のCSVファイル作成のヘッダエンティティです。
 *
 * @reamsid_L DBC-2890-010 wangxingpeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuShogohyoInCsvEntity {

    @CsvField(order = 10, name = "審査年月")
    private RString 審査年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "連番")
    private RString 連番;
    @CsvField(order = 40, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 50, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 60, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 70, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 80, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 90, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 100, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 110, name = "警告種別")
    private RString 警告種別;
    @CsvField(order = 120, name = "事業者番号")
    private RString 事業者番号;
    @CsvField(order = 130, name = "事業者名")
    private RString 事業者名;
    @CsvField(order = 140, name = "要介護区分コード")
    private RString 要介護区分コード;
    @CsvField(order = 150, name = "要介護度")
    private RString 要介護度;
    @CsvField(order = 160, name = "旧措置入所者特例コード")
    private RString 旧措置入所者特例コード;
    @CsvField(order = 170, name = "旧措置入所者特例有無")
    private RString 旧措置入所者特例有無;
    @CsvField(order = 180, name = "認定有効期間（開始)")
    private RString 認定有効期間_開始;
    @CsvField(order = 190, name = "認定有効期間（終了）")
    private RString 認定有効期間_終了;
    @CsvField(order = 200, name = "限度額適用期間（開始）")
    private RString 限度額適用期間_開始;
    @CsvField(order = 210, name = "限度額適用期間（終了）")
    private RString 限度額適用期間_終了;
    @CsvField(order = 220, name = "訪問通所／短期入所支給限度額")
    private RString 訪問通所_短期入所支給限度額;
    @CsvField(order = 230, name = "居宅サービス計画作成区分コード")
    private RString 居宅サービス計画作成区分コード;
    @CsvField(order = 240, name = "居宅サービス計画作成区分")
    private RString 居宅サービス計画作成区分;
    @CsvField(order = 250, name = "支援事業者番号")
    private RString 支援事業者番号;
    @CsvField(order = 260, name = "食事標準負担額（月額）")
    private RString 食事標準負担額_月額;
    @CsvField(order = 270, name = "食事標準負担額（日額）")
    private RString 食事標準負担額_日額;
    @CsvField(order = 280, name = "食費負担限度額")
    private RString 食費負担限度額;
    @CsvField(order = 290, name = "居住費負担限度額・ユニット型個室")
    private RString 居住費負担限度額_ユニット型個室;
    @CsvField(order = 300, name = "居住費負担限度額・ユニット型準個室")
    private RString 居住費負担限度額_ユニット型準個室;
    @CsvField(order = 310, name = "居住費負担限度額・従来型個室（特養等）")
    private RString 居住費負担限度額_従来型個室_特養等;
    @CsvField(order = 320, name = "居住費負担限度額・従来型個室（老健・療養等）")
    private RString 居住費負担限度額_従来型個室_老健_療養等;
    @CsvField(order = 330, name = "居住費負担限度額・多床室")
    private RString 居住費負担限度額_多床室;
    @CsvField(order = 340, name = "単位数単価")
    private RString 単位数単価;
    @CsvField(order = 350, name = "保険給付率")
    private RString 保険給付率;
    @CsvField(order = 360, name = "公費1給付率")
    private RString 公費1給付率;
    @CsvField(order = 370, name = "公費2給付率")
    private RString 公費2給付率;
    @CsvField(order = 380, name = "公費3給付率")
    private RString 公費3給付率;
    @CsvField(order = 390, name = "サービス日数・回数")
    private RString サービス日数_回数;
    @CsvField(order = 400, name = "サービス単位数")
    private RString サービス単位数;
    @CsvField(order = 410, name = "特定入所者介護サービス費等")
    private RString 特定入所者介護サービス費等;
    @CsvField(order = 420, name = "利用者負担額")
    private RString 利用者負担額;
    @CsvField(order = 430, name = "食事標準負担額")
    private RString 食事標準負担額;
    @CsvField(order = 440, name = "証記載保険者番号")
    private RString 証記載保険者番号;

    /**
     *
     * 証記載保険者番号列を出力しない
     *
     * @return ShikakuShogohyoInCsvEntity
     */
    public ShikakuShogohyoInCsvEntity to単一() {
        ShikakuShogohyoInCsvEntity 単一 = new ShikakuShogohyoInCsvEntity();
        単一.setサービス単位数(this.サービス単位数);
        単一.setサービス提供年月(this.サービス提供年月);
        単一.setサービス日数_回数(this.サービス日数_回数);
        単一.setサービス種類コード(this.サービス種類コード);
        単一.setサービス種類名(this.サービス種類名);
        単一.set事業者名(this.事業者名);
        単一.set事業者番号(this.事業者番号);
        単一.set作成日時(this.作成日時);
        単一.set保険給付率(this.保険給付率);
        単一.set保険者名(this.保険者名);
        単一.set保険者番号(this.保険者番号);
        単一.set公費1給付率(this.公費1給付率);
        単一.set公費2給付率(this.公費2給付率);
        単一.set公費3給付率(this.公費3給付率);
        単一.set利用者負担額(this.利用者負担額);
        単一.set単位数単価(this.単位数単価);
        単一.set審査年月(this.審査年月);
        単一.set居住費負担限度額_ユニット型個室(this.居住費負担限度額_ユニット型個室);
        単一.set居住費負担限度額_ユニット型準個室(this.居住費負担限度額_ユニット型準個室);
        単一.set居住費負担限度額_多床室(this.居住費負担限度額_多床室);
        単一.set居住費負担限度額_従来型個室_特養等(this.居住費負担限度額_従来型個室_特養等);
        単一.set居住費負担限度額_従来型個室_老健_療養等(this.居住費負担限度額_従来型個室_老健_療養等);
        単一.set居宅サービス計画作成区分(this.居宅サービス計画作成区分);
        単一.set居宅サービス計画作成区分コード(this.居宅サービス計画作成区分コード);
        単一.set支援事業者番号(this.支援事業者番号);
        単一.set旧措置入所者特例コード(this.旧措置入所者特例コード);
        単一.set旧措置入所者特例有無(this.旧措置入所者特例有無);
        単一.set特定入所者介護サービス費等(this.特定入所者介護サービス費等);
        単一.set被保険者氏名(this.被保険者氏名);
        単一.set被保険者番号(this.被保険者番号);
        単一.set要介護区分コード(this.要介護区分コード);
        単一.set要介護度(this.要介護度);
        単一.set訪問通所_短期入所支給限度額(this.訪問通所_短期入所支給限度額);
        単一.set認定有効期間_終了(this.認定有効期間_終了);
        単一.set認定有効期間_開始(this.認定有効期間_開始);
        単一.set警告種別(this.警告種別);
        単一.set連番(this.連番);
        単一.set限度額適用期間_終了(this.限度額適用期間_終了);
        単一.set限度額適用期間_開始(this.限度額適用期間_開始);
        単一.set食事標準負担額(this.食事標準負担額);
        単一.set食事標準負担額_日額(this.食事標準負担額_日額);
        単一.set食事標準負担額_月額(this.食事標準負担額_月額);
        単一.set食費負担限度額(this.食費負担限度額);
        return 単一;
    }
}
