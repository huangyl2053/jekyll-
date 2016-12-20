/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.csv.jizenshinsakekka;

import jp.co.ndensan.reams.uz.uza.io.fld.FldField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCR情報受入＿バッチ ファイル 読み取り結果 行entityです。
 *
 * @author n8429
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public abstract class OcrJohoOcrRecordEntity {

    @FldField(order = 1, length = 1)
    private RString 調査区分;

}
