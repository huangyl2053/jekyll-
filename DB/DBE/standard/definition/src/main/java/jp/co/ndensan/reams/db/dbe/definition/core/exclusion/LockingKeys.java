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
    申請書管理番号("DBEShinseishoKanriNo", true),
    /**
     * DBEShinsakaiNo + 介護認定審査会開催番号
     */
    介護認定審査会開催番号("DBEShinsakaiNo", true),
    /**
     * ShinsakaiKaisaiYoteiToroku
     */
    審査会開催予定登録("ShinsakaiKaisaiYoteiToroku", false);

    private final RString aValue;
    private final boolean usesWithAppendingKey;

    private LockingKeys(String value, boolean usesWithAppendingKey) {
        this.aValue = new RString(value);
        this.usesWithAppendingKey = usesWithAppendingKey;
    }

    /**
     * @param value 付加文字列
     * @return 指定の値を末尾に付加した排他キー
     * @throw IllegalStateException キーとなる値を付加して利用しない排他キーの場合
     */
    public LockingKey appended(RString value) {
        if (!usesWithAppendingKey) {
            throw new IllegalStateException(value + "は、そのまま利用する排他キーです。");
        }
        return new LockingKey(new RStringBuilder().append(this.aValue).append(value).toRString());
    }

    /**
     * @return 排他キー
     * @throw IllegalStateException キーとなる値を付加して利用するべき排他キーの場合
     */
    public LockingKey value() {
        if (usesWithAppendingKey) {
            throw new IllegalStateException(aValue + "は、値を付加して利用する排他キーです。");
        }
        return new LockingKey(this.aValue);
    }
}
