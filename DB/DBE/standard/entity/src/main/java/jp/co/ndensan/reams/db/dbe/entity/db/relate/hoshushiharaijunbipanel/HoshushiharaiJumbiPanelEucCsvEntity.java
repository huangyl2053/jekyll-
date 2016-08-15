/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbipanel;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 支払いデータ作成CSV用データEntity。
 *
 * @reamsid_L DBE-1990-020 lizhuoxuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HoshushiharaiJumbiPanelEucCsvEntity {

    @CsvField(order = 1, name = "データ区分1 ")
    private RString データ区分1;
    @CsvField(order = 2, name = "種別コード")
    private RString 種別コード;
    @CsvField(order = 3, name = "コード区分")
    private RString コード区分;
    @CsvField(order = 4, name = "会社コード")
    private RString 会社コード;
    @CsvField(order = 5, name = "会社名　")
    private RString 会社名;
    @CsvField(order = 6, name = "振込指定日")
    private RString 振込指定日;
    @CsvField(order = 7, name = "仕向銀行番号")
    private RString 仕向銀行番号;
    @CsvField(order = 8, name = "仕向銀行名")
    private RString 仕向銀行名;
    @CsvField(order = 9, name = "仕向支店番号")
    private RString 仕向支店番号;
    @CsvField(order = 10, name = "仕向支店名")
    private RString 仕向支店名;
    @CsvField(order = 11, name = "預金種別")
    private RString 預金種別;
    @CsvField(order = 12, name = "口座番号")
    private RString 口座番号;
    @CsvField(order = 13, name = "ダミー1")
    private RString ダミー1;
    @CsvField(order = 14, name = "データ区分2")
    private RString データ区分2;
    @CsvField(order = 15, name = "被仕向銀行番号")
    private RString 被仕向銀行番号;
    @CsvField(order = 16, name = "被仕向銀行名")
    private RString 被仕向銀行名;
    @CsvField(order = 17, name = "被仕向支店番号")
    private RString 被仕向支店番号;
    @CsvField(order = 18, name = "被仕向支店名")
    private RString 被仕向支店名;
    @CsvField(order = 19, name = "手形交換所番号")
    private RString 手形交換所番号;
    @CsvField(order = 20, name = "預金種別2")
    private RString 預金種別2;
    @CsvField(order = 21, name = "口座番号2")
    private RString 口座番号2;
    @CsvField(order = 22, name = "受取人名")
    private RString 受取人名;
    @CsvField(order = 23, name = "振込金額")
    private RString 振込金額;
    @CsvField(order = 24, name = "新規コード")
    private RString 新規コード;
    @CsvField(order = 25, name = "顧客コード1")
    private RString 顧客コード1;
    @CsvField(order = 26, name = "顧客コード2")
    private RString 顧客コード2;
    @CsvField(order = 27, name = "EDI情報")
    private RString edi情報;
    @CsvField(order = 28, name = "振込指定区分")
    private RString 振込指定区分;
    @CsvField(order = 29, name = "識別表示")
    private RString 識別表示;
    @CsvField(order = 30, name = "ダミー2")
    private RString ダミー2;
    @CsvField(order = 31, name = "データ区分3")
    private RString データ区分3;
    @CsvField(order = 32, name = "合計件数")
    private RString 合計件数;
    @CsvField(order = 33, name = "合計金額")
    private RString 合計金額;
    @CsvField(order = 34, name = "ダミー3")
    private RString ダミー3;
    @CsvField(order = 35, name = "データ区分4")
    private RString データ区分4;
    @CsvField(order = 36, name = "ダミー4")
    private RString ダミー4;
}
