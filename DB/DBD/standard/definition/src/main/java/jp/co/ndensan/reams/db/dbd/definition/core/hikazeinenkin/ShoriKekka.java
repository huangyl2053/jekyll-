/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理結果を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 liangbc
 */
public enum ShoriKekka {

    /**
     * コード:00 名称:初期値 略称:定義なし
     */
    初期値("00", "初期値"),
    /**
     * コード:01 名称:受給権の失権 略称:定義なし
     */
    受給権の失権("01", "受給権の失権"),
    /**
     * コード:01 名称:差止・一時差止・停止 略称:定義なし
     */
    差止_一時差し止め_停止("02", "差止・一時差止・停止");

    private final RString code;
    private final RString fullName;

    private ShoriKekka(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 処理結果のコードを返します。
     *
     * @return 処理結果のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 処理結果の名称を返します。
     *
     * @return 処理結果の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 処理結果のコードと一致する内容を探します。
     *
     * @param code 処理結果のコード
     * @return {@code code} に対応する処理結果
     */
    public static ShoriKekka toValue(RString code) {
        for (ShoriKekka shoriKekka : ShoriKekka.values()) {
            if (shoriKekka.code.equals(code)) {
                return shoriKekka;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("処理結果"));
    }
}
