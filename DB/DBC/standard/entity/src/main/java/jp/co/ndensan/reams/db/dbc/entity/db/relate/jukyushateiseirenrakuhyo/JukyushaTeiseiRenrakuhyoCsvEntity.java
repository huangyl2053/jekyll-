/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushateiseirenrakuhyo;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBCZV00002_受給者訂正連絡票（CSV）Entity
 *
 * @reamsid_L DBC-2101-070 lijian
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaTeiseiRenrakuhyoCsvEntity {

    @CsvField(order = 10, name = "レコード種別1")
    private RString レコード種別1;
    @CsvField(order = 20, name = "レコード番号連1")
    private RString レコード番号連1;
    @CsvField(order = 30, name = "ボリュム通番")
    private RString ボリュム通番;
    @CsvField(order = 40, name = "レコード件数")
    private RString レコード件数;
    @CsvField(order = 50, name = "データ種別")
    private RString データ種別;
    @CsvField(order = 60, name = "福祉事務所特定番号")
    private RString 福祉事務所特定番号;
    @CsvField(order = 70, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 80, name = "事業所番号")
    private RString 事業所番号;
    @CsvField(order = 90, name = "都道府県番号")
    private RString 都道府県番号;
    @CsvField(order = 100, name = "媒体区分")
    private RString 媒体区分;
    @CsvField(order = 110, name = "処理対象年月")
    private RString 処理対象年月;
    @CsvField(order = 120, name = "ファイル管理番号")
    private RString ファイル管理番号;
    @CsvField(order = 130, name = "ブランク1")
    private RString ブランク1;
    @CsvField(order = 140, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 150, name = "レコード種別コード")
    private RString レコード種別コード;
    @CsvField(order = 160, name = "異動年月日")
    private RString 異動年月日;
    @CsvField(order = 170, name = "異動事由")
    private RString 異動事由;
    @CsvField(order = 180, name = "訂正年月日")
    private RString 訂正年月日;
    @CsvField(order = 190, name = "訂正区分コード")
    private RString 訂正区分コード;
    @CsvField(order = 200, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 210, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 220, name = "被保険者氏名カナ")
    private RString 被保険者氏名カナ;
    @CsvField(order = 230, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 240, name = "性別コード")
    private RString 性別コード;
    @CsvField(order = 250, name = "資格取得年月日")
    private RString 資格取得年月日;
    @CsvField(order = 260, name = "資格喪失年月日")
    private RString 資格喪失年月日;
    @CsvField(order = 270, name = "老人保健市町村番号")
    private RString 老人保健市町村番号;
    @CsvField(order = 270, name = "老人保健受給者番号")
    private RString 老人保健受給者番号;
    @CsvField(order = 290, name = "申請種別コード")
    private RString 申請種別コード;
    @CsvField(order = 300, name = "変更申請中区分コード")
    private RString 変更申請中区分コード;
    @CsvField(order = 310, name = "申請年月日")
    private RString 申請年月日;
    @CsvField(order = 320, name = "みなし要介護区分コード")
    private RString みなし要介護区分コード;
    @CsvField(order = 330, name = "要介護状態区分コード")
    private RString 要介護状態区分コード;
    @CsvField(order = 340, name = "認定有効期間開始年月日")
    private RString 認定有効期間開始年月日;
    @CsvField(order = 350, name = "認定有効期間終了年月日")
    private RString 認定有効期間終了年月日;
    @CsvField(order = 360, name = "居宅サービス計画作成区分コード")
    private RString 居宅サービス計画作成区分コード;
    @CsvField(order = 370, name = "居宅介護支援事業所番号")
    private RString 居宅介護支援事業所番号;
    @CsvField(order = 380, name = "居宅サービス計画適用開始年月日")
    private RString 居宅サービス計画適用開始年月日;
    @CsvField(order = 390, name = "居宅サービス計画適用終了年月日")
    private RString 居宅サービス計画適用終了年月日;
    @CsvField(order = 400, name = "訪問通所支給限度基準額")
    private RString 訪問通所支給限度基準額;
    @CsvField(order = 410, name = "訪問通所上限管理適用期間開始年月日")
    private RString 訪問通所上限管理適用期間開始年月日;
    @CsvField(order = 420, name = "訪問通所上限管理適用期間終了年月日")
    private RString 訪問通所上限管理適用期間終了年月日;
    @CsvField(order = 430, name = "短期入所支給限度基準額")
    private RString 短期入所支給限度基準額;
    @CsvField(order = 440, name = "短期入所上限管理適用期間開始年月日")
    private RString 短期入所上限管理適用期間開始年月日;
    @CsvField(order = 450, name = "短期入所上限管理適用期間終了年月日")
    private RString 短期入所上限管理適用期間終了年月日;
    @CsvField(order = 460, name = "公費負担上限額減額の有無")
    private RString 公費負担上限額減額の有無;
    @CsvField(order = 470, name = "償還払化開始年月日")
    private RString 償還払化開始年月日;
    @CsvField(order = 480, name = "償還払化終了年月日")
    private RString 償還払化終了年月日;
    @CsvField(order = 490, name = "給付率引下げ開始年月日")
    private RString 給付率引下げ開始年月日;
    @CsvField(order = 500, name = "給付率引下げ終了年月日")
    private RString 給付率引下げ終了年月日;
    @CsvField(order = 510, name = "旧措置入所者減免申請中区分コード")
    private RString 旧措置入所者減免申請中区分コード;
    @CsvField(order = 520, name = "旧措置入所者利用者負担区分コード")
    private RString 旧措置入所者利用者負担区分コード;
    @CsvField(order = 530, name = "旧措置入所者給付率")
    private RString 旧措置入所者給付率;
    @CsvField(order = 540, name = "旧措置入所者適用開始年月日")
    private RString 旧措置入所者適用開始年月日;
    @CsvField(order = 550, name = "旧措置入所者適用終了年月日")
    private RString 旧措置入所者適用終了年月日;
    @CsvField(order = 560, name = "特定標準負担標準負担区分コード")
    private RString 特定標準負担標準負担区分コード;
    @CsvField(order = 570, name = "特定標準負担標準負担額")
    private RString 特定標準負担標準負担額;
    @CsvField(order = 580, name = "特定標準負担負担額適用開始年月日")
    private RString 特定標準負担負担額適用開始年月日;
    @CsvField(order = 590, name = "特定標準負担負担額適用終了年月日")
    private RString 特定標準負担負担額適用終了年月日;
    @CsvField(order = 600, name = "特定入所者認定申請中区分コード")
    private RString 特定入所者認定申請中区分コード;
    @CsvField(order = 610, name = "特定入所者介護サービス区分コード")
    private RString 特定入所者介護サービス区分コード;
    @CsvField(order = 620, name = "課税層の特例減額措置対象")
    private RString 課税層の特例減額措置対象;
    @CsvField(order = 630, name = "食費負担限度額")
    private RString 食費負担限度額;
    @CsvField(order = 640, name = "居住費ユニット型個室負担限度額")
    private RString 居住費ユニット型個室負担限度額;
    @CsvField(order = 650, name = "居住費ユニット型準個室負担限度額")
    private RString 居住費ユニット型準個室負担限度額;
    @CsvField(order = 660, name = "居住費従来型個室特養等負担限度額")
    private RString 居住費従来型個室特養等負担限度額;
    @CsvField(order = 670, name = "居住費従来型個室老健療養等負担限度額")
    private RString 居住費従来型個室老健療養等負担限度額;
    @CsvField(order = 680, name = "居住費多床室負担限度額")
    private RString 居住費多床室負担限度額;
    @CsvField(order = 690, name = "負担限度額適用開始年月日")
    private RString 負担限度額適用開始年月日;
    @CsvField(order = 700, name = "負担限度額適用終了年月日")
    private RString 負担限度額適用終了年月日;
    @CsvField(order = 710, name = "社会福祉法人軽減情報軽減率")
    private RString 社会福祉法人軽減情報軽減率;
    @CsvField(order = 720, name = "軽減率適用開始年月日")
    private RString 軽減率適用開始年月日;
    @CsvField(order = 730, name = "軽減率適用終了年月日")
    private RString 軽減率適用終了年月日;
    @CsvField(order = 740, name = "小規模多機能型居宅介護利用の有無")
    private RString 小規模多機能型居宅介護利用の有無;
    @CsvField(order = 750, name = "後期高齢視者保険者番号後期")
    private RString 後期高齢視者保険者番号後期;
    @CsvField(order = 760, name = "後期高齢視者被保険者番号後期")
    private RString 後期高齢視者被保険者番号後期;
    @CsvField(order = 770, name = "国民健康保険資格保険者番号国保")
    private RString 国民健康保険資格保険者番号国保;
    @CsvField(order = 780, name = "国民健康保険資格被保険者証番号国保")
    private RString 国民健康保険資格被保険者証番号国保;
    @CsvField(order = 790, name = "国民健康保険資格個人番号国保")
    private RString 国民健康保険資格個人番号国保;
    @CsvField(order = 800, name = "二次予防事業区分コード")
    private RString 二次予防事業区分コード;
    @CsvField(order = 810, name = "二次予防事業有効期間開始年月日")
    private RString 二次予防事業有効期間開始年月日;
    @CsvField(order = 820, name = "二次予防事業有効期間終了年月日")
    private RString 二次予防事業有効期間終了年月日;
    @CsvField(order = 830, name = "住所地特例住所地特例対象者区分コード")
    private RString 住所地特例住所地特例対象者区分コード;
    @CsvField(order = 840, name = "住所地特例施設所在保険者番号")
    private RString 住所地特例施設所在保険者番号;
    @CsvField(order = 850, name = "住所地特例住所地特例適用開始年月日")
    private RString 住所地特例住所地特例適用開始年月日;
    @CsvField(order = 860, name = "住所地特例住所地特例適用終了年月日")
    private RString 住所地特例住所地特例適用終了年月日;
    @CsvField(order = 870, name = "居住費新１負担限度額")
    private RString 居住費新１負担限度額;
    @CsvField(order = 880, name = "居住費新２負担限度額")
    private RString 居住費新２負担限度額;
    @CsvField(order = 890, name = "居住費新３負担限度額")
    private RString 居住費新３負担限度額;
    @CsvField(order = 900, name = "二割負担適用開始年月日")
    private RString 二割負担適用開始年月日;
    @CsvField(order = 910, name = "二割負担適用終了年月日")
    private RString 二割負担適用終了年月日;
    @CsvField(order = 920, name = "レコード種別2")
    private RString レコード種別2;
    @CsvField(order = 930, name = "レコード番号連2")
    private RString レコード番号連2;
    @CsvField(order = 940, name = "レコード種別3")
    private RString レコード種別3;
    @CsvField(order = 950, name = "レコード番号連3")
    private RString レコード番号連3;
    @CsvField(order = 960, name = "ブランク2")
    private RString ブランク2;
    @CsvField(order = 970, name = "ブランク3")
    private RString ブランク3;

}
