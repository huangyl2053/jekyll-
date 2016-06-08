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
 * コードマスタ保守シート(DBD介護受給)のコード種別を表す列挙型です。
 *
 * @reamsid_L DBE-9999-023 wangchao
 */
public enum DBDCodeShubetsu {

    /**
     * コード:0001 コード種別名称:延期理由
     */
    延期理由("0001", "延期理由"),
    /**
     * コード:0002 コード種別名称:指定サービス種類コード
     */
    指定サービス種類コード("0002", "指定サービス種類コード"),
    /**
     * コード:0003 コード種別名称:結果通知理由
     */
    結果通知理由("0003", "結果通知理由");

    private final CodeShubetsu code;
    private final RString fullName;

    private DBDCodeShubetsu(String code, String fullname) {
        this.code = new CodeShubetsu(code);
        this.fullName = new RString(fullname);
    }

    /**
     * コードマスタ保守シート(DBD介護受給)のコード種別のコードを返します。
     *
     * @return コードマスタ保守シート(DBD介護受給)のコード種別のコード
     */
    public CodeShubetsu getコード() {
        return code;
    }

    /**
     * コードマスタ保守シート((DBD介護受給)のコード種別の名称を返します。
     *
     * @return コードマスタ保守シート((DBD介護受給)のコード種別のコード種別名称
     */
    public RString getコード種別名称() {
        return fullName;
    }

    /**
     * コードマスタ保守シート((DBD介護受給)のコード種別のコードと一致する内容を探します。
     *
     * @param code コードマスタ保守シート((DBD介護受給)のコード種別のコード
     * @return {@code code} に対応するコードマスタ保守シート((DBD介護受給)のコード種別
     */
    public static DBDCodeShubetsu toValue(CodeShubetsu code) {
        for (DBDCodeShubetsu codeShubetsu : DBDCodeShubetsu.values()) {
            if (codeShubetsu.code.equals(code)) {
                return codeShubetsu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("コードマスタ保守シート((DBD介護受給)のコード種別"));
    }
}
