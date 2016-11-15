/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 普徴仮算定結果一覧表CSVのEntity。
 *
 * @reamsid_L DBB-0870-010 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutyoKarisanteiKekkaIcihiranDataCSVEntity {

    @CsvField(order = 1, name = "作成年月日")
    private RString 作成年月日;
    @CsvField(order = 2, name = "作成時刻")
    private RString 作成時刻;
    @CsvField(order = 3, name = "賦課年度")
    private RString 賦課年度;
    @CsvField(order = 4, name = "連番")
    private RString 連番;
    @CsvField(order = 5, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 6, name = "住所")
    private RString 住所;
    @CsvField(order = 7, name = "町域（管内）・管外住所")
    private RString 町域管内管外住所;
    @CsvField(order = 8, name = "番地")
    private RString 番地;
    @CsvField(order = 9, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 10, name = "行政区")
    private RString 行政区;
    @CsvField(order = 11, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 12, name = "性別")
    private RString 性別;
    @CsvField(order = 13, name = "世帯主名")
    private RString 世帯主名;
    @CsvField(order = 14, name = "通知書番号")
    private RString 通知書番号;
    @CsvField(order = 15, name = "世帯コード")
    private RString 世帯コード;
    @CsvField(order = 16, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 17, name = "特別徴収業務者コード")
    private RString 特別徴収業務者コード;
    @CsvField(order = 18, name = "特別徴収義務者")
    private RString 特別徴収義務者;
    @CsvField(order = 19, name = "特別徴収対象年金コード")
    private RString 特別徴収対象年金コード;
    @CsvField(order = 20, name = "特別徴収対象年金")
    private RString 特別徴収対象年金;
    @CsvField(order = 21, name = "特別徴収仮徴収額（4月）")
    private RString 特別徴収仮徴収額_4月;
    @CsvField(order = 22, name = "特別徴収仮徴収額（6月）")
    private RString 特別徴収仮徴収額_6月;
    @CsvField(order = 23, name = "特別徴収仮徴収額（8月）")
    private RString 特別徴収仮徴収額_8月;
    @CsvField(order = 24, name = "前年度情報の最終所得段階")
    private RString 前年度情報の最終所得段階;
    @CsvField(order = 25, name = "前年度情報の最終月別年額")
    private RString 前年度情報の最終月別年額;
    @CsvField(order = 26, name = "前年度情報の最終普徴額")
    private RString 前年度情報の最終普徴額;
    @CsvField(order = 27, name = "前年度情報の確定保険料額")
    private RString 前年度情報の確定保険料額;
    @CsvField(order = 28, name = "前年度情報の計算納期数")
    private RString 前年度情報の計算納期数;
    @CsvField(order = 29, name = "前年度情報の賦課納期数")
    private RString 前年度情報の賦課納期数;
    @CsvField(order = 30, name = "仮算定時保険料段階")
    private RString 仮算定時保険料段階;
    @CsvField(order = 31, name = "新規資格適用段階対象者")
    private RString 新規資格適用段階対象者;
    @CsvField(order = 32, name = "徴収方法")
    private RString 徴収方法;
    @CsvField(order = 33, name = "普通徴収仮徴収額（4月）")
    private RString 普通徴収仮徴収額_4月;
    @CsvField(order = 34, name = "普通徴収仮徴収額（5月）")
    private RString 普通徴収仮徴収額_5月;
    @CsvField(order = 35, name = "普通徴収仮徴収額（6月）")
    private RString 普通徴収仮徴収額_6月;
    @CsvField(order = 36, name = "普通徴収仮徴収額（7月）")
    private RString 普通徴収仮徴収額_7月;
    @CsvField(order = 37, name = "普通徴収仮徴収額（8月）")
    private RString 普通徴収仮徴収額_8月;
    @CsvField(order = 38, name = "普通徴収仮徴収額（9月）")
    private RString 普通徴収仮徴収額_9月;
    @CsvField(order = 39, name = "備考")
    private RString 備考;
}
