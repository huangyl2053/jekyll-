/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査データ出力（モバイル）調査員情報CSV用データEntity。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosainOutputEucCsvEntity {

    @CsvField(order = 1, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 2, name = "市町村")
    private RString 市町村;
    @CsvField(order = 3, name = "調査員コード")
    private RString 調査員コード;
    @CsvField(order = 4, name = "調査員氏名")
    private RString 調査員氏名;
    @CsvField(order = 5, name = "調査員カナ氏名")
    private RString 調査員カナ氏名;
    @CsvField(order = 6, name = "調査委託先コード")
    private RString 調査委託先コード;
    @CsvField(order = 7, name = "調査委託先名称")
    private RString 調査委託先名称;
    @CsvField(order = 8, name = "性別")
    private RString 性別;
    @CsvField(order = 9, name = "地区コード")
    private RString 地区コード;
    @CsvField(order = 10, name = "地区名称")
    private RString 地区名称;
    @CsvField(order = 11, name = "調査員資格")
    private RString 調査員資格;
    @CsvField(order = 12, name = "調査可能人数")
    private RString 調査可能人数;
    @CsvField(order = 13, name = "状況フラグ")
    private RString 状況フラグ;
    @CsvField(order = 14, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 15, name = "住所")
    private RString 住所;
    @CsvField(order = 16, name = "電話番号")
    private RString 電話番号;
    @CsvField(order = 17, name = "ＦＡＸ番号")
    private RString ＦＡＸ番号;
    @CsvField(order = 18, name = "所属機関名称")
    private RString 所属機関名称;

}
