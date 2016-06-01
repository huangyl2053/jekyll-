/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 過誤決定通知書情報取込共通処理（保険者分・ファイル読込）のcsvEntity
 *
 * @reamsid_L DBC-0980-302 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoKetteiHokenshaInControlCsvEntity {

    //TODO keyN 目前名称没找
    @CsvField(order = 10, name = "レコード種別")
    private RString codeShubetsu;
    @CsvField(order = 20, name = "レコード番号")
    private RString codeNo;
    @CsvField(order = 30, name = "keyOne")
    private RString keyOne;
    @CsvField(order = 40, name = "レコード件数")
    private RString codeNum;
    @CsvField(order = 50, name = "keyTwo")
    private RString keyTwo;
    @CsvField(order = 60, name = "keyThree")
    private RString keyThree;
    @CsvField(order = 70, name = "保険者番号")
    private RString hokenshaNo;
    @CsvField(order = 80, name = "事業所番号")
    private RString jigyoshoNo;
    @CsvField(order = 90, name = "keyFour")
    private RString keyFour;
    @CsvField(order = 100, name = "keyFive")
    private RString keyFive;
    @CsvField(order = 110, name = "処理対象年月")
    private RString shoriYM;
    @CsvField(order = 120, name = "keySix")
    private RString keySix;
    @CsvField(order = 130, name = "ブランク")
    private RString flag;

}
