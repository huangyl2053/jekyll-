/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * コードマスタ保守シート(DBB介護賦課)のコード種別を表す列挙型です。
 *
 * @reamsid_L DBE-9999-023 wangchao
 */
public enum DBBCodeShubetsu {

    /**
     * コード:0001 コード種別名称:変更事由
     */
    変更事由("0001", "変更事由"),
    /**
     * コード:0002 コード種別名称:普徴暫定賦課方法
     */
    普徴暫定賦課方法("0002", "普徴暫定賦課方法"),
    /**
     * コード:0003 コード種別名称:調定事由
     */
    調定事由("0003", "調定事由"),
    /**
     * コード:0004 コード種別名称:保険料減免種類
     */
    保険料減免種類("0004", "保険料減免種類"),
    /**
     * コード:0005 コード種別名称:保険料徴収猶予種類
     */
    保険料徴収猶予種類("0005", "保険料徴収猶予種類"),
    /**
     * コード:0006 コード種別名称:保険料減免取消種類
     */
    保険料減免取消種類("0006", "保険料減免取消種類"),
    /**
     * コード:0007 コード種別名称:保険料徴収猶予取消種類
     */
    保険料徴収猶予取消種類("0007", "保険料徴収猶予取消種類"),
    /**
     * コード:0008 コード種別名称:特別徴収停止事由
     */
    特別徴収停止事由("0008", "特別徴収停止事由"),
    /**
     * コード:0009 コード種別名称:エラーコード
     */
    エラーコード("0009", "エラーコード");

    private final CodeShubetsu code;
    private final RString fullName;

    private DBBCodeShubetsu(String code, String fullname) {
        this.code = new CodeShubetsu(code);
        this.fullName = new RString(fullname);
    }

    /**
     * コードマスタ保守シート(DBB介護賦課)のコード種別のコードを返します。
     *
     * @return コードマスタ保守シート(DBB介護賦課)のコード種別のコード
     */
    public CodeShubetsu getコード() {
        return code;
    }

    /**
     * コードマスタ保守シート((DBB介護賦課)のコード種別の名称を返します。
     *
     * @return コードマスタ保守シート((DBB介護賦課)のコード種別のコード種別名称
     */
    public RString getコード種別名称() {
        return fullName;
    }

    /**
     * コードマスタ保守シート((DBB介護賦課)のコード種別のコードと一致する内容を探します。
     *
     * @param code コードマスタ保守シート((DBB介護賦課)のコード種別のコード
     * @return {@code code} に対応するコードマスタ保守シート((DBB介護賦課)のコード種別
     */
    public static DBBCodeShubetsu toValue(CodeShubetsu code) {
        for (DBBCodeShubetsu codeShubetsu : DBBCodeShubetsu.values()) {
            if (codeShubetsu.code.equals(code)) {
                return codeShubetsu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("コードマスタ保守シート((DBB介護賦課)のコード種別"));
    }
}
