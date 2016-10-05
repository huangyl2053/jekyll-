/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kogakugassankyufujissekiout;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算給付実績情報の送付ファイル作成データレコードのCsvEntity
 *
 * @reamsid_L DBC-2710-030 wangxue
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanKyufuJissekiSofuDataEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号（連番）")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "支給申請書整理番号")
    private RString 支給申請書整理番号;
    @CsvField(order = 50, name = "自己負担額証明書整理番号")
    private RString 自己負担額証明書整理番号;
    @CsvField(order = 60, name = "保険制度コード")
    private RString 保険制度コード;
    @CsvField(order = 70, name = "給付実績作成区分コード")
    private RString 給付実績作成区分コード;
    @CsvField(order = 80, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 90, name = "被保険者証記号")
    private RString 被保険者証記号;
    @CsvField(order = 100, name = "被保険者（証）番号")
    private RString 被保険者証番号;
    @CsvField(order = 110, name = "申請年月日")
    private RString 申請年月日;
    @CsvField(order = 120, name = "決定年月日")
    private RString 決定年月日;
    @CsvField(order = 130, name = "自己負担総額")
    private RString 自己負担総額;
    @CsvField(order = 140, name = "支給額")
    private RString 支給額;
    @CsvField(order = 150, name = "処理年月")
    private RString 処理年月;
}
