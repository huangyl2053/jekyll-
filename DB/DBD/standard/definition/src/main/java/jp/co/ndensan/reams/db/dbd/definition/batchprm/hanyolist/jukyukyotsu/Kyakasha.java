/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyukyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 却下者を表す列挙型です。
 *
 * @reamsid_L DBD-3900-030 mawy
 */
public enum Kyakasha {

    /**
     * コード:1 名称:却下含 略称:定義なし
     */
    却下含("1", "却下含"),
    /**
     * コード:2 名称:却下者 略称:定義なし
     */
    却下者("2", "却下者"),
    /**
     * コード:3 名称:却下他 略称:定義なし
     */
    却下他("3", "却下他");

    private final RString code;
    private final RString fullName;

    private Kyakasha(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 却下者のコードを返します。
     *
     * @return 却下者のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 却下者の名称を返します。
     *
     * @return 却下者の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 却下者のコードと一致する内容を探します。
     *
     * @param code 却下者のコード
     * @return {@code code} に対応する却下者
     */
    public static Kyakasha toValue(RString code) {
        for (Kyakasha kyakashaKubun : Kyakasha.values()) {
            if (kyakashaKubun.code.equals(code)) {
                return kyakashaKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("対応する却下者"));
    }
}
