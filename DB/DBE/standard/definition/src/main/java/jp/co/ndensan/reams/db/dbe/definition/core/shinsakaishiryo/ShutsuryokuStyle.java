/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.definition.core.shinsakaishiryo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3423
 */
public enum ShutsuryokuStyle {
    /**
     * コード:1 名称:A4縦 略称:定義なし
     */
    A4縦("1", "A4縦"),
    
    
    /**
     * コード:2 名称:A3横 略称:定義なし
     */
    A3横("2", "A3横");
   
    private final RString code;
    private final RString fullName;

    private ShutsuryokuStyle(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * サンプル文書グループコードのコードを返します。
     *
     * @return サンプル文書グループコードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * サンプル文書グループコードの名称を返します。
     *
     * @return サンプル文書グループコードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * サンプル文書グループコードのコードと一致する内容を探します。
     *
     * @param code サンプル文書グループコードのコード
     * @return {@code code} に対応するサンプル文書グループコード
     */
    public static ShutsuryokuStyle toValue(RString code) {
        for (ShutsuryokuStyle shutsuryokuYoshiType : ShutsuryokuStyle.values()) {
            if (shutsuryokuYoshiType.code.equals(code)) {
                return shutsuryokuYoshiType;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("出力用紙タイプ"));
    }
}
