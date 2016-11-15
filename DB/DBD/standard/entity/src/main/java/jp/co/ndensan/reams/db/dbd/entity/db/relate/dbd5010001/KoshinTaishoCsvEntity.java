/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5010001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * csv出力Entityです。
 *
 * @reamsid_L DBD-2030-010 x_youyj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoshinTaishoCsvEntity {

    @CsvField(order = 1, name = "保険者")
    private RString 保険者;
    @CsvField(order = 2, name = "(被保険者)被保番号")
    private RString 被保険者被保番号;
    @CsvField(order = 3, name = "(被保険者)氏名")
    private RString 被保険者氏名;
    @CsvField(order = 4, name = "(更新対象)完了日")
    private RString 更新対象完了日;
    @CsvField(order = 5, name = "(更新対象)通知年月日")
    private RString 更新対象通知年月日;
}
