/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc110070;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算支給額計算結果情報作成のヘッダーレコードです。
 *
 * @reamsid_L DBC-2670-030 zhaowei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanKeisanKekkaRenrakuJohoHeadEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号（連番）")
    private RString レコード番号_連番;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "レコード種別")
    private RString レコード種別２;
    @CsvField(order = 50, name = "連絡票整理番号")
    private RString 連絡票整理番号;
    @CsvField(order = 60, name = "保険制度コード")
    private RString 保険制度コード;
    @CsvField(order = 70, name = "対象年度")
    private RString 対象年度;
    @CsvField(order = 80, name = "自己負担額証明書整理番号")
    private RString 自己負担額証明書整理番号;
    @CsvField(order = 90, name = "支給対象者氏名（カナ）")
    private RString 支給対象者氏名_カナ;
    @CsvField(order = 100, name = "支給対象者氏名（漢字）")
    private RString 支給対象者氏名_漢字;
    @CsvField(order = 110, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 120, name = "性別")
    private RString 性別;
    @CsvField(order = 130, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 140, name = "被保険者証記号")
    private RString 被保険者証記号;
    @CsvField(order = 150, name = "被保険者（証）番号")
    private RString 被保険者_証_番号;
    @CsvField(order = 160, name = "計算対象期間開始年月日")
    private RString 計算対象期間開始年月日;
    @CsvField(order = 170, name = "計算対象期間終了年月日")
    private RString 計算対象期間終了年月日;
    @CsvField(order = 180, name = "世帯負担総額")
    private RString 世帯負担総額;
    @CsvField(order = 190, name = "介護等合算一部負担金等世帯合算額")
    private RString 介護等合算一部負担金等世帯合算額;
    @CsvField(order = 200, name = "70歳以上介護等合算一部負担金等世帯合算額")
    private RString ななじゅう歳以上介護等合算一部負担金等世帯合算額;
    @CsvField(order = 210, name = "所得区分")
    private RString 所得区分;
    @CsvField(order = 220, name = "70歳以上の者に係る所得区分")
    private RString ななじゅう歳以上の者に係る所得区分;
    @CsvField(order = 230, name = "介護等合算算定基準額")
    private RString 介護等合算算定基準額;
    @CsvField(order = 240, name = "70歳以上介護等合算算定基準額")
    private RString ななじゅう歳以上介護等合算算定基準額;
    @CsvField(order = 250, name = "世帯支給総額")
    private RString 世帯支給総額;
    @CsvField(order = 260, name = "うち70歳以上分世帯支給総額")
    private RString うち70歳以上分世帯支給総額;
    @CsvField(order = 270, name = "按分後支給額")
    private RString 按分後支給額;
    @CsvField(order = 280, name = "うち70歳以上分按分後支給額")
    private RString うち70歳以上分按分後支給額;
    @CsvField(order = 290, name = "介護低所得者Ⅰ再計算実施の有無")
    private RString 介護低所得者Ⅰ再計算実施の有無;
    @CsvField(order = 300, name = "備考")
    private RString 備考;
    @CsvField(order = 310, name = "支給額計算結果連絡先郵便番号")
    private RString 支給額計算結果連絡先郵便番号;
    @CsvField(order = 320, name = "支給額計算結果連絡先住所")
    private RString 支給額計算結果連絡先住所;
    @CsvField(order = 330, name = "支給額計算結果連絡先名称1")
    private RString 支給額計算結果連絡先名称1;
    @CsvField(order = 340, name = "支給額計算結果連絡先名称2")
    private RString 支給額計算結果連絡先名称2;
    @CsvField(order = 350, name = "通知年月日")
    private RString 通知年月日;
    @CsvField(order = 360, name = "連絡票発行者名")
    private RString 連絡票発行者名;
    @CsvField(order = 370, name = "連絡票発行者郵便番号")
    private RString 連絡票発行者郵便番号;
    @CsvField(order = 380, name = "連絡票発行者住所")
    private RString 連絡票発行者住所;
    @CsvField(order = 390, name = "問い合わせ先郵便番号")
    private RString 問い合わせ先郵便番号;
    @CsvField(order = 400, name = "問い合わせ先住所")
    private RString 問い合わせ先住所;
    @CsvField(order = 410, name = "問い合わせ先名称1")
    private RString 問い合わせ先名称1;
    @CsvField(order = 420, name = "問い合わせ先名称2")
    private RString 問い合わせ先名称2;
    @CsvField(order = 430, name = "問い合わせ先電話番号")
    private RString 問い合わせ先電話番号;
}
