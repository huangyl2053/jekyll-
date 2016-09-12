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
@lombok.Getter
public class JigyoHokokuRenkeiHead2EucCsvEntity implements IJigyoHokokuRenkeiEucCsvEntity {

    @CsvField(order = 10, name = "先頭項目")
    private final RString 先頭項目;
    @CsvField(order = 20, name = "先頭項目2")
    private final RString 先頭項目2;
    @CsvField(order = 30, name = "交換情報識別番号")
    private final RString 交換情報識別番号;
    @CsvField(order = 40, name = "レコード種別番号")
    private final RString レコード種別番号;
    @CsvField(order = 50, name = "審査年月日")
    private final RString 審査年月日;
    @CsvField(order = 60, name = "作成年月日")
    private final RString 作成年月日;
    @CsvField(order = 70, name = "連合会名称")
    private final RString 連合会名称;
    @CsvField(order = 80, name = "保険者番号")
    private final RString 保険者番号;
    @CsvField(order = 90, name = "保険者名称")
    private final RString 保険者名称;

    /**
     * コンストラクタ
     *
     * @param 先頭項目 RString
     * @param 先頭項目2 RString
     * @param 交換情報識別番号 RString
     * @param レコード種別番号 RString
     * @param 審査年月日 RString
     * @param 作成年月日 RString
     * @param 連合会名称 RString
     * @param 保険者番号 RString
     * @param 保険者名称 RString
     */
    public JigyoHokokuRenkeiHead2EucCsvEntity(
            RString 先頭項目,
            RString 先頭項目2,
            RString 交換情報識別番号,
            RString レコード種別番号,
            RString 審査年月日,
            RString 作成年月日,
            RString 連合会名称,
            RString 保険者番号,
            RString 保険者名称
    ) {
        this.先頭項目 = 先頭項目;
        this.先頭項目2 = 先頭項目2;
        this.交換情報識別番号 = 交換情報識別番号;
        this.レコード種別番号 = レコード種別番号;
        this.審査年月日 = 審査年月日;
        this.作成年月日 = 作成年月日;
        this.連合会名称 = 連合会名称;
        this.保険者番号 = 保険者番号;
        this.保険者名称 = 保険者名称;
    }
}
