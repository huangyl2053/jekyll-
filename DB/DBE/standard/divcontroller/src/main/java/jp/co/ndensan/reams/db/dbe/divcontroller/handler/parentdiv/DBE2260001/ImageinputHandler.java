/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2260001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE250002.DBE250002_ImageTorikomiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2260001.ImageinputDiv;

/**
 * イメージ取込み（規定・規定外）のコントローラクラスです。
 *
 * @reamsid_L DBE-1580-010 dongyabin
 */
public class ImageinputHandler {

    private final ImageinputDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public ImageinputHandler(ImageinputDiv div) {
        this.div = div;
    }

    /**
     * 画面情報としてセットされている項目を元に、バッチパラメータとして生成する。
     *
     * @return バッチパラメータ
     */
    public DBE250002_ImageTorikomiParameter setバッチパラメータ() {
        return new DBE250002_ImageTorikomiParameter(div.getHdnSharedFileEntryInfo());
    }
}
