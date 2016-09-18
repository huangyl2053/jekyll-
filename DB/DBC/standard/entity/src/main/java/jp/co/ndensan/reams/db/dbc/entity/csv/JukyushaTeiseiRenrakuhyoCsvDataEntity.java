/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票設計_DBCZV00002_受給者訂正連絡票（CSV）CsvDataEntity
 *
 * @reamsid_L DBC-2720-091 surun
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaTeiseiRenrakuhyoCsvDataEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号（連）")
    private RString レコード番号連;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "レコード種別コード")
    private RString レコード種別コード;
    @CsvField(order = 50, name = "異動年月日")
    private RString 異動年月日;
    @CsvField(order = 60, name = "異動事由")
    private RString 異動事由;
    @CsvField(order = 70, name = "訂正年月日")
    private RString 訂正年月日;
    @CsvField(order = 80, name = "訂正区分コード")
    private RString 訂正区分コード;
    @CsvField(order = 90, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 100, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 110, name = "被保険者氏名（カナ）")
    private RString 被保険者氏名カナ;
    @CsvField(order = 120, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 130, name = "性別コード")
    private RString 性別コード;
    @CsvField(order = 140, name = "資格取得年月日")
    private RString 資格取得年月日;
    @CsvField(order = 150, name = "資格喪失年月日")
    private RString 資格喪失年月日;
    @CsvField(order = 160, name = "老人保健市町村番号")
    private RString 老人保健市町村番号;
    @CsvField(order = 170, name = "老人保健受給者番号")
    private RString 老人保健受給者番号;
    @CsvField(order = 180, name = "申請種別コード")
    private RString 申請種別コード;
    @CsvField(order = 190, name = "変更申請中区分コード")
    private RString 変更申請中区分コード;
    @CsvField(order = 200, name = "申請年月日")
    private RString 申請年月日;
    @CsvField(order = 210, name = "みなし要介護区分コード")
    private RString みなし要介護区分コード;
    @CsvField(order = 220, name = "要介護状態区分コード")
    private RString 要介護状態区分コード;
    @CsvField(order = 230, name = "認定有効期間（開始年月日）")
    private RString 認定有効期間開始年月日;
    @CsvField(order = 240, name = "認定有効期間（終了年月日）")
    private RString 認定有効期間終了年月日;
    @CsvField(order = 250, name = "居宅サービス計画作成区分コード")
    private RString 居宅サービス計画作成区分コード;
    @CsvField(order = 260, name = "居宅介護支援事業所番号")
    private RString 居宅介護支援事業所番号;
    @CsvField(order = 270, name = "居宅サービス計画適用開始年月日")
    private RString 居宅サービス計画適用開始年月日;
    @CsvField(order = 280, name = "居宅サービス計画適用終了年月日")
    private RString 居宅サービス計画適用終了年月日;
    @CsvField(order = 290, name = "訪問通所サービス　支給限度基準額")
    private RString 訪問通所サービス_支給限度基準額;
    @CsvField(order = 300, name = "訪問通所サービス　上限管理適用期間開始年月日")
    private RString 訪問通所サービス_上限管理適用期間開始年月日;
    @CsvField(order = 310, name = "訪問通所サービス　上限管理適用期間終了年月日")
    private RString 訪問通所サービス_上限管理適用期間終了年月日;
    @CsvField(order = 320, name = "短期入所サービス　支給限度基準額")
    private RString 短期入所サービス_支給限度基準額;
    @CsvField(order = 330, name = "短期入所サービス　上限管理適用期間開始年月日")
    private RString 短期入所サービス_上限管理適用期間開始年月日;
    @CsvField(order = 340, name = "短期入所サービス　上限管理適用期間終了年月日")
    private RString 短期入所サービス_上限管理適用期間終了年月日;
    @CsvField(order = 350, name = "公費負担上限額減額の有無")
    private RString 公費負担上限額減額の有無;
    @CsvField(order = 360, name = "償還払化開始年月日")
    private RString 償還払化開始年月日;
    @CsvField(order = 370, name = "償還払化終了年月日")
    private RString 償還払化終了年月日;
    @CsvField(order = 380, name = "給付率引下げ開始年月日")
    private RString 給付率引下げ開始年月日;
    @CsvField(order = 390, name = "給付率引下げ終了年月日")
    private RString 給付率引下げ終了年月日;
    @CsvField(order = 400, name = "利用者負担減免・旧措置入所者　減免申請中区分コード")
    private RString 利用者負担減免_旧措置入所者_減免申請中区分コード;
    @CsvField(order = 410, name = "利用者負担減免・旧措置入所者　利用者負担区分コード")
    private RString 利用者負担減免_旧措置入所者_利用者負担区分コード;
    @CsvField(order = 420, name = "利用者負担減免・旧措置入所者　給付率")
    private RString 利用者負担減免_旧措置入所者_給付率;
    @CsvField(order = 430, name = "利用者負担減免・旧措置入所者　適用開始年月日")
    private RString 利用者負担減免_旧措置入所者_適用開始年月日;
    @CsvField(order = 440, name = "利用者負担減免・旧措置入所者　適用終了年月日")
    private RString 利用者負担減免_旧措置入所者_適用終了年月日;
    @CsvField(order = 450, name = "特定標準負担・標準負担　標準負担区分コード")
    private RString 特定標準負担_標準負担_標準負担区分コード;
    @CsvField(order = 460, name = "特定標準負担・標準負担　負担額")
    private RString 特定標準負担_標準負担_負担額;
    @CsvField(order = 470, name = "特定標準負担・標準負担　負担額適用開始年月日")
    private RString 特定標準負担_標準負担_負担額適用開始年月日;
    @CsvField(order = 480, name = "特定標準負担・標準負担　負担額適用終了年月日")
    private RString 特定標準負担_標準負担_負担額適用終了年月日;
    @CsvField(order = 490, name = "特定入所者介護サービス　特定入所者認定申請中区分コード")
    private RString 特定入所者介護サービス_特定入所者認定申請中区分コード;
    @CsvField(order = 500, name = "特定入所者介護サービス　特定入所者介護サービス区分コード")
    private RString 特定入所者介護サービス_特定入所者介護サービス区分コード;
    @CsvField(order = 510, name = "特定入所者介護サービス　課税層の特例減額措置対象")
    private RString 特定入所者介護サービス_課税層の特例減額措置対象;
    @CsvField(order = 520, name = "特定入所者介護サービス　食費負担限度額")
    private RString 特定入所者介護サービス_食費負担限度額;
    @CsvField(order = 530, name = "特定入所者介護サービス　居住費（ユニット型個室）負担限度額")
    private RString 特定入所者介護サービス_居住費ユニット型個室負担限度額;
    @CsvField(order = 540, name = "特定入所者介護サービス　居住費（ユニット型準個室）負担限度額")
    private RString 特定入所者介護サービス_居住費ユニット型準個室負担限度額;
    @CsvField(order = 550, name = "特定入所者介護サービス　居住費（従来型個室（特養等））負担限度額")
    private RString 特定入所者介護サービス_居住費従来型個室特養等負担限度額;
    @CsvField(order = 560, name = "特定入所者介護サービス　居住費（従来型個室（老健、療養等））負担限度額")
    private RString 特定入所者介護サービス_居住費従来型個室老健療養等負担限度額;
    @CsvField(order = 570, name = "特定入所者介護サービス　居住費（多床室）負担限度額")
    private RString 特定入所者介護サービス_居住費多床室負担限度額;
    @CsvField(order = 580, name = "特定入所者介護サービス　負担限度額適用開始年月日")
    private RString 特定入所者介護サービス_負担限度額適用開始年月日;
    @CsvField(order = 590, name = "特定入所者介護サービス　負担限度額適用終了年月日")
    private RString 特定入所者介護サービス_負担限度額適用終了年月日;
    @CsvField(order = 600, name = "社会福祉法人軽減情報　軽減率")
    private RString 社会福祉法人軽減情報_軽減率;
    @CsvField(order = 610, name = "社会福祉法人軽減情報　軽減率適用開始年月日")
    private RString 社会福祉法人軽減情報_軽減率適用開始年月日;
    @CsvField(order = 620, name = "社会福祉法人軽減情報　軽減率適用終了年月日")
    private RString 社会福祉法人軽減情報_軽減率適用終了年月日;
    @CsvField(order = 630, name = "小規模多機能型居宅介護の利用開始月における居宅サービス等の利用の有無")
    private RString 小規模多機能型居宅介護の利用開始月における居宅サービス等の利用の有無;
    @CsvField(order = 640, name = "医療資格　後期高齢視者　保険者番号（後期）")
    private RString 医療資格_後期高齢視者_保険者番号後期;
    @CsvField(order = 650, name = "医療資格　後期高齢視者　被保険者番号（後期）")
    private RString 医療資格_後期高齢視者_被保険者番号後期;
    @CsvField(order = 660, name = "国民健康保険資格　保険者番号（国保）")
    private RString 国民健康保険資格_保険者番号国保;
    @CsvField(order = 670, name = "国民健康保険資格　被保険者証番号（国保）")
    private RString 国民健康保険資格_被保険者証番号国保;
    @CsvField(order = 680, name = "国民健康保険資格　個人番号（国保）")
    private RString 国民健康保険資格_個人番号国保;
    @CsvField(order = 690, name = "二次予防事業区分コード")
    private RString 二次予防事業区分コード;
    @CsvField(order = 700, name = "二次予防事業有効期間開始年月日")
    private RString 二次予防事業有効期間開始年月日;
    @CsvField(order = 710, name = "二次予防事業有効期間終了年月日")
    private RString 二次予防事業有効期間終了年月日;
    @CsvField(order = 720, name = "住所地特例　住所地特例対象者区分コード")
    private RString 住所地特例_住所地特例対象者区分コード;
    @CsvField(order = 730, name = "住所地特例　施設所在保険者番号")
    private RString 住所地特例_施設所在保険者番号;
    @CsvField(order = 740, name = "住所地特例　住所地特例適用開始年月日")
    private RString 住所地特例_住所地特例適用開始年月日;
    @CsvField(order = 750, name = "住所地特例　住所地特例適用終了年月日")
    private RString 住所地特例_住所地特例適用終了年月日;
    @CsvField(order = 760, name = "特定入所者介護サービス　居住費（新１）負担限度額")
    private RString 特定入所者介護サービス_居住費新１負担限度額;
    @CsvField(order = 770, name = "特定入所者介護サービス　居住費（新２）負担限度額")
    private RString 特定入所者介護サービス_居住費新２負担限度額;
    @CsvField(order = 780, name = "特定入所者介護サービス　居住費（新３）負担限度額")
    private RString 特定入所者介護サービス_居住費新３負担限度額;
    @CsvField(order = 790, name = "二割負担　適用開始年月日")
    private RString 二割負担_適用開始年月日;
    @CsvField(order = 800, name = "二割負担　適用終了年月日")
    private RString 二割負担_適用終了年月日;
    @CsvField(order = 810, name = "ブランク")
    private RString ブランク;

}
