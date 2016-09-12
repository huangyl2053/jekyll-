/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenjukyushain;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 国保連保有受給者情報取込CSVファイルレコード構成Entity
 *
 * @reamsid_L DBC-2740-010 fuyanling
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KokuhorenJukyushaDataCsvEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "異動年月日")
    private RString 異動年月日;
    @CsvField(order = 50, name = "訂正年月日")
    private RString 訂正年月日;
    @CsvField(order = 60, name = "異動区分コード")
    private RString 異動区分コード;
    @CsvField(order = 70, name = "異動事由")
    private RString 異動事由;
    @CsvField(order = 80, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 90, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 100, name = "被保険者氏名カナ")
    private RString 被保険者氏名カナ;
    @CsvField(order = 110, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 120, name = "性別コード")
    private RString 性別コード;
    @CsvField(order = 130, name = "資格取得年月日")
    private RString 資格取得年月日;
    @CsvField(order = 140, name = "資格喪失年月日")
    private RString 資格喪失年月日;
    @CsvField(order = 150, name = "老人保健市町村番号")
    private RString 老人保健市町村番号;
    @CsvField(order = 160, name = "老人保健受給者番号")
    private RString 老人保健受給者番号;
    @CsvField(order = 170, name = "公費負担者番号")
    private RString 公費負担者番号;
    @CsvField(order = 180, name = "広域連合政令市保険者番号")
    private RString 広域連合政令市保険者番号;
    @CsvField(order = 190, name = "申請種別コード")
    private RString 申請種別コード;
    @CsvField(order = 200, name = "変更申請中区分コード")
    private RString 変更申請中区分コード;
    @CsvField(order = 210, name = "申請年月日")
    private RString 申請年月日;
    @CsvField(order = 220, name = "みなし要介護区分コード")
    private RString みなし要介護区分コード;
    @CsvField(order = 230, name = "要介護状態区分コード")
    private RString 要介護状態区分コード;
    @CsvField(order = 240, name = "認定有効期間開始年月日")
    private RString 認定有効期間開始年月日;
    @CsvField(order = 250, name = "認定有効期間終了年月日")
    private RString 認定有効期間終了年月日;
    @CsvField(order = 260, name = "居宅サービス計画作成区分コード")
    private RString 居宅サービス計画作成区分コード;
    @CsvField(order = 270, name = "居宅介護支援事業所番号")
    private RString 居宅介護支援事業所番号;
    @CsvField(order = 280, name = "居宅サービス計画適用開始年月日")
    private RString 居宅サービス計画適用開始年月日;
    @CsvField(order = 290, name = "居宅サービス計画適用終了年月日")
    private RString 居宅サービス計画適用終了年月日;
    @CsvField(order = 300, name = "訪問通所サービス支給限度基準額")
    private RString 訪問通所サービス支給限度基準額;
    @CsvField(order = 310, name = "訪問通所サービス上限管理適用期間開始年月日")
    private RString 訪問通所サービス上限管理適用期間開始年月日;
    @CsvField(order = 320, name = "訪問通所サービス上限管理適用期間終了年月日")
    private RString 訪問通所サービス上限管理適用期間終了年月日;
    @CsvField(order = 330, name = "短期入所サービス支給限度基準額")
    private RString 短期入所サービス支給限度基準額;
    @CsvField(order = 340, name = "短期入所サービス上限管理適用期間開始年月日")
    private RString 短期入所サービス上限管理適用期間開始年月日;
    @CsvField(order = 350, name = "短期入所サービス上限管理適用期間終了年月日")
    private RString 短期入所サービス上限管理適用期間終了年月日;
    @CsvField(order = 360, name = "公費負担上限額減額の有無")
    private RString 公費負担上限額減額の有無;
    @CsvField(order = 370, name = "償還払化開始年月日")
    private RString 償還払化開始年月日;
    @CsvField(order = 380, name = "償還払化終了年月日")
    private RString 償還払化終了年月日;
    @CsvField(order = 390, name = "給付率引下げ開始年月日")
    private RString 給付率引下げ開始年月日;
    @CsvField(order = 400, name = "給付率引下げ終了年月日")
    private RString 給付率引下げ終了年月日;
    @CsvField(order = 410, name = "減免申請中区分コード")
    private RString 減免申請中区分コード;
    @CsvField(order = 420, name = "利用者負担減免旧措置入所者利用者負担区分コード")
    private RString 利用者負担減免旧措置入所者利用者負担区分コード;
    @CsvField(order = 430, name = "利用者負担減免旧措置入所者給付率")
    private RString 利用者負担減免旧措置入所者給付率;
    @CsvField(order = 440, name = "利用者負担減免旧措置入所者適用開始年月日")
    private RString 利用者負担減免旧措置入所者適用開始年月日;
    @CsvField(order = 450, name = "利用者負担減免旧措置入所者適用終了年月日")
    private RString 利用者負担減免旧措置入所者適用終了年月日;
    @CsvField(order = 460, name = "標準負担特定標準負担標準負担区分コード")
    private RString 標準負担特定標準負担標準負担区分コード;
    @CsvField(order = 470, name = "標準負担特定標準負担負担額")
    private RString 標準負担特定標準負担負担額;
    @CsvField(order = 480, name = "標準負担特定標準負担負担額適用開始年月日")
    private RString 標準負担特定標準負担負担額適用開始年月日;
    @CsvField(order = 490, name = "標準負担特定標準負担負担額適用終了年月日")
    private RString 標準負担特定標準負担負担額適用終了年月日;
    @CsvField(order = 500, name = "特定入所者介護サービス特定入所者認定申請中区分コード")
    private RString 特定入所者介護サービス特定入所者認定申請中区分コード;
    @CsvField(order = 510, name = "特定入所者介護サービス特定入所者介護サービス区分コード")
    private RString 特定入所者介護サービス特定入所者介護サービス区分コード;
    @CsvField(order = 520, name = "特定入所者介護サービス課税層の特例減額措置対象")
    private RString 特定入所者介護サービス課税層の特例減額措置対象;
    @CsvField(order = 530, name = "特定入所者介護サービス食費負担限度額")
    private RString 特定入所者介護サービス食費負担限度額;
    @CsvField(order = 540, name = "特定入所者介護サービス居住費ユニット型個室負担限度額")
    private RString 特定入所者介護サービス居住費ユニット型個室負担限度額;
    @CsvField(order = 550, name = "特定入所者介護サービス居住費ユニット型準個室負担限度額")
    private RString 特定入所者介護サービス居住費ユニット型準個室負担限度額;
    @CsvField(order = 560, name = "特定入所者介護サービス居住費従来型個室特養等負担限度額")
    private RString 特定入所者介護サービス居住費従来型個室特養等負担限度額;
    @CsvField(order = 570, name = "特定入所者介護サービス居住費従来型個室老健、療養等負担限度額")
    private RString 特定入所者介護サービス居住費従来型個室老健療養等負担限度額;
    @CsvField(order = 580, name = "特定入所者介護サービス居住費多床室負担限度額")
    private RString 特定入所者介護サービス居住費多床室負担限度額;
    @CsvField(order = 590, name = "特定入所者介護サービス負担限度額適用開始年月日")
    private RString 特定入所者介護サービス負担限度額適用開始年月日;
    @CsvField(order = 600, name = "特定入所者介護サービス負担限度額適用終了年月日")
    private RString 特定入所者介護サービス負担限度額適用終了年月日;
    @CsvField(order = 610, name = "社会福祉法人軽減情報軽減率")
    private RString 社会福祉法人軽減情報軽減率;
    @CsvField(order = 620, name = "社会福祉法人軽減情報軽減率適用開始年月日")
    private RString 社会福祉法人軽減情報軽減率適用開始年月日;
    @CsvField(order = 630, name = "社会福祉法人軽減情報軽減率適用終了年月日")
    private RString 社会福祉法人軽減情報軽減率適用終了年月日;
    @CsvField(order = 640, name = "小規模多機能型居宅介護の利用開始月における居宅サービス等の利用の有無")
    private RString 小規模多機能型居宅介護の利用開始月における居宅サービス等の利用の有無;
    @CsvField(order = 650, name = "後期高齢者医療資格保険者番号後期")
    private RString 後期高齢者医療資格保険者番号後期;
    @CsvField(order = 660, name = "後期高齢者医療資格被保険者番号後期")
    private RString 後期高齢者医療資格被保険者番号後期;
    @CsvField(order = 670, name = "国民健康保険資格保険者番号国保")
    private RString 国民健康保険資格保険者番号国保;
    @CsvField(order = 680, name = "国民健康保険資格被保険者証番号国保")
    private RString 国民健康保険資格被保険者証番号国保;
    @CsvField(order = 690, name = "国民健康保険資格宛名番号")
    private RString 国民健康保険資格宛名番号;
    @CsvField(order = 700, name = "二次予防事業区分コード")
    private RString 二次予防事業区分コード;
    @CsvField(order = 710, name = "二次予防事業有効期間開始年月日")
    private RString 二次予防事業有効期間開始年月日;
    @CsvField(order = 720, name = "二次予防事業有効期間終了年月日")
    private RString 二次予防事業有効期間終了年月日;
    @CsvField(order = 730, name = "住所地特例住所地特例対象者区分コード")
    private RString 住所地特例住所地特例対象者区分コード;
    @CsvField(order = 740, name = "住所地特例施設所在保険者番号")
    private RString 住所地特例施設所在保険者番号;
    @CsvField(order = 750, name = "住所地特例住所地特例適用開始年月日")
    private RString 住所地特例住所地特例適用開始年月日;
    @CsvField(order = 760, name = "住所地特例住所地特例適用終了年月日")
    private RString 住所地特例住所地特例適用終了年月日;
    @CsvField(order = 770, name = "特定入所者介護サービス居住費新１負担限度額")
    private RString 特定入所者介護サービス居住費新１負担限度額;
    @CsvField(order = 780, name = "特定入所者介護サービス居住費新２負担限度額")
    private RString 特定入所者介護サービス居住費新２負担限度額;
    @CsvField(order = 790, name = "特定入所者介護サービス居住費新３負担限度額")
    private RString 特定入所者介護サービス居住費新３負担限度額;
    @CsvField(order = 800, name = "二割負担適用開始年月日")
    private RString 二割負担適用開始年月日;
    @CsvField(order = 810, name = "二割負担終了開始年月日")
    private RString 二割負担終了開始年月日;
    @CsvField(order = 820, name = "有料老人ホーム等同意書の有無")
    private RString 有料老人ホーム等同意書の有無;

}
