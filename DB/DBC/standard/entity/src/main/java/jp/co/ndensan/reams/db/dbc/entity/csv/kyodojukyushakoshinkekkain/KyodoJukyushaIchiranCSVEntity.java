/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kyodojukyushakoshinkekkain;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 共同処理用受給者情報一覧表のCsvEntityです。
 *
 * @reamsid_L DBC-2780-010 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyodoJukyushaIchiranCSVEntity {

    @CsvField(order = 1, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 2, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 3, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 4, name = "基_被保険者番号")
    private RString 基_被保険者番号;
    @CsvField(order = 5, name = "基_異動年月日")
    private RString 基_異動年月日;
    @CsvField(order = 6, name = "基_異動区分")
    private RString 基_異動区分;
    @CsvField(order = 7, name = "基_異動区分名称")
    private RString 基_異動区分名称;
    @CsvField(order = 8, name = "基_異動事由")
    private RString 基_異動事由;
    @CsvField(order = 9, name = "基_異動事由名称")
    private RString 基_異動事由名称;
    @CsvField(order = 10, name = "基_訂正年月日")
    private RString 基_訂正年月日;
    @CsvField(order = 11, name = "基_訂正区分")
    private RString 基_訂正区分;
    @CsvField(order = 12, name = "基_訂正区分名称")
    private RString 基_訂正区分名称;
    @CsvField(order = 13, name = "基_行政区コード")
    private RString 基_行政区コード;
    @CsvField(order = 14, name = "基_行政区")
    private RString 基_行政区;
    @CsvField(order = 15, name = "基_順序")
    private RString 基_順序;
    @CsvField(order = 16, name = "基_証記載保険者番号")
    private RString 基_証記載保険者番号;
    @CsvField(order = 17, name = "基_被保険者カナ氏名")
    private RString 基_被保険者カナ氏名;
    @CsvField(order = 18, name = "基_被保険者氏名")
    private RString 基_被保険者氏名;
    @CsvField(order = 19, name = "基_電話番号")
    private RString 基_電話番号;
    @CsvField(order = 20, name = "基_郵便番号")
    private RString 基_郵便番号;
    @CsvField(order = 21, name = "基_町域コード")
    private RString 基_町域コード;
    @CsvField(order = 22, name = "基_住所カナ")
    private RString 基_住所カナ;
    @CsvField(order = 23, name = "基_住所")
    private RString 基_住所;
    @CsvField(order = 24, name = "償_異動年月日")
    private RString 償_異動年月日;
    @CsvField(order = 25, name = "償_異動区分")
    private RString 償_異動区分;
    @CsvField(order = 26, name = "償_異動区分名称")
    private RString 償_異動区分名称;
    @CsvField(order = 27, name = "償_異動事由")
    private RString 償_異動事由;
    @CsvField(order = 28, name = "償_異動事由名称")
    private RString 償_異動事由名称;
    @CsvField(order = 29, name = "償_訂正年月日")
    private RString 償_訂正年月日;
    @CsvField(order = 30, name = "償_訂正区分")
    private RString 償_訂正区分;
    @CsvField(order = 31, name = "償_訂正区分名称")
    private RString 償_訂正区分名称;
    @CsvField(order = 32, name = "償_差止開始日")
    private RString 償_差止開始日;
    @CsvField(order = 33, name = "償_差止終了日")
    private RString 償_差止終了日;
    @CsvField(order = 34, name = "償_差止区分")
    private RString 償_差止区分;
    @CsvField(order = 35, name = "償_差止区分名称")
    private RString 償_差止区分名称;
    @CsvField(order = 36, name = "償_差止金額")
    private RString 償_差止金額;
    @CsvField(order = 37, name = "高_異動年月日")
    private RString 高_異動年月日;
    @CsvField(order = 38, name = "高_異動区分")
    private RString 高_異動区分;
    @CsvField(order = 39, name = "高_異動区分名称")
    private RString 高_異動区分名称;
    @CsvField(order = 40, name = "高_異動事由")
    private RString 高_異動事由;
    @CsvField(order = 41, name = "高_異動事由名称")
    private RString 高_異動事由名称;
    @CsvField(order = 42, name = "高_訂正年月日")
    private RString 高_訂正年月日;
    @CsvField(order = 43, name = "高_訂正区分")
    private RString 高_訂正区分;
    @CsvField(order = 44, name = "高_訂正区分名称")
    private RString 高_訂正区分名称;
    @CsvField(order = 45, name = "高_世帯主被保番号")
    private RString 高_世帯主被保番号;
    @CsvField(order = 46, name = "高_世帯所得区分")
    private RString 高_世帯所得区分;
    @CsvField(order = 47, name = "高_世帯所得区分名称")
    private RString 高_世帯所得区分名称;
    @CsvField(order = 48, name = "高_所得区分")
    private RString 高_所得区分;
    @CsvField(order = 49, name = "高_所得区分名称")
    private RString 高_所得区分名称;
    @CsvField(order = 50, name = "高_第２段階")
    private RString 高_第２段階;
    @CsvField(order = 51, name = "高_第２段階名称")
    private RString 高_第２段階名称;
    @CsvField(order = 52, name = "高_支給申請書")
    private RString 高_支給申請書;
    @CsvField(order = 53, name = "高_支給申請書名称")
    private RString 高_支給申請書名称;
    @CsvField(order = 54, name = "高_年金受給有無")
    private RString 高_年金受給有無;
    @CsvField(order = 55, name = "高_年金受給有無名称")
    private RString 高_年金受給有無名称;

}
