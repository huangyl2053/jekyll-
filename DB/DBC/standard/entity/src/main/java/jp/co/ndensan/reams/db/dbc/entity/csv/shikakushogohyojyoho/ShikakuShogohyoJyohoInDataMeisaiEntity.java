/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.shikakushogohyojyoho;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 資格照合表情報取込共通処理（CSVファイル取込）のMeisaiEntity。
 *
 * @reamsid_L DBC-2890-013 wangxue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuShogohyoJyohoInDataMeisaiEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "帳票レコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 50, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 60, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 70, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 80, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 90, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 100, name = "種別")
    private RString 種別;
    @CsvField(order = 110, name = "事業所番号")
    private RString 事業所番号;
    @CsvField(order = 120, name = "事業所名")
    private RString 事業所名;
    @CsvField(order = 130, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 140, name = "性別コード")
    private RString 性別コード;
    @CsvField(order = 150, name = "要介護区分コード")
    private RString 要介護区分コード;
    @CsvField(order = 160, name = "旧措置入所者特例コード")
    private RString 旧措置入所者特例コード;
    @CsvField(order = 170, name = "認定有効期間 開始年月日")
    private RString 認定有効期間_開始年月日;
    @CsvField(order = 180, name = "認定有効期間 開始年月日")
    private RString 認定有効期間_終了年月日;
    @CsvField(order = 190, name = "認定有効期間 終了年月日")
    private RString 限度額適用期間_開始年月日;
    @CsvField(order = 200, name = "限度額適用期間 終了年月日")
    private RString 限度額適用期間_終了年月日;
    @CsvField(order = 210, name = "支給限度額")
    private RString 支給限度額;
    @CsvField(order = 220, name = "居宅サービス計画作成区分コード")
    private RString 居宅サービス計画作成区分コード;
    @CsvField(order = 230, name = "支援事業所番号")
    private RString 支援事業所番号;
    @CsvField(order = 240, name = "食事標準負担額（月額）")
    private RString 食事標準負担額_月額;
    @CsvField(order = 250, name = "食事標準負担額（日額）")
    private RString 食事標準負担額_日額;
    @CsvField(order = 260, name = "食費負担限度額")
    private RString 食費負担限度額;
    @CsvField(order = 270, name = "居住費（ユニット型個室）負担限度額")
    private RString 居住費_負担限度額_1;
    @CsvField(order = 280, name = "居住費（ユニット型準個室）負担限度額")
    private RString 居住費_負担限度額_2;
    @CsvField(order = 290, name = "居住費（従来型個室（特養等））負担限度額")
    private RString 居住費_負担限度額_3;
    @CsvField(order = 300, name = "居住費（従来型個室（老健、療養等））負担限度額")
    private RString 居住費_負担限度額_4;
    @CsvField(order = 310, name = "居住費（多床室）負担限度額")
    private RString 居住費_負担限度額_5;
    @CsvField(order = 320, name = "単位数単価")
    private RString 単位数単価;
    @CsvField(order = 330, name = "保険給付率")
    private RString 保険給付率;
    @CsvField(order = 340, name = "公費１給付率")
    private RString 公費給付率_1;
    @CsvField(order = 350, name = "公費２給付率")
    private RString 公費給付率_2;
    @CsvField(order = 360, name = "公費３給付率")
    private RString 公費給付率_3;
    @CsvField(order = 370, name = "サービス日数・回数")
    private RString サービス日数_回数;
    @CsvField(order = 380, name = "サービス単位数")
    private RString サービス単位数;
    @CsvField(order = 390, name = "特定入所者介護サービス費等")
    private RString 特定入所者介護サービス費等;
    @CsvField(order = 400, name = "利用者負担額")
    private RString 利用者負担額;
    @CsvField(order = 410, name = "食事標準負担額")
    private RString 食事標準負担額;
    @CsvField(order = 420, name = "ブランク")
    private RString ブランク;
}
