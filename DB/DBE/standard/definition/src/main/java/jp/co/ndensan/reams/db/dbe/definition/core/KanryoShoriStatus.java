/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 完了処理で使用する状態区分の定義です。
 */
public enum KanryoShoriStatus {

    /**
     * 未処理の定義です。
     */
    未処理("1", "未"),
    /**
     * 完了可能の定義です。
     */
    完了可能("2", "可"),
    /**
     * すべての定義です。
     */
    すべて("3", "すべて"),
    /**
     * 未定義の定義です。
     */
    未定義("", "");

    private final RString code;
    private final RString ryakusho;

    private KanryoShoriStatus(String code, String ryakusho) {
        this.code = new RString(code);
        this.ryakusho = new RString(ryakusho);
    }

    /**
     * 略称を取得します。
     *
     * @return 略称
     */
    public RString get略称() {
        return this.ryakusho;
    }

    /**
     * 指定されたコードに該当する、状態を取得します。
     *
     * @param code コード
     * @return 状態
     */
    public static KanryoShoriStatus toValue(RString code) {
        if (RString.isNullOrEmpty(code)) {
            return KanryoShoriStatus.未定義;
        }
        for (KanryoShoriStatus status : KanryoShoriStatus.values()) {
            if (status.code.equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("状態"));
    }

}
