/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishosha;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護サービス費給付対象者のCsvEntity
 *
 * @reamsid_L DBC-0980-360 chenaoqi
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKyufuTaishoshaGokeiCsvEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "帳票レコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 50, name = "サービス費用合計額合計")
    private RString サービス費用合計額合計;
    @CsvField(order = 60, name = "利用者負担額合計")
    private RString 利用者負担額合計;
    @CsvField(order = 70, name = "算定基準額")
    private RString 算定基準額;
    @CsvField(order = 80, name = "支払済金額合計")
    private RString 支払済金額合計;
    @CsvField(order = 90, name = "高額支給額")
    private RString 高額支給額;
    @CsvField(order = 100, name = "ブランク")
    private RString ブランク;
}
