/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.csv.ocr;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class OcrTorikomiKekkaCsvEntity {

    @CsvField(order = 10, name = "取込日")
    private RString 取込日西暦;
    @CsvField(order = 20, name = "ID")
    private RString ocrID;
    @CsvField(order = 30, name = "帳票連番")
    private RString 帳票連番;
    @CsvField(order = 40, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 50, name = "申請日")
    private RString 申請日西暦;
    @CsvField(order = 60, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 70, name = "氏名")
    private RString 氏名;
    @CsvField(order = 80, name = "氏名カナ")
    private RString 氏名カナ;
    @CsvField(order = 90, name = "新規/更新")
    private RString 新規更新区分;
    @CsvField(order = 100, name = "結果")
    private RString 結果;
    @CsvField(order = 100, name = "取込イメージ件数")
    private int 取込イメージ件数;
    @CsvField(order = 110, name = "エラー内容")
    private RString エラー内容;

}
