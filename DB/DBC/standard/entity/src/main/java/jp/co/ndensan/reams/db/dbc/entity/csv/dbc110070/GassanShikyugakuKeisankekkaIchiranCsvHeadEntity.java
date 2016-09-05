/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc110070;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算支給額計算結果連絡票情報送付一覧表ＣＳＶファイルのヘッダレコードです。
 *
 * @reamsid_L DBC-2670-030 zhaowei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GassanShikyugakuKeisankekkaIchiranCsvHeadEntity {

    @CsvField(order = 10, name = "送付年月")
    private RString 送付年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 40, name = "保険者名")
    private RString 保険者名;
}
