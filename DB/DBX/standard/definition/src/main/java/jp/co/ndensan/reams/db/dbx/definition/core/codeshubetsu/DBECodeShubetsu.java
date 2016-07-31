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
 * コードマスタ保守シート(DBE介護認定)のコード種別を表す列挙型です。
 *
 * @reamsid_L DBE-9999-023 wangchao
 */
public enum DBECodeShubetsu {

    /**
     * コード:0001 コード種別名称:審査会地区コード
     */
    審査会地区コード("5001", "審査会地区コード"),
    /**
     * コード:5002 コード種別名称:調査地区コード
     */
    調査地区コード("5002", "調査地区コード"),
    /**
     * コード:5003 コード種別名称:原因疾患コード
     */
    原因疾患コード("5003", "原因疾患コード"),
    /**
     * コード:5004 コード種別名称:消費税率
     */
    消費税率("5004", "消費税率"),
    /**
     * コード:5005 コード種別名称:控除税率
     */
    控除税率("5005", "控除税率");

    private final CodeShubetsu code;
    private final RString fullName;

    private DBECodeShubetsu(String code, String fullname) {
        this.code = new CodeShubetsu(code);
        this.fullName = new RString(fullname);
    }

    /**
     * コードマスタ保守シート(DBE介護認定)のコード種別のコードを返します。
     *
     * @return コードマスタ保守シート(DBE介護認定)のコード種別のコード
     */
    public CodeShubetsu getコード() {
        return code;
    }

    /**
     * コードマスタ保守シート((DBE介護認定)のコード種別の名称を返します。
     *
     * @return コードマスタ保守シート((DBE介護認定)のコード種別のコード種別名称
     */
    public RString getコード種別名称() {
        return fullName;
    }

    /**
     * コードマスタ保守シート((DBE介護認定)のコード種別のコードと一致する内容を探します。
     *
     * @param code コードマスタ保守シート((DBE介護認定)のコード種別のコード
     * @return {@code code} に対応するコードマスタ保守シート((DBE介護認定)のコード種別
     */
    public static DBECodeShubetsu toValue(CodeShubetsu code) {
        for (DBECodeShubetsu codeShubetsu : DBECodeShubetsu.values()) {
            if (codeShubetsu.code.equals(code)) {
                return codeShubetsu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("コードマスタ保守シート((DBE介護認定)のコード種別"));
    }
}
