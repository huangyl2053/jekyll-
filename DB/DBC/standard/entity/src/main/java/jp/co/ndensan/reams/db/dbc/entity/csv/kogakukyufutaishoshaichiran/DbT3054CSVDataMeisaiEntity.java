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
 * 高額介護サービス費給付対象者明細CsvField
 *
 * @reamsid_L DBB-0890-040 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbT3054CSVDataMeisaiEntity {

    @CsvField(order = 10, name = "交換情報識別番号")
    private RString kokanShikibetsuNo;
    @CsvField(order = 20, name = "帳票レコード種別")
    private RString chouhyouCodeShubetsu;
    @CsvField(order = 30, name = "No")
    private RString no;
    @CsvField(order = 40, name = "被保険者番号")
    private RString hihokenshaNo;
    @CsvField(order = 50, name = "被保険者氏名")
    private RString hiHokenshaSimei;
    @CsvField(order = 60, name = "サービス提供年月")
    private RString serviceTeikyoYM;
    @CsvField(order = 70, name = "事業所番号")
    private RString jigyoshaNo;
    @CsvField(order = 80, name = "事業所名")
    private RString jigyoshaName;
    @CsvField(order = 90, name = "サービス種類コード")
    private RString serviceShuruiCode;
    @CsvField(order = 100, name = "サービス種類名")
    private RString serviceShuruiName;
    @CsvField(order = 110, name = "サービス費用合計額")
    private Decimal serviceHiyoGokeiGaku;
    @CsvField(order = 120, name = "利用者負担額")
    private Decimal riyoshaFutanGaku;
    @CsvField(order = 130, name = "備考")
    private RString bikou;
}
