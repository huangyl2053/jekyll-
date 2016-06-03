/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共有ファイル名称列挙型です。
 *
 */
public enum KyoyuFileName {

    /**
     * コード:01 名称:合議体情報作成一括登録ファイル 略称:定義なし
     */
    合議体情報作成一括登録ファイル("01", "合議体情報作成一括登録ファイル");

    private final RString code;
    private final RString fullName;

    private KyoyuFileName(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 事業者区分のコードを返します。
     *
     * @return 事業者区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 事業者区分の名称を返します。
     *
     * @return 事業者区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 共有ファイル名称のコードと一致する内容を探します。
     *
     * @param code 共有ファイル名称のコード
     * @return {@code code} に対応する共有ファイル名称
     */
    public static KyoyuFileName toValue(RString code) {

        for (KyoyuFileName kyoyuFileName : KyoyuFileName.values()) {
            if (kyoyuFileName.code.equals(code)) {
                return kyoyuFileName;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("共有ファイル名称"));
    }
}
