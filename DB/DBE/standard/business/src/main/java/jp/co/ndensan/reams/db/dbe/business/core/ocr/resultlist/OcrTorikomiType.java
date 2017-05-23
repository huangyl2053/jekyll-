/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.resultlist;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCR取込の種類を表します。
 */
public enum OcrTorikomiType {

    /**
     * 認定調査
     */
    認定調査("認定調査"),
    /**
     * 主治医意見書
     */
    意見書("主治医意見書"),
    /**
     * その他資料
     */
    その他資料("その他資料"),
    /**
     * 特に指定できない場合に利用する要素
     */
    未指定("");

    private final RString theDiplayName;

    private OcrTorikomiType(String displayName) {
        this.theDiplayName = new RString(displayName);
    }

    /**
     * @return 表示名称
     */
    RString displayName() {
        return this.theDiplayName;
    }

}
