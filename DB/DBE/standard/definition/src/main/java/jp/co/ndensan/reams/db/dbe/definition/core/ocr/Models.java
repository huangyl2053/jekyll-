/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.ocr;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * モデルの名称を管理します。
 */
public enum Models {

    /**
     * ID501
     */
    ID501,
    /**
     * ID502
     */
    ID502,
    /**
     * ID550
     */
    ID550,
    /**
     * ID777
     */
    ID777,
    /**
     * ID778
     */
    ID778;

    private final RString nameAsRString;

    private Models() {
        this.nameAsRString = new RString(name());
    }

    /**
     * @return 名称
     */
    public RString getName() {
        return nameAsRString;
    }
}
