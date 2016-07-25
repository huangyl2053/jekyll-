/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 様式別連携情報作成のＣＳＶを定義したEntityクラスです。
 *
 * @reamsid_L DBU-4050-020 lijia
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Setter
@lombok.Getter
public class JigyoHokokuRenkei24or26EucCsvEntity implements IJigyoHokokuRenkeiEucCsvEntity {

    @CsvField(order = 10, name = "先頭項目")
    private RString 先頭項目;
    @CsvField(order = 20, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 30, name = "レコード種別番号")
    private RString レコード種別番号;
    @CsvField(order = 40, name = "要支援１")
    private RString 要支援１;
    @CsvField(order = 50, name = "要支援２")
    private RString 要支援２;
    @CsvField(order = 60, name = "計（予防給付）")
    private RString 計_予防給付;
    @CsvField(order = 70, name = "経過的要介護")
    private RString 経過的要介護;
    @CsvField(order = 80, name = "要介護１")
    private RString 要介護１;
    @CsvField(order = 90, name = "要介護２")
    private RString 要介護２;
    @CsvField(order = 100, name = "要介護３")
    private RString 要介護３;
    @CsvField(order = 110, name = "要介護４")
    private RString 要介護４;
    @CsvField(order = 120, name = "要介護５")
    private RString 要介護５;
    @CsvField(order = 130, name = "計（介護給付）")
    private RString 計_介護給付;
    @CsvField(order = 140, name = "計")
    private RString 計;
}
