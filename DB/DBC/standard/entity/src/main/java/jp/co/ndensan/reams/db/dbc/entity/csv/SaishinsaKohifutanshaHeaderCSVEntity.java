/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再審査決定通知書情報取込（公費負担者分）ヘッダ部
 *
 * @reamsid_L DBC-2820-010 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaKohifutanshaHeaderCSVEntity {

    @CsvField(order = 10, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 20, name = "取扱年月")
    private RString 取扱年月;
    @CsvField(order = 30, name = "公費負担者番号")
    private RString 公費負担者番号;
    @CsvField(order = 40, name = "公費負担者名")
    private RString 公費負担者名;
    @CsvField(order = 50, name = "作成年月日")
    private RString 作成年月日;
    @CsvField(order = 60, name = "頁")
    private RString 頁;
    @CsvField(order = 70, name = "国保連合会名")
    private RString 国保連合会名;
    @CsvField(order = 80, name = "審査委員会名")
    private RString 審査委員会名;
}
