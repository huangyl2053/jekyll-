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
 * 高額合算支給申請書情報作成の送付ファイルのヘッダレコードです。
 *
 * @reamsid_L DBC-2630-030 wangxue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanShinseishoSofuFileHeadEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号（連番）")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "データレコード種別")
    private RString データレコード種別;
    @CsvField(order = 50, name = "提出保険者番号")
    private RString 提出保険者番号;
    @CsvField(order = 60, name = "支給申請書整理番号")
    private RString 支給申請書整理番号;
    @CsvField(order = 70, name = "支給申請区分")
    private RString 支給申請区分;
    @CsvField(order = 80, name = "支給申請形態")
    private RString 支給申請形態;
    @CsvField(order = 90, name = "申請代表者氏名（漢字）")
    private RString 申請代表者氏名;
    @CsvField(order = 100, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 110, name = "住所（漢字）")
    private RString 住所;
    @CsvField(order = 120, name = "電話番号")
    private RString 電話番号;
    @CsvField(order = 130, name = "申請年月日")
    private RString 申請年月日;
    @CsvField(order = 140, name = "自己負担額証明書交付申請の有無")
    private RString 自己負担額証明書交付申請の有無;

}
