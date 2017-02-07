/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2240001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE250001.DBE250001_NinteiChosaKekkaTorikomiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2240001.NinteiChosaOCRTorikomiDiv;

/**
 * 認定調査結果取込み（OCR）のコントローラクラスです。
 *
 * @reamsid_L DBE-1540-010 dongyabin
 */
public class NinteiChosaKekkaTorikomiOcrHandler {

    private final NinteiChosaOCRTorikomiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public NinteiChosaKekkaTorikomiOcrHandler(NinteiChosaOCRTorikomiDiv div) {
        this.div = div;
    }

    /**
     * 画面に表示するサーバファイルパスを取得し、テキストボックスにセットします。
     */
    public void initialize() {

    }

    /**
     * 画面情報としてセットされている項目を元に、バッチパラメータとして生成する。
     *
     * @return バッチパラメータ
     */
    public DBE250001_NinteiChosaKekkaTorikomiParameter setバッチパラメータ() {
        return new DBE250001_NinteiChosaKekkaTorikomiParameter(div.getHdnSharedFileEntryInfo());
    }
}
