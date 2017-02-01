/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.errorlist;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 新規、更新の区分です。
 */
public enum ShinkiKoshinKubun {

    /**
     * 新規
     */
    新規,
    /**
     * 更新
     */
    更新,
    /**
     * データなし
     */
    対象データなし;

    private final RString theName;

    private ShinkiKoshinKubun() {
        this.theName = new RString(name());
    }

    RString toRString() {
        return this.theName;
    }
}
