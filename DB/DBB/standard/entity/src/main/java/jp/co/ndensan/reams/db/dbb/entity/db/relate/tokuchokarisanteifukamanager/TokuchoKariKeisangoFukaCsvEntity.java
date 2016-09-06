/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 特別徴収仮算定結果一覧表CSVのクラスです。
 *
 * @reamsid_L DBB-0700-020 xuhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Setter
@Getter
public class TokuchoKariKeisangoFukaCsvEntity {

    @CsvField(order = 1, name = "連番")
    private RString 連番;
    @CsvField(order = 2, name = "作成年月日")
    private RString 作成年月日;
    @CsvField(order = 3, name = "作成時刻")
    private RString 作成時刻;
    @CsvField(order = 4, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 5, name = "住所")
    private RString 住所;

}
