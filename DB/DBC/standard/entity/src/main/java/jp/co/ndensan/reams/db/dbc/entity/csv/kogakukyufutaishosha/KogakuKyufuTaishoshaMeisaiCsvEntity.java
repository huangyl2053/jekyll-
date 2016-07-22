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
public class KogakuKyufuTaishoshaMeisaiCsvEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "帳票レコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 50, name = "No.")
    private RString no;
    @CsvField(order = 60, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 70, name = "被保険者氏名(漢字)")
    private RString 被保険者氏名_漢字;
    @CsvField(order = 80, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 90, name = "事業所番号")
    private RString 事業所番号;
    @CsvField(order = 100, name = "事業所名(漢字)")
    private RString 事業所名_漢字;
    @CsvField(order = 110, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 120, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 130, name = "サービス費用合計額")
    private RString サービス費用合計額;
    @CsvField(order = 140, name = "使用者負担額")
    private RString 使用者負担額;
    @CsvField(order = 150, name = "備考")
    private RString 備考;
    @CsvField(order = 160, name = "ブランク")
    private RString ブランク;

}
