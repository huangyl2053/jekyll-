/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc110060;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * DBCMNF1001-371_高額合算支給申請書情報作成のコントロールレコードです。
 *
 * @reamsid_L DBC-2630-030 sunqingzhu
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanShikyushinseishoOutCsvEntity {

    @CsvField(order = 10, name = "送付年月")
    private RString 送付年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 40, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 50, name = "№")
    private RString no;
    @CsvField(order = 60, name = "申請年度")
    private RString 申請年度;
    @CsvField(order = 70, name = "支給申請区分")
    private RString 支給申請区分;
    @CsvField(order = 80, name = "支給申請区分名")
    private RString 支給申請区分名;
    @CsvField(order = 90, name = "申請年月日")
    private RString 申請年月日;
    @CsvField(order = 100, name = "支給申請書整理番号")
    private RString 支給申請書整理番号;
    @CsvField(order = 110, name = "申請代表者氏名")
    private RString 申請代表者氏名;
    @CsvField(order = 120, name = "自己負担額証明交付申請有無区分")
    private RString 自己負担額証明交付申請有無区分;
    @CsvField(order = 130, name = "自己負担額証明交付申請有無")
    private RString 自己負担額証明交付申請有無;
    @CsvField(order = 140, name = "支給申請形態")
    private RString 支給申請形態;
    @CsvField(order = 150, name = "支給申請形態名")
    private RString 支給申請形態名;
    @CsvField(order = 160, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 170, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 180, name = "介護加入期間開始年月日")
    private RString 介護加入期間開始年月日;
    @CsvField(order = 190, name = "介護加入期間終了年月日")
    private RString 介護加入期間終了年月日;
    @CsvField(order = 200, name = "所得区分")
    private RString 所得区分;
    @CsvField(order = 210, name = "所得区分名")
    private RString 所得区分名;
    @CsvField(order = 220, name = "所得区分（70歳以上分）")
    private RString 所得区分_70歳以上分;
    @CsvField(order = 230, name = "所得区分名（70歳以上分）")
    private RString 所得区分名_70歳以上分;
    @CsvField(order = 240, name = "支給方法区分")
    private RString 支給方法区分;
    @CsvField(order = 250, name = "支給方法名")
    private RString 支給方法名;
    @CsvField(order = 260, name = "再送")
    private RString 再送;
    @CsvField(order = 270, name = "重複")
    private RString 重複;

}
