/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト項目出力位置を表す列挙型です。
 *
 * @reamsid_L DBZ-4570-010 jinge
 */
public enum ShutsuryokuKomokuPosition {
    /**
     * コード:0 名称:左詰め 略称:定義なし
     */
    左詰め("0", "左詰め"),
    /**
     * コード:1 名称:右詰め 略称:定義なし
     */
    右詰め("1", "右詰め");

    private final RString code;
    private final RString fullName;

    private ShutsuryokuKomokuPosition(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 汎用リスト項目出力位置のコードを返します。
     *
     * @return 汎用リスト項目出力位置のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 汎用リスト項目出力位置の名称を返します。
     *
     * @return 汎用リスト項目出力位置の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 汎用リスト項目出力位置のコードと一致する内容を探します。
     *
     * @param code 汎用リスト項目出力位置のコード
     * @return {@code code} に対応する汎用リスト項目出力位置
     */
    public static ShutsuryokuKomokuPosition toValue(RString code) {
        for (ShutsuryokuKomokuPosition shutsuryokuKomokuPosition : ShutsuryokuKomokuPosition.values()) {
            if (shutsuryokuKomokuPosition.code.equals(code)) {
                return shutsuryokuKomokuPosition;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("汎用リスト項目出力位置"));
    }
}
