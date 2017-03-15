/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.exclusion;

import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 前排他用の排他キーを生成します。
 */
public enum LockingKeys {

    /**
     * DBEShinseishoKanriNo + 申請書管理番号
     */
    申請書管理番号("DBEShinseishoKanriNo"),
    /**
     * DBEShinsakaiNo + 介護認定審査会開催番号
     */
    介護認定審査会開催番号("DBEShinsakaiNo");

    private final RString aHeader;

    private LockingKeys(String aHeader) {
        this.aHeader = new RString(aHeader);
    }

    /**
     * @param value 付加文字列
     * @return 指定の値を末尾に付加した排他キー
     */
    public LockingKey appended(RString value) {
        return new LockingKey(new RStringBuilder().append(this.aHeader).append(value).toRString());
    }
}
