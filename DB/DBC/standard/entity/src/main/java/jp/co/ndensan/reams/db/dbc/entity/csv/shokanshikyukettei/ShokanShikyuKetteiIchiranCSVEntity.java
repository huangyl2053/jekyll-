/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.shokanshikyukettei;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 償還払支給決定情報取込帳票CSVEntity
 *
 * @reamsid_L DBC-0980-330 gongliang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanShikyuKetteiIchiranCSVEntity {

    @CsvField(order = 10, name = "処理年月")
    private RString 処理年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "国保連合会名")
    private RString 国保連合会名;
    @CsvField(order = 40, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 50, name = "証記載保険者名")
    private RString 証記載保険者名;
    @CsvField(order = 60, name = "決定通知№")
    private RString 通知書番号;
    @CsvField(order = 70, name = "整理番号")
    private RString 整理番号;
    @CsvField(order = 80, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 90, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 100, name = "町域コード")
    private RString 町域コード;
    @CsvField(order = 110, name = "住所")
    private RString 住所;
    @CsvField(order = 120, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 130, name = "行政区名")
    private RString 行政区名;
    @CsvField(order = 140, name = "事業者番号")
    private RString 事業者番号;
    @CsvField(order = 150, name = "事業者名")
    private RString 事業者名;
    @CsvField(order = 160, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 170, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 180, name = "サービス種類")
    private RString サービス種類;
    @CsvField(order = 190, name = "単位数／金額")
    private RString 単位数_金額;
    @CsvField(order = 200, name = "増減点")
    private RString 増減点;
    @CsvField(order = 210, name = "支払金額")
    private RString 支払金額;
    @CsvField(order = 220, name = "支払方法区分")
    private RString 支払方法区分;
    @CsvField(order = 230, name = "支払方法")
    private RString 支払方法;
    @CsvField(order = 240, name = "資格喪失事由コード")
    private RString 資格喪失事由コード;
    @CsvField(order = 250, name = "資格喪失事由")
    private RString 資格喪失事由;
    @CsvField(order = 260, name = "資格喪失日")
    private RString 資格喪失日;
    @CsvField(order = 270, name = "備考")
    private RString 備考;
    @CsvField(order = 280, name = "更新DB無")
    private RString 更新DB無;

}
