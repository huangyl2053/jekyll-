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
 * 介護認定審査会情報CSV用Entityです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiJohoEucCsvEntity {

    @CsvField(order = 1, name = "介護認定審査会開催番号")
    private RString 介護認定審査会開催番号;
    @CsvField(order = 2, name = "介護認定審査会開催年月日")
    private RString 介護認定審査会開催年月日;
    @CsvField(order = 3, name = "介護認定審査会開始時刻")
    private RString 介護認定審査会開始時刻;
    @CsvField(order = 4, name = "介護認定審査会終了時刻")
    private RString 介護認定審査会終了時刻;
    @CsvField(order = 5, name = "合議体番号")
    private Decimal 合議体番号;

}
