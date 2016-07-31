/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 様式別連携情報作成のＣＳＶを定義したEntityクラスです。
 *
 * @reamsid_L DBU-4050-020 lijia
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class JigyoHokokuRenkei27EucCsvEntity implements IJigyoHokokuRenkeiEucCsvEntity {

    @CsvField(order = 10, name = "交換情報識別番号")
    private final RString 交換情報識別番号;
    @CsvField(order = 20, name = "レコード種別番号")
    private final RString レコード種別番号;
    @CsvField(order = 30, name = "件数")
    private final int 件数;
    @CsvField(order = 40, name = "給付費")
    private final Decimal 給付費;

    /**
     * コンストラクタ
     *
     * @param 交換情報識別番号 RString
     * @param レコード種別番号 RString
     * @param 件数 int
     * @param 給付費 Decimal
     */
    public JigyoHokokuRenkei27EucCsvEntity(
            RString 交換情報識別番号,
            RString レコード種別番号,
            int 件数,
            Decimal 給付費
    ) {
        this.交換情報識別番号 = 交換情報識別番号;
        this.レコード種別番号 = レコード種別番号;
        this.件数 = 件数;
        this.給付費 = 給付費;
    }
}
