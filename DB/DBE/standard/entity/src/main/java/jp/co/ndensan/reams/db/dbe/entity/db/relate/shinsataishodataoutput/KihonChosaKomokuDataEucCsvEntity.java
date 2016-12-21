/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 基本調査項目データCSV用Entityです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KihonChosaKomokuDataEucCsvEntity {

    @CsvField(order = 1, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 2, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 3, name = "認定申請年月日")
    private RString 認定申請年月日;
    @CsvField(order = 4, name = "連番")
    private Decimal 連番;
    @CsvField(order = 5, name = "表示番号")
    private RString 表示番号;
    @CsvField(order = 6, name = "調査項目文言")
    private RString 調査項目文言;
    @CsvField(order = 7, name = "パターンNo")
    private Decimal パターンNo;
    @CsvField(order = 8, name = "回答コード")
    private RString 回答コード;

}
