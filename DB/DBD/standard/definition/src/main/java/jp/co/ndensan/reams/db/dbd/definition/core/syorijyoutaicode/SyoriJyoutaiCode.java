/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.syorijyoutaicode;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理状態コードを表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 huangh
 */
public enum SyoriJyoutaiCode {

    /**
     * コード:1 名称:未処理 略称:定義なし
     */
    未処理("1", "未処理"),
    /**
     * コード:2 名称:処理済 略称:定義なし
     */
    処理済("2", "処理済"),
    /**
     * コード:3 名称:再処理前 略称:定義なし
     */
    再処理前("3", "再処理前"),
    /**
     * コード:4 名称:追加取込前 略称:定義なし
     */
    追加取込前("4", "追加取込前"),
    /**
     * コード:9 名称:処理なし 略称:定義なし
     */
    処理なし("9", "処理なし");

    private final RString code;
    private final RString fullName;

    private SyoriJyoutaiCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 処理状態コードのコードを返します。
     *
     * @return 処理状態コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 処理状態コードの名称を返します。
     *
     * @return 処理状態コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 処理状態コードのコードと一致する内容を探します。
     *
     * @param code 処理状態コードのコード
     * @return {@code code} に対応する処理状態コード
     */
    public static SyoriJyoutaiCode toValue(RString code) {

        for (SyoriJyoutaiCode syoriJyoutaiCode : SyoriJyoutaiCode.values()) {
            if (syoriJyoutaiCode.code.equals(code)) {
                return syoriJyoutaiCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("処理状態コード"));
    }
}
