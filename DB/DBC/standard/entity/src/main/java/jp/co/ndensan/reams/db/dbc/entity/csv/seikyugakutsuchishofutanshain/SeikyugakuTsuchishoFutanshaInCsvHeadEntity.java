/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.seikyugakutsuchishofutanshain;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 請求額通知書情報取込共通処理（CSVファイル取込・公費負担者分）のheadEntity
 *
 * @reamsid_L DBC-2790-011 hemin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikyugakuTsuchishoFutanshaInCsvHeadEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "帳票レコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 50, name = "公費負担者番号")
    private RString 公費負担者番号;
    @CsvField(order = 60, name = "公費負担者名")
    private RString 公費負担者名;
    @CsvField(order = 70, name = "款コード")
    private RString 款コード;
    @CsvField(order = 80, name = "款名")
    private RString 款名;
    @CsvField(order = 90, name = "項コード")
    private RString 項コード;
    @CsvField(order = 100, name = "項名")
    private RString 項名;
    @CsvField(order = 110, name = "審査年月")
    private RString 審査年月;
    @CsvField(order = 120, name = "作成年月日")
    private RString 作成年月日;
    @CsvField(order = 130, name = "頁")
    private RString 頁;
    @CsvField(order = 140, name = "国保連合会名")
    private RString 国保連合会名;
    @CsvField(order = 150, name = "ブランク")
    private RString ブランク;

}
