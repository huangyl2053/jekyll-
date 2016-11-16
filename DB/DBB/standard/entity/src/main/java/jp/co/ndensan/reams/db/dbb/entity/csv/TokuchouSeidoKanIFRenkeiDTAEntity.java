/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.fld.Align;
import jp.co.ndensan.reams.uz.uza.io.fld.FldField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 連携用出力ファイルのEntityを作成です。
 *
 * @reamsid_L DBB-1810-040 dengjiajia
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Setter
@lombok.Getter
public class TokuchouSeidoKanIFRenkeiDTAEntity {

    @FldField(order = 1, length = 1)
    private RString レコード区分;
    @FldField(order = 2, length = 5)
    private RString 市町村コード;
    @FldField(order = 3, length = 3)
    private RString 特別徴収義務者コード;
    @FldField(order = 4, length = 2)
    private RString 通知内容コード;
    @FldField(order = 5, length = 1)
    private RString 予備1;
    @FldField(order = 6, length = 1)
    private RString 特別徴収制度コード;
    @FldField(order = 7, length = 8)
    private RString 作成年月日;
    @FldField(order = 8, length = 10)
    private RString 基礎年金番号;
    @FldField(order = 9, length = 4)
    private RString 年金コード;
    @FldField(order = 10, length = 3)
    private RString 予備2;
    @FldField(order = 11, length = 8)
    private RString 生年月日;
    @FldField(order = 12, length = 1)
    private RString 性別;
    @FldField(order = 13, length = 25)
    private RString カナ氏名;
    @FldField(order = 14, length = 3)
    private RString 氏名1_シフトコード;
    @FldField(order = 15, length = 25)
    private RString 漢字氏名;
    @FldField(order = 16, length = 3)
    private RString 氏名2_シフトコード;
    @FldField(order = 17, length = 7)
    private RString 郵便番号;
    @FldField(order = 18, length = 80)
    private RString カナ住所;
    @FldField(order = 19, length = 3)
    private RString 住所3_シフトコード;
    @FldField(order = 20, length = 25)
    private RString 漢字住所;
    @FldField(order = 21, length = 3)
    private RString 住所4_シフトコード;
    @FldField(order = 22, length = 2)
    private RString 各種区分;
    @FldField(order = 23, length = 2)
    private RString 処理結果コード;
    @FldField(order = 24, length = 1)
    private RString 後期移管コード;
    @FldField(order = 25, length = 8)
    private RString 各種年月日;
    @FldField(order = 26, length = 11)
    private RString 金額1;
    @FldField(order = 27, length = 11)
    private RString 金額2;
    @FldField(order = 28, length = 11, align = Align.Right, paddingChar = "0")
    private RString 金額3;
    @FldField(order = 29, length = 58)
    private RString 予備3;
    @FldField(order = 30, length = 15)
    private RString 共済年金証書記号番号;
    @FldField(order = 31, length = 10)
    private RString 介護被保険者番号;
    @FldField(order = 32, length = 1)
    private RString 個人コード区分;
    @FldField(order = 33, length = 16, align = Align.Right, paddingChar = "0")
    private RString 個人コード;
    @FldField(order = 34, length = 1)
    private RString 介護住所地特例;
    @FldField(order = 35, length = 8)
    private RString 介護捕捉年月日;
    @FldField(order = 36, length = 1)
    private RString 介護待機フラグ;
    @FldField(order = 37, length = 13)
    private RString 予備4;

}
