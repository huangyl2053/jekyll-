/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc020070;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 総合事業分支給額計算結果一覧表CSVクラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class GassanJigyobunShikyugakuKeisanKekkaIchiranEntity {

    @CsvField(order = 1, name = "通番")
    private RString 通番;
    @CsvField(order = 2, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 3, name = "対象年度")
    private RString 対象年度;
    @CsvField(order = 4, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 5, name = "支給申請書整理番号")
    private RString 支給申請書整理番号;
    @CsvField(order = 6, name = "氏名カナ")
    private RString 氏名カナ;
    @CsvField(order = 7, name = "氏名")
    private RString 氏名;
    @CsvField(order = 8, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 9, name = "明細通番")
    private RString 明細通番;
    @CsvField(order = 10, name = "データ内容")
    private RString データ内容;
    @CsvField(order = 11, name = "保険制度コード")
    private RString 保険制度コード;
    @CsvField(order = 12, name = "自己負担額証明書整理番号")
    private RString 自己負担額証明書整理番号;
    @CsvField(order = 13, name = "対象計算期間（開始）")
    private RString 対象計算期間_開始;
    @CsvField(order = 14, name = "対象計算期間（終了）")
    private RString 対象計算期間_終了;
    @CsvField(order = 15, name = "世帯負担総額")
    private RString 世帯負担総額;
    @CsvField(order = 16, name = "介護等合算一部負担金等世帯合算額")
    private RString 介護等合算一部負担金等世帯合算額;
    @CsvField(order = 17, name = "70歳以上介護等合算一部負担金等世帯合算額")
    private RString 七十歳以上介護等合算一部負担金等世帯合算額;
    @CsvField(order = 18, name = "所得区分")
    private RString 所得区分;
    @CsvField(order = 19, name = "70歳以上の者に係る所得区分")
    private RString 七十歳以上の者に係る所得区分;
    @CsvField(order = 20, name = "介護等合算算定基準額")
    private RString 介護等合算算定基準額;
    @CsvField(order = 21, name = "70歳以上介護等合算算定基準額")
    private RString 七十歳以上介護等合算算定基準額;
    @CsvField(order = 22, name = "世帯支給総額")
    private RString 世帯支給総額;
    @CsvField(order = 23, name = "うち70歳以上分世帯支給総額")
    private RString うち70歳以上分世帯支給総額;
    @CsvField(order = 24, name = "按分後支給額")
    private RString 按分後支給額;
    @CsvField(order = 25, name = "うち70歳以上分按分後支給額")
    private RString うち70歳以上分按分後支給額;
    @CsvField(order = 26, name = "介護低所得者Ⅰ再計算実施の有無")
    private RString 介護低所得者Ⅰ再計算実施の有無;
    @CsvField(order = 27, name = "備考")
    private RString 備考;
    @CsvField(order = 28, name = "支給額計算結果連絡先郵便番号")
    private RString 支給額計算結果連絡先郵便番号;
    @CsvField(order = 29, name = "支給額計算結果連絡先住所")
    private RString 支給額計算結果連絡先住所;
    @CsvField(order = 30, name = "支給額計算結果連絡先名称1")
    private RString 支給額計算結果連絡先名称1;
    @CsvField(order = 31, name = "支給額計算結果連絡先名称2")
    private RString 支給額計算結果連絡先名称2;
    @CsvField(order = 32, name = "保険制度コード")
    private RString 支給額明細_保険制度コード;
    @CsvField(order = 33, name = "内訳保険者番号")
    private RString 内訳保険者番号;
    @CsvField(order = 34, name = "国保 被保険者証記号")
    private RString 国保_被保険者証記号;
    @CsvField(order = 35, name = "被保険者（証）番号")
    private RString 被保険者_証番号;
    @CsvField(order = 36, name = "内訳保険者名")
    private RString 内訳保険者名;
    @CsvField(order = 37, name = "自己負担額証明書整理番号")
    private RString 支給額明細_自己負担額証明書整理番号;
    @CsvField(order = 38, name = "対象者氏名（漢字）")
    private RString 対象者氏名_漢字;
    @CsvField(order = 39, name = "① 70歳以上負担額")
    private RString 一七十歳以上負担額;
    @CsvField(order = 40, name = "② 70歳以上按分率")
    private RString 二七十歳以上按分率;
    @CsvField(order = 41, name = "③ ①にかかる支給額")
    private RString 三一にかかる支給額;
    @CsvField(order = 42, name = "④ 70歳未満負担額")
    private RString 四七十歳未満負担額;
    @CsvField(order = 43, name = "⑤ ④＋（①－③）")
    private RString 五四一三;
    @CsvField(order = 44, name = "⑥ 按分率")
    private RString 按分率;
    @CsvField(order = 45, name = "⑦ ⑤に係る支給額")
    private RString 七五に係る支給額;
    @CsvField(order = 46, name = "⑧ ③＋⑦")
    private RString 八三七;
    @CsvField(order = 47, name = "備考欄記載70歳以上負担額（平成20年4月～7月分）")
    private RString 備考欄記載70歳以上負担額_平成20年4月_7月分;
    @CsvField(order = 48, name = "備考欄記載70歳未満負担額（平成20年4月～7月分）")
    private RString 備考欄記載70歳未満負担額_平成20年4月_7月分;
    @CsvField(order = 49, name = "決定情報-支給額再計算")
    private RString 決定情報_支給額再計算;
    @CsvField(order = 50, name = "決定情報-支給区分")
    private RString 決定情報_支給区分;
    @CsvField(order = 51, name = "決定情報-世帯負担総額")
    private RString 決定情報_世帯負担総額;
    @CsvField(order = 52, name = "決定情報-支給額")
    private RString 決定情報_支給額;
    @CsvField(order = 53, name = "決定情報-支払方法引き継ぎ元")
    private RString 決定情報_支払方法引き継ぎ元;
    @CsvField(order = 54, name = "決定情報-支払方法区分")
    private RString 決定情報_支払方法区分;
    @CsvField(order = 55, name = "決定情報-支払場所")
    private RString 決定情報_支払場所;
    @CsvField(order = 56, name = "決定情報-支払期間開始日")
    private RString 決定情報_支払期間開始日;
    @CsvField(order = 57, name = "決定情報-支払期間終了日")
    private RString 決定情報_支払期間終了日;
    @CsvField(order = 58, name = "決定情報-支払期間開始日（開始時間）")
    private RString 決定情報_支払期間開始日_開始時間;
    @CsvField(order = 59, name = "決定情報-支払期間終了日（終了時間）")
    private RString 決定情報_支払期間終了日_終了時間;
    @CsvField(order = 60, name = "決定情報-金融機関コード")
    private RString 決定情報_金融機関コード;
    @CsvField(order = 61, name = "決定情報-金融機関名")
    private RString 決定情報_金融機関名;
    @CsvField(order = 62, name = "決定情報-金融機関支店コード")
    private RString 決定情報_金融機関支店コード;
    @CsvField(order = 63, name = "決定情報-金融機関支店名")
    private RString 決定情報_金融機関支店名;
    @CsvField(order = 64, name = "決定情報-口座種目")
    private RString 決定情報_口座種目;
    @CsvField(order = 65, name = "決定情報-口座種目名")
    private RString 決定情報_口座種目名;
    @CsvField(order = 66, name = "決定情報-口座番号")
    private RString 決定情報_口座番号;
    @CsvField(order = 67, name = "決定情報-口座名義人（カナ）")
    private RString 決定情報_口座名義人_カナ;
    @CsvField(order = 68, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 69, name = "住所コード")
    private RString 住所コード;
    @CsvField(order = 70, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 71, name = "市町村コード")
    private RString 市町村コード;

}
