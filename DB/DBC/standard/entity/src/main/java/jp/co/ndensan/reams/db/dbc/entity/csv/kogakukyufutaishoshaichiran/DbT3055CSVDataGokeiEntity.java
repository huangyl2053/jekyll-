/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishoshaichiran;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額介護サービス費給付対象者合計CsvField
 */
@Getter
@Setter
public class DbT3055CSVDataGokeiEntity {

    @CsvField(order = 10, name = "交換情報識別番号")
    private RString kokanShikibetsuNo;
    @CsvField(order = 20, name = "帳票レコード種別")
    private RString chouhyouCodeShubetsu;
    @CsvField(order = 30, name = "被保険者番号")
    private RString hihokenshaNo;
    @CsvField(order = 40, name = "サービス費用合計額合計")
    private Decimal serviceHiyoGokeiGakuGokei;
    @CsvField(order = 50, name = "利用者負担額合計")
    private Decimal riyoshaFutanGakuGokei;
    @CsvField(order = 60, name = "算定基準額")
    private Decimal santeiKijunGaku;
    @CsvField(order = 70, name = "支払済金額合計")
    private Decimal shiharaiSumiKingakuGokei;
    @CsvField(order = 80, name = "高額支給額")
    private Decimal kogakuShikyuGaku;
}
